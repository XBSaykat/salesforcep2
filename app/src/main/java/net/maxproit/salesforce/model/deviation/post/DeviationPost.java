
package net.maxproit.salesforce.model.deviation.post;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviationPost {

    @SerializedName("prospectReferenceNo")
    @Expose
    private String prospectReferenceNo;

    @SerializedName("deviationDetails")
    @Expose
    private List<DeviationDetail> deviationDetails = null;
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

    public DeviationPost withProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
        return this;
    }


    public List<DeviationDetail> getDeviationDetails() {
        return deviationDetails;
    }

    public void setDeviationDetails(List<DeviationDetail> deviationDetails) {
        this.deviationDetails = deviationDetails;
    }

    public DeviationPost withDeviationDetails(List<DeviationDetail> deviationDetails) {
        this.deviationDetails = deviationDetails;
        return this;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public DeviationPost withMakerName(String makerName) {
        this.makerName = makerName;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public DeviationPost withRemark(String remark) {
        this.remark = remark;
        return this;
    }

}
