package com.leagueoflegendscalculator;

import com.google.android.gms.ads.*;

import java.text.DecimalFormat;

import com.google.gson.Gson;
import com.leagueoflegendscalculator.myclasses.ClassStatCalculations;
import com.leagueoflegendscalculator.myclasses.ConvertSavedElementsBuildsToClassStatCalculations;
import com.leagueoflegendscalculator.myclasses.SavedElementsBuilds;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.preference.PreferenceManager;

public class DuelResultsActivity extends ActionBarActivity {
	
	
	ClassStatCalculations blue;
	ClassStatCalculations red;
	double competitor1FinishesWithHealth = 0;
	double competitor2FinishesWithHealth = 0;
	boolean draw = false;
	DecimalFormat oneDForm = new DecimalFormat("#.#");
	DecimalFormat threeDForm = new DecimalFormat("#.###");
	double duelLength;
	int universalMillisecondCounter;
	byte round = 1; 
	String duelResultMessage = "";
	String duelTimeline = "Name   AA#   Dmg   LS   HP/5   HP";
	
	TextView duelResultText;
	TextView duelTimelineText;
	
	String firstBuild;
	String secondBuild;
	
	boolean criticalConditionOnlyOnce = true;
	boolean criticalCondition = false;
	int volibearTimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_duel_results);
		
	    // Look up the AdView as a resource and load a request.
	    AdView adView = (AdView) this.findViewById(R.id.adView);
	    AdRequest adRequest = new AdRequest.Builder().build();
	    adView.loadAd(adRequest);
	    
		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
		
		duelResultText = (TextView)findViewById(R.id.duel_results);
		
		int numberOfBuilds = appSharedPrefs.getInt("Number of Builds", 0);
		
		switch(numberOfBuilds){
		case 2:  
			duelListing("Build 1", "Build 2");
			duelResultText.setText(duelResultMessage + duelTimeline);
			break; 

		case 3:
			duelListing("Build 1", "Build 2");
			duelListing("Build 1", "Build 3"); 
			duelListing("Build 2", "Build 3"); 
			duelResultText.setText(duelResultMessage);
			break;

		case 4:  
			duelListing("Build 1", "Build 2");
			duelListing("Build 1", "Build 3");
			duelListing("Build 1", "Build 4");
			duelListing("Build 2", "Build 3");
			duelListing("Build 2", "Build 4"); 
			duelListing("Build 3", "Build 4");
			duelResultText.setText(duelResultMessage);
			break;
	
		case 5:
			duelListing("Build 1", "Build 2");
			duelListing("Build 1", "Build 3");
			duelListing("Build 1", "Build 4");
			duelListing("Build 1", "Build 5");
			duelListing("Build 2", "Build 3");
			duelListing("Build 2", "Build 4");
			duelListing("Build 2", "Build 5");
			duelListing("Build 3", "Build 4");
			duelListing("Build 3", "Build 5");
			duelListing("Build 4", "Build 5");
			duelResultText.setText(duelResultMessage);
			break;
		}//END OF SWITCH
	}//END OF onCreate()

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_duel_results, menu);
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
		else if (id == R.id.action_help){
			help();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	public void duelListing(String inputSerializedObject1, String inputSerializedObject2){
		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
		Gson gson = new Gson();
		
		String json1 = appSharedPrefs.getString(inputSerializedObject1, "");
		String json2 = appSharedPrefs.getString(inputSerializedObject2, "");
		
		firstBuild = gson.fromJson(json1, SavedElementsBuilds.class).getName();
		secondBuild = gson.fromJson(json2, SavedElementsBuilds.class).getName();
		
		competitor1FinishesWithHealth = 0;
		competitor2FinishesWithHealth = 0;
		duelLength = 0;
		round = 1;
		
		blue = contructBuild(inputSerializedObject1);//Setup so that competitor 1 (build 1) is blue in round 1 and red in round 2
		red = contructBuild(inputSerializedObject2);
		startDuelSimulation(blue, red);
		
		if (draw == false){
			round = 2;
			blue = contructBuild(inputSerializedObject2);
			red = contructBuild(inputSerializedObject1);
			startDuelSimulation(blue, red);
			
			if (competitor1FinishesWithHealth > competitor2FinishesWithHealth){
				duelResultMessage += firstBuild + " beats " + secondBuild + " with approximately " + (int)(competitor1FinishesWithHealth - competitor2FinishesWithHealth)/2 + " health on average in " + Double.valueOf(threeDForm.format(duelLength/2000)) + " seconds.\n\n";
			}
			else if (competitor1FinishesWithHealth < competitor2FinishesWithHealth){
				duelResultMessage += secondBuild + " beats " + firstBuild + " with approximately " + (int)(competitor2FinishesWithHealth - competitor1FinishesWithHealth)/2 + " health on average in " + Double.valueOf(threeDForm.format(duelLength/2000)) + " seconds.\n\n";
			}
			else {
				duelResultMessage += "Draw: On average " + firstBuild + " and " + secondBuild + " kill each other in " + Double.valueOf(threeDForm.format(duelLength/2000)) + " seconds. \n\n";
			}
		}
		else if (draw == true){
			duelResultMessage += "Technical Draw: Duel goes on for at least 60 seconds between: " + firstBuild + " and " + secondBuild + "\n\n";
			draw = false;
		}
	}
	
	
	
	public ClassStatCalculations contructBuild(String buildInput){
		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
		Gson gson = new Gson();

		String json = appSharedPrefs.getString(buildInput, "");
		SavedElementsBuilds obj = gson.fromJson(json, SavedElementsBuilds.class);
		ClassStatCalculations statFinal = new ConvertSavedElementsBuildsToClassStatCalculations(obj).statFinal;
				
		if (buildInput == "Build 1"){
			statFinal.feralFlareStacks = appSharedPrefs.getInt("feralFlareStacks1", 0);
			statFinal.manaChargeStacks = appSharedPrefs.getInt("manaChargeStacks1", 0);
			statFinal.mejaisSoulstealerStacks = appSharedPrefs.getInt("mejaisSoulstealerStacks1", 0);
			statFinal.rodOfAgesStacks = appSharedPrefs.getInt("rodOfAgesStacks1", 0);
			statFinal.seekersArmguardStacks = appSharedPrefs.getInt("seekersArmguardStacks1", 0);
			statFinal.spiritOfTheSpectralWraithStacks = appSharedPrefs.getInt("spiritOfTheSpectralWraithStacks1", 0);
			statFinal.swordOfTheOccultStacks = appSharedPrefs.getInt("swordOfTheOccultStacks1", 0);
			statFinal.threshStacks = appSharedPrefs.getInt("threshStacks1", 0); 
		}
		else if (buildInput == "Build 2"){
			statFinal.feralFlareStacks = appSharedPrefs.getInt("feralFlareStacks2", 0);
			statFinal.manaChargeStacks = appSharedPrefs.getInt("manaChargeStacks2", 0);
			statFinal.mejaisSoulstealerStacks = appSharedPrefs.getInt("mejaisSoulstealerStacks2", 0);
			statFinal.rodOfAgesStacks = appSharedPrefs.getInt("rodOfAgesStacks2", 0);
			statFinal.seekersArmguardStacks = appSharedPrefs.getInt("seekersArmguardStacks2", 0);
			statFinal.spiritOfTheSpectralWraithStacks = appSharedPrefs.getInt("spiritOfTheSpectralWraithStacks2", 0);
			statFinal.swordOfTheOccultStacks = appSharedPrefs.getInt("swordOfTheOccultStacks2", 0);
			statFinal.threshStacks = appSharedPrefs.getInt("threshStacks2", 0); 
		}
		else if (buildInput == "Build 3"){
			statFinal.feralFlareStacks = appSharedPrefs.getInt("feralFlareStacks3", 0);
			statFinal.manaChargeStacks = appSharedPrefs.getInt("manaChargeStacks3", 0);
			statFinal.mejaisSoulstealerStacks = appSharedPrefs.getInt("mejaisSoulstealerStacks3", 0);
			statFinal.rodOfAgesStacks = appSharedPrefs.getInt("rodOfAgesStacks3", 0);
			statFinal.seekersArmguardStacks = appSharedPrefs.getInt("seekersArmguardStacks3", 0);
			statFinal.spiritOfTheSpectralWraithStacks = appSharedPrefs.getInt("spiritOfTheSpectralWraithStacks3", 0);
			statFinal.swordOfTheOccultStacks = appSharedPrefs.getInt("swordOfTheOccultStacks3", 0);
			statFinal.threshStacks = appSharedPrefs.getInt("threshStacks3", 0); 
		}
		else if (buildInput == "Build 4"){
			statFinal.feralFlareStacks = appSharedPrefs.getInt("feralFlareStacks4", 0);
			statFinal.manaChargeStacks = appSharedPrefs.getInt("manaChargeStacks4", 0);
			statFinal.mejaisSoulstealerStacks = appSharedPrefs.getInt("mejaisSoulstealerStacks4", 0);
			statFinal.rodOfAgesStacks = appSharedPrefs.getInt("rodOfAgesStacks4", 0);
			statFinal.seekersArmguardStacks = appSharedPrefs.getInt("seekersArmguardStacks4", 0);
			statFinal.spiritOfTheSpectralWraithStacks = appSharedPrefs.getInt("spiritOfTheSpectralWraithStacks4", 0);
			statFinal.swordOfTheOccultStacks = appSharedPrefs.getInt("swordOfTheOccultStacks4", 0);
			statFinal.threshStacks = appSharedPrefs.getInt("threshStacks4", 0); 
		}
		else if (buildInput == "Build 5"){
			statFinal.feralFlareStacks = appSharedPrefs.getInt("feralFlareStacks5", 0);
			statFinal.manaChargeStacks = appSharedPrefs.getInt("manaChargeStacks5", 0);
			statFinal.mejaisSoulstealerStacks = appSharedPrefs.getInt("mejaisSoulstealerStacks5", 0);
			statFinal.rodOfAgesStacks = appSharedPrefs.getInt("rodOfAgesStacks5", 0);
			statFinal.seekersArmguardStacks = appSharedPrefs.getInt("seekersArmguardStacks5", 0);
			statFinal.spiritOfTheSpectralWraithStacks = appSharedPrefs.getInt("spiritOfTheSpectralWraithStacks5", 0);
			statFinal.swordOfTheOccultStacks = appSharedPrefs.getInt("swordOfTheOccultStacks5", 0);
			statFinal.threshStacks = appSharedPrefs.getInt("threshStacks5", 0); 
		}
		
		return statFinal;
	}


	public void startDuelSimulation(ClassStatCalculations blueTeam, ClassStatCalculations redTeam){
		
		//health regen is applied every 0.5 seconds
		//measured in microseconds, so 1000000 is 1 second. Attack Speed is measured to 3 decimals places, but AS modifiers can easily add more decimal places. More decimals means less likelihood
		//of the two champs hitting each other at the exact same time and throwing off the calculation for damage and lifesteal that come with certain items.

		blueTeam.counter= 0;
		redTeam.counter= 0;
		universalMillisecondCounter = 0;
		blueTeam.hits = 0;
		redTeam.hits = 0;
		blueTeam.currentHealth = blueTeam.healthFinal;
		redTeam.currentHealth = redTeam.healthFinal;
		
		uniquePassiveModifiers(blueTeam, redTeam);
		uniquePassiveModifiers(redTeam, blueTeam);

		
		while (universalMillisecondCounter <= 60000){

			//Sunfire Cape - Blue & Red
			if (universalMillisecondCounter % 1000 == 0){
				sunfireCapeDamagePerSecond(universalMillisecondCounter, blueTeam, redTeam);
				sunfireCapeDamagePerSecond(universalMillisecondCounter, redTeam, blueTeam);
			}
			//Health regeneration every half second
			if (universalMillisecondCounter % 500 == 0){
				healthRegnerationPerSecond(blueTeam, redTeam);
				healthRegnerationPerSecond(redTeam, blueTeam);
			}
			//Condition for Guinsoo's passive and Hextech magic shields
			if (universalMillisecondCounter % 500 == 0){
				healthReachesCriticalPoint(blueTeam, redTeam);//outside of attack loops so it can be checked more frequently in case of negative health regeneration
				healthReachesCriticalPoint(redTeam, blueTeam);//must also between attacks to update the shield in time
			}
			//Condition for Graves' passive
			if (blueTeam.champName.equals("Graves") && (universalMillisecondCounter <= 11000) && (universalMillisecondCounter % 1000 == 0) && (universalMillisecondCounter > 999)){
				if (blueTeam.level < 7){
					blueTeam.gravesBonusProtection = 1;
				}
				else if (blueTeam.level < 13){
					blueTeam.gravesBonusProtection = 2;
				}
				else{
					blueTeam.gravesBonusProtection = 3;
				}
				blueTeam.magicResistBonus += blueTeam.gravesBonusProtection;
				blueTeam.armorBonus += blueTeam.gravesBonusProtection;
			}
			
			
			//Blue attacks
			if (blueTeam.counter % (int)(1000/blueTeam.attackSpeedFinal) == 0){
				onAttacks(blueTeam, redTeam);
				
				//Condition for Guinsoo's passive and Hextech magic shields
				healthReachesCriticalPoint(blueTeam, redTeam);//outside of attack loops so it can be checked more frequently in case of negative health regeneration
				healthReachesCriticalPoint(redTeam, blueTeam);//must also between attacks to update the shield in time
			}
			//Red attacks
			if (redTeam.counter % (int)(1000/redTeam.attackSpeedFinal) == 0){
				onAttacks(redTeam, blueTeam);
				
				//Condition for Guinsoo's passive and Hextech magic shields
				healthReachesCriticalPoint(redTeam, blueTeam);//outside of attack loops so it can be checked more frequently in case of negative health regeneration
				healthReachesCriticalPoint(blueTeam, redTeam);//must also between attacks to update the shield in time
			}




			//WHEN SOMEONE DIES
			if (blueTeam.guardianAngelPassive == true && blueTeam.currentHealth <= 0){
				universalMillisecondCounter += 4000;
				for (int i = 0; i == 4; i++){
					healthRegnerationPerSecond(redTeam, blueTeam);//regenerate the enemy
				}
				blueTeam.currentHealth = blueTeam.healthFinal * 0.3;
				blueTeam.guardianAngelPassive = false;
				blueTeam.counter = -1;
				redTeam.counter = -1;
			}
			if (redTeam.guardianAngelPassive == true && redTeam.currentHealth == 0){
				universalMillisecondCounter += 4000;
				for (int i = 0; i == 4; i++){
					healthRegnerationPerSecond(blueTeam, redTeam);//regenerate the enemy
				}
				redTeam.currentHealth = redTeam.healthFinal * 0.3;
				redTeam.guardianAngelPassive = false;
				blueTeam.counter = -1;
				redTeam.counter = -1;
			}
			
			duelResult(blueTeam, redTeam);

	

			if (universalMillisecondCounter % 100 == 0){
				duelTimeline += "\n\nRound " + round + ", Time " + (double)universalMillisecondCounter/1000 + "s" + "\n" 
			+ firstBuild + "\n" + blueTeam.hits + "   " + Double.valueOf(oneDForm.format(blueTeam.truePhysicalDamage + blueTeam.trueMagicDamage)) + "   " + Double.valueOf(oneDForm.format(blueTeam.actualLifesteal)) + "   " + Double.valueOf(oneDForm.format(blueTeam.actualHealthRegen * 10)) + "   " + Double.valueOf(oneDForm.format(blueTeam.currentHealth)) + "\n"
			+ secondBuild + "\n" + redTeam.hits + "   " + Double.valueOf(oneDForm.format(redTeam.truePhysicalDamage + redTeam.trueMagicDamage)) + "   " + Double.valueOf(oneDForm.format(redTeam.actualLifesteal)) + "   " + Double.valueOf(oneDForm.format(redTeam.actualHealthRegen * 10)) + "   " + Double.valueOf(oneDForm.format(redTeam.currentHealth));
			}
			
			
			blueTeam.counter ++;
			redTeam.counter++;
			universalMillisecondCounter++;
		}//END OF WHILE LOOP
	}//END OF startDuelSimulation

		
	

	
	
	//Only add unique passives here if they don't end up scaling with other items (e.g. nathors tooth needs to scale with current AP, 
	//which varies depending on the number of guinsoo stacks made in combat. Items that scale on max health or max mana can be done here since
	//those stats don't change during combat.
	public void uniquePassiveModifiers(ClassStatCalculations statFinal1, ClassStatCalculations statFinal2){
		
		//ADDITIVE BONUSES (COMES BEFORE MULTIPLICATIVE BONUSES)
		
		if(statFinal1.doransShieldPassive == true){
			statFinal1.bonusPhysicalAttackDamageFinal += -8;
		}
		if(statFinal1.orbOfWinterPassive == true){
			statFinal1.shield += (30 + (10 * statFinal1.level));
		}	
		if (statFinal1.theLightbringerPassive == true){
			statFinal2.healthRegenFinal += -statFinal1.criticalChanceFinal * statFinal1.attackDamageBonus * 0.9;
		}
		if (statFinal1.runicBlessing == true){
			statFinal1.shield += 50;
		}
		if (statFinal1.spiritOfTheElderLizardPassive == true){
			//deals 14 + 2xlevel per 3 seconds TRUE damage 
			statFinal2.healthRegenFinal += -((14 + 2*statFinal1.level)*(5/3));
		}
		
		
		//PRE-STACKED ITEMS (ALL OF THESE ARE ALSO ADDITIVE BONUSES)
		if (statFinal1.feralFlareStacks > 0){
			statFinal1.bonusMagicAttackDamageExtra += (25 + statFinal1.feralFlareStacks);
		}
		if (statFinal1.manaChargeStacks > 0 && statFinal1.manaChargeArchangelsStaffPassive == true){
			statFinal1.manaFinal += (8 * statFinal1.manaChargeStacks);
		}
		if (statFinal1.manaChargeStacks > 0 && statFinal1.manaChargePassive == true){//for Manamune or Tear of the Goddess
			statFinal1.manaFinal += (4 * statFinal1.manaChargeStacks);
		}
		if (statFinal1.mejaisSoulstealerStacks > 0){//unique
			statFinal1.abilityPowerExtra += (8 * statFinal1.mejaisSoulstealerStacks);
		}
		if(statFinal1.rodOfAgesStacks > 0){//not unique
			statFinal1.healthExtra += 20 * statFinal1.rodOfAgesStacks;
			statFinal1.manaFinal += 20 * statFinal1.rodOfAgesStacks;
			statFinal1.abilityPowerExtra += 2 * statFinal1.rodOfAgesStacks;
		}   
		if (statFinal1.seekersArmguardStacks > 0){
			statFinal1.abilityPowerExtra += (0.5 * statFinal1.seekersArmguardStacks);
			statFinal1.armorBonus += (0.5 * statFinal1.seekersArmguardStacks);
		}    
		if (statFinal1.spiritOfTheSpectralWraithStacks > 0){//unique
			statFinal1.abilityPowerExtra += (2 * statFinal1.spiritOfTheSpectralWraithStacks);			
		}     
		if (statFinal1.swordOfTheOccultStacks > 0){//unique
			statFinal1.attackDamageBonus += (5 * statFinal1.swordOfTheOccultStacks);
			updateAD(statFinal1, statFinal2);
		}
		

		//MULTIPLICATIVE BONUSES (MUST COME AFTER ADDITIVE BONUSES, AND ORDER IS IMPORTANT)
		//AS nerfs
		if(statFinal1.coldSteelPassive == true){
			statFinal2.attackSpeedFinal *= 0.9;
		}
		if(statFinal1.frozenHeartPassive == true){
			statFinal2.attackSpeedFinal *= 0.85;
		}
		
		//mana boost
		if (statFinal1.insightPassive == true){
			statFinal1.manaFinal *= 1.03;
		}
		//Strength of Spirit must come after mana boost and before health regeneration boost
		if (statFinal1.strengthOfSpirit == true){
			statFinal1.healthRegenFinal += (statFinal1.manaFinal/300);
		}
		
		//health regeneration and lifesteal boost
		if (statFinal1.spiritVisagePassive == true){
			statFinal1.healthRegenFinal *= 1.2;
			statFinal1.lifestealPercentFinal *=1.2;
		}
		
		//health boost
		updateHP(statFinal1);
		
		//health regen nerf
		if (statFinal1.wickedHatchetPassive == true){
			updateDC(statFinal1, statFinal2);
			statFinal2.healthRegenFinal += -(statFinal1.criticalChanceFinal * statFinal1.attackDamageBonus * 0.6 * statFinal1.physicalDamageCoefficient);//physical damage
		}
		if  (statFinal1.executionersCallingPassive == true){
			statFinal2.healthRegenFinal *= 0.5;
			statFinal2.lifestealPercentFinal *= 0.5;
		}

		
		//Reinforced Armor
		if (statFinal1.reinforcedArmor == true){
			statFinal2.criticalDamageFinal *= 0.9;
			updateAD(statFinal1, statFinal2);
		}
		
		//bonus AD boost - relies on max mana
		if(statFinal1.awePassive == true){
			statFinal1.bonusPhysicalAttackDamageFinal += statFinal1.manaFinal*(0.02);
		}
		
		//bonus AD boost - relies on max health
		if(statFinal1.atmasImpalerPassive == true){
			statFinal1.bonusPhysicalAttackDamageFinal += statFinal1.healthFinal*(0.015);
		}

		//health regen boost - relies on max health
		if(statFinal1.warmogsArmorPassive == true){
			statFinal1.healthRegenFinal += (statFinal1.healthFinal * 0.01);
		}
		
		//MS soft-cap
		if (statFinal1.movementSpeedFinal > 490){//must come before Hecarim's AD bonus
			statFinal1.movementSpeedFinal = (statFinal1.movementSpeedFinal * 0.5) + 230;
		}
		else if (statFinal1.movementSpeedFinal > 415){
			statFinal1.movementSpeedFinal = (statFinal1.movementSpeedFinal * 0.8) + 83;
		}
		
		//Champion passives who's values will not change throughout a battle
		String champName = statFinal1.champName;
		switch (champName){
		case "Amumu":
			if (statFinal1.level < 7){
				statFinal2.magicResistBonus += -15;
			}
			else if (statFinal1.level < 3){
				statFinal2.magicResistBonus += -20;
			}
			else{
				statFinal2.magicResistBonus += -25;
			}
			break;
		case "Dr.Mundo":
			statFinal1.healthRegenFinal += (0.015 * statFinal1.healthFinal);
			break;
		case "Fiddlesticks":
			statFinal2.magicResistBonus += -10;
			break;
			
		//case "Fizz": do in updateAD()
		
		case "Heimerdinger":
			if (statFinal1.level < 5){
				statFinal1.healthRegenFinal += 10;
			}
			else if (statFinal1.level < 9){
				statFinal1.healthRegenFinal += 15;
			}
			else if (statFinal1.level < 13){
				statFinal1.healthRegenFinal += 20;
			}
			else if (statFinal1.level < 17){
				statFinal1.healthRegenFinal += 25;
			}
			else{
				statFinal1.healthRegenFinal += 30;
			}
			break;
		
		//case "Kassadin": do in updateDC()
		
		case "Malphite":
			statFinal1.shield += statFinal1.healthFinal * 0.1;
			break;
		case "Morgana":
			if (statFinal1.level < 6){
				statFinal1.spellVampFinal += 0.1;
			}
			else if (statFinal1.level < 12){
				statFinal1.spellVampFinal  += 0.15;
			}
			else{
				statFinal1.spellVampFinal  += 0.2;
			}
			break;
		case "Nasus":
			if (statFinal1.level < 6){
				statFinal1.lifestealPercentFinal += 0.1;
			}
			else if (statFinal1.level < 12){
				statFinal1.lifestealPercentFinal  += 0.15;
			}
			else{
				statFinal1.lifestealPercentFinal  += 0.2;
			}
			break;
		case "Galio":
			statFinal1.abilityPowerExtra+= 0.5 * statFinal1.magicResistFinal;
			break;
		case "Hecarim":
			if (statFinal1.level < 3){
				statFinal1.attackDamageBonus += 0.1 * statFinal1.movementSpeedFinal;
			}
			else if (statFinal1.level < 6){
				statFinal1.attackDamageBonus += 0.125 * statFinal1.movementSpeedFinal;
			}
			else if (statFinal1.level < 9){
				statFinal1.attackDamageBonus += 0.15 * statFinal1.movementSpeedFinal;
			}
			else if (statFinal1.level < 12){
				statFinal1.attackDamageBonus += 0.175 * statFinal1.movementSpeedFinal;
			}
			else if (statFinal1.level < 15){
				statFinal1.attackDamageBonus += 0.2 * statFinal1.movementSpeedFinal;
			}
			else if (statFinal1.level < 18){
				statFinal1.attackDamageBonus += 0.225 * statFinal1.movementSpeedFinal;
			}
			else{
				statFinal1.attackDamageBonus += 0.25 * statFinal1.movementSpeedFinal;
			}
			break;
		case "Rammus":
			statFinal1.bonusPhysicalAttackDamageFinal += 0.25 * statFinal1.armorFinal;
			break;
		case "Singed":
			statFinal1.healthExtra += 0.25 * statFinal1.manaFinal;
			break;
		case "Shyvana":
			if (statFinal1.level < 6){
				statFinal1.armorBonus += 5;
				statFinal1.magicResistBonus += 5;
			}
			else if (statFinal1.level < 11){
				statFinal1.armorBonus += 10;
				statFinal1.magicResistBonus += 10;
			}
			else if (statFinal1.level < 16){
				statFinal1.armorBonus += 15;
				statFinal1.magicResistBonus += 15;
			}
			else{
				statFinal1.armorBonus += 20;
				statFinal1.magicResistBonus += 20;
			}
			break;
		case "Thresh":
			statFinal1.armorBonus += 0.75 * statFinal1.threshStacks;
			statFinal1.abilityPowerExtra += 0.75 * statFinal1.threshStacks;
			break;
		case "Wukong":
			byte wukongBonusPro;
			if (statFinal1.level < 7){
				wukongBonusPro = 4;
			}
			else if (statFinal1.level < 13){
				wukongBonusPro = 6;
			}
			else {
				wukongBonusPro = 8;
			}
			statFinal1.armorBonus += wukongBonusPro;
			statFinal1.magicResistBonus += wukongBonusPro;
			break;
		case "Yasuo":
			statFinal1.criticalChanceFinal *= 2;
		}
	}
		
	
		
		
		
//UPDATE ATTACK DAMAGE
	public void updateAD(ClassStatCalculations statFinal1, ClassStatCalculations statFinal2){
		statFinal1.attackDamageNoCritical = (statFinal1.attackDamageBase + statFinal1.attackDamageBonus) * (1 + statFinal1.havoc);
		statFinal1.criticalChanceFinal = statFinal1.criticalChanceItem + statFinal1.CriticalChanceRuneTotal + (statFinal1.tryndamereFury * 0.0035);
		
		if (statFinal1.criticalChanceFinal > 1){
			statFinal1.criticalChanceFinal = 1;
		}

		statFinal1.attackDamageFinal = (statFinal1.attackDamageNoCritical * (1 - statFinal1.criticalChanceFinal)) + (statFinal1.attackDamageNoCritical * statFinal1.criticalChanceFinal * statFinal1.criticalDamageFinal);
		updateAP(statFinal1);
		statFinal1.bonusMagicAttackDamageFinal = statFinal1.bonusMagicAttackDamageExtra + (statFinal1.arcaneBlade * statFinal1.abilityPowerFinal);
		
		//Double Edged Sword - If a champion can alternate, assume melee
		if (statFinal1.doubleEdgedSword == true && statFinal1.rangedChampion == true){//attackDamageFinal can't be used directly as a damage modifier since updates using updateAD() afterwards will just erase it in a recalculation
			statFinal1.attackDamageFinal *= 1.015;
			
		}
		else if (statFinal1.doubleEdgedSword == true && statFinal1.rangedChampion == false){
			statFinal1.attackDamageFinal *= 1.02;
		}
		if (statFinal2.doubleEdgedSword == true && statFinal2.rangedChampion == true){
			statFinal1.attackDamageFinal *= 1.015;
			
		}
		else if (statFinal2.doubleEdgedSword == true && statFinal2.rangedChampion == false){
			statFinal1.attackDamageFinal *= 1.01;
		}
		
		//Executioner
		if (statFinal2.currentHealth < statFinal1.executioner){
			statFinal1.attackDamageFinal *= 1.05;
		}
			
		//Unyielding
		if (statFinal1.unyielding == true && statFinal1.rangedChampion == true){
			statFinal2.attackDamageFinal += -1;
		}
		else if (statFinal1.unyielding == true && statFinal1.rangedChampion == false){
			statFinal2.attackDamageFinal += -2;
		}
		
		//Block
		if (statFinal1.unyielding == true){
			statFinal2.attackDamageFinal += -1;
		}
		
		
		if (statFinal2.champName.equals("Sion")){//unlike fizz's passive this one is calculated before armor reduction
			byte sionPassive;
			if (statFinal2.level < 8){
				sionPassive = 12;
			}
			else if (statFinal2.level < 13){
				sionPassive = 16;
			}
			else {
				sionPassive = 20;
			}
			statFinal1.attackDamageFinal =- sionPassive;
		}

	}

	
//UPDATE ATTACK SPEED
	public void updateAS(ClassStatCalculations statFinal1){
		statFinal1.attackSpeedFinal = statFinal1.attackSpeedBase * (1 + statFinal1.attackSpeedBonus);

		if (statFinal1.frenzy == true){
			if (statFinal1.hits == 1){
				statFinal1.frenzyBonus = (statFinal1.criticalChanceFinal * statFinal1.attackSpeedBase);
			}
			else if (statFinal1.hits == 2){
				statFinal1.frenzyBonus = (statFinal1.criticalChanceFinal * statFinal1.attackSpeedBase) + (statFinal1.criticalChanceFinal * statFinal1.criticalChanceFinal * statFinal1.attackSpeedBase);
			}
			else{
				statFinal1.frenzyBonus = (statFinal1.criticalChanceFinal * statFinal1.attackSpeedBase) + (statFinal1.criticalChanceFinal * statFinal1.criticalChanceFinal * statFinal1.attackSpeedBase) + (statFinal1.criticalChanceFinal * statFinal1.criticalChanceFinal * statFinal1.criticalChanceFinal * statFinal1.attackSpeedBase);
			}
		}

		if (statFinal1.champName.equals("Olaf")){
			statFinal1.attackSpeedBonus += -statFinal1.olafBonusAS;
			statFinal1.olafBonusAS = (statFinal1.healthFinal - statFinal1.currentHealth)/statFinal1.healthFinal;
			statFinal1.attackSpeedBonus += statFinal1.olafBonusAS;
		}

		statFinal1.attackSpeedFinal = statFinal1.attackSpeedBase * (1 + statFinal1.attackSpeedBonus + statFinal1.frenzyBonus);
		if (statFinal1.attackSpeedFinal > 2.5){
			statFinal1.attackSpeedFinal = 2.5;
		}
	}

	
//UPDATE DAMAGE REDUCTION
	public void updateDC(ClassStatCalculations statFinal1, ClassStatCalculations statFinal2){
		
		//Ninja Tabi
		if (statFinal2.ninjaTabiPassive == true){
			statFinal2.ninjaTabiResistance = 0.9;
		}
		//Odyn's Veil
		if (statFinal2.odynsVeilPassive == true){
			statFinal2.odynsVeilResistance = 0.9;
		}
		
		//Champion passives
		double kassadinPassive = 1;
		if (statFinal2.champName.equals("Kassadin")){
			kassadinPassive = 0.85;
		}
		double urgotPassive = 1;
		if (statFinal2.champName.equals("Urgot") && universalMillisecondCounter > 0){
			kassadinPassive = 0.85;
		}
		double kaylePassive = 1;
		if (statFinal2.champName.equals("Kayle")){
			if (statFinal2.hits < 6){
				kaylePassive = 1 - 0.03 * statFinal2.hits;
			}
			else{
				kaylePassive = 0.85;
			}
		}
		statFinal1.physicalDamageCoefficient = (100/(100 + (statFinal2.armorFinal * (1 - statFinal1.armorRedPercentFinal) * (1 - statFinal1.armorPenPercentFinal)) - statFinal1.armorPenFlatFinal)) * statFinal2.ninjaTabiResistance * urgotPassive * kaylePassive;
		statFinal1.magicDamageCoefficient = (100/(100 + (statFinal2.magicResistFinal * (1 - statFinal1.magicRedPercentFinal) * (1 - statFinal1.magicPenPercentFinal)) - statFinal1.magicPenFlatFinal)) * statFinal2.odynsVeilResistance * kassadinPassive * urgotPassive * kaylePassive;
	}

	
//UPDATE ABILITY POWER
	public void updateAP(ClassStatCalculations statFinal1){
		statFinal1.abilityPowerFinal = statFinal1.abilityPowerExtra * (1 + statFinal1.archmage) * statFinal1.rabadonsDeathcapPassive * statFinal1.woogletsWitchcapPassive;
	}


	
//UPDATE HEALTH
	public void updateHP(ClassStatCalculations statFinal1){
		statFinal1.healthExtra = (statFinal1.healthPartialExtra * (1 + 0.25 * statFinal1.spiritOfTheAncientGolemPercentHealth)) * (1 + statFinal1.juggernaut + statFinal1.HealthPercentRuneTotal) + statFinal1.healthBase * (statFinal1.juggernaut + statFinal1.HealthPercentRuneTotal);
		statFinal1.healthFinal = statFinal1.healthBase + statFinal1.healthExtra;
	}

//UPDATE PROTECTION
	public void updatePRO(ClassStatCalculations statFinal1, ClassStatCalculations statFinal2){
		double xinZhaoPassive = 1;
		if (statFinal2.champName.equals("Xin Zhao") && statFinal2.hits > 0){//only turns on after the first attack
			xinZhaoPassive = 0.85;
		}
		
		
		statFinal1.armorFinal = (statFinal1.armorBase + (statFinal1.armorBonus * (1 + statFinal1.enchantedArmor))) * xinZhaoPassive;
		statFinal1.magicResistFinal = statFinal1.magicResistBase + statFinal1.magicResistBonus;
	}
	

	
//CONDITIONS WHEN HEALTH REACHES A CRITICAL POINT
	public void healthReachesCriticalPoint(ClassStatCalculations statFinal1, ClassStatCalculations statFinal2){
		if ( (statFinal1.guinsoosRagebladeUniquePassive == true) && ((statFinal1.currentHealth < ((statFinal1.healthFinal)*0.5)) || criticalCondition == true) ){//unique passive
			statFinal1.attackSpeedBonus += 0.2;
			updateAS(statFinal1);
			if (statFinal2.executionersCallingPassive == true //lifesteal bonus is halved if grevious would is in effect
					|| ((statFinal2.morellonomiconPassive == true) && (statFinal1.currentHealth < (0.4 * statFinal1.healthFinal)))){
				statFinal1.lifestealPercentFinal += 0.05;
			}
			else{
				statFinal1.lifestealPercentFinal += 0.1;
			}
			statFinal1.guinsoosRagebladeUniquePassive = false;
			criticalCondition = false;
		}
		if ((statFinal1.hexDrinkerShield == true)
				&& (statFinal1.mawOfMalmortiusPassive == false)
				&& ((statFinal1.currentHealth < (statFinal1.healthFinal * 0.3))  || criticalCondition == true)
				&& ((statFinal2.bonusMagicAttackDamageFinal > 0 ) || (statFinal2.thornmailPassive == true))){
			//magic shield
			statFinal1.magicShield += 250;
			statFinal1.hexDrinkerShield = false;
			criticalCondition = false;
		}
		if ((statFinal1.mawOfMalmortiusShield == true)
				&& (statFinal1.currentHealth < (statFinal1.healthFinal * 0.3) || criticalCondition == true)
				&& ((statFinal2.bonusMagicAttackDamageFinal > 0 ) || (statFinal2.thornmailPassive == true))) {
			//magic shield
			statFinal1.magicShield += 400;
			statFinal1.mawOfMalmortiusShield = false;
			statFinal1.hexDrinkerShield = false;
			criticalCondition = false;
		}
		if ( statFinal1.secondWind == true && (statFinal1.currentHealth < (statFinal1.healthFinal * 0.25) || criticalCondition == true) ){
			statFinal1.healthRegenFinal *= 1.1;
			statFinal1.lifestealPercentFinal *= 1.1;
			statFinal1.secondWind = false;
			criticalCondition = false;
		}
		
		if (statFinal1.champName.equals("Blitzcrank")){
			if ( (statFinal1.currentHealth < (0.2 * statFinal1.healthFinal) || criticalCondition == true) && statFinal1.blitzcrankShield == true ){
				statFinal1.shield += 0.5 * statFinal1.manaFinal;
				statFinal1.blitzcrankShield = false;
				criticalCondition = false;
			}
		}
		
	}
		
		
//THORNMAIL DAMAGE
	public void thornmail(ClassStatCalculations statFinal1, ClassStatCalculations statFinal2){
		updateDC(statFinal1, statFinal2);
		//The thornmail damage done to blue on attacking red will be saved in the blueTeam object
		statFinal1.thornmailDamage = statFinal1.attackDamageFinal * 0.30 * statFinal2.magicDamageCoefficient;
	
		if (statFinal1.shield == 0 && statFinal1.magicShield == 0){
			statFinal1.currentHealth += -(statFinal1.thornmailDamage);
		}
		else if (statFinal1.shield > 0 && statFinal1.magicShield == 0){
			if (statFinal1.shield > statFinal1.thornmailDamage){
				statFinal1.shield += -(statFinal1.thornmailDamage);
			}
			else if (statFinal1.shield < statFinal1.thornmailDamage){
				statFinal1.currentHealth += statFinal1.shield - (statFinal1.thornmailDamage);
				statFinal1.shield = 0;
			}
		}
		else if (statFinal1.shield == 0 && statFinal1.magicShield > 0){
			if (statFinal1.magicShield > statFinal1.thornmailDamage){
				statFinal1.magicShield += -(statFinal1.thornmailDamage);
			}
			else if (statFinal1.magicShield < statFinal1.thornmailDamage){
				statFinal1.currentHealth += statFinal1.magicShield - (statFinal1.thornmailDamage);
				statFinal1.shield = 0;
			}
		}		
		else if (statFinal1.shield > 0 && statFinal1.magicShield > 0){
			if (statFinal1.magicShield > statFinal1.thornmailDamage){
				statFinal1.magicShield += -(statFinal1.thornmailDamage);
			}
			else if ((statFinal1.magicShield < (statFinal1.thornmailDamage)) && (statFinal1.shield + statFinal1.magicShield >= (statFinal1.thornmailDamage))){
				statFinal1.shield += statFinal1.magicShield - (statFinal1.thornmailDamage);
				statFinal1.magicShield = 0;
			}
			else if ((statFinal1.magicShield < (statFinal1.thornmailDamage)) && (statFinal1.shield + statFinal1.magicShield < (statFinal1.thornmailDamage))){
				statFinal1.currentHealth += statFinal1.shield + statFinal1.magicShield - (statFinal1.thornmailDamage);
				statFinal1.shield = 0;
				statFinal1.magicShield = 0;
			}
		}
	}
		
	
	
//SUNFIRE CAPE DAMAGE
	public void sunfireCapeDamagePerSecond(int universalMicrosecondCounter, ClassStatCalculations statFinal1, ClassStatCalculations statFinal2){
		if (statFinal1.sunfireCapePassive == true){
			updateDC(statFinal1, statFinal2);
			statFinal1.sunfireCapeDamage = (25 + statFinal1.level)  * statFinal1.magicDamageCoefficient;
			if (statFinal2.magicShield > statFinal1.sunfireCapeDamage){
				statFinal2.magicShield += -(statFinal1.sunfireCapeDamage);
			}
			else if ((statFinal2.magicShield < statFinal1.sunfireCapeDamage) && (statFinal2.magicShield > 0)){
				statFinal2.currentHealth += statFinal2.magicShield - statFinal1.sunfireCapeDamage;
				statFinal2.magicShield = 0;
			}
			else{
				statFinal2.currentHealth += -(statFinal1.sunfireCapeDamage);
			}
		}
	}
	
	
	public void onAttacks(ClassStatCalculations statFinal1, ClassStatCalculations statFinal2){//statFinal1 is the attacker, statFinal2 is required for some calculations

		if (statFinal1.hits == 0 && statFinal1.frostQueensClaimPassive == true){
			statFinal1.bonusPhysicalAttackDamageFinal += 15;
		}
		else if (statFinal1.hits == 3 && statFinal1.frostQueensClaimPassive == true){
			statFinal1.bonusPhysicalAttackDamageFinal -= 15;
		}
		else if (statFinal1.hits == 0 && statFinal1.frostFangPassive == true){
			statFinal1.bonusPhysicalAttackDamageFinal += 15;
		}
		else if (statFinal1.hits == 3 && statFinal1.frostFangPassive == true){
			statFinal1.bonusPhysicalAttackDamageFinal -= 15;
		}
		else if (statFinal1.hits == 0 && statFinal1.spellthiefsEdgePassive == true){
			statFinal1.bonusPhysicalAttackDamageFinal += 10;
		}
		else if (statFinal1.hits == 3 && statFinal1.spellthiefsEdgePassive == true){
			statFinal1.bonusPhysicalAttackDamageFinal -= 10;
		}
		
		//apply grievous wounds from Morellonomicon
		if ((statFinal1.morellonomiconPassive == true)
				&& (statFinal1.bonusMagicAttackDamageFinal > 0 || statFinal1.thornmailPassive == true)
				&& (statFinal1.executionersCallingPassive == false)
				&& (statFinal2.currentHealth < (statFinal2.healthFinal * 0.4))){//Mind the bonus magic damage
			statFinal2.healthRegenFinal *= 0.5;
			statFinal2.lifestealPercentFinal *= 0.5;
			statFinal1.morellonomiconPassive = false;
		}

		//+n stacks per hit for n guinsoos for a maximum of 8n stacks
		if ((statFinal1.guinsoosRagebladeNumber >= 1) && (statFinal1.hits < 8)){//non-unique passive
			statFinal1.attackSpeedBonus += (0.04 * statFinal1.guinsoosRagebladeNumber);
			updateAS(statFinal1);
			statFinal1.abilityPowerExtra += (4 * statFinal1.guinsoosRagebladeNumber);
		}

		if ((statFinal1.sanguineBladePassive == true) && (statFinal1.hits > 0) && (statFinal1.hits <= 5)){//unique passive
			statFinal1.attackDamageBonus += 6;
			updateAD(statFinal1, statFinal2);
			if (statFinal2.executionersCallingPassive == true //lifesteal bonus is halved if grevious would is in effect
					|| ((statFinal2.morellonomiconPassive == true) && (statFinal1.currentHealth < (0.4 * statFinal1.healthFinal)))){
				statFinal1.lifestealPercentFinal += 0.005;
			}
			else{
				statFinal1.lifestealPercentFinal += 0.01;
			}
		}
		
		
		if ((statFinal1.statikkShivPassive == true) && (statFinal1.statikkShivStacks % 100 == 0) && (statFinal1.hits > 0)){//11th hit is the first actual proc
			//deals 100 bonus magic damage that can crit strike every 100 charges
			statFinal1.statikkShivBonus = (100 * (1 - statFinal1.criticalChanceFinal)) + (100 * statFinal1.criticalChanceFinal * statFinal1.criticalDamageFinal);
			statFinal1.bonusMagicAttackDamageExtra += statFinal1.statikkShivBonus;
			
		}
		else if ((statFinal1.statikkShivPassive == true) && (statFinal1.statikkShivStacks % 100 == 10) && (statFinal1.hits > 10)){
			//undo the effects for the next 9 attacks
			statFinal1.bonusMagicAttackDamageExtra += -statFinal1.statikkShivBonus;
		}
		if (statFinal1.statikkShivPassive == true){
			statFinal1.statikkShivStacks += 10;
		}


		if (statFinal1.witsEndSecondPassive == true && (statFinal1.hits > 0) && (statFinal1.hits <= 5)){//unique passive with 5 stacks max
			statFinal2.magicResistBonus += -5;
		}
		
		if ((statFinal1.theBlackCleaverStacksPerHit > 0) && (statFinal1.blackCleaverStackBonus < 0.25)){//non-unique passive with a build in cap for total stacks
			statFinal1.armorRedPercentFinal += -statFinal1.blackCleaverStackBonus;
			
			statFinal1.blackCleaverStackBonus += (0.05 * statFinal1.theBlackCleaverStacksPerHit);
			if (statFinal1.blackCleaverStackBonus > 0.25){
				statFinal1.blackCleaverStackBonus = 0.25;
			}
			statFinal1.armorRedPercentFinal += statFinal1.blackCleaverStackBonus;
		}
		
		if (statFinal1.bladeOfTheRuinedKingPassive == true){
			//remove previous BotRK bonus
			statFinal1.bonusPhysicalAttackDamageFinal += -statFinal1.bladeOfTheRuinedKingBonus;
			//create and apply new BotRK bonus
			statFinal1.bladeOfTheRuinedKingBonus = (0.08 * statFinal2.currentHealth);
			statFinal1.bonusPhysicalAttackDamageFinal += statFinal1.bladeOfTheRuinedKingBonus;
		}
		
		if (statFinal1.mawOfMalmortiusPassive == true){
			statFinal1.attackDamageBonus += -statFinal1.mawOfMalmortiusBonus;
			//%of miss HP in x100 form, divided by 2
			statFinal1.mawOfMalmortiusBonus = ((statFinal1.healthFinal - statFinal1.currentHealth) / statFinal1.healthFinal) * 50;
			if (statFinal1.mawOfMalmortiusBonus > 35){
				statFinal1.mawOfMalmortiusBonus = 35;
			}
			statFinal1.attackDamageBonus += statFinal1.mawOfMalmortiusBonus;
			updateAD(statFinal1, statFinal2);
		}
		
		if (statFinal1.nashorsToothPassive == true){//needs to come after multiplicative ability power bonus
			statFinal1.bonusMagicAttackDamageExtra += -(statFinal1.nashorsToothBonus);
			updateAP(statFinal1);
			statFinal1.nashorsToothBonus = (15 + (statFinal1.abilityPowerFinal * (0.15)));
			statFinal1.bonusMagicAttackDamageExtra += statFinal1.nashorsToothBonus;
		}	
		
		updatePRO(statFinal1, statFinal2);
		updateAD(statFinal1, statFinal2);
		updateDC(statFinal1, statFinal2);
		
		

		String champName = statFinal1.champName;
		switch (champName){
		case "Akali":
			statFinal1.bonusMagicAttackDamageExtra += -statFinal1.akaliBonusMagicDamage;
			statFinal1.akaliBonusMagicDamage = ((0.06 + statFinal1.abilityPowerFinal/600) * statFinal1.attackDamageFinal);
			statFinal1.bonusMagicAttackDamageExtra += statFinal1.akaliBonusMagicDamage;
			
			statFinal1.spellVampFinal += -statFinal1.akaliBonusSpellvamp;
			statFinal1.akaliBonusSpellvamp = 0.06 + statFinal1.attackDamageBonus/600;
			statFinal1.spellVampFinal += statFinal1.akaliBonusSpellvamp;
			break;
			
		
		case "Corki":
			statFinal1.bonusTrueDamageFinal += -statFinal1.corkiBonusTrueDamage;
			statFinal1.corkiBonusTrueDamage = statFinal1.attackDamageNoCritical * 0.1;
			statFinal1.bonusTrueDamageFinal += statFinal1.corkiBonusTrueDamage; 
			break;
			
			
		case "Vladimir":
			statFinal1.abilityPowerExtra += -statFinal1.vladBonusAP;
			statFinal1.healthExtra += -statFinal1.vladBonusHP;
			statFinal1.vladBonusAP = (0.025 * statFinal1.healthExtra);
			statFinal1.vladBonusHP = 1.4 * statFinal1.abilityPowerFinal;
			statFinal1.abilityPowerExtra += statFinal1.vladBonusAP;
			statFinal1.healthExtra += statFinal1.vladBonusHP;
			break;
		}
		
		
		
		
		if (statFinal1.champName.equals("Jax") && statFinal1.hits < 6){
			if (statFinal1.level < 4){
				statFinal1.attackSpeedBonus += 0.04;
			}
			else if (statFinal1.level < 7){
				statFinal1.attackSpeedBonus += 0.06;
			}
			else if (statFinal1.level < 10){
				statFinal1.attackSpeedBonus += 0.08;
			}
			else if (statFinal1.level < 13){
				statFinal1.attackSpeedBonus += 0.1;
			}
			else if (statFinal1.level < 16){
				statFinal1.attackSpeedBonus += 0.12;
			}
			else{
				statFinal1.attackSpeedBonus += 0.14;
			}
		}
		
		if (statFinal1.champName.equals("Miss Fortune") && statFinal1.hits < (6 + statFinal1.rskill)){//+1 stack immediately before hit
			statFinal1.bonusMagicAttackDamageExtra += 0.6 * statFinal1.attackDamageNoCritical;
		}
	
		if (statFinal1.champName.equals("Jinx") && statFinal1.hits < 3){
			statFinal1.attackSpeedBonus += (10 + 8.33 * (statFinal1.level - 1))/100;
		}
		
		if (statFinal1.champName.equals("Warwick") && statFinal1.hits < 3){
			if (statFinal1.level < 10){
				statFinal1.bonusMagicAttackDamageExtra += 2.5 + (0.5 * statFinal1.level);
			}
			else{
				statFinal1.lifestealFlatBonus += -2 + (statFinal1.level);//flat lifesteal is probably not affected by enemy magic resist
			}
		}
		if (statFinal1.champName.equals("Sejuani") && statFinal1.hits < 1){
			if(statFinal1.level < 7){
				statFinal1.armorBase += 10;
			}
			else if(statFinal1.level < 12){
				statFinal1.armorBase += 15;
			}
			else if(statFinal1.level < 17){
				statFinal1.armorBase += 20;
			}
			else {
				statFinal1.armorBase += 25;
			}
			
		}
		if (statFinal1.champName.equals("Tryndamere") && statFinal1.hits > 0){
			statFinal1.tryndamereFury += 5 * (1 - statFinal1.criticalChanceFinal) + 10 * (statFinal1.criticalChanceFinal);
			if (statFinal1.tryndamereFury > 100){
				statFinal1.tryndamereFury = 100;
			}
		}
		double caitlynBonusDamage = 0;
		if (statFinal1.champName.equals("Caitlyn")){
			byte caitlynPassive;
			if (statFinal1.level < 7){
				caitlynPassive = 7;
			}
			else if (statFinal1.level < 13){
				caitlynPassive = 6;
			}
			else{
				caitlynPassive = 5;
			}
			
			if(statFinal1.hits % caitlynPassive == 0 && statFinal1.hits > 0){
				caitlynBonusDamage = 0.5 * statFinal1.attackDamageFinal;
			}
		}
		double jarvanBonusDamage = 0;
		if (statFinal1.champName.equals("Jarvan IV") && statFinal1.hits == 0){
			jarvanBonusDamage = 0.1 * statFinal2.currentHealth;
			if (jarvanBonusDamage > 400){
				jarvanBonusDamage = 400;
			}
		}
		double luluBonusDamage = 0;
		if (statFinal1.champName.equals("Lulu")){
			byte luluPassive;
			if (statFinal1.level < 3){
				luluPassive = 9;
			}
			else if (statFinal1.level < 5){
				luluPassive = 21;
			}
			else if (statFinal1.level < 7){
				luluPassive = 33;
			}
			else if (statFinal1.level < 9){
				luluPassive = 45;
			}
			else if (statFinal1.level < 11){
				luluPassive = 57;
			}
			else if (statFinal1.level < 13){
				luluPassive = 69;
			}
			else if (statFinal1.level < 15){
				luluPassive = 81;
			}
			else if (statFinal1.level < 17){
				luluPassive = 93;
			}
			else {
				luluPassive = 105;
			}
			luluBonusDamage = luluPassive + 0.15 * statFinal1.abilityPowerFinal;
		}
		double masterYiBonusDamage = 0;
		if (statFinal1.champName.equals("Master Yi")){		
			if(statFinal1.hits % 4 == 0){
				masterYiBonusDamage = 0.5 * statFinal1.attackDamageFinal;
			}
		}
		double nautilusBonusDamage = 0;
		if (statFinal1.champName.equals("Nautilus")){
			byte nautilusTimer;
			if (statFinal1.level < 6){
				nautilusTimer = 9;
			}
			else if (statFinal1.level < 11){
				nautilusTimer = 8;
			}
			else if (statFinal1.level < 16){
				nautilusTimer = 7;
			}
			else {
				nautilusTimer = 6;
			}

			if(universalMillisecondCounter % nautilusTimer == 0){
				nautilusBonusDamage = 2 + 6 * statFinal1.level;
			}
		}
		if (statFinal1.champName.equals("Nocturne")){
			
		}
		double quinnBonusDamage = 0;
		if (statFinal1.champName.equals("Quinn") && statFinal1.hits > 0){
			int quinnPassive;
			if (statFinal1.level < 15){
				quinnPassive = 15 + 10 * statFinal1.level;
			}
			else{
				quinnPassive = -55 + 15 * statFinal1.level;
			}
			
			if (universalMillisecondCounter % 3000 == 0){
				statFinal1.quinnValorCondition = true;
			}
			if (statFinal1.quinnValorCondition == true){
				quinnBonusDamage = quinnPassive + statFinal1.attackDamageNoCritical;
				statFinal1.quinnValorCondition = false;
			}
			
		}
		double oriannaBonusDamage = 0;
		if (statFinal1.champName.equals("Orianna")){
			if (statFinal1.level < 4){
				oriannaBonusDamage = 10;
			}
			else if (statFinal1.level < 7){
				oriannaBonusDamage = 18;
			}
			else if (statFinal1.level < 10){
				oriannaBonusDamage = 26;
			}
			else if (statFinal1.level < 13){
				oriannaBonusDamage = 34;
			}
			else if (statFinal1.level < 16){
				oriannaBonusDamage = 42;
			}
			else{
				oriannaBonusDamage = 50;
			}
			byte stacks = (byte)statFinal1.hits;
			if (stacks > 2){
				stacks = 2;
			}
			oriannaBonusDamage += (0.15 * statFinal1.abilityPowerFinal) * (1 + 0.2 * stacks);
		}
		double shenBonusDamage = 0;
		if (statFinal1.champName.equals("Shen")){
			statFinal1.shenCounter += 1/statFinal1.attackSpeedFinal + 1;//AS is the delay between attacks, +1 to reduce CD by 1 for each AA
			if (statFinal1.shenCounter > 9){
				shenBonusDamage = 4 + 4 * statFinal1.level + 0.1 * statFinal1.healthExtra;
				statFinal1.shenCounter = 0;
			}
		}	
		double ziggsBonusDamage = 0;
		if (statFinal1.champName.equals("Ziggs")){
			statFinal1.ziggsCounter += 1/statFinal1.attackSpeedFinal;
			if (statFinal1.ziggsCounter > 12){
				if (statFinal1.level < 7){
					ziggsBonusDamage = 16 + 4 * statFinal1.level + 0.25 * statFinal1.abilityPowerFinal;
				}
				else if (statFinal1.level < 13){
					ziggsBonusDamage = -8 + 8 * statFinal1.level + 0.3 * statFinal1.abilityPowerFinal;
				}
				else{
					ziggsBonusDamage = -56 + 12 * statFinal1.level + 0.35 * statFinal1.abilityPowerFinal;
				}
				statFinal1.ziggsCounter = 0;
			}
		}
		byte fizzProtection = 0;
		if (statFinal2.champName.equals("Fizz")){//only applies to physical attacks, but is not affected by armor reduction/penetration
			if (statFinal2.level < 4){
				fizzProtection = 4;
			}
			else if (statFinal2.level < 7){
				fizzProtection = 6;
			} 
			else if (statFinal2.level < 10){
				fizzProtection = 8;
			} 
			else if (statFinal2.level < 13){
				fizzProtection = 10;
			} 
			else if (statFinal2.level < 16){
				fizzProtection = 12;
			} 
			else{
				fizzProtection = 14;
			}
		}
		double vayneBonusDamage = 0;
		if (statFinal1.champName.equals("Vayne") && statFinal1.wskill > 0 && statFinal1.hits % 3 == 0 && statFinal1.hits > 0){
			if (statFinal1.wskill == 1){
				vayneBonusDamage = 20 + 0.04 * statFinal2.healthFinal;
			}
			else if (statFinal1.wskill == 2){
				vayneBonusDamage = 30 + 0.05 * statFinal2.healthFinal;
			}
			else if (statFinal1.wskill == 3){
				vayneBonusDamage = 40 + 0.06 * statFinal2.healthFinal;
			}
			else if (statFinal1.wskill == 4){
				vayneBonusDamage = 50 + 0.07 * statFinal2.healthFinal;
			}
			else {
				vayneBonusDamage = 60 + 0.08 * statFinal2.healthFinal;
			}
		}
		double zedBonusDamage = 0;
		if (statFinal1.champName.equals("Zed")){
			statFinal1.zedCounter += 1/statFinal1.attackSpeedFinal ;
			if (statFinal1.zedCounter >= 10 && statFinal2.currentHealth < 0.5 * statFinal2.healthFinal){
				if (statFinal1.level < 7){
					zedBonusDamage = 0.06 * statFinal2.healthFinal;
				}
				else if (statFinal1.level < 17){
					zedBonusDamage = 0.08 * statFinal2.healthFinal;
				}
				else{
					zedBonusDamage = 0.1 * statFinal2.healthFinal;
				}
				statFinal1.zedCounter = 0;
			}
		}
		if (statFinal2.champName.equals("Pantheon") && statFinal2.hits % 4 == 3){//happens every 4th attack
			statFinal2.pantheonPassive = true;
		}
		double nocturneBonusDamage = 0;
		double nocturneBonusHeal = 0;
		if (statFinal1.champName.equals("Nocturne")){
			statFinal1.nocturneCounter += 1/statFinal1.attackSpeedFinal + 1;
			if (statFinal1.nocturneCounter >= 10){
				if (statFinal1.level < 7){
					nocturneBonusHeal = 10; 
				}
				else if (statFinal1.level < 13){
					nocturneBonusHeal = 18;
				}
				else{
					nocturneBonusHeal = 26;
				}
				nocturneBonusDamage = 0.2 * statFinal1.attackDamageFinal;
				statFinal1.nocturneCounter = 0;
			}
		}

	
		
		
		//DEAL DAMAGE TO ENEMY
		updatePRO(statFinal1, statFinal2);
		updateAD(statFinal1, statFinal2);
		updateDC(statFinal1, statFinal2);
		
		double championBonusPhysicalDamage = caitlynBonusDamage + jarvanBonusDamage + masterYiBonusDamage + nautilusBonusDamage + quinnBonusDamage + nocturneBonusDamage;
		double championBonusMagicalDamage = luluBonusDamage + oriannaBonusDamage + shenBonusDamage + ziggsBonusDamage + zedBonusDamage;
		double championBonusTrueDamage =  -fizzProtection + vayneBonusDamage;//technically fizz reduces physical damage but it is not affected by armor//both act on autoattacks and can be blocked by the general shield but not by a magic shield
		
		
		statFinal1.truePhysicalDamage = (statFinal1.attackDamageFinal + statFinal1.bonusPhysicalAttackDamageFinal + championBonusPhysicalDamage) * statFinal1.physicalDamageCoefficient + statFinal1.bonusTrueDamageFinal + championBonusTrueDamage;
		statFinal1.trueMagicDamage = (statFinal1.bonusMagicAttackDamageFinal + championBonusMagicalDamage) * statFinal1.magicDamageCoefficient;
		
		//activate shield if the damage is enough to kill the champion in one hit
		if (statFinal2.currentHealth < statFinal1.truePhysicalDamage + statFinal1.trueMagicDamage){
			if (criticalConditionOnlyOnce = true){//ensures that the critical condition shields don't come up a second time
				criticalCondition = true;//ensures that the shields come up in time in case a champion is about to get killed in one shot before reaching the conditions
			}
			criticalConditionOnlyOnce = false;
			healthReachesCriticalPoint(statFinal2, statFinal1);
		}
		

		if (statFinal2.pantheonPassive == true){//happens every 4th attack
			statFinal1.truePhysicalDamage = 0;
			statFinal1.trueMagicDamage = 0;
		}
		
		//Some passives needs to be done after the final damage calculation
		if (statFinal1.champName.equals("Ashe") && statFinal1.hits == 0){
			statFinal1.truePhysicalDamage = statFinal1.attackDamageNoCritical * statFinal1.criticalDamageFinal * statFinal1.physicalDamageCoefficient + statFinal1.bonusTrueDamageFinal;
		}
		if (statFinal2.champName.equals("Poppy") && (statFinal1.truePhysicalDamage > (0.1 * statFinal2.currentHealth))){
			statFinal1.truePhysicalDamage /= 2;
		}
		if (statFinal2.champName.equals("Poppy") && (statFinal1.trueMagicDamage > (0.1 * statFinal2.currentHealth))){
			statFinal1.trueMagicDamage /= 2;
		}

		


		if ((statFinal1.truePhysicalDamage) > statFinal2.shield){
			statFinal2.currentHealth +=  statFinal2.shield - (statFinal1.truePhysicalDamage);
			statFinal2.shield = 0;
		}
		else if ((statFinal1.truePhysicalDamage) <= statFinal2.shield){
			statFinal2.shield += -(statFinal1.truePhysicalDamage);
		}
		if ((statFinal1.trueMagicDamage) > statFinal2.magicShield){
			statFinal2.currentHealth += statFinal2.magicShield - statFinal1.trueMagicDamage;
			statFinal2.magicShield = 0;
		}
		else if ((statFinal1.trueMagicDamage) <= statFinal2.magicShield){
			statFinal2.magicShield += -(statFinal1.trueMagicDamage);
		}
		
		
		//GET LIFESTEAL (works on shields)
		double championBonusPhysicalDamageForLifesteal = caitlynBonusDamage + masterYiBonusDamage + nocturneBonusDamage;
		statFinal1.actualLifesteal = ( ((statFinal1.attackDamageFinal + championBonusPhysicalDamageForLifesteal) * statFinal1.physicalDamageCoefficient - fizzProtection) * statFinal1.lifestealPercentFinal) + statFinal1.lifestealFlatBonus + nocturneBonusHeal;
		
		
		if (statFinal2.pantheonPassive == true){//happens every 4th attack
			statFinal1.actualLifesteal = 0;
			statFinal2.pantheonPassive = false;
		}
		
		
		statFinal1.currentHealth += statFinal1.actualLifesteal;
		
		//prevent health from going over the maximum
		if (statFinal1.currentHealth > statFinal1.healthFinal){
			if (statFinal1.theBloodthirsterPassive == true){//The Bloodthirster passive works immediately after attacking and before being attacked or having the enemy Thornmail proc
				//shield
				statFinal1.shield += statFinal1.currentHealth - statFinal1.healthFinal;
				statFinal1.currentHealth = statFinal1.healthFinal;
			}
			else{
				statFinal1.currentHealth = statFinal1.healthFinal;				
			}
		}

		
	
		//thornmail comes after shield calculations
		if (statFinal2.thornmailPassive == true){
			thornmail(statFinal1, statFinal2);
		}
		


		statFinal1.hits ++;
		statFinal1.counter = 1;//reset the counter in case AS changes
	}
	
	

//HEALTH REGENERATION PER FIVE SECONDS
	public void healthRegnerationPerSecond(ClassStatCalculations statFinal1, ClassStatCalculations statFinal2){
		if (statFinal1.perseverance > 0){
			statFinal1.perseveranceBonus = ((statFinal1.healthFinal - statFinal1.currentHealth) * statFinal1.perseverance);
		}
		
		if ((statFinal1.currentHealth < (0.3 * statFinal1.healthFinal)) && statFinal1.volibearHeal == true){
			statFinal1.volibearHeal = false;
			volibearTimer = universalMillisecondCounter;
			statFinal1.volibearHealBonus = 0.05 * statFinal1.healthFinal;
			
		}
		else if (universalMillisecondCounter - volibearTimer > 6000){
			statFinal1.volibearHealBonus = 0;
		}
		
		double dariusDamagePerHalfSecond = 0;//The variable for darius' passive damage must be outside the if statement so it is in scope for the health regen.
		if (statFinal2.champName.equals("Darius") && statFinal2.hits < 6){
			if (statFinal2.level < 3){
				dariusDamagePerHalfSecond = 12;
			}
			else if (statFinal2.level < 5){
				dariusDamagePerHalfSecond = 15;
			}
			else if (statFinal2.level < 7){
				dariusDamagePerHalfSecond = 18;
			}
			else if (statFinal2.level < 9){
				dariusDamagePerHalfSecond = 21;
			}
			else if (statFinal2.level < 11){
				dariusDamagePerHalfSecond = 24;
			}
			else if (statFinal2.level < 13){
				dariusDamagePerHalfSecond = 27;
			}
			else if (statFinal2.level < 15){
				dariusDamagePerHalfSecond = 30;
			}
			else if (statFinal2.level < 18){
				dariusDamagePerHalfSecond = 33;
			}
			else{
				dariusDamagePerHalfSecond = 36;
			}
			
			dariusDamagePerHalfSecond += (0.3 * statFinal2.attackDamageBonus)/10;
			if (statFinal2.hits < 6){
				dariusDamagePerHalfSecond *= statFinal2.hits;
			}
			else{
				dariusDamagePerHalfSecond *= 5;
			}
		}
		
		double fioraPassiveHeal = 0;
		if (statFinal1.champName.equals("Fiora") && statFinal1.hits < 5){
			fioraPassiveHeal += (7 + statFinal1.level) * statFinal1.hits/12;
		}
		else if (statFinal1.champName.equals("Fiora") && statFinal1.hits >= 5){
			fioraPassiveHeal += (7 + statFinal1.level)/3;
		}
		
		double gangplankDamagePerHalfSecond = 0;
		if (statFinal2.champName.equals("Gangplank") && statFinal2.hits < 4){
			gangplankDamagePerHalfSecond = (3 + statFinal2.level) * statFinal2.hits /2;
		}
		else if (statFinal2.champName.equals("Gangplank") && statFinal2.hits >= 4){
			gangplankDamagePerHalfSecond = (3 + statFinal2.level) * 3/2;
		}
		
		double twitchDamagePerHalfSecond = 0;
		if (statFinal2.champName.equals("Twitch")){
			if (statFinal2.level < 4){
				twitchDamagePerHalfSecond = 1/2;
			}
			else if (statFinal2.level < 7){
				twitchDamagePerHalfSecond = 1;
			} 
			else if (statFinal2.level < 10){
				twitchDamagePerHalfSecond = 3/2;
			} 
			else if (statFinal2.level < 13){
				twitchDamagePerHalfSecond = 2;
			} 
			else if (statFinal2.level < 16){
				twitchDamagePerHalfSecond = 5/2;
			}
			else{
				twitchDamagePerHalfSecond = 3;
			}  
			if (statFinal2.hits < 7){
				twitchDamagePerHalfSecond *= statFinal2.hits;
			}
			else{
				twitchDamagePerHalfSecond *= 6;
			}
		}
		
		//The actual healing calculation//Poisons and extra healing from champion passives must already be in /0.5s format
		double poisonEffects = ((dariusDamagePerHalfSecond + gangplankDamagePerHalfSecond)* statFinal1.magicDamageCoefficient) + twitchDamagePerHalfSecond;
		statFinal1.actualHealthRegen = ((statFinal1.healthRegenFinal + statFinal1.perseveranceBonus) /10) + statFinal1.volibearHealBonus - poisonEffects + fioraPassiveHeal;
		statFinal1.currentHealth += statFinal1.actualHealthRegen;
		
		if (statFinal1.currentHealth > statFinal1.healthFinal){
			statFinal1.currentHealth = statFinal1.healthFinal;
		}
	}
	
	
	
	public void duelResult(ClassStatCalculations blueTeam, ClassStatCalculations redTeam){
		if (blueTeam.currentHealth <= 0 && redTeam.currentHealth > 0){//Setup so that competitor 1 is blue in round 1 and red in round 2
			//competitor1 is blue first, competitor2 is red first
			if (round == 1){
				competitor2FinishesWithHealth += redTeam.currentHealth;
			}
			else if (round == 2){
				competitor1FinishesWithHealth += redTeam.currentHealth;
			}
			duelLength += universalMillisecondCounter;
			universalMillisecondCounter = 60000;
		}
		else if (redTeam.currentHealth <= 0 && blueTeam.currentHealth > 0){
			if (round == 1){
				competitor1FinishesWithHealth += blueTeam.currentHealth;
			}
			else if (round == 2){
				competitor2FinishesWithHealth += blueTeam.currentHealth;
			}
			duelLength += universalMillisecondCounter;
			universalMillisecondCounter = 60000;
		}
		else if (universalMillisecondCounter == 60000){
			draw = true;
		}
		else if (redTeam.currentHealth <= 0 && blueTeam.currentHealth <= 0){
			universalMillisecondCounter = 60000;
		}
	}


	

	
	public void backToMainMenu(){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void help(){
		Toast.makeText(getApplicationContext(), "Name - Build name\nAA# - Number of auto attacks\nDmg - Damage dealt in last attack\nLS - Lifesteal from last attack\nHP/5 - Health regeneration per 5 seconds (1/10 added every half-second)\nHP - Current Health\n\nThe timeline only shows when two builds are selected." ,Toast.LENGTH_LONG).show();
	}
	
}
