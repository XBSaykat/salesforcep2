
package net.maxproit.idlc.model.myprospect.updateProspect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("generalInfo")
    @Expose
    private GeneralInfo generalInfo;
    @SerializedName("guarantorsInfo")
    @Expose
    private List<GuarantorsInfo> guarantorsInfo = null;
    @SerializedName("loanInfo")
    @Expose
    private LoanInfo loanInfo;
    @SerializedName("makerName")
    @Expose
    private String makerName;
    @SerializedName("mobileDbId")
    @Expose
    private int mobileDbId;
    @SerializedName("proprietorsInfo")
    @Expose
    private List<ProprietorsInfo> proprietorsInfo = null;
    @SerializedName("prospectAddresses")
    @Expose
    private List<ProspectAddress> prospectAddresses = null;
    @SerializedName("prospectReferenceNo")
    @Expose
    private String prospectReferenceNo;
    @SerializedName("supervisorCode")
    @Expose
    private String supervisorCode;
    @SerializedName("verification")
    @Expose
    private Verification verification;
    @SerializedName("visitRecords")
    @Expose
    private List<VisitRecord> visitRecords = null;


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

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public Data withGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
        return this;
    }

    public List<GuarantorsInfo> getGuarantorsInfo() {
        return guarantorsInfo;
    }

    public void setGuarantorsInfo(List<GuarantorsInfo> guarantorsInfo) {
        this.guarantorsInfo = guarantorsInfo;
    }

    public Data withGuarantorsInfo(List<GuarantorsInfo> guarantorsInfo) {
        this.guarantorsInfo = guarantorsInfo;
        return this;
    }

    public LoanInfo getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(LoanInfo loanInfo) {
        this.loanInfo = loanInfo;
    }

    public Data withLoanInfo(LoanInfo loanInfo) {
        this.loanInfo = loanInfo;
        return this;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public Data withMakerName(String makerName) {
        this.makerName = makerName;
        return this;
    }

    public int getMobileDbId() {
        return mobileDbId;
    }

    public void setMobileDbId(int mobileDbId) {
        this.mobileDbId = mobileDbId;
    }

    public Data withMobileDbId(int mobileDbId) {
        this.mobileDbId = mobileDbId;
        return this;
    }

    public List<ProprietorsInfo> getProprietorsInfo() {
        return proprietorsInfo;
    }

    public void setProprietorsInfo(List<ProprietorsInfo> proprietorsInfo) {
        this.proprietorsInfo = proprietorsInfo;
    }

    public Data withProprietorsInfo(List<ProprietorsInfo> proprietorsInfo) {
        this.proprietorsInfo = proprietorsInfo;
        return this;
    }

    public List<ProspectAddress> getProspectAddresses() {
        return prospectAddresses;
    }

    public void setProspectAddresses(List<ProspectAddress> prospectAddresses) {
        this.prospectAddresses = prospectAddresses;
    }

    public Data withProspectAddresses(List<ProspectAddress> prospectAddresses) {
        this.prospectAddresses = prospectAddresses;
        return this;
    }

    public String getProspectReferenceNo() {
        return prospectReferenceNo;
    }

    public void setProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
    }

    public Data withProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
        return this;
    }

    public String getSupervisorCode() {
        return supervisorCode;
    }

    public void setSupervisorCode(String supervisorCode) {
        this.supervisorCode = supervisorCode;
    }

    public Data withSupervisorCode(String supervisorCode) {
        this.supervisorCode = supervisorCode;
        return this;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public Data withVerification(Verification verification) {
        this.verification = verification;
        return this;
    }

    public List<VisitRecord> getVisitRecords() {
        return visitRecords;
    }

    public void setVisitRecords(List<VisitRecord> visitRecords) {
        this.visitRecords = visitRecords;
    }

    public Data withVisitRecords(List<VisitRecord> visitRecords) {
        this.visitRecords = visitRecords;
        return this;
    }

}