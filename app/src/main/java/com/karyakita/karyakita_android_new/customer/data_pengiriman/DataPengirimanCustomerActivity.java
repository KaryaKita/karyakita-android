package com.karyakita.karyakita_android_new.customer.data_pengiriman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.PesananSelesai;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataPengirimanCustomerActivity extends AppCompatActivity implements IDataPengirimanView {
    @BindView(R.id.btnPesan)
    Button bt_id_pesanan;
    @BindView(R.id.sp_prov)
    Spinner prov;
    @BindView(R.id.sp_kab)
    Spinner kab;
    @BindView(R.id.sp_kec)
    Spinner kec;
    @BindView(R.id.sp_alamat)
    EditText alamat;
    @BindView(R.id.sp_opsipengiriman)
    Spinner opsipengiriman;


    DataPengirimanPresenter dataPengirimanPresenter = null;
    DataPengirimanModel dataPengirimanModel = null;

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
    public void display(DataPengirimanResultModel model) {

    }

    @Override
    public void displayError(String s) {
    }

    private void setupPresenter() {
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("provinsi", prov.toString());
        inputan.put("kabupaten", kab.toString());
        inputan.put("kecamatan", kec.toString());
        inputan.put("alamat", alamat.toString());
        inputan.put("opsipengiriman", opsipengiriman.toString());

        dataPengirimanPresenter = new DataPengirimanPresenter(this);
        dataPengirimanPresenter.insert(inputan);
    }
}
