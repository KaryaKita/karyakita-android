package com.karyakita.karyakita_android_new.customer.profil_customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfilModel {
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
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("notelp")
    @Expose
    private String notelp;

    @SerializedName("role_id")
    @Expose
    private String role_id;

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
    private String kode_pos;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    public ProfilModel() {
    }

    public ProfilModel(String createdAt, String updatedAt, Integer id, String email, String username, String password, String nama, String notelp, String role_id, String kecamatan, String kota_kab, String provinsi, String alamat_lengkap, String kode_pos, String user_id) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.notelp = notelp;
        this.role_id = role_id;
        this.kecamatan = kecamatan;
        this.kota_kab = kota_kab;
        this.provinsi = provinsi;
        this.alamat_lengkap = alamat_lengkap;
        this.kode_pos = kode_pos;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public void setKota_kab(String kota_kab) {
        this.kota_kab = kota_kab;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
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

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public String getRole_id() {
        return role_id;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public String getKota_kab() {
        return kota_kab;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public String getUser_id() {
        return user_id;
    }
}