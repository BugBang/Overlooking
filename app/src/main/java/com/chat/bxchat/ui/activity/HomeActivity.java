package com.chat.bxchat.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chat.bxchat.R;
import com.chat.bxchat.adapter.HomeActivityViewPagerAdapter;
import com.chat.bxchat.click.NavigationViewClick;
import com.chat.bxchat.databinding.ActivityHomeBinding;
import com.chat.bxchat.ui.base.BaseActivity;
import com.chat.bxchat.ui.base.BaseFragment;
import com.chat.bxchat.ui.fragment.OneFragment;
import com.chat.bxchat.ui.fragment.ThreeFragment;
import com.chat.bxchat.ui.fragment.TwoFragment;
import com.chat.bxchat.ui.model.HomeAtModel;
import com.chat.bxchat.ui.presenter.HomeAtPresenter;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeAtPresenter, HomeAtModel> implements NavigationViewClick{

    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        mViewDataBinding.navView.getHeaderView(0).findViewById(R.id.ll_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showLongToast("onClick");
            }
        });
        mViewDataBinding.vpContent.setOffscreenPageLimit(2);
        mViewDataBinding.navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewDataBinding.vpContent.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewDataBinding.vpContent.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewDataBinding.vpContent.setCurrentItem(2);
                    return true;
            }
            return false;
        });
        mViewDataBinding.vpContent.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    mViewDataBinding.navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = mViewDataBinding.navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setSupportActionBar(mViewDataBinding.toolbar.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mViewDataBinding.mainDrawer,
                mViewDataBinding.toolbar.toolbar, R.string.open,
                R.string.close);
        actionBarDrawerToggle.syncState();
        mViewDataBinding.mainDrawer.addDrawerListener(actionBarDrawerToggle);
        setupViewPager();
    }

    private void setupViewPager() {
        HomeActivityViewPagerAdapter adapter = new HomeActivityViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(OneFragment.newInstance());
        adapter.addFragment(TwoFragment.newInstance());
        adapter.addFragment(ThreeFragment.newInstance());
        mViewDataBinding.vpContent.setAdapter(adapter);
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
    public void clickLogin() {

    }
}
