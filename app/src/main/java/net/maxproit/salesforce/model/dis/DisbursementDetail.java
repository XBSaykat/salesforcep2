package net.maxproit.salesforce.model.dis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan Chowdhury on 10/3/2018.
 * heyrezwan@gmail.com
 */
public class DisbursementDetail {
    @SerializedName("paymentDetailID")
    @Expose
    private Integer paymentDetailID;
    @SerializedName("payeeIndexID")
    @Expose
    private Integer payeeIndexID;
    @SerializedName("disburseAmount")
    @Expose
    private Integer disburseAmount;
    @SerializedName("disburseDate")
    @Expose
    private String disburseDate;
    @SerializedName("disburseRemark")
    @Expose
    private String disburseRemark;
    @SerializedName("instrTypeID")
    @Expose
    private Integer instrTypeID;

    public Integer getPaymentDetailID() {
        return paymentDetailID;
    }

    public void setPaymentDetailID(Integer paymentDetailID) {
        this.paymentDetailID = paymentDetailID;
    }

    public Integer getPayeeIndexID() {
        return payeeIndexID;
    }

    public void setPayeeIndexID(Integer payeeIndexID) {
        this.payeeIndexID = payeeIndexID;
    }

    public Integer getDisburseAmount() {
        return disburseAmount;
    }

    public void setDisburseAmount(Integer disburseAmount) {
        this.disburseAmount = disburseAmount;
    }

    public String getDisburseDate() {
        return disburseDate;
    }

    public void setDisburseDate(String disburseDate) {
        this.disburseDate = disburseDate;
    }

    public String getDisburseRemark() {
        return disburseRemark;
    }

    public void setDisburseRemark(String disburseRemark) {
        this.disburseRemark = disburseRemark;
    }

    public Integer getInstrTypeID() {
        return instrTypeID;
    }

    public void setInstrTypeID(Integer instrTypeID) {
        this.instrTypeID = instrTypeID;
    }
}
