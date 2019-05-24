package net.maxproit.salesforce2.model.search.searchlist.disbursementsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan Chowdhury on 10/3/2018.
 * heyrezwan@gmail.com
 */
public class DisbursementItem {



    @SerializedName("CIF")
    @Expose
    private String cIF;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ReferenceNo")
    @Expose
    private String referenceNo;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Branch")
    @Expose
    private String branch;
    @SerializedName("SanctionDate")
    @Expose
    private String sanctionDate;
    @SerializedName("SanctionAmount")
    @Expose
    private String sanctionAmount;
    @SerializedName("RM")
    @Expose
    private String rM;
    @SerializedName("Product")
    @Expose
    private String product;

    public String getCIF() {
        return cIF;
    }

    public void setCIF(String cIF) {
        this.cIF = cIF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSanctionDate() {
        return sanctionDate;
    }

    public void setSanctionDate(String sanctionDate) {
        this.sanctionDate = sanctionDate;
    }

    public String getSanctionAmount() {
        return sanctionAmount;
    }

    public void setSanctionAmount(String sanctionAmount) {
        this.sanctionAmount = sanctionAmount;
    }

    public String getRM() {
        return rM;
    }

    public void setRM(String rM) {
        this.rM = rM;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
