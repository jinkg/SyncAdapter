package com.yalin.syncadapterdemo.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.yalin.syncadapterdemo.log.StatLog;

/**
 * Created by YaLin
 * On 2016/11/20.
 */

public class SyncService extends Service {
    private static final String TAG = "SyncService";

    private static SyncAdapter sSyncAdapter = null;

    private static final Object sSyncAdapterLock = new Object();

    @Override
    public void onCreate() {
        StatLog.printLog(TAG, "SyncService onCreate");
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null) {
                sSyncAdapter = new SyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        StatLog.printLog(TAG, "SyncService onBind'");
        return sSyncAdapter.getSyncAdapterBinder();
    }
}
