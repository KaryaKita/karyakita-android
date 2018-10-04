package com.karyakita.karyakita_android_new.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;

public class LoginResultModel extends BaseModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private LoginModel data;

    @SerializedName("token")
    @Expose
    private String token;

    public LoginResultModel() {
    }

    public LoginResultModel(Boolean success, String message, LoginModel data, String token) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.token = token;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(LoginModel data) {
        this.data = data;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public LoginModel getData() {
        return data;
    }

    public String getToken() {
        return token;
    }
}
