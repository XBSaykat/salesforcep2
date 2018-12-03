package net.maxproit.salesforce.masum.model.api.visitPlan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyVisitPlanApi {

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
private Data data;

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

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

}