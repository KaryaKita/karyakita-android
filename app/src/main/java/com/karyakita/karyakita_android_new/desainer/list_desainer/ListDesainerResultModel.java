package com.karyakita.karyakita_android_new.desainer.list_desainer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListDesainerResultModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("data")
    @Expose
    private List<ListDesainerModel> data;

    @SerializedName("message")
    @Expose
    private String message;

    public ListDesainerResultModel() {
    }

    public ListDesainerResultModel(Boolean success, List<ListDesainerModel> data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ListDesainerModel> getData() {
        return data;
    }

    public void setData(List<ListDesainerModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
