package com.ruiqin.umengdemo.module.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ruiqin.umengdemo.R;
import com.ruiqin.umengdemo.base.BaseActivity;

public class ShareActivity extends BaseActivity {

    /**
     * 创建自身的实列
     *
     * @param context
     * @return
     */
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), ShareActivity.class);
        return intent;
    }

    @Override
    protected int getFragmentId() {
        return 0;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
    }
}
