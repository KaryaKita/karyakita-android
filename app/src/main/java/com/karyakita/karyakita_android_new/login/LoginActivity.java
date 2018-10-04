package com.karyakita.karyakita_android_new.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.widget.EditText;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.example.MovieResponse;
import com.karyakita.karyakita_android_new.example.ITestView;

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
    }
}
