package net.maxproit.salesforce.feature.salesOfficer.parallelprocess.cif;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityCifNewBinding;
import net.maxproit.salesforce.feature.salesOfficer.parallelprocess.cif.adapter.NotRequestCifAdapter;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.model.cif.notRequestedCIF.NotRequestedCif;
import net.maxproit.salesforce.model.cif.notRequestedCIF.NotRequestedCifData;
import net.maxproit.salesforce.model.cif.post.CifRequestDtl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CifActivityNew extends BaseActivity implements AdapterInfo {
    private static final String TAG = "CibActivityNew";
    public static final String CIF_LIST = "CIF_LIST";

    ActivityCifNewBinding binding;

    public static String KEY_REFERRENCE_ID = "KEY_REFERRENCE_ID";
    List<NotRequestedCif> cifList;
    NotRequestCifAdapter cifAdapter;

    private String referrenceid = "";


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_cif_new;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityCifNewBinding) getBinding();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("NotRequested Cif");
        getIntentData();


        cifList = new ArrayList<>();
        setupCifAdapter();
        getCibData();

        binding.submit.setOnClickListener(v -> {
            List<CifRequestDtl> list = new ArrayList<>();
            if (cifList.size() != 0) {
                for (NotRequestedCif n : cifList) {
                    if (n.isSelect()) {
                        list.add(new CifRequestDtl(Integer.parseInt(n.getProspectIndexID()), n.getProspectName()));
                    }
                }

            }

            if (list.size() != 0) {

                Bundle bundle = new Bundle();
                bundle.putString(CifActivity.KEY_REFERRENCE_ID, referrenceid);
                bundle.putString(CIF_LIST, toJson(list));
                Intent intent = new Intent(CifActivityNew.this, CifDialog.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);

            }


        });



    }

    private void getCibData() {
        showProgressDialog();
        String random = UUID.randomUUID().toString();
        getApiService().cifNewRequestById(referrenceid, random).enqueue(new Callback<NotRequestedCifData>() {
            @Override
            public void onResponse(Call<NotRequestedCifData> call, Response<NotRequestedCifData> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + toJson(response.body()));
                    cifList.clear();
                    cifList = response.body().getData();
                    setupCifAdapter();
                } else {
                    showToast("Try again!");
                }
            }

            @Override
            public void onFailure(Call<NotRequestedCifData> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed");

            }
        });
    }

    private void setupCifAdapter() {
        cifAdapter = new NotRequestCifAdapter(this, cifList, referrenceid);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvCib.setLayoutManager(mLayoutManager);
        binding.rvCib.setAdapter(cifAdapter);
    }

    @Override
    protected void getIntentData() {

        if (getIntent().getExtras().containsKey(KEY_REFERRENCE_ID)) {
            referrenceid = getIntent().getExtras().getString(KEY_REFERRENCE_ID);
        }
    }

    @Override
    public void adShowProgressDialog() {

    }

    @Override
    public void adHideProgressDialog() {

    }

    @Override
    public void adSuccess(String message) {

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            recreate();
        }
    }
}
