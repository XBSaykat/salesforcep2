
package net.maxproit.salesforce.model.cib.notRequestedCIB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotRequestedCIB {

    @SerializedName("CustomerNo")
    @Expose
    private String customerNo;
    @SerializedName("ProspectName")
    @Expose
    private String prospectName;
    @SerializedName("ContactRelation")
    @Expose
    private String contactRelation;
    @SerializedName("ProspectIndexID")
    @Expose
    private String prospectIndexID;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Notes")
    @Expose
    private String notes;


    private boolean isSelect = false;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getProspectName() {
        return prospectName;
    }

    public void setProspectName(String prospectName) {
        this.prospectName = prospectName;
    }

    public String getContactRelation() {
        return contactRelation;
    }

    public void setContactRelation(String contactRelation) {
        this.contactRelation = contactRelation;
    }

    public String getProspectIndexID() {
        return prospectIndexID;
    }

    public void setProspectIndexID(String prospectIndexID) {
        this.prospectIndexID = prospectIndexID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
