package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.login.LoginResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PilihUkuranPresenter implements IMainPresenter{
    IPilihUkuranView iPilihUkuranPesanLangsungView;
    BaseModel model;
    PilihUkuranModel pilihUkuranModel = null;
    Map<String, String> input = null;

    public PilihUkuranPresenter(IPilihUkuranView iPilihUkuranPesanLangsungView){
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

    public Observable<PilihUkuranResultModel> getObservable(){
        Log.d("tag", "masuk observable");
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .pilihukuran(this.input.get("sp_ukuran_kertas"),
                        this.input.get("sp_jenis_kertas"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<PilihUkuranModel> getObserver(){
        return new DisposableObserver<PilihUkuranModel>() {
            @Override
            public void onNext(PilihUkuranModel pilihUkuranModel) {
                iPilihUkuranPesanLangsungView.display(pilihUkuranModel);
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
