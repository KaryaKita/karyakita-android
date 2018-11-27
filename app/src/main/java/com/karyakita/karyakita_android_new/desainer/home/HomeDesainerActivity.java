package com.karyakita.karyakita_android_new.desainer.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaActivity;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeDesainerActivity extends AppCompatActivity implements IHomeDesainerView{
    HomeDesainerPresenter homeDesainerPresenter = null;
    HomeDesainerResultModel homeDesainerResultModel = null;

    private String TAG = "HomeDesainerActivity";

//    @BindView(R.id.rv_home_desainer)
//    RecyclerView rv_home_desaainer;
    @BindView(R.id.toolbar_navigation_home_desainer)
    Toolbar toolbar_navigation_home_desainer;
    @BindView(R.id.iv_pesanan)
    ImageView iv_pesanan;
    @BindView(R.id.tv_jenis_pesanan)
    TextView tv_jenis_pesanan;
    @BindView(R.id.tv_judul_karya)
    TextView tv_judulKarya;
    @BindView(R.id.tv_deadline)
    TextView tv_deadline;
    @BindView(R.id.tv_ukuran_karya)
    TextView tv_ukuranKarya;
    @BindView(R.id.tv_opsi_bingkai)
    TextView tv_opsiBingkai;
    @BindView(R.id.btn_acc)
    Button btn_acc;
    @BindView(R.id.btn_dec)
    Button btn_dec;

    HomeDesainerModel homeDesainerModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_desainer);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar_navigation_home_desainer);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Home Desainer");

        //setupPresenter();
        //setupView();
        //getHomeDesainer();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
    public void display(HomeDesainerResultModel homeDesainerResultModel) {
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

    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
