package com.karyakita.karyakita_android_new.customer.pesanan_saya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.SplashScreenActivity;
import com.karyakita.karyakita_android_new.customer.home.HomeCustomerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPesananSayaActivity extends AppCompatActivity {
    @BindView(R.id.btn_status)
    Button btn_status;

    @BindView(R.id.btn_back)
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        ButterKnife.bind(this);

        btn_status.setText("Menunggu Konfirmasi");

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeCustomerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
