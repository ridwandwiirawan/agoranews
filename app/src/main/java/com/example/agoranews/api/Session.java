package com.example.agoranews.api;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    private Context context;
    private SharedPreferences sp;

    public static Session init(Context context) {
        return new Session(context);
    }

    private Session(Context context) {
        this.context = context.getApplicationContext();
        this.sp = this.context.getSharedPreferences(this.context.getPackageName(), Context.MODE_PRIVATE);
    }

    public Session set(String key, int value) {
        sp.edit().putInt(key, value).apply();
        return this;
    }

    public Session set(String key, String value) {
        sp.edit().putString(key, value).apply();
        return this;
    }

    public Session set(String key, float value) {
        sp.edit().putFloat(key, value).apply();
        return this;
    }

    public Session set(String key, long value) {
        sp.edit().putLong(key, value).apply();
        return this;
    }

    public Session set(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
        return this;
    }

    public int getInt(String key) {
        return sp.getInt(key, 0);
    }

    public String getString(String key) {
        return sp.getString(key, null);
    }

    public float getFloat(String key) {
        return sp.getFloat(key, 0);
    }

    public long getLong(String key) {
        return sp.getLong(key, 0);
    }

    public boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }
}
