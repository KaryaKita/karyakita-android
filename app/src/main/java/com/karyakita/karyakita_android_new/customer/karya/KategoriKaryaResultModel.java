package com.karyakita.karyakita_android_new.customer.karya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;

import java.util.List;

public class KategoriKaryaResultModel extends BaseModel {
    @SerializedName("success")
    @Expose
    private String success;


    @SerializedName("data")
    @Expose
    private List<KategoriKaryaModel> data;

    @SerializedName("message")
    @Expose
    private String message;

    public KategoriKaryaResultModel(String success, List<KategoriKaryaModel> data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public KategoriKaryaResultModel() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<KategoriKaryaModel> getData() {
        return data;
    }

    public void setData(List<KategoriKaryaModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
