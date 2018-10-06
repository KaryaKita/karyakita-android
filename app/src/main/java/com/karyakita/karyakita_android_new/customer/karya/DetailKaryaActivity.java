package com.karyakita.karyakita_android_new.customer.karya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.transaksi.DataPengirimanCustomerActivity;
import com.karyakita.karyakita_android_new.customer.transaksi.PesanCustomActivity;
import com.karyakita.karyakita_android_new.example.MovieResponse;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.login.LoginActivity;
import com.karyakita.karyakita_android_new.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailKaryaActivity extends AppCompatActivity implements ITestView{

    @BindView(R.id.btnKirimPesan)
    Button btnKirimPesan;
    @BindView(R.id.btnPesanCustom)
    Button btnPesanCustom;
    @BindView(R.id.btnPesanSekarang)
    Button btnPesanSekarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_karya);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnKirimPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailKaryaActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnPesanCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailKaryaActivity.this, PesanCustomActivity.class);
                startActivity(intent);
            }
        });

        btnPesanSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailKaryaActivity.this, DataPengirimanCustomerActivity.class);
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
