package net.maxproit.salesforce2.model.search.searchlist.disbursementsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan Chowdhury on 10/3/2018.
 * heyrezwan@gmail.com
 */
public class DisbursementSearchResponce {



    @SerializedName("prospectReferenceNo")
    @Expose
    private String prospectReferenceNo;
    @SerializedName("RequestDate")
    @Expose
    private String requestDate;
    @SerializedName("MemberName")
    @Expose
    private String memberName;
    @SerializedName("Branch")
    @Expose
    private String branch;
    @SerializedName("Product")
    @Expose
    private String product;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("RmName")
    @Expose
    private String rmName;
    @SerializedName("ApprovalSetID")
    @Expose
    private String approvalSetID;
    @SerializedName("SPProspectListID")
    @Expose
    private String sPProspectListID;
    @SerializedName("CurrentLevel")
    @Expose
    private String currentLevel;
    @SerializedName("STMName")
    @Expose
    private String sTMName;
    @SerializedName("CreditAnalyst")
    @Expose
    private String creditAnalyst;
    @SerializedName("FinalApprover")
    @Expose
    private String finalApprover;
    @SerializedName("BusinessCIF")
    @Expose
    private String businessCIF;
    @SerializedName("InitialApproveDate")
    @Expose
    private String initialApproveDate;
    @SerializedName("FinalApproveDate")
    @Expose
    private String finalApproveDate;
    @SerializedName("FlexCubeProductName")
    @Expose
    private String flexCubeProductName;
    @SerializedName("DefaultAddress")
    @Expose
    private String defaultAddress;
    @SerializedName("ProspectID")
    @Expose
    private String prospectID;
    @SerializedName("ACCOUNT_NUMBER")
    @Expose
    private String aCCOUNTNUMBER;
    @SerializedName("RMCode")
    @Expose
    private String rMCode;
    @SerializedName("ProductCode")
    @Expose
    private String productCode;
    @SerializedName("SanctionDate")
    @Expose
    private String sanctionDate;

    public String getProspectReferenceNo() {
        return prospectReferenceNo;
    }

    public void setProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getApprovalSetID() {
        return approvalSetID;
    }

    public void setApprovalSetID(String approvalSetID) {
        this.approvalSetID = approvalSetID;
    }

    public String getSPProspectListID() {
        return sPProspectListID;
    }

    public void setSPProspectListID(String sPProspectListID) {
        this.sPProspectListID = sPProspectListID;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getSTMName() {
        return sTMName;
    }

    public void setSTMName(String sTMName) {
        this.sTMName = sTMName;
    }

    public String getCreditAnalyst() {
        return creditAnalyst;
    }

    public void setCreditAnalyst(String creditAnalyst) {
        this.creditAnalyst = creditAnalyst;
    }

    public String getFinalApprover() {
        return finalApprover;
    }

    public void setFinalApprover(String finalApprover) {
        this.finalApprover = finalApprover;
    }

    public String getBusinessCIF() {
        return businessCIF;
    }

    public void setBusinessCIF(String businessCIF) {
        this.businessCIF = businessCIF;
    }

    public String getInitialApproveDate() {
        return initialApproveDate;
    }

    public void setInitialApproveDate(String initialApproveDate) {
        this.initialApproveDate = initialApproveDate;
    }

    public String getFinalApproveDate() {
        return finalApproveDate;
    }

    public void setFinalApproveDate(String finalApproveDate) {
        this.finalApproveDate = finalApproveDate;
    }

    public String getFlexCubeProductName() {
        return flexCubeProductName;
    }

    public void setFlexCubeProductName(String flexCubeProductName) {
        this.flexCubeProductName = flexCubeProductName;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getProspectID() {
        return prospectID;
    }

    public void setProspectID(String prospectID) {
        this.prospectID = prospectID;
    }

    public String getACCOUNTNUMBER() {
        return aCCOUNTNUMBER;
    }

    public void setACCOUNTNUMBER(String aCCOUNTNUMBER) {
        this.aCCOUNTNUMBER = aCCOUNTNUMBER;
    }

    public String getRMCode() {
        return rMCode;
    }

    public void setRMCode(String rMCode) {
        this.rMCode = rMCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSanctionDate() {
        return sanctionDate;
    }

    public void setSanctionDate(String sanctionDate) {
        this.sanctionDate = sanctionDate;
    }
}
