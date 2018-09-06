package mani.itachi.mvpexample.helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    public void saveName(Context context, String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE).edit();
        editor.putString("Name", name);
        editor.apply();
    }
}
