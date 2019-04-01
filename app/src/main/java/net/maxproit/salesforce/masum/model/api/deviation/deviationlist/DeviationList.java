package net.maxproit.salesforce.masum.model.api.deviation.deviationlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/12/2018.
 * mehedipy@gmail.com
 */
public class DeviationList {
    @SerializedName("LTV")
    @Expose
    private String lTV;
    @SerializedName("LoanAmount")
    @Expose
    private String loanAmount;
    @SerializedName("DeviationSetID")
    @Expose
    private String deviationSetID;
    @SerializedName("DeviationCategory")
    @Expose
    private String deviationCategory;
    @SerializedName("DeviationAccountHead")
    @Expose
    private String deviationAccountHead;
    @SerializedName("RiskCategory")
    @Expose
    private String riskCategory;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("MakerName")
    @Expose
    private String makerName;
    @SerializedName("MakeDate")
    @Expose
    private String makeDate;
    @SerializedName("CurrentApprover")
    @Expose
    private String currentApprover;
    @SerializedName("FinalApprover")
    @Expose
    private String finalApprover;
    @SerializedName("ApproverRemark")
    @Expose
    private String approverRemark;
    @SerializedName("LastApprovalDate")
    @Expose
    private String lastApprovalDate;

    public String getLTV() {
        return lTV;
    }

    public void setLTV(String lTV) {
        this.lTV = lTV;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getDeviationSetID() {
        return deviationSetID;
    }

    public void setDeviationSetID(String deviationSetID) {
        this.deviationSetID = deviationSetID;
    }

    public String getDeviationCategory() {
        return deviationCategory;
    }

    public void setDeviationCategory(String deviationCategory) {
        this.deviationCategory = deviationCategory;
    }

    public String getDeviationAccountHead() {
        return deviationAccountHead;
    }

    public void setDeviationAccountHead(String deviationAccountHead) {
        this.deviationAccountHead = deviationAccountHead;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
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

    public String getCurrentApprover() {
        return currentApprover;
    }

    public void setCurrentApprover(String currentApprover) {
        this.currentApprover = currentApprover;
    }

    public String getFinalApprover() {
        return finalApprover;
    }

    public void setFinalApprover(String finalApprover) {
        this.finalApprover = finalApprover;
    }

    public String getApproverRemark() {
        return approverRemark;
    }

    public void setApproverRemark(String approverRemark) {
        this.approverRemark = approverRemark;
    }

    public String getLastApprovalDate() {
        return lastApprovalDate;
    }

    public void setLastApprovalDate(String lastApprovalDate) {
        this.lastApprovalDate = lastApprovalDate;
    }
}
