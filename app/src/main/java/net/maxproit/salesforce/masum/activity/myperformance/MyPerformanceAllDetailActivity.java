package net.maxproit.salesforce.masum.activity.myperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityMyPerformanceAllDetailBinding;
import net.maxproit.salesforce.masum.activity.lead.MyLeadActivity;
import net.maxproit.salesforce.masum.activity.visitplan.VisitPLanDetailsActivity;
import net.maxproit.salesforce.masum.adapter.MyPerformanceAllDetailsAdapter;
import net.maxproit.salesforce.masum.adapter.MyPerformanceDetailsDataAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.model.api.lead.Data;
import net.maxproit.salesforce.masum.model.api.lead.MyLeadByRefApi;
import net.maxproit.salesforce.masum.model.api.myactivity.MyActivityGetByJournalIdApi;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.model.local.MyPerformanceModel;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.model.myprospect.updatemyprospect.OldProspect;
import net.maxproit.salesforce.util.CommonUtil;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerformanceAllDetailActivity extends BaseActivity {
    ActivityMyPerformanceAllDetailBinding binding;
    private ArrayList<MyPerformanceModel> myPerformanceDataModelList;
    private MyPerformanceAllDetailsAdapter myPerformanceAllDetailsAdapter;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_performance_all_detail;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityMyPerformanceAllDetailBinding) getBinding();
        myPerformanceDataModelList = new ArrayList<>();
        String head = getIntent().getStringExtra(AppConstant.INTENT_DATA1);
        String id = getIntent().getStringExtra(AppConstant.INTENT_DATA2);
        myPerformanceAllDetailsAdapter = new MyPerformanceAllDetailsAdapter(this, myPerformanceDataModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recycleView.setLayoutManager(mLayoutManager);
        binding.recycleView.setAdapter(myPerformanceAllDetailsAdapter);
        callApi(head, id);

    }

    private void callApi(String head, String id) {
        String random = UUID.randomUUID().toString();
        if (isNetworkAvailable()) {
            if (!myPerformanceDataModelList.isEmpty()) {
                myPerformanceDataModelList.clear();
            }
            showProgressDialog();
            if (head.equalsIgnoreCase("Lead")) {
                callLeadData(id, random);

            } else if (head.equalsIgnoreCase("Activity")) {
                callActivityData(id, random);

            } else if (head.equalsIgnoreCase("Prospect")) {
                callProspectData(id, random);
            }
        }

    }


    private void callLeadData(String id, String random) {
        getApiService().getLeadDataByRef(id, random).enqueue(new Callback<MyLeadByRefApi>() {
            @Override
            public void onResponse(Call<MyLeadByRefApi> call, Response<MyLeadByRefApi> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        if (response.body().getData() != null) {
                            Data data = response.body().getData();
                            setLeadData(data);
                            hideProgressDialog();
                        } else showEmptyView();
                    } else {
                        showAlertDialog(getResources().getString(R.string.error_text), response.body().getMessage());
                    }
                } else
                    showAlertDialog(getResources().getString(R.string.error_text), response.message());

            }

            @Override
            public void onFailure(Call<MyLeadByRefApi> call, Throwable t) {
                showAlertDialog(getResources().getString(R.string.error_text), t.getMessage());

            }
        });
    }

    private void setLeadData(Data data) {
        myPerformanceDataModelList.add(new MyPerformanceModel("address", data.getAddress()));
        myPerformanceDataModelList.add(new MyPerformanceModel("branchName", data.getBranchName()));
        myPerformanceDataModelList.add(new MyPerformanceModel("city", data.getCity()));
        myPerformanceDataModelList.add(new MyPerformanceModel("customerName", data.getCustomerName()));
        myPerformanceDataModelList.add(new MyPerformanceModel("designation", data.getDesignation()));
        myPerformanceDataModelList.add(new MyPerformanceModel("disbursementDate", DateUtils.jsonToDate(data.getDisbursementDate())));
        myPerformanceDataModelList.add(new MyPerformanceModel("followUp", data.getFollowUp()));
        myPerformanceDataModelList.add(new MyPerformanceModel("followUpDate", DateUtils.jsonToDate(data.getFollowUpDate())));
        myPerformanceDataModelList.add(new MyPerformanceModel("leadReferenceNo", data.getLeadReferenceNo()));
        myPerformanceDataModelList.add(new MyPerformanceModel("loanAmount", "" + data.getLoanAmount()));
        myPerformanceDataModelList.add(new MyPerformanceModel("mobileNumber", data.getMobileNumber()));
        myPerformanceDataModelList.add(new MyPerformanceModel("offeredInterestRate", "" + data.getOfferedInterestRate()));
        myPerformanceDataModelList.add(new MyPerformanceModel("offeredProcessFee", "" + data.getOfferedProcessFee()));
        myPerformanceDataModelList.add(new MyPerformanceModel("organization", data.getOrganization()));
        myPerformanceDataModelList.add(new MyPerformanceModel("product", data.getProduct()));
        myPerformanceDataModelList.add(new MyPerformanceModel("productSubCategory", data.getProductSubCategory()));
        myPerformanceDataModelList.add(new MyPerformanceModel("profession", data.getProfession()));
        myPerformanceDataModelList.add(new MyPerformanceModel("ps", data.getPs()));
        myPerformanceDataModelList.add(new MyPerformanceModel("remark", data.getRemark()));
        myPerformanceDataModelList.add(new MyPerformanceModel("rmCode", data.getRmCode()));
        myPerformanceDataModelList.add(new MyPerformanceModel("sourceOfReference", data.getSourceOfReference()));
        myPerformanceDataModelList.add(new MyPerformanceModel("status", data.getStatus()));
        myPerformanceDataModelList.add(new MyPerformanceModel("userName", data.getUserName()));
        myPerformanceAllDetailsAdapter.notifyDataSetChanged();
    }

    private void callActivityData(String id, String random) {
        getApiService().getActivityByJournalId(id, random).enqueue(new Callback<MyActivityGetByJournalIdApi>() {
            @Override
            public void onResponse(Call<MyActivityGetByJournalIdApi> call, Response<MyActivityGetByJournalIdApi> response) {
                if (response.body().getCode().equals("200")) {
                    if (response.body().getData() != null) {
                        net.maxproit.salesforce.masum.model.api.myactivity.Data data = response.body().getData();
                        sentActivityData(data);
                        hideProgressDialog();
                    } else {
                        showEmptyView();
                    }
                } else showAlertDialog(response.body().getCode(), response.body().getMessage());
            }

            @Override
            public void onFailure(Call<MyActivityGetByJournalIdApi> call, Throwable t) {
                showEmptyView();
                showAlertDialog("Error", t.getMessage());
            }
        });
    }

    private void sentActivityData(net.maxproit.salesforce.masum.model.api.myactivity.Data data) {
        myPerformanceDataModelList.add(new MyPerformanceModel("clientType", data.getClientType()));
        myPerformanceDataModelList.add(new MyPerformanceModel("customerName", data.getCustomerName()));
        myPerformanceDataModelList.add(new MyPerformanceModel("city", data.getCity()));
        myPerformanceDataModelList.add(new MyPerformanceModel("product", data.getProductType()));
        myPerformanceDataModelList.add(new MyPerformanceModel("ps", data.getPs()));
        myPerformanceDataModelList.add(new MyPerformanceModel("activityDate", data.getActivityDate()));
        myPerformanceDataModelList.add(new MyPerformanceModel("remark", data.getRemarks()));
        myPerformanceDataModelList.add(new MyPerformanceModel("follow up remark", data.getFollowupRemarks()));
        myPerformanceDataModelList.add(new MyPerformanceModel("followUpDate", data.getFollowupDate()));
        myPerformanceDataModelList.add(new MyPerformanceModel("status", data.getActivityStatus()));
        myPerformanceDataModelList.add(new MyPerformanceModel("userName", data.getMaker()));
        myPerformanceDataModelList.add(new MyPerformanceModel("mobileNo", data.getMobileNo()));
        myPerformanceAllDetailsAdapter.notifyDataSetChanged();
    }

    private void callProspectData(String id, String random) {
        getApiService().getNewProspect(id, random).enqueue(new Callback<OldProspect>() {
            @Override
            public void onResponse(Call<OldProspect> call, Response<OldProspect> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        if (response.body().getData() != null) {
                            OldProspect oldProspect = response.body();
                            // sentProspectData(oldProspect);
                            // ActivityUtils.invokLeadDetailForProspectStage(getActivity(), oldProspect.getMyNewProspect());

                        } else {
                            showAlertDialog("Error", "Server Error");
                            hideLoader();
                        }
                    } else {
                        showAlertDialog("Error", response.body().getMessage());
                        hideLoader();
                    }

                } else {
                    showAlertDialog("Error", response.message());
                    hideLoader();
                }

            }

            @Override
            public void onFailure(Call<OldProspect> call, Throwable t) {
                showAlertDialog("Error", t.getMessage());
                hideLoader();
            }
        });

    }

  /*  private void sentProspectData(OldProspect data) {
        myPerformanceDataModelList.add(new MyPerformanceModel("permanent Address",data.getData().getPermanentAddress()));
        myPerformanceDataModelList.add(new MyPerformanceModel("present Address",data.getData().getPresentAddress()));
        myPerformanceDataModelList.add(new MyPerformanceModel("branchName",data.getData().getBranchName()));
        myPerformanceDataModelList.add(new MyPerformanceModel("permanent city",data.getData().getPermanentAddressCity()));
        myPerformanceDataModelList.add(new MyPerformanceModel("present city",data.getData().getPresentAddressCity()));
        myPerformanceDataModelList.add(new MyPerformanceModel("customerName",data.getData().getCustomerName()));
        myPerformanceDataModelList.add(new MyPerformanceModel("designation",data.getData().getDesignation()));
        myPerformanceDataModelList.add(new MyPerformanceModel("leadReferenceNo",data.getData().getLeadReferenceNo()));
        myPerformanceDataModelList.add(new MyPerformanceModel("mobileNumber",data.getData().getMobileNo()));
        myPerformanceDataModelList.add(new MyPerformanceModel("offeredInterestRate",""+data.getData().getIntersetRate()));
        myPerformanceDataModelList.add(new MyPerformanceModel("offeredProcessFee",""+data.getData().getFee()));
        myPerformanceDataModelList.add(new MyPerformanceModel("product",data.getData().getProduct()));
        myPerformanceDataModelList.add(new MyPerformanceModel("productSubCategory",data.getData().getProductSubCategory()));
        myPerformanceDataModelList.add(new MyPerformanceModel("profession",data.getData().getProfession()));
        myPerformanceDataModelList.add(new MyPerformanceModel("per ps",data.getData().getPermanentAddressPS()));
        myPerformanceDataModelList.add(new MyPerformanceModel("pre ps",data.getData().getPresentAddressPS()));
        myPerformanceDataModelList.add(new MyPerformanceModel("rmCode",data.getData().getRmCode()));
        myPerformanceDataModelList.add(new MyPerformanceModel("status",data.getData().getStatus()));
        myPerformanceDataModelList.add(new MyPerformanceModel("segment",data.getData().getSegment()));
        myPerformanceDataModelList.add(new MyPerformanceModel("dateOfBirth",DateUtils.jsonToDate(data.getData().getDateOfBirth())));
        myPerformanceDataModelList.add(new MyPerformanceModel("districtOfBirth",data.getData().getDistrictOfBirth()));
        myPerformanceDataModelList.add(new MyPerformanceModel("countryOfBirth",data.getData().getCountryOfBirth()));
        myPerformanceDataModelList.add(new MyPerformanceModel("photoIdNumber",data.getData().getPhotoIdNumber()));
        myPerformanceDataModelList.add(new MyPerformanceModel("photoIdIssueDate",DateUtils.jsonToDate(data.getData().getUserName())));
        myPerformanceDataModelList.add(new MyPerformanceModel("eTin",data.getData().getETin()));
        myPerformanceDataModelList.add(new MyPerformanceModel("fatherName",data.getData().getFatherName()));
        myPerformanceDataModelList.add(new MyPerformanceModel("motherName",data.getData().getMotherName()));
        myPerformanceDataModelList.add(new MyPerformanceModel("spouseName",data.getData().getSpouseName()));
        myPerformanceDataModelList.add(new MyPerformanceModel("company",data.getData().getCompany()));
        myPerformanceDataModelList.add(new MyPerformanceModel("currentJobDuration",data.getData().getCurrentJobDuration()));
        myPerformanceDataModelList.add(new MyPerformanceModel("relationshipWithApplicant",data.getData().getRelationshipWithApplicant()));
        myPerformanceDataModelList.add(new MyPerformanceModel("netSalaryType",data.getData().getNetSalaryType()));
        myPerformanceDataModelList.add(new MyPerformanceModel("net salary",""+data.getData().getNetSalary()));
        myPerformanceDataModelList.add(new MyPerformanceModel("net salary",""+data.getData().getNetSalary()));
        myPerformanceDataModelList.add(new MyPerformanceModel("net salary",""+data.getData().getNetSalary()));
        myPerformanceDataModelList.add(new MyPerformanceModel("net salary",""+data.getData().getNetSalary()));
        myPerformanceDataModelList.add(new MyPerformanceModel("net salary",""+data.getData().getNetSalary()));
        myPerformanceDataModelList.add(new MyPerformanceModel("net salary",""+data.getData().getNetSalary()));
        myPerformanceDataModelList.add(new MyPerformanceModel("net salary",""+data.getData().getNetSalary()));
        myPerformanceDataModelList.add(new MyPerformanceModel("net salary",""+data.getData().getNetSalary()));
        myPerformanceDataModelList.add(new MyPerformanceModel("net salary",""+data.getData().getNetSalary()));
    }*/

    @Override
    protected void getIntentData() {

    }
}
