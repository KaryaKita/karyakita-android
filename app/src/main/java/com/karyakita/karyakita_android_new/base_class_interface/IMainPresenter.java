package com.karyakita.karyakita_android_new.base_class_interface;

import java.util.Map;

public interface IMainPresenter {
    void get();

    void update();

    void insert(Map<String, String> dataInput);
}
