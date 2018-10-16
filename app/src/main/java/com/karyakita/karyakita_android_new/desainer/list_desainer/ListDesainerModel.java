package com.karyakita.karyakita_android_new.desainer.list_desainer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;

public class ListDesainerModel extends BaseModel{
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("username")
    @Expose
    private String nama;

    @SerializedName("nama")
    @Expose
    private String notelp;

    @SerializedName("role_id")
    @Expose
    private Integer role_id;

    @SerializedName("rating")
    @Expose
    private Integer rating;

    @SerializedName("subscriber")
    @Expose
    private Integer subscriber;

    public ListDesainerModel() {
    }

    public ListDesainerModel(String createdAt, String updatedAt, Integer id, String email, String nama, String notelp, Integer role_id, Integer rating, Integer subscriber) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.email = email;
        this.nama = nama;
        this.notelp = notelp;
        this.role_id = role_id;
        this.rating = rating;
        this.subscriber = subscriber;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setSubscriber(Integer subscriber) {
        this.subscriber = subscriber;
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

    public String getEmail() {
        return email;
    }

    public String getNama() {
        return nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getSubscriber() {
        return subscriber;
    }
}
