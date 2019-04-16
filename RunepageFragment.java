package com.leagueoflegendscalculator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.leagueoflegendscalculator.adapter.ClassCustomRuneSaved;
import com.leagueoflegendscalculator.myclasses.ClassRunes;
import com.leagueoflegendscalculator.myclasses.SavedElementsRunes;

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

public class RunepageFragment extends Fragment {
	 
	
    List<SavedElementsRunes> runes;   
    String[] runeID;
	String[] savedRuneSetName;
	String[] savedRuneSetDetails;
    ListView listViewRune;
    TextView textRune;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_runepage, container, false);
        
        
        listViewRune = (ListView) rootView.findViewById (R.id.listViewRune);
        textRune = (TextView) rootView.findViewById (R.id.RuneText);
        
        createRuneList();
        ClassCustomRuneSaved dataAdapter4 = new ClassCustomRuneSaved(getActivity(), runeID, savedRuneSetName, savedRuneSetDetails);
        listViewRune.setAdapter(dataAdapter4);
        

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        Editor prefsEditor = appSharedPrefs.edit();
        if (textRune.getText().toString().equals("Select a Rune Page")){
        	prefsEditor.putString("RuneState", textRune.getText().toString());//may have to put this into an if statement like if(textChampion.getText().equal("Select a champion")
        }
    	prefsEditor.commit();

    	
        listViewRune.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	DatabaseHelper dbRune = new DatabaseHelper(getActivity());

		    	int idOfSelection = Integer.parseInt(listViewRune.getItemAtPosition(position).toString());
		    	String runeSelection = dbRune.getRune(idOfSelection).getName() ;
		    	
		    	SavedElementsRunes obj = new SavedElementsRunes(dbRune.getRune(idOfSelection).getName() 
		    			, dbRune.getRune(idOfSelection).getAbilityPowerRuneMCount()
		    			, dbRune.getRune(idOfSelection).getAbilityPowerRuneSCount()
		    			, dbRune.getRune(idOfSelection).getAbilityPowerRuneGCount()
		    			, dbRune.getRune(idOfSelection).getAbilityPowerRuneQCount()
		    			, dbRune.getRune(idOfSelection).getAbilityPowerScalingRuneMCount()
		    			, dbRune.getRune(idOfSelection).getAbilityPowerScalingRuneSCount()
		    			, dbRune.getRune(idOfSelection).getAbilityPowerScalingRuneGCount()
		    			, dbRune.getRune(idOfSelection).getAbilityPowerScalingRuneQCount()
		    			, dbRune.getRune(idOfSelection).getArmorRuneMCount()
		    			, dbRune.getRune(idOfSelection).getArmorRuneSCount()
		    			, dbRune.getRune(idOfSelection).getArmorRuneGCount()
		    			, dbRune.getRune(idOfSelection).getArmorRuneQCount()
		    			, dbRune.getRune(idOfSelection).getArmorScalingRuneSCount()
		    			, dbRune.getRune(idOfSelection).getArmorScalingRuneQCount()
		    			, dbRune.getRune(idOfSelection).getArmorPenetrationRuneMCount()
		    			, dbRune.getRune(idOfSelection).getArmorPenetrationRuneQCount()
		    			, dbRune.getRune(idOfSelection).getAttackDamageRuneMCount()
		    			, dbRune.getRune(idOfSelection).getAttackDamageRuneSCount()
		    			, dbRune.getRune(idOfSelection).getAttackDamageRuneGCount()
		    			, dbRune.getRune(idOfSelection).getAttackDamageRuneQCount()
		    			, dbRune.getRune(idOfSelection).getAttackDamageScalingRuneMCount()
		    			, dbRune.getRune(idOfSelection).getAttackDamageScalingRuneSCount()
		    			, dbRune.getRune(idOfSelection).getAttackDamageScalingRuneGCount()
		    			, dbRune.getRune(idOfSelection).getAttackDamageScalingRuneQCount()
		    			, dbRune.getRune(idOfSelection).getAttackSpeedRuneMCount()
		    			, dbRune.getRune(idOfSelection).getAttackSpeedRuneSCount()
		    			, dbRune.getRune(idOfSelection).getAttackSpeedRuneGCount()
		    			, dbRune.getRune(idOfSelection).getAttackSpeedRuneQCount()
		    			, dbRune.getRune(idOfSelection).getCooldownReductionRuneMCount()
		    			, dbRune.getRune(idOfSelection).getCooldownReductionRuneSCount()
		    			, dbRune.getRune(idOfSelection).getCooldownReductionRuneGCount()
		    			, dbRune.getRune(idOfSelection).getCooldownReductionRuneQCount()
		    			, dbRune.getRune(idOfSelection).getCooldownReductionScalingRuneGCount()
		    			, dbRune.getRune(idOfSelection).getCooldownReductionScalingRuneQCount()
		    			, dbRune.getRune(idOfSelection).getCriticalChanceRuneMCount()
		    			, dbRune.getRune(idOfSelection).getCriticalChanceRuneSCount()
		    			, dbRune.getRune(idOfSelection).getCriticalChanceRuneGCount()
		    			, dbRune.getRune(idOfSelection).getCriticalChanceRuneQCount()
		    			, dbRune.getRune(idOfSelection).getCriticalDamageRuneMCount()
		    			, dbRune.getRune(idOfSelection).getCriticalDamageRuneSCount()
		    			, dbRune.getRune(idOfSelection).getCriticalDamageRuneGCount()
		    			, dbRune.getRune(idOfSelection).getCriticalDamageRuneQCount()
		    			, dbRune.getRune(idOfSelection).getEnergyRuneGCount()
		    			, dbRune.getRune(idOfSelection).getEnergyRuneQCount()
		    			, dbRune.getRune(idOfSelection).getEnergyScalingRuneGCount()
		    			, dbRune.getRune(idOfSelection).getEnergyRegenRuneSCount()
		    			, dbRune.getRune(idOfSelection).getEnergyRegenRuneQCount()
		    			, dbRune.getRune(idOfSelection).getEnergyRegenScalingRuneSCount()
		    			, dbRune.getRune(idOfSelection).getHealthRuneMCount()
		    			, dbRune.getRune(idOfSelection).getHealthRuneSCount()
		    			, dbRune.getRune(idOfSelection).getHealthRuneGCount()
		    			, dbRune.getRune(idOfSelection).getHealthRuneQCount()
		    			, dbRune.getRune(idOfSelection).getHealthScalingRuneMCount()
		    			, dbRune.getRune(idOfSelection).getHealthScalingRuneSCount()
		    			, dbRune.getRune(idOfSelection).getHealthScalingRuneGCount()
		    			, dbRune.getRune(idOfSelection).getHealthScalingRuneQCount()
		    			, dbRune.getRune(idOfSelection).getHealthPercentRuneSCount()
		    			, dbRune.getRune(idOfSelection).getHealthPercentRuneQCount()
		    			, dbRune.getRune(idOfSelection).getHealthRegenRuneSCount()
		    			, dbRune.getRune(idOfSelection).getHealthRegenRuneGCount()
		    			, dbRune.getRune(idOfSelection).getHealthRegenRuneQCount()
		    			, dbRune.getRune(idOfSelection).getHealthRegenScalingRuneSCount()
		    			, dbRune.getRune(idOfSelection).getHealthRegenScalingRuneQCount()
		    			, dbRune.getRune(idOfSelection).getHybridPenetrationRuneMCount()
		    			, dbRune.getRune(idOfSelection).getHybridPenetrationRuneQCount()
		    			, dbRune.getRune(idOfSelection).getLifeStealRuneQCount()
		    			, dbRune.getRune(idOfSelection).getMagicPenetrationRuneMCount()
		    			, dbRune.getRune(idOfSelection).getMagicPenetrationRuneGCount()
		    			, dbRune.getRune(idOfSelection).getMagicPenetrationRuneQCount()
		    			, dbRune.getRune(idOfSelection).getMagicResistRuneMCount()
		    			, dbRune.getRune(idOfSelection).getMagicResistRuneSCount()
		    			, dbRune.getRune(idOfSelection).getMagicResistRuneGCount()
		    			, dbRune.getRune(idOfSelection).getMagicResistRuneQCount()
		    			, dbRune.getRune(idOfSelection).getMagicResistScalingRuneMCount()
		    			, dbRune.getRune(idOfSelection).getMagicResistScalingRuneSCount()
		    			, dbRune.getRune(idOfSelection).getMagicResistScalingRuneGCount()
		    			, dbRune.getRune(idOfSelection).getMagicResistScalingRuneQCount()
		    			, dbRune.getRune(idOfSelection).getManaRuneMCount()
		    			, dbRune.getRune(idOfSelection).getManaRuneSCount()
		    			, dbRune.getRune(idOfSelection).getManaRuneGCount()
		    			, dbRune.getRune(idOfSelection).getManaRuneQCount()
		    			, dbRune.getRune(idOfSelection).getManaScalingRuneMCount()
		    			, dbRune.getRune(idOfSelection).getManaScalingRuneSCount()
		    			, dbRune.getRune(idOfSelection).getManaScalingRuneGCount()
		    			, dbRune.getRune(idOfSelection).getManaScalingRuneQCount()
		    			, dbRune.getRune(idOfSelection).getManaRegenRuneMCount()
		    			, dbRune.getRune(idOfSelection).getManaRegenRuneSCount()
		    			, dbRune.getRune(idOfSelection).getManaRegenRuneGCount()
		    			, dbRune.getRune(idOfSelection).getManaRegenRuneQCount()
		    			, dbRune.getRune(idOfSelection).getManaRegenScalingRuneSCount()
		    			, dbRune.getRune(idOfSelection).getManaRegenScalingRuneGCount()
		    			, dbRune.getRune(idOfSelection).getManaRegenScalingRuneQCount()
		    			, dbRune.getRune(idOfSelection).getMovementSpeedRuneQCount()
		    			, dbRune.getRune(idOfSelection).getSpellVampRuneQCount());
		        
		    	//dbRune.close();
		    	
		    	textRune.setText(runeSelection); 
		    	Toast.makeText(getActivity(), "You selected:\n" + runeSelection, Toast.LENGTH_SHORT).show();
		    	
		    	SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
		    	Editor prefsEditor = appSharedPrefs.edit();
		    	Gson gson = new Gson();
		    	String json = gson.toJson(obj);
		    	prefsEditor.putString("Rune Page", json);
		    	prefsEditor.putString("RuneState", textRune.getText().toString());
		    	prefsEditor.commit();
		    }
		});
        
        
        
        
        return rootView;
    }
    
    public void createRuneList(){
    	
    	DatabaseHelper dbRune = new DatabaseHelper(getActivity());
    	runes = dbRune.getAllRunes();   
        //dbRune.close();
    	
		   Collections.sort(runes, new Comparator<SavedElementsRunes>() {
		        @Override
		        public int compare(final SavedElementsRunes object1, final SavedElementsRunes object2) {
		            return object1.getName().compareTo(object2.getName());
		        }
		   });
    	
        int i = runes.size();

        runeID = new String[i];
		savedRuneSetName = new String[i];
		savedRuneSetDetails = new String[i];
        

        int j=0;
        for (SavedElementsRunes listRune : runes) {//runs a for loop for every member of the List called contacts
            
    		ClassRunes runePageInfo = new ClassRunes(
    				Byte.parseByte(listRune.getAbilityPowerRuneMCount()),
    				Byte.parseByte(listRune.getAbilityPowerRuneSCount()),
    				Byte.parseByte(listRune.getAbilityPowerRuneGCount()),
    				Byte.parseByte(listRune.getAbilityPowerRuneQCount()),
    				Byte.parseByte(listRune.getAbilityPowerScalingRuneMCount()),
    				Byte.parseByte(listRune.getAbilityPowerScalingRuneSCount()),
    				Byte.parseByte(listRune.getAbilityPowerScalingRuneGCount()),
    				Byte.parseByte(listRune.getAbilityPowerScalingRuneQCount()),
    				Byte.parseByte(listRune.getArmorRuneMCount()),
    				Byte.parseByte(listRune.getArmorRuneSCount()),
    				Byte.parseByte(listRune.getArmorRuneGCount()),
    				Byte.parseByte(listRune.getArmorRuneQCount()),
    				Byte.parseByte(listRune.getArmorScalingRuneSCount()),
    				Byte.parseByte(listRune.getArmorScalingRuneQCount()),
    				Byte.parseByte(listRune.getArmorPenetrationRuneMCount()),
    				Byte.parseByte(listRune.getArmorPenetrationRuneQCount()),
    				Byte.parseByte(listRune.getAttackDamageRuneMCount()),
    				Byte.parseByte(listRune.getAttackDamageRuneSCount()),
    				Byte.parseByte(listRune.getAttackDamageRuneGCount()),
    				Byte.parseByte(listRune.getAttackDamageRuneQCount()),
    				Byte.parseByte(listRune.getAttackDamageScalingRuneMCount()),
    				Byte.parseByte(listRune.getAttackDamageScalingRuneSCount()),
    				Byte.parseByte(listRune.getAttackDamageScalingRuneGCount()),
    				Byte.parseByte(listRune.getAttackDamageScalingRuneQCount()),
    				Byte.parseByte(listRune.getAttackSpeedRuneMCount()),
    				Byte.parseByte(listRune.getAttackSpeedRuneSCount()),
    				Byte.parseByte(listRune.getAttackSpeedRuneGCount()),
    				Byte.parseByte(listRune.getAttackSpeedRuneQCount()),
    				Byte.parseByte(listRune.getCooldownReductionRuneMCount()),
    				Byte.parseByte(listRune.getCooldownReductionRuneSCount()),
    				Byte.parseByte(listRune.getCooldownReductionRuneGCount()),
    				Byte.parseByte(listRune.getCooldownReductionRuneQCount()),
    				Byte.parseByte(listRune.getCooldownReductionScalingRuneGCount()),
    				Byte.parseByte(listRune.getCooldownReductionScalingRuneQCount()),
    				Byte.parseByte(listRune.getCriticalChanceRuneMCount()),
    				Byte.parseByte(listRune.getCriticalChanceRuneSCount()),
    				Byte.parseByte(listRune.getCriticalChanceRuneGCount()),
    				Byte.parseByte(listRune.getCriticalChanceRuneQCount()),
    				Byte.parseByte(listRune.getCriticalDamageRuneMCount()),
    				Byte.parseByte(listRune.getCriticalDamageRuneSCount()),
    				Byte.parseByte(listRune.getCriticalDamageRuneGCount()),
    				Byte.parseByte(listRune.getCriticalDamageRuneQCount()),
    				Byte.parseByte(listRune.getEnergyRuneGCount()),
    				Byte.parseByte(listRune.getEnergyRuneQCount()),
    				Byte.parseByte(listRune.getEnergyScalingRuneGCount()),
    				Byte.parseByte(listRune.getEnergyRegenRuneSCount()),
    				Byte.parseByte(listRune.getEnergyRegenRuneQCount()),
    				Byte.parseByte(listRune.getEnergyRegenScalingRuneSCount()),
    				Byte.parseByte(listRune.getHealthRuneMCount()),
    				Byte.parseByte(listRune.getHealthRuneSCount()),
    				Byte.parseByte(listRune.getHealthRuneGCount()),
    				Byte.parseByte(listRune.getHealthRuneQCount()),
    				Byte.parseByte(listRune.getHealthScalingRuneMCount()),
    				Byte.parseByte(listRune.getHealthScalingRuneSCount()),
    				Byte.parseByte(listRune.getHealthScalingRuneGCount()),
    				Byte.parseByte(listRune.getHealthScalingRuneQCount()),
    				Byte.parseByte(listRune.getHealthPercentRuneSCount()),
    				Byte.parseByte(listRune.getHealthPercentRuneQCount()),
    				Byte.parseByte(listRune.getHealthRegenRuneSCount()),
    				Byte.parseByte(listRune.getHealthRegenRuneGCount()),
    				Byte.parseByte(listRune.getHealthRegenRuneQCount()),
    				Byte.parseByte(listRune.getHealthRegenScalingRuneSCount()),
    				Byte.parseByte(listRune.getHealthRegenScalingRuneQCount()),
    				Byte.parseByte(listRune.getHybridPenetrationRuneMCount()),
    				Byte.parseByte(listRune.getHybridPenetrationRuneQCount()),
    				Byte.parseByte(listRune.getLifeStealRuneQCount()),
    				Byte.parseByte(listRune.getMagicPenetrationRuneMCount()),
    				Byte.parseByte(listRune.getMagicPenetrationRuneGCount()),
    				Byte.parseByte(listRune.getMagicPenetrationRuneQCount()),
    				Byte.parseByte(listRune.getMagicResistRuneMCount()),
    				Byte.parseByte(listRune.getMagicResistRuneSCount()),
    				Byte.parseByte(listRune.getMagicResistRuneGCount()),
    				Byte.parseByte(listRune.getMagicResistRuneQCount()),
    				Byte.parseByte(listRune.getMagicResistScalingRuneMCount()),
    				Byte.parseByte(listRune.getMagicResistScalingRuneSCount()),
    				Byte.parseByte(listRune.getMagicResistScalingRuneGCount()),
    				Byte.parseByte(listRune.getMagicResistScalingRuneQCount()),
    				Byte.parseByte(listRune.getManaRuneMCount()),
    				Byte.parseByte(listRune.getManaRuneSCount()),
    				Byte.parseByte(listRune.getManaRuneGCount()),
    				Byte.parseByte(listRune.getManaRuneQCount()),
    				Byte.parseByte(listRune.getManaScalingRuneMCount()),
    				Byte.parseByte(listRune.getManaScalingRuneSCount()),
    				Byte.parseByte(listRune.getManaScalingRuneGCount()),
    				Byte.parseByte(listRune.getManaScalingRuneQCount()),
    				Byte.parseByte(listRune.getManaRegenRuneMCount()),
    				Byte.parseByte(listRune.getManaRegenRuneSCount()),
    				Byte.parseByte(listRune.getManaRegenRuneGCount()),
    				Byte.parseByte(listRune.getManaRegenRuneQCount()),
    				Byte.parseByte(listRune.getManaRegenScalingRuneSCount()),
    				Byte.parseByte(listRune.getManaRegenScalingRuneGCount()),
    				Byte.parseByte(listRune.getManaRegenScalingRuneQCount()),
    				Byte.parseByte(listRune.getMovementSpeedRuneQCount()),
    				Byte.parseByte(listRune.getSpellVampRuneQCount())
    				);
            
            
    		float AbilityPowerRuneTotal = runePageInfo.AbilityPowerRuneTotal;
    		float AbilityPowerScalingRuneTotal = runePageInfo.AbilityPowerScalingRuneTotal;
    		float ArmorRuneTotal = runePageInfo.ArmorRuneTotal;
    		float ArmorScalingRuneTotal = runePageInfo.ArmorScalingRuneTotal;
    		float ArmorPenetrationRuneTotal = runePageInfo.ArmorPenetrationRuneTotal;
    		float AttackDamageRuneTotal = runePageInfo.AttackDamageRuneTotal;
    		float AttackDamageScalingRuneTotal = runePageInfo.AttackDamageScalingRuneTotal;
    		float AttackSpeedRuneTotal = runePageInfo.AttackSpeedRuneTotal;
    		float CooldownReductionRuneTotal = runePageInfo.CooldownReductionRuneTotal;
    		float CooldownReductionRuneScalingTotal = runePageInfo.CooldownReductionRuneScalingTotal;
    		float CriticalChanceRuneTotal = runePageInfo.CriticalChanceRuneTotal;
    		float CriticalDamageRuneTotal = runePageInfo.CriticalDamageRuneTotal;
    		float EnergyRuneTotal = runePageInfo.EnergyRuneTotal;
    		float EnergyScalingRuneTotal = runePageInfo.EnergyScalingRuneTotal;
    		float EnergyRegenRuneTotal = runePageInfo.EnergyRegenRuneTotal;
    		float EnergyRegenScalingRuneTotal = runePageInfo.EnergyRegenScalingRuneTotal;
    		float HealthRuneTotal = runePageInfo.HealthRuneTotal;
    		float HealthScalingRuneTotal = runePageInfo.HealthScalingRuneTotal;
    		float HealthPercentRuneTotal = runePageInfo.HealthPercentRuneTotal;
    		float HealthRegenRuneTotal = runePageInfo.HealthRegenRuneTotal;
    		float HealthRegenScalingRuneTotal = runePageInfo.HealthRegenScalingRuneTotal;
    		float LifeStealRuneTotal = runePageInfo.LifeStealRuneTotal;
    		float MagicPenetrationRuneTotal = runePageInfo.MagicPenetrationRuneTotal;
    		float MagicResistRunTotal = runePageInfo.MagicResistRunTotal;
    		float MagicResistScalingRuneTotal = runePageInfo.MagicResistScalingRuneTotal;
    		float ManaRuneTotal = runePageInfo.ManaRuneTotal;
    		float ManaScalingRuneTotal = runePageInfo.ManaScalingRuneTotal;
    		float ManaRegenRuneTotal = runePageInfo.ManaRegenRuneTotal;
    		float ManaRegenScalingRuneTotal = runePageInfo.ManaRegenScalingRuneTotal;
    		float MovementSpeedRuneTotal = runePageInfo.MovementSpeedRuneTotal;
    		float SpellVampRuneTotal = runePageInfo.SpellVampRuneTotal;
    		String AbilityPowerRuneTotalText;
    		String AbilityPowerScalingRuneTotalText;
    		String ArmorRuneTotalText;
    		String ArmorScalingRuneTotalText;
    		String ArmorPenetrationRuneTotalText;
    		String AttackDamageRuneTotalText;
    		String AttackDamageScalingRuneTotalText;
    		String AttackSpeedRuneTotalText;
    		String CooldownReductionRuneTotalText;
    		String CooldownReductionRuneScalingTotalText;
    		String CriticalChanceRuneTotalText;
    		String CriticalDamageRuneTotalText;
    		String EnergyRuneTotalText;
    		String EnergyScalingRuneTotalText;
    		String EnergyRegenRuneTotalText;
    		String EnergyRegenScalingRuneTotalText;
    		String HealthRuneTotalText;
    		String HealthScalingRuneTotalText;
    		String HealthPercentRuneTotalText;
    		String HealthRegenRuneTotalText;
    		String HealthRegenScalingRuneTotalText;
    		String LifeStealRuneTotalText;
    		String MagicPenetrationRuneTotalText;
    		String MagicResistRunTotalText;
    		String MagicResistScalingRuneTotalText;
    		String ManaRuneTotalText;
    		String ManaScalingRuneTotalText;
    		String ManaRegenRuneTotalText;
    		String ManaRegenScalingRuneTotalText;
    		String MovementSpeedRuneTotalText;
    		String SpellVampRuneTotalText;
    		

			if (AbilityPowerRuneTotal == 0){
			    AbilityPowerRuneTotalText = "";
			}
			else{
			    AbilityPowerRuneTotalText = "Ability Power = " + AbilityPowerRuneTotal + "\n";
			}
			if (AbilityPowerScalingRuneTotal == 0){
			    AbilityPowerScalingRuneTotalText = "";
			}
			else{
			    AbilityPowerScalingRuneTotalText = "Ability Power/Level = " + AbilityPowerScalingRuneTotal + "\n";
			}
			if (ArmorRuneTotal == 0){
			    ArmorRuneTotalText = "";
			}
			else{
			    ArmorRuneTotalText = "Armor = " + ArmorRuneTotal + "\n";
			}
			if (ArmorScalingRuneTotal == 0){
			    ArmorScalingRuneTotalText = "";
			}
			else{
			    ArmorScalingRuneTotalText = "Armor/Level = " + ArmorScalingRuneTotal + "\n";
			}
			if (ArmorPenetrationRuneTotal == 0){
			    ArmorPenetrationRuneTotalText = "";
			}
			else{
			    ArmorPenetrationRuneTotalText = "Armor Penetration = " + ArmorPenetrationRuneTotal + "\n";
			}
			if (AttackDamageRuneTotal == 0){
			    AttackDamageRuneTotalText = "";
			}
			else{
			    AttackDamageRuneTotalText = "Attack Damage = " + AttackDamageRuneTotal + "\n";
			}
			if (AttackDamageScalingRuneTotal == 0){
			    AttackDamageScalingRuneTotalText = "";
			}
			else{
			    AttackDamageScalingRuneTotalText = "Attack Damage/Level = " + AttackDamageScalingRuneTotal + "\n";
			}
			if (AttackSpeedRuneTotal == 0){
			    AttackSpeedRuneTotalText = "";
			}
			else{
			    AttackSpeedRuneTotalText = "Attack Speed = " + AttackSpeedRuneTotal + "\n";
			}
			if (CooldownReductionRuneTotal == 0){
			    CooldownReductionRuneTotalText = "";
			}
			else{
			    CooldownReductionRuneTotalText = "Cooldown Reduction = " + CooldownReductionRuneTotal + "\n";
			}
			if (CooldownReductionRuneScalingTotal == 0){
			    CooldownReductionRuneScalingTotalText = "";
			}
			else{
			    CooldownReductionRuneScalingTotalText = "Cooldown Reduction/Level = " + CooldownReductionRuneScalingTotal + "\n";
			}
			if (CriticalChanceRuneTotal == 0){
			    CriticalChanceRuneTotalText = "";
			}
			else{
			    CriticalChanceRuneTotalText = "Critical Chance = " + CriticalChanceRuneTotal + "\n";
			}
			if (CriticalDamageRuneTotal == 0){
			    CriticalDamageRuneTotalText = "";
			}
			else{
			    CriticalDamageRuneTotalText = "Critical Damage = " + CriticalDamageRuneTotal + "\n";
			}
			if (EnergyRuneTotal == 0){
			    EnergyRuneTotalText = "";
			}
			else{
			    EnergyRuneTotalText = "Energy = " + EnergyRuneTotal + "\n";
			}
			if (EnergyScalingRuneTotal == 0){
			    EnergyScalingRuneTotalText = "";
			}
			else{
			    EnergyScalingRuneTotalText = "Energy/Level = " + EnergyScalingRuneTotal + "\n";
			}
			if (EnergyRegenRuneTotal == 0){
			    EnergyRegenRuneTotalText = "";
			}
			else{
			    EnergyRegenRuneTotalText = "Energy Regeneration = " + EnergyRegenRuneTotal + "\n";
			}
			if (EnergyRegenScalingRuneTotal == 0){
			    EnergyRegenScalingRuneTotalText = "";
			}
			else{
			    EnergyRegenScalingRuneTotalText = "Energy Regeneration/Level = " + EnergyRegenScalingRuneTotal + "\n";
			}
			if (HealthRuneTotal == 0){
			    HealthRuneTotalText = "";
			}
			else{
			    HealthRuneTotalText = "Health = " + HealthRuneTotal + "\n";
			}
			if (HealthScalingRuneTotal == 0){
			    HealthScalingRuneTotalText = "";
			}
			else{
			    HealthScalingRuneTotalText = "Health/Level = " + HealthScalingRuneTotal + "\n";
			}
			if (HealthPercentRuneTotal == 0){
			    HealthPercentRuneTotalText = "";
			}
			else{
			    HealthPercentRuneTotalText = "Percent Health = " + HealthPercentRuneTotal + "\n";
			}
			if (HealthRegenRuneTotal == 0){
			    HealthRegenRuneTotalText = "";
			}
			else{
			    HealthRegenRuneTotalText = "Health Regeneration = " + HealthRegenRuneTotal + "\n";
			}
			if (HealthRegenScalingRuneTotal == 0){
			    HealthRegenScalingRuneTotalText = "";
			}
			else{
			    HealthRegenScalingRuneTotalText = "Health Regeneration/Level = " + HealthRegenScalingRuneTotal + "\n";
			}
			if (LifeStealRuneTotal == 0){
			    LifeStealRuneTotalText = "";
			}
			else{
			    LifeStealRuneTotalText = "Life Steal = " + LifeStealRuneTotal + "\n";
			}
			if (MagicPenetrationRuneTotal == 0){
			    MagicPenetrationRuneTotalText = "";
			}
			else{
			    MagicPenetrationRuneTotalText = "Magic Penetration = " + MagicPenetrationRuneTotal + "\n";
			}
			if (MagicResistRunTotal == 0){
			    MagicResistRunTotalText = "";
			}
			else{
			    MagicResistRunTotalText = "Magic Resist = " + MagicResistRunTotal + "\n";
			}
			if (MagicResistScalingRuneTotal == 0){
			    MagicResistScalingRuneTotalText = "";
			}
			else{
			    MagicResistScalingRuneTotalText = "Magic Resist/Leel = " + MagicResistScalingRuneTotal + "\n";
			}
			if (ManaRuneTotal == 0){
			    ManaRuneTotalText = "";
			}
			else{
			    ManaRuneTotalText = "Mana = " + ManaRuneTotal + "\n";
			}
			if (ManaScalingRuneTotal == 0){
			    ManaScalingRuneTotalText = "";
			}
			else{
			    ManaScalingRuneTotalText = "Mana/Level = " + ManaScalingRuneTotal + "\n";
			}
			if (ManaRegenRuneTotal == 0){
			    ManaRegenRuneTotalText = "";
			}
			else{
			    ManaRegenRuneTotalText = "Mana Regeneration = " + ManaRegenRuneTotal + "\n";
			}
			if (ManaRegenScalingRuneTotal == 0){
			    ManaRegenScalingRuneTotalText = "";
			}
			else{
			    ManaRegenScalingRuneTotalText = "Mana Regeneration/Level = " + ManaRegenScalingRuneTotal + "\n";
			}
			if (MovementSpeedRuneTotal == 0){
			    MovementSpeedRuneTotalText = "";
			}
			else{
			    MovementSpeedRuneTotalText = "Movement Speed = " + MovementSpeedRuneTotal + "\n";
			}
			if (SpellVampRuneTotal == 0){
			    SpellVampRuneTotalText = "";
			}
			else{
			    SpellVampRuneTotalText = "Spellvamp = " + SpellVampRuneTotal + "\n";
			}
		
		    		

        	runeID[j] = Integer.toString(listRune.getID());
			savedRuneSetName[j] = listRune.getName();
			savedRuneSetDetails[j] = AbilityPowerRuneTotalText
					 + AbilityPowerScalingRuneTotalText
					 + ArmorRuneTotalText
					 + ArmorScalingRuneTotalText
					 + ArmorPenetrationRuneTotalText
					 + AttackDamageRuneTotalText
					 + AttackDamageScalingRuneTotalText
					 + AttackSpeedRuneTotalText
					 + CooldownReductionRuneTotalText
					 + CooldownReductionRuneScalingTotalText
					 + CriticalChanceRuneTotalText
					 + CriticalDamageRuneTotalText
					 + EnergyRuneTotalText
					 + EnergyScalingRuneTotalText
					 + EnergyRegenRuneTotalText
					 + EnergyRegenScalingRuneTotalText
					 + HealthRuneTotalText
					 + HealthScalingRuneTotalText
					 + HealthPercentRuneTotalText
					 + HealthRegenRuneTotalText
					 + HealthRegenScalingRuneTotalText
					 + LifeStealRuneTotalText
					 + MagicPenetrationRuneTotalText
					 + MagicResistRunTotalText
					 + MagicResistScalingRuneTotalText
					 + ManaRuneTotalText
					 + ManaScalingRuneTotalText
					 + ManaRegenRuneTotalText
					 + ManaRegenScalingRuneTotalText
					 + MovementSpeedRuneTotalText
					 + SpellVampRuneTotalText;

            if (i == j+1){
            	break;
            }
            j++;
        }
    }
    
}