package com.karyakita.karyakita_android_new.customer.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiResultModel;
import com.karyakita.karyakita_android_new.customer.profil_customer.IProfilView;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilModel;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilPresenter;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilResultModel;
import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;
import com.karyakita.karyakita_android_new.login.LoginHelper;
import com.karyakita.karyakita_android_new.login.SessionModel;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CustomerAkunFragment extends Fragment implements IProfilView{
    ProfilPresenter profilPresenter = null;
    NotifikasiResultModel notifikasiResultModel = null;

    Realm realm;
    RealmHelper realmHelper;
    LoginHelper loginHelper;
    Context context;
    Integer user_id;

    private String TAG = "Profil Fragment";

    ProfilModel profilModel = null;

    @BindView(R.id.bt_logout)
    Button bt_logout;
    @BindView(R.id.iv_user)
    Button iv_user;
    @BindView(R.id.tv_nama)
    Button tv_nama;
    @BindView(R.id.tv_email)
    Button tv_email;
    @BindView(R.id.tv_username)
    Button tv_username;
    @BindView(R.id.tv_notelp)
    Button tv_notelp;
    @BindView(R.id.tv_provinsi)
    Button tv_provinsi;
    @BindView(R.id.tv_kota_kab)
    Button tv_kota_kab;
    @BindView(R.id.tv_kecamatan)
    Button tv_kecamatan;
    @BindView(R.id.tv_alamat_lengkap)
    Button tv_alamat_lengkap;
    @BindView(R.id.bt_edit_profil)
    Button bt_edit_profil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_akun, container, false);
        ButterKnife.bind(this, view);
        setupPresenter();
        getProfil();
        return view;
    }

    private void getProfil(){
        Map<String, String> dataInput = new HashMap<>();
        dataInput.put("user_id", user_id.toString());
        profilPresenter.get(dataInput);
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(ProfilResultModel profilResultModel) {
        //ProfilAdapter profilAdapter = new ProfilAdapter(getActivity());
        //Glide.with(getActivity().l
        tv_nama.setText(profilResultModel.getData().getNama());
        tv_username.setText(profilResultModel.getData().getUsername());
        tv_email.setText(profilResultModel.getData().getEmail());
        tv_alamat_lengkap.setText(profilResultModel.getData().getAlamat_lengkap());
        tv_notelp.setText(profilResultModel.getData().getNotelp());
        tv_kecamatan.setText(profilResultModel.getData().getKecamatan());
        tv_kota_kab.setText(profilResultModel.getData().getKota_kab());
        tv_provinsi.setText(profilResultModel.getData().getProvinsi());
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

        if(GlobalVariable.TOKEN != ""){
            loginHelper = new LoginHelper(realm);
            SessionModel user = loginHelper.getUser();
            profilPresenter = new ProfilPresenter(this, user.getId());
        }
    }

    @Override
    public void displayError(String s) {

    }
}
