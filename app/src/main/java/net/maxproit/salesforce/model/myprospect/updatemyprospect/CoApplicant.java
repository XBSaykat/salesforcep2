package net.maxproit.salesforce.model.myprospect.updatemyprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/3/2018.
 * mehedipy@gmail.com
 */


public class CoApplicant {


    @SerializedName("agriculturalIncome")
    @Expose
    private double agriculturalIncome;
    @SerializedName("apartmentIncome")
    @Expose
    private double apartmentIncome;
    @SerializedName("businessIncome")
    @Expose
    private double businessIncome;
    @SerializedName("commercialSpaceIncome")
    @Expose
    private double commercialSpaceIncome;
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
    @SerializedName("factoryIncome")
    @Expose
    private double factoryIncome;
    @SerializedName("fatherName")
    @Expose
    private String fatherName;
    @SerializedName("fatherTitle")
    @Expose
    private String fatherTitle;
    @SerializedName("interestIncomeOfFDR")
    @Expose
    private double interestIncomeOfFDR;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("motherName")
    @Expose
    private String motherName;
    @SerializedName("motherTitle")
    @Expose
    private String motherTitle;
    @SerializedName("netSalary")
    @Expose
    private double netSalary;
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
    @SerializedName("profession")
    @Expose
    private String profession;
    @SerializedName("relationshipWithApplicant")
    @Expose
    private String relationshipWithApplicant;
    @SerializedName("remittanceIncome")
    @Expose
    private double remittanceIncome;
    @SerializedName("semipakaIncome")
    @Expose
    private double semipakaIncome;
    @SerializedName("spouseName")
    @Expose
    private String spouseName;

    @SerializedName("spouseTitle")
    @Expose
    private String spouseTitle;
    @SerializedName("tutionIncome")
    @Expose
    private double tutionIncome;
    @SerializedName("mobileNoId")
    @Expose
    private Integer mobileNoId;
    @SerializedName("exceptionList")
    @Expose
    private Integer exceptionList;

    public Integer getExceptionList() {
        return exceptionList;
    }

    public void setExceptionList(Integer exceptionList) {
        this.exceptionList = exceptionList;
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

    public Integer getMobileNoId() {
        return mobileNoId;
    }

    public void setMobileNoId(Integer mobileNoId) {
        this.mobileNoId = mobileNoId;
    }

    public double getAgriculturalIncome() {
        return agriculturalIncome;
    }

    public void setAgriculturalIncome(double agriculturalIncome) {
        this.agriculturalIncome = agriculturalIncome;
    }

    public double getApartmentIncome() {
        return apartmentIncome;
    }

    public void setApartmentIncome(double apartmentIncome) {
        this.apartmentIncome = apartmentIncome;
    }

    public double getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(double businessIncome) {
        this.businessIncome = businessIncome;
    }

    public double getCommercialSpaceIncome() {
        return commercialSpaceIncome;
    }

    public void setCommercialSpaceIncome(double commercialSpaceIncome) {
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

    public double getFactoryIncome() {
        return factoryIncome;
    }

    public void setFactoryIncome(double factoryIncome) {
        this.factoryIncome = factoryIncome;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public double getInterestIncomeOfFDR() {
        return interestIncomeOfFDR;
    }

    public void setInterestIncomeOfFDR(double interestIncomeOfFDR) {
        this.interestIncomeOfFDR = interestIncomeOfFDR;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
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

    public double getRemittanceIncome() {
        return remittanceIncome;
    }

    public void setRemittanceIncome(double remittanceIncome) {
        this.remittanceIncome = remittanceIncome;
    }

    public double getSemipakaIncome() {
        return semipakaIncome;
    }

    public void setSemipakaIncome(double semipakaIncome) {
        this.semipakaIncome = semipakaIncome;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public double getTutionIncome() {
        return tutionIncome;
    }

    public void setTutionIncome(double tutionIncome) {
        this.tutionIncome = tutionIncome;
    }

}
