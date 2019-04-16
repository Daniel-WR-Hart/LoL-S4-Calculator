package com.leagueoflegendscalculator;


import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leagueoflegendscalculator.adapter.ClassCustomRuneSaved;
import com.leagueoflegendscalculator.myclasses.ClassRunes;
import com.leagueoflegendscalculator.myclasses.SavedElementsRunes;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;


public class ViewRunepagesActivity extends ActionBarActivity {

	DatabaseHelper dbRune;
    List<SavedElementsRunes> runes;  
    String[] runeID;
	String[] savedRuneSetName;
	String[] savedRuneSetDetails;
	ListView list;
	ClassCustomRuneSaved dataAdapter;
	
	DecimalFormat twoDForm = new DecimalFormat("#.##");//for rounding numbers to two decimal places properly
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_runepages);	
		
		
		Intent getValue = getIntent();
		byte byteHolder = 0;
		
		String runeSetName = getValue.getStringExtra("runeSetName");
		String AbilityPowerRuneMCount = String.valueOf(getValue.getByteExtra("AbilityPowerRuneMCount", byteHolder));
		String AbilityPowerRuneSCount = String.valueOf(getValue.getByteExtra("AbilityPowerRuneSCount", byteHolder));
		String AbilityPowerRuneGCount = String.valueOf(getValue.getByteExtra("AbilityPowerRuneGCount", byteHolder));
		String AbilityPowerRuneQCount = String.valueOf(getValue.getByteExtra("AbilityPowerRuneQCount", byteHolder));
		String AbilityPowerScalingRuneMCount = String.valueOf(getValue.getByteExtra("AbilityPowerScalingRuneMCount", byteHolder));
		String AbilityPowerScalingRuneSCount = String.valueOf(getValue.getByteExtra("AbilityPowerScalingRuneSCount", byteHolder));
		String AbilityPowerScalingRuneGCount = String.valueOf(getValue.getByteExtra("AbilityPowerScalingRuneGCount", byteHolder));
		String AbilityPowerScalingRuneQCount = String.valueOf(getValue.getByteExtra("AbilityPowerScalingRuneQCount", byteHolder));
		String ArmorRuneMCount = String.valueOf(getValue.getByteExtra("ArmorRuneMCount", byteHolder));
		String ArmorRuneSCount = String.valueOf(getValue.getByteExtra("ArmorRuneSCount", byteHolder));
		String ArmorRuneGCount = String.valueOf(getValue.getByteExtra("ArmorRuneGCount", byteHolder));
		String ArmorRuneQCount = String.valueOf(getValue.getByteExtra("ArmorRuneQCount", byteHolder));
		String ArmorScalingRuneSCount = String.valueOf(getValue.getByteExtra("ArmorScalingRuneSCount", byteHolder));
		String ArmorScalingRuneQCount = String.valueOf(getValue.getByteExtra("ArmorScalingRuneQCount", byteHolder));
		String ArmorPenetrationRuneMCount = String.valueOf(getValue.getByteExtra("ArmorPenetrationRuneMCount", byteHolder));
		String ArmorPenetrationRuneQCount = String.valueOf(getValue.getByteExtra("ArmorPenetrationRuneQCount", byteHolder));
		String AttackDamageRuneMCount = String.valueOf(getValue.getByteExtra("AttackDamageRuneMCount", byteHolder));
		String AttackDamageRuneSCount = String.valueOf(getValue.getByteExtra("AttackDamageRuneSCount", byteHolder));
		String AttackDamageRuneGCount = String.valueOf(getValue.getByteExtra("AttackDamageRuneGCount", byteHolder));
		String AttackDamageRuneQCount = String.valueOf(getValue.getByteExtra("AttackDamageRuneQCount", byteHolder));
		String AttackDamageScalingRuneMCount = String.valueOf(getValue.getByteExtra("AttackDamageScalingRuneMCount", byteHolder));
		String AttackDamageScalingRuneSCount = String.valueOf(getValue.getByteExtra("AttackDamageScalingRuneSCount", byteHolder));
		String AttackDamageScalingRuneGCount = String.valueOf(getValue.getByteExtra("AttackDamageScalingRuneGCount", byteHolder));
		String AttackDamageScalingRuneQCount = String.valueOf(getValue.getByteExtra("AttackDamageScalingRuneQCount", byteHolder));
		String AttackSpeedRuneMCount = String.valueOf(getValue.getByteExtra("AttackSpeedRuneMCount", byteHolder));
		String AttackSpeedRuneSCount = String.valueOf(getValue.getByteExtra("AttackSpeedRuneSCount", byteHolder));
		String AttackSpeedRuneGCount = String.valueOf(getValue.getByteExtra("AttackSpeedRuneGCount", byteHolder));
		String AttackSpeedRuneQCount = String.valueOf(getValue.getByteExtra("AttackSpeedRuneQCount", byteHolder));
		String CooldownReductionRuneMCount = String.valueOf(getValue.getByteExtra("CooldownReductionRuneMCount", byteHolder));
		String CooldownReductionRuneSCount = String.valueOf(getValue.getByteExtra("CooldownReductionRuneSCount", byteHolder));
		String CooldownReductionRuneGCount = String.valueOf(getValue.getByteExtra("CooldownReductionRuneGCount", byteHolder));
		String CooldownReductionRuneQCount = String.valueOf(getValue.getByteExtra("CooldownReductionRuneQCount", byteHolder));
		String CooldownReductionScalingRuneGCount = String.valueOf(getValue.getByteExtra("CooldownReductionScalingRuneGCount", byteHolder));
		String CooldownReductionScalingRuneQCount = String.valueOf(getValue.getByteExtra("CooldownReductionScalingRuneQCount", byteHolder));
		String CriticalChanceRuneMCount = String.valueOf(getValue.getByteExtra("CriticalChanceRuneMCount", byteHolder));
		String CriticalChanceRuneSCount = String.valueOf(getValue.getByteExtra("CriticalChanceRuneSCount", byteHolder));
		String CriticalChanceRuneGCount = String.valueOf(getValue.getByteExtra("CriticalChanceRuneGCount", byteHolder));
		String CriticalChanceRuneQCount = String.valueOf(getValue.getByteExtra("CriticalChanceRuneQCount", byteHolder));
		String CriticalDamageRuneMCount = String.valueOf(getValue.getByteExtra("CriticalDamageRuneMCount", byteHolder));
		String CriticalDamageRuneSCount = String.valueOf(getValue.getByteExtra("CriticalDamageRuneSCount", byteHolder));
		String CriticalDamageRuneGCount = String.valueOf(getValue.getByteExtra("CriticalDamageRuneGCount", byteHolder));
		String CriticalDamageRuneQCount = String.valueOf(getValue.getByteExtra("CriticalDamageRuneQCount", byteHolder));
		String EnergyRuneGCount = String.valueOf(getValue.getByteExtra("EnergyRuneGCount", byteHolder));
		String EnergyRuneQCount = String.valueOf(getValue.getByteExtra("EnergyRuneQCount", byteHolder));
		String EnergyScalingRuneGCount = String.valueOf(getValue.getByteExtra("EnergyScalingRuneGCount", byteHolder));
		String EnergyRegenRuneSCount = String.valueOf(getValue.getByteExtra("EnergyRegenRuneSCount", byteHolder));
		String EnergyRegenRuneQCount = String.valueOf(getValue.getByteExtra("EnergyRegenRuneQCount", byteHolder));
		String EnergyRegenScalingRuneSCount = String.valueOf(getValue.getByteExtra("EnergyRegenScalingRuneSCount", byteHolder));
		String HealthRuneMCount = String.valueOf(getValue.getByteExtra("HealthRuneMCount", byteHolder));
		String HealthRuneSCount = String.valueOf(getValue.getByteExtra("HealthRuneSCount", byteHolder));
		String HealthRuneGCount = String.valueOf(getValue.getByteExtra("HealthRuneGCount", byteHolder));
		String HealthRuneQCount = String.valueOf(getValue.getByteExtra("HealthRuneQCount", byteHolder));
		String HealthScalingRuneMCount = String.valueOf(getValue.getByteExtra("HealthScalingRuneMCount", byteHolder));
		String HealthScalingRuneSCount = String.valueOf(getValue.getByteExtra("HealthScalingRuneSCount", byteHolder));
		String HealthScalingRuneGCount = String.valueOf(getValue.getByteExtra("HealthScalingRuneGCount", byteHolder));
		String HealthScalingRuneQCount = String.valueOf(getValue.getByteExtra("HealthScalingRuneQCount", byteHolder));
		String HealthPercentRuneSCount = String.valueOf(getValue.getByteExtra("HealthPercentRuneSCount", byteHolder));
		String HealthPercentRuneQCount = String.valueOf(getValue.getByteExtra("HealthPercentRuneQCount", byteHolder));
		String HealthRegenRuneSCount = String.valueOf(getValue.getByteExtra("HealthRegenRuneSCount", byteHolder));
		String HealthRegenRuneGCount = String.valueOf(getValue.getByteExtra("HealthRegenRuneGCount", byteHolder));
		String HealthRegenRuneQCount = String.valueOf(getValue.getByteExtra("HealthRegenRuneQCount", byteHolder));
		String HealthRegenScalingRuneSCount = String.valueOf(getValue.getByteExtra("HealthRegenScalingRuneSCount", byteHolder));
		String HealthRegenScalingRuneQCount = String.valueOf(getValue.getByteExtra("HealthRegenScalingRuneQCount", byteHolder));
		String HybridPenetrationRuneMCount = String.valueOf(getValue.getByteExtra("HybridPenetrationRuneMCount", byteHolder));
		String HybridPenetrationRuneQCount = String.valueOf(getValue.getByteExtra("HybridPenetrationRuneQCount", byteHolder));
		String LifeStealRuneQCount = String.valueOf(getValue.getByteExtra("LifeStealRuneQCount", byteHolder));
		String MagicPenetrationRuneMCount = String.valueOf(getValue.getByteExtra("MagicPenetrationRuneMCount", byteHolder));
		String MagicPenetrationRuneGCount = String.valueOf(getValue.getByteExtra("MagicPenetrationRuneGCount", byteHolder));
		String MagicPenetrationRuneQCount = String.valueOf(getValue.getByteExtra("MagicPenetrationRuneQCount", byteHolder));
		String MagicResistRuneMCount = String.valueOf(getValue.getByteExtra("MagicResistRuneMCount", byteHolder));
		String MagicResistRuneSCount = String.valueOf(getValue.getByteExtra("MagicResistRuneSCount", byteHolder));
		String MagicResistRuneGCount = String.valueOf(getValue.getByteExtra("MagicResistRuneGCount", byteHolder));
		String MagicResistRuneQCount = String.valueOf(getValue.getByteExtra("MagicResistRuneQCount", byteHolder));
		String MagicResistScalingRuneMCount = String.valueOf(getValue.getByteExtra("MagicResistScalingRuneMCount", byteHolder));
		String MagicResistScalingRuneSCount = String.valueOf(getValue.getByteExtra("MagicResistScalingRuneSCount", byteHolder));
		String MagicResistScalingRuneGCount = String.valueOf(getValue.getByteExtra("MagicResistScalingRuneGCount", byteHolder));
		String MagicResistScalingRuneQCount = String.valueOf(getValue.getByteExtra("MagicResistScalingRuneQCount", byteHolder));
		String ManaRuneMCount = String.valueOf(getValue.getByteExtra("ManaRuneMCount", byteHolder));
		String ManaRuneSCount = String.valueOf(getValue.getByteExtra("ManaRuneSCount", byteHolder));
		String ManaRuneGCount = String.valueOf(getValue.getByteExtra("ManaRuneGCount", byteHolder));
		String ManaRuneQCount = String.valueOf(getValue.getByteExtra("ManaRuneQCount", byteHolder));
		String ManaScalingRuneMCount = String.valueOf(getValue.getByteExtra("ManaScalingRuneMCount", byteHolder));
		String ManaScalingRuneSCount = String.valueOf(getValue.getByteExtra("ManaScalingRuneSCount", byteHolder));
		String ManaScalingRuneGCount = String.valueOf(getValue.getByteExtra("ManaScalingRuneGCount", byteHolder));
		String ManaScalingRuneQCount = String.valueOf(getValue.getByteExtra("ManaScalingRuneQCount", byteHolder));
		String ManaRegenRuneMCount = String.valueOf(getValue.getByteExtra("ManaRegenRuneMCount", byteHolder));
		String ManaRegenRuneSCount = String.valueOf(getValue.getByteExtra("ManaRegenRuneSCount", byteHolder));
		String ManaRegenRuneGCount = String.valueOf(getValue.getByteExtra("ManaRegenRuneGCount", byteHolder));
		String ManaRegenRuneQCount = String.valueOf(getValue.getByteExtra("ManaRegenRuneQCount", byteHolder));
		String ManaRegenScalingRuneSCount = String.valueOf(getValue.getByteExtra("ManaRegenScalingRuneSCount", byteHolder));
		String ManaRegenScalingRuneGCount = String.valueOf(getValue.getByteExtra("ManaRegenScalingRuneGCount", byteHolder));
		String ManaRegenScalingRuneQCount = String.valueOf(getValue.getByteExtra("ManaRegenScalingRuneQCount", byteHolder));
		String MovementSpeedRuneQCount = String.valueOf(getValue.getByteExtra("MovementSpeedRuneQCount", byteHolder));
		String SpellVampRuneQCount = String.valueOf(getValue.getByteExtra("SpellVampRuneQCount", byteHolder));


		
		
		dbRune = new DatabaseHelper(this);
		
		

        // Inserting Contacts //argument1 = itemsetname, argument2 = items
        dbRune.addRune(new SavedElementsRunes(runeSetName 
        		, AbilityPowerRuneMCount
        		, AbilityPowerRuneSCount
        		, AbilityPowerRuneGCount
        		, AbilityPowerRuneQCount
        		, AbilityPowerScalingRuneMCount
        		, AbilityPowerScalingRuneSCount
        		, AbilityPowerScalingRuneGCount
        		, AbilityPowerScalingRuneQCount
        		, ArmorRuneMCount
        		, ArmorRuneSCount
        		, ArmorRuneGCount
        		, ArmorRuneQCount
        		, ArmorScalingRuneSCount
        		, ArmorScalingRuneQCount
        		, ArmorPenetrationRuneMCount
        		, ArmorPenetrationRuneQCount
        		, AttackDamageRuneMCount
        		, AttackDamageRuneSCount
        		, AttackDamageRuneGCount
        		, AttackDamageRuneQCount
        		, AttackDamageScalingRuneMCount
        		, AttackDamageScalingRuneSCount
        		, AttackDamageScalingRuneGCount
        		, AttackDamageScalingRuneQCount
        		, AttackSpeedRuneMCount
        		, AttackSpeedRuneSCount
        		, AttackSpeedRuneGCount
        		, AttackSpeedRuneQCount
        		, CooldownReductionRuneMCount
        		, CooldownReductionRuneSCount
        		, CooldownReductionRuneGCount
        		, CooldownReductionRuneQCount
        		, CooldownReductionScalingRuneGCount
        		, CooldownReductionScalingRuneQCount
        		, CriticalChanceRuneMCount
        		, CriticalChanceRuneSCount
        		, CriticalChanceRuneGCount
        		, CriticalChanceRuneQCount
        		, CriticalDamageRuneMCount
        		, CriticalDamageRuneSCount
        		, CriticalDamageRuneGCount
        		, CriticalDamageRuneQCount
        		, EnergyRuneGCount
        		, EnergyRuneQCount
        		, EnergyScalingRuneGCount
        		, EnergyRegenRuneSCount
        		, EnergyRegenRuneQCount
        		, EnergyRegenScalingRuneSCount
        		, HealthRuneMCount
        		, HealthRuneSCount
        		, HealthRuneGCount
        		, HealthRuneQCount
        		, HealthScalingRuneMCount
        		, HealthScalingRuneSCount
        		, HealthScalingRuneGCount
        		, HealthScalingRuneQCount
        		, HealthPercentRuneSCount
        		, HealthPercentRuneQCount
        		, HealthRegenRuneSCount
        		, HealthRegenRuneGCount
        		, HealthRegenRuneQCount
        		, HealthRegenScalingRuneSCount
        		, HealthRegenScalingRuneQCount
        		, HybridPenetrationRuneMCount
        		, HybridPenetrationRuneQCount
        		, LifeStealRuneQCount
        		, MagicPenetrationRuneMCount
        		, MagicPenetrationRuneGCount
        		, MagicPenetrationRuneQCount
        		, MagicResistRuneMCount
        		, MagicResistRuneSCount
        		, MagicResistRuneGCount
        		, MagicResistRuneQCount
        		, MagicResistScalingRuneMCount
        		, MagicResistScalingRuneSCount
        		, MagicResistScalingRuneGCount
        		, MagicResistScalingRuneQCount
        		, ManaRuneMCount
        		, ManaRuneSCount
        		, ManaRuneGCount
        		, ManaRuneQCount
        		, ManaScalingRuneMCount
        		, ManaScalingRuneSCount
        		, ManaScalingRuneGCount
        		, ManaScalingRuneQCount
        		, ManaRegenRuneMCount
        		, ManaRegenRuneSCount
        		, ManaRegenRuneGCount
        		, ManaRegenRuneQCount
        		, ManaRegenScalingRuneSCount
        		, ManaRegenScalingRuneGCount
        		, ManaRegenScalingRuneQCount
        		, MovementSpeedRuneQCount
        		, SpellVampRuneQCount));
         
        // Reading all contacts
        runes = dbRune.getAllRunes();   
        
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
			    AbilityPowerRuneTotalText = "Ability Power = " + Double.valueOf(twoDForm.format(AbilityPowerRuneTotal)) + "\n";
			}
			if (AbilityPowerScalingRuneTotal == 0){
			    AbilityPowerScalingRuneTotalText = "";
			}
			else{
			    AbilityPowerScalingRuneTotalText = "Ability Power/Level = " + Double.valueOf(twoDForm.format(AbilityPowerScalingRuneTotal)) + "\n";
			}
			if (ArmorRuneTotal == 0){
			    ArmorRuneTotalText = "";
			}
			else{
			    ArmorRuneTotalText = "Armor = " + Double.valueOf(twoDForm.format(ArmorRuneTotal)) + "\n";
			}
			if (ArmorScalingRuneTotal == 0){
			    ArmorScalingRuneTotalText = "";
			}
			else{
			    ArmorScalingRuneTotalText = "Armor/Level = " + Double.valueOf(twoDForm.format(ArmorScalingRuneTotal)) + "\n";
			}
			if (ArmorPenetrationRuneTotal == 0){
			    ArmorPenetrationRuneTotalText = "";
			}
			else{
			    ArmorPenetrationRuneTotalText = "Armor Penetration = " + Double.valueOf(twoDForm.format(ArmorPenetrationRuneTotal)) + "\n";
			}
			if (AttackDamageRuneTotal == 0){
			    AttackDamageRuneTotalText = "";
			}
			else{
			    AttackDamageRuneTotalText = "Attack Damage = " + Double.valueOf(twoDForm.format(AttackDamageRuneTotal)) + "\n";
			}
			if (AttackDamageScalingRuneTotal == 0){
			    AttackDamageScalingRuneTotalText = "";
			}
			else{
			    AttackDamageScalingRuneTotalText = "Attack Damage/Level = " + Double.valueOf(twoDForm.format(AttackDamageScalingRuneTotal)) + "\n";
			}
			if (AttackSpeedRuneTotal == 0){
			    AttackSpeedRuneTotalText = "";
			}
			else{
			    AttackSpeedRuneTotalText = "Attack Speed = " + Double.valueOf(twoDForm.format(AttackSpeedRuneTotal)) + "\n";
			}
			if (CooldownReductionRuneTotal == 0){
			    CooldownReductionRuneTotalText = "";
			}
			else{
			    CooldownReductionRuneTotalText = "Cooldown Reduction = " + Double.valueOf(twoDForm.format(CooldownReductionRuneTotal)) + "\n";
			}
			if (CooldownReductionRuneScalingTotal == 0){
			    CooldownReductionRuneScalingTotalText = "";
			}
			else{
			    CooldownReductionRuneScalingTotalText = "Cooldown Reduction/Level = " + Double.valueOf(twoDForm.format(CooldownReductionRuneScalingTotal)) + "\n";
			}
			if (CriticalChanceRuneTotal == 0){
			    CriticalChanceRuneTotalText = "";
			}
			else{
			    CriticalChanceRuneTotalText = "Critical Chance = " + Double.valueOf(twoDForm.format(CriticalChanceRuneTotal)) + "\n";
			}
			if (CriticalDamageRuneTotal == 0){
			    CriticalDamageRuneTotalText = "";
			}
			else{
			    CriticalDamageRuneTotalText = "Critical Damage = " + Double.valueOf(twoDForm.format(CriticalDamageRuneTotal)) + "\n";
			}
			if (EnergyRuneTotal == 0){
			    EnergyRuneTotalText = "";
			}
			else{
			    EnergyRuneTotalText = "Energy = " + Double.valueOf(twoDForm.format(EnergyRuneTotal)) + "\n";
			}
			if (EnergyScalingRuneTotal == 0){
			    EnergyScalingRuneTotalText = "";
			}
			else{
			    EnergyScalingRuneTotalText = "Energy/Level = " + Double.valueOf(twoDForm.format(EnergyScalingRuneTotal)) + "\n";
			}
			if (EnergyRegenRuneTotal == 0){
			    EnergyRegenRuneTotalText = "";
			}
			else{
			    EnergyRegenRuneTotalText = "Energy Regeneration = " + Double.valueOf(twoDForm.format(EnergyRegenRuneTotal)) + "\n";
			}
			if (EnergyRegenScalingRuneTotal == 0){
			    EnergyRegenScalingRuneTotalText = "";
			}
			else{
			    EnergyRegenScalingRuneTotalText = "Energy Regeneration/Level = " + Double.valueOf(twoDForm.format(EnergyRegenScalingRuneTotal)) + "\n";
			}
			if (HealthRuneTotal == 0){
			    HealthRuneTotalText = "";
			}
			else{
			    HealthRuneTotalText = "Health = " + Double.valueOf(twoDForm.format(HealthRuneTotal)) + "\n";
			}
			if (HealthScalingRuneTotal == 0){
			    HealthScalingRuneTotalText = "";
			}
			else{
			    HealthScalingRuneTotalText = "Health/Level = " + Double.valueOf(twoDForm.format(HealthScalingRuneTotal)) + "\n";
			}
			if (HealthPercentRuneTotal == 0){
			    HealthPercentRuneTotalText = "";
			}
			else{
			    HealthPercentRuneTotalText = "Percent Health = " + Double.valueOf(twoDForm.format(HealthPercentRuneTotal)) + "\n";
			}
			if (HealthRegenRuneTotal == 0){
			    HealthRegenRuneTotalText = "";
			}
			else{
			    HealthRegenRuneTotalText = "Health Regeneration = " + Double.valueOf(twoDForm.format(HealthRegenRuneTotal)) + "\n";
			}
			if (HealthRegenScalingRuneTotal == 0){
			    HealthRegenScalingRuneTotalText = "";
			}
			else{
			    HealthRegenScalingRuneTotalText = "Health Regeneration/Level = " + Double.valueOf(twoDForm.format(HealthRegenScalingRuneTotal)) + "\n";
			}
			if (LifeStealRuneTotal == 0){
			    LifeStealRuneTotalText = "";
			}
			else{
			    LifeStealRuneTotalText = "Life Steal = " + Double.valueOf(twoDForm.format(LifeStealRuneTotal)) + "\n";
			}
			if (MagicPenetrationRuneTotal == 0){
			    MagicPenetrationRuneTotalText = "";
			}
			else{
			    MagicPenetrationRuneTotalText = "Magic Penetration = " + Double.valueOf(twoDForm.format(MagicPenetrationRuneTotal)) + "\n";
			}
			if (MagicResistRunTotal == 0){
			    MagicResistRunTotalText = "";
			}
			else{
			    MagicResistRunTotalText = "Magic Resist = " + Double.valueOf(twoDForm.format(MagicResistRunTotal)) + "\n";
			}
			if (MagicResistScalingRuneTotal == 0){
			    MagicResistScalingRuneTotalText = "";
			}
			else{
			    MagicResistScalingRuneTotalText = "Magic Resist/Leel = " + Double.valueOf(twoDForm.format(MagicResistScalingRuneTotal)) + "\n";
			}
			if (ManaRuneTotal == 0){
			    ManaRuneTotalText = "";
			}
			else{
			    ManaRuneTotalText = "Mana = " + Double.valueOf(twoDForm.format(ManaRuneTotal)) + "\n";
			}
			if (ManaScalingRuneTotal == 0){
			    ManaScalingRuneTotalText = "";
			}
			else{
			    ManaScalingRuneTotalText = "Mana/Level = " + Double.valueOf(twoDForm.format(ManaScalingRuneTotal)) + "\n";
			}
			if (ManaRegenRuneTotal == 0){
			    ManaRegenRuneTotalText = "";
			}
			else{
			    ManaRegenRuneTotalText = "Mana Regeneration = " + Double.valueOf(twoDForm.format(ManaRegenRuneTotal)) + "\n";
			}
			if (ManaRegenScalingRuneTotal == 0){
			    ManaRegenScalingRuneTotalText = "";
			}
			else{
			    ManaRegenScalingRuneTotalText = "Mana Regeneration/Level = " + Double.valueOf(twoDForm.format(ManaRegenScalingRuneTotal)) + "\n";
			}
			if (MovementSpeedRuneTotal == 0){
			    MovementSpeedRuneTotalText = "";
			}
			else{
			    MovementSpeedRuneTotalText = "Movement Speed = " + Double.valueOf(twoDForm.format(MovementSpeedRuneTotal)) + "\n";
			}
			if (SpellVampRuneTotal == 0){
			    SpellVampRuneTotalText = "";
			}
			else{
			    SpellVampRuneTotalText = "Spellvamp = " + Double.valueOf(twoDForm.format(SpellVampRuneTotal)) + "\n";
			}
		
		    		

        	runeID[j] = Integer.toString(listRune.getID());
			savedRuneSetName[j] = listRune.getName();
			savedRuneSetDetails[j] = AbilityPowerRuneTotalText + AbilityPowerScalingRuneTotalText + ArmorRuneTotalText + ArmorScalingRuneTotalText
					 + ArmorPenetrationRuneTotalText + AttackDamageRuneTotalText + AttackDamageScalingRuneTotalText + AttackSpeedRuneTotalText + CooldownReductionRuneTotalText
					 + CooldownReductionRuneScalingTotalText + CriticalChanceRuneTotalText + CriticalDamageRuneTotalText
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
        

        dataAdapter = new ClassCustomRuneSaved(ViewRunepagesActivity.this, runeID, savedRuneSetName, savedRuneSetDetails);
	    list = (ListView)findViewById(R.id.listViewDisplaySavedRunes);
		list.setAdapter(dataAdapter);
		
		
		list.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		    	if(savedRuneSetName[position] != " "){
		    		
			    	String idString = list.getItemAtPosition(position).toString(); 
			    	int idInt = Integer.parseInt(idString);
			    	
			    	String deletedRune = dbRune.getRune(idInt).getName();
			    	dbRune.deleteRune(dbRune.getRune(idInt));
	
			    	Toast.makeText(getApplicationContext(), "You deleted " + deletedRune, Toast.LENGTH_SHORT).show();
			    	
			    	savedRuneSetName[position] = " ";
			    	savedRuneSetDetails[position] = " ";
			    	
			    	dataAdapter = new ClassCustomRuneSaved(ViewRunepagesActivity.this, runeID, savedRuneSetName, savedRuneSetDetails);
					list.setAdapter(dataAdapter);
		    	}
				
		    }
		});

		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_view_runepage, menu);
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

