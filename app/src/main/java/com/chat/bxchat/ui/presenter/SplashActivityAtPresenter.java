package com.chat.bxchat.ui.presenter;

import com.chat.bxchat.entity.common.SplashImgEntity;
import com.chat.bxchat.ui.contract.HomeContract;
import com.chat.bxchat.ui.contract.SplashActivityContract;
import com.orhanobut.logger.Logger;

import rx.Subscriber;

/**
 * @创建者 baoxin
 * @日期 2017/4/25.
 * @描述
 */

public class SplashActivityAtPresenter extends SplashActivityContract.Presenter {

    @Override
    public void getSplashImage() {

        mRxManager.add(mModel.getSplashImg().subscribe(new Subscriber<SplashImgEntity>() {
            @Override
            public void onCompleted() {
                mView.onRequestEnd();
            }

            @Override
            public void onError(Throwable e) {
                mView.onRequestError(e.toString());
            }

            @Override
            public void onNext(SplashImgEntity splashImgEntity) {
                mView.loadSplashImage(splashImgEntity);
            }
        }));
    }
}
