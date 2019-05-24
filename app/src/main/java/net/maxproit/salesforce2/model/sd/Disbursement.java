package net.maxproit.salesforce2.model.sd;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan Chowdhury on 9/27/2018.
 * heyrezwan@gmail.com
 */
public class Disbursement {


    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("CustomerNo")
    @Expose
    private String customerNo;
    @SerializedName("Reference")
    @Expose
    private String reference;
    @SerializedName("Branch")
    @Expose
    private String branch;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Amount")
    @Expose
    private String amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
