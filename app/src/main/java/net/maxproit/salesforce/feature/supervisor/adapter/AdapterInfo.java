package net.maxproit.salesforce.feature.supervisor.adapter;

import android.os.Bundle;

/**
 * Created by Rezwan Khan chowdhury on 6/27/18.
 * heyRezwan@gmail.com
 */
public interface AdapterInfo {
    void adShowProgressDialog();

    void adHideProgressDialog();

    void adSuccess(String message);

    void adFailed(String message);

    void startActivity(boolean self, Bundle bundle);

    void startActivity(boolean self, Bundle bundle, int code);
}
