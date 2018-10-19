
package net.maxproit.idlc.model.mylead.updateLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicInfo {

    @SerializedName("BoothCode")
    @Expose
    private String boothCode;
    @SerializedName("BoothName")
    @Expose
    private String boothName;
    @SerializedName("BranchCode")
    @Expose
    private Object branchCode;
    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("InterestedAmount")
    @Expose
    private int interestedAmount;
    @SerializedName("LeadIndexID")
    @Expose
    private int leadIndexID;
    @SerializedName("OfferedRate")
    @Expose
    private int offeredRate;
    @SerializedName("RelationshipWithIDLC")
    @Expose
    private String relationshipWithIDLC;
    @SerializedName("SalesOfficerCode")
    @Expose
    private String salesOfficerCode;
    @SerializedName("SalesOfficerName")
    @Expose
    private String salesOfficerName;
    @SerializedName("SupervisorCode")
    @Expose
    private String supervisorCode;
    @SerializedName("SupervisorName")
    @Expose
    private String supervisorName;

    public String getBoothCode() {
        return boothCode;
    }

    public void setBoothCode(String boothCode) {
        this.boothCode = boothCode;
    }

    public BasicInfo withBoothCode(String boothCode) {
        this.boothCode = boothCode;
        return this;
    }

    public String getBoothName() {
        return boothName;
    }

    public void setBoothName(String boothName) {
        this.boothName = boothName;
    }

    public BasicInfo withBoothName(String boothName) {
        this.boothName = boothName;
        return this;
    }

    public Object getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Object branchCode) {
        this.branchCode = branchCode;
    }

    public BasicInfo withBranchCode(Object branchCode) {
        this.branchCode = branchCode;
        return this;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public BasicInfo withBranchName(String branchName) {
        this.branchName = branchName;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BasicInfo withCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public int getInterestedAmount() {
        return interestedAmount;
    }

    public void setInterestedAmount(int interestedAmount) {
        this.interestedAmount = interestedAmount;
    }

    public BasicInfo withInterestedAmount(int interestedAmount) {
        this.interestedAmount = interestedAmount;
        return this;
    }

    public int getLeadIndexID() {
        return leadIndexID;
    }

    public void setLeadIndexID(int leadIndexID) {
        this.leadIndexID = leadIndexID;
    }

    public BasicInfo withLeadIndexID(int leadIndexID) {
        this.leadIndexID = leadIndexID;
        return this;
    }

    public int getOfferedRate() {
        return offeredRate;
    }

    public void setOfferedRate(int offeredRate) {
        this.offeredRate = offeredRate;
    }

    public BasicInfo withOfferedRate(int offeredRate) {
        this.offeredRate = offeredRate;
        return this;
    }

    public String getRelationshipWithIDLC() {
        return relationshipWithIDLC;
    }

    public void setRelationshipWithIDLC(String relationshipWithIDLC) {
        this.relationshipWithIDLC = relationshipWithIDLC;
    }

    public BasicInfo withRelationshipWithIDLC(String relationshipWithIDLC) {
        this.relationshipWithIDLC = relationshipWithIDLC;
        return this;
    }

    public String getSalesOfficerCode() {
        return salesOfficerCode;
    }

    public void setSalesOfficerCode(String salesOfficerCode) {
        this.salesOfficerCode = salesOfficerCode;
    }

    public BasicInfo withSalesOfficerCode(String salesOfficerCode) {
        this.salesOfficerCode = salesOfficerCode;
        return this;
    }

    public String getSalesOfficerName() {
        return salesOfficerName;
    }

    public void setSalesOfficerName(String salesOfficerName) {
        this.salesOfficerName = salesOfficerName;
    }

    public BasicInfo withSalesOfficerName(String salesOfficerName) {
        this.salesOfficerName = salesOfficerName;
        return this;
    }

    public String getSupervisorCode() {
        return supervisorCode;
    }

    public void setSupervisorCode(String supervisorCode) {
        this.supervisorCode = supervisorCode;
    }

    public BasicInfo withSupervisorCode(String supervisorCode) {
        this.supervisorCode = supervisorCode;
        return this;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public BasicInfo withSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
        return this;
    }

}
