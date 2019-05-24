package net.maxproit.salesforce2.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Rezwan Khan Chowdhury on 4/12/18.
 */

public class MyApplication extends Application {

    private static Object mContext;

    public static Context getContext() {
        return (Context) mContext;
    }

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}