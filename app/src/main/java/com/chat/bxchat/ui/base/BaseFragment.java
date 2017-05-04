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
import com.chat.bxchat.util.TUtil;

/**
 * Created by soffice on 2017/4/25.
 */

public abstract class BaseFragment<Q extends ViewDataBinding,P extends BasePresenter,M extends BaseModel> extends Fragment implements BaseView{
    private boolean isDebug;
    private String APP_NAME;
    protected final String TAG = this.getClass().getSimpleName();
    private View mContextView = null;
    protected BaseActivity mActivity;
    protected Q mViewDataBinding;
    public P mPresenter;
    public M mModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = TUtil.getT(this, 1);
        mModel = TUtil.getT(this, 2);
        if (this instanceof BaseView) {
            mPresenter.attachVM(this, mModel);
        }
        isDebug = App.isDebug;
        APP_NAME = App.APP_NAME;
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
        if (mPresenter != null) {
            mPresenter.detachVM();
        }
        super.onDestroy();
    }

    @Override
    public void onRequestStart() {

    }

    @Override
    public void onRequestError(String msg) {

    }

    @Override
    public void onRequestEnd() {

    }

    @Override
    public void onInternetError() {

    }
}
