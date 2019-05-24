
package net.maxproit.salesforce2.model.deviation.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviationDetail {

    @SerializedName("deviationDetailID")
    @Expose
    private int deviationDetailID;
    @SerializedName("deviationCategory")
    @Expose
    private DeviationCategory deviationCategory;
    @SerializedName("deviationHead")
    @Expose
    private DeviationHead deviationHead;
    @SerializedName("currentValue")
    @Expose
    private int currentValue;
    @SerializedName("proposedValue")
    @Expose
    private int proposedValue;
    @SerializedName("remark")
    @Expose
    private String remark;

    public int getDeviationDetailID() {
        return deviationDetailID;
    }

    public void setDeviationDetailID(int deviationDetailID) {
        this.deviationDetailID = deviationDetailID;
    }

    public DeviationDetail withDeviationDetailID(int deviationDetailID) {
        this.deviationDetailID = deviationDetailID;
        return this;
    }

    public DeviationCategory getDeviationCategory() {
        return deviationCategory;
    }

    public void setDeviationCategory(DeviationCategory deviationCategory) {
        this.deviationCategory = deviationCategory;
    }

    public DeviationDetail withDeviationCategory(DeviationCategory deviationCategory) {
        this.deviationCategory = deviationCategory;
        return this;
    }

    public DeviationHead getDeviationHead() {
        return deviationHead;
    }

    public void setDeviationHead(DeviationHead deviationHead) {
        this.deviationHead = deviationHead;
    }

    public DeviationDetail withDeviationHead(DeviationHead deviationHead) {
        this.deviationHead = deviationHead;
        return this;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public DeviationDetail withCurrentValue(int currentValue) {
        this.currentValue = currentValue;
        return this;
    }

    public int getProposedValue() {
        return proposedValue;
    }

    public void setProposedValue(int proposedValue) {
        this.proposedValue = proposedValue;
    }

    public DeviationDetail withProposedValue(int proposedValue) {
        this.proposedValue = proposedValue;
        return this;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public DeviationDetail withRemark(String remark) {
        this.remark = remark;
        return this;
    }

}
