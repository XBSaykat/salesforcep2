package net.maxproit.salesforce2.masum.model.api.lead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("addressId")
    @Expose
    private Integer addressId;
    @SerializedName("branchCode")
    @Expose
    private Integer branchCode;
    @SerializedName("branchName")
    @Expose
    private String branchName;
    @SerializedName("customerId")
    @Expose
    private Integer customerId;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("customerTitle")
    @Expose
    private String customerTitle;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("disbursementDate")
    @Expose
    private String disbursementDate;
    @SerializedName("followUp")
    @Expose
    private String followUp;
    @SerializedName("followUpDate")
    @Expose
    private String followUpDate;
    @SerializedName("leadReferenceNo")
    @Expose
    private String leadReferenceNo;
    @SerializedName("loanAmount")
    @Expose
    private Integer loanAmount;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("mobileNumberId")
    @Expose
    private Integer mobileNumberId;
    @SerializedName("offeredInterestRate")
    @Expose
    private Float offeredInterestRate;
    @SerializedName("offeredProcessFee")
    @Expose
    private Float offeredProcessFee;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("productSubCategory")
    @Expose
    private String productSubCategory;
    @SerializedName("productSubCategoryId")
    @Expose
    private Integer productSubCategoryId;
    @SerializedName("profession")
    @Expose
    private String profession;
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("rmCode")
    @Expose
    private String rmCode;
    @SerializedName("sourceOfReference")
    @Expose
    private String sourceOfReference;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("visitId")
    @Expose
    private Integer visitId;

    @SerializedName("city")
    @Expose
    private String city;


    @SerializedName("ps")
    @Expose
    private String ps;


    public String getCustomerTitle() {
        return customerTitle;
    }

    public void setCustomerTitle(String customerTitle) {
        this.customerTitle = customerTitle;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(String disbursementDate) {
        this.disbursementDate = disbursementDate;
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

    public String getLeadReferenceNo() {
        return leadReferenceNo;
    }

    public void setLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getMobileNumberId() {
        return mobileNumberId;
    }

    public void setMobileNumberId(Integer mobileNumberId) {
        this.mobileNumberId = mobileNumberId;
    }

    public Float getOfferedInterestRate() {
        return offeredInterestRate;
    }

    public void setOfferedInterestRate(Float offeredInterestRate) {
        this.offeredInterestRate = offeredInterestRate;
    }

    public Float getOfferedProcessFee() {
        return offeredProcessFee;
    }

    public void setOfferedProcessFee(Float offeredProcessFee) {
        this.offeredProcessFee = offeredProcessFee;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProductSubCategoryId() {
        return productSubCategoryId;
    }

    public void setProductSubCategoryId(Integer productSubCategoryId) {
        this.productSubCategoryId = productSubCategoryId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getSourceOfReference() {
        return sourceOfReference;
    }

    public void setSourceOfReference(String sourceOfReference) {
        this.sourceOfReference = sourceOfReference;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

}