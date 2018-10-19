package net.maxproit.idlc.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan Chowdhury on 10/2/2018.
 * heyrezwan@gmail.com
 */
public class Profession {

    @SerializedName("InActive")
    @Expose
    private Boolean inActive;
    @SerializedName("IsDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("OccupationTypeCode")
    @Expose
    private Integer occupationTypeCode;
    @SerializedName("OccupationTypeName")
    @Expose
    private String occupationTypeName;

    public Boolean getInActive() {
        return inActive;
    }

    public void setInActive(Boolean inActive) {
        this.inActive = inActive;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getOccupationTypeCode() {
        return occupationTypeCode;
    }

    public void setOccupationTypeCode(Integer occupationTypeCode) {
        this.occupationTypeCode = occupationTypeCode;
    }

    public String getOccupationTypeName() {
        return occupationTypeName;
    }

    public void setOccupationTypeName(String occupationTypeName) {
        this.occupationTypeName = occupationTypeName;
    }

}
