package com.karyakita.karyakita_android_new.desainer.pesanan_saya;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.desainer.list_desainer.ListDesainerResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class PesananSayaPresenter implements IMainPresenter{
    IPesananSayaView iPesananSayaView;
    BaseModel model = null;
    PesananSayaModel pesananSayaModel = null;
    Map<String, String> input;

    public PesananSayaPresenter(IPesananSayaView iPesananSayaView) {
        this.iPesananSayaView = iPesananSayaView;
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

    //public io.reactivex.Observable<PesananSayaResultModel> getObservable() {

    //}

    public Observable<PesananSayaResultModel> getObservable(){
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getPesananSayaDesainer("Bearer" + GlobalVariable.TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<PesananSayaResultModel> getObserver() {
        return new DisposableObserver<PesananSayaResultModel>() {

            @Override
            public void onNext(@NonNull PesananSayaResultModel pesananSayaResultModel) {
                Log.d(TAG, "OnNext" + pesananSayaResultModel.getData().getNama());
                iPesananSayaView.display(pesananSayaResultModel);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error" + e);
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
