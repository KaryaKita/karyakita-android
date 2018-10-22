package com.karyakita.karyakita_android_new.desainer.home;

public interface IHomeDesainerView {
    void showToast(String s);

    void display(HomeDesainerResultModel homeDesainerResultModel);

    void displayError(String s);
}
