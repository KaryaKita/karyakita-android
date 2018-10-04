package com.karyakita.karyakita_android_new.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karyakita.karyakita_android_new.customer.home.HomeCustomerActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(SplashActivity.this, HomeCustomerActivity.class));
        finish();
    }
}
