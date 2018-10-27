
package net.maxproit.salesforce.model.newprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonalAssets {

    @SerializedName("realStateID")
    @Expose
    private Integer realStateID;
    @SerializedName("type")
    @Expose
    private PersonalAssetsType type =new PersonalAssetsType();
    @SerializedName("propertytype")
    @Expose
    private PersonalAssetsPropertytype propertytype =new PersonalAssetsPropertytype();
    @SerializedName("propertySize")
    @Expose
    private String propertySize;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("locationNTenureofOwnership")
    @Expose
    private String locationNTenureofOwnership;


    public PersonalAssets() {
    }

    public PersonalAssets(Integer realStateID, PersonalAssetsType type, PersonalAssetsPropertytype propertytype, String propertySize, String total, String locationNTenureofOwnership) {
        this.realStateID = realStateID;
        this.type = type;
        this.propertytype = propertytype;
        this.propertySize = propertySize;
        this.total = total;
        this.locationNTenureofOwnership = locationNTenureofOwnership;
    }

    public Integer getRealStateID() {
        return realStateID;
    }

    public void setRealStateID(Integer realStateID) {
        this.realStateID = realStateID;
    }

    public PersonalAssetsType getType() {
        return type;
    }

    public void setType(PersonalAssetsType type) {
        this.type = type;
    }

    public PersonalAssetsPropertytype getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(PersonalAssetsPropertytype propertytype) {
        this.propertytype = propertytype;
    }

    public String getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(String propertySize) {
        this.propertySize = propertySize;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getLocationNTenureofOwnership() {
        return locationNTenureofOwnership;
    }

    public void setLocationNTenureofOwnership(String locationNTenureofOwnership) {
        this.locationNTenureofOwnership = locationNTenureofOwnership;
    }

}
