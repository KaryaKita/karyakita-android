package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class PilihUkuranPesanLangsungModel extends BaseModel{
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("ukuran_kertas")
    @Expose
    private String ukuran_kertas;

    @SerializedName("ukuran_bingkai")
    @Expose
    private String ukuran_bingkai;

    public PilihUkuranPesanLangsungModel(String createdAt, String updatedAt, Integer id, String ukuran_kertas, String ukuran_bingkai){
        this.createdAt      = createdAt;
        this.updatedAt      = updatedAt;
        this.id             = id;
        this.ukuran_kertas  = ukuran_kertas;
        this.ukuran_bingkai = ukuran_bingkai;
    }

    public PilihUkuranPesanLangsungModel(){
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUkuran_kertas(){
        return ukuran_kertas;
    }

    public void setUkuran_kertas(String ukuran_kertas){
        this.ukuran_kertas = ukuran_kertas;
    }

    public String getUkuran_bingkai() {
        return ukuran_bingkai;
    }

    public void setUkuran_bingkai(String ukuran_bingkai){
        this.ukuran_bingkai = ukuran_bingkai;
    }
}
