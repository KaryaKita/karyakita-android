package com.karyakita.karyakita_android_new.desainer.pesanan_saya;

import android.content.Context;
import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.service.IDesainerRestServices;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import com.karyakita.karyakita_android_new.sessions.SessionSharedPreferences;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class PesananSayaPresenter implements IMainPresenter {
    IPesananSayaView iPesananSayaView;
    BaseModel model = null;
    PesananSayaModel pesananSayaModel = null;
    Map<String, String> input;
    Context context;

    public PesananSayaPresenter(IPesananSayaView iPesananSayaView, Context context) {
        this.iPesananSayaView = iPesananSayaView;
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
    public Observable<PesananSayaResultModel> getObservable(){
        return RetrofitHelper.getRetrofit().create(IDesainerRestServices.class)
                .getPesananSayaDesainer("Bearer" + SessionSharedPreferences.getToken(this.context))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<PesananSayaResultModel> getObserver() {
        return new DisposableObserver<PesananSayaResultModel>() {

            @Override
            public void onNext(@NonNull PesananSayaResultModel pesananSayaResultModel) {
                iPesananSayaView.display(pesananSayaResultModel);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                iPesananSayaView.displayError("Error fetching Desainer List");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }


}
