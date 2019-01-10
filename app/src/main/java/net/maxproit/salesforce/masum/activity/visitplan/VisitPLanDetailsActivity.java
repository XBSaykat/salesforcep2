package net.maxproit.salesforce.masum.activity.visitplan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.masum.activity.lead.LeadStageActivity;
import net.maxproit.salesforce.masum.adapter.FollowUpActivityAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.FollowUpDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.model.api.followup.FollowUpDatum;
import net.maxproit.salesforce.masum.model.api.followup.FollowUpHistoryApi;
import net.maxproit.salesforce.masum.model.api.myactivity.CompleteActivity;
import net.maxproit.salesforce.masum.model.api.myactivity.Data;
import net.maxproit.salesforce.masum.model.api.myactivity.MyActivityApi;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.masum.utility.DividerItemDecoration;

import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisitPLanDetailsActivity extends BaseActivity {

    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd.MM.yyyy";
    DatePickerDialog.OnDateSetListener date;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.GERMAN);
    public EditText tvClientType, tvVisitPurpose, tvClientName, tvMobileNumber, tvProductType, tvCity, tvPoliceStation,
            tvVisitDate, tvRemarks, etNewRemark, etNewFollowUpdate;
    private AwesomeSpinner spinnerClientType, spinnerProductType, spinnerPurposeOfVisit, spinnerPoliceStation;
    private SpinnerDbController spinnerDbController;
    private CardView tvProceedToLead, tvRejected, tvSave;
    private AutoCompleteTextView spinnerCity;
    private Intent myActivityItemIntent;
    private LinearLayout secMobiile;
    private LocalSetting localSetting;
    private int itemPosition;
    private String isVAlidText = null;
    private List<String> listClientType, listProductType, listPurpose, polishStationList, listPs;
    private ArrayAdapter<String> productTypeAdapter, cityAdapter;
    private LinearLayout mlayout, mLayoutCLientTypeField;
    private Button btnFollowUp;
    private ImageView backButton;
    private ArrayList<FollowUpDatum> followUpList;
    private ArrayAdapter<String> adptrClientType = null;
    private ArrayAdapter<String> adptrPurpose = null;
    private ArrayList<VisitPlan> visitPlanArrayList, visitPlanFilterList;
    private VisitPlanDbController visitPlanDbController;
    private FollowUpDbController followUpDbController;
    private VisitPlan visitPlanModel = null;
    private String spinerClientTypeStr = null, citySpn, polisStattionSpn, userName;
    private String sProductTypeString = null;
    private String sPurposeOfVisitStr = null;
    private LinearLayout layoutNewRemark, layoutNewDate, lPTypeSpinner, lPrtype, layoutPurOfvisit, lspiner_pov, lnCity, lnPStation, lnSpinnerPolis, lnSpinerCity;
    static final String PRE_DISBURSEMENT = "Pre- Disbursement";
    static final String POST_DISBURSEMENT = "Post- Disbursement";
    static final String INDIVIDUAL = "Individual";
    private ArrayAdapter<String> polishStationAdapter;
    private String clientType, productType, purposeOfVisit;



    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_activity_details;
    }

    @Override
    protected void initComponents() {
        initVariable();
        initView();

        initListener();
    }

    @Override
    protected void getIntentData() {

    }

    private void initVariable() {
        localSetting = new LocalSetting(this);

        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        localCash().put(SharedPreferencesEnum.Key.USER_NAME_PER, userName);
        visitPlanDbController = new VisitPlanDbController(this);
        followUpDbController = new FollowUpDbController(getContext());
        listClientType = new ArrayList<String>();
        polishStationList = new ArrayList<String>();
        listPs = new ArrayList<String>();
        listProductType = new ArrayList<String>();
        listPurpose = new ArrayList<String>();
        followUpList = new ArrayList<>();
        if (!listClientType.isEmpty()) {
            listClientType.clear();
        }

        if (!followUpList.isEmpty()) {
            followUpList.clear();
        }
        polishStationList.addAll(localSetting.getPseStringList());


    }

    private void setAllData(VisitPlan visitPlanModel) {
        tvClientName.setText(visitPlanModel.getClientName());
        tvClientType.setText(visitPlanModel.getClientType());
        tvVisitPurpose.setText(visitPlanModel.getPurposeOfVisit());
        tvMobileNumber.setText(visitPlanModel.getMobileNumber());
        tvCity.setText(visitPlanModel.getCity());
        tvPoliceStation.setText(visitPlanModel.getPoliceStation());

        if (visitPlanModel.getFollowUpRemark() != null) {
            tvRemarks.setText(visitPlanModel.getFollowUpRemark());
            tvVisitDate.setText(DateUtils.getDateFormateEt(visitPlanModel.getFollowUpDate()));
        } else {
            tvRemarks.setText(visitPlanModel.getRemarks());
            tvVisitDate.setText(DateUtils.getDateFormateEt(visitPlanModel.getDateOfVisit()));
        }


        if (visitPlanModel.getProductType() != null/* && !visitPlanModel.getStatus().equals(AppConstant.STATUS_ACTIVITY_NEW)*/) {
            spinnerProductType.setVisibility(View.VISIBLE);

            sProductTypeString = visitPlanModel.getProductType();
            try {
                spinnerProductType.setSelection(productTypeAdapter.getPosition(visitPlanModel.getProductType()));
            } catch (final IllegalStateException e) {

            }
        }
        if (visitPlanModel.getClientType() != null /*&& !visitPlanModel.getStatus().equals(AppConstant.STATUS_ACTIVITY_NEW)*/) {

            spinerClientTypeStr = visitPlanModel.getClientType();
            try {
                spinnerClientType.setSelection(adptrClientType.getPosition(visitPlanModel.getClientType()));
            } catch (final IllegalStateException e) {

            }
        }

        if (visitPlanModel.getClientType() != null /*&& !visitPlanModel.getStatus().equals(AppConstant.STATUS_ACTIVITY_NEW)*/) {

            sPurposeOfVisitStr = visitPlanModel.getPurposeOfVisit();
            try {
                spinnerPurposeOfVisit.setSelection(adptrPurpose.getPosition(visitPlanModel.getPurposeOfVisit()));
            } catch (final IllegalStateException e) {

            }
        }


        if (visitPlanModel.getStatus().equals(AppConstant.STATUS_ACTIVITY)) {
            lPTypeSpinner.setVisibility(View.GONE);
            mlayout.setVisibility(View.GONE);
            lspiner_pov.setVisibility(View.GONE);
            tvProductType.setText(visitPlanModel.getProductType());
            lPrtype.setVisibility(View.VISIBLE);
            tvProductType.setEnabled(false);
            tvClientType.setEnabled(false);
            tvClientName.setEnabled(false);
            tvVisitPurpose.setEnabled(false);
            tvCity.setEnabled(false);
            tvRemarks.setEnabled(false);
            tvVisitDate.setEnabled(false);
            tvPoliceStation.setEnabled(false);
            tvMobileNumber.setEnabled(false);

        } else {
            layoutPurOfvisit.setVisibility(View.GONE);
            mLayoutCLientTypeField.setVisibility(View.GONE);
            lPrtype.setVisibility(View.GONE);
            sPurposeOfVisitStr = visitPlanModel.getPurposeOfVisit();
            lnCity.setVisibility(View.VISIBLE);
            lnPStation.setVisibility(View.VISIBLE);
        }

    }

    private void initView() {

        layoutNewDate = findViewById(R.id.layout_follow_up);
        layoutNewRemark = findViewById(R.id.layout_new_remark);
        lspiner_pov = findViewById(R.id.lspiner_pov);
        lnCity = findViewById(R.id.lnet_city);
        lnSpinerCity = findViewById(R.id.ln_spinner_city);
        lnSpinerCity = findViewById(R.id.ln_spinner_polis);
        lnPStation = findViewById(R.id.lnet_polis);
        lnPStation.setVisibility(View.GONE);
        lnCity.setVisibility(View.GONE);
        spinnerCity = findViewById(R.id.awe_spinner_visit_plan_city);
        spinnerPoliceStation = findViewById(R.id.awe_spinner_visit_plan_police_station);
        spinnerPurposeOfVisit = findViewById(R.id.awe_spinner_visit_plan_Purpose);
        tvVisitPurpose = findViewById(R.id.tv_activity_details_visit_Purpose);
        tvClientType = findViewById(R.id.tv_activity_details_client_type);
        mLayoutCLientTypeField = findViewById(R.id.activity_details_client_type);
        tvProductType = findViewById(R.id.tv_activity_details_product_type);
        tvClientName = findViewById(R.id.tv_activity_details_client_name);
        tvMobileNumber = findViewById(R.id.tv_activity_details_mobile_no);
        tvCity = findViewById(R.id.tv_activity_details_city);
        tvPoliceStation = findViewById(R.id.tv_activity_details_police_station);
        tvVisitDate = findViewById(R.id.tv_activity_details_visit_date);
        tvRemarks = findViewById(R.id.tv_activity_details_remarks);
        tvProceedToLead = findViewById(R.id.tv_activity_details_proceed_to_lead);
        tvRejected = findViewById(R.id.tv_activity_details_rejected);
        tvSave = findViewById(R.id.tv_activity_details_save);
        spinnerClientType = findViewById(R.id.awe_spinner_visit_plan_client_type);
        mlayout = findViewById(R.id.secClientType);
        etNewFollowUpdate = findViewById(R.id.et_new_follow_up_date);
        etNewRemark = findViewById(R.id.et_new_remark);
        btnFollowUp = findViewById(R.id.btn_show_followUp_history);
        lPrtype = findViewById(R.id.secProductType);
        layoutPurOfvisit = findViewById(R.id.lyout_purpose_of_visit);
        lPTypeSpinner = findViewById(R.id.secProductTypeSpinner);
        secMobiile = (LinearLayout) findViewById(R.id.secinput_mobile_no);
        adptrClientType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, localSetting.getClientTypeString());
        spinnerClientType.setAdapter(adptrClientType);
        adptrPurpose = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, localSetting.getVisitPurposeTypeStringList());
        spinnerPurposeOfVisit.setAdapter(adptrPurpose);
        cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, localSetting.getCityStringList());
        spinnerCity.setAdapter(cityAdapter);
        spinnerCity.setThreshold(1);

        polishStationAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPs);
        spinnerPoliceStation.setAdapter(polishStationAdapter);

        spinnerProductType = findViewById(R.id.awe_spinner_visit_plan_product_type);
        productTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, localSetting.getProductCategorystring());
        spinnerProductType.setAdapter(productTypeAdapter);
        backButton = (ImageView) findViewById(R.id.btn_back);

        tvMobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String mobileNo = charSequence.toString(), regex = "01[3|5|6|7|8|9][0-9]{8}";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(mobileNo);
                if (!mobileNo.isEmpty() && matcher.matches()) {

                } else {
                    tvMobileNumber.setError("You entered invalid mobile no.");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void initListener() {
        spinnerClientType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                spinerClientTypeStr = s;

            }
        });

        spinnerProductType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                sProductTypeString = s;
            }
        });


        spinnerPurposeOfVisit.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                sPurposeOfVisitStr = s;

                if (s.equals(PRE_DISBURSEMENT)) {
                    throwAlertDialogForCIF();

                }
                if (s.equals(POST_DISBURSEMENT)) {
                    throwAlertDialogForCIF();
                }


            }
        });

        spinnerCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                citySpn = String.valueOf(spinnerCity.getAdapter().getItem(i));
                if (!listPs.isEmpty())
                    listPs.clear();
                listPs.addAll(localSetting.getpsListByCityCode(citySpn));
                polishStationAdapter.notifyDataSetChanged();
            }
        });
      /*  spinnerCity.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                citySpn = s;

            }

        });*/
        spinnerPoliceStation.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                polisStattionSpn = s;

            }
        });

        tvProceedToLead.setOnClickListener(view -> {
//            mapUtils.gpsChecker();
//            mapUtils.getLatLong();

            if (!isValid()){
                return;
            }

            if (isNetworkAvailable()) {
                if (isValidForProceed()) {
                    alertDialogProceed();
                } else {
                    showAlertDialog(getResources().getString(R.string.alert), isVAlidText);

                }
            } else
                showAlertDialog(getResources().getString(R.string.error_text), getResources().getString(R.string.proceed_unavailable));

        });


        tvRejected.setOnClickListener(view -> {
            alertDialogReject();

        });

        tvSave.setOnClickListener(view -> {

            getGpsLocation();
            if (!isValid()){
                return;
            }

            if (isValidForProceed()) {
                if (!TextUtils.isEmpty(etNewFollowUpdate.getText()) &&
                        !TextUtils.isEmpty(etNewRemark.getText())) {
                    alertDialogSave();
                } else
                    showAlertDialog(getResources().getString(R.string.alert), "Follow up date and Remark is mandatory for " + spinerClientTypeStr + " client & " + sPurposeOfVisitStr);

            } else {
                alertDialogSave();
            }

        });


        backButton.setOnClickListener(view -> {
            onBackPressed();

        });


        tvVisitDate.setOnClickListener(view -> {
            datePickerDialog(tvVisitDate);

        });

        layoutNewRemark.setVisibility(View.GONE);


        etNewFollowUpdate.setOnClickListener(view -> {
            datePickerDialog(etNewFollowUpdate);
            if (etNewFollowUpdate != null) {
                layoutNewRemark.setVisibility(View.VISIBLE);
            } else {
                layoutNewRemark.setVisibility(View.GONE);
            }

        });

        btnFollowUp.setOnClickListener(view -> {
            if (!followUpList.isEmpty()) {
                followUpList.clear();
            }
            if (isNetworkAvailable())
                followUpAlert();
            else
                showAlertDialog(getResources().getString(R.string.error_text), getResources().getString(R.string.internet_not_available));


        });

        getDataFromVisitPlan();
    }


    private void alertDialogReject() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this);
        }
        builder.setTitle(getString(R.string.remove));
        builder.setMessage(getString(R.string.reject_item));
        builder.setNegativeButton(getString(R.string.no), null);
        builder.setPositiveButton(getString(R.string.yes), (dialog, which) -> {
            if (isNetworkAvailable()) {
                showProgressDialog();
                getApiService().actionCompleteActivity(visitPlanModel.getJournalId()).enqueue(new Callback<CompleteActivity>() {
                    @Override
                    public void onResponse(Call<CompleteActivity> call, Response<CompleteActivity> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getCode().equals("200")) {
                                visitPlanDbController.updateVisitPlanDataStatus(visitPlanModel.getId(), AppConstant.REJECTED);
                                hideProgressDialog();
                                MasumCommonUtils.statusAlert(response.body().getStatus(), response.body().getMessage(), VisitPLanDetailsActivity.this);
                            } else {
                                showAlertDialog(response.body().getStatus(), response.body().getMessage());
                                hideProgressDialog();
                            }
                        } else {
                            showAlertDialog(getResources().getString(R.string.error_text), response.message());
                            hideProgressDialog();
                        }
                    }

                    @Override
                    public void onFailure(Call<CompleteActivity> call, Throwable t) {
                        showAlertDialog(getString(R.string.error_text), t.getMessage());
                        hideProgressDialog();
                    }
                });
            } else {

                visitPlanDbController.updateVisitPlanDataStatus(visitPlanModel.getId(), AppConstant.REJECTED);
                startActivity(new Intent(VisitPLanDetailsActivity.this, MyActivitiesActivity.class));
                finish();
            }

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setUpdatedData() {
        showProgressDialog();
        if (tvVisitDate.getText().toString().isEmpty()) {
            showAlertDialog(getString(R.string.alert), "Enter date of visit");
            hideProgressDialog();
            return;
        }

        if (visitPlanModel != null) {
            upactivityData();
        } else {
            Data data = getDataFromField(0);

            if (isNetworkAvailable()) {
                getApiService().createActivity(data).enqueue(new Callback<MyActivityApi>() {
                    @Override
                    public void onResponse(Call<MyActivityApi> call, Response<MyActivityApi> response) {
                        hideProgressDialog();
                        if (response.isSuccessful()) {
                            if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                Data data1 = response.body().getData();
                                insertActivityData(data1);
                                sendGpsLocation(String.valueOf(data1.getActivityJournalID()), "Activity", userName, getltd(), getLng(), "", VisitPLanDetailsActivity.this);

                            }
                            else{
                                showAlertDialog(response.body().getCode(),response.body().getMessage());
                            }
                        }
                        else {
                            showAlertDialog(""+response.code(),response.errorBody().toString());
                        }

                    }

                    @Override
                    public void onFailure(Call<MyActivityApi> call, Throwable t) {
                        getAlertDialog(getString(R.string.error_text), t.getMessage());
                        hideProgressDialog();

                    }
                });
            } else {
                insertActivityData(data);
                hideProgressDialog();
                finish();
            }
        }

    }

    private void insertActivityData(Data data1) {
        String syncStatus = null;
        if (data1.getActivityJournalID() == 0) {
            syncStatus = AppConstant.SYNC_STATUS_WAIT;
        } else {
            syncStatus = AppConstant.SYNC_STATUS_OK;
        }

        visitPlanDbController.insertData(data1.getActivityJournalID(), tvClientName.getText().toString(), spinerClientTypeStr,
                tvMobileNumber.getText().toString(), sProductTypeString,
                citySpn, polisStattionSpn, sPurposeOfVisitStr, tvVisitDate.getText().toString(),
                tvRemarks.getText().toString(), data1.getActivityStatus(), syncStatus, data1.getFollowupDate(), data1.getFollowupRemarks());
    }

    private Data getDataFromField(int journalId) {
        Data data = new Data();
        data.setActivityDate(DateUtils.getDateFormateForSqlite(tvVisitDate.getText().toString()));
        data.setActivityJournalID(journalId);
        if (journalId > 0)
            data.setActivityStatus(visitPlanModel.getStatus());
        else {
            data.setActivityStatus("");
        }
        data.setCity(spinnerCity.getText().toString());
        data.setClientType(spinerClientTypeStr);
        data.setCustomerName(tvClientName.getText().toString());
        if (!etNewFollowUpdate.getText().toString().isEmpty()) {
            data.setFollowupDate(DateUtils.getDateFormateForSqlite(etNewFollowUpdate.getText().toString()));
            data.setFollowupRemarks(etNewRemark.getText().toString());
        } else {
            data.setFollowupDate(DateUtils.getDateFormateForSqlite(tvVisitDate.getText().toString()));
            data.setFollowupRemarks("");
        }
        data.setMaker(userName);
        data.setMobileNo(tvMobileNumber.getText().toString());
        data.setProductType(sProductTypeString);
        data.setPs(polisStattionSpn);
        data.setRemarks(tvRemarks.getText().toString());
        data.setVisitPurposeType(sPurposeOfVisitStr);

        return data;
    }


    private void getDataFromVisitPlan() {

        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            visitPlanModel = (VisitPlan) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            setAllData(visitPlanModel);

            // followUpList.addAll(followUpDbController.getAllData(visitPlanModel.getId()));

            if (visitPlanModel.getFollowUpDate() != null) {
                btnFollowUp.setVisibility(View.VISIBLE);
            }

            sPurposeOfVisitStr = visitPlanModel.getPurposeOfVisit();

            if (!MasumCommonUtils.isNullStr(visitPlanModel.getCity())) {
                spinnerCity.setText(visitPlanModel.getCity());
                if (!listPs.isEmpty())
                    listPs.clear();
                listPs.addAll(localSetting.getpsListByCityCode(visitPlanModel.getCity()));
                polishStationAdapter.notifyDataSetChanged();
            }
            if (visitPlanModel.getPoliceStation() != null) {
                try {
                    spinnerPoliceStation.setSelection(polishStationAdapter.getPosition(visitPlanModel.getPoliceStation()));
                } catch (final IllegalStateException e) {
                    e.getMessage();
                }
            }


            lnCity.setVisibility(View.GONE);
            lnPStation.setVisibility(View.GONE);


        } else {
            long currentdate = System.currentTimeMillis();
            String dateString = sdf.format(currentdate);
            tvVisitDate.setText(dateString);
            lPrtype.setVisibility(View.GONE);
            mLayoutCLientTypeField.setVisibility(View.GONE);
            btnFollowUp.setVisibility(View.GONE);
            layoutPurOfvisit.setVisibility(View.GONE);
            tvRejected.setEnabled(false);
            lnCity.setVisibility(View.GONE);
            lnPStation.setVisibility(View.GONE);
            layoutNewRemark.setVisibility(View.GONE);
        }
    }


    private void upactivityData() {
        if (!isValidFollowUp()) {
            return;
        }
        Data data = getDataFromField(visitPlanModel.getJournalId());
        if (!TextUtils.isEmpty(etNewFollowUpdate.getText()) &&
                !TextUtils.isEmpty(etNewRemark.getText())) {

            if (isNetworkAvailable()) {
                getApiService().createActivity(data).enqueue(new Callback<MyActivityApi>() {
                    @Override
                    public void onResponse(Call<MyActivityApi> call, Response<MyActivityApi> response) {
                        if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                            Data data1 = response.body().getData();
                            hideProgressDialog();
                            updateDataACtivity(data1);
                            sendGpsLocation(String.valueOf(data1.getActivityJournalID()), "Activity", userName, getltd(), getLng(), getCompleteAddressString(getltd(),getLng()), VisitPLanDetailsActivity.this);

                        } else {
                            updateDataACtivity(data);
                            hideProgressDialog();

                        }

                    }

                    @Override
                    public void onFailure(Call<MyActivityApi> call, Throwable t) {
                        getAlertDialog(getString(R.string.error_text), t.getMessage());
                        hideProgressDialog();

                    }
                });
            } else {
                updateDataACtivity(data);
                hideProgressDialog();
            }

        } else {
            if (isNetworkAvailable()) {
                getApiService().createActivity(data).enqueue(new Callback<MyActivityApi>() {
                    @Override
                    public void onResponse(Call<MyActivityApi> call, Response<MyActivityApi> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                Data data1 = response.body().getData();
                                updateDataACtivity(data1);
                                sendGpsLocation(String.valueOf(data1.getActivityJournalID()), "Activity", userName, getltd(), getLng(), getCompleteAddressString(getltd(),getLng()), VisitPLanDetailsActivity.this);

                            } else {
                                showAlertDialog(response.body().getStatus(), response.body().getMessage());

                            }

                        } else {
                            updateDataACtivity(data);

                        }

                    }

                    @Override
                    public void onFailure(Call<MyActivityApi> call, Throwable t) {
                        showAlertDialog("ERROR", t.getMessage());

                    }
                });
            } else {
                updateDataACtivity(data);

            }

        }
    }

    private void updateDataACtivity(Data data) {
        String syncStatus = null;
        if (isNetworkAvailable()) {
            syncStatus = AppConstant.SYNC_STATUS_OK;
        } else {
            syncStatus = AppConstant.SYNC_STATUS_WAIT;
        }
        VisitPlan visitPlan = new VisitPlan(visitPlanModel.getId(), data.getActivityJournalID(),
                data.getCustomerName(),
                data.getClientType(),
                data.getMobileNo(),
                data.getPs(),
                data.getProductType(),
                data.getCity(),
                data.getVisitPurposeType(),
                data.getActivityDate(),
                data.getRemarks(),
                data.getActivityStatus(), syncStatus);
        visitPlan.setFollowUpDate(data.getFollowupDate());
        visitPlan.setFollowUpRemark(data.getFollowupRemarks());

        visitPlanDbController.updateData(visitPlan);
        MasumCommonUtils.statusAlert("Success", getString(R.string.internet_not_available_local_save), VisitPLanDetailsActivity.this);
    }


    private boolean isValidFollowUp() {
        boolean valid = true;
        if (!TextUtils.isEmpty(etNewFollowUpdate.getText()) &&
                TextUtils.isEmpty(etNewRemark.getText())) {
            etNewRemark.setError("Please fill up new Follow up & Remarks");
            valid = false;
        }
        return valid;
    }


    public void datePickerDialog(EditText et) {

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String selectedDate = (dayOfMonth + "." + month + "." + year);
                et.getText().clear();
                et.setText(selectedDate);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                listener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.show();

    }


    private void followUpAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = (View) inflater.inflate(R.layout.follow_up_date, null);

        builder.setView(dialogView);
        String random = UUID.randomUUID().toString();
        RecyclerView rv = (RecyclerView) dialogView.findViewById(R.id.rv_followup);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        FollowUpActivityAdapter adapter = new FollowUpActivityAdapter(this, followUpList);
        rv.setAdapter(adapter);
        if (isNetworkAvailable()) {
            getApiService().getFollowUpHistory(visitPlanModel.getJournalId(), random).enqueue(new Callback<FollowUpHistoryApi>() {
                @Override
                public void onResponse(Call<FollowUpHistoryApi> call, Response<FollowUpHistoryApi> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            followUpList.addAll(response.body().getData());
                            adapter.notifyDataSetChanged();
                        } else {
                            showAlertDialog(response.body().getCode(), response.body().getMessage());
                        }
                    } else showAlertDialog(getString(R.string.error_text), response.message());

                }

                @Override
                public void onFailure(Call<FollowUpHistoryApi> call, Throwable t) {
                    showAlertDialog(getString(R.string.error_text), t.getMessage());

                }
            });
        } else {
            showAlertDialog(getString(R.string.error_text), getString(R.string.internet_not_available));
        }


        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private boolean isValidForProceed() {
        boolean valid = true;
        if (spinerClientTypeStr.equalsIgnoreCase(AppConstant.INDIVIDUAL)) {
            if (sPurposeOfVisitStr.equalsIgnoreCase(AppConstant.LEAD_GENERATION) || sPurposeOfVisitStr.equalsIgnoreCase(AppConstant.FRESH)) {
                valid = true;
            } else {
                isVAlidText = getResources().getString(R.string.proceed_not_valid)+" " + sPurposeOfVisitStr;
                valid = false;
            }
        } else {
            isVAlidText = getString(R.string.proceed_not_valid)+" "  + spinerClientTypeStr;
            valid = false;
        }

        return valid;
    }


/*    private void processToLeadDetails() {
        if (isValidForProceed()) {

            if (visitPlanModel != null) {
                Data data = getDataFromField(visitPlanModel.getJournalId());

                if (isNetworkAvailable()) {
                    getApiService().createActivity(data).enqueue(new Callback<MyActivityApi>() {
                        @Override
                        public void onResponse(Call<MyActivityApi> call, Response<MyActivityApi> response) {
                            if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                Data data1 = response.body().getData();
                                visitPlanDbController.updateData(getPLanDataModel(visitPlanModel.getId(), data.getActivityJournalID(),
                                        data.getCustomerName(),
                                        data.getClientType(),
                                        data.getMobileNo(),
                                        data.getPs(),
                                        data.getProductType(),
                                        data.getCity(),
                                        data.getVisitPurposeType(),
                                        data.getFollowupDate(),
                                        data.getFollowupRemarks(),
                                        data1.getActivityStatus(), AppConstant.SYNC_STATUS_OK));
                                finish();
                            } else {
                                visitPlanDbController.updateData(getPLanDataModel(visitPlanModel.getId(), data.getActivityJournalID(),
                                        data.getCustomerName(),
                                        data.getClientType(),
                                        data.getMobileNo(),
                                        data.getPs(),
                                        data.getProductType(),
                                        data.getCity(),
                                        data.getVisitPurposeType(),
                                        data.getFollowupDate(),
                                        data.getFollowupRemarks(),
                                        AppConstant.STATUS_ACTIVITY, AppConstant.SYNC_STATUS_WAIT));
                                finish();
                            }

                        }

                        @Override
                        public void onFailure(Call<MyActivityApi> call, Throwable t) {
                            getAlertDialog("ERROR", t.getMessage());

                        }
                    });
                } else {
                    visitPlanDbController.updateData(getPLanDataModel(visitPlanModel.getId(), data.getActivityJournalID(),
                            data.getCustomerName(),
                            data.getClientType(),
                            data.getMobileNo(),
                            data.getPs(),
                            data.getProductType(),
                            data.getCity(),
                            data.getVisitPurposeType(),
                            data.getFollowupDate(),
                            data.getFollowupRemarks(),
                            AppConstant.STATUS_ACTIVITY, AppConstant.SYNC_STATUS_WAIT));

                }

                VisitPlan visitPlan = new VisitPlan(visitPlanModel.getId(), data.getActivityJournalID(),
                        data.getCustomerName(),
                        data.getClientType(),
                        data.getMobileNo(),
                        data.getPs(),
                        data.getProductType(),
                        data.getCity(),
                        data.getVisitPurposeType(),
                        data.getFollowupDate(),
                        data.getFollowupRemarks(),
                        AppConstant.STATUS_ACTIVITY, AppConstant.SYNC_STATUS_WAIT);
                ActivityUtils.invokVisitPlanDetail(this, LeadStageActivity.class, visitPlan);
            } else {
                Data data1 = getDataFromField(0);

                if (isNetworkAvailable()) {
                    getApiService().createActivity(data1).enqueue(new Callback<MyActivityApi>() {
                        @Override
                        public void onResponse(Call<MyActivityApi> call, Response<MyActivityApi> response) {
                            if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                Data data1 = response.body().getData();
                                int insert = visitPlanDbController.insertData(data1.getActivityJournalID(), tvClientName.getText().toString(), spinerClientTypeStr,
                                        tvMobileNumber.getText().toString(), sProductTypeString,
                                        citySpn, polisStattionSpn, sPurposeOfVisitStr, tvVisitDate.getText().toString(),
                                        tvRemarks.getText().toString(), data1.getActivityStatus(), AppConstant.SYNC_STATUS_OK);
                                VisitPlan visitPlan = new VisitPlan(insert, data1.getActivityJournalID(),
                                        data1.getCustomerName(),
                                        data1.getClientType(),
                                        data1.getMobileNo(),
                                        data1.getPs(),
                                        data1.getProductType(),
                                        data1.getCity(),
                                        data1.getVisitPurposeType(),
                                        data1.getFollowupDate(),
                                        data1.getFollowupRemarks(),
                                        AppConstant.STATUS_ACTIVITY, AppConstant.SYNC_STATUS_OK);
                                ActivityUtils.invokVisitPlanDetail(VisitPLanDetailsActivity.this, LeadStageActivity.class, visitPlan);

                            }

                        }

                        @Override
                        public void onFailure(Call<MyActivityApi> call, Throwable t) {
                            getAlertDialog("ERROR", t.getMessage());

                        }
                    });
                } else {
                    visitPlanDbController.insertData(0, tvClientName.getText().toString(), spinerClientTypeStr,
                            tvMobileNumber.getText().toString(), sProductTypeString,
                            citySpn, polisStattionSpn, sPurposeOfVisitStr, tvVisitDate.getText().toString(),
                            tvRemarks.getText().toString(), AppConstant.STATUS_ACTIVITY_NEW, AppConstant.SYNC_STATUS_WAIT);

                    VisitPlan visitPlan = new VisitPlan(visitPlanModel.getId(), data1.getActivityJournalID(),
                            data1.getCustomerName(),
                            data1.getClientType(),
                            data1.getMobileNo(),
                            data1.getPs(),
                            data1.getProductType(),
                            data1.getCity(),
                            data1.getVisitPurposeType(),
                            data1.getFollowupDate(),
                            data1.getFollowupRemarks(),
                            AppConstant.STATUS_ACTIVITY, AppConstant.SYNC_STATUS_WAIT);
                    ActivityUtils.invokVisitPlanDetail(this, LeadStageActivity.class, visitPlan);

                }


            }

        } else {
            showAlertDialog("Alert", isVAlidText);
        }

    }*/

    private void throwAlertDialogForCIF() {
        final AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_visit_plan_cif_dialog, null);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext(), R.style.Theme_AppCompat);
//        LayoutInflater inflater = this.getLayoutInflater();
//        View cifDialog = inflater.inflate(R.layout., null);
//        builder.setView(cifDialog);
//        final AlertDialog dialog = builder.create();

        EditText editText = (EditText) dialogView.findViewById(R.id.et_dialog_cif_number);
        Button cifSubmit = (Button) dialogView.findViewById(R.id.btn_dialog_cif_submit);
        Button cifCancel = (Button) dialogView.findViewById(R.id.btn_dialog_cif_cancel);

        cifSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.dismiss();
            }
        });

        cifCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.dismiss();
            }
        });
        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }

    private void alertDialogSave() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this);
        }
        builder.setTitle(getResources().getString(R.string.save_txt));
        builder.setMessage(getResources().getString(R.string.save_alert));
        builder.setNegativeButton(getResources().getString(R.string.no), null);
        builder.setPositiveButton(getResources().getString(R.string.yes), (dialog, which) -> {
            setUpdatedData();

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void alertDialogProceed() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this);
        }
        builder.setTitle("Proceed");
        builder.setMessage("Do you want to proceed?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            //processToLeadDetails();
            proceedToLeadDetail();

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void proceedToLeadDetail() {

        showProgressDialog();
        Data data = null;
        if (visitPlanModel != null) {
            data = getDataFromField(visitPlanModel.getJournalId());
            hideProgressDialog();
            ActivityUtils.invokVisitPlanDetail(this, LeadStageActivity.class, data);

        } else {
            data = getDataFromField(0);
            hideProgressDialog();
            ActivityUtils.invokVisitPlanDetail(this, LeadStageActivity.class, data);
        }

    }

    private boolean isValid() {
        boolean valid = true;

//        if(spinerClientTypeStr == null || sPurposeOfVisitStr == null || sProductTypeString == null ){
//
//            android.app.AlertDialog.Builder builder;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
//            } else {
//                builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this);
//            }
//            builder.setIcon(R.drawable.ic_required);
//            builder.setTitle(Html.fromHtml("<font color='#FF0000'>Enter required values</font>"));
//            builder.setNegativeButton("OK", null);
//            android.app.AlertDialog dialog = builder.create();
//            dialog.show();
//            valid = false;
//        }
//        else valid=true;

        if (spinerClientTypeStr==null){
            showAlertDialog("Required", "Enter Client Type");
            return false;
        }
        if (sPurposeOfVisitStr==null){
            showAlertDialog("Required", "Enter Purpose of Visit");
            return false;
        }
        if (sProductTypeString==null){
            showAlertDialog("Required", "Enter Product Type");
            return false;
        }
        if (MasumCommonUtils.isNullStr(spinnerCity.getText().toString())){
            showAlertDialog("Required", "Enter City");
            return false;
        }
        if (polisStattionSpn==null){
            showAlertDialog("Required", "Enter Police Station");
            return false;
        }

        if (getltd()==0 && getLng()==0){
            return false;
        }

        return valid;
    }


}
