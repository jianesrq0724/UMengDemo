package com.ruiqin.umengdemo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.ruiqin.umengdemo.greendao.gen.DaoMaster;
import com.ruiqin.umengdemo.greendao.gen.DaoSession;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Ruiqin on 2017/6/26.
 */

public class App extends Application {
    private static Context mContext;
    private static App app;
    private DaoSession daoSession;
    public static String mobileNum;

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mContext = getApplicationContext();
        Utils.init(mContext);

        UMShareAPI.get(this);

        /**
         * 初始化数据库
         */
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(mContext, "test-db");
        Database writableDb = devOpenHelper.getWritableDb();
        daoSession = new DaoMaster(writableDb).newSession();
    }

    public static final Context getContext() {
        return mContext;
    }

    public static final App getApp() {
        return app;
    }

}
