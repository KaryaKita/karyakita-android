package com.karyakita.karyakita_android_new.customer.home;

import com.karyakita.karyakita_android_new.customer.karya.KategoriKaryaResultModel;

public interface IHomeView {
    void showToast(String s);

    void display(KategoriKaryaResultModel kategoriKaryaResultModel);

    void displayError(String s);
}
