package com.leagueoflegendscalculator;


import com.google.gson.Gson;
import com.leagueoflegendscalculator.myclasses.SavedElementsBuilds;
import com.leagueoflegendscalculator.myclasses.SavedElementsItems;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.preference.PreferenceManager;

public class DuelSimulatorItemStacksActivity extends ActionBarActivity {
		
	TextView build3Text;
	TextView build4Text;
	TextView build5Text;

	TextView feralFlare1Text;
	TextView manaCharge1Text;
	TextView mejaisSoulstealer1Text;
	TextView rodOfAges1Text;
	TextView seekersArmguard1Text;
	TextView spiritOfTheSpectralWraith1Text;
	TextView swordOfTheOccult1Text;
	TextView feralFlare2Text;
	TextView manaCharge2Text;
	TextView mejaisSoulstealer2Text;
	TextView rodOfAges2Text;
	TextView seekersArmguard2Text;
	TextView spiritOfTheSpectralWraith2Text;
	TextView swordOfTheOccult2Text;
	TextView feralFlare3Text;
	TextView manaCharge3Text;
	TextView mejaisSoulstealer3Text;
	TextView rodOfAges3Text;
	TextView seekersArmguard3Text;
	TextView spiritOfTheSpectralWraith3Text;
	TextView swordOfTheOccult3Text;
	TextView feralFlare4Text;
	TextView manaCharge4Text;
	TextView mejaisSoulstealer4Text;
	TextView rodOfAges4Text;
	TextView seekersArmguard4Text;
	TextView spiritOfTheSpectralWraith4Text;
	TextView swordOfTheOccult4Text;
	TextView feralFlare5Text;
	TextView manaCharge5Text;
	TextView mejaisSoulstealer5Text;
	TextView rodOfAges5Text;
	TextView seekersArmguard5Text;
	TextView spiritOfTheSpectralWraith5Text;
	TextView swordOfTheOccult5Text;
	
	ImageView feralFlare1Image;
	ImageView manaCharge1Image;
	ImageView mejaisSoulstealer1Image;
	ImageView rodOfAges1Image;
	ImageView seekersArmguard1Image;
	ImageView spiritOfTheSpectralWraith1Image;
	ImageView swordOfTheOccult1Image;
	ImageView feralFlare2Image;
	ImageView manaCharge2Image;
	ImageView mejaisSoulstealer2Image;
	ImageView rodOfAges2Image;
	ImageView seekersArmguard2Image;
	ImageView spiritOfTheSpectralWraith2Image;
	ImageView swordOfTheOccult2Image;
	ImageView feralFlare3Image;
	ImageView manaCharge3Image;
	ImageView mejaisSoulstealer3Image;
	ImageView rodOfAges3Image;
	ImageView seekersArmguard3Image;
	ImageView spiritOfTheSpectralWraith3Image;
	ImageView swordOfTheOccult3Image;
	ImageView feralFlare4Image;
	ImageView manaCharge4Image;
	ImageView mejaisSoulstealer4Image;
	ImageView rodOfAges4Image;
	ImageView seekersArmguard4Image;
	ImageView spiritOfTheSpectralWraith4Image;
	ImageView swordOfTheOccult4Image;
	ImageView feralFlare5Image;
	ImageView manaCharge5Image;
	ImageView mejaisSoulstealer5Image;
	ImageView rodOfAges5Image;
	ImageView seekersArmguard5Image;
	ImageView spiritOfTheSpectralWraith5Image;
	ImageView swordOfTheOccult5Image;
	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_duel_simulator_item_stacks);

		setViews();
		
		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
		int numberOfBuilds = appSharedPrefs.getInt("Number of Builds", 0);
		
		//each object in DuelResultsActivity need to get the correct stacks
		//a list of items and EditText will come up for each build, with unnecessary items omitted and with accurate hints for the limits, and conditions to prevent unacceptable values.
		//add limitations for stacks
		//delete all the views for builds 3,4, and 5

		if (numberOfBuilds == 2){
			build3Text.setVisibility(View.GONE);
			build4Text.setVisibility(View.GONE);
			build5Text.setVisibility(View.GONE);
			deleteViews ("Build 1");
			deleteViews ("Build 2");
			deleteViews ("Build 3");
			deleteViews ("Build 4");
			deleteViews ("Build 5");
			
		}

		else if (numberOfBuilds == 3){
			build4Text.setVisibility(View.GONE);
			build5Text.setVisibility(View.GONE);
			deleteViews ("Build 1");
			deleteViews ("Build 2");
			deleteViews ("Build 3");
			deleteViews ("Build 4");
			deleteViews ("Build 5");
		}
		
		else if (numberOfBuilds == 4){
			build5Text.setVisibility(View.GONE);
			deleteViews ("Build 1");
			deleteViews ("Build 2");
			deleteViews ("Build 3");
			deleteViews ("Build 4");
			deleteViews ("Build 5");
		}
		
		else if (numberOfBuilds == 5){
			deleteViews ("Build 1");
			deleteViews ("Build 2");
			deleteViews ("Build 3");
			deleteViews ("Build 4");
			deleteViews ("Build 5");
		}
	}
		

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_duel_simulator_item_stacks, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_start) {
			start();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	public void setViews(){

		build3Text = (TextView)findViewById(R.id.build3);
		build4Text = (TextView)findViewById(R.id.build4);
		build5Text = (TextView)findViewById(R.id.build5);
		
		feralFlare1Text = (TextView)findViewById(R.id.feral_flare1_text);
		manaCharge1Text = (TextView)findViewById(R.id.mana_charge1_text);
		mejaisSoulstealer1Text = (TextView)findViewById(R.id.mejais_soulstealer1_text);
		rodOfAges1Text = (TextView)findViewById(R.id.rod_of_ages1_text);
		seekersArmguard1Text = (TextView)findViewById(R.id.seekers_armguard1_text);
		spiritOfTheSpectralWraith1Text = (TextView)findViewById(R.id.spirit_of_the_spectral_wraith1_text);
		swordOfTheOccult1Text = (TextView)findViewById(R.id.sword_of_the_occult1_text);
		feralFlare2Text = (TextView)findViewById(R.id.feral_flare2_text);
		manaCharge2Text = (TextView)findViewById(R.id.mana_charge2_text);
		mejaisSoulstealer2Text = (TextView)findViewById(R.id.mejais_soulstealer2_text);
		rodOfAges2Text = (TextView)findViewById(R.id.rod_of_ages2_text);
		seekersArmguard2Text = (TextView)findViewById(R.id.seekers_armguard2_text);
		spiritOfTheSpectralWraith2Text = (TextView)findViewById(R.id.spirit_of_the_spectral_wraith2_text);
		swordOfTheOccult2Text = (TextView)findViewById(R.id.sword_of_the_occult2_text);
		feralFlare3Text = (TextView)findViewById(R.id.feral_flare3_text);
		manaCharge3Text = (TextView)findViewById(R.id.mana_charge3_text);
		mejaisSoulstealer3Text = (TextView)findViewById(R.id.mejais_soulstealer3_text);
		rodOfAges3Text = (TextView)findViewById(R.id.rod_of_ages3_text);
		seekersArmguard3Text = (TextView)findViewById(R.id.seekers_armguard3_text);
		spiritOfTheSpectralWraith3Text = (TextView)findViewById(R.id.spirit_of_the_spectral_wraith3_text);
		swordOfTheOccult3Text = (TextView)findViewById(R.id.sword_of_the_occult3_text);
		feralFlare4Text = (TextView)findViewById(R.id.feral_flare4_text);
		manaCharge4Text = (TextView)findViewById(R.id.mana_charge4_text);
		mejaisSoulstealer4Text = (TextView)findViewById(R.id.mejais_soulstealer4_text);
		rodOfAges4Text = (TextView)findViewById(R.id.rod_of_ages4_text);
		seekersArmguard4Text = (TextView)findViewById(R.id.seekers_armguard4_text);
		spiritOfTheSpectralWraith4Text = (TextView)findViewById(R.id.spirit_of_the_spectral_wraith4_text);
		swordOfTheOccult4Text = (TextView)findViewById(R.id.sword_of_the_occult4_text);
		feralFlare5Text = (TextView)findViewById(R.id.feral_flare5_text);
		manaCharge5Text = (TextView)findViewById(R.id.mana_charge5_text);
		mejaisSoulstealer5Text = (TextView)findViewById(R.id.mejais_soulstealer5_text);
		rodOfAges5Text = (TextView)findViewById(R.id.rod_of_ages5_text);
		seekersArmguard5Text = (TextView)findViewById(R.id.seekers_armguard5_text);
		spiritOfTheSpectralWraith5Text = (TextView)findViewById(R.id.spirit_of_the_spectral_wraith5_text);
		swordOfTheOccult5Text = (TextView)findViewById(R.id.sword_of_the_occult5_text);
		
		feralFlare1Image = (ImageView)findViewById(R.id.feral_flare1_image);
		manaCharge1Image = (ImageView)findViewById(R.id.mana_charge1_image);
		mejaisSoulstealer1Image = (ImageView)findViewById(R.id.mejais_soulstealer1_image);
		rodOfAges1Image = (ImageView)findViewById(R.id.rod_of_ages1_image);
		seekersArmguard1Image = (ImageView)findViewById(R.id.seekers_armguard1_image);
		spiritOfTheSpectralWraith1Image = (ImageView)findViewById(R.id.spirit_of_the_spectral_wraith1_image);
		swordOfTheOccult1Image = (ImageView)findViewById(R.id.sword_of_the_occult1_image);
		feralFlare2Image = (ImageView)findViewById(R.id.feral_flare2_image);
		manaCharge2Image = (ImageView)findViewById(R.id.mana_charge2_image);
		mejaisSoulstealer2Image = (ImageView)findViewById(R.id.mejais_soulstealer2_image);
		rodOfAges2Image = (ImageView)findViewById(R.id.rod_of_ages2_image);
		seekersArmguard2Image = (ImageView)findViewById(R.id.seekers_armguard2_image);
		spiritOfTheSpectralWraith2Image = (ImageView)findViewById(R.id.spirit_of_the_spectral_wraith2_image);
		swordOfTheOccult2Image = (ImageView)findViewById(R.id.sword_of_the_occult2_image);
		feralFlare3Image = (ImageView)findViewById(R.id.feral_flare3_image);
		manaCharge3Image = (ImageView)findViewById(R.id.mana_charge3_image);
		mejaisSoulstealer3Image = (ImageView)findViewById(R.id.mejais_soulstealer3_image);
		rodOfAges3Image = (ImageView)findViewById(R.id.rod_of_ages3_image);
		seekersArmguard3Image = (ImageView)findViewById(R.id.seekers_armguard3_image);
		spiritOfTheSpectralWraith3Image = (ImageView)findViewById(R.id.spirit_of_the_spectral_wraith3_image);
		swordOfTheOccult3Image = (ImageView)findViewById(R.id.sword_of_the_occult3_image);
		feralFlare4Image = (ImageView)findViewById(R.id.feral_flare4_image);
		manaCharge4Image = (ImageView)findViewById(R.id.mana_charge4_image);
		mejaisSoulstealer4Image = (ImageView)findViewById(R.id.mejais_soulstealer4_image);
		rodOfAges4Image = (ImageView)findViewById(R.id.rod_of_ages4_image);
		seekersArmguard4Image = (ImageView)findViewById(R.id.seekers_armguard4_image);
		spiritOfTheSpectralWraith4Image = (ImageView)findViewById(R.id.spirit_of_the_spectral_wraith4_image);
		swordOfTheOccult4Image = (ImageView)findViewById(R.id.sword_of_the_occult4_image);
		feralFlare5Image = (ImageView)findViewById(R.id.feral_flare5_image);
		manaCharge5Image = (ImageView)findViewById(R.id.mana_charge5_image);
		mejaisSoulstealer5Image = (ImageView)findViewById(R.id.mejais_soulstealer5_image);
		rodOfAges5Image = (ImageView)findViewById(R.id.rod_of_ages5_image);
		seekersArmguard5Image = (ImageView)findViewById(R.id.seekers_armguard5_image);
		spiritOfTheSpectralWraith5Image = (ImageView)findViewById(R.id.spirit_of_the_spectral_wraith5_image);
		swordOfTheOccult5Image = (ImageView)findViewById(R.id.sword_of_the_occult5_image);
	}
	
	

	public void deleteViews (String build){
		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
		Gson gson = new Gson();

		//extract the saved builds and their items
		String json = appSharedPrefs.getString(build, "");
		SavedElementsBuilds obj = gson.fromJson(json, SavedElementsBuilds.class);
		SavedElementsItems itemInput = gson.fromJson(obj.getItemInputString(), SavedElementsItems.class);
		
		String Item1 = itemInput._item1;
		String Item2 = itemInput._item2;
		String Item3 = itemInput._item3;
		String Item4 = itemInput._item4;
		String Item5 = itemInput._item5;
		String Item6 = itemInput._item6;
		Toast.makeText(getApplicationContext(), Item1 + Item2 + Item3 + Item4 + Item5 + Item6 , Toast.LENGTH_SHORT).show();
		//check to see if stacked items are inside the builds and delete the images and text fields for the ones that are absent
		if (Item1 != "Feral Flare" && Item2 != "Feral Flare" && Item3 != "Feral Flare" && Item4 != "Feral Flare" && Item5 != "Feral Flare" && Item6 != "Feral Flare"){
			if (build == "Build 1"){
				//delete the corresponding image and text field
				feralFlare1Text.setVisibility(View.GONE);
				feralFlare1Image.setVisibility(View.GONE);
			}
			if (build == "Build 2"){
				feralFlare2Text.setVisibility(View.GONE);
				feralFlare2Image.setVisibility(View.GONE);
			}
			if (build == "Build 3"){
				feralFlare3Text.setVisibility(View.GONE);
				feralFlare3Image.setVisibility(View.GONE);
			}
			if (build == "Build 4"){
				feralFlare4Text.setVisibility(View.GONE);
				feralFlare4Image.setVisibility(View.GONE);
			}
			if (build == "Build 5"){
				feralFlare5Text.setVisibility(View.GONE);
				feralFlare5Image.setVisibility(View.GONE);
			}
		}
		if (Item1 != "Mana Charge" && Item2 != "Mana Charge" && Item3 != "Mana Charge" && Item4 != "Mana Charge" && Item5 != "Mana Charge" && Item6 != "Mana Charge"){
			if (build == "Build 1"){
				//delete the corresponding image and text field
				manaCharge1Text.setVisibility(View.GONE);
				manaCharge1Image.setVisibility(View.GONE);
			}
			if (build == "Build 2"){
				manaCharge2Text.setVisibility(View.GONE);
				manaCharge2Image.setVisibility(View.GONE);
			}
			if (build == "Build 3"){
				manaCharge3Text.setVisibility(View.GONE);
				manaCharge3Image.setVisibility(View.GONE);
			}
			if (build == "Build 4"){
				manaCharge4Text.setVisibility(View.GONE);
				manaCharge4Image.setVisibility(View.GONE);
			}
			if (build == "Build 5"){
				manaCharge5Text.setVisibility(View.GONE);
				manaCharge5Image.setVisibility(View.GONE);
			}
		}
		if (Item1 != "Mejai's Soulstealer" && Item2 != "Mejai's Soulstealer" && Item3 != "Mejai's Soulstealer" && Item4 != "Mejai's Soulstealer" && Item5 != "Mejai's Soulstealer" && Item6 != "Mejai's Soulstealer"){
			if (build == "Build 1"){
				//delete the corresponding image and text field
				mejaisSoulstealer1Text.setVisibility(View.GONE);
				mejaisSoulstealer1Image.setVisibility(View.GONE);
			}
			if (build == "Build 2"){
				mejaisSoulstealer2Text.setVisibility(View.GONE);
				mejaisSoulstealer2Image.setVisibility(View.GONE);
			}
			if (build == "Build 3"){
				mejaisSoulstealer3Text.setVisibility(View.GONE);
				mejaisSoulstealer3Image.setVisibility(View.GONE);
			}
			if (build == "Build 4"){
				mejaisSoulstealer4Text.setVisibility(View.GONE);
				mejaisSoulstealer4Image.setVisibility(View.GONE);
			}
			if (build == "Build 5"){
				mejaisSoulstealer5Text.setVisibility(View.GONE);
				mejaisSoulstealer5Image.setVisibility(View.GONE);
			}
		}
		if (Item1 != "Rod of Ages" && Item2 != "Rod of Ages" && Item3 != "Rod of Ages" && Item4 != "Rod of Ages" && Item5 != "Rod of Ages" && Item6 != "Rod of Ages"){
			if (build == "Build 1"){
				//delete the corresponding image and text field
				rodOfAges1Text.setVisibility(View.GONE);
				rodOfAges1Image.setVisibility(View.GONE);
			}
			if (build == "Build 2"){
				rodOfAges2Text.setVisibility(View.GONE);
				rodOfAges2Image.setVisibility(View.GONE);
			}
			if (build == "Build 3"){
				rodOfAges3Text.setVisibility(View.GONE);
				rodOfAges3Image.setVisibility(View.GONE);
			}
			if (build == "Build 4"){
				rodOfAges4Text.setVisibility(View.GONE);
				rodOfAges4Image.setVisibility(View.GONE);
			}
			if (build == "Build 5"){
				rodOfAges5Text.setVisibility(View.GONE);
				rodOfAges5Image.setVisibility(View.GONE);
			}
		}
		if (Item1 != "Seeker's Armguard" && Item2 != "Seeker's Armguard" && Item3 != "Seeker's Armguard" && Item4 != "Seeker's Armguard" && Item5 != "Seeker's Armguard" && Item6 != "Seeker's Armguard"){
			if (build == "Build 1"){
				//delete the corresponding image and text field
				seekersArmguard1Text.setVisibility(View.GONE);
				seekersArmguard1Image.setVisibility(View.GONE);
			}
			if (build == "Build 2"){
				seekersArmguard2Text.setVisibility(View.GONE);
				seekersArmguard2Image.setVisibility(View.GONE);
			}
			if (build == "Build 3"){
				seekersArmguard3Text.setVisibility(View.GONE);
				seekersArmguard3Image.setVisibility(View.GONE);
			}
			if (build == "Build 4"){
				seekersArmguard4Text.setVisibility(View.GONE);
				seekersArmguard4Image.setVisibility(View.GONE);
			}
			if (build == "Build 5"){
				seekersArmguard5Text.setVisibility(View.GONE);
				seekersArmguard5Image.setVisibility(View.GONE);
			}
		}
		if (Item1 != "Spirit of the Spectral Wraith" && Item2 != "Spirit of the Spectral Wraith" && Item3 != "Spirit of the Spectral Wraith" && Item4 != "Spirit of the Spectral Wraith" && Item5 != "Spirit of the Spectral Wraith" && Item6 != "Spirit of the Spectral Wraith"){
			if (build == "Build 1"){
				//delete the corresponding image and text field
				spiritOfTheSpectralWraith1Text.setVisibility(View.GONE);
				spiritOfTheSpectralWraith1Image.setVisibility(View.GONE);
			}
			if (build == "Build 2"){
				spiritOfTheSpectralWraith2Text.setVisibility(View.GONE);
				spiritOfTheSpectralWraith2Image.setVisibility(View.GONE);
			}
			if (build == "Build 3"){
				spiritOfTheSpectralWraith3Text.setVisibility(View.GONE);
				spiritOfTheSpectralWraith3Image.setVisibility(View.GONE);
			}
			if (build == "Build 4"){
				spiritOfTheSpectralWraith4Text.setVisibility(View.GONE);
				spiritOfTheSpectralWraith4Image.setVisibility(View.GONE);
			}
			if (build == "Build 5"){
				spiritOfTheSpectralWraith5Text.setVisibility(View.GONE);
				spiritOfTheSpectralWraith5Image.setVisibility(View.GONE);
			}
		}
		if (Item1 != "Sword of the Occult" && Item2 != "Sword of the Occult" && Item3 != "Sword of the Occult" && Item4 != "Sword of the Occult" && Item5 != "Sword of the Occult" && Item6 != "Sword of the Occult"){
			if (build == "Build 1"){
				//delete the corresponding image and text field
				swordOfTheOccult1Text.setVisibility(View.GONE);
				swordOfTheOccult1Image.setVisibility(View.GONE);
			}
			if (build == "Build 2"){
				swordOfTheOccult2Text.setVisibility(View.GONE);
				swordOfTheOccult2Image.setVisibility(View.GONE);
			}
			if (build == "Build 3"){
				swordOfTheOccult3Text.setVisibility(View.GONE);
				swordOfTheOccult3Image.setVisibility(View.GONE);
			}
			if (build == "Build 4"){
				swordOfTheOccult4Text.setVisibility(View.GONE);
				swordOfTheOccult4Image.setVisibility(View.GONE);
			}
			if (build == "Build 5"){
				swordOfTheOccult5Text.setVisibility(View.GONE);
				swordOfTheOccult5Image.setVisibility(View.GONE);
			}
		}
	}
		
		
		
	//saves the info in the text fields and sets the empty ones to 0.
	public void setValues(){
		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
		Editor prefsEditor = appSharedPrefs.edit();
		
		//stacks must be 0 by default if the textfield is empty/null whether or not it is necessary
		if (feralFlare1Text.getText().toString().matches("")){
			prefsEditor.putInt("feralFlareStacks1", 0);
		}
		else{
			prefsEditor.putInt("feralFlareStacks1", Integer.parseInt(feralFlare1Text.getText().toString()));
		}
		if (feralFlare2Text.getText().toString().matches("")){
			prefsEditor.putInt("feralFlareStacks2", 0);
		}
		else{
			prefsEditor.putInt("feralFlareStacks2", Integer.parseInt(feralFlare2Text.getText().toString()));
		}
		if (feralFlare3Text.getText().toString().matches("")){
			prefsEditor.putInt("feralFlareStacks3", 0);
		}
		else{
			prefsEditor.putInt("feralFlareStacks3", Integer.parseInt(feralFlare3Text.getText().toString()));
		}
		if (feralFlare4Text.getText().toString().matches("")){
			prefsEditor.putInt("feralFlareStacks4", 0);
		}
		else{
			prefsEditor.putInt("feralFlareStacks4", Integer.parseInt(feralFlare4Text.getText().toString()));
		}
		if (feralFlare5Text.getText().toString().matches("")){
			prefsEditor.putInt("feralFlareStacks5", 0);
		}
		else{
			prefsEditor.putInt("feralFlareStacks5", Integer.parseInt(feralFlare5Text.getText().toString()));
		}
		
		
		if (manaCharge1Text.getText().toString().matches("")){
			prefsEditor.putInt("manaChargeStacks1", 0);
		}
		else{
			prefsEditor.putInt("manaChargeStacks1", Integer.parseInt(manaCharge1Text.getText().toString()));
		}
		if (manaCharge2Text.getText().toString().matches("")){
			prefsEditor.putInt("manaChargeStacks2", 0);
		}
		else{
			prefsEditor.putInt("manaChargeStacks2", Integer.parseInt(manaCharge2Text.getText().toString()));
		}
		if (manaCharge3Text.getText().toString().matches("")){
			prefsEditor.putInt("manaChargeStacks3", 0);
		}
		else{
			prefsEditor.putInt("manaChargeStacks3", Integer.parseInt(manaCharge3Text.getText().toString()));
		}
		if (manaCharge4Text.getText().toString().matches("")){
			prefsEditor.putInt("manaChargeStacks4", 0);
		}
		else{
			prefsEditor.putInt("manaChargeStacks4", Integer.parseInt(manaCharge4Text.getText().toString()));
		}
		if (manaCharge5Text.getText().toString().matches("")){
			prefsEditor.putInt("manaChargeStacks5", 0);
		}
		else{
			prefsEditor.putInt("manaChargeStacks5", Integer.parseInt(manaCharge5Text.getText().toString()));
		}
		
		
		if (mejaisSoulstealer1Text.getText().toString().matches("")){
			prefsEditor.putInt("mejaisSoulstealerStacks1", 0);
		}
		else{
			prefsEditor.putInt("mejaisSoulstealerStacks1", Integer.parseInt(mejaisSoulstealer1Text.getText().toString()));
		}
		if (mejaisSoulstealer2Text.getText().toString().matches("")){
			prefsEditor.putInt("mejaisSoulstealerStacks2", 0);
		}
		else{
			prefsEditor.putInt("mejaisSoulstealerStacks2", Integer.parseInt(mejaisSoulstealer2Text.getText().toString()));
		}
		if (mejaisSoulstealer3Text.getText().toString().matches("")){
			prefsEditor.putInt("mejaisSoulstealerStacks3", 0);
		}
		else{
			prefsEditor.putInt("mejaisSoulstealerStacks3", Integer.parseInt(mejaisSoulstealer3Text.getText().toString()));
		}
		if (mejaisSoulstealer4Text.getText().toString().matches("")){
			prefsEditor.putInt("mejaisSoulstealerStacks4", 0);
		}
		else{
			prefsEditor.putInt("mejaisSoulstealerStacks4", Integer.parseInt(mejaisSoulstealer4Text.getText().toString()));
		}
		if (mejaisSoulstealer5Text.getText().toString().matches("")){
			prefsEditor.putInt("mejaisSoulstealerStacks5", 0);
		}
		else{
			prefsEditor.putInt("mejaisSoulstealerStacks5", Integer.parseInt(mejaisSoulstealer5Text.getText().toString()));
		}
		
		
		if (rodOfAges1Text.getText().toString().matches("")){
			prefsEditor.putInt("rodOfAgesStacks1", 0);
		}
		else{
			prefsEditor.putInt("rodOfAgesStacks1", Integer.parseInt(rodOfAges1Text.getText().toString()));
		}
		if (rodOfAges2Text.getText().toString().matches("")){
			prefsEditor.putInt("rodOfAgesStacks2", 0);
		}
		else{
			prefsEditor.putInt("rodOfAgesStacks2", Integer.parseInt(rodOfAges2Text.getText().toString()));
		}
		if (rodOfAges3Text.getText().toString().matches("")){
			prefsEditor.putInt("rodOfAgesStacks3", 0);
		}
		else{
			prefsEditor.putInt("rodOfAgesStacks3", Integer.parseInt(rodOfAges3Text.getText().toString()));
		}
		if (rodOfAges4Text.getText().toString().matches("")){
			prefsEditor.putInt("rodOfAgesStacks4", 0);
		}
		else{
			prefsEditor.putInt("rodOfAgesStacks4", Integer.parseInt(rodOfAges4Text.getText().toString()));
		}
		if (rodOfAges5Text.getText().toString().matches("")){
			prefsEditor.putInt("rodOfAgesStacks5", 0);
		}
		else{
			prefsEditor.putInt("rodOfAgesStacks5", Integer.parseInt(rodOfAges5Text.getText().toString()));
		}
		
		
		if (seekersArmguard1Text.getText().toString().matches("")){
			prefsEditor.putInt("seekersArmguardStacks1", 0);
		}
		else{
			prefsEditor.putInt("seekersArmguardStacks1", Integer.parseInt(seekersArmguard1Text.getText().toString()));
		}
		if (seekersArmguard2Text.getText().toString().matches("")){
			prefsEditor.putInt("seekersArmguardStacks2", 0);
		}
		else{
			prefsEditor.putInt("seekersArmguardStacks2", Integer.parseInt(seekersArmguard2Text.getText().toString()));
		}
		if (seekersArmguard3Text.getText().toString().matches("")){
			prefsEditor.putInt("seekersArmguardStacks3", 0);
		}
		else{
			prefsEditor.putInt("seekersArmguardStacks3", Integer.parseInt(seekersArmguard3Text.getText().toString()));
		}
		if (seekersArmguard4Text.getText().toString().matches("")){
			prefsEditor.putInt("seekersArmguardStacks4", 0);
		}
		else{
			prefsEditor.putInt("seekersArmguardStacks4", Integer.parseInt(seekersArmguard4Text.getText().toString()));
		}
		if (seekersArmguard5Text.getText().toString().matches("")){
			prefsEditor.putInt("seekersArmguardStacks5", 0);
		}
		else{
			prefsEditor.putInt("seekersArmguardStacks5", Integer.parseInt(seekersArmguard5Text.getText().toString()));
		}
		
		
		if (spiritOfTheSpectralWraith1Text.getText().toString().matches("")){
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks1", 0);
		}
		else{
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks1", Integer.parseInt(spiritOfTheSpectralWraith1Text.getText().toString()));
		}
		if (spiritOfTheSpectralWraith2Text.getText().toString().matches("")){
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks2", 0);
		}
		else{
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks2", Integer.parseInt(spiritOfTheSpectralWraith2Text.getText().toString()));
		}
		if (spiritOfTheSpectralWraith3Text.getText().toString().matches("")){
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks3", 0);
		}
		else{
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks3", Integer.parseInt(spiritOfTheSpectralWraith3Text.getText().toString()));
		}
		if (spiritOfTheSpectralWraith4Text.getText().toString().matches("")){
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks4", 0);
		}
		else{
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks4", Integer.parseInt(spiritOfTheSpectralWraith4Text.getText().toString()));
		}
		if (spiritOfTheSpectralWraith5Text.getText().toString().matches("")){
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks5", 0);
		}
		else{
			prefsEditor.putInt("spiritOfTheSpectralWraithStacks5", Integer.parseInt(spiritOfTheSpectralWraith5Text.getText().toString()));
		}
		
		
		if (swordOfTheOccult1Text.getText().toString().matches("")){
			prefsEditor.putInt("swordOfTheOccultStacks1", 0);
		}
		else{
			prefsEditor.putInt("swordOfTheOccultStacks1", Integer.parseInt(swordOfTheOccult1Text.getText().toString()));
		}
		if (swordOfTheOccult2Text.getText().toString().matches("")){
			prefsEditor.putInt("swordOfTheOccultStacks2", 0);
		}
		else{
			prefsEditor.putInt("swordOfTheOccultStacks2", Integer.parseInt(swordOfTheOccult2Text.getText().toString()));
		}
		if (swordOfTheOccult3Text.getText().toString().matches("")){
			prefsEditor.putInt("swordOfTheOccultStacks3", 0);
		}
		else{
			prefsEditor.putInt("swordOfTheOccultStacks3", Integer.parseInt(swordOfTheOccult3Text.getText().toString()));
		}
		if (swordOfTheOccult4Text.getText().toString().matches("")){
			prefsEditor.putInt("swordOfTheOccultStacks4", 0);
		}
		else{
			prefsEditor.putInt("swordOfTheOccultStacks4", Integer.parseInt(swordOfTheOccult4Text.getText().toString()));
		}
		if (swordOfTheOccult5Text.getText().toString().matches("")){
			prefsEditor.putInt("swordOfTheOccultStacks5", 0);
		}
		else{
			prefsEditor.putInt("swordOfTheOccultStacks5", Integer.parseInt(swordOfTheOccult5Text.getText().toString()));
		}
		

		prefsEditor.commit();
	}
	
	
	
	
	public void start(){
		setValues();
		Intent intent = new Intent(this, DuelResultsActivity.class);
		startActivity(intent);
	}
	
	
	
}
