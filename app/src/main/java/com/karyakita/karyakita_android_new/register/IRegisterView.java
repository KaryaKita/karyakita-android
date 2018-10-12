package com.karyakita.karyakita_android_new.register;

public interface IRegisterView {
    void showToast(String s);

    void display(RegisterResultModel model);

    void displayError(String s);
}
