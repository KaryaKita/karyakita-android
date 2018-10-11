package com.karyakita.karyakita_android_new.customer.karya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.example.MovieResponse;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaPresenter;
import com.karyakita.karyakita_android_new.login.LoginResultModel;

import butterknife.ButterKnife;

public class ListKaryaActivity extends AppCompatActivity implements IListKaryaView {
    ListKaryaPresenter listKaryaPresenter = null;
    ListKaryaModel listKaryaModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_list_karya_activity);
        ButterKnife.bind(this);

        //setupPresenter();
        setupView();
    }

    private void setupView() {
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(LoginResultModel loginResultModel) {

    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

//    private void setupPresenter() {
//        listKaryaPresenter = new ListKaryaPresenter(this);
//    }
}
