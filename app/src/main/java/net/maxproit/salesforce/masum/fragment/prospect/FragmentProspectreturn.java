package net.maxproit.salesforce.masum.fragment.prospect;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.adapter.MyReturnProspectAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.model.login.LocalLogin;

import java.util.ArrayList;

public class FragmentProspectreturn extends Fragment {

    LocalLogin localLogin;
    MyReturnProspectAdapter myProspectAdapter;
    String userName;
    Bundle extras;
    MyLeadDbController myLeadDbController;
    RecyclerView recyclerView;
    ArrayList<MyNewProspect> leadList, filterList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_my_activity_list, container, false);
        leadList = new ArrayList<>();
        filterList = new ArrayList<>();
        myLeadDbController = new MyLeadDbController(getActivity());

        if (!leadList.isEmpty()) {
            leadList.clear();
        }

        leadList.addAll(myLeadDbController.myNewProspectGetAllData(AppConstant.STATUS_RETURN_RBM));
        recyclerView=view.findViewById(R.id.rv_my_activity);
        myProspectAdapter = new MyReturnProspectAdapter(getActivity(), leadList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(myProspectAdapter);
        initListener();
        return view;

    }

    public void beginSearching(String s) {
        filterList= getFilterData(leadList,s);
        myProspectAdapter.setFilter(filterList);
    }
    private void initListener() {

        myProspectAdapter.setItemClickListener(new OnItemClickListener() {

            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()){
                    default:
                        sentDataToDetail(position);
                        break;
                }
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
                filterList.get(position).getSegment(),
                filterList.get(position).getDateOfBirth(),
                filterList.get(position).getAge(),
                filterList.get(position).getDob(),
                filterList.get(position).getCob(),
                filterList.get(position).getpIDType(),
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
                filterList.get(position).getBusinessIncomeAmount(),
                filterList.get(position).getApartmentAmount(),
                filterList.get(position).getSemipakaIncome(),
                filterList.get(position).getOfficeSpaceINcome(),
                filterList.get(position).getWireHouseINcome(),
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
                filterList.get(position).getProspectFee()
        );
        ActivityUtils.invokLeadDetailForProspectStage(getActivity(),myNewLead);
    }

    //filter  data
    private ArrayList<MyNewProspect> getFilterData(ArrayList<MyNewProspect> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<MyNewProspect> filteredModelList = new ArrayList<>();
        for (MyNewProspect model : models) {
            final String uName = model.getUserName().toLowerCase();
            final String phone = model.getPhone().toLowerCase();

            if (uName.contains(searchKey) || phone.contains(searchKey)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private void loadFilterData() {
        if (!filterList.isEmpty()) {
            filterList.clear();
        }
        filterList.addAll(myProspectAdapter.getDataList());
    }



}


