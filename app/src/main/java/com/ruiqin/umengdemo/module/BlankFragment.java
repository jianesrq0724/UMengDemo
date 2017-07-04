package com.ruiqin.umengdemo.module;

import android.os.Bundle;
import android.view.View;

import com.ruiqin.umengdemo.R;
import com.ruiqin.umengdemo.base.BaseFragment;
import com.ruiqin.umengdemo.util.ShareUtils;

import butterknife.OnClick;

public class BlankFragment extends BaseFragment {

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @OnClick(R.id.btn_share)
    public void onClick() {
        ShareUtils.share2QQ(getActivity());
    }

}
