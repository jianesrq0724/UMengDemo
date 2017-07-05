package com.ruiqin.umengdemo.module.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.ruiqin.umengdemo.R;
import com.ruiqin.umengdemo.util.ToastUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class ShareDialog extends Dialog {

    private Context mContext;

    public ShareDialog(@NonNull Context context) {
        this(context, R.style.custom_dialog_theme);
    }

    public ShareDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    protected ShareDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        ButterKnife.bind(this);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.BOTTOM);
    }


    @OnClick({R.id.share_qq, R.id.share_wx_chat, R.id.share_wx_circle, R.id.share_sms, R.id.share_cancel})
    public void onClick(View view) {
        cancel();
        switch (view.getId()) {
            case R.id.share_qq:
                share2QQ();
                break;
            case R.id.share_wx_chat:
                share2WX_Chat();
                break;
            case R.id.share_wx_circle:
                share2WX_Circle();
                break;
            case R.id.share_sms:
                share2SMS();
                break;
            case R.id.share_cancel:
                break;
        }
    }


    /**
     * 分享到QQ
     */
    private void share2QQ() {
        shareAction(SHARE_MEDIA.QQ);
    }


    /**
     * 分享到微信好友
     *
     * @return
     */
    private void share2WX_Chat() {
        shareAction(SHARE_MEDIA.WEIXIN);
    }

    /**
     * 分享到微信朋友圈
     */
    private void share2WX_Circle() {
        shareAction(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /**
     * 分享到短信
     */
    private void share2SMS() {
        shareAction(SHARE_MEDIA.SMS);
    }

    /**
     * 创建action
     */
    private void shareAction(SHARE_MEDIA platform) {
        new ShareAction((Activity) mContext).setPlatform(platform)
                .withMedia(getUMWeb())
                .setCallback(umShareListener)
                .share();
    }

    private static UMWeb getUMWeb() {
        UMWeb web = new UMWeb("http://www.baidu.com");
        web.setTitle("test share");//标题
        web.setDescription("test share");//描述
        return web;
    }


    private static UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
            ToastUtils.showShort("开始分享");
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            ToastUtils.showShort("分享成功啦");
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            ToastUtils.showShort("分享失败啦, " + t.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            ToastUtils.showShort("分享取消了");
        }
    };

}
