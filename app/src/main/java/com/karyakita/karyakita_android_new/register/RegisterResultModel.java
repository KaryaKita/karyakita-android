package com.karyakita.karyakita_android_new.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class RegisterResultModel extends BaseModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private RegisterModel data;

    public RegisterResultModel(Boolean success, String message, RegisterModel data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public RegisterResultModel() {
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

    public RegisterModel getData() {
        return data;
    }

    public void setData(RegisterModel data) {
        this.data = data;
    }
}
