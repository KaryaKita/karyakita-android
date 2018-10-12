package com.karyakita.karyakita_android_new.customer.transaksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.PesananSelesai;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.example.MovieResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataPengirimanCustomerActivity extends AppCompatActivity implements ITestView {
    @BindView(R.id.id_pesanan)
    Button bt_id_pesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pengiriman_customer);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bt_id_pesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataPengirimanCustomerActivity.this, PesananSelesai.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(MovieResponse model) {

    }

    @Override
    public void displayError(String s) {

    }
}
