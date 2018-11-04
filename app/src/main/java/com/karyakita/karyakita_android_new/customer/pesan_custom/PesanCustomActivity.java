package com.karyakita.karyakita_android_new.customer.pesan_custom;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Spinner;

import com.karyakita.karyakita_android_new.R;
import com.mlsdev.rximagepicker.RxImagePicker;
import com.mlsdev.rximagepicker.Sources;

import butterknife.BindView;

public class PesanCustomActivity extends AppCompatActivity {

    Spinner spinner;
    @BindView(R.id.iv_img_custom)
    ImageView img_custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_custom);

//        RxImagePicker.with(this).requestImage(Sources.GALLERY)

    }
}
