
package net.maxproit.salesforce.model.newlead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicInfo {

    @SerializedName("branchCode")
    @Expose
    private String branchCode = "";
    @SerializedName("branchName")
    @Expose
    private String branchName = "";
    @SerializedName("boothCode")
    @Expose
    private String boothCode = "";
    @SerializedName("boothName")
    @Expose
    private String boothName = "";
    @SerializedName("salesOfficerCode")
    @Expose
    private String salesOfficerCode = "";
    @SerializedName("salesOfficerName")
    @Expose
    private String salesOfficerName = "";
    @SerializedName("supervisorCode")
    @Expose
    private String supervisorCode = "";
    @SerializedName("supervisorName")
    @Expose
    private String supervisorName = "";
    @SerializedName("relationshipWithIDLC")
    @Expose
    private String relationshipWithIDLC = "";
    @SerializedName("interestedAmount")
    @Expose
    private int interestedAmount = 0;
    @SerializedName("offeredRate")
    @Expose
    private int offeredRate = 0;
    @SerializedName("leadIndexID")
    @Expose
    private int leadIndexID = 0;
    @SerializedName("customerName")
    @Expose
    private String customerName = "";


    public BasicInfo() {
    }


    public BasicInfo(String branchCode, String branchName, String boothCode, String boothName, String salesOfficerCode, String salesOfficerName, String supervisorCode, String supervisorName, String relationshipWithIDLC, int interestedAmount, int offeredRate, int leadIndexID, String customerName) {
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.boothCode = boothCode;
        this.boothName = boothName;
        this.salesOfficerCode = salesOfficerCode;
        this.salesOfficerName = salesOfficerName;
        this.supervisorCode = supervisorCode;
        this.supervisorName = supervisorName;
        this.relationshipWithIDLC = relationshipWithIDLC;
        this.interestedAmount = interestedAmount;
        this.offeredRate = offeredRate;
        this.leadIndexID = leadIndexID;
        this.customerName = customerName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public BasicInfo withBranchCode(String branchCode) {
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

}
