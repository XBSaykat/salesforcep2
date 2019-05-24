
package net.maxproit.salesforce2.model.myprospect.updateProspect;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GuarantorsInfo {

    @SerializedName("ContactId")
    @Expose
    private int contactId;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = null;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("emailid")
    @Expose
    private int emailid;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("facebookid")
    @Expose
    private int facebookid;
    @SerializedName("fathersName")
    @Expose
    private String fathersName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("guarantorIndexID")
    @Expose
    private int guarantorIndexID;
    @SerializedName("guarantorName")
    @Expose
    private String guarantorName;
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
    @SerializedName("personalnetWorth")
    @Expose
    private String personalnetWorth;
    @SerializedName("getProfessionString")
    @Expose
    private String profession;
    @SerializedName("relationShip")
    @Expose
    private String relationShip;
    @SerializedName("spouseName")
    @Expose
    private String spouseName;

    @SerializedName("guarantorTitle")
    @Expose
    private String guarantorTitle = "";
    @SerializedName("fathersTitle")
    @Expose
    private String fathersTitle = "";
    @SerializedName("mothersTitle")
    @Expose
    private String mothersTitle = "";
    @SerializedName("spouseTitle")
    @Expose
    private String spouseTitle = "";

    public String getGuarantorTitle() {
        return guarantorTitle;
    }

    public void setGuarantorTitle(String guarantorTitle) {
        this.guarantorTitle = guarantorTitle;
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

    public GuarantorsInfo withContactId(int contactId) {
        this.contactId = contactId;
        return this;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public GuarantorsInfo withAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public GuarantorsInfo withDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GuarantorsInfo withEmail(String email) {
        this.email = email;
        return this;
    }

    public int getEmailid() {
        return emailid;
    }

    public void setEmailid(int emailid) {
        this.emailid = emailid;
    }

    public GuarantorsInfo withEmailid(int emailid) {
        this.emailid = emailid;
        return this;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public GuarantorsInfo withFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    public int getFacebookid() {
        return facebookid;
    }

    public void setFacebookid(int facebookid) {
        this.facebookid = facebookid;
    }

    public GuarantorsInfo withFacebookid(int facebookid) {
        this.facebookid = facebookid;
        return this;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public GuarantorsInfo withFathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public GuarantorsInfo withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public int getGuarantorIndexID() {
        return guarantorIndexID;
    }

    public void setGuarantorIndexID(int guarantorIndexID) {
        this.guarantorIndexID = guarantorIndexID;
    }

    public GuarantorsInfo withGuarantorIndexID(int guarantorIndexID) {
        this.guarantorIndexID = guarantorIndexID;
        return this;
    }

    public String getGuarantorName() {
        return guarantorName;
    }

    public void setGuarantorName(String guarantorName) {
        this.guarantorName = guarantorName;
    }

    public GuarantorsInfo withGuarantorName(String guarantorName) {
        this.guarantorName = guarantorName;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public GuarantorsInfo withMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public GuarantorsInfo withMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
        return this;
    }

    public int getMobilenumberID() {
        return mobilenumberID;
    }

    public void setMobilenumberID(int mobilenumberID) {
        this.mobilenumberID = mobilenumberID;
    }

    public GuarantorsInfo withMobilenumberID(int mobilenumberID) {
        this.mobilenumberID = mobilenumberID;
        return this;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public GuarantorsInfo withMothersName(String mothersName) {
        this.mothersName = mothersName;
        return this;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public GuarantorsInfo withNid(String nid) {
        this.nid = nid;
        return this;
    }

    public int getOwnership() {
        return ownership;
    }

    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }

    public GuarantorsInfo withOwnership(int ownership) {
        this.ownership = ownership;
        return this;
    }

    public String getPersonalnetWorth() {
        return personalnetWorth;
    }

    public void setPersonalnetWorth(String personalnetWorth) {
        this.personalnetWorth = personalnetWorth;
    }

    public GuarantorsInfo withPersonalnetWorth(String personalnetWorth) {
        this.personalnetWorth = personalnetWorth;
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public GuarantorsInfo withProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public String getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip;
    }

    public GuarantorsInfo withRelationShip(String relationShip) {
        this.relationShip = relationShip;
        return this;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public GuarantorsInfo withSpouseName(String spouseName) {
        this.spouseName = spouseName;
        return this;
    }

}
