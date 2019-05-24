package net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityCibNewBinding;
import net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cib.adapter.NotRequestCibAdapter;
import net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cif.CifActivity;
import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.model.cib.notRequestedCIB.NotRequestedCIB;
import net.maxproit.salesforce2.model.cib.notRequestedCIB.NotRequestedCIBData;
import net.maxproit.salesforce2.model.cib.post.CibRequestDtl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CibActivityNew extends BaseActivity implements AdapterInfo {
    private static final String TAG = "CibActivityNew";

    ActivityCibNewBinding binding;

    public static String KEY_REFERRENCE_ID = "KEY_REFERRENCE_ID";
    List<NotRequestedCIB> cibList;
    NotRequestCibAdapter cibAdapter;

    private String referrenceid = "";
    public static final String CIB_LIST ="CIB_LIST";


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_cib_new;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityCibNewBinding) getBinding();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("NotRequested CIB");
        getIntentData();


        cibList = new ArrayList<>();
        setupCifAdapter();
        getCibData();



        binding.submit.setOnClickListener(v -> {
            List<CibRequestDtl> list = new ArrayList<>();
            if(cibList.size()!=0){
                for (NotRequestedCIB n :cibList) {
                    if (n.isSelect()) {
                        list.add(new CibRequestDtl(Integer.parseInt(n.getProspectIndexID())));
                    }
                }

            }

            if (list.size()!=0) {

                Bundle bundle = new Bundle();
            bundle.putString(CifActivity.KEY_REFERRENCE_ID, referrenceid);
            bundle.putString(CIB_LIST, toJson(list));
            Intent intent = new Intent(CibActivityNew.this, CibDialog.class);
            intent.putExtras(bundle);
          //  startActivity(intent);
            startActivityForResult(intent,1);

            }


        });


    }

    private void getCibData() {
        showProgressDialog();
        String random = UUID.randomUUID().toString();
        getApiService().cibNewRequestById(referrenceid, random).enqueue(new Callback<NotRequestedCIBData>() {
            @Override
            public void onResponse(Call<NotRequestedCIBData> call, Response<NotRequestedCIBData> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + toJson(response.body()));
                    cibList.clear();
                    cibList = response.body().getData();
                    setupCifAdapter();
                } else {
                    showToast("Try again!");
                }
            }

            @Override
            public void onFailure(Call<NotRequestedCIBData> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed");

            }
        });
    }

    private void setupCifAdapter() {
        cibAdapter = new NotRequestCibAdapter(this, cibList, referrenceid);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvCib.setLayoutManager(mLayoutManager);
        binding.rvCib.setAdapter(cibAdapter);
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
