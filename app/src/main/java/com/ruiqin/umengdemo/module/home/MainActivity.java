package com.ruiqin.umengdemo.module.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ruiqin.umengdemo.R;
import com.ruiqin.umengdemo.base.BaseActivity;
import com.ruiqin.umengdemo.module.BlankFragment;
import com.ruiqin.umengdemo.util.ToastUtils;
import com.umeng.socialize.UMShareAPI;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View {


    @Override
    protected int getFragmentId() {
        return R.id.fragment;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(new BlankFragment());
        mPresenter.testjudge(2);
    }

    @Override
    public void testSuccess() {
        ToastUtils.showShort("大于0");
    }

    @Override
    public void textFail() {
        ToastUtils.showShort("小于0");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean canBack() {
        mToolbarTitle.setText("友盟统计");
        return false;
    }
}
