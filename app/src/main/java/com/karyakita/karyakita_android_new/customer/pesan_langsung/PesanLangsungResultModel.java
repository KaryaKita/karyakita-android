package com.karyakita.karyakita_android_new.customer.pesan_langsung;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.customer.pilih_ukuran.DetailModel;
import com.karyakita.karyakita_android_new.customer.pilih_ukuran.OrderModel;

public class PesanLangsungResultModel extends BaseModel {
    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("order")
    @Expose
    private OrderModel orderModel;

    @SerializedName("detail")
    @Expose
    private DetailModel detailModel;

    public PesanLangsungResultModel() {
    }

    public PesanLangsungResultModel(Boolean success, String message, OrderModel orderModel, DetailModel detailModel) {
        this.success = success;
        this.message = message;
        this.orderModel = orderModel;
        this.detailModel = detailModel;
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

    public OrderModel getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    public DetailModel getDetailModel() {
        return detailModel;
    }

    public void setDetailModel(DetailModel detailModel) {
        this.detailModel = detailModel;
    }
}
