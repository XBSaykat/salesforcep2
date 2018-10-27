package net.maxproit.salesforce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityDetailsActivity extends AppCompatActivity {

    public TextView tvClientType, tvVisitPurpose, tvClientName, tvMobileNumber, tvProductType,tvCity,tvPoliceStation,
    tvVisitDate, tvRemarks, tvProceedToLead, tvRejected, tvReappointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_details);

        tvClientType = (TextView)findViewById(R.id.tv_activity_details_client_type);
        tvVisitPurpose = (TextView)findViewById(R.id.tv_activity_details_visit_Purpose);
        tvClientType  = (TextView)findViewById(R.id.tv_activity_details_client_type);
        tvClientName = (TextView)findViewById(R.id.tv_activity_details_client_name);
        tvMobileNumber = (TextView)findViewById(R.id.tv_activity_details_mobile_no);
        tvProductType = (TextView)findViewById(R.id.tv_activity_details_product_type);
        tvCity = (TextView)findViewById(R.id.tv_activity_details_city);
        tvPoliceStation = (TextView)findViewById(R.id.tv_activity_details_police_station);
        tvVisitDate = (TextView)findViewById(R.id.tv_activity_details_visit_date);
        tvRemarks = (TextView)findViewById(R.id.tv_activity_details_remarks);
        tvProceedToLead = (TextView)findViewById(R.id.tv_activity_details_proceed_to_lead);
        tvRejected = (TextView)findViewById(R.id.tv_activity_details_rejected);
        tvReappointment = (TextView)findViewById(R.id.tv_activity_details_reappointment);


    }
}
