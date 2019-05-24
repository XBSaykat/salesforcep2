package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientType {

@SerializedName("ClientType")
@Expose
private String clientType;
@SerializedName("ClientTypeID")
@Expose
private Integer clientTypeID;

public String getClientType() {
return clientType;
}

public void setClientType(String clientType) {
this.clientType = clientType;
}

public Integer getClientTypeID() {
return clientTypeID;
}

public void setClientTypeID(Integer clientTypeID) {
this.clientTypeID = clientTypeID;
}

}