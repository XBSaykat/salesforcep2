package net.maxproit.idlc.feature.dashboard;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import net.maxproit.idlc.LeadStageActivity;
import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityDashboardBinding;
import net.maxproit.idlc.feature.login.LoginActivity;
import net.maxproit.idlc.feature.masum.MyVisitPlanListActivity;
import net.maxproit.idlc.feature.salesOfficer.VisitPlanActivity;
import net.maxproit.idlc.feature.salesOfficer.myPerfomance.MyPerfomanceActivity;
import net.maxproit.idlc.feature.salesOfficer.myPerfomance.disbursement.MyPerfomanceDisbursementsActivity;
import net.maxproit.idlc.feature.salesOfficer.myProspect.MyProspectActivity;
import net.maxproit.idlc.feature.salesOfficer.mylead.MyLeadActivity;
import net.maxproit.idlc.feature.salesOfficer.newlead.NewLeadActivity;
import net.maxproit.idlc.feature.upload.UploadActivity;
import net.maxproit.idlc.util.ActivityUtils;
import net.maxproit.idlc.util.SharedPreferencesEnum;

public class DashboardSalesOfficerActivity extends BaseActivity {
    ActivityDashboardBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDashboardBinding) getBinding();
        binding.btnBack.setOnClickListener(v -> finish());
        binding.logout.setOnClickListener(v -> logout());


        // binding.btnNewSurvey.setOnClickListener(view -> startActivity(InitialSurveyActivity.class, false));
        // binding.btnDraft.setOnClickListener(view -> startActivity(DraftActivity.class, false));
        //  binding.btnSurveyStatus.setOnClickListener(view -> startActivity(StatusActivity.class, false));
        Bundle mBundle = new Bundle();
        mBundle.putString("ROOT", "new");

        binding.visitPlan.setOnClickListener(v -> startActivity(VisitPlanActivity.class, false, mBundle));
        //binding.newLead.setOnClickListener(v -> startActivity(NewLeadActivity.class, false, mBundle));
        binding.newLead.setOnClickListener(v -> startActivity(LeadStageActivity.class, false, mBundle));
        binding.myLeads.setOnClickListener(v -> startActivity(MyLeadActivity.class, false));
        binding.prospect.setOnClickListener(v -> startActivity(MyProspectActivity.class, false, mBundle));
        binding.upload.setOnClickListener(v -> startActivity(MyPerfomanceDisbursementsActivity.class, false));
        binding.verification.setOnClickListener(v -> startActivity(MyPerfomanceActivity.class, false));
   binding.myVisit.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           ActivityUtils.getInstance().invokeActivity(DashboardSalesOfficerActivity.this,MyVisitPlanListActivity.class,false);
           Toast.makeText(DashboardSalesOfficerActivity.this, "click", Toast.LENGTH_SHORT).show();
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
