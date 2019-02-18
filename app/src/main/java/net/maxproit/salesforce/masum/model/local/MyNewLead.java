package net.maxproit.salesforce.masum.model.local;

import java.io.Serializable;

public class MyNewLead implements Serializable {

    private String userID,userCode;
    private String refNumber;
    private String syncStatus;
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

    private String disDate;
    private String visitDate;
    private String followUp;
    private String remark;
    private String status;
    private String ps,city,titleName;


    private int id,cusId,mobileId,addressId,visitId,branchCode,productCode,subCode;

public MyNewLead(){

}
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

    public MyNewLead(String userID,String refNumber,int cusId,int mobileId,int addressId,int visitId,int branchCode,int productCode,int subCode,int id, String branchName, String userName, String profession,
                     String organization, String designation, String phone,
                     String address, String sourceRef, String productType,
                     String productSubcategory, String loadAmount, String orInterest,
                     String opFee, String disDate, String visitDate, String followUp, String remark, String status,String syncStatus) {
        this.id = id;
        this.branchCode = branchCode;
        this.productCode = productCode;
        this.subCode = subCode;
        this.cusId = cusId;
        this.mobileId = mobileId;
        this.addressId = addressId;
        this.visitId = visitId;
        this.userID = userID;
        this.refNumber = refNumber;
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
        this.syncStatus = syncStatus;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSourceRef(String sourceRef) {
        this.sourceRef = sourceRef;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductSubcategory(String productSubcategory) {
        this.productSubcategory = productSubcategory;
    }

    public void setLoadAmount(String loadAmount) {
        this.loadAmount = loadAmount;
    }

    public void setOrInterest(String orInterest) {
        this.orInterest = orInterest;
    }

    public void setOpFee(String opFee) {
        this.opFee = opFee;
    }

    public void setDisDate(String disDate) {
        this.disDate = disDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public void setSubCode(int subCode) {
        this.subCode = subCode;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public int getSubCode() {
        return subCode;
    }

    public String getUserID() {
        return userID;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public int getCusId() {
        return cusId;
    }

    public int getMobileId() {
        return mobileId;
    }

    public int getAddressId() {
        return addressId;
    }

    public int getVisitId() {
        return visitId;
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

    public String getLoadAmount() {
        return loadAmount;
    }

    public String getDisDate() {
        return disDate;
    }
}
