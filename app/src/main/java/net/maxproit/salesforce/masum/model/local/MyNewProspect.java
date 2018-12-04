package net.maxproit.salesforce.masum.model.local;

import net.maxproit.salesforce.model.myprospect.updatemyprospect.CoApplicant;

import java.io.Serializable;
import java.util.List;

public class MyNewProspect extends MyNewLead implements Serializable {

    private String segment,dateOfBirth,age,dob,cob,pIdNumber,pIDType
            ,pIssueDate,etin,fName,mName,
            sName,exList,currentJob,applicant,
            pAddress,netSalary,salaryAmount,businessIncomeAmount, apartmentAmount,
            semipakaIncome,officeSpaceINcome,wireHouseINcome,
            ag_Income,tution,remitance,inFdr,fExpense,emiOther,sValue,loanReq,
            loanTerm,piRate, prospectFee;
    private List<CoApplicant> coApplicantList;


    int branchCode, assetTypeId,  manufacturingNameId,  contactId, permAddressId, presAddressId;
    String manufacturingName, manufacturingCountry,
            manufacturingYear, assetType, rmCode, PermAddressCity,PermAddressPs,
            PresAddressCity,PresAddressPs ;

    public List<CoApplicant> getCoApplicantList() {
        return coApplicantList;
    }

    public void setCoApplicantList(List<CoApplicant> coApplicantList) {
        this.coApplicantList = coApplicantList;
    }

    public MyNewProspect(int id, String branchName, String userName, String profession,
                         String organization, String designation, String phone, String address,
                         String sourceRef, String productType, String productSubcategory,
                         String loadAmount, String orInterest, String opFee, String disDate,
                         String visitDate, String followUp, String remark, String status) {
        super(id,branchName, userName, profession, organization, designation, phone,
                address, sourceRef, productType, productSubcategory, loadAmount, orInterest,
                opFee, disDate, visitDate, followUp, remark, status);

    }
    public MyNewProspect(){

    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public int getPermAddressId() {
        return permAddressId;
    }

    public void setPermAddressId(int permAddressId) {
        this.permAddressId = permAddressId;
    }

    public int getPresAddressId() {
        return presAddressId;
    }

    public void setPresAddressId(int presAddressId) {
        this.presAddressId = presAddressId;
    }

    @Override
    public int getBranchCode() {
        return branchCode;
    }

    @Override
    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public int getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(int assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public int getManufacturingNameId() {
        return manufacturingNameId;
    }

    public void setManufacturingNameId(int manufacturingNameId) {
        this.manufacturingNameId = manufacturingNameId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getManufacturingName() {
        return manufacturingName;
    }

    public void setManufacturingName(String manufacturingName) {
        this.manufacturingName = manufacturingName;
    }

    public String getManufacturingCountry() {
        return manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getPermAddressCity() {
        return PermAddressCity;
    }

    public void setPermAddressCity(String permAddressCity) {
        PermAddressCity = permAddressCity;
    }

    public String getPermAddressPs() {
        return PermAddressPs;
    }

    public void setPermAddressPs(String permAddressPs) {
        PermAddressPs = permAddressPs;
    }

    public String getPresAddressCity() {
        return PresAddressCity;
    }

    public void setPresAddressCity(String presAddressCity) {
        PresAddressCity = presAddressCity;
    }

    public String getPresAddressPs() {
        return PresAddressPs;
    }

    public void setPresAddressPs(String presAddressPs) {
        PresAddressPs = presAddressPs;
    }

    public MyNewProspect(String branchName, String userName, String profession, String organization, String designation, String phone, String address, String sourceRef, String productType, String productSubcategory, String loadAmount, String orInterest, String opFee, String disDate, String visitDate, String followUp, String remark, String status, String segment, String dateOfBirth, String age, String dob, String cob, String pIDType, String pIdNumber, String pIssueDate, String etin, String fName, String mName, String sName, String exList, String currentJob, String applicant, String pAddress, String netSalary, String salaryAmount, String businessIncomeAmount, String apartmentAmount, String semipakaIncome, String officeSpaceINcome, String wireHouseINcome, String ag_Income, String tution, String remitance, String inFdr, String fExpense, String emiOther, String sValue, String loanReq, String loanTerm, String piRate, String prospectFee) {
        super(branchName,  userName, profession, organization, designation, phone, address, sourceRef, productType, productSubcategory, loadAmount, orInterest, opFee, disDate, visitDate, followUp, remark, status);
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


    public MyNewProspect(int id, String branchName, String userName, String profession, String organization,
                         String designation, String phone, String address, String sourceRef, String productType,
                         String productSubcategory, String loadAmount, String orInterest, String opFee,
                         String disDate, String visitDate, String followUp, String remark, String status,
                         String segment, String dateOfBirth, String age, String dob, String cob, String pIDType,
                         String pIdNumber, String pIssueDate, String etin, String fName, String mName,
                         String sName, String exList, String currentJob, String applicant, String pAddress,
                         String netSalary, String salaryAmount, String businessIncomeAmount,
                         String apartmentAmount, String semipakaIncome, String officeSpaceINcome,
                         String wireHouseINcome,String ag_Income, String tution, String remitance,
                         String inFdr, String fExpense, String emiOther, String sValue, String loanReq,
                         String loanTerm, String piRate, String prospectFee) {
        super(id, branchName, userName, profession, organization, designation, phone, address,
                sourceRef, productType, productSubcategory, loadAmount, orInterest, opFee, disDate,
                visitDate, followUp, remark, status);
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
    public MyNewProspect(String userID,String refNumber,int cusId,int mobileId,int addressId,int
            visitId,int branchCode,int productCode,int subCode,int id, String branchName,
                         String userName, String profession, String organization,
                         String designation, String phone, String address, String sourceRef,
                         String productType, String productSubcategory, String loadAmount,
                         String orInterest, String opFee, String disDate, String visitDate,
                         String followUp, String remark, String status,String synStatus,
                         String segment, String dateOfBirth, String age, String dob,
                         String cob, String pIDType,String pIdNumber, String pIssueDate,
                         String etin, String fName, String mName, String sName, String exList,
                         String currentJob, String applicant, String pAddress, String netSalary,
                         String salaryAmount, String businessIncomeAmount, String apartmentAmount,
                         String semipakaIncome, String officeSpaceINcome, String wireHouseINcome,
                         String ag_Income, String tution, String remitance, String inFdr,
                         String fExpense, String emiOther, String sValue, String loanReq,
                         String loanTerm, String piRate, String prospectFee) {
        super(userID,refNumber,cusId,mobileId,addressId,visitId,branchCode,
                productCode, subCode, id, branchName, userName, profession, organization,
                designation, phone, address, sourceRef, productType, productSubcategory,
                loadAmount, orInterest, opFee, disDate, visitDate, followUp, remark, status,synStatus);
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


    public void setSegment(String segment) {
        this.segment = segment;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setCob(String cob) {
        this.cob = cob;
    }

    public void setpIdNumber(String pIdNumber) {
        this.pIdNumber = pIdNumber;
    }

    public void setpIDType(String pIDType) {
        this.pIDType = pIDType;
    }

    public void setpIssueDate(String pIssueDate) {
        this.pIssueDate = pIssueDate;
    }

    public void setEtin(String etin) {
        this.etin = etin;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setExList(String exList) {
        this.exList = exList;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public void setNetSalary(String netSalary) {
        this.netSalary = netSalary;
    }

    public void setSalaryAmount(String salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public void setBusinessIncomeAmount(String businessIncomeAmount) {
        this.businessIncomeAmount = businessIncomeAmount;
    }

    public void setApartmentAmount(String apartmentAmount) {
        this.apartmentAmount = apartmentAmount;
    }

    public void setSemipakaIncome(String semipakaIncome) {
        this.semipakaIncome = semipakaIncome;
    }

    public void setOfficeSpaceINcome(String officeSpaceINcome) {
        this.officeSpaceINcome = officeSpaceINcome;
    }

    public void setWireHouseINcome(String wireHouseINcome) {
        this.wireHouseINcome = wireHouseINcome;
    }

    public void setAg_Income(String ag_Income) {
        this.ag_Income = ag_Income;
    }

    public void setTution(String tution) {
        this.tution = tution;
    }

    public void setRemitance(String remitance) {
        this.remitance = remitance;
    }

    public void setInFdr(String inFdr) {
        this.inFdr = inFdr;
    }

    public void setfExpense(String fExpense) {
        this.fExpense = fExpense;
    }

    public void setEmiOther(String emiOther) {
        this.emiOther = emiOther;
    }

    public void setsValue(String sValue) {
        this.sValue = sValue;
    }

    public void setLoanReq(String loanReq) {
        this.loanReq = loanReq;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public void setPiRate(String piRate) {
        this.piRate = piRate;
    }

    public void setProspectFee(String prospectFee) {
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
