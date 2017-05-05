package com.example;

import java.util.List;

public class TestClass {

    public static void main(String[] args){
        Object p = new Object();
        to(2,p);
    }

    void func1(List<? extends Object> list){

    }

    <T extends Object> void func2(List<T> list){

    }

    public static <X>void to(X x,X b){

    }

    public static void s(){
        to(2,"2");
    }
}
