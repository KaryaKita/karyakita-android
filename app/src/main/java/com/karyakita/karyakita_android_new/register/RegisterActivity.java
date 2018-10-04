package com.karyakita.karyakita_android_new.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.example.MovieResponse;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {
    RegisterPresenter registerPresenter = null;
    RegisterModel registerModel = null;
    @BindView(R.id.textViewNama) EditText textViewNama;
    @BindView(R.id.textViewEmail) EditText textViewEmail;
    @BindView(R.id.textViewPassword) EditText textViewPassword;
    @BindView(R.id.textViewKonfirPassword) EditText textViewKonfirPassword;
    @BindView(R.id.textViewUsername) EditText textViewUsername;
    @BindView(R.id.buttonRegister) Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), " joosss", Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(RegisterResultModel model) {

    }

    @Override
    public void displayError(String s) {

    }

    private void setupPresenter(){
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("nama", textViewNama.getText().toString());
        inputan.put("email", textViewEmail.getText().toString());
        inputan.put("password", textViewPassword.getText().toString());
        inputan.put("konfirpassword", textViewKonfirPassword.getText().toString());
        inputan.put("username", textViewUsername.getText().toString());
        registerPresenter = new RegisterPresenter(this);
        registerPresenter.insert(inputan);
    }
}
