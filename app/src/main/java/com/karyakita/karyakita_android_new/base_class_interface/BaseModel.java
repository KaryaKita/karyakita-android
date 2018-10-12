package com.karyakita.karyakita_android_new.base_class_interface;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseModel implements Parcelable {

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };


    @SerializedName("id")
    @Expose
    protected int id;

    @SerializedName("createdAt")
    @Expose
    protected String createdAt;

    @SerializedName("updatedAt")
    @Expose
    protected String updatedAt;

    public BaseModel() {
    }

    protected BaseModel(Parcel in) {
        this.id         = in.readInt();
        this.createdAt  = in.readString();
        this.updatedAt  = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
    }
}
