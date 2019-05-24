package net.maxproit.salesforce2.masum.model.api.deviation.deviationlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Md. Mehedi Hasan on 12/12/2018.
 * mehedipy@gmail.com
 */
public class DeviationResponse {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DeviationList> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DeviationList> getData() {
        return data;
    }

    public void setData(List<DeviationList> data) {
        this.data = data;
    }


}
