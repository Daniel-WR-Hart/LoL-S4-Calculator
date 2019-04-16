package com.leagueoflegendscalculator;


import java.util.ArrayList;
import java.util.List;

import com.leagueoflegendscalculator.myclasses.SavedElementsBuilds;
import com.leagueoflegendscalculator.myclasses.SavedElementsChampions;
import com.leagueoflegendscalculator.myclasses.SavedElementsItems;
import com.leagueoflegendscalculator.myclasses.SavedElementsMastery;
import com.leagueoflegendscalculator.myclasses.SavedElementsRunes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
	private static final int DATABASE_VERSION = 1;
	 
    // Database Name
    private static final String DATABASE_NAME = "buildDataManager";
 
    // Table Names
    private static final String TABLE_CHAMPIONS = "Champions";
    private static final String TABLE_ITEMS = "Items";
    private static final String TABLE_MASTERIES = "Masteries";
    private static final String TABLE_RUNES = "Runes";
    private static final String TABLE_BUILDS = "Builds";
    
    
    // Common column names
    private static final String KEY_ID = "id";
    
    //CHAMPS Table - column names
    private static final String KEY_CHAMPNAME = "champ_name";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_QSKILL = "qskill";
    private static final String KEY_WSKILL = "wskill";
    private static final String KEY_ESKILL = "eskill";
    private static final String KEY_RSKILL = "rskill";
    
    //ITEMS Table - column names
    private static final String KEY_ITEMSETNAME = "item_name";
    private static final String KEY_ITEM1 = "item1";
    private static final String KEY_ITEM2 = "item2";
    private static final String KEY_ITEM3 = "item3";
    private static final String KEY_ITEM4 = "item4";
    private static final String KEY_ITEM5 = "item5";
    private static final String KEY_ITEM6 = "item6";
    
    //MASTERIES Table - column names
    private static final String KEY_MASTERYNAME = "mastery_name";
	public static final String KEY_offenseMasteryCount = "offenseMasteryCount";
	public static final String KEY_defenseMasteryCount = "defenseMasteryCount";
	public static final String KEY_utilityMasteryCount = "utilityMasteryCount";
	public static final String KEY_doubleEdgedSwordCount = "doubleEdgedSwordCount";
	public static final String KEY_furyCount = "furyCount";
	public static final String KEY_sorceryCount = "sorceryCount";
	public static final String KEY_exposeWeaknessCount = "exposeWeaknessCount";
	public static final String KEY_martialMasteryCount = "martialMasteryCount";
	public static final String KEY_arcaneMasteryCount = "arcaneMasteryCount";
	public static final String KEY_bladeWeavingCount = "bladeWeavingCount";
	public static final String KEY_warlordCount = "warlordCount";
	public static final String KEY_archmageCount = "archmageCount";
	public static final String KEY_frenzyCount = "frenzyCount";
	public static final String KEY_devastatingStrikeCount = "devastatingStrikeCount";
	public static final String KEY_arcaneBladeCount = "arcaneBladeCount";
	public static final String KEY_havocCount = "havocCount";
	public static final String KEY_recoveryCount = "recoveryCount";
	public static final String KEY_enchantedArmorCount = "enchantedArmorCount";
	public static final String KEY_unyieldingCount = "unyieldingCount";
	public static final String KEY_oppressionCount = "oppressionCount";
	public static final String KEY_juggernautCount = "juggernautCount";
	public static final String KEY_reinforcedArmorCount = "reinforcedArmorCount";
	public static final String KEY_evasiveCount = "evasiveCount";
	public static final String KEY_secondWindCount = "secondWindCount";
	public static final String KEY_runicBlessingCount = "runicBlessingCount";
	public static final String KEY_fleetOfFootCount = "fleetOfFootCount";
	public static final String KEY_strengthOfSpiritCount = "strengthOfSpiritCount";
	public static final String KEY_vampirismCount = "vampirismCount";
	public static final String KEY_expandedMindCount = "expandedMindCount";
	public static final String KEY_intelligenceCount = "intelligenceCount";
	public static final String KEY_bruteForceCount = "bruteForceCount";
	public static final String KEY_mentalForceCount = "mentalForceCount";
	public static final String KEY_spellWeavingCount = "spellWeavingCount";
	public static final String KEY_executionerCount = "executionerCount";
	public static final String KEY_blockCount = "blockCount";
	public static final String KEY_veteransScarsCount = "veteransScarsCount";
	public static final String KEY_hardinessCount = "hardinessCount";
	public static final String KEY_resistanceCount = "resistanceCount";
	public static final String KEY_perseveranceCount = "perseveranceCount";
	public static final String KEY_meditationCount = "meditationCount";
    
    //RUNES Table - column names
    private static final String KEY_RUNESETNAME = "rune_name";
	private static final String KEY_AbilityPowerRuneMCount = "AbilityPowerRuneMCount";
	private static final String KEY_AbilityPowerRuneSCount = "AbilityPowerRuneSCount";
	private static final String KEY_AbilityPowerRuneGCount = "AbilityPowerRuneGCount";
	private static final String KEY_AbilityPowerRuneQCount = "AbilityPowerRuneQCount";
	private static final String KEY_AbilityPowerScalingRuneMCount = "AbilityPowerScalingRuneMCount";
	private static final String KEY_AbilityPowerScalingRuneSCount = "AbilityPowerScalingRuneSCount";
	private static final String KEY_AbilityPowerScalingRuneGCount = "AbilityPowerScalingRuneGCount";
	private static final String KEY_AbilityPowerScalingRuneQCount = "AbilityPowerScalingRuneQCount";
	private static final String KEY_ArmorRuneMCount = "ArmorRuneMCount";
	private static final String KEY_ArmorRuneSCount = "ArmorRuneSCount";
	private static final String KEY_ArmorRuneGCount = "ArmorRuneGCount";
	private static final String KEY_ArmorRuneQCount = "ArmorRuneQCount";
	private static final String KEY_ArmorScalingRuneSCount = "ArmorScalingRuneSCount";
	private static final String KEY_ArmorScalingRuneQCount = "ArmorScalingRuneQCount";
	private static final String KEY_ArmorPenetrationRuneMCount = "ArmorPenetrationRuneMCount";
	private static final String KEY_ArmorPenetrationRuneQCount = "ArmorPenetrationRuneQCount";
	private static final String KEY_AttackDamageRuneMCount = "AttackDamageRuneMCount";
	private static final String KEY_AttackDamageRuneSCount = "AttackDamageRuneSCount";
	private static final String KEY_AttackDamageRuneGCount = "AttackDamageRuneGCount";
	private static final String KEY_AttackDamageRuneQCount = "AttackDamageRuneQCount";
	private static final String KEY_AttackDamageScalingRuneMCount = "AttackDamageScalingRuneMCount";
	private static final String KEY_AttackDamageScalingRuneSCount = "AttackDamageScalingRuneSCount";
	private static final String KEY_AttackDamageScalingRuneGCount = "AttackDamageScalingRuneGCount";
	private static final String KEY_AttackDamageScalingRuneQCount = "AttackDamageScalingRuneQCount";
	private static final String KEY_AttackSpeedRuneMCount = "AttackSpeedRuneMCount";
	private static final String KEY_AttackSpeedRuneSCount = "AttackSpeedRuneSCount";
	private static final String KEY_AttackSpeedRuneGCount = "AttackSpeedRuneGCount";
	private static final String KEY_AttackSpeedRuneQCount = "AttackSpeedRuneQCount";
	private static final String KEY_CooldownReductionRuneMCount = "CooldownReductionRuneMCount";
	private static final String KEY_CooldownReductionRuneSCount = "CooldownReductionRuneSCount";
	private static final String KEY_CooldownReductionRuneGCount = "CooldownReductionRuneGCount";
	private static final String KEY_CooldownReductionRuneQCount = "CooldownReductionRuneQCount";
	private static final String KEY_CooldownReductionScalingRuneGCount = "CooldownReductionScalingRuneGCount";
	private static final String KEY_CooldownReductionScalingRuneQCount = "CooldownReductionScalingRuneQCount";
	private static final String KEY_CriticalChanceRuneMCount = "CriticalChanceRuneMCount";
	private static final String KEY_CriticalChanceRuneSCount = "CriticalChanceRuneSCount";
	private static final String KEY_CriticalChanceRuneGCount = "CriticalChanceRuneGCount";
	private static final String KEY_CriticalChanceRuneQCount = "CriticalChanceRuneQCount";
	private static final String KEY_CriticalDamageRuneMCount = "CriticalDamageRuneMCount";
	private static final String KEY_CriticalDamageRuneSCount = "CriticalDamageRuneSCount";
	private static final String KEY_CriticalDamageRuneGCount = "CriticalDamageRuneGCount";
	private static final String KEY_CriticalDamageRuneQCount = "CriticalDamageRuneQCount";
	private static final String KEY_EnergyRuneGCount = "EnergyRuneGCount";
	private static final String KEY_EnergyRuneQCount = "EnergyRuneQCount";
	private static final String KEY_EnergyScalingRuneGCount = "EnergyScalingRuneGCount";
	private static final String KEY_EnergyRegenRuneSCount = "EnergyRegenRuneSCount";
	private static final String KEY_EnergyRegenRuneQCount = "EnergyRegenRuneQCount";
	private static final String KEY_EnergyRegenScalingRuneSCount = "EnergyRegenScalingRuneSCount";
	private static final String KEY_HealthRuneMCount = "HealthRuneMCount";
	private static final String KEY_HealthRuneSCount = "HealthRuneSCount";
	private static final String KEY_HealthRuneGCount = "HealthRuneGCount";
	private static final String KEY_HealthRuneQCount = "HealthRuneQCount";
	private static final String KEY_HealthScalingRuneMCount = "HealthScalingRuneMCount";
	private static final String KEY_HealthScalingRuneSCount = "HealthScalingRuneSCount";
	private static final String KEY_HealthScalingRuneGCount = "HealthScalingRuneGCount";
	private static final String KEY_HealthScalingRuneQCount = "HealthScalingRuneQCount";
	private static final String KEY_HealthPercentRuneSCount = "HealthPercentRuneSCount";
	private static final String KEY_HealthPercentRuneQCount = "HealthPercentRuneQCount";
	private static final String KEY_HealthRegenRuneSCount = "HealthRegenRuneSCount";
	private static final String KEY_HealthRegenRuneGCount = "HealthRegenRuneGCount";
	private static final String KEY_HealthRegenRuneQCount = "HealthRegenRuneQCount";
	private static final String KEY_HealthRegenScalingRuneSCount = "HealthRegenScalingRuneSCount";
	private static final String KEY_HealthRegenScalingRuneQCount = "HealthRegenScalingRuneQCount";
	private static final String KEY_HybridPenetrationRuneMCount = "HybridPenetrationRuneMCount";
	private static final String KEY_HybridPenetrationRuneQCount = "HybridPenetrationRuneQCount";
	private static final String KEY_LifeStealRuneQCount = "LifeStealRuneQCount";
	private static final String KEY_MagicPenetrationRuneMCount = "MagicPenetrationRuneMCount";
	private static final String KEY_MagicPenetrationRuneGCount = "MagicPenetrationRuneGCount";
	private static final String KEY_MagicPenetrationRuneQCount = "MagicPenetrationRuneQCount";
	private static final String KEY_MagicResistRuneMCount = "MagicResistRuneMCount";
	private static final String KEY_MagicResistRuneSCount = "MagicResistRuneSCount";
	private static final String KEY_MagicResistRuneGCount = "MagicResistRuneGCount";
	private static final String KEY_MagicResistRuneQCount = "MagicResistRuneQCount";
	private static final String KEY_MagicResistScalingRuneMCount = "MagicResistScalingRuneMCount";
	private static final String KEY_MagicResistScalingRuneSCount = "MagicResistScalingRuneSCount";
	private static final String KEY_MagicResistScalingRuneGCount = "MagicResistScalingRuneGCount";
	private static final String KEY_MagicResistScalingRuneQCount = "MagicResistScalingRuneQCount";
	private static final String KEY_ManaRuneMCount = "ManaRuneMCount";
	private static final String KEY_ManaRuneSCount = "ManaRuneSCount";
	private static final String KEY_ManaRuneGCount = "ManaRuneGCount";
	private static final String KEY_ManaRuneQCount = "ManaRuneQCount";
	private static final String KEY_ManaScalingRuneMCount = "ManaScalingRuneMCount";
	private static final String KEY_ManaScalingRuneSCount = "ManaScalingRuneSCount";
	private static final String KEY_ManaScalingRuneGCount = "ManaScalingRuneGCount";
	private static final String KEY_ManaScalingRuneQCount = "ManaScalingRuneQCount";
	private static final String KEY_ManaRegenRuneMCount = "ManaRegenRuneMCount";
	private static final String KEY_ManaRegenRuneSCount = "ManaRegenRuneSCount";
	private static final String KEY_ManaRegenRuneGCount = "ManaRegenRuneGCount";
	private static final String KEY_ManaRegenRuneQCount = "ManaRegenRuneQCount";
	private static final String KEY_ManaRegenScalingRuneSCount = "ManaRegenScalingRuneSCount";
	private static final String KEY_ManaRegenScalingRuneGCount = "ManaRegenScalingRuneGCount";
	private static final String KEY_ManaRegenScalingRuneQCount = "ManaRegenScalingRuneQCount";
	private static final String KEY_MovementSpeedRuneQCount = "MovementSpeedRuneQCount";
	private static final String KEY_SpellVampRuneQCount = "SpellVampRuneQCount";
    
	//ITEMS Table - column names
    private static final String KEY_BUILDNAME = "build_name";
    private static final String KEY_CHAMPION_INPUT = "champion_input";
    private static final String KEY_ITEM_INPUT = "item_input";
    private static final String KEY_MASTERY_INPUT = "mastery_input";
    private static final String KEY_RUNE_INPUT = "rune_input";
	
    // Table Create Statements
    // Champs table create statement
    private static final String CREATE_TABLE_CHAMPS = "CREATE TABLE " + TABLE_CHAMPIONS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CHAMPNAME + " TEXT,"
            + KEY_LEVEL + " TEXT," + KEY_QSKILL + " TEXT," + KEY_WSKILL + " TEXT," + KEY_ESKILL + " TEXT," + KEY_RSKILL + " TEXT" + ")";
    
    // Items table create statement
    private static final String CREATE_TABLE_ITEMS = "CREATE TABLE " + TABLE_ITEMS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ITEMSETNAME + " TEXT,"
            + KEY_ITEM1 + " TEXT," + KEY_ITEM2 + " TEXT," + KEY_ITEM3 + " TEXT," + KEY_ITEM4 + " TEXT," + KEY_ITEM5 + " TEXT," + KEY_ITEM6 + " TEXT" + ")";
    
    // Mastery table create statement
    private static final String CREATE_TABLE_MASTERYS = "CREATE TABLE " + TABLE_MASTERIES + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MASTERYNAME + " TEXT,"
			+ KEY_offenseMasteryCount + " TEXT,"
			+ KEY_defenseMasteryCount + " TEXT,"
			+ KEY_utilityMasteryCount + " TEXT,"
			+ KEY_doubleEdgedSwordCount + " TEXT,"
			+ KEY_furyCount + " TEXT,"
			+ KEY_sorceryCount + " TEXT,"
			+ KEY_exposeWeaknessCount + " TEXT,"
			+ KEY_martialMasteryCount + " TEXT,"
			+ KEY_arcaneMasteryCount + " TEXT,"
			+ KEY_bladeWeavingCount + " TEXT,"
			+ KEY_warlordCount + " TEXT,"
			+ KEY_archmageCount + " TEXT,"
			+ KEY_frenzyCount + " TEXT,"
			+ KEY_devastatingStrikeCount + " TEXT,"
			+ KEY_arcaneBladeCount + " TEXT,"
			+ KEY_havocCount + " TEXT,"
			+ KEY_recoveryCount + " TEXT,"
			+ KEY_enchantedArmorCount + " TEXT,"
			+ KEY_unyieldingCount + " TEXT,"
			+ KEY_oppressionCount + " TEXT,"
			+ KEY_juggernautCount + " TEXT,"
			+ KEY_reinforcedArmorCount + " TEXT,"
			+ KEY_evasiveCount + " TEXT,"
			+ KEY_secondWindCount + " TEXT,"
			+ KEY_runicBlessingCount + " TEXT,"
			+ KEY_fleetOfFootCount + " TEXT,"
			+ KEY_strengthOfSpiritCount + " TEXT,"
			+ KEY_vampirismCount + " TEXT,"
			+ KEY_expandedMindCount + " TEXT,"
			+ KEY_intelligenceCount + " TEXT,"
			+ KEY_bruteForceCount + " TEXT,"
			+ KEY_mentalForceCount + " TEXT,"
			+ KEY_spellWeavingCount + " TEXT,"
			+ KEY_executionerCount + " TEXT,"
			+ KEY_blockCount + " TEXT,"
			+ KEY_veteransScarsCount + " TEXT,"
			+ KEY_hardinessCount + " TEXT,"
			+ KEY_resistanceCount + " TEXT,"
			+ KEY_perseveranceCount + " TEXT,"
			+ KEY_meditationCount + " TEXT" + ")";

    // Runes table create statement
    private static final String CREATE_TABLE_RUNES = "CREATE TABLE " + TABLE_RUNES + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_RUNESETNAME + " TEXT,"
            + KEY_AbilityPowerRuneMCount + " TEXT,"
            + KEY_AbilityPowerRuneSCount + " TEXT,"
            + KEY_AbilityPowerRuneGCount + " TEXT,"
            + KEY_AbilityPowerRuneQCount + " TEXT,"
            + KEY_AbilityPowerScalingRuneMCount + " TEXT,"
            + KEY_AbilityPowerScalingRuneSCount + " TEXT,"
            + KEY_AbilityPowerScalingRuneGCount + " TEXT,"
            + KEY_AbilityPowerScalingRuneQCount + " TEXT,"
            + KEY_ArmorRuneMCount + " TEXT,"
            + KEY_ArmorRuneSCount + " TEXT,"
            + KEY_ArmorRuneGCount + " TEXT,"
            + KEY_ArmorRuneQCount + " TEXT,"
            + KEY_ArmorScalingRuneSCount + " TEXT,"
            + KEY_ArmorScalingRuneQCount + " TEXT,"
            + KEY_ArmorPenetrationRuneMCount + " TEXT,"
            + KEY_ArmorPenetrationRuneQCount + " TEXT,"
            + KEY_AttackDamageRuneMCount + " TEXT,"
            + KEY_AttackDamageRuneSCount + " TEXT,"
            + KEY_AttackDamageRuneGCount + " TEXT,"
            + KEY_AttackDamageRuneQCount + " TEXT,"
            + KEY_AttackDamageScalingRuneMCount + " TEXT,"
            + KEY_AttackDamageScalingRuneSCount + " TEXT,"
            + KEY_AttackDamageScalingRuneGCount + " TEXT,"
            + KEY_AttackDamageScalingRuneQCount + " TEXT,"
            + KEY_AttackSpeedRuneMCount + " TEXT,"
            + KEY_AttackSpeedRuneSCount + " TEXT,"
            + KEY_AttackSpeedRuneGCount + " TEXT,"
            + KEY_AttackSpeedRuneQCount + " TEXT,"
            + KEY_CooldownReductionRuneMCount + " TEXT,"
            + KEY_CooldownReductionRuneSCount + " TEXT,"
            + KEY_CooldownReductionRuneGCount + " TEXT,"
            + KEY_CooldownReductionRuneQCount + " TEXT,"
            + KEY_CooldownReductionScalingRuneGCount + " TEXT,"
            + KEY_CooldownReductionScalingRuneQCount + " TEXT,"
            + KEY_CriticalChanceRuneMCount + " TEXT,"
            + KEY_CriticalChanceRuneSCount + " TEXT,"
            + KEY_CriticalChanceRuneGCount + " TEXT,"
            + KEY_CriticalChanceRuneQCount + " TEXT,"
            + KEY_CriticalDamageRuneMCount + " TEXT,"
            + KEY_CriticalDamageRuneSCount + " TEXT,"
            + KEY_CriticalDamageRuneGCount + " TEXT,"
            + KEY_CriticalDamageRuneQCount + " TEXT,"
            + KEY_EnergyRuneGCount + " TEXT,"
            + KEY_EnergyRuneQCount + " TEXT,"
            + KEY_EnergyScalingRuneGCount + " TEXT,"
            + KEY_EnergyRegenRuneSCount + " TEXT,"
            + KEY_EnergyRegenRuneQCount + " TEXT,"
            + KEY_EnergyRegenScalingRuneSCount + " TEXT,"
            + KEY_HealthRuneMCount + " TEXT,"
            + KEY_HealthRuneSCount + " TEXT,"
            + KEY_HealthRuneGCount + " TEXT,"
            + KEY_HealthRuneQCount + " TEXT,"
            + KEY_HealthScalingRuneMCount + " TEXT,"
            + KEY_HealthScalingRuneSCount + " TEXT,"
            + KEY_HealthScalingRuneGCount + " TEXT,"
            + KEY_HealthScalingRuneQCount + " TEXT,"
            + KEY_HealthPercentRuneSCount + " TEXT,"
            + KEY_HealthPercentRuneQCount + " TEXT,"
            + KEY_HealthRegenRuneSCount + " TEXT,"
            + KEY_HealthRegenRuneGCount + " TEXT,"
            + KEY_HealthRegenRuneQCount + " TEXT,"
            + KEY_HealthRegenScalingRuneSCount + " TEXT,"
            + KEY_HealthRegenScalingRuneQCount + " TEXT,"
            + KEY_HybridPenetrationRuneMCount + " TEXT,"
            + KEY_HybridPenetrationRuneQCount + " TEXT,"
            + KEY_LifeStealRuneQCount + " TEXT,"
            + KEY_MagicPenetrationRuneMCount + " TEXT,"
            + KEY_MagicPenetrationRuneGCount + " TEXT,"
            + KEY_MagicPenetrationRuneQCount + " TEXT,"
            + KEY_MagicResistRuneMCount + " TEXT,"
            + KEY_MagicResistRuneSCount + " TEXT,"
            + KEY_MagicResistRuneGCount + " TEXT,"
            + KEY_MagicResistRuneQCount + " TEXT,"
            + KEY_MagicResistScalingRuneMCount + " TEXT,"
            + KEY_MagicResistScalingRuneSCount + " TEXT,"
            + KEY_MagicResistScalingRuneGCount + " TEXT,"
            + KEY_MagicResistScalingRuneQCount + " TEXT,"
            + KEY_ManaRuneMCount + " TEXT,"
            + KEY_ManaRuneSCount + " TEXT,"
            + KEY_ManaRuneGCount + " TEXT,"
            + KEY_ManaRuneQCount + " TEXT,"
            + KEY_ManaScalingRuneMCount + " TEXT,"
            + KEY_ManaScalingRuneSCount + " TEXT,"
            + KEY_ManaScalingRuneGCount + " TEXT,"
            + KEY_ManaScalingRuneQCount + " TEXT,"
            + KEY_ManaRegenRuneMCount + " TEXT,"
            + KEY_ManaRegenRuneSCount + " TEXT,"
            + KEY_ManaRegenRuneGCount + " TEXT,"
            + KEY_ManaRegenRuneQCount + " TEXT,"
            + KEY_ManaRegenScalingRuneSCount + " TEXT,"
            + KEY_ManaRegenScalingRuneGCount + " TEXT,"
            + KEY_ManaRegenScalingRuneQCount + " TEXT,"
            + KEY_MovementSpeedRuneQCount + " TEXT,"
            + KEY_SpellVampRuneQCount + " TEXT" + ")";
    
    // Builds table create statement
    private static final String CREATE_TABLE_BUILDS = "CREATE TABLE " + TABLE_BUILDS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_BUILDNAME + " TEXT,"
            + KEY_CHAMPION_INPUT + " TEXT," + KEY_ITEM_INPUT + " TEXT," + KEY_MASTERY_INPUT + " TEXT," + KEY_RUNE_INPUT + " TEXT" + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    public void onCreate(SQLiteDatabase db) {
    	 
        // creating required tables
        db.execSQL(CREATE_TABLE_CHAMPS);
        db.execSQL(CREATE_TABLE_ITEMS);
        db.execSQL(CREATE_TABLE_MASTERYS);
        db.execSQL(CREATE_TABLE_RUNES);
        db.execSQL(CREATE_TABLE_BUILDS);
        
    }
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAMPIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MASTERIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RUNES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUILDS);
        
        // create new tables
        onCreate(db);
    }

    public 
	
	
	
	
	
	
	
    // Adding new champion	
    void addChampion(SavedElementsChampions champ) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_CHAMPNAME, champ.getName());
        values.put(KEY_LEVEL, champ.getLevel());
        values.put(KEY_QSKILL, champ.getQSkill());
        values.put(KEY_WSKILL, champ.getWSkill());
        values.put(KEY_ESKILL, champ.getESkill());
        values.put(KEY_RSKILL, champ.getRSkill());
        
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Inserting Row
        db.insert(TABLE_CHAMPIONS, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single champion
    SavedElementsChampions getChampion(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CHAMPIONS, new String[] { KEY_ID,
                KEY_CHAMPNAME, KEY_LEVEL, KEY_QSKILL , KEY_WSKILL , KEY_ESKILL , KEY_RSKILL }, KEY_ID + "=?",//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        SavedElementsChampions champ = new SavedElementsChampions(Integer.parseInt(cursor.getString(0)),
        		cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        cursor.close();
        db.close();
        return champ;
    }
     
    // Getting All Champions
    public List<SavedElementsChampions> getAllChampions() {
        List<SavedElementsChampions> champList = new ArrayList<SavedElementsChampions>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CHAMPIONS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SavedElementsChampions champ = new SavedElementsChampions();
                champ.setID(Integer.parseInt(cursor.getString(0)));
                champ.setName(cursor.getString(1));
                champ.setLevel(cursor.getString(2));
                champ.setQSkill(cursor.getString(3));
                champ.setWSkill(cursor.getString(4));
                champ.setESkill(cursor.getString(5));
                champ.setRSkill(cursor.getString(6));
                
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Adding Champion to list
                champList.add(champ);
            } while (cursor.moveToNext());
        }
 
        // return Champion list
        cursor.close();
        db.close();
        return champList;
    }
 
    // Updating single Champion
    public int updateChampions(SavedElementsChampions champ) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_CHAMPNAME, champ.getName());
        values.put(KEY_LEVEL, champ.getLevel());
        values.put(KEY_QSKILL, champ.getQSkill());
        values.put(KEY_WSKILL, champ.getWSkill());
        values.put(KEY_ESKILL, champ.getESkill());
        values.put(KEY_RSKILL, champ.getRSkill());
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // updating row
        return db.update(TABLE_CHAMPIONS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(champ.getID()) });
    }
 
    // Deleting single Champion
    public void deleteChampion(SavedElementsChampions champ) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHAMPIONS, KEY_ID + " = ?",
                new String[] { String.valueOf(champ.getID()) });
        db.close();
    }
 
 
    // Getting Champions Count
    public int getChampionCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CHAMPIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();
 
        // return count
        return cursor.getCount();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Adding new itemset
    void addItem(SavedElementsItems items) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_ITEMSETNAME, items.getName());
        values.put(KEY_ITEM1, items.getItem1());
        values.put(KEY_ITEM2, items.getItem2());
        values.put(KEY_ITEM3, items.getItem3());
        values.put(KEY_ITEM4, items.getItem4());
        values.put(KEY_ITEM5, items.getItem5());
        values.put(KEY_ITEM6, items.getItem6());
        
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Inserting Row
        db.insert(TABLE_ITEMS, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single itemset
    SavedElementsItems getItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_ITEMS, new String[] { KEY_ID,
                KEY_ITEMSETNAME, KEY_ITEM1, KEY_ITEM2 , KEY_ITEM3 , KEY_ITEM4 , KEY_ITEM5 , KEY_ITEM6 }, KEY_ID + "=?",//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        SavedElementsItems itemSet = new SavedElementsItems(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        cursor.close();
        db.close();
        return itemSet;
    }
     
    // Getting All item sets
    public List<SavedElementsItems> getAllItems() {
        List<SavedElementsItems> itemList = new ArrayList<SavedElementsItems>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SavedElementsItems items = new SavedElementsItems();
                items.setID(Integer.parseInt(cursor.getString(0)));
                items.setName(cursor.getString(1));
                items.setItem1(cursor.getString(2));
                items.setItem2(cursor.getString(3));
                items.setItem3(cursor.getString(4));
                items.setItem4(cursor.getString(5));
                items.setItem5(cursor.getString(6));
                items.setItem6(cursor.getString(7));
                
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Adding item set to list
                itemList.add(items);
            } while (cursor.moveToNext());
        }
 
        // return item set list
        cursor.close();
        db.close();
        return itemList;
    }
 
    // Updating single item set
    public int updateItems(SavedElementsItems items) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_ITEMSETNAME, items.getName());
        values.put(KEY_ITEM1, items.getItem1());
        values.put(KEY_ITEM2, items.getItem2());
        values.put(KEY_ITEM3, items.getItem3());
        values.put(KEY_ITEM4, items.getItem4());
        values.put(KEY_ITEM5, items.getItem5());
        values.put(KEY_ITEM6, items.getItem6());
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // updating row
        return db.update(TABLE_ITEMS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(items.getID()) });
    }
 
    // Deleting single item set
    public void deleteItem(SavedElementsItems items) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, KEY_ID + " = ?",
                new String[] { String.valueOf(items.getID()) });
        db.close();
    }
 
 
    // Getting item set Count
    public int getItemCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ITEMS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();
 
        // return count
        return cursor.getCount();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Adding new masterypage
    void addMastery(SavedElementsMastery masteries) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_MASTERYNAME, masteries.getName());
        values.put(KEY_offenseMasteryCount, masteries.getOffenseMasteryCount());
        values.put(KEY_defenseMasteryCount, masteries.getDefenseMasteryCount());
        values.put(KEY_utilityMasteryCount, masteries.getUtilityMasteryCount());
        values.put(KEY_doubleEdgedSwordCount, masteries.getDoubleEdgedSwordCount());
        values.put(KEY_furyCount, masteries.getFuryCount());
        values.put(KEY_sorceryCount, masteries.getSorceryCount());
        values.put(KEY_exposeWeaknessCount, masteries.getExposeWeaknessCount());
        values.put(KEY_martialMasteryCount, masteries.getMartialMasteryCount());
        values.put(KEY_arcaneMasteryCount, masteries.getArcaneMasteryCount());
        values.put(KEY_bladeWeavingCount, masteries.getBladeWeavingCount());
        values.put(KEY_warlordCount, masteries.getWarlordCount());
        values.put(KEY_archmageCount, masteries.getArchmageCount());
        values.put(KEY_frenzyCount, masteries.getFrenzyCount());
        values.put(KEY_devastatingStrikeCount, masteries.getDevastatingStrikeCount());
        values.put(KEY_arcaneBladeCount, masteries.getArcaneBladeCount());
        values.put(KEY_havocCount, masteries.getHavocCount());
        values.put(KEY_recoveryCount, masteries.getRecoveryCount());
        values.put(KEY_enchantedArmorCount, masteries.getEnchantedArmorCount());
        values.put(KEY_unyieldingCount, masteries.getUnyieldingCount());
        values.put(KEY_oppressionCount, masteries.getOppressionCount());
        values.put(KEY_juggernautCount, masteries.getJuggernautCount());
        values.put(KEY_reinforcedArmorCount, masteries.getReinforcedArmorCount());
        values.put(KEY_evasiveCount, masteries.getEvasiveCount());
        values.put(KEY_secondWindCount, masteries.getSecondWindCount());
        values.put(KEY_runicBlessingCount, masteries.getRunicBlessingCount());
        values.put(KEY_fleetOfFootCount, masteries.getFleetOfFootCount());
        values.put(KEY_strengthOfSpiritCount, masteries.getStrengthOfSpiritCount());
        values.put(KEY_vampirismCount, masteries.getVampirismCount());
        values.put(KEY_expandedMindCount, masteries.getExpandedMindCount());
        values.put(KEY_intelligenceCount, masteries.getIntelligenceCount());
        values.put(KEY_bruteForceCount, masteries.getBruteForceCount());
        values.put(KEY_mentalForceCount, masteries.getMentalForceCount());
        values.put(KEY_spellWeavingCount, masteries.getSpellWeavingCount());
        values.put(KEY_executionerCount, masteries.getExecutionerCount());
        values.put(KEY_blockCount, masteries.getBlockCount());
        values.put(KEY_veteransScarsCount, masteries.getVeteransScarsCount());
        values.put(KEY_hardinessCount, masteries.getHardinessCount());
        values.put(KEY_resistanceCount, masteries.getResistanceCount());
        values.put(KEY_perseveranceCount, masteries.getPerseveranceCount());
        values.put(KEY_meditationCount, masteries.getMeditationCount());
        
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Inserting Row
        db.insert(TABLE_MASTERIES, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single mastery page
    SavedElementsMastery getMastery(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_MASTERIES, new String[] { KEY_ID,
                KEY_MASTERYNAME,
                KEY_offenseMasteryCount,
                KEY_defenseMasteryCount,
                KEY_utilityMasteryCount,
                KEY_doubleEdgedSwordCount,
                KEY_furyCount,
                KEY_sorceryCount,
                KEY_exposeWeaknessCount,
                KEY_martialMasteryCount,
                KEY_arcaneMasteryCount,
                KEY_bladeWeavingCount,
                KEY_warlordCount,
                KEY_archmageCount,
                KEY_frenzyCount,
                KEY_devastatingStrikeCount,
                KEY_arcaneBladeCount,
                KEY_havocCount,
                KEY_recoveryCount,
                KEY_enchantedArmorCount,
                KEY_unyieldingCount,
                KEY_oppressionCount,
                KEY_juggernautCount,
                KEY_reinforcedArmorCount,
                KEY_evasiveCount,
                KEY_secondWindCount,
                KEY_runicBlessingCount,
                KEY_fleetOfFootCount,
                KEY_strengthOfSpiritCount,
                KEY_vampirismCount,
                KEY_expandedMindCount,
                KEY_intelligenceCount,
                KEY_bruteForceCount,
                KEY_mentalForceCount,
                KEY_spellWeavingCount,
                KEY_executionerCount,
                KEY_blockCount,
                KEY_veteransScarsCount,
                KEY_hardinessCount,
                KEY_resistanceCount,
                KEY_perseveranceCount,
                KEY_meditationCount }, KEY_ID + "=?",//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        SavedElementsMastery masteries = new SavedElementsMastery(Integer.parseInt(cursor.getString(0)),
        		 cursor.getString(1),
        		 cursor.getString(2),
        		 cursor.getString(3),
        		 cursor.getString(4),
        		 cursor.getString(5),
        		 cursor.getString(6),
        		 cursor.getString(7),
        		 cursor.getString(8),
        		 cursor.getString(9),
        		 cursor.getString(10),
        		 cursor.getString(11),
        		 cursor.getString(12),
        		 cursor.getString(13),
        		 cursor.getString(14),
        		 cursor.getString(15),
        		 cursor.getString(16),
        		 cursor.getString(17),
        		 cursor.getString(18),
        		 cursor.getString(19),
        		 cursor.getString(20),
        		 cursor.getString(21),
        		 cursor.getString(22),
        		 cursor.getString(23),
        		 cursor.getString(24),
        		 cursor.getString(25),
        		 cursor.getString(26),
        		 cursor.getString(27),
        		 cursor.getString(28),
        		 cursor.getString(29),
        		 cursor.getString(30),
        		 cursor.getString(31),
        		 cursor.getString(32),
        		 cursor.getString(33),
        		 cursor.getString(34),
        		 cursor.getString(35),
        		 cursor.getString(36),
        		 cursor.getString(37),
        		 cursor.getString(38),
        		 cursor.getString(39),
        		 cursor.getString(40),
        		 cursor.getString(41));
        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        cursor.close();
        db.close();
        return masteries;
    }
     
    // Getting All Masteries
    public List<SavedElementsMastery> getAllMasteries() {
        List<SavedElementsMastery> masteryList = new ArrayList<SavedElementsMastery>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MASTERIES;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	SavedElementsMastery masteries = new SavedElementsMastery();
                masteries.setID(Integer.parseInt(cursor.getString(0)));
                masteries.setName(cursor.getString(1));
                masteries.setOffenseMasteryCount(cursor.getString(2));
                masteries.setDefenseMasteryCount(cursor.getString(3));
                masteries.setUtilityMasteryCount(cursor.getString(4));
                masteries.setDoubleEdgedSwordCount(cursor.getString(5));
                masteries.setFuryCount(cursor.getString(6));
                masteries.setSorceryCount(cursor.getString(7));
                masteries.setExposeWeaknessCount(cursor.getString(8));
                masteries.setMartialMasteryCount(cursor.getString(9));
                masteries.setArcaneMasteryCount(cursor.getString(10));
                masteries.setBladeWeavingCount(cursor.getString(11));
                masteries.setWarlordCount(cursor.getString(12));
                masteries.setArchmageCount(cursor.getString(13));
                masteries.setFrenzyCount(cursor.getString(14));
                masteries.setDevastatingStrikeCount(cursor.getString(15));
                masteries.setArcaneBladeCount(cursor.getString(16));
                masteries.setHavocCount(cursor.getString(17));
                masteries.setRecoveryCount(cursor.getString(18));
                masteries.setEnchantedArmorCount(cursor.getString(19));
                masteries.setUnyieldingCount(cursor.getString(20));
                masteries.setOppressionCount(cursor.getString(21));
                masteries.setJuggernautCount(cursor.getString(22));
                masteries.setReinforcedArmorCount(cursor.getString(23));
                masteries.setEvasiveCount(cursor.getString(24));
                masteries.setSecondWindCount(cursor.getString(25));
                masteries.setRunicBlessingCount(cursor.getString(26));
                masteries.setFleetOfFootCount(cursor.getString(27));
                masteries.setStrengthOfSpiritCount(cursor.getString(28));
                masteries.setVampirismCount(cursor.getString(29));
                masteries.setExpandedMindCount(cursor.getString(30));
                masteries.setIntelligenceCount(cursor.getString(31));
                masteries.setBruteForceCount(cursor.getString(32));
                masteries.setMentalForceCount(cursor.getString(33));
                masteries.setSpellWeavingCount(cursor.getString(34));
                masteries.setExecutionerCount(cursor.getString(35));
                masteries.setBlockCount(cursor.getString(36));
                masteries.setVeteransScarsCount(cursor.getString(37));
                masteries.setHardinessCount(cursor.getString(38));
                masteries.setResistanceCount(cursor.getString(39));
                masteries.setPerseveranceCount(cursor.getString(40));
                masteries.setMeditationCount(cursor.getString(41));
                
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Adding mastery to list
                masteryList.add(masteries);
            } while (cursor.moveToNext());
        }
 
        // return mastery page list
        cursor.close();
        db.close();
        return masteryList;
    }
 
    // Updating single mastery page
    public int updateMasteries(SavedElementsMastery masteries) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_MASTERYNAME, masteries.getName());
        values.put(KEY_offenseMasteryCount, masteries.getOffenseMasteryCount());
        values.put(KEY_defenseMasteryCount, masteries.getDefenseMasteryCount());
        values.put(KEY_utilityMasteryCount, masteries.getUtilityMasteryCount());
        values.put(KEY_doubleEdgedSwordCount, masteries.getDoubleEdgedSwordCount());
        values.put(KEY_furyCount, masteries.getFuryCount());
        values.put(KEY_sorceryCount, masteries.getSorceryCount());
        values.put(KEY_exposeWeaknessCount, masteries.getExposeWeaknessCount());
        values.put(KEY_martialMasteryCount, masteries.getMartialMasteryCount());
        values.put(KEY_arcaneMasteryCount, masteries.getArcaneMasteryCount());
        values.put(KEY_bladeWeavingCount, masteries.getBladeWeavingCount());
        values.put(KEY_warlordCount, masteries.getWarlordCount());
        values.put(KEY_archmageCount, masteries.getArchmageCount());
        values.put(KEY_frenzyCount, masteries.getFrenzyCount());
        values.put(KEY_devastatingStrikeCount, masteries.getDevastatingStrikeCount());
        values.put(KEY_arcaneBladeCount, masteries.getArcaneBladeCount());
        values.put(KEY_havocCount, masteries.getHavocCount());
        values.put(KEY_recoveryCount, masteries.getRecoveryCount());
        values.put(KEY_enchantedArmorCount, masteries.getEnchantedArmorCount());
        values.put(KEY_unyieldingCount, masteries.getUnyieldingCount());
        values.put(KEY_oppressionCount, masteries.getOppressionCount());
        values.put(KEY_juggernautCount, masteries.getJuggernautCount());
        values.put(KEY_reinforcedArmorCount, masteries.getReinforcedArmorCount());
        values.put(KEY_evasiveCount, masteries.getEvasiveCount());
        values.put(KEY_secondWindCount, masteries.getSecondWindCount());
        values.put(KEY_runicBlessingCount, masteries.getRunicBlessingCount());
        values.put(KEY_fleetOfFootCount, masteries.getFleetOfFootCount());
        values.put(KEY_strengthOfSpiritCount, masteries.getStrengthOfSpiritCount());
        values.put(KEY_vampirismCount, masteries.getVampirismCount());
        values.put(KEY_expandedMindCount, masteries.getExpandedMindCount());
        values.put(KEY_intelligenceCount, masteries.getIntelligenceCount());
        values.put(KEY_bruteForceCount, masteries.getBruteForceCount());
        values.put(KEY_mentalForceCount, masteries.getMentalForceCount());
        values.put(KEY_spellWeavingCount, masteries.getSpellWeavingCount());
        values.put(KEY_executionerCount, masteries.getExecutionerCount());
        values.put(KEY_blockCount, masteries.getBlockCount());
        values.put(KEY_veteransScarsCount, masteries.getVeteransScarsCount());
        values.put(KEY_hardinessCount, masteries.getHardinessCount());
        values.put(KEY_resistanceCount, masteries.getResistanceCount());
        values.put(KEY_perseveranceCount, masteries.getPerseveranceCount());
        values.put(KEY_meditationCount, masteries.getMeditationCount());
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // updating row
        return db.update(TABLE_MASTERIES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(masteries.getID()) });
    }
 
    // Deleting single mastery page
    public void deleteMastery(SavedElementsMastery masteries) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MASTERIES, KEY_ID + " = ?",
                new String[] { String.valueOf(masteries.getID()) });
        db.close();
    }
 
 
    // Getting mastery page Count
    public int getMasteryCount() {
        String countQuery = "SELECT  * FROM " + TABLE_MASTERIES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();
 
        // return count
        return cursor.getCount();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Adding new rune page
    void addRune(SavedElementsRunes runes) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_RUNESETNAME, runes.getName());
		values.put(KEY_AbilityPowerRuneMCount, runes.getAbilityPowerRuneMCount());
		values.put(KEY_AbilityPowerRuneSCount, runes.getAbilityPowerRuneSCount());
		values.put(KEY_AbilityPowerRuneGCount, runes.getAbilityPowerRuneGCount());
		values.put(KEY_AbilityPowerRuneQCount, runes.getAbilityPowerRuneQCount());
		values.put(KEY_AbilityPowerScalingRuneMCount, runes.getAbilityPowerScalingRuneMCount());
		values.put(KEY_AbilityPowerScalingRuneSCount, runes.getAbilityPowerScalingRuneSCount());
		values.put(KEY_AbilityPowerScalingRuneGCount, runes.getAbilityPowerScalingRuneGCount());
		values.put(KEY_AbilityPowerScalingRuneQCount, runes.getAbilityPowerScalingRuneQCount());
		values.put(KEY_ArmorRuneMCount, runes.getArmorRuneMCount());
		values.put(KEY_ArmorRuneSCount, runes.getArmorRuneSCount());
		values.put(KEY_ArmorRuneGCount, runes.getArmorRuneGCount());
		values.put(KEY_ArmorRuneQCount, runes.getArmorRuneQCount());
		values.put(KEY_ArmorScalingRuneSCount, runes.getArmorScalingRuneSCount());
		values.put(KEY_ArmorScalingRuneQCount, runes.getArmorScalingRuneQCount());
		values.put(KEY_ArmorPenetrationRuneMCount, runes.getArmorPenetrationRuneMCount());
		values.put(KEY_ArmorPenetrationRuneQCount, runes.getArmorPenetrationRuneQCount());
		values.put(KEY_AttackDamageRuneMCount, runes.getAttackDamageRuneMCount());
		values.put(KEY_AttackDamageRuneSCount, runes.getAttackDamageRuneSCount());
		values.put(KEY_AttackDamageRuneGCount, runes.getAttackDamageRuneGCount());
		values.put(KEY_AttackDamageRuneQCount, runes.getAttackDamageRuneQCount());
		values.put(KEY_AttackDamageScalingRuneMCount, runes.getAttackDamageScalingRuneMCount());
		values.put(KEY_AttackDamageScalingRuneSCount, runes.getAttackDamageScalingRuneSCount());
		values.put(KEY_AttackDamageScalingRuneGCount, runes.getAttackDamageScalingRuneGCount());
		values.put(KEY_AttackDamageScalingRuneQCount, runes.getAttackDamageScalingRuneQCount());
		values.put(KEY_AttackSpeedRuneMCount, runes.getAttackSpeedRuneMCount());
		values.put(KEY_AttackSpeedRuneSCount, runes.getAttackSpeedRuneSCount());
		values.put(KEY_AttackSpeedRuneGCount, runes.getAttackSpeedRuneGCount());
		values.put(KEY_AttackSpeedRuneQCount, runes.getAttackSpeedRuneQCount());
		values.put(KEY_CooldownReductionRuneMCount, runes.getCooldownReductionRuneMCount());
		values.put(KEY_CooldownReductionRuneSCount, runes.getCooldownReductionRuneSCount());
		values.put(KEY_CooldownReductionRuneGCount, runes.getCooldownReductionRuneGCount());
		values.put(KEY_CooldownReductionRuneQCount, runes.getCooldownReductionRuneQCount());
		values.put(KEY_CooldownReductionScalingRuneGCount, runes.getCooldownReductionScalingRuneGCount());
		values.put(KEY_CooldownReductionScalingRuneQCount, runes.getCooldownReductionScalingRuneQCount());
		values.put(KEY_CriticalChanceRuneMCount, runes.getCriticalChanceRuneMCount());
		values.put(KEY_CriticalChanceRuneSCount, runes.getCriticalChanceRuneSCount());
		values.put(KEY_CriticalChanceRuneGCount, runes.getCriticalChanceRuneGCount());
		values.put(KEY_CriticalChanceRuneQCount, runes.getCriticalChanceRuneQCount());
		values.put(KEY_CriticalDamageRuneMCount, runes.getCriticalDamageRuneMCount());
		values.put(KEY_CriticalDamageRuneSCount, runes.getCriticalDamageRuneSCount());
		values.put(KEY_CriticalDamageRuneGCount, runes.getCriticalDamageRuneGCount());
		values.put(KEY_CriticalDamageRuneQCount, runes.getCriticalDamageRuneQCount());
		values.put(KEY_EnergyRuneGCount, runes.getEnergyRuneGCount());
		values.put(KEY_EnergyRuneQCount, runes.getEnergyRuneQCount());
		values.put(KEY_EnergyScalingRuneGCount, runes.getEnergyScalingRuneGCount());
		values.put(KEY_EnergyRegenRuneSCount, runes.getEnergyRegenRuneSCount());
		values.put(KEY_EnergyRegenRuneQCount, runes.getEnergyRegenRuneQCount());
		values.put(KEY_EnergyRegenScalingRuneSCount, runes.getEnergyRegenScalingRuneSCount());
		values.put(KEY_HealthRuneMCount, runes.getHealthRuneMCount());
		values.put(KEY_HealthRuneSCount, runes.getHealthRuneSCount());
		values.put(KEY_HealthRuneGCount, runes.getHealthRuneGCount());
		values.put(KEY_HealthRuneQCount, runes.getHealthRuneQCount());
		values.put(KEY_HealthScalingRuneMCount, runes.getHealthScalingRuneMCount());
		values.put(KEY_HealthScalingRuneSCount, runes.getHealthScalingRuneSCount());
		values.put(KEY_HealthScalingRuneGCount, runes.getHealthScalingRuneGCount());
		values.put(KEY_HealthScalingRuneQCount, runes.getHealthScalingRuneQCount());
		values.put(KEY_HealthPercentRuneSCount, runes.getHealthPercentRuneSCount());
		values.put(KEY_HealthPercentRuneQCount, runes.getHealthPercentRuneQCount());
		values.put(KEY_HealthRegenRuneSCount, runes.getHealthRegenRuneSCount());
		values.put(KEY_HealthRegenRuneGCount, runes.getHealthRegenRuneGCount());
		values.put(KEY_HealthRegenRuneQCount, runes.getHealthRegenRuneQCount());
		values.put(KEY_HealthRegenScalingRuneSCount, runes.getHealthRegenScalingRuneSCount());
		values.put(KEY_HealthRegenScalingRuneQCount, runes.getHealthRegenScalingRuneQCount());
		values.put(KEY_HybridPenetrationRuneMCount, runes.getHybridPenetrationRuneMCount());
		values.put(KEY_HybridPenetrationRuneQCount, runes.getHybridPenetrationRuneQCount());
		values.put(KEY_LifeStealRuneQCount, runes.getLifeStealRuneQCount());
		values.put(KEY_MagicPenetrationRuneMCount, runes.getMagicPenetrationRuneMCount());
		values.put(KEY_MagicPenetrationRuneGCount, runes.getMagicPenetrationRuneGCount());
		values.put(KEY_MagicPenetrationRuneQCount, runes.getMagicPenetrationRuneQCount());
		values.put(KEY_MagicResistRuneMCount, runes.getMagicResistRuneMCount());
		values.put(KEY_MagicResistRuneSCount, runes.getMagicResistRuneSCount());
		values.put(KEY_MagicResistRuneGCount, runes.getMagicResistRuneGCount());
		values.put(KEY_MagicResistRuneQCount, runes.getMagicResistRuneQCount());
		values.put(KEY_MagicResistScalingRuneMCount, runes.getMagicResistScalingRuneMCount());
		values.put(KEY_MagicResistScalingRuneSCount, runes.getMagicResistScalingRuneSCount());
		values.put(KEY_MagicResistScalingRuneGCount, runes.getMagicResistScalingRuneGCount());
		values.put(KEY_MagicResistScalingRuneQCount, runes.getMagicResistScalingRuneQCount());
		values.put(KEY_ManaRuneMCount, runes.getManaRuneMCount());
		values.put(KEY_ManaRuneSCount, runes.getManaRuneSCount());
		values.put(KEY_ManaRuneGCount, runes.getManaRuneGCount());
		values.put(KEY_ManaRuneQCount, runes.getManaRuneQCount());
		values.put(KEY_ManaScalingRuneMCount, runes.getManaScalingRuneMCount());
		values.put(KEY_ManaScalingRuneSCount, runes.getManaScalingRuneSCount());
		values.put(KEY_ManaScalingRuneGCount, runes.getManaScalingRuneGCount());
		values.put(KEY_ManaScalingRuneQCount, runes.getManaScalingRuneQCount());
		values.put(KEY_ManaRegenRuneMCount, runes.getManaRegenRuneMCount());
		values.put(KEY_ManaRegenRuneSCount, runes.getManaRegenRuneSCount());
		values.put(KEY_ManaRegenRuneGCount, runes.getManaRegenRuneGCount());
		values.put(KEY_ManaRegenRuneQCount, runes.getManaRegenRuneQCount());
		values.put(KEY_ManaRegenScalingRuneSCount, runes.getManaRegenScalingRuneSCount());
		values.put(KEY_ManaRegenScalingRuneGCount, runes.getManaRegenScalingRuneGCount());
		values.put(KEY_ManaRegenScalingRuneQCount, runes.getManaRegenScalingRuneQCount());
		values.put(KEY_MovementSpeedRuneQCount, runes.getMovementSpeedRuneQCount());
		values.put(KEY_SpellVampRuneQCount, runes.getSpellVampRuneQCount());
        
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Inserting Row
        db.insert(TABLE_RUNES, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single rune page
    SavedElementsRunes getRune(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_RUNES, new String[] { KEY_ID,
                KEY_RUNESETNAME
                , KEY_AbilityPowerRuneMCount
                , KEY_AbilityPowerRuneSCount
                , KEY_AbilityPowerRuneGCount
                , KEY_AbilityPowerRuneQCount
                , KEY_AbilityPowerScalingRuneMCount
                , KEY_AbilityPowerScalingRuneSCount
                , KEY_AbilityPowerScalingRuneGCount
                , KEY_AbilityPowerScalingRuneQCount
                , KEY_ArmorRuneMCount
                , KEY_ArmorRuneSCount
                , KEY_ArmorRuneGCount
                , KEY_ArmorRuneQCount
                , KEY_ArmorScalingRuneSCount
                , KEY_ArmorScalingRuneQCount
                , KEY_ArmorPenetrationRuneMCount
                , KEY_ArmorPenetrationRuneQCount
                , KEY_AttackDamageRuneMCount
                , KEY_AttackDamageRuneSCount
                , KEY_AttackDamageRuneGCount
                , KEY_AttackDamageRuneQCount
                , KEY_AttackDamageScalingRuneMCount
                , KEY_AttackDamageScalingRuneSCount
                , KEY_AttackDamageScalingRuneGCount
                , KEY_AttackDamageScalingRuneQCount
                , KEY_AttackSpeedRuneMCount
                , KEY_AttackSpeedRuneSCount
                , KEY_AttackSpeedRuneGCount
                , KEY_AttackSpeedRuneQCount
                , KEY_CooldownReductionRuneMCount
                , KEY_CooldownReductionRuneSCount
                , KEY_CooldownReductionRuneGCount
                , KEY_CooldownReductionRuneQCount
                , KEY_CooldownReductionScalingRuneGCount
                , KEY_CooldownReductionScalingRuneQCount
                , KEY_CriticalChanceRuneMCount
                , KEY_CriticalChanceRuneSCount
                , KEY_CriticalChanceRuneGCount
                , KEY_CriticalChanceRuneQCount
                , KEY_CriticalDamageRuneMCount
                , KEY_CriticalDamageRuneSCount
                , KEY_CriticalDamageRuneGCount
                , KEY_CriticalDamageRuneQCount
                , KEY_EnergyRuneGCount
                , KEY_EnergyRuneQCount
                , KEY_EnergyScalingRuneGCount
                , KEY_EnergyRegenRuneSCount
                , KEY_EnergyRegenRuneQCount
                , KEY_EnergyRegenScalingRuneSCount
                , KEY_HealthRuneMCount
                , KEY_HealthRuneSCount
                , KEY_HealthRuneGCount
                , KEY_HealthRuneQCount
                , KEY_HealthScalingRuneMCount
                , KEY_HealthScalingRuneSCount
                , KEY_HealthScalingRuneGCount
                , KEY_HealthScalingRuneQCount
                , KEY_HealthPercentRuneSCount
                , KEY_HealthPercentRuneQCount
                , KEY_HealthRegenRuneSCount
                , KEY_HealthRegenRuneGCount
                , KEY_HealthRegenRuneQCount
                , KEY_HealthRegenScalingRuneSCount
                , KEY_HealthRegenScalingRuneQCount
                , KEY_HybridPenetrationRuneMCount
                , KEY_HybridPenetrationRuneQCount
                , KEY_LifeStealRuneQCount
                , KEY_MagicPenetrationRuneMCount
                , KEY_MagicPenetrationRuneGCount
                , KEY_MagicPenetrationRuneQCount
                , KEY_MagicResistRuneMCount
                , KEY_MagicResistRuneSCount
                , KEY_MagicResistRuneGCount
                , KEY_MagicResistRuneQCount
                , KEY_MagicResistScalingRuneMCount
                , KEY_MagicResistScalingRuneSCount
                , KEY_MagicResistScalingRuneGCount
                , KEY_MagicResistScalingRuneQCount
                , KEY_ManaRuneMCount
                , KEY_ManaRuneSCount
                , KEY_ManaRuneGCount
                , KEY_ManaRuneQCount
                , KEY_ManaScalingRuneMCount
                , KEY_ManaScalingRuneSCount
                , KEY_ManaScalingRuneGCount
                , KEY_ManaScalingRuneQCount
                , KEY_ManaRegenRuneMCount
                , KEY_ManaRegenRuneSCount
                , KEY_ManaRegenRuneGCount
                , KEY_ManaRegenRuneQCount
                , KEY_ManaRegenScalingRuneSCount
                , KEY_ManaRegenScalingRuneGCount
                , KEY_ManaRegenScalingRuneQCount
                , KEY_MovementSpeedRuneQCount
                , KEY_SpellVampRuneQCount }, KEY_ID + "=?",//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        SavedElementsRunes runes = new SavedElementsRunes(Integer.parseInt(cursor.getString(0))
                , cursor.getString(1)
				, cursor.getString(2)
				, cursor.getString(3)
				, cursor.getString(4)
				, cursor.getString(5)
				, cursor.getString(6)
				, cursor.getString(7)
				, cursor.getString(8)
				, cursor.getString(9)
				, cursor.getString(10)
				, cursor.getString(11)
				, cursor.getString(12)
				, cursor.getString(13)
				, cursor.getString(14)
				, cursor.getString(15)
				, cursor.getString(16)
				, cursor.getString(17)
				, cursor.getString(18)
				, cursor.getString(19)
				, cursor.getString(20)
				, cursor.getString(21)
				, cursor.getString(22)
				, cursor.getString(23)
				, cursor.getString(24)
				, cursor.getString(25)
				, cursor.getString(26)
				, cursor.getString(27)
				, cursor.getString(28)
				, cursor.getString(29)
				, cursor.getString(30)
				, cursor.getString(31)
				, cursor.getString(32)
				, cursor.getString(33)
				, cursor.getString(34)
				, cursor.getString(35)
				, cursor.getString(36)
				, cursor.getString(37)
				, cursor.getString(38)
				, cursor.getString(39)
				, cursor.getString(40)
				, cursor.getString(41)
				, cursor.getString(42)
				, cursor.getString(43)
				, cursor.getString(44)
				, cursor.getString(45)
				, cursor.getString(46)
				, cursor.getString(47)
				, cursor.getString(48)
				, cursor.getString(49)
				, cursor.getString(50)
				, cursor.getString(51)
				, cursor.getString(52)
				, cursor.getString(53)
				, cursor.getString(54)
				, cursor.getString(55)
				, cursor.getString(56)
				, cursor.getString(57)
				, cursor.getString(58)
				, cursor.getString(59)
				, cursor.getString(60)
				, cursor.getString(61)
				, cursor.getString(62)
				, cursor.getString(63)
				, cursor.getString(64)
				, cursor.getString(65)
				, cursor.getString(66)
				, cursor.getString(67)
				, cursor.getString(68)
				, cursor.getString(69)
				, cursor.getString(70)
				, cursor.getString(71)
				, cursor.getString(72)
				, cursor.getString(73)
				, cursor.getString(74)
				, cursor.getString(75)
				, cursor.getString(76)
				, cursor.getString(77)
				, cursor.getString(78)
				, cursor.getString(79)
				, cursor.getString(80)
				, cursor.getString(81)
				, cursor.getString(82)
				, cursor.getString(83)
				, cursor.getString(84)
				, cursor.getString(85)
				, cursor.getString(86)
				, cursor.getString(87)
				, cursor.getString(88)
				, cursor.getString(89)
				, cursor.getString(90)
				, cursor.getString(91)
				, cursor.getString(92)
				, cursor.getString(93)
				, cursor.getString(94)
				, cursor.getString(95)
                );
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        cursor.close();
        db.close();
        return runes;
    }
     
    // Getting All Rune Pages
    public List<SavedElementsRunes> getAllRunes() {
        List<SavedElementsRunes> runeList = new ArrayList<SavedElementsRunes>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RUNES;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SavedElementsRunes runes = new SavedElementsRunes();
                runes.setID(Integer.parseInt(cursor.getString(0)));
                runes.setName(cursor.getString(1));
                runes.setAbilityPowerRuneMCount(cursor.getString(2));
                runes.setAbilityPowerRuneSCount(cursor.getString(3));
                runes.setAbilityPowerRuneGCount(cursor.getString(4));
                runes.setAbilityPowerRuneQCount(cursor.getString(5));
                runes.setAbilityPowerScalingRuneMCount(cursor.getString(6));
                runes.setAbilityPowerScalingRuneSCount(cursor.getString(7));
                runes.setAbilityPowerScalingRuneGCount(cursor.getString(8));
                runes.setAbilityPowerScalingRuneQCount(cursor.getString(9));
                runes.setArmorRuneMCount(cursor.getString(10));
                runes.setArmorRuneSCount(cursor.getString(11));
                runes.setArmorRuneGCount(cursor.getString(12));
                runes.setArmorRuneQCount(cursor.getString(13));
                runes.setArmorScalingRuneSCount(cursor.getString(14));
                runes.setArmorScalingRuneQCount(cursor.getString(15));
                runes.setArmorPenetrationRuneMCount(cursor.getString(16));
                runes.setArmorPenetrationRuneQCount(cursor.getString(17));
                runes.setAttackDamageRuneMCount(cursor.getString(18));
                runes.setAttackDamageRuneSCount(cursor.getString(19));
                runes.setAttackDamageRuneGCount(cursor.getString(20));
                runes.setAttackDamageRuneQCount(cursor.getString(21));
                runes.setAttackDamageScalingRuneMCount(cursor.getString(22));
                runes.setAttackDamageScalingRuneSCount(cursor.getString(23));
                runes.setAttackDamageScalingRuneGCount(cursor.getString(24));
                runes.setAttackDamageScalingRuneQCount(cursor.getString(25));
                runes.setAttackSpeedRuneMCount(cursor.getString(26));
                runes.setAttackSpeedRuneSCount(cursor.getString(27));
                runes.setAttackSpeedRuneGCount(cursor.getString(28));
                runes.setAttackSpeedRuneQCount(cursor.getString(29));
                runes.setCooldownReductionRuneMCount(cursor.getString(30));
                runes.setCooldownReductionRuneSCount(cursor.getString(31));
                runes.setCooldownReductionRuneGCount(cursor.getString(32));
                runes.setCooldownReductionRuneQCount(cursor.getString(33));
                runes.setCooldownReductionScalingRuneGCount(cursor.getString(34));
                runes.setCooldownReductionScalingRuneQCount(cursor.getString(35));
                runes.setCriticalChanceRuneMCount(cursor.getString(36));
                runes.setCriticalChanceRuneSCount(cursor.getString(37));
                runes.setCriticalChanceRuneGCount(cursor.getString(38));
                runes.setCriticalChanceRuneQCount(cursor.getString(39));
                runes.setCriticalDamageRuneMCount(cursor.getString(40));
                runes.setCriticalDamageRuneSCount(cursor.getString(41));
                runes.setCriticalDamageRuneGCount(cursor.getString(42));
                runes.setCriticalDamageRuneQCount(cursor.getString(43));
                runes.setEnergyRuneGCount(cursor.getString(44));
                runes.setEnergyRuneQCount(cursor.getString(45));
                runes.setEnergyScalingRuneGCount(cursor.getString(46));
                runes.setEnergyRegenRuneSCount(cursor.getString(47));
                runes.setEnergyRegenRuneQCount(cursor.getString(48));
                runes.setEnergyRegenScalingRuneSCount(cursor.getString(49));
                runes.setHealthRuneMCount(cursor.getString(50));
                runes.setHealthRuneSCount(cursor.getString(51));
                runes.setHealthRuneGCount(cursor.getString(52));
                runes.setHealthRuneQCount(cursor.getString(53));
                runes.setHealthScalingRuneMCount(cursor.getString(54));
                runes.setHealthScalingRuneSCount(cursor.getString(55));
                runes.setHealthScalingRuneGCount(cursor.getString(56));
                runes.setHealthScalingRuneQCount(cursor.getString(57));
                runes.setHealthPercentRuneSCount(cursor.getString(58));
                runes.setHealthPercentRuneQCount(cursor.getString(59));
                runes.setHealthRegenRuneSCount(cursor.getString(60));
                runes.setHealthRegenRuneGCount(cursor.getString(61));
                runes.setHealthRegenRuneQCount(cursor.getString(62));
                runes.setHealthRegenScalingRuneSCount(cursor.getString(63));
                runes.setHealthRegenScalingRuneQCount(cursor.getString(64));
                runes.setHybridPenetrationRuneMCount(cursor.getString(65));
                runes.setHybridPenetrationRuneQCount(cursor.getString(66));
                runes.setLifeStealRuneQCount(cursor.getString(67));
                runes.setMagicPenetrationRuneMCount(cursor.getString(68));
                runes.setMagicPenetrationRuneGCount(cursor.getString(69));
                runes.setMagicPenetrationRuneQCount(cursor.getString(70));
                runes.setMagicResistRuneMCount(cursor.getString(71));
                runes.setMagicResistRuneSCount(cursor.getString(72));
                runes.setMagicResistRuneGCount(cursor.getString(73));
                runes.setMagicResistRuneQCount(cursor.getString(74));
                runes.setMagicResistScalingRuneMCount(cursor.getString(75));
                runes.setMagicResistScalingRuneSCount(cursor.getString(76));
                runes.setMagicResistScalingRuneGCount(cursor.getString(77));
                runes.setMagicResistScalingRuneQCount(cursor.getString(78));
                runes.setManaRuneMCount(cursor.getString(79));
                runes.setManaRuneSCount(cursor.getString(80));
                runes.setManaRuneGCount(cursor.getString(81));
                runes.setManaRuneQCount(cursor.getString(82));
                runes.setManaScalingRuneMCount(cursor.getString(83));
                runes.setManaScalingRuneSCount(cursor.getString(84));
                runes.setManaScalingRuneGCount(cursor.getString(85));
                runes.setManaScalingRuneQCount(cursor.getString(86));
                runes.setManaRegenRuneMCount(cursor.getString(87));
                runes.setManaRegenRuneSCount(cursor.getString(88));
                runes.setManaRegenRuneGCount(cursor.getString(89));
                runes.setManaRegenRuneQCount(cursor.getString(90));
                runes.setManaRegenScalingRuneSCount(cursor.getString(91));
                runes.setManaRegenScalingRuneGCount(cursor.getString(92));
                runes.setManaRegenScalingRuneQCount(cursor.getString(93));
                runes.setMovementSpeedRuneQCount(cursor.getString(94));
                runes.setSpellVampRuneQCount(cursor.getString(95));
                
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Adding rune page to list
                runeList.add(runes);
            } while (cursor.moveToNext());
        }
 
        // return rune page list
        cursor.close();
        db.close();
        return runeList;
    }
 
    // Updating single runepage
    public int updateRunes(SavedElementsRunes runes) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_RUNESETNAME, runes.getName());
		values.put(KEY_AbilityPowerRuneMCount, runes.getAbilityPowerRuneMCount());
		values.put(KEY_AbilityPowerRuneSCount, runes.getAbilityPowerRuneSCount());
		values.put(KEY_AbilityPowerRuneGCount, runes.getAbilityPowerRuneGCount());
		values.put(KEY_AbilityPowerRuneQCount, runes.getAbilityPowerRuneQCount());
		values.put(KEY_AbilityPowerScalingRuneMCount, runes.getAbilityPowerScalingRuneMCount());
		values.put(KEY_AbilityPowerScalingRuneSCount, runes.getAbilityPowerScalingRuneSCount());
		values.put(KEY_AbilityPowerScalingRuneGCount, runes.getAbilityPowerScalingRuneGCount());
		values.put(KEY_AbilityPowerScalingRuneQCount, runes.getAbilityPowerScalingRuneQCount());
		values.put(KEY_ArmorRuneMCount, runes.getArmorRuneMCount());
		values.put(KEY_ArmorRuneSCount, runes.getArmorRuneSCount());
		values.put(KEY_ArmorRuneGCount, runes.getArmorRuneGCount());
		values.put(KEY_ArmorRuneQCount, runes.getArmorRuneQCount());
		values.put(KEY_ArmorScalingRuneSCount, runes.getArmorScalingRuneSCount());
		values.put(KEY_ArmorScalingRuneQCount, runes.getArmorScalingRuneQCount());
		values.put(KEY_ArmorPenetrationRuneMCount, runes.getArmorPenetrationRuneMCount());
		values.put(KEY_ArmorPenetrationRuneQCount, runes.getArmorPenetrationRuneQCount());
		values.put(KEY_AttackDamageRuneMCount, runes.getAttackDamageRuneMCount());
		values.put(KEY_AttackDamageRuneSCount, runes.getAttackDamageRuneSCount());
		values.put(KEY_AttackDamageRuneGCount, runes.getAttackDamageRuneGCount());
		values.put(KEY_AttackDamageRuneQCount, runes.getAttackDamageRuneQCount());
		values.put(KEY_AttackDamageScalingRuneMCount, runes.getAttackDamageScalingRuneMCount());
		values.put(KEY_AttackDamageScalingRuneSCount, runes.getAttackDamageScalingRuneSCount());
		values.put(KEY_AttackDamageScalingRuneGCount, runes.getAttackDamageScalingRuneGCount());
		values.put(KEY_AttackDamageScalingRuneQCount, runes.getAttackDamageScalingRuneQCount());
		values.put(KEY_AttackSpeedRuneMCount, runes.getAttackSpeedRuneMCount());
		values.put(KEY_AttackSpeedRuneSCount, runes.getAttackSpeedRuneSCount());
		values.put(KEY_AttackSpeedRuneGCount, runes.getAttackSpeedRuneGCount());
		values.put(KEY_AttackSpeedRuneQCount, runes.getAttackSpeedRuneQCount());
		values.put(KEY_CooldownReductionRuneMCount, runes.getCooldownReductionRuneMCount());
		values.put(KEY_CooldownReductionRuneSCount, runes.getCooldownReductionRuneSCount());
		values.put(KEY_CooldownReductionRuneGCount, runes.getCooldownReductionRuneGCount());
		values.put(KEY_CooldownReductionRuneQCount, runes.getCooldownReductionRuneQCount());
		values.put(KEY_CooldownReductionScalingRuneGCount, runes.getCooldownReductionScalingRuneGCount());
		values.put(KEY_CooldownReductionScalingRuneQCount, runes.getCooldownReductionScalingRuneQCount());
		values.put(KEY_CriticalChanceRuneMCount, runes.getCriticalChanceRuneMCount());
		values.put(KEY_CriticalChanceRuneSCount, runes.getCriticalChanceRuneSCount());
		values.put(KEY_CriticalChanceRuneGCount, runes.getCriticalChanceRuneGCount());
		values.put(KEY_CriticalChanceRuneQCount, runes.getCriticalChanceRuneQCount());
		values.put(KEY_CriticalDamageRuneMCount, runes.getCriticalDamageRuneMCount());
		values.put(KEY_CriticalDamageRuneSCount, runes.getCriticalDamageRuneSCount());
		values.put(KEY_CriticalDamageRuneGCount, runes.getCriticalDamageRuneGCount());
		values.put(KEY_CriticalDamageRuneQCount, runes.getCriticalDamageRuneQCount());
		values.put(KEY_EnergyRuneGCount, runes.getEnergyRuneGCount());
		values.put(KEY_EnergyRuneQCount, runes.getEnergyRuneQCount());
		values.put(KEY_EnergyScalingRuneGCount, runes.getEnergyScalingRuneGCount());
		values.put(KEY_EnergyRegenRuneSCount, runes.getEnergyRegenRuneSCount());
		values.put(KEY_EnergyRegenRuneQCount, runes.getEnergyRegenRuneQCount());
		values.put(KEY_EnergyRegenScalingRuneSCount, runes.getEnergyRegenScalingRuneSCount());
		values.put(KEY_HealthRuneMCount, runes.getHealthRuneMCount());
		values.put(KEY_HealthRuneSCount, runes.getHealthRuneSCount());
		values.put(KEY_HealthRuneGCount, runes.getHealthRuneGCount());
		values.put(KEY_HealthRuneQCount, runes.getHealthRuneQCount());
		values.put(KEY_HealthScalingRuneMCount, runes.getHealthScalingRuneMCount());
		values.put(KEY_HealthScalingRuneSCount, runes.getHealthScalingRuneSCount());
		values.put(KEY_HealthScalingRuneGCount, runes.getHealthScalingRuneGCount());
		values.put(KEY_HealthScalingRuneQCount, runes.getHealthScalingRuneQCount());
		values.put(KEY_HealthPercentRuneSCount, runes.getHealthPercentRuneSCount());
		values.put(KEY_HealthPercentRuneQCount, runes.getHealthPercentRuneQCount());
		values.put(KEY_HealthRegenRuneSCount, runes.getHealthRegenRuneSCount());
		values.put(KEY_HealthRegenRuneGCount, runes.getHealthRegenRuneGCount());
		values.put(KEY_HealthRegenRuneQCount, runes.getHealthRegenRuneQCount());
		values.put(KEY_HealthRegenScalingRuneSCount, runes.getHealthRegenScalingRuneSCount());
		values.put(KEY_HealthRegenScalingRuneQCount, runes.getHealthRegenScalingRuneQCount());
		values.put(KEY_HybridPenetrationRuneMCount, runes.getHybridPenetrationRuneMCount());
		values.put(KEY_HybridPenetrationRuneQCount, runes.getHybridPenetrationRuneQCount());
		values.put(KEY_LifeStealRuneQCount, runes.getLifeStealRuneQCount());
		values.put(KEY_MagicPenetrationRuneMCount, runes.getMagicPenetrationRuneMCount());
		values.put(KEY_MagicPenetrationRuneGCount, runes.getMagicPenetrationRuneGCount());
		values.put(KEY_MagicPenetrationRuneQCount, runes.getMagicPenetrationRuneQCount());
		values.put(KEY_MagicResistRuneMCount, runes.getMagicResistRuneMCount());
		values.put(KEY_MagicResistRuneSCount, runes.getMagicResistRuneSCount());
		values.put(KEY_MagicResistRuneGCount, runes.getMagicResistRuneGCount());
		values.put(KEY_MagicResistRuneQCount, runes.getMagicResistRuneQCount());
		values.put(KEY_MagicResistScalingRuneMCount, runes.getMagicResistScalingRuneMCount());
		values.put(KEY_MagicResistScalingRuneSCount, runes.getMagicResistScalingRuneSCount());
		values.put(KEY_MagicResistScalingRuneGCount, runes.getMagicResistScalingRuneGCount());
		values.put(KEY_MagicResistScalingRuneQCount, runes.getMagicResistScalingRuneQCount());
		values.put(KEY_ManaRuneMCount, runes.getManaRuneMCount());
		values.put(KEY_ManaRuneSCount, runes.getManaRuneSCount());
		values.put(KEY_ManaRuneGCount, runes.getManaRuneGCount());
		values.put(KEY_ManaRuneQCount, runes.getManaRuneQCount());
		values.put(KEY_ManaScalingRuneMCount, runes.getManaScalingRuneMCount());
		values.put(KEY_ManaScalingRuneSCount, runes.getManaScalingRuneSCount());
		values.put(KEY_ManaScalingRuneGCount, runes.getManaScalingRuneGCount());
		values.put(KEY_ManaScalingRuneQCount, runes.getManaScalingRuneQCount());
		values.put(KEY_ManaRegenRuneMCount, runes.getManaRegenRuneMCount());
		values.put(KEY_ManaRegenRuneSCount, runes.getManaRegenRuneSCount());
		values.put(KEY_ManaRegenRuneGCount, runes.getManaRegenRuneGCount());
		values.put(KEY_ManaRegenRuneQCount, runes.getManaRegenRuneQCount());
		values.put(KEY_ManaRegenScalingRuneSCount, runes.getManaRegenScalingRuneSCount());
		values.put(KEY_ManaRegenScalingRuneGCount, runes.getManaRegenScalingRuneGCount());
		values.put(KEY_ManaRegenScalingRuneQCount, runes.getManaRegenScalingRuneQCount());
		values.put(KEY_MovementSpeedRuneQCount, runes.getMovementSpeedRuneQCount());
		values.put(KEY_SpellVampRuneQCount, runes.getSpellVampRuneQCount());
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // updating row
        return db.update(TABLE_RUNES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(runes.getID()) });
    }
 
    // Deleting single rune page
    public void deleteRune(SavedElementsRunes runes) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RUNES, KEY_ID + " = ?",
                new String[] { String.valueOf(runes.getID()) });
        db.close();
    }
 
 
    // Getting Rune Page Count
    public int getRuneCount() {
        String countQuery = "SELECT  * FROM " + TABLE_RUNES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();
 
        // return count
        return cursor.getCount();
    }
    
    
    
    
    
    
    
	
	


    
 // Adding new Build
    void addBuild(SavedElementsBuilds build) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_BUILDNAME, build.getName());
        values.put(KEY_CHAMPION_INPUT, build.getChampionInputString());
        values.put(KEY_ITEM_INPUT, build.getItemInputString());
        values.put(KEY_MASTERY_INPUT, build.getMasteryInputString());
        values.put(KEY_RUNE_INPUT, build.getRuneInputString());
        
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Inserting Row
        db.insert(TABLE_BUILDS, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single Build
    SavedElementsBuilds getBuild(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_BUILDS, new String[] { KEY_ID,
        		KEY_BUILDNAME, KEY_CHAMPION_INPUT, KEY_ITEM_INPUT , KEY_MASTERY_INPUT , KEY_RUNE_INPUT }, KEY_ID + "=?",//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        SavedElementsBuilds build = new SavedElementsBuilds(Integer.parseInt(cursor.getString(0)),
        		cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        cursor.close();
        db.close();
        return build;
    }
     
    // Getting All Builds
    public List<SavedElementsBuilds> getAllBuilds() {
        List<SavedElementsBuilds> buildList = new ArrayList<SavedElementsBuilds>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BUILDS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SavedElementsBuilds builds = new SavedElementsBuilds();
                builds.setID(Integer.parseInt(cursor.getString(0)));
                builds.setName(cursor.getString(1));
                builds.setChampionInputString(cursor.getString(2));
                builds.setItemInputString(cursor.getString(3));
                builds.setMasteryInputString(cursor.getString(4));
                builds.setRuneInputString(cursor.getString(5));
                
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Adding builds to list
                buildList.add(builds);
            } while (cursor.moveToNext());
        }
 
        // return build list
        cursor.close();
        db.close();
        return buildList;
    }
 
    // Updating single build
    public int updateBuilds(SavedElementsBuilds builds) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_BUILDNAME, builds.getName());
        values.put(KEY_CHAMPION_INPUT, builds.getChampionInputString());
        values.put(KEY_ITEM_INPUT, builds.getItemInputString());
        values.put(KEY_MASTERY_INPUT, builds.getMasteryInputString());
        values.put(KEY_RUNE_INPUT, builds.getRuneInputString());
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // updating row
        return db.update(TABLE_BUILDS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(builds.getID()) });
    }
 
    // Deleting single build
    public void deleteBuild(SavedElementsBuilds build) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BUILDS, KEY_ID + " = ?",
                new String[] { String.valueOf(build.getID()) });
        db.close();
    }
 
 
    // Getting Build Count
    public int getBuildCount() {
        String countQuery = "SELECT  * FROM " + TABLE_BUILDS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();
 
        // return count
        return cursor.getCount();
    }
    
 
    
}










