package com.karyakita.karyakita_android_new.service;

import com.karyakita.karyakita_android_new.model.MovieResponse;
import com.karyakita.karyakita_android_new.model.TestModel;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IRestServices {
    @GET("customer/list")
    Call<List<TestModel>> getListHome(@Path("id") int id);

    @GET("discover/movie")
    io.reactivex.Observable<MovieResponse> getMovies(@Query("api_key") String api_key);

}
