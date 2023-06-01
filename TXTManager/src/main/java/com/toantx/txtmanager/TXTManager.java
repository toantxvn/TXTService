package com.toantx.txtmanager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * To manage TXTService
 */
public class TXTManager {
    private static final String TAG = "TXTX-TXTManager";

    private static final String PACKAGE_NAME = "com.toantx.txtservice";
    private static final String CLASS_NAME = "com.toantx.txtservice.TXTService";
    private final Context mContext;
    private ITXTAidlInterface mService;
    private final ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ITXTAidlInterface.Stub.asInterface(service);
            Log.i(TAG, "onServiceConnected: " + service + " - " + mService);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
            Log.i(TAG, "onServiceDisconnected()");
        }
    };

    public TXTManager(Context context) {
        Log.i(TAG, "TXTManager: constructor()");
        this.mContext = context;
    }

    /**
     * bind to TXTService
     *
     * @return result of binding to TXTService
     */
    public boolean bindToService() {
        Intent intent = new Intent();
        intent.setClassName(PACKAGE_NAME, CLASS_NAME);
        boolean result = mContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        Log.i(TAG, "bindToService: " + result);
        return result;
    }

    /**
     * unbind to TXTService
     */
    public void unbindToService() {
        mContext.unbindService(mConnection);
    }

    /**
     * set MyData
     *
     * @param myData is MyData
     * @return another new MyData
     */
    public MyData setValue(MyData myData) {
        Log.i(TAG, "setValue: " + myData);
        MyData returnedData = null;
        try {
            returnedData = mService.setMyData(myData);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "setValue: returned Value: " + returnedData);
        return returnedData;
    }
}
