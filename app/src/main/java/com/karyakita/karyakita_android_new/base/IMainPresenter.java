package com.karyakita.karyakita_android_new.base;

import java.util.Map;

public interface IMainPresenter {
    void get(Map<String, String> dataInputs);

    void update();

    void insert(Map<String, String> dataInput);
}
