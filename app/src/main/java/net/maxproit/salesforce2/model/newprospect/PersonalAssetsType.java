
package net.maxproit.salesforce2.model.newprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonalAssetsType {

    @SerializedName("realStateTypeCode")
    @Expose
    private Integer realStateTypeCode;
    @SerializedName("realStateType")
    @Expose
    private String realStateType;


    public PersonalAssetsType() {
    }

    public PersonalAssetsType(Integer realStateTypeCode, String realStateType) {
        this.realStateTypeCode = realStateTypeCode;
        this.realStateType = realStateType;
    }

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
