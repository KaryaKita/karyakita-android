package com.karyakita.karyakita_android_new.customer.karya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.karyakita.karyakita_android_new.MustLoginRegisterActivity;
import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanCustomerActivity;
import com.karyakita.karyakita_android_new.customer.pesan_custom.PesanCustomActivity;

import com.karyakita.karyakita_android_new.customer.pilih_ukuran.PilihUkuranActivity;

import com.karyakita.karyakita_android_new.login.LoginActivity;
import com.karyakita.karyakita_android_new.login_as.LoginAsActivity;
import com.karyakita.karyakita_android_new.sessions.SessionSharedPreferences;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailKaryaActivity extends AppCompatActivity implements IDetailKaryaView {
    DetailKaryaPresenter detailKaryaPresenter = null;
    DetailKaryaModel detailKaryaModel = null;
    Integer karya_id;
    Context context;

//    private String TAG = "DetailKaryaActivity";

    @BindView(R.id.btnKirimPesan)
    Button btnKirimPesan;
    @BindView(R.id.btnPesanCustom)
    Button btnPesanCustom;
    @BindView(R.id.btnPesanSekarang)
    Button btnPesanSekarang;
    @BindView(R.id.iv_karya)
    ImageView imageKarya;
    @BindView(R.id.tv_hargaKarya)
    TextView hargakarya;
    @BindView(R.id.tv_katkarya)
    TextView katkarya;
    @BindView(R.id.tv_namakar)
    TextView namakarya;
    @BindView(R.id.tv_deskripsi)
    TextView deskripsikarya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_karya);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        karya_id = bundle.getInt("karya_id");

        setUpPresenter();
        getDetailKarya();


        btnPesanCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(SessionSharedPreferences.getLoggedStatus(getApplicationContext())){
                    intent = new Intent(DetailKaryaActivity.this, PesanCustomActivity.class);
                } else {
                    intent = new Intent(DetailKaryaActivity.this, MustLoginRegisterActivity.class);
                }
                startActivity(intent);
            }
        });

        btnPesanSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(SessionSharedPreferences.getLoggedStatus(getApplicationContext())){
                    intent = new Intent(DetailKaryaActivity.this, PilihUkuranActivity.class);
                } else {
                    intent = new Intent(DetailKaryaActivity.this, MustLoginRegisterActivity.class);
                }

                Bundle bundle = new Bundle();
                bundle.putInt("karya_id", karya_id);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    private void getDetailKarya() {
        Map<String, String> dataInput = new HashMap<>();
        dataInput.put("karya_id", karya_id.toString());
        detailKaryaPresenter.get(dataInput);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        startActivity(new Intent(DetailKaryaActivity.this, DataPengirimanCustomerActivity.class));
    }

    @Override
    public void display(DetailKaryaResultModel detailKaryaResultModel) {
        Glide.with(getApplicationContext()).load(detailKaryaResultModel.getData().getDeploy_url()).into(imageKarya);
        katkarya.setText("#Art #Vector");
        namakarya.setText(detailKaryaResultModel.getData().getNama());
        deskripsikarya.setText(detailKaryaResultModel.getData().getDeskripsi());
    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    private void setUpPresenter() {
        detailKaryaPresenter = new DetailKaryaPresenter(this);
    }
}
