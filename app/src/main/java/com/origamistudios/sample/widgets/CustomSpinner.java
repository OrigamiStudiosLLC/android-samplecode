package com.origamistudios.sample.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;

/*
* Custom spinner extends AppCompatSpinner
* Handles app:customFont attribute
*/
public class CustomSpinner extends AppCompatSpinner {
    public CustomSpinner(Context context) {
        super(context);
    }

    public CustomSpinner(Context context, int mode) {
        super(context, mode);
    }
    //  Apply custom font
    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //  Apply custom font
    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
    }
}
