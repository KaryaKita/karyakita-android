package com.karyakita.karyakita_android_new.customer.home.fragment;

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
import android.widget.Toast;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.customer.carousel.Carousel;
import com.karyakita.karyakita_android_new.customer.carousel.CarouselAdapter;
import com.karyakita.karyakita_android_new.customer.carousel.Item;
import com.karyakita.karyakita_android_new.customer.home.HomePresenter;
import com.karyakita.karyakita_android_new.customer.home.IHomeView;
import com.karyakita.karyakita_android_new.customer.karya.IListKaryaView;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaAdapter;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaModel;
import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaAdapter;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaModel;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaPresenter;
import com.karyakita.karyakita_android_new.customer.karya.ListKaryaResultModel;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class CustomerBerandaFragment extends Fragment implements IHomeView, IListKaryaView, DiscreteScrollView.OnItemChangedListener {

    HomePresenter homePresenter = null;
    ListKaryaPresenter listKaryaPresenter = null;
    KategoriKaryaAdapter kategoriKaryaAdapter;

    RecyclerView rv_kategori_home;
    RecyclerView rv_list_karya_customer;

    DiscreteScrollView carouselScrollView;
    InfiniteScrollAdapter infiniteScrollAdapter;
    List<Item> data_image;
    Carousel carousel;
    CarouselAdapter carouselAdapter;

    public CustomerBerandaFragment() {
        // Required empty public constructor.
    }

    public static CustomerBerandaFragment newInstance() {
        CustomerBerandaFragment fragment = new CustomerBerandaFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_beranda, container, false);

        rv_kategori_home = view.findViewById(R.id.rv_kategori_home);
        rv_list_karya_customer = view.findViewById(R.id.rv_list_karya_customer);
        rv_kategori_home.setNestedScrollingEnabled(false);
        rv_list_karya_customer.setNestedScrollingEnabled(false);

        carousel = new Carousel();
        data_image = carousel.getData();

        setUpPresenter();
        setUpView();
        setUpViewListKarya();
        getGridViewHome();
        getListKarya();

        carouselScrollView = (DiscreteScrollView) view.findViewById(R.id.carousel_scroll_view);
        carouselScrollView.setOrientation(DSVOrientation.HORIZONTAL);
        carouselScrollView.addOnItemChangedListener(this);
        carouselAdapter = new CarouselAdapter(data_image, getActivity().getApplicationContext());
        infiniteScrollAdapter = InfiniteScrollAdapter.wrap(carouselAdapter);
        carouselScrollView.setAdapter(infiniteScrollAdapter);
        carouselScrollView.setItemTransitionTimeMillis(500);
        carouselScrollView.setItemTransformer(new ScaleTransformer.Builder().setMinScale(0.8f).build());

        return view;
    }

    private void setUpPresenter() {
        homePresenter = new HomePresenter(this);
        listKaryaPresenter = new ListKaryaPresenter(this);
    }

    private void setUpView() {
        rv_kategori_home.setLayoutManager(new GridLayoutManager(this.getActivity().getApplicationContext(), 4));
        rv_kategori_home.setHasFixedSize(true);
    }

    private void setUpViewListKarya() {
        rv_list_karya_customer.setLayoutManager(new GridLayoutManager(this.getActivity().getApplicationContext(), 2));
        rv_list_karya_customer.setHasFixedSize(true);
    }


    private void getGridViewHome() {
        homePresenter.get(null);
    }

    private void getListKarya() {
        listKaryaPresenter.get(null);
    }

    @Override
    public void display(ListKaryaResultModel listKaryaResultModel) {
        ListKaryaAdapter listKaryaAdapter = new ListKaryaAdapter(listKaryaResultModel.getData(), getActivity());

        if (listKaryaResultModel.getData() != null) {
            List<ListKaryaModel> listResponse = listKaryaResultModel.getData();
            if (listResponse.size() > 0) {
                for (int i = 0; i < listResponse.size(); i++) {
                    ListKaryaModel listKaryaModel = listResponse.get(i);
                    Log.d(TAG, listKaryaModel.getFilename());
                    listKaryaAdapter.addToList(listKaryaModel);
                }
            }
            rv_list_karya_customer.setAdapter(listKaryaAdapter);

        } else {
            Log.d(TAG, "null");
        }
    }

    @Override
    public void display(KategoriKaryaResultModel kategoriKaryaResultModel) {
        KategoriKaryaAdapter kategoriKaryaAdapter = new KategoriKaryaAdapter(kategoriKaryaResultModel.getData(), getActivity());
        if (kategoriKaryaResultModel.getData() != null) {
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

    @Override
    public void showToast(String str) {
    }

    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {

    }
}
