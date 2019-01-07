package com.karyakita.karyakita_android_new.service;

import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanResultModel;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiResultModel;
import com.karyakita.karyakita_android_new.customer.pesan_custom.PesanCustomResultModel;
import com.karyakita.karyakita_android_new.customer.pesan_langsung.PesanLangsungResultModel;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaResultModel;

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ICustomerRestServices {
    /* Using Header Authorization Bearer */

    @FormUrlEncoded
    @Multipart
    @POST("customer/order/custom")
    io.reactivex.Observable<PesanCustomResultModel> pesan_custom(
            @Header("Authorization") String bearer,
            @Field("catatan") String catatan,
            @Field("tanggal_deadline") String tanggal_deadline,
            @Field("kategori_karya") int kategori_karya,
            @Field("opsi_order_id") Integer opsi_order_id,
            @Field("ukuran") String ukuran,
            @Part MultipartBody.Part gambar
    );

    @FormUrlEncoded
    @POST("customer/order/direct")
    io.reactivex.Observable<PesanLangsungResultModel> pesan_langsung(
            @Header("Authorization") String bearer,
            @Field("karya_id") Integer karya_id,
            @Field("catatan") String catatan,
            @Field("tanggal_deadline") String tanggal_deadline,
            @Field("pelanggan_id") Integer pelanggan_id,
            @Field("opsi_order_id") Integer opsi_desainer_id,
            @Field("ukuran") String ukuran );

    @FormUrlEncoded
    @POST("customer/order/data-pengiriman")
    io.reactivex.Observable<DataPengirimanResultModel> datapengiriman(
            @Header("Authorization") String bearer,
            @Field("provinsi") String provinsi,
            @Field("kota_kab") String kota_kab,
            @Field("kecamatan") String kecamatan,
            @Field("alamat_lengkap") String alamat_lengkap,
            @Field("resi") String resi,
            @Field("kode_pos") String kode_pos,
            @Field("via") String via,
            @Field("order_id") Integer order_id);

    @GET("customer/order/list/{customer_id}")
    io.reactivex.Observable<PesananSayaResultModel> getPesananSaya(@Header("Authorization") String bearer, @Path("customer_id")Integer customer_id);



    @GET("customer/notif/list/{customer_id}")
    io.reactivex.Observable<NotifikasiResultModel> getNotifikasi(@Header("Authorization") String bearer, @Path("customer_id")Integer notifikasi_id);

}
