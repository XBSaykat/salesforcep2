package net.maxproit.salesforce.masum.model.api.lead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.utility.DateUtils;

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

    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("customerId")
    @Expose
    private Integer customerId;
    @SerializedName("customerTitle")
    @Expose
    private String customerTitle;
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
    private Double offeredInterestRate;
    @SerializedName("offeredProcessFee")
    @Expose
    private Double offeredProcessFee;
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

    @SerializedName("city")
    @Expose
    private String city;


    @SerializedName("ps")
    @Expose
    private String ps;
    @SerializedName("branchCode")
    @Expose
    private Integer branchCode;

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }
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

    public Double getOfferedInterestRate() {
        return offeredInterestRate;
    }

    public void setOfferedInterestRate(Double offeredInterestRate) {
        this.offeredInterestRate = offeredInterestRate;
    }

    public Double getOfferedProcessFee() {
        return offeredProcessFee;
    }

    public void setOfferedProcessFee(Double offeredProcessFee) {
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

    public MyLeadDataModelApi myLeadDataModelApi(MyNewLead myNewLead) {
        MyLeadDataModelApi myLeadApi = new MyLeadDataModelApi();
        myLeadApi.setRmCode(myNewLead.getUserCode());
        myLeadApi.setUserName(myNewLead.getUserID());
        myLeadApi.setBranchName(myNewLead.getBranchName());
        myLeadApi.setBranchCode(myNewLead.getBranchCode());
        myLeadApi.setCustomerName(myNewLead.getUserName());
        myLeadApi.setCustomerId(myNewLead.getCusId());
        myLeadApi.setProfession(myNewLead.getProfession());
        myLeadApi.setOrganization(myNewLead.getOrganization());
        myLeadApi.setDesignation(myNewLead.getDesignation());
        myLeadApi.setMobileNumberId(myNewLead.getMobileId());
        myLeadApi.setMobileNumber(myNewLead.getPhone());
        myLeadApi.setAddressId(myNewLead.getAddressId());
        myLeadApi.setAddress(myNewLead.getAddress());
        myLeadApi.setSourceOfReference(myNewLead.getSourceRef());
        myLeadApi.setProductId(myNewLead.getProductCode());
        myLeadApi.setProduct(myNewLead.getProductType());
        myLeadApi.setProductSubCategoryId(myNewLead.getSubCode());
        myLeadApi.setProductSubCategory(myNewLead.getProductSubcategory());
        myLeadApi.setLoanAmount(Integer.valueOf(myNewLead.getLoanAmount().replace(",", "")));
        myLeadApi.setOfferedInterestRate(Double.valueOf(myNewLead.getOrInterest()));
        myLeadApi.setOfferedProcessFee(Double.valueOf(myNewLead.getOpFee()));
        myLeadApi.setDisbursementDate(DateUtils.getDateFormateForSqlite(myNewLead.getDisDate()));
        myLeadApi.setVisitId(myNewLead.getVisitId());
        myLeadApi.setFollowUp(myNewLead.getFollowUp());
        myLeadApi.setFollowUpDate(DateUtils.getDateFormateForSqlite(myNewLead.getVisitDate()));
        myLeadApi.setRemark(myNewLead.getRemark());
        myLeadApi.setLeadReferenceNo(myNewLead.getRefNumber());


        return myLeadApi;
    }

}