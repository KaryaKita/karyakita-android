package com.karyakita.karyakita_android_new.customer.karya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.example.ITestView;
import com.karyakita.karyakita_android_new.example.MovieResponse;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaPresenter;
import com.karyakita.karyakita_android_new.login.LoginResultModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListKaryaActivity extends AppCompatActivity implements IListKaryaView {
    ListKaryaPresenter listKaryaPresenter = null;
    private String TAG = "ListKaryaActivity";

    @BindView(R.id.rv_list_karya)
    RecyclerView rv_list_karya;
    ListKaryaModel listKaryaModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_karya_customer);
        ButterKnife.bind(this);

        //setupPresenter();

        Toolbar toolbar = findViewById(R.id.toolbar_navigation_list_karya);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("List Karya");

        setupPresenter();
//        setupPresenter();
        setupView();
        getListKarya();
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

    private void setupView() {
        rv_list_karya.setLayoutManager(new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rv_list_karya.setHasFixedSize(true);
    }

    private void getListKarya() {
        listKaryaPresenter.get();
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(ListKaryaResultModel listKaryaResultModel) {
        ListKaryaAdapter listKaryaAdapter = new ListKaryaAdapter(listKaryaResultModel.getData(), ListKaryaActivity.this);

        if(listKaryaResultModel.getData() != null){
            List<ListKaryaModel> listResponse = listKaryaResultModel.getData();
            Log.d(TAG, "respon: " + listResponse.get(1).getNama());
            if (listResponse.size()>0){
                for (int i=0; i<listResponse.size(); i++){
                    ListKaryaModel listKaryaModel = listResponse.get(i);
                    Log.d(TAG, listKaryaModel.getFilename());
                    listKaryaAdapter.addToList(listKaryaModel);
                }
            }
            rv_list_karya.setAdapter(listKaryaAdapter);

//            Log.d(TAG,listKaryaResultModel.getData().get(0).getNama());
////            Log.d(TAG,listKaryaResultModel.getData().get(0).getKategori_karya_id().toString());
//            Log.d(TAG,listKaryaResultModel.getData().get(0).getDeploy_url());
        }else {
            Log.d(TAG, "null");
        }

    public void display(LoginResultModel loginResultModel) {

    }

    @Override
    public void displayError(String s) {

    }

    private void setupPresenter() {
        listKaryaPresenter = new ListKaryaPresenter(this);
        listKaryaPresenter.get();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

//    private void setupPresenter() {
//        listKaryaPresenter = new ListKaryaPresenter(this);
//    }
}
