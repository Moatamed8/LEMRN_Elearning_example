package com.example.moatamed.gproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ParrelleSectionPager extends FragmentPagerAdapter {
    public ParrelleSectionPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                ParrelleTextbook parrelleTextbook = new ParrelleTextbook();
                return parrelleTextbook;

            case 1:
                ParrelleUnit parrelleUnit = new ParrelleUnit();
                return  parrelleUnit;



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

