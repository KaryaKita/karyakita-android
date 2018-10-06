package com.karyakita.karyakita_android_new.customer.home;

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
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaAdapter;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaModel;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends Fragment implements IHomeView {
    HomePresenter homePresenter = null;
    RecyclerView rv_kategori_home;

//    @BindView(R.id.rv_image_home)
//    RecyclerView rv_image_home;

    KategoriKaryaAdapter kategoriKaryaAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_customer, container, false);
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
