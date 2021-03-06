package com.karyakita.karyakita_android_new.customer.home.fragment;

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

import com.karyakita.karyakita_android_new.MustLoginRegisterActivity;
import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiPresenter;
import com.karyakita.karyakita_android_new.customer.pesan_custom.PesanCustomRealmHelper;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.IPesananSayaView;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaAdapter;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaModel;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaPresenter;
import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaResultModel;
import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;
import com.karyakita.karyakita_android_new.login.LoginActivity;
import com.karyakita.karyakita_android_new.login.LoginHelper;
import com.karyakita.karyakita_android_new.login.SessionModel;
import com.karyakita.karyakita_android_new.sessions.SessionSharedPreferences;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CustomerPesananSayaFragment extends Fragment implements IPesananSayaView{
    PesananSayaPresenter pesananSayaPresenter = null;
    PesananSayaResultModel pesananSayaResultModel = null;

    Realm realm;
    RealmHelper realmHelper;

    private String TAG = "Pesanan Saya Fragment";

    RecyclerView rv_pesanan_saya_customer;

    PesananSayaModel pesananSayaModel = null;

    LoginHelper loginHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_pesanan_saya, container, false);
        rv_pesanan_saya_customer = view.findViewById(R.id.rv_pesanan_saya_customer);

        setupView();
        setupPresenter();

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
        PesananSayaAdapter pesananSayaAdapter = new PesananSayaAdapter(getActivity().getApplicationContext());
        if(pesananSayaResultModel.getData() != null){
            List<PesananSayaModel> listResponse = pesananSayaResultModel.getData();
            if(listResponse.size() > 0){
                for(int i = 0; i < listResponse.size(); i++){
                    PesananSayaModel pesananSayaModel = listResponse.get(i);
                    Log.d(TAG, "hasil " + pesananSayaModel.getDeploy_url());
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
        Realm.init(getActivity().getApplicationContext());
        RealmConfiguration configuration = new RealmConfiguration
                .Builder()
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        if(SessionSharedPreferences.getLoggedStatus(getActivity().getApplicationContext())){
            loginHelper = new LoginHelper(realm);
            SessionModel user = loginHelper.getUser();

            pesananSayaPresenter = new PesananSayaPresenter(this, user.getId(), getActivity().getApplicationContext());
            getPesananSaya();
        } else {
            Intent intent = new Intent(getActivity().getApplicationContext(), MustLoginRegisterActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void displayError(String s) {

    }
}
