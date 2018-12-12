package net.maxproit.salesforce.masum.model.api.deviation.deviationresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.masum.model.api.deviation.postdeviation.PostDeviation;
import net.maxproit.salesforce.model.deviation.post.DeviationPost;

/**
 * Created by Md. Mehedi Hasan on 12/12/2018.
 * mehedipy@gmail.com
 */
public class DeviationPostRespose {
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
    private PostDeviation data;

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

    public PostDeviation getData() {
        return data;
    }

    public void setData(PostDeviation data) {
        this.data = data;
    }

}
