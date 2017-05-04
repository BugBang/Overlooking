package com.chat.bxchat.entity.common;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.chat.bxchat.BR;

/**
 * @创建者 baoxin
 * @日期 2017/5/3.
 * @描述
 */

public class UserEntity extends BaseObservable{
    private String name;
    private String sex;
    private int age;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
