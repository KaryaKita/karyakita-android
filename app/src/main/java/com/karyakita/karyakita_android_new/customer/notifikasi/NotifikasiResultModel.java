package com.karyakita.karyakita_android_new.customer.notifikasi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaModel;

import java.util.List;

public class NotifikasiResultModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("data")
    @Expose
    private List<NotifikasiModel> data;

    @SerializedName("message")
    @Expose
    private String message;

    public NotifikasiResultModel() {
    }

    public NotifikasiResultModel(Boolean success, List<NotifikasiModel> data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setData(List<NotifikasiModel> data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public List<NotifikasiModel> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
