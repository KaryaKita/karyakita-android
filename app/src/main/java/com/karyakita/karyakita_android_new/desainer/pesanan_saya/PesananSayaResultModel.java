package com.karyakita.karyakita_android_new.desainer.pesanan_saya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class PesananSayaResultModel extends BaseModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private PesananSayaModel data;

    @SerializedName("token")
    @Expose
    private String token;

    public PesananSayaResultModel() {
    }

    public PesananSayaResultModel(Boolean success, String message, PesananSayaModel data, String token) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.token = token;
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

    public PesananSayaModel getData() {
        return data;
    }

    public void setData(PesananSayaModel data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
