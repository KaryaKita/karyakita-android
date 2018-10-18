package com.karyakita.karyakita_android_new.service;

import com.karyakita.karyakita_android_new.customer.karya.DetailKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaResultModel;
import com.karyakita.karyakita_android_new.desainer.list_desainer.ListDesainerModel;
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
    @POST("user/login")
    io.reactivex.Observable<LoginResultModel> login(@Field("email") String email,
                                                    @Field("password") String password,
                                                    @Field("role_id") Integer role_id);

    @GET("karya/get-all")
    io.reactivex.Observable<KategoriKaryaResultModel> getListKarya(@Header("Authorization") String bearer);

    @GET("kategori_karya/get-all")
    io.reactivex.Observable<KategoriKaryaResultModel> getKategoriKarya(@Header("Authorization") String bearer);

//    @GET("karya/get-by-kategori/kategori_id")
//    io.reactivex.Observable<ListKaryaResultModel>getListKaryaByKategori(@Path("kategori_id")Integer kategori_id);

    @GET("karya/get-by-kategori/{kategori_id}")

    io.reactivex.Observable<ListKaryaResultModel> getListKaryaByKategori(@Header("Authorization") String bearer, @Path("kategori_id")Integer kategori_id);

//    @GET("discover/movie")
//    io.reactivex.Observable<ListDesainerModel> getListDesainer(@Path("desainer_id")Integer desainer_id);


    @GET("karya/{kategori_id}")
    io.reactivex.Observable<DetailKaryaResultModel> getDetailKarya(@Header("Authorization") String bearer, @Path("kategori_id")Integer kategori_id);
}
