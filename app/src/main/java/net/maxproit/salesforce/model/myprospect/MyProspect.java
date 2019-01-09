
package net.maxproit.salesforce.model.myprospect;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.masum.model.api.rbm.Datum;

public class MyProspect {

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
    private List<Data> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MyProspect withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MyProspect withCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyProspect withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public MyProspect withData(List<Data> data) {
        this.data = data;
        return this;
    }


    public ArrayList<Data> setRbmDataModelList(ArrayList<Datum> rbmList){
        ArrayList<Data> dataList=new ArrayList<>();


        for (int i=0;i<rbmList.size();i++){
           Data data=new Data();
           data.setApprovalSetID(rbmList.get(i).getApprovalSetID());
           data.setBranch(rbmList.get(i).getBranch());
           data.setName(rbmList.get(i).getName());
           data.setStatus(rbmList.get(i).getProduct());
           data.setReference(rbmList.get(i).getReference());
           data.setCurrentLevel(rbmList.get(i).getCurrentLevel());
           dataList.add(data);
        }


        return dataList;

    }

}
