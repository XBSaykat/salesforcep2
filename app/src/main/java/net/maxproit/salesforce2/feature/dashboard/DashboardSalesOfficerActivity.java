package net.maxproit.salesforce2.feature.dashboard;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import net.maxproit.salesforce2.masum.activity.lead.LeadStageActivity;
import net.maxproit.salesforce2.MyPerformancePhaseTwo;
import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityDashboardBinding;
import net.maxproit.salesforce2.feature.login.LoginActivity;
import net.maxproit.salesforce2.masum.activity.prospect.MyProspectFragmentActivity;
import net.maxproit.salesforce2.masum.activity.visitplan.MyActivitiesActivity;
import net.maxproit.salesforce2.masum.activity.lead.MyLeadActivity;
import net.maxproit.salesforce2.masum.activity.visitplan.VisitPlanActivity;
import net.maxproit.salesforce2.masum.utility.ActivityUtils;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

public class DashboardSalesOfficerActivity extends BaseActivity {
    ActivityDashboardBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDashboardBinding) getBinding();
        binding.logout.setOnClickListener(v -> logout());

        Bundle mBundle = new Bundle();
        mBundle.putString("ROOT", "new");
        setProfileData();
        binding.visitPlan.setOnClickListener(v -> startActivity(VisitPlanActivity.class, false));
        //binding.newLead.setOnClickListener(v -> startActivity(NewLeadActivity.class, false, mBundle));
        binding.newLead.setOnClickListener(v -> startActivity(LeadStageActivity.class, false, mBundle));
        binding.myLeads.setOnClickListener(v -> startActivity(MyLeadActivity.class, false));
        binding.prospect.setOnClickListener(v -> startActivity(MyProspectFragmentActivity.class, false, mBundle));
        binding.verification.setOnClickListener(v -> startActivity(MyPerformancePhaseTwo.class, false));

        binding.myVisit.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           ActivityUtils.getInstance().invokeActivity(DashboardSalesOfficerActivity.this,
                   MyActivitiesActivity.class,false);

       }
   });
    }

    @Override
    protected void getIntentData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void setProfileData() {
        String name = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.FULL_NAME);
        String branch = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.BRANCH);
        String svName = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.RBM_NAME);
        String rmCode = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.USER_CODE);

        binding.profile.tvName.setText(name);
        binding.profile.tvBranch.setText(branch);
        binding.profile.tvSuper.setText(svName);
        binding.profile.tvRmCode.setText(rmCode);
    }


    private void logout() {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(DashboardSalesOfficerActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(DashboardSalesOfficerActivity.this);
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
}
