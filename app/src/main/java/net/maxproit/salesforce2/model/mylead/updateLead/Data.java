
package net.maxproit.salesforce2.model.mylead.updateLead;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("LeadReferenceNo")
    @Expose
    private String leadReferenceNo;
    @SerializedName("UserName")
    @Expose
    private Object userName;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = null;
    @SerializedName("basicInfo")
    @Expose
    private BasicInfo basicInfo;
    @SerializedName("industryInfo")
    @Expose
    private IndustryInfo industryInfo;
    @SerializedName("mobileDbId")
    @Expose
    private int mobileDbId;
    @SerializedName("visitRecords")
    @Expose
    private List<VisitRecord> visitRecords = null;

    public String getLeadReferenceNo() {
        return leadReferenceNo;
    }

    public void setLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
    }

    public Data withLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
        return this;
    }

    public Object getUserName() {
        return userName;
    }

    public void setUserName(Object userName) {
        this.userName = userName;
    }

    public Data withUserName(Object userName) {
        this.userName = userName;
        return this;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Data withAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public Data withBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
        return this;
    }

    public IndustryInfo getIndustryInfo() {
        return industryInfo;
    }

    public void setIndustryInfo(IndustryInfo industryInfo) {
        this.industryInfo = industryInfo;
    }

    public Data withIndustryInfo(IndustryInfo industryInfo) {
        this.industryInfo = industryInfo;
        return this;
    }

    public int getMobileDbId() {
        return mobileDbId;
    }

    public void setMobileDbId(int mobileDbId) {
        this.mobileDbId = mobileDbId;
    }

    public Data withMobileDbId(int mobileDbId) {
        this.mobileDbId = mobileDbId;
        return this;
    }

    public List<VisitRecord> getVisitRecords() {
        return visitRecords;
    }

    public void setVisitRecords(List<VisitRecord> visitRecords) {
        this.visitRecords = visitRecords;
    }

    public Data withVisitRecords(List<VisitRecord> visitRecords) {
        this.visitRecords = visitRecords;
        return this;
    }

}
