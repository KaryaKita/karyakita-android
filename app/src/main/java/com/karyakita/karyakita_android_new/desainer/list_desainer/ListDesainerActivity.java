package com.karyakita.karyakita_android_new.desainer.list_desainer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaModel;
import com.karyakita.karyakita_android_new.login.LoginResultModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListDesainerActivity extends AppCompatActivity implements IListDesainerView {
    ListDesainerPresenter listDesainerPresenter = null;
    ListKaryaModel listKaryaModel = null;

    private String TAG = "ListDesainerActivity";

    @BindView(R.id.rv_list_desainer)
    RecyclerView rv_list_desainer;

    ListDesainerModel listDesainerModel = null;

    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_desainer_customer);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar_navigation_list_desainer);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("List Desainer");

        //setupPresenter();
        //setupView();
        //setupPresenter();
        //getListDesainer();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setupView() {
        rv_list_desainer.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        rv_list_desainer.setHasFixedSize(true);
    }

    private void getListDesainer() {
        listDesainerPresenter.get(null);
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(ListDesainerResultModel listDesainerResultModel) {
        ListDesainerAdapter listDesainerAdapter = new ListDesainerAdapter(listDesainerResultModel.getData(), ListDesainerActivity.this);

        if (listDesainerResultModel.getData() != null) {
            List<ListDesainerModel> listResponse = listDesainerResultModel.getData();
            Log.d(TAG, "respon: " + listResponse.get(1).getNama());
            if (listResponse.size() > 0) {
                for (int i = 0; i < listResponse.size(); i++) {
                    ListDesainerModel listDesainerModel = listResponse.get(i);
                    //Log.d(TAG, listDesainerModel.getFilename());
                    listDesainerAdapter.addToList(listDesainerModel);
                }
            }
            rv_list_desainer.setAdapter(listDesainerAdapter);

//            Log.d(TAG,listKaryaResultModel.getData().get(0).getNama());
////            Log.d(TAG,listKaryaResultModel.getData().get(0).getKategori_karya_id().toString());
//            Log.d(TAG,listKaryaResultModel.getData().get(0).getDeploy_url());
        } else {
            Log.d(TAG, "null");
        }

    }

    public void display(LoginResultModel loginResultModel) {

    }

    @Override
    public void displayError(String s) {

    }

    private void setupPresenter() {
        listDesainerPresenter = new ListDesainerPresenter(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
