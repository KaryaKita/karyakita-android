package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.login.LoginResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PilihUkuranPesanLangsungPresenter implements IMainPresenter{
    IPilihUkuranPesanLangsungView iPilihUkuranPesanLangsungView;
    BaseModel model;
    PilihUkuranPesanLangsungModel pilihUkuranPesanLangsungModel = null;
    Map<String, String> input = null;

    public PilihUkuranPesanLangsungPresenter(IPilihUkuranPesanLangsungView iPilihUkuranPesanLangsungView){
        this.iPilihUkuranPesanLangsungView = iPilihUkuranPesanLangsungView;
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
        Log.d("tag", "kenek");
    }

    public io.reactivex.Observable<LoginResultModel> getObservable(){
        Log.d("tag", "masuk observable");
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .pilihukuran(this.input.get("ukuran_kertas"),
                        this.input.get("ukuran_bingkai"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<PilihUkuranPesanLangsungModel> getObserver(){
        return new DisposableObserver<PilihUkuranPesanLangsungModel>() {
            @Override
            public void onNext(PilihUkuranPesanLangsungModel pilihUkuranPesanLangsungModel) {
                iPilihUkuranPesanLangsungView.display(pilihUkuranPesanLangsungModel);
                Log.d("tag", "succes");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("tag", "Error" + e);
                e.printStackTrace();
                iPilihUkuranPesanLangsungView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("tag", "Completed");
            }
        };
    }
}
