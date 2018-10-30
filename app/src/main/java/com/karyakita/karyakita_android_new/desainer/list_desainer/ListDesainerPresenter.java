package com.karyakita.karyakita_android_new.desainer.list_desainer;

import com.karyakita.karyakita_android_new.base.BaseModel;
import com.karyakita.karyakita_android_new.base.IMainPresenter;

import java.util.Map;
import java.util.Observable;

public class ListDesainerPresenter implements IMainPresenter{
    IListDesainerView iListDesainerView;
    BaseModel model = null;
    ListDesainerModel listDesainerModel = null;
    Map<String, String> input;

    public ListDesainerPresenter(IListDesainerView iListDesainerView) {
        this.iListDesainerView = iListDesainerView;
    }

    @Override
    public void get() {
        //getObservable().subscribeWith(getObserver());
    }

    @Override
    public void update() {

    }

    @Override
    public void insert(Map<String, String> dataInput) {

    }
}
