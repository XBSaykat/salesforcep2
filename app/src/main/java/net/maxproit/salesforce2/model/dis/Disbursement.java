package net.maxproit.salesforce2.model.dis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 10/3/2018.
 * heyrezwan@gmail.com
 */
public class Disbursement {


    @SerializedName("issueBranch")
    @Expose
    private String issueBranch;
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("disbursementID")
    @Expose
    private Integer disbursementID;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("requestBy")
    @Expose
    private String requestBy;
    @SerializedName("disRequestDate")
    @Expose
    private String disRequestDate;
    @SerializedName("emiDate")
    @Expose
    private Integer emiDate;
    @SerializedName("disbursementDetails")
    @Expose
    private List<DisbursementDetail> disbursementDetails = null;

    public String getIssueBranch() {
        return issueBranch;
    }

    public void setIssueBranch(String issueBranch) {
        this.issueBranch = issueBranch;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDisbursementID() {
        return disbursementID;
    }

    public void setDisbursementID(Integer disbursementID) {
        this.disbursementID = disbursementID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public String getDisRequestDate() {
        return disRequestDate;
    }

    public void setDisRequestDate(String disRequestDate) {
        this.disRequestDate = disRequestDate;
    }

    public Integer getEmiDate() {
        return emiDate;
    }

    public void setEmiDate(Integer emiDate) {
        this.emiDate = emiDate;
    }

    public List<DisbursementDetail> getDisbursementDetails() {
        return disbursementDetails;
    }

    public void setDisbursementDetails(List<DisbursementDetail> disbursementDetails) {
        this.disbursementDetails = disbursementDetails;
    }

}