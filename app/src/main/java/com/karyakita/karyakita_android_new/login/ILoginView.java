package com.karyakita.karyakita_android_new.login;

import com.karyakita.karyakita_android_new.example.MovieResponse;

public interface ILoginView {
    void showToast(String s);

    void display(LoginResultModel model);

    void displayError(String s);
}
