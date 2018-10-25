
package net.maxproit.salesforce.model.supervisor.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("DisbursementAmount")
    @Expose
    private Integer disbursementAmount;
    @SerializedName("NoOfCustomer")
    @Expose
    private Integer noOfCustomer;
    @SerializedName("NoOfDisbursement")
    @Expose
    private Integer noOfDisbursement;
    @SerializedName("NoOfLeads")
    @Expose
    private Integer noOfLeads;
    @SerializedName("NoOfProspects")
    @Expose
    private Integer noOfProspects;
    @SerializedName("NoOfSalesOfficer")
    @Expose
    private Integer noOfSalesOfficer;
    @SerializedName("NoOfSanction")
    @Expose
    private Integer noOfSanction;
    @SerializedName("NoOfVisits")
    @Expose
    private Integer noOfVisits;
    @SerializedName("ProspectsAmount")
    @Expose
    private Integer prospectsAmount;
    @SerializedName("SanctionAmount")
    @Expose
    private Integer sanctionAmount;

    public Integer getDisbursementAmount() {
        return disbursementAmount;
    }

    public void setDisbursementAmount(Integer disbursementAmount) {
        this.disbursementAmount = disbursementAmount;
    }

    public Integer getNoOfCustomer() {
        return noOfCustomer;
    }

    public void setNoOfCustomer(Integer noOfCustomer) {
        this.noOfCustomer = noOfCustomer;
    }

    public Integer getNoOfDisbursement() {
        return noOfDisbursement;
    }

    public void setNoOfDisbursement(Integer noOfDisbursement) {
        this.noOfDisbursement = noOfDisbursement;
    }

    public Integer getNoOfLeads() {
        return noOfLeads;
    }

    public void setNoOfLeads(Integer noOfLeads) {
        this.noOfLeads = noOfLeads;
    }

    public Integer getNoOfProspects() {
        return noOfProspects;
    }

    public void setNoOfProspects(Integer noOfProspects) {
        this.noOfProspects = noOfProspects;
    }

    public Integer getNoOfSalesOfficer() {
        return noOfSalesOfficer;
    }

    public void setNoOfSalesOfficer(Integer noOfSalesOfficer) {
        this.noOfSalesOfficer = noOfSalesOfficer;
    }

    public Integer getNoOfSanction() {
        return noOfSanction;
    }

    public void setNoOfSanction(Integer noOfSanction) {
        this.noOfSanction = noOfSanction;
    }

    public Integer getNoOfVisits() {
        return noOfVisits;
    }

    public void setNoOfVisits(Integer noOfVisits) {
        this.noOfVisits = noOfVisits;
    }

    public Integer getProspectsAmount() {
        return prospectsAmount;
    }

    public void setProspectsAmount(Integer prospectsAmount) {
        this.prospectsAmount = prospectsAmount;
    }

    public Integer getSanctionAmount() {
        return sanctionAmount;
    }

    public void setSanctionAmount(Integer sanctionAmount) {
        this.sanctionAmount = sanctionAmount;
    }
}
