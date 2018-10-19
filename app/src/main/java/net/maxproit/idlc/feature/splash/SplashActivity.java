package net.maxproit.idlc.feature.splash;

import android.os.Handler;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivitySplashBinding;
import net.maxproit.idlc.feature.login.LoginActivity;

public class SplashActivity extends BaseActivity {
    ActivitySplashBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySplashBinding) getBinding();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(LoginActivity.class, true);
                SplashActivity.this.finish();
            }
        }, 1500);
    }

    @Override
    protected void getIntentData() {
    }
}
