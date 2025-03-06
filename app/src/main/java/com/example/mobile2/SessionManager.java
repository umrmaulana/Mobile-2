package com.example.mobile2;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "UserSession";

    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_NAME = "nama";
    private static final String KEY_PHOTO = "foto";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_STATUS = "status";
    private static final String KEY_EMAIL = "email";

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String username, String nama, String foto, String password, String status, String email) {
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_NAME, nama);
        editor.putString(KEY_PHOTO, foto);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_STATUS, status);
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public String getUsername() { return sharedPreferences.getString(KEY_USERNAME, null); }
    public String getNama() { return sharedPreferences.getString(KEY_NAME, null); }
    public String getFoto() { return sharedPreferences.getString(KEY_PHOTO, null); }
    public String getPassword() { return sharedPreferences.getString(KEY_PASSWORD, null); }
    public String getStatus() { return sharedPreferences.getString(KEY_STATUS, null); }
    public String getEmail() { return sharedPreferences.getString(KEY_EMAIL, null); }

    public void logoutSession() {
        editor.clear();
        editor.apply();
    }
}
