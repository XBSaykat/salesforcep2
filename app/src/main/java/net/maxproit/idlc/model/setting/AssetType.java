
package net.maxproit.idlc.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssetType {

    @SerializedName("AssetType")
    @Expose
    private String assetType;
    @SerializedName("AssetTypeCode")
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
