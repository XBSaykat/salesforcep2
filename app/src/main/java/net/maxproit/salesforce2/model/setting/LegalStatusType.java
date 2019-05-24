
package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LegalStatusType {

    @SerializedName("LegalStatusTypeCode")
    @Expose
    private int legalStatusTypeCode;
    @SerializedName("LegalStatusTypeName")
    @Expose
    private String legalStatusTypeName;

    public int getLegalStatusTypeCode() {
        return legalStatusTypeCode;
    }

    public void setLegalStatusTypeCode(int legalStatusTypeCode) {
        this.legalStatusTypeCode = legalStatusTypeCode;
    }

    public LegalStatusType withLegalStatusTypeCode(int legalStatusTypeCode) {
        this.legalStatusTypeCode = legalStatusTypeCode;
        return this;
    }

    public String getLegalStatusTypeName() {
        return legalStatusTypeName;
    }

    public void setLegalStatusTypeName(String legalStatusTypeName) {
        this.legalStatusTypeName = legalStatusTypeName;
    }

    public LegalStatusType withLegalStatusTypeName(String legalStatusTypeName) {
        this.legalStatusTypeName = legalStatusTypeName;
        return this;
    }

}
