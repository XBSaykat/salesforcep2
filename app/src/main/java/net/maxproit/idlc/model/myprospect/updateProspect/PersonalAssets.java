
package net.maxproit.idlc.model.myprospect.updateProspect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonalAssets {

    @SerializedName("RealStateID")
    @Expose
    private Integer realStateID;
    @SerializedName("Type")
    @Expose
    private PersonalAssetsType type;
    @SerializedName("Propertytype")
    @Expose
    private PersonalAssetsPropertytype propertytype;
    @SerializedName("PropertySize")
    @Expose
    private String propertySize;
    @SerializedName("Total")
    @Expose
    private String total;
    @SerializedName("LocationNTenureofOwnership")
    @Expose
    private String locationNTenureofOwnership;

    public Integer getRealStateID() {
        return realStateID;
    }

    public void setRealStateID(Integer realStateID) {
        this.realStateID = realStateID;
    }

    public PersonalAssetsType getType() {
        return type;
    }


    public net.maxproit.idlc.model.newprospect.PersonalAssetsType getTypec() {
        return new net.maxproit.idlc.model.newprospect.PersonalAssetsType(
                type.getRealStateTypeCode(),type.getRealStateType());
    }


    public void setType(PersonalAssetsType type) {
        this.type = type;
    }

    public PersonalAssetsPropertytype getPropertytype() {
        return propertytype;
    }

    public net.maxproit.idlc.model.newprospect.PersonalAssetsPropertytype getPropertytypec() {
        return new net.maxproit.idlc.model.newprospect.PersonalAssetsPropertytype(propertytype.getPropertyTypeCode(),propertytype.getPropertyType());
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
