package com.karyakita.karyakita_android_new.customer.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.customer.karya.DetailKaryaActivity;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaAdapter;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaModel;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends Fragment implements IHomeView {
    HomePresenter homePresenter = null;
    KategoriKaryaAdapter kategoriKaryaAdapter;
    RecyclerView rv_kategori_home;

    ImageView im_list_image1;
    ImageView im_list_image2;
    ImageView im_list_image3;
    ImageView im_list_image4;


//    @BindView(R.id.rv_image_home)
//    RecyclerView rv_image_home;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_customer, container, false);

        im_list_image1 = view.findViewById(R.id.list_image1);
        im_list_image2 = view.findViewById(R.id.list_image2);
        im_list_image3 = view.findViewById(R.id.list_image3);
        im_list_image4 = view.findViewById(R.id.list_image4);

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
        homePresenter.get(null);
    }


}
