package com.karyakita.karyakita_android_new.register_as;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.login_as.LoginAsActivity;
import com.karyakita.karyakita_android_new.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterAsActivity extends AppCompatActivity {

    @BindView(R.id.masukAkun)
    TextView masukAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as);
        ButterKnife.bind(this);


        Button btRegisCustomer = (Button) findViewById(R.id.bt_regis_customer);
        Button btRegisDesainer = (Button) findViewById(R.id.bt_regis_desainer);

        btRegisCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("role_id", 3);
                Intent intent = new Intent(RegisterAsActivity.this, RegisterActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btRegisDesainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("role_id", 2);
                Intent intent = new Intent(RegisterAsActivity.this, RegisterActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        masukAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterAsActivity.this, LoginAsActivity.class));
            }
        });
    }
}
