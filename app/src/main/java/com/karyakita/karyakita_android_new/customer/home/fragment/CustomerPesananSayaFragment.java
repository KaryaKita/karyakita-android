package com.karyakita.karyakita_android_new.customer.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.IPesananSayaView;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaModel;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaPresenter;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaResultModel;

import butterknife.BindView;

public class CustomerPesananSayaFragment extends Fragment implements IPesananSayaView{
    PesananSayaPresenter pesananSayaPresenter = null;
    PesananSayaResultModel pesananSayaResultModel = null;

    private String TAG = "PesananSayaActivity";

    @BindView(R.id.rv_pesanan_saya_customer)
    RecyclerView rv_pesanan_saya_customer;

    PesananSayaModel pesananSayaModel = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_pesanan_saya, container, false);

        rv_pesanan_saya_customer = view.findViewById(R.id.rv_pesanan_saya_customer);
        //setupView();
        //setupPresenter();
        //getPesananSaya();

        return view;
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(PesananSayaResultModel pesananSayaResultModel) {

    }

    @Override
    public void displayError(String s) {

    }
}
