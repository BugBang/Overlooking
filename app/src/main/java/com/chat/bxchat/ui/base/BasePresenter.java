package com.chat.bxchat.ui.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by soffice on 2017/4/25.
 */

public class BasePresenter<M, V> {

    public M mModel;
    public V mView;
    //    public RxManager mRxManager = new RxManager();

    public void attachVM(V v, M m) {
        this.mModel = m;
        this.mView = v;
    }

    public void detachVM() {
        //        mRxManager.clear();
        mView = null;
        mModel = null;
    }
}
