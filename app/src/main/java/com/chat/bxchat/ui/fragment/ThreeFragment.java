package com.chat.bxchat.ui.fragment;

import android.content.Context;

import com.chat.bxchat.R;
import com.chat.bxchat.databinding.FragmentThreeBinding;
import com.chat.bxchat.databinding.FragmentTwoBinding;
import com.chat.bxchat.ui.base.BaseFragment;
import com.chat.bxchat.ui.model.ThreeFragmentAtModel;
import com.chat.bxchat.ui.presenter.ThreeFragmentAtPresenter;

/**
 * @创建者 baoxin
 * @日期 2017/5/2.
 * @描述
 */

public class ThreeFragment extends BaseFragment<FragmentThreeBinding,ThreeFragmentAtPresenter,ThreeFragmentAtModel> {

    public static ThreeFragment newInstance(){
        return new ThreeFragment();
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_three;
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
