package com.karyakita.karyakita_android_new.customer.karya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailKaryaResultModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("data")
    @Expose
    private DetailKaryaModel data;

    @SerializedName("message")
    @Expose
    private String message;

    public DetailKaryaResultModel(Boolean success, DetailKaryaModel data, String message){
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public DetailKaryaResultModel(){
    }

    public  Boolean getSuccess(){
        return success;
    }

    public  void setSuccess(Boolean success){
        this.success = success;
    }

    public DetailKaryaModel getData(){
        return data;
    }

    public void setData(DetailKaryaModel data){
        this.data = data;
    }

    public String getMessage(){
        return message;
    }

    public  void setMessage(String message){
        this.message = message;
    }


}
