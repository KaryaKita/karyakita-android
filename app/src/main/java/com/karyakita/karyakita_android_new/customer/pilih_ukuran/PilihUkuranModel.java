package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class PilihUkuranModel extends BaseModel {
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("sp_ukuran_kertas")
    @Expose
    private String sp_ukuran_kertas;

    @SerializedName("rd_dg_pigora")
    @Expose
    private String rd_dg_pigora;

    @SerializedName("rd_tp_pigora")
    @Expose
    private String rd_tp_pigora;

    @SerializedName("sp_jenis_kertas")
    @Expose
    private String sp_jenis_kertas;

    public PilihUkuranModel(String createdAt, String updatedAt, Integer id, String sp_ukuran_kertas, String rd_dg_pigora, String rd_tp_pigora, String sp_jenis_kertas) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.sp_ukuran_kertas = sp_ukuran_kertas;
        this.rd_dg_pigora = rd_dg_pigora;
        this.rd_tp_pigora = rd_tp_pigora;
        this.sp_jenis_kertas = sp_jenis_kertas;
    }

    public PilihUkuranModel() {
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

    public String getSp_ukuran_kertas() {
        return sp_ukuran_kertas;
    }

    public void setSp_ukuran_kertas(String sp_ukuran_kertas) {
        this.sp_ukuran_kertas = sp_ukuran_kertas;
    }

    public String getRd_dg_pigora() {
        return rd_dg_pigora;
    }

    public void setRd_dg_pigora(String rd_dg_pigora) {
        this.rd_dg_pigora = rd_dg_pigora;
    }

    public String getRd_tp_pigora() {
        return rd_tp_pigora;
    }

    public void setRd_tp_pigora(String rd_tp_pigora) {
        this.rd_tp_pigora = rd_tp_pigora;
    }

    public String getSp_jenis_kertas() {
        return sp_jenis_kertas;
    }

    public void setSp_jenis_kertas(String sp_jenis_kertas) {
        this.sp_jenis_kertas = sp_jenis_kertas;
    }
}
