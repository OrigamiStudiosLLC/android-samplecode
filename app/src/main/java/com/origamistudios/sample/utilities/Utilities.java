package com.origamistudios.sample.utilities;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Utilities implements Constants {

    private static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 111;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 222;
    private static Utilities instance = null;
    private Context mContext;
    private final String STRING_PREFERENCES = "StringPreferences";
    private final String BOOLEAN_PREFERENCES = "BooleanPreferences";
    private final String INTEGER_PREFERENCES = "IntegerPreferences";

    public static Utilities getInstance(Context context) {
        if (instance == null) {
            instance = new Utilities(context);
        }
        return instance;
    }

    public Utilities(Context context) {
        this.mContext = context;
    }

    public float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    public void saveStringPreferences(String key, String value) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(STRING_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void saveIntegerPreferences(String key, int value) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(INTEGER_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void saveBooleanPreferences(String key, boolean value) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(BOOLEAN_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public String getStringPreferences(String key) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(STRING_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getString(key, "");
    }

    public boolean getBooleanPreferences(String key) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(BOOLEAN_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getBoolean(key, false);
    }

    public int getIntegerPreferences(String key) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(INTEGER_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getInt(key, 0);
    }

    public <T> List getListPreferences(String key, Class<T> clazz) {
        try {
            Gson gson = new Gson();
            String value = getStringPreferences(key);
            if (!value.equals("")) {
                Type type = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, clazz);
                return gson.<List<T>>fromJson(value, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isNetworkConnectionAvailable() {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) return false;
        NetworkInfo.State network = info.getState();
        return (network == NetworkInfo.State.CONNECTED || network == NetworkInfo.State.CONNECTING);
    }

    public boolean checkExternalStoragePermission(final Context context) {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle(kStringTitlePermission);
                    alertBuilder.setMessage(kStringExternalStoragePermission);
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                        }
                    });
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public void clearAllSharedPreferences() {
        SharedPreferences stringSharedPreferences = mContext.getSharedPreferences(STRING_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences integerSharedPreferences = mContext.getSharedPreferences(INTEGER_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences booleanSharedPreferences = mContext.getSharedPreferences(BOOLEAN_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = stringSharedPreferences.edit();
        editor.clear().apply();
        SharedPreferences.Editor editor1 = integerSharedPreferences.edit();
        editor1.clear().apply();
        SharedPreferences.Editor editor2 = booleanSharedPreferences.edit();
        editor2.clear().apply();
    }

}
