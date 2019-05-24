package net.maxproit.salesforce2.model.myprospect.updatemyprospect;

/**
 * Created by Md. Mehedi Hasan on 12/3/2018.
 * mehedipy@gmail.com
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {


    @SerializedName("agriculturalIncome")
    @Expose
    private Integer agriculturalIncome;
    @SerializedName("apartmentIncome")
    @Expose
    private Integer apartmentIncome;
    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("assetTypeId")
    @Expose
    private Integer assetTypeId;
    @SerializedName("branchCode")
    @Expose
    private Integer branchCode;
    @SerializedName("branchName")
    @Expose
    private String branchName;
    @SerializedName("businessIncome")
    @Expose
    private Integer businessIncome;
    @SerializedName("coApplicants")
    @Expose
    private List<CoApplicant> coApplicants = new ArrayList<>();
    @SerializedName("commercialSpaceIncome")
    @Expose
    private Integer commercialSpaceIncome;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("contactId")
    @Expose
    private Integer contactId;
    @SerializedName("countryOfBirth")
    @Expose
    private String countryOfBirth;
    @SerializedName("currentJobDuration")
    @Expose
    private String currentJobDuration;
    @SerializedName("customerId")
    @Expose
    private Integer customerId;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("customerTitle")
    @Expose
    private String customerTitle;

    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("districtOfBirth")
    @Expose
    private String districtOfBirth;
    @SerializedName("eTin")
    @Expose
    private String eTin;
    @SerializedName("emiOfOtherLoan")
    @Expose
    private Integer emiOfOtherLoan;
    @SerializedName("factoryIncome")
    @Expose
    private Integer factoryIncome;
    @SerializedName("familyExpenditure")
    @Expose
    private Integer familyExpenditure;
    @SerializedName("fatherName")
    @Expose
    private String fatherName;
    @SerializedName("fatherTitle")
    @Expose
    private String fatherTitle;
    @SerializedName("fee")
    @Expose
    private Float fee;
    @SerializedName("interestIncomeOfFDR")
    @Expose
    private Integer interestIncomeOfFDR;
    @SerializedName("intersetRate")
    @Expose
    private Float intersetRate;
    @SerializedName("leadReferenceNo")
    @Expose
    private String leadReferenceNo;
    @SerializedName("loanRequired")
    @Expose
    private Integer loanRequired;
    @SerializedName("loanTerm")
    @Expose
    private Integer loanTerm;
    @SerializedName("manufacturerName")
    @Expose
    private String manufacturerName;
    @SerializedName("manufacturerNameId")
    @Expose
    private Integer manufacturerNameId;
    @SerializedName("manufacturingCountry")
    @Expose
    private String manufacturingCountry;
    @SerializedName("manufacturingYear")
    @Expose
    private String manufacturingYear;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("mobileNoId")
    @Expose
    private Integer mobileNoId;
    @SerializedName("motherName")
    @Expose
    private String motherName;
    @SerializedName("motherTitle")
    @Expose
    private String motherTitle;
    @SerializedName("netSalary")
    @Expose
    private Integer netSalary;
    @SerializedName("netSalaryType")
    @Expose
    private String netSalaryType;
    @SerializedName("permanentAddress")
    @Expose
    private String permanentAddress;
    @SerializedName("permanentAddressCity")
    @Expose
    private String permanentAddressCity;
    @SerializedName("permanentAddressId")
    @Expose
    private Integer permanentAddressId;
    @SerializedName("permanentAddressPS")
    @Expose
    private String permanentAddressPS;
    @SerializedName("photoIdIssueDate")
    @Expose
    private String photoIdIssueDate;
    @SerializedName("photoIdNumber")
    @Expose
    private String photoIdNumber;
    @SerializedName("photoIdTypeCode")
    @Expose
    private Integer photoIdTypeCode;
    @SerializedName("presentAddress")
    @Expose
    private String presentAddress;
    @SerializedName("presentAddressCity")
    @Expose
    private String presentAddressCity;
    @SerializedName("presentAddressId")
    @Expose
    private Integer presentAddressId;
    @SerializedName("presentAddressPS")
    @Expose
    private String presentAddressPS;
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
    @SerializedName("relationshipWithApplicant")
    @Expose
    private String relationshipWithApplicant;
    @SerializedName("remittanceIncome")
    @Expose
    private Integer remittanceIncome;
    @SerializedName("rmCode")
    @Expose
    private String rmCode;
    @SerializedName("securityValue")
    @Expose
    private Integer securityValue;
    @SerializedName("segment")
    @Expose
    private String segment;
    @SerializedName("semipakaIncome")
    @Expose
    private Integer semipakaIncome;
    @SerializedName("spouseName")
    @Expose
    private String spouseName;
    @SerializedName("spouseTitle")
    @Expose
    private String spouseTitle;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tutionIncome")
    @Expose
    private Integer tutionIncome;
    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("CIBInformation")
    @Expose
    private String cIBInformation;
    @SerializedName("RuleEngineInformation")
    @Expose
    private String ruleEngineInformation;
    @SerializedName("exceptionList")
    @Expose
    private Integer exceptionList;

    public Integer getExceptionList() {
        return exceptionList;
    }

    public void setExceptionList(Integer exceptionList) {
        this.exceptionList = exceptionList;
    }

    public String getCIBInformation() {
        return cIBInformation;
    }

    public void setCIBInformation(String cIBInformation) {
        this.cIBInformation = cIBInformation;
    }

    public String getRuleEngineInformation() {
        return ruleEngineInformation;
    }

    public void setRuleEngineInformation(String ruleEngineInformation) {
        this.ruleEngineInformation = ruleEngineInformation;
    }
    public Integer getAgriculturalIncome() {
        return agriculturalIncome;
    }

    public void setAgriculturalIncome(Integer agriculturalIncome) {
        this.agriculturalIncome = agriculturalIncome;
    }

    public Integer getApartmentIncome() {
        return apartmentIncome;
    }

    public void setApartmentIncome(Integer apartmentIncome) {
        this.apartmentIncome = apartmentIncome;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Integer getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(Integer assetTypeId) {
        this.assetTypeId = assetTypeId;
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

    public Integer getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(Integer businessIncome) {
        this.businessIncome = businessIncome;
    }

    public List<CoApplicant> getCoApplicants() {
        return coApplicants;
    }

    public void setCoApplicants(List<CoApplicant> coApplicants) {
        this.coApplicants = coApplicants;
    }

    public Integer getCommercialSpaceIncome() {
        return commercialSpaceIncome;
    }

    public void setCommercialSpaceIncome(Integer commercialSpaceIncome) {
        this.commercialSpaceIncome = commercialSpaceIncome;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getCurrentJobDuration() {
        return currentJobDuration;
    }

    public void setCurrentJobDuration(String currentJobDuration) {
        this.currentJobDuration = currentJobDuration;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDistrictOfBirth() {
        return districtOfBirth;
    }

    public void setDistrictOfBirth(String districtOfBirth) {
        this.districtOfBirth = districtOfBirth;
    }

    public String getETin() {
        return eTin;
    }

    public void setETin(String eTin) {
        this.eTin = eTin;
    }

    public Integer getEmiOfOtherLoan() {
        return emiOfOtherLoan;
    }

    public void setEmiOfOtherLoan(Integer emiOfOtherLoan) {
        this.emiOfOtherLoan = emiOfOtherLoan;
    }

    public Integer getFactoryIncome() {
        return factoryIncome;
    }

    public void setFactoryIncome(Integer factoryIncome) {
        this.factoryIncome = factoryIncome;
    }

    public Integer getFamilyExpenditure() {
        return familyExpenditure;
    }

    public void setFamilyExpenditure(Integer familyExpenditure) {
        this.familyExpenditure = familyExpenditure;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Integer getInterestIncomeOfFDR() {
        return interestIncomeOfFDR;
    }

    public void setInterestIncomeOfFDR(Integer interestIncomeOfFDR) {
        this.interestIncomeOfFDR = interestIncomeOfFDR;
    }

    public Float getIntersetRate() {
        return intersetRate;
    }

    public void setIntersetRate(Float intersetRate) {
        this.intersetRate = intersetRate;
    }

    public String getLeadReferenceNo() {
        return leadReferenceNo;
    }

    public void setLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
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

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Integer getManufacturerNameId() {
        return manufacturerNameId;
    }

    public void setManufacturerNameId(Integer manufacturerNameId) {
        this.manufacturerNameId = manufacturerNameId;
    }

    public String getManufacturingCountry() {
        return manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getMobileNoId() {
        return mobileNoId;
    }

    public void setMobileNoId(Integer mobileNoId) {
        this.mobileNoId = mobileNoId;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Integer getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Integer netSalary) {
        this.netSalary = netSalary;
    }

    public String getNetSalaryType() {
        return netSalaryType;
    }

    public void setNetSalaryType(String netSalaryType) {
        this.netSalaryType = netSalaryType;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentAddressCity() {
        return permanentAddressCity;
    }

    public void setPermanentAddressCity(String permanentAddressCity) {
        this.permanentAddressCity = permanentAddressCity;
    }

    public Integer getPermanentAddressId() {
        return permanentAddressId;
    }

    public void setPermanentAddressId(Integer permanentAddressId) {
        this.permanentAddressId = permanentAddressId;
    }

    public String getPermanentAddressPS() {
        return permanentAddressPS;
    }

    public void setPermanentAddressPS(String permanentAddressPS) {
        this.permanentAddressPS = permanentAddressPS;
    }

    public String getPhotoIdIssueDate() {
        return photoIdIssueDate;
    }

    public void setPhotoIdIssueDate(String photoIdIssueDate) {
        this.photoIdIssueDate = photoIdIssueDate;
    }

    public String getPhotoIdNumber() {
        return photoIdNumber;
    }

    public void setPhotoIdNumber(String photoIdNumber) {
        this.photoIdNumber = photoIdNumber;
    }

    public Integer getPhotoIdTypeCode() {
        return photoIdTypeCode;
    }

    public void setPhotoIdTypeCode(Integer photoIdTypeCode) {
        this.photoIdTypeCode = photoIdTypeCode;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPresentAddressCity() {
        return presentAddressCity;
    }

    public void setPresentAddressCity(String presentAddressCity) {
        this.presentAddressCity = presentAddressCity;
    }

    public Integer getPresentAddressId() {
        return presentAddressId;
    }

    public void setPresentAddressId(Integer presentAddressId) {
        this.presentAddressId = presentAddressId;
    }

    public String getPresentAddressPS() {
        return presentAddressPS;
    }

    public void setPresentAddressPS(String presentAddressPS) {
        this.presentAddressPS = presentAddressPS;
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

    public String getRelationshipWithApplicant() {
        return relationshipWithApplicant;
    }

    public void setRelationshipWithApplicant(String relationshipWithApplicant) {
        this.relationshipWithApplicant = relationshipWithApplicant;
    }

    public Integer getRemittanceIncome() {
        return remittanceIncome;
    }

    public void setRemittanceIncome(Integer remittanceIncome) {
        this.remittanceIncome = remittanceIncome;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public Integer getSecurityValue() {
        return securityValue;
    }

    public void setSecurityValue(Integer securityValue) {
        this.securityValue = securityValue;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public Integer getSemipakaIncome() {
        return semipakaIncome;
    }

    public void setSemipakaIncome(Integer semipakaIncome) {
        this.semipakaIncome = semipakaIncome;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTutionIncome() {
        return tutionIncome;
    }

    public void setTutionIncome(Integer tutionIncome) {
        this.tutionIncome = tutionIncome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCustomerTitle() {
        return customerTitle;
    }

    public void setCustomerTitle(String customerTitle) {
        this.customerTitle = customerTitle;
    }

    public String geteTin() {
        return eTin;
    }

    public void seteTin(String eTin) {
        this.eTin = eTin;
    }

    public String getFatherTitle() {
        return fatherTitle;
    }

    public void setFatherTitle(String fatherTitle) {
        this.fatherTitle = fatherTitle;
    }

    public String getMotherTitle() {
        return motherTitle;
    }

    public void setMotherTitle(String motherTitle) {
        this.motherTitle = motherTitle;
    }

    public String getSpouseTitle() {
        return spouseTitle;
    }

    public void setSpouseTitle(String spouseTitle) {
        this.spouseTitle = spouseTitle;
    }

    public String getcIBInformation() {
        return cIBInformation;
    }

    public void setcIBInformation(String cIBInformation) {
        this.cIBInformation = cIBInformation;
    }
}
