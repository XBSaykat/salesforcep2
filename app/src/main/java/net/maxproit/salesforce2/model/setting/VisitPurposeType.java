
package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisitPurposeType {

    @SerializedName("VisitPurposeType")
    @Expose
    private String visitPurposeType;
    @SerializedName("VisitPurposeTypeID")
    @Expose
    private Integer visitPurposeTypeID;

    public String getVisitPurposeType() {
        return visitPurposeType;
    }

    public void setVisitPurposeType(String visitPurposeType) {
        this.visitPurposeType = visitPurposeType;
    }

    public Integer getVisitPurposeTypeID() {
        return visitPurposeTypeID;
    }

    public void setVisitPurposeTypeID(Integer visitPurposeTypeID) {
        this.visitPurposeTypeID = visitPurposeTypeID;
    }

}


