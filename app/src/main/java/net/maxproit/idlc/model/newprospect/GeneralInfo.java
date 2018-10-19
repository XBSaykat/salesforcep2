
package net.maxproit.idlc.model.newprospect;

import android.databinding.BindingAdapter;
import android.widget.EditText;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralInfo {

    @SerializedName("loanPurposeTypeCode")
    @Expose
    private int loanPurposeTypeCode;
    @SerializedName("industryType")
    @Expose
    private String industryType = "";
    @SerializedName("relationShip")
    @Expose
    private String relationShip = "";
    @SerializedName("natureOfBusiness")
    @Expose
    private String natureOfBusiness = "";
    @SerializedName("applicantMobile")
    @Expose
    private String applicantMobile = "";
    @SerializedName("legalStatus")
    @Expose
    private String legalStatus = "";
    @SerializedName("tinNumber")
    @Expose
    private String tinNumber = "";
    @SerializedName("tradeLicenseNumber")
    @Expose
    private String tradeLicenseNumber = "";
    @SerializedName("licenseIssuedate")
    @Expose
    private String licenseIssuedate = "";
    @SerializedName("licenseExpiredate")
    @Expose
    private String licenseExpiredate = "";
    @SerializedName("commencementDate")
    @Expose
    private String commencementDate = "";
    @SerializedName("incorporationNumber")
    @Expose
    private String incorporationNumber = "";
    @SerializedName("businessSince")
    @Expose
    private String businessSince = "";


    public GeneralInfo() {
    }

    public GeneralInfo(int loanPurposeTypeCode, String industryType, String relationShip, String natureOfBusiness, String applicantMobile, String legalStatus, String tinNumber, String tradeLicenseNumber, String licenseIssuedate, String licenseExpiredate, String commencementDate, String incorporationNumber, String businessSince) {
        this.loanPurposeTypeCode = loanPurposeTypeCode;
        this.industryType = industryType;
        this.relationShip = relationShip;
        this.natureOfBusiness = natureOfBusiness;
        this.applicantMobile = applicantMobile;
        this.legalStatus = legalStatus;
        this.tinNumber = tinNumber;
        this.tradeLicenseNumber = tradeLicenseNumber;
        this.licenseIssuedate = licenseIssuedate;
        this.licenseExpiredate = licenseExpiredate;
        this.commencementDate = commencementDate;
        this.incorporationNumber = incorporationNumber;
        this.businessSince = businessSince;
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

    public String getIncorporationNumber() {
        return incorporationNumber;
    }

    public void setIncorporationNumber(String incorporationNumber) {
        this.incorporationNumber = incorporationNumber;
    }

    public GeneralInfo withIncorporationNumber(String incorporationNumber) {
        this.incorporationNumber = incorporationNumber;
        return this;
    }

    public String getBusinessSince() {
        return businessSince;
    }

    public void setBusinessSince(String businessSince) {
        this.businessSince = businessSince;
    }

    public GeneralInfo withBusinessSince(String businessSince) {
        this.businessSince = businessSince;
        return this;
    }

    @BindingAdapter("android:text")
    public static void convert0toString(EditText editText, String number) {

        if (isNumber(number)) {
            editText.setText(Integer.parseInt(number) == 0 ? "" : number);

        } else editText.setText(number);





    }




    private static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
