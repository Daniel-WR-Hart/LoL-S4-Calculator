package com.leagueoflegendscalculator.adapter;


import com.leagueoflegendscalculator.DuelList1Fragment;
import com.leagueoflegendscalculator.DuelList2Fragment;
import com.leagueoflegendscalculator.DuelList3Fragment;
import com.leagueoflegendscalculator.DuelList4Fragment;
import com.leagueoflegendscalculator.DuelList5Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapterDuel extends FragmentPagerAdapter {
 
    public TabsPagerAdapterDuel(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            return new DuelList1Fragment();
        case 1:
            return new DuelList2Fragment();
        case 2:
            return new DuelList3Fragment();
        case 3:
        	return new DuelList4Fragment();
        case 4:
        	return new DuelList5Fragment();
        }
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 5;
    }
 
}