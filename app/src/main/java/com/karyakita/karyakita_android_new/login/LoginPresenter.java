package com.karyakita.karyakita_android_new.login;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainPresenter;
import com.karyakita.karyakita_android_new.example.MovieResponse;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import com.karyakita.karyakita_android_new.example.ITestView;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class LoginPresenter implements IMainPresenter{
    ILoginView iLoginView;
    BaseModel model = null;
    LoginModel loginModel = null;
    Map<String, String> input;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
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
        getObservable().subscribeWith(getObserver());
    }

    public Observable<LoginResultModel> getObservable() {
        Log.d(TAG   , "Berhasil joss");
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .login(this.input.get("email"),
                        this.input.get("password"),
                        Integer.parseInt(this.input.get("role_id")))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<LoginResultModel> getObserver(){
        return new DisposableObserver<LoginResultModel>() {

            @Override
            public void onNext(@NonNull LoginResultModel loginResultModel) {
                iLoginView.display(loginResultModel);
                iLoginView.showToast(loginResultModel.getMessage());
                Log.d(TAG, "Success");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                iLoginView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}
