package com.karyakita.karyakita_android_new.customer.profil_customer;

import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;

public interface IProfilView {
    void showToast(String s);

    void display(ProfilResultModel profilResultModel);

    void displayError(String s);
}
