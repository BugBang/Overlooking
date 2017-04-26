package com.chat.bxchat.ui.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chat.bxchat.app.App;
import com.chat.bxchat.event.EventMsg;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by soffice on 2017/4/25.
 */

public abstract class BaseFragment<Q extends ViewDataBinding, V, T extends BasePresenter<V>> extends Fragment {
    private boolean isDebug;
    private String APP_NAME;
    protected final String TAG = this.getClass().getSimpleName();
    private View mContextView = null;
    protected BaseActivity mActivity;
    protected Q mViewDataBinding;
    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        isDebug = App.isDebug;
        APP_NAME = App.APP_NAME;

        //判断是否使用MVP模式
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);//因为之后所有的子类都要实现对应的View接口
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContextView = inflater.inflate(bindLayout(), container, false);
        mViewDataBinding = DataBindingUtil.bind(mContextView);
        doBusiness(getActivity());
        return mContextView;
    }

    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int bindLayout();

    /**
     * [业务操作]
     *
     * @param mContext
     */
    public abstract void doBusiness(Context mContext);

    /**
     * [用于创建Presenter和判断是否使用MVP模式(由子类实现)]
     */
    protected abstract T createPresenter();

    /**
     * [日志输出]
     *
     * @param msg
     */
    protected void $Log(String msg) {
        if (isDebug) {
            Log.i(APP_NAME, msg);
        }
    }

    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment);
        }
    }

    protected void addFragment(BaseFragment fragment, String key, String value) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment, key, value);
        }
    }

    protected void addFragment(BaseFragment fragment, Bundle bundle) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment, bundle);
        }
    }


    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEventPostThread(EventMsg messageEvent) {
        Log.e("PostThread", Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEventMainThread(EventMsg messageEvent) {
        Log.e("MainThread", Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessageEventBackgroundThread(EventMsg messageEvent) {
        Log.e("BackgroundThread", Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessageEventAsync(EventMsg messageEvent) {
        Log.e("Async", Thread.currentThread().getName());
    }
}
