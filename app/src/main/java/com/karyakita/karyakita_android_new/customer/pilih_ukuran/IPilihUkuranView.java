package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import com.karyakita.karyakita_android_new.customer.pesan_langsung.PesanLangsungResultModel;

interface IPilihUkuranView {
    void showToast(String s);

    void display(PesanLangsungResultModel model);

    void displayError(String s);
}
