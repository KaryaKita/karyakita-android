package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import io.realm.RealmObject;

public class PilihUkuranModelRealm extends RealmObject{
    private Integer id;
    private String sp_ukuran_kertas;
    private String sp_jenis_kertas;
    private String rd_dg_pigora;
    private  String rd_tp_pigora;

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

    public String getSp_jenis_kertas() {
        return sp_jenis_kertas;
    }

    public void setSp_jenis_kertas(String sp_jenis_kertas) {
        this.sp_jenis_kertas = sp_jenis_kertas;
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
}
