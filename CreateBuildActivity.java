package com.leagueoflegendscalculator;

//The imports here and minor modification in the code are to make the TabListener work for API below 11
import com.leagueoflegendscalculator.adapter.TabsPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;




//The Android Lint tool is like a warning system that works when your code is not optimal or is about to crash.
//In this case, @SuppressLint("NewApi") means to ignore warnings that your device is not compatible with a higher API feature.
//My device is an Android 2.3.5 / API 10, but ActionBar.TabListener requires at least API 11. One recommendation by Eclipse is to add
//@SuppressLint("NewApi") to get rid of the problem, which is why this works on the emulator for Nexus 10 (Android 4.4.2), but not
//for my Samsung Galaxy Player 5.0. My mistake was not realizing that the quick fix by Eclipse did not actually solve the problem.
//When LogCat says that CreateBuildActivity cannot be found, it actually means that there is a class INSIDE CreateBuildActivity that
//cannot be found (People on stackoverflow.com pointed this part out). 
//Without @SuppressLint("NewApi") and with an increased value for the minimum API in manifest.xml, my physical device would not show up 
//on the list of devices to test on. By using SuppressLint, my device would show up on the list but would crash at the part that requires API 11.
//@SuppressLint("NewApi")

public class CreateBuildActivity extends ActionBarActivity implements ActionBar.TabListener {
	
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "Champions", "Items", "Masteries", "Runepages", "Build Name"};
    

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_build);
 
        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        //prevents fragments from losing their information when another one is called (spacing of 5)
        viewPager.setOffscreenPageLimit(5);
        //actionBar = getActionBar();
        actionBar = getSupportActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);       
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }
 
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        
        
    }
 
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
 
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }
 
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }
 
	


    
}


