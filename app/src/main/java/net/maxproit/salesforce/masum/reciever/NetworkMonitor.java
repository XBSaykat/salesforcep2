package net.maxproit.salesforce.masum.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import net.maxproit.salesforce.masum.utility.NetworkUtil;


public class NetworkMonitor extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean status = NetworkUtil.getConnectivityStatusString(context);

        if (status){
            Log.e("status","connected");
        }
        else {
            Log.e("status","not connected");
        }
    }

}
