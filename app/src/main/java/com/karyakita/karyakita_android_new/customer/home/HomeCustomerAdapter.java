package com.karyakita.karyakita_android_new.customer.home;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerAkunFragment;
import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerBerandaFragment;
import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerDesainerFragment;
import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerNotifikasiFragment;
import com.karyakita.karyakita_android_new.customer.home.fragment.CustomerPesananSayaFragment;

public class HomeCustomerAdapter extends FragmentStatePagerAdapter {


    public HomeCustomerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new CustomerBerandaFragment();
                break;
            case 1:
                fragment = new CustomerDesainerFragment();
                break;
            case 2:
                fragment = new CustomerPesananSayaFragment();
                break;
            case 3:
                fragment = new CustomerNotifikasiFragment();
                break;
            case 4:
                fragment = new CustomerAkunFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Beranda";
                break;
            case 1:
                title = "Desainer";
                break;
            case 2:
                title = "Pesanan Saya";
                break;
            case 3:
                title = "Notifikasi";
                break;
            case 4:
                title = "Akun";
                break;
        }
        return title;
    }
}
