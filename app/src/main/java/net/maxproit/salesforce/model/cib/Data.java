package net.maxproit.salesforce.model.cib;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 7/7/18.
 * heyRezwan@gmail.com
 */
public class Data {
    @SerializedName("CIBRequestSetID")
    @Expose
    private int cIBRequestSetID;
    @SerializedName("MakerName")
    @Expose
    private String makerName;
    @SerializedName("ProspectReferenceNo")
    @Expose
    private String prospectReferenceNo;
    @SerializedName("Remark")
    @Expose
    private String remark;
    @SerializedName("cibRequestDtls")
    @Expose
    private List<CibRequestDtl> cibRequestDtls = null;

    public int getCIBRequestSetID() {
        return cIBRequestSetID;
    }

    public void setCIBRequestSetID(int cIBRequestSetID) {
        this.cIBRequestSetID = cIBRequestSetID;
    }

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

    public List<CibRequestDtl> getCibRequestDtls() {
        return cibRequestDtls;
    }

    public void setCibRequestDtls(List<CibRequestDtl> cibRequestDtls) {
        this.cibRequestDtls = cibRequestDtls;
    }
}
