package com.chat.bxchat.ui.fragment;

import android.content.Context;

import com.chat.bxchat.R;
import com.chat.bxchat.databinding.FragmentTwoBinding;
import com.chat.bxchat.ui.base.BaseFragment;
import com.chat.bxchat.ui.model.TwoFragmentAtModel;
import com.chat.bxchat.ui.presenter.TwoFragmentAtPresenter;

/**
 * @创建者 baoxin
 * @日期 2017/5/2.
 * @描述
 */

public class TwoFragment extends BaseFragment<FragmentTwoBinding,TwoFragmentAtPresenter,TwoFragmentAtModel> {

    public static TwoFragment newInstance(){
        return new TwoFragment();
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_two;
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
