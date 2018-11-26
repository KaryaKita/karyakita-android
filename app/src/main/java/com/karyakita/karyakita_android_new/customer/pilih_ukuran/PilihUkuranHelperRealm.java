package com.karyakita.karyakita_android_new.customer.pilih_ukuran;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class PilihUkuranHelperRealm {
    Realm realm;

    public PilihUkuranHelperRealm(Realm realm){ this.realm = realm; }

    public void save(final PilihUkuranModelRealm pilihUkuranModelRealm){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm!=null){
                    Log.d("created : ", "database created");
                    Number currentIdNum = realm.where(PilihUkuranModelRealm.class).max("id");
                    int nextId;

                    if (currentIdNum==null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue()+1;
                    }

                    pilihUkuranModelRealm.setId(nextId);
                    PilihUkuranModelRealm model = realm.copyToRealm(pilihUkuranModelRealm);
                }else {
                    Log.d("error", "database not exist");
                }
            }
        });
    }

    public List<PilihUkuranModelRealm> getAllData(){
        RealmResults<PilihUkuranModelRealm> results = realm.where(PilihUkuranModelRealm.class).findAll();
        return results;
    }

    public void delete(Integer id){
        final RealmResults<PilihUkuranModelRealm> model = realm.where(PilihUkuranModelRealm.class)
                .equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteAllFromRealm();
            }
        });
    }
}
