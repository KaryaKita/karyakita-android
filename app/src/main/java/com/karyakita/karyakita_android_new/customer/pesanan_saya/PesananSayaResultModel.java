package com.karyakita.karyakita_android_new.customer.pesanan_saya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaModel;

import java.util.List;

public class PesananSayaResultModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("data")
    @Expose
    private List<PesananSayaModel> data;

    @SerializedName("message")
    @Expose
    private String message;

    public PesananSayaResultModel() {
    }

    public PesananSayaResultModel(Boolean success, List<PesananSayaModel> data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setData(List<PesananSayaModel> data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public List<PesananSayaModel> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
