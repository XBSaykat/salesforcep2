package net.maxproit.idlc.feature.salesOfficer;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.widget.Toast;
//import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.Global;
import net.maxproit.idlc.sqlite.VisitPlanDbController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class VisitPlanActivity extends AppCompatActivity {

    Toolbar toolbar;

    String VariableID;
    private int hour;
    private int minute;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;


    private AwesomeSpinner spinnerClientType, spinnerProductType, spinnerArea, spinnerPurposeOfVisit;
    TextView VlblClientType, lblHeading, VlblMobileNo, VlblProductType, VlblArea, VlblPurpose, VlblVisitDT, VlblRemarks, buttonSave;
    LinearLayout secClientType, secMobileNo, secProductType, secArea, secPurpose, secVisitDT, secRemarks;
    View lineClientType, lineMobileNo, lineProductType, lineArea, linePurpose, lineVisitDT, lineRemarks;
    EditText txtMobileNo, dtpVisitDT, txtRemarks;
    String clientType, mobileNo, productType, area, purposeOfVisit, dateOfvisit, remarks;
   private VisitPlanDbController dbController;

    List<String> listClientType, listProductType, listArea, listPurpose;

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

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Visit Plan");
        g = Global.getInstance();

        secMobileNo = (LinearLayout) findViewById(R.id.secinput_mobile_no);
        secMobileNo.setVisibility(View.GONE);

        spinnerClientType = findViewById(R.id.awe_spinner_visit_plan_client_type);
        spinnerProductType = findViewById(R.id.awe_spinner_visit_plan_product_type);
        spinnerArea = findViewById(R.id.awe_spinner_visit_plan_area);
        spinnerPurposeOfVisit = findViewById(R.id.awe_spinner_visit_plan_Purpose);

        txtMobileNo = (EditText) findViewById(R.id.input_mobile_no);
        dtpVisitDT = (EditText) findViewById(R.id.dtpVisitDT);
        txtRemarks = (EditText) findViewById(R.id.input_remarks);

        buttonSave = findViewById(R.id.btn_save);
       dbController=new VisitPlanDbController(VisitPlanActivity.this);
        initArrayListForSpinners();
        initAdapterForSpinners();
        initListener();


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

        // onclick - popup datepicker
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







        //lineMobileNo=(View)findViewById(R.id.lineMobileNo);
        // VlblMobileNo=(TextView) findViewById(R.id.VlblMobileNo);
        // secProductType=(LinearLayout)findViewById(R.id.secProductType);
        //  lineProductType=(View)findViewById(R.id.lineProductType);
        // VlblProductType=(TextView) findViewById(R.id.VlblProductType);
//        spnProductType=(Spinner) findViewById(R.id.spinner_product_type);



        //  secArea=(LinearLayout)findViewById(R.id.secArea);
        //  lineArea=(View)findViewById(R.id.lineArea);
        //  VlblArea=(TextView) findViewById(R.id.VlblArea);
//        spnArea=(Spinner) findViewById(R.id.spinner_area);


        // secPurpose=(LinearLayout)findViewById(R.id.secPurpose);
        // linePurpose=(View)findViewById(R.id.linePurpose);
        // VlblPurpose=(TextView) findViewById(R.id.VlblPurpose);
//        spnPurpose=(Spinner) findViewById(R.id.spinner_purpose_of_visit);




        //  secVisitDT=(LinearLayout)findViewById(R.id.secVisitDT);
        // lineVisitDT=(View)findViewById(R.id.lineVisitDT);
        //  VlblVisitDT=(TextView) findViewById(R.id.VlblVisitDT);

        dtpVisitDT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (dtpVisitDT.getRight() - dtpVisitDT.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        VariableID = "btnVisitDT";
                        showDialog(DATE_DIALOG);
                        return true;
                    }
                }
                return false;
            }
        });


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

    private void initAdapterForSpinners() {

        ArrayAdapter<String> adptrClientType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listClientType);
        spinnerClientType.setAdapter(adptrClientType);

        ArrayAdapter<String> productTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listProductType);
        spinnerProductType.setAdapter(productTypeAdapter);

        ArrayAdapter<String> adptrArea = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listArea);
        spinnerArea.setAdapter(adptrArea);

        ArrayAdapter<String> adptrPurpose = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPurpose);
        spinnerPurposeOfVisit.setAdapter(adptrPurpose);
    }

    private void initArrayListForSpinners() {
        listClientType = new ArrayList<String>();
        listProductType = new ArrayList<String>();
        listArea = new ArrayList<String>();
        listPurpose = new ArrayList<String>();


        listClientType.add("Individual");
        listClientType.add("Developer");
        listClientType.add("Vendor");
        listClientType.add("Corporate House");

        listProductType.add("Home Loan");
        listProductType.add("Car Loan");
        listProductType.add("Personal Loan");
        listProductType.add("Deposit");
        listProductType.add("Investment");

        listArea.add("1-syd");

        listPurpose.add("Fresh");
        listPurpose.add("Lead Generation");
        listPurpose.add("Relationship Mgt");
        listPurpose.add("Pre-Disbursement");
        listPurpose.add("Post Disbursement");


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







    public void initListener() {

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mobileNo= txtMobileNo.getText().toString().trim();
                dateOfvisit= dtpVisitDT.getText().toString().trim();
                remarks = txtRemarks.getText().toString().trim();

                int insert=dbController.insertData(clientType, mobileNo,
                        productType, area, purposeOfVisit, dateOfvisit, remarks,"status");
                int insert = visitPlanDbController.insertData(clientType, mobileNo,
                        productType, area, purposeOfVisit, dateOfvisit, remarks);
                if (insert>0){
                    Toast.makeText(getApplicationContext(), "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "data not inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });
        spinnerClientType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

                clientType = s;
                if (s.equals("Individual")) {
                    secMobileNo.setVisibility(View.VISIBLE);
                } else {
                    secMobileNo.setVisibility(View.GONE);

                }
            }
        });

        spinnerProductType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                productType = s;
            }
        });

        spinnerArea.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                area = s;
            }
        });

        spinnerPurposeOfVisit.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                purposeOfVisit = s;
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

}