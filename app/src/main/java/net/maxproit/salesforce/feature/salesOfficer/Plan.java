
 package net.maxproit.salesforce.feature.salesOfficer;


 //Android Manifest Code
 //<activity android:name=".Plan" android:label="Plan" />
 import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
 import net.maxproit.salesforce.R;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
 //import Common.*;

 public class Plan extends Activity {
    boolean networkAvailable=false;
    Location currentLocation; 
    double currentLatitude,currentLongitude; 
    //Disabled Back/Home key
    //--------------------------------------------------------------------------------------------------
    @Override 
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME) 
             { return false; }
        else { return true;  }
    }
    String VariableID;
    private int hour;
    private int minute;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

   // Connection C;
   // Global g;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
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

    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
   // MySharedPreferences sp;

    Bundle IDbundle;
    static String MOBILENO = "";

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.plan);
        // C = new Connection(this);
        // g = Global.getInstance();
//
        // STARTTIME = g.CurrentTime24();
        // DEVICEID  = sp.getValue(this, "deviceid");
        // ENTRYUSER = sp.getValue(this, "userid");

        // IDbundle = getIntent().getExtras();
        // MOBILENO = IDbundle.getString("MobileNo");

         TableName = "Plan";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         lblHeading = (TextView)findViewById(R.id.lblHeading);

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Plan.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secClientType=(LinearLayout)findViewById(R.id.secClientType);
         lineClientType=(View)findViewById(R.id.lineClientType);
         VlblClientType=(TextView) findViewById(R.id.VlblClientType);
         spnClientType=(Spinner) findViewById(R.id.spnClientType);
         List<String> listClientType = new ArrayList<String>();
         
         listClientType.add("");
         listClientType.add("1-Individual");
         listClientType.add("2-Developer");
         listClientType.add("3-Vendor");
         listClientType.add("4-Corporate House");
         ArrayAdapter<String> adptrClientType= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listClientType);
         spnClientType.setAdapter(adptrClientType);

         secMobileNo=(LinearLayout)findViewById(R.id.secMobileNo);
         lineMobileNo=(View)findViewById(R.id.lineMobileNo);
         VlblMobileNo=(TextView) findViewById(R.id.VlblMobileNo);
         txtMobileNo=(EditText) findViewById(R.id.txtMobileNo);
         secProductType=(LinearLayout)findViewById(R.id.secProductType);
         lineProductType=(View)findViewById(R.id.lineProductType);
         VlblProductType=(TextView) findViewById(R.id.VlblProductType);
         spnProductType=(Spinner) findViewById(R.id.spnProductType);
         List<String> listProductType = new ArrayList<String>();
         
         listProductType.add("");
         listProductType.add("1-Home Loan");
         listProductType.add("2-Car Loan");
         listProductType.add("3-Personal Loan");
         listProductType.add("4-Deposit");
         listProductType.add("5-Investment");
         ArrayAdapter<String> adptrProductType= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listProductType);
         spnProductType.setAdapter(adptrProductType);

         secArea=(LinearLayout)findViewById(R.id.secArea);
         lineArea=(View)findViewById(R.id.lineArea);
         VlblArea=(TextView) findViewById(R.id.VlblArea);
         spnArea=(Spinner) findViewById(R.id.spnArea);
         List<String> listArea = new ArrayList<String>();
         
         listArea.add("");
         listArea.add("1-syd");
         ArrayAdapter<String> adptrArea= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listArea);
         spnArea.setAdapter(adptrArea);

         secPurpose=(LinearLayout)findViewById(R.id.secPurpose);
         linePurpose=(View)findViewById(R.id.linePurpose);
         VlblPurpose=(TextView) findViewById(R.id.VlblPurpose);
         spnPurpose=(Spinner) findViewById(R.id.spnPurpose);
         List<String> listPurpose = new ArrayList<String>();
         
         listPurpose.add("");
         listPurpose.add("1-Fresh");
         listPurpose.add("2-Lead Generation");
         listPurpose.add("3- Relationship Mgt");
         listPurpose.add("4- Pre-Disbursement");
         listPurpose.add("5- Post Disbursement");
         ArrayAdapter<String> adptrPurpose= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPurpose);
         spnPurpose.setAdapter(adptrPurpose);

         secVisitDT=(LinearLayout)findViewById(R.id.secVisitDT);
         lineVisitDT=(View)findViewById(R.id.lineVisitDT);
         VlblVisitDT=(TextView) findViewById(R.id.VlblVisitDT);
         dtpVisitDT=(EditText) findViewById(R.id.dtpVisitDT);
         secRemarks=(LinearLayout)findViewById(R.id.secRemarks);
         lineRemarks=(View)findViewById(R.id.lineRemarks);
         VlblRemarks=(TextView) findViewById(R.id.VlblRemarks);
         txtRemarks=(EditText) findViewById(R.id.txtRemarks);
/*

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
*/


         //Hide all skip variables


        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) { 
            DataSave();
        }});
     }
     catch(Exception  e)
     {
         //Connection.MessageBox(Plan.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {
 /*
         String DV="";

         if(spnClientType.getSelectedItemPosition()==0  & secClientType.isShown())
           {
             Connection.MessageBox(Plan.this, "Required field: Client Type.");
             spnClientType.requestFocus(); 
             return;	
           }
         else if(txtMobileNo.getText().toString().length()==0 & secMobileNo.isShown())
           {
             Connection.MessageBox(Plan.this, "Required field: Mobile No.");
             txtMobileNo.requestFocus(); 
             return;	
           }
         else if(spnProductType.getSelectedItemPosition()==0  & secProductType.isShown())
           {
             Connection.MessageBox(Plan.this, "Required field: Product Type.");
             spnProductType.requestFocus(); 
             return;	
           }
         else if(spnArea.getSelectedItemPosition()==0  & secArea.isShown())
           {
             Connection.MessageBox(Plan.this, "Required field: Area.");
             spnArea.requestFocus(); 
             return;	
           }
         else if(spnPurpose.getSelectedItemPosition()==0  & secPurpose.isShown())
           {
             Connection.MessageBox(Plan.this, "Required field: Purpose of Visit.");
             spnPurpose.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpVisitDT.getText().toString());
         if(DV.length()!=0 & secVisitDT.isShown())
           {
             Connection.MessageBox(Plan.this, DV);
             dtpVisitDT.requestFocus(); 
             return;	
           }
         else if(txtRemarks.getText().toString().length()==0 & secRemarks.isShown())
           {
             Connection.MessageBox(Plan.this, "Required field: Remarks.");
             txtRemarks.requestFocus(); 
             return;	
           }
 
         String SQL = "";
         RadioButton rb;

         Plan_DataModel objSave = new Plan_DataModel();
         objSave.setClientType((spnClientType.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnClientType.getSelectedItem().toString(), "-")));
         objSave.setMobileNo(txtMobileNo.getText().toString());
         objSave.setProductType((spnProductType.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnProductType.getSelectedItem().toString(), "-")));
         objSave.setArea((spnArea.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnArea.getSelectedItem().toString(), "-")));
         objSave.setPurpose((spnPurpose.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnPurpose.getSelectedItem().toString(), "-")));
         objSave.setVisitDT(dtpVisitDT.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpVisitDT.getText().toString()) : dtpVisitDT.getText().toString());
         objSave.setRemarks(txtRemarks.getText().toString());
         objSave.setEnDt(Global.DateTimeNowYMDHMS());
         objSave.setStartTime(STARTTIME);
         objSave.setEndTime(g.CurrentTime24());
         objSave.setDeviceID(DEVICEID);
         objSave.setEntryUser(ENTRYUSER); //from data entry user list
         objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
         //objSave.setLat(Double.toString(currentLatitude));
         //objSave.setLon(Double.toString(currentLongitude));

         String status = objSave.SaveUpdateData(this);
         if(status.length()==0) {
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(Plan.this, "Saved Successfully");
         }
         else{
             Connection.MessageBox(Plan.this, status);
             return;
         }*/
     }
     catch(Exception  e)
     {
         //Connection.MessageBox(Plan.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String MobileNo)
     {
       try
        {
     
          /* RadioButton rb;
           Plan_DataModel d = new Plan_DataModel();
           String SQL = "Select * from "+ TableName +"  Where MobileNo='"+ MobileNo +"'";
           List<Plan_DataModel> data = d.SelectAll(this, SQL);
           for(Plan_DataModel item : data){
             spnClientType.setSelection(Global.SpinnerItemPositionAnyLength(spnClientType, item.getClientType()));
             txtMobileNo.setText(item.getMobileNo());
             spnProductType.setSelection(Global.SpinnerItemPositionAnyLength(spnProductType, item.getProductType()));
             spnArea.setSelection(Global.SpinnerItemPositionAnyLength(spnArea, item.getCity()));
             spnPurpose.setSelection(Global.SpinnerItemPositionAnyLength(spnPurpose, item.getPurpose()));
             dtpVisitDT.setText(item.getVisitDT().toString().length()==0 ? "" : Global.DateConvertDMY(item.getVisitDT()));
             txtRemarks.setText(item.getRemarks());
           }*/
        }
        catch(Exception  e)
        {
           // Connection.MessageBox(Plan.this, e.getMessage());
            return;
        }
     }



 protected Dialog onCreateDialog(int id) {
   final Calendar c = Calendar.getInstance();
   hour = c.get(Calendar.HOUR_OF_DAY);
   minute = c.get(Calendar.MINUTE);
   switch (id) {
       case DATE_DIALOG:
           //return new DatePickerDialog(this, mDateSetListener,g.mYear,g.mMonth-1,g.mDay);
       case TIME_DIALOG:
         //  return new TimePickerDialog(this, timePickerListener, hour, minute,false);
       }
     return null;
 }

 private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
      mYear = year; mMonth = monthOfYear+1; mDay = dayOfMonth;
      EditText dtpDate;

/*
              dtpDate = (EditText)findViewById(R.id.dtpVisitDT);
             if (VariableID.equals("btnVisitDT"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpVisitDT);
              }
      dtpDate.setText(new StringBuilder()
      .append(Global.Right("00"+mDay,2)).append("/")
      .append(Global.Right("00"+mMonth,2)).append("/")
      .append(mYear));*/
      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime;


        //  tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

    }
  };


 //GPS Reading
 //.....................................................................................................
 public void FindLocation() {
 LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

 LocationListener locationListener = new LocationListener() {
     public void onLocationChanged(Location location) {
         updateLocation(location);
     }
     public void onStatusChanged(String provider, int status, Bundle extras) {
     }
     public void onProviderEnabled(String provider) {
     }
     public void onProviderDisabled(String provider) {
     }
   };
 // locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
 }

 void updateLocation(Location location) {
     currentLocation  = location;
     currentLatitude  = currentLocation.getLatitude();
     currentLongitude = currentLocation.getLongitude();
 }


 // Method to turn on GPS
 public void turnGPSOn(){
     try
     {
       /*  String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
         if(!provider.contains("gps")){ //if gps is disabled
             final Intent poke = new Intent();
             poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
             poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
             poke.setData(Uri.parse("3"));
             sendBroadcast(poke);
         }*/
     }
     catch (Exception e) {
     }
 }
 
 // Method to turn off the GPS
 public void turnGPSOff(){
     String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
 
    /* if(provider.contains("gps")){ //if gps is enabled
         final Intent poke = new Intent();
         poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
         poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
         poke.setData(Uri.parse("3"));
         sendBroadcast(poke);
     }*/
 }
 
 // turning off the GPS if its in on state. to avoid the battery drain.
 @Override
 protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
     turnGPSOff();
 }
}