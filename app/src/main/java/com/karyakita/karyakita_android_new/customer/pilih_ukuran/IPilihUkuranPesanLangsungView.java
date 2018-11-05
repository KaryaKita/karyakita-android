package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

interface IPilihUkuranPesanLangsungView {
    void showToast(String s);

    void display(PilihUkuranPesanLangsungModel model);

    void displayError(String s);
}
