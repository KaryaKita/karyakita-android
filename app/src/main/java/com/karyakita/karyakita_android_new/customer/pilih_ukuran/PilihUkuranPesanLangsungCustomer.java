package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.PesananSelesai;
import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanCustomerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PilihUkuranPesanLangsungCustomer extends AppCompatActivity {

    @BindView(R.id.btnLanjut) Button btnLanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_ukuran_pesan_langsung_customer);
        ButterKnife.bind(this);

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PilihUkuranPesanLangsungCustomer.this, DataPengirimanCustomerActivity.class));

            }
        });
    }
}
