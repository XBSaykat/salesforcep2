package net.maxproit.idlc.feature.dashboard;

import android.app.AlertDialog;
import android.os.Build;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityDashboardVirifierBinding;
import net.maxproit.idlc.feature.login.LoginActivity;
import net.maxproit.idlc.feature.virifier.VirifierListActivity;
import net.maxproit.idlc.util.SharedPreferencesEnum;

public class DashboardVirifierActivity extends BaseActivity {

    ActivityDashboardVirifierBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_dashboard_virifier;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDashboardVirifierBinding) getBinding();
        binding.logout.setOnClickListener(v -> logout());
        binding.btnBack.setOnClickListener(v -> finish());
        binding.vrf.setOnClickListener(view -> startActivity(VirifierListActivity.class, false));

    }

    private void logout() {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(DashboardVirifierActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(DashboardVirifierActivity.this);
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
