
package net.maxproit.salesforce.model.salesOfficer.myPerfomance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("DisbursementAmount")
    @Expose
    private int disbursementAmount;
    @SerializedName("NoOfCalls")
    @Expose
    private int noOfCalls;
    @SerializedName("NoOfDisbursement")
    @Expose
    private int noOfDisbursement;
    @SerializedName("NoOfLeads")
    @Expose
    private int noOfLeads;
    @SerializedName("NoOfProspects")
    @Expose
    private int noOfProspects;
    @SerializedName("NoOfSanction")
    @Expose
    private int noOfSanction;
    @SerializedName("NoOfVisits")
    @Expose
    private int noOfVisits;
    @SerializedName("ProspectsAmount")
    @Expose
    private int prospectsAmount;
    @SerializedName("SanctionAmount")
    @Expose
    private int sanctionAmount;


    @SerializedName("NoOfCustomer")
    @Expose
    private int NoOfCustomer;


    public int getNoOfCustomer() {
        return NoOfCustomer;
    }

    public void setNoOfCustomer(int noOfCustomer) {
        NoOfCustomer = noOfCustomer;
    }

    public int getDisbursementAmount() {
        return disbursementAmount;
    }

    public void setDisbursementAmount(int disbursementAmount) {
        this.disbursementAmount = disbursementAmount;
    }

    public int getNoOfCalls() {
        return noOfCalls;
    }

    public void setNoOfCalls(int noOfCalls) {
        this.noOfCalls = noOfCalls;
    }

    public int getNoOfDisbursement() {
        return noOfDisbursement;
    }

    public void setNoOfDisbursement(int noOfDisbursement) {
        this.noOfDisbursement = noOfDisbursement;
    }

    public int getNoOfLeads() {
        return noOfLeads;
    }

    public void setNoOfLeads(int noOfLeads) {
        this.noOfLeads = noOfLeads;
    }

    public int getNoOfProspects() {
        return noOfProspects;
    }

    public void setNoOfProspects(int noOfProspects) {
        this.noOfProspects = noOfProspects;
    }

    public int getNoOfSanction() {
        return noOfSanction;
    }

    public void setNoOfSanction(int noOfSanction) {
        this.noOfSanction = noOfSanction;
    }

    public int getNoOfVisits() {
        return noOfVisits;
    }

    public void setNoOfVisits(int noOfVisits) {
        this.noOfVisits = noOfVisits;
    }

    public int getProspectsAmount() {
        return prospectsAmount;
    }

    public void setProspectsAmount(int prospectsAmount) {
        this.prospectsAmount = prospectsAmount;
    }

    public int getSanctionAmount() {
        return sanctionAmount;
    }

    public void setSanctionAmount(int sanctionAmount) {
        this.sanctionAmount = sanctionAmount;
    }
}
