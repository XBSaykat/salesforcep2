
package net.maxproit.salesforce.model.cif;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("CIFRequestSetID")
    @Expose
    private int cIFRequestSetID;
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
    private List<CifRequestDtl> cifRequestDtls = new ArrayList<>();


    public int getCIFRequestSetID() {
        return cIFRequestSetID;
    }

    public void setCIFRequestSetID(int cIFRequestSetID) {
        this.cIFRequestSetID = cIFRequestSetID;
    }

    public Data withCIFRequestSetID(int cIFRequestSetID) {
        this.cIFRequestSetID = cIFRequestSetID;
        return this;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public Data withMakerName(String makerName) {
        this.makerName = makerName;
        return this;
    }


    public String getProspectReferenceNo() {
        return prospectReferenceNo;
    }

    public void setProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
    }

    public Data withProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Data withRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public List<CifRequestDtl> getCifRequestDtls() {
        return cifRequestDtls;
    }

    public void setCifRequestDtls(List<CifRequestDtl> cifRequestDtls) {
        this.cifRequestDtls = cifRequestDtls;
    }

    public Data withCifRequestDtls(List<CifRequestDtl> cifRequestDtls) {
        this.cifRequestDtls = cifRequestDtls;
        return this;
    }

}
