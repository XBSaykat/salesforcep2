package net.maxproit.salesforce.masum.model.api.myactivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable {

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
@SerializedName("Ps")
@Expose
private String ps;
@SerializedName("Remarks")
@Expose
private String remarks;
@SerializedName("VisitPurposeType")
@Expose
private String visitPurposeType;
@SerializedName("FollowupDate")
@Expose
private String followupDate;
@SerializedName("FollowupRemarks")
@Expose
private String followupRemarks;
@SerializedName("MobileNo")
@Expose
private String mobileNo;
@SerializedName("ProductType")
@Expose
private String productType;

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

public String getFollowupDate() {
return followupDate;
}

public void setFollowupDate(String followupDate) {
this.followupDate = followupDate;
}

public String getFollowupRemarks() {
return followupRemarks;
}

public void setFollowupRemarks(String followupRemarks) {
this.followupRemarks = followupRemarks;
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

    @Override
    public String toString() {
        return "Data{" +
                "activityDate='" + activityDate + '\'' +
                ", activityJournalID=" + activityJournalID +
                ", activityStatus='" + activityStatus + '\'' +
                ", preCity='" + city + '\'' +
                ", clientType='" + clientType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", maker='" + maker + '\'' +
                ", ps='" + ps + '\'' +
                ", remarks='" + remarks + '\'' +
                ", visitPurposeType='" + visitPurposeType + '\'' +
                ", followupDate='" + followupDate + '\'' +
                ", followupRemarks='" + followupRemarks + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }
}