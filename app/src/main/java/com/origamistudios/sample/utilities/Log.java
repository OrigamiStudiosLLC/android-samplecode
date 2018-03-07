package com.origamistudios.sample.utilities;

public class Log {
    private static final boolean TAG = true;

    public static void d(String tag, String message) {
        if (TAG)
            android.util.Log.d(tag, message);
    }

    public static void e(String tag, String message) {
        if (TAG)
            android.util.Log.e(tag, message);
    }

    public static void v(String tag, String message) {
        if (TAG)
            android.util.Log.v(tag, message);
    }
}
