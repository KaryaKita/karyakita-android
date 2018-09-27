package com.karyakita.karyakita_android_new.activity.customer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.adapter.HomeCustomerAdapter;
import com.karyakita.karyakita_android_new.fragment.AkunCustomerFragment;
import com.karyakita.karyakita_android_new.fragment.DesainerFragment;
import com.karyakita.karyakita_android_new.fragment.HomeFragment;
import com.karyakita.karyakita_android_new.fragment.KategoriDesainFragment;
import com.karyakita.karyakita_android_new.fragment.NotifikasiCustomerFragment;
import com.karyakita.karyakita_android_new.fragment.PesananSayaFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeCustomerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.tab_home_customer) TabLayout tabHomeCustomer;
    @BindView(R.id.view_pager_home_customer) ViewPager viewPagerHomeCustomer;
    @BindView(R.id.drawer_layout_navigation) DrawerLayout drawerLayoutNavigation;
    @BindView(R.id.nav_view_application) NavigationView navViewApplication;
    @BindView(R.id.toolbar_navigation) Toolbar toolbarNavigation;

    @SuppressLint("ResourceType")
    @BindView(R.layout.home_customer_activity)
    ContentFrameLayout homeCustomerActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_customer_activity);
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

    public void setNavigationView(Toolbar toolbar){
//        DrawerLayout drawer = findViewById(R.id.drawer_layout_navigation);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayoutNavigation, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayoutNavigation.addDrawerListener(toggle);
        toggle.syncState();

//        NavigationView navigationView = findViewById(R.id.nav_view_application);
        navViewApplication.setNavigationItemSelectedListener(this);
    }

    public void setFloatingActionButton(){
        FloatingActionButton fab = findViewById(R.id.fab_application);
        fab.setOnClickListener(new View.OnClickListener() {
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
        DrawerLayout drawer = findViewById(R.id.drawer_layout_navigation);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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
        switch (id){
            case R.id.nav_beranda_customer:
                fragment = new HomeFragment();
                break;
            case R.id.nav_kategori_customer:
                fragment = new KategoriDesainFragment();
                break;
            case R.id.nav_desainer_customer:
                fragment = new DesainerFragment();
                break;
            case R.id.nav_pesanan_saya_customer:
                fragment = new PesananSayaFragment();
                break;
            case R.id.nav_notifikasi_customer:
                fragment = new NotifikasiCustomerFragment();
                break;
            case R.id.nav_akun_customer:
                fragment = new AkunCustomerFragment();
                break;
        }

//        if (id == R.id.nav_beranda_customer) {
//            // Handle the camera action
//        } else if (id == R.id.nav_kategori_customer) {
//
//        } else if (id == R.id.nav_desainer_customer) {
//
//        } else if (id == R.id.nav_pesanan_saya_customer) {
//
//        } else if (id == R.id.nav_notifikasi_customer) {
//
//        } else if (id == R.id.nav_keluar) {
//
//        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_navigation);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
