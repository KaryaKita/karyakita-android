package com.karyakita.karyakita_android_new.customer.pesanan_saya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PesananSayaModel {
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("nama_desainer")
    @Expose
    private String nama_desainer;

    @SerializedName("kategori")
    @Expose
    private String kategori;

    @SerializedName("harga")
    @Expose
    private String harga;

    @SerializedName("deadline")
    @Expose
    private String deadline;

    @SerializedName("jenis_pesanan")
    @Expose
    private String jenis_pesanan;

    @SerializedName("opsi_pesanan")
    @Expose
    private String opsi_pesanan;

    @SerializedName("deploy_url")
    @Expose
    private String deploy_url;

    public PesananSayaModel() {
    }

    public PesananSayaModel(String createdAt, String updatedAt, Integer id, String nama_desainer, String kategori, String harga, String deadline, String jenis_pesanan, String opsi_pesanan, String deploy_url) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.nama_desainer = nama_desainer;
        this.kategori = kategori;
        this.harga = harga;
        this.deadline = deadline;
        this.jenis_pesanan = jenis_pesanan;
        this.opsi_pesanan = opsi_pesanan;
        this.deploy_url = deploy_url;
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

    public void setNama_desainer(String nama_desainer) {
        this.nama_desainer = nama_desainer;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setJenis_pesanan(String jenis_pesanan) {
        this.jenis_pesanan = jenis_pesanan;
    }

    public void setOpsi_pesanan(String opsi_pesanan) {
        this.opsi_pesanan = opsi_pesanan;
    }

    public void setDeploy_url(String deploy_url) {
        this.deploy_url = deploy_url;
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

    public String getNama_desainer() {
        return nama_desainer;
    }

    public String getKategori() {
        return kategori;
    }

    public String getHarga() {
        return harga;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getJenis_pesanan() {
        return jenis_pesanan;
    }

    public String getOpsi_pesanan() {
        return opsi_pesanan;
    }

    public String getDeploy_url() {
        return deploy_url;
    }
}
