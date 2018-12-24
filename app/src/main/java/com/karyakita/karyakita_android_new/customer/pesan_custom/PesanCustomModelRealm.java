package com.karyakita.karyakita_android_new.customer.pesan_custom;

import io.realm.RealmObject;

public class PesanCustomModelRealm extends RealmObject{
    private Integer id;
    private String catatan;
    private  Integer total;
    private String tanggal_deadline;
    private Integer pelanggan_id;
    private Integer desainer_id;
    private Integer kategori_karya_id;
    private Integer jenis_order_id;
    private Integer opsi_order_id;
    private String ukuran;
    private String gambar;

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTanggal_deadline() {
        return tanggal_deadline;
    }

    public void setTanggal_deadline(String tanggal_deadline) {
        this.tanggal_deadline = tanggal_deadline;
    }

    public Integer getPelanggan_id() {
        return pelanggan_id;
    }

    public void setPelanggan_id(Integer pelanggan_id) {
        this.pelanggan_id = pelanggan_id;
    }

    public Integer getDesainer_id() {
        return desainer_id;
    }

    public void setDesainer_id(Integer desainer_id) {
        this.desainer_id = desainer_id;
    }

    public Integer getKategori_karya_id() {
        return kategori_karya_id;
    }

    public void setKategori_karya_id(Integer kategori_karya_id) {
        this.kategori_karya_id = kategori_karya_id;
    }

    public Integer getJenis_order_id() {
        return jenis_order_id;
    }

    public void setJenis_order_id(Integer jenis_order_id) {
        this.jenis_order_id = jenis_order_id;
    }

    public Integer getOpsi_order_id() {
        return opsi_order_id;
    }

    public void setOpsi_order_id(Integer opsi_order_id) {
        this.opsi_order_id = opsi_order_id;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public void setId(int id) {
        this.id = id;
    }
}
