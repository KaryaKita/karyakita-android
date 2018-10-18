package com.karyakita.karyakita_android_new.customer.karya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class DetailKaryaModel extends BaseModel {
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private  Integer id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    @SerializedName("jumlah_revisi")
    @Expose
    private Integer jumlah_revisi;

    @SerializedName("path")
    @Expose
    private String path;

    @SerializedName("filename")
    @Expose
    private String filename;

    @SerializedName("filesize")
    @Expose
    private Integer filesize;

    @SerializedName("kategori_karya_id")
    @Expose
    private Integer kategori_karya_id;

    @SerializedName("local_url")
    @Expose
    private String local_url;

    @SerializedName("deploy_url")
    @Expose
    private String deploy_url;


    public DetailKaryaModel(String createdAt, String updatedAt, Integer id, String nama,String deskripsi, Integer jumlah_revisi, String path, String filename, Integer filesize, Integer kategori_karya_id, String local_url, String deploy_url){
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.jumlah_revisi = jumlah_revisi;
        this.path = path;
        this.filename = filename;
        this.filesize = filesize;
        this.kategori_karya_id = kategori_karya_id;
        this.local_url = local_url;
        this.deploy_url = deploy_url;
    }

    public DetailKaryaModel(){

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getJumlah_revisi() {
        return jumlah_revisi;
    }

    public void setJumlah_revisi(Integer jumlah_revisi) {
        this.jumlah_revisi = jumlah_revisi;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public Integer getKategori_karya_id() {
        return kategori_karya_id;
    }

    public void setKategori_karya_id(Integer kategori_karya_id) {
        this.kategori_karya_id = kategori_karya_id;
    }

    public String getLocal_url() {
        return local_url;
    }

    public void setLocal_url(String local_url) {
        this.local_url = local_url;
    }

    public String getDeploy_url() {
        return deploy_url;
    }

    public void setDeploy_url(String deploy_url) {
        this.deploy_url = deploy_url;
    }

}
