package com.example.moatamed.gproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class IntroductionSectionPager extends FragmentPagerAdapter {
    public IntroductionSectionPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                IntroductionFTextBook introductionFTextBook = new IntroductionFTextBook();
                return introductionFTextBook;

            case 1:
                IntroductionFUnit introductionFUnit = new IntroductionFUnit();
                return  introductionFUnit;



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
