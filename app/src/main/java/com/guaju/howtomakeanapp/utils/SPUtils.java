package com.guaju.howtomakeanapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by guaju on 2017/7/25.
 */

public class SPUtils {
    private static SharedPreferences sp;
    private static SPUtils spUtils;

    private SPUtils(Context context, String str) {
        sp = context.getSharedPreferences(str, Context.MODE_PRIVATE);
    }

    public static SPUtils getInstance(Context context, String str) {
        if (spUtils == null) {
            spUtils = new SPUtils(context, str);
        }
        return spUtils;
    }

    public static void putSP(String key, Object value) {
        SharedPreferences.Editor edit = sp.edit();
        if (value instanceof Integer) {
            edit.putInt(key, (int) value);
        } else if (value instanceof Boolean) {
            edit.putBoolean(key, (boolean) value);
        } else if (value instanceof String) {
            edit.putString(key, (String) value);
        } else if (value instanceof Float) {
            edit.putFloat(key, (float) value);
        } else if (value instanceof Long) {
            edit.putLong(key, (long) value);
        }
        edit.commit();
    }
    public  static Object getSp(String key,Object def){
        Object value=null;
        if (sp!=null){
            if (def instanceof Integer) {
               value= sp.getInt(key, (int) def);
            } else if (def instanceof Boolean) {
                value= sp.getBoolean(key, (boolean) def);
            } else if (def instanceof String) {
                value= sp.getString(key, (String) def);
            } else if (def instanceof Float) {
                value= sp.getFloat(key, (float) def);
            } else if (def instanceof Long) {
                value= sp.getLong(key, (long) def);
            }
        }
        return value;
    }


}
