
package net.maxproit.salesforce.model.newprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.model.newlead.VisitRecord;

import java.util.ArrayList;
import java.util.List;

public class NewProspect {

    @SerializedName("mobileDbId")
    @Expose
    private int mobileDbId;
    @SerializedName("prospectReferenceNo")
    @Expose
    private String prospectReferenceNo;
    @SerializedName("generalInfo")
    @Expose
    private GeneralInfo generalInfo;
    @SerializedName("loanInfo")
    @Expose
    private LoanInfo loanInfo;
    @SerializedName("proprietorsInfo")
    @Expose
    private List<ProprietorsInfo> proprietorsInfo = new ArrayList<>();
    @SerializedName("guarantorsInfo")
    @Expose
    private List<GuarantorsInfo> guarantorsInfo = new ArrayList<>();
    @SerializedName("visitRecords")
    @Expose
    private List<VisitRecord> visitRecords = new ArrayList<>();
    @SerializedName("prospectAddresses")
    @Expose
    private List<Address> prospectAddresses = new ArrayList<>();
    @SerializedName("verification")
    @Expose
    private Verification verification;
    @SerializedName("makerName")
    @Expose
    private String makerName;
    @SerializedName("supervisorCode")
    @Expose
    private String supervisorCode;

    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("cif")
    @Expose
    private String cif;
    @SerializedName("clientName")
    @Expose
    private String clientName;
    @SerializedName("product")
    @Expose
    private String product;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getMobileDbId() {
        return mobileDbId;
    }

    public void setMobileDbId(int mobileDbId) {
        this.mobileDbId = mobileDbId;
    }

    public NewProspect withMobileDbId(int mobileDbId) {
        this.mobileDbId = mobileDbId;
        return this;
    }

    public String getProspectReferenceNo() {
        return prospectReferenceNo;
    }

    public void setProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
    }

    public NewProspect withProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
        return this;
    }

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public NewProspect withGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
        return this;
    }

    public LoanInfo getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(LoanInfo loanInfo) {
        this.loanInfo = loanInfo;
    }

    public NewProspect withLoanInfo(LoanInfo loanInfo) {
        this.loanInfo = loanInfo;
        return this;
    }

    public List<ProprietorsInfo> getProprietorsInfo() {
        return proprietorsInfo;
    }

    public void setProprietorsInfo(List<ProprietorsInfo> proprietorsInfo) {
        this.proprietorsInfo = proprietorsInfo;
    }

    public NewProspect withProprietorsInfo(List<ProprietorsInfo> proprietorsInfo) {
        this.proprietorsInfo = proprietorsInfo;
        return this;
    }

    public List<GuarantorsInfo> getGuarantorsInfo() {
        return guarantorsInfo;
    }

    public void setGuarantorsInfo(List<GuarantorsInfo> guarantorsInfo) {
        this.guarantorsInfo = guarantorsInfo;
    }

    public NewProspect withGuarantorsInfo(List<GuarantorsInfo> guarantorsInfo) {
        this.guarantorsInfo = guarantorsInfo;
        return this;
    }

    public List<VisitRecord> getVisitRecords() {
        return visitRecords;
    }

    public void setVisitRecords(List<VisitRecord> visitRecords) {
        this.visitRecords = visitRecords;
    }

    public NewProspect withVisitRecords(List<VisitRecord> visitRecords) {
        this.visitRecords = visitRecords;
        return this;
    }

    public List<Address> getProspectAddresses() {
        return prospectAddresses;
    }

    public void setProspectAddresses(List<Address> prospectAddresses) {
        this.prospectAddresses = prospectAddresses;
    }

    public NewProspect withProspectAddresses(List<Address> prospectAddresses) {
        this.prospectAddresses = prospectAddresses;
        return this;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public NewProspect withVerification(Verification verification) {
        this.verification = verification;
        return this;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public NewProspect withMakerName(String makerName) {
        this.makerName = makerName;
        return this;
    }

    public String getSupervisorCode() {
        return supervisorCode;
    }

    public void setSupervisorCode(String supervisorCode) {
        this.supervisorCode = supervisorCode;
    }

    public NewProspect withSupervisorCode(String supervisorCode) {
        this.supervisorCode = supervisorCode;
        return this;
    }

}
