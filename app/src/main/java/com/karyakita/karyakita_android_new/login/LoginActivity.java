package com.karyakita.karyakita_android_new.login;

import android.content.Intent;
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
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.customer.home.HomeCustomerActivity;
import com.karyakita.karyakita_android_new.desainer.home.HomeDesainerActivity;
import com.karyakita.karyakita_android_new.login_as.LoginAsActivity;
import com.karyakita.karyakita_android_new.register_as.RegisterAsActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    LoginPresenter loginPresenter;
    Integer role_id;

    @BindView(R.id.addAkun)
    TextView addAkun;
    @BindView(R.id.et_username_login)
    EditText et_Username_login;
    @BindView(R.id.et_password_login)
    EditText et_Password_login;
    @BindView(R.id.bt_masuk)
    Button bt_masuk;

    Realm realm;
    LoginHelper loginHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        role_id = bundle.getInt("role_id");

        Realm.init(LoginActivity.this);
        RealmConfiguration configuration = new RealmConfiguration
                .Builder()
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(configuration);

        bt_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpPresenter();

            }
        });

        addAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(LoginActivity.this, RegisterAsActivity.class);
                startActivity(intent);
            }
        });

        bt_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpPresenter();
                if (et_Username_login.getText().toString().length() == 0) {
                    et_Username_login.setError("Email tidak boleh kosong");
                } else if (et_Password_login.getText().toString().length() == 0) {
                    et_Password_login.setError("Password tidak boleh kosong");
                } else {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void display(LoginResultModel model) {
        GlobalVariable.TOKEN = model.getToken();
        Log.i("Test", model.getToken());

        if (model.getData().getRole_id() == 3) {
            finish();
            LoginAsActivity.loginAs.finish();
            startActivity(new Intent(LoginActivity.this, HomeCustomerActivity.class));
        } else if (model.getData().getRole_id() == 2) {
            finish();
            LoginAsActivity.loginAs.finish();
            startActivity(new Intent(LoginActivity.this, HomeDesainerActivity.class));
        }
        loginHelper = new LoginHelper(realm);

        loginHelper.save(new SessionModel(
                model.getData().getCreatedAt(),
                model.getData().getUpdatedAt(),
                model.getData().getId(),
                model.getData().getEmail(),
                model.getData().getUsername(),
                model.getData().getNama(),
                null,
                model.getData().getRole_id()
        ));
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
