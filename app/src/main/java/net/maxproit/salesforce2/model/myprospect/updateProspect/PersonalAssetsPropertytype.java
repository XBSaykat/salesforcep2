
package net.maxproit.salesforce2.model.myprospect.updateProspect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonalAssetsPropertytype {

    @SerializedName("PropertyTypeCode")
    @Expose
    private Integer propertyTypeCode;
    @SerializedName("PropertyType")
    @Expose
    private String propertyType;

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
