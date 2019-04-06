
package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssetType {


    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("assetTypeCode")
    @Expose
    private Integer assetTypeCode;

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Integer getAssetTypeCode() {
        return assetTypeCode;
    }

    public void setAssetTypeCode(Integer assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
    }

}
