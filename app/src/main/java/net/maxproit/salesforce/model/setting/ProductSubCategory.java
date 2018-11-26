package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductSubCategory {

@SerializedName("LoanPurposeType")
@Expose
private String loanPurposeType;
@SerializedName("LoanPurposeTypeCode")
@Expose
private Integer loanPurposeTypeCode;
@SerializedName("ProductID")
@Expose
private Integer productID;

public String getLoanPurposeType() {
return loanPurposeType;
}

public void setLoanPurposeType(String loanPurposeType) {
this.loanPurposeType = loanPurposeType;
}

public Integer getLoanPurposeTypeCode() {
return loanPurposeTypeCode;
}

public void setLoanPurposeTypeCode(Integer loanPurposeTypeCode) {
this.loanPurposeTypeCode = loanPurposeTypeCode;
}

public Integer getProductID() {
return productID;
}

public void setProductID(Integer productID) {
this.productID = productID;
}

}