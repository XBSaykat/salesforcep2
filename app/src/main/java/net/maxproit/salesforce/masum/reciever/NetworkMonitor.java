package net.maxproit.salesforce.masum.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static net.maxproit.salesforce.masum.appdata.AppConstant.IS_NETWORK_AVAILABLE;

public class NetworkMonitor extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            if (isConnectedToInternet(context)) {
                Toast.makeText(context, "connected", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "no connected", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private boolean isConnectedToInternet(Context context) {
        try {
            if (context != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
