package net.maxproit.salesforce.model.login;

import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("Booth")
    private String booth;

    @SerializedName("UserTypeId")
    private String userTypeId;

    @SerializedName("UserTypeName")
    private String userTypeName;

    @SerializedName("Branch")
    private String branch;

    @SerializedName("FullName")
    private String fullName;

    @SerializedName("SpervisorName")
    private String spervisorName;



    @SerializedName("UserCode")
    private String UserCode;
    @SerializedName("STMCode")
    private String STMCode;



    public void setBooth(String booth) {
        this.booth = booth;
    }

    public String getBooth() {
        return booth;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setSpervisorName(String spervisorName) {
        this.spervisorName = spervisorName;
    }

    public String getSpervisorName() {
        return spervisorName;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
    }

    public String getSTMCode() {
        return STMCode;
    }

    public void setSTMCode(String STMCode) {
        this.STMCode = STMCode;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "booth = '" + booth + '\'' +
                        ",userTypeId = '" + userTypeId + '\'' +
                        ",userTypeName = '" + userTypeName + '\'' +
                        ",branch = '" + branch + '\'' +
                        ",fullName = '" + fullName + '\'' +
                        ",spervisorName = '" + spervisorName + '\'' +
                        "}";
    }
}