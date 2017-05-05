package com.chat.bxchat.api;

import com.chat.bxchat.entity.common.SplashImgEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @创建者 baoxin
 * @日期 2017/4/27.
 * @描述
 */

public interface CommonApi {
    /**
     * 获取启动界面图像
     * @return
     */
    @GET("7/prefetch-launch-images/1080*1920")
    Observable<SplashImgEntity> getSplashImg();
}
