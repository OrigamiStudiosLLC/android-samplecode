package com.origamistudios.sample.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.origamistudios.sample.utilities.FontHelper;

/*
* Custom EditText extends AppCompatEditText
* Handles app:customFont attribute
* Apply custom font using FontHelper class
*/
public class CustomEditText extends AppCompatEditText {
    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        FontHelper.setCustomFont(this, context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //  Apply custom font using FontHelper class
        FontHelper.setCustomFont(this, context, attrs);
    }

}
