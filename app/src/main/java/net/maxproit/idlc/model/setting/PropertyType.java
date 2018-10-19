
package net.maxproit.idlc.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyType {

    @SerializedName("PropertyType")
    @Expose
    private String assetType;
    @SerializedName("PropertyTypeCode")
    @Expose
    private int assetTypeCode;

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public PropertyType withAssetType(String assetType) {
        this.assetType = assetType;
        return this;
    }

    public int getAssetTypeCode() {
        return assetTypeCode;
    }

    public void setAssetTypeCode(int assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
    }

    public PropertyType withAssetTypeCode(int assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
        return this;
    }

}
