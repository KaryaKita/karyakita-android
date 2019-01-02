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

import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiResultModel;
import com.karyakita.karyakita_android_new.customer.profil_customer.IProfilView;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilModel;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilPresenter;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilResultModel;
import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;
import com.karyakita.karyakita_android_new.login.LoginHelper;

import io.realm.Realm;

public class CustomerAkunFragment extends Fragment implements IProfilView{
    ProfilPresenter profilPresenter = null;
    NotifikasiResultModel notifikasiResultModel = null;

    Realm realm;
    RealmHelper realmHelper;
    LoginHelper loginHelper;
    Context context;
    Integer karya_id;

    private String TAG = "Profil Fragment";

    ProfilModel profilModel = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_akun, container, false);
        return view;
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(ProfilResultModel profilResultModel) {

    }

    @Override
    public void displayError(String s) {

    }
}
