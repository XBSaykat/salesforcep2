package net.maxproit.salesforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.maxproit.salesforce.masum.activity.MyActivitiesActivityNew;
import net.maxproit.salesforce.masum.activity.MyProspectActivity;
import net.maxproit.salesforce.masum.mylead.MyLeadActivity;
import net.maxproit.salesforce.masum.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.sqlite.VisitPlanDbController;

public class MyPerformancePhaseTwo extends AppCompatActivity {

    LinearLayout myActivitiesPerformance, myLeadsPerformance, myProspectsPerformance;
    ImageView backBtn;
    TextView tvPlan,tvLead,tvProspect;
    VisitPlanDbController planDbController;
    MyLeadDbController leadDbController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_performance_phase_two);
        planDbController=new VisitPlanDbController(this);
        leadDbController=new MyLeadDbController(this);
        tvPlan=findViewById(R.id.tvActivity);
        tvLead=findViewById(R.id.tvLead);
        tvProspect=findViewById(R.id.tvProspect);

        tvPlan.setText(""+planDbController.getAllData().size());
        tvLead.setText(""+leadDbController.myNewProspectGetAllData().size());
        tvProspect.setText(""+leadDbController.getProspectData().size());


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
