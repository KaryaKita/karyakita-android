package com.karyakita.karyakita_android_new.desainer.list_desainer;

import com.karyakita.karyakita_android_new.customer.karya.ListKaryaResultModel;

public interface IListDesainerView {
    void showToast(String s);

    void display(ListDesainerResultModel listDesainerResultModel);

    void displayError(String s);

}
