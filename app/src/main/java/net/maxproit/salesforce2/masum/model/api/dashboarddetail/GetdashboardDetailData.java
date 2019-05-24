package net.maxproit.salesforce2.masum.model.api.dashboarddetail;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetdashboardDetailData {

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
private List<DashBoardDetailModel> data = null;

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

public List<DashBoardDetailModel> getData() {
return data;
}

public void setData(List<DashBoardDetailModel> data) {
this.data = data;
}

}