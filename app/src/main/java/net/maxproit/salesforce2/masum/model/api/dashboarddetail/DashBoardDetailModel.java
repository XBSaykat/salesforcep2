package net.maxproit.salesforce2.masum.model.api.dashboarddetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashBoardDetailModel {

@SerializedName("ID")
@Expose
private String iD;
@SerializedName("ClientName")
@Expose
private String clientName;
@SerializedName("Field3")
@Expose
private String field3;
@SerializedName("Field4")
@Expose
private String field4;

public String getID() {
return iD;
}

public void setID(String iD) {
this.iD = iD;
}

public String getClientName() {
return clientName;
}

public void setClientName(String clientName) {
this.clientName = clientName;
}

public String getField3() {
return field3;
}

public void setField3(String field3) {
this.field3 = field3;
}

public String getField4() {
return field4;
}

public void setField4(String field4) {
this.field4 = field4;
}

}