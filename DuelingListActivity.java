package com.leagueoflegendscalculator;



import com.leagueoflegendscalculator.adapter.TabsPagerAdapterDuel;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;

public class DuelingListActivity extends ActionBarActivity implements ActionBar.TabListener {
	
    private ViewPager viewPager;
    private TabsPagerAdapterDuel mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = {"Build 1", "Build 2", "Build 3 (optional)", "Build 4 (optional)", "Build 5 (optional)"};
    byte numberOfBuilds = 0;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dueling_list);
 
        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        //prevents fragments from losing their information when another one is called (spacing of 5)
        viewPager.setOffscreenPageLimit(5);
        actionBar = getSupportActionBar();
        mAdapter = new TabsPagerAdapterDuel(getSupportFragmentManager());
 
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
 


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		getMenuInflater().inflate(R.menu.menu_duel_simulator_activity, menu);
		return true;
	}
		
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_item_stacks) {
			itemStacks();
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

			
     public void itemStacks(){
 		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
 		Editor prefsEditor = appSharedPrefs.edit();
 		
 		//loads the TextView info for the conditions below
 		String A = appSharedPrefs.getString("Build 1 State", "");
 		String B = appSharedPrefs.getString("Build 2 State", "");
 		String C = appSharedPrefs.getString("Build 3 State", "");
 		String D = appSharedPrefs.getString("Build 4 State", "");
 		String E = appSharedPrefs.getString("Build 5 State", "");
 		String Con = "Select a Build"; 
 		

 		
 		boolean selected5 = !A.equals(Con) && !B.equals(Con) && !C.equals(Con) && !D.equals(Con) && !E.equals(Con);
 		boolean selected4 = !A.equals(Con) && !B.equals(Con) && !C.equals(Con) && !D.equals(Con) && E.equals(Con);	
 		boolean selected3 = !A.equals(Con) && !B.equals(Con) && !C.equals(Con) && D.equals(Con) && E.equals(Con) ;	
 		boolean selected2 = !A.equals(Con) && !B.equals(Con) && C.equals(Con) && D.equals(Con) && E.equals(Con);
 		
 		if (selected5 == true){
 			numberOfBuilds = 5;
 		}
 		else if (selected4 == true){
 			numberOfBuilds = 4;
 		}
 		else if (selected3 == true){
 			numberOfBuilds = 3;
 		}
 		else if (selected2 == true){
 			numberOfBuilds = 2;
 		}
 		
 		
 		
 		if((selected5 || selected4 || selected3 || selected2) == true){
 			prefsEditor.putInt("Number of Builds", numberOfBuilds);
 			prefsEditor.commit();
 			//Intent intent = new Intent(this, DuelSimulatorItemStacksActivity.class);
 			Intent intent = new Intent(this, DuelResultsActivity.class);
 			startActivity(intent);
 		}
 		else{
 			Toast.makeText(this, "Choose builds from at least two lists and in order, i.e. if you choose four builds they must be from the first four lists.", Toast.LENGTH_LONG).show();
 		}
    }
 
    
    
    
}




