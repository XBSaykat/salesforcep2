package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ManufacturerName {

@SerializedName("assetTypeCode")
@Expose
private Integer assetTypeCode;
@SerializedName("manufacturerName")
@Expose
private String manufacturerName;
@SerializedName("manufacturerNameId")
@Expose
private Integer manufacturerNameId;

public Integer getAssetTypeCode() {
return assetTypeCode;
}

public void setAssetTypeCode(Integer assetTypeCode) {
this.assetTypeCode = assetTypeCode;
}

public String getManufacturerName() {
return manufacturerName;
}

public void setManufacturerName(String manufacturerName) {
this.manufacturerName = manufacturerName;
}

public Integer getManufacturerNameId() {
return manufacturerNameId;
}

public void setManufacturerNameId(Integer manufacturerNameId) {
this.manufacturerNameId = manufacturerNameId;
}

}