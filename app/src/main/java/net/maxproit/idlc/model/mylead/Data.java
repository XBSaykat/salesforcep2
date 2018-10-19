
package net.maxproit.idlc.model.mylead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("Reference")
    @Expose
    private String reference;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Branch")
    @Expose
    private String branch;
    @SerializedName("Address")
    @Expose
    private String address;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Data withReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data withName(String name) {
        this.name = name;
        return this;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Data withBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Data withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getApprovalSetID() {
        return approvalSetID;
    }

    public void setApprovalSetID(String approvalSetID) {
        this.approvalSetID = approvalSetID;
    }

    public Data withApprovalSetID(String approvalSetID) {
        this.approvalSetID = approvalSetID;
        return this;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Data withCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data withStatus(String status) {
        this.status = status;
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

}
