package com.karyakita.karyakita_android_new.service;

import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanResultModel;
import com.karyakita.karyakita_android_new.customer.karya.DetailKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiResultModel;
import com.karyakita.karyakita_android_new.customer.pesan_custom.PesanCustomResultModel;
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
    @Multipart
    @POST("customer/order/custom")
    io.reactivex.Observable<PesanCustomResultModel> pesan_custom(

            @Field("catatan") String catatan,
            @Field("tanggal_deadline") String tanggal_deadline,
            @Field("kategori_karya") int kategori_karya,
            @Field("opsi_order_id") Integer opsi_order_id,
            @Field("ukuran") String ukuran,
            @Part MultipartBody.Part gambar
    );

    @FormUrlEncoded
    @POST("customer/order/direct")
    io.reactivex.Observable<PilihUkuranResultModel> pesan_langsung(
            @Header("Authorization") String bearer,
            @Field("karya_id") Integer karya_id,
            @Field("catatan") String catatan,
            @Field("total") Integer total,
            @Field("tanggal_deadline") String tanggal_deadline,
            @Field("pelanggan_id") Integer pelanggan_id,
            @Field("desainer_id") Integer desainer_id,
            @Field("jenis_order_id") Integer jenis_ord6er_id,
            @Field("opsi_order_id") Integer opsi_desainer_id,
            @Field("ukuran") String ukuran );

    @FormUrlEncoded
    @POST("login")
    io.reactivex.Observable<LoginResultModel> login(@Field("email") String email,
                                                    @Field("password") String password,
                                                    @Field("role_id") Integer role_id);
//
//    @FormUrlEncoded
//    @POST("user/login")
//    io.reactivex.Observable<PilihUkuranResultModel> pilihukuran (@Field("ukuran_kertas") String ukuran_kertas,
//                                                                 @Field("ukuran_bingkai") String ukuran_bingkai);


//    @FormUrlEncoded
//    @POST("user/pilih")
//    io.reactivex.Observable<PilihUkuranResultModel> pilihukuran(@Field("ukuran_kertas") String ukuran_kertas,
//                                                                 @Field("ukuran_bingkai") String ukuran_bingkai);

    @FormUrlEncoded
    @POST("user/login")
    io.reactivex.Observable<PilihUkuranResultModel> pilihukuran(@Field("ukuran_kertas") String ukuran_kertas,
                                                                @Field("ukuran_bingkai") String ukuran_bingkai);

    @POST("customer/datapengiriman")
    io.reactivex.Observable<DataPengirimanResultModel> datapengiriman(@Field("provinsi") String provinsi,
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

    @GET("customer/order/list/{customer_id}")
    io.reactivex.Observable<PesananSayaResultModel> getPesananSaya(@Header("Authorization") String bearer, @Path("customer_id")Integer customer_id);

    @GET("customer/notifikasi")
    io.reactivex.Observable<NotifikasiResultModel> getNotifikasi(@Header("Authorization") String bearer, @Path("notifikasi_id")Integer notifikasi_id);

    @GET("desainer/order/list")
    io.reactivex.Observable<com.karyakita.karyakita_android_new.desainer.pesanan_saya.PesananSayaResultModel> getPesananSayaDesainer(@Header("Authorization") String bearer);

//    @GET("karya/get-by-kategori/kategori_id")
//    io.reactivex.Observable<ListKaryaResultModel>getListKaryaByKategori(@Path("kategori_id")Integer kategori_id);

    @GET("karya/get-by-kategori/{kategori_id}")
    io.reactivex.Observable<ListKaryaResultModel> getListKaryaByKategori(@Header("Authorization") String bearer, @Path("kategori_id") Integer kategori_id);

//    @GET("discover/movie")
//    io.reactivex.Observable<ListDesainerModel> getListDesainer(@Path("desainer_id")Integer desainer_id);


    @GET("karya/{id}")
    io.reactivex.Observable<DetailKaryaResultModel> getDetailKarya(@Header("Authorization") String bearer, @Path("id")Integer id);

    @GET("user/{id}")
    io.reactivex.Observable<ProfilResultModel> getProfil(@Header("Authorization") String bearer, @Path("id")Integer id);

}
