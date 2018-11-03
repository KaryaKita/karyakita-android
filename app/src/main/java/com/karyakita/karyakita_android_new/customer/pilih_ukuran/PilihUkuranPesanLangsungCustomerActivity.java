package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanCustomerActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PilihUkuranPesanLangsungCustomerActivity extends AppCompatActivity implements IPilihUkuranPesanLangsungView{
    PilihUkuranPesanLangsungPresenter pilihUkuranPesanLangsungPresenter = null;
    PilihUkuranPesanLangsungModel pilihUkuranPesanLangsungModel = null;

    @BindView(R.id.sp_ukuran_kertas)
    Spinner ukuran_kertas;
    @BindView(R.id.sp_ukuran_bingkai)
    Spinner ukuran_bingkai;
    @BindView(R.id.bt_konfimasi)
    Button konfirmasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_ukuran_pesan_langsung_customer);
        ButterKnife.bind(this);
        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupPresenter();
                Toast.makeText(getApplicationContext(), "Konfirmasi", Toast.LENGTH_SHORT).show();

                finish();
                Intent intent = new Intent(PilihUkuranPesanLangsungCustomerActivity.this, DataPengirimanCustomerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(PilihUkuranPesanLangsungModel model) {

    }

    @Override
    public void displayError(String s) {

    }

    private void setupPresenter(){
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("ukuran_kertas", ukuran_kertas.toString());
        inputan.put("ukuran_bingkai", ukuran_bingkai.toString());

        pilihUkuranPesanLangsungPresenter = new PilihUkuranPesanLangsungPresenter(this);
        pilihUkuranPesanLangsungPresenter.insert(inputan);
    }
}
