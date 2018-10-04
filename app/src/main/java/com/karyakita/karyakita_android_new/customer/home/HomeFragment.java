package com.karyakita.karyakita_android_new.customer.home;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.model.MovieResponse;
import com.karyakita.karyakita_android_new.presenter.HomePresenter;
import com.karyakita.karyakita_android_new.view.ITestView;

import butterknife.BindView;

public class HomeFragment extends Fragment implements ITestView {

    HomePresenter homePresenter = null;

    @BindView(R.id.rv_kategori_home)
    RecyclerView rv_kategori_home;

    @BindView(R.id.rv_image_home)
    RecyclerView rv_image_home;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_customer, null);
        setUpPresenter();
        setUpView();
        return view;
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getContext().getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void display(MovieResponse model) {
        
    }

    @Override
    public void displayError(String s) {

    }
    private void setUpPresenter() {
        homePresenter = new HomePresenter(this);
    }

    private void setUpView(){
        rv_kategori_home.setLayoutManager(new GridLayoutManager(this.getActivity().getApplicationContext(), 4 ));
        rv_kategori_home.setHasFixedSize(true);
    }

    private void getGridViewHome(){
        homePresenter.get();
    }
}
