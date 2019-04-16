package com.leagueoflegendscalculator.myclasses;


public class ClassItems {
	public String item1;
	public String item2;
	public String item3;
	public String item4;
	public String item5;
	public String item6;
	
	public float healthItem						= 0f;
	public float healthRegenItem				= 0f;
	public float manaItem						= 0f;
	public float manaRegenItem					= 0f;

	public float attackDamageItem				= 0f;
	public float attackSpeedItem				= 0f;
	public float armorItem						= 0f;
	public float magicResistItem				= 0f;
	public float criticalChanceItem				= 0f;
	
	public float lifestealPercentItem			= 0f;
	public float abilityPowerItem				= 0f;
	public float abilityPowerScalingItem		= 0f;
	public float coolDownReductionItem			= 0f;
	
	public float movementSpeedFlatItem			= 0f;
	public float movementSpeedPercentItem		= 0f;
	
	public float bonusMagicAttackDamageItem		= 0f;
	public float criticalDamageItem				= 0f;
	
	public float armorRedPercentItem			= 0f;
	public float armorPenPercentItem			= 0f;
	public float armorPenFlatItem				= 0f;
	
	public float magicRedFlatItem				= 0f;
	public float magicRedPercentItem			= 0f;
	public float magicPenPercentItem			= 0f;
	public float magicPenFlatItem				= 0f;
	
	public float spellVampItem					= 0f;

	public boolean atmasImpalerPassive 		= false;
	public boolean awePassive 					= false;
	public boolean bladeOfTheRuinedKingPassive = false;
	public boolean coldSteelPassive 			= false;
	public boolean doransShieldPassive 		= false;
	public boolean eyesOfPainPassive 			= false;
	public boolean executionersCallingPassive 	= false;
	public boolean feralFlarePassive 			= false;
	public boolean frostQueensClaimPassive 	= false;
	public boolean frostFangPassive 			= false;
	public boolean frozenHeartPassive 			= false;
	public boolean guardianAngelPassive 		= false;
	public boolean guinsoosRagebladeUniquePassive 	= false;
	public boolean hexDrinkerShield 			= false;
	public boolean hexDrinkerPassive 			= false;
	public boolean insightPassive 				= false;
	public boolean liandrysTormentPassive 		= false;
	public boolean manaChargeArchangelsStaffPassive = false;
	public boolean manaChargePassive 			= false;
	public boolean mawOfMalmortiusShield 		= false;
	public boolean mawOfMalmortiusPassive 		= false;
	public boolean mejaisSoulstealerPassive 	= false;
	public boolean morellonomiconPassive 		= false;
	public boolean nashorsToothPassive 		= false;
	public boolean ninjaTabiPassive 			= false;
	public boolean odynsVeilPassive 			= false;
	public boolean orbOfWinterPassive 			= false;
	public double rabadonsDeathcapPassive 		= 1;
	public boolean sanguineBladePassive 		= false;
	public boolean seekersArmguardPassive 		= false;
	public boolean spellthiefsEdgePassive 		= false;
	public boolean spiritVisagePassive 		= false;
	public boolean spiritOfTheElderLizardPassive = false;
	public boolean spiritOfTheSpectralWraithPassive = false;
	public boolean statikkShivPassive 			= false;
	public boolean sunfireCapePassive 			= false;
	public boolean swordOfTheOccultPassive 	= false;
	public boolean theBloodthirsterPassive		 = false;
	public boolean theLightbringerPassive 		= false;
	public boolean thornmailPassive 			= false;
	public boolean warmogsArmorPassive 		= false;
	public boolean wickedHatchetPassive 		= false;
	public boolean witsEndSecondPassive 		= false;
	public double woogletsWitchcapPassive 	= 1;

	public byte spiritOfTheAncientGolemPercentHealth = 0;
	public byte theBlackCleaverStacksPerHit 		= 0;
	public byte rodOfAgesStacks					= 0;
	public byte guinsoosRagebladeNumber 			= 0;

	//each item get their own unique variables to modify the above properties from unique passives.
	

	public ClassItems(String item1, String item2, String item3, String item4, String item5, String item6){
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		
		String[] itemName = new String[6];
		itemName[0] = item1;
		itemName[1] = item2;
		itemName[2] = item3;
		itemName[3] = item4;
		itemName[4] = item5;
		itemName[5] = item6;
		

		for(byte i=0; i<6; i++){
			switch(itemName[i]){
			
			case "Abyssal Scepter":
				magicResistItem += 45f;
				abilityPowerItem += 70f;
				break;
			
			case "Aegis of the Legion":
				healthItem += 200f;
				magicResistItem += 20f;
				break;
			
			case "Aether Wisp":
				abilityPowerItem += 30f;
				break;
				
			case "Amplifying Tome":
				abilityPowerItem += 20f;
				break;
	
			case "Ancient Coin":
				manaRegenItem += 3f;
				break;
				
			case "Archangel's Staff":
				manaItem += 250f;
				manaRegenItem += 10f;
				abilityPowerItem += 60f;
				break;

			case "Ardent Censer":
				abilityPowerItem += 40f;
				manaRegenItem += 10f;
				coolDownReductionItem += 0.10f;
				break;
				
			case "Athene's Unholy Grail":
				manaRegenItem += 10f;
				magicResistItem += 25f;
				abilityPowerItem += 60f;
				coolDownReductionItem += 0.20f;
				break;
				
			case "Atma's Impaler":
				armorItem += 45f;
				criticalChanceItem += 0.15f;
				break;
				
			case "Augment: Death":
				abilityPowerItem += 45f;
				abilityPowerScalingItem += 3f;
				break;
				
			case "Augment: Gravity":
				manaItem += 200f;
				manaRegenItem += 5f;
				coolDownReductionItem += 0.10f;
				abilityPowerScalingItem += 3f;
				break;
				
			case "Augment: Power":
				healthItem += 220f;
				healthRegenItem += 6f;
				abilityPowerScalingItem +=3f;
				break;
				
			case "Avarice Blade":
				criticalChanceItem += 0.1f;
				break;
				
			case "B.F. Sword":
				attackDamageItem += 50f;
				break;
				
			case "Banner of Command":
				abilityPowerItem += 80f;
				coolDownReductionItem += 0.2f;
				break;
				
			case "Banshee's Veil":
				healthItem += 450f;
				magicResistItem += 55f;
				break;
				
			case "Berserker's Greaves":
				attackSpeedItem += 0.25f;
				break;
				
			case "Bilgewater Cutlass":
				attackDamageItem += 25f;
				lifestealPercentItem += 0.08f;
				break;
				
			case "Blackfire Torch":
				abilityPowerItem += 80f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Blade of the Ruined King":
				attackDamageItem += 25f;
				attackSpeedItem += 0.4f;
				lifestealPercentItem += 0.10f;
				break;
				
			case "Blasting Wand":
				abilityPowerItem += 40f;
				break;
				
			//case "Boots of Mobility": passives only
				
			//case "Boots of Speed": passives only
				
			//case "Boots of Swiftness": passives only
				
			case "Brawler's Gloves":
				criticalChanceItem += 0.08f;
				break;
				
			case "Catalyst the Protector":
				healthItem += 200f;
				manaItem += 300f;
				break;
				
			case "Chain Vest":
				armorItem += 40f;
				break;
				
			case "Chalice of Harmony":
				manaRegenItem += 7f;
				magicResistItem += 20f;
				break;
				
			case "Cloak of Agility":
				criticalChanceItem += 0.15f;
				break;
				
			case "Cloth Armor":
				armorItem += 15f;
				break;
				
			case "Dagger":
				attackSpeedItem += 0.15f;
				break;
				
			case "Deathfire Grasp":
				abilityPowerItem += 120f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Dervish Blade":
				attackSpeedItem += 0.5f;
				magicResistItem += 45f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Doran's Blade":
				healthItem += 70f;
				attackDamageItem += 7f;
				lifestealPercentItem += 0.03f;
				break;
				
			case "Doran's Ring":
				healthItem += 60f;
				manaRegenItem += 3f;
				abilityPowerItem += 15f;
				break;
				
			case "Doran's Shield":
				healthItem += 80f;
				healthRegenItem += 6f;
				break;
				
			//case "Elixir of Brilliance": separate category
				
			//case "Elixir of Fortitude": separate category
				
			case "Entropy":
				healthItem += 275f;
				attackDamageItem += 55f;
				break;
				
			case "Essence Reaver":
				attackDamageItem += 80f;
				lifestealPercentItem += 0.1f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Executioner's Calling":
				attackDamageItem += 25f;
				criticalChanceItem += 0.2f;
				break;
				
			case "Face of the Mountain":
				healthItem += 500f;
				healthRegenItem += 20f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Faerie Charm":
				manaRegenItem += 3f;
				break;
				
			case "Feral Flare":
				attackDamageItem += 12f;
				attackSpeedItem += 0.3f;
				break;
				
			case "Fiendish Codex":
				abilityPowerItem += 30f;
				break;
				
			case "Forbidden Idol":
				manaRegenItem += 8f;
				break;
				
			case "Frost Queen's Claim":
				manaRegenItem += 10f;
				abilityPowerItem += 50f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Frostfang":
				manaRegenItem += 5f;
				abilityPowerItem += 10f;
				break;
				
			case "Frozen Heart":
				manaItem += 400f;
				armorItem += 100f;
				coolDownReductionItem += 0.2f;
				break;
				
			case "Frozen Mallet":
				healthItem += 700f;
				attackDamageItem += 30f;
				break;
				
			case "Giant's Belt":
				healthItem += 380f;
				break;
				
			case "Glacial Shroud":
				manaItem += 250f;
				armorItem += 20f;
				break;
				
			case "Grez's Spectral Lantern":
				attackDamageItem += 15f;
				armorItem += 20f;
				lifestealPercentItem += 0.12f;
				break;
				
			case "Guardian Angel":
				armorItem += 50f;
				magicResistItem += 40f;
				break;
				
			case "Guardian's Horn":
				healthItem += 180f;
				healthRegenItem += 12f;
				break;
				
			case "Guinsoo's Rageblade":
				attackDamageItem += 30f;
				abilityPowerItem += 40f;
				guinsoosRagebladeNumber += 1f;
				break;
				
			case "Haunting Guise":
				healthItem += 200f;
				abilityPowerItem += 25f;
				break;
	
			case "Hexdrinker":
				attackDamageItem += 25f;
				magicResistItem += 25f;
				break;
				
			case "Hextech Gunblade":
				attackDamageItem += 45f;
				lifestealPercentItem += 0.12f;
				abilityPowerItem += 65f;
				break;
				
			case "Hextech Revolver":
				abilityPowerItem += 40f;
				break;
				
			case "Hextech Sweeper":
				healthItem += 225f;
				manaItem += 250f;
				armorItem += 25f;
				coolDownReductionItem += 0.2f;
				break;
				
			//case "Hunter's Machete": passives only
				
			case "Iceborn Gauntlet":
				manaItem += 500f;
				armorItem += 60f;
				abilityPowerItem += 30f;
				coolDownReductionItem += 0.1f;
				break;
				
			//case "Ichor of Illumination":
				
			//case "Ichor of Rage": have separate
				
			case "Infinity Edge":
				attackDamageItem += 80f;
				criticalChanceItem += 0.25f;
				break;
				
			//case "Ionian Boots of Lucidity": passives only
				
			case "Kindlegem":
				healthItem += 200f;
				break;
				
			case "Last Whisper":
				attackDamageItem += 40f;
				break;
				
			case "Liandry's Torment":
				healthItem += 300f;
				abilityPowerItem += 50f;
				break;
				
			case "Lich Bane":
				manaItem += 250f;
				abilityPowerItem += 80f;
				movementSpeedPercentItem += 0.05f;
				break;
				
			case "Locket of the Iron Solari":
				healthItem += 400f;
				magicResistItem += 20f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Long Sword":
				attackDamageItem += 10f;
				break;
				
			case "Lord Van Damm's Pillager":
				attackDamageItem += 70f;
				criticalChanceItem += 0.25f;
				break;
				
			case "Madred's Razors":
				attackSpeedItem += 0.15f;
				break;
	
			case "Manamune":
				manaItem += 250f;
				manaRegenItem += 7f;
				attackDamageItem += 25f;
				break;
				
			case "Maw of Malmortius":
				attackDamageItem += 60f;
				magicResistItem += 40f;
				break;
				
			case "Mejai's Soulstealer":
				abilityPowerItem += 20f;
				break;
				
			case "Mercurial Scimitar":
				attackDamageItem += 80f;
				magicResistItem += 45f;
				break;
				
			case "Mercury's Tread":
				magicResistItem += 25f;
				break;
				
			case "Mikael's Crucible":
				manaRegenItem += 20f;
				magicResistItem += 40f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Moonflair Spellblade":
				armorItem += 50f;
				magicResistItem += 50f;
				abilityPowerItem += 50f;
				break;
				
			case "Morellonomicon":
				manaRegenItem += 10f;
				abilityPowerItem += 80f;
				coolDownReductionItem += 0.2f;
				break;
				
			case "Muramana":
				manaItem += 1000f;
				manaRegenItem += 7f;
				attackDamageItem += 20f;
				break;
				
			case "Nashor's Tooth":
				attackSpeedItem += 0.5f;
				abilityPowerItem += 60f;
				break;
				
			case "Needlessly Large Rod":
				abilityPowerItem += 80f;
				break;
				
			case "Negatron Cloak":
				magicResistItem += 40f;
				break;
				
			case "Ninja Tabi":
				armorItem += 25f;
				break;
				
			case "Nomad's Medallion":
				healthRegenItem += 5f;
				manaRegenItem += 5f;
				movementSpeedFlatItem += 10f;
				break;
				
			case "Null-Magic Mantle":
				magicResistItem += 20f;
				break;
				
			case "Odyn's Veil":
				healthItem += 350f;
				manaItem += 350f;
				magicResistItem += 50f;
				break;
				
			case "Ohmwrecker":
				healthItem += 350f;
				abilityPowerItem += 50f;
				break;
	
			case "Orb of Winter":
				healthRegenItem += 20f;
				magicResistItem += 70f;
				break;
				
			case "Overlord's Bloodmail":
				healthItem += 850f;
				break;
				
			case "Phage":
				healthItem += 200f;
				attackDamageItem += 20f;
				break;
				
			case "Phantom Dancer":
				attackSpeedItem += 0.5f;
				criticalChanceItem += 0.3f;
				movementSpeedPercentItem += 0.05f;
				break;
				
			case "Pickaxe":
				attackDamageItem += 25f;
				break;
				
			case "Prospector's Blade":
				attackDamageItem += 16f;
				attackSpeedItem += 0.15f;
				break;
				
			case "Prospector's Ring":
				manaRegenItem += 6f;
				abilityPowerItem += 35f;
				break;
				
			case "Quicksilver Sash":
				magicResistItem += 45f;
				break;
				
			case "Quill Coat":
				armorItem += 20f;
				
			case "Rabadon's Deathcap":
				abilityPowerItem += 120f;
				break;
				
			case "Randuin's Omen":
				healthItem += 500f;
				armorItem += 70f;
				break;
				
			case "Ravenous Hydra (Melee Only)":
				healthRegenItem += 15f;
				attackDamageItem += 75f;
				lifestealPercentItem += 0.12f;
				break;
				
			case "Recursive Bow":
				attackSpeedItem += 0.3f;
				break;
				
			case "Rejuvenation Bead":
				healthRegenItem += 5f;
				break;
				
			case "Relic Shield":
				healthItem += 75f;
				break;
				
			case "Rod of Ages":
				healthItem += 450f;
				manaItem += 450f;
				abilityPowerItem += 60f;
				rodOfAgesStacks += 1;
				break;
				
			case "Ruby Crystal":
				healthItem += 150f;
				break;
				
			case "Ruby Sightstone":
				healthItem += 400f;
				break;
				
			case "Runaan's Hurricane (Ranged Only)":
				attackSpeedItem += 0.7f;
				break;
				
			case "Rylai's Crystal Scepter":
				healthItem += 400f;
				abilityPowerItem += 100f;
				break;
				
			case "Sanguine Blade":
				attackDamageItem += 45f;
				lifestealPercentItem += 0.1f;
				break;
				
			case "Sapphire Crystal":
				manaItem += 200f;
				break;
				
			case "Seeker's Armguard":
				armorItem += 30f;
				abilityPowerItem += 20f;
				break;
				
			case "Seraph's Embrace":
				manaItem += 1000f;
				manaRegenItem += 10f;
				abilityPowerItem += 60f;
				break;
				
			case "Sheen":
				manaItem += 200f;
				abilityPowerItem += 25f;
				break;
				
			case "Sightstone":
				healthItem += 150f;
				break;
				
			case "Sorcerer's Shoes":
				magicPenFlatItem += 15f;
				break;
				
			case "Spectre's Cowl":
				healthItem += 200f;
				magicResistItem += 45f;
				break;
				
			case "Spellthief's Edge":
				manaRegenItem += 2f;
				abilityPowerItem += 5f;
				break;
				
			//case "Spirit Stone": passives only - not important
				
			case "Spirit Visage":
				healthItem += 400f;
				healthRegenItem += 20f;
				magicResistItem += 55f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Spirit of the Ancient Golem":
				healthItem += 200f;
				coolDownReductionItem += 0.1f;
				armorItem += 20f;
				spiritOfTheAncientGolemPercentHealth += 1;
				break;
				
			case "Spirit of the Elder Lizard":
				attackDamageItem += 30f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Spirit of the Spectral Wraith":
				abilityPowerItem += 50f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Statikk Shiv":
				attackSpeedItem += 0.4f;
				criticalChanceItem += 0.2f;
				movementSpeedPercentItem += 0.06f;
				break;
	
			case "Stinger":
				attackSpeedItem += 0.4f;
				break;
				
			case "Sunfire Cape":
				healthItem += 450f;
				armorItem += 45f;
				break;
				
			case "Sword of the Divine":
				attackSpeedItem += 0.45f;
				break;
				
			case "Sword of the Occult":
				attackDamageItem += 10f;
				break;
				
			case "Talisman of Ascension":
				healthRegenItem += 15f;
				manaRegenItem += 15f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Targon's Brace":
				healthItem += 175f;
				healthRegenItem += 8f;
				break;
				
			case "Tear of the Goddess":
				manaItem += 250f;
				manaRegenItem += 6f;
				break;
				
			case "The Black Cleaver":
				healthItem += 200f;
				attackDamageItem += 50f;
				coolDownReductionItem += 0.1f;
				theBlackCleaverStacksPerHit += 1;
				break;
				
			case "The Bloodthirster":
				attackDamageItem += 80f;
				break;
				
			case "The Brutalizer":
				attackDamageItem += 25f;
				break;
				
			case "The Hex Core":
				abilityPowerScalingItem += 3f;
				
			case "The Lightbringer":
				attackDamageItem += 30f;
				criticalChanceItem += 0.3f;
				break;
				
			case "Thornmail":
				armorItem += 100f;
				break;
				
			case "Tiamat (Melee Only)":
				healthRegenItem += 15f;
				attackDamageItem += 40f;
				break;
				
			case "Trinity Force":
				healthItem += 250f;
				manaItem += 200f;
				attackDamageItem += 30f;
				attackSpeedItem += 0.3f;
				criticalChanceItem += 0.1f;
				abilityPowerItem += 30f;
				movementSpeedPercentItem += 0.08f;
				break;
				
			case "Twin Shadows":
				abilityPowerItem += 80f;
				coolDownReductionItem += 0.1f;
				movementSpeedPercentItem += 0.06f;
				break;
				
			case "Vampiric Scepter":
				attackDamageItem += 10f;
				lifestealPercentItem += 0.08f;
				break;
	
			case "Void Staff":
				abilityPowerItem += 70f;
				break;
				
			case "Warden's Mail":
				armorItem += 50f;
				break;
				
			case "Warmog's Armor":
				healthItem += 1000f;
				break;
				
			case "Wicked Hatchet":
				attackDamageItem += 20f;
				criticalChanceItem += 0.1f;
				break;
				
			case "Will of the Ancients":
				abilityPowerItem += 80f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Wit's End":
				attackSpeedItem += 0.50f;
				magicResistItem += 25f;
				break;
				
			case "Wooglet's Witchcap":
				armorItem += 45f;
				abilityPowerItem += 100f;
				break;
				
			case "Wriggle's Lantern":
				attackDamageItem += 12f;
				attackSpeedItem += 0.3f;
				break;
				
			case "Youmuu's Ghostblade":
				attackDamageItem += 30f;
				criticalChanceItem += 0.15f;
				coolDownReductionItem += 0.1f;
				break;
				
			case "Zeal":
				attackSpeedItem += 0.20f;
				criticalChanceItem += 0.1f;
				movementSpeedPercentItem += 0.05f;
				break;
				
			case "Zeke's Herald":
				healthItem += 250f;
				coolDownReductionItem += 0.2f;
				break;
				
			case "Zephyr":
				attackDamageItem += 25f;
				attackSpeedItem += 0.5f;
				coolDownReductionItem += 0.1f;
				movementSpeedPercentItem += 0.1f;
				break;
				
			case "Zhonya's Hourglass":
				armorItem += 50f;
				abilityPowerItem += 120f;
				break;
			}
		}
		
	
		if (item1.equals("Abyssal Scepter") || item2.equals("Abyssal Scepter") || item3.equals("Abyssal Scepter") || item4.equals("Abyssal Scepter") || item5.equals("Abyssal Scepter") || item6.equals("Abyssal Scepter")){
			magicRedFlatItem = 20;
		}
		if (item1.equals("Aegis of the Legion") || item2.equals("Aegis of the Legion") || item3.equals("Aegis of the Legion") || item4.equals("Aegis of the Legion") ||item5.equals("Aegis of the Legion") || item6.equals("Aegis of the Legion") || item1.equals("Locket of the Iron Solari") || item2.equals("Locket of the Iron Solari") || item3.equals("Locket of the Iron Solari") || item4.equals("Locketof the Iron Solari") || item5.equals("Locket of the Iron Solari") || item6.equals("Locket of the Iron Solari")){
			magicResistItem += 20;
			healthRegenItem += 10;
		}
		if (item1.equals("Aether Wisp") || item2.equals("Aether Wisp") || item3.equals("Aether Wisp") || item4.equals("Aether Wisp") || item5.equals("Aether Wisp") || item6.equals("Aether Wisp")){
			movementSpeedPercentItem += 0.05;
		}
		if (item1.equals("Archangel's Staff") || item2.equals("Archangel's Staff") || item3.equals("Archangel's Staff") || item4.equals("Archangel's Staff") || item5.equals("Archangel's Staff") || item6.equals("Archangel's Staff")){
			insightPassive = true;
			manaChargeArchangelsStaffPassive = true;
		}
		if (item1.equals("Ardent Censer") || item2.equals("Ardent Censer") || item3.equals("Ardent Censer") || item4.equals("Ardent Censer") || item5.equals("Ardent Censer") || item6.equals("Ardent Censer")){
			movementSpeedPercentItem += 0.08;
		}
		if (item1.equals("Atma's Impaler") || item2.equals("Atma's Impaler") || item3.equals("Atma's Impaler") || item4.equals("Atma's Impaler") || item5.equals("Atma's Impaler") || item6.equals("Atma's Impaler")){
			atmasImpalerPassive = true;
		}
		if (item1.equals("Banshee's Veil") || item2.equals("Banshee's Veil") || item3.equals("Banshee's Veil") || item4.equals("Banshee's Veil") || item5.equals("Banshee's Veil") || item6.equals("Banshee's Veil")){
			healthRegenItem += 45;
		}
		if (item1.equals("Berserker's Greaves") || item2.equals("Berserker's Greaves") || item3.equals("Berserker's Greaves") || item4.equals("Berserker's Greaves") ||item5.equals("Berserker's Greaves") || item6.equals("Berserker's Greaves")){
			movementSpeedFlatItem += 45;
		}
		if (item1.equals("Blade of the Ruined King") || item2.equals("Blade of the Ruined King") || item3.equals("Blade of the Ruined King") || item4.equals("Blade of the Ruined King") || item5.equals("Blade of the Ruined King") || item6.equals("Blade of the Ruined King")){
			bladeOfTheRuinedKingPassive = true;
		}
		if (item1.equals("Doran's Shield") || item2.equals("Doran's Shield") || item3.equals("Doran's Shield") || item4.equals("Doran's Shield") || item5.equals("Doran's Shield") || item6.equals("Doran's Shield")){
			doransShieldPassive = true;
		}
		if (item1.equals("Executioner's Calling") || item2.equals("Executioner's Calling") || item3.equals("Executioner's Calling") || item4.equals("Executioner's Calling") || item5.equals("Executioner's Calling") || item6.equals("Executioner's Calling")){
			executionersCallingPassive = true;
		}
		if (item1.equals("Feral Flare") || item2.equals("Feral Flare") || item3.equals("Feral Flare") || item4.equals("Feral Flare") || item5.equals("Feral Flare") || item6.equals("Feral Flare")){
			feralFlarePassive = true;
		}
		if (item1.equals("Fiendish Codex") || item2.equals("Fiendish Codex") || item3.equals("Fiendish Codex") || item4.equals("Fiendish Codex") || item5.equals("Fiendish Codex") || item6.equals("Fiendish Codex")){
			coolDownReductionItem += 0.10;
		}
		if (item1.equals("Forbidden Idol") || item2.equals("Forbidden Idol") || item3.equals("Forbidden Idol") || item4.equals("Forbidden Idol") || item5.equals("Forbidden Idol") || item6.equals("Forbidden Idol")){
			coolDownReductionItem += 0.10;
		}
		if (item1.equals("Frost Queen's Claim") || item2.equals("Frost Queen's Claim") || item3.equals("Frost Queen's Claim") || item4.equals("Frost Queen's Claim") ||item5.equals("Frost Queen's Claim") || item6.equals("Frost Queen's Claim")){
			frostQueensClaimPassive = true;
		}
		if (item1.equals("Frostfang") || item2.equals("Frostfang") || item3.equals("Frostfang") || item4.equals("Frostfang") || item5.equals("Frostfang") || item6.equals("Frostfang")){
			frostFangPassive = true;
		}
		if (item1.equals("Frozen Heart") || item2.equals("Frozen Heart") || item3.equals("Frozen Heart") || item4.equals("Frozen Heart") || item5.equals("Frozen Heart") || item6.equals("Frozen Heart")){
			frozenHeartPassive = true;
		}
		if (item1.equals("Glacial Shroud") || item2.equals("Glacial Shroud") || item3.equals("Glacial Shroud") || item4.equals("Glacial Shroud") || item5.equals("Glacial Shroud") || item6.equals("Glacial Shroud")){
			coolDownReductionItem += 0.10;
		}
		if (item1.equals("Guardian Angel") || item2.equals("Guardian Angel") || item3.equals("Guardian Angel") || item4.equals("Guardian Angel") || item5.equals("Guardian Angel") || item6.equals("Guardian Angel")){
			guardianAngelPassive = true;
		}
		if (item1.equals("Guinsoo's Rageblade") || item2.equals("Guinsoo's Rageblade") || item3.equals("Guinsoo's Rageblade") || item4.equals("Guinsoo's Rageblade") ||item5.equals("Guinsoo's Rageblade") || item6.equals("Guinsoo's Rageblade")){
			guinsoosRagebladeUniquePassive = true;
		}
		if (item1.equals("Haunting Guise") || item2.equals("Haunting Guise") || item3.equals("Haunting Guise") || item4.equals("Haunting Guise") || item5.equals("Haunting Guise") || item6.equals("Haunting Guise")){
			eyesOfPainPassive = true;
		}
		if (item1.equals("Hexdrinker") || item2.equals("Hexdrinker") || item3.equals("Hexdrinker") || item4.equals("Hexdrinker") || item5.equals("Hexdrinker") || item6.equals("Hexdrinker")){
			hexDrinkerPassive = true;
			hexDrinkerShield = true;
		}
		if (item1.equals("Hextech Gunblade") || item2.equals("Hextech Gunblade") || item3.equals("Hextech Gunblade") || item4.equals("Hextech Gunblade") || item5.equals("Hextech Gunblade") || item6.equals("Hextech Gunblade")){
			spellVampItem += 0.20;
		}
		if (item1.equals("Hextech Revolver") || item2.equals("Hextech Revolver") || item3.equals("Hextech Revolver") || item4.equals("Hextech Revolver") || item5.equals("Hextech Revolver") || item6.equals("Hextech Revolver")){
			spellVampItem += 0.12;
		}
		if (item1.equals("Infinity Edge") || item2.equals("Infinity Edge") || item3.equals("Infinity Edge") || item4.equals("Infinity Edge") || item5.equals("Infinity Edge") || item6.equals("Infinity Edge")){
			criticalDamageItem += 0.5;
		}
		if (item1.equals("Kindlegem") || item2.equals("Kindlegem") || item3.equals("Kindlegem") || item4.equals("Kindlegem") || item5.equals("Kindlegem") || item6.equals("Kindlegem")){
			coolDownReductionItem += 0.10;
		}
		if (item1.equals("Last Whisper") || item2.equals("Last Whisper") || item3.equals("Last Whisper") || item4.equals("Last Whisper") || item5.equals("Last Whisper") || item6.equals("Last Whisper")){
			armorPenPercentItem += 0.35;
		}
		if (item1.equals("Liandry's Torment") || item2.equals("Liandry's Torment") || item3.equals("Liandry's Torment") || item4.equals("Liandry's Torment") || item5.equals("Liandry's Torment") || item6.equals("Liandry's Torment")){
			eyesOfPainPassive = true;
		}
		if (item1.equals("Lord Van Damm's Pillager") || item2.equals("Lord Van Damm's Pillager") || item3.equals("Lord Van Damm's Pillager") || item4.equals("Lord Van Damm's Pillager") || item5.equals("Lord Van Damm's Pillager") || item6.equals("Lord Van Damm's Pillager")){
			criticalDamageItem += 0.5;
		}
		if (item1.equals("Manamune") || item2.equals("Manamune") || item3.equals("Manamune") || item4.equals("Manamune") || item5.equals("Manamune") || item6.equals("Manamune")){
			awePassive = true;
			manaChargePassive = true;
		}
		if (item1.equals("Maw of Malmortius") || item2.equals("Maw of Malmortius") || item3.equals("Maw of Malmortius") || item4.equals("Maw of Malmortius") || item5.equals("Maw of Malmortius") || item6.equals("Maw of Malmortius")){
			mawOfMalmortiusPassive = true;
			mawOfMalmortiusShield = true;
		}
		if (item1.equals("Mejai's Soulstealer") || item2.equals("Mejai's Soulstealer") || item3.equals("Mejai's Soulstealer") || item4.equals("Mejai's Soulstealer") || item5.equals("Mejai's Soulstealer") || item6.equals("Mejai's Soulstealer")){
			mejaisSoulstealerPassive = true;
		}
		if (item1.equals("Morellonomicon") || item2.equals("Morellonomicon") || item3.equals("Morellonomicon") || item4.equals("Morellonomicon") || item5.equals("Morellonomicon") || item6.equals("Morellonomicon")){
			morellonomiconPassive = true;
		}
		if (item1.equals("Muramana") || item2.equals("Muramana") || item3.equals("Muramana") || item4.equals("Muramana") || item5.equals("Muramana") || item6.equals("Muramana")){
			awePassive = true;
		}
		if (item1.equals("Nashor's Tooth") || item2.equals("Nashor's Tooth") || item3.equals("Nashor's Tooth") || item4.equals("Nashor's Tooth") || item5.equals("Nashor's Tooth") || item6.equals("Nashor's Tooth")){
			coolDownReductionItem += 0.20;
			nashorsToothPassive = true;
		}
		if (item1.equals("Odyn's Veil") || item2.equals("Odyn's Veil") || item3.equals("Odyn's Veil") || item4.equals("Odyn's Veil") || item5.equals("Odyn's Veil") || item6.equals("Odyn's Veil")){
			odynsVeilPassive = true;
		}
		if (item1.equals("Orb of Winter") || item2.equals("Orb of Winter") || item3.equals("Orb of Winter") || item4.equals("Orb of Winter") || item5.equals("Orb of Winter") || item6.equals("Orb of Winter")){
			orbOfWinterPassive = true;
		}
		if (item1.equals("Prospector's Blade") || item2.equals("Prospector's Blade") || item3.equals("Prospector's Blade") || item4.equals("Prospector's Blade") || item5.equals("Prospector's Blade") || item6.equals("Prospector's Blade") || item1.equals("Prospector's Ring") || item2.equals("Prospector's Ring") || item3.equals("Prospector's Ring") || item4.equals("Prospector's Ring") || item5.equals("Prospector's Ring") || item6.equals("Prospector's Ring")){
			healthItem += 150;
		}
		if (item1.equals("Rabadon's Deathcap") || item2.equals("Rabadon's Deathcap") || item3.equals("Rabadon's Deathcap") || item4.equals("Rabadon's Deathcap") || item5.equals("Rabadon's Deathcap") || item6.equals("Rabadon's Deathcap")){
			rabadonsDeathcapPassive = 1.3;
		}
		if (item1.equals("Randuin's Omen") || item2.equals("Randuin's Omen") || item3.equals("Randuin's Omen") || item4.equals("Randuin's Omen") || item5.equals("Randuin's Omen") || item6.equals("Randuin's Omen")){
			coldSteelPassive = true;
		}
		if (item1.equals("Sanguine Blade") || item2.equals("Sanguine Blade") || item3.equals("Sanguine Blade") || item4.equals("Sanguine Blade") || item5.equals("Sanguine Blade") || item6.equals("Sanguine Blade")){
			sanguineBladePassive = true;
		}
		if (item1.equals("Seeker's Armguard") || item2.equals("Seeker's Armguard") || item3.equals("Seeker's Armguard") || item4.equals("Seeker's Armguard") || item5.equals("Seeker's Armguard") || item6.equals("Seeker's Armguard")){
			seekersArmguardPassive = true;
		}
		if (item1.equals("Seraph's Embrace") || item2.equals("Seraph's Embrace") || item3.equals("Seraph's Embrace") || item4.equals("Seraph's Embrace") || item5.equals("Seraph's Embrace") || item6.equals("Seraph's Embrace")){
			insightPassive = true;
		}
		if (item1.equals("Spectre's Cowl") || item2.equals("Spectre's Cowl") || item3.equals("Spectre's Cowl") || item4.equals("Spectre's Cowl") || item5.equals("Spectre's Cowl") || item6.equals("Spectre's Cowl")){
			healthRegenItem += 15;
		}
		if (item1.equals("Spellthief's Edge") || item2.equals("Spellthief's Edge") || item3.equals("Spellthief's Edge") || item4.equals("Spellthief's Edge") || item5.equals("Spellthief's Edge") || item6.equals("Spellthief's Edge")){
			spellthiefsEdgePassive = true;
		}
		if (item1.equals("Spirit Visage") || item2.equals("Spirit Visage") || item3.equals("Spirit Visage") || item4.equals("Spirit Visage") || item5.equals("Spirit Visage") || item6.equals("Spirit Visage")){
			spiritVisagePassive = true;
		}
		if (item1.equals("Spirit of the Elder Lizard") || item2.equals("Spirit of the Elder Lizard") || item3.equals("Spirit of the Elder Lizard") || item4.equals("Spirit of the Elder Lizard") || item5.equals("Spirit of the Elder Lizard") || item6.equals("Spirit of the Elder Lizard")){
			spiritOfTheElderLizardPassive = true;
		}
		if (item1.equals("Spirit of the Spectral Wraith") || item2.equals("Spirit of the Spectral Wraith") || item3.equals("Spirit of the Spectral Wraith") || item4.equals("Spirit of the Spectral Wraith") || item5.equals("Spirit of the Spectral Wraith") || item6.equals("Spirit of the Spectral Wraith")){
			spiritOfTheSpectralWraithPassive = true;
		}
		if (item1.equals("Statikk Shiv") || item2.equals("Statikk Shiv") || item3.equals("Statikk Shiv") || item4.equals("Statikk Shiv") || item5.equals("Statikk Shiv") || item6.equals("Statikk Shiv")){
			statikkShivPassive = true;
		}
		if (item1.equals("Stinger") || item2.equals("Stinger") || item3.equals("Stinger") || item4.equals("Stinger") || item5.equals("Stinger") || item6.equals("Stinger")){
			coolDownReductionItem += 0.10;
		}
		if (item1.equals("Sunfire Cape") || item2.equals("Sunfire Cape") || item3.equals("Sunfire Cape") || item4.equals("Sunfire Cape") || item5.equals("Sunfire Cape") || item6.equals("Sunfire Cape")){
			sunfireCapePassive = true;
		}
		if (item1.equals("Sword of the Occult") || item2.equals("Sword of the Occult") || item3.equals("Sword of the Occult") || item4.equals("Sword of the Occult") || item5.equals("Sword of the Occult") || item6.equals("Sword of the Occult")){
			swordOfTheOccultPassive = true;
		}
		if (item1.equals("Tear of the Goddess") || item2.equals("Tear of the Goddess") || item3.equals("Tear of the Goddess") || item4.equals("Tear of the Goddess") || item5.equals("Tear of the Goddess") || item6.equals("Tear of the Goddess")){
			manaChargePassive = true;
		}
		if (item1.equals("The Black Cleaver") || item2.equals("The Black Cleaver") || item3.equals("The Black Cleaver") || item4.equals("The Black Cleaver") || item5.equals("The Black Cleaver") || item6.equals("The Black Cleaver")){
			armorPenFlatItem += 10;
		}
		if (item1.equals("The Bloodthirster") || item2.equals("The Bloodthirster") || item3.equals("The Bloodthirster") || item4.equals("The Bloodthirster") || item5.equals("The Bloodthirster") || item6.equals("The Bloodthirster")){
			theBloodthirsterPassive = true;
			lifestealPercentItem += 0.2;
		}
		if (item1.equals("The Brutalizer") || item2.equals("The Brutalizer") || item3.equals("The Brutalizer") || item4.equals("The Brutalizer") || item5.equals("The Brutalizer") || item6.equals("The Brutalizer")){
			coolDownReductionItem += 0.10;
		}
		if (item1.equals("The Lightbringer") || item2.equals("The Lightbringer") || item3.equals("The Lightbringer") || item4.equals("The Lightbringer") || item5.equals("The Lightbringer") || item6.equals("The Lightbringer")){
			theLightbringerPassive = true;
		}
		if (item1.equals("Thornmail") || item2.equals("Thornmail") || item3.equals("Thornmail") || item4.equals("Thornmail") || item5.equals("Thornmail") || item6.equals("Thornmail")){
			thornmailPassive = true;
		}
		if (item1.equals("Void Staff") || item2.equals("Void Staff") || item3.equals("Void Staff") || item4.equals("Void Staff") || item5.equals("Void Staff") || item6.equals("Void Staff")){
			magicPenPercentItem += 0.35;
		}
		if (item1.equals("Warden's Mail") || item2.equals("Warden's Mail") || item3.equals("Warden's Mail") || item4.equals("Warden's Mail") || item5.equals("Warden's Mail") || item6.equals("Warden's Mail")){
			coldSteelPassive = true;
		}
		if (item1.equals("Warmog's Armor") || item2.equals("Warmog's Armor") || item3.equals("Warmog's Armor") || item4.equals("Warmog's Armor") || item5.equals("Warmog's Armor") || item6.equals("Warmog's Armor")){
			warmogsArmorPassive = true;
		}
		if (item1.equals("Wicked Hatchet") || item2.equals("Wicked Hatchet") || item3.equals("Wicked Hatchet") || item4.equals("Wicked Hatchet") || item5.equals("Wicked Hatchet") || item6.equals("Wicked Hatchet")){
			wickedHatchetPassive = true;
		}
		if (item1.equals("Will of the Ancients") || item2.equals("Will of the Ancients") || item3.equals("Will of the Ancients") || item4.equals("Will of the Ancients") || item5.equals("Will of the Ancients") || item6.equals("Will of the Ancients")){
			spellVampItem += 0.20;
		}
		if (item1.equals("Wit's End") || item2.equals("Wit's End") || item3.equals("Wit's End") || item4.equals("Wit's End") || item5.equals("Wit's End") || item6.equals("Wit's End")){
			bonusMagicAttackDamageItem += 42;
			witsEndSecondPassive = true;
		}
		if (item1.equals("Wooglet's Witchcap") || item2.equals("Wooglet's Witchcap") || item3.equals("Wooglet's Witchcap") || item4.equals("Wooglet's Witchcap") || item5.equals("Wooglet's Witchcap") || item6.equals("Wooglet's Witchcap")){
			woogletsWitchcapPassive = 1.25;
		}
		if (item1.equals("Youmuu's Ghostblade") || item2.equals("Youmuu's Ghostblade") || item3.equals("Youmuu's Ghostblade") || item4.equals("Youmuu's Ghostblade") ||item5.equals("Youmuu's Ghostblade") || item6.equals("Youmuu's Ghostblade")){
			armorPenFlatItem = 20;
		}
		if (item1.equals("Zeke's Herald") || item2.equals("Zeke's Herald") || item3.equals("Zeke's Herald") || item4.equals("Zeke's Herald") || item5.equals("Zeke's Herald") || item6.equals("Zeke's Herald")){
			lifestealPercentItem += 0.10;
			attackDamageItem += 20;
		}
		
		
		
		
		//Boots must be in ascending order of MS boost and with = instead of += so that the one that gives the largest MS boost 
		if (item1.equals("Boots of Mobility") || item2.equals("Boots of Mobility") || item3.equals("Boots of Mobility") || item4.equals("Boots of Mobility") || item5.equals("Boots of Mobility") || item6.equals("Boots of Mobility")){
			movementSpeedFlatItem = 25;
		}
		if (item1.equals("Boots of Speed") || item2.equals("Boots of Speed") || item3.equals("Boots of Speed") || item4.equals("Boots of Speed") || item5.equals("Bootsof Speed") || item6.equals("Boots of Speed")){
			movementSpeedFlatItem = 25;
		}
		if (item1.equals("Ionian Boots of Lucidity") || item2.equals("Ionian Boots of Lucidity") || item3.equals("Ionian Boots of Lucidity") || item4.equals("Ionian Boots of Lucidity") || item5.equals("Ionian Boots of Lucidity") || item6.equals("Ionian Boots of Lucidity")){
			coolDownReductionItem += 0.15;
			movementSpeedFlatItem = 45;
		}
		if (item1.equals("Mercury's Treads") || item2.equals("Mercury's Treads") || item3.equals("Mercury's Treads") || item4.equals("Mercury's Treads") || item5.equals("Mercury's Treads") || item6.equals("Mercury's Treads")){
			movementSpeedFlatItem = 45;
		}
		if (item1.equals("Ninja Tabi") || item2.equals("Ninja Tabi") || item3.equals("Ninja Tabi") || item4.equals("Ninja Tabi") || item5.equals("Ninja Tabi") || item6.equals("Ninja Tabi")){
			movementSpeedFlatItem = 45;
			ninjaTabiPassive = true;
		}
		if (item1.equals("Sorcerer's Shoes") || item2.equals("Sorcerer's Shoes") || item3.equals("Sorcerer's Shoes") || item4.equals("Sorcerer's Shoes") || item5.equals("Sorcerer's Shoes") || item6.equals("Sorcerer's Shoes")){
			movementSpeedFlatItem = 45;	
		}
		if (item1.equals("Boots of Swiftness") || item2.equals("Boots of Swiftness") || item3.equals("Boots of Swiftness") || item4.equals("Boots of Swiftness") || item5.equals("Boots of Swiftness") || item6.equals("Boots of Swiftness")){
			movementSpeedFlatItem = 60;
		}
		
		
		//For when unique passives have the same name
		
		if (frostQueensClaimPassive == true){
			frostFangPassive = false;
			spellthiefsEdgePassive = false;
		}
		if (frostFangPassive == true){
			spellthiefsEdgePassive = false;
		}
		
		
		if (eyesOfPainPassive == true){
			magicPenFlatItem += 15;
		}
		
		
		if (manaChargePassive == true && manaChargeArchangelsStaffPassive == true){//archangel's staff overules tear and manamune
			manaChargePassive = false;
		}

		
		
		
		
		////////////////////////////////////////EXPLAIN HOW PASSIVES STACK WITH EACH OTHER FOR ITEMS

	}
}
