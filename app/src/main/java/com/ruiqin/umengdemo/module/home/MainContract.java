package com.ruiqin.umengdemo.module.home;

import com.ruiqin.umengdemo.base.BaseModel;
import com.ruiqin.umengdemo.base.BasePresenter;
import com.ruiqin.umengdemo.base.BaseView;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public interface MainContract {
    interface Model extends BaseModel {

    }

    interface View extends BaseView {
        void testSuccess();

        void textFail();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void testjudge(int value);
    }
}
