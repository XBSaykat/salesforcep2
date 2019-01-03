package net.maxproit.salesforce.masum.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.model.myprospect.updatemyprospect.CoApplicant;

public class GetExistingCoApplicant {

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
private CoApplicant data;

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

public CoApplicant getData() {
return data;
}

public void setData(CoApplicant data) {
this.data = data;
}

}