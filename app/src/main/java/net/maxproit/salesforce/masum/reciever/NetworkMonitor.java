package net.maxproit.salesforce.masum.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.model.api.MyLeadDataModelApi;
import net.maxproit.salesforce.masum.model.api.MyOldLeadApi;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.utility.NetworkUtil;
import net.maxproit.salesforce.network.ApiService;
import net.maxproit.salesforce.network.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NetworkMonitor extends BroadcastReceiver {
    MyLeadDbController myLeadDbController;

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean status = NetworkUtil.getConnectivityStatusString(context);

        if (status) {
         /*   ArrayList<MyNewLead> myLeadList = new ArrayList<>();
            myLeadDbController = new MyLeadDbController(context);
            myLeadList.addAll(myLeadDbController.getDataForSync());

                Log.e("status", "connected");
                myLeadList = new ArrayList<>();
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
                                Log.e("status","save to server");
                            }

                        }

                        @Override
                        public void onFailure(Call<MyOldLeadApi> call, Throwable t) {

                        }
                    });

                }*/
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
        myLeadApi.setUserName("masif");
        myLeadApi.setBranchName("Gulshan");
        myLeadApi.setBranchCode(105);
        myLeadApi.setCustomerName(myNewLead.getUserName());
        myLeadApi.setCustomerId(0);
        myLeadApi.setProfession(myNewLead.getProfession());
        myLeadApi.setOrganization(myNewLead.getOrganization());
        myLeadApi.setDesignation(myNewLead.getDesignation());
        myLeadApi.setMobileNumberId(0);
        myLeadApi.setMobileNumber(myNewLead.getPhone());
        myLeadApi.setAddressId(0);
        myLeadApi.setAddress("53, Bay's Galleria, Gulshan-1, Dhaka");
        myLeadApi.setSourceOfReference("string");
        myLeadApi.setProductId(8);
        myLeadApi.setProduct("Home Loan");
        myLeadApi.setProductSubCategoryId(34);
        myLeadApi.setProductSubCategory("Apartment purchase");
        myLeadApi.setLoanAmount(Integer.valueOf(myNewLead.getLoanAmount().replace(",","")));
        myLeadApi.setOfferedInterestRate(Integer.valueOf(myNewLead.getOrInterest()));
        myLeadApi.setOfferedProcessFee(Integer.valueOf(myNewLead.getOpFee()));
        myLeadApi.setDisbursementDate(myNewLead.getDisDate());
        myLeadApi.setVisitId(0);
        myLeadApi.setFollowUp("yes");
        myLeadApi.setFollowUpDate(myNewLead.getVisitDate());
        myLeadApi.setRemark("re");
        myLeadApi.setLeadReferenceNo("");


        return myLeadApi;
    }
}

