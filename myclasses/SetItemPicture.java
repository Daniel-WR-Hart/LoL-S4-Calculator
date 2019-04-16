package com.leagueoflegendscalculator.myclasses;

import com.leagueoflegendscalculator.R;
import com.leagueoflegendscalculator.R.drawable;


public class SetItemPicture {
	
	public Integer[] itemPicture = new Integer[6];
	
	public SetItemPicture(String item1, String item2, String item3, String item4, String item5, String item6){
		itemPicture[0] = picture(item1);
		itemPicture[1] = picture(item2);
		itemPicture[2] = picture(item3);
		itemPicture[3] = picture(item4);
		itemPicture[4] = picture(item5);
		itemPicture[5] = picture(item6);
		
	}
	
	
	public int picture(String itemName){

		switch(itemName){
		
		case "Abyssal Scepter":
			return R.drawable.i_abyssal_scepter;
	    	
		case "Aegis of the Legion":
			return R.drawable.i_aegis_of_the_legion; 
	    	
		case "Aether Wisp":
			return R.drawable.i_aether_wisp; 
			
		case "Amplifying Tome":
			return R.drawable.i_amplifying_tome; 
			
		case "Ancient Coin":
			return R.drawable.i_ancient_coin; 
			
		case "Archangel's Staff":
			return R.drawable.i_archangels_staff; 
			
		case "Athene's Unholy Grail":
			return R.drawable.i_athenes_unholy_grail; 
			
		case "Atma's Impaler":
			return R.drawable.i_atmas_impaler; 
			
		case "Augment: Death":
			return R.drawable.i_augment_death; 
			
		case "Augment: Gravity":
			return R.drawable.i_augment_gravity; 
			
		case "Augment: Power":
			return R.drawable.i_augment_power; 
			
		case "Avarice Blade":
			return R.drawable.i_avarice_blade; 
			
		case "Banner of Command":
			return R.drawable.i_banner_of_command; 
			
		case "Banshee's Veil":
			return R.drawable.i_banshees_veil; 
			
		case "Berserker's Greaves":
			return R.drawable.i_berserkers_greaves;
			
		case "Bilgewater Cutlass":
			return R.drawable.i_bilgewater_cutlass;
			
		case "Blackfire Torch":
			return R.drawable.i_blackfire_torch; 
			
		case "Blade of the Ruined King":
			return R.drawable.i_blade_of_the_ruined_king; 
			
		case "Blasting Wand":
			return R.drawable.i_blasting_wand; 
			
		case "B.F. Sword":
			return R.drawable.i_b_f_sword; 
			
		case "Boots of Mobility":
			return R.drawable.i_boots_of_mobility; 
			
		case "Boots of Speed":
			return R.drawable.i_boots_of_speed; 
			
		case "Boots of Swifness":
			return R.drawable.i_boots_of_swiftness; 
			
		case "Brawler's Gloves":
			return R.drawable.i_brawlers_gloves; 
			
		case "Catalyst the Protector":
			return R.drawable.i_catalyst_the_protector; 
			
		case "Chain Vest":
			return R.drawable.i_chain_vest; 
			
		case "Chalice of Harmony":
			return R.drawable.i_chalice_of_harmony; 
			
		case "Cloak of Agility":
			return R.drawable.i_cloak_of_agility; 
			
		case "Cloth Armor":
			return R.drawable.i_cloth_armor; 
			
		case "Dagger":
			return R.drawable.i_dagger; 
			
		case "Deathfire Grasp":
			return R.drawable.i_deathfire_grasp; 
			
		case "Dervish Blade":
			return R.drawable.i_dervish_blade; 
			
		case "Doran's Blade":
			return R.drawable.i_dorans_blade;
			
		case "Doran's Ring":
			return R.drawable.i_dorans_ring; 
			
		case "Doran's Shield":
			return R.drawable.i_dorans_shield; 
			
		case "Entropy":
			return R.drawable.i_entropy; 
			
		case "Executioner's Calling":
			return R.drawable.i_executioners_calling; 
			
		case "Face of the Mountain":
			return R.drawable.i_face_of_the_mountain; 
			
		case "Faerie Charm":
			return R.drawable.i_faerie_charm; 
			
		case "Feral Flare":
			return R.drawable.i_feral_flare; 
			
		case "Fiendish Codex":
			return R.drawable.i_fiendish_codex; 
			
		case "Forbidden Idol":
			return R.drawable.i_forbidden_idol; 
			
		case "Frost Queen's Claim":
			return R.drawable.i_frost_queens_claim; 
			
		case "Frostfang":
			return R.drawable.i_frostfang; 
			
		case "Frozen Heart":
			return R.drawable.i_frozen_heart; 
			
		case "Frozen Mallet":
			return R.drawable.i_frozen_mallet; 
			
		case "Giant's Belt":
			return R.drawable.i_giants_belt; 
			
		case "Glacial Shroud":
			return R.drawable.i_glacial_shroud; 
			
		case "Grez's Spectral Lantern":
			return R.drawable.i_grezs_spectral_lantern; 
			
		case "Guardian Angel":
			return R.drawable.i_guardian_angel; 
			
		case "Guardian's Horn":
			return R.drawable.i_guardians_horn; 
			
		case "Guinsoo's Rageblade":
			return R.drawable.i_guinsoos_rageblade; 
			
		case "Haunting Guise":
			return R.drawable.i_haunting_guise; 
			
		case "Hexdrinker":
			return R.drawable.i_hexdrinker; 
			
		case "Hextech Gunblade":
			return R.drawable.i_hextech_gunblade; 
			
		case "Hextech Revolver":
			return R.drawable.i_hextech_revolver; 
			
		case "Hextech Sweeper":
			return R.drawable.i_hextech_sweeper; 
			
		case "Hunter's Machete":
			return R.drawable.i_hunters_machete; 
			
		case "Iceborn Gauntlet":
			return R.drawable.i_iceborn_gauntlet; 
			
		case "Infinity Edge":
			return R.drawable.i_infinity_edge; 
			
		case "Ionian Boots of Lucidity":
			return R.drawable.i_ionian_boots_of_lucidity; 
			
		case "Kindlegem":
			return R.drawable.i_kindlegem; 
			
		case "Last Whisper":
			return R.drawable.i_last_whisper; 
			
		case "Liandry's Torment":
			return R.drawable.i_liandrys_torment; 
			
		case "Lich Bane":
			return R.drawable.i_lich_bane;
			
		case "Locket of the Iron Solari":
			return R.drawable.i_locket_of_the_iron_solari; 
			
		case "Long Sword":
			return R.drawable.i_long_sword; 
			
		case "Lord Van Damm's Pillager":
			return R.drawable.i_lord_van_damms_pillager; 
			
		case "Madred's Razors":
			return R.drawable.i_madreds_razors; 
			
		case "Manamune":
			return R.drawable.i_manamune; 
			
		case "Maw of Malmortius":
			return R.drawable.i_maw_of_malmortius; 

		case "Mejai's Soulstealer":
			return R.drawable.i_mejais_soulstealer; 
			
		case "Mercurial Scimitar":
			return R.drawable.i_mercurial_scimitar; 
			
		case "Mercury's Treads":
			return R.drawable.i_mercurys_treads; 
			
		case "Mikael's Crucible":
			return R.drawable.i_mikaels_crucible; 
			
		case "Moonflair Spellblade":
			return R.drawable.i_moonflair_spellblade;
			
		case "Morellonomicon":
			return R.drawable.i_morellonomicon; 
			   		
		case "Muramana":
			return R.drawable.i_muramana; 
			
		case "Nashor's Tooth":
			return R.drawable.i_nashors_tooth; 
			
		case "Needlessly Large Rod":
			return R.drawable.i_needlessly_large_rod; 
			
		case "Negatron Cloak":
			return R.drawable.i_negatron_cloak; 
			
		case "Ninja Tabi":
			return R.drawable.i_ninja_tabi; 
			
		case "Nomad's Medallion":
			return R.drawable.i_nomads_medallion; 
			
		case "Null-Magic Mantle":
			return R.drawable.i_null_magic_mantle; 
			
		case "Odyn's Veil":
			return R.drawable.i_odyns_veil; 
			
		case "Ohmwrecker":
			return R.drawable.i_ohmwrecker; 
			
		case "Orb of Winter":
			return R.drawable.i_orb_of_winter; 
			
		case "Overlord's Bloodmail":
			return R.drawable.i_overlords_bloodmail; 
			
		case "Phage":
			return R.drawable.i_phage;
			
		case "Phantom Dancer":
			return R.drawable.i_phantom_dancer; 

		case "Pickaxe":
			return R.drawable.i_pickaxe; 
			
		case "Prospector's Blade":
			return R.drawable.i_prospectors_blade; 
			
		case "Prospector's Ring":
			return R.drawable.i_prospectors_ring; 
			
		case "Quicksilver Sash":
			return R.drawable.i_quicksilver_sash; 
			
		case "Rabadon's Deathcap":
			return R.drawable.i_rabadons_deathcap; 
			
		case "Randuin's Omen":
			return R.drawable.i_randuins_omen; 
			
		case "Ravenous Hydra (Melee Only)":
			return R.drawable.i_ravenous_hydra; 
			
		case "Recurve Bow":
			return R.drawable.i_recurve_bow; 
			
		case "Rejuvenation Bead":
			return R.drawable.i_rejuvenation_bead; 
			
		case "Relic Shield":
			return R.drawable.i_relic_shield; 
			
		case "Rod of Ages":
			return R.drawable.i_rod_of_ages; 
			
		case "Ruby Crystal":
			return R.drawable.i_ruby_crystal; 
			
		case "Ruby Sightstone":
			return R.drawable.i_ruby_sightstone; 
			
		case "Runaan's Hurricane (Ranged Only)":
			return R.drawable.i_runaans_hurricane;
			
		case "Rylai's Crystal Scepter":
			return R.drawable.i_rylais_crystal_scepter; 
			
		case "Sanguine Blade":
			return R.drawable.i_sanguine_blade; 
			
		case "Sapphire Crystal":
			return R.drawable.i_sapphire_crystal; 
			
		case "Seeker's Armguard":
			return R.drawable.i_seekers_armguard; 
			
		case "Seraph's Embrace":
			return R.drawable.i_seraphs_embrace; 
			
		case "Sheen":
			return R.drawable.i_sheen; 
			
		case "Sightstone":
			return R.drawable.i_sightstone; 
			
		case "Sorcerer's Shoes":
			return R.drawable.i_sorcerers_shoes; 
			
		case "Spectre's Cowl":
			return R.drawable.i_spectres_cowl; 
			
		case "Spellthief's Edge":
			return R.drawable.i_spellthiefs_edge; 
			
		case "Spirit Stone":
			return R.drawable.i_spirit_stone; 
			
		case "Spirit Visage":
			return R.drawable.i_spirit_visage; 
			
		case "Spirit of the Ancient Golem":
			return R.drawable.i_spirit_of_the_ancient_golem; 
			
		case "Spirit of the Elder Lizard":
			return R.drawable.i_spirit_of_the_elder_lizard; 
			
		case "Spirit of the Spectral Wraith":
			return R.drawable.i_spirit_of_the_spectral_wraith; 
			
		case "Statikk Shiv":
			return R.drawable.i_statikk_shiv; 
			
		case "Stinger":
			return R.drawable.i_stinger; 
			
		case "Sunfire Cape":
			return R.drawable.i_sunfire_cape; 
			
		case "Sword of the Divine":
			return R.drawable.i_sword_of_the_divine;
			
		case "Sword of the Occult":
			return R.drawable.i_sword_of_the_occult;
			
		case "Talisman of Ascension":
			return R.drawable.i_talisman_of_ascension; 
			
		case "Targon's Brace":
			return R.drawable.i_targons_brace; 
			
		case "Tear of the Goddess":
			return R.drawable.i_tear_of_the_goddess; 
			
		case "The Black Cleaver":
			return R.drawable.i_the_black_cleaver; 
			
		case "The Bloodthirster":
			return R.drawable.i_the_bloodthirster; 
			
		case "The Brutalizer":
			return R.drawable.i_the_brutalizer; 
			
		case "The Hex Core":
			return R.drawable.i_the_hex_core; 
			
		case "The Lightbringer":
			return R.drawable.i_the_lightbringer;
			
		case "Thornmail":
			return R.drawable.i_thornmail; 
			
		case "Tiamat (Melee Only)":
			return R.drawable.i_tiamat; 
			
		case "Trinity Force":
			return R.drawable.i_trinity_force; 

		case "Twin Shadows":
			return R.drawable.i_twin_shadows; 
			
		case "Vampiric Scepter":
			return R.drawable.i_vampiric_scepter; 
			
		case "Void Staff":
			return R.drawable.i_void_staff; 
			
		case "Warden's Mail":
			return R.drawable.i_wardens_mail;
			
		case "Warmog's Armor":
			return R.drawable.i_warmogs_armor; 
			
		case "Wicked Hatchet":
			return R.drawable.i_wicked_hatchet; 
			
		case "Will of the Ancients":
			return R.drawable.i_will_of_the_ancients;
			
		case "Wit's End":
			return R.drawable.i_wits_end; 
			
		case "Wooglet's Witchcap":
			return R.drawable.i_wooglets_witchcap; 
			
		case "Wriggle's Lantern":
			return R.drawable.i_wriggles_lantern;
			
		case "Youmuu's Ghostblade":
			return R.drawable.i_youmuus_ghostblade;
			
	   	case "Zeal":
	   		return R.drawable.i_zeal;
			
		case "Zeke's Herald":
			return R.drawable.i_zekes_herald; 
			
		case "Zephyr":
			return R.drawable.i_zephyr;
			
		case "Zhonya's Hourglass":
			return R.drawable.i_zhonyas_hourglass;
		default:
			return 0;
			
		}
	}
}

