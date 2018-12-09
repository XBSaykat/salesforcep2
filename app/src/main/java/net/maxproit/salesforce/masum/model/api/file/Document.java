package net.maxproit.salesforce.masum.model.api.file;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Document implements Serializable {
    @SerializedName("LeadReferenceNo")
    @Expose
    private String leadReferenceNo;
    @SerializedName("DocCheckListItemID")
    @Expose
    private String docCheckListItemID;
    @SerializedName("DocCheckListItem")
    @Expose
    private String docCheckListItem;
    @SerializedName("FileName")
    @Expose
    private String fileName;
    @SerializedName("URL")
    @Expose
    private String uRL;
    @SerializedName("DocCheckListID")
    @Expose
    private String docCheckListID;

    public String getLeadReferenceNo() {
        return leadReferenceNo;
    }

    public void setLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
    }

    public String getDocCheckListItemID() {
        return docCheckListItemID;
    }

    public void setDocCheckListItemID(String docCheckListItemID) {
        this.docCheckListItemID = docCheckListItemID;
    }

    public String getDocCheckListItem() {
        return docCheckListItem;
    }

    public void setDocCheckListItem(String docCheckListItem) {
        this.docCheckListItem = docCheckListItem;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getURL() {
        return uRL;
    }

    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    public String getDocCheckListID() {
        return docCheckListID;
    }

    public void setDocCheckListID(String docCheckListID) {
        this.docCheckListID = docCheckListID;
    }

}
