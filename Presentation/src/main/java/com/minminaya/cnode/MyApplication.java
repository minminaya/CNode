package com.minminaya.cnode;

import android.app.Application;
import android.content.Context;

/**
 * Created by Niwa on 2017/5/13.
 */

public class MyApplication extends Application {


    private static MyApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
    public static MyApplication getINSTANCE() {
        return INSTANCE;
    }
}
