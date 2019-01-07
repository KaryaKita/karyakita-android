package com.karyakita.karyakita_android_new;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.karyakita.karyakita_android_new.customer.home.HomeCustomerActivity;
import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;
import com.karyakita.karyakita_android_new.login.LoginHelper;
import com.karyakita.karyakita_android_new.login.SessionModel;
import com.karyakita.karyakita_android_new.login_as.LoginAsActivity;

import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SplashScreenActivity extends AppCompatActivity {
    Realm realm;
    RealmHelper realmHelper;
    LoginHelper loginHelper;
    Context context;
    Integer user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        ImageView image = findViewById(R.id.ic_splash_karyakita);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);

        new CountDownTimer(5000, 1000) {
            @Override
            public void onFinish() {
                /** Creates a new activity, on finishing this timer */
                startActivity(new Intent(getBaseContext(), HomeCustomerActivity.class));

                /** Close this activity screen */
                finish();
            }

            @Override
            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }
}
