package com.karyakita.karyakita_android_new.customer.pesan_custom;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class PesanCustomRealmHelper {
    Realm realm;

    public PesanCustomRealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void save(final PesanCustomModelRealm pesanCustomModelRealm) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null) {
                    Log.d("Created :", "Database was created!");

                    Number currentIdNum = realm.where(PesanCustomModelRealm.class).max("id");
                    int nextId;

                    if (currentIdNum == null) {
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue() + 1;
                    }

                    pesanCustomModelRealm.setId(nextId);
                    PesanCustomModelRealm model = realm.copyToRealm(pesanCustomModelRealm);

                } else {
                    Log.e("erorr", "Database not exist");
                }
            }
        });
    }

    public List<PesanCustomModelRealm> getAlldata() {
        RealmResults<PesanCustomModelRealm> results = realm.where(PesanCustomModelRealm.class).findAll();
        return results;
    }

    public void delete(Integer id) {
        final RealmResults<PesanCustomModelRealm> model = realm.where(PesanCustomModelRealm.class)
                .equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteAllFromRealm();
            }
        });
    }
}
