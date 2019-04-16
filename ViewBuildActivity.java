package com.leagueoflegendscalculator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.leagueoflegendscalculator.adapter.ClassCustomBuildSaved;
import com.leagueoflegendscalculator.myclasses.SavedElementsBuilds;
import com.leagueoflegendscalculator.myclasses.SavedElementsChampions;
import com.leagueoflegendscalculator.myclasses.SavedElementsItems;
import com.leagueoflegendscalculator.myclasses.SavedElementsMastery;
import com.leagueoflegendscalculator.myclasses.SavedElementsRunes;
import com.leagueoflegendscalculator.myclasses.SetChampionPicture;
import com.leagueoflegendscalculator.myclasses.SetItemPicture;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.preference.PreferenceManager;

public class ViewBuildActivity extends ActionBarActivity {


	DatabaseHelper dbBuild;
	List<SavedElementsBuilds> builds;
	String[] buildID;
	String[] buildName;
	String[] championInfo;
	Integer[] championImage;
    String[] itemSetName; 
    Integer[] itemImage1; 
    Integer[] itemImage2; 
    Integer[] itemImage3;
    Integer[] itemImage4; 
    Integer[] itemImage5;
    Integer[] itemImage6; 
    String[] masteryPageName;
    String[] runePageName; 
	ListView list;
	ClassCustomBuildSaved dataAdapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_build);

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
		Gson gson = new Gson();

		//Retrieve the String information selected by the user in the Create Build Section
		String name = appSharedPrefs.getString("Build Name", "");
		String championInputString = appSharedPrefs.getString("Champion", "");
		String itemInputString = appSharedPrefs.getString("Item Set", "");
		String masteryInputString = appSharedPrefs.getString("Mastery Page", "");
		String runeInputString = appSharedPrefs.getString("Rune Page", "");
		
		//Add the latest build to the Build Table of builds and retrieve the Build Table
		dbBuild = new DatabaseHelper(this);
		dbBuild.addBuild(new SavedElementsBuilds(name, championInputString, itemInputString, masteryInputString, runeInputString));
		builds = dbBuild.getAllBuilds();   
		
		Collections.sort(builds, new Comparator<SavedElementsBuilds>() {
		        @Override
		        public int compare(final SavedElementsBuilds object1, final SavedElementsBuilds object2) {
		            return object1.getName().compareTo(object2.getName());
		        }
		});
		
		
		int i = builds.size();
    	buildID= new String[i];
    	buildName= new String[i];
        championInfo = new String[i];
        championImage = new Integer[i];
        itemSetName = new String[i];
        itemImage1= new Integer[i];
        itemImage2 = new Integer[i];
        itemImage3 = new Integer[i];
        itemImage4 = new Integer[i];
        itemImage5 = new Integer[i];
        itemImage6 = new Integer[i];
        masteryPageName = new String[i];
        runePageName = new String[i];
	        
        //Create the arrays that will contain the data for each build taken from the Build Table
	    int j=0;
	    for (SavedElementsBuilds listBuild : builds) {
	    
	    	SavedElementsChampions championInput = gson.fromJson(listBuild.getChampionInputString(), SavedElementsChampions.class);
			SavedElementsItems itemInput = gson.fromJson(listBuild.getItemInputString(), SavedElementsItems.class);
			SavedElementsMastery masteryInput = gson.fromJson(listBuild.getMasteryInputString(), SavedElementsMastery.class);
			SavedElementsRunes runeInput = gson.fromJson(listBuild.getRuneInputString(), SavedElementsRunes.class);
			
	    	
        	buildID[j] = Integer.toString(listBuild.getID());
        	buildName[j] = listBuild.getName();
            championInfo[j] =  championInput.getName()
            		+ ", Level " + championInput.getLevel() 
            		+ "\nQ/W/E/R = " + championInput.getQSkill() 
            		+"/"+ championInput.getWSkill() 
            		+"/"+ championInput.getESkill() 
            		+"/"+ championInput.getRSkill();
            
            SetChampionPicture championImageObject = new SetChampionPicture(championInput.getName());
            championImage[j] = championImageObject.championPicture;
            itemSetName[j] = itemInput.getName();
            SetItemPicture itemImageObject = new SetItemPicture(itemInput.getItem1(), itemInput.getItem2(), itemInput.getItem3(), itemInput.getItem4(), itemInput.getItem5(), itemInput.getItem6());
            itemImage1[j] = itemImageObject.itemPicture[0];
            itemImage2[j] = itemImageObject.itemPicture[1];
            itemImage3[j] = itemImageObject.itemPicture[2];
            itemImage4[j] = itemImageObject.itemPicture[3];
            itemImage5[j] = itemImageObject.itemPicture[4];
            itemImage6[j] = itemImageObject.itemPicture[5];
            masteryPageName[j] = masteryInput.getName();
            runePageName[j] = runeInput.getName();
                            
            if (i == j+1){
            	break;
            }
            j++;
        }
        
        //Populate the ListView with the information from the arrays
        dataAdapter = new ClassCustomBuildSaved(ViewBuildActivity.this, buildID, buildName, championInfo, championImage, itemSetName, itemImage1, itemImage2, itemImage3, itemImage4, itemImage5, itemImage6, masteryPageName, runePageName);
	    list = (ListView)findViewById(R.id.listViewDisplaySavedBuilds);
		list.setAdapter(dataAdapter);

					
		//Set the OnItemClickListener to delete the build and info from the cell that is clicked
		list.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		    	if(buildName[position] != " "){
		    		//turn the name of the cell into an integer
			    	String idString = list.getItemAtPosition(position).toString(); 
			    	int idInt = Integer.parseInt(idString);
			    	
			    	//save the cell info of the cell to be deleted, then delete it
			    	String deletedBuild = dbBuild.getBuild(idInt).getName();
			    	dbBuild.deleteBuild(dbBuild.getBuild(idInt));
	
			    	//make a temporary message saying that the cell was deleted
			    	Toast.makeText(getApplicationContext(), "You deleted " + deletedBuild, Toast.LENGTH_SHORT).show();
			    	
			    	//erase the info on the cell associated with the deleted info
			    	buildName[position] = " ";
			    	championInfo[position] = " ";
			    	championImage[position] = R.drawable.c_blank;
			    	itemSetName[position] = " ";
			    	itemImage1[position] = R.drawable.i_blankspace;
			    	itemImage2[position] = R.drawable.i_blankspace;
			    	itemImage3[position] = R.drawable.i_blankspace;
			    	itemImage4[position] = R.drawable.i_blankspace;
			    	itemImage5[position] = R.drawable.i_blankspace;
			    	itemImage6[position] = R.drawable.i_blankspace;
			    	masteryPageName[position] = " ";
			    	runePageName[position] = " ";
			    	
			    	//rebuild the ListView to show the changes in cell info
			    	dataAdapter = new ClassCustomBuildSaved(ViewBuildActivity.this, buildID, buildName, championInfo, championImage, itemSetName, itemImage1, itemImage2, itemImage3, itemImage4, itemImage5, itemImage6, masteryPageName, runePageName);
					list.setAdapter(dataAdapter);
		    	}
		    }
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_view_build, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_main_menu) {
			backToMainMenu();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	
	public void backToMainMenu(){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
