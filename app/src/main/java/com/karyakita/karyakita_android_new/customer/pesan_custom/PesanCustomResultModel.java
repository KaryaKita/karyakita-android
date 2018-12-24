package com.karyakita.karyakita_android_new.customer.pesan_custom;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class PesanCustomResultModel extends BaseModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private PesanCustomModel data;

    public PesanCustomResultModel(Boolean success, String message, PesanCustomModel data) {
        this.success = success;
        this.message = message;
        this.data = data;
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

    public PesanCustomModel getData() {
        return data;
    }

    public void setData(PesanCustomModel data) {
        this.data = data;
    }
}
