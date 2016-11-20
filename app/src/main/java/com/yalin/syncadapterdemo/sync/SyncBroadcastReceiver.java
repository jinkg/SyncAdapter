package com.yalin.syncadapterdemo.sync;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.yalin.syncadapterdemo.log.StatLog;
import com.yalin.syncadapterdemo.sync.account.Account;

/**
 * Created by YaLin
 * On 2016/11/20.
 */

public class SyncBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "SyncBroadcastReceiver";

    public static final String AUTHORITY = "com.yalin.syncadapterdemo.provider";

    public static final String ACTION_SYNC_REQUEST = "com.yalin.ACTION_SYNC_REQUEST";

    @Override
    public void onReceive(Context context, Intent intent) {
        StatLog.printLog(TAG, "onReceive : " + intent.getAction());
        if (TextUtils.equals(intent.getAction(), ACTION_SYNC_REQUEST)) {
            Bundle extras = new Bundle();
            extras.putInt(SyncAdapter.TYPE_KEY, SyncAdapter.TYPE_BROADCAST);
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
            extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
            ContentResolver.requestSync(
                    new android.accounts.Account(Account.ACCOUNT_NAME, Account.ACCOUNT_TYPE),
                    AUTHORITY, extras);
        }
    }
}
