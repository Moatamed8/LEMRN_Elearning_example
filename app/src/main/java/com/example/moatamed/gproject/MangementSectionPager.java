package com.example.moatamed.gproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MangementSectionPager extends FragmentPagerAdapter {
    public MangementSectionPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                MangementTextBook mangementTextBook = new MangementTextBook();
                return mangementTextBook;

            case 1:
                MangementFUnit mangementFUnit = new MangementFUnit();
                return  mangementFUnit;



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
