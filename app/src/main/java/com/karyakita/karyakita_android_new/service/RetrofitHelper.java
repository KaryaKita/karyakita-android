package com.karyakita.karyakita_android_new.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public static Retrofit retrofit;

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(1000, TimeUnit.SECONDS)
                    .readTimeout(1000, TimeUnit.SECONDS);
            OkHttpClient okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://178.128.22.48:1337/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

        }
        return retrofit;
    }

    public void NetworkClient() {

    }
}
