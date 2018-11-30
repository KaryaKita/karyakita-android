package com.karyakita.karyakita_android_new.customer.pesan_custom;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.service.IRestServices;

import butterknife.BindView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.PesananSelesai;
import com.karyakita.karyakita_android_new.customer.data_pengiriman.DataPengirimanCustomerActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class PesanCustomActivity extends AppCompatActivity {
    Realm realm;
    PesanCustomRealmHelper pesanCustomRealmHelper;
    PesanCustomModelRealm pesanCustomModelRealm;
    Spinner spinner;
    @BindView(R.id.iv_img_custom) ImageView img_custom;
    @BindView(R.id.sp_pilih_kategori) Spinner pilih_kategori;
    @BindView(R.id.sp_pilih_ukuran) Spinner ukuran_kertas;
    @BindView(R.id.Calendar) Spinner calendar;
    @BindView(R.id.ed_catatan) EditText ed_catatan;
    @BindView(R.id.btnLanjut) Button btnLanjut;

    String ukuran, calender, catatan;
    Integer kategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_custom);
        ButterKnife.bind(this);
        Realm.init(PesanCustomActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
//        RxImagePicker.with(this).requestImage(Sources.GALLERY)

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setupPresenter();

                kategori = 1;
                ukuran   = ukuran_kertas.getSelectedItem().toString();
                calender = calendar.toString();
                catatan  = ed_catatan.getText().toString();

                if (!kategori.equals("")&&!ukuran.equals("")&&!calender.equals("")&&!catatan.equals((""))){
                    pesanCustomModelRealm = new PesanCustomModelRealm();
                    pesanCustomModelRealm.setKategori_id(kategori);
                    pesanCustomModelRealm.setUkuran_karya(ukuran);
                    pesanCustomModelRealm.setDeadline(calender);
                    pesanCustomModelRealm.setCatatan(catatan);

                    pesanCustomRealmHelper = new PesanCustomRealmHelper(realm);
                    pesanCustomRealmHelper.save(pesanCustomModelRealm);

                    Log.d("TAG", "sukses masuk dong");

                    startActivity(new Intent(PesanCustomActivity.this, DataPengirimanCustomerActivity.class));

                }else {
                    Toast.makeText(getApplicationContext(), "isidong", Toast.LENGTH_LONG);
                }

            }
        });
    }


    private void setupPresenter(){
        Map<String, String> inputan = new HashMap<String, String>();
        inputan.put("pilih_kategori", pilih_kategori.toString());
        inputan.put("ukuran_kertas", ukuran_kertas.toString());
        inputan.put("calender", calendar.toString());
        inputan.put("catatan", catatan.toString());
    }

}
