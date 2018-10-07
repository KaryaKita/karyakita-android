package com.karyakita.karyakita_android_new.customer.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
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
    RecyclerView rv_kategori_home;

    ImageView im_kategori_doodle_art;
    ImageView im_kategori_kaligrafi;
    ImageView im_kategori_karikatur;
    ImageView im_kategori_lettering;
    ImageView im_kategori_line_art;
    ImageView im_kategori_mozaik;
    ImageView im_kategori_origin_karakter;
    ImageView im_kategori_papercut;
    ImageView im_kategori_siluet;
    ImageView im_kategori_sketsa;
    ImageView im_list_image1;
    ImageView im_list_image2;
    ImageView im_list_image3;
    ImageView im_list_image4;


//    @BindView(R.id.rv_image_home)
//    RecyclerView rv_image_home;

    KategoriKaryaAdapter kategoriKaryaAdapter;

    @Nullable
    @Override
//    public void onCreat(Bundle savedInstanceState){
//        super.onCreate(R.layout.fragment_home_customer);
//
//    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_customer, container, false);
        im_kategori_doodle_art = view.findViewById(R.id.kategori_doodle_art);
        im_kategori_kaligrafi= view.findViewById(R.id.kategori_kaligrafi);
        im_kategori_karikatur= view.findViewById(R.id.kategori_karikatur);
        im_kategori_lettering= view.findViewById(R.id.kategori_lettering);
        im_kategori_line_art= view.findViewById(R.id.kategori_line_art);
        im_kategori_mozaik= view.findViewById(R.id.kategori_mozaik);
        im_kategori_origin_karakter= view.findViewById(R.id.kategori_origin_karakter);
        im_kategori_papercut= view.findViewById(R.id.kategori_papercut);
        im_kategori_siluet= view.findViewById(R.id.kategori_siluet);
        im_kategori_sketsa= view.findViewById(R.id.kategori_sketsa);
        im_list_image1= view.findViewById(R.id.list_image1);
        im_list_image2= view.findViewById(R.id.list_image2);
        im_list_image3= view.findViewById(R.id.list_image3);
        im_list_image4= view.findViewById(R.id.list_image4);

        im_kategori_sketsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_kategori_siluet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_kategori_papercut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_kategori_origin_karakter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_kategori_mozaik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_kategori_line_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_kategori_lettering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_kategori_karikatur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_kategori_kaligrafi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_kategori_doodle_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ListKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_list_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DetailKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_list_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DetailKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_list_image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DetailKaryaActivity.class);
                startActivity(intent);
            }
        });

        im_list_image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DetailKaryaActivity.class);
                startActivity(intent);
            }
        });

//        setUpView();

        setUpPresenter();
        getGridViewHome();
        return view;
    }


    @Override
    public void showToast(String str) {
        Toast.makeText(getContext().getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void display(KategoriKaryaResultModel kategoriKaryaResultModel) {
        KategoriKaryaAdapter kategoriKaryaAdapter = new KategoriKaryaAdapter(kategoriKaryaResultModel.getData(), getContext().getApplicationContext());
        if (kategoriKaryaAdapter != null) {
//            Log.d(TAG,movieResponse.getResults().get(0).getTitle());
//            Log.d(TAG,movieResponse.getResults().get(0).getOriginalLanguage());
//            Log.d(TAG,movieResponse.getResults().get(0).getOriginalTitle());

            List<KategoriKaryaModel> listResponse = kategoriKaryaResultModel.getData();
            if (listResponse.size() > 0) {
                for (int i = 0; i < listResponse.size(); i++) {
                    KategoriKaryaModel kategoriKaryaModel = listResponse.get(i);
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
        rv_kategori_home.setLayoutManager(new LinearLayoutManager(this.getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rv_kategori_home.setHasFixedSize(true);
    }

    private void getGridViewHome() {
        homePresenter.get();
    }


}
