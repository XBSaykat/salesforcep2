
package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrgOwnershipType {

    @SerializedName("OrgOwnershipType")
    @Expose
    private String orgOwnershipType;
    @SerializedName("OrgOwnershipTypeCode")
    @Expose
    private int orgOwnershipTypeCode;

    public String getOrgOwnershipType() {
        return orgOwnershipType;
    }

    public void setOrgOwnershipType(String orgOwnershipType) {
        this.orgOwnershipType = orgOwnershipType;
    }

    public OrgOwnershipType withOrgOwnershipType(String orgOwnershipType) {
        this.orgOwnershipType = orgOwnershipType;
        return this;
    }

    public int getOrgOwnershipTypeCode() {
        return orgOwnershipTypeCode;
    }

    public void setOrgOwnershipTypeCode(int orgOwnershipTypeCode) {
        this.orgOwnershipTypeCode = orgOwnershipTypeCode;
    }

    public OrgOwnershipType withOrgOwnershipTypeCode(int orgOwnershipTypeCode) {
        this.orgOwnershipTypeCode = orgOwnershipTypeCode;
        return this;
    }

}
