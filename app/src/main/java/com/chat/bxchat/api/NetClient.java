package com.chat.bxchat.api;

import com.chat.bxchat.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @创建者 baoxin
 * @日期 2017/4/27.
 * @描述
 */

public class NetClient {
    private static final int DEFAULT_TIMEOUT = 5;
    private static Retrofit retrofit;
    private static NetClient mNetworks;
    private static CommonApi mCommonApi;

    public static NetClient getInstance() {
        if (mNetworks == null) {
            mNetworks = new NetClient();
        }
        return mNetworks;
    }

    public CommonApi getCommonApi(){
        return mCommonApi == null ? configRetrofit(CommonApi.class) : mCommonApi;
    }

    private <T> T configRetrofit(Class<T> service) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .client(configClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    private OkHttpClient configClient(){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return okHttpClient.build();
    }

}
