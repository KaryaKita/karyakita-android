package com.karyakita.karyakita_android_new.customer.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.karya.DetailKaryaActivity;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeCustomerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.tab_home_customer)
    TabLayout tabHomeCustomer;
    @BindView(R.id.view_pager_home_customer)
    ViewPager viewPagerHomeCustomer;
    @BindView(R.id.drawer_layout_navigation)
    DrawerLayout drawerLayoutNavigation;
    @BindView(R.id.nav_view_application)
    NavigationView navViewApplication;
    @BindView(R.id.toolbar_navigation)
    Toolbar toolbarNavigation;
    @BindView(R.id.fab_application)
    FloatingActionButton fabApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);
        ButterKnife.bind(this);

//        Toolbar toolbar = findViewById(R.id.toolbar_navigation);
        setSupportActionBar(toolbarNavigation);

        setNavigationView(toolbarNavigation);
        setFloatingActionButton();
        setViewPager();
    }

    private void setViewPager() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeCustomerAdapter homeCustomerAdapter = new HomeCustomerAdapter(fragmentManager);
        viewPagerHomeCustomer.setAdapter(homeCustomerAdapter);
        viewPagerHomeCustomer.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabHomeCustomer));
        tabHomeCustomer.setupWithViewPager(viewPagerHomeCustomer);
        tabHomeCustomer.setTabsFromPagerAdapter(homeCustomerAdapter);
    }

    public void setNavigationView(Toolbar toolbar) {
//        DrawerLayout drawer = findViewById(R.id.drawer_layout_navigation);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayoutNavigation, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayoutNavigation.addDrawerListener(toggle);
        toggle.syncState();

//        NavigationView navigationView = findViewById(R.id.nav_view_application);
        navViewApplication.setNavigationItemSelectedListener(this);
    }

    public void setFloatingActionButton() {
//        FloatingActionButton fab = findViewById(R.id.fab_application);
        fabApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = findViewById(R.id.drawer_layout_navigation);
        if (drawerLayoutNavigation.isDrawerOpen(GravityCompat.START)) {
            drawerLayoutNavigation.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cari) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        int id = item.getItemId();

        if (id == R.id.nav_beranda_customer) {
            fragment = new HomeFragment();
        } else if (id == R.id.nav_kategori_desain_customer) {
            startActivity(new Intent(HomeCustomerActivity.this, ListKaryaActivity.class));
        } else if (id == R.id.nav_desainer_customer) {

        } else if (id == R.id.nav_pesanan_saya_customer) {

        } else if (id == R.id.nav_notifikasi_customer) {

        } else if (id == R.id.nav_keluar) {

        }
        if (fragment != null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.view_pager_home_customer, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_navigation);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
