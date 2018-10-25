package net.maxproit.salesforce.feature.salesOfficer.parallelprocess;

import android.app.Activity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityDeviationBinding;
import net.maxproit.salesforce.feature.supervisor.adapter.UtilSpinner;
import net.maxproit.salesforce.model.deviation.head.DevAccountHead;
import net.maxproit.salesforce.model.deviation.head.DevAccountHeadEntities;
import net.maxproit.salesforce.model.deviation.post.DeviationDetail;
import net.maxproit.salesforce.model.deviation.post.DeviationHead;
import net.maxproit.salesforce.model.deviation.post.DeviationPost;
import net.maxproit.salesforce.model.setting.DeviationCategory;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeviationActivity extends BaseActivity {
    ActivityDeviationBinding binding;
    private static final String TAG = "DeviationActivity";
    int dvCategoryId = 0;
    String dvcategory = "";
    int dvHedId = 0;
    String dvHead = "";
    UtilSpinner dvcategoryAdapter;
    UtilSpinner dvHeadAdapter;
    List<DeviationCategory> deviationlist;


    public static String KEY_REFERRENCE_ID = "KEY_REFERRENCE_ID";
    private String referrenceid = "";

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_deviation;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDeviationBinding) getBinding();
        deviationlist = new LocalSetting(getContext()).getDeviationCategory();

        getIntentData();

        Log.d(TAG, "initComponents: " + toJson(deviationlist));

        List<String> data1 = new ArrayList<>();
        for (DeviationCategory in : deviationlist) {
            data1.add(in.getDeviationCategory());
        }

        dvcategoryAdapter = new UtilSpinner(DeviationActivity.this, data1);
        binding.dvcategory.setAdapter(dvcategoryAdapter);
        binding.dvcategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                deviationlist.get(position);
                if (deviationlist.get(position) != null) {
                    dvCategoryId = deviationlist.get(position).getDeviationCategoryID();
                    dvcategory = deviationlist.get(position).getDeviationCategory();
                    showProgressDialog();

                    getApiService().deviationHeadById("" + deviationlist.get(position).getDeviationCategoryID()).enqueue(new Callback<DevAccountHeadEntities>() {
                        @Override
                        public void onResponse(Call<DevAccountHeadEntities> call, Response<DevAccountHeadEntities> response) {
                            hideProgressDialog();
                            if (response.isSuccessful()) {
                                List<String> data2 = new ArrayList<>();
                                for (DevAccountHead in : response.body().getData()) {
                                    data2.add(in.getDevAccountHeadName());
                                    dvHeadAdapter = new UtilSpinner(DeviationActivity.this, data2);
                                    binding.dvhead.setAdapter(dvHeadAdapter);
                                    binding.dvhead.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            dvHedId = response.body().getData().get(position).getDevAccountHeadCode();
                                            dvHead = response.body().getData().get(position).getDevAccountHeadName();
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });
                                }

                            }

                        }

                        @Override
                        public void onFailure(Call<DevAccountHeadEntities> call, Throwable t) {
                            hideProgressDialog();

                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        binding.btnSubmit.setOnClickListener(v -> {
            nextRequest();

        });



    }


    private void nextRequest() {

        DeviationPost deviationPost = new DeviationPost();
        deviationPost.setProspectReferenceNo(referrenceid);
        deviationPost.setMakerName(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));
        DeviationDetail deviationDetail = new DeviationDetail();

        deviationDetail.setDeviationDetailID(0);
        deviationDetail.setDeviationCategory(new net.maxproit.salesforce.model.deviation.post.DeviationCategory(dvCategoryId, dvcategory));
        deviationDetail.setDeviationHead(new DeviationHead(dvHead, dvHedId));
        if (!StringUtils.isEmpty((binding.etCurrebt.getText().toString()))) {
            deviationDetail.setCurrentValue(Integer.parseInt(binding.etCurrebt.getText().toString()));
        }
        if (!StringUtils.isEmpty((binding.etPrppese.getText().toString()))) {
            deviationDetail.setProposedValue(Integer.parseInt(binding.etPrppese.getText().toString()));
        }



        deviationDetail.setRemark(binding.etRemark.getText().toString());

        localCash().put(SharedPreferencesEnum.Key.DAVIATION_LIST, toJson(deviationDetail));

        setResult(Activity.RESULT_OK);
        finish();


        deviationPost.setRemark("");
        deviationPost.setMakerName(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));
        deviationPost.setDeviationDetails(Arrays.asList(deviationDetail));

//        Log.d(TAG, "nextRequest: " + toJson(deviationPost));
//
//        showProgressDialog();
//        getApiService().deviationPost(deviationPost).enqueue(new Callback<DaviationPostResponce>() {
//            @Override
//            public void onResponse(Call<DaviationPostResponce> call, Response<DaviationPostResponce> response) {
//                hideProgressDialog();
//                if (response.isSuccessful()) {
//                    finish();
//                    setResult(Activity.RESULT_OK);
//                } else showToast(" Deviation request failed");
//
//            }
//
//            @Override
//            public void onFailure(Call<DaviationPostResponce> call, Throwable t) {
//                hideProgressDialog();
//                showToast(" Failed");
//
//            }
//        });


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
    protected void getIntentData() {
        if (getIntent().getExtras().containsKey(KEY_REFERRENCE_ID)) {
            referrenceid = getIntent().getExtras().getString(KEY_REFERRENCE_ID);
        }
    }


}
