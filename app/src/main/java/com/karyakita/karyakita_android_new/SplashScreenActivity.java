package com.karyakita.karyakita_android_new;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.karyakita.karyakita_android_new.customer.home.HomeCustomerActivity;
import com.karyakita.karyakita_android_new.login_as.LoginAsActivity;

import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** Hiding Title bar of this activity screen */
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        /** Making this activity, full screen */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        ImageView image = findViewById(R.id.ic_splash_karyakita);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_down);
        image.startAnimation(animation1);

        new CountDownTimer(5000, 1000) {

            /** This method will be invoked on finishing or expiring the timer */
            @Override
            public void onFinish() {
                /** Creates an intent to start new activity */
//                Intent intent = new Intent();

                /** Creates a new activity, on finishing this timer */
                startActivity(new Intent(getBaseContext(), HomeCustomerActivity.class));

                /** Close this activity screen */
                finish();
            }

            /** This method will be invoked in every 1000 milli seconds until
             * this timer is expired.Because we specified 1000 as tick time
             * while creating this CountDownTimer
             */
            @Override
            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }
}
