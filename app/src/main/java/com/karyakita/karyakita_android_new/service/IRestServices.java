package com.karyakita.karyakita_android_new.service;

import com.karyakita.karyakita_android_new.model.MovieResponse;
import com.karyakita.karyakita_android_new.model.RegisterResultModel;
import com.karyakita.karyakita_android_new.model.TestModel;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IRestServices {
    @GET("customer/list")
    Call<List<TestModel>> getListHome(@Path("id") int id);

    @GET("discover/movie")
    io.reactivex.Observable<MovieResponse> getMovies(@Query("api_key") String api_key);

    @POST("user/signup")
    io.reactivex.Observable<RegisterResultModel> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("confirmation") String confirmation,
            @Field("role_id") Integer role_id,
            @Field("nama") String nama);

}
