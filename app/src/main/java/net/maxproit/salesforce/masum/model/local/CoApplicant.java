package net.maxproit.salesforce.masum.model.local;


import net.maxproit.salesforce.masum.utility.DateUtils;

import java.io.Serializable;

public class CoApplicant implements Serializable {


    int id, contactId, customerId, permanentAddressId, presentAddressId, photoIdCode, mobileNoId;
    String name, dateOfBirth, age, districtOfBirth, countryOfBirth, photoIdType, photoIdNo,
            photoIdIssueDate, eTin, fName, mName, sName, profession, companyName,
            designation, noOfYrsInCurrentJob, relationWithApplicant, permanentAddress,
            presentAddress, mobileNo, monthSalaryType, monthSalaryAmount, leadId,
            monthBusinessIncomeAmount, monthWareHouseAmount, monthOfficeSpaceIncomeAmount,
            monthSemipakaIncomeAmount, monthApartmentIncomeAmount, monthAgricultureIncomeAmount,
            monthTuitionIncomeAmount, remittance, interestFDRIncomeAmount, monthFamilyExpenditure,
            emiOfOtherLoans, permanentAddressCity, permanentAddressPS, presentAddressCity, presentAddressPS;
    private int exceptionList;

    public CoApplicant() {
    }

    ;

    //            for retrieving from DB
    public CoApplicant(int id, String leadId, String name, String dateOfBirth, String age,
                       String districtOfBirth, String countryOfBirth, String photoIdType,
                       String photoIdNo, String photoIdIssueDate, String eTin, String fName,
                       String mName, String sName, String profession, int exceptionList,
                       String companyName, String designation, String noOfYrsInCurrentJob,
                       String relationWithApplicant, String permanentAddress, String presentAddress,
                       String mobileNo, String monthSalaryType, String monthSalaryAmount,
                       String monthBusinessIncomeAmount, String monthWareHouseAmount,
                       String monthOfficeSpaceIncomeAmount, String monthSemipakaIncomeAmount,
                       String monthApartmentIncomeAmount, String monthAgricultureIncomeAmount,
                       String monthTuitionIncomeAmount, String remittance,
                       String interestFDRIncomeAmount, String monthFamilyExpenditure,
                       String emiOfOtherLoans) {
        this.id = id;
        this.leadId = leadId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.districtOfBirth = districtOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.photoIdType = photoIdType;
        this.photoIdNo = photoIdNo;
        this.photoIdIssueDate = photoIdIssueDate;
        this.eTin = eTin;
        this.fName = fName;
        this.mName = mName;
        this.sName = sName;
        this.profession = profession;
        this.exceptionList = exceptionList;
        this.companyName = companyName;
        this.designation = designation;
        this.noOfYrsInCurrentJob = noOfYrsInCurrentJob;
        this.relationWithApplicant = relationWithApplicant;
        this.permanentAddress = permanentAddress;
        this.presentAddress = presentAddress;
        this.mobileNo = mobileNo;
        this.monthSalaryType = monthSalaryType;
        this.monthSalaryAmount = monthSalaryAmount;
        this.monthBusinessIncomeAmount = monthBusinessIncomeAmount;
        this.monthWareHouseAmount = monthWareHouseAmount;
        this.monthOfficeSpaceIncomeAmount = monthOfficeSpaceIncomeAmount;
        this.monthSemipakaIncomeAmount = monthSemipakaIncomeAmount;
        this.monthApartmentIncomeAmount = monthApartmentIncomeAmount;
        this.monthAgricultureIncomeAmount = monthAgricultureIncomeAmount;
        this.monthTuitionIncomeAmount = monthTuitionIncomeAmount;
        this.remittance = remittance;
        this.interestFDRIncomeAmount = interestFDRIncomeAmount;
        this.monthFamilyExpenditure = monthFamilyExpenditure;
        this.emiOfOtherLoans = emiOfOtherLoans;
    }

    //                for inserting in DB
    public CoApplicant(String leadId, String name, String dateOfBirth, String age,
                       String districtOfBirth, String countryOfBirth, String photoIdType,
                       String photoIdNo, String photoIdIssueDate, String eTin, String fName,
                       String mName, String sName, String profession, int exceptionList,
                       String companyName, String designation, String noOfYrsInCurrentJob,
                       String relationWithApplicant, String permanentAddress, String presentAddress,
                       String mobileNo, String monthSalaryType, String monthSalaryAmount,
                       String monthBusinessIncomeAmount, String monthWareHouseAmount,
                       String monthOfficeSpaceIncomeAmount, String monthSemipakaIncomeAmount,
                       String monthApartmentIncomeAmount, String monthAgricultureIncomeAmount,
                       String monthTuitionIncomeAmount, String remittance,
                       String interestFDRIncomeAmount, String monthFamilyExpenditure,
                       String emiOfOtherLoans) {
        this.leadId = leadId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.districtOfBirth = districtOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.photoIdType = photoIdType;
        this.photoIdNo = photoIdNo;
        this.photoIdIssueDate = photoIdIssueDate;
        this.eTin = eTin;
        this.fName = fName;
        this.mName = mName;
        this.sName = sName;
        this.profession = profession;
        this.exceptionList = exceptionList;
        this.companyName = companyName;
        this.designation = designation;
        this.noOfYrsInCurrentJob = noOfYrsInCurrentJob;
        this.relationWithApplicant = relationWithApplicant;
        this.permanentAddress = permanentAddress;
        this.presentAddress = presentAddress;
        this.mobileNo = mobileNo;
        this.monthSalaryType = monthSalaryType;
        this.monthSalaryAmount = monthSalaryAmount;
        this.monthBusinessIncomeAmount = monthBusinessIncomeAmount;
        this.monthWareHouseAmount = monthWareHouseAmount;
        this.monthOfficeSpaceIncomeAmount = monthOfficeSpaceIncomeAmount;
        this.monthSemipakaIncomeAmount = monthSemipakaIncomeAmount;
        this.monthApartmentIncomeAmount = monthApartmentIncomeAmount;
        this.monthAgricultureIncomeAmount = monthAgricultureIncomeAmount;
        this.monthTuitionIncomeAmount = monthTuitionIncomeAmount;
        this.remittance = remittance;
        this.interestFDRIncomeAmount = interestFDRIncomeAmount;
        this.monthFamilyExpenditure = monthFamilyExpenditure;
        this.emiOfOtherLoans = emiOfOtherLoans;
    }

    public int getPhotoIdCode() {
        return photoIdCode;
    }

    public int getExceptionList() {
        return exceptionList;
    }

    public void setExceptionList(int exceptionList) {
        this.exceptionList = exceptionList;
    }

    public void setPhotoIdCode(int photoIdCode) {
        this.photoIdCode = photoIdCode;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getId() {
        return id;
    }

    public String getLeadId() {
        return leadId;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAge() {
        return age;
    }

    public String getDistrictOfBirth() {
        return districtOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public String getPhotoIdType() {
        return photoIdType;
    }

    public String getPhotoIdNo() {
        return photoIdNo;
    }

    public int getMobileNoId() {
        return mobileNoId;
    }

    public void setMobileNoId(int mobileNoId) {
        this.mobileNoId = mobileNoId;
    }

    public String getPhotoIdIssueDate() {
        return photoIdIssueDate;
    }

    public String geteTin() {
        return eTin;
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

    public String getProfession() {
        return profession;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public String getNoOfYrsInCurrentJob() {
        return noOfYrsInCurrentJob;
    }

    public String getRelationWithApplicant() {
        return relationWithApplicant;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getMonthSalaryType() {
        return monthSalaryType;
    }

    public String getMonthSalaryAmount() {
        return monthSalaryAmount;
    }

    public String getMonthBusinessIncomeAmount() {
        return monthBusinessIncomeAmount;
    }

    public String getMonthWareHouseAmount() {
        return monthWareHouseAmount;
    }

    public String getMonthOfficeSpaceIncomeAmount() {
        return monthOfficeSpaceIncomeAmount;
    }

    public String getMonthSemipakaIncomeAmount() {
        return monthSemipakaIncomeAmount;
    }

    public String getMonthApartmentIncomeAmount() {
        return monthApartmentIncomeAmount;
    }

    public String getMonthAgricultureIncomeAmount() {
        return monthAgricultureIncomeAmount;
    }

    public String getMonthTuitionIncomeAmount() {
        return monthTuitionIncomeAmount;
    }

    public int getPermanentAddressId() {
        return permanentAddressId;
    }

    public void setPermanentAddressId(int permanentAddressCityId) {
        this.permanentAddressId = permanentAddressCityId;
    }

    public int getPresentAddressId() {
        return presentAddressId;
    }

    public void setPresentAddressId(int presentAddressId) {
        this.presentAddressId = presentAddressId;
    }

    public String getPermanentAddressCity() {
        return permanentAddressCity;
    }

    public void setPermanentAddressCity(String permanentAddressCity) {
        this.permanentAddressCity = permanentAddressCity;
    }

    public String getPermanentAddressPS() {
        return permanentAddressPS;
    }

    public void setPermanentAddressPS(String permanentAddressPS) {
        this.permanentAddressPS = permanentAddressPS;
    }

    public String getPresentAddressCity() {
        return presentAddressCity;
    }

    public void setPresentAddressCity(String presentAddressCity) {
        this.presentAddressCity = presentAddressCity;
    }

    public String getPresentAddressPS() {
        return presentAddressPS;
    }

    public void setPresentAddressPS(String presentAddressPS) {
        this.presentAddressPS = presentAddressPS;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDistrictOfBirth(String districtOfBirth) {
        this.districtOfBirth = districtOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public void setPhotoIdType(String photoIdType) {
        this.photoIdType = photoIdType;
    }

    public void setPhotoIdNo(String photoIdNo) {
        this.photoIdNo = photoIdNo;
    }

    public void setPhotoIdIssueDate(String photoIdIssueDate) {
        this.photoIdIssueDate = photoIdIssueDate;
    }

    public void seteTin(String eTin) {
        this.eTin = eTin;
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

    public void setProfession(String profession) {
        this.profession = profession;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setNoOfYrsInCurrentJob(String noOfYrsInCurrentJob) {
        this.noOfYrsInCurrentJob = noOfYrsInCurrentJob;
    }

    public void setRelationWithApplicant(String relationWithApplicant) {
        this.relationWithApplicant = relationWithApplicant;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setMonthSalaryType(String monthSalaryType) {
        this.monthSalaryType = monthSalaryType;
    }

    public void setMonthSalaryAmount(String monthSalaryAmount) {
        this.monthSalaryAmount = monthSalaryAmount;
    }

    public void setMonthBusinessIncomeAmount(String monthBusinessIncomeAmount) {
        this.monthBusinessIncomeAmount = monthBusinessIncomeAmount;
    }

    public void setMonthWareHouseAmount(String monthWareHouseAmount) {
        this.monthWareHouseAmount = monthWareHouseAmount;
    }

    public void setMonthOfficeSpaceIncomeAmount(String monthOfficeSpaceIncomeAmount) {
        this.monthOfficeSpaceIncomeAmount = monthOfficeSpaceIncomeAmount;
    }

    public void setMonthSemipakaIncomeAmount(String monthSemipakaIncomeAmount) {
        this.monthSemipakaIncomeAmount = monthSemipakaIncomeAmount;
    }

    public void setMonthApartmentIncomeAmount(String monthApartmentIncomeAmount) {
        this.monthApartmentIncomeAmount = monthApartmentIncomeAmount;
    }

    public void setMonthAgricultureIncomeAmount(String monthAgricultureIncomeAmount) {
        this.monthAgricultureIncomeAmount = monthAgricultureIncomeAmount;
    }

    public void setMonthTuitionIncomeAmount(String monthTuitionIncomeAmount) {
        this.monthTuitionIncomeAmount = monthTuitionIncomeAmount;
    }

    public void setRemittance(String remittance) {
        this.remittance = remittance;
    }

    public void setInterestFDRIncomeAmount(String interestFDRIncomeAmount) {
        this.interestFDRIncomeAmount = interestFDRIncomeAmount;
    }

    public void setMonthFamilyExpenditure(String monthFamilyExpenditure) {
        this.monthFamilyExpenditure = monthFamilyExpenditure;
    }

    public void setEmiOfOtherLoans(String emiOfOtherLoans) {
        this.emiOfOtherLoans = emiOfOtherLoans;
    }

    public String getRemittance() {
        return remittance;
    }

    public String getInterestFDRIncomeAmount() {
        return interestFDRIncomeAmount;
    }

    public String getMonthFamilyExpenditure() {
        return monthFamilyExpenditure;
    }

    public String getEmiOfOtherLoans() {
        return emiOfOtherLoans;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }






    public void setcoApplicantDatafromServer(net.maxproit.salesforce.model.myprospect.updatemyprospect.CoApplicant coApplicantServer){

        setName(coApplicantServer.getCustomerName());
        setCustomerId(coApplicantServer.getCustomerId());
        setPermanentAddress(coApplicantServer.getPermanentAddress());
        setPermanentAddressId(coApplicantServer.getPermanentAddressId());
        setPresentAddress(coApplicantServer.getPresentAddress());
        setPresentAddressId(coApplicantServer.getPresentAddressId());
        setPermanentAddressCity(coApplicantServer.getPermanentAddressCity());
        setPermanentAddressPS(coApplicantServer.getPermanentAddressPS());
        setPresentAddressCity(coApplicantServer.getPresentAddressCity());
        setPresentAddressPS(coApplicantServer.getPresentAddressPS());


        setCompanyName(coApplicantServer.getCompany());
        if (coApplicantServer.getDateOfBirth() !=null)
        setDateOfBirth(DateUtils.getDateFormateEt(DateUtils.jsonToDate(coApplicantServer.getDateOfBirth())));
        setPhotoIdIssueDate(DateUtils.getDateFormateEt(DateUtils.jsonToDate(coApplicantServer.getPhotoIdIssueDate())));
        setPhotoIdCode(coApplicantServer.getPhotoIdTypeCode());
        setPhotoIdType(String.valueOf(coApplicantServer.getPhotoIdTypeCode()));
        setPhotoIdNo(coApplicantServer.getPhotoIdNumber());
        setExceptionList(coApplicantServer.getExceptionList());
        if (coApplicantServer.getPhotoIdIssueDate() !=null)
            setPhotoIdIssueDate(DateUtils.getDateFormateEt(DateUtils.jsonToDate(coApplicantServer.getPhotoIdIssueDate())));
        setCountryOfBirth(coApplicantServer.getCountryOfBirth());
        setDistrictOfBirth(coApplicantServer.getDistrictOfBirth());
        setfName(coApplicantServer.getFatherName());
        setmName(coApplicantServer.getMotherName());
        setsName(coApplicantServer.getSpouseName());
        setMobileNoId(coApplicantServer.getMobileNoId());
        setMobileNo(coApplicantServer.getMobile());
        setContactId(coApplicantServer.getContactId());
        setProfession(coApplicantServer.getProfession());




    }

}
