package com.karyakita.karyakita_android_new.sessions;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.karyakita.karyakita_android_new.login.LoginResultModel;
import com.karyakita.karyakita_android_new.login.SessionModel;

public class SessionSharedPreferences {
    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Set the Login Status
     * @param context
     * @param loggedIn
     */
    public static void setLoggedIn(Context context, boolean loggedIn, LoginResultModel loginResultModel) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(PreferencesUtility.LOGGED_IN, loggedIn);

        if (loginResultModel != null){
            editor.putInt(PreferencesUtility.USER_ID, loginResultModel.getData().getId());
            editor.putInt(PreferencesUtility.USER_ROLE, loginResultModel.getData().getRole_id());

            editor.putString(PreferencesUtility.TOKEN, loginResultModel.getToken());
        }
        editor.apply();
    }

    /**
     * Get the Login Status
     * @param context
     * @return boolean: login status
     */
    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(PreferencesUtility.LOGGED_IN, false);
    }

    public static Integer getUserId(Context context) {
        return getPreferences(context).getInt(PreferencesUtility.USER_ID, 0);
    }

    public static Integer getUserRole(Context context) {
        return getPreferences(context).getInt(PreferencesUtility.USER_ROLE, 0);
    }

    public static String getToken(Context context) {
        return getPreferences(context).getString(PreferencesUtility.TOKEN, "");
    }

    public static void logout(Context context) {
        setLoggedIn(context, false, null);
    }
}
