package com.karyakita.karyakita_android_new.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.login.LoginActivity;
import com.karyakita.karyakita_android_new.login_as.LoginAsActivity;
import com.karyakita.karyakita_android_new.register_as.RegisterAsActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {
    RegisterPresenter registerPresenter = null;
    RegisterModel registerModel = null;

    @BindView(R.id.masukAkun)
    TextView masukAkun;
    @BindView(R.id.et_nama_lengkap_register)
    EditText et_nama_lengkap_register;
    @BindView(R.id.et_email_register)
    EditText et_email_register;
    @BindView(R.id.et_password_register)
    EditText et_password_register;
    @BindView(R.id.et_password_conf_register)
    EditText et_password_conf_register;
    @BindView(R.id.et_username_register)
    EditText et_username_register;
    @BindView(R.id.buttonRegister)
    Button buttonRegister;
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

                finish();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        masukAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginAsActivity.class);
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

    private void setupPresenter() {
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("nama", et_nama_lengkap_register.getText().toString());
        inputan.put("email", et_email_register.getText().toString());
        inputan.put("password", et_password_register.getText().toString());
        inputan.put("konfirpassword", et_password_conf_register.getText().toString());
        inputan.put("username", et_username_register.getText().toString());
        inputan.put("role_id", role_id.toString());

        registerPresenter = new RegisterPresenter(this);
        registerPresenter.insert(inputan);
    }
}
