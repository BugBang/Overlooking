package com.chat.bxchat.ui.contract;

import com.chat.bxchat.ui.base.BaseModel;
import com.chat.bxchat.ui.base.BasePresenter;
import com.chat.bxchat.ui.base.BaseView;

/**
 * @创建者 baoxin
 * @日期 2017/5/4.
 * @描述
 */

public interface OneFragmentContract {

   interface Model extends BaseModel{

   }
   interface View extends BaseView{

   }
   abstract class Presenter extends BasePresenter<Model,View>{

   }
}
