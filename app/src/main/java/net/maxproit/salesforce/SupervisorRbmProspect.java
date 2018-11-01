package net.maxproit.salesforce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.maxproit.salesforce.masum.adapter.adapter.MyNewProspectAdapter;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.utility.ActivityUtils;

import java.util.ArrayList;

public class SupervisorRbmProspect extends AppCompatActivity {

    ArrayList<MyNewProspect> prospectArrayList, filterList;

    MyNewProspectAdapter myAdapter;
//    String userName;
//    Bundle extras;
    MyLeadDbController myLeadDbController;
    RecyclerView rvProspect;

//    ArrayList<MyNewLead> leadList, filterList;
//    Button btnAddProspect;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_rbm_prospect);
        rvProspect = findViewById(R.id.rv_supervisor_rbm);
        prospectArrayList = new ArrayList<>();
        filterList = new ArrayList<>();

        myLeadDbController = new MyLeadDbController(this);
        if (!filterList.isEmpty()){
            filterList.clear();
        }

        filterList.addAll(myLeadDbController.myProspectProceedGetAllData());
        myAdapter = new MyNewProspectAdapter(this, filterList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvProspect.setLayoutManager(mLayoutManager);
        rvProspect.setAdapter(myAdapter);
        initListener();

    }

    private void initListener() {

        myAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                sentDataToDetail(position);
            }
        });

    }

    private void sentDataToDetail(int position) {
        MyNewProspect myNewLead=new MyNewProspect(filterList.get(position).getId(),
                filterList.get(position).getBranchName(),
                filterList.get(position).getUserName(),
                filterList.get(position).getProfession(),
                filterList.get(position).getOrganization(),
                filterList.get(position).getDesignation(),
                filterList.get(position).getPhone(),
                filterList.get(position).getAddress(),
                filterList.get(position).getSourceRef(),
                filterList.get(position).getProductType(),
                filterList.get(position).getProductSubcategory(),
                filterList.get(position).getLoanAmount(),
                filterList.get(position).getOrInterest(),
                filterList.get(position).getOpFee(),
                filterList.get(position).getVisitDate(),
                filterList.get(position).getDisDate(),
                filterList.get(position).getFollowUp(),
                filterList.get(position).getRemark(),
                filterList.get(position).getStatus(),
                filterList.get(position).getpLoanType(),
                filterList.get(position).getProductDetail(),
                filterList.get(position).getSegment(),
                filterList.get(position).getAge(),
                filterList.get(position).getDob(),
                filterList.get(position).getCob(),
                filterList.get(position).getpIdNumber(),
                filterList.get(position).getpIssueDate(),
                filterList.get(position).getEtin(),
                filterList.get(position).getfName(),
                filterList.get(position).getmName(),
                filterList.get(position).getsName(),
                filterList.get(position).getExList(),
                filterList.get(position).getCurrentJob(),
                filterList.get(position).getApplicant(),
                filterList.get(position).getpAddress(),
                filterList.get(position).getNetSalary(),
                filterList.get(position).getSalaryAmount(),
                filterList.get(position).getRentIncome(),
                filterList.get(position).getRentIncomeAmount(),
                filterList.get(position).getAg_Income(),
                filterList.get(position).getTution(),
                filterList.get(position).getRemitance(),
                filterList.get(position).getInFdr(),
                filterList.get(position).getfExpense(),
                filterList.get(position).getEmiOther(),
                filterList.get(position).getsValue(),
                filterList.get(position).getLoanReq(),
                filterList.get(position).getLoanTerm(),
                filterList.get(position).getPiRate(),
                filterList.get(position).getFee(),
                filterList.get(position).getMonthlyEmi());
        ActivityUtils.invokProspectRbmViewStage(this,myNewLead);
    }



}
