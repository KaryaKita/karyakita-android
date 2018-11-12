package com.karyakita.karyakita_android_new.customer.pesan_custom;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.IMainPresenter;

import java.util.Map;

public class PesanCustomPresenter implements IMainPresenter{
    IPesanCustomView iPesanCustomView;
    BaseModel model;
    PesanCustomModel pesanCustomModel = null;
    Map<String, String>input;

    public PesanCustomPresenter(IPesanCustomView iPesanCustomView){
        this.iPesanCustomView = iPesanCustomView;
    }

    @Override
    public void get(Map<String, String> dataInput) {

    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {

    }
}
