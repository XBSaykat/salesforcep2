
package net.maxproit.salesforce2.model.deviation.getlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Daviation {

    @SerializedName("DeviationAccountHead")
    @Expose
    private String deviationAccountHead;
    @SerializedName("DeviationCategory")
    @Expose
    private String deviationCategory;
    @SerializedName("CurrentValue")
    @Expose
    private String currentValue;
    @SerializedName("ProposedValue")
    @Expose
    private String proposedValue;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("MakerName")
    @Expose
    private String makerName;
    @SerializedName("MakeDate")
    @Expose
    private String makeDate;
    @SerializedName("Remark")
    @Expose
    private String remark;

    public String getDeviationAccountHead() {
        return deviationAccountHead;
    }

    public void setDeviationAccountHead(String deviationAccountHead) {
        this.deviationAccountHead = deviationAccountHead;
    }

    public String getDeviationCategory() {
        return deviationCategory;
    }

    public void setDeviationCategory(String deviationCategory) {
        this.deviationCategory = deviationCategory;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public String getProposedValue() {
        return proposedValue;
    }

    public void setProposedValue(String proposedValue) {
        this.proposedValue = proposedValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(String makeDate) {
        this.makeDate = makeDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
