
package net.maxproit.salesforce2.model.setting;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusinessType {

    @SerializedName("BusinessType")
    @Expose
    private String businessType;
    @SerializedName("BusinessTypeID")
    @Expose
    private int businessTypeID;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public BusinessType withBusinessType(String businessType) {
        this.businessType = businessType;
        return this;
    }

    public int getBusinessTypeID() {
        return businessTypeID;
    }

    public void setBusinessTypeID(int businessTypeID) {
        this.businessTypeID = businessTypeID;
    }

    public BusinessType withBusinessTypeID(int businessTypeID) {
        this.businessTypeID = businessTypeID;
        return this;
    }


}
