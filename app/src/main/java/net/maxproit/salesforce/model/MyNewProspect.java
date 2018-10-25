package net.maxproit.salesforce.model;

import net.maxproit.salesforce.model.newlead.MyNewLead;

public class MyNewProspect extends MyNewLead{

    private String pLoanType,productDetail,segment,age,dob,cob,pIdNumber
            ,pIssueDate,etin,fName,mName,
            sName,exList,currentJob,applicant,
            pAddress,netSalary,salaryAmount,rentIncome,rentIncomeAmount,
            ag_Income,tution,remitance,inFdr,fExpense,emiOther,sValue,loanReq,
            loanTerm,piRate,fee,monthlyEmi;


    public MyNewProspect(int id, String branchName, String userName, String profession, String organization, String designation, String phone, String address, String sourceRef, String productType, String productSubcategory, String loadAmount, String orInterest, String opFee, String visitDate, String followUp, String remark, String status,String pLoanType, String productDetail, String segment, String age, String dob, String cob, String pIdNumber, String pIssueDate, String etin, String fName, String mName, String sName, String exList, String currentJob, String applicant, String pAddress, String netSalary, String salaryAmount, String rentIncome,String rentIncomeAmount, String ag_Income, String tution, String remitance, String inFdr, String fExpense, String emiOther, String sValue, String loanReq, String loanTerm, String piRate, String fee, String monthlyEmi) {
        super(id, branchName, userName, profession, organization, designation, phone, address, sourceRef, productType, productSubcategory, loadAmount, orInterest, opFee, visitDate, followUp, remark, status);
        this.pLoanType = pLoanType;
        this.productDetail = productDetail;
        this.segment = segment;
        this.age = age;
        this.dob = dob;
        this.cob = cob;
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
        this.rentIncome = rentIncome;
        this.rentIncomeAmount = rentIncomeAmount;
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
        this.fee = fee;
        this.monthlyEmi = monthlyEmi;
    }

    public MyNewProspect(String branchName, String userName, String profession, String organization, String designation, String phone, String address, String sourceRef, String productType, String productSubcategory, String loadAmount, String orInterest, String opFee, String visitDate, String followUp, String remark, String status,String pLoanType, String productDetail, String segment, String age, String dob, String cob, String pIdNumber, String pIssueDate, String etin, String fName, String mName, String sName, String exList, String currentJob, String applicant, String pAddress, String netSalary, String salaryAmount, String rentIncome,String rentIncomeAmount, String ag_Income, String tution, String remitance, String inFdr, String fExpense, String emiOther, String sValue, String loanReq, String loanTerm, String piRate, String fee, String monthlyEmi) {
        super(branchName, userName, profession, organization, designation, phone, address, sourceRef, productType, productSubcategory, loadAmount, orInterest, opFee, visitDate, followUp, remark, status);
        this.pLoanType = pLoanType;
        this.productDetail = productDetail;
        this.segment = segment;
        this.age = age;
        this.dob = dob;
        this.cob = cob;
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
        this.rentIncome = rentIncome;
        this.rentIncomeAmount = rentIncomeAmount;
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
        this.fee = fee;
        this.monthlyEmi = monthlyEmi;
    }


    public String getpLoanType() {
        return pLoanType;
    }

    public String getRentIncomeAmount() {
        return rentIncomeAmount;
    }

    public String getProductDetail() {
        return productDetail;
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

    public String getRentIncome() {
        return rentIncome;
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

    public String getFee() {
        return fee;
    }

    public String getMonthlyEmi() {
        return monthlyEmi;
    }

}
