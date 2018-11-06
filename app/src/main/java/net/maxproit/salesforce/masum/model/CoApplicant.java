package net.maxproit.salesforce.masum.model;


public class CoApplicant {

    int id, leadId;
    String  name, segment,dateOfBirth, age, districtOfBirth, countryOfBirth, photoIdType, photoIdNo,
            photoIdIssueDate, eTin, fName, mName, sName, profession, exList, companyName,
            designation, noOfYrsInCurrentJob, relationWithApplicant, permanentAddress,
            presentAddress, mobileNo, monthSalaryType, monthSalaryAmount,
            monthBusinessIncomeAmount, monthWareHouseAmount,monthOfficeSpaceIncomeAmount,
            monthSemipakaIncomeAmount, monthApartmentIncomeAmount, monthAgricultureIncomeAmount,
            monthTuitionIncomeAmount, remittance, interestFDRIncomeAmount, monthFamilyExpenditure,
            emiOfOtherLoans;
//            for retrieving from DB
    public CoApplicant(int id, int leadId, String name, String segment, String dateOfBirth, String age,
                       String districtOfBirth, String countryOfBirth, String photoIdType,
                       String photoIdNo, String photoIdIssueDate, String eTin, String fName,
                       String mName, String sName, String profession, String exList,
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
        this.segment = segment;
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
        this.exList = exList;
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
    public CoApplicant(String name, String segment, String dateOfBirth, String age,
                       String districtOfBirth, String countryOfBirth, String photoIdType,
                       String photoIdNo, String photoIdIssueDate, String eTin, String fName,
                       String mName, String sName, String profession, String exList,
                       String companyName, String designation, String noOfYrsInCurrentJob,
                       String relationWithApplicant, String permanentAddress, String presentAddress,
                       String mobileNo, String monthSalaryType, String monthSalaryAmount,
                       String monthBusinessIncomeAmount, String monthWareHouseAmount,
                       String monthOfficeSpaceIncomeAmount, String monthSemipakaIncomeAmount,
                       String monthApartmentIncomeAmount, String monthAgricultureIncomeAmount,
                       String monthTuitionIncomeAmount, String remittance,
                       String interestFDRIncomeAmount, String monthFamilyExpenditure,
                       String emiOfOtherLoans) {
        this.name = name;
        this.segment = segment;
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
        this.exList = exList;
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


    public int getId() {
        return id;
    }

    public int getLeadId() {
        return leadId;
    }

    public String getName() {
        return name;
    }

    public String getSegment() {
        return segment;
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

    public String getExList() {
        return exList;
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
}
