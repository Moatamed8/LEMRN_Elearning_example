package com.example.moatamed.gproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DataSecuirtySectionPager extends FragmentPagerAdapter {
    public DataSecuirtySectionPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                DataSecurityTextbook dataSecurityTextbook = new DataSecurityTextbook();
                return dataSecurityTextbook;

            case 1:
                DataSecurityUnit dataSecurityUnit = new DataSecurityUnit();
                return  dataSecurityUnit;



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
