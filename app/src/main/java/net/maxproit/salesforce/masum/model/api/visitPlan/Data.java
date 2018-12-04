package net.maxproit.salesforce.masum.model.api.visitPlan;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("ActivityDate")
    @Expose
    private String activityDate;
    @SerializedName("ActivityJournalID")
    @Expose
    private Integer activityJournalID;
    @SerializedName("ActivityStatus")
    @Expose
    private String activityStatus;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("ClientType")
    @Expose
    private String clientType;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("Maker")
    @Expose
    private String maker;
    @SerializedName("MobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("ProductType")
    @Expose
    private String productType;
    @SerializedName("Ps")
    @Expose
    private String ps;
    @SerializedName("Remarks")
    @Expose
    private String remarks;
    @SerializedName("VisitPurposeType")
    @Expose
    private String visitPurposeType;

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public Integer getActivityJournalID() {
        return activityJournalID;
    }

    public void setActivityJournalID(Integer activityJournalID) {
        this.activityJournalID = activityJournalID;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
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

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getVisitPurposeType() {
        return visitPurposeType;
    }

    public void setVisitPurposeType(String visitPurposeType) {
        this.visitPurposeType = visitPurposeType;
    }

}