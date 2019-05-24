
package net.maxproit.salesforce2.model.cif.post;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CifPost {

    @SerializedName("prospectReferenceNo")
    @Expose
    private String prospectReferenceNo;
    @SerializedName("cifRequestDtls")
    @Expose
    private List<CifRequestDtl> cifRequestDtls = null;
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

    public List<CifRequestDtl> getCifRequestDtls() {
        return cifRequestDtls;
    }

    public void setCifRequestDtls(List<CifRequestDtl> cifRequestDtls) {
        this.cifRequestDtls = cifRequestDtls;
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
