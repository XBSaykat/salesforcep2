
package net.maxproit.idlc.model.supervisor.sanctions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("Reference")
    @Expose
    private String reference;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Branch")
    @Expose
    private String branch;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("DefaultAddress")
    @Expose
    private String defaultAddress;
    @SerializedName("ApprovalSetID")
    @Expose
    private String approvalSetID;
    @SerializedName("CurrentLevel")
    @Expose
    private String currentLevel;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Remark")
    @Expose
    private String remark;
    @SerializedName("SPProspectListID")
    @Expose
    private String sPProspectListID;
    @SerializedName("Product")
    @Expose
    private String product;
    @SerializedName("Pending")
    @Expose
    private String pending;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Datum withReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Datum withName(String name) {
        this.name = name;
        return this;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Datum withBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Datum withAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public Datum withDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
        return this;
    }

    public String getApprovalSetID() {
        return approvalSetID;
    }

    public void setApprovalSetID(String approvalSetID) {
        this.approvalSetID = approvalSetID;
    }

    public Datum withApprovalSetID(String approvalSetID) {
        this.approvalSetID = approvalSetID;
        return this;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Datum withCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Datum withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Datum withRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getSPProspectListID() {
        return sPProspectListID;
    }

    public void setSPProspectListID(String sPProspectListID) {
        this.sPProspectListID = sPProspectListID;
    }

    public Datum withSPProspectListID(String sPProspectListID) {
        this.sPProspectListID = sPProspectListID;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Datum withProduct(String product) {
        this.product = product;
        return this;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public Datum withPending(String pending) {
        this.pending = pending;
        return this;
    }

}
