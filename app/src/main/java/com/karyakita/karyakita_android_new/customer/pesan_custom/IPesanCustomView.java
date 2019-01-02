package com.karyakita.karyakita_android_new.customer.pesan_custom;


import retrofit2.http.Multipart;
import retrofit2.http.POST;

interface IPesanCustomView {
    void showToast(String s);

    void display(PesanCustomResultModel model);

    void displayError(String s);


}
