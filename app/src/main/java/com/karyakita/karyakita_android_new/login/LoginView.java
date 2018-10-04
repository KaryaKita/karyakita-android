package com.karyakita.karyakita_android_new.login;

import com.karyakita.karyakita_android_new.example.MovieResponse;

public interface LoginView {
    void showToast(String s);

    void display(MovieResponse model);

    void displayError(String s);


}
