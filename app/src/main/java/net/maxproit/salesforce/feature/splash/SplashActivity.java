package net.maxproit.salesforce.feature.splash;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivitySplashBinding;
import net.maxproit.salesforce.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.salesforce.feature.dashboard.DashboardVirifierActivity;
import net.maxproit.salesforce.feature.dashboard.supervisor.MainDashboardSupervisorActivity;
import net.maxproit.salesforce.feature.login.LoginActivity;
import net.maxproit.salesforce.masum.appdata.preference.AppPreference;
import net.maxproit.salesforce.masum.appdata.preference.PrefKey;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

public class SplashActivity extends BaseActivity {
    ActivitySplashBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySplashBinding) getBinding();
        if (isNetworkAvailable()) {
            boolean isFromSplashScreen = true;
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
                checkAppVersion(isFromSplashScreen, SplashActivity.this, LoginActivity.class);
            } else {
                if (!AppPreference.getInstance(SplashActivity.this).getBoolean(PrefKey.IS_LOGIN)) {
                    initSplash(SplashActivity.this, LoginActivity.class);
                }
                else {
                    String roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);
                    if (!roll.isEmpty()) {
                        gotoBoard(roll);
                    }
                }
            }

        } else {
            if (!AppPreference.getInstance(SplashActivity.this).getBoolean(PrefKey.IS_LOGIN)) {
                initSplash(SplashActivity.this, LoginActivity.class);
            }
            else {
                String roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);
                if (!roll.isEmpty()) {
                    gotoBoard(roll);
                }
            }
        }

    }

    @Override
    protected void getIntentData() {
    }

    private void gotoBoard(String uT) {

        if (uT.equals("1")) {
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, uT);
            startActivity(DashboardSalesOfficerActivity.class, true);
            // startActivity(LocationTestActivity.class, true);


        } else if (uT.equals("2")) {
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, uT);
            startActivity(MainDashboardSupervisorActivity.class, true);


        } else if (uT.equals("3")) {
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, uT);
            startActivity(DashboardVirifierActivity.class, true);


        }

    }
}
