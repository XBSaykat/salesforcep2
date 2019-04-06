package net.maxproit.salesforce.feature.salesOfficer.myPerfomance;

import android.util.Log;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityMyPerfomanceBinding;
import net.maxproit.salesforce.feature.salesOfficer.SalesOfficerDisbursementActivity;
import net.maxproit.salesforce.model.salesOfficer.myPerfomance.MyPerfomance;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerfomanceActivity extends BaseActivity {
    private static final String TAG = "MyPerfomanceActivity";

    ActivityMyPerfomanceBinding binding;
    String username;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_perfomance;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityMyPerfomanceBinding) getBinding();
        binding.btnBack.setOnClickListener(v -> finish());
        username = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        localCash().put(SharedPreferencesEnum.Key.USER_NAME_PER,username);

        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getMyPerfomance(username, UUID.randomUUID().toString()).enqueue(new Callback<MyPerfomance>() {
                @Override
                public void onResponse(Call<MyPerfomance> call, Response<MyPerfomance> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {
                        binding.setModel(response.body().getData());
                        String en = new GsonBuilder().serializeNulls().create().toJson(response.body());
                        Log.d(TAG, en);


                    }

                }

                @Override
                public void onFailure(Call<MyPerfomance> call, Throwable t) {
                    hideProgressDialog();

                }
            });
        } else showToast("Network is not avalable");


        binding.leads.setOnClickListener(v -> startActivity(MyPerfomanceLeadActivity.class, false));
        binding.prospects.setOnClickListener(v -> startActivity(MyPerfomanceProspectActivity.class, false));
        binding.sen.setOnClickListener(v -> startActivity(MyPerfomanceSanctionActivity.class, false));
        binding.visit1.setOnClickListener(v -> startActivity(MyPerformanceVisitsActivity.class, false));
        binding.Follow.setOnClickListener(v -> startActivity(MyPerfomancFollowUpCallsActivity.class, false));
        binding.Disbursement.setOnClickListener(v -> startActivity(SalesOfficerDisbursementActivity.class, false));


    }

    @Override
    protected void getIntentData() {

    }
}
