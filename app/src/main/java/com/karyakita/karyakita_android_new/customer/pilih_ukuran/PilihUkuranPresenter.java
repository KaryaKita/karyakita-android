package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.customer.pesan_langsung.PesanLangsungResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class PilihUkuranPresenter implements IMainPresenter{
    IPilihUkuranView iPilihUkuranView;
    BaseModel model;
    PilihUkuranModel pilihUkuranModel = null;
    Map<String, String> input = null;
    Integer karya_id = null;
    Integer total = null;

    public PilihUkuranPresenter(IPilihUkuranView iPilihUkuranView){
        this.iPilihUkuranView = iPilihUkuranView;
    }

    @Override
    public void get(Map<String, String> dataInput) {

    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {
        this.input = dataInput;
        getObservable().subscribeWith(getObserver());
    }

    public io.reactivex.Observable<PesanLangsungResultModel> getObservable(){
        Log.d("tag", "masuk observable");
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .pesan_langsung("Bearer " + GlobalVariable.TOKEN,Integer.parseInt(
                        this.input.get("karya_id")),
                        this.input.get("catatan"),
                        this.input.get("tanggal_deadline"),
                        Integer.parseInt(this.input.get("pelanggan_id")),
                        Integer.parseInt(this.input.get("opsi_order_id")),
                        this.input.get("ukuran"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<PesanLangsungResultModel> getObserver() {
        return new DisposableObserver<PesanLangsungResultModel>() {
            @Override
            public void onNext(PesanLangsungResultModel pilihUkuranResultModel) {
                iPilihUkuranView.display(pilihUkuranResultModel);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                iPilihUkuranView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("tag", "Completed");
            }
        };
    }
}
