package com.leagueoflegendscalculator.myclasses;


public class ClassStatCalculations {
	
	public double attackDamageBase;//I split up Attack Damage to make it easier to manage. I really only need to use attackDamageFinal outside of this class.
	public double attackDamageBonus;
	public double attackDamageNoCritical;
	public double attackDamageFinal;
	public double totalDamagePerSecondRaw;
	
	public double attackSpeedBase;//Attack Speed is split public into its base and the bonuses from leveling up and items
	public double attackSpeedBonus;
	public double attackSpeedFinal;
	
	public double rangeFinal;
	
	
	public double healthBase;
	public double healthPartialExtra;
	public double healthExtra;
	public double healthFinal;
	public double healthRegenFinal;
	public double manaFinal;
	public double manaRegenFinal;
	public double energyFinal;
	public double energyRegenFinal;
	
	public double armorBase;
	public double armorBonus;
	public double armorFinal;
	public double magicResistBase;
	public double magicResistBonus;
	public double magicResistFinal;
	
	public double abilityPowerExtra;
	public double abilityPowerFinal;
	public double coolDownReductionFinal;
	
	public double criticalChanceFinal;
	public double criticalDamageFinal;

	//public double armorRedFlat;
	public double armorRedPercentFinal;
	public double armorPenPercentFinal;
	public double armorPenFlatFinal;
	
	public double magicRedFlatFinal;
	public double magicRedPercentFinal;//no item that reduces percent magic resist
	public double magicPenPercentFinal;
	public double magicPenFlatFinal;
	
	public double lifestealPercentFinal;
	public double lifestealFlatBonus = 0;
	public double spellVampFinal;
	
	public double movementSpeedBase;//Movement Speed is split public into its base and the PERCENT bonuses from items. The flat bonuses for MS need to be done separately and are applied before the percent
	public double movementSpeedFlatBonus;
	public double movementSpeedPercentBonus;
	public double movementSpeedFinal;
	
	public double bonusMagicAttackDamageExtra;
	public double bonusMagicAttackDamageFinal;
	public double bonusPhysicalAttackDamageFinal = 0;//Trinity Force and Sheen would do this type of extra damage (Not in calculations); Only used on Blade of the Ruined King. Does not apply LifeSteal or Critical.
	
	public double physicalDamagePerSecondRaw;
	public double lifestealFlatRaw;
	public double lifestealPerSecondRaw;
	public double physicaldamagePerSecondVSTurrets;
	public double totaldamagePerSecondVSTurrets;
	
	public double bonusTrueDamageFinal = 0;
	
	//unique item passives
	public boolean atmasImpalerPassive;
	public boolean awePassive;
	public boolean bladeOfTheRuinedKingPassive;
	public boolean coldSteelPassive;
	public boolean doransShieldPassive;
	public boolean executionersCallingPassive;
	public boolean feralFlarePassive;
	public boolean frostQueensClaimPassive;
	public boolean frostFangPassive;
	public boolean frozenHeartPassive;
	public boolean guardianAngelPassive;
	public boolean guinsoosRagebladeUniquePassive;
	public boolean hexDrinkerShield;
	public boolean hexDrinkerPassive;
	public boolean insightPassive;
	public boolean manaChargeArchangelsStaffPassive;
	public boolean manaChargePassive;
	public boolean mawOfMalmortiusShield;
	public boolean mawOfMalmortiusPassive;
	public boolean mejaisSoulstealerPassive;
	public boolean morellonomiconPassive;
	public boolean nashorsToothPassive;
	public boolean ninjaTabiPassive;
	public boolean odynsVeilPassive;
	public boolean orbOfWinterPassive;
	public double rabadonsDeathcapPassive;
	public boolean sanguineBladePassive;
	public boolean seekersArmguardPassive;
	public boolean spellthiefsEdgePassive;
	public boolean spiritVisagePassive;
	public boolean spiritOfTheElderLizardPassive;
	public boolean spiritOfTheSpectralWraithPassive;
	public boolean statikkShivPassive;
	public boolean sunfireCapePassive;
	public boolean swordOfTheOccultPassive;
	public boolean theBloodthirsterPassive;
	public boolean theLightbringerPassive;
	public boolean thornmailPassive;
	public boolean warmogsArmorPassive;
	public boolean wickedHatchetPassive;
	public boolean witsEndSecondPassive;
	public double woogletsWitchcapPassive;
	
	//itemss that are needed for updates in the Duel Simulator
	public double criticalChanceItem;
	
	
	//Combat-stacks for items
	public byte guinsoosRagebladeNumber;//get stacks twice as fast with public double the cap. # of Guinsoo's
	public byte theBlackCleaverStacksPerHit;//get stacks twice as fast with same cap. # of BC
	public double blackCleaverStackBonus = 0;
	public double bladeOfTheRuinedKingBonus = 0;
	public double mawOfMalmortiusBonus = 0;
	
	//Bonus counts and amounts for items
	public byte spiritOfTheAncientGolemPercentHealth = 0;// # of SotAG//non-unique passive, stacks on itself but has no stacks itself
	public byte statikkShivStacks = 0;//actual in-game stacks from the item, not the # of SS. Easier to keep track here since it procs only every 10 hits unlike the others
	public double statikkShivBonus = 0;
	public double sunfireCapeDamage = 0;
	public double ninjaTabiResistance = 1;
	public double odynsVeilResistance = 1;
	public double thornmailDamage = 0;
	public double nashorsToothBonus = 0;
	
	//Pre-Stacks (some unique, some not) for items
	public int feralFlareStacks;
	public int manaChargeStacks;//works with manaChargePassive or the Archangel's variation
	public int mejaisSoulstealerStacks;
	public int rodOfAgesStacks;//not unique
	public int seekersArmguardStacks;
	public int spiritOfTheSpectralWraithStacks;
	public int swordOfTheOccultStacks;
	
	//created by some items and masteries
	public double shield = 0;
	public double magicShield = 0;
	
	//masteries that are not simple enough to do in ClassMastery
	public double arcaneBlade;
	public double archmage;
	public boolean doubleEdgedSword;
	public double enchantedArmor;
	public boolean frenzy;
	public boolean unyielding;
	public boolean reinforcedArmor;
	public boolean secondWind;
	public boolean runicBlessing;
	public boolean strengthOfSpirit;
	public double executioner;
	public byte block;
	public double perseverance;
	public double perseveranceBonus = 0;
	public double havoc;
	public double frenzyBonus = 0;
	public double juggernaut; 
	
	//runes that are needed for updates in the Duel Simulator
	public double HealthPercentRuneTotal;
	public double CriticalChanceRuneTotal;
	
	//champion stat
	public String champName;
	public byte level;
	public byte qskill;
	public byte wskill;
	public byte eskill;
	public byte rskill;
	public boolean rangedChampion;
	public double currentHealth;
	public double truePhysicalDamage;
	public double trueMagicDamage;
	public double physicalDamageCoefficient;
	public double magicDamageCoefficient;
	
	//Duel Simulator variables
	public int counter;
	public int hits;
	public double actualLifesteal;//The calculated flat amount used and reported in the Duel Simulator
	public double actualHealthRegen;
	
	//Duel Simulator ability condition switches
	public boolean blitzcrankShield = false;
	public boolean volibearHeal = false;
	public double volibearHealBonus = 0;
	public double olafBonusAS = 0;
	public double vladBonusAP = 0;
	public double vladBonusHP = 0;
	public boolean quinnValorCondition = false;
	public double corkiBonusTrueDamage = 0;
	public double akaliBonusSpellvamp = 0;
	public double akaliBonusMagicDamage = 0;
	public double gravesBonusProtection = 0;
	public double oriannaBonusMagicDamage = 0;
	public byte shyvanaBonusPro = 0;
	public double shenCounter = 0;
	public double ziggsCounter = 0;
	public double zedCounter = 0;
	public double nocturneCounter = 0;
	public int threshStacks;
	public byte tryndamereFury;
	public boolean pantheonPassive = false;
	
	public ClassStatCalculations(ClassChampion championStats, ClassItems itemStats, ClassMastery masteryStats, ClassRunes runeStats){

		attackDamageBase = (championStats.level * championStats.attackDamagePerLevel) + championStats.attackDamage;
		attackDamageBonus = (itemStats.attackDamageItem + masteryStats.martialMastery + runeStats.AttackDamageRuneTotal + (championStats.level * (masteryStats.bruteForce + runeStats.AttackDamageScalingRuneTotal))) * (1 + masteryStats.warlord);
		attackDamageNoCritical = (attackDamageBase + attackDamageBonus) * (1 + masteryStats.havoc);//excludes bonusPhysicalAttackDamageFinal
		criticalChanceFinal = itemStats.criticalChanceItem + runeStats.CriticalChanceRuneTotal;
		criticalDamageFinal = championStats.criticalDamage + itemStats.criticalDamageItem + runeStats.CriticalDamageRuneTotal;
		attackDamageFinal = (attackDamageNoCritical * (1-criticalChanceFinal)) + (attackDamageNoCritical * criticalChanceFinal * criticalDamageFinal);
		
		attackSpeedBase = championStats.attackSpeed;
		attackSpeedBonus = ((championStats.level - 1) * championStats.attackSpeedPerLevel) + itemStats.attackSpeedItem + masteryStats.fury + runeStats.AttackSpeedRuneTotal;
		attackSpeedFinal = attackSpeedBase * (1 + attackSpeedBonus);
		
		rangeFinal = championStats.range;
		
		healthBase = (championStats.level * championStats.healthPerLevel) + championStats.health;
		healthPartialExtra = ((championStats.level * runeStats.HealthScalingRuneTotal) + itemStats.healthItem + masteryStats.veteransScars + runeStats.HealthRuneTotal);
		healthExtra = (healthPartialExtra * (1 + 0.25 * spiritOfTheAncientGolemPercentHealth)) * (1 + masteryStats.juggernaut + runeStats.HealthPercentRuneTotal) + healthBase * (masteryStats.juggernaut + runeStats.HealthPercentRuneTotal);
		healthFinal = healthBase + healthExtra;
		healthRegenFinal = (championStats.level * (championStats.healthRegenPerLevel + runeStats.HealthRegenScalingRuneTotal)) + championStats.healthRegen + itemStats.healthRegenItem  + masteryStats.recovery + runeStats.HealthRegenRuneTotal;
		
		manaFinal = ((championStats.level * (championStats.manaPerLevel + runeStats.ManaScalingRuneTotal)) + championStats.mana + itemStats.manaItem + runeStats.ManaRuneTotal) * (1 + masteryStats.expandedMind);
		manaRegenFinal = (championStats.level * (championStats.manaRegenPerLevel + runeStats.ManaRegenScalingRuneTotal)) + championStats.manaRegen + itemStats.manaRegenItem + + masteryStats.meditation + runeStats.ManaRegenRuneTotal;
		energyFinal = (championStats.level * runeStats.EnergyScalingRuneTotal) + runeStats.EnergyRuneTotal;
		energyRegenFinal = (championStats.level * runeStats.EnergyRegenScalingRuneTotal) + runeStats.EnergyRegenRuneTotal;

		armorBase = (championStats.level * championStats.armorPerLevel) + championStats.armor;
		armorBonus = ((championStats.level * runeStats.ArmorScalingRuneTotal) + itemStats.armorItem + runeStats.ArmorRuneTotal + masteryStats.hardiness);
		armorFinal = armorBase + (armorBonus * (1 + masteryStats.enchantedArmor));
		magicResistBase = championStats.level * (championStats.magicResistPerLevel) + championStats.magicResist;
		magicResistBonus = (championStats.level * runeStats.MagicResistScalingRuneTotal) + itemStats.magicResistItem + masteryStats.resistance + runeStats.MagicResistRunTotal;
		magicResistFinal = magicResistBase + magicResistBonus;

		abilityPowerExtra = (championStats.level * (itemStats.abilityPowerScalingItem + masteryStats.mentalForce + runeStats.AbilityPowerScalingRuneTotal)) + itemStats.abilityPowerItem + masteryStats.arcaneMastery + runeStats.AbilityPowerRuneTotal;
		abilityPowerFinal = abilityPowerExtra * (1 + masteryStats.archmage) * (itemStats.rabadonsDeathcapPassive);
		coolDownReductionFinal = itemStats.coolDownReductionItem + masteryStats.sorcery + masteryStats.intelligence + runeStats.CooldownReductionRuneTotal + (championStats.level * runeStats.CooldownReductionRuneScalingTotal);

		armorRedPercentFinal = itemStats.armorRedPercentItem;
		armorPenPercentFinal = itemStats.armorPenPercentItem + masteryStats.devastatingStrikes;
		armorPenFlatFinal = itemStats.armorPenFlatItem + runeStats.ArmorPenetrationRuneTotal;
		
		magicRedFlatFinal = itemStats.magicPenFlatItem;
		magicRedPercentFinal = itemStats.magicRedPercentItem;
		magicPenPercentFinal = itemStats.magicPenPercentItem + masteryStats.devastatingStrikes;
		magicPenFlatFinal = itemStats.magicPenFlatItem + runeStats.MagicPenetrationRuneTotal;
		
		lifestealPercentFinal = itemStats.lifestealPercentItem + masteryStats.vampirism + runeStats.LifeStealRuneTotal;
		spellVampFinal = itemStats.spellVampItem + masteryStats.vampirism + runeStats.SpellVampRuneTotal;
		
		movementSpeedBase = championStats.movementSpeed;
		movementSpeedFlatBonus = itemStats.movementSpeedFlatItem;
		movementSpeedPercentBonus = itemStats.movementSpeedPercentItem + masteryStats.fleetOfFoot + runeStats.MovementSpeedRuneTotal;
		movementSpeedFinal = (movementSpeedBase + movementSpeedFlatBonus) * (1 + movementSpeedPercentBonus);
		
		bonusMagicAttackDamageExtra = itemStats.bonusMagicAttackDamageItem;
		bonusMagicAttackDamageFinal = bonusMagicAttackDamageExtra + (masteryStats.arcaneBlade * abilityPowerFinal);//make sure that stats are in the right order. e.g. bonusMagicAttackDamage Final needs to be below abilityPowerFinal
		//bonusPhysicalAttackDamageFinal is only a factor to consider in the Duel Simulator since BotRK is the only item to give this type of bonus
		
		//Cumulative Offensive Stats
		physicalDamagePerSecondRaw = attackDamageFinal * attackSpeedFinal; //no Blade of the Ruined King, Maw of Malmortius, Spellblade, or nashor's tooth passives
				
		lifestealFlatRaw = attackDamageFinal * lifestealPercentFinal;//Feral Flare assumed to have 0 stacks
		
		physicaldamagePerSecondVSTurrets = (attackDamageNoCritical * attackSpeedFinal);
		totaldamagePerSecondVSTurrets = (attackDamageNoCritical + bonusMagicAttackDamageFinal) * attackSpeedFinal;
		
		

		
		//This lists how I use the masteries in the calculations, not as how they are actually done in-game. Make this list public so people that test this can correct me and I can update this
		//all masteries used in this class are treated like item bonuses of the same type, unless otherwise specified
		//enchanted armor is multiplied by the bonus from items
		//warlord is multiplied by the bonus from items
		//juggernaut and percent health runes stack additively with each other
		 

		
		//ADD CONDITIONS THAT LIMIT THE STATS ON ATTACK SPEED, COOLDOWN REDUCTION, MOVEMENTS SPEED, AND ANY OTHER STATS
		
		
		
		atmasImpalerPassive 		= itemStats.atmasImpalerPassive;
		awePassive 					= itemStats.awePassive;
		bladeOfTheRuinedKingPassive = itemStats.bladeOfTheRuinedKingPassive;
		coldSteelPassive 			= itemStats.coldSteelPassive;
		doransShieldPassive 		= itemStats.doransShieldPassive;
		executionersCallingPassive 	= itemStats.executionersCallingPassive;
		feralFlarePassive 			= itemStats.feralFlarePassive;
		frostQueensClaimPassive 	= itemStats.frostQueensClaimPassive;
		frostFangPassive 			= itemStats.frostFangPassive;
		frozenHeartPassive 			= itemStats.frozenHeartPassive;
		guardianAngelPassive 		= itemStats.guardianAngelPassive;
		hexDrinkerShield			= itemStats.hexDrinkerShield;
		hexDrinkerPassive 			= itemStats.hexDrinkerPassive;
		insightPassive 				= itemStats.insightPassive;
		manaChargeArchangelsStaffPassive = itemStats.manaChargeArchangelsStaffPassive;
		manaChargePassive 			= itemStats.manaChargePassive;
		mawOfMalmortiusShield 		= itemStats.mawOfMalmortiusShield;
		mawOfMalmortiusPassive 		= itemStats.mawOfMalmortiusPassive;
		mejaisSoulstealerPassive 	= itemStats.mejaisSoulstealerPassive;
		morellonomiconPassive 		= itemStats.morellonomiconPassive;
		nashorsToothPassive 		= itemStats.nashorsToothPassive;
		ninjaTabiPassive 			= itemStats.ninjaTabiPassive;
		odynsVeilPassive 			= itemStats.odynsVeilPassive;
		orbOfWinterPassive 			= itemStats.orbOfWinterPassive;
		rabadonsDeathcapPassive 	= itemStats.rabadonsDeathcapPassive;
		sanguineBladePassive 		= itemStats.sanguineBladePassive;
		seekersArmguardPassive 		= itemStats.seekersArmguardPassive;
		spellthiefsEdgePassive 		= itemStats.spellthiefsEdgePassive;
		spiritVisagePassive 		= itemStats.spiritVisagePassive;
		spiritOfTheElderLizardPassive = itemStats.spiritOfTheElderLizardPassive;
		spiritOfTheSpectralWraithPassive = itemStats.spiritOfTheSpectralWraithPassive;
		statikkShivPassive 			= itemStats.statikkShivPassive;
		sunfireCapePassive 			= itemStats.sunfireCapePassive;
		swordOfTheOccultPassive 	= itemStats.swordOfTheOccultPassive;
		theBloodthirsterPassive		= itemStats.theBloodthirsterPassive;
		theLightbringerPassive 		= itemStats.theLightbringerPassive;
		thornmailPassive 			= itemStats.thornmailPassive;
		warmogsArmorPassive 		= itemStats.warmogsArmorPassive;
		wickedHatchetPassive 		= itemStats.wickedHatchetPassive;
		witsEndSecondPassive 		= itemStats.witsEndSecondPassive;
		woogletsWitchcapPassive 	= itemStats.woogletsWitchcapPassive;
		
		criticalChanceItem 			= itemStats.criticalChanceItem;

		spiritOfTheAncientGolemPercentHealth = itemStats.spiritOfTheAncientGolemPercentHealth;
		theBlackCleaverStacksPerHit 	= itemStats.theBlackCleaverStacksPerHit;
		rodOfAgesStacks				= itemStats.rodOfAgesStacks;
		guinsoosRagebladeNumber 		= itemStats.guinsoosRagebladeNumber;
		guinsoosRagebladeUniquePassive 	= itemStats.guinsoosRagebladeUniquePassive;

		arcaneBlade			= masteryStats.arcaneBlade;
		archmage			= masteryStats.archmage;
		doubleEdgedSword 	= masteryStats.doubleEdgedSword;
		enchantedArmor		= masteryStats.enchantedArmor;
		frenzy 				= masteryStats.frenzy;
		unyielding 			= masteryStats.unyielding;
		reinforcedArmor 	= masteryStats.reinforcedArmor;
		secondWind 			= masteryStats.secondWind;
		runicBlessing 		= masteryStats.runicBlessing;
		strengthOfSpirit 	= masteryStats.strengthOfSpirit;
		executioner 		= masteryStats.executioner;
		block 				= masteryStats.block;
		perseverance 		= masteryStats.perseverance;
		juggernaut 			= masteryStats.juggernaut;
		
		HealthPercentRuneTotal = runeStats.HealthPercentRuneTotal;
		CriticalChanceRuneTotal = runeStats.CriticalChanceRuneTotal;

		havoc = masteryStats.havoc;

		champName = championStats.getName();
		level = (byte)championStats.level;
		qskill = (byte)championStats.qskill;
		wskill = (byte)championStats.wskill;
		eskill = (byte)championStats.eskill;
		rskill = (byte)championStats.rskill;
		
		switch(championStats.getName()){
		case "Aatrox":
	        rangedChampion = false;
	        break;
		case "Ahri":
	        rangedChampion = true;
	        break;
		case "Akali":
	        rangedChampion = false;
	        break;
		case "Alistar":
	        rangedChampion = false;
	        break;
		case "Amumu":
	        rangedChampion = false;
	        break;
		case "Anivia":
	        rangedChampion = true;
	        break;
		case "Annie":
	        rangedChampion = true;
	        break;
		case "Ashe":
	        rangedChampion = true;
	        break;
		case "Blitzcrank":
	        rangedChampion = false;
	        break;
		case "Brand":
	        rangedChampion = true;
	        blitzcrankShield = true;
	        break;
		case "Braum":
	        rangedChampion = false;
	        break;
		case "Caitlyn":
	        rangedChampion = true;
	        break;
		case "Cassiopeia":
	        rangedChampion = true;
	        break;
		case "Cho'Gath":
	        rangedChampion = false;
	        break;
		case "Corki":
	        rangedChampion = true;
	        break;
		case "Darius":
	        rangedChampion = false;
	        break;
		case "Diana":
	        rangedChampion = false;
	        break;
		case "Dr.Mundo":
	        rangedChampion = false;
	        break;
		case "Draven":
	        rangedChampion = true;
	        break;
		case "Elise":
	        rangedChampion = true;
	        break;
		case "Evelynn":
	        rangedChampion = false;
	        break;
		case "Ezreal":
	        rangedChampion = true;
	        break;
		case "Fiddlesticks":
	        rangedChampion = true;
	        break;
		case "Fiora":
	        rangedChampion = false;
	        break;
		case "Fizz":
	        rangedChampion = false;
	        break;
		case "Galio":
	        rangedChampion = true;
	        break;
		case "Gangplank":
	        rangedChampion = false;
	        break;
		case "Garen":
	        rangedChampion = false;
	        break;
		case "Gragas":
	        rangedChampion = false;
	        break;
		case "Graves":
	        rangedChampion = true;
	        break;
		case "Hecarim":
	        rangedChampion = false;
	        break;
		case "Heimerdinger":
	        rangedChampion = true;
	        break;
		case "Irelia":
	        rangedChampion = false;
	        break;
		case "Janna":
	        rangedChampion = true;
	        break;
		case "Jarvan IV":
	        rangedChampion = false;
	        break;
		case "Jax":
	        rangedChampion = false;
	        break;
		case "Jayce":
	        rangedChampion = false;
	        break;
		case "Jinx":
	        rangedChampion = true;
	        break;
		case "Karma":
	        rangedChampion = true;
	        break;
		case "Karthus":
	        rangedChampion = true;
	        break;
		case "Kassadin":
	        rangedChampion = false;
	        break;
		case "Katarina":
	        rangedChampion = false;
	        break;
		case "Kayle":
	        rangedChampion = false;
	        break;
		case "Kennen":
	        rangedChampion = false;
	        break;
		case "Kha'Zix":
	        rangedChampion = false;
	        break;
		case "Kog'Maw":
	        rangedChampion = true;
	        break;
		case "LeBlanc":
	        rangedChampion = true;
	        break;
		case "Lee Sin":
	        rangedChampion = false;
	        break;
		case "Leona":
	        rangedChampion = false;
	        break;
		case "Lissandra":
	        rangedChampion = true;
	        break;
		case "Lucian":
	        rangedChampion = true;
	        break;
		case "Lulu":
	        rangedChampion = true;
	        break;
		case "Lux":
	        rangedChampion = true;
	        break;
		case "Malphite":
	        rangedChampion = false;
	        break;
		case "Malzahar":
	        rangedChampion = true;
	        break;
		case "Maokai":
	        rangedChampion = false;
	        break;
		case "Master Yi":
	        rangedChampion = false;
	        break;
		case "Miss Fortune":
	        rangedChampion = true;
	        break;
		case "Mordekaiser":
	        rangedChampion = false;
	        break;
		case "Morgana":
	        rangedChampion = true;
	        break;
		case "Nami":
	        rangedChampion = true;
	        break;
		case "Nasus":
	        rangedChampion = false;
	        break;
		case "Nautilus":
	        rangedChampion = false;
	        break;
		case "Nidalee":
	        rangedChampion = false;
	        break;
		case "Nocturne":
	        rangedChampion = false;
	        break;
		case "Nunu":
	        rangedChampion = false;
	        break;
		case "Olaf":
	        rangedChampion = false;
	        break;
		case "Orianna":
	        rangedChampion = true;
	        break;
		case "Pantheon":
	        rangedChampion = false;
	        break;
		case "Poppy":
	        rangedChampion = false;
	        break;
		case "Quinn":
	        rangedChampion = true;
	        break;
		case "Rammus":
	        rangedChampion = false;
	        break;
		case "Renekton":
	        rangedChampion = false;
	        break;
		case "Rengar":
	        rangedChampion = false;
	        break;
		case "Riven":
	        rangedChampion = false;
	        break;
		case "Rumble":
	        rangedChampion = false;
	        break;
		case "Ryze":
	        rangedChampion = true;
	        break;
		case "Sejuani":
	        rangedChampion = false;
	        break;
		case "Shaco":
	        rangedChampion = false;
	        break;
		case "Shen":
	        rangedChampion = false;
	        break;
		case "Shyvana":
	        rangedChampion = false;
	        break;
		case "Singed":
	        rangedChampion = false;
	        break;
		case "Sion":
	        rangedChampion = false;
	        break;
		case "Sivir":
	        rangedChampion = true;
	        break;
		case "Skarner":
	        rangedChampion = false;
	        break;
		case "Sona":
	        rangedChampion = true;
	        break;
		case "Soraka":
	        rangedChampion = true;
	        break;
		case "Swain":
	        rangedChampion = true;
	        break;
		case "Syndra":
	        rangedChampion = true;
	        break;
		case "Talon":
	        rangedChampion = false;
	        break;
		case "Taric":
	        rangedChampion = false;
	        break;
		case "Teemo":
	        rangedChampion = true;
	        break;
		case "Thresh":
	        rangedChampion = true;
	        break;
		case "Tristana":
	        rangedChampion = true;
	        break;
		case "Trundle":
	        rangedChampion = false;
	        break;
		case "Tryndamere":
	        rangedChampion = false;
	        break;
		case "Twisted Fate":
	        rangedChampion = true;
	        break;
		case "Twitch":
	        rangedChampion = true;
	        break;
		case "Udyr":
	        rangedChampion = false;
	        break;
		case "Urgot":
	        rangedChampion = true;
	        break;
		case "Varus":
	        rangedChampion = true;
	        break;
		case "Vayne":
	        rangedChampion = true;
	        break;
		case "Veigar":
	        rangedChampion = true;
	        break;
		case "Vel'Koz":
	        rangedChampion = true;
	        break;
		case "Vi":
	        rangedChampion = false;
	        break;
		case "Viktor":
	        rangedChampion = true;
	        break;
		case "Vladimir":
	        rangedChampion = true;
	        break;
		case "Volibear":
	        rangedChampion = false;
	        volibearHeal = true;
	        break;
		case "Warwick":
	        rangedChampion = false;
	        break;
		case "Wukong":
	        rangedChampion = false;
	        break;
		case "Xerath":
	        rangedChampion = true;
	        break;
		case "Xin Zhao":
	        rangedChampion = false;
	        break;
		case "Yasuo":
	        rangedChampion = false;
	        break;
		case "Yorick":
	        rangedChampion = false;
	        break;
		case "Zac":
	        rangedChampion = false;
	        break;
		case "Zed":
	        rangedChampion = false;
	        break;
		case "Ziggs":
	        rangedChampion = true;
	        break;
		case "Zilean":
	        rangedChampion = true;
	        break;
		case "Zyra":
	        rangedChampion = true;
	        break;
		default:
	        rangedChampion = false;
	        break;
		}
	}
	

	
	
	
	//in the display have a checkbox to show stats with or without passives, and multiple
	//variable textboxes to fill in that may potentially affect that build
	//e.g. %HPmissing, current enemy HP, enemy max HP, enemy armor, enemy MR,
	//BT average stacks, Mejai stacks, Occult Stacks, Rageblade average stacks, 
	//Seeker's Armguard stacks, 
	
	//explain that some items are omitted because they are not useful for the calculations or are done separately, like potions and Hunter's Machete.
	

	

	
	
	
	
	
	
	
	
	
	
	
	
}
