package net.maxproit.salesforce.masum.model;

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
    private int id;

    public VisitPlan(int id, String clientName, String clientType,  String mobileNumber, String policeStation, String productType, String city, String purposeOfVisit, String dateOfVisit, String remarks, String status ) {

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
}
