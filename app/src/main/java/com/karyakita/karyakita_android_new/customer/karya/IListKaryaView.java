package com.karyakita.karyakita_android_new.customer.karya;

import com.karyakita.karyakita_android_new.login.LoginResultModel;

public interface IListKaryaView {
    void showToast(String s);

    void display(ListKaryaResultModel listKaryaResultModel);

    void displayError(String s);


}
