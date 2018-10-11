package com.karyakita.karyakita_android_new.customer.karya;


import android.util.Log;

import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.GlobalVariable;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;


public class ListKaryaPresenter implements IMainPresenter {
    IListKaryaView iListKaryaView;
    BaseModel model = null;
    ListKaryaModel listKaryaModel = null;
    Map<String, String> input;

    public ListKaryaPresenter(IListKaryaView iListKaryaView) {
        this.iListKaryaView = iListKaryaView;
    }

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

    public Observable<ListKaryaResultModel> getObservable(){
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getListKaryaByKategori("Bearer " + GlobalVariable.TOKEN, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ListKaryaResultModel> getObserver(){
        return new DisposableObserver<ListKaryaResultModel>() {

            @Override
            public void onNext(@NonNull ListKaryaResultModel listKaryaResultModel) {
                Log.d(TAG,"OnNext"+listKaryaResultModel.getData().get(0).getNama());
                iListKaryaView.display(listKaryaResultModel);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                iListKaryaView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}
