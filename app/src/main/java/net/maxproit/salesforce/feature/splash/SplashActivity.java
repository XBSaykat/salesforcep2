package net.maxproit.salesforce.feature.splash;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivitySplashBinding;
import net.maxproit.salesforce.feature.login.LoginActivity;

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
            }else {
                initSplash(SplashActivity.this, LoginActivity.class);
            }

        }
        else {
            initSplash(SplashActivity.this, LoginActivity.class);
        }

    }

    @Override
    protected void getIntentData() {
    }
}
