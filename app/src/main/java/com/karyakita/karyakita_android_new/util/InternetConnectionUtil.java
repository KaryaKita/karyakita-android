package com.karyakita.karyakita_android_new.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class InternetConnectionUtil {
    Context context;
    public Boolean isConnected(Context context) {
        this.context = context;
        Boolean connected = false;

        try {
            ConnectivityManager cm  = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo     = cm.getActiveNetworkInfo();

            connected = netInfo.isConnectedOrConnecting();
            Log.d("Tag : ", connected.toString());
            return connected;
        } catch (Exception e) {
            Log.e("Error Connection","Connectivity Exception : " + e.getMessage());
        }
        return connected;
    }

}
