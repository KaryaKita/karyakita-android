package com.karyakita.karyakita_android_new.customer.data_pengiriman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
    @BindView(R.id.ed_kodepos)
    EditText ed_kodepos;
    Integer order_id;

    DataPengirimanPresenter dataPengirimanPresenter = null;
    DataPengirimanModel dataPengirimanModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pengiriman_customer);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        order_id = bundle.getInt("order_id");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bt_id_pesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alamat.getText().toString().length() == 0) {
                    alamat.setError("Alamat tidak boleh kosong");
                } else if (ed_kodepos.getText().toString().length() == 0) {
                    ed_kodepos.setError("Kode Pos tidak boleh kosong");
                } else {
                    setupPresenter();
                }
            }
        });
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(DataPengirimanResultModel model) {
        Intent intent = new Intent(DataPengirimanCustomerActivity.this, PesananSelesai.class);
        startActivity(intent);
    }

    @Override
    public void displayError(String s) {
    }

    public void setupPresenter() {
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("via", opsipengiriman.getSelectedItem().toString());
        inputan.put("kecamatan", kec.getSelectedItem().toString());
        inputan.put("kota_kab", kab.getSelectedItem().toString());
        inputan.put("provinsi", prov.getSelectedItem().toString());
        inputan.put("alamat_lengkap", alamat.getText().toString());
        inputan.put("kode_pos", ed_kodepos.getText().toString());
        inputan.put("order_id", order_id.toString());

        dataPengirimanPresenter = new DataPengirimanPresenter(this, getApplicationContext());
        dataPengirimanPresenter.insert(inputan);
    }
}
