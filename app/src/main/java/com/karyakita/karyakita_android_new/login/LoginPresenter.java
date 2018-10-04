package com.karyakita.karyakita_android_new.login;

import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import com.karyakita.karyakita_android_new.example.ITestView;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements IMainPresenter{
    ITestView iTestView;
    BaseModel model = null;

    public LoginPresenter(ITestView iTestView) {
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


    public Observable<LoginResultModel> getObservable() {
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .login("", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
