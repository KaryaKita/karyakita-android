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
import com.karyakita.karyakita_android_new.customer.notifikasi.INotifikasiView;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiAdapter;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiModel;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiPresenter;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiResultModel;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaAdapter;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaModel;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaPresenter;
import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;
import com.karyakita.karyakita_android_new.login.LoginHelper;
import com.karyakita.karyakita_android_new.login.SessionModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CustomerNotifikasiFragment extends Fragment implements INotifikasiView {
    NotifikasiPresenter notifikasiPresenter = null;
    NotifikasiResultModel notifikasiResultModel = null;

    Realm realm;
    RealmHelper realmHelper;

    private String TAG = "Notifikasi Fragment";

    RecyclerView rv_notifikasi;

    NotifikasiModel notifikasiModel = null;

    LoginHelper loginHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_notifikasi, container, false);
        rv_notifikasi = view.findViewById(R.id.rv_notifikasi);
        setupView();
        setupPresenter();
//        getNotifikasi();

        return view;
    }

    private void setupView(){
        rv_notifikasi.setLayoutManager((new GridLayoutManager(getActivity().getApplicationContext(), 1)));
        rv_notifikasi.setHasFixedSize(true);
    }

    @Override
    public void showToast(String s) {

    }

    private void getNotifikasi() {
        notifikasiPresenter.get(null);
    }

    @Override
    public void display(NotifikasiResultModel notifikasiResultModel) {
        NotifikasiAdapter notifikasiAdapter = new NotifikasiAdapter(getActivity());
        if(notifikasiResultModel.getData() != null){
            List<NotifikasiModel> listResponse = notifikasiResultModel.getData();
            Log.d(TAG, "respon" +listResponse.get(0).getId());
            if(listResponse.size() > 0){
                for(int i = 0; i < listResponse.size(); i++){
                    NotifikasiModel notifikasiModel = listResponse.get(i);
                    notifikasiAdapter.addToList(notifikasiModel);
                }
                rv_notifikasi.setAdapter(notifikasiAdapter);
            }
        }
        else{
            Log.d(TAG, "null");
        }
    }

    private void setupPresenter(){
        Integer id_customer = 1;


        Realm.init(getActivity().getApplicationContext());
        RealmConfiguration configuration = new RealmConfiguration
                .Builder()
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);


        loginHelper = new LoginHelper(realm);
        SessionModel user = loginHelper.getUser();

        notifikasiPresenter = new NotifikasiPresenter(this, user.getId());
    }


    @Override
    public void displayError(String s) {

    }
}
