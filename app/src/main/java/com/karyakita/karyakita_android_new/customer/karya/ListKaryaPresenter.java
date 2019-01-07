package com.karyakita.karyakita_android_new.customer.karya;

import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class ListKaryaPresenter implements IMainPresenter {
    IListKaryaView iListKaryaView;
    BaseModel model = null;
    ListKaryaModel listKaryaModel = null;
    Map<String, String> input = null;

    public ListKaryaPresenter(IListKaryaView iListKaryaView) {
        this.iListKaryaView = iListKaryaView;
    }

    @Override
    public void get(Map<String, String> dataInput) {
        this.input = dataInput;
        getObservable().subscribeWith(getObserver());
    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {
    }

    public Observable<ListKaryaResultModel> getObservable() {
        if (this.input == null || this.input.get("kategori_id") == null || this.input.get("kategori_id") == "") {
            return RetrofitHelper.getRetrofit().create(IRestServices.class)
                    .getListKarya()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .getListKaryaByKategori(Integer.parseInt(this.input.get("kategori_id")))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ListKaryaResultModel> getObserver() {
        return new DisposableObserver<ListKaryaResultModel>() {

            @Override
            public void onNext(@NonNull ListKaryaResultModel listKaryaResultModel) {
                iListKaryaView.display(listKaryaResultModel);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                iListKaryaView.displayError("Error fetching List Karya");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}
