package com.example.pfddemo;

import android.app.Application;
import android.content.Context;

import com.google.android.play.core.splitcompat.SplitCompat;

public class MyApplication extends Application {

    protected static MyApplication instance = null;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        instance = this;
        SplitCompat.install(this);
    }
}
