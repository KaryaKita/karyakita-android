package com.karyakita.karyakita_android_new.login_as;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.karyakita.karyakita_android_new.R;

import butterknife.ButterKnife;

public class LoginAsActivity extends AppCompatActivity {

//    @BindView(R.id.)

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);
        ButterKnife.bind(this);
    }
}
