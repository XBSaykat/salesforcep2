
package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("InActive")
    @Expose
    private Boolean inActive;
    @SerializedName("IsDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("TitleCode")
    @Expose
    private Integer titleCode;
    @SerializedName("TitleName")
    @Expose
    private String titleName;

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

    public Integer getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(Integer titleCode) {
        this.titleCode = titleCode;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
