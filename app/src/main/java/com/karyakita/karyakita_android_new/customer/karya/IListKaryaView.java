package com.karyakita.karyakita_android_new.customer.karya;

public interface IListKaryaView {
    void showToast(String s);

    void display(ListKaryaResultModel listKaryaResultModel);

    void displayError(String s);
}
