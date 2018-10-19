package net.maxproit.idlc.model.newlead;

public class MyNewLead {

   private  String branchName,userName,profession,
            organization,designation,phone,address,
            sourceRef,productType,productSubcategory,
            loadAmount,orInterest,opFee,visitDate,
            followUp,remark,status;
    private int id;


    public MyNewLead(String branchName, String userName, String profession,
                     String organization, String designation, String phone,
                     String address, String sourceRef, String productType,
                     String productSubcategory, String loadAmount, String orInterest,
                     String opFee, String visitDate, String followUp, String remark,String status) {

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
        this.visitDate = visitDate;
        this.followUp = followUp;
        this.remark = remark;
        this.status = status;
    }

    public MyNewLead(int id,String branchName, String userName, String profession,
                     String organization, String designation, String phone,
                     String address, String sourceRef, String productType,
                     String productSubcategory, String loadAmount, String orInterest,
                     String opFee, String visitDate, String followUp, String remark,String status) {
        this.id=id;
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
        this.visitDate = visitDate;
        this.followUp = followUp;
        this.remark = remark;
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
