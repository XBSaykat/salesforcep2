package net.maxproit.salesforce.feature.splash;

import android.os.Handler;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivitySplashBinding;
import net.maxproit.salesforce.feature.login.LoginActivity;
import net.maxproit.salesforce.masum.sqlite.SpinnerDbController;

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
