package com.karyakita.karyakita_android_new.customer.data_pengiriman;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DataPengirimanPresenter implements IMainPresenter{
    IDataPengirimanView iDataPengirimanView;
    BaseModel model = null;
    DataPengirimanModel dataPengirimanModel = null;
    Map<String, String> input;

    public DataPengirimanPresenter(IDataPengirimanView iDataPengirimanView){
        this.iDataPengirimanView = iDataPengirimanView;
    }

    @Override
    public void get() {

    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {
        this.input = dataInput;
        Log.d("tag", "masuk");
        getObservable().subscribeWith(getObserver());
    }

    public io.reactivex.Observable<DataPengirimanResultModel> getObservable(){
        Log.d("tag", "masuk observable");
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .datapengiriman(this.input.get("provinsi"),
                        this.input.get("kabupaten"),
                        this.input.get("kecamatan"),
                        this.input.get("alamat"),
                        this.input.get("opsipengiriman"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<DataPengirimanResultModel>getObserver(){
        return new DisposableObserver<DataPengirimanResultModel>() {
            @Override
            public void onNext(DataPengirimanResultModel dataPengirimanResultModel) {
                iDataPengirimanView.display(dataPengirimanResultModel);
                iDataPengirimanView.showToast(dataPengirimanResultModel.getMessage());
                Log.d("tag", "success");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("tag", "Error" + e);
                e.printStackTrace();
                iDataPengirimanView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("tag", "Completed");
            }
        };
    }
}