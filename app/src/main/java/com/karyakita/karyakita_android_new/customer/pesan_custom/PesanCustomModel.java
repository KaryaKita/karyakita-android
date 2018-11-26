package com.karyakita.karyakita_android_new.customer.pesan_custom;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class PesanCustomModel extends BaseModel{
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("kategori_id")
    @Expose
    private Integer kategori_id;

    @SerializedName("ukuran_karya")
    @Expose
    private String ukuran_karya;

    @SerializedName("deadline")
    @Expose
    private String deadline;

    @SerializedName("opsi")
    @Expose
    private String opsi;

    @SerializedName("catatan")
    @Expose
    private String catatan;

    public PesanCustomModel(String createdAt, String updatedAt, Integer id, String image, Integer kategori_id, String ukuran_karya, String deadline, String opsi, String catatatan){
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id        = id;
        this.image     = image;
        this.kategori_id = kategori_id;
        this.ukuran_karya= ukuran_karya;
        this.deadline  = deadline;
        this.opsi      = opsi;
        this.catatan   = catatatan;
    }

    public PesanCustomModel(){
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setKategori_id(Integer kategori_id) {
        this.kategori_id = kategori_id;
    }

    public Integer getKategori_id() {
        return kategori_id;
    }

    public void setUkuran_karya(String ukuran_karya) {
        this.ukuran_karya = ukuran_karya;
    }

    public String getUkuran_karya() {
        return ukuran_karya;
    }

    public void setOpsi(String opsi) {
        this.opsi = opsi;
    }

    public String getOpsi() {
        return opsi;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getCatatan() {
        return catatan;
    }
}
