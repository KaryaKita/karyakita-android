package com.karyakita.karyakita_android_new.customer.data_pengiriman;

interface IDataPengirimanView {
    void showToast(String s);

    void display(DataPengirimanResultModel model);

    void displayError(String s);
}
