package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

@SerializedName("country")
@Expose
private String country;
@SerializedName("countyCode")
@Expose
private Integer countyCode;

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public Integer getCountyCode() {
return countyCode;
}

public void setCountyCode(Integer countyCode) {
this.countyCode = countyCode;
}

}