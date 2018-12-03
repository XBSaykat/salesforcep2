package net.maxproit.salesforce.masum.model.api.lead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyLeadDataModelApi {

@SerializedName("leadReferenceNo")
@Expose
private String leadReferenceNo;
@SerializedName("rmCode")
@Expose
private String rmCode;
@SerializedName("userName")
@Expose
private String userName;
@SerializedName("branchName")
@Expose
private String branchName;
@SerializedName("branchCode")
@Expose
private Integer branchCode;
@SerializedName("customerName")
@Expose
private String customerName;
@SerializedName("customerId")
@Expose
private Integer customerId;
@SerializedName("profession")
@Expose
private String profession;
@SerializedName("organization")
@Expose
private String organization;
@SerializedName("designation")
@Expose
private String designation;
@SerializedName("mobileNumberId")
@Expose
private Integer mobileNumberId;
@SerializedName("mobileNumber")
@Expose
private String mobileNumber;
@SerializedName("addressId")
@Expose
private Integer addressId;
@SerializedName("address")
@Expose
private String address;
@SerializedName("sourceOfReference")
@Expose
private String sourceOfReference;
@SerializedName("productId")
@Expose
private Integer productId;
@SerializedName("product")
@Expose
private String product;
@SerializedName("productSubCategoryId")
@Expose
private Integer productSubCategoryId;
@SerializedName("productSubCategory")
@Expose
private String productSubCategory;
@SerializedName("loanAmount")
@Expose
private Integer loanAmount;
@SerializedName("offeredInterestRate")
@Expose
private Integer offeredInterestRate;
@SerializedName("offeredProcessFee")
@Expose
private Integer offeredProcessFee;
@SerializedName("disbursementDate")
@Expose
private String disbursementDate;
@SerializedName("visitId")
@Expose
private Integer visitId;
@SerializedName("followUp")
@Expose
private String followUp;
@SerializedName("followUpDate")
@Expose
private String followUpDate;
@SerializedName("remark")
@Expose
private String remark;


public String getLeadReferenceNo() {
return leadReferenceNo;
}

public void setLeadReferenceNo(String leadReferenceNo) {
this.leadReferenceNo = leadReferenceNo;
}

public String getRmCode() {
return rmCode;
}

public void setRmCode(String rmCode) {
this.rmCode = rmCode;
}

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
}

public String getBranchName() {
return branchName;
}

public void setBranchName(String branchName) {
this.branchName = branchName;
}

public Integer getBranchCode(int i) {
return branchCode;
}

public void setBranchCode(Integer branchCode) {
this.branchCode = branchCode;
}

public String getCustomerName() {
return customerName;
}

public void setCustomerName(String customerName) {
this.customerName = customerName;
}

public Integer getCustomerId() {
return customerId;
}

public void setCustomerId(Integer customerId) {
this.customerId = customerId;
}

public String getProfession() {
return profession;
}

public void setProfession(String profession) {
this.profession = profession;
}

public String getOrganization() {
return organization;
}

public void setOrganization(String organization) {
this.organization = organization;
}

public String getDesignation() {
return designation;
}

public void setDesignation(String designation) {
this.designation = designation;
}

public Integer getMobileNumberId() {
return mobileNumberId;
}

public void setMobileNumberId(Integer mobileNumberId) {
this.mobileNumberId = mobileNumberId;
}

public String getMobileNumber() {
return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
this.mobileNumber = mobileNumber;
}

public Integer getAddressId() {
return addressId;
}

public void setAddressId(Integer addressId) {
this.addressId = addressId;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getSourceOfReference() {
return sourceOfReference;
}

public void setSourceOfReference(String sourceOfReference) {
this.sourceOfReference = sourceOfReference;
}

public Integer getProductId() {
return productId;
}

public void setProductId(Integer productId) {
this.productId = productId;
}

public String getProduct() {
return product;
}

public void setProduct(String product) {
this.product = product;
}

public Integer getProductSubCategoryId() {
return productSubCategoryId;
}

public void setProductSubCategoryId(Integer productSubCategoryId) {
this.productSubCategoryId = productSubCategoryId;
}

public String getProductSubCategory() {
return productSubCategory;
}

public void setProductSubCategory(String productSubCategory) {
this.productSubCategory = productSubCategory;
}

public Integer getLoanAmount() {
return loanAmount;
}

public void setLoanAmount(Integer loanAmount) {
this.loanAmount = loanAmount;
}

public Integer getOfferedInterestRate() {
return offeredInterestRate;
}

public void setOfferedInterestRate(Integer offeredInterestRate) {
this.offeredInterestRate = offeredInterestRate;
}

public Integer getOfferedProcessFee() {
return offeredProcessFee;
}

public void setOfferedProcessFee(Integer offeredProcessFee) {
this.offeredProcessFee = offeredProcessFee;
}

public String getDisbursementDate() {
return disbursementDate;
}

public void setDisbursementDate(String disbursementDate) {
this.disbursementDate = disbursementDate;
}

public Integer getVisitId() {
return visitId;
}

public void setVisitId(Integer visitId) {
this.visitId = visitId;
}

public String getFollowUp() {
return followUp;
}

public void setFollowUp(String followUp) {
this.followUp = followUp;
}

public String getFollowUpDate() {
return followUpDate;
}

public void setFollowUpDate(String followUpDate) {
this.followUpDate = followUpDate;
}

public String getRemark() {
return remark;
}

public void setRemark(String remark) {
this.remark = remark;
}

}