package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NetSalaryType {

@SerializedName("netSalaryType")
@Expose
private String netSalaryType;
@SerializedName("netSalaryTypeCode")
@Expose
private Integer netSalaryTypeCode;

public String getNetSalaryType() {
return netSalaryType;
}

public void setNetSalaryType(String netSalaryType) {
this.netSalaryType = netSalaryType;
}

public Integer getNetSalaryTypeCode() {
return netSalaryTypeCode;
}

public void setNetSalaryTypeCode(Integer netSalaryTypeCode) {
this.netSalaryTypeCode = netSalaryTypeCode;
}

}