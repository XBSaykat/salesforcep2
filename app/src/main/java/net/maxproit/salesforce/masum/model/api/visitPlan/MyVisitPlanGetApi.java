package net.maxproit.salesforce.masum.model.api.visitPlan;

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

    public void setVisitPlanList(List<VisitPlan> visitPlanList) {

        for (int i=0;i<visitPlanList.size();i++){
            Datum datum=new Datum();
            datum.setClientType(visitPlanList.get(i).getClientType());
            datum.setCustomerName(visitPlanList.get(i).getClientName());
            datum.setActivityStatus(visitPlanList.get(i).getStatus());
            data.add(datum);
        }
    }

}