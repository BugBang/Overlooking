package com.chat.bxchat.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.chat.bxchat.R;
import com.chat.bxchat.databinding.ActivitySplashBinding;
import com.chat.bxchat.entity.common.SplashImgEntity;
import com.chat.bxchat.loader.GlideImageLoader;
import com.chat.bxchat.rx.RxSchedulerHelper;
import com.chat.bxchat.ui.base.BaseActivity;
import com.chat.bxchat.ui.base.BaseFragment;
import com.chat.bxchat.ui.contract.SplashActivityContract;
import com.chat.bxchat.ui.model.SplashActivityAtModel;
import com.chat.bxchat.ui.presenter.SplashActivityAtPresenter;
import com.crashlytics.android.Crashlytics;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.concurrent.TimeUnit;

import io.fabric.sdk.android.Fabric;
import rx.Observable;
import rx.Subscriber;

/**
 * @创建者 baoxin
 * @日期 2017/5/4.
 * @描述
 */

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashActivityAtPresenter, SplashActivityAtModel> implements SplashActivityContract.View {


    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        method1();
        method2();
        method3();
        method4();
        method5();
        method6();
        Fabric.with(this, new Crashlytics());
        return R.layout.activity_splash;
    }

    @Override
    public void doBusiness(Context mContext) {
        mPresenter.getSplashImage();
    }

    private void method1() {

        System.out.println("1");
        System.out.println("2");

        System.out.println("3");

        System.out.println("4");

    }

    private void method2() {
        System.out.println("5");
        System.out.println("6");

    }

    private void method3() {
        System.out.println("7");
        int i = 3;
        long x = SystemClock.currentThreadTimeMillis();
        System.out.println("8");
        System.out.println("9");

    }

    private void method4() {
        System.out.println("10");

    }

    private void method5() {
        System.out.println("11");
        System.out.println("12");

    }

    private void method6() {
        int i = 3;
        System.out.println(i + "");
        System.out.println("13");
        System.out.println("14");
        System.out.println("15");
        System.out.println("16");
        System.out.println("17");
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
    public void loadSplashImage(SplashImgEntity splashImgEntity) {
        GlideImageLoader.getInstance().displayImage(this, splashImgEntity.getCreatives().get(0).getUrl(), mViewDataBinding.splashImg);
    }

    @Override
    public void onRequestEnd() {
        Observable.timer(3, TimeUnit.SECONDS)
                .compose(RxSchedulerHelper.io_main())
                .subscribe(
                        new Subscriber<Long>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Long aLong) {
                                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                );
        //                        .compose(RxPermissions.getInstance(this)
        //                        .ensureEach(Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE))
        super.onRequestEnd();
    }

    @Override
    public void onRequestError(String msg) {
        super.onRequestError(msg);
    }
}
