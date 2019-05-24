package net.maxproit.salesforce2.feature.dashboard.supervisor;

import android.app.AlertDialog;
import android.os.Build;
import android.view.View;

import net.maxproit.salesforce2.MyPerformancePhaseTwo;
import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.SupervisorRbmProspect;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityMainDashboardSupervisorBinding;
import net.maxproit.salesforce2.feature.login.LoginActivity;
import net.maxproit.salesforce2.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

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

        setProfileData();
    }


    private void setProfileData() {
        String name = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.FULL_NAME);
        String branch = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.BRANCH);
        String svName = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.RBM_NAME);
        String rmCode = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.USER_CODE);

        binding.profile.tvName.setText(name);
        binding.profile.tvBranch.setText(branch);

        if (!MasumCommonUtils.isNullStr(svName)) {
            binding.profile.tvSuper.setText(svName);
        } else {
            binding.profile.lnSup.setVisibility(View.GONE);
        }
        binding.profile.tvRmCode.setText(rmCode);
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
