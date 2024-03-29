package net.maxproit.salesforce2.feature.splash;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivitySplashBinding;
import net.maxproit.salesforce2.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.salesforce2.feature.dashboard.DashboardVirifierActivity;
import net.maxproit.salesforce2.feature.dashboard.supervisor.MainDashboardSupervisorActivity;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

public class SplashActivity extends BaseActivity {
    ActivitySplashBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySplashBinding) getBinding();
        if (isNetworkAvailable() && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
            checkAppVersion(this);
        } else {
           initSplash(this);
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
