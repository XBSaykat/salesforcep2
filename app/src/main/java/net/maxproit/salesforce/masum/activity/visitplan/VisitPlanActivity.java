package net.maxproit.salesforce.masum.activity.visitplan;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.Html;
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
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.common.base.Global;
import net.maxproit.salesforce.feature.login.LoginActivity;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.model.api.gpstracker.GetGpsResponse;
import net.maxproit.salesforce.masum.model.api.visitPlan.Data;
import net.maxproit.salesforce.masum.model.api.visitPlan.MyVisitPlanApi;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.masum.utility.GPSTracker;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static net.maxproit.salesforce.masum.appdata.AppConstant.POST_DISBURSEMENT;
import static net.maxproit.salesforce.masum.appdata.AppConstant.PRE_DISBURSEMENT;


public class VisitPlanActivity extends BaseActivity {

//    Toolbar toolbarVisitPlan;

    String VariableID;
    private int hour;
    private int minute;
    private int mDay;
    private int mMonth;
    private int mYear;
    private ArrayAdapter<String> polishStationAdapter;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;
    private LocalSetting mLocalSetting;
    private VisitPlanDbController dbController;
    private SpinnerDbController spinnerDbController;
    private VisitPlan visitPlanModel;
    private ArrayAdapter<String> adptrClientType, cityAdapter, adptrPurpose, productTypeAdapter;
    private AwesomeSpinner spinnerClientType, spinnerProductType, spinnerPoliceStation, spinnerPurposeOfVisit;
    TextView buttonSave;
    private AutoCompleteTextView spinnerCity;
    LinearLayout secClientType, secMobileNo, secProductType, secArea, secPurpose, secVisitDT, secRemarks;
    View lineClientType, lineMobileNo, lineProductType, lineArea, linePurpose, lineVisitDT, lineRemarks;
    EditText txtClientName, txtMobileNo, tvVisitDT, txtRemarks;
    String clientName, clientType, mobileNo, productType, city, policeStation, purposeOfVisit, dateOfvisit, remarks;
    private List<String> listPs = null;
    List<String> listClientType, listProductType, listArea, listPurpose, listCity, listDhakaSouth, listDhakaNorth, polishStationList;
    ImageView backButton;

    Context context = this;
    Global g;
    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd.MM.yyyy", userName;
    DatePickerDialog.OnDateSetListener date;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.GERMAN);



    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_visit_plan;
    }

    @Override
    protected void initComponents() {
        listPs = new ArrayList<>();
        backButton = findViewById(R.id.btn_back);
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        localCash().put(SharedPreferencesEnum.Key.USER_NAME_PER, userName);
        g = Global.getInstance();
        dbController = new VisitPlanDbController(VisitPlanActivity.this);
        spinnerDbController = new SpinnerDbController(VisitPlanActivity.this);
        mLocalSetting = new LocalSetting(this);
        GPSTracker gps;
        double latitude,longitude;
        initView();

        txtMobileNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String mobileNo = charSequence.toString(), regex = "01[3|5|6|7|8|9][0-9]{8}";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(mobileNo);
                if (!mobileNo.isEmpty() && matcher.matches()) {

                } else {
                    txtMobileNo.setError("You entered invalid mobile no.");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        buttonSave = findViewById(R.id.btn_save);
        initArrayListForSpinners();
        initAdapterForSpinners(context);
        initListener(context);


        // init - set date to current date
        long currentdate = System.currentTimeMillis();
        String dateString = sdf.format(currentdate);
        tvVisitDT.setText(dateString);

        // set calendar date and update editDate
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDate();
            }

        };


        tvVisitDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePickerDialog(context);


            }
        });


        getDataFromVisitPlan();
/*
    public void getGpsLocation() {
        gps = new GPSTracker(this);
        if (gps.canGetLocation()) {
             latitude = gps.getLatitude();
             longitude = gps.getLongitude();
            Toast.makeText(this, "lt:" + latitude + "\n" + "lng:" + longitude, Toast.LENGTH_SHORT).show();

        } else {
            gps.showSettingsAlert();
        }
    }*/
    }




    private void initView() {
        secMobileNo = (LinearLayout) findViewById(R.id.secinput_mobile_no);
        secProductType = (LinearLayout) findViewById(R.id.secProductType);
        secMobileNo.setVisibility(View.GONE);
        secProductType.setVisibility(View.GONE);

        spinnerClientType = findViewById(R.id.awe_spinner_visit_plan_client_type);
        spinnerProductType = findViewById(R.id.awe_spinner_visit_plan_product_type);
        spinnerCity = findViewById(R.id.awe_spinner_visit_plan_city);
        spinnerPoliceStation = findViewById(R.id.awe_spinner_visit_plan_police_station);
        spinnerPurposeOfVisit = findViewById(R.id.awe_spinner_visit_plan_Purpose);

        txtClientName = (EditText) findViewById(R.id.input_client_name);
        txtMobileNo = (EditText) findViewById(R.id.input_mobile_no);
        tvVisitDT = (EditText) findViewById(R.id.dtpVisitDT);
        txtRemarks = (EditText) findViewById(R.id.input_remarks);
    }

    @Override
    protected void getIntentData() {

    }

    public void datePickerDialog(Context context) {

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String selectedDate = (dayOfMonth + "." + month + "." + year);
                tvVisitDT.getText().clear();
                tvVisitDT.setText(selectedDate);
                dateOfvisit = tvVisitDT.getText().toString();
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(context,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                listener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.show();

    }

    private void initAdapterForSpinners(Context context) {
        adptrClientType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mLocalSetting.getClientTypeString());
        spinnerClientType.setAdapter(adptrClientType);

        productTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mLocalSetting.getProductCategorystring());
        spinnerProductType.setAdapter(productTypeAdapter);
        polishStationAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listPs);
        spinnerPoliceStation.setAdapter(polishStationAdapter);

        cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mLocalSetting.getCityStringList());
        spinnerCity.setAdapter(cityAdapter);
        spinnerCity.setThreshold(1);
        adptrPurpose = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mLocalSetting.getVisitPurposeTypeStringList()
        );
        spinnerPurposeOfVisit.setAdapter(adptrPurpose);
    }

    private void initArrayListForSpinners() {
        listClientType = new ArrayList<String>();
        listProductType = new ArrayList<String>();
        listArea = new ArrayList<String>();
        listPurpose = new ArrayList<String>();
        listCity = new ArrayList<String>();
        listDhakaSouth = new ArrayList<String>();
        listDhakaNorth = new ArrayList<String>();
        polishStationList = new ArrayList<String>();
        polishStationList.addAll(mLocalSetting.getPseStringList());

        if (!listPurpose.isEmpty()) {
            listPurpose.clear();
        }
        listArea.add("1-syd");

//        listPurpose.add("Fresh");
//        listPurpose.add("Lead Generation");
//        listPurpose.add("Relationship Mgt");
//        listPurpose.add(PRE_DISBURSEMENT);
//        listPurpose.add(POST_DISBURSEMENT);


    }

    private void updateDate() {
        tvVisitDT.setText(sdf.format(myCalendar.getTime()));
    }

    protected Dialog onCreateDialog(int id) {
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mDateSetListener, g.mYear, g.mMonth - 1, g.mDay);
            case TIME_DIALOG:
                return new TimePickerDialog(this, timePickerListener, hour, minute, false);
        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
            hour = selectedHour;
            minute = selectedMinute;
            EditText tpTime;


            //  tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

        }
    };

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear + 1;
            mDay = dayOfMonth;
            EditText dtpDate;


            dtpDate = (EditText) findViewById(R.id.dtpVisitDT);
            if (VariableID.equals("btnVisitDT")) {
                dtpDate = (EditText) findViewById(R.id.dtpVisitDT);
            }
            dtpDate.setText(new StringBuilder()
                    .append(Global.Right("00" + mDay, 2)).append("/")
                    .append(Global.Right("00" + mMonth, 2)).append("/")
                    .append(mYear));
        }
    };


    public void initListener(Context context) {

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VisitPlanActivity.super.onBackPressed();
                finish();
            }
        });

        buttonSave.setOnClickListener(view -> {
                getGpsLocation();
                clientName = txtClientName.getText().toString().trim();
                mobileNo = txtMobileNo.getText().toString().trim();
                dateOfvisit = tvVisitDT.getText().toString().trim();
                remarks = txtRemarks.getText().toString();
                if (isValid()) {
                    alertDialog();
                }

        });

        spinnerClientType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

                clientType = s;
                if (s.equalsIgnoreCase("INDIVIDUAL")) {
                    secMobileNo.setVisibility(View.VISIBLE);
                    secProductType.setVisibility(View.VISIBLE);

                } else {
                    secMobileNo.setVisibility(View.GONE);
                    secProductType.setVisibility(View.GONE);


                }
            }
        });

        spinnerProductType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                productType = s;
            }
        });


        spinnerPurposeOfVisit.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                purposeOfVisit = s;

                if (s.equals(PRE_DISBURSEMENT)) {
                    throwAlertDialogForCIF();
                }
                if (s.equals(POST_DISBURSEMENT)) {
                    throwAlertDialogForCIF();
                }
            }
        });

    /*    spinnerCity.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                city = s;


            }

        });*/

        spinnerCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                city = String.valueOf(spinnerCity.getAdapter().getItem(i));
                if (!listPs.isEmpty())
                    listPs.clear();
                listPs.addAll(mLocalSetting.getpsListByCityCode(city));
                polishStationAdapter.notifyDataSetChanged();
            }
        });

        spinnerPoliceStation.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                policeStation = s;
            }
        });


    }

    private boolean isValid() {
        boolean valid = true;


//        if (clientType == null || purposeOfVisit == null || city == null || policeStation == null) {
//
//            android.app.AlertDialog.Builder builder;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                builder = new android.app.AlertDialog.Builder(VisitPlanActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
//            } else {
//                builder = new android.app.AlertDialog.Builder(VisitPlanActivity.this);
//            }
//            builder.setIcon(R.drawable.ic_required);
//            builder.setTitle(Html.fromHtml("<font color='#FF0000'>Enter required values</font>"));
//            builder.setNegativeButton("OK", null);
//            android.app.AlertDialog dialog = builder.create();
//            dialog.show();
//            valid = false;
//        }

        if (clientType == null){
            showAlertDialog("Required","Enter Client Type");
            return false;
        }
        if (purposeOfVisit == null){
            showAlertDialog("Required","Enter Purpose of Visit");
            return false;
        }
        if (clientType.equalsIgnoreCase("INDIVIDUAL")){
            if (MasumCommonUtils.isNullStr(productType)){
                showAlertDialog("Required","Enter Product Type");
                return false;
            }
        }
        if (city==null){
            showAlertDialog("Required","Enter City");
            return false;
        }
        if (policeStation==null){
            showAlertDialog("Required","Enter Police Station");
            return false;
        }
        if (dateOfvisit==null){
            showAlertDialog("Required","Enter Date of visit");
            return false;
        }

        else if (getltd()==0 && getltd()==0){
           valid=false;
        }

        return valid;
    }


    private void getDataFromVisitPlan() {

        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            visitPlanModel = (VisitPlan) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            setAllData(visitPlanModel);
        }
    }

    private void setAllData(VisitPlan visitPlanModel) {
        if (visitPlanModel.getClientType() != null) {
            try {
                spinnerClientType.setSelection(adptrClientType.getPosition(visitPlanModel.getClientType()));
            } catch (final IllegalStateException e) {

            }
        }

        if (visitPlanModel.getPurposeOfVisit() != null) {
            try {
                spinnerPurposeOfVisit.setSelection(adptrPurpose.getPosition(visitPlanModel.getPurposeOfVisit()));
            } catch (final IllegalStateException e) {

            }
        }

/*
        if (visitPlanModel.getCity() != null) {
            try {
                spinnerCity.setSelection(cityAdapter.getPosition(visitPlanModel.getCity()));
            } catch (final IllegalStateException e) {

            }


            ArrayAdapter<String> dhakaNorth = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, polishStationList);
            spinnerPoliceStation.setAdapter(dhakaNorth);

            try {
                spinnerPoliceStation.setSelection(dhakaNorth.getPosition(visitPlanModel.getPoliceStation()));
            } catch (final IllegalStateException e) {

            }


        }*/

        if (!MasumCommonUtils.isNullStr(visitPlanModel.getCity())) {
            spinnerCity.setText(visitPlanModel.getCity());
            if (!listPs.isEmpty())
                listPs.clear();
            listPs.addAll(mLocalSetting.getpsListByCityCode(city));
            polishStationAdapter.notifyDataSetChanged();
        }


        if (visitPlanModel.getProductType() != null) {
            try {
                spinnerProductType.setSelection(productTypeAdapter.getPosition(visitPlanModel.getProductType()));
            } catch (final IllegalStateException e) {

            }
        }
        clientName = visitPlanModel.getClientName();
        mobileNo = visitPlanModel.getMobileNumber();
        dateOfvisit = visitPlanModel.getDateOfVisit();
        remarks = visitPlanModel.getRemarks();

        txtClientName.setText(clientName);
        txtMobileNo.setText(mobileNo);
        txtRemarks.setText(remarks);
        if (visitPlanModel.getDateOfVisit() != null)
            tvVisitDT.setText(DateUtils.getDateFormateEt(visitPlanModel.getDateOfVisit()));


    }


    private void throwAlertDialogForCIF() {
        final AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_visit_plan_cif_dialog, null);
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

    private void alertDialog() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(VisitPlanActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(VisitPlanActivity.this);
        }
        builder.setTitle("Save");
        builder.setMessage("Do you want to save data?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            int insert = 0;
            if (visitPlanModel != null) {
                Data data = new Data();
                data.setActivityDate(DateUtils.getDateFormateForSqlite(dateOfvisit));
                data.setActivityJournalID(visitPlanModel.getJournalId());
                data.setActivityStatus(visitPlanModel.getStatus());
                data.setCity(city);
                data.setClientType(clientType);
                data.setCustomerName(clientName);

                data.setMaker(userName);
                data.setMobileNo(mobileNo);
                data.setProductType(productType);
                data.setPs(policeStation);
                data.setRemarks(remarks);
                data.setVisitPurposeType(purposeOfVisit);

                if (isNetworkAvailable()) {
                    getApiService().createVisitPlan(data).enqueue(new Callback<MyVisitPlanApi>() {
                        @Override
                        public void onResponse(Call<MyVisitPlanApi> call, Response<MyVisitPlanApi> response) {
                            if (response.isSuccessful()){
                                if (response.body().getCode().equals(getString(R.string.success_code))){
                                    VisitPlan visitPlan = new VisitPlan(visitPlanModel.getId(), visitPlanModel.getJournalId(), clientName, spinnerClientType.getSelectedItem(),
                                            mobileNo, spinnerPoliceStation.getSelectedItem(), spinnerProductType.getSelectedItem(), spinnerCity.getText().toString(),
                                            purposeOfVisit, dateOfvisit, remarks, AppConstant.LEAD_STATUS_New_PLAN, AppConstant.SYNC_STATUS_OK);
                                    dbController.updateData(visitPlan);
                                    sendGpsLocation(String.valueOf(response.body().getData().getActivityJournalID()),"Activity",userName,getltd(),getLng(),getCompleteAddressString(getltd(),getLng()),VisitPlanActivity.this);

                                }
                                else if (response.body().getCode().equals("404")){
                                    showAlertDialog(response.body().getCode(),response.body().getMessage());
                                }

                                else {
                                    showAlertDialog(response.body().getCode(),response.body().getMessage());
                                }

                            }
                            else {
                                showAlertDialog(getString(R.string.error_text),response.errorBody().toString());

                            }


                        }

                        @Override
                        public void onFailure(Call<MyVisitPlanApi> call, Throwable t) {
                            showAlertDialog(getString(R.string.error_text),t.getMessage());

                        }
                    });
                } else {
                    VisitPlan visitPlan = new VisitPlan(visitPlanModel.getId(), visitPlanModel.getJournalId(), clientName, spinnerClientType.getSelectedItem(),
                            mobileNo, spinnerPoliceStation.getSelectedItem(), spinnerProductType.getSelectedItem(), spinnerCity.getText().toString(),
                            purposeOfVisit, dateOfvisit, remarks, AppConstant.LEAD_STATUS_New_PLAN, AppConstant.SYNC_STATUS_WAIT);
                    dbController.updateData(visitPlan);
                    finish();
                }


            } else {
                Data data = new Data();
                data.setActivityDate(DateUtils.getDateFormateForSqlite(dateOfvisit));
                data.setActivityJournalID(0);
                data.setActivityStatus("");
                data.setCity(city);
                data.setClientType(clientType);
                data.setCustomerName(clientName);

                data.setMaker(userName);
                data.setMobileNo(mobileNo);
                data.setProductType(productType);
                data.setPs(policeStation);
                data.setRemarks(remarks);
                data.setVisitPurposeType(purposeOfVisit);
                if (isNetworkAvailable()) {
                    getApiService().createVisitPlan(data).enqueue(new Callback<MyVisitPlanApi>() {
                        @Override
                        public void onResponse(Call<MyVisitPlanApi> call, Response<MyVisitPlanApi> response) {
                            if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                Data data1 = response.body().getData();
                              /*  dbController.insertData(data1.getActivityJournalID(), clientName, spinnerClientType.getSelectedItem(),
                                        mobileNo, spinnerProductType.getSelectedItem(), spinnerCity.getText().toString(),
                                        spinnerPoliceStation.getSelectedItem(),
                                        purposeOfVisit, dateOfvisit, remarks, AppConstant.LEAD_STATUS_New_PLAN, AppConstant.SYNC_STATUS_OK);
                           */
                                sendGpsLocation(String.valueOf(data1.getActivityJournalID()),"Activity",userName,getltd(),getLng(),getCompleteAddressString(getltd(),getLng()),VisitPlanActivity.this);

                                Log.e("status", "save data into server and local" + response.body().getData().toString());

                            }

                        }

                        @Override
                        public void onFailure(Call<MyVisitPlanApi> call, Throwable t) {
                            getAlertDialog("ERROR", t.getMessage());

                        }
                    });
                } else {
                /*    int insert1 = dbController.insertData(0, clientName, spinnerClientType.getSelectedItem(),
                            mobileNo, spinnerProductType.getSelectedItem(), spinnerCity.getText().toString(),
                            spinnerPoliceStation.getSelectedItem(),
                            purposeOfVisit, dateOfvisit, remarks, AppConstant.STATUS_ACTIVITY_NEW, AppConstant.SYNC_STATUS_WAIT);*/
                    Log.e("status", " no internet save data into local");
                    finish();
                }
            }
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }





}