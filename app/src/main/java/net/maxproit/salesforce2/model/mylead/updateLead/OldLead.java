
package net.maxproit.salesforce2.model.mylead.updateLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce2.model.newlead.BasicInfo;
import net.maxproit.salesforce2.model.newlead.IndustryInfo;
import net.maxproit.salesforce2.model.newlead.NewLead;

public class OldLead {

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

    public OldLead withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OldLead withCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OldLead withMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public OldLead withData(Data data) {
        this.data = data;
        return this;
    }


    public NewLead getNewLead() {
        NewLead newLead = new NewLead();
        newLead.setLeadReferenceNo(getData().getLeadReferenceNo());


        newLead.setBasicInfo(new BasicInfo(
                "",
                getData().getBasicInfo().getBranchName(),
                getData().getBasicInfo().getBoothCode(),
                getData().getBasicInfo().getBoothName(),
                getData().getBasicInfo().getSalesOfficerCode(),
                getData().getBasicInfo().getSalesOfficerName(),
                getData().getBasicInfo().getSupervisorCode(),
                getData().getBasicInfo().getSupervisorName(),
                getData().getBasicInfo().getRelationshipWithIDLC(),
                getData().getBasicInfo().getInterestedAmount(),
                getData().getBasicInfo().getOfferedRate(),
                getData().getBasicInfo().getLeadIndexID(),
                getData().getBasicInfo().getCustomerName()));

        newLead.setIndustryInfo(new IndustryInfo(
                getData().getIndustryInfo().getIndustry(),
                getData().getIndustryInfo().getNatureOfBusiness(),
                getData().getIndustryInfo().getLegalStatusType(),
                getData().getIndustryInfo().getProprietorName(),
                getData().getIndustryInfo().getProprietorIndexID(),
                 getData().getIndustryInfo().getProprietorMobileNumber(),
                getData().getIndustryInfo().getProprietorMobileNumberID(),
                getData().getIndustryInfo().getYearlySales(),
                getData().getIndustryInfo().getInventory(),
                getData().getIndustryInfo().getProprietorTitle()
        ));
        newLead.setAddresses(newLead.getOldAddresses(getData().getAddresses()));
        newLead.setVisitRecords(newLead.getOldVisitRecords(getData().getVisitRecords()));
        return newLead;
    }


}
