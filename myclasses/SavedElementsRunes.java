package com.leagueoflegendscalculator.myclasses;


public class SavedElementsRunes {
	 //private variables
    int _id;
    String itemSetName;
    String AbilityPowerRuneMCount;
    String AbilityPowerRuneSCount;
    String AbilityPowerRuneGCount;
    String AbilityPowerRuneQCount;
    String AbilityPowerScalingRuneMCount;
    String AbilityPowerScalingRuneSCount;
    String AbilityPowerScalingRuneGCount;
    String AbilityPowerScalingRuneQCount;
    String ArmorRuneMCount;
    String ArmorRuneSCount;
    String ArmorRuneGCount;
    String ArmorRuneQCount;
    String ArmorScalingRuneSCount;
    String ArmorScalingRuneQCount;
    String ArmorPenetrationRuneMCount;
    String ArmorPenetrationRuneQCount;
    String AttackDamageRuneMCount;
    String AttackDamageRuneSCount;
    String AttackDamageRuneGCount;
    String AttackDamageRuneQCount;
    String AttackDamageScalingRuneMCount;
    String AttackDamageScalingRuneSCount;
    String AttackDamageScalingRuneGCount;
    String AttackDamageScalingRuneQCount;
    String AttackSpeedRuneMCount;
    String AttackSpeedRuneSCount;
    String AttackSpeedRuneGCount;
    String AttackSpeedRuneQCount;
    String CooldownReductionRuneMCount;
    String CooldownReductionRuneSCount;
    String CooldownReductionRuneGCount;
    String CooldownReductionRuneQCount;
    String CooldownReductionScalingRuneGCount;
    String CooldownReductionScalingRuneQCount;
    String CriticalChanceRuneMCount;
    String CriticalChanceRuneSCount;
    String CriticalChanceRuneGCount;
    String CriticalChanceRuneQCount;
    String CriticalDamageRuneMCount;
    String CriticalDamageRuneSCount;
    String CriticalDamageRuneGCount;
    String CriticalDamageRuneQCount;
    String EnergyRuneGCount;
    String EnergyRuneQCount;
    String EnergyScalingRuneGCount;
    String EnergyRegenRuneSCount;
    String EnergyRegenRuneQCount;
    String EnergyRegenScalingRuneSCount;
    String HealthRuneMCount;
    String HealthRuneSCount;
    String HealthRuneGCount;
    String HealthRuneQCount;
    String HealthScalingRuneMCount;
    String HealthScalingRuneSCount;
    String HealthScalingRuneGCount;
    String HealthScalingRuneQCount;
    String HealthPercentRuneSCount;
    String HealthPercentRuneQCount;
    String HealthRegenRuneSCount;
    String HealthRegenRuneGCount;
    String HealthRegenRuneQCount;
    String HealthRegenScalingRuneSCount;
    String HealthRegenScalingRuneQCount;
    String HybridPenetrationRuneMCount;
    String HybridPenetrationRuneQCount;
    String LifeStealRuneQCount;
    String MagicPenetrationRuneMCount;
    String MagicPenetrationRuneGCount;
    String MagicPenetrationRuneQCount;
    String MagicResistRuneMCount;
    String MagicResistRuneSCount;
    String MagicResistRuneGCount;
    String MagicResistRuneQCount;
    String MagicResistScalingRuneMCount;
    String MagicResistScalingRuneSCount;
    String MagicResistScalingRuneGCount;
    String MagicResistScalingRuneQCount;
    String ManaRuneMCount;
    String ManaRuneSCount;
    String ManaRuneGCount;
    String ManaRuneQCount;
    String ManaScalingRuneMCount;
    String ManaScalingRuneSCount;
    String ManaScalingRuneGCount;
    String ManaScalingRuneQCount;
    String ManaRegenRuneMCount;
    String ManaRegenRuneSCount;
    String ManaRegenRuneGCount;
    String ManaRegenRuneQCount;
    String ManaRegenScalingRuneSCount;
    String ManaRegenScalingRuneGCount;
    String ManaRegenScalingRuneQCount;
    String MovementSpeedRuneQCount;
    String SpellVampRuneQCount;

    
     
    // Empty constructor
    public SavedElementsRunes(){
    }
    
    public SavedElementsRunes(int id
    		, String itemSetName
    		, String AbilityPowerRuneMCount
    		, String AbilityPowerRuneSCount
    		, String AbilityPowerRuneGCount
    		, String AbilityPowerRuneQCount
    		, String AbilityPowerScalingRuneMCount
    		, String AbilityPowerScalingRuneSCount
    		, String AbilityPowerScalingRuneGCount
    		, String AbilityPowerScalingRuneQCount
    		, String ArmorRuneMCount
    		, String ArmorRuneSCount
    		, String ArmorRuneGCount
    		, String ArmorRuneQCount
    		, String ArmorScalingRuneSCount
    		, String ArmorScalingRuneQCount
    		, String ArmorPenetrationRuneMCount
    		, String ArmorPenetrationRuneQCount
    		, String AttackDamageRuneMCount
    		, String AttackDamageRuneSCount
    		, String AttackDamageRuneGCount
    		, String AttackDamageRuneQCount
    		, String AttackDamageScalingRuneMCount
    		, String AttackDamageScalingRuneSCount
    		, String AttackDamageScalingRuneGCount
    		, String AttackDamageScalingRuneQCount
    		, String AttackSpeedRuneMCount
    		, String AttackSpeedRuneSCount
    		, String AttackSpeedRuneGCount
    		, String AttackSpeedRuneQCount
    		, String CooldownReductionRuneMCount
    		, String CooldownReductionRuneSCount
    		, String CooldownReductionRuneGCount
    		, String CooldownReductionRuneQCount
    		, String CooldownReductionScalingRuneGCount
    		, String CooldownReductionScalingRuneQCount
    		, String CriticalChanceRuneMCount
    		, String CriticalChanceRuneSCount
    		, String CriticalChanceRuneGCount
    		, String CriticalChanceRuneQCount
    		, String CriticalDamageRuneMCount
    		, String CriticalDamageRuneSCount
    		, String CriticalDamageRuneGCount
    		, String CriticalDamageRuneQCount
    		, String EnergyRuneGCount
    		, String EnergyRuneQCount
    		, String EnergyScalingRuneGCount
    		, String EnergyRegenRuneSCount
    		, String EnergyRegenRuneQCount
    		, String EnergyRegenScalingRuneSCount
    		, String HealthRuneMCount
    		, String HealthRuneSCount
    		, String HealthRuneGCount
    		, String HealthRuneQCount
    		, String HealthScalingRuneMCount
    		, String HealthScalingRuneSCount
    		, String HealthScalingRuneGCount
    		, String HealthScalingRuneQCount
    		, String HealthPercentRuneSCount
    		, String HealthPercentRuneQCount
    		, String HealthRegenRuneSCount
    		, String HealthRegenRuneGCount
    		, String HealthRegenRuneQCount
    		, String HealthRegenScalingRuneSCount
    		, String HealthRegenScalingRuneQCount
    		, String HybridPenetrationRuneMCount
    		, String HybridPenetrationRuneQCount
    		, String LifeStealRuneQCount
    		, String MagicPenetrationRuneMCount
    		, String MagicPenetrationRuneGCount
    		, String MagicPenetrationRuneQCount
    		, String MagicResistRuneMCount
    		, String MagicResistRuneSCount
    		, String MagicResistRuneGCount
    		, String MagicResistRuneQCount
    		, String MagicResistScalingRuneMCount
    		, String MagicResistScalingRuneSCount
    		, String MagicResistScalingRuneGCount
    		, String MagicResistScalingRuneQCount
    		, String ManaRuneMCount
    		, String ManaRuneSCount
    		, String ManaRuneGCount
    		, String ManaRuneQCount
    		, String ManaScalingRuneMCount
    		, String ManaScalingRuneSCount
    		, String ManaScalingRuneGCount
    		, String ManaScalingRuneQCount
    		, String ManaRegenRuneMCount
    		, String ManaRegenRuneSCount
    		, String ManaRegenRuneGCount
    		, String ManaRegenRuneQCount
    		, String ManaRegenScalingRuneSCount
    		, String ManaRegenScalingRuneGCount
    		, String ManaRegenScalingRuneQCount
    		, String MovementSpeedRuneQCount
    		, String SpellVampRuneQCount){
        this._id = id;
        this.itemSetName = itemSetName;
        this.AbilityPowerRuneMCount = AbilityPowerRuneMCount;
        this.AbilityPowerRuneSCount = AbilityPowerRuneSCount;
        this.AbilityPowerRuneGCount = AbilityPowerRuneGCount;
        this.AbilityPowerRuneQCount = AbilityPowerRuneQCount;
        this.AbilityPowerScalingRuneMCount = AbilityPowerScalingRuneMCount;
        this.AbilityPowerScalingRuneSCount = AbilityPowerScalingRuneSCount;
        this.AbilityPowerScalingRuneGCount = AbilityPowerScalingRuneGCount;
        this.AbilityPowerScalingRuneQCount = AbilityPowerScalingRuneQCount;
        this.ArmorRuneMCount = ArmorRuneMCount;
        this.ArmorRuneSCount = ArmorRuneSCount;
        this.ArmorRuneGCount = ArmorRuneGCount;
        this.ArmorRuneQCount = ArmorRuneQCount;
        this.ArmorScalingRuneSCount = ArmorScalingRuneSCount;
        this.ArmorScalingRuneQCount = ArmorScalingRuneQCount;
        this.ArmorPenetrationRuneMCount = ArmorPenetrationRuneMCount;
        this.ArmorPenetrationRuneQCount = ArmorPenetrationRuneQCount;
        this.AttackDamageRuneMCount = AttackDamageRuneMCount;
        this.AttackDamageRuneSCount = AttackDamageRuneSCount;
        this.AttackDamageRuneGCount = AttackDamageRuneGCount;
        this.AttackDamageRuneQCount = AttackDamageRuneQCount;
        this.AttackDamageScalingRuneMCount = AttackDamageScalingRuneMCount;
        this.AttackDamageScalingRuneSCount = AttackDamageScalingRuneSCount;
        this.AttackDamageScalingRuneGCount = AttackDamageScalingRuneGCount;
        this.AttackDamageScalingRuneQCount = AttackDamageScalingRuneQCount;
        this.AttackSpeedRuneMCount = AttackSpeedRuneMCount;
        this.AttackSpeedRuneSCount = AttackSpeedRuneSCount;
        this.AttackSpeedRuneGCount = AttackSpeedRuneGCount;
        this.AttackSpeedRuneQCount = AttackSpeedRuneQCount;
        this.CooldownReductionRuneMCount = CooldownReductionRuneMCount;
        this.CooldownReductionRuneSCount = CooldownReductionRuneSCount;
        this.CooldownReductionRuneGCount = CooldownReductionRuneGCount;
        this.CooldownReductionRuneQCount = CooldownReductionRuneQCount;
        this.CooldownReductionScalingRuneGCount = CooldownReductionScalingRuneGCount;
        this.CooldownReductionScalingRuneQCount = CooldownReductionScalingRuneQCount;
        this.CriticalChanceRuneMCount = CriticalChanceRuneMCount;
        this.CriticalChanceRuneSCount = CriticalChanceRuneSCount;
        this.CriticalChanceRuneGCount = CriticalChanceRuneGCount;
        this.CriticalChanceRuneQCount = CriticalChanceRuneQCount;
        this.CriticalDamageRuneMCount = CriticalDamageRuneMCount;
        this.CriticalDamageRuneSCount = CriticalDamageRuneSCount;
        this.CriticalDamageRuneGCount = CriticalDamageRuneGCount;
        this.CriticalDamageRuneQCount = CriticalDamageRuneQCount;
        this.EnergyRuneGCount = EnergyRuneGCount;
        this.EnergyRuneQCount = EnergyRuneQCount;
        this.EnergyScalingRuneGCount = EnergyScalingRuneGCount;
        this.EnergyRegenRuneSCount = EnergyRegenRuneSCount;
        this.EnergyRegenRuneQCount = EnergyRegenRuneQCount;
        this.EnergyRegenScalingRuneSCount = EnergyRegenScalingRuneSCount;
        this.HealthRuneMCount = HealthRuneMCount;
        this.HealthRuneSCount = HealthRuneSCount;
        this.HealthRuneGCount = HealthRuneGCount;
        this.HealthRuneQCount = HealthRuneQCount;
        this.HealthScalingRuneMCount = HealthScalingRuneMCount;
        this.HealthScalingRuneSCount = HealthScalingRuneSCount;
        this.HealthScalingRuneGCount = HealthScalingRuneGCount;
        this.HealthScalingRuneQCount = HealthScalingRuneQCount;
        this.HealthPercentRuneSCount = HealthPercentRuneSCount;
        this.HealthPercentRuneQCount = HealthPercentRuneQCount;
        this.HealthRegenRuneSCount = HealthRegenRuneSCount;
        this.HealthRegenRuneGCount = HealthRegenRuneGCount;
        this.HealthRegenRuneQCount = HealthRegenRuneQCount;
        this.HealthRegenScalingRuneSCount = HealthRegenScalingRuneSCount;
        this.HealthRegenScalingRuneQCount = HealthRegenScalingRuneQCount;
        this.HybridPenetrationRuneMCount = HybridPenetrationRuneMCount;
        this.HybridPenetrationRuneQCount = HybridPenetrationRuneQCount;
        this.LifeStealRuneQCount = LifeStealRuneQCount;
        this.MagicPenetrationRuneMCount = MagicPenetrationRuneMCount;
        this.MagicPenetrationRuneGCount = MagicPenetrationRuneGCount;
        this.MagicPenetrationRuneQCount = MagicPenetrationRuneQCount;
        this.MagicResistRuneMCount = MagicResistRuneMCount;
        this.MagicResistRuneSCount = MagicResistRuneSCount;
        this.MagicResistRuneGCount = MagicResistRuneGCount;
        this.MagicResistRuneQCount = MagicResistRuneQCount;
        this.MagicResistScalingRuneMCount = MagicResistScalingRuneMCount;
        this.MagicResistScalingRuneSCount = MagicResistScalingRuneSCount;
        this.MagicResistScalingRuneGCount = MagicResistScalingRuneGCount;
        this.MagicResistScalingRuneQCount = MagicResistScalingRuneQCount;
        this.ManaRuneMCount = ManaRuneMCount;
        this.ManaRuneSCount = ManaRuneSCount;
        this.ManaRuneGCount = ManaRuneGCount;
        this.ManaRuneQCount = ManaRuneQCount;
        this.ManaScalingRuneMCount = ManaScalingRuneMCount;
        this.ManaScalingRuneSCount = ManaScalingRuneSCount;
        this.ManaScalingRuneGCount = ManaScalingRuneGCount;
        this.ManaScalingRuneQCount = ManaScalingRuneQCount;
        this.ManaRegenRuneMCount = ManaRegenRuneMCount;
        this.ManaRegenRuneSCount = ManaRegenRuneSCount;
        this.ManaRegenRuneGCount = ManaRegenRuneGCount;
        this.ManaRegenRuneQCount = ManaRegenRuneQCount;
        this.ManaRegenScalingRuneSCount = ManaRegenScalingRuneSCount;
        this.ManaRegenScalingRuneGCount = ManaRegenScalingRuneGCount;
        this.ManaRegenScalingRuneQCount = ManaRegenScalingRuneQCount;
        this.MovementSpeedRuneQCount = MovementSpeedRuneQCount;
        this.SpellVampRuneQCount = SpellVampRuneQCount;

        
    }
     
    public SavedElementsRunes(String itemSetName, String AbilityPowerRuneMCount
    		, String AbilityPowerRuneSCount
    		, String AbilityPowerRuneGCount
    		, String AbilityPowerRuneQCount
    		, String AbilityPowerScalingRuneMCount
    		, String AbilityPowerScalingRuneSCount
    		, String AbilityPowerScalingRuneGCount
    		, String AbilityPowerScalingRuneQCount
    		, String ArmorRuneMCount
    		, String ArmorRuneSCount
    		, String ArmorRuneGCount
    		, String ArmorRuneQCount
    		, String ArmorScalingRuneSCount
    		, String ArmorScalingRuneQCount
    		, String ArmorPenetrationRuneMCount
    		, String ArmorPenetrationRuneQCount
    		, String AttackDamageRuneMCount
    		, String AttackDamageRuneSCount
    		, String AttackDamageRuneGCount
    		, String AttackDamageRuneQCount
    		, String AttackDamageScalingRuneMCount
    		, String AttackDamageScalingRuneSCount
    		, String AttackDamageScalingRuneGCount
    		, String AttackDamageScalingRuneQCount
    		, String AttackSpeedRuneMCount
    		, String AttackSpeedRuneSCount
    		, String AttackSpeedRuneGCount
    		, String AttackSpeedRuneQCount
    		, String CooldownReductionRuneMCount
    		, String CooldownReductionRuneSCount
    		, String CooldownReductionRuneGCount
    		, String CooldownReductionRuneQCount
    		, String CooldownReductionScalingRuneGCount
    		, String CooldownReductionScalingRuneQCount
    		, String CriticalChanceRuneMCount
    		, String CriticalChanceRuneSCount
    		, String CriticalChanceRuneGCount
    		, String CriticalChanceRuneQCount
    		, String CriticalDamageRuneMCount
    		, String CriticalDamageRuneSCount
    		, String CriticalDamageRuneGCount
    		, String CriticalDamageRuneQCount
    		, String EnergyRuneGCount
    		, String EnergyRuneQCount
    		, String EnergyScalingRuneGCount
    		, String EnergyRegenRuneSCount
    		, String EnergyRegenRuneQCount
    		, String EnergyRegenScalingRuneSCount
    		, String HealthRuneMCount
    		, String HealthRuneSCount
    		, String HealthRuneGCount
    		, String HealthRuneQCount
    		, String HealthScalingRuneMCount
    		, String HealthScalingRuneSCount
    		, String HealthScalingRuneGCount
    		, String HealthScalingRuneQCount
    		, String HealthPercentRuneSCount
    		, String HealthPercentRuneQCount
    		, String HealthRegenRuneSCount
    		, String HealthRegenRuneGCount
    		, String HealthRegenRuneQCount
    		, String HealthRegenScalingRuneSCount
    		, String HealthRegenScalingRuneQCount
    		, String HybridPenetrationRuneMCount
    		, String HybridPenetrationRuneQCount
    		, String LifeStealRuneQCount
    		, String MagicPenetrationRuneMCount
    		, String MagicPenetrationRuneGCount
    		, String MagicPenetrationRuneQCount
    		, String MagicResistRuneMCount
    		, String MagicResistRuneSCount
    		, String MagicResistRuneGCount
    		, String MagicResistRuneQCount
    		, String MagicResistScalingRuneMCount
    		, String MagicResistScalingRuneSCount
    		, String MagicResistScalingRuneGCount
    		, String MagicResistScalingRuneQCount
    		, String ManaRuneMCount
    		, String ManaRuneSCount
    		, String ManaRuneGCount
    		, String ManaRuneQCount
    		, String ManaScalingRuneMCount
    		, String ManaScalingRuneSCount
    		, String ManaScalingRuneGCount
    		, String ManaScalingRuneQCount
    		, String ManaRegenRuneMCount
    		, String ManaRegenRuneSCount
    		, String ManaRegenRuneGCount
    		, String ManaRegenRuneQCount
    		, String ManaRegenScalingRuneSCount
    		, String ManaRegenScalingRuneGCount
    		, String ManaRegenScalingRuneQCount
    		, String MovementSpeedRuneQCount
    		, String SpellVampRuneQCount){
        this.itemSetName = itemSetName;
        this.AbilityPowerRuneMCount = AbilityPowerRuneMCount;
        this.AbilityPowerRuneSCount = AbilityPowerRuneSCount;
        this.AbilityPowerRuneGCount = AbilityPowerRuneGCount;
        this.AbilityPowerRuneQCount = AbilityPowerRuneQCount;
        this.AbilityPowerScalingRuneMCount = AbilityPowerScalingRuneMCount;
        this.AbilityPowerScalingRuneSCount = AbilityPowerScalingRuneSCount;
        this.AbilityPowerScalingRuneGCount = AbilityPowerScalingRuneGCount;
        this.AbilityPowerScalingRuneQCount = AbilityPowerScalingRuneQCount;
        this.ArmorRuneMCount = ArmorRuneMCount;
        this.ArmorRuneSCount = ArmorRuneSCount;
        this.ArmorRuneGCount = ArmorRuneGCount;
        this.ArmorRuneQCount = ArmorRuneQCount;
        this.ArmorScalingRuneSCount = ArmorScalingRuneSCount;
        this.ArmorScalingRuneQCount = ArmorScalingRuneQCount;
        this.ArmorPenetrationRuneMCount = ArmorPenetrationRuneMCount;
        this.ArmorPenetrationRuneQCount = ArmorPenetrationRuneQCount;
        this.AttackDamageRuneMCount = AttackDamageRuneMCount;
        this.AttackDamageRuneSCount = AttackDamageRuneSCount;
        this.AttackDamageRuneGCount = AttackDamageRuneGCount;
        this.AttackDamageRuneQCount = AttackDamageRuneQCount;
        this.AttackDamageScalingRuneMCount = AttackDamageScalingRuneMCount;
        this.AttackDamageScalingRuneSCount = AttackDamageScalingRuneSCount;
        this.AttackDamageScalingRuneGCount = AttackDamageScalingRuneGCount;
        this.AttackDamageScalingRuneQCount = AttackDamageScalingRuneQCount;
        this.AttackSpeedRuneMCount = AttackSpeedRuneMCount;
        this.AttackSpeedRuneSCount = AttackSpeedRuneSCount;
        this.AttackSpeedRuneGCount = AttackSpeedRuneGCount;
        this.AttackSpeedRuneQCount = AttackSpeedRuneQCount;
        this.CooldownReductionRuneMCount = CooldownReductionRuneMCount;
        this.CooldownReductionRuneSCount = CooldownReductionRuneSCount;
        this.CooldownReductionRuneGCount = CooldownReductionRuneGCount;
        this.CooldownReductionRuneQCount = CooldownReductionRuneQCount;
        this.CooldownReductionScalingRuneGCount = CooldownReductionScalingRuneGCount;
        this.CooldownReductionScalingRuneQCount = CooldownReductionScalingRuneQCount;
        this.CriticalChanceRuneMCount = CriticalChanceRuneMCount;
        this.CriticalChanceRuneSCount = CriticalChanceRuneSCount;
        this.CriticalChanceRuneGCount = CriticalChanceRuneGCount;
        this.CriticalChanceRuneQCount = CriticalChanceRuneQCount;
        this.CriticalDamageRuneMCount = CriticalDamageRuneMCount;
        this.CriticalDamageRuneSCount = CriticalDamageRuneSCount;
        this.CriticalDamageRuneGCount = CriticalDamageRuneGCount;
        this.CriticalDamageRuneQCount = CriticalDamageRuneQCount;
        this.EnergyRuneGCount = EnergyRuneGCount;
        this.EnergyRuneQCount = EnergyRuneQCount;
        this.EnergyScalingRuneGCount = EnergyScalingRuneGCount;
        this.EnergyRegenRuneSCount = EnergyRegenRuneSCount;
        this.EnergyRegenRuneQCount = EnergyRegenRuneQCount;
        this.EnergyRegenScalingRuneSCount = EnergyRegenScalingRuneSCount;
        this.HealthRuneMCount = HealthRuneMCount;
        this.HealthRuneSCount = HealthRuneSCount;
        this.HealthRuneGCount = HealthRuneGCount;
        this.HealthRuneQCount = HealthRuneQCount;
        this.HealthScalingRuneMCount = HealthScalingRuneMCount;
        this.HealthScalingRuneSCount = HealthScalingRuneSCount;
        this.HealthScalingRuneGCount = HealthScalingRuneGCount;
        this.HealthScalingRuneQCount = HealthScalingRuneQCount;
        this.HealthPercentRuneSCount = HealthPercentRuneSCount;
        this.HealthPercentRuneQCount = HealthPercentRuneQCount;
        this.HealthRegenRuneSCount = HealthRegenRuneSCount;
        this.HealthRegenRuneGCount = HealthRegenRuneGCount;
        this.HealthRegenRuneQCount = HealthRegenRuneQCount;
        this.HealthRegenScalingRuneSCount = HealthRegenScalingRuneSCount;
        this.HealthRegenScalingRuneQCount = HealthRegenScalingRuneQCount;
        this.HybridPenetrationRuneMCount = HybridPenetrationRuneMCount;
        this.HybridPenetrationRuneQCount = HybridPenetrationRuneQCount;
        this.LifeStealRuneQCount = LifeStealRuneQCount;
        this.MagicPenetrationRuneMCount = MagicPenetrationRuneMCount;
        this.MagicPenetrationRuneGCount = MagicPenetrationRuneGCount;
        this.MagicPenetrationRuneQCount = MagicPenetrationRuneQCount;
        this.MagicResistRuneMCount = MagicResistRuneMCount;
        this.MagicResistRuneSCount = MagicResistRuneSCount;
        this.MagicResistRuneGCount = MagicResistRuneGCount;
        this.MagicResistRuneQCount = MagicResistRuneQCount;
        this.MagicResistScalingRuneMCount = MagicResistScalingRuneMCount;
        this.MagicResistScalingRuneSCount = MagicResistScalingRuneSCount;
        this.MagicResistScalingRuneGCount = MagicResistScalingRuneGCount;
        this.MagicResistScalingRuneQCount = MagicResistScalingRuneQCount;
        this.ManaRuneMCount = ManaRuneMCount;
        this.ManaRuneSCount = ManaRuneSCount;
        this.ManaRuneGCount = ManaRuneGCount;
        this.ManaRuneQCount = ManaRuneQCount;
        this.ManaScalingRuneMCount = ManaScalingRuneMCount;
        this.ManaScalingRuneSCount = ManaScalingRuneSCount;
        this.ManaScalingRuneGCount = ManaScalingRuneGCount;
        this.ManaScalingRuneQCount = ManaScalingRuneQCount;
        this.ManaRegenRuneMCount = ManaRegenRuneMCount;
        this.ManaRegenRuneSCount = ManaRegenRuneSCount;
        this.ManaRegenRuneGCount = ManaRegenRuneGCount;
        this.ManaRegenRuneQCount = ManaRegenRuneQCount;
        this.ManaRegenScalingRuneSCount = ManaRegenScalingRuneSCount;
        this.ManaRegenScalingRuneGCount = ManaRegenScalingRuneGCount;
        this.ManaRegenScalingRuneQCount = ManaRegenScalingRuneQCount;
        this.MovementSpeedRuneQCount = MovementSpeedRuneQCount;
        this.SpellVampRuneQCount = SpellVampRuneQCount;
            }
    
    public int getID(){
        return this._id;
    }
    public void setID(int id){
        this._id = id;
    }
    public String getName(){
        return this.itemSetName;
    }
    public void setName(String itemSetName){
        this.itemSetName = itemSetName;
    }
    
    
	public String getAbilityPowerRuneMCount(){
	    return this.AbilityPowerRuneMCount;
	}
	public void setAbilityPowerRuneMCount(String AbilityPowerRuneMCount){
	    this.AbilityPowerRuneMCount = AbilityPowerRuneMCount;
	}
	public String getAbilityPowerRuneSCount(){
	    return this.AbilityPowerRuneSCount;
	}
	public void setAbilityPowerRuneSCount(String AbilityPowerRuneSCount){
	    this.AbilityPowerRuneSCount = AbilityPowerRuneSCount;
	}
	public String getAbilityPowerRuneGCount(){
	    return this.AbilityPowerRuneGCount;
	}
	public void setAbilityPowerRuneGCount(String AbilityPowerRuneGCount){
	    this.AbilityPowerRuneGCount = AbilityPowerRuneGCount;
	}
	public String getAbilityPowerRuneQCount(){
	    return this.AbilityPowerRuneQCount;
	}
	public void setAbilityPowerRuneQCount(String AbilityPowerRuneQCount){
	    this.AbilityPowerRuneQCount = AbilityPowerRuneQCount;
	}
	public String getAbilityPowerScalingRuneMCount(){
	    return this.AbilityPowerScalingRuneMCount;
	}
	public void setAbilityPowerScalingRuneMCount(String AbilityPowerScalingRuneMCount)
	{
	    this.AbilityPowerScalingRuneMCount = AbilityPowerScalingRuneMCount;
	}
	public String getAbilityPowerScalingRuneSCount(){
	    return this.AbilityPowerScalingRuneSCount;
	}
	public void setAbilityPowerScalingRuneSCount(String AbilityPowerScalingRuneSCount)
	{
	    this.AbilityPowerScalingRuneSCount = AbilityPowerScalingRuneSCount;
	}
	public String getAbilityPowerScalingRuneGCount(){
	    return this.AbilityPowerScalingRuneGCount;
	}
	public void setAbilityPowerScalingRuneGCount(String AbilityPowerScalingRuneGCount)
	{
	    this.AbilityPowerScalingRuneGCount = AbilityPowerScalingRuneGCount;
	}
	public String getAbilityPowerScalingRuneQCount(){
	    return this.AbilityPowerScalingRuneQCount;
	}
	public void setAbilityPowerScalingRuneQCount(String AbilityPowerScalingRuneQCount)
	{
	    this.AbilityPowerScalingRuneQCount = AbilityPowerScalingRuneQCount;
	}
	public String getArmorRuneMCount(){
	    return this.ArmorRuneMCount;
	}
	public void setArmorRuneMCount(String ArmorRuneMCount){
	    this.ArmorRuneMCount = ArmorRuneMCount;
	}
	public String getArmorRuneSCount(){
	    return this.ArmorRuneSCount;
	}
	public void setArmorRuneSCount(String ArmorRuneSCount){
	    this.ArmorRuneSCount = ArmorRuneSCount;
	}
	public String getArmorRuneGCount(){
	    return this.ArmorRuneGCount;
	}
	public void setArmorRuneGCount(String ArmorRuneGCount){
	    this.ArmorRuneGCount = ArmorRuneGCount;
	}
	public String getArmorRuneQCount(){
	    return this.ArmorRuneQCount;
	}
	public void setArmorRuneQCount(String ArmorRuneQCount){
	    this.ArmorRuneQCount = ArmorRuneQCount;
	}
	public String getArmorScalingRuneSCount(){
	    return this.ArmorScalingRuneSCount;
	}
	public void setArmorScalingRuneSCount(String ArmorScalingRuneSCount){
	    this.ArmorScalingRuneSCount = ArmorScalingRuneSCount;
	}
	public String getArmorScalingRuneQCount(){
	    return this.ArmorScalingRuneQCount;
	}
	public void setArmorScalingRuneQCount(String ArmorScalingRuneQCount){
	    this.ArmorScalingRuneQCount = ArmorScalingRuneQCount;
	}
	public String getArmorPenetrationRuneMCount(){
	    return this.ArmorPenetrationRuneMCount;
	}
	public void setArmorPenetrationRuneMCount(String ArmorPenetrationRuneMCount){
	    this.ArmorPenetrationRuneMCount = ArmorPenetrationRuneMCount;
	}
	public String getArmorPenetrationRuneQCount(){
	    return this.ArmorPenetrationRuneQCount;
	}
	public void setArmorPenetrationRuneQCount(String ArmorPenetrationRuneQCount){
	    this.ArmorPenetrationRuneQCount = ArmorPenetrationRuneQCount;
	}
	public String getAttackDamageRuneMCount(){
	    return this.AttackDamageRuneMCount;
	}
	public void setAttackDamageRuneMCount(String AttackDamageRuneMCount){
	    this.AttackDamageRuneMCount = AttackDamageRuneMCount;
	}
	public String getAttackDamageRuneSCount(){
	    return this.AttackDamageRuneSCount;
	}
	public void setAttackDamageRuneSCount(String AttackDamageRuneSCount){
	    this.AttackDamageRuneSCount = AttackDamageRuneSCount;
	}
	public String getAttackDamageRuneGCount(){
	    return this.AttackDamageRuneGCount;
	}
	public void setAttackDamageRuneGCount(String AttackDamageRuneGCount){
	    this.AttackDamageRuneGCount = AttackDamageRuneGCount;
	}
	public String getAttackDamageRuneQCount(){
	    return this.AttackDamageRuneQCount;
	}
	public void setAttackDamageRuneQCount(String AttackDamageRuneQCount){
	    this.AttackDamageRuneQCount = AttackDamageRuneQCount;
	}
	public String getAttackDamageScalingRuneMCount(){
	    return this.AttackDamageScalingRuneMCount;
	}
	public void setAttackDamageScalingRuneMCount(String AttackDamageScalingRuneMCount)
	{
	    this.AttackDamageScalingRuneMCount = AttackDamageScalingRuneMCount;
	}
	public String getAttackDamageScalingRuneSCount(){
	    return this.AttackDamageScalingRuneSCount;
	}
	public void setAttackDamageScalingRuneSCount(String AttackDamageScalingRuneSCount)
	{
	    this.AttackDamageScalingRuneSCount = AttackDamageScalingRuneSCount;
	}
	public String getAttackDamageScalingRuneGCount(){
	    return this.AttackDamageScalingRuneGCount;
	}
	public void setAttackDamageScalingRuneGCount(String AttackDamageScalingRuneGCount)
	{
	    this.AttackDamageScalingRuneGCount = AttackDamageScalingRuneGCount;
	}
	public String getAttackDamageScalingRuneQCount(){
	    return this.AttackDamageScalingRuneQCount;
	}
	public void setAttackDamageScalingRuneQCount(String AttackDamageScalingRuneQCount)
	{
	    this.AttackDamageScalingRuneQCount = AttackDamageScalingRuneQCount;
	}
	public String getAttackSpeedRuneMCount(){
	    return this.AttackSpeedRuneMCount;
	}
	public void setAttackSpeedRuneMCount(String AttackSpeedRuneMCount){
	    this.AttackSpeedRuneMCount = AttackSpeedRuneMCount;
	}
	public String getAttackSpeedRuneSCount(){
	    return this.AttackSpeedRuneSCount;
	}
	public void setAttackSpeedRuneSCount(String AttackSpeedRuneSCount){
	    this.AttackSpeedRuneSCount = AttackSpeedRuneSCount;
	}
	public String getAttackSpeedRuneGCount(){
	    return this.AttackSpeedRuneGCount;
	}
	public void setAttackSpeedRuneGCount(String AttackSpeedRuneGCount){
	    this.AttackSpeedRuneGCount = AttackSpeedRuneGCount;
	}
	public String getAttackSpeedRuneQCount(){
	    return this.AttackSpeedRuneQCount;
	}
	public void setAttackSpeedRuneQCount(String AttackSpeedRuneQCount){
	    this.AttackSpeedRuneQCount = AttackSpeedRuneQCount;
	}
	public String getCooldownReductionRuneMCount(){
	    return this.CooldownReductionRuneMCount;
	}
	public void setCooldownReductionRuneMCount(String CooldownReductionRuneMCount){
	    this.CooldownReductionRuneMCount = CooldownReductionRuneMCount;
	}
	public String getCooldownReductionRuneSCount(){
	    return this.CooldownReductionRuneSCount;
	}
	public void setCooldownReductionRuneSCount(String CooldownReductionRuneSCount){
	    this.CooldownReductionRuneSCount = CooldownReductionRuneSCount;
	}
	public String getCooldownReductionRuneGCount(){
	    return this.CooldownReductionRuneGCount;
	}
	public void setCooldownReductionRuneGCount(String CooldownReductionRuneGCount){
	    this.CooldownReductionRuneGCount = CooldownReductionRuneGCount;
	}
	public String getCooldownReductionRuneQCount(){
	    return this.CooldownReductionRuneQCount;
	}
	public void setCooldownReductionRuneQCount(String CooldownReductionRuneQCount){
	    this.CooldownReductionRuneQCount = CooldownReductionRuneQCount;
	}
	public String getCooldownReductionScalingRuneGCount(){
	    return this.CooldownReductionScalingRuneGCount;
	}
	public void setCooldownReductionScalingRuneGCount(String CooldownReductionScalingRuneGCount){
	    this.CooldownReductionScalingRuneGCount = CooldownReductionScalingRuneGCount;
	}
	public String getCooldownReductionScalingRuneQCount(){
	    return this.CooldownReductionScalingRuneQCount;
	}
	public void setCooldownReductionScalingRuneQCount(String CooldownReductionScalingRuneQCount){
	    this.CooldownReductionScalingRuneQCount = CooldownReductionScalingRuneQCount;
	}
	public String getCriticalChanceRuneMCount(){
	    return this.CriticalChanceRuneMCount;
	}
	public void setCriticalChanceRuneMCount(String CriticalChanceRuneMCount){
	    this.CriticalChanceRuneMCount = CriticalChanceRuneMCount;
	}
	public String getCriticalChanceRuneSCount(){
	    return this.CriticalChanceRuneSCount;
	}
	public void setCriticalChanceRuneSCount(String CriticalChanceRuneSCount){
	    this.CriticalChanceRuneSCount = CriticalChanceRuneSCount;
	}
	public String getCriticalChanceRuneGCount(){
	    return this.CriticalChanceRuneGCount;
	}
	public void setCriticalChanceRuneGCount(String CriticalChanceRuneGCount){
	    this.CriticalChanceRuneGCount = CriticalChanceRuneGCount;
	}
	public String getCriticalChanceRuneQCount(){
	    return this.CriticalChanceRuneQCount;
	}
	public void setCriticalChanceRuneQCount(String CriticalChanceRuneQCount){
	    this.CriticalChanceRuneQCount = CriticalChanceRuneQCount;
	}
	public String getCriticalDamageRuneMCount(){
	    return this.CriticalDamageRuneMCount;
	}
	public void setCriticalDamageRuneMCount(String CriticalDamageRuneMCount){
	    this.CriticalDamageRuneMCount = CriticalDamageRuneMCount;
	}
	public String getCriticalDamageRuneSCount(){
	    return this.CriticalDamageRuneSCount;
	}
	public void setCriticalDamageRuneSCount(String CriticalDamageRuneSCount){
	    this.CriticalDamageRuneSCount = CriticalDamageRuneSCount;
	}
	public String getCriticalDamageRuneGCount(){
	    return this.CriticalDamageRuneGCount;
	}
	public void setCriticalDamageRuneGCount(String CriticalDamageRuneGCount){
	    this.CriticalDamageRuneGCount = CriticalDamageRuneGCount;
	}
	public String getCriticalDamageRuneQCount(){
	    return this.CriticalDamageRuneQCount;
	}
	public void setCriticalDamageRuneQCount(String CriticalDamageRuneQCount){
	    this.CriticalDamageRuneQCount = CriticalDamageRuneQCount;
	}
	public String getEnergyRuneGCount(){
	    return this.EnergyRuneGCount;
	}
	public void setEnergyRuneGCount(String EnergyRuneGCount){
	    this.EnergyRuneGCount = EnergyRuneGCount;
	}
	public String getEnergyRuneQCount(){
	    return this.EnergyRuneQCount;
	}
	public void setEnergyRuneQCount(String EnergyRuneQCount){
	    this.EnergyRuneQCount = EnergyRuneQCount;
	}
	public String getEnergyScalingRuneGCount(){
	    return this.EnergyScalingRuneGCount;
	}
	public void setEnergyScalingRuneGCount(String EnergyScalingRuneGCount){
	    this.EnergyScalingRuneGCount = EnergyScalingRuneGCount;
	}
	public String getEnergyRegenRuneSCount(){
	    return this.EnergyRegenRuneSCount;
	}
	public void setEnergyRegenRuneSCount(String EnergyRegenRuneSCount){
	    this.EnergyRegenRuneSCount = EnergyRegenRuneSCount;
	}
	public String getEnergyRegenRuneQCount(){
	    return this.EnergyRegenRuneQCount;
	}
	public void setEnergyRegenRuneQCount(String EnergyRegenRuneQCount){
	    this.EnergyRegenRuneQCount = EnergyRegenRuneQCount;
	
	}
	public String getEnergyRegenScalingRuneSCount(){
	    return this.EnergyRegenScalingRuneSCount;
	}
	public void setEnergyRegenScalingRuneSCount(String EnergyRegenScalingRuneSCount){
	    this.EnergyRegenScalingRuneSCount = EnergyRegenScalingRuneSCount;
	}
	public String getHealthRuneMCount(){
	    return this.HealthRuneMCount;
	}
	public void setHealthRuneMCount(String HealthRuneMCount){
	    this.HealthRuneMCount = HealthRuneMCount;
	}
	public String getHealthRuneSCount(){
	    return this.HealthRuneSCount;
	}
	public void setHealthRuneSCount(String HealthRuneSCount){
	    this.HealthRuneSCount = HealthRuneSCount;
	}
	public String getHealthRuneGCount(){
	    return this.HealthRuneGCount;
	}
	public void setHealthRuneGCount(String HealthRuneGCount){
	    this.HealthRuneGCount = HealthRuneGCount;
	}
	public String getHealthRuneQCount(){
	    return this.HealthRuneQCount;
	}
	public void setHealthRuneQCount(String HealthRuneQCount){
	    this.HealthRuneQCount = HealthRuneQCount;
	}
	public String getHealthScalingRuneMCount(){
	    return this.HealthScalingRuneMCount;
	}
	public void setHealthScalingRuneMCount(String HealthScalingRuneMCount){
	    this.HealthScalingRuneMCount = HealthScalingRuneMCount;
	}
	public String getHealthScalingRuneSCount(){
	    return this.HealthScalingRuneSCount;
	}
	public void setHealthScalingRuneSCount(String HealthScalingRuneSCount){
	    this.HealthScalingRuneSCount = HealthScalingRuneSCount;
	}
	public String getHealthScalingRuneGCount(){
	    return this.HealthScalingRuneGCount;
	}
	public void setHealthScalingRuneGCount(String HealthScalingRuneGCount){
	    this.HealthScalingRuneGCount = HealthScalingRuneGCount;
	}
	public String getHealthScalingRuneQCount(){
	    return this.HealthScalingRuneQCount;
	}
	public void setHealthScalingRuneQCount(String HealthScalingRuneQCount){
	    this.HealthScalingRuneQCount = HealthScalingRuneQCount;
	}
	public String getHealthPercentRuneSCount(){
	    return this.HealthPercentRuneSCount;
	}
	public void setHealthPercentRuneSCount(String HealthPercentRuneSCount){
	    this.HealthPercentRuneSCount = HealthPercentRuneSCount;
	}
	public String getHealthPercentRuneQCount(){
	    return this.HealthPercentRuneQCount;
	}
	public void setHealthPercentRuneQCount(String HealthPercentRuneQCount){
	    this.HealthPercentRuneQCount = HealthPercentRuneQCount;
	}
	public String getHealthRegenRuneSCount(){
	    return this.HealthRegenRuneSCount;
	}
	public void setHealthRegenRuneSCount(String HealthRegenRuneSCount){
	    this.HealthRegenRuneSCount = HealthRegenRuneSCount;
	}
	public String getHealthRegenRuneGCount(){
	    return this.HealthRegenRuneGCount;
	}
	public void setHealthRegenRuneGCount(String HealthRegenRuneGCount){
	    this.HealthRegenRuneGCount = HealthRegenRuneGCount;
	}
	public String getHealthRegenRuneQCount(){
	    return this.HealthRegenRuneQCount;
	}
	public void setHealthRegenRuneQCount(String HealthRegenRuneQCount){
	    this.HealthRegenRuneQCount = HealthRegenRuneQCount;
	}
	public String getHealthRegenScalingRuneSCount(){
	    return this.HealthRegenScalingRuneSCount;
	}
	public void setHealthRegenScalingRuneSCount(String HealthRegenScalingRuneSCount){
	    this.HealthRegenScalingRuneSCount = HealthRegenScalingRuneSCount;
	}
	public String getHealthRegenScalingRuneQCount(){
	    return this.HealthRegenScalingRuneQCount;
	}
	public void setHealthRegenScalingRuneQCount(String HealthRegenScalingRuneQCount){
	    this.HealthRegenScalingRuneQCount = HealthRegenScalingRuneQCount;
	}
	public String getHybridPenetrationRuneMCount(){
	    return this.HybridPenetrationRuneMCount;
	}
	public void setHybridPenetrationRuneMCount(String HybridPenetrationRuneMCount){
	    this.HybridPenetrationRuneMCount = HybridPenetrationRuneMCount;
	}
	public String getHybridPenetrationRuneQCount(){
	    return this.HybridPenetrationRuneQCount;
	}
	public void setHybridPenetrationRuneQCount(String HybridPenetrationRuneQCount){
	    this.HybridPenetrationRuneQCount = HybridPenetrationRuneQCount;
	}
	public String getLifeStealRuneQCount(){
	    return this.LifeStealRuneQCount;
	}
	public void setLifeStealRuneQCount(String LifeStealRuneQCount){
	    this.LifeStealRuneQCount = LifeStealRuneQCount;
	}
	public String getMagicPenetrationRuneMCount(){
	    return this.MagicPenetrationRuneMCount;
	}
	public void setMagicPenetrationRuneMCount(String MagicPenetrationRuneMCount){
	    this.MagicPenetrationRuneMCount = MagicPenetrationRuneMCount;
	}
	public String getMagicPenetrationRuneGCount(){
	    return this.MagicPenetrationRuneGCount;
	}
	public void setMagicPenetrationRuneGCount(String MagicPenetrationRuneGCount){
	    this.MagicPenetrationRuneGCount = MagicPenetrationRuneGCount;
	}
	public String getMagicPenetrationRuneQCount(){
	    return this.MagicPenetrationRuneQCount;
	}
	public void setMagicPenetrationRuneQCount(String MagicPenetrationRuneQCount){
	    this.MagicPenetrationRuneQCount = MagicPenetrationRuneQCount;
	}
	public String getMagicResistRuneMCount(){
	    return this.MagicResistRuneMCount;
	}
	public void setMagicResistRuneMCount(String MagicResistRuneMCount){
	    this.MagicResistRuneMCount = MagicResistRuneMCount;
	}
	public String getMagicResistRuneSCount(){
	    return this.MagicResistRuneSCount;
	}
	public void setMagicResistRuneSCount(String MagicResistRuneSCount){
	    this.MagicResistRuneSCount = MagicResistRuneSCount;
	}
	public String getMagicResistRuneGCount(){
	    return this.MagicResistRuneGCount;
	}
	public void setMagicResistRuneGCount(String MagicResistRuneGCount){
	    this.MagicResistRuneGCount = MagicResistRuneGCount;
	}
	public String getMagicResistRuneQCount(){
	    return this.MagicResistRuneQCount;
	}
	public void setMagicResistRuneQCount(String MagicResistRuneQCount){
	    this.MagicResistRuneQCount = MagicResistRuneQCount;
	}
	public String getMagicResistScalingRuneMCount(){
	    return this.MagicResistScalingRuneMCount;
	}
	public void setMagicResistScalingRuneMCount(String MagicResistScalingRuneMCount){
	    this.MagicResistScalingRuneMCount = MagicResistScalingRuneMCount;
	}
	public String getMagicResistScalingRuneSCount(){
	    return this.MagicResistScalingRuneSCount;
	}
	public void setMagicResistScalingRuneSCount(String MagicResistScalingRuneSCount){
	    this.MagicResistScalingRuneSCount = MagicResistScalingRuneSCount;
	}
	public String getMagicResistScalingRuneGCount(){
	    return this.MagicResistScalingRuneGCount;
	}
	public void setMagicResistScalingRuneGCount(String MagicResistScalingRuneGCount){
	    this.MagicResistScalingRuneGCount = MagicResistScalingRuneGCount;
	}
	public String getMagicResistScalingRuneQCount(){
	    return this.MagicResistScalingRuneQCount;
	}
	public void setMagicResistScalingRuneQCount(String MagicResistScalingRuneQCount){
	    this.MagicResistScalingRuneQCount = MagicResistScalingRuneQCount;
	}
	public String getManaRuneMCount(){
	    return this.ManaRuneMCount;
	}
	public void setManaRuneMCount(String ManaRuneMCount){
	    this.ManaRuneMCount = ManaRuneMCount;
	}
	public String getManaRuneSCount(){
	    return this.ManaRuneSCount;
	}
	public void setManaRuneSCount(String ManaRuneSCount){
	    this.ManaRuneSCount = ManaRuneSCount;
	}
	public String getManaRuneGCount(){
	    return this.ManaRuneGCount;
	}
	public void setManaRuneGCount(String ManaRuneGCount){
	    this.ManaRuneGCount = ManaRuneGCount;
	}
	public String getManaRuneQCount(){
	    return this.ManaRuneQCount;
	}
	public void setManaRuneQCount(String ManaRuneQCount){
	    this.ManaRuneQCount = ManaRuneQCount;
	}
	public String getManaScalingRuneMCount(){
	    return this.ManaScalingRuneMCount;
	}
	public void setManaScalingRuneMCount(String ManaScalingRuneMCount){
	    this.ManaScalingRuneMCount = ManaScalingRuneMCount;
	}
	public String getManaScalingRuneSCount(){
	    return this.ManaScalingRuneSCount;
	}
	public void setManaScalingRuneSCount(String ManaScalingRuneSCount){
	    this.ManaScalingRuneSCount = ManaScalingRuneSCount;
	}
	public String getManaScalingRuneGCount(){
	    return this.ManaScalingRuneGCount;
	}
	public void setManaScalingRuneGCount(String ManaScalingRuneGCount){
	    this.ManaScalingRuneGCount = ManaScalingRuneGCount;
	}
	public String getManaScalingRuneQCount(){
	    return this.ManaScalingRuneQCount;
	}
	public void setManaScalingRuneQCount(String ManaScalingRuneQCount){
	    this.ManaScalingRuneQCount = ManaScalingRuneQCount;
	}
	public String getManaRegenRuneMCount(){
	    return this.ManaRegenRuneMCount;
	}
	public void setManaRegenRuneMCount(String ManaRegenRuneMCount){
	    this.ManaRegenRuneMCount = ManaRegenRuneMCount;
	}
	public String getManaRegenRuneSCount(){
	    return this.ManaRegenRuneSCount;
	}
	public void setManaRegenRuneSCount(String ManaRegenRuneSCount){
	    this.ManaRegenRuneSCount = ManaRegenRuneSCount;
	}
	public String getManaRegenRuneGCount(){
	    return this.ManaRegenRuneGCount;
	}
	public void setManaRegenRuneGCount(String ManaRegenRuneGCount){
	    this.ManaRegenRuneGCount = ManaRegenRuneGCount;
	}
	public String getManaRegenRuneQCount(){
	    return this.ManaRegenRuneQCount;
	}
	public void setManaRegenRuneQCount(String ManaRegenRuneQCount){
	    this.ManaRegenRuneQCount = ManaRegenRuneQCount;
	}
	public String getManaRegenScalingRuneSCount(){
	    return this.ManaRegenScalingRuneSCount;
	}
	public void setManaRegenScalingRuneSCount(String ManaRegenScalingRuneSCount){
	    this.ManaRegenScalingRuneSCount = ManaRegenScalingRuneSCount;
	}
	public String getManaRegenScalingRuneGCount(){
	    return this.ManaRegenScalingRuneGCount;
	}
	public void setManaRegenScalingRuneGCount(String ManaRegenScalingRuneGCount){
	    this.ManaRegenScalingRuneGCount = ManaRegenScalingRuneGCount;
	}
	public String getManaRegenScalingRuneQCount(){
	    return this.ManaRegenScalingRuneQCount;
	}
	public void setManaRegenScalingRuneQCount(String ManaRegenScalingRuneQCount){
	    this.ManaRegenScalingRuneQCount = ManaRegenScalingRuneQCount;
	}
	public String getMovementSpeedRuneQCount(){
	    return this.MovementSpeedRuneQCount;
	}
	public void setMovementSpeedRuneQCount(String MovementSpeedRuneQCount){
	    this.MovementSpeedRuneQCount = MovementSpeedRuneQCount;
	}
	public String getSpellVampRuneQCount(){
	    return this.SpellVampRuneQCount;
	}
	public void setSpellVampRuneQCount(String SpellVampRuneQCount){
	    this.SpellVampRuneQCount = SpellVampRuneQCount;
	
	}
    
}

