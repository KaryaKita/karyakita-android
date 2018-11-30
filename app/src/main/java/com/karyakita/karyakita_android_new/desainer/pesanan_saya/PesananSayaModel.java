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
    private String nama;

    @SerializedName("ukuran_kertas")
    @Expose
    private String ukuran_kertas;

    @SerializedName("opsi_bingkai")
    @Expose
    private String opsi_bingkai;

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("jenis_order_id")
    @Expose
    private Integer jenis_order_id;

    @SerializedName("deploy_url")
    @Expose
    private String deploy_url;

    public PesananSayaModel() {
    }

    public PesananSayaModel(String createdAt, String updatedAt, Integer id, Date deadline, String nama, String ukuran_kertas, String opsi_bingkai, Integer status, Integer jenis_order_id, String deploy_url) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.deadline = deadline;
        this.nama = nama;
        this.ukuran_kertas = ukuran_kertas;
        this.opsi_bingkai = opsi_bingkai;
        this.status = status;
        this.jenis_order_id = jenis_order_id;
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

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setNama(String nama) {
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

    public void setJenis_order_id(Integer jenis_order_id){
        this.jenis_order_id = jenis_order_id;
    }

    public void setDeploy_url(String deploy_url) {
        this.deploy_url = deploy_url;
    }

    public String getDeploy_url() {
        return deploy_url;
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

    public String getNama() {
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

    public Integer getJenis_order_id() {
        return jenis_order_id;
    }
}
