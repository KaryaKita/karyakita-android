package com.karyakita.karyakita_android_new.data.local.realm.model;

import io.realm.RealmObject;

public class PesanLangsungModel extends RealmObject {
    private Integer id;
    private String ukuran_kertas;
    private String ukuran_pigora;
    private String provinsi;
    private String kabupaten;
    private String kecamatan;
    private String alamat;
    private String opsi_pengiriman;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUkuran_kertas() {
        return ukuran_kertas;
    }

    public void setUkuran_kertas(String ukuran_kertas) {
        this.ukuran_kertas = ukuran_kertas;
    }

    public String getUkuran_pigora() {
        return ukuran_pigora;
    }

    public void setUkuran_pigora(String ukuran_pigora) {
        this.ukuran_pigora = ukuran_pigora;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getOpsi_pengiriman() {
        return opsi_pengiriman;
    }

    public void setOpsi_pengiriman(String opsi_pengiriman) {
        this.opsi_pengiriman = opsi_pengiriman;
    }
}
