package net.maxproit.salesforce.masum.model.api.deviation.postdeviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Md. Mehedi Hasan on 12/11/2018.
 * mehedipy@gmail.com
 */
public class PostDeviation {
    @SerializedName("prospectReferenceNo")
    @Expose
    private String prospectReferenceNo;
    @SerializedName("deviationSetID")
    @Expose
    private Integer deviationSetID;
    @SerializedName("makerName")
    @Expose
    private String makerName;
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("deviationDetails")
    @Expose
    private List<DeviationDetail> deviationDetails = null;

    public String getProspectReferenceNo() {
        return prospectReferenceNo;
    }

    public void setProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
    }

    public Integer getDeviationSetID() {
        return deviationSetID;
    }

    public void setDeviationSetID(Integer deviationSetID) {
        this.deviationSetID = deviationSetID;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<DeviationDetail> getDeviationDetails() {
        return deviationDetails;
    }

    public void setDeviationDetails(List<DeviationDetail> deviationDetails) {
        this.deviationDetails = deviationDetails;
    }
}
