
package net.maxproit.salesforce.model.deviation.postresponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviationDetail {

    @SerializedName("CurrentValue")
    @Expose
    private Integer currentValue;
    @SerializedName("DeviationCategory")
    @Expose
    private DeviationCategory deviationCategory;
    @SerializedName("DeviationDetailID")
    @Expose
    private Integer deviationDetailID;
    @SerializedName("DeviationHead")
    @Expose
    private DeviationHead deviationHead;
    @SerializedName("ProposedValue")
    @Expose
    private Integer proposedValue;
    @SerializedName("Remark")
    @Expose
    private String remark;

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public DeviationCategory getDeviationCategory() {
        return deviationCategory;
    }

    public void setDeviationCategory(DeviationCategory deviationCategory) {
        this.deviationCategory = deviationCategory;
    }

    public Integer getDeviationDetailID() {
        return deviationDetailID;
    }

    public void setDeviationDetailID(Integer deviationDetailID) {
        this.deviationDetailID = deviationDetailID;
    }

    public DeviationHead getDeviationHead() {
        return deviationHead;
    }

    public void setDeviationHead(DeviationHead deviationHead) {
        this.deviationHead = deviationHead;
    }

    public Integer getProposedValue() {
        return proposedValue;
    }

    public void setProposedValue(Integer proposedValue) {
        this.proposedValue = proposedValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
