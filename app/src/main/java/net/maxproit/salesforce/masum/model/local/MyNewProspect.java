package net.maxproit.salesforce.masum.model.local;

import java.io.Serializable;

public class MyNewProspect extends MyNewLead implements Serializable {

    private String segment,dateOfBirth,age,dob,cob,pIdNumber,pIDType
            ,pIssueDate,etin,fName,mName,
            sName,exList,currentJob,applicant,
            pAddress,netSalary,salaryAmount,businessIncomeAmount, apartmentAmount,
            semipakaIncome,officeSpaceINcome,wireHouseINcome,
            ag_Income,tution,remitance,inFdr,fExpense,emiOther,sValue,loanReq,
            loanTerm,piRate, prospectFee;


    public MyNewProspect(int id,String branchName, String userName, String profession, String organization, String designation, String phone, String address, String sourceRef, String productType, String productSubcategory, String loadAmount, String orInterest, String opFee, String disDate, String visitDate, String followUp, String remark, String status) {
        super(id,branchName, userName, profession, organization, designation, phone, address, sourceRef, productType, productSubcategory, loadAmount, orInterest, opFee, disDate, visitDate, followUp, remark, status);

    }

    public MyNewProspect(String branchName, String userName, String profession, String organization, String designation, String phone, String address, String sourceRef, String productType, String productSubcategory, String loadAmount, String orInterest, String opFee, String disDate, String visitDate, String followUp, String remark, String status, String segment, String dateOfBirth, String age, String dob, String cob,String pIDType,String pIdNumber, String pIssueDate, String etin, String fName, String mName, String sName, String exList, String currentJob, String applicant, String pAddress, String netSalary, String salaryAmount, String businessIncomeAmount, String apartmentAmount, String semipakaIncome, String officeSpaceINcome, String wireHouseINcome,String ag_Income, String tution, String remitance, String inFdr, String fExpense, String emiOther, String sValue, String loanReq, String loanTerm, String piRate, String prospectFee) {
        super(branchName, userName, profession, organization, designation, phone, address, sourceRef, productType, productSubcategory, loadAmount, orInterest, opFee, disDate, visitDate, followUp, remark, status);
        this.segment = segment;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.dob = dob;
        this.cob = cob;
        this.pIDType = pIDType;
        this.pIdNumber = pIdNumber;
        this.pIssueDate = pIssueDate;
        this.etin = etin;
        this.fName = fName;
        this.mName = mName;
        this.sName = sName;
        this.exList = exList;
        this.currentJob = currentJob;
        this.applicant = applicant;
        this.pAddress = pAddress;
        this.netSalary = netSalary;
        this.salaryAmount = salaryAmount;
        this.businessIncomeAmount = businessIncomeAmount;
        this.apartmentAmount = apartmentAmount;
        this.semipakaIncome = semipakaIncome;
        this.officeSpaceINcome = officeSpaceINcome;
        this.wireHouseINcome = wireHouseINcome;

        this.ag_Income = ag_Income;
        this.tution = tution;
        this.remitance = remitance;
        this.inFdr = inFdr;
        this.fExpense = fExpense;
        this.emiOther = emiOther;
        this.sValue = sValue;
        this.loanReq = loanReq;
        this.loanTerm = loanTerm;
        this.piRate = piRate;
        this.prospectFee = prospectFee;
    }

    public MyNewProspect(int id, String branchName, String userName, String profession, String organization, String designation, String phone, String address, String sourceRef, String productType, String productSubcategory, String loadAmount, String orInterest, String opFee, String disDate, String visitDate, String followUp, String remark, String status, String segment, String dateOfBirth, String age, String dob, String cob, String pIDType,String pIdNumber, String pIssueDate, String etin, String fName, String mName, String sName, String exList, String currentJob, String applicant, String pAddress, String netSalary, String salaryAmount, String businessIncomeAmount, String apartmentAmount, String semipakaIncome, String officeSpaceINcome, String wireHouseINcome,String ag_Income, String tution, String remitance, String inFdr, String fExpense, String emiOther, String sValue, String loanReq, String loanTerm, String piRate, String prospectFee) {
        super(id, branchName, userName, profession, organization, designation, phone, address, sourceRef, productType, productSubcategory, loadAmount, orInterest, opFee, disDate, visitDate, followUp, remark, status);
        this.segment = segment;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.dob = dob;
        this.cob = cob;
        this.pIDType = pIDType;
        this.pIdNumber = pIdNumber;
        this.pIssueDate = pIssueDate;
        this.etin = etin;
        this.fName = fName;
        this.mName = mName;
        this.sName = sName;
        this.exList = exList;
        this.currentJob = currentJob;
        this.applicant = applicant;
        this.pAddress = pAddress;
        this.netSalary = netSalary;
        this.salaryAmount = salaryAmount;
        this.businessIncomeAmount = businessIncomeAmount;
        this.apartmentAmount = apartmentAmount;
        this.semipakaIncome = semipakaIncome;
        this.officeSpaceINcome = officeSpaceINcome;
        this.wireHouseINcome = wireHouseINcome;
        this.ag_Income = ag_Income;
        this.tution = tution;
        this.remitance = remitance;
        this.inFdr = inFdr;
        this.fExpense = fExpense;
        this.emiOther = emiOther;
        this.sValue = sValue;
        this.loanReq = loanReq;
        this.loanTerm = loanTerm;
        this.piRate = piRate;
        this.prospectFee = prospectFee;
    }

    public String getBusinessIncomeAmount() {
        return businessIncomeAmount;
    }

    public String getSegment() {
        return segment;
    }

    public String getAge() {
        return age;
    }

    public String getDob() {
        return dob;
    }

    public String getCob() {
        return cob;
    }

    public String getpIdNumber() {
        return pIdNumber;
    }

    public String getpIssueDate() {
        return pIssueDate;
    }

    public String getEtin() {
        return etin;
    }

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getsName() {
        return sName;
    }

    public String getExList() {
        return exList;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public String getApplicant() {
        return applicant;
    }

    public String getpAddress() {
        return pAddress;
    }

    public String getNetSalary() {
        return netSalary;
    }

    public String getSalaryAmount() {
        return salaryAmount;
    }

    public String getApartmentAmount() {
        return apartmentAmount;
    }

    public String getAg_Income() {
        return ag_Income;
    }

    public String getTution() {
        return tution;
    }

    public String getRemitance() {
        return remitance;
    }

    public String getInFdr() {
        return inFdr;
    }

    public String getfExpense() {
        return fExpense;
    }

    public String getEmiOther() {
        return emiOther;
    }

    public String getsValue() {
        return sValue;
    }

    public String getLoanReq() {
        return loanReq;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public String getPiRate() {
        return piRate;
    }

    public String getProspectFee() {
        return prospectFee;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getpIDType() {
        return pIDType;
    }

    public String getSemipakaIncome() {
        return semipakaIncome;
    }

    public String getOfficeSpaceINcome() {
        return officeSpaceINcome;
    }

    public String getWireHouseINcome() {
        return wireHouseINcome;
    }
}
