package com.karyakita.karyakita_android_new.register;


import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;


public class RegisterPresenter implements IMainPresenter {
    IRegisterView iRegisterView;
    BaseModel model;
    RegisterModel registerModel = null;
    Map<String, String> input = null;


    public RegisterPresenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
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

    public Observable<RegisterResultModel> getObservable() {
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .register(this.input.get("username"),
                        this.input.get("email"),
                        this.input.get("password"),
                        this.input.get("konfirpassword"),
                        Integer.parseInt(this.input.get("role_id")),
                        this.input.get("nama"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<RegisterResultModel> getObserver() {
        return new DisposableObserver<RegisterResultModel>() {

            @Override
            public void onNext(@NonNull RegisterResultModel registerResultModel) {
                iRegisterView.display(registerResultModel);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                iRegisterView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}
