package net.maxproit.idlc.feature.salesOfficer;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
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


    AwesomeSpinner spinnerClientType, spinnerProductType, spinnerArea, spinnerPurposeOfVisit;

    VisitPlanDbController visitPlanDbController;

    TextView lblHeading;
    LinearLayout secClientType;
    View lineClientType;
    TextView VlblClientType;
    Spinner spnClientType;
    LinearLayout secMobileNo;
    View lineMobileNo;
    TextView VlblMobileNo;
    EditText txtMobileNo;
    LinearLayout secProductType;
    View lineProductType;
    TextView VlblProductType;
    Spinner spnProductType;
    LinearLayout secArea;
    View lineArea;
    TextView VlblArea;
    Spinner spnArea;
    LinearLayout secPurpose;
    View linePurpose;
    TextView VlblPurpose;
    Spinner spnPurpose;
    LinearLayout secVisitDT;
    View lineVisitDT;
    TextView VlblVisitDT;
    EditText dtpVisitDT;
    LinearLayout secRemarks;
    View lineRemarks;
    TextView VlblRemarks;
    EditText txtRemarks;

    List<String> listClientType;
    List<String> listProductType;

    TextView buttonSave;

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

        dtpVisitDT = (EditText) findViewById(R.id.dtpVisitDT);
        buttonSave = findViewById(R.id.btn_save);


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

        secMobileNo=(LinearLayout)findViewById(R.id.secinput_mobile_no);
        secMobileNo.setVisibility(View.GONE);
        spinnerClientType = findViewById(R.id.awe_spinner_visit_plan_client_type);
        listClientType = new ArrayList<String>();

        listClientType.add("Individual");
        listClientType.add("Developer");
        listClientType.add("Vendor");
        listClientType.add("Corporate House");
        ArrayAdapter<String> adptrClientType= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listClientType);
        spinnerClientType.setAdapter(adptrClientType);



        //lineMobileNo=(View)findViewById(R.id.lineMobileNo);
        // VlblMobileNo=(TextView) findViewById(R.id.VlblMobileNo);
        txtMobileNo=(EditText) findViewById(R.id.input_mobile_no);
        // secProductType=(LinearLayout)findViewById(R.id.secProductType);
        //  lineProductType=(View)findViewById(R.id.lineProductType);
        // VlblProductType=(TextView) findViewById(R.id.VlblProductType);
//        spnProductType=(Spinner) findViewById(R.id.spinner_product_type);

        spinnerProductType = findViewById(R.id.awe_spinner_visit_plan_product_type);

        listProductType = new ArrayList<String>();


        listProductType.add("1-Home Loan");
        listProductType.add("2-Car Loan");
        listProductType.add("3-Personal Loan");
        listProductType.add("4-Deposit");
        listProductType.add("5-Investment");
        ArrayAdapter<String> productTypeAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listProductType);
        spinnerProductType.setAdapter(productTypeAdapter);

        //  secArea=(LinearLayout)findViewById(R.id.secArea);
        //  lineArea=(View)findViewById(R.id.lineArea);
        //  VlblArea=(TextView) findViewById(R.id.VlblArea);
//        spnArea=(Spinner) findViewById(R.id.spinner_area);
        spinnerArea= findViewById(R.id.awe_spinner_visit_plan_area);

        List<String> listArea = new ArrayList<String>();


        listArea.add("1-syd");
        ArrayAdapter<String> adptrArea= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listArea);
        spinnerArea.setAdapter(adptrArea);

        // secPurpose=(LinearLayout)findViewById(R.id.secPurpose);
        // linePurpose=(View)findViewById(R.id.linePurpose);
        // VlblPurpose=(TextView) findViewById(R.id.VlblPurpose);
//        spnPurpose=(Spinner) findViewById(R.id.spinner_purpose_of_visit);

        spinnerPurposeOfVisit= findViewById(R.id.awe_spinner_visit_plan_Purpose);
        List<String> listPurpose = new ArrayList<String>();


        listPurpose.add("1-Fresh");
        listPurpose.add("2-Lead Generation");
        listPurpose.add("3- Relationship Mgt");
        listPurpose.add("4- Pre-Disbursement");
        listPurpose.add("5- Post Disbursement");
        ArrayAdapter<String> adptrPurpose= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPurpose);
        spinnerPurposeOfVisit.setAdapter(adptrPurpose);

        //  secVisitDT=(LinearLayout)findViewById(R.id.secVisitDT);
        // lineVisitDT=(View)findViewById(R.id.lineVisitDT);
        //  VlblVisitDT=(TextView) findViewById(R.id.VlblVisitDT);
        dtpVisitDT=(EditText) findViewById(R.id.dtpVisitDT);

        dtpVisitDT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT  = 2;
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (dtpVisitDT.getRight() - dtpVisitDT.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        VariableID = "btnVisitDT"; showDialog(DATE_DIALOG);
                        return true;
                    }
                }
                return false;
            }
        });




        // secRemarks=(LinearLayout)findViewById(R.id.secRemarks);
        // lineRemarks=(View)findViewById(R.id.lineRemarks);
        // VlblRemarks=(TextView) findViewById(R.id.VlblRemarks);
        txtRemarks=(EditText) findViewById(R.id.input_remarks);

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

        initListener();
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
                return new DatePickerDialog(this, mDateSetListener,g.mYear,g.mMonth-1,g.mDay);
            case TIME_DIALOG:
                return new TimePickerDialog(this, timePickerListener, hour, minute,false);
        }
        return null;
    }
    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
            hour = selectedHour; minute = selectedMinute;
            EditText tpTime;


            //  tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

        }
    };

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year; mMonth = monthOfYear+1; mDay = dayOfMonth;
            EditText dtpDate;


            dtpDate = (EditText)findViewById(R.id.dtpVisitDT);
            if (VariableID.equals("btnVisitDT"))
            {
                dtpDate = (EditText)findViewById(R.id.dtpVisitDT);
            }
            dtpDate.setText(new StringBuilder()
                    .append(Global.Right("00"+mDay,2)).append("/")
                    .append(Global.Right("00"+mMonth,2)).append("/")
                    .append(mYear));
        }
    };

    public void saveVisitPlan(){
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });


    }


    public void initListener(){
        spinnerClientType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                if (s.equals("Individual")){
                    secMobileNo.setVisibility(View.VISIBLE);
                }else{
                    secMobileNo.setVisibility(View.GONE);

                }
            }
        });

        spinnerProductType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

            }
        });

        spinnerArea.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

            }
        });

        spinnerPurposeOfVisit.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

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