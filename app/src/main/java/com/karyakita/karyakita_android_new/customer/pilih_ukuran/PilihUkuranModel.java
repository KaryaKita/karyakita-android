package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class PilihUkuranModel extends BaseModel {
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("karya_id")
    @Expose
    private Integer karya_id;

    @SerializedName("catatan")
    @Expose
    private String catatan;

    @SerializedName("total")
    @Expose
    private Integer total;

    @SerializedName("tanggal_deadline")
    @Expose
    private String tanggal_deadline;

    @SerializedName("pelanggan_id")
    @Expose
    private Integer pelanggan_id;

    @SerializedName("desainer_id")
    @Expose
    private Integer desainer_id;

    @SerializedName("jenis_order_id")
    @Expose
    private Integer jenis_order_id;

    @SerializedName("opsi_order_id")
    @Expose
    private Integer opsi_order_id;

    @SerializedName("ukuran")
    @Expose
    private String ukuran;

    public PilihUkuranModel(String createdAt, String updatedAt, Integer karya_id, String catatan, Integer total, String tanggal_deadline, Integer pelanggan_id, Integer desainer_id, Integer jenis_order_id, Integer opsi_order_id, String ukuran) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.karya_id = karya_id;
        this.catatan = catatan;
        this.total = total;
        this.tanggal_deadline = tanggal_deadline;
        this.pelanggan_id = pelanggan_id;
        this.desainer_id = desainer_id;
        this.jenis_order_id = jenis_order_id;
        this.opsi_order_id = opsi_order_id;
        this.ukuran = ukuran;
    }

    public PilihUkuranModel() {
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getKarya_id() {
        return karya_id;
    }

    public void setKarya_id(Integer karya_id) {
        this.karya_id = karya_id;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTanggal_deadline() {
        return tanggal_deadline;
    }

    public void setTanggal_deadline(String tanggal_deadline) {
        this.tanggal_deadline = tanggal_deadline;
    }

    public Integer getPelanggan_id() {
        return pelanggan_id;
    }

    public void setPelanggan_id(Integer pelanggan_id) {
        this.pelanggan_id = pelanggan_id;
    }

    public Integer getDesainer_id() {
        return desainer_id;
    }

    public void setDesainer_id(Integer desainer_id) {
        this.desainer_id = desainer_id;
    }

    public Integer getJenis_order_id() {
        return jenis_order_id;
    }

    public void setJenis_order_id(Integer jenis_order_id) {
        this.jenis_order_id = jenis_order_id;
    }

    public Integer getOpsi_order_id() {
        return opsi_order_id;
    }

    public void setOpsi_order_id(Integer opsi_order_id) {
        this.opsi_order_id = opsi_order_id;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }
}
