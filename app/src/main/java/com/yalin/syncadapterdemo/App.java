package com.yalin.syncadapterdemo;

import android.app.Application;

import com.yalin.syncadapterdemo.log.StatLog;

/**
 * Created by YaLin
 * On 2016/11/20.
 */

public class App extends Application {
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(final Thread thread, final Throwable ex) {

                StatLog.printLog("App", "exception ", ex);

                defaultUncaughtExceptionHandler.uncaughtException(thread, ex);
            }
        });
    }
}
