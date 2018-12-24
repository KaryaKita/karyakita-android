package com.karyakita.karyakita_android_new.login;

import android.util.Log;

import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;
import com.karyakita.karyakita_android_new.data.local.realm.model.PesanLangsungModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginHelper {
    Realm realm;

    public LoginHelper(Realm realm){
        this.realm = realm;
    }

    public void save(final SessionModel sessionModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if(realm != null){
                    Log.d("Created : ", "Database was created");

                    Number currentIdNum = realm.where(SessionModel.class).max("id");
                    int nextId;

                    if(currentIdNum == null){
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


    public SessionModel getUser(){
        SessionModel results = realm.where(SessionModel.class).findFirst();
        return results;
    }
}
