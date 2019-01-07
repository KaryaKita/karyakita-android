package com.karyakita.karyakita_android_new.service;

import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanResultModel;
import com.karyakita.karyakita_android_new.customer.karya.DetailKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiResultModel;
import com.karyakita.karyakita_android_new.customer.pesan_custom.PesanCustomResultModel;
import com.karyakita.karyakita_android_new.customer.pesan_langsung.PesanLangsungResultModel;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaResultModel;
import com.karyakita.karyakita_android_new.customer.pilih_ukuran.PilihUkuranResultModel;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilResultModel;
import com.karyakita.karyakita_android_new.desainer.list_desainer.ListDesainerResultModel;
import com.karyakita.karyakita_android_new.login.LoginResultModel;
import com.karyakita.karyakita_android_new.register.RegisterResultModel;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface IRestServices {
    @FormUrlEncoded
    @POST("signup")
    io.reactivex.Observable<RegisterResultModel> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("confirmation") String confirmation,
            @Field("role_id") Integer role_id,
            @Field("nama") String nama);

    @FormUrlEncoded
    @POST("login")
    io.reactivex.Observable<LoginResultModel> login(@Field("email") String email,
                                                    @Field("password") String password,
                                                    @Field("role_id") Integer role_id);

    @GET("kategori_karya/get-all")
    io.reactivex.Observable<KategoriKaryaResultModel> getKategoriKarya();

    @GET("desainer/get-all")
    io.reactivex.Observable<ListDesainerResultModel> getListDesainer();

    @GET("karya/get-all")
    io.reactivex.Observable<ListKaryaResultModel> getListKarya();

    @GET("karya/get-by-kategori/{kategori_id}")
    io.reactivex.Observable<ListKaryaResultModel> getListKaryaByKategori(@Path("kategori_id") Integer kategori_id);

    @GET("karya/{id}")
    io.reactivex.Observable<DetailKaryaResultModel> getDetailKarya(@Path("id")Integer id);


    /* Using Header Authorization Bearer */

    @GET("user/{id}")
    io.reactivex.Observable<ProfilResultModel> getProfil(@Header("Authorization") String bearer, @Path("id")Integer id);

}
