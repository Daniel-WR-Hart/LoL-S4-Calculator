package com.leagueoflegendscalculator;


import com.leagueoflegendscalculator.adapter.ClassCustomChampList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class CreateChampionActivity extends ActionBarActivity {

	//there may be benefits to defining ListView list and ArrayAdapter<String> dataAdapter here as non-final
	int id;
	String userSelectedChampion;
	ListView list;
	//A customized adapter is needed for this type of ListView
	ClassCustomChampList dataAdapter;
	
    String[] arrayOfChampions = {"Aatrox","Ahri","Akali","Alistar","Amumu","Anivia","Annie","Ashe","Azir", "Blitzcrank"
    		,"Brand","Braum","Caitlyn","Cassiopeia","Cho'Gath","Corki","Darius","Diana","Dr.Mundo","Draven","Elise"
    		,"Evelynn","Ezreal","Fiddlesticks","Fiora","Fizz","Galio","Gangplank","Garen","Gnar","Gragas","Graves","Hecarim"
    		,"Heimerdinger","Irelia","Janna","Jarvan IV","Jax","Jayce","Jinx","Karma","Karthus","Kassadin","Katarina"
    		,"Kayle","Kennen","Kha'Zix","Kog'Maw","LeBlanc","Lee Sin","Leona","Lissandra","Lucian","Lulu","Lux","Malphite"
    		,"Malzahar","Maokai","Master Yi","Miss Fortune","Mordekaiser","Morgana","Nami","Nasus","Nautilus","Nidalee","Nocturne"
    		,"Nunu","Olaf","Orianna","Pantheon","Poppy","Quinn","Rammus","Renekton","Rengar","Riven","Rumble","Ryze"
    		,"Sejuani","Shaco","Shen","Shyvana","Singed","Sion","Sivir","Skarner","Sona","Soraka","Swain","Syndra","Talon"
    		,"Taric","Teemo","Thresh","Tristana","Trundle","Tryndamere","Twisted Fate","Twitch","Udyr","Urgot","Varus"
    		,"Vayne","Veigar","Vel'Koz","Vi","Viktor","Vladimir","Volibear","Warwick","Wukong","Xerath","Xin Zhao","Yasuo"
    		,"Yorick","Zac","Zed","Ziggs","Zilean","Zyra"};
    
    Integer[] imageId = {R.drawable.c_aatrox, R.drawable.c_ahri, R.drawable.c_akali, R.drawable.c_alistar, R.drawable.c_amumu,
    		R.drawable.c_anivia, R.drawable.c_annie, R.drawable.c_ashe, R.drawable.c_azir, R.drawable.c_blitzcrank, R.drawable.c_brand
    		, R.drawable.c_braum, R.drawable.c_caitlyn, R.drawable.c_cassiopeia, R.drawable.c_chogath, R.drawable.c_corki
    		, R.drawable.c_darius, R.drawable.c_diana, R.drawable.c_drmundo, R.drawable.c_draven, R.drawable.c_elise
    		, R.drawable.c_evelynn, R.drawable.c_ezreal, R.drawable.c_fiddlesticks, R.drawable.c_fiora, R.drawable.c_fizz
    		, R.drawable.c_galio, R.drawable.c_gangplank, R.drawable.c_garen, R.drawable.c_gnar, R.drawable.c_gragas, R.drawable.c_graves
    		, R.drawable.c_hecarim, R.drawable.c_heimerdinger, R.drawable.c_irelia, R.drawable.c_janna, R.drawable.c_jarvaniv
    		, R.drawable.c_jax, R.drawable.c_jayce, R.drawable.c_jinx, R.drawable.c_karma, R.drawable.c_karthus, R.drawable.c_kassadin
    		, R.drawable.c_katarina, R.drawable.c_kayle, R.drawable.c_kennen, R.drawable.c_khazix, R.drawable.c_kogmaw, R.drawable.c_leblanc
    		, R.drawable.c_leesin, R.drawable.c_leona, R.drawable.c_lissandra, R.drawable.c_lucian, R.drawable.c_lulu, R.drawable.c_lux
    		, R.drawable.c_malphite, R.drawable.c_malzahar, R.drawable.c_maokai, R.drawable.c_masteryi, R.drawable.c_missfortune, R.drawable.c_mordekaiser
    		, R.drawable.c_morgana, R.drawable.c_nami, R.drawable.c_nasus, R.drawable.c_nautilus, R.drawable.c_nidalee, R.drawable.c_nocturne
    		, R.drawable.c_nunu, R.drawable.c_olaf, R.drawable.c_orianna, R.drawable.c_pantheon, R.drawable.c_poppy, R.drawable.c_quinn
    		, R.drawable.c_rammus, R.drawable.c_renekton, R.drawable.c_rengar, R.drawable.c_riven, R.drawable.c_rumble, R.drawable.c_ryze
    		, R.drawable.c_sejuani, R.drawable.c_shaco, R.drawable.c_shen, R.drawable.c_shyvana, R.drawable.c_singed, R.drawable.c_sion
    		, R.drawable.c_sivir, R.drawable.c_skarner, R.drawable.c_sona, R.drawable.c_soraka, R.drawable.c_swain, R.drawable.c_syndra
    		, R.drawable.c_talon, R.drawable.c_taric, R.drawable.c_teemo, R.drawable.c_thresh, R.drawable.c_tristana, R.drawable.c_trundle
    		, R.drawable.c_tryndamere, R.drawable.c_twistedfate, R.drawable.c_twitch, R.drawable.c_udyr, R.drawable.c_urgot, R.drawable.c_varus
    		, R.drawable.c_vayne, R.drawable.c_veigar, R.drawable.c_velkoz, R.drawable.c_vi, R.drawable.c_viktor, R.drawable.c_vladimir
    		, R.drawable.c_volibear, R.drawable.c_warwick, R.drawable.c_wukong, R.drawable.c_xerath, R.drawable.c_xinzhao, R.drawable.c_yasuo
    		, R.drawable.c_yorick, R.drawable.c_zac, R.drawable.c_zed, R.drawable.c_ziggs, R.drawable.c_zilean, R.drawable.c_zyra};
    
    String[] arrayOfTitles = {"The Darkin Blade", "The Nine-Tailed Fox", "The Fist of Shadow", "The Minotaur", "The Sad Mummy"
    		, "The Cryophoenix", "The Dark Child", "The Frost Archer", "The Emperor of the Sands", "The Great Steam Golem", "The Burning Vengeance"
    		, "The Heart of the Frejlord", "The Sheriff of Piltover", "The Serpent's Embrace", "The Terror of the Void"
    		, "The Daring Bombardier", "The Hand of Noxus", "The Scorn of the Moon", "The Madman of Zaun", "The Glorious Executioner"
    		, "The Spider Queen", "The Widowmaker", "The Prodigal Explorer", "The Harbinger of Doom", "The Grand Duelist"
    		,"The Tidal Trickster", "The Sentinel's Sorrow", "The Saltwater Scourge", "The Might of Demacia", "The Missing Link", "The Rabble Rouser"
    		,"The Outlaw", "The Shadow of War", "The Revered Inventor", "The Will of the Blades", "The Storm's Fury"
    		,"The Exemplar of Demacia", "The Grandmaster at Arms", "The Defender of Tomorrow", "The Loose Cannon", "The Englightened One"
    		, "The Deathsinger", "The Void Walker", "The Sinister Blade", "The Judicator", "The Heart of the Tempest", "The Voidreaver"
    		, "The Mouth of the Abyss", "The Deceiver", "The Blind Monk", "The Radiant Dawn", "The Ice Witch", "The Purifier"
    		, "The Fae Sorceress", "The Lady of Luminosity", "The Shard of the Monolith", "The Prophet of the Void", "The Twisted Treant"
    		, "The Wuju Bladesman", "The Bounty Hunter", "The Master of Metal", "The Fallen Angel", "The TideCaller", "The Curator of the Sands"
    		, "The Titan of the Depths", "The Bestial Huntress", "The Eternal Nightmare", "The Yeti Rider", "The Berserker"
    		,"The Lady of Clockwork", "The Artisan of War", "The Iron Ambassador", "Demacia's Wings", "The Armordillo"
    		, "The Butcher of the Sands", "The Pridestalker", "The Exile", "The Mechanized Menace", "The Rogue Mage", "The Winter's Wrath"
    		, "The Demon Jester", "The Eye of the Twilight", "The Half-Dragon", "The Mad Chemist", "The Undead Champion", "The Battle Mistress"
    		, "The Crystal Vanguard", "The Maven of the Strings", "The Starchild", "The Master Tactician", "The Dark Sovereign"
    		, "The Blade's Shadow", "The Gem Knight", "The Swift Scout", "The Chain Warden", "The Megling Gunner", "The Troll King"
    		, "The Barbarian King", "The Card Master", "The Plague Rat", "The Spirit Walker", "The Headsman's Pride", "The Arrow of Retribution"
    		, "The Night Hunter", "The Tiny Master of Evil", "The Eye of the Void", "The Piltover Enforcer", "The Machine Herald"
    		, "The Crimson Reaper", "The Thunder's Roar", "The Blood Hunter", "The Monkey King", "The Magus Ascendant"
    		, "The Seneschal of Demacia", "The Unforgiven", "The Gravedigger", "The Secret Weapon", "The Master of Shadows"
    		, "The Hexplosives Expert", "The Chronokeeper", "The Rise of the Thorns"};
    
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_champion);


	    dataAdapter = new ClassCustomChampList(CreateChampionActivity.this, arrayOfChampions, imageId, arrayOfTitles);//the layout for the list is not defined, but why? is that all taken care of inside CustomList.java?
	    list = (ListView)findViewById(R.id.listViewCreateNewBuild);
		list.setAdapter(dataAdapter);
		
		
		
		

		list.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	//This variable in position is the location on the list that you clicked on.
		    	//Since this variable is used below, I can't just define the onClick listener in the xml file.
		    	
		    	
		    	
		    	//saves the champion selection as a string
		    	userSelectedChampion = list.getItemAtPosition(position).toString(); 

		    	//announces the user's choice for champion
		    	Toast.makeText(getApplicationContext(), "You selected " + list.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
		    	
		    	//changes the skill icons when a champion is selected
		    	setAbilityPictures(userSelectedChampion);
		    	
		    	
		    }
		});
    }
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_create_champion, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_save){
			save();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	
	public void setAbilityPictures(String userSelectedChampion){
		ImageView qskill = (ImageView) findViewById(R.id.image_skill_q);
		ImageView wskill = (ImageView) findViewById(R.id.image_skill_w);
		ImageView eskill = (ImageView) findViewById(R.id.image_skill_e);
		ImageView rskill = (ImageView) findViewById(R.id.image_skill_r);
		
		switch(userSelectedChampion){
		case "Aatrox":
		    qskill.setImageResource(R.drawable.a_aatrox_dark_flight);
		    wskill.setImageResource(R.drawable.a_aatrox_blood_thirst);
		    eskill.setImageResource(R.drawable.a_aatrox_blades_of_torment);
		    rskill.setImageResource(R.drawable.a_aatrox_massacre);
		    break;
		case "Ahri":
		    qskill.setImageResource(R.drawable.a_ahri_orb_of_deception);
		    wskill.setImageResource(R.drawable.a_ahri_fox_fire);
		    eskill.setImageResource(R.drawable.a_ahri_charm);
		    rskill.setImageResource(R.drawable.a_ahri_spirit_rush);
		    break;
		case "Akali":
		    qskill.setImageResource(R.drawable.a_akali_mark_of_the_assassin);
		    wskill.setImageResource(R.drawable.a_akali_twilight_shroud);
		    eskill.setImageResource(R.drawable.a_akali_crescent_slash);
		    rskill.setImageResource(R.drawable.a_akali_shadow_dance);
		    break;
		case "Alistar":
		    qskill.setImageResource(R.drawable.a_alistar_pulverize);
		    wskill.setImageResource(R.drawable.a_alistar_headbutt);
		    eskill.setImageResource(R.drawable.a_alistar_triumphant_roar);
		    rskill.setImageResource(R.drawable.a_alistar_unbreakable_will);
		    break;
		case "Amumu":
		    qskill.setImageResource(R.drawable.a_amumu_bandage_toss);
		    wskill.setImageResource(R.drawable.a_amumu_despair);
		    eskill.setImageResource(R.drawable.a_amumu_tantrum);
		    rskill.setImageResource(R.drawable.a_amumu_curse_of_the_sad_mummy);
		    break;
		case "Anivia":
		    qskill.setImageResource(R.drawable.a_anivia_flash_frost);
		    wskill.setImageResource(R.drawable.a_anivia_crystallize);
		    eskill.setImageResource(R.drawable.a_anivia_frostbite);
		    rskill.setImageResource(R.drawable.a_anivia_glacial_storm);
		    break;
		case "Annie":
		    qskill.setImageResource(R.drawable.a_annie_disintegrate);
		    wskill.setImageResource(R.drawable.a_annie_incinerate);
		    eskill.setImageResource(R.drawable.a_annie_molten_shield);
		    rskill.setImageResource(R.drawable.a_annie_summon_tibbers);
		    break;
		case "Ashe":
		    qskill.setImageResource(R.drawable.a_ashe_frost_shot);
		    wskill.setImageResource(R.drawable.a_ashe_volley);
		    eskill.setImageResource(R.drawable.a_ashe_hawkshot);
		    rskill.setImageResource(R.drawable.a_ashe_enchanted_crystal_arrow);
		    break;
		case "Azir":
			qskill.setImageResource(R.drawable.a_azir_conquering_sands);
		    wskill.setImageResource(R.drawable.a_azir_arise);
		    eskill.setImageResource(R.drawable.a_azir_shifting_sands);
		    rskill.setImageResource(R.drawable.a_azir_emperors_divide);
		    break;
		case "Blitzcrank":
		    qskill.setImageResource(R.drawable.a_blitzcrank_rocket_grab);
		    wskill.setImageResource(R.drawable.a_blitzcrank_overdrive);
		    eskill.setImageResource(R.drawable.a_blitzcrank_power_fist);
		    rskill.setImageResource(R.drawable.a_blitzcrank_static_field);
		    break;
		case "Brand":
		    qskill.setImageResource(R.drawable.a_brand_sear);
		    wskill.setImageResource(R.drawable.a_brand_pillar_of_flame);
		    eskill.setImageResource(R.drawable.a_brand_conflagration);
		    rskill.setImageResource(R.drawable.a_brand_pyroclasm);
		    break;
		case "Braum":
		    qskill.setImageResource(R.drawable.a_braum_winters_bite);
		    wskill.setImageResource(R.drawable.a_braum_stand_behind_me);
		    eskill.setImageResource(R.drawable.a_braum_unbreakable);
		    rskill.setImageResource(R.drawable.a_braum_glacial_fissure);
		    break;
		case "Caitlyn":
		    qskill.setImageResource(R.drawable.a_caitlyn_piltover_peacemaker);
		    wskill.setImageResource(R.drawable.a_caitlyn_yordle_snap_trap);
		    eskill.setImageResource(R.drawable.a_caitlyn_90_caliber_net);
		    rskill.setImageResource(R.drawable.a_caitlyn_ace_in_the_hole);
		    break;
		case "Cassiopeia":
		    qskill.setImageResource(R.drawable.a_cassiopeia_noxious_blast);
		    wskill.setImageResource(R.drawable.a_cassiopeia_miasma);
		    eskill.setImageResource(R.drawable.a_cassiopeia_twin_fang);
		    rskill.setImageResource(R.drawable.a_cassiopeia_petrifying_gaze);
		    break;
		case "Cho'Gath":
		    qskill.setImageResource(R.drawable.a_chogath_rupture);
		    wskill.setImageResource(R.drawable.a_chogath_feral_scream);
		    eskill.setImageResource(R.drawable.a_chogath_vorpal_spikes);
		    rskill.setImageResource(R.drawable.a_chogath_feast);
		    break;
		case "Corki":
		    qskill.setImageResource(R.drawable.a_corki_phosphorus_bomb);
		    wskill.setImageResource(R.drawable.a_corki_valkyrie);
		    eskill.setImageResource(R.drawable.a_corki_gatling_gun);
		    rskill.setImageResource(R.drawable.a_corki_missile_barrage);
		    break;
		case "Darius":
		    qskill.setImageResource(R.drawable.a_darius_decimate);
		    wskill.setImageResource(R.drawable.a_darius_crippling_strike);
		    eskill.setImageResource(R.drawable.a_darius_apprehend);
		    rskill.setImageResource(R.drawable.a_darius_noxian_guillotine);
		    break;
		case "Diana":
		    qskill.setImageResource(R.drawable.a_diana_crescent_strike);
		    wskill.setImageResource(R.drawable.a_diana_pale_cascade);
		    eskill.setImageResource(R.drawable.a_diana_moonfall);
		    rskill.setImageResource(R.drawable.a_diana_lunar_rush);
		    break;
		case "Dr.Mundo":
		    qskill.setImageResource(R.drawable.a_dr_mundo_infected_cleaver);
		    wskill.setImageResource(R.drawable.a_dr_mundo_burning_agony);
		    eskill.setImageResource(R.drawable.a_dr_mundo_masochism);
		    rskill.setImageResource(R.drawable.a_dr_mundo_sadism);
		    break;
		case "Draven":
		    qskill.setImageResource(R.drawable.a_draven_spinning_axe);
		    wskill.setImageResource(R.drawable.a_draven_blood_rush);
		    eskill.setImageResource(R.drawable.a_draven_stand_aside);
		    rskill.setImageResource(R.drawable.a_draven_whirling_death);
		    break;
		case "Elise":
		    qskill.setImageResource(R.drawable.a_elise_neurotoxin);
		    wskill.setImageResource(R.drawable.a_elise_volatile_spiderling);
		    eskill.setImageResource(R.drawable.a_elise_cocoon);
		    rskill.setImageResource(R.drawable.a_elise_spider_form);
		    break;
		case "Evelynn":
		    qskill.setImageResource(R.drawable.a_evelynn_hate_spike);
		    wskill.setImageResource(R.drawable.a_evelynn_dark_frenzy);
		    eskill.setImageResource(R.drawable.a_evelynn_ravage);
		    rskill.setImageResource(R.drawable.a_evelynn_agonys_embrace);
		    break;
		case "Ezreal":
		    qskill.setImageResource(R.drawable.a_ezreal_mystic_shot);
		    wskill.setImageResource(R.drawable.a_ezreal_essence_flux);
		    eskill.setImageResource(R.drawable.a_ezreal_arcane_shift);
		    rskill.setImageResource(R.drawable.a_ezreal_trueshot_barrage);
		    break;
		case "Fiddlesticks":
		    qskill.setImageResource(R.drawable.a_fiddlesticks_terrify);
		    wskill.setImageResource(R.drawable.a_fiddlesticks_drain);
		    eskill.setImageResource(R.drawable.a_fiddlesticks_dark_wind);
		    rskill.setImageResource(R.drawable.a_fiddlesticks_crowstorm);
		    break;
		case "Fiora":
		    qskill.setImageResource(R.drawable.a_fiora_lunge);
		    wskill.setImageResource(R.drawable.a_fiora_riposte);
		    eskill.setImageResource(R.drawable.a_fiora_burst_of_speed);
		    rskill.setImageResource(R.drawable.a_fiora_blade_waltz);
		    break;
		case "Fizz":
		    qskill.setImageResource(R.drawable.a_fizz_urchin_strike);
		    wskill.setImageResource(R.drawable.a_fizz_seastone_trident);
		    eskill.setImageResource(R.drawable.a_fizz_playful_trickster);
		    rskill.setImageResource(R.drawable.a_fizz_chum_the_waters);
		    break;
		case "Galio":
		    qskill.setImageResource(R.drawable.a_galio_resolute_smite);
		    wskill.setImageResource(R.drawable.a_galio_bulwark);
		    eskill.setImageResource(R.drawable.a_galio_righteous_gust);
		    rskill.setImageResource(R.drawable.a_galio_idol_of_durand);
		    break;
		case "Gangplank":
		    qskill.setImageResource(R.drawable.a_gangplank_parrrley);
		    wskill.setImageResource(R.drawable.a_gangplank_remove_scurvy);
		    eskill.setImageResource(R.drawable.a_gangplank_raise_morale);
		    rskill.setImageResource(R.drawable.a_gangplank_cannon_barrage);
		    break;
		case "Garen":
		    qskill.setImageResource(R.drawable.a_garen_decisive_strike);
		    wskill.setImageResource(R.drawable.a_garen_courage);
		    eskill.setImageResource(R.drawable.a_garen_judgment);
		    rskill.setImageResource(R.drawable.a_garen_demacian_justice);
		    break;
		case "Gnar":
			qskill.setImageResource(R.drawable.a_gnar_boomerang_throw);
		    wskill.setImageResource(R.drawable.a_gnar_hyper);
		    eskill.setImageResource(R.drawable.a_gnar_hop);
		    rskill.setImageResource(R.drawable.a_gnar_gnar);
		    break;
		case "Gragas":
		    qskill.setImageResource(R.drawable.a_gragas_barrel_roll);
		    wskill.setImageResource(R.drawable.a_gragas_drunken_rage);
		    eskill.setImageResource(R.drawable.a_gragas_body_slam);
		    rskill.setImageResource(R.drawable.a_gragas_explosive_cask);
		    break;
		case "Graves":
		    qskill.setImageResource(R.drawable.a_graves_buckshot);
		    wskill.setImageResource(R.drawable.a_graves_smoke_screen);
		    eskill.setImageResource(R.drawable.a_graves_quickdraw);
		    rskill.setImageResource(R.drawable.a_graves_collateral_damage);
		    break;
		case "Hecarim":
		    qskill.setImageResource(R.drawable.a_hecarim_rampage);
		    wskill.setImageResource(R.drawable.a_hecarim_spirit_of_dread);
		    eskill.setImageResource(R.drawable.a_hecarim_devastating_charge);
		    rskill.setImageResource(R.drawable.a_hecarim_onslaught_of_shadows);
		    break;
		case "Heimerdinger":
		    qskill.setImageResource(R.drawable.a_heimerdinger_h_28g_evolution_turret);
		    wskill.setImageResource(R.drawable.a_heimerdinger_hextech_micro_rockets);
		    eskill.setImageResource(R.drawable.a_heimerdinger_ch_2_electron_storm_grenade);
		    rskill.setImageResource(R.drawable.a_heimerdinger_upgrade);
		    break;
		case "Irelia":
		    qskill.setImageResource(R.drawable.a_irelia_bladesurge);
		    wskill.setImageResource(R.drawable.a_irelia_hiten_style);
		    eskill.setImageResource(R.drawable.a_irelia_equilibrium_strike);
		    rskill.setImageResource(R.drawable.a_irelia_transcendent_blades);
		    break;
		case "Janna":
		    qskill.setImageResource(R.drawable.a_janna_howling_gale);
		    wskill.setImageResource(R.drawable.a_janna_zephyr);
		    eskill.setImageResource(R.drawable.a_janna_eye_of_the_storm);
		    rskill.setImageResource(R.drawable.a_janna_monsoon);
		    break;
		case "Jarvan IV":
		    qskill.setImageResource(R.drawable.a_jarvan_iv_dragon_strike);
		    wskill.setImageResource(R.drawable.a_jarvan_iv_golden_aegis);
		    eskill.setImageResource(R.drawable.a_jarvan_iv_demacian_standard);
		    rskill.setImageResource(R.drawable.a_jarvan_iv_cataclysm);
		    break;
		case "Jax":
		    qskill.setImageResource(R.drawable.a_jax_leap_strike);
		    wskill.setImageResource(R.drawable.a_jax_empower);
		    eskill.setImageResource(R.drawable.a_jax_counter_strike);
		    rskill.setImageResource(R.drawable.a_jax_grandmasters_might);
		    break;
		case "Jayce":
		    qskill.setImageResource(R.drawable.a_jayce_to_the_skies);
		    wskill.setImageResource(R.drawable.a_jayce_lightning_field);
		    eskill.setImageResource(R.drawable.a_jayce_thundering_blow);
		    rskill.setImageResource(R.drawable.a_jayce_mercury_cannon);
		    break;
		case "Jinx":
		    qskill.setImageResource(R.drawable.a_jinx_switcheroo);
		    wskill.setImageResource(R.drawable.a_jinx_zap);
		    eskill.setImageResource(R.drawable.a_jinx_flame_chompers);
		    rskill.setImageResource(R.drawable.a_jinx_super_mega_death_rocket);
		    break;
		case "Karma":
		    qskill.setImageResource(R.drawable.a_karma_inner_flame);
		    wskill.setImageResource(R.drawable.a_karma_focused_resolve);
		    eskill.setImageResource(R.drawable.a_karma_inspire);
		    rskill.setImageResource(R.drawable.a_karma_mantra);
		    break;
		case "Karthus":
		    qskill.setImageResource(R.drawable.a_karthus_lay_waste);
		    wskill.setImageResource(R.drawable.a_karthus_wall_of_pain);
		    eskill.setImageResource(R.drawable.a_karthus_defile);
		    rskill.setImageResource(R.drawable.a_karthus_requiem);
		    break;
		case "Kassadin":
		    qskill.setImageResource(R.drawable.a_kassadin_null_sphere);
		    wskill.setImageResource(R.drawable.a_kassadin_nether_blade);
		    eskill.setImageResource(R.drawable.a_kassadin_force_pulse);
		    rskill.setImageResource(R.drawable.a_kassadin_riftwalk);
		    break;
		case "Katarina":
		    qskill.setImageResource(R.drawable.a_katarina_bouncing_blades);
		    wskill.setImageResource(R.drawable.a_katarina_sinister_steel);
		    eskill.setImageResource(R.drawable.a_katarina_shunpo);
		    rskill.setImageResource(R.drawable.a_katarina_death_lotus);
		    break;
		case "Kayle":
		    qskill.setImageResource(R.drawable.a_kayle_reckoning);
		    wskill.setImageResource(R.drawable.a_kayle_divine_blessing);
		    eskill.setImageResource(R.drawable.a_kayle_righteous_fury);
		    rskill.setImageResource(R.drawable.a_kayle_intervention);
		    break;
		case "Kennen":
		    qskill.setImageResource(R.drawable.a_kennen_thundering_shuriken);
		    wskill.setImageResource(R.drawable.a_kennen_electrical_surge);
		    eskill.setImageResource(R.drawable.a_kennen_lightning_rush);
		    rskill.setImageResource(R.drawable.a_kennen_slicing_maelstrom);
		    break;
		case "Kha'Zix":
		    qskill.setImageResource(R.drawable.a_khazix_taste_their_fear);
		    wskill.setImageResource(R.drawable.a_khazix_void_spike);
		    eskill.setImageResource(R.drawable.a_khazix_leap);
		    rskill.setImageResource(R.drawable.a_khazix_void_assault);
		    break;
		case "Kog'Maw":
		    qskill.setImageResource(R.drawable.a_kogmaw_caustic_spittle);
		    wskill.setImageResource(R.drawable.a_kogmaw_bio_arcane_barrage);
		    eskill.setImageResource(R.drawable.a_kogmaw_void_ooze);
		    rskill.setImageResource(R.drawable.a_kogmaw_living_artillery);
		    break;
		case "LeBlanc":
		    qskill.setImageResource(R.drawable.a_leblanc_sigil_of_malice);
		    wskill.setImageResource(R.drawable.a_leblanc_distortion);
		    eskill.setImageResource(R.drawable.a_leblanc_ethereal_chains);
		    rskill.setImageResource(R.drawable.a_leblanc_mimic);
		    break;
		case "Lee Sin":
		    qskill.setImageResource(R.drawable.a_lee_sin_sonic_wave);
		    wskill.setImageResource(R.drawable.a_lee_sin_safeguard);
		    eskill.setImageResource(R.drawable.a_lee_sin_tempest);
		    rskill.setImageResource(R.drawable.a_lee_sin_dragons_rage);
		    break;
		case "Leona":
		    qskill.setImageResource(R.drawable.a_leona_shield_of_daybreak);
		    wskill.setImageResource(R.drawable.a_leona_eclipse);
		    eskill.setImageResource(R.drawable.a_leona_zenith_blade);
		    rskill.setImageResource(R.drawable.a_leona_solar_flare);
		    break;
		case "Lissandra":
		    qskill.setImageResource(R.drawable.a_lissandra_ice_shard);
		    wskill.setImageResource(R.drawable.a_lissandra_ring_of_frost);
		    eskill.setImageResource(R.drawable.a_lissandra_glacial_path);
		    rskill.setImageResource(R.drawable.a_lissandra_frozen_tomb);
		    break;
		case "Lucian":
		    qskill.setImageResource(R.drawable.a_lucian_piercing_light);
		    wskill.setImageResource(R.drawable.a_lucian_ardent_blaze);
		    eskill.setImageResource(R.drawable.a_lucian_relentless_pursuit);
		    rskill.setImageResource(R.drawable.a_lucian_the_culling);
		    break;
		case "Lulu":
		    qskill.setImageResource(R.drawable.a_lulu_glitterlance);
		    wskill.setImageResource(R.drawable.a_lulu_whimsy);
		    eskill.setImageResource(R.drawable.a_lulu_help_pix);
		    rskill.setImageResource(R.drawable.a_lulu_wild_growth);
		    break;
		case "Lux":
		    qskill.setImageResource(R.drawable.a_lux_light_binding);
		    wskill.setImageResource(R.drawable.a_lux_prismatic_barrier);
		    eskill.setImageResource(R.drawable.a_lux_lucent_singularity);
		    rskill.setImageResource(R.drawable.a_lux_final_spark);
		    break;
		case "Malphite":
		    qskill.setImageResource(R.drawable.a_malphite_seismic_shard);
		    wskill.setImageResource(R.drawable.a_malphite_brutal_strikes);
		    eskill.setImageResource(R.drawable.a_malphite_ground_slam);
		    rskill.setImageResource(R.drawable.a_malphite_unstoppable_force);
		    break;
		case "Malzahar":
		    qskill.setImageResource(R.drawable.a_malzahar_call_of_the_void);
		    wskill.setImageResource(R.drawable.a_malzahar_null_zone);
		    eskill.setImageResource(R.drawable.a_malzahar_malefic_visions);
		    rskill.setImageResource(R.drawable.a_malzahar_nether_grasp);
		    break;
		case "Maokai":
		    qskill.setImageResource(R.drawable.a_maokai_arcane_smash);
		    wskill.setImageResource(R.drawable.a_maokai_twisted_advance);
		    eskill.setImageResource(R.drawable.a_maokai_sapling_toss);
		    rskill.setImageResource(R.drawable.a_maokai_vengeful_maelstrom);
		    break;
		case "Master Yi":
		    qskill.setImageResource(R.drawable.a_master_yi_alpha_strike);
		    wskill.setImageResource(R.drawable.a_master_yi_meditate);
		    eskill.setImageResource(R.drawable.a_master_yi_wuju_style);
		    rskill.setImageResource(R.drawable.a_master_yi_highlander);
		    break;
		case "Miss Fortune":
		    qskill.setImageResource(R.drawable.a_miss_fortune_double_up);
		    wskill.setImageResource(R.drawable.a_miss_fortune_impure_shots);
		    eskill.setImageResource(R.drawable.a_miss_fortune_make_it_rain);
		    rskill.setImageResource(R.drawable.a_miss_fortune_bullet_time);
		    break;
		case "Mordekaiser":
		    qskill.setImageResource(R.drawable.a_mordekaiser_mace_of_spades);
		    wskill.setImageResource(R.drawable.a_mordekaiser_creeping_death);
		    eskill.setImageResource(R.drawable.a_mordekaiser_siphon_of_destruction);
		    rskill.setImageResource(R.drawable.a_mordekaiser_children_of_the_grave);
		    break;
		case "Morgana":
		    qskill.setImageResource(R.drawable.a_morgana_dark_binding);
		    wskill.setImageResource(R.drawable.a_morgana_tormented_soil);
		    eskill.setImageResource(R.drawable.a_morgana_black_shield);
		    rskill.setImageResource(R.drawable.a_morgana_soul_shackles);
		    break;
		case "Nami":
		    qskill.setImageResource(R.drawable.a_nami_aqua_prison);
		    wskill.setImageResource(R.drawable.a_nami_ebb_and_flow);
		    eskill.setImageResource(R.drawable.a_nami_tidecallers_blessing);
		    rskill.setImageResource(R.drawable.a_nami_tidal_wave);
		    break;
		case "Nasus":
		    qskill.setImageResource(R.drawable.a_nasus_siphoning_strike);
		    wskill.setImageResource(R.drawable.a_nasus_wither);
		    eskill.setImageResource(R.drawable.a_nasus_spirit_fire);
		    rskill.setImageResource(R.drawable.a_nasus_fury_of_the_sands);
		    break;
		case "Nautilus":
		    qskill.setImageResource(R.drawable.a_nautilus_dredge_line);
		    wskill.setImageResource(R.drawable.a_nautilus_titans_wrath);
		    eskill.setImageResource(R.drawable.a_nautilus_riptide);
		    rskill.setImageResource(R.drawable.a_nautilus_depth_charge);
		    break;
		case "Nidalee":
		    qskill.setImageResource(R.drawable.a_nidalee_javelin_toss);
		    wskill.setImageResource(R.drawable.a_nidalee_bushwhack);
		    eskill.setImageResource(R.drawable.a_nidalee_primal_surge);
		    rskill.setImageResource(R.drawable.a_nidalee_aspect_of_the_cougar);
		    break;
		case "Nocturne":
		    qskill.setImageResource(R.drawable.a_nocturne_duskbringer);
		    wskill.setImageResource(R.drawable.a_nocturne_shroud_of_darkness);
		    eskill.setImageResource(R.drawable.a_nocturne_unspeakable_horror);
		    rskill.setImageResource(R.drawable.a_nocturne_paranoia);
		    break;
		case "Nunu":
		    qskill.setImageResource(R.drawable.a_nunu_consume);
		    wskill.setImageResource(R.drawable.a_nunu_blood_boil);
		    eskill.setImageResource(R.drawable.a_nunu_ice_blast);
		    rskill.setImageResource(R.drawable.a_nunu_absolute_zero);
		    break;
		case "Olaf":
		    qskill.setImageResource(R.drawable.a_olaf_undertow);
		    wskill.setImageResource(R.drawable.a_olaf_vicious_strikes);
		    eskill.setImageResource(R.drawable.a_olaf_reckless_swing);
		    rskill.setImageResource(R.drawable.a_olaf_ragnarok);
		    break;
		case "Orianna":
		    qskill.setImageResource(R.drawable.a_orianna_command_attack);
		    wskill.setImageResource(R.drawable.a_orianna_command_dissonance);
		    eskill.setImageResource(R.drawable.a_orianna_command_protect);
		    rskill.setImageResource(R.drawable.a_orianna_command_shockwave);
		    break;
		case "Pantheon":
		    qskill.setImageResource(R.drawable.a_pantheon_spear_shot);
		    wskill.setImageResource(R.drawable.a_pantheon_aegis_of_zeonia);
		    eskill.setImageResource(R.drawable.a_pantheon_heartseeker_strike);
		    rskill.setImageResource(R.drawable.a_pantheon_grand_skyfall);
		    break;
		case "Poppy":
		    qskill.setImageResource(R.drawable.a_poppy_devastating_blow);
		    wskill.setImageResource(R.drawable.a_poppy_paragon_of_demacia);
		    eskill.setImageResource(R.drawable.a_poppy_heroic_charge);
		    rskill.setImageResource(R.drawable.a_poppy_diplomatic_immunity);
		    break;
		case "Quinn":
		    qskill.setImageResource(R.drawable.a_quinn_blinding_assault);
		    wskill.setImageResource(R.drawable.a_quinn_heightened_senses);
		    eskill.setImageResource(R.drawable.a_quinn_vault);
		    rskill.setImageResource(R.drawable.a_quinn_tag_team);
		    break;
		case "Rammus":
		    qskill.setImageResource(R.drawable.a_rammus_powerball);
		    wskill.setImageResource(R.drawable.a_rammus_defensive_ball_curl);
		    eskill.setImageResource(R.drawable.a_rammus_puncturing_taunt);
		    rskill.setImageResource(R.drawable.a_rammus_tremors);
		    break;
		case "Renekton":
		    qskill.setImageResource(R.drawable.a_renekton_cull_the_meek);
		    wskill.setImageResource(R.drawable.a_renekton_ruthless_predator);
		    eskill.setImageResource(R.drawable.a_renekton_slice_and_dice);
		    rskill.setImageResource(R.drawable.a_renekton_dominus);
		    break;
		case "Rengar":
		    qskill.setImageResource(R.drawable.a_rengar_savagery);
		    wskill.setImageResource(R.drawable.a_rengar_battle_roar);
		    eskill.setImageResource(R.drawable.a_rengar_bola_strike);
		    rskill.setImageResource(R.drawable.a_rengar_thrill_of_the_hunt);
		    break;
		case "Riven":
		    qskill.setImageResource(R.drawable.a_riven_broken_wings);
		    wskill.setImageResource(R.drawable.a_riven_ki_burst);
		    eskill.setImageResource(R.drawable.a_riven_valor);
		    rskill.setImageResource(R.drawable.a_riven_blade_of_the_exile);
		    break;
		case "Rumble":
		    qskill.setImageResource(R.drawable.a_rumble_flamespitter);
		    wskill.setImageResource(R.drawable.a_rumble_scrap_shield);
		    eskill.setImageResource(R.drawable.a_rumble_electro_harpoon);
		    rskill.setImageResource(R.drawable.a_rumble_the_equalizer);
		    break;
		case "Ryze":
		    qskill.setImageResource(R.drawable.a_ryze_overload);
		    wskill.setImageResource(R.drawable.a_ryze_rune_prison);
		    eskill.setImageResource(R.drawable.a_ryze_spell_flux);
		    rskill.setImageResource(R.drawable.a_ryze_desperate_power);
		    break;
		case "Sejuani":
		    qskill.setImageResource(R.drawable.a_sejuani_arctic_assault);
		    wskill.setImageResource(R.drawable.a_sejuani_flail_of_the_northern_winds);
		    eskill.setImageResource(R.drawable.a_sejuani_permafrost);
		    rskill.setImageResource(R.drawable.a_sejuani_glacial_prison);
		    break;
		case "Shaco":
		    qskill.setImageResource(R.drawable.a_shaco_deceive);
		    wskill.setImageResource(R.drawable.a_shaco_jack_in_the_box);
		    eskill.setImageResource(R.drawable.a_shaco_two_shiv_poison);
		    rskill.setImageResource(R.drawable.a_shaco_hallucinate);
		    break;
		case "Shen":
		    qskill.setImageResource(R.drawable.a_shen_vorpal_blade);
		    wskill.setImageResource(R.drawable.a_shen_feint);
		    eskill.setImageResource(R.drawable.a_shen_shadow_dash);
		    rskill.setImageResource(R.drawable.a_shen_stand_united);
		    break;
		case "Shyvana":
		    qskill.setImageResource(R.drawable.a_shyvana_twin_bite);
		    wskill.setImageResource(R.drawable.a_shyvana_burnout);
		    eskill.setImageResource(R.drawable.a_shyvana_flame_breath);
		    rskill.setImageResource(R.drawable.a_shyvana_dragons_descent);
		    break;
		case "Singed":
		    qskill.setImageResource(R.drawable.a_singed_poison_trail);
		    wskill.setImageResource(R.drawable.a_singed_mega_adhesive);
		    eskill.setImageResource(R.drawable.a_singed_fling);
		    rskill.setImageResource(R.drawable.a_singed_insanity_potion);
		    break;
		case "Sion":
		    qskill.setImageResource(R.drawable.a_sion_cryptic_gaze);
		    wskill.setImageResource(R.drawable.a_sion_deaths_caress);
		    eskill.setImageResource(R.drawable.a_sion_enrage);
		    rskill.setImageResource(R.drawable.a_sion_cannibalism);
		    break;
		case "Sivir":
		    qskill.setImageResource(R.drawable.a_sivir_boomerang_blade);
		    wskill.setImageResource(R.drawable.a_sivir_ricochet);
		    eskill.setImageResource(R.drawable.a_sivir_spell_shield);
		    rskill.setImageResource(R.drawable.a_sivir_on_the_hunt);
		    break;
		case "Skarner":
		    qskill.setImageResource(R.drawable.a_skarner_crystal_slash);
		    wskill.setImageResource(R.drawable.a_skarner_crystalline_exoskeleton);
		    eskill.setImageResource(R.drawable.a_skarner_fracture);
		    rskill.setImageResource(R.drawable.a_skarner_impale);
		    break;
		case "Sona":
		    qskill.setImageResource(R.drawable.a_sona_hymn_of_valor);
		    wskill.setImageResource(R.drawable.a_sona_aria_of_perseverance);
		    eskill.setImageResource(R.drawable.a_sona_song_of_celerity);
		    rskill.setImageResource(R.drawable.a_sona_crescendo);
		    break;
		case "Soraka":
		    qskill.setImageResource(R.drawable.a_soraka_starcall);
		    wskill.setImageResource(R.drawable.a_soraka_astral_blessing);
		    eskill.setImageResource(R.drawable.a_soraka_infuse);
		    rskill.setImageResource(R.drawable.a_soraka_wish);
		    break;
		case "Swain":
		    qskill.setImageResource(R.drawable.a_swain_decrepify);
		    wskill.setImageResource(R.drawable.a_swain_nevermove);
		    eskill.setImageResource(R.drawable.a_swain_torment);
		    rskill.setImageResource(R.drawable.a_swain_ravenous_flock);
		    break;
		case "Syndra":
		    qskill.setImageResource(R.drawable.a_syndra_dark_sphere);
		    wskill.setImageResource(R.drawable.a_syndra_force_of_will);
		    eskill.setImageResource(R.drawable.a_syndra_scatter_the_weak);
		    rskill.setImageResource(R.drawable.a_syndra_unleashed_power);
		    break;
		case "Talon":
		    qskill.setImageResource(R.drawable.a_talon_noxian_diplomacy);
		    wskill.setImageResource(R.drawable.a_talon_rake);
		    eskill.setImageResource(R.drawable.a_talon_cutthroat);
		    rskill.setImageResource(R.drawable.a_talon_shadow_assault);
		    break;
		case "Taric":
		    qskill.setImageResource(R.drawable.a_taric_imbue);
		    wskill.setImageResource(R.drawable.a_taric_shatter);
		    eskill.setImageResource(R.drawable.a_taric_dazzle);
		    rskill.setImageResource(R.drawable.a_taric_radiance);
		    break;
		case "Teemo":
		    qskill.setImageResource(R.drawable.a_teemo_blinding_dart);
		    wskill.setImageResource(R.drawable.a_teemo_move_quick);
		    eskill.setImageResource(R.drawable.a_teemo_toxic_shot);
		    rskill.setImageResource(R.drawable.a_teemo_noxious_trap);
		    break;
		case "Thresh":
		    qskill.setImageResource(R.drawable.a_thresh_death_sentence);
		    wskill.setImageResource(R.drawable.a_thresh_dark_passage);
		    eskill.setImageResource(R.drawable.a_thresh_flay);
		    rskill.setImageResource(R.drawable.a_thresh_the_box);
		    break;
		case "Tristana":
		    qskill.setImageResource(R.drawable.a_tristana_rapid_fire);
		    wskill.setImageResource(R.drawable.a_tristana_rocket_jump);
		    eskill.setImageResource(R.drawable.a_tristana_explosive_shot);
		    rskill.setImageResource(R.drawable.a_tristana_buster_shot);
		    break;
		case "Trundle":
		    qskill.setImageResource(R.drawable.a_trundle_chomp);
		    wskill.setImageResource(R.drawable.a_trundle_frozen_domain);
		    eskill.setImageResource(R.drawable.a_trundle_pillar_of_ice);
		    rskill.setImageResource(R.drawable.a_trundle_subjugate);
		    break;
		case "Tryndamere":
		    qskill.setImageResource(R.drawable.a_tryndamere_battle_fury);
		    wskill.setImageResource(R.drawable.a_tryndamere_bloodlust);
		    eskill.setImageResource(R.drawable.a_tryndamere_mocking_shout);
		    rskill.setImageResource(R.drawable.a_tryndamere_spinning_slash);
		    break;
		case "Twisted Fate":
		    qskill.setImageResource(R.drawable.a_twisted_fate_wild_cards);
		    wskill.setImageResource(R.drawable.a_twisted_fate_pick_a_card);
		    eskill.setImageResource(R.drawable.a_twisted_fate_stacked_deck);
		    rskill.setImageResource(R.drawable.a_twisted_fate_destiny);
		    break;
		case "Twitch":
		    qskill.setImageResource(R.drawable.a_twitch_ambush);
		    wskill.setImageResource(R.drawable.a_twitch_venom_cask);
		    eskill.setImageResource(R.drawable.a_twitch_contaminate);
		    rskill.setImageResource(R.drawable.a_twitch_rat_ta_tat_tat);
		    break;
		case "Udyr":
		    qskill.setImageResource(R.drawable.a_udyr_tiger_stance);
		    wskill.setImageResource(R.drawable.a_udyr_turtle_stance);
		    eskill.setImageResource(R.drawable.a_udyr_bear_stance);
		    rskill.setImageResource(R.drawable.a_udyr_phoenix_stance);
		    break;
		case "Urgot":
		    qskill.setImageResource(R.drawable.a_urgot_acid_hunter);
		    wskill.setImageResource(R.drawable.a_urgot_terror_capacitor);
		    eskill.setImageResource(R.drawable.a_urgot_noxian_corrosive_charge);
		    rskill.setImageResource(R.drawable.a_urgot_hyper_kinetic_position_reverser);
		    break;
		case "Varus":
		    qskill.setImageResource(R.drawable.a_varus_piercing_arrow);
		    wskill.setImageResource(R.drawable.a_varus_blighted_quiver);
		    eskill.setImageResource(R.drawable.a_varus_hail_of_arrows);
		    rskill.setImageResource(R.drawable.a_varus_chain_of_corruption);
		    break;
		case "Vayne":
		    qskill.setImageResource(R.drawable.a_vayne_tumble);
		    wskill.setImageResource(R.drawable.a_vayne_silver_bolts);
		    eskill.setImageResource(R.drawable.a_vayne_condemn);
		    rskill.setImageResource(R.drawable.a_vayne_final_hour);
		    break;
		case "Veigar":
		    qskill.setImageResource(R.drawable.a_veigar_baleful_strike);
		    wskill.setImageResource(R.drawable.a_veigar_dark_matter);
		    eskill.setImageResource(R.drawable.a_veigar_event_horizon);
		    rskill.setImageResource(R.drawable.a_veigar_primordial_burst);
		    break;
		case "Vel'Koz":
		    qskill.setImageResource(R.drawable.a_velkoz_plasma_fission);
		    wskill.setImageResource(R.drawable.a_velkoz_void_rift);
		    eskill.setImageResource(R.drawable.a_velkoz_tectonic_disruption);
		    rskill.setImageResource(R.drawable.a_velkoz_life_form_disintegration_ray);
		    break;
		case "Vi":
		    qskill.setImageResource(R.drawable.a_vi_vault_breaker);
		    wskill.setImageResource(R.drawable.a_vi_denting_blows);
		    eskill.setImageResource(R.drawable.a_vi_excessive_force);
		    rskill.setImageResource(R.drawable.a_vi_assault_and_battery);
		    break;
		case "Viktor":
		    qskill.setImageResource(R.drawable.a_viktor_power_transfer);
		    wskill.setImageResource(R.drawable.a_viktor_gravity_field);
		    eskill.setImageResource(R.drawable.a_viktor_death_ray);
		    rskill.setImageResource(R.drawable.a_viktor_chaos_storm);
		    break;
		case "Vladimir":
		    qskill.setImageResource(R.drawable.a_vladimir_transfusion);
		    wskill.setImageResource(R.drawable.a_vladimir_sanguine_pool);
		    eskill.setImageResource(R.drawable.a_vladimir_tides_of_blood);
		    rskill.setImageResource(R.drawable.a_vladimir_hemoplague);
		    break;
		case "Volibear":
		    qskill.setImageResource(R.drawable.a_volibear_rolling_thunder);
		    wskill.setImageResource(R.drawable.a_volibear_frenzy);
		    eskill.setImageResource(R.drawable.a_volibear_majestic_roar);
		    rskill.setImageResource(R.drawable.a_volibear_thunder_claws);
		    break;
		case "Warwick":
		    qskill.setImageResource(R.drawable.a_warwick_hungering_strike);
		    wskill.setImageResource(R.drawable.a_warwick_hunters_call);
		    eskill.setImageResource(R.drawable.a_warwick_blood_scent);
		    rskill.setImageResource(R.drawable.a_warwick_infinite_duress);
		    break;
		case "Wukong":
		    qskill.setImageResource(R.drawable.a_wukong_crushing_blow);
		    wskill.setImageResource(R.drawable.a_wukong_decoy);
		    eskill.setImageResource(R.drawable.a_wukong_nimbus_strike);
		    rskill.setImageResource(R.drawable.a_wukong_cyclone);
		    break;
		case "Xerath":
		    qskill.setImageResource(R.drawable.a_xerath_arcanopulse);
		    wskill.setImageResource(R.drawable.a_xerath_eye_of_destruction);
		    eskill.setImageResource(R.drawable.a_xerath_shocking_orb);
		    rskill.setImageResource(R.drawable.a_xerath_rite_of_the_arcane);
		    break;
		case "Xin Zhao":
		    qskill.setImageResource(R.drawable.a_xin_zhao_three_talon_strike);
		    wskill.setImageResource(R.drawable.a_xin_zhao_battle_cry);
		    eskill.setImageResource(R.drawable.a_xin_zhao_audacious_charge);
		    rskill.setImageResource(R.drawable.a_xin_zhao_crescent_sweep);
		    break;
		case "Yasuo":
		    qskill.setImageResource(R.drawable.a_yasuo_steel_tempest);
		    wskill.setImageResource(R.drawable.a_yasuo_wind_wall);
		    eskill.setImageResource(R.drawable.a_yasuo_sweeping_blade);
		    rskill.setImageResource(R.drawable.a_yasuo_last_breath);
		    break;
		case "Yorick":
		    qskill.setImageResource(R.drawable.a_yorick_omen_of_war);
		    wskill.setImageResource(R.drawable.a_yorick_omen_of_pestilence);
		    eskill.setImageResource(R.drawable.a_yorick_omen_of_famine);
		    rskill.setImageResource(R.drawable.a_yorick_omen_of_death);
		    break;
		case "Zac":
		    qskill.setImageResource(R.drawable.a_zac_stretching_strike);
		    wskill.setImageResource(R.drawable.a_zac_unstable_matter);
		    eskill.setImageResource(R.drawable.a_zac_elastic_slingshot);
		    rskill.setImageResource(R.drawable.a_zac_lets_bounce);
		    break;
		case "Zed":
		    qskill.setImageResource(R.drawable.a_zed_razor_shuriken);
		    wskill.setImageResource(R.drawable.a_zed_living_shadow);
		    eskill.setImageResource(R.drawable.a_zed_shadow_slash);
		    rskill.setImageResource(R.drawable.a_zed_death_mark);
		    break;
		case "Ziggs":
		    qskill.setImageResource(R.drawable.a_ziggs_short_fuse);
		    wskill.setImageResource(R.drawable.a_ziggs_bouncing_bomb);
		    eskill.setImageResource(R.drawable.a_ziggs_satchel_charge);
		    rskill.setImageResource(R.drawable.a_ziggs_hexplosive_minefield);
		    break;
		case "Zilean":
		    qskill.setImageResource(R.drawable.a_zilean_time_bomb);
		    wskill.setImageResource(R.drawable.a_zilean_rewind);
		    eskill.setImageResource(R.drawable.a_zilean_time_warp);
		    rskill.setImageResource(R.drawable.a_zilean_chrono_shift);
		    break;
		case "Zyra":
		    qskill.setImageResource(R.drawable.a_zyra_deadly_bloom);
		    wskill.setImageResource(R.drawable.a_zyra_rampant_growth);
		    eskill.setImageResource(R.drawable.a_zyra_grasping_roots);
		    rskill.setImageResource(R.drawable.a_zyra_stranglethorns);
		    break; 
		}
		
		
		
	}

	public void save(){//View v is a required argument if you use onClick inside the XML file to call this directly.
		//this method determines whether or not to send a toast with instructions or to just save this info when the save button is clicked
				
		EditText levelTextInput = (EditText) findViewById(R.id.edit_text_level);
		EditText qskillTextInput = (EditText) findViewById(R.id.edit_text_q);
		EditText wskillTextInput = (EditText) findViewById(R.id.edit_text_w);
		EditText eskillTextInput = (EditText) findViewById(R.id.edit_text_e);
		EditText rskillTextInput = (EditText) findViewById(R.id.edit_text_r);
		String levelText = levelTextInput.getText().toString();
		String qskillText = qskillTextInput.getText().toString();
		String wskillText = wskillTextInput.getText().toString();
		String eskillText = eskillTextInput.getText().toString();
		String rskillText = rskillTextInput.getText().toString();
		
		
		
		if (levelText.matches("")){//.equals() also works
			levelText = "0";
		}
		if (qskillText.matches("")){
			qskillText = "0";
		}
		if (wskillText.matches("")){
			wskillText = "0";
		}
		if (eskillText.matches("")){
			eskillText = "0";
		}
		if (rskillText.matches("")){
			rskillText = "0";
		}
		
		
		byte level = Byte.parseByte(levelText);
		byte qskill = Byte.parseByte(qskillText);
		byte wskill = Byte.parseByte(wskillText);
		byte eskill = Byte.parseByte(eskillText);
		byte rskill = Byte.parseByte(rskillText);

		
		boolean pointConditionFail = 
				(level > 18) ||
				(level < qskill + wskill + eskill + rskill) ||
				((qskill >=2 || wskill >=2 || eskill >=2) && level < 3) ||
				((qskill >=3 || wskill >=3 || eskill >=3) &&level < 5) ||
				((qskill >=4 || wskill >=4 || eskill >=4) && level < 7) ||
				((qskill >=5 || wskill >=5 || eskill >=5) && level < 9) ||
				(qskill >5 || wskill >5 || eskill >5 || rskill >3) ||
				((rskill >=1) && level < 6) ||
				((rskill >=2) && level < 11) ||
				((rskill >=3) && level < 16);
		
		

		if (pointConditionFail == false){
			


			Intent saveChampion = new Intent(this, ViewChampionActivity.class);
			

			saveChampion.putExtra("Name", userSelectedChampion);
			saveChampion.putExtra("level", level);
			saveChampion.putExtra("qskill", qskill);
			saveChampion.putExtra("wskill", wskill);
			saveChampion.putExtra("eskill", eskill);
			saveChampion.putExtra("rskill", rskill);

			
			startActivity(saveChampion);
		}
		
		else{
			Toast.makeText(CreateChampionActivity.this, "Q, W, and E restrictions: "
					+ "\n" + "2 ability points at level 3, "
					+ "\n" + "3 ability points at level 5, "
					+ "\n" + "4 ability points at level 7, "
					+ "\n" + "5 ability points at level 9."
					+ "\n" + "\n" + "R restrictions: "
					+ "\n" + "1 ability point at level 6, "
					+ "\n" + "2 ability points at level 11, "
					+ "\n" + "3 ability points at level 16.", Toast.LENGTH_LONG).show();
		}
	}
}




