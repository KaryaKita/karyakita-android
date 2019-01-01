package com.karyakita.karyakita_android_new.desainer.list_desainer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class ListDesainerModel extends BaseModel {
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("username")
    @Expose
    private String nama;

    @SerializedName("nama")
    @Expose
    private String notelp;

    @SerializedName("role_id")
    @Expose
    private Integer role_id;

    @SerializedName("rating")
    @Expose
    private Integer rating;

    @SerializedName("subscriber")
    @Expose
    private Integer subscriber;

    @SerializedName("alamat_lengkap")
    @Expose
    private String alamat_lengkap;

    @SerializedName("kode_pos")
    @Expose
    private String kode_pos;

    @SerializedName("kecamatan")
    @Expose
    private String kecamatan;

    @SerializedName("kota_kab")
    @Expose
    private String kota_kab;

    @SerializedName("provinsi")
    @Expose
    private String provinsi;

    public ListDesainerModel() {
    }

    public ListDesainerModel(ListDesainerModel listDesainerModel) {
        this.createdAt = listDesainerModel.createdAt;
        this.updatedAt = listDesainerModel.updatedAt;
        this.id = listDesainerModel.id;
        this.email = listDesainerModel.email;
        this.nama = listDesainerModel.nama;
        this.notelp = listDesainerModel.notelp;
        this.role_id = listDesainerModel.role_id;
        this.rating = listDesainerModel.rating;
        this.subscriber = listDesainerModel.subscriber;
        this.alamat_lengkap = listDesainerModel.alamat_lengkap;
        this.kode_pos = listDesainerModel.kode_pos;
        this.kecamatan = listDesainerModel.kecamatan;
        this.kota_kab = listDesainerModel.kota_kab;
        this.provinsi = listDesainerModel.provinsi;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Integer subscriber) {
        this.subscriber = subscriber;
    }
}
