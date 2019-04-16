package com.leagueoflegendscalculator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leagueoflegendscalculator.adapter.ClassCustomMasterySaved;
import com.leagueoflegendscalculator.myclasses.SavedElementsMastery;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ViewMasteryActivity extends ActionBarActivity {

	DatabaseHelper dbMastery;
	List<SavedElementsMastery> masteries; 
	String[] masteryID;
	String[] savedMasterySet;
	Byte[] offenseTotal;
	Byte[] defenseTotal;
	Byte[] utilityTotal;
	ListView list;
	ClassCustomMasterySaved dataAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_mastery);
		
		byte byteHolder = 0;//needed for the .getByteExtra parameter
		
		Intent getValue = getIntent();
		
		//If you try to save a mastery page using the wrong conversion method, getBooleanExtra, that masterypage will be messed up even if you make revisions here.
		//When re-testing a faulty mastery page you should rebuild during the test before using it in a build just to be safe.
		String masterySetName = getValue.getStringExtra("Mastery Set Name");
		String offenseMasteryCount = String.valueOf(getValue.getByteExtra("offenseMasteryCount", byteHolder));//this list is a mixture of bytes and booleans
		String defenseMasteryCount = String.valueOf(getValue.getByteExtra("defenseMasteryCount", byteHolder));
		String utilityMasteryCount = String.valueOf(getValue.getByteExtra("utilityMasteryCount", byteHolder));
		String doubleEdgedSwordCount = String.valueOf(getIntent().getExtras().getBoolean("doubleEdgedSwordCount"));
		String furyCount = String.valueOf(getValue.getByteExtra("furyCount", byteHolder));
		String sorceryCount = String.valueOf(getValue.getByteExtra("sorceryCount", byteHolder));
		String exposeWeaknessCount = String.valueOf(getIntent().getExtras().getBoolean("exposeWeaknessCount"));
		String martialMasteryCount = String.valueOf(getIntent().getExtras().getBoolean("martialMasteryCount"));
		String arcaneMasteryCount = String.valueOf(getIntent().getExtras().getBoolean("arcaneMasteryCount"));
		String bladeWeavingCount = String.valueOf(getIntent().getExtras().getBoolean("bladeWeavingCount"));
		String warlordCount = String.valueOf(getValue.getByteExtra("warlordCount", byteHolder));
		String archmageCount = String.valueOf(getValue.getByteExtra("archmageCount", byteHolder));
		String frenzyCount = String.valueOf(getIntent().getExtras().getBoolean("frenzyCount"));
		String devastatingStrikeCount = String.valueOf(getValue.getByteExtra("devastatingStrikeCount", byteHolder));
		String arcaneBladeCount = String.valueOf(getIntent().getExtras().getBoolean("arcaneBladeCount"));
		String havocCount = String.valueOf(getIntent().getExtras().getBoolean("havocCount"));
		String recoveryCount = String.valueOf(getValue.getByteExtra("recoveryCount", byteHolder));
		String enchantedArmorCount = String.valueOf(getValue.getByteExtra("enchantedArmorCount", byteHolder));
		String unyieldingCount = String.valueOf(getIntent().getExtras().getBoolean("unyieldingCount"));
		String oppressionCount = String.valueOf(getIntent().getExtras().getBoolean("oppressionCount"));
		String juggernautCount = String.valueOf(getIntent().getExtras().getBoolean("juggernautCount"));
		String reinforcedArmorCount =String.valueOf(getIntent().getExtras().getBoolean("reinforcedArmorCount"));
		String evasiveCount = String.valueOf(getIntent().getExtras().getBoolean("evasiveCount"));
		String secondWindCount = String.valueOf(getIntent().getExtras().getBoolean("secondWindCount"));
		String runicBlessingCount = String.valueOf(getIntent().getExtras().getBoolean("runicBlessingCount"));
		String fleetOfFootCount = String.valueOf(getValue.getByteExtra("fleetOfFootCount", byteHolder));
		String strengthOfSpiritCount = String.valueOf(getIntent().getExtras().getBoolean("strengthOfSpiritCount"));
		String vampirismCount = String.valueOf(getValue.getByteExtra("vampirismCount", byteHolder));
		String expandedMindCount = String.valueOf(getValue.getByteExtra("expandedMindCount", byteHolder));
		String intelligenceCount = String.valueOf(getValue.getByteExtra("intelligenceCount", byteHolder));
		String bruteForceCount = String.valueOf(getValue.getByteExtra("bruteForceCount", byteHolder));
		String mentalForceCount = String.valueOf(getValue.getByteExtra("mentalForceCount", byteHolder));
		String spellWeavingCount = String.valueOf(getIntent().getExtras().getBoolean("spellWeavingCount"));
		String executionerCount = String.valueOf(getValue.getByteExtra("executionerCount", byteHolder));
		String blockCount = String.valueOf(getValue.getByteExtra("blockCount", byteHolder));
		String veteransScarsCount = String.valueOf(getValue.getByteExtra("veteransScarsCount", byteHolder));
		String hardinessCount = String.valueOf(getValue.getByteExtra("hardinessCount", byteHolder));
		String resistanceCount = String.valueOf(getValue.getByteExtra("resistanceCount", byteHolder));
		String perseveranceCount = String.valueOf(getValue.getByteExtra("perseveranceCount", byteHolder));
		String meditationCount = String.valueOf(getValue.getByteExtra("meditationCount", byteHolder));
		
		
		dbMastery = new DatabaseHelper(this);

        // Inserting Contacts //argument1 = itemsetname, argument2 = items
        dbMastery.addMastery(new SavedElementsMastery(masterySetName, offenseMasteryCount, defenseMasteryCount, utilityMasteryCount, doubleEdgedSwordCount, furyCount, 
        		sorceryCount, exposeWeaknessCount, martialMasteryCount, arcaneMasteryCount, bladeWeavingCount, warlordCount, archmageCount,
        		frenzyCount, devastatingStrikeCount, arcaneBladeCount, havocCount, recoveryCount, enchantedArmorCount, unyieldingCount,
        		oppressionCount, juggernautCount, reinforcedArmorCount, evasiveCount, secondWindCount, runicBlessingCount,
        		fleetOfFootCount, strengthOfSpiritCount, vampirismCount, expandedMindCount, intelligenceCount,
        		bruteForceCount, mentalForceCount, spellWeavingCount, executionerCount, blockCount, veteransScarsCount, hardinessCount,
        		resistanceCount, perseveranceCount, meditationCount));
         

        masteries = dbMastery.getAllMasteries();  
        
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
        

        dataAdapter = new ClassCustomMasterySaved(ViewMasteryActivity.this, masteryID, savedMasterySet, offenseTotal, defenseTotal, utilityTotal);
	    list = (ListView)findViewById(R.id.listViewDisplayMasterySets);
		list.setAdapter(dataAdapter);
		
		
		list.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	
		    	if(savedMasterySet[position] != " "){
		    		
			    	String idString = list.getItemAtPosition(position).toString(); 
			    	int idInt = Integer.parseInt(idString);
			    	
			    	String deletedMastery = dbMastery.getMastery(idInt).getName();
			    	dbMastery.deleteMastery(dbMastery.getMastery(idInt));
	
			    	Toast.makeText(getApplicationContext(), "You deleted " + deletedMastery, Toast.LENGTH_SHORT).show();
			    	
			    	savedMasterySet[position] = " ";
			    	offenseTotal[position] = 0;
			    	defenseTotal[position] = 0;
			    	utilityTotal[position] = 0;
			    	
			    	dataAdapter = new ClassCustomMasterySaved(ViewMasteryActivity.this, masteryID, savedMasterySet, offenseTotal, defenseTotal, utilityTotal);
					list.setAdapter(dataAdapter);
		    	}
		    }
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_view_mastery, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_main_menu){
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
