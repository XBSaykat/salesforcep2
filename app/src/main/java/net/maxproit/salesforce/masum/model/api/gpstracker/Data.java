package net.maxproit.salesforce.masum.model.api.gpstracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

@SerializedName("latitude")
@Expose
private Double latitude;
@SerializedName("locationInfo")
@Expose
private String locationInfo;
@SerializedName("longitude")
@Expose
private Double longitude;
@SerializedName("referenceNo")
@Expose
private String referenceNo;
@SerializedName("source")
@Expose
private String source;
@SerializedName("userName")
@Expose
private String userName;

public Double getLatitude() {
return latitude;
}

public void setLatitude(Double latitude) {
this.latitude = latitude;
}

public String getLocationInfo() {
return locationInfo;
}

public void setLocationInfo(String locationInfo) {
this.locationInfo = locationInfo;
}

public Double getLongitude() {
return longitude;
}

public void setLongitude(Double longitude) {
this.longitude = longitude;
}

public String getReferenceNo() {
return referenceNo;
}

public void setReferenceNo(String referenceNo) {
this.referenceNo = referenceNo;
}

public String getSource() {
return source;
}

public void setSource(String source) {
this.source = source;
}

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
}

}