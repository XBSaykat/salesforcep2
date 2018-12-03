package net.maxproit.salesforce.masum.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.model.api.lead.Data;
import net.maxproit.salesforce.masum.model.api.lead.MyLeadDataModelApi;
import net.maxproit.salesforce.masum.model.api.lead.MyOldLeadApi;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.masum.utility.NetworkUtil;
import net.maxproit.salesforce.network.ApiService;
import net.maxproit.salesforce.network.RestClient;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NetworkMonitor extends BroadcastReceiver {
    MyLeadDbController myLeadDbController;
    String userName=null;

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean status = NetworkUtil.getConnectivityStatusString(context);
        if (status) {
            userName = localCash(context).getString(SharedPreferencesEnum.Key.USER_NAME);
            localCash(context).put(SharedPreferencesEnum.Key.USER_NAME_PER, userName);
            ArrayList<MyNewLead> myLeadList = new ArrayList<>();

                Log.e("status", "connected");
                myLeadDbController = new MyLeadDbController(context);
                myLeadList.addAll(myLeadDbController.getDataForSync());
                for (int i = 0; i < myLeadList.size(); i++) {
                    MyNewLead myNewLead = myLeadList.get(i);
                    MyLeadDataModelApi myLeadDataModelApi = myLeadDataModelApi(myNewLead);
                    getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                        @Override
                        public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                            Log.e("status","call to server");
                            if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                myLeadDbController.updateSyncDataStatus(myNewLead.getId(),AppConstant.SYNC_STATUS_OK);
                                Data data=response.body().getData();
                                int insert = myLeadDbController.updateLeadData(userName, myNewLead.getRefNumber(), data.getCustomerId(), data.getMobileNumberId(), data.getVisitId(), data.getAddressId(), data.getBranchCode(), data.getProductId(), data.getProductSubCategoryId(), data.getBranchName(), data.getCustomerName()
                                        , data.getProfession(), data.getOrganization(),
                                        data.getDesignation(), data.getMobileNumber(), data.getAddress(), data.getSourceOfReference(),
                                        data.getProduct(), data.getProductSubCategory(),
                                        String.valueOf(data.getLoanAmount()),String.valueOf(data.getOfferedInterestRate()) ,String.valueOf(data.getOfferedProcessFee()) , myNewLead.getDisDate(), myNewLead.getVisitDate(), myLeadDataModelApi.getFollowUp(), data.getRemark(), AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_OK);
                                Log.e("status","save to server");
                            }

                        }

                        @Override
                        public void onFailure(Call<MyOldLeadApi> call, Throwable t) {

                        }
                    });

                }
            } else {
                Log.e("status", "not connected");
            }
        }


    private ApiService getApiService() {
        return RestClient.getInstance().callRetrofit();
    }



    private MyLeadDataModelApi myLeadDataModelApi(MyNewLead myNewLead) {
        MyLeadDataModelApi myLeadApi = new MyLeadDataModelApi();
        myLeadApi.setRmCode("336132");
        myLeadApi.setUserName(myNewLead.getUserID());
        myLeadApi.setBranchName(myNewLead.getBranchName());
        myLeadApi.setBranchCode(myNewLead.getBranchCode());
        myLeadApi.setCustomerName(myNewLead.getUserName());
        myLeadApi.setCustomerId(myNewLead.getCusId());
        myLeadApi.setProfession(myNewLead.getProfession());
        myLeadApi.setOrganization(myNewLead.getOrganization());
        myLeadApi.setDesignation(myNewLead.getDesignation());
        myLeadApi.setMobileNumberId(myNewLead.getMobileId());
        myLeadApi.setMobileNumber(myNewLead.getPhone());
        myLeadApi.setAddressId(myNewLead.getAddressId());
        myLeadApi.setAddress(myNewLead.getAddress());
        myLeadApi.setSourceOfReference(myNewLead.getSourceRef());
        myLeadApi.setProductId(myNewLead.getProductCode());
        myLeadApi.setProduct(myNewLead.getProductType());
        myLeadApi.setProductSubCategoryId(myNewLead.getSubCode());
        myLeadApi.setProductSubCategory(myNewLead.getProductSubcategory());
        myLeadApi.setLoanAmount(Integer.valueOf(myNewLead.getLoanAmount().replace(",","")));
        myLeadApi.setOfferedInterestRate(Integer.valueOf(myNewLead.getOrInterest()));
        myLeadApi.setOfferedProcessFee(Integer.valueOf(myNewLead.getOpFee()));
        myLeadApi.setDisbursementDate(DateUtils.getDateFormateForSqlite(myNewLead.getDisDate()));
        myLeadApi.setVisitId(myNewLead.getVisitId());
        myLeadApi.setFollowUp(myNewLead.getFollowUp());
        myLeadApi.setFollowUpDate(DateUtils.getDateFormateForSqlite(myNewLead.getVisitDate()));
        myLeadApi.setRemark(myNewLead.getRemark());
        myLeadApi.setLeadReferenceNo(myNewLead.getRefNumber());


        return myLeadApi;
    }


    public SharedPreferencesEnum localCash(Context context) {
        return SharedPreferencesEnum.getInstance(context);
    }

}

