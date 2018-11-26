package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

interface IPilihUkuranView {
    void showToast(String s);

    void display(PilihUkuranModel model);

    void displayError(String s);
}
