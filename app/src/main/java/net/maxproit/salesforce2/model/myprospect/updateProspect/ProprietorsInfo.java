
package net.maxproit.salesforce2.model.myprospect.updateProspect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProprietorsInfo {

    @SerializedName("ContactId")
    @Expose
    private int contactId;
    @SerializedName("OrgownershipID")
    @Expose
    private int orgownershipID;
    @SerializedName("ProprietorIndexID")
    @Expose
    private int proprietorIndexID;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = null;
    @SerializedName("personalAssets")
    @Expose
    private List<PersonalAssets> personalAssets = new ArrayList<>();

    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("emailid")
    @Expose
    private int emailid;
    @SerializedName("facebook")
    @Expose
    private Object facebook;
    @SerializedName("facebookid")
    @Expose
    private int facebookid;
    @SerializedName("fathersName")
    @Expose
    private String fathersName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("maritalStatus")
    @Expose
    private String maritalStatus;
    @SerializedName("mobilenumber")
    @Expose
    private String mobilenumber;
    @SerializedName("mobilenumberID")
    @Expose
    private int mobilenumberID;
    @SerializedName("mothersName")
    @Expose
    private String mothersName;
    @SerializedName("nid")
    @Expose
    private String nid;
    @SerializedName("ownership")
    @Expose
    private int ownership;
    @SerializedName("ownershipType")
    @Expose
    private String ownershipType;
    @SerializedName("personalnetWorth")
    @Expose
    private Object personalnetWorth;
    @SerializedName("getProfessionString")
    @Expose
    private String profession;
    @SerializedName("proprietorName")
    @Expose
    private String proprietorName;
    @SerializedName("relationShip")
    @Expose
    private Object relationShip;
    @SerializedName("spouseName")
    @Expose
    private String spouseName;



    @SerializedName("proprietorTitle")
    @Expose
    private String proprietorTitle = "";
    @SerializedName("fathersTitle")
    @Expose
    private String fathersTitle = "";
    @SerializedName("mothersTitle")
    @Expose
    private String mothersTitle = "";
    @SerializedName("spouseTitle")
    @Expose
    private String spouseTitle = "";


    public String getProprietorTitle() {
        return proprietorTitle;
    }

    public void setProprietorTitle(String proprietorTitle) {
        this.proprietorTitle = proprietorTitle;
    }

    public String getFathersTitle() {
        return fathersTitle;
    }

    public void setFathersTitle(String fathersTitle) {
        this.fathersTitle = fathersTitle;
    }

    public String getMothersTitle() {
        return mothersTitle;
    }

    public void setMothersTitle(String mothersTitle) {
        this.mothersTitle = mothersTitle;
    }

    public String getSpouseTitle() {
        return spouseTitle;
    }

    public void setSpouseTitle(String spouseTitle) {
        this.spouseTitle = spouseTitle;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public ProprietorsInfo withContactId(int contactId) {
        this.contactId = contactId;
        return this;
    }

    public int getOrgownershipID() {
        return orgownershipID;
    }

    public void setOrgownershipID(int orgownershipID) {
        this.orgownershipID = orgownershipID;
    }

    public ProprietorsInfo withOrgownershipID(int orgownershipID) {
        this.orgownershipID = orgownershipID;
        return this;
    }

    public int getProprietorIndexID() {

        return proprietorIndexID;
    }

    public void setProprietorIndexID(int proprietorIndexID) {
        this.proprietorIndexID = proprietorIndexID;
    }

    public ProprietorsInfo withProprietorIndexID(int proprietorIndexID) {
        this.proprietorIndexID = proprietorIndexID;
        return this;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public ProprietorsInfo withAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public ProprietorsInfo withDob(String dob) {
        this.dob = dob;
        return this;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public ProprietorsInfo withEmail(Object email) {
        this.email = email;
        return this;
    }

    public int getEmailid() {
        return emailid;
    }

    public void setEmailid(int emailid) {
        this.emailid = emailid;
    }

    public ProprietorsInfo withEmailid(int emailid) {
        this.emailid = emailid;
        return this;
    }

    public Object getFacebook() {
        return facebook;
    }

    public void setFacebook(Object facebook) {
        this.facebook = facebook;
    }

    public ProprietorsInfo withFacebook(Object facebook) {
        this.facebook = facebook;
        return this;
    }

    public int getFacebookid() {
        return facebookid;
    }

    public void setFacebookid(int facebookid) {
        this.facebookid = facebookid;
    }

    public ProprietorsInfo withFacebookid(int facebookid) {
        this.facebookid = facebookid;
        return this;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public ProprietorsInfo withFathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ProprietorsInfo withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public ProprietorsInfo withMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public ProprietorsInfo withMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
        return this;
    }

    public int getMobilenumberID() {
        return mobilenumberID;
    }

    public void setMobilenumberID(int mobilenumberID) {
        this.mobilenumberID = mobilenumberID;
    }

    public ProprietorsInfo withMobilenumberID(int mobilenumberID) {
        this.mobilenumberID = mobilenumberID;
        return this;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public ProprietorsInfo withMothersName(String mothersName) {
        this.mothersName = mothersName;
        return this;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public ProprietorsInfo withNid(String nid) {
        this.nid = nid;
        return this;
    }

    public int getOwnership() {
        return ownership;
    }

    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }

    public ProprietorsInfo withOwnership(int ownership) {
        this.ownership = ownership;
        return this;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public ProprietorsInfo withOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
        return this;
    }

    public Object getPersonalnetWorth() {
        return personalnetWorth;
    }

    public void setPersonalnetWorth(Object personalnetWorth) {
        this.personalnetWorth = personalnetWorth;
    }

    public ProprietorsInfo withPersonalnetWorth(Object personalnetWorth) {
        this.personalnetWorth = personalnetWorth;
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public ProprietorsInfo withProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public String getProprietorName() {
        return proprietorName;
    }

    public void setProprietorName(String proprietorName) {
        this.proprietorName = proprietorName;
    }

    public ProprietorsInfo withProprietorName(String proprietorName) {
        this.proprietorName = proprietorName;
        return this;
    }

    public Object getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(Object relationShip) {
        this.relationShip = relationShip;
    }

    public ProprietorsInfo withRelationShip(Object relationShip) {
        this.relationShip = relationShip;
        return this;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public ProprietorsInfo withSpouseName(String spouseName) {
        this.spouseName = spouseName;
        return this;
    }

    public List<PersonalAssets> getPersonalAssets() {
        return personalAssets;
    }

    public void setPersonalAssets(List<PersonalAssets> personalAssets) {
        this.personalAssets = personalAssets;
    }

}
