package net.maxproit.salesforce2.model.login;

import android.content.Context;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce2.util.SharedPreferencesEnum;

/**
 * Created by Rezwan Khan chowdhury on 6/21/18.
 * heyRezwan@gmail.com
 */
public class LocalLogin {

    private Context context;

    public LocalLogin(Context context) {
        this.context = context;
    }

    public LoginResponse getLocalogin() {
        String setting = SharedPreferencesEnum.getInstance(context).getString(SharedPreferencesEnum.Key.LOCA_LLOGIN);
        if (!setting.isEmpty()) {
            return new GsonBuilder().serializeNulls().create().fromJson(setting, LoginResponse.class);
        } else
            return null;

    }

    public String getFullname() {
        if (getLocalogin() != null) {
            return getLocalogin().getData().getFullName();
        }
        return "";
    }

    public String getBranch() {
        if (getLocalogin() != null) {
            return getLocalogin().getData().getBranch();
        }
        return "";
    }

    public String getBooth() {
        if (getLocalogin() != null) {
            return getLocalogin().getData().getBooth();
        }
        return "";
    }

    public String getUserTypeId() {
        if (getLocalogin() != null) {
            return getLocalogin().getData().getUserTypeId();
        }
        return "";
    }

}
