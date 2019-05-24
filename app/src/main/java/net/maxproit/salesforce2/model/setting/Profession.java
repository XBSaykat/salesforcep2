package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Profession {
    @SerializedName("ProfessionType")
    @Expose
    private String professionType;
    @SerializedName("ProfessionTypeCode")
    @Expose
    private Integer professionTypeCode;

    public String getProfessionType() {
        return professionType;
    }

    public void setProfessionType(String professionType) {
        this.professionType = professionType;
    }

    public Integer getProfessionTypeCode() {
        return professionTypeCode;
    }

    public void setProfessionTypeCode(Integer professionTypeCode) {
        this.professionTypeCode = professionTypeCode;
    }


}
