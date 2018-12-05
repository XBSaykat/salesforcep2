package net.maxproit.salesforce.masum.model.local;

import java.io.Serializable;

public class VisitPlan implements Serializable {


    private String clientName;
    private String clientType;
    private String mobileNumber;
    private String productType;
    private String city;
    private String policeStation;
    private String purposeOfVisit;
    private String dateOfVisit;
    private String remarks;
    private String status;
    private String synStatus;
    private int id,journalId;
    String followUpDate,followUpRemark;

    public VisitPlan(int id,int journalId, String clientName, String clientType,  String mobileNumber, String policeStation, String productType, String city, String purposeOfVisit, String dateOfVisit, String remarks, String status,String synStatus ) {

        this.clientName = clientName;
        this.policeStation = policeStation;
        this.id = id;
        this.journalId = journalId;
        this.clientType = clientType;
        this.mobileNumber = mobileNumber;
        this.productType = productType;
        this.city = city;
        this.purposeOfVisit = purposeOfVisit;
        this.dateOfVisit = dateOfVisit;
        this.remarks = remarks;
        this.status = status;
        this.synStatus = synStatus;
    }

    public VisitPlan(int id,String clientName, String clientType,  String mobileNumber, String policeStation, String productType, String city, String purposeOfVisit, String dateOfVisit, String remarks, String status) {

        this.clientName = clientName;
        this.policeStation = policeStation;
        this.id = id;
        this.clientType = clientType;
        this.mobileNumber = mobileNumber;
        this.productType = productType;
        this.city = city;
        this.purposeOfVisit = purposeOfVisit;
        this.dateOfVisit = dateOfVisit;
        this.remarks = remarks;
        this.status = status;
        this.synStatus = synStatus;
    }

    public VisitPlan(int journalId,String clientName, String clientType,  String mobileNumber, String policeStation, String productType, String city, String purposeOfVisit, String dateOfVisit, String remarks, String status,String followUpDate,String followUpRemark) {

        this.clientName = clientName;
        this.policeStation = policeStation;
        this.followUpDate = followUpDate;
        this.followUpRemark = followUpRemark;
        this.journalId = journalId;
        this.clientType = clientType;
        this.mobileNumber = mobileNumber;
        this.productType = productType;
        this.city = city;
        this.purposeOfVisit = purposeOfVisit;
        this.dateOfVisit = dateOfVisit;
        this.remarks = remarks;
        this.status = status;

    }

    public VisitPlan(String clientName, String clientType,  String mobileNumber, String policeStation, String productType, String city, String purposeOfVisit, String dateOfVisit, String remarks, String status) {

        this.clientName = clientName;
        this.policeStation = policeStation;
        this.id = id;
        this.journalId = journalId;
        this.clientType = clientType;
        this.mobileNumber = mobileNumber;
        this.productType = productType;
        this.city = city;
        this.purposeOfVisit = purposeOfVisit;
        this.dateOfVisit = dateOfVisit;
        this.remarks = remarks;
        this.status = status;
        this.synStatus = synStatus;
    }

    public VisitPlan(int journalId, String clientName, String clientType,  String mobileNumber, String policeStation, String productType, String city, String purposeOfVisit, String dateOfVisit, String remarks, String status ,String synStatus) {

        this.clientName = clientName;
        this.journalId = journalId;
        this.policeStation = policeStation;
        this.clientType = clientType;
        this.mobileNumber = mobileNumber;
        this.productType = productType;
        this.city = city;
        this.purposeOfVisit = purposeOfVisit;
        this.dateOfVisit = dateOfVisit;
        this.remarks = remarks;
        this.status = status;
        this.synStatus = synStatus;
    }



    public int getJournalId() {
        return journalId;
    }

    public String getSynStatus() {
        return synStatus;
    }

    public String getClientName() {
        return clientName; }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientType() {
        return clientType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getProductType() {
        return productType;
    }

    public String getCity() {
        return city;
    }
    public String getPoliceStation() {
        return policeStation;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public String getRemarks() {
        return remarks;
    }

    public int getId() {
        return id;
    }

    public String getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getFollowUpRemark() {
        return followUpRemark;
    }

    public void setFollowUpRemark(String followUpRemark) {
        this.followUpRemark = followUpRemark;
    }
}
