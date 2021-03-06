package com.karyakita.karyakita_android_new.base;

public interface IBaseView<T> {
    void setPresenter(T presenter);

    void display(T model);

    void displayError(String s);

    void showToast(String s);

    void showStatus(Integer type, String message);

    void setLoadingDialog(Boolean isLoading, String message);
}
