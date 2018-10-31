package com.karyakita.karyakita_android_new.customer.data_pengiriman;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class DataPengirimanResultModel extends BaseModel{
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private DataPengirimanModel data;

    public DataPengirimanResultModel(){
    }

    public DataPengirimanResultModel(Boolean success, String message, DataPengirimanModel data){
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public void setSuccess(Boolean success){
        this.success = success;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setData(DataPengirimanModel data){
        this.data = data;
    }

    public Boolean getSuccess(){
        return success;
    }

    public String getMessage(){
        return message;
    }

    public DataPengirimanModel getData(){
        return data;
    }

}
