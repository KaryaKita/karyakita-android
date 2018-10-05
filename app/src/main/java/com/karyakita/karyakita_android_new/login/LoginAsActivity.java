package com.karyakita.karyakita_android_new.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.karyakita.karyakita_android_new.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginAsActivity extends AppCompatActivity implements ILoginView {
    @BindView(R.id.btLoginCustomer) Button btLoginCustomer;
    @BindView(R.id.btLoginDesigner) Button btLoginDesigner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btLoginCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setUpPresenter();
            }
        });

        btLoginDesigner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setUpPresenter();
            }
        });
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(LoginResultModel model) {

    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
