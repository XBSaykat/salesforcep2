
package net.maxproit.salesforce2.model.newprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonalAssetsPropertytype {

    @SerializedName("propertyTypeCode")
    @Expose
    private Integer propertyTypeCode;
    @SerializedName("propertyType")
    @Expose
    private String propertyType;

    public PersonalAssetsPropertytype() {
    }

    public PersonalAssetsPropertytype(Integer propertyTypeCode, String propertyType) {
        this.propertyTypeCode = propertyTypeCode;
        this.propertyType = propertyType;
    }

    public Integer getPropertyTypeCode() {
        return propertyTypeCode;
    }

    public void setPropertyTypeCode(Integer propertyTypeCode) {
        this.propertyTypeCode = propertyTypeCode;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

}
