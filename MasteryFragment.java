package com.leagueoflegendscalculator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.leagueoflegendscalculator.adapter.ClassCustomMasterySaved;
import com.leagueoflegendscalculator.myclasses.SavedElementsMastery;

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
 
public class MasteryFragment extends Fragment {
 
	
	List<SavedElementsMastery> masteries; 
	String[] masteryID;
	String[] savedMasterySet;
	Byte[] offenseTotal;
	Byte[] defenseTotal;
	Byte[] utilityTotal;
    ListView listViewMastery;
    TextView textMastery;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_mastery, container, false);

        
        listViewMastery = (ListView) rootView.findViewById (R.id.listViewMastery);
        textMastery = (TextView) rootView.findViewById (R.id.MasteryText);
        createMasteryList();
        ClassCustomMasterySaved dataAdapter3 = new ClassCustomMasterySaved(getActivity(), masteryID, savedMasterySet, offenseTotal, defenseTotal, utilityTotal);
        listViewMastery.setAdapter(dataAdapter3);
        

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        Editor prefsEditor = appSharedPrefs.edit();
        if (textMastery.getText().toString().equals("Select a Mastery Page")){
        	prefsEditor.putString("MasteryState", textMastery.getText().toString());//may have to put this into an if statement like if(textChampion.getText().equal("Select a champion")
        }
    	prefsEditor.commit();


        listViewMastery.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	DatabaseHelper dbMastery = new DatabaseHelper(getActivity()); 

		    	int idOfSelection = Integer.parseInt(listViewMastery.getItemAtPosition(position).toString());
		    	String masterySelection = dbMastery.getMastery(idOfSelection).getName();
		    	
		    	SavedElementsMastery obj = new SavedElementsMastery(dbMastery.getMastery(idOfSelection).getName()
		    			, dbMastery.getMastery(idOfSelection).getOffenseMasteryCount()
		    			, dbMastery.getMastery(idOfSelection).getDefenseMasteryCount()
		    			, dbMastery.getMastery(idOfSelection).getUtilityMasteryCount()
		    			, dbMastery.getMastery(idOfSelection).getDoubleEdgedSwordCount()
		    			, dbMastery.getMastery(idOfSelection).getFuryCount()
		    			, dbMastery.getMastery(idOfSelection).getSorceryCount()
		    			, dbMastery.getMastery(idOfSelection).getExposeWeaknessCount()
		    			, dbMastery.getMastery(idOfSelection).getMartialMasteryCount()
		    			, dbMastery.getMastery(idOfSelection).getArcaneMasteryCount()
		    			, dbMastery.getMastery(idOfSelection).getBladeWeavingCount()
		    			, dbMastery.getMastery(idOfSelection).getWarlordCount()
		    			, dbMastery.getMastery(idOfSelection).getArchmageCount()
		    			, dbMastery.getMastery(idOfSelection).getFrenzyCount()
		    			, dbMastery.getMastery(idOfSelection).getDevastatingStrikeCount()
		    			, dbMastery.getMastery(idOfSelection).getArcaneBladeCount()
		    			, dbMastery.getMastery(idOfSelection).getHavocCount()
		    			, dbMastery.getMastery(idOfSelection).getRecoveryCount()
		    			, dbMastery.getMastery(idOfSelection).getEnchantedArmorCount()
		    			, dbMastery.getMastery(idOfSelection).getUnyieldingCount()
		    			, dbMastery.getMastery(idOfSelection).getOppressionCount()
		    			, dbMastery.getMastery(idOfSelection).getJuggernautCount()
		    			, dbMastery.getMastery(idOfSelection).getReinforcedArmorCount()
		    			, dbMastery.getMastery(idOfSelection).getEvasiveCount()
		    			, dbMastery.getMastery(idOfSelection).getSecondWindCount()
		    			, dbMastery.getMastery(idOfSelection).getRunicBlessingCount()
		    			, dbMastery.getMastery(idOfSelection).getFleetOfFootCount()
		    			, dbMastery.getMastery(idOfSelection).getStrengthOfSpiritCount()
		    			, dbMastery.getMastery(idOfSelection).getVampirismCount()
		    			, dbMastery.getMastery(idOfSelection).getExpandedMindCount()
		    			, dbMastery.getMastery(idOfSelection).getIntelligenceCount()
		    			, dbMastery.getMastery(idOfSelection).getBruteForceCount()
		    			, dbMastery.getMastery(idOfSelection).getMentalForceCount()
		    			, dbMastery.getMastery(idOfSelection).getSpellWeavingCount()
		    			, dbMastery.getMastery(idOfSelection).getExecutionerCount()
		    			, dbMastery.getMastery(idOfSelection).getBlockCount()
		    			, dbMastery.getMastery(idOfSelection).getVeteransScarsCount()
		    			, dbMastery.getMastery(idOfSelection).getHardinessCount()
		    			, dbMastery.getMastery(idOfSelection).getResistanceCount()
		    			, dbMastery.getMastery(idOfSelection).getPerseveranceCount()
		    			, dbMastery.getMastery(idOfSelection).getMeditationCount());

		    	//dbMastery.close();
		    	
		    	textMastery.setText(masterySelection); 
		    	Toast.makeText(getActivity(), "You selected:\n" + masterySelection, Toast.LENGTH_SHORT).show();
		    	
		    	SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
		    	Editor prefsEditor = appSharedPrefs.edit();
		    	Gson gson = new Gson();
		    	String json = gson.toJson(obj);
		    	prefsEditor.putString("Mastery Page", json);
		    	prefsEditor.putString("MasteryState", textMastery.getText().toString());
		    	prefsEditor.commit();

		    }
		});
        
        
        return rootView;
    }
 
    public void createMasteryList(){
    	DatabaseHelper dbMastery = new DatabaseHelper(getActivity());   
    	
        masteries = dbMastery.getAllMasteries();  
        //dbMastery.close();
        
		   Collections.sort(masteries, new Comparator<SavedElementsMastery>() {
		        @Override
		        public int compare(final SavedElementsMastery object1, final SavedElementsMastery object2) {
		            return object1.getName().compareTo(object2.getName());
		        }
		   });
        
        int i = masteries.size();

    	masteryID = new String[i];
		savedMasterySet = new String[i];
		offenseTotal = new Byte[i];
		defenseTotal = new Byte[i];
		utilityTotal = new Byte[i];

        int j=0;
        for (SavedElementsMastery listItem : masteries) {//runs a for loop for every member of the List called contacts
        	masteryID[j] = Integer.toString(listItem.getID());
        	savedMasterySet[j] = listItem.getName();
            offenseTotal[j] = Byte.parseByte(listItem.getOffenseMasteryCount());///////////////////////
            defenseTotal[j] = Byte.parseByte(listItem.getDefenseMasteryCount());
            utilityTotal[j] = Byte.parseByte(listItem.getUtilityMasteryCount());
            
            
            if (i == j+1){
            	break;
            }
            j++;
        }
    }
    
}

