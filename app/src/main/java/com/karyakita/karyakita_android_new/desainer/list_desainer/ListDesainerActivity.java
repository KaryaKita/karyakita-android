package com.karyakita.karyakita_android_new.desainer.list_desainer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListDesainerActivity extends AppCompatActivity implements IListDesainerView{
    ListDesainerPresenter listDesainerPresenter = null;
    ListKaryaModel listKaryaModel = null;

    private String TAG = "ListDesainerActivity";

    @BindView(R.id.rv_list_desainer)
    RecyclerView rv_list_desainer;

    ListDesainerModel listDesainerModel = null;

    protected void onCreateView(Bundle savedInstanceState){
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
    public void showToast(String s) {

    }

    @Override
    public void display(ListDesainerResultModel listDesainerResultModel) {

    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
