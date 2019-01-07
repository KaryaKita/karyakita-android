package com.karyakita.karyakita_android_new.login;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class LoginHelper {
    Realm realm;

    public LoginHelper(Realm realm) {
        this.realm = realm;
    }

    public void save(final SessionModel sessionModel) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null) {
                    Log.d("Created : ", "Database was created");

                    Number currentIdNum = realm.where(SessionModel.class).max("id");
                    int nextId;

                    if (currentIdNum == null) {
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue() + 1;
                    }

                    sessionModel.setId(nextId);
                    SessionModel model = realm.copyToRealm(sessionModel);
                } else {
                    Log.e("Error : ", "Database not exist");
                }
            }
        });
    }


    public SessionModel getUser() {
        RealmResults<SessionModel> results = realm.where(SessionModel.class).findAll().sort("createdAt", Sort.DESCENDING);
        return results.get(0);
    }
    public void deleteById(Integer id) {
        final RealmResults<SessionModel> model = realm.where(SessionModel.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteAllFromRealm();
            }
        });
    }
    public void delete() {
        final RealmResults<SessionModel> model = realm.where(SessionModel.class).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteAllFromRealm();
            }
        });
    }
}
