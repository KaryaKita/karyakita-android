package com.karyakita.karyakita_android_new.customer.home;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class HomeCustomerAdapter extends FragmentStatePagerAdapter {


    public HomeCustomerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new DesainerFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        String title = "";
        switch (position) {
            case 0:
                title = "Beranda";
                break;
            case 1:
                title = "Desainer";
                break;
        }
        return title;
    }
}
