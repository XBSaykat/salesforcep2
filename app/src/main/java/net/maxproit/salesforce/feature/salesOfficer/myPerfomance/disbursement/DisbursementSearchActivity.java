package net.maxproit.salesforce.feature.salesOfficer.myPerfomance.disbursement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityDisbursementSearchBinding;
import net.maxproit.salesforce.feature.salesOfficer.myPerfomance.disbursement.adapter.DisbursementSearchAdapter;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.model.search.DisbursementSearch;
import net.maxproit.salesforce.model.search.searchlist.disbursementsearch.DisbursementSearchResponce;
import net.maxproit.salesforce.model.search.searchlist.disbursementsearch.DisbursementSearchResponceList;
import net.maxproit.salesforce.util.CommonUtil;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisbursementSearchActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "DisbursementSearchActiv";
    ActivityDisbursementSearchBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_disbursement_search;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDisbursementSearchBinding) getBinding();
        binding.setModel(new DisbursementSearch());

        binding.etClientName.setOnClickListener(v -> CommonUtil.showDatePicker(getContext(), binding.etClientName, Calendar.getInstance()));
        binding.etNationalID.setOnClickListener(v -> CommonUtil.showDatePicker(getContext(), binding.etNationalID, Calendar.getInstance()));
        binding.btnSearch.setOnClickListener(v -> callSearchApi());

    }

    private void callSearchApi() {
        showProgressDialog();
        getApiService().searchDisbursement(binding.getModel()).enqueue(new Callback<DisbursementSearchResponceList>() {
            @Override
            public void onResponse(Call<DisbursementSearchResponceList> call, Response<DisbursementSearchResponceList> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        binding.mainSearchView.setVisibility(View.GONE);
                        binding.listSearchView.setVisibility(View.VISIBLE);

                        crateView(response.body().getData());

                        // localCash().put(SharedPreferencesEnum.Key.DEV_SEARCH,toJson(response.body()));
                        Log.d(TAG, "onResponse: " + toJson(response.body()));


                    } else showAlertDialog("Error", response.body().getMessage());

                } else showAlertDialog("Error", response.message());

            }

            private void crateView(List<DisbursementSearchResponce> data) {

                DisbursementSearchAdapter adapter = new DisbursementSearchAdapter(DisbursementSearchActivity.this, data);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                binding.rv.setLayoutManager(mLayoutManager);
                binding.rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<DisbursementSearchResponceList> call, Throwable t) {
                hideProgressDialog();
                showAlertDialog("Error", t.getMessage());

            }
        });

    }

    @Override
    protected void getIntentData() {

    }

    @Override
    public void adShowProgressDialog() {

    }

    @Override
    public void adHideProgressDialog() {

    }

    @Override
    public void adSuccess(String message) {
        Intent intent = new Intent();
        intent.putExtra("RFID", message);
        setResult(RESULT_OK,intent);
        finish();


    }

    @Override
    public void adFailed(String message) {

    }

    @Override
    public void startActivity(boolean self, Bundle bundle) {

    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {

    }
}
