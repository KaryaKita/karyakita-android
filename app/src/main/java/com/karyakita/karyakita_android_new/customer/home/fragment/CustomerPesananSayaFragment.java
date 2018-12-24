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

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.IPesananSayaView;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaAdapter;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaModel;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaPresenter;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaResultModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerPesananSayaFragment extends Fragment implements IPesananSayaView{
    PesananSayaPresenter pesananSayaPresenter = null;
    PesananSayaResultModel pesananSayaResultModel = null;

    private String TAG = "Pesanan Saya Fragment";

    RecyclerView rv_pesanan_saya_customer;

    PesananSayaModel pesananSayaModel = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_pesanan_saya, container, false);

        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_karya_customer);
        //ButterKnife.bind(this);
        rv_pesanan_saya_customer = view.findViewById(R.id.rv_pesanan_saya_customer);
        setupView();
        setupPresenter();
        getPesananSaya();

        return view;
    }

    private void setupView(){
        rv_pesanan_saya_customer.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1));
        rv_pesanan_saya_customer.setHasFixedSize(true);
    }

    @Override
    public void showToast(String s) {

    }

    private void getPesananSaya(){
        pesananSayaPresenter.get(null);
    }

    @Override
    public void display(PesananSayaResultModel pesananSayaResultModel) {
        PesananSayaAdapter pesananSayaAdapter = new PesananSayaAdapter(getActivity());
        if(pesananSayaResultModel.getData() != null){
            List<PesananSayaModel> listResponse = pesananSayaResultModel.getData();
            Log.d(TAG, "respon" +listResponse.get(0).getId());
            if(listResponse.size() > 0){
                for(int i = 0; i < listResponse.size(); i++){
                    PesananSayaModel pesananSayaModel = listResponse.get(i);
                    Log.d(TAG, "hasil " + pesananSayaModel.getNama_desainer());
                    pesananSayaAdapter.addToList(pesananSayaModel);
                }
                rv_pesanan_saya_customer.setAdapter(pesananSayaAdapter);
            }
        }
        else{
            Log.d(TAG, "null");
        }
    }

    private void setupPresenter(){
        pesananSayaPresenter = new PesananSayaPresenter(this);
    }

    @Override
    public void displayError(String s) {

    }
}
