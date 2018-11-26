package com.karyakita.karyakita_android_new.customer.pesan_custom;

import io.realm.RealmObject;

public class PesanCustomModelRealm extends RealmObject{
    private Integer id;
    private Integer kategori_id;
//    private String image;
    private String ukuran_karya;
    private String deadline;
    private String catatan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(Integer kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getUkuran_karya() {
        return ukuran_karya;
    }

    public void setUkuran_karya(String ukuran_karya) {
        this.ukuran_karya = ukuran_karya;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
