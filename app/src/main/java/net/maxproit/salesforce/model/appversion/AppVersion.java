package net.maxproit.salesforce.model.appversion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AppVersion implements Serializable {
    @SerializedName("Url")
    @Expose
    private String url;
    @SerializedName("VersionCode")
    @Expose
    private Integer versionCode;
    @SerializedName("VersionName")
    @Expose
    private String versionName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
}
