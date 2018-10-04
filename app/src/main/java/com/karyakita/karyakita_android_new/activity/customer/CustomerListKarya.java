package com.karyakita.karyakita_android_new.activity.customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.model.MovieResponse;
import com.karyakita.karyakita_android_new.presenter.ListKaryaPresenter;
import com.karyakita.karyakita_android_new.view.ITestView;

import butterknife.ButterKnife;

public class CustomerListKarya extends AppCompatActivity implements ITestView {
    ListKaryaPresenter listKaryaPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_list_karya_activity);
        ButterKnife.bind(this);

        setupPresenter();
        setupView();
    }

    private void setupView() {
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(MovieResponse model) {

    }

    @Override
    public void displayError(String s) {

    }

    private void setupPresenter() {
        listKaryaPresenter = new ListKaryaPresenter(this);
    }
}
