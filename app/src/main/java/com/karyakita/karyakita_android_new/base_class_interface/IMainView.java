package com.karyakita.karyakita_android_new.base_class_interface;

import com.karyakita.karyakita_android_new.model.MovieResponse;

public interface IMainView {
    void showToast(String s);

    void display(MovieResponse model);

    void displayError(String s);
}
