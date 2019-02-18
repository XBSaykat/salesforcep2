
package net.maxproit.salesforce.masum.model.prospectmodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatePostpect {

    @SerializedName("leadReferenceNo")
    @Expose
    private String leadReferenceNo;
    @SerializedName("status")
    @Expose
    private String status;
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
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("customerId")
    @Expose
    private Integer customerId;
    @SerializedName("contactId")
    @Expose
    private Integer contactId;
    @SerializedName("segment")
    @Expose
    private String segment;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("districtOfBirth")
    @Expose
    private String districtOfBirth;
    @SerializedName("countryOfBirth")
    @Expose
    private String countryOfBirth;
    @SerializedName("photoIdTypeCode")
    @Expose
    private Integer photoIdTypeCode;
    @SerializedName("photoIdNumber")
    @Expose
    private String photoIdNumber;
    @SerializedName("photoIdIssueDate")
    @Expose
    private String photoIdIssueDate;
    @SerializedName("eTin")
    @Expose
    private String eTin;
    @SerializedName("fatherName")
    @Expose
    private String fatherName;
    @SerializedName("motherName")
    @Expose
    private String motherName;
    @SerializedName("spouseName")
    @Expose
    private String spouseName;
    @SerializedName("profession")
    @Expose
    private String profession;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("currentJobDuration")
    @Expose
    private String currentJobDuration;
    @SerializedName("relationshipWithApplicant")
    @Expose
    private String relationshipWithApplicant;
    @SerializedName("permanentAddressId")
    @Expose
    private Integer permanentAddressId;
    @SerializedName("permanentAddress")
    @Expose
    private String permanentAddress;
    @SerializedName("permanentAddressPS")
    @Expose
    private String permanentAddressPS;
    @SerializedName("permanentAddressCity")
    @Expose
    private String permanentAddressCity;
    @SerializedName("presentAddressId")
    @Expose
    private Integer presentAddressId;
    @SerializedName("presentAddress")
    @Expose
    private String presentAddress;
    @SerializedName("presentAddressPS")
    @Expose
    private String presentAddressPS;
    @SerializedName("presentAddressCity")
    @Expose
    private String presentAddressCity;
    @SerializedName("mobileNoId")
    @Expose
    private Integer mobileNoId;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("netSalaryType")
    @Expose
    private String netSalaryType;
    @SerializedName("netSalary")
    @Expose
    private double netSalary;
    @SerializedName("businessIncome")
    @Expose
    private double businessIncome;
    @SerializedName("apartmentIncome")
    @Expose
    private double apartmentIncome;
    @SerializedName("semipakaIncome")
    @Expose
    private double semipakaIncome;
    @SerializedName("commercialSpaceIncome")
    @Expose
    private double commercialSpaceIncome;
    @SerializedName("factoryIncome")
    @Expose
    private double factoryIncome;
    @SerializedName("agriculturalIncome")
    @Expose
    private double agriculturalIncome;
    @SerializedName("tutionIncome")
    @Expose
    private double tutionIncome;
    @SerializedName("remittanceIncome")
    @Expose
    private double remittanceIncome;
    @SerializedName("interestIncomeOfFDR")
    @Expose
    private double interestIncomeOfFDR;
    @SerializedName("familyExpenditure")
    @Expose
    private double familyExpenditure;
    @SerializedName("emiOfOtherLoan")
    @Expose
    private double emiOfOtherLoan;
    @SerializedName("securityValue")
    @Expose
    private double securityValue;
    @SerializedName("assetTypeId")
    @Expose
    private Integer assetTypeId;
    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("manufacturerNameId")
    @Expose
    private Integer manufacturerNameId;
    @SerializedName("manufacturerName")
    @Expose
    private String manufacturerName;
    @SerializedName("manufacturingYear")
    @Expose
    private String manufacturingYear;
    @SerializedName("manufacturingCountry")
    @Expose
    private String manufacturingCountry;
    @SerializedName("loanRequired")
    @Expose
    private Integer loanRequired;
    @SerializedName("loanTerm")
    @Expose
    private Integer loanTerm;
    @SerializedName("intersetRate")
    @Expose
    private double intersetRate;
    @SerializedName("fee")
    @Expose
    private double fee;
    @SerializedName("coApplicants")
    @Expose
    private List<CoApplicant> coApplicants = null;

    public String getLeadReferenceNo() {
        return leadReferenceNo;
    }

    public void setLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
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

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDistrictOfBirth() {
        return districtOfBirth;
    }

    public void setDistrictOfBirth(String districtOfBirth) {
        this.districtOfBirth = districtOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public Integer getPhotoIdTypeCode() {
        return photoIdTypeCode;
    }

    public void setPhotoIdTypeCode(Integer photoIdTypeCode) {
        this.photoIdTypeCode = photoIdTypeCode;
    }

    public String getPhotoIdNumber() {
        return photoIdNumber;
    }

    public void setPhotoIdNumber(String photoIdNumber) {
        this.photoIdNumber = photoIdNumber;
    }

    public String getPhotoIdIssueDate() {
        return photoIdIssueDate;
    }

    public void setPhotoIdIssueDate(String photoIdIssueDate) {
        this.photoIdIssueDate = photoIdIssueDate;
    }

    public String getETin() {
        return eTin;
    }

    public void setETin(String eTin) {
        this.eTin = eTin;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCurrentJobDuration() {
        return currentJobDuration;
    }

    public void setCurrentJobDuration(String currentJobDuration) {
        this.currentJobDuration = currentJobDuration;
    }

    public String getRelationshipWithApplicant() {
        return relationshipWithApplicant;
    }

    public void setRelationshipWithApplicant(String relationshipWithApplicant) {
        this.relationshipWithApplicant = relationshipWithApplicant;
    }

    public Integer getPermanentAddressId() {
        return permanentAddressId;
    }

    public void setPermanentAddressId(Integer permanentAddressId) {
        this.permanentAddressId = permanentAddressId;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentAddressPS() {
        return permanentAddressPS;
    }

    public void setPermanentAddressPS(String permanentAddressPS) {
        this.permanentAddressPS = permanentAddressPS;
    }

    public String getPermanentAddressCity() {
        return permanentAddressCity;
    }

    public void setPermanentAddressCity(String permanentAddressCity) {
        this.permanentAddressCity = permanentAddressCity;
    }

    public Integer getPresentAddressId() {
        return presentAddressId;
    }

    public void setPresentAddressId(Integer presentAddressId) {
        this.presentAddressId = presentAddressId;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPresentAddressPS() {
        return presentAddressPS;
    }

    public void setPresentAddressPS(String presentAddressPS) {
        this.presentAddressPS = presentAddressPS;
    }

    public String getPresentAddressCity() {
        return presentAddressCity;
    }

    public void setPresentAddressCity(String presentAddressCity) {
        this.presentAddressCity = presentAddressCity;
    }

    public Integer getMobileNoId() {
        return mobileNoId;
    }

    public void setMobileNoId(Integer mobileNoId) {
        this.mobileNoId = mobileNoId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getNetSalaryType() {
        return netSalaryType;
    }

    public void setNetSalaryType(String netSalaryType) {
        this.netSalaryType = netSalaryType;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(double businessIncome) {
        this.businessIncome = businessIncome;
    }

    public double getApartmentIncome() {
        return apartmentIncome;
    }

    public void setApartmentIncome(double apartmentIncome) {
        this.apartmentIncome = apartmentIncome;
    }

    public double getSemipakaIncome() {
        return semipakaIncome;
    }

    public void setSemipakaIncome(double semipakaIncome) {
        this.semipakaIncome = semipakaIncome;
    }

    public double getCommercialSpaceIncome() {
        return commercialSpaceIncome;
    }

    public void setCommercialSpaceIncome(double commercialSpaceIncome) {
        this.commercialSpaceIncome = commercialSpaceIncome;
    }

    public double getFactoryIncome() {
        return factoryIncome;
    }

    public void setFactoryIncome(Integer factoryIncome) {
        this.factoryIncome = factoryIncome;
    }

    public double getAgriculturalIncome() {
        return agriculturalIncome;
    }

    public void setAgriculturalIncome(double agriculturalIncome) {
        this.agriculturalIncome = agriculturalIncome;
    }

    public double getTutionIncome() {
        return tutionIncome;
    }

    public void setTutionIncome(double tutionIncome) {
        this.tutionIncome = tutionIncome;
    }

    public double getRemittanceIncome() {
        return remittanceIncome;
    }

    public void setRemittanceIncome(double remittanceIncome) {
        this.remittanceIncome = remittanceIncome;
    }

    public double getInterestIncomeOfFDR() {
        return interestIncomeOfFDR;
    }

    public void setInterestIncomeOfFDR(double interestIncomeOfFDR) {
        this.interestIncomeOfFDR = interestIncomeOfFDR;
    }

    public double getFamilyExpenditure() {
        return familyExpenditure;
    }

    public void setFamilyExpenditure(double familyExpenditure) {
        this.familyExpenditure = familyExpenditure;
    }

    public double getEmiOfOtherLoan() {
        return emiOfOtherLoan;
    }

    public void setEmiOfOtherLoan(double emiOfOtherLoan) {
        this.emiOfOtherLoan = emiOfOtherLoan;
    }

    public double getSecurityValue() {
        return securityValue;
    }

    public void setSecurityValue(Integer securityValue) {
        this.securityValue = securityValue;
    }

    public Integer getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(Integer assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Integer getManufacturerNameId() {
        return manufacturerNameId;
    }

    public void setManufacturerNameId(Integer manufacturerNameId) {
        this.manufacturerNameId = manufacturerNameId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public String getManufacturingCountry() {
        return manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

    public Integer getLoanRequired() {
        return loanRequired;
    }

    public void setLoanRequired(Integer loanRequired) {
        this.loanRequired = loanRequired;
    }

    public Integer getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Integer loanTerm) {
        this.loanTerm = loanTerm;
    }

    public double getIntersetRate() {
        return intersetRate;
    }

    public void setIntersetRate(double intersetRate) {
        this.intersetRate = intersetRate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<CoApplicant> getCoApplicants() {
        return coApplicants;
    }

    public void setCoApplicants(List<CoApplicant> coApplicants) {
        this.coApplicants = coApplicants;
    }

}
