package com.karyakita.karyakita_android_new.login;

public interface ILoginView {
    void showToast(String s);

    void display(LoginResultModel model);

    void displayError(String s);
}
