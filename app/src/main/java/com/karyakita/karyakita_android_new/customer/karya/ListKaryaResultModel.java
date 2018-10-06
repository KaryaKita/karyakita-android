package com.karyakita.karyakita_android_new.customer.karya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListKaryaResultModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("data")
    @Expose
    private List<ListKaryaModel> data;

    @SerializedName("message")
    @Expose
    private String message;

    public ListKaryaResultModel(Boolean success, List<ListKaryaModel> data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public ListKaryaResultModel() {
    }

//    public List<ListKaryaModel> getListKaryaByKategori(){
//        return data;
//    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ListKaryaModel> getData() {
        return data;
    }

    public void setData(List<ListKaryaModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
