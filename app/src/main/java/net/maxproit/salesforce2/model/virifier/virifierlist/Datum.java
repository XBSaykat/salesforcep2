
package net.maxproit.salesforce2.model.virifier.virifierlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("LeadReferenceNo")
    @Expose
    private String leadReferenceNo;
    @SerializedName("ProspectID")
    @Expose
    private String prospectID;
    @SerializedName("CustomerNo")
    @Expose
    private String customerNo;
    @SerializedName("ProspectName")
    @Expose
    private String prospectName;
    @SerializedName("Branch")
    @Expose
    private String branch;
    @SerializedName("BranchCode")
    @Expose
    private String branchCode;
    @SerializedName("ProductCode")
    @Expose
    private String productCode;
    @SerializedName("Product")
    @Expose
    private String product;

    public String getLeadReferenceNo() {
        return leadReferenceNo;
    }

    public void setLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
    }

    public Datum withLeadReferenceNo(String leadReferenceNo) {
        this.leadReferenceNo = leadReferenceNo;
        return this;
    }

    public String getProspectID() {
        return prospectID;
    }

    public void setProspectID(String prospectID) {
        this.prospectID = prospectID;
    }

    public Datum withProspectID(String prospectID) {
        this.prospectID = prospectID;
        return this;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Datum withCustomerNo(String customerNo) {
        this.customerNo = customerNo;
        return this;
    }

    public String getProspectName() {
        return prospectName;
    }

    public void setProspectName(String prospectName) {
        this.prospectName = prospectName;
    }

    public Datum withProspectName(String prospectName) {
        this.prospectName = prospectName;
        return this;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Datum withBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Datum withBranchCode(String branchCode) {
        this.branchCode = branchCode;
        return this;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Datum withProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Datum withProduct(String product) {
        this.product = product;
        return this;
    }

}
