package com.ruiqin.umengdemo.util;

import android.app.Activity;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class ShareUtils {
    /**
     * 分享到QQ
     *
     * @param activity
     */
    public static void share2QQ(Activity activity) {
        new ShareAction(activity).setPlatform(SHARE_MEDIA.QQ)
                .withMedia(getUMWeb())
                .setCallback(umShareListener)
                .share();
    }

    /**
     * 分享到微信
     *
     * @return
     */
    public static void share2WX(Activity activity) {
        new ShareAction(activity).setPlatform(SHARE_MEDIA.WEIXIN)
                .withMedia(getUMWeb())
                .setCallback(umShareListener)
                .share();
    }

    /**
     * 分享到短信
     *
     * @param activity
     */
    public static void share2SMS(Activity activity) {
        new ShareAction(activity).setPlatform(SHARE_MEDIA.SMS)
                .withMedia(getUMWeb())
                .setCallback(umShareListener)
                .share();
    }

    private static UMWeb getUMWeb() {
        UMWeb web = new UMWeb("http://www.baidu.com");
        web.setTitle("This is music title");//标题
        web.setDescription("my description");//描述
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
