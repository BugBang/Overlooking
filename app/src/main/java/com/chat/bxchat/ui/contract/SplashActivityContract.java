package com.chat.bxchat.ui.contract;

import com.chat.bxchat.entity.common.SplashImgEntity;
import com.chat.bxchat.ui.base.BaseModel;
import com.chat.bxchat.ui.base.BasePresenter;
import com.chat.bxchat.ui.base.BaseView;

import rx.Observable;

/**
 * @创建者 baoxin
 * @日期 2017/4/26.
 * @描述
 */

public interface SplashActivityContract {

    interface Model extends BaseModel {
        Observable<SplashImgEntity> getSplashImg();
    }

    interface View extends BaseView {
        void loadSplashImage(SplashImgEntity splashImgEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getSplashImage();
    }
}
