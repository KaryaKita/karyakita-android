package com.karyakita.karyakita_android_new.service;

import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanResultModel;
import com.karyakita.karyakita_android_new.customer.karya.DetailKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.pesan_custom.PesanCustomResultModel;
import com.karyakita.karyakita_android_new.customer.pilih_ukuran.PilihUkuranResultModel;
import com.karyakita.karyakita_android_new.desainer.list_desainer.ListDesainerResultModel;
import com.karyakita.karyakita_android_new.example.MovieResponse;
import com.karyakita.karyakita_android_new.example.TestModel;
import com.karyakita.karyakita_android_new.login.LoginResultModel;
import com.karyakita.karyakita_android_new.register.RegisterResultModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IRestServices {
    @GET("customer/list")
    Call<List<TestModel>> getListHome(@Path("id") int id);

    @GET("discover/movie")
    io.reactivex.Observable<MovieResponse> getMovies(@Query("api_key") String api_key);

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
    @POST
    io.reactivex.Observable<PesanCustomResultModel> pesan_custom(
            @Field("id")Integer id,
            @Field("image")String image,
            @Field("pilih_ukuran")String pilih_ukuran,
            @Field("opsi")String opsi
    );

    @FormUrlEncoded
    @POST("user/login")
    io.reactivex.Observable<LoginResultModel> login(@Field("email") String email,
                                                    @Field("password") String password,
                                                    @Field("role_id") Integer role_id);

    @FormUrlEncoded
    @POST("user/login")
    io.reactivex.Observable<PilihUkuranResultModel> pilihukuran (@Field("ukuran_kertas") String ukuran_kertas,
                                                                 @Field("ukuran_bingkai") String ukuran_bingkai);


    @POST("customer/datapengiriman")
    io.reactivex.Observable<DataPengirimanResultModel> datapengiriman (@Field("provinsi") String provinsi,
                                                                       @Field("kabupaten") String kabupaten,
                                                                       @Field("kecamatan") String kecamatan,
                                                                       @Field("alamat") String alamat,
                                                                       @Field("opsipengiriman") String opsipengiriman);

    @GET("karya/get-all")
    io.reactivex.Observable<KategoriKaryaResultModel> getListKarya(@Header("Authorization") String bearer);

    @GET("kategori_karya/get-all")
    io.reactivex.Observable<KategoriKaryaResultModel> getKategoriKarya(@Header("Authorization") String bearer);

    @GET("desainer/get-all")
    io.reactivex.Observable<ListDesainerResultModel> getListDesainer(@Header("Authorization") String bearer);

//    @GET("karya/get-by-kategori/kategori_id")
//    io.reactivex.Observable<ListKaryaResultModel>getListKaryaByKategori(@Path("kategori_id")Integer kategori_id);

    @GET("karya/get-by-kategori/{kategori_id}")
    io.reactivex.Observable<ListKaryaResultModel> getListKaryaByKategori(@Header("Authorization") String bearer, @Path("kategori_id")Integer kategori_id);

//    @GET("discover/movie")
//    io.reactivex.Observable<ListDesainerModel> getListDesainer(@Path("desainer_id")Integer desainer_id);


    @GET("karya/{id}")
    io.reactivex.Observable<DetailKaryaResultModel> getDetailKarya(@Header("Authorization") String bearer, @Path("id")Integer id);
}
