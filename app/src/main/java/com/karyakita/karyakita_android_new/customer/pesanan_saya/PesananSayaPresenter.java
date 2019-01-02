package com.karyakita.karyakita_android_new.customer.pesanan_saya;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaModel;

import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import java.util.Map;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class PesananSayaPresenter implements IMainPresenter {
    IPesananSayaView iPesananSayaView;
    BaseModel model = null;
    PesananSayaModel pesananSayaModel = null;
    Map<String, String> input;
    Integer id_customer;

    public PesananSayaPresenter(IPesananSayaView iPesananSayaView, Integer id_customer){
        this.iPesananSayaView = iPesananSayaView;
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

    public io.reactivex.Observable<PesananSayaResultModel> getObservable(){
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getPesananSaya("Bearer " + GlobalVariable.TOKEN, this.id_customer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<PesananSayaResultModel> getObserver(){
        return new DisposableObserver<PesananSayaResultModel>() {
            @Override
            public void onNext(PesananSayaResultModel pesananSayaResultModel) {
                iPesananSayaView.display(pesananSayaResultModel);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error " + e);
                e.printStackTrace();
                iPesananSayaView.displayError("Error fetching Data Pesanan");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}
