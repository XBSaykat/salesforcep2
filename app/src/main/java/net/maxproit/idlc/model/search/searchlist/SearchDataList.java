
package net.maxproit.idlc.model.search.searchlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchDataList {

    @SerializedName("IndexID")
    @Expose
    private String indexID;
    @SerializedName("CIF")
    @Expose
    private String cIF;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Address")
    @Expose
    private String address;

    public String getIndexID() {
        return indexID;
    }

    public void setIndexID(String indexID) {
        this.indexID = indexID;
    }

    public String getCIF() {
        return cIF;
    }

    public void setCIF(String cIF) {
        this.cIF = cIF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
