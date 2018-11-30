package com.karyakita.karyakita_android_new.desainer.pesanan_saya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.desainer.TugasSayaActivity;
import com.karyakita.karyakita_android_new.example.MainActivity;

public class TerimaPesananActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_diterima_desainer);

        TextView tv1 = (TextView) findViewById(R.id.tv_1);
        TextView tv2 = (TextView) findViewById(R.id.tv_2);
        TextView tv3 = (TextView) findViewById(R.id.tv_3);
        Button btnTugasSaya = (Button) findViewById(R.id.btn_tugas_saya);

        btnTugasSaya.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Intent intent =  new Intent(TugasSayaActivity.this, MainActivity.class);
                //startActivity(intent);
            }
        });
    }

}
