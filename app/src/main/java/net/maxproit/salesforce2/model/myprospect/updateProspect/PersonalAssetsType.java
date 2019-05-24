
package net.maxproit.salesforce2.model.myprospect.updateProspect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonalAssetsType {

    @SerializedName("RealStateTypeCode")
    @Expose
    private Integer realStateTypeCode;
    @SerializedName("RealStateType")
    @Expose
    private String realStateType;

    public Integer getRealStateTypeCode() {
        return realStateTypeCode;
    }

    public void setRealStateTypeCode(Integer realStateTypeCode) {
        this.realStateTypeCode = realStateTypeCode;
    }

    public String getRealStateType() {
        return realStateType;
    }

    public void setRealStateType(String realStateType) {
        this.realStateType = realStateType;
    }

}
