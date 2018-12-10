package com.karyakita.karyakita_android_new.login;

import android.app.Activity;
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
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaActivity;
import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;
import com.karyakita.karyakita_android_new.desainer.home.HomeDesainerActivity;
import com.karyakita.karyakita_android_new.desainer.pesanan_saya.PesananSayaDesainerActivity;
import com.karyakita.karyakita_android_new.example.MainActivity;
import com.karyakita.karyakita_android_new.example.TestActivity;
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

    @BindView(R.id.et_username_login)
    EditText et_Username_login;
    @BindView(R.id.et_password_login)
    EditText et_Password_login;
    @BindView(R.id.bt_masuk)
    Button bt_masuk;
    @BindView(R.id.addAkun)
    TextView addAkun;

    Realm realm;
    RealmHelper realmHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        role_id = bundle.getInt("role_id");
        Log.d("Test0 : ", GlobalVariable.TOKEN);

        Realm.init(LoginActivity.this);
        RealmConfiguration configuration = new RealmConfiguration
                .Builder()
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

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
                startActivity(new Intent(LoginActivity.this, RegisterAsActivity.class));
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
        Log.i("Test", model.getToken() );

        if(model.getData().getRole_id() == 3) {
            finish();
            LoginAsActivity.loginAs.finish();
            startActivity(new Intent(LoginActivity.this, HomeCustomerActivity.class));
        }
        if(model.getData().getRole_id() == 2) {
            finish();
            LoginAsActivity.loginAs.finish();
            startActivity(new Intent(LoginActivity.this, HomeDesainerActivity.class));
        }
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
