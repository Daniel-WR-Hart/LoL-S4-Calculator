package com.leagueoflegendscalculator.myclasses;



public class ClassMastery {
	
	//Do elsewhere in this section means integrate them in the calculations in the build comparison section using checkboxes. The rest can be handled in ClassStatCalculations.java ahead of time
	public boolean doubleEdgedSword = false;//DuelResultsActivity
	public double fury = 0;
	public double sorcery = 0;
	public byte martialMastery = 0;	
	public byte arcaneMastery = 0;
	public double warlord = 0;
	public double archmage = 0;
	public boolean frenzy = false; //DuelResultsActivity
	public double devastatingStrikes = 0;
	public double arcaneBlade = 0;
	public double havoc = 0;
	public byte recovery = 0;
	public double enchantedArmor = 0;
	public boolean unyielding = false; //DuelResultsActivity
	public double juggernaut = 0;
	public boolean reinforcedArmor = false; //DuelResultsActivity
	public boolean secondWind = false; //DuelResultsActivity
	public boolean runicBlessing = false; //DuelResultsActivity
	public double fleetOfFoot =0;
	public boolean strengthOfSpirit = false; //DuelResultsActivity
	public double vampirism = 0;
	public double expandedMind = 0;
	public double intelligence = 0;
	public double bruteForce = 0;
	public int mentalForce = 0;
	public double executioner = 0; //DuelResultsActivity
	public byte block = 0; //DuelResultsActivity
	public int veteransScars = 0;
	public double hardiness = 0;
	public double resistance = 0;
	public double perseverance = 0; //DuelResultsActivity
	public byte meditation = 0;
	
	
	public ClassMastery(
		boolean doubleEdgedSwordCount,
		byte furyCount,
		byte sorceryCount,
		boolean exposeWeaknessCount,//remove
		boolean martialMasteryCount,
		boolean arcaneMasteryCount,
		boolean bladeWeavingCount,//remove
		byte warlordCount,
		byte archmageCount,
		boolean frenzyCount,
		byte devastatingStrikeCount,
		boolean arcaneBladeCount,
		boolean havocCount,
		byte recoveryCount,
		byte enchantedArmorCount,
		boolean unyieldingCount,
		boolean oppressionCount,//remove
		boolean juggernautCount,
		boolean reinforcedArmorCount,
		boolean evasiveCount,//remove
		boolean secondWindCount,
		boolean runicBlessingCount,
		byte fleetOfFootCount,
		boolean strengthOfSpiritCount,
		byte vampirismCount,
		byte expandedMindCount,
		byte intelligenceCount,
		byte bruteForceCount,
		byte mentalForceCount,
		boolean spellWeavingCount,//remove
		byte executionerCount,
		byte blockCount,
		byte veteransScarsCount,
		byte hardinessCount,
		byte resistanceCount,
		byte perseveranceCount,
		byte meditationCount){

		

		
		//In this section, do elsewhere means to do these calculations in the build comparison section
		doubleEdgedSword = doubleEdgedSwordCount;//condition can't be done here
		
		fury = 0.0125*furyCount;
		
		sorcery = 0.0125*sorceryCount;
		
		if (martialMasteryCount != false){
			martialMastery = 4;	
		}
		
		if (arcaneMasteryCount != false){
			arcaneMastery = 6;
		}

		if (warlordCount != 0){
			warlord = 0.005 + .015*warlordCount;
		}
		if (archmageCount != 0){
			archmage = 0.005 + 0.015*archmageCount;
		}
	
		frenzy = frenzyCount;
		
		devastatingStrikes = 0.02*devastatingStrikeCount;
		
		if (arcaneBladeCount != false){
			arcaneBlade = 0.05;
		}
		if (havocCount != false){
			havoc = 0.03;
		}
		
		recovery = recoveryCount;
		
		enchantedArmor = 0.025*enchantedArmorCount;
		
		unyielding = unyieldingCount; //do elsewhere
		
		if (juggernautCount != false){
			juggernaut = 0.03;
		}
	
		reinforcedArmor = reinforcedArmorCount;
	
		secondWind = secondWindCount;

		runicBlessing = runicBlessingCount;
			
		
		fleetOfFoot = 0.015*fleetOfFootCount;
		strengthOfSpirit = strengthOfSpiritCount; //do elsewhere
		
		vampirism = 0.01*vampirismCount;

		if (expandedMindCount != 0){
			expandedMind = 0.02 + 0.015*expandedMindCount;
		}
		if (intelligenceCount != 0){
			 intelligence = 0.02 + 0.015*intelligenceCount;
		}
		if (bruteForceCount == 1){
			bruteForce = 0.22;
		}
		else if (bruteForceCount == 2){
			bruteForce = 0.39;
		}
		else if (bruteForceCount == 3){
			bruteForce = 0.55;
		}
		
		if (mentalForceCount != 0){
			mentalForce = 1 + 5*mentalForceCount;
		}
		
		if (executionerCount != 0){
			executioner = 0.05 + 0.15*executionerCount;
		}
		
		block = blockCount;
		veteransScars = 12*veteransScarsCount;
		
		if (hardinessCount != 0){
			hardiness = 0.5 + 1.5*hardinessCount;
		}
		if (resistanceCount != 0){
			resistance = 0.5 + 1.5*resistanceCount;
		}
		if (perseveranceCount != 0){
			perseverance = 0.00025 + 0.00325*perseveranceCount;
		}

		meditation = meditationCount;
		
		
		
		
	}	
	
	
}


