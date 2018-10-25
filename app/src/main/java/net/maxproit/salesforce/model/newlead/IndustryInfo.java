
package net.maxproit.salesforce.model.newlead;

import android.databinding.BindingAdapter;
import android.widget.EditText;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndustryInfo {

    @SerializedName("industry")
    @Expose
    private String industry = "";
    @SerializedName("natureOfBusiness")
    @Expose
    private String natureOfBusiness = "";
    @SerializedName("legalStatusType")
    @Expose
    private String legalStatusType = "";
    @SerializedName("proprietorName")
    @Expose
    private String proprietorName = "";
    @SerializedName("proprietorIndexID")
    @Expose
    private int proprietorIndexID = 0;
    @SerializedName("ProprietorMobileNumber")
    @Expose
    private String proprietorMobileNumber = "";
    @SerializedName("proprietorMobileNumberID")
    @Expose
    private int proprietorMobileNumberID = 0;
    @SerializedName("yearlySales")
    @Expose
    private int yearlySales = 0;
    @SerializedName("inventory")
    @Expose
    private int inventory = 0;

    @SerializedName("proprietorTitle")
    @Expose
    private String proprietorTitle = "";


    public IndustryInfo() {
    }


    public IndustryInfo(String industry, String natureOfBusiness, String legalStatusType, String proprietorName, int proprietorIndexID, String proprietorMobileNumber, int proprietorMobileNumberID, int yearlySales, int inventory, String proprietorTitle) {
        this.industry = industry;
        this.natureOfBusiness = natureOfBusiness;
        this.legalStatusType = legalStatusType;
        this.proprietorName = proprietorName;
        this.proprietorIndexID = proprietorIndexID;
        this.proprietorMobileNumber = proprietorMobileNumber;
        this.proprietorMobileNumberID = proprietorMobileNumberID;
        this.yearlySales = yearlySales;
        this.inventory = inventory;
        this.proprietorTitle = proprietorTitle;
    }

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

    public int getYearlySales() {
        return yearlySales;
    }

    public void setYearlySales(int yearlySales) {
        this.yearlySales = yearlySales;
    }


    // Convert int to String
    public String getYearlySalesString() {
        return Integer.toString(yearlySales);
    }

    public void setYearlySalesString(String yearlySales) {
        try {
            int val = Integer.parseInt(yearlySales.replace(",",""));
            this.setYearlySales(val);
        } catch (NumberFormatException ex) {
            this.setYearlySales(0);//default value
        }
    }


    public IndustryInfo withYearlySales(int yearlySales) {
        this.yearlySales = yearlySales;
        return this;
    }


    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    // Convert int to String
    public String getInventoryString() {
        return Integer.toString(inventory);
    }

    public void setInventoryString(String inventory) {
        try {
            int val = Integer.parseInt(inventory.replace(",",""));
            this.setInventory(val);
        } catch (NumberFormatException ex) {
            this.setInventory(0);//default value
        }


    }


    public IndustryInfo withInventory(int inventory) {
        this.inventory = inventory;
        return this;
    }


    @BindingAdapter("android:text")
    public static void convert0toString(EditText editText, String number) {

        if (isNumber(number)) {
            editText.setText(Integer.parseInt(number) == 0 ? "" : number);

        } else editText.setText(number);


    }

    private static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
