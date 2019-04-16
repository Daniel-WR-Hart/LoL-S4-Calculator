package com.leagueoflegendscalculator.myclasses;



public class ClassRunes {

	public float AbilityPowerRuneM = 0.59f;
	public float AbilityPowerRuneS = 0.59f;
	public float AbilityPowerRuneG = 1.19f;
	public float AbilityPowerRuneQ = 4.95f;

	public float AbilityPowerScalingRuneM = 0.1f;
	public float AbilityPowerScalingRuneS = 0.1f;
	public float AbilityPowerScalingRuneG = 0.17f;
	public float AbilityPowerScalingRuneQ = 0.43f;

	public float ArmorRuneM = 0.91f;
	public float ArmorRuneS = 1f;
	public float ArmorRuneG = 0.7f;
	public float ArmorRuneQ = 4.26f;

	public float ArmorScalingRuneS = 0.16f;
	public float ArmorScalingRuneQ = 0.38f;

	public float ArmorPenetrationRuneM = 1.28f;
	public float ArmorPenetrationRuneQ = 2.56f;

	public float AttackDamageRuneM = 0.95f;
	public float AttackDamageRuneS = 0.43f;
	public float AttackDamageRuneG = 0.28f;
	public float AttackDamageRuneQ = 2.25f;

	public float AttackDamageScalingRuneM = 0.13f;
	public float AttackDamageScalingRuneS = 0.06f;
	public float AttackDamageScalingRuneG = 0.04f;
	public float AttackDamageScalingRuneQ = 0.25f;

	public float AttackSpeedRuneM = 0.017f;
	public float AttackSpeedRuneS = 0.0076f;
	public float AttackSpeedRuneG = 0.0064f;
	public float AttackSpeedRuneQ = 0.045f;

	public float CooldownReductionRuneM = 0.002f;
	public float CooldownReductionRuneS = 0.0036f;
	public float CooldownReductionRuneG = 0.0083f;
	public float CooldownReductionRuneQ = 0.025f;

	public float CooldownReductionScalingRuneG = 0.0009f;
	public float CooldownReductionScalingRuneQ = 0.0028f;

	public float CriticalChanceRuneM = 0.0093f;
	public float CriticalChanceRuneS = 0.0042f;
	public float CriticalChanceRuneG = 0.0028f;
	public float CriticalChanceRuneQ = 0.0186f;

	public float CriticalDamageRuneM = 0.0223f;
	public float CriticalDamageRuneS = 0.0078f;
	public float CriticalDamageRuneG = 0.0056f;
	public float CriticalDamageRuneQ = 0.0446f;

	public float EnergyRuneG = 2.2f;
	public float EnergyRuneQ = 5.4f;

	public float EnergyScalingRuneG = 0.161f;

	public float EnergyRegenRuneS = 0.63f;
	public float EnergyRegenRuneQ = 1.575f;

	public float EnergyRegenScalingRuneS = 0.064f;

	public float HealthRuneM = 3.47f;
	public float HealthRuneS = 8f;
	public float HealthRuneG = 2.67f;
	public float HealthRuneQ = 26f;

	public float HealthScalingRuneM = 0.54f;
	public float HealthScalingRuneS = 1.33f;
	public float HealthScalingRuneG = 0.54f;
	public float HealthScalingRuneQ = 2.7f;

	public float HealthPercentRuneS = 0.005f;
	public float HealthPercentRuneQ = 0.015f;

	public float HealthRegenRuneS = 0.56f;
	public float HealthRegenRuneG = 0.27f;
	public float HealthRegenRuneQ = 2.7f;

	public float HealthRegenScalingRuneS = 0.11f;
	public float HealthRegenScalingRuneQ = 0.28f;

	public float HybridPenetrationArmorRuneM = 0.9f;
	public float HybridPenetrationMagicRuneM = 0.62f;
	public float HybridPenetrationArmorRuneQ = 1.79f;
	public float HybridPenetrationMagicRuneQ = 1.4f;

	public float LifeStealRuneQ = 0.015f;

	public float MagicPenetrationRuneM = 0.87f;
	public float MagicPenetrationRuneG = 0.63f;
	public float MagicPenetrationRuneQ = 2.01f;

	public float MagicResistRuneM = 0.77f;
	public float MagicResistRuneS = 0.74f;
	public float MagicResistRuneG = 1.34f;
	public float MagicResistRuneQ = 4f;

	public float MagicResistScalingRuneM = 0.07f;
	public float MagicResistScalingRuneS = 0.1f;
	public float MagicResistScalingRuneG = 0.16f;
	public float MagicResistScalingRuneQ = 0.37f;

	public float ManaRuneM = 5.91f;
	public float ManaRuneS = 6.89f;
	public float ManaRuneG = 11.25f;
	public float ManaRuneQ = 37.5f;

	public float ManaScalingRuneM = 1.17f;
	public float ManaScalingRuneS = 1.17f;
	public float ManaScalingRuneG = 1.42f;
	public float ManaScalingRuneQ = 4.17f;

	public float ManaRegenRuneM = 0.26f;
	public float ManaRegenRuneS = 0.41f;
	public float ManaRegenRuneG = 0.33f;
	public float ManaRegenRuneQ = 1.25f;

	public float ManaRegenScalingRuneS = 0.065f;
	public float ManaRegenScalingRuneG = 0.06f;
	public float ManaRegenScalingRuneQ = 0.24f;

	public float MovementSpeedRuneQ = 0.015f;

	public float SpellVampRuneQ = 0.02f;
	
	public float AbilityPowerRuneTotal;
	public float AbilityPowerScalingRuneTotal;
	public float ArmorRuneTotal;
	public float ArmorScalingRuneTotal; //The benefits of the hybrid penetration rune are split between the armor penetration and magic penetration runes
	public float ArmorPenetrationRuneTotal;
	public float AttackDamageRuneTotal;
	public float AttackDamageScalingRuneTotal;
	public float AttackSpeedRuneTotal;
	public float CooldownReductionRuneTotal;
	public float CooldownReductionRuneScalingTotal;
	public float CriticalChanceRuneTotal;
	public float CriticalDamageRuneTotal;
	public float EnergyRuneTotal;
	public float EnergyScalingRuneTotal;
	public float EnergyRegenRuneTotal;
	public float EnergyRegenScalingRuneTotal;
	public float HealthRuneTotal;
	public float HealthScalingRuneTotal;
	public float HealthPercentRuneTotal;
	public float HealthRegenRuneTotal;
	public float HealthRegenScalingRuneTotal;
	public float LifeStealRuneTotal;
	public float MagicPenetrationRuneTotal;
	public float MagicResistRunTotal;
	public float MagicResistScalingRuneTotal;
	public float ManaRuneTotal;
	public float ManaScalingRuneTotal;
	public float ManaRegenRuneTotal;
	public float ManaRegenScalingRuneTotal;
	public float MovementSpeedRuneTotal;
	public float SpellVampRuneTotal;
	
	
	
	public ClassRunes(
			byte AbilityPowerRuneMCount,
		    byte AbilityPowerRuneSCount,
		    byte AbilityPowerRuneGCount,
		    byte AbilityPowerRuneQCount,
		    byte AbilityPowerScalingRuneMCount,
		    byte AbilityPowerScalingRuneSCount,
		    byte AbilityPowerScalingRuneGCount,
		    byte AbilityPowerScalingRuneQCount,
		    byte ArmorRuneMCount,
		    byte ArmorRuneSCount,
		    byte ArmorRuneGCount,
		    byte ArmorRuneQCount,
		    byte ArmorScalingRuneSCount,
		    byte ArmorScalingRuneQCount,
		    byte ArmorPenetrationRuneMCount,
		    byte ArmorPenetrationRuneQCount,
		    byte AttackDamageRuneMCount,
		    byte AttackDamageRuneSCount,
		    byte AttackDamageRuneGCount,
		    byte AttackDamageRuneQCount,
		    byte AttackDamageScalingRuneMCount,
		    byte AttackDamageScalingRuneSCount,
		    byte AttackDamageScalingRuneGCount,
		    byte AttackDamageScalingRuneQCount,
		    byte AttackSpeedRuneMCount,
		    byte AttackSpeedRuneSCount,
		    byte AttackSpeedRuneGCount,
		    byte AttackSpeedRuneQCount,
		    byte CooldownReductionRuneMCount,
		    byte CooldownReductionRuneSCount,
		    byte CooldownReductionRuneGCount,
		    byte CooldownReductionRuneQCount,
		    byte CooldownReductionScalingRuneGCount,
		    byte CooldownReductionScalingRuneQCount,
		    byte CriticalChanceRuneMCount,
		    byte CriticalChanceRuneSCount,
		    byte CriticalChanceRuneGCount,
		    byte CriticalChanceRuneQCount,
		    byte CriticalDamageRuneMCount,
		    byte CriticalDamageRuneSCount,
		    byte CriticalDamageRuneGCount,
		    byte CriticalDamageRuneQCount,
		    byte EnergyRuneGCount,
		    byte EnergyRuneQCount,
		    byte EnergyScalingRuneGCount,
		    byte EnergyRegenRuneSCount,
		    byte EnergyRegenRuneQCount,
		    byte EnergyRegenScalingRuneSCount,
		    byte HealthRuneMCount,
		    byte HealthRuneSCount,
		    byte HealthRuneGCount,
		    byte HealthRuneQCount,
		    byte HealthScalingRuneMCount,
		    byte HealthScalingRuneSCount,
		    byte HealthScalingRuneGCount,
		    byte HealthScalingRuneQCount,
		    byte HealthPercentRuneSCount,
		    byte HealthPercentRuneQCount,
		    byte HealthRegenRuneSCount,
			byte HealthRegenRuneGCount,
			byte HealthRegenRuneQCount,
			byte HealthRegenScalingRuneSCount,
			byte HealthRegenScalingRuneQCount,
			byte HybridPenetrationRuneMCount,
			byte HybridPenetrationRuneQCount,
			byte LifeStealRuneQCount,
			byte MagicPenetrationRuneMCount,
			byte MagicPenetrationRuneGCount,
			byte MagicPenetrationRuneQCount,
			byte MagicResistRuneMCount,
			byte MagicResistRuneSCount,
			byte MagicResistRuneGCount,
			byte MagicResistRuneQCount,
			byte MagicResistScalingRuneMCount,
			byte MagicResistScalingRuneSCount,
			byte MagicResistScalingRuneGCount,
			byte MagicResistScalingRuneQCount,
			byte ManaRuneMCount,
			byte ManaRuneSCount,
			byte ManaRuneGCount,
			byte ManaRuneQCount,
			byte ManaScalingRuneMCount,
			byte ManaScalingRuneSCount,
			byte ManaScalingRuneGCount,
			byte ManaScalingRuneQCount,
			byte ManaRegenRuneMCount,
			byte ManaRegenRuneSCount,
			byte ManaRegenRuneGCount,
			byte ManaRegenRuneQCount,
			byte ManaRegenScalingRuneSCount,
			byte ManaRegenScalingRuneGCount,
			byte ManaRegenScalingRuneQCount,
			byte MovementSpeedRuneQCount,
			byte SpellVampRuneQCount) {

		AbilityPowerRuneTotal = AbilityPowerRuneMCount*AbilityPowerRuneM + AbilityPowerRuneSCount*AbilityPowerRuneS + AbilityPowerRuneGCount*AbilityPowerRuneG + AbilityPowerRuneQCount*AbilityPowerRuneQ;
		AbilityPowerScalingRuneTotal = AbilityPowerScalingRuneMCount*AbilityPowerScalingRuneM + AbilityPowerScalingRuneSCount*AbilityPowerScalingRuneS + AbilityPowerScalingRuneGCount*AbilityPowerScalingRuneG + AbilityPowerScalingRuneQCount*AbilityPowerScalingRuneQ;
		ArmorRuneTotal = ArmorRuneMCount*ArmorRuneM + ArmorRuneSCount*ArmorRuneS + ArmorRuneGCount*ArmorRuneG + ArmorRuneQCount*ArmorRuneQ;
		ArmorScalingRuneTotal = ArmorScalingRuneSCount*ArmorScalingRuneS + ArmorScalingRuneQCount*ArmorScalingRuneQ;
		ArmorPenetrationRuneTotal = ArmorPenetrationRuneMCount*ArmorPenetrationRuneM + ArmorPenetrationRuneQCount*ArmorPenetrationRuneQ + HybridPenetrationRuneMCount*HybridPenetrationArmorRuneM + HybridPenetrationRuneQCount*HybridPenetrationArmorRuneQ;
		AttackDamageRuneTotal = AttackDamageRuneMCount*AttackDamageRuneM + AttackDamageRuneSCount*AttackDamageRuneS + AttackDamageRuneGCount*AttackDamageRuneG + AttackDamageRuneQCount*AttackDamageRuneQ;
		AttackDamageScalingRuneTotal = AttackDamageScalingRuneMCount*AttackDamageScalingRuneM + AttackDamageScalingRuneSCount*AttackDamageScalingRuneS + AttackDamageScalingRuneGCount*AttackDamageScalingRuneG + AttackDamageScalingRuneQCount*AttackDamageScalingRuneQ;
		AttackSpeedRuneTotal = AttackSpeedRuneMCount*AttackSpeedRuneM + AttackSpeedRuneSCount*AttackSpeedRuneS + AttackSpeedRuneGCount*AttackSpeedRuneG + AttackSpeedRuneQCount*AttackSpeedRuneQ;
		CooldownReductionRuneTotal = CooldownReductionRuneMCount*CooldownReductionRuneM + CooldownReductionRuneSCount*CooldownReductionRuneS + CooldownReductionRuneGCount*CooldownReductionRuneG + CooldownReductionRuneQCount*CooldownReductionRuneQ;
		CooldownReductionRuneScalingTotal = CooldownReductionScalingRuneGCount*CooldownReductionScalingRuneG + CooldownReductionScalingRuneQCount*CooldownReductionScalingRuneQ;
		CriticalChanceRuneTotal = CriticalChanceRuneMCount*CriticalChanceRuneM + CriticalChanceRuneSCount*CriticalChanceRuneS + CriticalChanceRuneGCount*CriticalChanceRuneG + CriticalChanceRuneQCount*CriticalChanceRuneQ;
		CriticalDamageRuneTotal = CriticalDamageRuneMCount*CriticalDamageRuneM + CriticalDamageRuneSCount*CriticalDamageRuneS + CriticalDamageRuneGCount*CriticalDamageRuneG + CriticalDamageRuneQCount*CriticalDamageRuneQ;
		EnergyRuneTotal = EnergyRuneGCount*EnergyRuneG + EnergyRuneQCount*EnergyRuneQ;
		EnergyScalingRuneTotal = EnergyScalingRuneGCount*EnergyScalingRuneG;
		EnergyRegenRuneTotal = EnergyRegenRuneSCount*EnergyRegenRuneS + EnergyRegenRuneQCount*EnergyRegenRuneQ;
		EnergyRegenScalingRuneTotal = EnergyRegenScalingRuneSCount*EnergyRegenScalingRuneS;
		HealthRuneTotal = HealthRuneMCount*HealthRuneM + HealthRuneSCount*HealthRuneS + HealthRuneGCount*HealthRuneG + HealthRuneQCount*HealthRuneQ;
		HealthScalingRuneTotal = HealthScalingRuneMCount*HealthScalingRuneM + HealthScalingRuneSCount*HealthScalingRuneS + HealthScalingRuneGCount*HealthScalingRuneG + HealthScalingRuneQCount*HealthScalingRuneQ;
		HealthPercentRuneTotal = HealthPercentRuneSCount*HealthPercentRuneSCount + HealthPercentRuneQCount*HealthPercentRuneQCount;
		HealthRegenRuneTotal = HealthRegenRuneSCount*HealthRegenRuneS + HealthRegenRuneGCount*HealthRegenRuneG + HealthRegenRuneQCount*HealthRegenRuneQ;
		HealthRegenScalingRuneTotal = HealthRegenScalingRuneSCount*HealthRegenScalingRuneS + HealthRegenScalingRuneQCount*HealthRegenScalingRuneQ;
		LifeStealRuneTotal = LifeStealRuneQCount*LifeStealRuneQ;
		MagicPenetrationRuneTotal = MagicPenetrationRuneMCount*MagicPenetrationRuneM + MagicPenetrationRuneGCount*MagicPenetrationRuneG + MagicPenetrationRuneQCount*MagicPenetrationRuneQ + HybridPenetrationRuneMCount*HybridPenetrationMagicRuneM + HybridPenetrationRuneQCount*HybridPenetrationMagicRuneQ;
		MagicResistRunTotal = MagicResistRuneMCount*MagicResistRuneM + MagicResistRuneSCount*MagicResistRuneS + MagicResistRuneGCount*MagicResistRuneG + MagicResistRuneQCount*MagicResistRuneQ;
		MagicResistScalingRuneTotal = MagicResistScalingRuneMCount*MagicResistScalingRuneM + MagicResistScalingRuneSCount*MagicResistScalingRuneS + MagicResistScalingRuneGCount*MagicResistScalingRuneG + MagicResistScalingRuneQCount*MagicResistScalingRuneQ;
		ManaRuneTotal = ManaRuneMCount*ManaRuneM + ManaRuneSCount*ManaRuneS + ManaRuneGCount*ManaRuneG + ManaRuneQCount*ManaRuneQ;
		ManaScalingRuneTotal = ManaScalingRuneMCount*ManaScalingRuneM + ManaScalingRuneSCount*ManaScalingRuneS + ManaScalingRuneGCount*ManaScalingRuneG + ManaScalingRuneQCount*ManaScalingRuneQ;
		ManaRegenRuneTotal = ManaRegenRuneMCount*ManaRegenRuneM + ManaRegenRuneSCount*ManaRegenRuneS + ManaRegenRuneGCount*ManaRegenRuneG + ManaRegenRuneQCount*ManaRegenRuneQ;
		ManaRegenScalingRuneTotal = ManaRegenScalingRuneSCount*ManaRegenScalingRuneS + ManaRegenScalingRuneGCount*ManaRegenScalingRuneG + ManaRegenScalingRuneQCount*ManaRegenScalingRuneQ;
		MovementSpeedRuneTotal = MovementSpeedRuneQCount*MovementSpeedRuneQ;
		SpellVampRuneTotal = SpellVampRuneQCount*SpellVampRuneQ;

	}

}

