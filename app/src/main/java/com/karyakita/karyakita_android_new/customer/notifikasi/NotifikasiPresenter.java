package com.karyakita.karyakita_android_new.customer.notifikasi;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.service.ICustomerRestServices;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class NotifikasiPresenter implements IMainPresenter{

    INotifikasiView iNotifikasiView;
    BaseModel model = null;
    NotifikasiModel notifikasiModel = null;
    Map<String, String> input;
    Integer id_customer;

    public NotifikasiPresenter(INotifikasiView iNotifikasiView, Integer id_customer) {
        this.iNotifikasiView = iNotifikasiView;
        this.id_customer = id_customer;
    }

    @Override
    public void get(Map<String, String> dataInputs) {
        getObservable().subscribeWith(getObserver());
    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {

    }

    public Observable<NotifikasiResultModel> getObservable(){
        return RetrofitHelper.getRetrofit().create(ICustomerRestServices.class)
                .getNotifikasi("Bearer " + GlobalVariable.TOKEN, this.id_customer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<NotifikasiResultModel> getObserver(){
        return new DisposableObserver<NotifikasiResultModel>() {
            @Override
            public void onNext(NotifikasiResultModel notifikasiResultModel) {
                iNotifikasiView.display(notifikasiResultModel);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                iNotifikasiView.displayError("Error fetching Notifikasi");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");

            }
        };
    }
}
