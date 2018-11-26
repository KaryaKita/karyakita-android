package com.karyakita.karyakita_android_new.customer.pesan_custom;


interface IPesanCustomView {
    void showToast(String s);

    void display(PesanCustomResultModel model);

    void displayError(String s);
}
