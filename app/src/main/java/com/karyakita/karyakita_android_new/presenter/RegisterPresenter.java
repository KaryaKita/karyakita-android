package com.karyakita.karyakita_android_new.presenter;

import com.karyakita.karyakita_android_new.activity.RegisterActivity;
import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.model.RegisterModel;
import com.karyakita.karyakita_android_new.model.RegisterResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import com.karyakita.karyakita_android_new.view.ITestView;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
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
    public void insert(BaseModel model) {
        this.model = new RegisterModel();
    }

    public Observable<RegisterResultModel> getObservable(){
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .register("","", "",  "", 0,  "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
