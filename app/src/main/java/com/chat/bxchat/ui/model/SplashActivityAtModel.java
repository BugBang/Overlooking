package com.chat.bxchat.ui.model;

import com.chat.bxchat.api.NetClient;
import com.chat.bxchat.entity.common.SplashImgEntity;
import com.chat.bxchat.rx.RxSchedulerHelper;
import com.chat.bxchat.ui.contract.HomeContract;
import com.chat.bxchat.ui.contract.SplashActivityContract;

import rx.Observable;

/**
 * @创建者 baoxin
 * @日期 2017/4/27.
 * @描述
 */

public class SplashActivityAtModel implements SplashActivityContract.Model {

    @Override
    public Observable<SplashImgEntity> getSplashImg() {
        return NetClient.getInstance().getCommonApi()
                .getSplashImg()
                .compose(RxSchedulerHelper.<SplashImgEntity>io_main());
    }
}
