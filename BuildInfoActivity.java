package com.leagueoflegendscalculator;

import com.google.android.gms.ads.*;
import java.text.DecimalFormat;
import com.google.gson.Gson;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.leagueoflegendscalculator.myclasses.ClassStatCalculations;
import com.leagueoflegendscalculator.myclasses.ConvertSavedElementsBuildsToClassStatCalculations;
import com.leagueoflegendscalculator.myclasses.SavedElementsBuilds;
import com.leagueoflegendscalculator.myclasses.SavedElementsChampions;
import com.leagueoflegendscalculator.myclasses.SavedElementsItems;
import com.leagueoflegendscalculator.myclasses.SavedElementsMastery;
import com.leagueoflegendscalculator.myclasses.SavedElementsRunes;
import com.leagueoflegendscalculator.myclasses.SetChampionPicture;
import com.leagueoflegendscalculator.myclasses.SetItemPicture;

public class BuildInfoActivity extends ActionBarActivity {
    
	String championKey;
	String itemKey;
	String masteryKey;
	String runeKey;
	
	SavedElementsChampions championInput;
	SavedElementsItems itemInput;
	SavedElementsMastery masteryInput;
	SavedElementsRunes runeInput;
	
	String championInfo;
	Integer championImage;
    Integer itemImage1; 
    Integer itemImage2; 
    Integer itemImage3;
    Integer itemImage4; 
    Integer itemImage5;
    Integer itemImage6; 
    String allStats;
    
	DecimalFormat twoDForm = new DecimalFormat("#.##");//for rounding numbers to two decimal places properly
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_build_info);

	    // Look up the AdView as a resource and load a request.
	    AdView adView = (AdView) this.findViewById(R.id.adView);
	    AdRequest adRequest = new AdRequest.Builder().build();
	    adView.loadAd(adRequest);
	    
		//Get the String info from the cell of the selected build
		Intent intent = getIntent();
		championKey = intent.getStringExtra("Champion Key");
		itemKey = intent.getStringExtra("Item Key");
		masteryKey = intent.getStringExtra("Mastery Key");
		runeKey = intent.getStringExtra("Rune Key");
		
		//Convert the String info into Class info
		Gson gson = new Gson();
    	championInput = gson.fromJson(championKey, SavedElementsChampions.class);
		itemInput = gson.fromJson(itemKey, SavedElementsItems.class);
		masteryInput = gson.fromJson(masteryKey, SavedElementsMastery.class);
		runeInput = gson.fromJson(runeKey, SavedElementsRunes.class);
		
		//Use the Class info to make the data that needs to be displayed
        championInfo =  championInput.getName() + ", Level " + championInput.getLevel() + "\nQ/W/E/R = " + championInput.getQSkill() +"/"+ championInput.getWSkill() +"/"+ championInput.getESkill() +"/"+ championInput.getRSkill();
        SetChampionPicture championImageObject = new SetChampionPicture(championInput.getName());
        championImage = championImageObject.championPicture;
        SetItemPicture itemImageObject = new SetItemPicture(itemInput.getItem1(), itemInput.getItem2(), itemInput.getItem3(), itemInput.getItem4(), itemInput.getItem5(), itemInput.getItem6());
        itemImage1 = itemImageObject.itemPicture[0];
        itemImage2 = itemImageObject.itemPicture[1];
        itemImage3 = itemImageObject.itemPicture[2];
        itemImage4 = itemImageObject.itemPicture[3];
        itemImage5 = itemImageObject.itemPicture[4];
        itemImage6 = itemImageObject.itemPicture[5];
        SavedElementsBuilds buildInput = new SavedElementsBuilds("not important", championKey, itemKey, masteryKey, runeKey);
        allStats = allStatCalculation(buildInput);
        /////////////////////////////////////MAKE A NOTE THAT THESE STATS EXCLUDE ANY PASSIVE BONUSES FROM ABILITES, BUT THEY DO TAKE INTO ACCOUNT PASSIVES FROM ITEMS AND CHAMPION PASSIVES
        
        //Set up the TextViews and ImageViews of the XML file
		TextView championInfoTextView = (TextView)findViewById(R.id.champion_info);
		ImageView championImageView = (ImageView)findViewById(R.id.champion_image);
		ImageView itemImageView1 = (ImageView)findViewById(R.id.item_image1);
		ImageView itemImageView2 = (ImageView)findViewById(R.id.item_image2);
		ImageView itemImageView3 = (ImageView)findViewById(R.id.item_image3);
		ImageView itemImageView4 = (ImageView)findViewById(R.id.item_image4);
		ImageView itemImageView5 = (ImageView)findViewById(R.id.item_image5);
		ImageView itemImageView6 = (ImageView)findViewById(R.id.item_image6);
		TextView allStatsTextView = (TextView)findViewById(R.id.all_stats);
		
		//Populate the XML file with the data
		championInfoTextView.setText(championInfo);
		championImageView.setImageResource(championImage);
		itemImageView1.setImageResource(itemImage1);
		itemImageView2.setImageResource(itemImage2);
		itemImageView3.setImageResource(itemImage3);
		itemImageView4.setImageResource(itemImage4);
		itemImageView5.setImageResource(itemImage5);
		itemImageView6.setImageResource(itemImage6);
		allStatsTextView.setText(allStats);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_build_info, menu);
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
		else if (id == R.id.action_help) {
			help();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	public String allStatCalculation(SavedElementsBuilds buildInput){

		ClassStatCalculations statFinal = new ConvertSavedElementsBuildsToClassStatCalculations(buildInput).statFinal;
		
		
//MANA, ENERGY, OR NEITHER
		String manaEquivalent;
		
		//normally you would put the most likely case at the top to make this branch more efficient, but in this case you would have to have a much
		//more complicated set of conditions. It would make sense if the cases were defined as mathematical inequalities, but in this case I need
		//to make conditions that retrieve a string from an object and compare it to potentially many other strings.
		String champName = statFinal.champName;
		
		if (champName.equals("Aatrox") || champName.equals("Dr.Mundo") || champName.equals("Garen") || champName.equals("Gnar") || champName.equals("Katarina") || champName.equals("Mordekaiser") || champName.equals("Renekton") || champName.equals("Rengar") || champName.equals("Riven") || champName.equals("Rumble") || champName.equals("Shyvana") || champName.equals("Tryndamere") || champName.equals("Vladimir") || champName.equals("Yasuo") || champName.equals("Zac")){
			manaEquivalent = "";
		}
		else if (champName.equals("Akali") || champName.equals("Kennen") || champName.equals("Lee Sin") || champName.equals("Shen") || champName.equals("Zed")){
			manaEquivalent = "\nEnergy = " + Double.valueOf(twoDForm.format(statFinal.energyFinal)) + "\nEnergy/5 = " + Double.valueOf(twoDForm.format(statFinal.energyRegenFinal));
		}
		else{
			manaEquivalent = "\nMana = " + Double.valueOf(twoDForm.format(statFinal.manaFinal)) + "\nMana/5 = " + Double.valueOf(twoDForm.format(statFinal.manaRegenFinal));
		}
		
		
//ITEM UNIQUE PASSIVES//Most passives are dealt with in ClassItems, but many that are omitted there are omitted here as well because their stats are too dynamic
		//Multiplicative Bonuses
		if (statFinal.insightPassive == true){
			statFinal.manaFinal *= 1.03;
		}
		//condition for multiplicative AP is done way below, and Nashor's Tooth is done after it
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
		
		
		if (champName.equals("Akali")){
			statFinal.bonusMagicAttackDamageExtra += ((0.06 + statFinal.abilityPowerFinal/600) * statFinal.attackDamageFinal);
			statFinal.spellVampFinal += 0.06 + statFinal.attackDamageBonus/600;
		}
		else if (champName.equals("Corki")){
			statFinal.bonusPhysicalAttackDamageFinal += 1.1 * statFinal.attackDamageFinal;
		}
		else if (champName.equals("Dr.Mundo")){
			statFinal.healthRegenFinal += (0.015 * statFinal.healthFinal);
		}
		else if (champName.equals("Galio")){
			statFinal.abilityPowerExtra += 0.5 * statFinal.magicResistFinal;
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
		else if (champName.equals("Janna")){
			statFinal.movementSpeedFinal *= 1.05;
		}
		else if (champName.equals("Morgana")){
			if (statFinal.level < 6){
				statFinal.spellVampFinal += 0.1;
			}
			else if (statFinal.level < 12){
				statFinal.spellVampFinal  += 0.15;
			}
			else{
				statFinal.spellVampFinal  += 0.2;
			}
		}
		else if (champName.equals("Nasus")){
			if (statFinal.level < 6){
				statFinal.lifestealPercentFinal += 0.1;
			}
			else if (statFinal.level < 12){
				statFinal.lifestealPercentFinal  += 0.15;
			}
			else{
				statFinal.lifestealPercentFinal  += 0.2;
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
		else if (champName.equals("Singed")){
			statFinal.healthFinal += 0.25 * statFinal.manaFinal;
		}
		else if (champName.equals("Tristana")){
			statFinal.rangeFinal += 9 * (statFinal.level - 1);
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
		

		
		if(statFinal.atmasImpalerPassive == true){
			statFinal.attackDamageBonus += statFinal.healthFinal*(0.015);
		}
		if(statFinal.warmogsArmorPassive == true){
			statFinal.healthRegenFinal += (statFinal.healthFinal * 0.01);
		}
		

		
		//LIMITS ON STATS (Do for Duel Simulator as well) //updates //should  do something similar for all the other stats that have multiplicative increases from masteries and runes, for this section and the Duel Simulator
		statFinal.attackSpeedFinal = statFinal.attackSpeedBase * (1 + statFinal.attackSpeedBonus);
		if (statFinal.attackSpeedFinal > 2.5){
			statFinal.attackSpeedFinal = 2.5;
		}
		if (statFinal.criticalChanceFinal > 1){
			statFinal.criticalChanceFinal = 1;
		}
		
		updateAP(statFinal);
		
		if(statFinal.nashorsToothPassive == true){
			statFinal.bonusMagicAttackDamageExtra += 15 + (statFinal.abilityPowerFinal * 0.15);
		}
		
		statFinal.attackDamageNoCritical = (statFinal.attackDamageBase + statFinal.attackDamageBonus) * (1 + statFinal.havoc);
		statFinal.attackDamageFinal = (statFinal.attackDamageNoCritical * (1-statFinal.criticalChanceFinal)) + (statFinal.attackDamageNoCritical * statFinal.criticalChanceFinal * statFinal.criticalDamageFinal);
		statFinal.bonusMagicAttackDamageFinal = statFinal.bonusMagicAttackDamageExtra + (statFinal.arcaneBlade * statFinal.abilityPowerFinal);
		statFinal.physicalDamagePerSecondRaw = statFinal.attackDamageFinal * statFinal.attackSpeedFinal;
		
		double bonusPhysicalDPS = statFinal.bonusPhysicalAttackDamageFinal * statFinal.attackSpeedFinal;//some champions have unique passives that give bonus physical damage
		double bonusMagicDPS = statFinal.bonusMagicAttackDamageFinal * statFinal.attackSpeedFinal;//some champions have unique passives that give bonus physical damage
		
		if (statFinal.coolDownReductionFinal > 0.4){
			statFinal.criticalChanceFinal = 0.4;
		}

		
		String blackCleaver = "0%";
		if (statFinal.theBlackCleaverStacksPerHit > 0){
			blackCleaver = "0% to 25%";
		}
		String BotRK = "";
		if (statFinal.bladeOfTheRuinedKingPassive == true){
			BotRK = "> ";
		}
		
		
		String allStats = "Advanced Stats:"
				+ "\nAve Total DPS = " + Double.valueOf(twoDForm.format(statFinal.physicalDamagePerSecondRaw + bonusPhysicalDPS + bonusMagicDPS))
				+ "\nAve Total Dmg/AA = " + Double.valueOf(twoDForm.format((statFinal.attackDamageFinal + statFinal.bonusPhysicalAttackDamageFinal + statFinal.bonusMagicAttackDamageFinal)))
				+ "\nAve Total DPS VS Turret = " + Double.valueOf(twoDForm.format(statFinal.totaldamagePerSecondVSTurrets + bonusPhysicalDPS + bonusMagicDPS))
				+ "\nAve Phys DPS = " + Double.valueOf(twoDForm.format(statFinal.physicalDamagePerSecondRaw + bonusPhysicalDPS))
				+ "\nAve Phys Dmg/AA = " + Double.valueOf(twoDForm.format(statFinal.attackDamageFinal + statFinal.bonusPhysicalAttackDamageFinal))
				+ "\nAve Phys DPS VS Turrets = " + Double.valueOf(twoDForm.format(statFinal.physicaldamagePerSecondVSTurrets + bonusPhysicalDPS))
				+ "\nBonus Phys Damage/AA = " + BotRK + Double.valueOf(twoDForm.format(statFinal.bonusPhysicalAttackDamageFinal))
				+ "\nBonus Magic Damage/AA = " + Double.valueOf(twoDForm.format(statFinal.bonusMagicAttackDamageFinal))
				+ "\nAve LS/s = " + Double.valueOf(twoDForm.format(statFinal.physicalDamagePerSecondRaw * statFinal.lifestealPercentFinal))
				+ "\nAve LS/AA = " + Double.valueOf(twoDForm.format(statFinal.attackDamageFinal * statFinal.lifestealPercentFinal))
				+ "\n%Phys Damage Taken = " + Double.valueOf(twoDForm.format(10000 / (100 + statFinal.armorFinal))) + "%"
				+ "\n%Magic Damage Taken = " + Double.valueOf(twoDForm.format(10000 / (100 + statFinal.magicResistFinal))) + "%"
				+ "\nEHP (Phys) = " + Double.valueOf(twoDForm.format((1 + statFinal.armorFinal/100) * statFinal.healthFinal))
				+ "\nEHP (Magic) = " + Double.valueOf(twoDForm.format((1 + statFinal.magicResistFinal/100) * statFinal.healthFinal))
				+ "\n\nBasic Stats:"
				+ "\nAD = " + Double.valueOf(twoDForm.format(statFinal.attackDamageNoCritical))
				+ "\nAS = " + Double.valueOf(twoDForm.format(statFinal.attackSpeedFinal)) + " | s/AA = " + Double.valueOf(twoDForm.format(1/statFinal.attackSpeedFinal))
				+ "\nRange = " + Double.valueOf(twoDForm.format(statFinal.rangeFinal))
				+ "\nHP = " + Double.valueOf(twoDForm.format(statFinal.healthFinal))
				+ "\nHP/5 = " + Double.valueOf(twoDForm.format(statFinal.healthRegenFinal))
				+ manaEquivalent
				+ "\nArmor = " + Double.valueOf(twoDForm.format(statFinal.armorFinal))
				+ "\nMR = " + Double.valueOf(twoDForm.format(statFinal.magicResistFinal))
				+ "\nAP = " + Double.valueOf(twoDForm.format(statFinal.abilityPowerFinal))
				+ "\nCDR = " + Double.valueOf(twoDForm.format(statFinal.coolDownReductionFinal * 100)) + "%"
				+ "\nCrit% = " + Double.valueOf(twoDForm.format(statFinal.criticalChanceFinal * 100)) + "%"
				+ "\nCritDmg = " + Double.valueOf(twoDForm.format(statFinal.criticalDamageFinal * 100)) + "%"
				+ "\nArRed% = " + blackCleaver
				+ "\nArPen% = " + Double.valueOf(twoDForm.format(statFinal.armorPenPercentFinal * 100)) + "%"
				+ "\nArPenFlat = " + Double.valueOf(twoDForm.format(statFinal.armorPenFlatFinal))
				+ "\nMagRedFlat = " + Double.valueOf(twoDForm.format(statFinal.magicRedFlatFinal))
				+ "\nMagPen% = " + Double.valueOf(twoDForm.format(statFinal.magicPenPercentFinal * 100)) + "%"
				+ "\nMagPenFlat = " + Double.valueOf(twoDForm.format(statFinal.magicPenFlatFinal))
				+ "\nLS% = " + Double.valueOf(twoDForm.format(statFinal.lifestealPercentFinal * 100)) + "%"
				+ "\nSV% = " + Double.valueOf(twoDForm.format(statFinal.spellVampFinal * 100)) + "%"
				+ "\nMS = " + Double.valueOf(twoDForm.format(statFinal.movementSpeedFinal));
				

		return allStats;
	}
		
	public void updateAP(ClassStatCalculations statFinal){
		statFinal.abilityPowerFinal = statFinal.abilityPowerExtra * (1 + statFinal.archmage) * statFinal.rabadonsDeathcapPassive * statFinal.woogletsWitchcapPassive;
	}
	
	public void updateHP(ClassStatCalculations statFinal){
		statFinal.healthExtra = (statFinal.healthPartialExtra * (1 + 0.25 * statFinal.spiritOfTheAncientGolemPercentHealth)) * (1 + statFinal.juggernaut + statFinal.HealthPercentRuneTotal) + statFinal.healthBase * (statFinal.juggernaut + statFinal.HealthPercentRuneTotal);
		statFinal.healthFinal = statFinal.healthBase + statFinal.healthExtra;
	}
	
	
	
	public void backToMainMenu(){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void help(){
		Toast.makeText(getApplicationContext(), "Dmg - damage" 
				+"\n/s - per second"
				+"\n/AA - per auto attack"
				+"\n/5 - per 5 seconds"
				+"\ns/AA = delay between AA in seconds"
				+"\nRed - reduction"
				+"\nPen - penetration"
				+"\nThe rest can be found at\nhttp://leagueoflegends.wikia.com/wiki/League_of_Legends_terminology",Toast.LENGTH_LONG).show();
	}

	
}

