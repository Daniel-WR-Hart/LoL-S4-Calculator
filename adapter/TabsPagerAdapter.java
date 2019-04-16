package com.leagueoflegendscalculator.adapter;



import com.leagueoflegendscalculator.BuildFragment;
import com.leagueoflegendscalculator.ChampionFragment;
import com.leagueoflegendscalculator.ItemFragment;
import com.leagueoflegendscalculator.MasteryFragment;
import com.leagueoflegendscalculator.RunepageFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            return new ChampionFragment();
        case 1:
            return new ItemFragment();
        case 2:
            return new MasteryFragment();
        case 3:
        	return new RunepageFragment();
        case 4:
        	return new BuildFragment();
        }
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 5;
    }
 
}