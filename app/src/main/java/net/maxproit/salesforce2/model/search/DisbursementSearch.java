package net.maxproit.salesforce2.model.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan Chowdhury on 10/3/2018.
 * heyrezwan@gmail.com
 */
public class DisbursementSearch {
    @SerializedName("fromDate")
    @Expose
    private String fromDate ="";
    @SerializedName("toDate")
    @Expose
    private String toDate ="";
    @SerializedName("cif")
    @Expose
    private String cif ="";
    @SerializedName("branch")
    @Expose
    private String branch="";
    @SerializedName("referenceNO")
    @Expose
    private String referenceNO="";
    @SerializedName("productID")
    @Expose
    private int productID=0;


    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getReferenceNO() {
        return referenceNO;
    }

    public void setReferenceNO(String referenceNO) {
        this.referenceNO = referenceNO;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
