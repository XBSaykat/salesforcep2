package net.maxproit.salesforce.masum.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.model.api.lead.Data;
import net.maxproit.salesforce.masum.model.api.lead.MyLeadDataModelApi;
import net.maxproit.salesforce.masum.model.api.lead.MyOldLeadApi;
import net.maxproit.salesforce.masum.model.api.visitPlan.MyVisitPlanApi;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
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
    VisitPlanDbController visitPlanDbController;
    String userName = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean status = NetworkUtil.getConnectivityStatusString(context);
        if (status) {
            userName = localCash(context).getString(SharedPreferencesEnum.Key.USER_NAME);
            localCash(context).put(SharedPreferencesEnum.Key.USER_NAME_PER, userName);
            ArrayList<MyNewLead> myLeadList = new ArrayList<>();
            ArrayList<VisitPlan> visitPlanList = new ArrayList<>();

            Log.e("status", "connected");
            myLeadDbController = new MyLeadDbController(context);
            visitPlanDbController = new VisitPlanDbController(context);
            myLeadList.addAll(myLeadDbController.getDataForSync());
            try {
                visitPlanList.addAll(visitPlanDbController.getUnSyncData());
            } catch (IllegalArgumentException e) {

            }
            if (myLeadList.size() > 0) {
                for (int i = 0; i < myLeadList.size(); i++) {
                    MyNewLead myNewLead = myLeadList.get(i);
                    MyLeadDataModelApi myLeadDataModelApi = new MyLeadDataModelApi();
                    myLeadDataModelApi.myLeadDataModelApi(myNewLead);
                    getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                        @Override
                        public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                            Log.e("status", "call to server");
                            if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                Data data = response.body().getData();
                                myLeadDbController.updateSyncDataStatus(myNewLead.getId(),
                                        AppConstant.SYNC_STATUS_OK, data.getLeadReferenceNo());
                                Log.e("status", "save to server");
                            }

                        }

                        @Override
                        public void onFailure(Call<MyOldLeadApi> call, Throwable t) {

                        }
                    });

                }
            }

            if (visitPlanList.size() > 0) {
                for (int i = 0; i < visitPlanList.size(); i++) {
                    VisitPlan visitPlan = visitPlanList.get(i);
                    net.maxproit.salesforce.masum.model.api.visitPlan.Data data = new net.maxproit.salesforce.masum.model.api.visitPlan.Data();
                    data.getVisitPlanApiModelData(visitPlanList.get(i), userName);
                    getApiService().createVisitPlan(data).enqueue(new Callback<MyVisitPlanApi>() {
                        @Override
                        public void onResponse(Call<MyVisitPlanApi> call, Response<MyVisitPlanApi> response) {
                            if (response.body().getCode().equals("200")) {
                                visitPlanDbController.updateSyncDataStatus(visitPlan.getId(),
                                        AppConstant.SYNC_STATUS_OK, response.body().getData().getActivityJournalID());
                            }
                        }

                        @Override
                        public void onFailure(Call<MyVisitPlanApi> call, Throwable t) {

                        }
                    });
                }
            }
        } else {
            Log.e("status", "not connected");
        }
    }


    private ApiService getApiService() {
        return RestClient.getInstance().callRetrofit();
    }


    public SharedPreferencesEnum localCash(Context context) {
        return SharedPreferencesEnum.getInstance(context);
    }

}

