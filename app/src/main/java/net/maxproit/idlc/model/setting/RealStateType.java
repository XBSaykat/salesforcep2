
package net.maxproit.idlc.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealStateType {

    @SerializedName("RealStateType")
    @Expose
    private String realStateType;
    @SerializedName("RealStateTypeCode")
    @Expose
    private Integer realStateTypeCode;

    public String getRealStateType() {
        return realStateType;
    }

    public void setRealStateType(String realStateType) {
        this.realStateType = realStateType;
    }

    public Integer getRealStateTypeCode() {
        return realStateTypeCode;
    }

    public void setRealStateTypeCode(Integer realStateTypeCode) {
        this.realStateTypeCode = realStateTypeCode;
    }

}
