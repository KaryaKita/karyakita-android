package com.karyakita.karyakita_android_new.view;

import com.karyakita.karyakita_android_new.model.MovieResponse;

public interface ITestView {
    void showToast(String s);

    void display(MovieResponse model);

    void displayError(String s);
}
