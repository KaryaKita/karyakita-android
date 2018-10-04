package com.karyakita.karyakita_android_new.customer.home;

import android.util.Log;

import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.model.KategoriKaryaResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class HomePresenter implements IMainPresenter {
    ITestView iTestView;

    public HomePresenter(ITestView iTestView) {
        this.iTestView = iTestView;
    }

    @Override
    public void get() {
//        getObservable().subscribeWith(getObserver());
    }

    private DisposableObserver<KategoriKaryaResultModel> getObservable() {
        return new DisposableObserver<KategoriKaryaResultModel>() {
            @Override
            public void onNext(KategoriKaryaResultModel kategoriKaryaResultModel) {
                Log.d(TAG, "OnNext" + kategoriKaryaResultModel.getMessage());
//                iTestView.display(kategoriKaryaResultModel.getMessage());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public void update() {

    }

    @Override
    public void insert(BaseModel model) {

    }

    public Observable<KategoriKaryaResultModel> getObserver() {
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getKategoriKarya()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
