package com.karyakita.karyakita_android_new.customer.karya;

import android.nfc.Tag;
import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseFragmentHolderActivity;
import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DetailKaryaPresenter implements IMainPresenter{
    IDetailKaryaView iDetailKaryaView;
    BaseModel model = null;
    DetailKaryaModel detailKaryaModel = null;
    Map<String, String> input;
    Integer karya_id = null;

    public DetailKaryaPresenter(IDetailKaryaView iDetailKaryaView){
        this.iDetailKaryaView = iDetailKaryaView;
    }

    @Override
    public void get(Map<String, String> dataInput) {
        this.karya_id = Integer.parseInt(dataInput.get("karya_id"));
        getObservable().subscribeWith(getObserver());
    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {

    }

    public Observable<DetailKaryaResultModel> getObservable(){
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getDetailKarya("Bearer " + GlobalVariable.TOKEN, this.karya_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<DetailKaryaResultModel>getObserver(){
        return new DisposableObserver<DetailKaryaResultModel>() {

            @Override
            public void onNext(DetailKaryaResultModel detailKaryaResultModel) {
                Log.d("tag", "OnNext iii" + detailKaryaResultModel.getData().getDeploy_url());
                iDetailKaryaView.display(detailKaryaResultModel);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("tag", "Error oiii" + e);
                e.printStackTrace();
                iDetailKaryaView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("tag", "Complete okkk");
            }
        };
    }
}

