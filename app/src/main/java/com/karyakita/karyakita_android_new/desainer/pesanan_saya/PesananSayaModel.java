package com.karyakita.karyakita_android_new.desainer.pesanan_saya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

import java.util.Date;

public class PesananSayaModel extends BaseModel {
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("deadline")
    @Expose
    private Date deadline;

    @SerializedName("nama")
    @Expose
    private Date nama;

    @SerializedName("ukuran_kertas")
    @Expose
    private String ukuran_kertas;

    @SerializedName("opsi_bingkai")
    @Expose
    private String opsi_bingkai;

    @SerializedName("status")
    @Expose
    private Integer status;

    public PesananSayaModel() {
    }

    public PesananSayaModel(String createdAt, String updatedAt, Integer id, Date deadline, Date nama, String ukuran_kertas, String opsi_bingkai, Integer status) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.deadline = deadline;
        this.nama = nama;
        this.ukuran_kertas = ukuran_kertas;
        this.opsi_bingkai = opsi_bingkai;
        this.status = status;
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

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setNama(Date nama) {
        this.nama = nama;
    }

    public void setUkuran_kertas(String ukuran_kertas) {
        this.ukuran_kertas = ukuran_kertas;
    }

    public void setOpsi_bingkai(String opsi_bingkai) {
        this.opsi_bingkai = opsi_bingkai;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getDeadline() {
        return deadline;
    }

    public Date getNama() {
        return nama;
    }

    public String getUkuran_kertas() {
        return ukuran_kertas;
    }

    public String getOpsi_bingkai() {
        return opsi_bingkai;
    }

    public Integer getStatus() {
        return status;
    }
}
