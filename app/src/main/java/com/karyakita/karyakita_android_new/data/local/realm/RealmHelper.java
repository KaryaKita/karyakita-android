package com.karyakita.karyakita_android_new.data.local.realm;

import android.util.Log;

import com.karyakita.karyakita_android_new.data.local.realm.model.PesanLangsungModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;

    public RealmHelper(Realm realm){
        this.realm = realm;
    }

    public void save(final PesanLangsungModel pesanLangsungModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if(realm != null){
                    Log.e("created", "database was created");
                    Number currentIdNum = realm.where(PesanLangsungModel.class).max("id");
                    int nexId;
                    if (currentIdNum == null){
                        nexId = 1;
                    }else {
                        nexId = currentIdNum.intValue() + 1;
                    }
                    pesanLangsungModel.setId(nexId);
                    PesanLangsungModel model = realm.copyToRealm(pesanLangsungModel);
                }else {
                    Log.e("pppp", "excute: Database not exist");
                }
            }
        });
    }

    public List<PesanLangsungModel> getAllKaryaKita(){
        RealmResults<PesanLangsungModel> results = realm.where(PesanLangsungModel.class).findAll();
        return results;
    }

    //untuk meng-update
    public void update(final Integer id, final String ukuran_kertas, final String ukuran_bingkai, final String provinsi, final String kabupaten, final String kecamatan, final String alamat, final String opsi_pengiriman){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                PesanLangsungModel model = realm.where(PesanLangsungModel.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setUkuran_pigora(ukuran_bingkai);
                model.setUkuran_kertas(ukuran_kertas);
                model.setProvinsi(provinsi);
                model.setKabupaten(kabupaten);
                model.setKecamatan(kecamatan);
                model.setAlamat(alamat);
                model.setOpsi_pengiriman(opsi_pengiriman);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("pppp", "onsucces : updated success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    //untuk menghapus data
    public void delete(Integer id){
        final RealmResults<PesanLangsungModel> model = realm.where(PesanLangsungModel.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteAllFromRealm();
            }
        });
    }
}
