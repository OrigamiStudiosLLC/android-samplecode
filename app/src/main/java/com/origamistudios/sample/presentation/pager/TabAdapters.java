package com.origamistudios.sample.presentation.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.origamistudios.sample.presentation.guide.screen1;
import com.origamistudios.sample.presentation.guide.screen2;
import com.origamistudios.sample.presentation.guide.screen3;

public class TabAdapters extends FragmentPagerAdapter {

    public TabAdapters(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:

                return new screen1();
            case 1:

                return new screen2();
            case 2:

                return new screen3();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}