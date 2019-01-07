package com.karyakita.karyakita_android_new.customer.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.karyakita.karyakita_android_new.MustLoginRegisterActivity;
import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.SplashScreenActivity;
import com.karyakita.karyakita_android_new.base.GlobalVariable;
import com.karyakita.karyakita_android_new.customer.home.HomeCustomerActivity;
import com.karyakita.karyakita_android_new.customer.notifikasi.NotifikasiResultModel;
import com.karyakita.karyakita_android_new.customer.profil_customer.IProfilView;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilModel;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilPresenter;
import com.karyakita.karyakita_android_new.customer.profil_customer.ProfilResultModel;
import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;
import com.karyakita.karyakita_android_new.login.LoginHelper;
import com.karyakita.karyakita_android_new.login.SessionModel;
import com.karyakita.karyakita_android_new.register.RegisterActivity;
import com.karyakita.karyakita_android_new.sessions.SessionSharedPreferences;

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

    @BindView(R.id.tv_logout)
    TextView tv_logout;
    @BindView(R.id.iv_user)
    ImageView iv_user;
    @BindView(R.id.tv_nama)
    TextView tv_nama;
    @BindView(R.id.tv_email)
    TextView tv_email;
    @BindView(R.id.tv_username)
    TextView tv_username;
    @BindView(R.id.tv_notelp)
    TextView tv_notelp;
    @BindView(R.id.tv_provinsi)
    TextView tv_provinsi;
    @BindView(R.id.tv_kota_kab)
    TextView tv_kota_kab;
    @BindView(R.id.tv_kecamatan)
    TextView tv_kecamatan;
    @BindView(R.id.tv_alamat_lengkap)
    TextView tv_alamat_lengkap;
    @BindView(R.id.bt_edit_profil)
    Button bt_edit_profil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_akun, container, false);
        ButterKnife.bind(this, view);
        context = getActivity().getApplicationContext();
        setupPresenter();

        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionSharedPreferences.logout(context);

                getActivity().finish();
                Intent intent = new Intent(context, SplashScreenActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        return view;
    }

    private void getProfil(){
        Map<String, String> dataInput = new HashMap<>();
        profilPresenter.get(dataInput);
    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void display(ProfilResultModel profilResultModel) {
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

        if(SessionSharedPreferences.getLoggedStatus(getActivity().getApplicationContext())){
            loginHelper = new LoginHelper(realm);
            SessionModel user = loginHelper.getUser();
            this.user_id = user.getId();

            profilPresenter = new ProfilPresenter(this,
                    SessionSharedPreferences.getUserId(getActivity().getApplicationContext()),
                    getActivity().getApplicationContext());
            getProfil();
        } else {
            Intent intent = new Intent(getActivity().getApplicationContext(), MustLoginRegisterActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void onResume() {
        super.onResume();
//        ((HomeCustomerActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
//        ((HomeCustomerActivity)getActivity()).getSupportActionBar().show();
    }
}
