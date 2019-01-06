package com.karyakita.karyakita_android_new.customer.profil_customer;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.customer.karya.DetailKaryaResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfilPresenter implements IMainPresenter{
    IProfilView iProfilView;
    BaseModel model = null;
    Map<String, String> input;
    Integer user_id = null;

    public ProfilPresenter(IProfilView iProfilView, Integer user_id){
        this.iProfilView = iProfilView;
        this.user_id = user_id;
    }

    @Override
    public void get(Map<String, String> dataInput) {
        this.user_id = Integer.parseInt(dataInput.get("user_id"));
        getObservable().subscribeWith(getObserver());
    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {

    }

    public io.reactivex.Observable<ProfilResultModel> getObservable(){
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getProfil("Bearer " + GlobalVariable.TOKEN, this.user_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ProfilResultModel> getObserver() {
        return new DisposableObserver<ProfilResultModel>() {

            @Override
            public void onNext(ProfilResultModel profilResultModel) {
                iProfilView.display(profilResultModel);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                iProfilView.displayError("Error fetching Profil User");
            }

            @Override
            public void onComplete() {
                Log.d("tag", "Complete");
            }
        };
    }
}
