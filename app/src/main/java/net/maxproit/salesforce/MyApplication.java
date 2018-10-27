package net.maxproit.salesforce;

import android.app.Application;

import com.rohitss.uceh.UCEHandler;

/**
 * Created by Rezwan Khan Chowdhury on 9/27/2018.
 * heyrezwan@gmail.com
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        new UCEHandler.Builder(this).build();
    }
}
