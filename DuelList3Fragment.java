package com.leagueoflegendscalculator;

//Your choice of either:
//group comparison of size 2-5
//list comparison of size 1:1 - 4:4



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

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DuelList3Fragment extends Fragment {
	
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
	ClassCustomBuildSaved dataAdapter1;
	String[] championKey;
	String[] itemKey;
	String[] masteryKey;
	String[] runeKey;
	ListView listViewBuild;
	TextView textBuild;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_duel_list3, container, false);

		
	    //Populate the Listview with these arrays so that each build has it's own cell
      listViewBuild = (ListView) rootView.findViewById (R.id.duel_list3);
      textBuild = (TextView) rootView.findViewById (R.id.duel_selection3);
      createBuildList();
      ClassCustomBuildSaved dataAdapter3 = new ClassCustomBuildSaved(getActivity(), buildID, buildName, championInfo, championImage, itemSetName, itemImage1, itemImage2, itemImage3, itemImage4, itemImage5, itemImage6, masteryPageName, runePageName);
      listViewBuild.setAdapter(dataAdapter3);
		
      
      //Sets the default value for the champion test value to prevent the app from crashing if the person tries to save the build without selecting a champion
      SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
      Editor prefsEditor = appSharedPrefs.edit();
      if (textBuild.getText().toString().equals("Select a Build")){
      	prefsEditor.putString("Build 3 State", textBuild.getText().toString());
      }
  	prefsEditor.commit();
  	
  	
		//Set the OnItemClickListener to send the build components of the selected build to the BuildInfoActivity to be displayed in greater detail
		listViewBuild.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	
		    	//set up the cell info as a string
		    	int idOfSelection = Integer.parseInt(listViewBuild.getItemAtPosition(position).toString());
		    	String buildSelection = dbBuild.getBuild(idOfSelection).getName();
		        
		    	//display the cell info as a message and TextView to show the user what they selected
			    textBuild.setText(buildSelection); 
		    	Toast.makeText(getActivity(), "You selected:\n" + buildSelection, Toast.LENGTH_SHORT).show();
		    	
		    	//save the selected build
		    	SavedElementsBuilds obj = new SavedElementsBuilds(buildName[position], championKey[position], itemKey[position], masteryKey[position], runeKey[position]);
		    	SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
		    	Editor prefsEditor = appSharedPrefs.edit();
		    	Gson gson = new Gson();
		    	String json = gson.toJson(obj);
		    	prefsEditor.putString("Build 3", json);
		    	prefsEditor.putString("Build 3 State", textBuild.getText().toString());
		    	prefsEditor.commit();
		    }
		}); 
		

		
		
		 return rootView;
	}



	
	public void createBuildList(){

		Gson gson = new Gson();
		//Get all the saved builds
		dbBuild = new DatabaseHelper(getActivity());
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
      championKey = new String[i];
      itemKey = new String[i];
      masteryKey = new String[i];
      runeKey = new String[i];

      //Populate the arrays with the data from the retrieved builds
	    int j=0;
	    for (SavedElementsBuilds listBuild : builds) {//runs a for loop for every member of the List called contacts
	    	
	    	//the SavedBuildsActivity object contains strings that are the keywords used to retrieve the corresponding objects that were saved with them
	    	championKey[j] = listBuild.getChampionInputString();
	    	itemKey[j] = listBuild.getItemInputString();
	    	masteryKey[j] = listBuild.getMasteryInputString();
	    	runeKey[j] = listBuild.getRuneInputString();

	    	SavedElementsChampions championInput = gson.fromJson(championKey[j], SavedElementsChampions.class);
			SavedElementsItems itemInput = gson.fromJson(itemKey[j], SavedElementsItems.class);
			SavedElementsMastery masteryInput = gson.fromJson(masteryKey[j], SavedElementsMastery.class);
			SavedElementsRunes runeInput = gson.fromJson(runeKey[j], SavedElementsRunes.class);

			
      	buildID[j] = Integer.toString(listBuild.getID());
      	buildName[j] = listBuild.getName();
          championInfo[j] =  championInput.getName()
          		+ ", Level " + championInput.getLevel() 
          		+ "\nQ/W/E/R = " + championInput.getQSkill() 
          		+"/"+ championInput.getWSkill() 
          		+"/"+ championInput.getESkill() 
          		+"/"+ championInput.getRSkill();
          
          SetChampionPicture champImage = new SetChampionPicture(championInput.getName());
          championImage[j] = champImage.championPicture;
          itemSetName[j] = itemInput.getName();
          SetItemPicture itemImage = new SetItemPicture(itemInput.getItem1(), itemInput.getItem2(), itemInput.getItem3(), itemInput.getItem4(), itemInput.getItem5(), itemInput.getItem6());
          itemImage1[j] = itemImage.itemPicture[0];
          itemImage2[j] = itemImage.itemPicture[1];
          itemImage3[j] = itemImage.itemPicture[2];
          itemImage4[j] = itemImage.itemPicture[3];
          itemImage5[j] = itemImage.itemPicture[4];
          itemImage6[j] = itemImage.itemPicture[5];
          masteryPageName[j] = masteryInput.getName();
          runePageName[j] = runeInput.getName();
                     
          if (i == j+1){
          	break;
          }
          j++;
      }
	}
	
	
}

