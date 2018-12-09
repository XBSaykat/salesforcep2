package net.maxproit.salesforce.model.newprospect.mynewprosppect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.masum.fragment.prospect.prospectstage.ProspectStageProductAndCustomerDetailsFragment;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.model.myprospect.updatemyprospect.CoApplicant;
import net.maxproit.salesforce.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Md. Mehedi Hasan on 12/3/2018.
 * mehedipy@gmail.com
 */
public class NewProspectUpdate {
    @SerializedName("leadReferenceNo")
    @Expose
    private String leadReferenceNo;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("rmCode")
    @Expose
    private String rmCode;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("branchName")
    @Expose
    private String branchName;
    @SerializedName("branchCode")
    @Expose
    private Integer branchCode;
    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("productSubCategoryId")
    @Expose
    private Integer productSubCategoryId;
    @SerializedName("productSubCategory")
    @Expose
    private String productSubCategory;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("customerId")
    @Expose
    private Integer customerId;
    @SerializedName("contactId")
    @Expose
    private Integer contactId;
    @SerializedName("segment")
    @Expose
    private String segment;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("districtOfBirth")
    @Expose
    private String districtOfBirth;
    @SerializedName("countryOfBirth")
    @Expose
    private String countryOfBirth;
    @SerializedName("photoIdTypeCode")
    @Expose
    private Integer photoIdTypeCode;
    @SerializedName("photoIdNumber")
    @Expose
    private String photoIdNumber;
    @SerializedName("photoIdIssueDate")
    @Expose
    private String photoIdIssueDate;
    @SerializedName("eTin")
    @Expose
    private String eTin;
    @SerializedName("fatherName")
    @Expose
    private String fatherName;
    @SerializedName("motherName")
    @Expose
    private String motherName;
    @SerializedName("spouseName")
    @Expose
    private String spouseName;
    @SerializedName("profession")
    @Expose
    private String profession;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("currentJobDuration")
    @Expose
    private String currentJobDuration;
    @SerializedName("relationshipWithApplicant")
    @Expose
    private String relationshipWithApplicant;
    @SerializedName("permanentAddressId")
    @Expose
    private Integer permanentAddressId;
    @SerializedName("permanentAddress")
    @Expose
    private String permanentAddress;
    @SerializedName("permanentAddressPS")
    @Expose
    private String permanentAddressPS;
    @SerializedName("permanentAddressCity")
    @Expose
    private String permanentAddressCity;
    @SerializedName("presentAddressId")
    @Expose
    private Integer presentAddressId;
    @SerializedName("presentAddress")
    @Expose
    private String presentAddress;
    @SerializedName("presentAddressPS")
    @Expose
    private String presentAddressPS;
    @SerializedName("presentAddressCity")
    @Expose
    private String presentAddressCity;
    @SerializedName("mobileNoId")
    @Expose
    private Integer mobileNoId;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("netSalaryType")
    @Expose
    private String netSalaryType;
    @SerializedName("netSalary")
    @Expose
    private Integer netSalary;
    @SerializedName("businessIncome")
    @Expose
    private Integer businessIncome;
    @SerializedName("apartmentIncome")
    @Expose
    private Integer apartmentIncome;
    @SerializedName("semipakaIncome")
    @Expose
    private Integer semipakaIncome;
    @SerializedName("commercialSpaceIncome")
    @Expose
    private Integer commercialSpaceIncome;
    @SerializedName("factoryIncome")
    @Expose
    private Integer factoryIncome;
    @SerializedName("agriculturalIncome")
    @Expose
    private Integer agriculturalIncome;
    @SerializedName("tutionIncome")
    @Expose
    private Integer tutionIncome;
    @SerializedName("remittanceIncome")
    @Expose
    private Integer remittanceIncome;
    @SerializedName("interestIncomeOfFDR")
    @Expose
    private Integer interestIncomeOfFDR;
    @SerializedName("familyExpenditure")
    @Expose
    private Integer familyExpenditure;
    @SerializedName("emiOfOtherLoan")
    @Expose
    private Integer emiOfOtherLoan;
    @SerializedName("securityValue")
    @Expose
    private Integer securityValue;
    @SerializedName("assetTypeId")
    @Expose
    private Integer assetTypeId;
    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("manufacturerNameId")
    @Expose
    private Integer manufacturerNameId;
    @SerializedName("manufacturerName")
    @Expose
    private String manufacturerName;
    @SerializedName("manufacturingYear")
    @Expose
    private String manufacturingYear;
    @SerializedName("manufacturingCountry")
    @Expose
    private String manufacturingCountry;
    @SerializedName("loanRequired")
    @Expose
    private Integer loanRequired;
    @SerializedName("loanTerm")
    @Expose
    private Integer loanTerm;
    @SerializedName("intersetRate")
    @Expose
    private Float intersetRate;
    @SerializedName("fee")
    @Expose
    private Float fee;
    @SerializedName("coApplicants")
    @Expose
    private List<CoApplicant> coApplicants = new ArrayList<>();

    public String getLeadReferenceNo() {
        return leadReferenceNo;
    }

    public void setLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRmCode() {
        return rmCode;
    }

    public void setRmCode(String rmCode) {
        this.rmCode = rmCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getProductSubCategoryId() {
        return productSubCategoryId;
    }

    public void setProductSubCategoryId(Integer productSubCategoryId) {
        this.productSubCategoryId = productSubCategoryId;
    }

    public String getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDistrictOfBirth() {
        return districtOfBirth;
    }

    public void setDistrictOfBirth(String districtOfBirth) {
        this.districtOfBirth = districtOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public Integer getPhotoIdTypeCode() {
        return photoIdTypeCode;
    }

    public void setPhotoIdTypeCode(Integer photoIdTypeCode) {
        this.photoIdTypeCode = photoIdTypeCode;
    }

    public String getPhotoIdNumber() {
        return photoIdNumber;
    }

    public void setPhotoIdNumber(String photoIdNumber) {
        this.photoIdNumber = photoIdNumber;
    }

    public String getPhotoIdIssueDate() {
        return photoIdIssueDate;
    }

    public void setPhotoIdIssueDate(String photoIdIssueDate) {
        this.photoIdIssueDate = photoIdIssueDate;
    }

    public String getETin() {
        return eTin;
    }

    public void setETin(String eTin) {
        this.eTin = eTin;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCurrentJobDuration() {
        return currentJobDuration;
    }

    public void setCurrentJobDuration(String currentJobDuration) {
        this.currentJobDuration = currentJobDuration;
    }

    public String getRelationshipWithApplicant() {
        return relationshipWithApplicant;
    }

    public void setRelationshipWithApplicant(String relationshipWithApplicant) {
        this.relationshipWithApplicant = relationshipWithApplicant;
    }

    public Integer getPermanentAddressId() {
        return permanentAddressId;
    }

    public void setPermanentAddressId(Integer permanentAddressId) {
        this.permanentAddressId = permanentAddressId;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentAddressPS() {
        return permanentAddressPS;
    }

    public void setPermanentAddressPS(String permanentAddressPS) {
        this.permanentAddressPS = permanentAddressPS;
    }

    public String getPermanentAddressCity() {
        return permanentAddressCity;
    }

    public void setPermanentAddressCity(String permanentAddressCity) {
        this.permanentAddressCity = permanentAddressCity;
    }

    public Integer getPresentAddressId() {
        return presentAddressId;
    }

    public void setPresentAddressId(Integer presentAddressId) {
        this.presentAddressId = presentAddressId;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPresentAddressPS() {
        return presentAddressPS;
    }

    public void setPresentAddressPS(String presentAddressPS) {
        this.presentAddressPS = presentAddressPS;
    }

    public String getPresentAddressCity() {
        return presentAddressCity;
    }

    public void setPresentAddressCity(String presentAddressCity) {
        this.presentAddressCity = presentAddressCity;
    }

    public Integer getMobileNoId() {
        return mobileNoId;
    }

    public void setMobileNoId(Integer mobileNoId) {
        this.mobileNoId = mobileNoId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getNetSalaryType() {
        return netSalaryType;
    }

    public void setNetSalaryType(String netSalaryType) {
        this.netSalaryType = netSalaryType;
    }

    public Integer getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Integer netSalary) {
        this.netSalary = netSalary;
    }

    public Integer getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(Integer businessIncome) {
        this.businessIncome = businessIncome;
    }

    public Integer getApartmentIncome() {
        return apartmentIncome;
    }

    public void setApartmentIncome(Integer apartmentIncome) {
        this.apartmentIncome = apartmentIncome;
    }

    public Integer getSemipakaIncome() {
        return semipakaIncome;
    }

    public void setSemipakaIncome(Integer semipakaIncome) {
        this.semipakaIncome = semipakaIncome;
    }

    public Integer getCommercialSpaceIncome() {
        return commercialSpaceIncome;
    }

    public void setCommercialSpaceIncome(Integer commercialSpaceIncome) {
        this.commercialSpaceIncome = commercialSpaceIncome;
    }

    public Integer getFactoryIncome() {
        return factoryIncome;
    }

    public void setFactoryIncome(Integer factoryIncome) {
        this.factoryIncome = factoryIncome;
    }

    public Integer getAgriculturalIncome() {
        return agriculturalIncome;
    }

    public void setAgriculturalIncome(Integer agriculturalIncome) {
        this.agriculturalIncome = agriculturalIncome;
    }

    public Integer getTutionIncome() {
        return tutionIncome;
    }

    public void setTutionIncome(Integer tutionIncome) {
        this.tutionIncome = tutionIncome;
    }

    public Integer getRemittanceIncome() {
        return remittanceIncome;
    }

    public void setRemittanceIncome(Integer remittanceIncome) {
        this.remittanceIncome = remittanceIncome;
    }

    public Integer getInterestIncomeOfFDR() {
        return interestIncomeOfFDR;
    }

    public void setInterestIncomeOfFDR(Integer interestIncomeOfFDR) {
        this.interestIncomeOfFDR = interestIncomeOfFDR;
    }

    public Integer getFamilyExpenditure() {
        return familyExpenditure;
    }

    public void setFamilyExpenditure(Integer familyExpenditure) {
        this.familyExpenditure = familyExpenditure;
    }

    public Integer getEmiOfOtherLoan() {
        return emiOfOtherLoan;
    }

    public void setEmiOfOtherLoan(Integer emiOfOtherLoan) {
        this.emiOfOtherLoan = emiOfOtherLoan;
    }

    public Integer getSecurityValue() {
        return securityValue;
    }

    public void setSecurityValue(Integer securityValue) {
        this.securityValue = securityValue;
    }

    public Integer getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(Integer assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Integer getManufacturerNameId() {
        return manufacturerNameId;
    }

    public void setManufacturerNameId(Integer manufacturerNameId) {
        this.manufacturerNameId = manufacturerNameId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public String getManufacturingCountry() {
        return manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }

    public Integer getLoanRequired() {
        return loanRequired;
    }

    public void setLoanRequired(Integer loanRequired) {
        this.loanRequired = loanRequired;
    }

    public Integer getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Integer loanTerm) {
        this.loanTerm = loanTerm;
    }

    public Float getIntersetRate() {
        return intersetRate;
    }

    public void setIntersetRate(Float intersetRate) {
        this.intersetRate = intersetRate;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public List<CoApplicant> getCoApplicants() {
        return coApplicants;
    }

    public void setCoApplicants(List<CoApplicant> coApplicants) {
        this.coApplicants = coApplicants;
    }

    public ArrayList<CoApplicant> setCoApplicantsFromProspect(ArrayList<net.maxproit.salesforce.masum.model.local.CoApplicant> coApplicanLocalList) {


        ArrayList<CoApplicant> coApplicantsList = new ArrayList<>();
        CoApplicant coApplicant = new CoApplicant();

        for (int i = 0; i < coApplicanLocalList.size(); i++) {

            try {

                coApplicant.setAgriculturalIncome(Integer.valueOf(coApplicanLocalList.get(i).getMonthAgricultureIncomeAmount().replace(",", "")));
            } catch (NumberFormatException e) {

            }
            try {

                coApplicant.setApartmentIncome(Integer.valueOf(coApplicanLocalList.get(i).getMonthApartmentIncomeAmount().replace(",", "")));
            } catch (NumberFormatException e) {

            }
            try {
                coApplicant.setBusinessIncome(Integer.valueOf(coApplicanLocalList.get(i).getMonthBusinessIncomeAmount().replace(",", "")));
            } catch (NumberFormatException e) {
            }
            try {
                coApplicant.setCommercialSpaceIncome(Integer.valueOf(coApplicanLocalList.get(i).getMonthOfficeSpaceIncomeAmount().replace(",", "")));
            } catch (NumberFormatException e) {
            }
            try {
                coApplicant.setFactoryIncome(Integer.valueOf(coApplicanLocalList.get(i).getMonthWareHouseAmount().replace(",", "")));
            } catch (NumberFormatException e) {
            }
            try {
                coApplicant.setInterestIncomeOfFDR(Integer.valueOf(coApplicanLocalList.get(i).getInterestFDRIncomeAmount().replace(",", "")));
            } catch (NumberFormatException e) {
            }
            try {
                coApplicant.setNetSalary(Integer.valueOf(coApplicanLocalList.get(i).getMonthSalaryAmount().replace(",", "")));
            } catch (NumberFormatException e) {
            }
            try {
                coApplicant.setRemittanceIncome(Integer.valueOf(coApplicanLocalList.get(i).getRemittance()));
            } catch (NumberFormatException e) {
            }
            try {
                coApplicant.setSemipakaIncome(Integer.valueOf(coApplicanLocalList.get(i).getMonthSemipakaIncomeAmount().replace(",", "")));
            } catch (NumberFormatException e) {
            }
            try{
                coApplicant.setTutionIncome(Integer.valueOf(coApplicanLocalList.get(i).getMonthTuitionIncomeAmount().replace(",", "")));
            }catch (NumberFormatException ex){

            }

            coApplicant.setCompany(coApplicanLocalList.get(i).getCompanyName());
            coApplicant.setContactId(coApplicanLocalList.get(i).getContactId());
            coApplicant.setCustomerId(coApplicanLocalList.get(i).getCustomerId());
            coApplicant.setMobile(coApplicanLocalList.get(i).getMobileNo());
            coApplicant.setCountryOfBirth(coApplicanLocalList.get(i).getCountryOfBirth());
            coApplicant.setCurrentJobDuration(coApplicanLocalList.get(i).getNoOfYrsInCurrentJob());
            coApplicant.setCustomerName(coApplicanLocalList.get(i).getName());
            coApplicant.setDateOfBirth(DateUtils.getDateFormateForSqlite(coApplicanLocalList.get(i).getDateOfBirth()));
            coApplicant.setDesignation(coApplicanLocalList.get(i).getDesignation());
            coApplicant.setDistrictOfBirth(coApplicanLocalList.get(i).getDistrictOfBirth());
            coApplicant.setETin(coApplicanLocalList.get(i).geteTin());
            coApplicant.setFatherName(coApplicanLocalList.get(i).getfName());
            coApplicant.setMotherName(coApplicanLocalList.get(i).getmName());
            coApplicant.setNetSalaryType(coApplicanLocalList.get(i).getMonthSalaryType());
            coApplicant.setPermanentAddress(coApplicanLocalList.get(i).getPermanentAddress());
            coApplicant.setPermanentAddressCity("");
            coApplicant.setPermanentAddressId(22);
            coApplicant.setPermanentAddressPS("");
            coApplicant.setPhotoIdIssueDate(DateUtils.getDateFormateForSqlite(coApplicanLocalList.get(i).getPhotoIdIssueDate()));
            coApplicant.setPhotoIdNumber(coApplicanLocalList.get(i).getPhotoIdNo());
            coApplicant.setPhotoIdTypeCode(coApplicanLocalList.get(i).getPhotoIdCode());
            coApplicant.setPresentAddress(coApplicanLocalList.get(i).getPresentAddress());
            coApplicant.setPresentAddressCity("Dhakax");
            coApplicant.setPresentAddressId(coApplicanLocalList.get(i).getPresentAddressId());
            coApplicant.setPresentAddressPS("Dhaka");
            if (!MasumCommonUtils.isNullStr(coApplicanLocalList.get(i).getProfession()))
                coApplicant.setProfession(coApplicanLocalList.get(i).getProfession());
            else coApplicant.setProfession("");
            coApplicant.setRelationshipWithApplicant(coApplicanLocalList.get(i).getRelationWithApplicant());
            coApplicant.setSpouseName(coApplicanLocalList.get(i).getsName());

            coApplicantsList.add(coApplicant);
        }

        return coApplicantsList;
    }


    public void getPRospectDAtaForPostAPi(MyNewProspect myNewProspect) {

        try {
            setAgriculturalIncome(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getAg_Income().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setApartmentIncome(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getApartmentAmount().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setBusinessIncome(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getBusinessIncomeAmount().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setCommercialSpaceIncome(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getOfficeSpaceINcome().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setEmiOfOtherLoan(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getEmiOther().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setFactoryIncome(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getWireHouseINcome().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setFamilyExpenditure(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getfExpense().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setFee(Float.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getProspectFee().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setInterestIncomeOfFDR(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getInFdr().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setIntersetRate(Float.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getPiRate().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setLoanRequired(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getLoanReq().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setLoanTerm(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getLoanTerm())));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setNetSalary(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getSalaryAmount().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setRemittanceIncome(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getRemitance().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setSecurityValue(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getsValue().replace(",", ""))));
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        try {
            setSemipakaIncome(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getSemipakaIncome()).replace(",", "")));
        } catch (NumberFormatException n) {

        } catch (NullPointerException n) {

        }
        try {
            setTutionIncome(Integer.valueOf(CommonUtil.emptyFieldToZero(myNewProspect.getTution().replace(",", ""))));

        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {

        }
        setAssetType("");
        setAssetTypeId(myNewProspect.getAssetTypeId());
        setBranchCode(myNewProspect.getBranchCode());
        setBranchName(myNewProspect.getBranchName());

        setCompany(myNewProspect.getOrganization());
        setContactId(myNewProspect.getContactId());
        setCountryOfBirth(myNewProspect.getCob());
        setCurrentJobDuration(myNewProspect.getCurrentJob());
        setCustomerId(myNewProspect.getCusId());
        setCustomerName(myNewProspect.getUserName());
        setDateOfBirth(DateUtils.getDateFormateForSqlite(myNewProspect.getDateOfBirth()));
        setDesignation(myNewProspect.getDesignation());
        setDistrictOfBirth(myNewProspect.getDob());
        setETin(myNewProspect.getEtin());
        setFatherName(myNewProspect.getfName());
        setLeadReferenceNo(myNewProspect.getRefNumber());
        setManufacturerName(myNewProspect.getManufacturingName());
        setManufacturerNameId(myNewProspect.getManufacturingNameId());
        setManufacturingCountry(myNewProspect.getManufacturingCountry());
        setManufacturingYear(myNewProspect.getManufacturingYear());
        setMobileNo(myNewProspect.getPhone());
        setMobileNoId(myNewProspect.getMobileId());
        setMotherName(myNewProspect.getmName());
        setNetSalaryType(myNewProspect.getNetSalary());
        setPermanentAddress(myNewProspect.getpAddress());
        setPermanentAddressCity("");
        setPermanentAddressId(myNewProspect.getPermAddressId());
        setPermanentAddressPS("");
        setSegment(myNewProspect.getSegment());
        setPhotoIdIssueDate(DateUtils.getDateFormateForSqlite(myNewProspect.getpIssueDate()));
        setPhotoIdNumber(myNewProspect.getpIdNumber());
        setPhotoIdTypeCode(Integer.valueOf(myNewProspect.getpIDType())); // issue
        setPresentAddress(myNewProspect.getAddress());
        setPresentAddressCity("");
        setPresentAddressId(myNewProspect.getPresAddressId());
        setPresentAddressPS("");
        setProduct(myNewProspect.getProductType());
        setProductId(myNewProspect.getProductCode());
        setProductSubCategory(myNewProspect.getProductSubcategory());
        setProductSubCategoryId(myNewProspect.getSubCode());
        setProfession(myNewProspect.getProfession());
        setRelationshipWithApplicant(myNewProspect.getApplicant());
        setRmCode("336132");
        setSpouseName(myNewProspect.getsName());
        setUserName(myNewProspect.getUserID());
        setStatus(myNewProspect.getStatus());


    }

    public void getDBCoApplicants(ArrayList<net.maxproit.salesforce.masum.model.local.CoApplicant> coApplicantList) {


    }
}
