package net.maxproit.salesforce2.feature.dashboard.supervisor;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityDashboardSupervisorBinding;
import net.maxproit.salesforce2.feature.supervisor.SupervisorFollowUpActivity;
import net.maxproit.salesforce2.feature.supervisor.lead.SupervisorLeadActivity;
import net.maxproit.salesforce2.feature.supervisor.SupervisorDisbursementActivity;
import net.maxproit.salesforce2.feature.supervisor.SupervisorProspectActivity;
import net.maxproit.salesforce2.feature.supervisor.SupervisorSalesofficerNameActivity;
import net.maxproit.salesforce2.feature.supervisor.SupervisorSanctionActivity;
import net.maxproit.salesforce2.feature.supervisor.SupervisorVisitsActivity;
import net.maxproit.salesforce2.model.supervisor.dashboard.SupProspect;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardSupervisorActivity extends BaseActivity {
    private static final String TAG = "DashboardSupervisorActi";
    public String USER_NAME;
    ActivityDashboardSupervisorBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_dashboard_supervisor;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDashboardSupervisorBinding) getBinding();
        USER_NAME = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);

        showProgressDialog();
        getApiService().getSupervisorDashboard(USER_NAME, UUID.randomUUID().toString()).enqueue(new Callback<SupProspect>() {
            @Override
            public void onResponse(Call<SupProspect> call, Response<SupProspect> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    binding.setModel(response.body().getData());

                }
            }

            @Override
            public void onFailure(Call<SupProspect> call, Throwable t) {
                hideProgressDialog();


            }
        });


        // binding.logout.setOnClickListener(v -> logout());
        binding.btnBack.setOnClickListener(v -> finish());


        binding.prospects.setOnClickListener(v -> startActivity(SupervisorProspectActivity.class, false));
        binding.leads.setOnClickListener(v -> startActivity(SupervisorLeadActivity.class, false));
        binding.sen.setOnClickListener(v -> startActivity(SupervisorSanctionActivity.class, false));
        binding.visit1.setOnClickListener(v -> startActivity(SupervisorVisitsActivity.class, false));
        binding.Disbursement.setOnClickListener(v -> startActivity(SupervisorDisbursementActivity.class, false));
        binding.name.setOnClickListener(v -> startActivity(SupervisorSalesofficerNameActivity.class, false));
        binding.Follow.setOnClickListener(v -> startActivity(SupervisorFollowUpActivity.class, false));

    }

    @Override
    protected void getIntentData() {

    }


}
