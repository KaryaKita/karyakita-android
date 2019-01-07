package com.karyakita.karyakita_android_new.service;

import retrofit2.http.GET;
import retrofit2.http.Header;

public interface IDesainerRestServices {

    /* Using Header Authorization Bearer */

    @GET("desainer/order/list")
    io.reactivex.Observable<com.karyakita.karyakita_android_new.desainer.pesanan_saya.PesananSayaResultModel> getPesananSayaDesainer(@Header("Authorization") String bearer);
}
