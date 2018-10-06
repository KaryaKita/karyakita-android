package com.karyakita.karyakita_android_new.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.karyakita.karyakita_android_new.R;

public class LoginAsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);

        Button bLoginCustomer = (Button) findViewById(R.id.bt_login_customer);
        Button bLoginDesigner = (Button) findViewById(R.id.bt_login_designer);

        bLoginCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("role_id", 3);
                Intent intent =  new Intent(LoginAsActivity.this, LoginActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        bLoginDesigner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("role_id", 2);
                Intent intent =  new Intent(LoginAsActivity.this, LoginActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
