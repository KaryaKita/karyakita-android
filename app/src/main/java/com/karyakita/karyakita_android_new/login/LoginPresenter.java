package com.karyakita.karyakita_android_new.login;

import android.content.Context;
import android.util.Log;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.IMainPresenter;
import com.karyakita.karyakita_android_new.service.IRestServices;
import com.karyakita.karyakita_android_new.service.RetrofitHelper;
import com.karyakita.karyakita_android_new.sessions.SessionSharedPreferences;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements IMainPresenter {
    private ILoginView iLoginView;
    private Map<String, String> input;
    private Context context;

    public LoginPresenter(ILoginView iLoginView, Context context) {
        this.iLoginView = iLoginView;
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

    public Observable<LoginResultModel> getObservable() {
        return RetrofitHelper.getRetrofit().create(IRestServices.class)
                .login(this.input.get("email"),
                        this.input.get("password"),
                        Integer.parseInt(this.input.get("role_id")))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<LoginResultModel> getObserver() {
        return new DisposableObserver<LoginResultModel>() {

            @Override
            public void onNext(@NonNull LoginResultModel loginResultModel) {
                setSessionLogin(loginResultModel);
                iLoginView.display(loginResultModel);
                iLoginView.showToast(loginResultModel.getMessage());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                iLoginView.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("TAG", "Completed");
            }
        };
    }

    public void setSessionLogin(LoginResultModel loginResultModel) {
        SessionSharedPreferences.setLoggedIn(this.context, true, loginResultModel);
    }
}
