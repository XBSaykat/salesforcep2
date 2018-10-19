package net.maxproit.idlc.model.search.searchlist.disbursementsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 10/3/2018.
 * heyrezwan@gmail.com
 */
public class DisbursementSearchResponceList {

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
    private List<DisbursementSearchResponce> data = null;

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

    public List<DisbursementSearchResponce> getData() {
        return data;
    }

    public void setData(List<DisbursementSearchResponce> data) {
        this.data = data;
    }
}
