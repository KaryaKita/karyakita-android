package com.karyakita.karyakita_android_new.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;

import java.util.List;

public class KategoriKaryaResultModel extends BaseModel {
    @SerializedName("success")
    @Expose
    private Integer success;


    @SerializedName("data")
    @Expose
    private List<KategoriKaryaModel> data;

    @SerializedName("message")
    @Expose
    private String message;

    public KategoriKaryaResultModel(Integer success, List<KategoriKaryaModel> data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public KategoriKaryaResultModel() {
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
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
