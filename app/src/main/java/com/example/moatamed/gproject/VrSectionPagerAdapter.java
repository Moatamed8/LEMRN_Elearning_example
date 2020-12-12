package com.example.moatamed.gproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class VrSectionPagerAdapter extends FragmentPagerAdapter {
    public VrSectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
              VrTextBook vrTextBook=new VrTextBook();
              return vrTextBook;

            case 1:
                VrUnit vrUnit=new VrUnit();
                return vrUnit;



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

