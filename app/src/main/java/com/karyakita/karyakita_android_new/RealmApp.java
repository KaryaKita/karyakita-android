package com.karyakita.karyakita_android_new;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("karya_kita.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
