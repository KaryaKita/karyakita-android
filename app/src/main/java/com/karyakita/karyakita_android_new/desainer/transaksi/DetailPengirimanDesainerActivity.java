package com.karyakita.karyakita_android_new.desainer.transaksi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.karyakita.karyakita_android_new.R;

import butterknife.ButterKnife;

public class DetailPengirimanDesainerActivity extends AppCompatActivity implements IDetailPengirimanView {

    DetailPengirimanModel detailPengirimanModel = null;
    DetailPengirimanPresenter detailPengirimanPresenter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desainer_detail_pengiriman);
        ButterKnife.bind(this);
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(DetailPengirimanResultModel detailPengirimanResultModel) {

    }

    @Override
    public void displayError(String s) {

    }
}
