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

        myNewProspect.setApplicant(data.getCustomerName());
        myNewProspect.setUserName(data.getUserName());
        myNewProspect.setRefNumber(data.getLeadReferenceNo());
        myNewProspect.setBranchName(data.getBranchName());
        myNewProspect.setAg_Income(String.valueOf(data.getAgriculturalIncome()));
        myNewProspect.setApartmentAmount(String.valueOf(data.getApartmentIncome()));
        myNewProspect.setBusinessIncomeAmount(String.valueOf(data.getBusinessIncome()));
        myNewProspect.setOfficeSpaceINcome(String.valueOf(data.getCommercialSpaceIncome()));
        myNewProspect.setOrganization(data.getCompany());
        myNewProspect.setProductCode(data.getProductId());
        myNewProspect.setProductType(data.getProduct());
        myNewProspect.setProductSubcategory(data.getProductSubCategory());
        myNewProspect.setDateOfBirth(data.getDateOfBirth());
        myNewProspect.setDob(CommonUtil.jsonToDate(data.getDistrictOfBirth()));
        myNewProspect.setPhone(data.getMobileNo());
        myNewProspect.setProfession(data.getProfession());
        myNewProspect.setDesignation(data.getDesignation());
        myNewProspect.setLoadAmount(String.valueOf(data.getLoanRequired()));
        myNewProspect.setOpFee(String.valueOf(data.getFee()));

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