package net.maxproit.salesforce.masum.activity;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
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
import net.maxproit.salesforce.common.base.Global;
import net.maxproit.salesforce.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.salesforce.masum.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.sqlite.VisitPlanDbController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class VisitPlanActivity extends AppCompatActivity {

//    Toolbar toolbarVisitPlan;


    String VariableID;
    private int hour;
    private int minute;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;
    private VisitPlanDbController dbController;
    private SpinnerDbController spinnerDbController;


    static final String PRE_DISBURSEMENT = "Pre- Disbursement";
    static final String POST_DISBURSEMENT = "Post- Disbursement";
    static final String INDIVIDUAL = "Individual";
    static final String DHAKA_NORTH = "Dhaka North";
    static final String DHAKA_SOUTH = "Dhaka South";
    static final String NARAYANGONJ = "Narayanganj";

    private AwesomeSpinner spinnerClientType, spinnerProductType, spinnerCity,  spinnerPoliceStation, spinnerPurposeOfVisit;
    TextView VlblClientType, lblHeading, VlblMobileNo, VlblProductType, VlblArea, VlblPurpose, VlblVisitDT, VlblRemarks, buttonSave;
    LinearLayout secClientType, secMobileNo, secProductType, secArea, secPurpose, secVisitDT, secRemarks;
    View lineClientType, lineMobileNo, lineProductType, lineArea, linePurpose, lineVisitDT, lineRemarks;
    EditText txtClientName, txtMobileNo, dtpVisitDT, txtRemarks;
    String clientName, clientType, mobileNo, productType, city, policeStation, purposeOfVisit, dateOfvisit, remarks;

    List<String> listClientType, listProductType, listArea, listPurpose, listCity,listDhakaSouth, listDhakaNorth, listNarayanganj;
    ImageView backButton;

    Context context = this;
    Global g;
    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd.MM.yyyy";
    DatePickerDialog.OnDateSetListener date;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.GERMAN);

//    Context context = this;
//    EditText editDate;
//    Calendar myCalendar = Calendar.getInstance();
//    String dateFormat = "dd.MM.yyyy";
//    DatePickerDialog.OnDateSetListener date;
//    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.BANGLADESH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_plan);

//        toolbarVisitPlan = (Toolbar) findViewById(R.id.toolbar_visit_plan);
//        toolbarVisitPlan.setTitle("Visit Plan");
//        toolbarVisitPlan.setTitleTextColor(getResources().getColor(R.color.white));
        backButton = findViewById(R.id.btn_back);

        g = Global.getInstance();
        dbController=new VisitPlanDbController(VisitPlanActivity.this);
        spinnerDbController = new SpinnerDbController(VisitPlanActivity.this);


//        int insert=spinnerDbController.insertCityData("dhaka");
//        if (insert>0){
//            Toast.makeText(VisitPlanActivity.this, "Save", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(VisitPlanActivity.this, "Save failed", Toast.LENGTH_SHORT).show();
//
//        }



//        Toast.makeText(context,"data"+ spinnerDbController.getCityData(), Toast.LENGTH_SHORT).show();


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
        dtpVisitDT = (EditText) findViewById(R.id.dtpVisitDT);
        txtRemarks = (EditText) findViewById(R.id.input_remarks);

        txtMobileNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String mobileNo = charSequence.toString(), regex = "01[3|5|6|7|8|9][0-9]{8}";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(mobileNo);
                if(!mobileNo.isEmpty() && matcher.matches()){

                }else{
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
        dtpVisitDT.setText(dateString);

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


//        dtpVisitDT.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                new DatePickerDialog(context, date, myCalendar
//                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });
//

        //  secClientType=(LinearLayout)findViewById(R.id.secClientType);
        //lineClientType=(View)findViewById(R.id.lineClientType);
        // VlblClientType=(TextView) findViewById(R.id.VlblClientType);


//        spnClientType=(Spinner) findViewById(R.id.spinner_client);




        dtpVisitDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePickerDialog(context);


            }
        });



//        dtpVisitDT.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                final int DRAWABLE_RIGHT = 2;
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    if (event.getRawX() >= (dtpVisitDT.getRight() - dtpVisitDT.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
//                        VariableID = "btnVisitDT";
//                        showDialog(DATE_DIALOG);
//                        return true;
//                    }
//                }
//                return false;
//            }
//        });


        // secRemarks=(LinearLayout)findViewById(R.id.secRemarks);
        // lineRemarks=(View)findViewById(R.id.lineRemarks);
        // VlblRemarks=(TextView) findViewById(R.id.VlblRemarks);

//        final Calendar calendar = Calendar.getInstance();
//
//        EditText dateOfVisit= (EditText) findViewById(R.id.datepicker_purpose_of_visit);
//        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
//
//                @Override
//                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//
//                    calendar.set(Calendar.YEAR, year);
//                    calendar.set(Calendar.MONTH, monthOfYear);
//                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
////                    updateLabel();
//                }
//        };

//        dateOfVisit.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    new DatePickerDialog(this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
//                }
//        });

    }

    public void datePickerDialog(Context context){

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String selectedDate = (dayOfMonth +"."+ month +"."+ year);
                dtpVisitDT.getText().clear();
                dtpVisitDT.setText(selectedDate);
                dateOfvisit = dtpVisitDT.getText().toString();
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

        ArrayAdapter<String> adptrClientType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listClientType);
        spinnerClientType.setAdapter(adptrClientType);

        ArrayAdapter<String> productTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listProductType);
        spinnerProductType.setAdapter(productTypeAdapter);


        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCity);
        spinnerCity.setAdapter(cityAdapter);
//        ArrayAdapter<CharSequence> adapterCity = ArrayAdapter.createFromResource(context,
//                R.array.city_array,
//                android.R.layout.simple_spinner_item);
//        spinnerCity.setAdapter(adapterCity, 0);

        ArrayAdapter<String> adptrPurpose = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPurpose);
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

        if (!listPurpose.isEmpty()){
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
        dtpVisitDT.setText(sdf.format(myCalendar.getTime()));
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
                mobileNo= txtMobileNo.getText().toString().trim();
                dateOfvisit= dtpVisitDT.getText().toString().trim();
                remarks = txtRemarks.getText().toString();

                int insert=dbController.insertData(clientName, clientType, mobileNo, productType, city, policeStation, purposeOfVisit, dateOfvisit,remarks);
                if (insert>0){
                    Toast.makeText(VisitPlanActivity.this, "Save", Toast.LENGTH_SHORT).show();
                    Intent dashboardIntent = new Intent(VisitPlanActivity.this, DashboardSalesOfficerActivity.class);
                    startActivity(dashboardIntent);
                    finish();
                }
                else {
                    Toast.makeText(VisitPlanActivity.this, "Save failed", Toast.LENGTH_SHORT).show();

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

                if (s.equals(PRE_DISBURSEMENT)){
                    throwAlertDialogForCIF();

                }if(s.equals(POST_DISBURSEMENT)){
                    throwAlertDialogForCIF();
                }
            }
        });

        spinnerCity.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                city = s;

                if ( s.equals(DHAKA_NORTH)){

//                    ArrayAdapter<CharSequence> adapterPoliceStation = ArrayAdapter.createFromResource(context,
//                            R.array.dhaka_north_police_station_array,
//                            android.R.layout.simple_spinner_item);
//                    spinnerPoliceStation.setAdapter(adapterPoliceStation, 0);

                    ArrayAdapter<String> dhakaNorth = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listDhakaNorth);
                    spinnerPoliceStation.setAdapter(dhakaNorth);

                }
                if ( s.equals(DHAKA_SOUTH)){

                    ArrayAdapter<String> dhakaSouth = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listDhakaSouth);
                    spinnerPoliceStation.setAdapter(dhakaSouth);

//                    ArrayAdapter<CharSequence> adapterPoliceStation = ArrayAdapter.createFromResource(context,
//                            R.array.dhaka_south_police_station_array,
//                            android.R.layout.simple_spinner_item);
//                    spinnerPoliceStation.setAdapter(adapterPoliceStation, 0);


                }
                if ( s.equals(NARAYANGONJ)){


                    ArrayAdapter<String> narayanganj = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listNarayanganj);
                    spinnerPoliceStation.setAdapter(narayanganj);
//                    ArrayAdapter<CharSequence> adapterPoliceStation = ArrayAdapter.createFromResource(context,
//                            R.array.narayanganj_police_station_array,
//                            android.R.layout.simple_spinner_item);
//                    spinnerPoliceStation.setAdapter(adapterPoliceStation, 0);



                }
            }
        });

        spinnerPoliceStation.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                policeStation = s;
            }
        });






//        spnClientType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                String selectedItemText = (String) parentView.getSelectedItem().toString();
//                if(selectedItemText.equals("Individual")){
//                     secMobileNo.setVisibility(View.VISIBLE);
//                }else{
//                    secMobileNo.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//                // your code here
//            }
//
//        });


    }


    private void throwAlertDialogForCIF(){
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

}