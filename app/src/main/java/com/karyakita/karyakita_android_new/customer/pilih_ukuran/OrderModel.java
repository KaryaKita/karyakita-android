package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class OrderModel extends BaseModel {
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("catatan")
    @Expose
    private String catatan;

    @SerializedName("total")
    @Expose
    private Integer total;

    @SerializedName("tanggal_deadline")
    @Expose
    private String tanggal_deadline;

    @SerializedName("tanggal_selesai")
    @Expose
    private String tanggal_selesai;

    @SerializedName("is_accepted")
    @Expose
    private Integer is_accepted;

    @SerializedName("status_bayar")
    @Expose
    private Integer status_bayar;

    @SerializedName("status_diproses")
    @Expose
    private Integer status_diproses;

    @SerializedName("status_selesai")
    @Expose
    private Integer status_selesai;

    @SerializedName("status_dikirim")
    @Expose
    private Integer status_dikirim;

    @SerializedName("status_diterima")
    @Expose
    private Integer status_diterima;

    @SerializedName("pelanggan_id")
    @Expose
    private Integer pelanggan_id;

    @SerializedName("desainer_id")
    @Expose
    private Integer desainer_id;

    @SerializedName("kategori_karya_id")
    @Expose
    private Integer kategori_karya_id;

    @SerializedName("jenis_order_id")
    @Expose
    private Integer jenis_order_id;

    @SerializedName("opsi_order_id")
    @Expose
    private Integer opsi_order_id;

    public OrderModel(){
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(String tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

    public Integer getIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(Integer is_accepted) {
        this.is_accepted = is_accepted;
    }

    public Integer getStatus_bayar() {
        return status_bayar;
    }

    public void setStatus_bayar(Integer status_bayar) {
        this.status_bayar = status_bayar;
    }

    public Integer getStatus_diproses() {
        return status_diproses;
    }

    public void setStatus_diproses(Integer status_diproses) {
        this.status_diproses = status_diproses;
    }

    public Integer getStatus_selesai() {
        return status_selesai;
    }

    public void setStatus_selesai(Integer status_selesai) {
        this.status_selesai = status_selesai;
    }

    public Integer getStatus_dikirim() {
        return status_dikirim;
    }

    public void setStatus_dikirim(Integer status_dikirim) {
        this.status_dikirim = status_dikirim;
    }

    public Integer getStatus_diterima() {
        return status_diterima;
    }

    public void setStatus_diterima(Integer status_diterima) {
        this.status_diterima = status_diterima;
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

    public Integer getKategori_karya_id() {
        return kategori_karya_id;
    }

    public void setKategori_karya_id(Integer kategori_karya_id) {
        this.kategori_karya_id = kategori_karya_id;
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
}
