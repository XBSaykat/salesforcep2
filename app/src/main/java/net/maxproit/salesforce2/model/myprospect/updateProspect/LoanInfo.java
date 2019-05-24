
package net.maxproit.salesforce2.model.myprospect.updateProspect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoanInfo {

    @SerializedName("cashsecurity")
    @Expose
    private int cashsecurity;
    @SerializedName("cashsecurityrate")
    @Expose
    private int cashsecurityrate;
    @SerializedName("financing")
    @Expose
    private int financing;
    @SerializedName("instalmentAmount")
    @Expose
    private int instalmentAmount;
    @SerializedName("interestrate")
    @Expose
    private int interestrate;
    @SerializedName("loadDeposite")
    @Expose
    private int loadDeposite;
    @SerializedName("loanAmount")
    @Expose
    private int loanAmount;

    @SerializedName("noOfEMI")
    @Expose
    private int noOfEMI;
    @SerializedName("productCategory")
    @Expose
    private String productCategory;
    @SerializedName("productCategoryID")
    @Expose
    private int productCategoryID;

    @SerializedName("purposeOfFinancing")
    @Expose
    private String purposeOfFinancing;
    @SerializedName("purposeOfFinancingCode")
    @Expose
    private int purposeOfFinancingCode;
    @SerializedName("temInMonths")
    @Expose
    private int temInMonths;



    @SerializedName("Inventory")
    @Expose
    private int Inventory;


    @SerializedName("YearlySales")
    @Expose
    private int YearlySales;


    public int getInventory() {
        return Inventory;
    }

    public void setInventory(int inventory) {
        Inventory = inventory;
    }

    public int getYearlySales() {
        return YearlySales;
    }

    public void setYearlySales(int yearlySales) {
        YearlySales = yearlySales;
    }

    public int getCashsecurity() {
        return cashsecurity;
    }

    public void setCashsecurity(int cashsecurity) {
        this.cashsecurity = cashsecurity;
    }

    public LoanInfo withCashsecurity(int cashsecurity) {
        this.cashsecurity = cashsecurity;
        return this;
    }

    public int getCashsecurityrate() {
        return cashsecurityrate;
    }

    public void setCashsecurityrate(int cashsecurityrate) {
        this.cashsecurityrate = cashsecurityrate;
    }

    public LoanInfo withCashsecurityrate(int cashsecurityrate) {
        this.cashsecurityrate = cashsecurityrate;
        return this;
    }

    public int getFinancing() {
        return financing;
    }

    public void setFinancing(int financing) {
        this.financing = financing;
    }

    public LoanInfo withFinancing(int financing) {
        this.financing = financing;
        return this;
    }

    public int getInstalmentAmount() {
        return instalmentAmount;
    }

    public void setInstalmentAmount(int instalmentAmount) {
        this.instalmentAmount = instalmentAmount;
    }

    public LoanInfo withInstalmentAmount(int instalmentAmount) {
        this.instalmentAmount = instalmentAmount;
        return this;
    }

    public int getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(int interestrate) {
        this.interestrate = interestrate;
    }

    public LoanInfo withInterestrate(int interestrate) {
        this.interestrate = interestrate;
        return this;
    }

    public int getLoadDeposite() {
        return loadDeposite;
    }

    public void setLoadDeposite(int loadDeposite) {
        this.loadDeposite = loadDeposite;
    }

    public LoanInfo withLoadDeposite(int loadDeposite) {
        this.loadDeposite = loadDeposite;
        return this;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public LoanInfo withLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
        return this;
    }



    public int getNoOfEMI() {
        return noOfEMI;
    }

    public void setNoOfEMI(int noOfEMI) {
        this.noOfEMI = noOfEMI;
    }

    public LoanInfo withNoOfEMI(int noOfEMI) {
        this.noOfEMI = noOfEMI;
        return this;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public LoanInfo withProductCategory(String productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public int getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(int productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public LoanInfo withProductCategoryID(int productCategoryID) {
        this.productCategoryID = productCategoryID;
        return this;
    }





    public String getPurposeOfFinancing() {
        return purposeOfFinancing;
    }

    public void setPurposeOfFinancing(String purposeOfFinancing) {
        this.purposeOfFinancing = purposeOfFinancing;
    }

    public LoanInfo withPurposeOfFinancing(String purposeOfFinancing) {
        this.purposeOfFinancing = purposeOfFinancing;
        return this;
    }

    public int getPurposeOfFinancingCode() {
        return purposeOfFinancingCode;
    }

    public void setPurposeOfFinancingCode(int purposeOfFinancingCode) {
        this.purposeOfFinancingCode = purposeOfFinancingCode;
    }

    public LoanInfo withPurposeOfFinancingCode(int purposeOfFinancingCode) {
        this.purposeOfFinancingCode = purposeOfFinancingCode;
        return this;
    }

    public int getTemInMonths() {
        return temInMonths;
    }

    public void setTemInMonths(int temInMonths) {
        this.temInMonths = temInMonths;
    }

    public LoanInfo withTemInMonths(int temInMonths) {
        this.temInMonths = temInMonths;
        return this;
    }

}
