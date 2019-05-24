package net.maxproit.salesforce2.masum.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityDeviationBinding;
import net.maxproit.salesforce2.feature.supervisor.adapter.UtilSpinner;
import net.maxproit.salesforce2.masum.model.api.deviation.deviationaccounthead.Data;
import net.maxproit.salesforce2.masum.model.api.deviation.postdeviation.DeviationDetail;
import net.maxproit.salesforce2.masum.model.api.deviation.postdeviation.DeviationHead;
import net.maxproit.salesforce2.masum.model.api.deviation.postdeviation.DeviationJustification;
import net.maxproit.salesforce2.masum.model.api.deviation.postdeviation.PostDeviation;
import net.maxproit.salesforce2.masum.model.api.deviation.queryapprovaltierfordeviation.QueryApprovalTier;
import net.maxproit.salesforce2.masum.model.api.deviation.querydeviationpropertyresponce.QueryDeviationPropertyResponce;
import net.maxproit.salesforce2.masum.model.api.deviation.deviationaccounthead.DevAccountHeadEntities;
import net.maxproit.salesforce2.model.setting.DeviationCategory;
import net.maxproit.salesforce2.model.setting.LocalSetting;
import net.maxproit.salesforce2.model.setting.LstDeviationJustification;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    String riskCat = "";
    String loanAmount = "";
    String lTV = "";
    String justification = "";
    int justificationId = 0;
    String approvalTier;
    ArrayList<String> selectedjustificationList = new ArrayList<>();

    UtilSpinner exceptionAreaAdapter;
    UtilSpinner exceptionParametersAdapter;
    UtilSpinner justificationAdapter;
    List<DeviationCategory> deviationlist;
    List<LstDeviationJustification> justificationList;
    List<DeviationJustification> justificationPostList = new ArrayList<>();

    List<String> justifiList;


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
        justificationList = new LocalSetting(getContext()).getLstDeviationJustification();

        getIntentData();

        Log.d(TAG, "initComponents: " + toJson(deviationlist));
        setViewsDisable();


        List<String> deviationCatList = new ArrayList<>();
        deviationCatList.add("Select Exception Area");

        for (DeviationCategory in : deviationlist) {
            deviationCatList.add(in.getDeviationCategory());
        }

        justifiList = new ArrayList<>();
        justifiList.add("Select Justification");
        for (LstDeviationJustification in : justificationList) {
            justifiList.add(in.getJustification());
        }


        exceptionAreaLoadList(deviationCatList);


        binding.btnSubmit.setOnClickListener(v -> {
            nextRequest();

        });


    }

    private void exceptionAreaLoadList(List<String> deviationCatList) {
        exceptionAreaAdapter = new UtilSpinner(DeviationActivity.this, deviationCatList);
        binding.exceptionArea.setAdapter(exceptionAreaAdapter);
        binding.exceptionArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                binding.exceptionArea.setSelection(position);
                if (position > 0) {
                    position = position - 1;
                    if (deviationlist.get(position) != null) {
                        dvCategoryId = deviationlist.get(position).getDeviationCategoryID();
                        dvcategory = deviationlist.get(position).getDeviationCategory();
                        if (isNetworkAvailable()) {
                            showProgressDialog();

                            getApiService().deviationHeadById("" + deviationlist.get(position).getDeviationCategoryID(), UUID.randomUUID().toString()).enqueue(new Callback<DevAccountHeadEntities>() {
                                @Override
                                public void onResponse(Call<DevAccountHeadEntities> call, Response<DevAccountHeadEntities> response) {
                                    hideProgressDialog();
                                    if (response.isSuccessful()) {
                                        List<String> data2 = new ArrayList<>();
                                        data2.add("Select Exception Parameters");
                                        for (Data in : response.body().getData()) {
                                            data2.add(in.getDevAccountHeadName());
                                            exceptionParametersAdapter = new UtilSpinner(DeviationActivity.this, data2);
                                            binding.exceptionParameters.setEnabled(true);
                                            binding.exceptionParameters.setAdapter(exceptionParametersAdapter);
                                            binding.exceptionParameters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    binding.exceptionParameters.setSelection(position);
                                                    if (position > 0) {
                                                        position = position - 1;
                                                        if (response.body().getData().get(position) != null) {
                                                            dvHedId = response.body().getData().get(position).getDevAccountHeadCode();
                                                            dvHead = response.body().getData().get(position).getDevAccountHeadName();
                                                            riskCat = response.body().getData().get(position).getRiskCategory();
                                                            binding.etRiskCategory.setText(riskCat);
                                                            callQueryApprovalTierForDeviation(riskCat);
                                                            callQueryDeviationPropertyApi();
                                                        }
                                                    } else {

                                                    }

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
                        } else {
                            hideProgressDialog();
                            showAlertDialog("Network ! ", "Network not available");
                        }
                    }
                } else {
                    showToast("select exception area");
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setViewsDisable() {
        binding.exceptionParameters.setEnabled(false);
        binding.etRiskCategory.setEnabled(false);
        binding.etLoanAmount.setEnabled(false);
        binding.etLtv.setEnabled(false);
        binding.etApproverTier.setEnabled(false);
        binding.spJustification.setEnabled(false);
    }

    private void callQueryDeviationPropertyApi() {

        getApiService().queryDeviationProperty("" + referrenceid, UUID.randomUUID().toString()).enqueue(new Callback<QueryDeviationPropertyResponce>() {
            @Override
            public void onResponse(Call<QueryDeviationPropertyResponce> call, Response<QueryDeviationPropertyResponce> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        hideProgressDialog();
                        loanAmount = response.body().getData().get(0).getLoanAmount();
                        lTV = response.body().getData().get(0).getLTV();
                        binding.etLoanAmount.setText(loanAmount);
                        binding.etLtv.setText(lTV);


                        loadJustificationSpinner();

                    }
                }
            }

            @Override
            public void onFailure(Call<QueryDeviationPropertyResponce> call, Throwable t) {

            }
        });
    }

    private void callQueryApprovalTierForDeviation(String riskCat) {

        getApiService().queryforApprovalTier("" + referrenceid, "" + riskCat, UUID.randomUUID().toString()).enqueue(new Callback<QueryApprovalTier>() {
            @Override
            public void onResponse(Call<QueryApprovalTier> call, Response<QueryApprovalTier> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {

                        approvalTier = response.body().getData().get(0).getApprovalTier();
                        binding.etApproverTier.setText(approvalTier);


                    }
                }
            }

            @Override
            public void onFailure(Call<QueryApprovalTier> call, Throwable t) {
                hideProgressDialog();
            }
        });

    }

    private void loadJustificationSpinner() {
        binding.spJustification.setEnabled(true);

        binding.spJustification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectJustificationDialog();
                Toast.makeText(DeviationActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
      /*  justificationAdapter = new UtilSpinner(DeviationActivity.this, justifiList);
        binding.spJustification.setEnabled(true);
        binding.spJustification.setAdapter(justificationAdapter);
        binding.spJustification.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                binding.spJustification.setSelection(position);
                if (position > 0){
                    position = position - 1;
                    if (justifiList.get(position) != null){
                        justification = justificationList.get(position).getJustification();
                        justificationId = justificationList.get(position).getJustificationID();
                    }
                }else{

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });*/
    }


    protected void showSelectJustificationDialog() {

        boolean[] checkedJustifications = new boolean[justifiList.size()];
        android.app.AlertDialog.Builder builder;
        int count = justifiList.size();

        for (int i = 0; i < count; i++)

            checkedJustifications[i] = selectedjustificationList.contains(justifiList.get(i));

        DialogInterface.OnMultiChoiceClickListener justicationDialuge = new DialogInterface.OnMultiChoiceClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                if (isChecked) {
                    selectedjustificationList.add(justifiList.get(which));
                } else {

                    selectedjustificationList.remove(justifiList.get(which));

                }
                onChangeSelectedColours();

            }

        };

        CharSequence ss[] = justifiList.toArray(new CharSequence[0]);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(getContext());
        }
        builder.setTitle("Select Justification");

        builder.setMultiChoiceItems(ss, checkedJustifications, justicationDialuge);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();

    }


    protected void onChangeSelectedColours() {

        StringBuilder stringBuilder = new StringBuilder();

        for (CharSequence colour : selectedjustificationList)

            stringBuilder.append(colour + ",");

        // need to remove comma
        String str = stringBuilder.toString();
        str = str.replaceAll(",$", "");

        // binding.spJustification.setText(stringBuilder.toString());
        binding.spJustification.setText(str);

    }

    private void nextRequest() {

        PostDeviation postDeviation = new PostDeviation();
        DeviationDetail deviationDetail = new DeviationDetail();

        for (int i = 0; i < selectedjustificationList.size(); i++) {
            for (int j = 0; j < justificationList.size(); j++) {
                if (selectedjustificationList.get(i).equalsIgnoreCase(justificationList.get(j).getJustification())) {
                    DeviationJustification deviationJustification = new DeviationJustification();
                    deviationJustification.setJustificationID(justificationList.get(j).getJustificationID());
                    deviationJustification.setJustification(justificationList.get(j).getJustification());
                    justificationPostList.add(deviationJustification);
                }
            }
        }
        DeviationHead deviationHead = new DeviationHead();
        net.maxproit.salesforce2.masum.model.api.deviation.postdeviation.DeviationCategory deviationCategory = new net.maxproit.salesforce2.masum.model.api.deviation.postdeviation.DeviationCategory();

        postDeviation.setProspectReferenceNo(referrenceid);
        postDeviation.setDeviationSetID(0);
        postDeviation.setMakerName(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));


        deviationDetail.setDeviationDetailID(0);
        deviationCategory.setDeviationCategory(dvcategory);
        deviationCategory.setDeviationCategoryID(dvCategoryId);
        deviationDetail.setDeviationCategory(deviationCategory);

        deviationHead.setDevAccountHeadName(dvHead);
        deviationHead.setDevAccountHeadCode(dvHedId);
        deviationHead.setRiskCategory(riskCat);
        deviationDetail.setDeviationHead(deviationHead);


        deviationDetail.setDeviationJustifications(justificationPostList);

        deviationDetail.setApprovalTier(binding.etApproverTier.getText().toString());
        deviationDetail.setRemark(binding.etRemark.getText().toString());


//        DeviationPost deviationPost = new DeviationPost();
//        deviationPost.setProspectReferenceNo(referrenceid);
//        deviationPost.setMakerName(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));
//        DeviationDetail deviationDetail = new DeviationDetail();
//
//        deviationDetail.setDeviationDetailID(0);
//        deviationDetail.setDeviationCategory(new net.maxproit.salesforce2.model.deviation.post.DeviationCategory(dvCategoryId, dvcategory));
//        deviationDetail.setDeviationHead(new DeviationHead(dvHead, dvHedId));


//        binding.etRiskCategory.setEnabled(false);
//        binding.etLoanAmount.setEnabled(false);
//        binding.etLtv.setEnabled(false);
//        binding.etApproverTier.setEnabled(false);
//        if (!StringUtils.isEmpty((binding.etRiskCategory.getText().toString()))) {
//            deviationDetail.setCurrentValue(Integer.parseInt(binding.etRiskCategory.getText().toString()));
//        }
//        if (!StringUtils.isEmpty((binding.etPrppese.getText().toString()))) {
//            deviationDetail.setProposedValue(Integer.parseInt(binding.etPrppese.getText().toString()));
//        }


        deviationDetail.setRemark(binding.etRemark.getText().toString());

        localCash().put(SharedPreferencesEnum.Key.DAVIATION_LIST, toJson(deviationDetail));

        setResult(Activity.RESULT_OK);
        finish();


//        deviationPost.setRemark("");
//        deviationPost.setMakerName(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));
//        deviationPost.setDeviationDetails(Arrays.asList(deviationDetail));

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
