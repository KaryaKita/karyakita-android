package com.karyakita.karyakita_android_new.customer.pesan_custom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.PesananSelesai;
import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanCustomerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PesanCustomActivity extends AppCompatActivity {

    Spinner spinner;
    @BindView(R.id.btnLanjut) Button btnLanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_custom);
        ButterKnife.bind(this);

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PesanCustomActivity.this, DataPengirimanCustomerActivity.class));
            }
        });
    }
}
