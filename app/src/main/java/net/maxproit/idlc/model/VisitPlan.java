package net.maxproit.idlc.model;

public class VisitPlan {


    private String clientType, mobileNumber, productType, area, purposeOfVisit, dateOfVisit, remarks;
    private int id;

    public VisitPlan(int id, String clientType, String mobileNumber, String productType, String area, String purposeOfVisit, String dateOfVisit, String remarks ) {

        this.id = id;
        this.clientType = clientType;
        this.mobileNumber = mobileNumber;
        this.productType = productType;
        this.area = area;
        this.purposeOfVisit = purposeOfVisit;
        this.dateOfVisit = dateOfVisit;
        this.remarks = remarks;
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

    public String getArea() {
        return area;
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
