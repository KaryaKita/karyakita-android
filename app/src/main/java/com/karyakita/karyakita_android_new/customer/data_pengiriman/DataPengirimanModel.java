package com.karyakita.karyakita_android_new.customer.data_pengiriman;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base.BaseModel;

public class DataPengirimanModel extends BaseModel{
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("provinsi")
    @Expose
    private String provinsi;

    @SerializedName("kabupaten")
    @Expose
    private String kabupaten;

    @SerializedName("kecamatan")
    @Expose
    private String kecamatan;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("opsipengiriman")
    @Expose
    private String opsipengiriman;

    public DataPengirimanModel(String createdAt, String updatedAt, String provinsi, String kabupaten, String kecamatan, String alamat, String opsipengiriman){
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.provinsi =provinsi;
        this.kabupaten = kabupaten;
        this.kecamatan = kecamatan;
        this.alamat = alamat;
    }

    public DataPengirimanModel(){
    }

    public  String getCreatedAt(){
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

    public String getProvinsi(){
        return provinsi;
    }

    public void setProvinsi(String provinsi){
        this.provinsi = provinsi;
    }

    public String getKabupaten(){
        return kabupaten;
    }

    public void setKabupaten(String kabupaten){
        this.kabupaten = kabupaten;
    }

    public String getKecamatan(){
        return kecamatan;
    }

    public void setKecamatan(String kecamatan){
        this.kecamatan = kecamatan;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getOpsipengiriman(){
        return opsipengiriman;
    }

    public void setOpsipengiriman(String opsipengiriman){
        this.opsipengiriman = opsipengiriman;
    }

}
