package com.karyakita.karyakita_android_new.customer.pesanan_saya;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaModel;

import com.karyakita.karyakita_android_new.service.ICustomerRestServices;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import com.karyakita.karyakita_android_new.sessions.PreferencesUtility;
import com.karyakita.karyakita_android_new.sessions.SessionSharedPreferences;

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
    Context context;

    public PesananSayaPresenter(IPesananSayaView iPesananSayaView, Integer id_customer, Context context){
        this.iPesananSayaView = iPesananSayaView;
        this.id_customer = id_customer;

        this.context = context;
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
        return RetrofitHelper.getRetrofit().create(ICustomerRestServices.class)
                .getPesananSaya("Bearer " + SessionSharedPreferences.getToken(this.context), this.id_customer)
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
