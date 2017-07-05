package com.ruiqin.umengdemo.module.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ruiqin.umengdemo.R;
import com.ruiqin.umengdemo.base.BaseActivity;
import com.ruiqin.umengdemo.util.ShareUtils;
import com.umeng.socialize.UMShareAPI;

import butterknife.OnClick;

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

    @OnClick({R.id.share_qq, R.id.share_wx_chat, R.id.share_wx_circle, R.id.share_sms, R.id.share_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share_qq:
                ShareUtils.share2QQ(ShareActivity.this);
                break;
            case R.id.share_wx_chat:
                ShareUtils.share2WX(ShareActivity.this);
                break;
            case R.id.share_wx_circle:
                break;
            case R.id.share_sms:
                ShareUtils.share2SMS(ShareActivity.this);
                break;
            case R.id.share_cancel:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
