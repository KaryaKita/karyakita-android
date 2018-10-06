package com.karyakita.karyakita_android_new.customer.karya;

import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.example.ITestView;

import java.util.Map;


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
    public void insert(Map<String, String> dataInput) {

    }


//    public Observable<ListKaryaResultModel> getObservable() {
//        return RetrofitHelper.getRetrofit().create(IRestServices.class).getListKaryaByKategori().subscribeOn(Schedulers.io());
//    }


}
