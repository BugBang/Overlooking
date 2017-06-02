package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TestClass {

    private static List<String> mWeeks = new ArrayList<>() ;
    private static List<String> mWeeksTodayBefore;
    private static List<String> mWeeksTodayAfter;

    public static void main(String[] args){
        String a = "2017-05-15";
        String[] split = a.split("-");
        System.out.println(split[2]);

    }

    public static int getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return w;
    }
}
