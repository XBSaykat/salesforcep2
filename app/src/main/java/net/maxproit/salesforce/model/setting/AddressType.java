
package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressType {

    @SerializedName("AddressType")
    @Expose
    private String addressType;
    @SerializedName("AddressTypeCode")
    @Expose
    private int addressTypeCode;

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public AddressType withAddressType(String addressType) {
        this.addressType = addressType;
        return this;
    }

    public int getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(int addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public AddressType withAddressTypeCode(int addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
        return this;
    }

}
