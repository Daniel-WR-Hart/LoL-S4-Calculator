package com.leagueoflegendscalculator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.leagueoflegendscalculator.adapter.ClassCustomChampSaved;
import com.leagueoflegendscalculator.myclasses.SavedElementsChampions;
import com.leagueoflegendscalculator.myclasses.SetChampionPicture;

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
 
public class ChampionFragment extends Fragment{
 
	
	List<SavedElementsChampions> champions;
	String[] championID;
	String[] savedChampion;
	Integer[] savedChampionImage;
	ListView listViewChampion;
	TextView textChampion;
	
	
	
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_champion, container, false);
        //Creates and fills the ListView
        listViewChampion = (ListView) rootView.findViewById (R.id.listViewChampion);
        textChampion = (TextView) rootView.findViewById (R.id.ChampionText);
        createChampionList();
        ClassCustomChampSaved dataAdapter1 = new ClassCustomChampSaved(getActivity(), championID, savedChampion, savedChampionImage);
        listViewChampion.setAdapter(dataAdapter1);
        
        //Sets the default value for the champion test value to prevent the app from crashing if the person tries to save the build without selecting a champion
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        Editor prefsEditor = appSharedPrefs.edit();
        if (textChampion.getText().toString().equals("Select a Champion")){
        	prefsEditor.putString("ChampionState", textChampion.getText().toString());
        }
    	prefsEditor.commit();


        listViewChampion.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	DatabaseHelper dbChamp = new DatabaseHelper(getActivity());
		    	
		    	//set up the cell info as a string
		    	int idOfSelection = Integer.parseInt(listViewChampion.getItemAtPosition(position).toString());
		    	String champSelection = dbChamp.getChampion(idOfSelection).getName() + ", Level " + dbChamp.getChampion(idOfSelection).getLevel() + "\nQ/W/E/R = " + dbChamp.getChampion(idOfSelection).getQSkill() +"/"+ dbChamp.getChampion(idOfSelection).getWSkill() +"/"+ dbChamp.getChampion(idOfSelection).getESkill() +"/"+ dbChamp.getChampion(idOfSelection).getRSkill();
		        
		    	//display the cell info as a message and TextView to show the user what they selected
			    textChampion.setText(champSelection); 
		    	Toast.makeText(getActivity(), "You selected:\n" + champSelection, Toast.LENGTH_SHORT).show();
		    	
		    	//save the selected champion
		    	SavedElementsChampions obj = new SavedElementsChampions(dbChamp.getChampion(idOfSelection).getName(), dbChamp.getChampion(idOfSelection).getLevel(), dbChamp.getChampion(idOfSelection).getQSkill(), dbChamp.getChampion(idOfSelection).getWSkill(), dbChamp.getChampion(idOfSelection).getESkill(), dbChamp.getChampion(idOfSelection).getRSkill());
		    	SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
		    	
		    	//dbChamp.close();
		    	
		    	Editor prefsEditor = appSharedPrefs.edit();
		    	Gson gson = new Gson();
		    	String json = gson.toJson(obj);
		    	prefsEditor.putString("Champion", json);
		    	prefsEditor.putString("ChampionState", textChampion.getText().toString());
		    	prefsEditor.commit();
		    }
		});
        
        
 
        return rootView;
        
    }
    
    
    
    public void createChampionList(){

    	DatabaseHelper dbChamp = new DatabaseHelper(getActivity());
		champions = dbChamp.getAllChampions(); 
        //dbChamp.close();
		
        
		Collections.sort(champions, new Comparator<SavedElementsChampions>() {
		        @Override
		        public int compare(final SavedElementsChampions object1, final SavedElementsChampions object2) {
		            return object1.getName().compareTo(object2.getName());
		        }
		});
		
		
		int i = champions.size();

        championID = new String[i];
		savedChampion = new String[i];
		savedChampionImage = new Integer[i];
        
        int j=0;
        for (SavedElementsChampions listChamp : champions) {//runs a for loop for every member of the List called contacts
        	championID[j] = Integer.toString(listChamp.getID());
            savedChampion[j] = listChamp.getName() + "\nLevel " + listChamp.getLevel() + ", Q/W/E/R = " + listChamp.getQSkill() +"/"+ listChamp.getWSkill() +"/"+ listChamp.getESkill() +"/"+ listChamp.getRSkill();
            SetChampionPicture championImageObject = new SetChampionPicture(listChamp.getName());
            savedChampionImage[j] = championImageObject.championPicture;
            if (i == j+1){
            	break;
            }
            j++;
        }
    }
    
   
}
