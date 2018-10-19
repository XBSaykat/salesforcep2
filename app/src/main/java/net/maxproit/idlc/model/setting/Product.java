
package net.maxproit.idlc.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("FCubeProductCode")
    @Expose
    private Object fCubeProductCode;
    @SerializedName("ProductCode")
    @Expose
    private int productCode;
    @SerializedName("ProductName")
    @Expose
    private String productName;

    public Object getFCubeProductCode() {
        return fCubeProductCode;
    }

    public void setFCubeProductCode(Object fCubeProductCode) {
        this.fCubeProductCode = fCubeProductCode;
    }

    public Product withFCubeProductCode(Object fCubeProductCode) {
        this.fCubeProductCode = fCubeProductCode;
        return this;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public Product withProductCode(int productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product withProductName(String productName) {
        this.productName = productName;
        return this;
    }

}
