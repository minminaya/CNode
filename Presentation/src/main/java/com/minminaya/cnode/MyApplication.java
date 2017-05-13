package com.minminaya.cnode;

import android.app.Application;
import android.content.Context;

/**
 * Created by Niwa on 2017/5/13.
 */

public class MyApplication extends Application {


    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

}
