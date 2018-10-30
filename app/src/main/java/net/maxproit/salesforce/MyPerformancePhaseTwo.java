package net.maxproit.salesforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import net.maxproit.salesforce.feature.masum.MyActivitiesActivity;
import net.maxproit.salesforce.feature.masum.MyActivitiesActivityNew;
import net.maxproit.salesforce.feature.masum.MyActivityListFragment;
import net.maxproit.salesforce.feature.salesOfficer.myProspect.MyProspectActivity;
import net.maxproit.salesforce.feature.salesOfficer.mylead.MyLeadActivity;

public class MyPerformancePhaseTwo extends AppCompatActivity {

    LinearLayout myActivitiesPerformance, myLeadsPerformance, myProspectsPerformance;
    ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_performance_phase_two);

        myActivitiesPerformance = (LinearLayout)findViewById(R.id.ll_my_activities_performance);
        myActivitiesPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myActivitiesPerformanceIntent = new Intent(MyPerformancePhaseTwo.this,MyActivitiesActivityNew.class);
                startActivity(myActivitiesPerformanceIntent);
                finish();
            }
        });

        myLeadsPerformance = (LinearLayout)findViewById(R.id.ll_my_leads_performance);
        myLeadsPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myLeadPerformanceIntent = new Intent(MyPerformancePhaseTwo.this,MyLeadActivity.class);
                startActivity(myLeadPerformanceIntent);
                finish();
            }
        });

        myProspectsPerformance = (LinearLayout)findViewById(R.id.ll_my_prospects_performance);
        myProspectsPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myProspectsPerformanceIntent = new Intent(MyPerformancePhaseTwo.this,MyProspectActivity.class);
                startActivity(myProspectsPerformanceIntent);
                finish();
            }
        });

        backBtn = (ImageView)findViewById(R.id.btnBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPerformancePhaseTwo.super.onBackPressed();
                finish();
            }
        });

    }
}
