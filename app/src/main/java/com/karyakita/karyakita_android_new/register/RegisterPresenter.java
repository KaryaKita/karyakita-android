package com.karyakita.karyakita_android_new.register;


import android.util.Log;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.example.MovieResponse;
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
    RegisterModel registerModel= null;
    Map<String, String> input = null;


    public RegisterPresenter(IRegisterView iRegisterView) {
            this.iRegisterView = iRegisterView;
    }

    @Override
    public void get() {

    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {
        this.input = dataInput;
        Log.d(TAG,"Melbu");
        getObservable().subscribeWith(getObserver());

    }

    public Observable<RegisterResultModel> getObservable(){
        Log.d(TAG,"Melbu Obsarvabel");
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .register(this.input.get("username"),this.input.get("email"), this.input.get("password"),  this.input.get("konfirpassword"), 2,  this.input.get("nama"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<RegisterResultModel> getObserver(){
        return new DisposableObserver<RegisterResultModel>() {

            @Override
            public void onNext(@NonNull RegisterResultModel registerResultModel) {
                iRegisterView.display(registerResultModel);
                Log.d(TAG,"Success");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                iRegisterView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}
