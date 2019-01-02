package com.karyakita.karyakita_android_new.customer.notifikasi;

import com.karyakita.karyakita_android_new.customer.pesanan_saya.PesananSayaResultModel;

public interface INotifikasiView {
    void showToast(String s);

    void display(NotifikasiResultModel notifikasiResultModel);

    void displayError(String s);
}
