package com.karyakita.karyakita_android_new.customer.pesanan_saya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.login.LoginResultModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PesananSayaActivity extends AppCompatActivity implements IPesananSayaView {
    PesananSayaPresenter pesananSayaPresenter = null;
    PesananSayaResultModel pesananSayaResultModel = null;

    private String TAG = "PesananSayaActivity";

    @BindView(R.id.rv_pesanan_saya_customer)
    RecyclerView rv_pesanan_saya_customer;

    PesananSayaModel pesananSayaModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_saya_customer);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar_navigation_pesanan_saya);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Pesanan Saya");

        setupPresenter();
//        setupPresenter();

        setupView();
        setupPresenter();
        getPesananSaya();
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

    private void setupView(){
        rv_pesanan_saya_customer.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        rv_pesanan_saya_customer.setHasFixedSize(true);
    }

    private void getPesananSaya(){
        pesananSayaPresenter.get(null);
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(PesananSayaResultModel pesananSayaResultModel) {
        PesananSayaAdapter pesananSayaAdapter = new PesananSayaAdapter(pesananSayaResultModel.getData(), PesananSayaActivity.this);
         if(pesananSayaResultModel.getData() != null){
             List<PesananSayaModel> listResponse = pesananSayaResultModel.getData();
             Log.d(TAG, "respon" +listResponse.get(1).getId());
             if(listResponse.size() > 0){
                 for(int i = 0; i < listResponse.size(); i++){
                     PesananSayaModel pesananSayaModel = listResponse.get(i);
                     Log.d(TAG, pesananSayaModel.getNama_desainer());
                     pesananSayaAdapter.addToList(pesananSayaModel);
                 }
                 rv_pesanan_saya_customer.setAdapter(pesananSayaAdapter);
             }
         }
         else{
             Log.d(TAG, "null");
         }
    }

    public void display(LoginResultModel loginResultModel){

    }

    @Override
    public void displayError(String s) {

    }

    private void setupPresenter(){
        pesananSayaPresenter = new PesananSayaPresenter(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
