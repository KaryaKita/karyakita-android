package com.karyakita.karyakita_android_new.customer.home;

import android.annotation.SuppressLint;
import android.util.Log;

import com.karyakita.karyakita_android_new.base_class_interface.GlobalVariable;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
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
    public void get() {
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
                Log.d("Log ", "OnNext" + kategoriKaryaResultModel.getData().get(0).getLocal_url());
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
