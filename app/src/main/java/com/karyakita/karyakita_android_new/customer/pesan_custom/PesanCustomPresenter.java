package com.karyakita.karyakita_android_new.customer.pesan_custom;

import android.util.Log;
import android.widget.Button;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;

import java.util.Map;

import butterknife.BindView;
import io.reactivex.observers.DisposableObserver;

public class PesanCustomPresenter implements IMainPresenter {

    IPesanCustomView iPesanCustomView;
    BaseModel model;
    PesanCustomModel pesanCustomModel = null;
    Map<String, String>input;
    Integer karya_id = null;

    public PesanCustomPresenter(IPesanCustomView iPesanCustomView){
        this.iPesanCustomView = iPesanCustomView;
    }

    @Override
    public void get(Map<String, String> dataInput) {

    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {
//        this.karya_id = Integer.parseInt(dataInput.get("karya_id"));

    }

//    public io.reactivex.Observable<PesanCustomResultModel> getObservable(){
//        return RetrofitHelper.getRetrofit().create(IRestServices.class)
//                .pesan_custom(this.input.get("id"),
//                        this.input.get("image"),
//                        this.input.get"pilih_ukuran"));
////    }(

    public DisposableObserver<PesanCustomResultModel>getObserver(){
        return new DisposableObserver<PesanCustomResultModel>() {
            @Override
            public void onNext(PesanCustomResultModel pesanCustomResultModel) {
                iPesanCustomView.display(pesanCustomResultModel);
                Log.d("tag","success");
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
