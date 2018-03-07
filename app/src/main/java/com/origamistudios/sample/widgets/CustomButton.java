package com.origamistudios.sample.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.origamistudios.sample.utilities.FontHelper;

/*
* Custom buttons extends AppCompatButton
* Handles app:customFont attribute
* Apply custom font using FontHelper class
*/
public class CustomButton extends AppCompatButton {

    private static final String TAG = "CustomButton";

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        FontHelper.setCustomFont(this, context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //  Apply custom font using FontHelper class
        FontHelper.setCustomFont(this, context, attrs);
    }

}
