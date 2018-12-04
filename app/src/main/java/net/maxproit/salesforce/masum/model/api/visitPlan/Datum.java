package net.maxproit.salesforce.masum.model.api.visitPlan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum {

@SerializedName("ActivityJournalID")
@Expose
private String activityJournalID;
@SerializedName("ActivitySetID")
@Expose
private String activitySetID;
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
@SerializedName("ActivitySource")
@Expose
private String activitySource;
@SerializedName("RecordStatus")
@Expose
private String recordStatus;
@SerializedName("MakerName")
@Expose
private String makerName;
@SerializedName("MakeDate")
@Expose
private String makeDate;
@SerializedName("LeadReferenceNo")
@Expose
private String leadReferenceNo;




public String getActivityJournalID() {
return activityJournalID;
}

public void setActivityJournalID(String activityJournalID) {
this.activityJournalID = activityJournalID;
}

public String getActivitySetID() {
return activitySetID;
}

public void setActivitySetID(String activitySetID) {
this.activitySetID = activitySetID;
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

public String getActivitySource() {
return activitySource;
}

public void setActivitySource(String activitySource) {
this.activitySource = activitySource;
}

public String getRecordStatus() {
return recordStatus;
}

public void setRecordStatus(String recordStatus) {
this.recordStatus = recordStatus;
}

public String getMakerName() {
return makerName;
}

public void setMakerName(String makerName) {
this.makerName = makerName;
}

public String getMakeDate() {
return makeDate;
}

public void setMakeDate(String makeDate) {
this.makeDate = makeDate;
}

public String getLeadReferenceNo() {
return leadReferenceNo;
}

public void setLeadReferenceNo(String leadReferenceNo) {
this.leadReferenceNo = leadReferenceNo;
}

}