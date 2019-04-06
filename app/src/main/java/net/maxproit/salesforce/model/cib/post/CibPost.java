
package net.maxproit.salesforce.model.cib.post;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CibPost {
    @SerializedName("prospectReferenceNo")
    @Expose
    private String prospectReferenceNo;
    @SerializedName("cibRequestDtls")
    @Expose
    private List<CibRequestDtl> cibRequestDtls = null;
    @SerializedName("makerName")
    @Expose
    private String makerName;
    @SerializedName("remark")
    @Expose
    private String remark;

    public String getProspectReferenceNo() {
        return prospectReferenceNo;
    }

    public void setProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
    }

    public List<CibRequestDtl> getCibRequestDtls() {
        return cibRequestDtls;
    }

    public void setCibRequestDtls(List<CibRequestDtl> cibRequestDtls) {
        this.cibRequestDtls = cibRequestDtls;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}