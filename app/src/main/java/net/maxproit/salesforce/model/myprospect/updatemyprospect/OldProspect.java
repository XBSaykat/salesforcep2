package net.maxproit.salesforce.model.myprospect.updatemyprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.masum.model.local.CoApplicant;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class OldProspect {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public MyNewProspect getMyNewProspect() {

        MyNewProspect myNewProspect = new MyNewProspect();


        myNewProspect.setAg_Income(MasumCommonUtils.isNotZero(data.getAgriculturalIncome()));
        myNewProspect.setPiRate(MasumCommonUtils.isNotZero(data.getIntersetRate()));
        myNewProspect.setInFdr(MasumCommonUtils.isNotZero(data.getInterestIncomeOfFDR()));
        myNewProspect.setEmiOther(MasumCommonUtils.isNotZero(data.getEmiOfOtherLoan()));
        myNewProspect.setWireHouseINcome(MasumCommonUtils.isNotZero(data.getFactoryIncome()));
        myNewProspect.setfExpense(MasumCommonUtils.isNotZero(data.getFamilyExpenditure()));
        myNewProspect.setBusinessIncomeAmount(MasumCommonUtils.isNotZero(data.getBusinessIncome()));
        myNewProspect.setOfficeSpaceINcome(MasumCommonUtils.isNotZero(data.getCommercialSpaceIncome()));
        myNewProspect.setApartmentAmount(MasumCommonUtils.isNotZero(data.getApartmentIncome()));
        myNewProspect.setApplicant(data.getRelationshipWithApplicant());
        myNewProspect.setUserName(data.getCustomerName());
        myNewProspect.setExceptionList(data.getExceptionList());

        myNewProspect.setRuleEngineInformation(data.getRuleEngineInformation());
        myNewProspect.setcIBInformation(data.getCIBInformation());
        myNewProspect.setRefNumber(data.getLeadReferenceNo());
        myNewProspect.setBranchCode(data.getBranchCode());
        myNewProspect.setBranchName(data.getBranchName());
        myNewProspect.setContactId(data.getContactId());
        myNewProspect.setCob(data.getCountryOfBirth());
        myNewProspect.setCurrentJob(data.getCurrentJobDuration());
        myNewProspect.setCusId(data.getCustomerId());
        myNewProspect.setDob(data.getDistrictOfBirth());
        myNewProspect.setDateOfBirth(data.getDateOfBirth());
        myNewProspect.setfName(data.getFatherName());
        myNewProspect.setmName(data.getMotherName());
        myNewProspect.setsName(data.getSpouseName());
        myNewProspect.setProspectFee(MasumCommonUtils.isNotZero(data.getFee()));
        myNewProspect.setRmCode(data.getRmCode());
        myNewProspect.setStatus(data.getStatus());
        myNewProspect.setSegment(data.getSegment());
        myNewProspect.setMobileId(data.getMobileNoId());
        myNewProspect.setOrganization(data.getCompany());
        myNewProspect.setProductCode(data.getProductId());
        myNewProspect.setProductType(data.getProduct());
        myNewProspect.setProductSubcategory(data.getProductSubCategory());
        myNewProspect.setSubCode(data.getProductSubCategoryId());
        myNewProspect.setDateOfBirth(CommonUtil.jsonToDate(data.getDateOfBirth()));
        myNewProspect.setPhone(data.getMobileNo());
        myNewProspect.setProfession(data.getProfession());
        myNewProspect.setDesignation(data.getDesignation());
        myNewProspect.setLoanReq(MasumCommonUtils.isNotZero(data.getLoanRequired()));
        myNewProspect.setLoanTerm(MasumCommonUtils.isNotZero(data.getLoanTerm()));
        myNewProspect.setOpFee(MasumCommonUtils.isNotZero(data.getFee()));
        myNewProspect.setMobileId(data.getMobileNoId());
        myNewProspect.setNetSalary(data.getNetSalaryType());
        myNewProspect.setSalaryAmount(MasumCommonUtils.isNotZero(data.getNetSalary()));
        myNewProspect.setpIssueDate(CommonUtil.jsonToDate(data.getPhotoIdIssueDate()));
        myNewProspect.setpIdNumber(data.getPhotoIdNumber());
        myNewProspect.setpIDType(String.valueOf(data.getPhotoIdTypeCode()));
        myNewProspect.setPermAddressId(data.getPermanentAddressId());
        myNewProspect.setPresAddressId(data.getPresentAddressId());
        myNewProspect.setAddress(data.getPresentAddress());

        myNewProspect.setperAddress(data.getPermanentAddress());
        myNewProspect.setPresAddressCity(data.getPresentAddressCity());
        myNewProspect.setPresAddressPs(data.getPresentAddressPS());
        myNewProspect.setPermAddressCity(data.getPermanentAddressCity());
        myNewProspect.setPermAddressPs(data.getPermanentAddressPS());
        myNewProspect.setSourceRef(data.getRelationshipWithApplicant());
        myNewProspect.setsValue(MasumCommonUtils.isNotZero(data.getSecurityValue()));
        myNewProspect.setOrInterest(MasumCommonUtils.isNotZero(data.getIntersetRate()));

//        myNewProspect.setRmCode(data.getRmCode());
//        myNewProspect.setUserName(data.getUserName());
        myNewProspect.setEtin(data.getETin());
        myNewProspect.setTution(MasumCommonUtils.isNotZero(data.getTutionIncome()));
        myNewProspect.setSegment(data.getSegment());
        myNewProspect.setRemitance(MasumCommonUtils.isNotZero(data.getRemittanceIncome()));
        myNewProspect.setSemipakaIncome(MasumCommonUtils.isNotZero(data.getSemipakaIncome()));

        myNewProspect.setManufacturingName(data.getManufacturerName());
        myNewProspect.setManufacturingNameId(data.getManufacturerNameId());
        myNewProspect.setAssetType(data.getAssetType());
        myNewProspect.setAssetTypeId(data.getAssetTypeId());
        myNewProspect.setManufacturingYear(data.getManufacturingYear());
        myNewProspect.setManufacturingCountry(data.getManufacturingCountry());
        List<net.maxproit.salesforce.masum.model.local.CoApplicant> coApplicantList = new ArrayList<>();
        if (!data.getCoApplicants().isEmpty()) {

            for (int i = 0; i < data.getCoApplicants().size(); i++) {
                net.maxproit.salesforce.masum.model.local.CoApplicant coApplicant = new CoApplicant();
                coApplicant.setMonthAgricultureIncomeAmount(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getAgriculturalIncome()));
                coApplicant.setMonthApartmentIncomeAmount(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getApartmentIncome()));
                coApplicant.setMonthBusinessIncomeAmount(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getBusinessIncome()));
                coApplicant.setMonthOfficeSpaceIncomeAmount(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getCommercialSpaceIncome()));
                coApplicant.setCompanyName(data.getCoApplicants().get(i).getCompany());
                coApplicant.setMobileNoId(data.getCoApplicants().get(i).getMobileNoId());
                coApplicant.setCustomerId(data.getCoApplicants().get(i).getCustomerId());
                coApplicant.setContactId(data.getCoApplicants().get(i).getContactId());
                coApplicant.setCountryOfBirth(data.getCoApplicants().get(i).getCountryOfBirth());
                coApplicant.setNoOfYrsInCurrentJob(data.getCoApplicants().get(i).getCurrentJobDuration());
                coApplicant.setName(data.getCoApplicants().get(i).getCustomerName());
                coApplicant.setExceptionList(data.getCoApplicants().get(i).getExceptionList());
                coApplicant.setDateOfBirth(data.getCoApplicants().get(i).getDateOfBirth());
                coApplicant.setDesignation(data.getCoApplicants().get(i).getDesignation());
                coApplicant.setDistrictOfBirth(data.getCoApplicants().get(i).getDistrictOfBirth());
                coApplicant.seteTin(data.getCoApplicants().get(i).getETin());
                coApplicant.setMonthWareHouseAmount(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getFactoryIncome()));
                coApplicant.setfName(data.getCoApplicants().get(i).getFatherName());
                coApplicant.setInterestFDRIncomeAmount(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getInterestIncomeOfFDR()));
                coApplicant.setMobileNo(data.getCoApplicants().get(i).getMobile());
                coApplicant.setmName(data.getCoApplicants().get(i).getMotherName());
                coApplicant.setMonthSalaryType(data.getCoApplicants().get(i).getNetSalaryType());
                coApplicant.setMonthSalaryAmount(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getNetSalary()));
                coApplicant.setPermanentAddress(data.getCoApplicants().get(i).getPermanentAddress());
                coApplicant.setPermanentAddressId(data.getCoApplicants().get(i).getPermanentAddressId());
                coApplicant.setPresentAddressId(data.getCoApplicants().get(i).getPresentAddressId());
                coApplicant.setPresentAddress(data.getCoApplicants().get(i).getPresentAddress());
                coApplicant.setPermanentAddressCity(data.getCoApplicants().get(i).getPermanentAddressCity());
                coApplicant.setPermanentAddressPS(data.getCoApplicants().get(i).getPermanentAddressPS());
                coApplicant.setPresentAddressCity(data.getCoApplicants().get(i).getPresentAddressCity());
                coApplicant.setPresentAddressPS(data.getCoApplicants().get(i).getPresentAddressPS());
                coApplicant.setPhotoIdIssueDate(data.getCoApplicants().get(i).getPhotoIdIssueDate());
                coApplicant.setPhotoIdNo(data.getCoApplicants().get(i).getPhotoIdNumber());
                coApplicant.setPhotoIdCode(data.getCoApplicants().get(i).getPhotoIdTypeCode());
                coApplicant.setProfession(data.getCoApplicants().get(i).getProfession());
                coApplicant.setRelationWithApplicant(data.getCoApplicants().get(i).getRelationshipWithApplicant());
                coApplicant.setMonthSemipakaIncomeAmount(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getSemipakaIncome()));
                coApplicant.setsName(data.getCoApplicants().get(i).getSpouseName());
                coApplicant.setRemittance(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getRemittanceIncome()));
                coApplicant.setMonthTuitionIncomeAmount(MasumCommonUtils.isNotZero(data.getCoApplicants().get(i).getTutionIncome()));
                coApplicantList.add(coApplicant);
            }

            myNewProspect.setCoApplicantList(coApplicantList);

        }


        return myNewProspect;

    }


}