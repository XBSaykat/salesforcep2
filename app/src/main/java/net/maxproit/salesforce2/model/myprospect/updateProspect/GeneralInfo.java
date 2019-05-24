
package net.maxproit.salesforce2.model.myprospect.updateProspect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeneralInfo {

    @SerializedName("TradeLicenseNumber")
    @Expose
    private String tradeLicenseNumber;
    @SerializedName("applicantMobile")
    @Expose
    private String applicantMobile;
    @SerializedName("businessSince")
    @Expose
    private Object businessSince;
    @SerializedName("commencementDate")
    @Expose
    private String commencementDate;
    @SerializedName("incorporationNumber")
    @Expose
    private Object incorporationNumber;
    @SerializedName("industryType")
    @Expose
    private String industryType;
    @SerializedName("legalStatus")
    @Expose
    private String legalStatus;
    @SerializedName("licenseExpiredate")

    @Expose
    private String licenseExpiredate;
    @SerializedName("licenseIssuedate")
    @Expose
    private String licenseIssuedate;
    @SerializedName("loanPurposeTypeCode")
    @Expose
    private int loanPurposeTypeCode;
    @SerializedName("natureOfBusiness")
    @Expose
    private String natureOfBusiness;
    @SerializedName("relationShip")
    @Expose
    private String relationShip;
    @SerializedName("tinNumber")
    @Expose
    private String tinNumber;

    public String getTradeLicenseNumber() {
        return tradeLicenseNumber;
    }

    public void setTradeLicenseNumber(String tradeLicenseNumber) {
        this.tradeLicenseNumber = tradeLicenseNumber;
    }

    public GeneralInfo withTradeLicenseNumber(String tradeLicenseNumber) {
        this.tradeLicenseNumber = tradeLicenseNumber;
        return this;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public GeneralInfo withApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
        return this;
    }

    public Object getBusinessSince() {
        return businessSince;
    }

    public void setBusinessSince(Object businessSince) {
        this.businessSince = businessSince;
    }

    public GeneralInfo withBusinessSince(Object businessSince) {
        this.businessSince = businessSince;
        return this;
    }

    public String getCommencementDate() {
        return commencementDate;
    }

    public void setCommencementDate(String commencementDate) {
        this.commencementDate = commencementDate;
    }

    public GeneralInfo withCommencementDate(String commencementDate) {
        this.commencementDate = commencementDate;
        return this;
    }

    public Object getIncorporationNumber() {
        return incorporationNumber;
    }

    public void setIncorporationNumber(Object incorporationNumber) {
        this.incorporationNumber = incorporationNumber;
    }

    public GeneralInfo withIncorporationNumber(Object incorporationNumber) {
        this.incorporationNumber = incorporationNumber;
        return this;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public GeneralInfo withIndustryType(String industryType) {
        this.industryType = industryType;
        return this;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public GeneralInfo withLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
        return this;
    }

    public String getLicenseExpiredate() {
        return licenseExpiredate;
    }

    public void setLicenseExpiredate(String licenseExpiredate) {
        this.licenseExpiredate = licenseExpiredate;
    }

    public GeneralInfo withLicenseExpiredate(String licenseExpiredate) {
        this.licenseExpiredate = licenseExpiredate;
        return this;
    }

    public String getLicenseIssuedate() {
        return licenseIssuedate;
    }

    public void setLicenseIssuedate(String licenseIssuedate) {
        this.licenseIssuedate = licenseIssuedate;
    }

    public GeneralInfo withLicenseIssuedate(String licenseIssuedate) {
        this.licenseIssuedate = licenseIssuedate;
        return this;
    }

    public int getLoanPurposeTypeCode() {
        return loanPurposeTypeCode;
    }

    public void setLoanPurposeTypeCode(int loanPurposeTypeCode) {
        this.loanPurposeTypeCode = loanPurposeTypeCode;
    }

    public GeneralInfo withLoanPurposeTypeCode(int loanPurposeTypeCode) {
        this.loanPurposeTypeCode = loanPurposeTypeCode;
        return this;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public GeneralInfo withNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
        return this;
    }

    public String getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip;
    }

    public GeneralInfo withRelationShip(String relationShip) {
        this.relationShip = relationShip;
        return this;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public GeneralInfo withTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
        return this;
    }


    public net.maxproit.salesforce2.model.newprospect.GeneralInfo generalInfo() {

        return new net.maxproit.salesforce2.model.newprospect.GeneralInfo(
                /*getIndustryType(),
                getRelationShip(),
                getNatureOfBusiness(),
                getApplicantMobile(),
                getLegalStatus(),
                getTinNumber(),getTinNumber(),
                getLicenseIssuedate(),
                getLicenseExpiredate(),
                String.valueOf(getBusinessSince())*/
        );

    }

}
