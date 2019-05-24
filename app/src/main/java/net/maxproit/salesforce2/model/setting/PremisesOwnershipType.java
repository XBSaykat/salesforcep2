
package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PremisesOwnershipType {

    @SerializedName("PremisesOwnershipType")
    @Expose
    private String premisesOwnershipType;
    @SerializedName("PremisesOwnershipTypeCode")
    @Expose
    private Integer premisesOwnershipTypeCode;

    public String getPremisesOwnershipType() {
        return premisesOwnershipType;
    }

    public void setPremisesOwnershipType(String premisesOwnershipType) {
        this.premisesOwnershipType = premisesOwnershipType;
    }

    public Integer getPremisesOwnershipTypeCode() {
        return premisesOwnershipTypeCode;
    }

    public void setPremisesOwnershipTypeCode(Integer premisesOwnershipTypeCode) {
        this.premisesOwnershipTypeCode = premisesOwnershipTypeCode;
    }

}
