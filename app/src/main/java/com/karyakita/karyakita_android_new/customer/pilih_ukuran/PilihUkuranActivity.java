package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanCustomerActivity;
import com.karyakita.karyakita_android_new.customer.pesan_langsung.PesanLangsungResultModel;
import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;
import com.karyakita.karyakita_android_new.login_as.LoginAsActivity;
import com.karyakita.karyakita_android_new.sessions.SessionSharedPreferences;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class PilihUkuranActivity extends AppCompatActivity implements IPilihUkuranView {
    PilihUkuranPresenter pilihUkuranPresenter = null;
    PilihUkuranModel pilihUkuranModel = null;
    Realm realm;
    RealmHelper realmHelper;
    PilihUkuranHelperRealm pilihUkuranHelperRealm;
    PilihUkuranModelRealm pilihUkuranModelRealm;
    @BindView(R.id.rd_pilih_opsi)
    RadioGroup rd_pilih_opsi;
    @BindView(R.id.rd_dg_pigora)
    RadioButton rd_dg_pigora;
    @BindView(R.id.rd_tp_pigora)
    RadioButton rd_tp_pigora;
    @BindView(R.id.sp_ukuran_kertas)
    Spinner sp_ukuran_kertas;
    @BindView(R.id.sp_jenis_kertas)
    Spinner sp_jenis_kertas;
    @BindView(R.id.btnLanjut)
    Button konfirmasi;
    Integer karya_id;
    Integer order_id;
    Intent intent;

    String dg_pigora, tp_pigora, ukuran_kertas, jenis_kertas;
    Integer opsi_order, pelanggan_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_ukuran_customer);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        karya_id = bundle.getInt("karya_id");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pesan Langsung");

//        setupPresenter();

        Realm.init(PilihUkuranActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rd_pilih_opsi.getCheckedRadioButtonId();

                if (selectedId == rd_dg_pigora.getId()) {
                    opsi_order = 1;
                }
                if (selectedId == rd_tp_pigora.getId()) {
                    opsi_order = 2;
                }
                ukuran_kertas = sp_ukuran_kertas.getSelectedItem().toString();
                jenis_kertas = sp_jenis_kertas.getSelectedItem().toString();

                setupPresenter();
            }
        });
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(PesanLangsungResultModel model) {

        order_id = model.getOrderModel().getId();
        Bundle bundle = new Bundle();
        bundle.putInt("order_id", order_id);
        Intent intent = new Intent(PilihUkuranActivity.this, DataPengirimanCustomerActivity.class);;
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void displayError(String s) {

    }

    private void setupPresenter() {
        pelanggan_id = SessionSharedPreferences.getUserId(getApplicationContext());

        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("karya_id", karya_id.toString());
        inputan.put("catatan", "");
        inputan.put("tanggal_deadline", "2019-01-01");
        inputan.put("pelanggan_id", pelanggan_id.toString());
        inputan.put("opsi_order_id", opsi_order.toString());
        inputan.put("ukuran", ukuran_kertas);

        pilihUkuranPresenter = new PilihUkuranPresenter(this, getApplicationContext());
        pilihUkuranPresenter.insert(inputan);
    }
}
