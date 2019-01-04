package com.karyakita.karyakita_android_new.customer.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.SearchActivity;
import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerAkunFragment;
import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerBerandaFragment;
import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerDesainerFragment;
import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerNotifikasiFragment;
import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerPesananSayaFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeCustomerActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottom_nav_view_customer)
    BottomNavigationView bottom_nav_view_customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);
        ButterKnife.bind(this);

        setListeners();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment fragment = new CustomerBerandaFragment();

        ft.replace(R.id.frame_container_customer, fragment);
        ft.commit();

        ImageView actionbar_search = findViewById(R.id.actionbar_search);
        actionbar_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeCustomerActivity.this, SearchActivity.class));
            }
        });

    }

    private void setListeners() {
        bottom_nav_view_customer.setOnNavigationItemSelectedListener(this);

//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottom_nav_view_customer.getLayoutParams();
//        layoutParams.setBehavior(new BottomNavigationBehavior());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_beranda_customer:
                fragment = new CustomerBerandaFragment();
                ft.replace(R.id.frame_container_customer, fragment);
                ft.commit();
                return true;
            case R.id.nav_desainer_customer:
                fragment = new CustomerDesainerFragment();
                ft.replace(R.id.frame_container_customer, fragment);
                ft.commit();
                return true;
            case R.id.nav_pesanan_saya_customer:
                fragment = new CustomerPesananSayaFragment();
                ft.replace(R.id.frame_container_customer, fragment);
                ft.commit();
                return true;
            case R.id.nav_notif_customer:
                fragment = new CustomerNotifikasiFragment();
                ft.replace(R.id.frame_container_customer, fragment);
                ft.commit();
                return true;
            case R.id.nav_profil_customer:
                fragment = new CustomerAkunFragment();
                ft.replace(R.id.frame_container_customer, fragment);
                ft.commit();
                return true;
        }
        return false;
    }
}
