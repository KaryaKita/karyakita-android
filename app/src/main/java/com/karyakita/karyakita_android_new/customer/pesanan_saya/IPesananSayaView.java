package com.karyakita.karyakita_android_new.customer.pesanan_saya;

import com.karyakita.karyakita_android_new.customer.karya.ListKaryaResultModel;

public interface IPesananSayaView {
    void showToast(String s);

    void display(PesananSayaResultModel pesananSayaResultModel);

    void displayError(String s);
}
