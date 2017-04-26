package com.chat.bxchat.event;

/**
 * Created by soffice on 2017/4/25.
 */

public class EventMsg<T> {
    private String s_msg;
    private int i_msg;
    private T msg;

    public EventMsg(String s_msg, T msg) {
        this.s_msg = s_msg;
        this.msg = msg;
    }

    public EventMsg(String s_msg, int i_msg) {
        this.s_msg = s_msg;
        this.i_msg = i_msg;
    }

    public EventMsg(int i_msg) {
        this.i_msg = i_msg;
    }

    public String getS_msg() {
        return s_msg;
    }

    public void setS_msg(String s_msg) {
        this.s_msg = s_msg;
    }

    public int getI_msg() {
        return i_msg;
    }

    public void setI_msg(int i_msg) {
        this.i_msg = i_msg;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}
