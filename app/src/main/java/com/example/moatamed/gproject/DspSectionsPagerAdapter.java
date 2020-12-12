package com.example.moatamed.gproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by moatamed on 3/9/2019.
 */

class DspSectionsPagerAdapter extends FragmentPagerAdapter{
    public DspSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                TextBookFragment textBookFragment = new TextBookFragment();
                return textBookFragment;

            case 1:
                DspUnitFragment dspUnitFragment = new DspUnitFragment();
                return  dspUnitFragment;



            default:
                return  null;
        }
    }

    @Override
    public int getCount() {

        return 2;
    }
    public CharSequence getPageTitle(int position){

        switch (position) {
            case 0:
                return "TEXTBOOK";

            case 1:
                return "UNITS";



            default:
                return null;
        }

    }
}
