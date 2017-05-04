package com.chat.bxchat.click;

import android.view.View;
import android.widget.Toast;

/**
 * @创建者 baoxin
 * @日期 2017/5/3.
 * @描述
 */

public class ClickEvent {
    public void click(View v){
        Toast.makeText(v.getContext(), "测试成功 \n Context对象为"
                        + v.getContext().toString()
                        + "\n View对象为"
                        + v.toString(),
                Toast.LENGTH_SHORT).show();
    }

}
