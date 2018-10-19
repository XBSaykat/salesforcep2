package net.maxproit.idlc.model.mylead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan chowdhury on 6/27/18.
 * heyRezwan@gmail.com
 */
public class MyLeadApproval {
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
    @SerializedName("spApprovalReqId")
    @Expose
    private int spApprovalReqId;

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public MyLeadApproval withApprovalType(String approvalType) {
        this.approvalType = approvalType;
        return this;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public MyLeadApproval withReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
        return this;
    }

    public int getApprovalSetID() {
        return approvalSetID;
    }

    public void setApprovalSetID(int approvalSetID) {
        this.approvalSetID = approvalSetID;
    }

    public MyLeadApproval withApprovalSetID(int approvalSetID) {
        this.approvalSetID = approvalSetID;
        return this;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public MyLeadApproval withCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MyLeadApproval withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public MyLeadApproval withRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public MyLeadApproval withUser(String user) {
        this.user = user;
        return this;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public MyLeadApproval withBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public int getSpApprovalReqId() {
        return spApprovalReqId;
    }

    public void setSpApprovalReqId(int spApprovalReqId) {
        this.spApprovalReqId = spApprovalReqId;
    }

    public MyLeadApproval withSpApprovalReqId(int spApprovalReqId) {
        this.spApprovalReqId = spApprovalReqId;
        return this;
    }
}
