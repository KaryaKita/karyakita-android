package com.karyakita.karyakita_android_new.desainer.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.home.IHomeView;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;
import com.karyakita.karyakita_android_new.desainer.fragment.DesainerBerandaFragment;
import com.karyakita.karyakita_android_new.desainer.fragment.DesainerPesananFragment;
import com.karyakita.karyakita_android_new.desainer.fragment.DesainerTugasSayaFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeDesainerActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, IHomeView {
    HomeDesainerPresenter homeDesainerPresenter = null;
    HomeDesainerResultModel homeDesainerResultModel = null;

//    private String TAG = "HomeDesainerActivity";

//    @BindView(R.id.rv_home_desainer)
//    RecyclerView rv_home_desaainer;
//    @BindView(R.id.toolbar_navigation_home_desainer)
//    Toolbar toolbar_navigation_home_desainer;
//    @BindView(R.id.iv_pesanan)
//    ImageView iv_pesanan;
//    @BindView(R.id.tv_jenis_pesanan)
//    TextView tv_jenis_pesanan;
//    @BindView(R.id.tv_judul_karya)
//    TextView tv_judulKarya;
//    @BindView(R.id.tv_deadline)
//    TextView tv_deadline;
//    @BindView(R.id.tv_ukuran_karya)
//    TextView tv_ukuranKarya;
//    @BindView(R.id.tv_opsi_bingkai)
//    TextView tv_opsiBingkai;
//    @BindView(R.id.btn_acc)
//    Button btn_acc;
//    @BindView(R.id.btn_dec)
//    Button btn_dec;

    @BindView(R.id.bottom_nav_view_desainer)
    BottomNavigationView bottom_nav_view_desainer;

    HomeDesainerModel homeDesainerModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_desainer);
        ButterKnife.bind(this);

        setListeners();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment fragment = new DesainerBerandaFragment();

        ft.replace(R.id.frame_container_desainer, fragment);
        ft.commit();

//        Toolbar toolbar = findViewById(R.id.toolbar_navigation_home_desainer);
//        setSupportActionBar(toolbar);

        //setupPresenter();
        //setupView();
        //getHomeDesainer();

    }

    private void setListeners() {
        bottom_nav_view_desainer.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_beranda_desainer:
                fragment = new DesainerBerandaFragment();
                ft.replace(R.id.frame_container_desainer, fragment);
                ft.commit();
                return true;
            case R.id.nav_tugas_saya_desainer:
                fragment = new DesainerTugasSayaFragment();
                ft.replace(R.id.frame_container_desainer, fragment);
                ft.commit();
                return true;
            case R.id.nav_pesanan_desainer:
                fragment = new DesainerPesananFragment();
                ft.replace(R.id.frame_container_desainer, fragment);
                ft.commit();
                return true;
        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setupPresenter() {
//        homeDesainerPresenter = new HomeDesainerPresenter(this);
    }

    private void setupView() {
        //rv_home_desaainer.setLayoutManager(new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        //rv_home_desaainer.setHasFixedSize(true);
    }

    private void getHomeDesainer() {
        homeDesainerPresenter.get();
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(KategoriKaryaResultModel kategoriKaryaResultModel) {

    }

    @Override
    public void displayError(String s) {

    }

//    @Override
//    public void display(HomeDesainerResultModel homeDesainerResultModel) {
//        HomeDesainerAdapter homeDesainerAdapter = new HomeDesainerAdapter(homeDesainerResultModel.getData(), HomeDesainerActivity.this);
//
//        if (homeDesainerResultModel.getData() != null) {
//            List<HomeDesainerModel> listResponse = homeDesainerResultModel.getData();
//            Log.d(TAG, "respon: " + listResponse.get(1).getNama());
//            if (listResponse.size() > 0) {
//                for (int i = 0; i < listResponse.size(); i++) {
//                    HomeDesainerModel homeDesainerModel = listResponse.get(i);
//                    Log.d(TAG, homeDesainerModel.getFilename());
//                    homeDesainerAdapter.addToList(homeDesainerModel);
//                }
//            }
//            rv_home_desaainer.setAdapter(homeDesainerAdapter);
//
//
//        } else {
//            Log.d(TAG, "null");
//        }
//
//    }

//    @Override
//    public void displayError(String s) {
//
//    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
