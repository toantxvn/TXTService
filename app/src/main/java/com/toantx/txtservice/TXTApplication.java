package com.toantx.txtservice;

import android.app.Application;
import android.telephony.ims.ImsManager;
import android.util.Log;

public class TXTApplication extends Application {
    private static final String TAG = "TXTX-TXTApplication";

    private ImsManager mImsManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");

        Log.i(TAG, "onCreate: done!");
    }
}
