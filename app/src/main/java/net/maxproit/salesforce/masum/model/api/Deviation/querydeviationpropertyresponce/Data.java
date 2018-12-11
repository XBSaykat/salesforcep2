package net.maxproit.salesforce.masum.model.api.Deviation.querydeviationpropertyresponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/11/2018.
 * mehedipy@gmail.com
 */
public class Data {
    @SerializedName("ProspectID")
    @Expose
    private String prospectID;
    @SerializedName("ProductCategoryID")
    @Expose
    private String productCategoryID;
    @SerializedName("ProductSubCategoryID")
    @Expose
    private String productSubCategoryID;
    @SerializedName("LTV")
    @Expose
    private String lTV;
    @SerializedName("LoanAmount")
    @Expose
    private String loanAmount;

    public String getProspectID() {
        return prospectID;
    }

    public void setProspectID(String prospectID) {
        this.prospectID = prospectID;
    }

    public String getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(String productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public String getProductSubCategoryID() {
        return productSubCategoryID;
    }

    public void setProductSubCategoryID(String productSubCategoryID) {
        this.productSubCategoryID = productSubCategoryID;
    }

    public String getLTV() {
        return lTV;
    }

    public void setLTV(String lTV) {
        this.lTV = lTV;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }
}
