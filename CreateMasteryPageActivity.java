package com.leagueoflegendscalculator;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateMasteryPageActivity extends ActionBarActivity{

	//you can define a TextView variable here, e.g. TextView test;, but you can't give it a value outside of a method.

	
	
	//needed for mastery conditions only
	byte masteryPointTotal = 0;
	byte offenseMasteryCount = 0;
	byte defenseMasteryCount = 0;
	byte utilityMasteryCount = 0;
	byte butcherCount = 0;
	boolean alchemistCount = false;
	byte greedCount = 0;
	boolean wealthCount = false;
	byte toughSkinCount = 0;
	
	//ADD THESE COUNTERS TO THE SECTION BELOW
	//needed for stats only
	boolean doubleEdgedSwordCount = false;
	byte furyCount = 0;
	byte sorceryCount = 0;
	boolean exposeWeaknessCount = false;
	boolean martialMasteryCount = false;
	boolean arcaneMasteryCount = false;
	boolean bladeWeavingCount = false;
	byte warlordCount = 0;
	byte archmageCount = 0;
	boolean frenzyCount = false; //may be difficult to take this one into account. crits give +5% AS for 3 seconds, stacks 3 times
	byte devastatingStrikeCount = 0;
	boolean arcaneBladeCount = false;
	boolean havocCount = false;
	byte recoveryCount = 0;
	byte enchantedArmorCount = 0;
	boolean unyieldingCount = false;
	boolean oppressionCount = false;
	boolean juggernautCount = false;
	boolean reinforcedArmorCount = false; //may be difficult to take this one into account. crits reduced by 10%
	boolean evasiveCount = false;
	boolean secondWindCount = false;
	boolean runicBlessingCount = false;
	byte fleetOfFootCount = 0;
	boolean strengthOfSpiritCount = false;
	byte vampirismCount = 0;
	byte expandedMindCount = 0;
	byte intelligenceCount = 0;
	
	//needed for mastery conditions and stats
	byte bruteForceCount = 0;
	byte mentalForceCount = 0;
	boolean spellWeavingCount = false;
	byte executionerCount = 0;
	byte blockCount = 0;
	byte veteransScarsCount = 0;
	byte hardinessCount = 0;
	byte resistanceCount = 0;
	byte perseveranceCount = 0;
	byte meditationCount = 0;
	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_mastery_page);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_create_mastery_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_save){
			save();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	
    public void masterySelection (View v){//onClick listener part is done in the xml file for each ImageButton

    	TextView doubleEdgedSword = (TextView) findViewById(R.id.double_edged_sword_text);
    	TextView fury = (TextView) findViewById(R.id.fury_text);
    	TextView sorcery = (TextView) findViewById(R.id.sorcery_text);
    	TextView butcher = (TextView) findViewById(R.id.butcher_text);
    	TextView block = (TextView) findViewById(R.id.block_text);
    	TextView recovery = (TextView) findViewById(R.id.recovery_text);
    	TextView enchantedArmor = (TextView) findViewById(R.id.enchanted_armor_text);
    	TextView toughSkin = (TextView) findViewById(R.id.tough_skin_text);
    	TextView phasewalker = (TextView) findViewById(R.id.phasewalker_text);
    	TextView fleetOfFoot = (TextView) findViewById(R.id.fleet_of_foot_text);
    	TextView meditation = (TextView) findViewById(R.id.meditation_text);
    	TextView scout = (TextView) findViewById(R.id.scout_text);
    	TextView exposeWeakness = (TextView) findViewById(R.id.expose_weakness_text);
    	TextView bruteForce = (TextView) findViewById(R.id.brute_force_text);
    	TextView mentalForce = (TextView) findViewById(R.id.mental_force_text);
    	TextView feast = (TextView) findViewById(R.id.feast_text);
    	TextView unyielding = (TextView) findViewById(R.id.unyielding_text);
    	TextView veteransScars = (TextView) findViewById(R.id.veterans_scars_text);
    	TextView bladedArmor = (TextView) findViewById(R.id.bladed_armor_text);
    	TextView summonersInsight = (TextView) findViewById(R.id.summoners_insight_text);
    	TextView strengthOfSpirit = (TextView) findViewById(R.id.strength_of_spirit_text);
    	TextView alchemist = (TextView) findViewById(R.id.alchemist_text);
    	TextView spellWeaving = (TextView) findViewById(R.id.spell_weaving_text);
    	TextView martialMastery = (TextView) findViewById(R.id.martial_mastery_text);
    	TextView arcaneMastery = (TextView) findViewById(R.id.arcane_mastery_text);
    	TextView executioner = (TextView) findViewById(R.id.executioner_text);
    	TextView oppression = (TextView) findViewById(R.id.oppression_text);
    	TextView juggernaut = (TextView) findViewById(R.id.juggernaut_text);
    	TextView hardiness = (TextView) findViewById(R.id.hardiness_text);
    	TextView resistance = (TextView) findViewById(R.id.resistance_text);
    	TextView greed = (TextView) findViewById(R.id.greed_text);
    	TextView runicAffinity = (TextView) findViewById(R.id.runic_affinity_text);
    	TextView vampirism = (TextView) findViewById(R.id.vampirism_text);
    	TextView culinaryMaster = (TextView) findViewById(R.id.culinary_master_text);
    	TextView bladeWeaving = (TextView) findViewById(R.id.blade_weaving_text);
    	TextView warlord = (TextView) findViewById(R.id.warlord_text);
    	TextView archmage = (TextView) findViewById(R.id.archmage_text);
    	TextView dangerousGame = (TextView) findViewById(R.id.dangerous_game_text);
    	TextView perseverance = (TextView) findViewById(R.id.perseverance_text);
    	TextView swiftness = (TextView) findViewById(R.id.swiftness_text);
    	TextView reinforcedArmor = (TextView) findViewById(R.id.reinforced_armor_text);
    	TextView evasive = (TextView) findViewById(R.id.evasive_text);
    	TextView scavenger = (TextView) findViewById(R.id.scavenger_text);
    	TextView wealth = (TextView) findViewById(R.id.wealth_text);
    	TextView expandedMind = (TextView) findViewById(R.id.expanded_mind_text);
    	TextView inspiration = (TextView) findViewById(R.id.inspiration_text);
    	TextView frenzy = (TextView) findViewById(R.id.frenzy_text);
    	TextView devastatingStrikes = (TextView) findViewById(R.id.devastating_strikes_text);
    	TextView arcaneBlade = (TextView) findViewById(R.id.arcane_blade_text);
    	TextView secondWind = (TextView) findViewById(R.id.second_wind_text);
    	TextView legendaryGuardian = (TextView) findViewById(R.id.legendary_guardian_text);
    	TextView runicBlessing = (TextView) findViewById(R.id.runic_blessing_text);
    	TextView bandit = (TextView) findViewById(R.id.bandit_text);
    	TextView intelligence = (TextView) findViewById(R.id.intelligence_text);
    	TextView havoc = (TextView) findViewById(R.id.havoc_text);
    	TextView tenacious = (TextView) findViewById(R.id.tenacious_text);
    	TextView wanderer = (TextView) findViewById(R.id.wanderer_text);
    	
    	
	    switch(v.getId()){
	     
	     case R.id.double_edged_sword_mastery:
	    	 if (masteryPointTotal <=30){
		    	 masteryPointTotal++;
		    	 offenseMasteryCount++;
		    	 doubleEdgedSwordCount = true;
		    	 if (doubleEdgedSword.getText().toString().equals("0/1")){
		    		 doubleEdgedSword.setText("1/1");
		    	 }
		    	 else {//prevents the points from going way up if over-selected.
		    		 offenseMasteryCount--;
		    		 masteryPointTotal--;
		    	 }
	    	 }
	    	 break;
	    	 
		 case R.id.fury_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
		    	 offenseMasteryCount++;
		    	 furyCount++;
		    	 if (fury.getText().toString().equals("0/4")){
		    		 fury.setText("1/4");
		    	 }
		    	 else if (fury.getText().toString().equals("1/4")){
		    		 fury.setText("2/4");
		    	 }
		    	 else if (fury.getText().toString().equals("2/4")){
		    		 fury.setText("3/4");
		    	 }
		    	 else if (fury.getText().toString().equals("3/4")){
		    		 fury.setText("4/4");
		    	 }
		    	 else{
		    		 offenseMasteryCount--;
		    		 masteryPointTotal--;
		    		 furyCount--;
		    	 }
	    	 }
		 	break;
		 	
		 	
	     case R.id.sorcery_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
		    	 offenseMasteryCount++;
		    	 sorceryCount++;
		    	 if (sorcery.getText().toString().equals("0/4")){
		    		 sorcery.setText("1/4");
		    	 }
		    	 else if (sorcery.getText().toString().equals("1/4")){
		    		 sorcery.setText("2/4");
		    	 }
		    	 else if (sorcery.getText().toString().equals("2/4")){
		    		 sorcery.setText("3/4");
		    	 }
		    	 else if (sorcery.getText().toString().equals("3/4")){
		    		 sorcery.setText("4/4");
		    	 }
		    	 else{
		    		 offenseMasteryCount--;
		    		 masteryPointTotal--;
		    		 sorceryCount--;
		    	 }
	    	 }
	     	break;
	     	
	     	
	     case R.id.butcher_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
		    	 offenseMasteryCount++;
		    	 butcherCount++;
		    	 if (butcher.getText().toString().equals("0/1")){
		    		 butcher.setText("1/1");
		    	 }
		    	 else{
		    		 offenseMasteryCount--;
		    		 butcherCount--;
		    		 masteryPointTotal--;
		    	 }
	    	 }
	     	break;
	     	
	     	
	     case R.id.block_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
		    	 defenseMasteryCount ++;
		    	 blockCount++;
		    	 if (block.getText().toString().equals("0/2")){
		    		 block.setText("1/2");
		    	 }
		    	 else if (block.getText().toString().equals("1/2")){
		    		 block.setText("2/2");
		    	 }
		    	 else{
		    		 defenseMasteryCount--;
		    		 blockCount--;
		    		 masteryPointTotal--;
		    	 }
	    	 }
	     	break;
	     	
	     	
	     case R.id.recovery_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
		    	 defenseMasteryCount ++;
		    	 recoveryCount++;
		    	 if (recovery.getText().toString().equals("0/2")){
		    		 recovery.setText("1/2");
		    	 }
		    	 else if (recovery.getText().toString().equals("1/2")){
		    		 recovery.setText("2/2");
		    	 }
		    	 else{
		    		 defenseMasteryCount--;
		    		 masteryPointTotal--;
		    		 recoveryCount--;
		    	 }
	    	 }
	     	break;
	     	
	     	
	     case R.id.enchanted_armor_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
		    	 defenseMasteryCount ++;
		    	 enchantedArmorCount++;
		    	 if (enchantedArmor.getText().toString().equals("0/2")){
		    		 enchantedArmor.setText("1/2");
		    	 }
		    	 else if (enchantedArmor.getText().toString().equals("1/2")){
		    		 enchantedArmor.setText("2/2");
		    	 }
		    	 else{
		    		 defenseMasteryCount--;
		    		 masteryPointTotal--;
		    		 enchantedArmorCount--;
		    	 }
	    	 }
	     	break;
	     	
	     	
	     case R.id.tough_skin_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
		    	 defenseMasteryCount ++;
		    	 toughSkinCount++;
		    	 if (toughSkin.getText().toString().equals("0/2")){
		    		 toughSkin.setText("1/2");
		    	 }
		    	 else if (toughSkin.getText().toString().equals("1/2")){
		    		 toughSkin.setText("2/2");
		    	 }
		    	 else{
		    		 defenseMasteryCount--;
		    		 toughSkinCount--;
		    		 masteryPointTotal--;
		    	 }
	    	 }
	     	break;
	     
	     	
	     case R.id.phasewalker_mastery:

	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
	    		 utilityMasteryCount ++;
		    	 if (phasewalker.getText().toString().equals("0/1")){
		    		 phasewalker.setText("1/1");
		    	 }
		    	 else{
		    		 utilityMasteryCount--;
		    		 masteryPointTotal--;
		    	 }
	    	 }
	     	break;
	     
	     	
	     case R.id.fleet_of_foot_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 fleetOfFootCount++;
		    	 if (fleetOfFoot.getText().toString().equals("0/3")){
		    		 fleetOfFoot.setText("1/3");
		    	 }
		    	 else if (fleetOfFoot.getText().toString().equals("1/3")){
		    		 fleetOfFoot.setText("2/3");
		    	 }
		    	 else if (fleetOfFoot.getText().toString().equals("2/3")){
		    		 fleetOfFoot.setText("3/3");
		    	 }
		    	 else{
		    		 utilityMasteryCount--;
		    		 masteryPointTotal--;
		    		 fleetOfFootCount--;
		    	 }
	    	 }
	     	break;
	     
	     	
	     case R.id.meditation_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
		    	 utilityMasteryCount ++;
		    	 meditationCount++;
		    	 if (meditation.getText().toString().equals("0/3")){
		    		 meditation.setText("1/3");
		    	 }
		    	 else if (meditation.getText().toString().equals("1/3")){
		    		 meditation.setText("2/3");
		    	 }
		    	 else if (meditation.getText().toString().equals("2/3")){
		    		 meditation.setText("3/3");
		    	 }
		    	 else{
		    		 utilityMasteryCount--;
		    		 meditationCount--;
		    		 masteryPointTotal--;
		    	 }
	    	 }
	     	break; 
	     	
	     
	     case R.id.scout_mastery:
	    	 if (masteryPointTotal <=30){
	    		 masteryPointTotal++;
	    		 utilityMasteryCount ++;
		    	 if (scout.getText().toString().equals("0/3")){
		    		 scout.setText("1/3");
		    	 }
		    	 else if (scout.getText().toString().equals("1/3")){
		    		 scout.setText("2/3");
		    	 }
		    	 else if (scout.getText().toString().equals("2/3")){
		    		 scout.setText("3/3");
		    	 }
		    	 else{
		    		 utilityMasteryCount--;
		    		 masteryPointTotal--;
		    	 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.expose_weakness_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 4){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 exposeWeaknessCount = true;
		    	 if (exposeWeakness.getText().toString().equals("0/1")){
		    		 exposeWeakness.setText("1/1");
		    	 }
		    	 else{
		    		 offenseMasteryCount--;
		    		 masteryPointTotal--;
		    	 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.brute_force_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 4){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 bruteForceCount++;
		    	 if (bruteForce.getText().toString().equals("0/3")){
		    		 bruteForce.setText("1/3");
		    	 }
		    	 else if (bruteForce.getText().toString().equals("1/3")){
		    		 bruteForce.setText("2/3");
		    	 }
		    	 else if (bruteForce.getText().toString().equals("2/3")){
		    		 bruteForce.setText("3/3");
		    	 }
		    	 else{
		    		 offenseMasteryCount--;
		    		 bruteForceCount--;
		    		 masteryPointTotal--;
		    	 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.mental_force_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 4){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 mentalForceCount++;
	    		 if (mentalForce.getText().toString().equals("0/3")){
	    			 mentalForce.setText("1/3");
	    		 }
	    		 else if (mentalForce.getText().toString().equals("1/3")){
	    			 mentalForce.setText("2/3");
	    		 }
	    		 else if (mentalForce.getText().toString().equals("2/3")){
	    			 mentalForce.setText("3/3");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
	    			 mentalForceCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.feast_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 4 && butcherCount == 1){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 if (feast.getText().toString().equals("0/1")){
	    			 feast.setText("1/1");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.unyielding_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 4 && blockCount == 2){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 unyieldingCount = true;
	    		 if (unyielding.getText().toString().equals("0/1")){
	    			 unyielding.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.veterans_scars_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 4){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 veteransScarsCount++;
	    		 if (veteransScars.getText().toString().equals("0/3")){
	    			 veteransScars.setText("1/3");
	    		 }
	    		 else if (veteransScars.getText().toString().equals("1/3")){
	    			 veteransScars.setText("2/3");
	    		 }
	    		 else if (veteransScars.getText().toString().equals("2/3")){
	    			 veteransScars.setText("3/3");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 veteransScarsCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.bladed_armor_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 4 && toughSkinCount == 2){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 if (bladedArmor.getText().toString().equals("0/1")){
	    			 bladedArmor.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.summoners_insight_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 4){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 if (summonersInsight.getText().toString().equals("0/3")){
	    			 summonersInsight.setText("1/3");
	    		 }
	    		 else if (summonersInsight.getText().toString().equals("1/3")){
	    			 summonersInsight.setText("2/3");
	    		 }
	    		 else if (summonersInsight.getText().toString().equals("2/3")){
	    			 summonersInsight.setText("3/3");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.strength_of_spirit_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 4 && meditationCount == 3){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 strengthOfSpiritCount = true;
	    		 if (strengthOfSpirit.getText().toString().equals("0/1")){
	    			 strengthOfSpirit.setText("1/1");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.alchemist_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 4){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 alchemistCount = true;
	    		 if (alchemist.getText().toString().equals("0/1")){
	    			 alchemist.setText("1/1");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	    	 
	     	break;     
	     
	     	
	     case R.id.spell_weaving_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 8){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 spellWeavingCount = true;
	    		 if (spellWeaving.getText().toString().equals("0/1")){
	    			 spellWeaving.setText("1/1");
	    		 }
	    		 else{
		    		 offenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break; 
	     	
	     
	     case R.id.martial_mastery_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 8 && bruteForceCount == 3){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 martialMasteryCount = true;
	    		 if (martialMastery.getText().toString().equals("0/1")){
	    			 martialMastery.setText("1/1");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.arcane_mastery_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 8 && mentalForceCount == 3){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 arcaneMasteryCount = true;
	    		 if (arcaneMastery.getText().toString().equals("0/1")){
	    			 arcaneMastery.setText("1/1");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
	     
	     	
	     case R.id.executioner_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 8){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 executionerCount++;
	    		 if (executioner.getText().toString().equals("0/3")){
	    			 executioner.setText("1/3");
	    		 }
	    		 else if (executioner.getText().toString().equals("1/3")){
	    			 executioner.setText("2/3");
	    		 }
	    		 else if (executioner.getText().toString().equals("2/3")){
	    			 executioner.setText("3/3");
	    		 }
	    		 else{
		    		 offenseMasteryCount--;
		    		 executionerCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.oppression_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 8){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 oppressionCount = true;
	    		 if (oppression.getText().toString().equals("0/1")){
	    			 oppression.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;    
	     	

	     case R.id.juggernaut_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 8 && veteransScarsCount == 3){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 juggernautCount = true;
	    		 if (juggernaut.getText().toString().equals("0/1")){
	    			 juggernaut.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.hardiness_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 8){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 hardinessCount++;
	    		 if (hardiness.getText().toString().equals("0/3")){
	    			 hardiness.setText("1/3");
	    		 }
	    		 else if (hardiness.getText().toString().equals("1/3")){
	    			 hardiness.setText("2/3");
	    		 }
	    		 else if (hardiness.getText().toString().equals("2/3")){
	    			 hardiness.setText("3/3");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 hardinessCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.resistance_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 8){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 resistanceCount++;
	    		 if (resistance.getText().toString().equals("0/3")){
	    			 resistance.setText("1/3");
	    		 }
	    		 else if (resistance.getText().toString().equals("1/3")){
	    			 resistance.setText("2/3");
	    		 }
	    		 else if (resistance.getText().toString().equals("2/3")){
	    			 resistance.setText("3/3");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 resistanceCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.greed_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 8){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 greedCount++;
	    		 if (greed.getText().toString().equals("0/3")){
	    			 greed.setText("1/3");
	    		 }
	    		 else if (greed.getText().toString().equals("1/3")){
	    			 greed.setText("2/3");
	    		 }
	    		 else if (greed.getText().toString().equals("2/3")){
	    			 greed.setText("3/3");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
	    			 greedCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	    	 
	     	break;     

	     	
	     case R.id.runic_affinity_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 8){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 if (runicAffinity.getText().toString().equals("0/1")){
	    			 runicAffinity.setText("1/1");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.vampirism_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 8){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 vampirismCount++;
	    		 if (vampirism.getText().toString().equals("0/3")){
	    			 vampirism.setText("1/3");
	    		 }
	    		 else if (vampirism.getText().toString().equals("1/3")){
	    			 vampirism.setText("2/3");
	    		 }
	    		 else if (vampirism.getText().toString().equals("2/3")){
	    			 vampirism.setText("3/3");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
		    		 vampirismCount--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.culinary_master_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >=8 && alchemistCount == true){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 if (culinaryMaster.getText().toString().equals("0/1")){
	    			 culinaryMaster.setText("1/1");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.blade_weaving_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 12 && spellWeavingCount == true){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 bladeWeavingCount = true;
	    		 if (bladeWeaving.getText().toString().equals("0/1")){
	    			 bladeWeaving.setText("1/1");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.warlord_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 12){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 warlordCount++;
	    		 if (warlord.getText().toString().equals("0/3")){
	    			 warlord.setText("1/3");
	    		 }
	    		 else if (warlord.getText().toString().equals("1/3")){
	    			 warlord.setText("2/3");
	    		 }
	    		 else if (warlord.getText().toString().equals("2/3")){
	    			 warlord.setText("3/3");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
		    		 warlordCount--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.archmage_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 12){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 archmageCount++;
	    		 if (archmage.getText().toString().equals("0/3")){
	    			 archmage.setText("1/3");
	    		 }
	    		 else if (archmage.getText().toString().equals("1/3")){
	    			 archmage.setText("2/3");
	    		 }
	    		 else if (archmage.getText().toString().equals("2/3")){
	    			 archmage.setText("3/3");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
		    		 archmageCount--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.dangerous_game_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 12 && executionerCount == 3){
		    	 masteryPointTotal++;
	    	 offenseMasteryCount++;
	    		 if (dangerousGame.getText().toString().equals("0/1")){
	    			 dangerousGame.setText("1/1");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.perseverance_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 12){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 perseveranceCount++;
	    		 if (perseverance.getText().toString().equals("0/3")){
	    			 perseverance.setText("1/3");
	    		 }
	    		 else if (perseverance.getText().toString().equals("1/3")){
	    			 perseverance.setText("2/3");
	    		 }
	    		 else if (perseverance.getText().toString().equals("2/3")){
	    			 perseverance.setText("3/3");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 perseveranceCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.swiftness_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 12){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 if (swiftness.getText().toString().equals("0/1")){
	    			 swiftness.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.reinforced_armor_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 12 && hardinessCount == 3){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 reinforcedArmorCount = true;
	    		 if (reinforcedArmor.getText().toString().equals("0/1")){
	    			 reinforcedArmor.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.evasive_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 12 && resistanceCount == 3){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 evasiveCount = true;
	    		 if (evasive.getText().toString().equals("0/1")){
	    			 evasive.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.scavenger_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >=12 && greedCount == 3){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 if (scavenger.getText().toString().equals("0/1")){
	    			 scavenger.setText("1/1");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.wealth_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 12){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 wealthCount = true;
	    		 if (wealth.getText().toString().equals("0/1")){
	    			 wealth.setText("1/1");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.expanded_mind_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 12){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 expandedMindCount++;
	    		 if (expandedMind.getText().toString().equals("0/3")){
	    			 expandedMind.setText("1/3");
	    		 }
	    		 else if (expandedMind.getText().toString().equals("1/3")){
	    			 expandedMind.setText("2/3");
	    		 }
	    		 else if (expandedMind.getText().toString().equals("2/3")){
	    			 expandedMind.setText("3/3");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
		    		 expandedMindCount--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.inspiration_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 12){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 if (inspiration.getText().toString().equals("0/2")){
	    			 inspiration.setText("1/2");
	    		 }
	    		 else if (inspiration.getText().toString().equals("1/2")){
	    			 inspiration.setText("2/2");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.frenzy_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 16){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 frenzyCount = true;
	    		 if (frenzy.getText().toString().equals("0/1")){
	    			 frenzy.setText("1/1");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.devastating_strikes_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 16){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 devastatingStrikeCount++;
	    		 if (devastatingStrikes.getText().toString().equals("0/3")){
	    			 devastatingStrikes.setText("1/3");
	    		 }
	    		 else if (devastatingStrikes.getText().toString().equals("1/3")){
	    			 devastatingStrikes.setText("2/3");
	    		 }
	    		 else if (devastatingStrikes.getText().toString().equals("2/3")){
	    			 devastatingStrikes.setText("3/3");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
		    		 devastatingStrikeCount--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.arcane_blade_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 16){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 arcaneBladeCount = true;
	    		 if (arcaneBlade.getText().toString().equals("0/1")){
	    			 arcaneBlade.setText("1/1");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.second_wind_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 16 && perseveranceCount == 3){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 secondWindCount = true;
	    		 if (secondWind.getText().toString().equals("0/1")){
	    			 secondWind.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.legendary_guardian_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 16){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 if (legendaryGuardian.getText().toString().equals("0/4")){
	    			 legendaryGuardian.setText("1/4");
	    		 }
	    		 else if (legendaryGuardian.getText().toString().equals("1/4")){
	    			 legendaryGuardian.setText("2/4");
	    		 }
	    		 else if (legendaryGuardian.getText().toString().equals("2/4")){
	    			 legendaryGuardian.setText("3/4");
	    		 }
	    		 else if (legendaryGuardian.getText().toString().equals("3/4")){
	    			 legendaryGuardian.setText("4/4");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.runic_blessing_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 16){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 runicBlessingCount = true;
	    		 if (runicBlessing.getText().toString().equals("0/1")){
	    			 runicBlessing.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.bandit_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >=16 && wealthCount == true){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 if (bandit.getText().toString().equals("0/1")){
	    			 bandit.setText("1/1");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.intelligence_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 16){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 intelligenceCount++;
	    		 if (intelligence.getText().toString().equals("0/3")){
	    			 intelligence.setText("1/3");
	    		 }
	    		 else if (intelligence.getText().toString().equals("1/3")){
	    			 intelligence.setText("2/3");
	    		 }
	    		 else if (intelligence.getText().toString().equals("2/3")){
	    			 intelligence.setText("3/3");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
		    		 intelligenceCount--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.havoc_mastery:
	    	 if (masteryPointTotal <=30 && offenseMasteryCount >= 20){
		    	 masteryPointTotal++;
	    		 offenseMasteryCount++;
	    		 havocCount = true;
	    		 if (havoc.getText().toString().equals("0/1")){
	    			 havoc.setText("1/1");
	    		 }
	    		 else{
	    			 offenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.tenacious_mastery:
	    	 if (masteryPointTotal <=30 && defenseMasteryCount >= 20){
		    	 masteryPointTotal++;
	    		 defenseMasteryCount ++;
	    		 if (tenacious.getText().toString().equals("0/1")){
	    			 tenacious.setText("1/1");
	    		 }
	    		 else{
	    			 defenseMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     

	     	
	     case R.id.wanderer_mastery:
	    	 if (masteryPointTotal <=30 && utilityMasteryCount >= 20){
		    	 masteryPointTotal++;
	    		 utilityMasteryCount ++;
	    		 if (wanderer.getText().toString().equals("0/1")){
	    			 wanderer.setText("1/1");
	    		 }
	    		 else{
	    			 utilityMasteryCount--;
		    		 masteryPointTotal--;
	    		 }
	    	 }
	     	break;     
      	}
   }
    
	public void save(){
		EditText masterySetNameView = (EditText)findViewById(R.id.mastery_set_name);
		String masterySetName = masterySetNameView.getText().toString();
		
		Intent saveMasteryPage = new Intent(this, ViewMasteryActivity.class);
		saveMasteryPage.putExtra("Mastery Set Name", masterySetName);
		saveMasteryPage.putExtra("offenseMasteryCount", offenseMasteryCount);//.toString());
		saveMasteryPage.putExtra("defenseMasteryCount", defenseMasteryCount);
		saveMasteryPage.putExtra("utilityMasteryCount", utilityMasteryCount);
		saveMasteryPage.putExtra("doubleEdgedSwordCount", doubleEdgedSwordCount);
		saveMasteryPage.putExtra("furyCount", furyCount);
		saveMasteryPage.putExtra("sorceryCount", sorceryCount);
		saveMasteryPage.putExtra("exposeWeaknessCount", exposeWeaknessCount);
		saveMasteryPage.putExtra("martialMasteryCount", martialMasteryCount);
		saveMasteryPage.putExtra("arcaneMasteryCount", arcaneMasteryCount);
		saveMasteryPage.putExtra("bladeWeavingCount", bladeWeavingCount);
		saveMasteryPage.putExtra("warlordCount", warlordCount);
		saveMasteryPage.putExtra("archmageCount", archmageCount);
		saveMasteryPage.putExtra("frenzyCount", frenzyCount);
		saveMasteryPage.putExtra("devastatingStrikeCount", devastatingStrikeCount);
		saveMasteryPage.putExtra("arcaneBladeCount", arcaneBladeCount);
		saveMasteryPage.putExtra("havocCount", havocCount);
		saveMasteryPage.putExtra("recoveryCount", recoveryCount);
		saveMasteryPage.putExtra("enchantedArmorCount", enchantedArmorCount);
		saveMasteryPage.putExtra("unyieldingCount", unyieldingCount);
		saveMasteryPage.putExtra("oppressionCount", oppressionCount);
		saveMasteryPage.putExtra("juggernautCount", juggernautCount);
		saveMasteryPage.putExtra("reinforcedArmorCount", reinforcedArmorCount);
		saveMasteryPage.putExtra("evasiveCount", evasiveCount);
		saveMasteryPage.putExtra("secondWindCount", secondWindCount);
		saveMasteryPage.putExtra("runicBlessingCount", runicBlessingCount);
		saveMasteryPage.putExtra("fleetOfFootCount", fleetOfFootCount);
		saveMasteryPage.putExtra("strengthOfSpiritCount", strengthOfSpiritCount);
		saveMasteryPage.putExtra("vampirismCount", vampirismCount);
		saveMasteryPage.putExtra("expandedMindCount", expandedMindCount);
		saveMasteryPage.putExtra("intelligenceCount", intelligenceCount);
		saveMasteryPage.putExtra("bruteForceCount", bruteForceCount);
		saveMasteryPage.putExtra("mentalForceCount", mentalForceCount);
		saveMasteryPage.putExtra("spellWeavingCount", spellWeavingCount);
		saveMasteryPage.putExtra("executionerCount", executionerCount);
		saveMasteryPage.putExtra("blockCount", blockCount);
		saveMasteryPage.putExtra("veteransScarsCount", veteransScarsCount);
		saveMasteryPage.putExtra("hardinessCount", hardinessCount);
		saveMasteryPage.putExtra("resistanceCount", resistanceCount);
		saveMasteryPage.putExtra("perseveranceCount", perseveranceCount);
		saveMasteryPage.putExtra("meditationCount", meditationCount);
		
		startActivity(saveMasteryPage);
	}
	

	

}

