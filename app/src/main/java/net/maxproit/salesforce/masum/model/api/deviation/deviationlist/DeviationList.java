package net.maxproit.salesforce.masum.model.api.deviation.deviationlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/12/2018.
 * mehedipy@gmail.com
 */
public class DeviationList {

    @SerializedName("DeviationSetID")
    @Expose
    private String deviationSetID;
    @SerializedName("DeviationDetailID")
    @Expose
    private String deviationDetailID;
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
    @SerializedName("LTV")
    @Expose
    private String lTV;
    @SerializedName("LoanAmount")
    @Expose
    private String loanAmount;
    @SerializedName("ProductCategoryID")
    @Expose
    private String productCategoryID;
    @SerializedName("ProductSubCategoryID")
    @Expose
    private String productSubCategoryID;
    @SerializedName("ApprovalTier")
    @Expose
    private String approvalTier;
    @SerializedName("JustificationID")
    @Expose
    private String justificationID;

    public String getDeviationSetID() {
        return deviationSetID;
    }

    public void setDeviationSetID(String deviationSetID) {
        this.deviationSetID = deviationSetID;
    }

    public String getDeviationDetailID() {
        return deviationDetailID;
    }

    public void setDeviationDetailID(String deviationDetailID) {
        this.deviationDetailID = deviationDetailID;
    }

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

    public String getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(String productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public String getProductSubCategoryID() {
        return productSubCategoryID;
    }

    public void setProductSubCategoryID(String productSubCategoryID) {
        this.productSubCategoryID = productSubCategoryID;
    }

    public String getApprovalTier() {
        return approvalTier;
    }

    public void setApprovalTier(String approvalTier) {
        this.approvalTier = approvalTier;
    }

    public String getJustificationID() {
        return justificationID;
    }

    public void setJustificationID(String justificationID) {
        this.justificationID = justificationID;
    }

}
