package com.karyakita.karyakita_android_new.customer.karya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.login.LoginResultModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListKaryaActivity extends AppCompatActivity implements IListKaryaView {
    ListKaryaPresenter listKaryaPresenter = null;
    LoginResultModel loginResultModel = null;
    @BindView(R.id.rv_list_karya)
    RecyclerView rv_list_karya;
    ListKaryaModel listKaryaModel = null;
    private String TAG = "ListKaryaActivity";
    Map<String, String> input;

    Integer kategori_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_karya_customer);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar_navigation_list_karya);
        setSupportActionBar(toolbar);

        final Bundle bundle = getIntent().getExtras();
        kategori_id = bundle.getInt("kategori_id");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("List Karya");

        setupView();
        setupPresenter();
        getListKarya();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setupView() {
        rv_list_karya.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rv_list_karya.setHasFixedSize(true);
    }

    private void getListKarya() {
        input = new HashMap<String, String>();
        input.put("kategori_id", kategori_id.toString());

        listKaryaPresenter.get(input);
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(ListKaryaResultModel listKaryaResultModel) {
        ListKaryaAdapter listKaryaAdapter = new ListKaryaAdapter(listKaryaResultModel.getData(), ListKaryaActivity.this);

        if (listKaryaResultModel.getData() != null) {
            List<ListKaryaModel> listResponse = listKaryaResultModel.getData();
            if (listResponse.size() > 0) {
                for (int i = 0; i < listResponse.size(); i++) {
                    ListKaryaModel listKaryaModel = listResponse.get(i);
                    Log.d(TAG, listKaryaModel.getFilename());
                    listKaryaAdapter.addToList(listKaryaModel);
                }
            }
            rv_list_karya.setAdapter(listKaryaAdapter);
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
        listKaryaPresenter = new ListKaryaPresenter(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
