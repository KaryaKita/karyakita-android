package com.karyakita.karyakita_android_new.customer.notifikasi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotifikasiModel {
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("order_id")
    @Expose
    private Integer order_id;

    @SerializedName("judul_notifikasi")
    @Expose
    private String judul_notifikasi;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("jenis_notifikasi_id")
    @Expose
    private String jenis_notifikasi_id;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    public NotifikasiModel() {

    }

    public NotifikasiModel(String createdAt, String updatedAt, Integer id, Integer order_id, String judul_notifikasi, String deskripsi, String status, String jenis_notifikasi_id, String user_id) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.order_id = order_id;
        this.judul_notifikasi = judul_notifikasi;
        this.deskripsi = deskripsi;
        this.status = status;
        this.jenis_notifikasi_id = jenis_notifikasi_id;
        this.user_id = user_id;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setJenis_notifikasi_id(String jenis_notifikasi_id) {
        this.jenis_notifikasi_id = jenis_notifikasi_id;
    }

    public String getJudul_notifikasi() {
        return judul_notifikasi;
    }

    public void setJudul_notifikasi(String judul_notifikasi) {

        this.judul_notifikasi = judul_notifikasi;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public String getJenis_notifikasi_id() {
        return jenis_notifikasi_id;
    }

    public String getUser_id() {
        return user_id;
    }
}
