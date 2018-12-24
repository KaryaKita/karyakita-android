package com.karyakita.karyakita_android_new.login_as;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.login.LoginActivity;
import com.karyakita.karyakita_android_new.register_as.RegisterAsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginAsActivity extends AppCompatActivity {
    public static Activity loginAs;

    @BindView(R.id.addAkun)
    TextView addAkun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);
        loginAs = this;
        ButterKnife.bind(this);

        Button bLoginCustomer = findViewById(R.id.bt_login_customer);
        Button bLoginDesigner = findViewById(R.id.bt_login_designer);

        bLoginCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("role_id", 3);
                Intent intent = new Intent(LoginAsActivity.this, LoginActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        bLoginDesigner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("role_id", 2);
                Intent intent = new Intent(LoginAsActivity.this, LoginActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        addAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LoginAsActivity.this, RegisterAsActivity.class));
            }
        });
    }

}
