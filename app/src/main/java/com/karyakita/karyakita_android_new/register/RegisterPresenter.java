package com.karyakita.karyakita_android_new.register;


import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class RegisterPresenter implements IMainPresenter {
    ITestView iTestView;
    BaseModel model;

    public RegisterPresenter(ITestView iTestView) {
            this.iTestView = iTestView;
    }

    @Override
    public void get() {

    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {

    }

    public Observable<RegisterResultModel> getObservable(){
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .register("","", "",  "", 0,  "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
