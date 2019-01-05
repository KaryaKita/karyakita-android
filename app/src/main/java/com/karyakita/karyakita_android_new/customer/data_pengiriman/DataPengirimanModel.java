package com.karyakita.karyakita_android_new.customer.data_pengiriman;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class DataPengirimanModel extends BaseModel{
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("via")
    @Expose
    private String via;

    @SerializedName("resi")
    @Expose
    private Integer resi;

    @SerializedName("kecamatan")
    @Expose
    private String kecamatan;

    @SerializedName("kota_kab")
    @Expose
    private String kota_kab;

    @SerializedName("provinsi")
    @Expose
    private String provinsi;

    @SerializedName("alamat_lengkap")
    @Expose
    private String alamat_lengkap;

    @SerializedName("kode_pos")
    @Expose
    private Integer kode_pos;

    @SerializedName("order_id")
    @Expose
    private Integer order_id;

    public DataPengirimanModel(String createdAt, String updatedAt, String via, Integer resi, String kecamatan, String kota_kab, String provinsi, String alamat_lengkap, Integer kode_pos, Integer order_id){
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.via = via;
        this.resi = resi;
        this.kecamatan = kecamatan;
        this.kota_kab = kota_kab;
        this.provinsi = provinsi;
        this.alamat_lengkap = alamat_lengkap;
        this.kode_pos = kode_pos;
        this.order_id = order_id;
    }

    public DataPengirimanModel(){
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

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public Integer getResi() {
        return resi;
    }

    public void setResi(Integer resi) {
        this.resi = resi;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKota_kab() {
        return kota_kab;
    }

    public void setKota_kab(String kota_kab) {
        this.kota_kab = kota_kab;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
    }

    public Integer getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(Integer kode_pos) {
        this.kode_pos = kode_pos;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
}
