package net.maxproit.salesforce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import net.maxproit.salesforce.feature.salesOfficer.myProspect.adapter.MyNewProspectAdapterRBM;
import net.maxproit.salesforce.listener.OnItemClickListener;
import net.maxproit.salesforce.model.MyNewProspect;
import net.maxproit.salesforce.model.newlead.MyNewLead;
import net.maxproit.salesforce.sqlite.MyLeadDbController;

import java.util.ArrayList;

public class SupervisorRbmProspect extends AppCompatActivity {

    ArrayList<MyNewProspect> prospectArrayList, filterList;
    ArrayList<MyNewLead> myNewLeadList;

    MyNewProspectAdapterRBM myAdapter;
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
        myNewLeadList = new ArrayList<>();


        myLeadDbController = new MyLeadDbController(this);
        if (!prospectArrayList.isEmpty()){
            prospectArrayList.clear();
        }
        if (!myNewLeadList.isEmpty()){
            myNewLeadList.clear();
        }



        prospectArrayList.addAll(myLeadDbController.myNewProspectGetAllData());
        myNewLeadList.addAll(myLeadDbController.getProspectData());

//        myAdapter = new MyNewProspectAdapterRBM(this, prospectArrayList);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        rvProspect.setLayoutManager(mLayoutManager);
//        rvProspect.setAdapter(myAdapter);
//        initListener();

    }

    private void initListener() {

        myAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                Toast.makeText(SupervisorRbmProspect.this, "HI....", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
