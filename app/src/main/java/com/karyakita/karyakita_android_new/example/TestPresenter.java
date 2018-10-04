package com.karyakita.karyakita_android_new.example;


import android.util.Log;

import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TestPresenter implements IMainPresenter {
    ITestView testView;
    private String TAG = "TestPresenter";

    public TestPresenter(ITestView iTestView) {
        this.testView = iTestView;
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

    public Observable<MovieResponse> getObservable(){
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getMovies("004cbaf19212094e32aa9ef6f6577f22")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<MovieResponse> getObserver(){
        return new DisposableObserver<MovieResponse>() {

            @Override
            public void onNext(@NonNull MovieResponse movieResponse) {
                Log.d(TAG,"OnNext"+movieResponse.getTotalResults());
                testView.display(movieResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                testView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}
