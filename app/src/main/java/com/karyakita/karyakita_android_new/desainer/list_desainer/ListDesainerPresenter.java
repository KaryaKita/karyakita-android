package com.karyakita.karyakita_android_new.desainer.list_desainer;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaResultModel;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.List;
import java.util.Map;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class ListDesainerPresenter implements IMainPresenter{
    IListDesainerView iListDesainerView;
    BaseModel model = null;
    ListDesainerModel listDesainerModel = null;
    Map<String, String> input;

    public ListDesainerPresenter(IListDesainerView iListDesainerView) {
        this.iListDesainerView = iListDesainerView;
    }

    @Override
    public void get(Map<String, String> dataInput) {
        getObservable().subscribeWith(getObserver());
    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {

    }

    public io.reactivex.Observable<ListDesainerResultModel> getObservable() {
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getListDesainer("Bearer" + GlobalVariable.TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public DisposableObserver<ListDesainerResultModel> getObserver() {
        return new DisposableObserver<ListDesainerResultModel>() {

            @Override
            public void onNext(@NonNull ListDesainerResultModel listDesainerResultModel) {
                Log.d(TAG, "OnNext" + listDesainerResultModel.getData().get(0).getNama());
                iListDesainerView.display(listDesainerResultModel);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error" + e);
                e.printStackTrace();
                iListDesainerView.displayError("Error fetching Desainer List");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}
