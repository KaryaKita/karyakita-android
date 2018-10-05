package com.karyakita.karyakita_android_new.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.example.MovieResponse;
import com.karyakita.karyakita_android_new.login.LoginActivity;

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
    Integer role_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        final Bundle bundle = getIntent().getExtras();
        role_id = bundle.getInt("role_id");
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupPresenter();
                Toast.makeText(getApplicationContext(), "Daftar Sukses", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
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
        inputan.put("role_id", role_id.toString());

        registerPresenter = new RegisterPresenter(this);
        registerPresenter.insert(inputan);
    }
}
