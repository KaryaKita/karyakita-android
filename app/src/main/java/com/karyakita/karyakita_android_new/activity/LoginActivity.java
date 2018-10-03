package com.karyakita.karyakita_android_new.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.model.LoginModel;
import com.karyakita.karyakita_android_new.model.MovieResponse;
import com.karyakita.karyakita_android_new.presenter.LoginPresenter;
import com.karyakita.karyakita_android_new.view.ITestView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ITestView{
    LoginPresenter loginPresenter = null;
    LoginModel loginModel = null;

    @BindView(R.id.et_Username_login) EditText et_Username_login;
    @BindView(R.id.et_Password_login) EditText et_Password_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);
        ButterKnife.bind(this);

        setUpPresenter();
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(MovieResponse model) {

    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void setUpPresenter(){
        loginPresenter = new LoginPresenter(this);
        loginPresenter.insert(loginModel);
    }
}
