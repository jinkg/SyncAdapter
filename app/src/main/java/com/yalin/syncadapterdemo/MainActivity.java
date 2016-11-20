package com.yalin.syncadapterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yalin.syncadapterdemo.log.StatLog;
import com.yalin.syncadapterdemo.sync.SyncBroadcastReceiver;
import com.yalin.syncadapterdemo.sync.account.Account;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private android.accounts.Account mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccount = Account.createSyncAccount(this);
    }


    public void syncByBroadcast(View view) {
        StatLog.printLog(TAG, "syncByBroadcast");
        Intent intent = new Intent(SyncBroadcastReceiver.ACTION_SYNC_REQUEST);
        sendBroadcast(intent);
    }
}
