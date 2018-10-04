package com.karyakita.karyakita_android_new.presenter;

import com.karyakita.karyakita_android_new.activity.customer.CustomerListKarya;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.model.ListKaryaResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import com.karyakita.karyakita_android_new.view.ITestView;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


public class ListKaryaPresenter implements IMainPresenter {
    ITestView iTestView;

    public ListKaryaPresenter(ITestView iTestView) {
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

    }

//    public Observable<ListKaryaResultModel> getObservable() {
//        return RetrofitHelper.getRetrofit().create(IRestServices.class).getListKaryaByKategori().subscribeOn(Schedulers.io());
//    }


}
