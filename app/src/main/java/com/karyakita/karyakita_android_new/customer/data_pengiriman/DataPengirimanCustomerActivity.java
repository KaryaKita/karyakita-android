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
    @BindView(R.id.ed_resi)
    EditText ed_resi;
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
                Intent intent = new Intent(DataPengirimanCustomerActivity.this, PesananSelesai.class);
                startActivity(intent);
                setupPresenter();
            }
        });
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(DataPengirimanResultModel model) {
        Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(DataPengirimanCustomerActivity.this, PesananSelesai.class);
        startActivity(intent);
    }

    @Override
    public void displayError(String s) {
    }

    private void setupPresenter() {
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("order_id", order_id.toString());
        inputan.put("via", opsipengiriman.toString());
        inputan.put("resi", ed_resi.toString());
        inputan.put("kecamatan", kec.toString());
        inputan.put("kota_kab", kab.toString());
        inputan.put("provinsi", prov.toString());
        inputan.put("alamat_lengkap", alamat.toString());
        inputan.put("kode_pos", ed_kodepos.toString());

        dataPengirimanPresenter = new DataPengirimanPresenter(this);
        dataPengirimanPresenter.insert(inputan);
    }
}
