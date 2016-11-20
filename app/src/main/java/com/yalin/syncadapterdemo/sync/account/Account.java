package com.yalin.syncadapterdemo.sync.account;

import android.accounts.AccountManager;
import android.content.Context;

/**
 * Created by YaLin
 * On 2016/11/20.
 */

public class Account {
    // @string/account_type
    public static final String ACCOUNT_TYPE = "com.yalin.account";
    public static final String ACCOUNT_NAME = "Sync Account";

    public static android.accounts.Account createSyncAccount(Context context) {
        android.accounts.Account newAccount = new android.accounts.Account(ACCOUNT_NAME, ACCOUNT_TYPE);
        AccountManager accountManager = AccountManager.get(context);
        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            return newAccount;
        } else {
            return null;
        }
    }
}
