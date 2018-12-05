package net.maxproit.salesforce.model.myprospect.updatemyprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.masum.model.local.MyNewProspect;
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

    public MyNewProspect getMyNewProspect(){

        MyNewProspect myNewProspect = new MyNewProspect();

        myNewProspect.setAg_Income(String.valueOf(data.getAgriculturalIncome()));
        myNewProspect.setApartmentAmount(String.valueOf(data.getApartmentIncome()));
        myNewProspect.setAssetType(data.getAssetType());
        myNewProspect.setAssetTypeId(data.getAssetTypeId());
        myNewProspect.setApplicant(data.getCustomerName());
        myNewProspect.setBrandName(data.getBrandName());
        myNewProspect.setRefNumber(data.getLeadReferenceNo());
        myNewProspect.setBranchCode(data.getBranchCode());
        myNewProspect.setBusinessIncomeAmount(String.valueOf(data.getBusinessIncome()));
        myNewProspect.setBranchName(data.getBranchName());
        myNewProspect.setOfficeSpaceINcome(String.valueOf(data.getCommercialSpaceIncome()));
        myNewProspect.setPermAddressId(data.getPermanentAddressId());
        myNewProspect.setPresAddressId(data.getPresentAddressId());
        myNewProspect.setContactId(data.getContactId());
        myNewProspect.setCob(data.getCountryOfBirth());
        myNewProspect.setCurrentJob(data.getCurrentJobDuration());
        myNewProspect.setCusId(data.getCustomerId());
        myNewProspect.setDob(data.getDistrictOfBirth());
        myNewProspect.setDateOfBirth(data.getDateOfBirth());
        myNewProspect.setPiRate(String.valueOf(data.getIntersetRate()));
        myNewProspect.setInFdr(String.valueOf(data.getInterestIncomeOfFDR()));
        myNewProspect.setEmiOther(String.valueOf(data.getEmiOfOtherLoan()));
        myNewProspect.setWireHouseINcome(String.valueOf(data.getFactoryIncome()));
        myNewProspect.setfExpense(String.valueOf(data.getFamilyExpenditure()));
        myNewProspect.setfName(data.getFatherName());
        myNewProspect.setmName(data.getMotherName());
        myNewProspect.setsName(data.getSpouseName());
        myNewProspect.setProspectFee(String.valueOf(data.getFee()));
        myNewProspect.setRmCode(data.getRmCode());
        myNewProspect.setStatus(data.getStatus());
        myNewProspect.setOfficeSpaceINcome(String.valueOf(data.getCommercialSpaceIncome()));
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
        myNewProspect.setLoanReq(String.valueOf(data.getLoanRequired()));
        myNewProspect.setLoanTerm(String.valueOf(data.getLoanTerm()));
        myNewProspect.setOpFee(String.valueOf(data.getFee()));
        myNewProspect.setManufacturingCountry(data.getManufacturingCountry());
        myNewProspect.setManufacturingName(data.getManufacturerName());
        myNewProspect.setManufacturingNameId(data.getManufacturerNameId());
        myNewProspect.setManufacturingYear(data.getManufacturingYear());
        myNewProspect.setMobileId(data.getMobileNoId());
        myNewProspect.setNetSalary(data.getNetSalaryType());
        myNewProspect.setSalaryAmount(String.valueOf(data.getNetSalary()));
        myNewProspect.setNetSalary(String.valueOf(data.getNetSalary()));
        myNewProspect.setPermAddressCity(data.getPermanentAddressCity());
        myNewProspect.setpAddress(data.getPermanentAddress());
        myNewProspect.setPermAddressPs(data.getPermanentAddressPS());
        myNewProspect.setpIssueDate(CommonUtil.jsonToDate(data.getPhotoIdIssueDate()));
        myNewProspect.setpIdNumber(data.getPhotoIdNumber());
        myNewProspect.setAddress(data.getPresentAddress());
        myNewProspect.setPresAddressCity(data.getPresentAddressCity());
        myNewProspect.setPresAddressPs(data.getPresentAddressPS());
        myNewProspect.setSourceRef(data.getRelationshipWithApplicant());
        myNewProspect.setsValue(String.valueOf(data.getSecurityValue()));
//        myNewProspect.setRmCode(data.getRmCode());
//        myNewProspect.setUserName(data.getUserName());
        myNewProspect.setEtin(data.getETin());
        myNewProspect.setTution(String.valueOf(data.getTutionIncome()));
        myNewProspect.setSegment(data.getSegment());
        myNewProspect.setRemitance(String.valueOf(data.getRemittanceIncome()));
        myNewProspect.setSemipakaIncome(String.valueOf(data.getSemipakaIncome()));



        List<CoApplicant> coApplicantList = new ArrayList<>();
        if ( !data.getCoApplicants().isEmpty()){

            for (int i = 0; i < data.getCoApplicants().size(); i++) {
                CoApplicant coApplicant = new CoApplicant();
                coApplicant.setAgriculturalIncome(data.getCoApplicants().get(i).getAgriculturalIncome());
                coApplicant.setApartmentIncome(data.getCoApplicants().get(i).getApartmentIncome());
                coApplicant.setBusinessIncome(data.getCoApplicants().get(i).getBusinessIncome());
                coApplicant.setCommercialSpaceIncome(data.getCoApplicants().get(i).getCommercialSpaceIncome());
                coApplicant.setCompany(data.getCoApplicants().get(i).getCompany());
                coApplicant.setContactId(data.getCoApplicants().get(i).getContactId());
                coApplicant.setCountryOfBirth(data.getCoApplicants().get(i).getCountryOfBirth());
                coApplicant.setCurrentJobDuration(data.getCoApplicants().get(i).getCurrentJobDuration());
                coApplicant.setCustomerId(data.getCoApplicants().get(i).getCustomerId());
                coApplicant.setCustomerName(data.getCoApplicants().get(i).getCustomerName());
                coApplicant.setDateOfBirth(data.getCoApplicants().get(i).getDateOfBirth());
                coApplicant.setDesignation(data.getCoApplicants().get(i).getDesignation());
                coApplicant.setDistrictOfBirth(data.getCoApplicants().get(i).getDistrictOfBirth());
                coApplicant.setETin(data.getCoApplicants().get(i).getETin());
                coApplicant.setFactoryIncome(data.getCoApplicants().get(i).getFactoryIncome());
                coApplicant.setFatherName(data.getCoApplicants().get(i).getFatherName());
                coApplicant.setInterestIncomeOfFDR(data.getCoApplicants().get(i).getInterestIncomeOfFDR());
                coApplicant.setMobile(data.getCoApplicants().get(i).getMobile());
                coApplicant.setMotherName(data.getCoApplicants().get(i).getMotherName());
                coApplicant.setNetSalary(data.getCoApplicants().get(i).getNetSalary());
                coApplicant.setPermanentAddress(data.getCoApplicants().get(i).getPermanentAddress());
                coApplicant.setPermanentAddressCity(data.getCoApplicants().get(i).getPermanentAddressCity());
                coApplicant.setPermanentAddressId(data.getCoApplicants().get(i).getPermanentAddressId());
                coApplicant.setPermanentAddressPS(data.getCoApplicants().get(i).getPermanentAddressPS());
                coApplicant.setPhotoIdIssueDate(data.getCoApplicants().get(i).getPhotoIdIssueDate());
                coApplicant.setPhotoIdNumber(data.getCoApplicants().get(i).getPhotoIdNumber());
                coApplicant.setPhotoIdTypeCode(data.getCoApplicants().get(i).getPhotoIdTypeCode());
                coApplicant.setPresentAddress(data.getCoApplicants().get(i).getPresentAddress());
                coApplicant.setPresentAddressCity(data.getCoApplicants().get(i).getPresentAddressCity());
                coApplicant.setPresentAddressId(data.getCoApplicants().get(i).getPresentAddressId());
                coApplicant.setPresentAddressPS(data.getCoApplicants().get(i).getPresentAddressPS());
                coApplicant.setProfession(data.getCoApplicants().get(i).getProfession());
                coApplicant.setRelationshipWithApplicant(data.getCoApplicants().get(i).getRelationshipWithApplicant());
                coApplicant.setSemipakaIncome(data.getCoApplicants().get(i).getSemipakaIncome());
                coApplicant.setSpouseName(data.getCoApplicants().get(i).getSpouseName());
                coApplicant.setRemittanceIncome(data.getCoApplicants().get(i).getRemittanceIncome());
                coApplicant.setTutionIncome(data.getCoApplicants().get(i).getTutionIncome());

                coApplicantList.add(coApplicant);
            }

        }


            return myNewProspect;

    }


}