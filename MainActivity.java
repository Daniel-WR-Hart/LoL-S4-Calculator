package com.leagueoflegendscalculator;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity{

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
	}
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true; 
	}
		
	@Override
	public boolean onOptionsItemSelected(MenuItem item) { 
		int id = item.getItemId();  
		if (id == R.id.action_settings) {
			settings();
			return true;
			//Change the menu button so it says OPTIONS, and clicking it brings down a dropdown menu
			//add a view to all the menus for future updates and patch history.
			//add a view to explain all the calculations and their extent of usefulness. Also have a section in it that
			//explains why hybrid penetration runes suck.
			//add a view to all the menus for purchases.
			//purchases include:
			//Themes; Diablo 2 & 3, Warcraft 3, WoW, Starcraft 1 & 2, LoL, space, scratched steel, goth,
			//popstar, plain-science-feel, shiny diamond, and a selection of all the default android themes.
			//Default themes are free, but the others cost $0.25 each to unlock.

		}
		else if (id == R.id.action_how_to_use) {
			howToUse();
			return true;
		}
		else if (id == R.id.action_website) {
			website();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

			
     public void startButton (View v){
	     switch(v.getId()){
	     
	     case R.id.duel_simulator:
	    	Intent intentDS = new Intent(this, DuelingListActivity.class);
	    	//startActivity(intentDS);
	    	Toast.makeText(getApplicationContext(), "The Duel Simulator is down until until several bugs are resolved.",Toast.LENGTH_SHORT).show();
	    	break;
	    	/*
	     case R.id.create_graph:
	    	Intent intentCG = new Intent(this, CreateGraphActivity.class);
	    	startActivity(intentCG);
	    	break;
	    	*/
	     case R.id.create_build:
	    	Intent intentCB = new Intent(this, CreateBuildActivity.class);
	    	startActivity(intentCB);
	    	break;
	     case R.id.saved_builds:
	    	Intent intentBD = new Intent(this, SavedBuildsActivity.class);
	    	startActivity(intentBD);
	    	break;
	     case R.id.create_champion:
	    	Intent intentCC = new Intent(this, CreateChampionActivity.class);
	    	startActivity(intentCC);  
	    	break;
	     case R.id.create_item_set:
	    	Intent intentCIS = new Intent(this, CreateItemSetActivity.class);
	    	startActivity(intentCIS);
	    	break;
	     case R.id.create_runepage:
	    	Intent intentCR = new Intent(this, CreateRunepageActivity.class);
	    	startActivity(intentCR);
	    	break;
	     case R.id.create_mastery_page:
	    	Intent intentCM = new Intent(this, CreateMasteryPageActivity.class);
	    	startActivity(intentCM);
	    	break;

       	}
    }
    

     
     public void settings(){
    	 
     }
     public void howToUse(){
    	 Toast.makeText(MainActivity.this, "For details on how all the calculations are done and the general design, visit\nhttp://leagueoflegendscalculator.com\nCertain calculations are done under certain assumptions that must be considered by the user.", Toast.LENGTH_LONG).show();
     }
     public void website(){
    	 Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
    	 myWebLink.setData(Uri.parse("http://leagueoflegendscalculator.com"));
    	 startActivity(myWebLink);
     }
     
}
