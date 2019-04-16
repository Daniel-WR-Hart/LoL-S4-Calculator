package com.leagueoflegendscalculator;

import com.google.android.gms.ads.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.leagueoflegendscalculator.adapter.ClassCustomBuildSaved;
import com.leagueoflegendscalculator.myclasses.ClassChampion;
import com.leagueoflegendscalculator.myclasses.ClassItems;
import com.leagueoflegendscalculator.myclasses.ClassMastery;
import com.leagueoflegendscalculator.myclasses.ClassRunes;
import com.leagueoflegendscalculator.myclasses.ClassStatCalculations;
import com.leagueoflegendscalculator.myclasses.ConvertSavedElementsBuildsToClassStatCalculations;
import com.leagueoflegendscalculator.myclasses.SavedElementsBuilds;
import com.leagueoflegendscalculator.myclasses.SavedElementsChampions;
import com.leagueoflegendscalculator.myclasses.SavedElementsItems;
import com.leagueoflegendscalculator.myclasses.SavedElementsMastery;
import com.leagueoflegendscalculator.myclasses.SavedElementsRunes;
import com.leagueoflegendscalculator.myclasses.SetChampionPicture;
import com.leagueoflegendscalculator.myclasses.SetItemPicture;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SavedBuildsActivity extends ActionBarActivity {
	
	
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
	String[] championKey;
	String[] itemKey;
	String[] masteryKey;
	String[] runeKey;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saved_builds);
		
	    // Look up the AdView as a resource and load a request.
	    AdView adView = (AdView) this.findViewById(R.id.adView);
	    AdRequest adRequest = new AdRequest.Builder().build();
	    adView.loadAd(adRequest);

		
		//Get all the saved builds
		DatabaseHelper dbBuild = new DatabaseHelper(this);
		builds = dbBuild.getAllBuilds();   
		dbBuild.close();
		
		//sorts builds by build name by default
		Collections.sort(builds, new Comparator<SavedElementsBuilds>() {
		        @Override
		        public int compare(final SavedElementsBuilds object1, final SavedElementsBuilds object2) {
		            return object1.getName().compareToIgnoreCase(object2.getName());
		        }
		});
		
		//creates all the arrays that will be used to populate the ListView using the list of objects, "builds"
		createList();

        
	    //Populate the Listview with these arrays so that each build has it's own cell
        dataAdapter = new ClassCustomBuildSaved(SavedBuildsActivity.this, buildID, buildName, championInfo, championImage, itemSetName, itemImage1, itemImage2, itemImage3, itemImage4, itemImage5, itemImage6, masteryPageName, runePageName);
	    list = (ListView)findViewById(R.id.listViewDisplaySavedBuilds);
		list.setAdapter(dataAdapter);

		//Set the OnItemClickListener to send the build components of the selected build to the BuildInfoActivity to be displayed in greater detail
		list.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	buildInfo(position);
		    }
		}); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_saved_builds, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_sort_by_name) {
			sortByName();
			return true;

		}
		else if (id == R.id.action_sort_by_champ) {
			sortByChamp();
			return true;

		}
		else if (id == R.id.action_sort_by_dps) {
			sortByDps();
			return true;

		}
		return super.onOptionsItemSelected(item);
	}
	
	public void sortByName(){//Build Name
		   Collections.sort(builds, new Comparator<SavedElementsBuilds>() {
		        @Override
		        public int compare(final SavedElementsBuilds object1, final SavedElementsBuilds object2) {
		            return object1.getName().compareToIgnoreCase(object2.getName());
		        }
		   });
		   
		   createList();
	       dataAdapter = new ClassCustomBuildSaved(SavedBuildsActivity.this, buildID, buildName, championInfo, championImage, itemSetName, itemImage1, itemImage2, itemImage3, itemImage4, itemImage5, itemImage6, masteryPageName, runePageName);
		   list.setAdapter(dataAdapter);
	}
	
	public void sortByChamp(){//Champ Name
		   Collections.sort(builds, new Comparator<SavedElementsBuilds>() {
		        @Override
		        public int compare(final SavedElementsBuilds object1, final SavedElementsBuilds object2) {
		        	Gson gson = new Gson();
		        	SavedElementsChampions championInput1 = gson.fromJson(object1.getChampionInputString(), SavedElementsChampions.class);
		        	SavedElementsChampions championInput2 = gson.fromJson(object2.getChampionInputString(), SavedElementsChampions.class);
		        	object1.champName = championInput1.getName();
		        	object2.champName = championInput2.getName();
		            return object1.champName.compareToIgnoreCase(object2.champName);
		        }
		   });
		   createList();
	       dataAdapter = new ClassCustomBuildSaved(SavedBuildsActivity.this, buildID, buildName, championInfo, championImage, itemSetName, itemImage1, itemImage2, itemImage3, itemImage4, itemImage5, itemImage6, masteryPageName, runePageName);
		   list.setAdapter(dataAdapter);
	}
	
	public void sortByDps(){
		
		   Collections.sort(builds, new Comparator<SavedElementsBuilds>() {
		        @Override
		        public int compare(final SavedElementsBuilds buildInput1, final SavedElementsBuilds buildInput2) {

					//put those input into this method that returns the correct DPS (same as the DPS shown in the 
		        	buildInput1.dps = adjustDPSForUniquePassivesAndChampionPassives(buildInput1);
		        	buildInput2.dps = adjustDPSForUniquePassivesAndChampionPassives(buildInput2);

		        	//conditions used to sort the builds in order of highest to lowest DPS
		        	if (buildInput1.dps < buildInput2.dps){
		        		return 1;
		        	}
		        	else if (buildInput1.dps > buildInput2.dps){
		        		return -1;
		        	}
		        	else{
		        		return 0;
		        	}
		        }
		   });
		   createList();
		   dataAdapter = new ClassCustomBuildSaved(SavedBuildsActivity.this, buildID, buildName, championInfo, championImage, itemSetName, itemImage1, itemImage2, itemImage3, itemImage4, itemImage5, itemImage6, masteryPageName, runePageName);
		   list.setAdapter(dataAdapter);
	}
	

	
	public void createList(){
		Gson gson = new Gson();
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
	
	
	
	public double adjustDPSForUniquePassivesAndChampionPassives(SavedElementsBuilds buildInput){

		ClassStatCalculations statFinal = new ConvertSavedElementsBuildsToClassStatCalculations(buildInput).statFinal;
		
		if (statFinal.insightPassive == true){
			statFinal.manaFinal *= 1.03;
		}
		
		updateAP(statFinal);
		if(statFinal.nashorsToothPassive == true){
			statFinal.bonusMagicAttackDamageExtra += 15 + (statFinal.abilityPowerFinal * 0.15);
		}
		if (statFinal.arcaneBlade > 0){
			statFinal.bonusMagicAttackDamageFinal = statFinal.bonusMagicAttackDamageExtra + (statFinal.arcaneBlade * statFinal.abilityPowerFinal);
		}
		if (statFinal.spiritVisagePassive == true){
			statFinal.healthRegenFinal *= 1.2;
			statFinal.lifestealPercentFinal *=1.2;
		}
		if(statFinal.awePassive == true){
			statFinal.bonusPhysicalAttackDamageFinal += statFinal.manaFinal*(0.02);
		}
		if (statFinal.movementSpeedFinal > 490){
			statFinal.movementSpeedFinal = (statFinal.movementSpeedFinal * 0.5) + 230;
		}
		else if (statFinal.movementSpeedFinal > 415){
			statFinal.movementSpeedFinal = (statFinal.movementSpeedFinal * 0.8) + 83;
		}
		
		String champName = statFinal.champName;
		
		if (champName.equals("Akali")){
			statFinal.bonusMagicAttackDamageExtra += ((0.06 + statFinal.abilityPowerFinal/600) * statFinal.attackDamageFinal);
			statFinal.spellVampFinal += 0.06 + statFinal.attackDamageBonus/600;
		}
		else if (champName.equals("Corki")){
			statFinal.bonusPhysicalAttackDamageFinal += 1.1 * statFinal.attackDamageFinal;
		}
		else if (champName.equals("Hecarim")){
			if (statFinal.level < 3){
				statFinal.attackDamageBonus += 0.1 * statFinal.movementSpeedFinal;
			}
			else if (statFinal.level < 6){
				statFinal.attackDamageBonus += 0.125 * statFinal.movementSpeedFinal;
			}
			else if (statFinal.level < 9){
				statFinal.attackDamageBonus += 0.15 * statFinal.movementSpeedFinal;
			}
			else if (statFinal.level < 12){
				statFinal.attackDamageBonus += 0.175 * statFinal.movementSpeedFinal;
			}
			else if (statFinal.level < 15){
				statFinal.attackDamageBonus += 0.2 * statFinal.movementSpeedFinal;
			}
			else if (statFinal.level < 18){
				statFinal.attackDamageBonus += 0.225 * statFinal.movementSpeedFinal;
			}
			else{
				statFinal.attackDamageBonus += 0.25 * statFinal.movementSpeedFinal;
			}
		}
		else if (champName.equals("Orianna")){
			if (statFinal.level < 3){
				statFinal.bonusMagicAttackDamageFinal += 10 + (0.15 * statFinal.abilityPowerFinal);
			}
			else if (statFinal.level < 6){
				statFinal.bonusMagicAttackDamageFinal += 18 + (0.15 * statFinal.abilityPowerFinal);
			}
			else if (statFinal.level < 9){
				statFinal.bonusMagicAttackDamageFinal += 26 + (0.15 * statFinal.abilityPowerFinal);
			}
			else if (statFinal.level < 12){
				statFinal.bonusMagicAttackDamageFinal += 34 + (0.15 * statFinal.abilityPowerFinal);
			}
			else if (statFinal.level < 15){
				statFinal.bonusMagicAttackDamageFinal += 42 + (0.15 * statFinal.abilityPowerFinal);
			}
			else{
				statFinal.bonusMagicAttackDamageFinal += 50 + (0.15 * statFinal.abilityPowerFinal);
			}
		}
		else if (champName.equals("Rammus")){
			statFinal.bonusPhysicalAttackDamageFinal += 0.25 * statFinal.armorFinal;
		}
		
		updateAP(statFinal);
		updateHP(statFinal);
		if (champName.equals("Vladimir")){
			double vladAP = (0.025 * statFinal.healthExtra);
			double vladHP = 1.4 * statFinal.abilityPowerFinal;

			statFinal.abilityPowerExtra += vladAP;
			statFinal.healthFinal += vladHP * (1 + statFinal.juggernaut + statFinal.HealthPercentRuneTotal);//increases Vlad's final health directly and apply mult. bonuses
		}
		else if (champName.equals("Yasuo")){
			statFinal.criticalChanceFinal *= 2;
		}
		else if (champName.equals("Yasuo")){
			statFinal.criticalChanceFinal *= 2;
		}
		

		if(statFinal.atmasImpalerPassive == true){
			statFinal.attackDamageBonus += statFinal.healthFinal*(0.015);
		}
		
		
		statFinal.attackSpeedFinal = statFinal.attackSpeedBase * (1 + statFinal.attackSpeedBonus);
		if (statFinal.attackSpeedFinal > 2.5){
			statFinal.attackSpeedFinal = 2.5;
		}
		if (statFinal.criticalChanceFinal > 1){
			statFinal.criticalChanceFinal = 1;
		}
		
		statFinal.attackDamageNoCritical = (statFinal.attackDamageBase + statFinal.attackDamageBonus) * (1 + statFinal.havoc);
		statFinal.attackDamageFinal = (statFinal.attackDamageNoCritical * (1-statFinal.criticalChanceFinal)) + (statFinal.attackDamageNoCritical * statFinal.criticalChanceFinal * statFinal.criticalDamageFinal);
		statFinal.bonusMagicAttackDamageFinal = statFinal.bonusMagicAttackDamageExtra + (statFinal.arcaneBlade * statFinal.abilityPowerFinal);
		statFinal.physicalDamagePerSecondRaw = statFinal.attackDamageFinal * statFinal.attackSpeedFinal;
		
		double bonusPhysicalDPS = statFinal.bonusPhysicalAttackDamageFinal * statFinal.attackSpeedFinal;//some champions have unique passives that give bonus physical damage
		double bonusMagicDPS = statFinal.bonusMagicAttackDamageFinal * statFinal.attackSpeedFinal;
		
		double returnedValue = statFinal.physicalDamagePerSecondRaw + bonusPhysicalDPS + bonusMagicDPS;
		
		return returnedValue;
	}
	
	public void updateAP(ClassStatCalculations statFinal){
		statFinal.abilityPowerFinal = statFinal.abilityPowerExtra * (1 + statFinal.archmage) * statFinal.rabadonsDeathcapPassive * statFinal.woogletsWitchcapPassive;
	}
	
	public void updateHP(ClassStatCalculations statFinal){
		statFinal.healthExtra = (statFinal.healthPartialExtra * (1 + 0.25 * statFinal.spiritOfTheAncientGolemPercentHealth)) * (1 + statFinal.juggernaut + statFinal.HealthPercentRuneTotal) + statFinal.healthBase * (statFinal.juggernaut + statFinal.HealthPercentRuneTotal);
		statFinal.healthFinal = statFinal.healthBase + statFinal.healthExtra;
	}
	
	

	public void buildInfo(int position){
    	Intent intent = new Intent(this, BuildInfoActivity.class);

    	intent.putExtra("Champion Key", championKey[position]);
    	intent.putExtra("Item Key", itemKey[position]);
    	intent.putExtra("Mastery Key", masteryKey[position]);
    	intent.putExtra("Rune Key", runeKey[position]);
    	
    	startActivity(intent);
	}

	
}
