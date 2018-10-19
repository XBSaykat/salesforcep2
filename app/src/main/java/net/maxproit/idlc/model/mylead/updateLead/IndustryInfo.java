
package net.maxproit.idlc.model.mylead.updateLead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndustryInfo {

    @SerializedName("Industry")
    @Expose
    private String industry;
    @SerializedName("Inventory")
    @Expose
    private int inventory;
    @SerializedName("LegalStatusType")
    @Expose
    private String legalStatusType;
    @SerializedName("NatureOfBusiness")
    @Expose
    private String natureOfBusiness;
    @SerializedName("ProprietorIndexID")
    @Expose
    private int proprietorIndexID;
    @SerializedName("ProprietorMobileNumber")
    @Expose
    private String proprietorMobileNumber;
    @SerializedName("ProprietorMobileNumberID")
    @Expose
    private int proprietorMobileNumberID;
    @SerializedName("ProprietorName")
    @Expose
    private String proprietorName;
    @SerializedName("YearlySales")
    @Expose
    private int yearlySales;

    @SerializedName("ProprietorTitle")
    @Expose
    private String proprietorTitle = "";

    public String getProprietorTitle() {
        return proprietorTitle;
    }

    public void setProprietorTitle(String proprietorTitle) {
        this.proprietorTitle = proprietorTitle;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public IndustryInfo withIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public IndustryInfo withInventory(int inventory) {
        this.inventory = inventory;
        return this;
    }

    public String getLegalStatusType() {
        return legalStatusType;
    }

    public void setLegalStatusType(String legalStatusType) {
        this.legalStatusType = legalStatusType;
    }

    public IndustryInfo withLegalStatusType(String legalStatusType) {
        this.legalStatusType = legalStatusType;
        return this;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public IndustryInfo withNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
        return this;
    }

    public int getProprietorIndexID() {
        return proprietorIndexID;
    }

    public void setProprietorIndexID(int proprietorIndexID) {
        this.proprietorIndexID = proprietorIndexID;
    }

    public IndustryInfo withProprietorIndexID(int proprietorIndexID) {
        this.proprietorIndexID = proprietorIndexID;
        return this;
    }

    public String getProprietorMobileNumber() {
        return proprietorMobileNumber;
    }

    public void setProprietorMobileNumber(String proprietorMobileNumber) {
        this.proprietorMobileNumber = proprietorMobileNumber;
    }

    public IndustryInfo withProprietorMobileNumber(String proprietorMobileNumber) {
        this.proprietorMobileNumber = proprietorMobileNumber;
        return this;
    }

    public int getProprietorMobileNumberID() {
        return proprietorMobileNumberID;
    }

    public void setProprietorMobileNumberID(int proprietorMobileNumberID) {
        this.proprietorMobileNumberID = proprietorMobileNumberID;
    }

    public IndustryInfo withProprietorMobileNumberID(int proprietorMobileNumberID) {
        this.proprietorMobileNumberID = proprietorMobileNumberID;
        return this;
    }

    public String getProprietorName() {
        return proprietorName;
    }

    public void setProprietorName(String proprietorName) {
        this.proprietorName = proprietorName;
    }

    public IndustryInfo withProprietorName(String proprietorName) {
        this.proprietorName = proprietorName;
        return this;
    }

    public int getYearlySales() {
        return yearlySales;
    }

    public void setYearlySales(int yearlySales) {
        this.yearlySales = yearlySales;
    }

    public IndustryInfo withYearlySales(int yearlySales) {
        this.yearlySales = yearlySales;
        return this;
    }

}
