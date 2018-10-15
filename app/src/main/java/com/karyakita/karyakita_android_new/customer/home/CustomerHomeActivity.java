package com.karyakita.karyakita_android_new.customer.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.karyakita.karyakita_android_new.R;

public class CustomerHomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_beranda_customer:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.nav_kategori_desain_customer:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.nav_desainer_customer:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.nav_pesanan_saya_customer:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.nav_notif_customer:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.nav_akun_customer:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
