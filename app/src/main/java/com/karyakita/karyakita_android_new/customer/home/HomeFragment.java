package com.karyakita.karyakita_android_new.customer.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.base_class_interface.GlobalVariable;
import com.karyakita.karyakita_android_new.customer.karya.DetailKaryaActivity;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaAdapter;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaModel;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaActivity;

import java.util.List;

import butterknife.BindView;

import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends Fragment implements IHomeView {
    HomePresenter homePresenter = null;
    KategoriKaryaAdapter kategoriKaryaAdapter;
    RecyclerView rv_kategori_home;

//    ImageView im_kategori_doodle_art;
//    ImageView im_kategori_kaligrafi;
//    ImageView im_kategori_karikatur;
//    ImageView im_kategori_lettering;
//    ImageView im_kategori_line_art;
//    ImageView im_kategori_mozaik;
//    ImageView im_kategori_origin_karakter;
//    ImageView im_kategori_papercut;
//    ImageView im_kategori_siluet;
//    ImageView im_kategori_sketsa;
//    ImageView im_list_image1;
//    ImageView im_list_image2;
//    ImageView im_list_image3;
//    ImageView im_list_image4;


//    @BindView(R.id.rv_image_home)
//    RecyclerView rv_image_home;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_customer, container, false);
        rv_kategori_home = view.findViewById(R.id.rv_kategori_home);

        setUpPresenter();
        setUpView();
        getGridViewHome();
        return view;
    }


    @Override
    public void showToast(String str) {
//        Toast.makeText(getContext().getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void display(KategoriKaryaResultModel kategoriKaryaResultModel) {
        KategoriKaryaAdapter kategoriKaryaAdapter = new KategoriKaryaAdapter(kategoriKaryaResultModel.getData(), getActivity());
        if (kategoriKaryaResultModel.getData() != null) {
            Log.d(TAG, "Respon ada");
            List<KategoriKaryaModel> listResponse = kategoriKaryaResultModel.getData();
            if (listResponse.size() > 0) {
                for (int i = 0; i < listResponse.size(); i++) {
                    KategoriKaryaModel kategoriKaryaModel = listResponse.get(i);
                    Log.d(TAG, kategoriKaryaModel.getFilename());
                    kategoriKaryaAdapter.addToList(kategoriKaryaModel);
                }
            }

            rv_kategori_home.setAdapter(kategoriKaryaAdapter);
        } else {
            Log.d(TAG, "Home fragment response null");
        }
    }

    @Override
    public void displayError(String s) {
        showToast(s);
    }

    private void setUpPresenter() {
        homePresenter = new HomePresenter(this);
    }

    private void setUpView() {
        rv_kategori_home.setLayoutManager(new GridLayoutManager(this.getActivity().getApplicationContext(), 3));
        rv_kategori_home.setHasFixedSize(true);
    }

    private void getGridViewHome() {
        Toast.makeText(getActivity().getApplicationContext(), "Toke " + GlobalVariable.TOKEN, Toast.LENGTH_LONG);
        homePresenter.get();
    }


}
