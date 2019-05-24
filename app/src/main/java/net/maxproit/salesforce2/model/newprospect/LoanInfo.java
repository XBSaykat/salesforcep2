
package net.maxproit.salesforce2.model.newprospect;

import android.databinding.BindingAdapter;
import android.widget.EditText;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoanInfo {

    @SerializedName("loanAmount")
    @Expose
    private int loanAmount;
    @SerializedName("temInMonths")
    @Expose
    private int temInMonths;
    @SerializedName("financing")
    @Expose
    private int financing;
    @SerializedName("cashsecurity")
    @Expose
    private int cashsecurity;
    @SerializedName("cashsecurityrate")
    @Expose
    private int cashsecurityrate;
    @SerializedName("noOfEMI")
    @Expose
    private int noOfEMI;
    @SerializedName("loadDeposite")
    @Expose
    private int loadDeposite;
    @SerializedName("interestrate")
    @Expose
    private int interestrate;
    @SerializedName("instalmentAmount")
    @Expose
    private int instalmentAmount;
    @SerializedName("purposeOfFinancingCode")
    @Expose
    private int purposeOfFinancingCode;
    @SerializedName("purposeOfFinancing")
    @Expose
    private String purposeOfFinancing = "";
    @SerializedName("productCategoryID")
    @Expose
    private int productCategoryID;
    @SerializedName("productCategory")
    @Expose
    private String productCategory = "";




    @SerializedName("inventory")
    @Expose
    private int Inventory;


    @SerializedName("yearlySales")
    @Expose
    private int YearlySales;




    public LoanInfo() {
    }

    public LoanInfo(int loanAmount, int temInMonths, int financing, int cashsecurity, int cashsecurityrate, int noOfEMI, int loadDeposite, int interestrate, int instalmentAmount, int purposeOfFinancingCode, String purposeOfFinancing, int productCategoryID, String productCategory, int Inventory, int YearlySales) {
        this.loanAmount = loanAmount;
        this.temInMonths = temInMonths;
        this.financing = financing;
        this.cashsecurity = cashsecurity;
        this.cashsecurityrate = cashsecurityrate;
        this.noOfEMI = noOfEMI;
        this.loadDeposite = loadDeposite;
        this.interestrate = interestrate;
        this.instalmentAmount = instalmentAmount;
        this.purposeOfFinancingCode = purposeOfFinancingCode;
        this.purposeOfFinancing = purposeOfFinancing;
        this.productCategoryID = productCategoryID;
        this.productCategory = productCategory;
        this.Inventory = Inventory;
        this.YearlySales = YearlySales;
    }

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

    public String getLoanAmount() {
        return Integer.toString(loanAmount);
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = stringToInt(loanAmount);
    }

    public LoanInfo withLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
        return this;
    }

    public String getTemInMonths() {
        return Integer.toString(temInMonths);
    }

    public void setTemInMonths(String temInMonths) {
        this.temInMonths = stringToInt(temInMonths);
    }

    public LoanInfo withTemInMonths(int temInMonths) {
        this.temInMonths = temInMonths;
        return this;
    }

    public String getFinancing() {
        return Integer.toString(financing);
    }

    public void setFinancing(String financing) {
        this.financing = stringToInt(financing);
    }

    public LoanInfo withFinancing(int financing) {
        this.financing = financing;
        return this;
    }

    public String getCashsecurity() {
        return Integer.toString(cashsecurity);
    }

    public void setCashsecurity(String cashsecurity) {
        this.cashsecurity = stringToInt(cashsecurity);
    }

    public LoanInfo withCashsecurity(int cashsecurity) {
        this.cashsecurity = cashsecurity;
        return this;
    }

    public String getCashsecurityrate() {
        return Integer.toString(cashsecurityrate);
    }

    public void setCashsecurityrate(String cashsecurityrate) {
        this.cashsecurityrate = stringToInt(cashsecurityrate);
    }

    public LoanInfo withCashsecurityrate(int cashsecurityrate) {
        this.cashsecurityrate = cashsecurityrate;
        return this;
    }

    public String getNoOfEMI() {
        return Integer.toString(noOfEMI);
    }

    public void setNoOfEMI(String noOfEMI) {
        this.noOfEMI = stringToInt(noOfEMI);
    }

    public LoanInfo withNoOfEMI(int noOfEMI) {
        this.noOfEMI = noOfEMI;
        return this;
    }

    public String getLoadDeposite() {
        return Integer.toString(loadDeposite);
    }

    public void setLoadDeposite(String loadDeposite) {
        this.loadDeposite = stringToInt(loadDeposite);
    }

    public LoanInfo withLoadDeposite(int loadDeposite) {
        this.loadDeposite = loadDeposite;
        return this;
    }

    public String getInterestrate() {
        return Integer.toString(interestrate);
    }

    public void setInterestrate(String interestrate) {
        this.interestrate = stringToInt(interestrate);
    }

    public LoanInfo withInterestrate(int interestrate) {
        this.interestrate = interestrate;
        return this;
    }

    public String getInstalmentAmount() {
        return Integer.toString(instalmentAmount);
    }

    public void setInstalmentAmount(String instalmentAmount) {
        this.instalmentAmount = stringToInt(instalmentAmount);
    }

    public LoanInfo withInstalmentAmount(int instalmentAmount) {
        this.instalmentAmount = instalmentAmount;
        return this;
    }

    public String getPurposeOfFinancingCode() {
        return Integer.toString(purposeOfFinancingCode);
    }

    public void setPurposeOfFinancingCode(String purposeOfFinancingCode) {
        this.purposeOfFinancingCode = stringToInt(purposeOfFinancingCode);
    }

    public LoanInfo withPurposeOfFinancingCode(int purposeOfFinancingCode) {
        this.purposeOfFinancingCode = purposeOfFinancingCode;
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

    public String getProductCategoryID() {
        return Integer.toString(productCategoryID);
    }

    public void setProductCategoryID(String productCategoryID) {
        this.productCategoryID = stringToInt(productCategoryID);
    }

    public LoanInfo withProductCategoryID(int productCategoryID) {
        this.productCategoryID = productCategoryID;
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




    public int stringToInt(String inventory) {
        try {
            return Integer.parseInt(inventory);

        } catch (NumberFormatException ex) {
            return 0;
        }


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
