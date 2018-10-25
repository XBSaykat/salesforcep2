
package net.maxproit.salesforce.model.cif.postResponce;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("MakerName")
    @Expose
    private String makerName;
    @SerializedName("ProspectReferenceNo")
    @Expose
    private String prospectReferenceNo;
    @SerializedName("Remark")
    @Expose
    private String remark;
    @SerializedName("cifRequestDtls")
    @Expose
    private List<CifRequestDtl> cifRequestDtls = null;

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getProspectReferenceNo() {
        return prospectReferenceNo;
    }

    public void setProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<CifRequestDtl> getCifRequestDtls() {
        return cifRequestDtls;
    }

    public void setCifRequestDtls(List<CifRequestDtl> cifRequestDtls) {
        this.cifRequestDtls = cifRequestDtls;
    }

}
