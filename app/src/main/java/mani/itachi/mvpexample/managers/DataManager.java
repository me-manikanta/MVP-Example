package mani.itachi.mvpexample.managers;

import android.content.Context;

import mani.itachi.mvpexample.helpers.SharedPreferencesHelper;

public class DataManager {

    private final Context context;
    private SharedPreferencesHelper sharedPreferencesHelper;

    public DataManager(Context context) {
        this.context = context;
        sharedPreferencesHelper = new SharedPreferencesHelper();
    }

    public void saveName(String name){
        sharedPreferencesHelper.saveName(context,name);
    }
}
