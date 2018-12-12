package net.maxproit.salesforce.masum.model.api.myactivity;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.masum.model.local.VisitPlan;

public class MyActivityGetDataApi {

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

     public  List<Datum> getVisitPlanList(List<VisitPlan> visitPlanList) {
        List<Datum> dataList=new ArrayList<>();
        for (int i=0;i<visitPlanList.size();i++){
            Datum datum=new Datum();
            datum.setId(visitPlanList.get(i).getId());
            datum.setActivityJournalID(String.valueOf(visitPlanList.get(i).getDateOfVisit()));
            datum.setClientType(visitPlanList.get(i).getMobileNumber());
            datum.setClientName(visitPlanList.get(i).getClientName());
            datum.setActivityStatus(visitPlanList.get(i).getStatus());
            dataList.add(datum);
        }

        return dataList;
    }

}