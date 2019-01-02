package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanCustomerActivity;
import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;

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

    String dg_pigora, tp_pigora, ukuran_kertas, jenis_kertas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_ukuran_customer);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        karya_id = bundle.getInt("karya_id");
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
                ukuran_kertas = sp_ukuran_kertas.getSelectedItem().toString();
                jenis_kertas = sp_jenis_kertas.getSelectedItem().toString();

                int selectedId = rd_pilih_opsi.getCheckedRadioButtonId();

                if (selectedId == rd_dg_pigora.getId()) {
                    dg_pigora = rd_dg_pigora.getText().toString();
                }
                if (selectedId == rd_tp_pigora.getId()) {
                    tp_pigora = rd_tp_pigora.getText().toString();
                }


                if (!ukuran_kertas.equals("") && !jenis_kertas.equals("") && !rd_tp_pigora.equals("") && !rd_dg_pigora.equals("") && !rd_pilih_opsi.equals("")) {
                    pilihUkuranModelRealm = new PilihUkuranModelRealm();
                    pilihUkuranModelRealm.setSp_ukuran_kertas(ukuran_kertas);
                    pilihUkuranModelRealm.setSp_jenis_kertas(jenis_kertas);

                    pilihUkuranHelperRealm = new PilihUkuranHelperRealm(realm);
                    pilihUkuranHelperRealm.save(pilihUkuranModelRealm);

                    setupPresenter();
                    Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(PilihUkuranActivity.this, DataPengirimanCustomerActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "isidong", Toast.LENGTH_LONG);
                }

            }
        });
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(PilihUkuranModel model) {

    }

    @Override
    public void displayError(String s) {

    }

    private void setupPresenter() {
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("karya_id", karya_id.toString());
        inputan.put("sp_ukuran_kertas", sp_ukuran_kertas.getSelectedItem().toString());
        inputan.put("rd_dg_pigora", rd_dg_pigora.toString());
        inputan.put("rd_tp_pigora", rd_tp_pigora.toString());

        pilihUkuranPresenter = new PilihUkuranPresenter(this);
        pilihUkuranPresenter.insert(inputan);
    }
}
