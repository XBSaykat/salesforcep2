package net.maxproit.salesforce.masum.model.api.deviation.postdeviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Md. Mehedi Hasan on 12/11/2018.
 * mehedipy@gmail.com
 */
public class DeviationDetail {
    @SerializedName("deviationDetailID")
    @Expose
    private Integer deviationDetailID;
    @SerializedName("deviationCategory")
    @Expose
    private DeviationCategory deviationCategory;
    @SerializedName("deviationHead")
    @Expose
    private DeviationHead deviationHead;
    @SerializedName("deviationJustifications")
    @Expose
    private List<DeviationJustification> deviationJustifications = null;
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("approvalTier")
    @Expose
    private String approvalTier;

    public Integer getDeviationDetailID() {
        return deviationDetailID;
    }

    public void setDeviationDetailID(Integer deviationDetailID) {
        this.deviationDetailID = deviationDetailID;
    }

    public DeviationCategory getDeviationCategory() {
        return deviationCategory;
    }

    public void setDeviationCategory(DeviationCategory deviationCategory) {
        this.deviationCategory = deviationCategory;
    }

    public DeviationHead getDeviationHead() {
        return deviationHead;
    }

    public void setDeviationHead(DeviationHead deviationHead) {
        this.deviationHead = deviationHead;
    }

    public List<DeviationJustification> getDeviationJustifications() {
        return deviationJustifications;
    }

    public void setDeviationJustifications(List<DeviationJustification> deviationJustifications) {
        this.deviationJustifications = deviationJustifications;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApprovalTier() {
        return approvalTier;
    }

    public void setApprovalTier(String approvalTier) {
        this.approvalTier = approvalTier;
    }
}
