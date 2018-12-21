package net.maxproit.salesforce;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityMyPerformancePhaseTwoBinding;
import net.maxproit.salesforce.masum.adapter.myperformacecountadapter.MyPerformanceItemAdapter;
import net.maxproit.salesforce.masum.model.api.performance.Datum;
import net.maxproit.salesforce.masum.model.api.performance.Getperformance;
import net.maxproit.salesforce.masum.model.local.MyPerformanceModel;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerformancePhaseTwo extends BaseActivity implements View.OnClickListener {

    private ActivityMyPerformancePhaseTwoBinding mBinding;

    MyPerformanceItemAdapter myActivityAdapter, myLeadAdapter, myProspectAdapter;
    private ArrayList<MyPerformanceModel> activity;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_performance_phase_two;
    }

    @Override
    protected void initComponents() {
        initVariable();
        //initView();
        initListener();
        //setAllData();
    }

    @Override
    protected void getIntentData() {

    }

    private void initView() {
/*
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
        btnCrm.setOnClickListener(this);*/


    }

    private void initVariable() {
        mBinding = (ActivityMyPerformancePhaseTwoBinding) getBinding();
        activity = new ArrayList<>();
     /*   leadDbController = new MyLeadDbController(this);
        visitPlanDbController = new VisitPlanDbController(this);
        allVisitPlanList = new ArrayList<>();
        upComingPLanList = new ArrayList<>();
        Log.e("after date", DateUtils.afterAMonth());
        Log.e("before date", DateUtils.beforeAMonth());
        visitPlanDbController.getDateBetween(DateUtils.beforeAMonth(), DateUtils.afterAMonth());*/


        callApi();

    }

    private void callApi() {

        if (isNetworkAvailable()) {
            String username = SharedPreferencesEnum.getInstance(getApplicationContext()).getString(SharedPreferencesEnum.Key.USER_NAME);
            String random = UUID.randomUUID().toString();
            showProgressDialog();
            getApiService().getPerformaceCountData(username, random).enqueue(new Callback<Getperformance>() {
                @Override
                public void onResponse(Call<Getperformance> call, Response<Getperformance> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            myLeadAdapter = new MyPerformanceItemAdapter(MyPerformancePhaseTwo.this, (ArrayList<Datum>) response.body().getData());
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mBinding.recycleViewMyPerformace.setLayoutManager(mLayoutManager);
                            mBinding.recycleViewMyPerformace.setAdapter(myLeadAdapter);
                            myLeadAdapter.notifyDataSetChanged();
                            hideProgressDialog();
                        } else {
                            showAlertDialog(response.body().getStatus(), response.body().getMessage());
                            hideProgressDialog();
                        }
                    }
                    else{
                        showAlertDialog("Error", response.errorBody().toString());
                        hideProgressDialog();

                    }
                }


                @Override
                public void onFailure(Call<Getperformance> call, Throwable t) {
                    showAlertDialog("Error",t.getMessage());
                    hideProgressDialog();
                }
            });
        }
    }

    private void initListener() {
        mBinding.btnBack.setOnClickListener(view -> {
            MyPerformancePhaseTwo.super.onBackPressed();
            finish();
        });


    }

    private void setAllData() {
  /*      if (!allVisitPlanList.isEmpty()) {
            allVisitPlanList.clear();
        }

        if (!upComingPLanList.isEmpty()) {
            allVisitPlanList.clear();
        }
        int unexPLan = visitPlanDbController.getPreviousData(DateUtils.getDateString()).size();

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
        });*/

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {

      /*      case R.id.btn_unx_plan:
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
                break;*/
        }

    }
}
