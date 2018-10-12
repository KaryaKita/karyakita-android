package com.karyakita.karyakita_android_new.base;

import java.util.Map;

public interface IMainPresenter {
    void get();

    void update();

    void insert(Map<String, String> dataInput);
}
