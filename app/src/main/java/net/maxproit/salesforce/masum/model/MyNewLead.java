package net.maxproit.salesforce.masum.model;

import java.io.Serializable;

public class MyNewLead implements Serializable {

    private String branchName;
    private String userName;
    private String profession;
    private String organization;
    private String designation;
    private String phone;
    private String address;
    private String sourceRef;
    private String productType;
    private String productSubcategory;
    private String loadAmount;
    private String orInterest;
    private String opFee;

    public String getLoadAmount() {
        return loadAmount;
    }

    public String getDisDate() {
        return disDate;
    }

    private String disDate;
    private String visitDate;
    private String followUp;
    private String remark;
    private String status;
    private int id;


    public MyNewLead(String branchName, String userName, String profession,
                     String organization, String designation, String phone,
                     String address, String sourceRef, String productType,
                     String productSubcategory, String loadAmount, String orInterest,
                     String opFee, String disDate, String visitDate, String followUp, String remark, String status) {

        this.branchName = branchName;
        this.userName = userName;
        this.profession = profession;
        this.organization = organization;
        this.designation = designation;
        this.phone = phone;
        this.address = address;
        this.sourceRef = sourceRef;
        this.productType = productType;
        this.productSubcategory = productSubcategory;
        this.loadAmount = loadAmount;
        this.orInterest = orInterest;
        this.opFee = opFee;
        this.disDate = disDate;
        this.visitDate = visitDate;
        this.followUp = followUp;
        this.remark = remark;
        this.status = status;
    }

    public MyNewLead(int id, String branchName, String userName, String profession,
                     String organization, String designation, String phone,
                     String address, String sourceRef, String productType,
                     String productSubcategory, String loadAmount, String orInterest,
                     String opFee, String disDate, String visitDate, String followUp, String remark, String status) {
        this.id = id;
        this.branchName = branchName;
        this.userName = userName;
        this.profession = profession;
        this.organization = organization;
        this.designation = designation;
        this.phone = phone;
        this.address = address;
        this.sourceRef = sourceRef;
        this.productType = productType;
        this.productSubcategory = productSubcategory;
        this.loadAmount = loadAmount;
        this.orInterest = orInterest;
        this.opFee = opFee;
        this.disDate = disDate;
        this.visitDate = visitDate;
        this.followUp = followUp;
        this.remark = remark;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfession() {
        return profession;
    }

    public String getOrganization() {
        return organization;
    }

    public String getDesignation() {
        return designation;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getSourceRef() {
        return sourceRef;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductSubcategory() {
        return productSubcategory;
    }

    public String getLoanAmount() {
        return loadAmount;
    }

    public String getOrInterest() {
        return orInterest;
    }

    public String getOpFee() {
        return opFee;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getFollowUp() {
        return followUp;
    }

    public String getRemark() {
        return remark;
    }
}
