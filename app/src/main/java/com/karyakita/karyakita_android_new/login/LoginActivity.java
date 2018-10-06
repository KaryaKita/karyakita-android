package com.karyakita.karyakita_android_new.login;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.home.HomeCustomerActivity;
import com.karyakita.karyakita_android_new.example.MovieResponse;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.register.RegisterActivity;
import com.karyakita.karyakita_android_new.register_as.RegisterAsActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    LoginPresenter loginPresenter = null;
    LoginModel loginModel = null;
    Integer role_id;

    @BindView(R.id.et_Username_login)
    EditText et_Username_login;
    @BindView(R.id.et_Password_login)
    EditText et_Password_login;
    @BindView(R.id.button1)
    Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        role_id = bundle.getInt("role_id");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpPresenter();
            }
        });


    }

    @Override
    public void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

        startActivity(new Intent(LoginActivity.this, HomeCustomerActivity.class));
    }

    @Override
    public void display(LoginResultModel model) {
        Log.d("Result", model.getToken());
    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void setUpPresenter() {
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("email", et_Username_login.getText().toString());
        inputan.put("password", et_Password_login.getText().toString());
        inputan.put("role_id", role_id.toString());
        loginPresenter = new LoginPresenter(this);
        loginPresenter.insert(inputan);
    }
}
