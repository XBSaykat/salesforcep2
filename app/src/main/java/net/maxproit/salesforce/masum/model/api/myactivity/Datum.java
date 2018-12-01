package net.maxproit.salesforce.masum.model.api.myactivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("ActivityJournalID")
    @Expose
    private String activityJournalID;
    @SerializedName("ClientType")
    @Expose
    private String clientType;
    @SerializedName("VisitPurposeType")
    @Expose
    private String visitPurposeType;
    @SerializedName("CIF")
    @Expose
    private String cIF;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("MobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("ProductType")
    @Expose
    private String productType;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("PS")
    @Expose
    private String pS;
    @SerializedName("ActivityDate")
    @Expose
    private String activityDate;
    @SerializedName("FollowupDate")
    @Expose
    private String followupDate;
    @SerializedName("Remarks")
    @Expose
    private String remarks;
    @SerializedName("ActivityStatus")
    @Expose
    private String activityStatus;
    @SerializedName("MakerName")
    @Expose
    private String makerName;
    @SerializedName("ActivityType")
    @Expose
    private String activityType;

    public String getActivityJournalID() {
        return activityJournalID;
    }

    public void setActivityJournalID(String activityJournalID) {
        this.activityJournalID = activityJournalID;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getVisitPurposeType() {
        return visitPurposeType;
    }

    public void setVisitPurposeType(String visitPurposeType) {
        this.visitPurposeType = visitPurposeType;
    }

    public String getCIF() {
        return cIF;
    }

    public void setCIF(String cIF) {
        this.cIF = cIF;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPS() {
        return pS;
    }

    public void setPS(String pS) {
        this.pS = pS;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public String getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(String followupDate) {
        this.followupDate = followupDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

}