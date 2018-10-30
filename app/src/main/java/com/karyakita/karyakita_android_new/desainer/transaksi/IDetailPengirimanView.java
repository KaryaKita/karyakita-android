package com.karyakita.karyakita_android_new.desainer.transaksi;

public interface IDetailPengirimanView {
    void showToast (String s);

    void display(DetailPengirimanResultModel detailPengirimanResultModel);

    void displayError(String s);
}
