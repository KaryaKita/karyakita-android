package com.karyakita.karyakita_android_new.customer.pesan_custom;

import android.content.Context;
import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.service.ICustomerRestServices;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import com.karyakita.karyakita_android_new.sessions.PreferencesUtility;
import com.karyakita.karyakita_android_new.sessions.SessionSharedPreferences;

import java.io.File;
import java.util.Map;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

public class PesanCustomPresenter implements IMainPresenter {

    IPesanCustomView iPesanCustomView;
    BaseModel model;
    PesanCustomModel pesanCustomModel = null;
    Map<String, String> input;
    Integer karya_id = null;
    Context context;

    MultipartBody.Part imageFile;

    public PesanCustomPresenter(IPesanCustomView iPesanCustomView, Context context) {
        this.iPesanCustomView = iPesanCustomView;
        this.context = context;
    }

    @Override
    public void get(Map<String, String> dataInput) {

    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {
        this.input = dataInput;
        getObservable().subscribeWith(getObserver());
    }

    public void setImagePesanCustom( MultipartBody.Part file) {
        this.imageFile = file;
    }

    public io.reactivex.Observable<PesanCustomResultModel> getObservable(){
        Log.d("tag", "masuk ovservable");
        return RetrofitHelper.getRetrofit().create(ICustomerRestServices.class)
                .pesan_custom(
                        SessionSharedPreferences.getToken(this.context),
                        this.input.get("catatan"),
                        this.input.get("tanggal_deadline"),
                        Integer.parseInt(this.input.get("kategori_karya")),
                        Integer.parseInt(this.input.get("opsi_order_id")),
                        this.input.get("ukuran"),
                        this.imageFile
                        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<PesanCustomResultModel> getObserver() {
        return new DisposableObserver<PesanCustomResultModel>() {
            @Override
            public void onNext(PesanCustomResultModel pesanCustomResultModel) {
                iPesanCustomView.display(pesanCustomResultModel);
                Log.d("tag", "success");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("tag", "Error" + e);
                e.printStackTrace();
                iPesanCustomView.displayError("error fetching movie data");
            }

            @Override
            public void onComplete() {
                Log.d("tag", "completed");
            }
        };
    }
}
