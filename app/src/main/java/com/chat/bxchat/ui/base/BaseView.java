package com.chat.bxchat.ui.base;

/**
 * @创建者 baoxin
 * @日期 2017/4/26.
 * @描述
 */

public interface BaseView {
    void onRequestStart();
    void onRequestError(String msg);
    void onRequestEnd();
    void onInternetError();
}
