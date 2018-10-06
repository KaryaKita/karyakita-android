package com.karyakita.karyakita_android_new.customer.karya;

import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;
import java.util.Observable;

import io.reactivex.schedulers.Schedulers;


public class ListKaryaPresenter implements IMainPresenter {
    ITestView iTestView;
    BaseModel model = null;
    ListKaryaModel listKaryaModel = null;
    Map<String, String> input;

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

//    @Override
//    public Observable<ListKaryaResultModel> getObservable() {
//        return RetrofitHelper.getRetrofit().create(IRestServices.class).getListKaryaByKategori().subscribeOn(Schedulers.io());
//    }


}
