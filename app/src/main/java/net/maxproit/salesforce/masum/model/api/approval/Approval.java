package net.maxproit.salesforce.masum.model.api.approval;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Approval {
    @SerializedName("approvalType")
    @Expose
    private String approvalType;
    @SerializedName("referenceNo")
    @Expose
    private String referenceNo;
    @SerializedName("approvalSetID")
    @Expose
    private int approvalSetID;
    @SerializedName("currentLevel")
    @Expose
    private int currentLevel;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("productId")
    @Expose
    private int productId;

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public Approval withApprovalType(String approvalType) {
        this.approvalType = approvalType;
        return this;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Approval withReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
        return this;
    }

    public int getApprovalSetID() {
        return approvalSetID;
    }

    public void setApprovalSetID(int approvalSetID) {
        this.approvalSetID = approvalSetID;
    }

    public Approval withApprovalSetID(int approvalSetID) {
        this.approvalSetID = approvalSetID;
        return this;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Approval withCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Approval withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Approval withRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Approval withUser(String user) {
        this.user = user;
        return this;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Approval withBranch(String branch) {
        this.branch = branch;
        return this;
    }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

    public Approval() {
        }

    public Approval(String approvalType, String referenceNo, int approvalSetID, int currentLevel, String status, String remark, String user, String branch, int productId) {
            this.approvalType = approvalType;
            this.referenceNo = referenceNo;
            this.approvalSetID = approvalSetID;
            this.currentLevel = currentLevel;
            this.status = status;
            this.remark = remark;
            this.user = user;
            this.branch = branch;
            this.productId = productId;
        }

        public Approval withProductId(int productId) {
            this.productId = productId;
            return this;


        }

    @Override
    public String toString() {
        return "MyLeadApproval{" +
                "approvalType='" + approvalType + '\'' +
                ", referenceNo='" + referenceNo + '\'' +
                ", approvalSetID=" + approvalSetID +
                ", currentLevel=" + currentLevel +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", user='" + user + '\'' +
                ", branch='" + branch + '\'' +
                ", productId=" + productId +
                '}';
    }
}

