package net.maxproit.salesforce.feature.dashboard;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import net.maxproit.salesforce.masum.activity.lead.LeadStageActivity;
import net.maxproit.salesforce.MyPerformancePhaseTwo;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityDashboardBinding;
import net.maxproit.salesforce.feature.login.LoginActivity;
import net.maxproit.salesforce.masum.activity.visitplan.MyActivitiesActivityNew;
import net.maxproit.salesforce.masum.activity.prospect.MyProspectActivity;
import net.maxproit.salesforce.masum.activity.lead.MyLeadActivity;
import net.maxproit.salesforce.masum.activity.visitplan.VisitPlanListActivity;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

public class DashboardSalesOfficerActivity extends BaseActivity {
    ActivityDashboardBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDashboardBinding) getBinding();
//        binding.btnBack.setOnClickListener(v -> finish());
        binding.logout.setOnClickListener(v -> logout());


        // binding.btnNewSurvey.setOnClickListener(view -> startActivity(InitialSurveyActivity.class, false));
        // binding.btnDraft.setOnClickListener(view -> startActivity(DraftActivity.class, false));
        //  binding.btnSurveyStatus.setOnClickListener(view -> startActivity(StatusActivity.class, false));
        Bundle mBundle = new Bundle();
        mBundle.putString("ROOT", "new");

        binding.visitPlan.setOnClickListener(v -> startActivity(VisitPlanListActivity.class, false, mBundle));
        //binding.newLead.setOnClickListener(v -> startActivity(NewLeadActivity.class, false, mBundle));
        binding.newLead.setOnClickListener(v -> startActivity(LeadStageActivity.class, false, mBundle));
        binding.myLeads.setOnClickListener(v -> startActivity(MyLeadActivity.class, false));
        binding.prospect.setOnClickListener(v -> startActivity(MyProspectActivity.class, false, mBundle));
//        binding.upload.setOnClickListener(v -> startActivity(MyPerfomanceDisbursementsActivity.class, false));
        binding.verification.setOnClickListener(v -> startActivity(MyPerformancePhaseTwo.class, false));

        binding.myVisit.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           ActivityUtils.getInstance().invokeActivity(DashboardSalesOfficerActivity.this,
                   MyActivitiesActivityNew.class,false);

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
