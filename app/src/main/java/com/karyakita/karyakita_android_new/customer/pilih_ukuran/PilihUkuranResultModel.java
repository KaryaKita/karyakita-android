package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class PilihUkuranResultModel extends BaseModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private  PilihUkuranModel data;

    public PilihUkuranResultModel(Boolean success, String message, PilihUkuranModel data){
        this.success = success;
        this.message = message;
        this.data    = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PilihUkuranModel getData() {
        return data;
    }

    public void setData(PilihUkuranModel data) {
        this.data = data;
    }
}
