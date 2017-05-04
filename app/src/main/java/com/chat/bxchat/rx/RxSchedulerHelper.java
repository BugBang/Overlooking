package com.chat.bxchat.rx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @创建者 baoxin
 * @日期 2017/5/2.
 * @描述
 */

public class RxSchedulerHelper {
    public static <T> Observable.Transformer<T, T> io_main() {

        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {

                return tObservable
                        // 生产线程
                        .subscribeOn(Schedulers.io())
                        // 消费线程
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
