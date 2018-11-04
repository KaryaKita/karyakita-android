package com.karyakita.karyakita_android_new.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.karyakita.karyakita_android_new.R;

public abstract class BaseActivity extends AppCompatActivity implements IBaseFragmentListener{

    protected TextView tvToolbarTitle;
    protected BaseFragment currentFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initFragment();
    }

    protected abstract void initView();

    protected abstract void initFragment();

    protected void setCurrentFragment(BaseFragment fragment, Boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (currentFragment != null && addToBackStack)
            fragmentTransaction.addToBackStack(currentFragment.getTitle());

        fragmentTransaction.replace(R.id.flFragmentContainer, fragment, fragment.getTitle());
        fragmentTransaction.commit();

        this.currentFragment = fragment;
    }

    @Override
    public void setTitle(String title) {
        tvToolbarTitle.setText(title);
    }
}
