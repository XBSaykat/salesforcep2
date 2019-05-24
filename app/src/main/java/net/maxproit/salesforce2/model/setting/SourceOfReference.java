package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceOfReference {

@SerializedName("sourceOfReference")
@Expose
private String sourceOfReference;
@SerializedName("sourceOfReferenceCode")
@Expose
private Integer sourceOfReferenceCode;

public String getSourceOfReference() {
return sourceOfReference;
}

public void setSourceOfReference(String sourceOfReference) {
this.sourceOfReference = sourceOfReference;
}

public Integer getSourceOfReferenceCode() {
return sourceOfReferenceCode;
}

public void setSourceOfReferenceCode(Integer sourceOfReferenceCode) {
this.sourceOfReferenceCode = sourceOfReferenceCode;
}

}