package com.origamistudios.sample.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.origamistudios.sample.R;

public class FontHelper {

    private static final String TAG = "FontHelper";

    public static void setCustomFont(TextView textView, Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        String customFont = a.getString(R.styleable.CustomTextView_customFont);
        setCustomFont(textView, ctx, customFont);
        a.recycle();
    }

    private static void setCustomFont(TextView textview, Context ctx, String asset) {
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/" + asset);
            Log.d(TAG, ctx.getAssets().toString());
        } catch (Exception e) {
            Log.e(TAG, "Unable to load typeface: " + e.getMessage());

        }
        textview.setTypeface(typeface);
    }

    public static void applyRegularFont(Context context, TextView tv) {
        try {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Regular.ttf");
            tv.setTypeface(typeface);
        } catch (Exception e) {
            Log.e(TAG, "Unable to load typeface: " + e.getMessage());
        }
    }

    public static void applyBoldFont(Context context, TextView tv) {
        try {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Bold.ttf");
            tv.setTypeface(typeface);
        } catch (Exception e) {
            Log.e(TAG, "Unable to load typeface: " + e.getMessage());
        }
    }
}
