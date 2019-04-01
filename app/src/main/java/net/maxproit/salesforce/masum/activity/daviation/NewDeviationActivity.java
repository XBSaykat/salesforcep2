package net.maxproit.salesforce.masum.activity.daviation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityNewDeviationBinding;
import net.maxproit.salesforce.masum.activity.DeviationActivity;
import net.maxproit.salesforce.masum.activity.daviation.adapter.NewDaviationAdapter;
import net.maxproit.salesforce.masum.model.api.deviation.postdeviation.DeviationDetail;
import net.maxproit.salesforce.masum.model.api.deviation.postdeviation.PostDeviation;
import net.maxproit.salesforce.masum.model.api.deviation.deviationresponse.DeviationPostRespose;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewDeviationActivity extends BaseActivity {
    private static final String TAG = "NewDeviationActivity";

    public static String KEY_REFERRENCE_ID = "KEY_REFERRENCE_ID";
    ActivityNewDeviationBinding binding;
    private String referrenceid = "";
    
    List<DeviationDetail> list = new ArrayList<>();
    private NewDaviationAdapter adapter;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_new_deviation;
    }

    @Override
    protected void initComponents() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        binding = (ActivityNewDeviationBinding) getBinding();
        getIntentData();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_REFERRENCE_ID, referrenceid);
        binding.btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(NewDeviationActivity.this, DeviationActivity.class);
            intent.putExtras(bundle);
            startActivityForResult(intent, 1);
            localCash().put(SharedPreferencesEnum.Key.DAVIATION_LIST, "");

        });


        binding.addRequest.setOnClickListener(v -> {
            nextRequest();
        });

    }

    private boolean isButtonActive() {
        if (list.size()>0) {
            return true;
        }else return false;
    }

    @Override
    protected void getIntentData() {
        if (getIntent().getExtras().containsKey(KEY_REFERRENCE_ID)) {
            referrenceid = getIntent().getExtras().getString(KEY_REFERRENCE_ID);
        }

    }


    private void nextRequest() {

        PostDeviation postDeviation = new PostDeviation();
        postDeviation.setProspectReferenceNo(referrenceid);
        postDeviation.setMakerName(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));
        postDeviation.setDeviationDetails(list);

        showProgressDialog();


        Log.d(TAG, "nextRequest: "+toJson(postDeviation));
        getApiService().postDeviationData(postDeviation).enqueue(new Callback<DeviationPostRespose>() {
            @Override
            public void onResponse(Call<DeviationPostRespose> call, Response<DeviationPostRespose> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    finish();
                    setResult(Activity.RESULT_OK);
                } else showToast(" Deviation request failed");

            }

            @Override
            public void onFailure(Call<DeviationPostRespose> call, Throwable t) {
                hideProgressDialog();
                showToast(" Failed");

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String d = localCash().getString(SharedPreferencesEnum.Key.DAVIATION_LIST);
        if (!StringUtils.isEmpty(d)) {
            DeviationDetail deviationDetail =  new GsonBuilder().serializeNulls().create().fromJson(d, DeviationDetail.class);
            list.add(deviationDetail);
            Log.d(TAG, "onActivityResult: ---------"+list.size());
        }

        if (isButtonActive()) {
            binding.addRequest.setVisibility(View.VISIBLE);

        }

        createView();



    }

    private void createView() {
        adapter = new NewDaviationAdapter(this, list, referrenceid);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvCib.setLayoutManager(mLayoutManager);
        binding.rvCib.setAdapter(adapter);
    }


}
