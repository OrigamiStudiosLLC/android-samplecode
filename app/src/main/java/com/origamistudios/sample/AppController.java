package com.origamistudios.sample;

import android.support.multidex.MultiDexApplication;

import com.origamistudios.sample.network.ApiInterface;
import com.origamistudios.sample.network.ApiClient;
import com.crashlytics.android.Crashlytics;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import io.fabric.sdk.android.Fabric;

public class AppController extends MultiDexApplication {

    private static AppController mInstance;
    private static ApiInterface apiService;
    private static DB snappy = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        mInstance = this;
        configRetrofit();
    }

    private static void configRetrofit() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public static ApiInterface getApiService() {
        return apiService;
    }

    public static synchronized DB getSnappyInstance() {
        try {
            if (snappy == null) {
                snappy = DBFactory.open(mInstance);
            }
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
        return snappy;
    }
}
