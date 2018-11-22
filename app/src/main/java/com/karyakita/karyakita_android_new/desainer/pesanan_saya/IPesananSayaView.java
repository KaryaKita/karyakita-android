package com.karyakita.karyakita_android_new.desainer.pesanan_saya;

public interface IPesananSayaView {
    void showToast(String s);

    void display(PesananSayaResultModel pesananSayaResultModel);

    void displayError(String s);
}
