package net.maxproit.salesforce.feature.dashboard.supervisor;

import android.app.AlertDialog;
import android.os.Build;

import net.maxproit.salesforce.MyPerformancePhaseTwo;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.SupervisorRbmProspect;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityMainDashboardSupervisorBinding;
import net.maxproit.salesforce.feature.login.LoginActivity;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

public class MainDashboardSupervisorActivity extends BaseActivity {

    ActivityMainDashboardSupervisorBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main_dashboard_supervisor;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityMainDashboardSupervisorBinding) getBinding();
        binding.logout.setOnClickListener(v -> logout());
        binding.btnBack.setOnClickListener(v -> finish());
//        binding.dashboard.setOnClickListener(v -> startActivity(DashboardSupervisorActivity.class, false));
        binding.prospect.setOnClickListener(v -> startActivity(SupervisorRbmProspect.class, false));
        binding.dashboard.setOnClickListener(v -> startActivity(MyPerformancePhaseTwo.class, false));

    }

    private void logout() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(MainDashboardSupervisorActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(MainDashboardSupervisorActivity.this);
        }
        builder.setTitle(getString(R.string.logout_title));
        builder.setMessage(getString(R.string.logout_message));
        builder.setIcon(R.drawable.logout_icon);
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            startActivity(LoginActivity.class, true);
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, "");
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void getIntentData() {

    }
}
