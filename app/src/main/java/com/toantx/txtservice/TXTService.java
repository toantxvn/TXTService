package com.toantx.txtservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.toantx.txtmanager.ITXTAidlInterface;
import com.toantx.txtmanager.MyData;

public class TXTService extends Service {
    private static final String TAG = "TXTX-TXTService";

    public TXTService() {
        Log.i(TAG, "TXTService: constructor()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: " + intent + " - " + mBinder);
        return mBinder;
    }

    private final ITXTAidlInterface.Stub mBinder = new ITXTAidlInterface.Stub() {
        @Override
        public MyData setMyData(MyData data) {
            Log.i(TAG, "setMyData: " + data);
            MyData returnData = new MyData("Toan", 22);
            Log.i(TAG, "return New MyData: " + returnData);
            return returnData;
        }
    };
}