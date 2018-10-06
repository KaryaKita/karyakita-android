package com.karyakita.karyakita_android_new.customer.karya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;

public class KategoriKaryaModel extends BaseModel {

    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("kategori")
    @Expose
    private String kategori;

    @SerializedName("path")
    @Expose
    private String path;

    @SerializedName("filename")
    @Expose
    private String filename;

    @SerializedName("filesize")
    @Expose
    private Integer filesize;

    public KategoriKaryaModel(String createdAt, String updatedAt, Integer id, String kategori, String path, String filename, Integer filesize) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.kategori = kategori;
        this.path = path;
        this.filename = filename;
        this.filesize = filesize;
    }

    public KategoriKaryaModel() {
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

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
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
}
