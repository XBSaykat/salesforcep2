package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoIdType {

@SerializedName("identityType")
@Expose
private String identityType;
@SerializedName("identityTypeCode")
@Expose
private Integer identityTypeCode;

public String getIdentityType() {
return identityType;
}

public void setIdentityType(String identityType) {
this.identityType = identityType;
}

public Integer getIdentityTypeCode() {
return identityTypeCode;
}

public void setIdentityTypeCode(Integer identityTypeCode) {
this.identityTypeCode = identityTypeCode;
}

}