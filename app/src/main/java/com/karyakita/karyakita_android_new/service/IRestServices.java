package com.karyakita.karyakita_android_new.service;

import com.karyakita.karyakita_android_new.login.LoginResultModel;
import com.karyakita.karyakita_android_new.example.MovieResponse;
import com.karyakita.karyakita_android_new.example.TestModel;

import java.util.List;

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

    @POST("user/login")
    io.reactivex.Observable<LoginResultModel> login(@Field("email") String email,
                                                    @Field("password") String password);

}
