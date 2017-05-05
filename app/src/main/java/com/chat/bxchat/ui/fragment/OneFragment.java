package com.chat.bxchat.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Observable;
import android.databinding.BaseObservable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chat.bxchat.R;
import com.chat.bxchat.click.ClickEvent;

import com.chat.bxchat.databinding.FragmentOneBinding;
import com.chat.bxchat.entity.common.UserEntity;
import com.chat.bxchat.ui.base.BaseFragment;
import com.chat.bxchat.ui.contract.HomeContract;
import com.chat.bxchat.ui.contract.OneFragmentContract;
import com.chat.bxchat.ui.model.OneFragmentAtModel;
import com.chat.bxchat.ui.presenter.OneFragmentAtPresenter;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import rx.functions.Func1;

/**
 * @创建者 baoxin
 * @日期 2017/5/2.
 * @描述
 */

public class OneFragment extends BaseFragment<FragmentOneBinding,OneFragmentAtPresenter,OneFragmentAtModel> {
    
    public static OneFragment newInstance(){
        return new OneFragment();
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_one;
    }

    @Override
    public void doBusiness(Context mContext) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(""+2);
//        Observable.
        rx.Observable.timer(3,TimeUnit.SECONDS).map(new Func1<Long, Object>() {
            @Override
            public Object call(Long aLong) {
                Logger.i("timer");
                mViewDataBinding.setUser(userEntity);
                return null;
            }
        }).subscribe();

        rx.Observable.timer(7,TimeUnit.SECONDS).map(new Func1<Long, Object>() {
            @Override
            public Object call(Long aLong) {
                userEntity.setName("222222222222222222222");
                return null;
            }
        }).subscribe();

//        mViewDataBinding.tv
    }
}
