package com.karyakita.karyakita_android_new.customer.profil_customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaModel;

import java.util.List;

public class ProfilResultModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("data")
    @Expose
    private ProfilModel data;

    @SerializedName("message")
    @Expose
    private String message;

    public ProfilResultModel() {
    }

    public ProfilResultModel(Boolean success, ProfilModel data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setData(ProfilModel data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public ProfilModel getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
