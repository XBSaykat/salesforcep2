package net.maxproit.salesforce.masum.activity.visitplan;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
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
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.model.setting.LocalSetting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.maxproit.salesforce.masum.appdata.AppConstant.DHAKA_NORTH;
import static net.maxproit.salesforce.masum.appdata.AppConstant.DHAKA_SOUTH;
import static net.maxproit.salesforce.masum.appdata.AppConstant.INDIVIDUAL;
import static net.maxproit.salesforce.masum.appdata.AppConstant.NARAYANGONJ;
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
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;
    private LocalSetting mLocalSetting;
    private VisitPlanDbController dbController;
    private SpinnerDbController spinnerDbController;
    private VisitPlan visitPlanModel;
    private ArrayAdapter<String> adptrClientType, cityAdapter, adptrPurpose, productTypeAdapter;
    private AwesomeSpinner spinnerClientType, spinnerProductType, spinnerCity, spinnerPoliceStation, spinnerPurposeOfVisit;
    TextView buttonSave;
    LinearLayout secClientType, secMobileNo, secProductType, secArea, secPurpose, secVisitDT, secRemarks;
    View lineClientType, lineMobileNo, lineProductType, lineArea, linePurpose, lineVisitDT, lineRemarks;
    EditText txtClientName, txtMobileNo, tvVisitDT, txtRemarks;
    String clientName, clientType, mobileNo, productType, city, policeStation, purposeOfVisit, dateOfvisit, remarks;

    List<String> listClientType, listProductType, listArea, listPurpose, listCity, listDhakaSouth, listDhakaNorth, listNarayanganj;
    ImageView backButton;

    Context context = this;
    Global g;
    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd.MM.yyyy";
    DatePickerDialog.OnDateSetListener date;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.GERMAN);

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_visit_plan;
    }

    @Override
    protected void initComponents() {

        backButton = findViewById(R.id.btn_back);

        g = Global.getInstance();
        dbController = new VisitPlanDbController(VisitPlanActivity.this);
        spinnerDbController = new SpinnerDbController(VisitPlanActivity.this);
        mLocalSetting=new LocalSetting(this);
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

        adptrClientType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listClientType);
        spinnerClientType.setAdapter(adptrClientType);

        productTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mLocalSetting.getProductCategorystring());
        spinnerProductType.setAdapter(productTypeAdapter);


        cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mLocalSetting.getCityStringList());
        spinnerCity.setAdapter(cityAdapter);

        adptrPurpose = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mLocalSetting.getVisitPurposeTypeStringList());
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
        listNarayanganj = new ArrayList<String>();

        if (!listPurpose.isEmpty()) {
            listPurpose.clear();
        }
        listClientType.addAll(spinnerDbController.getClientTypeData());
        listProductType.addAll(spinnerDbController.getProductTypeData());
        listPurpose.addAll(spinnerDbController.getPurposeOfVisitData());
        listCity.addAll(spinnerDbController.getCityData());
        listDhakaNorth.addAll(spinnerDbController.getDhakaNorthData());
        listDhakaSouth.addAll(spinnerDbController.getDhakaSouthData());
        listNarayanganj.addAll(spinnerDbController.getNarayanganjData());


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

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientName = txtClientName.getText().toString().trim();
                mobileNo = txtMobileNo.getText().toString().trim();
                dateOfvisit = tvVisitDT.getText().toString().trim();
                remarks = txtRemarks.getText().toString();

                if (isValid()) {
                    alertDialog();
                }


            }
        });

        spinnerClientType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

                clientType = s;
                if (s.equals(INDIVIDUAL)) {
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

        spinnerCity.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                city = s;

                if (s.equals(DHAKA_NORTH)) {

                    ArrayAdapter<String> dhakaNorth = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listDhakaNorth);
                    spinnerPoliceStation.setAdapter(dhakaNorth);

                }
                else if (s.equals(DHAKA_SOUTH)) {

                    ArrayAdapter<String> dhakaSouth = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listDhakaSouth);
                    spinnerPoliceStation.setAdapter(dhakaSouth);


                }
               else if (s.equals(NARAYANGONJ)) {


                    ArrayAdapter<String> narayanganj = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listNarayanganj);
                    spinnerPoliceStation.setAdapter(narayanganj);


                }
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


        if(clientType == null || purposeOfVisit == null || city == null || policeStation == null){

            android.app.AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new android.app.AlertDialog.Builder(VisitPlanActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
            } else {
                builder = new android.app.AlertDialog.Builder(VisitPlanActivity.this);
            }
            builder.setIcon(R.drawable.ic_required);
            builder.setTitle(Html.fromHtml("<font color='#FF0000'>Enter required values</font>"));
            builder.setNegativeButton("OK", null);
            android.app.AlertDialog dialog = builder.create();
            dialog.show();
            valid = false;
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


        if (visitPlanModel.getCity() != null) {
            try {
                spinnerCity.setSelection(cityAdapter.getPosition(visitPlanModel.getCity()));
            } catch (final IllegalStateException e) {

            }


            if (visitPlanModel.getCity().equals(DHAKA_NORTH)) {

                ArrayAdapter<String> dhakaNorth = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listDhakaNorth);
                spinnerPoliceStation.setAdapter(dhakaNorth);

                try{
                    spinnerPoliceStation.setSelection(dhakaNorth.getPosition(visitPlanModel.getPoliceStation()));
                }
                catch (final  IllegalStateException e){

                }

            }
            else if (visitPlanModel.getCity().equals(DHAKA_SOUTH)) {

                ArrayAdapter<String> dhakaSouth = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listDhakaSouth);
                spinnerPoliceStation.setAdapter(dhakaSouth);
                try{
                    spinnerPoliceStation.setSelection(dhakaSouth.getPosition(visitPlanModel.getPoliceStation()));
                }
                catch (final  IllegalStateException e){

                }

            }
            else if (visitPlanModel.getCity().equals(NARAYANGONJ)) {


                ArrayAdapter<String> narayanganj = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listNarayanganj);
                spinnerPoliceStation.setAdapter(narayanganj);
                try{
                    spinnerPoliceStation.setSelection(narayanganj.getPosition(visitPlanModel.getPoliceStation()));
                }
                catch (final  IllegalStateException e){

                }


            }
        }

        if (visitPlanModel.getProductType() !=null){
            try{
                spinnerProductType.setSelection(productTypeAdapter.getPosition(visitPlanModel.getProductType()));
            }
            catch (final  IllegalStateException e){

            }
        }
        clientName = visitPlanModel.getClientName();
        mobileNo = visitPlanModel.getMobileNumber();
        dateOfvisit = visitPlanModel.getDateOfVisit();
        remarks = visitPlanModel.getRemarks();

        txtClientName.setText(clientName);
        txtMobileNo.setText(mobileNo);
        txtRemarks.setText(remarks);
        tvVisitDT.setText(DateUtils.getDateFormateEt(dateOfvisit));


    }


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
                VisitPlan visitPlan = new VisitPlan(visitPlanModel.getId(), clientName, spinnerClientType.getSelectedItem(),
                        mobileNo,spinnerPoliceStation.getSelectedItem(), spinnerProductType.getSelectedItem(), spinnerCity.getSelectedItem(),
                        purposeOfVisit, dateOfvisit, remarks, AppConstant.LEAD_STATUS_New_PLAN);
                insert = dbController.updateData(visitPlan);
            } else {
                insert = dbController.insertData(clientName, spinnerClientType.getSelectedItem(),
                        mobileNo, spinnerProductType.getSelectedItem(), spinnerCity.getSelectedItem(),
                        spinnerPoliceStation.getSelectedItem(),
                        purposeOfVisit, dateOfvisit, remarks, AppConstant.LEAD_STATUS_New_PLAN);

            }

            if (insert > 0) {
                        Toast.makeText(VisitPlanActivity.this, "Successfully save", Toast.LENGTH_SHORT).show();
                        finish();

            } else {
                Toast.makeText(VisitPlanActivity.this, "Save failed", Toast.LENGTH_SHORT).show();

            }

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

}