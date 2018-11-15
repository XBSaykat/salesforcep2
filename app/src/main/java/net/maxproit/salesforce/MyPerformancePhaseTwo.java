package net.maxproit.salesforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.feature.salesOfficer.myPerfomance.MyPerfomanceActivity;
import net.maxproit.salesforce.masum.activity.lead.MyLeadActivity;
import net.maxproit.salesforce.masum.activity.visitplan.VisitPlanListActivity;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.fragment.myactivity.FragmentPreViousList;
import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;

public class MyPerformancePhaseTwo extends AppCompatActivity implements View.OnClickListener {

    LinearLayout btnUnexPlan, btnUpComingPlan, btnFreshCall, btnDevVisit, btnPendLead, btnProspectLead, btnCloesdLead, btnPendingPros, btnProcedPros, btnCrm;
    ImageView backBtn;
    TextView tvPendingPLan, tvUpcomingPLan, tvFreshActivity, tvVisitActivity, tvPandingLead, tvPropectLead, tvClosed, tvPendingPros, tvProcedPros, tvProsCRM;
    VisitPlanDbController planDbController;
    MyLeadDbController leadDbController;
    VisitPlanDbController visitPlanDbController;
    ArrayList<VisitPlan> allVisitPlanList, upComingPLanList;
    ArrayList<MyNewProspect> leadList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariable();
        initView();
        initListener();
        setAllData();

    }

    private void initView() {
        setContentView(R.layout.activity_my_performance_phase_two);
        planDbController = new VisitPlanDbController(this);
        leadDbController = new MyLeadDbController(this);
        tvPendingPLan = findViewById(R.id.tv_unex_plan);
        tvUpcomingPLan = findViewById(R.id.tv_up_plan);
        tvFreshActivity = findViewById(R.id.tv_fresh_call);
        tvVisitActivity = findViewById(R.id.tv_dev_visit);
        tvPandingLead = findViewById(R.id.tv_pendinglead);
        tvPropectLead = findViewById(R.id.tv_prospect_lead);
        tvClosed = findViewById(R.id.tv_propect_closed);
        tvPendingPros = findViewById(R.id.tv_pros_unsuc);
        tvProcedPros = findViewById(R.id.tv_prospect_proceed);
        tvProsCRM = findViewById(R.id.tv_propect_crm);
        backBtn = findViewById(R.id.btnBack);

        btnUnexPlan = findViewById(R.id.btn_unx_plan);
        btnUpComingPlan = findViewById(R.id.btnUpComingPlan);
        btnFreshCall = findViewById(R.id.btnFreshCall);
        btnDevVisit = findViewById(R.id.btnDevVisit);
        btnPendLead = findViewById(R.id.btnPendLead);
        btnProspectLead = findViewById(R.id.btnProspectLead);
        btnCloesdLead = findViewById(R.id.btnCloesdLead);
        btnPendingPros = findViewById(R.id.btnPendingPros);
        btnProcedPros = findViewById(R.id.btnProcedPros);
        btnCrm = findViewById(R.id.btnCrm);


        btnUnexPlan.setOnClickListener(this);
        btnUpComingPlan.setOnClickListener(this);
        btnFreshCall.setOnClickListener(this);
        btnDevVisit.setOnClickListener(this);
        btnPendLead.setOnClickListener(this);
        btnProspectLead.setOnClickListener(this);
        btnCloesdLead.setOnClickListener(this);
        btnPendingPros.setOnClickListener(this);
        btnProcedPros.setOnClickListener(this);
        btnCrm.setOnClickListener(this);


    }

    private void initVariable() {
        leadDbController = new MyLeadDbController(this);
        visitPlanDbController = new VisitPlanDbController(this);
        allVisitPlanList = new ArrayList<>();
        upComingPLanList = new ArrayList<>();
        Log.e("after date", DateUtils.afterAMonth());
        Log.e("before date", DateUtils.beforeAMonth());
        visitPlanDbController.getDateBetween(DateUtils.beforeAMonth(), DateUtils.afterAMonth());

    }

    private void initListener() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPerformancePhaseTwo.super.onBackPressed();
                finish();
            }
        });


    }

    private void setAllData() {
        if (!allVisitPlanList.isEmpty()) {
            allVisitPlanList.clear();
        }

        if (!upComingPLanList.isEmpty()) {
            allVisitPlanList.clear();
        }
        int unexPLan = visitPlanDbController.getDateBetween(DateUtils.getDateStringSqLite(), "2018-11-22").size();

        if (!visitPlanDbController.getPlanDataUsingStatus(AppConstant.LEAD_STATUS_New_PLAN).equals(null)) {

            allVisitPlanList.addAll(visitPlanDbController.getPlanDataUsingStatus(AppConstant.LEAD_STATUS_New_PLAN));


            for (int i = 0; i < allVisitPlanList.size(); i++) {

                try {
                    if (DateUtils.isPending(allVisitPlanList.get(i).getDateOfVisit()) == 2) {
                        upComingPLanList.add(allVisitPlanList.get(i));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Toast.makeText(this, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
        }

        int upComing = upComingPLanList.size();
        tvUpcomingPLan.setText("" + upComing);
        tvPendingPLan.setText("" + unexPLan);

        tvFreshActivity.setText("" + planDbController.getPlanDataUsingStatus(AppConstant.STATUS_ACTIVITY).size());
        tvVisitActivity.setText("" + planDbController.getPlanDataUsingStatus(AppConstant.VISITED).size());
        tvPandingLead.setText("" + leadDbController.getAllData().size());
        tvPropectLead.setText("" + leadDbController.getProspectData().size());
        tvClosed.setText("" + leadDbController.getAllData(AppConstant.LEAD_STATUS_REJECT).size());
        tvPendingPros.setText("" + leadDbController.getAllData(AppConstant.STATUS_NEW_PROSPECT).size());
        tvProcedPros.setText("" + leadDbController.getAllData(AppConstant.STATUS_RBM).size());

        tvUpcomingPLan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPerformancePhaseTwo.this, FragmentPreViousList.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {

            case R.id.btn_unx_plan:
                ActivityUtils.getInstance().invokFromPerformance(this, VisitPlanListActivity.class, 1);

                break;
            case R.id.btnUpComingPlan:
                ActivityUtils.getInstance().invokFromPerformance(this, VisitPlanListActivity.class, 2);
                break;
            case R.id.btnFreshCall:
                ActivityUtils.getInstance().invokFromPerformance(this, VisitPlanListActivity.class, 3);
                break;
            case R.id.btnDevVisit:
                ActivityUtils.getInstance().invokFromPerformance(this, VisitPlanListActivity.class, 4);
                break;
            case R.id.btnPendLead:
                ActivityUtils.getInstance().invokFromPerformance(this, MyLeadActivity.class, 1);
                break;
            case R.id.btnProspectLead:
                ActivityUtils.getInstance().invokFromPerformance(this, MyLeadActivity.class, 2);
                break;
            case R.id.btnCloesdLead:
                ActivityUtils.getInstance().invokFromPerformance(this, MyLeadActivity.class, 3);
                break;
            case R.id.btnPendingPros:
                ActivityUtils.getInstance().invokFromPerformance(this, MyLeadActivity.class, 4);
                break;
            case R.id.btnProcedPros:
                ActivityUtils.getInstance().invokFromPerformance(this, MyLeadActivity.class, 5);
                break;
            case R.id.btnCrm:
                //intent=new Intent(this,"");
                break;
            default:
                break;
        }

    }
}
