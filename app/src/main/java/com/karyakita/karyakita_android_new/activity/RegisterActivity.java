package com.karyakita.karyakita_android_new.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.model.MovieResponse;
import com.karyakita.karyakita_android_new.model.RegisterModel;
import com.karyakita.karyakita_android_new.presenter.RegisterPresenter;
import com.karyakita.karyakita_android_new.view.ITestView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements ITestView{
    RegisterPresenter registerPresenter = null;
    RegisterModel registerModel = null;
    @BindView(R.id.textViewNama) EditText textViewNama;
    @BindView(R.id.textViewEmail) EditText textViewEmail;
    @BindView(R.id.textViewPassword) EditText textViewPassword;
    @BindView(R.id.textViewKonfirPassword) EditText textViewKonfirPassword;
    @BindView(R.id.textViewUsername) EditText textViewUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        setupPresenter();
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

    private void setupPresenter(){
        registerPresenter = new RegisterPresenter(this);
        registerPresenter.insert(textViewNama.getText(), textViewUsername.getText(), textViewEmail.getText(), textViewPassword.getText(), textViewKonfirPassword.getText());
    }
}
