package com.karyakita.karyakita_android_new.presenter;

import android.text.Editable;

import com.karyakita.karyakita_android_new.activity.LoginActivity;
import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.model.LoginModel;
import com.karyakita.karyakita_android_new.model.LoginResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import com.karyakita.karyakita_android_new.view.ITestView;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.operators.observable.ObservableAll;
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
    public void insert() {
       this.model = new LoginModel();
    }

    public Observable<LoginResultModel> getObservable() {
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .login("", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
