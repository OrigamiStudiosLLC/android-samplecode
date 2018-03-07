package com.origamistudios.sample.presentation.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.origamistudios.sample.R;
import com.origamistudios.sample.presentation.account.SignUpActivity;
import com.origamistudios.sample.presentation.pager.TabAdapters;
import com.origamistudios.sample.utilities.Constants;
import com.origamistudios.sample.utilities.Utilities;
import com.origamistudios.sample.widgets.CustomTextView;

import me.relex.circleindicator.CircleIndicator;

public class GuideActivity extends FragmentActivity implements Constants, View.OnClickListener {


    private static final int CAMERA_MIC_PERMISSION_REQUEST_CODE = 11;
    private CustomTextView skipTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_tutorial);
        initData();
        setOnClickListeners();
    }

    private void initData() {
        ViewPager viewPager = findViewById(R.id.pager);
        CircleIndicator indicator = findViewById(R.id.indicator);
        skipTv = findViewById(R.id.skipTv);
        TabAdapters page_adapter = new TabAdapters(getSupportFragmentManager());
        viewPager.setAdapter(page_adapter);
        indicator.setViewPager(viewPager);
    }

    private void setOnClickListeners() {
        skipTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == skipTv) {
            Utilities.getInstance(this).saveBooleanPreferences(PREF_IS_SKIP, true);
            startActivity(new Intent(this, SignUpActivity.class));
            finish();
        }
    }
}
