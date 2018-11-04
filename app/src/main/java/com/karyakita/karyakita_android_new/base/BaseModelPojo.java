package com.karyakita.karyakita_android_new.base;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseModelPojo implements Parcelable, IBaseModel {
    public static final Parcelable.Creator<BaseModelPojo> CREATOR = new Parcelable.Creator<BaseModelPojo>() {
        @Override
        public BaseModelPojo createFromParcel(Parcel in) {
            return new BaseModelPojo(in);
        }

        @Override
        public BaseModelPojo[] newArray(int size) {
            return new BaseModelPojo[size];
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

    public BaseModelPojo() {
    }

    protected BaseModelPojo(Parcel in) {
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
