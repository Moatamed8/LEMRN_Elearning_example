package com.example.moatamed.gproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CloudSectionPager extends FragmentPagerAdapter {
    public CloudSectionPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                CloudTextBook cloudTextBook = new CloudTextBook();
                return cloudTextBook;

            case 1:
                CloudUnit cloudUnit = new CloudUnit();
                return  cloudUnit;



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
