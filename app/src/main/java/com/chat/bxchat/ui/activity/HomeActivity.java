package com.chat.bxchat.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.chat.bxchat.R;
import com.chat.bxchat.databinding.ActivityHomeBinding;
import com.chat.bxchat.ui.base.BaseActivity;
import com.chat.bxchat.ui.base.BaseFragment;
import com.chat.bxchat.ui.contract.HomeContract;
import com.chat.bxchat.ui.model.HomeAtModel;
import com.chat.bxchat.ui.presenter.HomeAtPresenter;

public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeAtPresenter,HomeAtModel> implements BottomNavigationView.OnNavigationItemSelectedListener,HomeContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBinding.navigation.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mViewDataBinding.message.setText(R.string.title_home);
                return true;
            case R.id.navigation_dashboard:
                mViewDataBinding.message.setText(R.string.title_dashboard);
                return true;
            case R.id.navigation_notifications:
                mViewDataBinding.message.setText(R.string.title_notifications);
                return true;
        }
        return false;
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
