package com.karyakita.karyakita_android_new.login;

import android.util.Log;

import com.karyakita.karyakita_android_new.data.local.realm.RealmHelper;

import io.realm.Realm;

public class LoginHelper {
    Realm realm;

    public LoginHelper(Realm realm){
        this.realm = realm;
    }

    public void save(final LoginModel loginModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if(realm != null){
                    Log.d("Created : ", "Database was created");

                    Number currentIdNum = realm.where(LoginModel.class).max("id");
                    int nextId;

                    if(currentIdNum == null){
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue() + 1;
                    }

                    loginModel.setId(nextId);
                    LoginModel model = realm.copyToRealm(loginModel);
                } else {
                    Log.e("Error : ", "Database not exist");
                }
            }
        });
    }

}
