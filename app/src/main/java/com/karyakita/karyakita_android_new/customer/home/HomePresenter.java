package com.karyakita.karyakita_android_new.customer.home;

import android.annotation.SuppressLint;
import android.util.Log;

import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaModel;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements IMainPresenter {
    IHomeView iHomeView;
    KategoriKaryaModel kategoriKaryaModel;


    public HomePresenter(IHomeView iHomeView) {
        this.iHomeView = iHomeView;
    }

    @SuppressLint("CheckResult")
    @Override
    public void get(Map<String, String> dataInput) {
        getObservable().subscribeWith(getObserver());
    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {

    }

    public Observable<KategoriKaryaResultModel> getObservable() {
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getKategoriKarya("Bearer " + GlobalVariable.TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<KategoriKaryaResultModel> getObserver() {
        return new DisposableObserver<KategoriKaryaResultModel>() {
            @Override
            public void onNext(KategoriKaryaResultModel kategoriKaryaResultModel) {
                iHomeView.display(kategoriKaryaResultModel);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                iHomeView.displayError("error fetching kategori data");
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
