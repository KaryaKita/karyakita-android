package com.karyakita.karyakita_android_new.presenter;

import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.example.ITestView;


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
    public void insert(BaseModel model) {

    }

//    public Observable<ListKaryaResultModel> getObservable() {
//        return RetrofitHelper.getRetrofit().create(IRestServices.class).getListKaryaByKategori().subscribeOn(Schedulers.io());
//    }


}
