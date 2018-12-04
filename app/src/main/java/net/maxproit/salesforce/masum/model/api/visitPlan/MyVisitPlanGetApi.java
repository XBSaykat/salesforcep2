package net.maxproit.salesforce.masum.model.api.visitPlan;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.masum.model.local.VisitPlan;

public class MyVisitPlanGetApi {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public List<Datum> getVisitPlanList(List<VisitPlan> visitPlanList) {
        List<Datum> dataList=new ArrayList<>();
        for (int i=0;i<visitPlanList.size();i++){
            Datum datum=new Datum();
            datum.setActivityJournalID(String.valueOf(visitPlanList.get(i).getJournalId()));
            datum.setClientType(visitPlanList.get(i).getClientType());
            datum.setCustomerName(visitPlanList.get(i).getClientName());
            datum.setActivityStatus(visitPlanList.get(i).getStatus());
            datum.setActivityDate(visitPlanList.get(i).getDateOfVisit());
            datum.setVisitPurposeType(visitPlanList.get(i).getPurposeOfVisit());
            datum.setCity(visitPlanList.get(i).getCity());
            datum.setPS(visitPlanList.get(i).getPoliceStation());
            datum.setMobileNo(visitPlanList.get(i).getMobileNumber());
            datum.setRemarks(visitPlanList.get(i).getRemarks());
            datum.setProductType(visitPlanList.get(i).getProductType());

            dataList.add(datum);
        }

        return dataList;
    }

}