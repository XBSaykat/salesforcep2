
package net.maxproit.salesforce.model.leadstage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.model.newlead.Address;
import net.maxproit.salesforce.model.newlead.IndustryInfo;

import java.util.ArrayList;
import java.util.List;

public class NewLead {

    @SerializedName("mobileDbId")
    @Expose
    private int mobileDbId = 0;
    @SerializedName("leadReferenceNo")
    @Expose
    private String leadReferenceNo = "";
    @SerializedName("basicInfo")
    @Expose
    private BasicInfo basicInfo;
    @SerializedName("industryInfo")
    @Expose
    private IndustryInfo industryInfo;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = new ArrayList<>();
    @SerializedName("visitRecords")
    @Expose
    private List<VisitRecord> visitRecords = new ArrayList<>();
    @SerializedName("userName")
    @Expose
    private String userName = "";

    public int getMobileDbId() {
        return mobileDbId;
    }

    public void setMobileDbId(int mobileDbId) {
        this.mobileDbId = mobileDbId;
    }

    public NewLead withMobileDbId(int mobileDbId) {
        this.mobileDbId = mobileDbId;
        return this;
    }

    public String getLeadReferenceNo() {
        return leadReferenceNo;
    }

    public void setLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
    }

    public NewLead withLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
        return this;
    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public NewLead withBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
        return this;
    }

    public IndustryInfo getIndustryInfo() {
        return industryInfo;
    }

    public void setIndustryInfo(IndustryInfo industryInfo) {
        this.industryInfo = industryInfo;
    }

    public NewLead withIndustryInfo(IndustryInfo industryInfo) {
        this.industryInfo = industryInfo;
        return this;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public NewLead withAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public List<VisitRecord> getVisitRecords() {
        return visitRecords;
    }

    public void setVisitRecords(List<VisitRecord> visitRecords) {
        this.visitRecords = visitRecords;
    }

    public NewLead withVisitRecords(List<VisitRecord> visitRecords) {
        this.visitRecords = visitRecords;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public NewLead withUserName(String userName) {
        this.userName = userName;
        return this;
    }


    public List<Address> getOldAddresses(List<net.maxproit.salesforce.model.mylead.updateLead.Address> addresses) {

        List<Address> list = new ArrayList<>();
        for (net.maxproit.salesforce.model.mylead.updateLead.Address a : addresses) {
            list.add(new Address(
                    a.getAddressID(),
                    a.getAddressType(),
                    String.valueOf(a.getArea()),
                    a.getVillage(),
                    a.getHouseName(),
                    a.getAppartmentNo(),
                    a.getFloor(),
                    a.getHoldingNumber(),
                    a.getRoad(),
                    a.getPs(),
                    a.getPremiseOwnershipStatus(),
                    a.getNearestLandMark(),
                    a.getCity()

            ));

        }

        return list;
    }

    public List<VisitRecord> getOldVisitRecords(List<net.maxproit.salesforce.model.mylead.updateLead.VisitRecord> visitRecords) {
        List<VisitRecord> list = new ArrayList<>();

        for (net.maxproit.salesforce.model.mylead.updateLead.VisitRecord v : visitRecords) {
            list.add(new VisitRecord(
                    v.getActivityID(),
                    v.getVisitPurpose(),
                    v.getRemarks(),
                    v.getMeetingDate(),
                    v.getFollowupDate()
            ));

        }
        return list;

    }
}
