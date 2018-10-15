package com.karyakita.karyakita_android_new.customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.home.HomeCustomerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PesananSelesai extends AppCompatActivity {
    @BindView(R.id.buttonpesanselesai)
    Button bt_pesananselesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_selesai);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bt_pesananselesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PesananSelesai.this, HomeCustomerActivity.class);
                startActivity(intent);
            }
        });
    }
}
