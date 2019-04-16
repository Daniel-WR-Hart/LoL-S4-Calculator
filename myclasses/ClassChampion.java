package com.leagueoflegendscalculator.myclasses;


public class ClassChampion{

	public int id;
	String userSelectedChampion;
	public int level;
	public int qskill;
	public int wskill;
	public int eskill;
	public int rskill;
	
	
	
	public float health = 0;
	public float healthPerLevel = 0;
	public float healthRegen = 0;
	public float healthRegenPerLevel = 0;
	
	public float mana = 0;
	public float manaPerLevel = 0;
	public float manaRegen = 0;
	public float manaRegenPerLevel = 0;
	
	public float energy = 0;
	public float energyPerLevel = 0;
	public float energyRegen = 0;
	public float energyRegenPerLevel = 0;
	
	public float attackDamage = 0;
	public float attackDamagePerLevel = 0;
	public float attackSpeed = 0;
	public float attackSpeedPerLevel = 0;
	public float armor = 0;
	public float armorPerLevel = 0;
	public float magicResist = 0;
	public float magicResistPerLevel = 0;
	public float movementSpeed = 0;
	public float range = 0;
	public float criticalDamage = 2;

	
	//each champion get their own unique variables nested in an if statement (if include abilities and passives) that
	//can modify the above stats, e.g. nasus gets 10% extra lifesteal, and missfortune gets more damage, akali's
	//bonus damage and spellvamp is also calculated separately.
		
	public ClassChampion (String userSelectedChampion, int level, int qskill, int wskill, int eskill, int rskill){
		this.userSelectedChampion = userSelectedChampion;
		this.level = level;
		this.qskill = qskill;
		this.wskill = wskill;
		this.eskill = eskill;
		this.rskill = rskill;
		
		//The methods to be used to change the variables must be called in the contructors that will be used if all the work wont be done in the contructors directly
		ChampionStats();
		}

	public void ChampionStats(){

		switch (userSelectedChampion){
//Base stats on http://leagueoflegends.wikia.com/wiki/Base_champion_statistics for stats like health and attack damage don't include the level 1 /per level bonus, but the official patch notes do.
		case "Aatrox":
		
			health = 				537.8f;
			healthPerLevel = 		85f;
			healthRegen = 			6.59f;
			healthRegenPerLevel = 	0.5f;
			mana = 					30f;
			manaPerLevel = 			45f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			60.376f;
			attackDamagePerLevel = 	3.2f;
			attackSpeed = 			0.651f;
			attackSpeedPerLevel = 	0.03f;
			armor = 				24.384f;
			armorPerLevel = 		3.8f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				150f;
			break;

		case "Ahri":
		
			health =				514.4f;
			healthPerLevel = 		80f;
			healthRegen = 			6.505f;
			healthRegenPerLevel = 	0.6f;
			mana = 					334f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			53.04f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.668f;
			attackSpeedPerLevel = 	0.02f;
			armor = 				20.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				550f;
			break;

		case "Akali":
		
			health = 				587.8f;
			healthPerLevel = 		85f;
			healthRegen = 			8.34f;
			healthRegenPerLevel = 	0.65f;
			energy = 				200f;
			energyPerLevel = 		0f;
			energyRegen = 			50f;
			energyRegenPerLevel = 	0f;
			attackDamage = 			58.378f;
			attackDamagePerLevel = 	3.2f;
			attackSpeed = 			0.694f;
			attackSpeedPerLevel = 	0.031f;
			armor = 				26.38f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Alistar":
		
			health = 				613.36f;
			healthPerLevel = 		102f;
			healthRegen = 			8.675f;
			healthRegenPerLevel = 	0.85f;
			mana = 					278.84f;
			manaPerLevel = 			38f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			61.1116f;
			attackDamagePerLevel = 	3.62f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.02125f;
			armor = 				24.38f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		330f;
			range = 				125f;
			break;

		case "Amumu":
		
			health = 				613.12f;
			healthPerLevel = 		84f;
			healthRegen = 			8.875f;
			healthRegenPerLevel = 	0.85f;
			mana = 					287.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.38f;
			manaRegenPerLevel = 	0.525f;
			attackDamage = 			53.384f;
			attackDamagePerLevel = 	3.8f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.0218f;
			armor = 				23.544f;
			armorPerLevel = 		3.3f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Anivia":
		
			health = 				467.6f;
			healthPerLevel = 		70f;
			healthRegen = 			5.57f;
			healthRegenPerLevel = 	0.55f;
			mana = 					346.04f;
			manaPerLevel = 			53f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			51.376f;
			attackDamagePerLevel = 	3.2f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0168f;
			armor = 				21.22f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				600f;
			break;

		case "Annie":
		
			health = 				511.68f;
			healthPerLevel = 		76f;
			healthRegen = 			5.42f;
			healthRegenPerLevel = 	0.55f;
			mana = 					334f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			50.41f;
			attackDamagePerLevel = 	2.625f;
			attackSpeed = 			0.579f;
			attackSpeedPerLevel = 	0.0136f;
			armor = 				19.22f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				625f;
			break;

		case "Ashe":
		
			health = 				527.72f;
			healthPerLevel = 		79f;
			healthRegen = 			5.42f;
			healthRegenPerLevel = 	0.55f;
			mana = 					231.8f;
			manaPerLevel = 			35f;
			manaRegen = 			6.97f;
			manaRegenPerLevel = 	0.4f;
			attackDamage = 			51.088f;
			attackDamagePerLevel = 	2.85f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.04f;
			armor = 				21.212f;
			armorPerLevel = 		3.4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				600f;
			break;

		case "Azir":
		
			health = 				524.4f;
			healthPerLevel = 		80f;
			healthRegen = 			6.92f;
			healthRegenPerLevel = 	0.55f;
			mana = 					350.56f;
			manaPerLevel = 			42f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			49.704f;
			attackDamagePerLevel = 	2.8f;
			attackSpeed = 			0.6f;
			attackSpeedPerLevel = 	0.015f;
			armor = 				19.04f;
			armorPerLevel = 		3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				525f;
			break;

		case "Blitzcrank":
		
			health = 				582.6f;
			healthPerLevel = 		95f;
			healthRegen = 			8.51f;
			healthRegenPerLevel = 	0.75f;
			mana = 					267.2f;
			manaPerLevel = 			40f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			61.54f;
			attackDamagePerLevel = 	3.5f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0113f;
			armor = 				24.38f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		325f;
			range = 				125f;
			break;

		case "Brand":
		
			health = 				507.68f;
			healthPerLevel = 		76f;
			healthRegen = 			5.42f;
			healthRegenPerLevel = 	0.55f;
			mana = 					325.6f;
			manaPerLevel = 			45f;
			manaRegen = 			8.005f;
			manaRegenPerLevel = 	0.6f;
			attackDamage = 			57.04f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0136f;
			armor = 				21.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		340f;
			range = 				550f;
			break;

		case "Braum":
		
			health = 				576.16f;
			healthPerLevel = 		87f;
			healthRegen = 			8.18f;
			healthRegenPerLevel = 	1f;
			mana = 					310.6f;
			manaPerLevel = 			45f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			55.376f;
			attackDamagePerLevel = 	3.2f;
			attackSpeed = 			0.644f;
			attackSpeedPerLevel = 	0.035f;
			armor = 				26.72f;
			armorPerLevel = 		4f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Caitlyn":
		
			health = 				524.4f;
			healthPerLevel = 		80f;
			healthRegen = 			5.67f;
			healthRegenPerLevel = 	0.55f;
			mana = 					313.8f;
			manaPerLevel = 			35f;
			manaRegen = 			7.42f;
			manaRegenPerLevel = 	0.55f;
			attackDamage = 			50.04f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.04f;
			armor = 				22.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				650f;
			break;

		case "Cassiopeia":
		
			health = 				506f;
			healthPerLevel = 		75f;
			healthRegen = 			5.69f;
			healthRegenPerLevel = 	0.5f;
			mana = 					370.8f;
			manaPerLevel = 			60f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			50.376f;
			attackDamagePerLevel = 	3.2f;
			attackSpeed = 			0.647f;
			attackSpeedPerLevel = 	0.0168f;
			armor = 				22.22f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				550f;
			break;

		case "Cho'Gath":
		
			health = 				574.4f;
			healthPerLevel = 		80f;
			healthRegen = 			8.925f;
			healthRegenPerLevel = 	0.85f;
			mana = 					272.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.205f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			61.156f;
			attackDamagePerLevel = 	4.2f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0144f;
			armor = 				28.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Corki":
		
			health = 				512.76f;
			healthPerLevel = 		82f;
			healthRegen = 			5.42f;
			healthRegenPerLevel = 	0.55f;
			mana = 					305.16f;
			manaPerLevel = 			37f;
			manaRegen = 			7.42f;
			manaRegenPerLevel = 	0.55f;
			attackDamage = 			51.24f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.023f;
			armor = 				23.38f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				550f;
			break;

		case "Darius":
		
			health = 				582.24f;
			healthPerLevel = 		93f;
			healthRegen = 			9.845f;
			healthRegenPerLevel = 	0.95f;
			mana = 					263f;
			manaPerLevel = 			37.5f;
			manaRegen = 			6.585f;
			manaRegenPerLevel = 	0.35f;
			attackDamage = 			55.88f;
			attackDamagePerLevel = 	3.5f;
			attackSpeed = 			0.679f;
			attackSpeedPerLevel = 	0.0265f;
			armor = 				29.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		340f;
			range = 				125f;
			break;

		case "Diana":
		
			health = 				589.2f;
			healthPerLevel = 		90f;
			healthRegen = 			7.425f;
			healthRegenPerLevel = 	0.85f;
			mana = 					297.2f;
			manaPerLevel = 			40f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			53.04f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0225f;
			armor = 				26.048f;
			armorPerLevel = 		3.6f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				150f;
			break;

		case "Dr.Mundo":
		
			health = 				582.52f;
			healthPerLevel = 		89f;
			healthRegen = 			7.76f;
			healthRegenPerLevel = 	0.75f;
			mana = 					0f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			61.27f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.028f;
			armor = 				26.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Draven":
		
			health = 				557.76f;
			healthPerLevel = 		82f;
			healthRegen = 			6.175f;
			healthRegenPerLevel = 	0.7f;
			mana = 					310.56f;
			manaPerLevel = 			42f;
			manaRegen = 			8.04f;
			manaRegenPerLevel = 	0.65f;
			attackDamage = 			50.38f;
			attackDamagePerLevel = 	3.5f;
			attackSpeed = 			0.679f;
			attackSpeedPerLevel = 	0.027f;
			armor = 				25.544f;
			armorPerLevel = 		3.3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				550f;
			break;

		case "Elise":
		
			health = 				529.4f;
			healthPerLevel = 		80f;
			healthRegen = 			5.705f;
			healthRegenPerLevel = 	0.6f;
			mana = 					324f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			50.54f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0175f;
			armor = 				22.128f;
			armorPerLevel = 		3.35f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				550f;
			break;

		case "Evelynn":
		
			health = 				531.2f;
			healthPerLevel = 		90f;
			healthRegen = 			9.82f;
			healthRegenPerLevel = 	0.55f;
			mana = 					265.6f;
			manaPerLevel = 			45f;
			manaRegen = 			8.105f;
			manaRegenPerLevel = 	0.6f;
			attackDamage = 			53.88f;
			attackDamagePerLevel = 	3.5f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.036f;
			armor = 				26.5f;
			armorPerLevel = 		3.8f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		340f;
			range = 				125f;
			break;

		case "Ezreal":
		
			health = 				484.4f;
			healthPerLevel = 		80f;
			healthRegen = 			6.42f;
			healthRegenPerLevel = 	0.55f;
			mana = 					310.6f;
			manaPerLevel = 			45f;
			manaRegen = 			8.09f;
			manaRegenPerLevel = 	0.65f;
			attackDamage = 			50.24f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.028f;
			armor = 				21.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				550f;
			break;

		case "Fiddlesticks":
		
			health = 				524.4f;
			healthPerLevel = 		80f;
			healthRegen = 			5.605f;
			healthRegenPerLevel = 	0.6f;
			mana = 					350.12f;
			manaPerLevel = 			59f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			48.38f;
			attackDamagePerLevel = 	2.625f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0211f;
			armor = 				20.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				480f;
			break;

		case "Fiora":
		
			health = 				592.8f;
			healthPerLevel = 		85f;
			healthRegen = 			6.84f;
			healthRegenPerLevel = 	0.8f;
			mana = 					287.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.59f;
			manaRegenPerLevel = 	0.5f;
			attackDamage = 			59.876f;
			attackDamagePerLevel = 	3.2f;
			attackSpeed = 			0.672f;
			attackSpeedPerLevel = 	0.03f;
			armor = 				24.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Fizz":
		
			health = 				558.48f;
			healthPerLevel = 		86f;
			healthRegen = 			8.175f;
			healthRegenPerLevel = 	0.7f;
			mana = 					267.2f;
			manaPerLevel = 			40f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			58.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.031f;
			armor = 				22.412f;
			armorPerLevel = 		3.4f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		335f;
			range = 				175f;
			break;

		case "Galio":
		
			health = 				577.8f;
			healthPerLevel = 		85f;
			healthRegen = 			8.71f;
			healthRegenPerLevel = 	0.75f;
			mana = 					319f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			61.97f;
			attackDamagePerLevel = 	3.375f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.012f;
			armor = 				26.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Gangplank":
		
			health = 				631.08f;
			healthPerLevel = 		81f;
			healthRegen = 			5.51f;
			healthRegenPerLevel = 	0.75f;
			mana = 					282.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.675f;
			manaRegenPerLevel = 	0.7f;
			attackDamage = 			59.04f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.651f;
			attackSpeedPerLevel = 	0.0275f;
			armor = 				26.044f;
			armorPerLevel = 		3.3f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Garen":
		
			health = 				616.28f;
			healthPerLevel = 		96f;
			healthRegen = 			7.84f;
			healthRegenPerLevel = 	0.5f;
			mana = 					0f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			57.88f;
			attackDamagePerLevel = 	3.5f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.029f;
			armor = 				27.536f;
			armorPerLevel = 		2.7f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Gnar":
		
			health = 				540f;
			healthPerLevel = 		65f;
			healthRegen = 			2.5f;
			healthRegenPerLevel = 	0.5f;
			mana = 					100f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			48f;
			attackDamagePerLevel = 	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.005f;
			armor = 				23f;
			armorPerLevel = 		2.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				150f;
			break;

		case "Gragas":
		
			health = 				583.52f;
			healthPerLevel = 		89f;
			healthRegen = 			8.675f;
			healthRegenPerLevel = 	0.85f;
			mana = 					299.96f;
			manaPerLevel = 			47f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			61.38f;
			attackDamagePerLevel = 	3.5f;
			attackSpeed = 			0.651f;
			attackSpeedPerLevel = 	0.0205f;
			armor = 				26.048f;
			armorPerLevel = 		3.6f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		330f;
			range = 				125f;
			break;

		case "Graves":
		
			health = 				551.12f;
			healthPerLevel = 		84f;
			healthRegen = 			6.675f;
			healthRegenPerLevel = 	0.7f;
			mana = 					322.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.925f;
			manaRegenPerLevel = 	0.7f;
			attackDamage = 			54.208f;
			attackDamagePerLevel = 	3.1f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.029f;
			armor = 				24.376f;
			armorPerLevel = 		3.2f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				525f;
			break;

		case "Hecarim":
		
			health = 				599.6f;
			healthPerLevel = 		95f;
			healthRegen = 			9.26f;
			healthRegenPerLevel = 	0.75f;
			mana = 					277.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.505f;
			manaRegenPerLevel = 	0.6f;
			attackDamage = 			61.376f;
			attackDamagePerLevel = 	3.2f;
			attackSpeed = 			0.670f;
			attackSpeedPerLevel = 	0.025f;
			armor = 				26.72f;
			armorPerLevel = 		4f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				175f;
			break;

		case "Heimerdinger":
		
			health = 				476f;
			healthPerLevel = 		75f;
			healthRegen = 			11.005f;
			healthRegenPerLevel = 	1.75f;
			mana = 					307.2f;
			manaPerLevel = 			40f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			55.536f;
			attackDamagePerLevel = 	2.7f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0136f;
			armor = 				19.04f;
			armorPerLevel = 		3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		340f;
			range = 				550f;
			break;

		case "Irelia":
		
			health =				607.2f;
			healthPerLevel =		90f;
			healthRegen =			8.59f;
			healthRegenPerLevel =	0.65f;
			mana = 					288.8f;
			manaPerLevel = 			35f;
			manaRegen = 			8.09f;
			manaRegenPerLevel = 	0.65f;
			attackDamage = 			61.544f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.665f;
			attackSpeedPerLevel = 	0.032f;
			armor = 				25.3f;
			armorPerLevel = 		3.75f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;



		case "Janna":
		
			health =				487.04f;
			healthPerLevel =		78f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					409.52f;
			manaPerLevel = 			64f;
			manaRegen = 			9f;
			manaRegenPerLevel = 	0.4f;
			attackDamage = 			51.956f;
			attackDamagePerLevel =	2.95f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0261f;
			armor = 				19.384f;
			armorPerLevel = 		3.8f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				475f;
			break;

		case "Jarvan IV":
		
			health =				571.2f;
			healthPerLevel =		90f;
			healthRegen =			8.175f;
			healthRegenPerLevel =	0.7f;
			mana = 					302.2f;
			manaPerLevel = 			40f;
			manaRegen = 			6.755f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			55.712f;
			attackDamagePerLevel =	3.4f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.025f;
			armor = 				24.048f;
			armorPerLevel = 		3.6f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed =		 	340f;
			range = 				175f;
			break;

		case "Jax":
		
			health =				592.8f;
			healthPerLevel =		85f;
			healthRegen =			8.37f;
			healthRegenPerLevel =	0.55f;
			mana = 					288.8f;
			manaPerLevel = 			35f;
			manaRegen = 			7.575f;
			manaRegenPerLevel = 	0.7f;
			attackDamage = 			61.97f;
			attackDamagePerLevel =	3.375f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.034f;
			armor = 				27.04f;
			armorPerLevel = 		3f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Jayce":
		
			health =				571.2f;
			healthPerLevel =		90f;
			healthRegen =			7.34f;
			healthRegenPerLevel =	0.8f;
			mana = 					307.2f;
			manaPerLevel = 			40f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			50.38f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.03f;
			armor = 				22.38f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Jinx":
		
			health =				517.76f;
			healthPerLevel =		82f;
			healthRegen =			5.84f;
			healthRegenPerLevel =	0.5f;
			mana = 					245.6f;
			manaPerLevel = 			45f;
			manaRegen = 			6.68f;
			manaRegenPerLevel = 	1f;
			attackDamage = 			53.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.01f;
			armor = 				22.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				525f;
			break;

		case "Kalista":
			
			health =				517.76f;
			healthPerLevel =		83f;
			healthRegen =			6f;
			healthRegenPerLevel =	0.55f;
			mana = 					231.8f;
			manaPerLevel = 			35f;
			manaRegen = 			6.3f;
			manaRegenPerLevel = 	0.4f;
			attackDamage = 			53.46f;
			attackDamagePerLevel =	3.25f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.033f;
			armor = 				19.012f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				550f;
			break;
			
		case "Karma":
		
			health =				522.44f;
			healthPerLevel =		83f;
			healthRegen =			5.62f;
			healthRegenPerLevel =	0.55f;
			mana = 					374f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			53.544f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.023f;
			armor = 				20.384f;
			armorPerLevel = 		3.8f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				525f;
			break;

		case "Karthus":
		
			health =				516f;
			healthPerLevel =		75f;
			healthRegen =			6.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					372.48f;
			manaPerLevel = 			61f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			45.66f;
			attackDamagePerLevel =	3.25f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0211f;
			armor = 				20.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				450f;
			break;

		case "Kassadin":
		
			health =				564.04f;
			healthPerLevel =		78f;
			healthRegen =			7.79f;
			healthRegenPerLevel =	0.5f;
			mana = 					347.6f;
			manaPerLevel = 			70f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			58.852f;
			attackDamagePerLevel =	3.9f;
			attackSpeed = 			0.64f;
			attackSpeedPerLevel = 	0.037f;
			armor = 				23.376f;
			armorPerLevel = 		3.2f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		340f;
			range = 				150f;
			break;

		case "Katarina":
		
			health =				559.4f;
			healthPerLevel =		80f;
			healthRegen =			7.87f;
			healthRegenPerLevel =	0.55f;
			mana = 					0f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			58.376f;
			attackDamagePerLevel =	3.2f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.0274f;
			armor = 				26.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Kayle":
		
			health =				574.24f;
			healthPerLevel =		93f;
			healthRegen =			8.28f;
			healthRegenPerLevel =	0.75f;
			mana = 					322.2f;
			manaPerLevel = 			40f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			56.004f;
			attackDamagePerLevel =	2.8f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.022f;
			armor = 				26.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Kennen":
		
			health =				535.72f;
			healthPerLevel =		79f;
			healthRegen =			5.59f;
			healthRegenPerLevel =	0.65f;
			energy = 				200f;
			energyPerLevel = 		0f;
			energyRegen = 			50f;
			energyRegenPerLevel = 	0f;
			attackDamage = 			50.544f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.690f;
			attackSpeedPerLevel = 	0.034f;
			armor = 				24.3f;
			armorPerLevel = 		3.75f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				550f;
			break;

		case "Kha'Zix":
		
			health =				572.8f;
			healthPerLevel =		85f;
			healthRegen =			7.51f;
			healthRegenPerLevel =	0.75f;
			mana = 					327.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.59f;
			manaRegenPerLevel = 	0.5f;
			attackDamage = 			55.208f;
			attackDamagePerLevel =	3.1f;
			attackSpeed = 			0.668f;
			attackSpeedPerLevel = 	0.027f;
			armor = 				24.04f;
			armorPerLevel = 		3f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Kog'Maw":
		
			health =				546.16f;
			healthPerLevel =		87f;
			healthRegen =			5.92f;
			healthRegenPerLevel =	0.55f;
			mana = 					322.2f;
			manaPerLevel = 			40f;
			manaRegen = 			8.675f;
			manaRegenPerLevel = 	0.7f;
			attackDamage = 			49.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.665f;
			attackSpeedPerLevel = 	0.0265f;
			armor = 				19.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				500f;
			break;

		case "Leblanc":
		
			health =				516f;
			healthPerLevel =		75f;
			healthRegen =			7.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					334f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			54.88f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.014f;
			armor = 				21.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				525f;
			break;

		case "Lee Sin":
		
			health =				570.8f;
			healthPerLevel =		85f;
			healthRegen =			7.425f;
			healthRegenPerLevel =	0.7f;
			energy = 				200f;
			energyPerLevel = 		0f;
			energyRegen = 			50f;
			energyRegenPerLevel = 	0f;
			attackDamage = 			61.176f;
			attackDamagePerLevel =	3.2f;
			attackSpeed = 			0.651f;
			attackSpeedPerLevel = 	0.03f;
			armor = 				24.216f;
			armorPerLevel = 		3.7f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Leona":
		
			health =				576.16f;
			healthPerLevel =		87f;
			healthRegen =			8.425f;
			healthRegenPerLevel =	0.85f;
			mana = 					302.2f;
			manaPerLevel = 			40f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			60.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.029f;
			armor = 				27.208f;
			armorPerLevel = 		3.1f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Lissandra":
		
			health =				506.12f;
			healthPerLevel =		84f;
			healthRegen =			6.92f;
			healthRegenPerLevel =	0.55f;
			mana = 					304f;
			manaPerLevel = 			50f;
			manaRegen = 			5.67f;
			manaRegenPerLevel = 	0.4f;
			attackDamage = 			50.536f;
			attackDamagePerLevel =	2.7f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0136f;
			armor = 				20.216f;
			armorPerLevel = 		3.7f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				550f;
			break;

		case "Lucian":
		
			health =				554.4f;
			healthPerLevel =		80f;
			healthRegen =			6.19f;
			healthRegenPerLevel =	0.65f;
			mana = 					298.88f;
			manaPerLevel = 			41f;
			manaRegen = 			8.175f;
			manaRegenPerLevel = 	0.7f;
			attackDamage = 			52.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.033f;
			armor = 				24.04f;
			armorPerLevel = 		3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				500f;
			break;

		case "Lulu":
		
			health =				552.76f;
			healthPerLevel =		82f;
			healthRegen =			6.005f;
			healthRegenPerLevel =	0.6f;
			mana = 					292.4f;
			manaPerLevel = 			55f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			46.368f;
			attackDamagePerLevel =	2.6f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0225f;
			armor = 				19.216f;
			armorPerLevel = 		3.7f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				550f;
			break;

		case "Lux":
		
			health =				477.72f;
			healthPerLevel =		79f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					334f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			53.544f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0136f;
			armor = 				18.72f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				550f;
			break;		

		case "Malphite":
		
			health =				574.2f;
			healthPerLevel =		90f;
			healthRegen =			8.37f;
			healthRegenPerLevel =	0.55f;
			mana = 					282.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.32f;
			manaRegenPerLevel = 	0.55f;
			attackDamage = 			61.97f;
			attackDamagePerLevel =	3.375f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.034f;
			armor = 				28.3f;
			armorPerLevel = 		3.75f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Malzahar":
		
			health =				514.4f;
			healthPerLevel =		80f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					325.6f;
			manaPerLevel = 			45f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			54.7f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0136f;
			armor = 				21.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		340f;
			range = 				550f;
			break;

		case "Maoki":
		
			health =				572.2f;
			healthPerLevel =		90f;
			healthRegen =			8.675f;
			healthRegenPerLevel =	0.85f;
			mana = 					327.28f;
			manaPerLevel = 			46f;
			manaRegen = 			7.205f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			63.544f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.694f;
			attackSpeedPerLevel = 	0.02125f;
			armor = 				28.72f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Master Yi":
		
			health =				598.56f;
			healthPerLevel =		92f;
			healthRegen =			7.59f;
			healthRegenPerLevel =	0.65f;
			mana = 					250.56f;
			manaPerLevel = 			42f;
			manaRegen = 			7.255f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			60.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.679f;
			attackSpeedPerLevel = 	0.02f;
			armor = 				24.04f;
			armorPerLevel = 		3f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		355f;
			range = 				125f;
			break;

		case "Miss Fortune":
		
			health =				577.8f;
			healthPerLevel =		85f;
			healthRegen =			6.19f;
			healthRegenPerLevel =	0.65f;
			mana = 					275.84f;
			manaPerLevel = 			38f;
			manaRegen = 			8.04f;
			manaRegenPerLevel = 	0.65f;
			attackDamage = 			49.54f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.656f;
			attackSpeedPerLevel = 	0.0301f;
			armor = 				24.04f;
			armorPerLevel = 		3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				550f;
			break;

		case "Mordekaiser":
		
			health =				555.4f;
			healthPerLevel =		80f;
			healthRegen =			8.37f;
			healthRegenPerLevel =	0.55f;
			mana = 					120f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			57.58f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.694f;
			attackSpeedPerLevel = 	0.03f;
			armor = 				24.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		340f;
			range = 				125f;
			break;	

		case "Morgana":
		
			health =				547.48f;
			healthPerLevel =		86f;
			healthRegen =			5.705f;
			healthRegenPerLevel =	0.6f;
			mana = 					340.8f;
			manaPerLevel = 			60f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			55.46f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0153f;
			armor = 				25.384f;
			armorPerLevel = 		3.8f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				450f;
			break;

		case "Nami":
		
			health =				489.32f;
			healthPerLevel =		74f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					377.24f;
			manaPerLevel = 			43f;
			manaRegen = 			9f;
			manaRegenPerLevel = 	0.4f;
			attackDamage = 			51.208f;
			attackDamagePerLevel =	3.1f;
			attackSpeed = 			0.644f;
			attackSpeedPerLevel = 	0.0261f;
			armor = 				19.72f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				550f;
			break;

		case "Nasus":
		
			health =				561.2f;
			healthPerLevel =		90f;
			healthRegen =			9.01f;
			healthRegenPerLevel =	0.9f;
			mana = 					275.6f;
			manaPerLevel = 			45f;
			manaRegen = 			7.44f;
			manaRegenPerLevel = 	0.5f;
			attackDamage = 			59.18f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.0348f;
			armor = 				24.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Nautilus":
		
			health =				576.48f;
			healthPerLevel =		86f;
			healthRegen =			8.37f;
			healthRegenPerLevel =	0.55f;
			mana = 					284f;
			manaPerLevel = 			50f;
			manaRegen = 			8.625f;
			manaRegenPerLevel = 	0.7f;
			attackDamage = 			57.544f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.613f;
			attackSpeedPerLevel = 	0.01f;
			armor = 				26.46f;
			armorPerLevel = 		3.25f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		325f;
			range = 				175f;
			break;

		case "Nidalee":
		
			health =				541.2f;
			healthPerLevel =		90f;
			healthRegen =			6.005f;
			healthRegenPerLevel =	0.6f;
			mana = 					295.6f;
			manaPerLevel = 			45f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			47.88f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.0322f;
			armor = 				22.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				525f;
			break;

		case "Nocturne":
		
			health =				582.8f;
			healthPerLevel =		85f;
			healthRegen =			8.26f;
			healthRegenPerLevel =	0.75f;
			mana = 					273.8f;
			manaPerLevel = 			35f;
			manaRegen = 			6.755f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			59.208f;
			attackDamagePerLevel =	3.1f;
			attackSpeed = 			0.668f;
			attackSpeedPerLevel = 	0.027f;
			armor = 				26.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Nunu":
		
			health =				598.28f;
			healthPerLevel =		96f;
			healthRegen =			8.39f;
			healthRegenPerLevel =	0.8f;
			mana = 					283.56f;
			manaPerLevel = 			42f;
			manaRegen = 			7.44f;
			manaRegenPerLevel = 	0.5f;
			attackDamage = 			56.856f;
			attackDamagePerLevel =	3.45f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0225f;
			armor = 				26.38f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Olaf":
		
			health =				597.24f;
			healthPerLevel =		93f;
			healthRegen =			8.51f;
			healthRegenPerLevel =	0.9f;
			mana = 					265.6f;
			manaPerLevel = 			45f;
			manaRegen = 			7.465f;
			manaRegenPerLevel = 	0.575f;
			attackDamage = 			59.98f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.694f;
			attackSpeedPerLevel = 	0.027f;
			armor = 				26.04f;
			armorPerLevel = 		3f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Orianna":
		
			health =				517.72f;
			healthPerLevel =		79f;
			healthRegen =			6.87f;
			healthRegenPerLevel =	0.55f;
			mana = 					334f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			40.368f;
			attackDamagePerLevel =	2.6f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.035f;
			armor = 				17.04f;
			armorPerLevel = 		3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				525f;
			break;

		case "Pantheon":
		
			health =				579.16f;
			healthPerLevel =		87f;
			healthRegen =			7.84f;
			healthRegenPerLevel =	0.65f;
			mana = 					267.12f;
			manaPerLevel = 			34f;
			manaRegen = 			7.355f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			55.572f;
			attackDamagePerLevel =	2.9f;
			attackSpeed = 			0.679f;
			attackSpeedPerLevel = 	0.0295f;
			armor = 				27.652f;
			armorPerLevel = 		3.9f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		355f;
			range = 				150f;
			break;

		case "Poppy":
		
			health =				559.08f;
			healthPerLevel =		81f;
			healthRegen =			8.37f;
			healthRegenPerLevel =	0.55f;
			mana = 					235.4f;
			manaPerLevel = 			30f;
			manaRegen = 			7.155f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			61.97f;
			attackDamagePerLevel =	3.375f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.0335f;
			armor = 				28.72f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Quinn":
		
			health =				532.8f;
			healthPerLevel =		85f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					268.8f;
			manaPerLevel = 			35f;
			manaRegen = 			6.97f;
			manaRegenPerLevel = 	0.4f;
			attackDamage = 			51.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.668f;
			attackSpeedPerLevel = 	0.031f;
			armor = 				23.38f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				525f;
			break;

		case "Rammus":
		
			health =				564.48f;
			healthPerLevel =		86f;
			healthRegen =			7.92f;
			healthRegenPerLevel =	0.55f;
			mana = 					310.44f;
			manaPerLevel = 			33f;
			manaRegen = 			7.84f;
			manaRegenPerLevel = 	0.5f;
			attackDamage = 			55.88f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.02215f;
			armor = 				31.384f;
			armorPerLevel = 		3.8f;
			magicResist = 			32.4f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Renekton":
		
			health =				572.16f;
			healthPerLevel =		87f;
			healthRegen =			7.96f;
			healthRegenPerLevel =	0.75f;
			mana = 					100f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			58.328f;
			attackDamagePerLevel =	3.1f;
			attackSpeed = 			0.665f;
			attackSpeedPerLevel = 	0.0265f;
			armor = 				25.584f;
			armorPerLevel = 		3.8f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Rengar":
		
			health =				586.2f;
			healthPerLevel =		90f;
			healthRegen =			4.27f;
			healthRegenPerLevel =	0.4f;
			mana = 					5f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			60.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.679f;
			attackSpeedPerLevel = 	0.0285f;
			armor = 				25.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Riven":
		
			health =				558.48f;
			healthPerLevel =		86f;
			healthRegen =			3.34f;
			healthRegenPerLevel =	0.5f;
			mana = 					0f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			56.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.035f;
			armor = 				24.376f;
			armorPerLevel = 		3.2f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Rumble":
		
			health =				584.4f;
			healthPerLevel =		80f;
			healthRegen =			8.005f;
			healthRegenPerLevel =	0.6f;
			mana = 					100f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			61.036f;
			attackDamagePerLevel =	3.2f;
			attackSpeed = 			0.644f;
			attackSpeedPerLevel = 	0.0185f;
			armor = 				25.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Ryze":
		
			health =				558.48f;
			healthPerLevel =		86f;
			healthRegen =			5.27f;
			healthRegenPerLevel =	0.55f;
			mana = 					342.4f;
			manaPerLevel = 			55f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			55.14f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.02112f;
			armor = 				21.552f;
			armorPerLevel = 		3.9f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		340f;
			range = 				550f;
			break;	

		case "Sejuani":
		
			health =				600f;
			healthPerLevel =		95f;
			healthRegen =			8.675f;
			healthRegenPerLevel =	0.85f;
			mana = 					400f;
			manaPerLevel = 			40f;
			manaRegen = 			7.205f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			57.544f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.67f;
			attackSpeedPerLevel = 	0.0144f;
			armor = 				29.54f;
			armorPerLevel = 		3f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		340f;
			range = 				125f;
			break;

		case "Shaco":
		
			health =				582.12f;
			healthPerLevel =		84f;
			healthRegen =			8.37f;
			healthRegenPerLevel =	0.55f;
			mana = 					297.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.155f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			57.58f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.694f;
			attackSpeedPerLevel = 	0.03f;
			armor = 				24.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Shen":
		
			health =				570.8f;
			healthPerLevel =		85f;
			healthRegen =			8.37f;
			healthRegenPerLevel =	0.55f;
			energy = 				200f;
			energyPerLevel = 		0f;
			energyRegen = 			50f;
			energyRegenPerLevel = 	0f;
			attackDamage = 			60.17f;
			attackDamagePerLevel =	3.375f;
			attackSpeed = 			0.651f;
			attackSpeedPerLevel = 	0.034f;
			armor = 				25.72f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Shyvana":
		
			health =				594.6f;
			healthPerLevel =		95f;
			healthRegen =			8.59f;
			healthRegenPerLevel =	0.8f;
			mana = 					100f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			60.712f;
			attackDamagePerLevel =	3.4f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.025f;
			armor = 				27.628f;
			armorPerLevel = 		3.35f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Singed":
		
			health =				542.76f;
			healthPerLevel =		82f;
			healthRegen =			8.02f;
			healthRegenPerLevel =	0.55f;
			mana = 					290.6f;
			manaPerLevel = 			45f;
			manaRegen = 			7.52f;
			manaRegenPerLevel = 	0.55f;
			attackDamage = 			62.32f;
			attackDamagePerLevel =	3.375f;
			attackSpeed = 			0.613f;
			attackSpeedPerLevel = 	0.0181f;
			armor = 				27.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Sion":
		
			health =				542.64f;
			healthPerLevel =		73f;
			healthRegen =			10.18f;
			healthRegenPerLevel =	0.8f;
			mana = 					275.6f;
			manaPerLevel = 			45f;
			manaRegen = 			8.005f;
			manaRegenPerLevel = 	0.6f;
			attackDamage = 			59.72f;
			attackDamagePerLevel =	4f;
			attackSpeed = 			0.679f;
			attackSpeedPerLevel = 	0.013f;
			armor = 				23.04f;
			armorPerLevel = 		3f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				150f;
			break;

		case "Sivir":
		
			health =				515.76f;
			healthPerLevel =		82f;
			healthRegen =			5.17f;
			healthRegenPerLevel =	0.55f;
			mana = 					284f;
			manaPerLevel = 			50f;
			manaRegen = 			8.01f;
			manaRegenPerLevel = 	0.9f;
			attackDamage = 			52.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.016f;
			armor = 				22.21f;
			armorPerLevel = 		3.25f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				500f;
			break;

		case "Skarner":
		
			health =				601.28f;
			healthPerLevel =		96f;
			healthRegen =			8.925f;
			healthRegenPerLevel =	0.85f;
			mana = 					272.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.205f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			61.156f;
			attackDamagePerLevel =	4.2f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.021f;
			armor = 				29.384f;
			armorPerLevel = 		3.8f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Sona":
		
			health =				482.36f;
			healthPerLevel =		77f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					340.6f;
			manaPerLevel = 			45f;
			manaRegen = 			9f;
			manaRegenPerLevel = 	0.4f;
			attackDamage = 			50.4f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.644f;
			attackSpeedPerLevel = 	0.023f;
			armor = 				20.544f;
			armorPerLevel = 		3.3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				550f;
			break;

		case "Soraka":
		
			health =				529.04f;
			healthPerLevel =		78f;
			healthRegen =			2.5f;
			healthRegenPerLevel =	0.5f;
			mana = 					350.8f;
			manaPerLevel = 			60f;
			manaRegen = 			9f;
			manaRegenPerLevel = 	0.4f;
			attackDamage = 			50.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0214f;
			armor = 				23.384f;
			armorPerLevel = 		3.8f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				550f;
			break;

		case "Swain":
		
			health =				516.04f;
			healthPerLevel =		78f;
			healthRegen =			7.84f;
			healthRegenPerLevel =	0.65f;
			mana = 					324f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			52.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0211f;
			armor = 				22.72f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				500f;
			break;

		case "Syndra":
		
			health =				511.04f;
			healthPerLevel =		78f;
			healthRegen =			6.505f;
			healthRegenPerLevel =	0.6f;
			mana = 					334f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			53.872f;
			attackDamagePerLevel =	2.9f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.02f;
			armor = 				24.712f;
			armorPerLevel = 		3.4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				550f;
			break;

		case "Talon":
		
			health =				582.8f;
			healthPerLevel =		85f;
			healthRegen =			8.51f;
			healthRegenPerLevel =	0.75f;
			mana = 					327.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.59f;
			manaRegenPerLevel = 	0.5f;
			attackDamage = 			55.208f;
			attackDamagePerLevel =	3.1f;
			attackSpeed = 			0.668f;
			attackSpeedPerLevel = 	0.027f;
			armor = 				26.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Taric":
		
			health =				619.2f;
			healthPerLevel =		90f;
			healthRegen =			7.94f;
			healthRegenPerLevel =	0.5f;
			mana = 					349.08f;
			manaPerLevel = 			56f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			57.88f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0202f;
			armor = 				25.876f;
			armorPerLevel = 		3.2f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		340f;
			range = 				125f;
			break;

		case "Teemo":
		
			health =				515.76f;
			healthPerLevel =		82f;
			healthRegen =			5.74f;
			healthRegenPerLevel =	0.65f;
			mana = 					267.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.205f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			47.54f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.69f;
			attackSpeedPerLevel = 	0.0338f;
			armor = 				24.3f;
			armorPerLevel = 		3.75f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				500f;
			break;

		case "Thresh":
		
			health =				560.52f;
			healthPerLevel =		89f;
			healthRegen =			6.92f;
			healthRegenPerLevel =	0.55f;
			mana = 					273.92f;
			manaPerLevel = 			44f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			47.695f;
			attackDamagePerLevel =	2.2f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.035f;
			armor = 				16f;
			armorPerLevel = 		0f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				450f;
			break;

		case "Tristana":
		
			health =				552.76f;
			healthPerLevel =		82f;
			healthRegen =			6.19f;
			healthRegenPerLevel =	0.65f;
			mana = 					246.76f;
			manaPerLevel = 			32f;
			manaRegen = 			7.205f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			49.54f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.656f;
			attackSpeedPerLevel = 	0.025f;
			armor = 				24.04f;
			armorPerLevel = 		3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				550f;
			break;

		case "Trundle":
		
			health =				616.28f;
			healthPerLevel =		96f;
			healthRegen =			9.425f;
			healthRegenPerLevel =	0.85f;
			mana = 					281.6f;
			manaPerLevel = 			45f;
			manaRegen = 			7.505f;
			manaRegenPerLevel = 	0.6f;
			attackDamage = 			60.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.67f;
			attackSpeedPerLevel = 	0.029f;
			armor = 				27.536f;
			armorPerLevel = 		2.7f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Tryndamere":
		
			health =				625.64f;
			healthPerLevel =		98f;
			healthRegen =			8.51f;
			healthRegenPerLevel =	0.9f;
			mana = 					100f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			61.376f;
			attackDamagePerLevel =	3.2f;
			attackSpeed = 			0.67f;
			attackSpeedPerLevel = 	0.029f;
			armor = 				24.108f;
			armorPerLevel = 		3.1f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Twisted Fate":
		
			health =				521.76f;
			healthPerLevel =		82f;
			healthRegen =			5.505f;
			healthRegenPerLevel =	0.6f;
			mana = 					265.84f;
			manaPerLevel = 			38f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			49.954f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.651f;
			attackSpeedPerLevel = 	0.0322f;
			armor = 				20.542f;
			armorPerLevel = 		3.15f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				525f;
			break;

		case "Twitch":
		
			health =				525.08f;
			healthPerLevel =		81f;
			healthRegen =			6.005f;
			healthRegenPerLevel =	0.6f;
			mana = 					287.2f;
			manaPerLevel = 			40f;
			manaRegen = 			7.255f;
			manaRegenPerLevel =	 	0.45f;
			attackDamage = 			49.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.679f;
			attackSpeedPerLevel = 	0.0338f;
			armor = 				23.04f;
			armorPerLevel = 		3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed =	 		330f;
			range = 				550f;
			break;

		case "Udyr":
		
			health =				593.32f;
			healthPerLevel =		99f;
			healthRegen =			8.71f;
			healthRegenPerLevel =	0.75f;
			mana = 					270.4f;
			manaPerLevel = 			30f;
			manaRegen = 			7.505f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			58.286f;
			attackDamagePerLevel =	3.2f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.0267f;
			armor = 				25.47f;
			armorPerLevel = 		4f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Urgot":
		
			health =				586.52f;
			healthPerLevel =		89f;
			healthRegen =			6.505f;
			healthRegenPerLevel =	0.6f;
			mana = 					312.4f;
			manaPerLevel = 			55f;
			manaRegen = 			8.59f;
			manaRegenPerLevel = 	0.65f;
			attackDamage = 			52.048f;
			attackDamagePerLevel =	3.6f;
			attackSpeed = 			0.644f;
			attackSpeedPerLevel = 	0.029f;
			armor = 				24.544f;
			armorPerLevel = 		3.3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				425f;
			break;

		case "Varus":
		
			health =				537.76f;
			healthPerLevel =		82f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					310.48f;
			manaPerLevel = 			36f;
			manaRegen = 			7.34f;
			manaRegenPerLevel = 	0.5f;
			attackDamage = 			49.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.03f;
			armor = 				23.212f;
			armorPerLevel = 		3.4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				575f;
			break;

		case "Vayne":
		
			health =				498.44f;
			healthPerLevel =		83f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					231.8f;
			manaPerLevel = 			35f;
			manaRegen = 			6.97f;
			manaRegenPerLevel = 	0.4f;
			attackDamage = 			53.46f;
			attackDamagePerLevel =	3.25f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.04f;
			armor = 				19.012f;
			armorPerLevel = 		3.4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		330f;
			range = 				550f;
			break;

		case "Veigar":
		
			health =				492.76f;
			healthPerLevel =		82f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					342.4f;
			manaPerLevel = 			55f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			50.71f;
			attackDamagePerLevel =	2.625f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0224f;
			armor = 				22.55f;
			armorPerLevel = 		3.75f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		340f;
			range = 				525f;
			break;		

		case "Vel'Koz":
		
			health =				507.68f;
			healthPerLevel =		76f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					325.6f;
			manaPerLevel = 			45f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			51.938f;
			attackDamagePerLevel =	3.142f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0136f;
			armor = 				21.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		340f;
			range = 				525f;
			break;

		case "Vi":
		
			health =				582.8f;
			healthPerLevel =		85f;
			healthRegen =			9.01f;
			healthRegenPerLevel =	0.9f;
			mana = 					295.6f;
			manaPerLevel = 			45f;
			manaRegen = 			8.09f;
			manaRegenPerLevel = 	0.65f;
			attackDamage = 			55.88f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.644f;
			attackSpeedPerLevel = 	0.025f;
			armor = 				25.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		350f;
			range = 				125f;
			break;

		case "Viktor":
		
			health =				516.01f;
			healthPerLevel =		78f;
			healthRegen =			7.84f;
			healthRegenPerLevel =	0.65f;
			mana = 					324f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			52.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.0211f;
			armor = 				22.72f;
			armorPerLevel = 		4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				525f;
			break;

		case "Vladimir":
		
			health =				542.8f;
			healthPerLevel =		85f;
			healthRegen =			7.005f;
			healthRegenPerLevel =	0.6f;
			mana = 					0f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			48.04f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.02f;
			armor = 				21.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				450f;
			break;

		case "Volibear":
		
			health =				584.48f;
			healthPerLevel =		86f;
			healthRegen =			8.09f;
			healthRegenPerLevel =	0.65f;
			mana = 					270.4f;
			manaPerLevel = 			30f;
			manaRegen = 			8.09f;
			manaRegenPerLevel = 	0.65f;
			attackDamage = 			59.544f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.0267f;
			armor = 				26.38f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Warwick":
		
			health =				592.64f;
			healthPerLevel =		98f;
			healthRegen =			8.39f;
			healthRegenPerLevel =	0.8f;
			mana = 					240.4f;
			manaPerLevel = 			30f;
			manaRegen = 			8.105f;
			manaRegenPerLevel = 	0.6f;
			attackDamage = 			62.43f;
			attackDamagePerLevel =	3.375f;
			attackSpeed = 			0.679f;
			attackSpeedPerLevel = 	0.0288f;
			armor = 				25.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Wukong":
		
			health =				577.8f;
			healthPerLevel =		85f;
			healthRegen =			6.19f;
			healthRegenPerLevel =	0.65f;
			mana = 					265.84f;
			manaPerLevel = 			38f;
			manaRegen = 			8.04f;
			manaRegenPerLevel = 	0.65f;
			attackDamage = 			59.876f;
			attackDamagePerLevel =	3.2f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.03f;
			armor = 				24.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				175f;
			break;

		case "Xerath":
		
			health =				514.4f;
			healthPerLevel =		80f;
			healthRegen =			5.42f;
			healthRegenPerLevel =	0.55f;
			mana = 					316.96f;
			manaPerLevel = 			47f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			54.7f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0136f;
			armor = 				21.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		340f;
			range = 				525f;
			break;

		case "Xin Zhao":
		
			health =				591.16f;
			healthPerLevel =		87f;
			healthRegen =			8.175f;
			healthRegenPerLevel =	0.7f;
			mana = 					273.8f;
			manaPerLevel = 			35f;
			manaRegen = 			7.255f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			57.544f;
			attackDamagePerLevel =	3.3f;
			attackSpeed = 			0.672f;
			attackSpeedPerLevel = 	0.026f;
			armor = 				25.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				175f;
			break;

		case "Yasuo":
		
			health =				517.76f;
			healthPerLevel =		82f;
			healthRegen =			6.51f;
			healthRegenPerLevel =	0.9f;
			mana = 					60f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			55.376f;
			attackDamagePerLevel =	3.2f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.032f;
			armor = 				24.712f;
			armorPerLevel = 		3.4f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		340f;
			range = 				175f;
			break;

		case "Yorick":
		
			health =				563.8f;
			healthPerLevel =		85f;
			healthRegen =			8.175f;
			healthRegenPerLevel =	0.7f;
			mana = 					293.8f;
			manaPerLevel = 			35f;
			manaRegen = 			6.755f;
			manaRegenPerLevel = 	0.45f;
			attackDamage = 			57.58f;
			attackDamagePerLevel =	3.5f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.03f;
			armor = 				25.048f;
			armorPerLevel = 		3.6f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		345f;
			range = 				125f;
			break;

		case "Zac":
		
			health =				614.6f;
			healthPerLevel =		95f;
			healthRegen =			7.92f;
			healthRegenPerLevel =	0.55f;
			mana = 					0f;
			manaPerLevel = 			0f;
			manaRegen = 			0f;
			manaRegenPerLevel = 	0f;
			attackDamage = 			59.67f;
			attackDamagePerLevel =	3.375f;
			attackSpeed = 			0.638f;
			attackSpeedPerLevel = 	0.016f;
			armor = 				23.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed = 		335f;
			range = 				125f;
			break;

		case "Zed":
		
			health =				579.4f;
			healthPerLevel =		80f;
			healthRegen =			7.09f;
			healthRegenPerLevel =	0.65f;
			energy = 				200f;
			energyPerLevel = 		0f;
			energyRegen = 			50f;
			energyRegenPerLevel = 	0f;
			attackDamage = 			54.712f;
			attackDamagePerLevel =	3.4f;
			attackSpeed = 			0.658f;
			attackSpeedPerLevel = 	0.031f;
			armor = 				26.88f;
			armorPerLevel = 		3.5f;
			magicResist = 			32.1f;
			magicResistPerLevel = 	1.25f;
			movementSpeed =	 		345f;
			range = 				125f;
			break;

		case "Ziggs":
		
			health =				524.4f;
			healthPerLevel =		80f;
			healthRegen =			6.255f;
			healthRegenPerLevel =	0.6f;
			mana = 					334f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			54.208f;
			attackDamagePerLevel =	3.1f;
			attackSpeed = 			0.656f;
			attackSpeedPerLevel = 	0.02f;
			armor = 				21.544f;
			armorPerLevel = 		3.3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				550f;
			break;

		case "Zilean":
		
			health =				499.28f;
			healthPerLevel =		71f;
			healthRegen =			5.44f;
			healthRegenPerLevel =	0.5f;
			mana = 					360.8f;
			manaPerLevel = 			60f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			51.64f;
			attackDamagePerLevel =	3f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0213f;
			armor = 				17.134f;
			armorPerLevel = 		3.8f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		335f;
			range = 				600f;
			break;

		case "Zyra":
		
			health =				479.32f;
			healthPerLevel =		74f;
			healthRegen =			5.69f;
			healthRegenPerLevel =	0.5f;
			mana = 					334f;
			manaPerLevel = 			50f;
			manaRegen = 			6f;
			manaRegenPerLevel = 	0.8f;
			attackDamage = 			53.376f;
			attackDamagePerLevel =	3.2f;
			attackSpeed = 			0.625f;
			attackSpeedPerLevel = 	0.0211f;
			armor = 				20.04f;
			armorPerLevel = 		3f;
			magicResist = 			30f;
			magicResistPerLevel = 	0f;
			movementSpeed = 		325f;
			range = 				575f;
			break;
		}
		
	}

	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public String getName(){
		return userSelectedChampion;
	}
	
	public void setName(String userSelectedChampion){
		this.userSelectedChampion = userSelectedChampion;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getQSkill(){
		return qskill;
	}
	
	public void setQSkill(int qskill){
		this.qskill = qskill;
	}
	
	public int getWSkill(){
		return wskill;
	}
	
	public void setWSkill(int wskill){
		this.wskill = wskill;
	}
	
	public int getESkill(){
		return eskill;
	}
	
	public void setESkill(int eskill){
		this.eskill = eskill;
	}
	
	public int getRSkill(){
		return rskill;
	}
	
	public void setRSkill(int rskill){
		this.rskill = rskill;
	}
	
	

	
	
}
	
	
	












