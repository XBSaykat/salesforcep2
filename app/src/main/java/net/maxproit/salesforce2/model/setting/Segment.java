package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Segment {

@SerializedName("segment")
@Expose
private String segment;
@SerializedName("segmentCode")
@Expose
private Integer segmentCode;

public String getSegment() {
return segment;
}

public void setSegment(String segment) {
this.segment = segment;
}

public Integer getSegmentCode() {
return segmentCode;
}

public void setSegmentCode(Integer segmentCode) {
this.segmentCode = segmentCode;
}

}