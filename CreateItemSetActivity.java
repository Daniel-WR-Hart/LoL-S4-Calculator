package com.leagueoflegendscalculator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.leagueoflegendscalculator.adapter.ClassExpandableListAdapterItems;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateItemSetActivity extends ActionBarActivity{
//REMEMBER TO TAKE INTO ACCOUNT CONSUMABLES IN THE FINAL DPS CALCULATIONS
    ClassExpandableListAdapterItems listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    
    ImageView itemSlot1;
    ImageView itemSlot2;
    ImageView itemSlot3;
    ImageView itemSlot4;
    ImageView itemSlot5;
    ImageView itemSlot6;
    
	String itemChosen1 = " ";
	String itemChosen2 = " ";
	String itemChosen3 = " ";
	String itemChosen4 = " ";
	String itemChosen5 = " ";
	String itemChosen6 = " ";
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_item);
		
		//This is needed to give listDataHeader and listDataChild actual values. Before this point they are defined but empty.
		prepareListData();
        expListView = (ExpandableListView) findViewById(R.id.expandableListViewItemSelect);
        listAdapter = new ClassExpandableListAdapterItems(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

		expListView.setOnChildClickListener(new OnChildClickListener() {
		    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {//This variable in position is the location on the list that you clicked on

		    	setItemCollection(groupPosition, childPosition);

		    	return false;
		    }
		});
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_create_item, menu);
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


	
	
    //Preparing the list data
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 

        // Adding header names
        listDataHeader.add("Attack Damage");
        listDataHeader.add("Critical Strike");   
        listDataHeader.add("Attack Speed");
        listDataHeader.add("Life Steal");
        listDataHeader.add("Ability Power");
        listDataHeader.add("Cooldown Reduction");
        listDataHeader.add("Mana + Mana Regen");
        listDataHeader.add("Health + Health Regen");
        listDataHeader.add("Magic Resist");
        listDataHeader.add("Armor");
        listDataHeader.add("Movement");

        
        // Adding child data
        List<String> attackDamage = new ArrayList<String>();
        attackDamage.add("B.F. Sword");
        attackDamage.add("Bilgewater Cutlass");
        attackDamage.add("Blade of the Ruined King");
        attackDamage.add("Doran's Blade");
        attackDamage.add("Entropy");
        attackDamage.add("Essence Reaver");        
        attackDamage.add("Executioner's Calling");
        attackDamage.add("Feral Flare");
        attackDamage.add("Frozen Mallet");
        attackDamage.add("Grez's Spectral Lantern");
        attackDamage.add("Guinsoo's Rageblade");
        attackDamage.add("Hexdrinker");
        attackDamage.add("Hextech Gunblade");
        attackDamage.add("Infinity Edge");
        attackDamage.add("Last Whisper");
        attackDamage.add("Long Sword");
        attackDamage.add("Lord Van Damm's Pillager");
        attackDamage.add("Manamune");
        attackDamage.add("Maw of Malmortius");
        attackDamage.add("Mercurial Scimitar");
        attackDamage.add("Muramana");
        attackDamage.add("Phage");
        attackDamage.add("Pickaxe");
        attackDamage.add("Prospector's Blade");
        attackDamage.add("Ravenous Hydra (Melee Only)");
        attackDamage.add("Sanguine Blade");
        attackDamage.add("Spirit of the Elder Lizard");
        attackDamage.add("Sword of the Occult");
        attackDamage.add("The Black Cleaver");
        attackDamage.add("The Bloodthirster");
        attackDamage.add("The Brutalizer");
        attackDamage.add("The Lightbringer");
        attackDamage.add("Tiamat (Melee Only)");
        attackDamage.add("Trinity Force");
        attackDamage.add("Vampiric Scepter");
        attackDamage.add("Wicked Hatchet");
        attackDamage.add("Wriggle's Lantern");
        attackDamage.add("Youmuu's Ghostblade");
        attackDamage.add("Zephyr");
        
        List<String> criticalStrike = new ArrayList<String>();
        criticalStrike.add("Atma's Impaler");
        criticalStrike.add("Avarice Blade");
        criticalStrike.add("Brawler's Gloves");
        criticalStrike.add("Cloak of Agility");
        criticalStrike.add("Executioner's Calling");
        criticalStrike.add("Infinity Edge");
        criticalStrike.add("Lord Van Damm's Pillager");
        criticalStrike.add("Phantom Dancer");
        criticalStrike.add("The Lightbringer");
        criticalStrike.add("Statikk Shiv");
        criticalStrike.add("Sword of the Divine");
        criticalStrike.add("Trinity Force");
        criticalStrike.add("Wicked Hatchet");
        criticalStrike.add("Youmuu's Ghostblade");
        criticalStrike.add("Zeal");
        
        List<String> attackSpeed = new ArrayList<String>();
        attackSpeed.add("Berserker's Greaves");
        attackSpeed.add("Blade of the Ruined King");
        attackSpeed.add("Dagger");
        attackSpeed.add("Dervish Blade");
        attackSpeed.add("Feral Flare");
        attackSpeed.add("Madred's Razors");
        attackSpeed.add("Nashor's Tooth");
        attackSpeed.add("Phantom Dancer");
        attackSpeed.add("Prospector's Blade");
        attackSpeed.add("Recurve Bow");
        attackSpeed.add("Runaan's Hurricane (Ranged Only)");
        attackSpeed.add("Statikk Shiv");
        attackSpeed.add("Stinger");
        attackSpeed.add("Sword of the Divine");
        attackSpeed.add("Trinity Force");
        attackSpeed.add("Wit's End");
        attackSpeed.add("Wriggle's Lantern");
        attackSpeed.add("Zeal");
        attackSpeed.add("Zephyr");
        
        List<String> lifeSteal = new ArrayList<String>();
        lifeSteal.add("Bilgewater Cutlass");
        lifeSteal.add("Blade of the Ruined King");
        lifeSteal.add("Doran's Blade");
        lifeSteal.add("Essence Reaver"); 
        lifeSteal.add("Grez's Spectral Lantern");
        lifeSteal.add("Guinsoo's Rageblade");
        lifeSteal.add("Hextech Gunblade");
        lifeSteal.add("Ravenous Hydra (Melee Only)");
        lifeSteal.add("Sanguine Blade");
        lifeSteal.add("The Bloodthirster");
        lifeSteal.add("Vampiric Scepter");
        lifeSteal.add("Zeke's Herald");
        
        List<String> abilityPower = new ArrayList<String>();
        abilityPower.add("Abyssal Scepter");
        abilityPower.add("Aether Wisp");
        abilityPower.add("Amplifying Tome");
        abilityPower.add("Archangel's Staff");
        abilityPower.add("Ardent Censer");
        abilityPower.add("Athene's Unholy Grail");
        abilityPower.add("Augment: Death");
        abilityPower.add("Banner of Command");
        abilityPower.add("Blackfire Torch");
        abilityPower.add("Blasting Wand");
        abilityPower.add("Deathfire Grasp");
        abilityPower.add("Doran's Ring");
        abilityPower.add("Fiendish Codex");
        abilityPower.add("Frost Queen's Claim");
        abilityPower.add("Frostfang");
        abilityPower.add("Guinsoo's Rageblade");
        abilityPower.add("Haunting Guise");
        abilityPower.add("Hextech Gunblade");
        abilityPower.add("Hextech Revolver");
        abilityPower.add("Iceborn Gauntlet");
        abilityPower.add("Liandry's Torment");
        abilityPower.add("Lich Bane");
        abilityPower.add("Mejai's Soulstealer");
        abilityPower.add("Moonflair Spellblade");
        abilityPower.add("Morellonomicon");
        abilityPower.add("Nashor's Tooth");
        abilityPower.add("Needlessly Large Rod");
        abilityPower.add("Ohmwrecker");
        abilityPower.add("Prospector's Ring");
        abilityPower.add("Rabadon's Deathcap");
        abilityPower.add("Rod of Ages");
        abilityPower.add("Rylai's Crystal Scepter");
        abilityPower.add("Seeker's Armguard");
        abilityPower.add("Seraph's Embrace");
        abilityPower.add("Sheen");
        abilityPower.add("Spellthief's Edge");
        abilityPower.add("Spirit of the Spectral Wraith");
        abilityPower.add("Trinity Force");
        abilityPower.add("Twin Shadows");
        abilityPower.add("Void Staff");
        abilityPower.add("Will of the Ancients");
        abilityPower.add("Wooglet's Witchcap");
        abilityPower.add("Zhonya's Hourglass");
        
        List<String> cooldownReduction = new ArrayList<String>();
        cooldownReduction.add("Ardent Censer");
        cooldownReduction.add("Athene's Unholy Grail");
        cooldownReduction.add("Augment: Gravity");
        cooldownReduction.add("Banner of Command");
        cooldownReduction.add("Blackfire Torch");
        cooldownReduction.add("Deathfire Grasp");
        cooldownReduction.add("Dervish Blade");
        cooldownReduction.add("Essence Reaver");
        cooldownReduction.add("Face of the Mountain");
        cooldownReduction.add("Fiendish Codex");
        cooldownReduction.add("Forbidden Idol");
        cooldownReduction.add("Frost Queen's Claim");
        cooldownReduction.add("Frozen Heart");
        cooldownReduction.add("Glacial Shroud");
        cooldownReduction.add("Hextech Sweeper");
        cooldownReduction.add("Iceborn Gauntlet");
        cooldownReduction.add("Ionian Boots of Lucidity");
        cooldownReduction.add("Kindlegem");
        cooldownReduction.add("Locket of the Iron Solari");
        cooldownReduction.add("Morellonomicon");
        cooldownReduction.add("Nashor's Tooth");
        cooldownReduction.add("Spirit Visage");
        cooldownReduction.add("Spirit of the Ancient Golem");
        cooldownReduction.add("Spirit of the Elder Lizard");
        cooldownReduction.add("Spirit of the Spectral Wraith");
        cooldownReduction.add("Stinger");
        cooldownReduction.add("Talisman of Ascension");
        cooldownReduction.add("The Black Cleaver");
        cooldownReduction.add("The Brutalizer");
        cooldownReduction.add("Twin Shadows");
        cooldownReduction.add("Will of the Ancients");
        cooldownReduction.add("Youmuu's Ghostblade");
        cooldownReduction.add("Zeke's Herald");
        cooldownReduction.add("Zephyr");
        
        List<String> mana = new ArrayList<String>();
        mana.add("Ancient Coin");
        mana.add("Archangel's Staff");
        mana.add("Ardent Censer");
        mana.add("Athene's Unholy Grail");
        mana.add("Augment: Gravity");
        mana.add("Catalyst the Protector");
        mana.add("Chalice of Harmony");
        mana.add("Doran's Ring");
        mana.add("Faerie Charm");
        mana.add("Forbidden Idol");
        mana.add("Frost Queen's Claim");
        mana.add("Frostfang");
        mana.add("Frozen Heart");
        mana.add("Glacial Shroud");
        mana.add("Hextech Sweeper");
        mana.add("Iceborn Gauntlet");
        mana.add("Lich Bane");
        mana.add("Manamune");
        mana.add("Mikael's Crucible");
        mana.add("Morellonomicon");
        mana.add("Muramana");
        mana.add("Nomad's Medallion");
        mana.add("Odyn's Veil");
        mana.add("Prospector's Ring");
        mana.add("Rod of Ages");
        mana.add("Sapphire Crystal");
        mana.add("Seraph's Embrace");
        mana.add("Sheen");
        mana.add("Spellthief's Edge");
        mana.add("Talisman of Ascension");
        mana.add("Tear of the Goddess");
        mana.add("Trinity Force");
        
        List<String> health = new ArrayList<String>();
        health.add("Aegis of the Legion");
        health.add("Augment: Power");
        health.add("Banshee's Veil");
        health.add("Catalyst the Protector");
        health.add("Doran's Blade");
        health.add("Doran's Ring");
        health.add("Doran's Shield");
        health.add("Entropy");
        health.add("Face of the Mountain");
        health.add("Frozen Mallet");
        health.add("Giant's Belt");
        health.add("Guardian's Horn");
        health.add("Haunting Guise");
        health.add("Hextech Sweeper");
        health.add("Kindlegem");
        health.add("Liandry's Torment");
        health.add("Locket of the Iron Solari");
        health.add("Nomad's Medallion");
        health.add("Odyn's Veil");
        health.add("Ohmwrecker");
        health.add("Orb of Winter");
        health.add("Overlord's Bloodmail");
        health.add("Phage");
        health.add("Randuin's Omen");
        health.add("Ravenous Hydra (Melee Only)");
        health.add("Relic Shield");
        health.add("Rejuvenation Bead");
        health.add("Rod of Ages");
        health.add("Ruby Crystal");
        health.add("Ruby Sightstone");
        health.add("Rylai's Crystal Scepter");
        health.add("Sightstone");
        health.add("Spectre's Cowl");
        health.add("Spirit Visage");
        health.add("Spirit of the Ancient Golem");
        health.add("Sunfire Cape");
        health.add("Talisman of Ascension");
        health.add("Targon's Brace");
        health.add("The Black Cleaver");
        health.add("Tiamat (Melee Only)");
        health.add("Trinity Force");
        health.add("Warmog's Armor");
        health.add("Zeke's Herald");
        
        List<String> magicResist = new ArrayList<String>();
        magicResist.add("Abyssal Scepter");
        magicResist.add("Aegis of the Legion");
        magicResist.add("Athene's Unholy Grail");
        magicResist.add("Banshee's Veil");
        magicResist.add("Chalice of Harmony");
        magicResist.add("Dervish Blade");
        magicResist.add("Guardian Angel");
        magicResist.add("Hexdrinker");
        magicResist.add("Locket of the Iron Solari");
        magicResist.add("Maw of Malmortius");
        magicResist.add("Mercurial Scimitar");
        magicResist.add("Mercury's Treads");
        magicResist.add("Mikael's Crucible");
        magicResist.add("Moonflair Spellblade");
        magicResist.add("Negatron Cloak");
        magicResist.add("Null-Magic Mantle");
        magicResist.add("Odyn's Veil");
        magicResist.add("Orb of Winter");
        magicResist.add("Quicksilver Sash");
        magicResist.add("Spectre's Cowl");
        magicResist.add("Spirit Visage");
        magicResist.add("Wit's End");
        
        List<String> armor = new ArrayList<String>();
        armor.add("Atma's Impaler");
        armor.add("Chain Vest");
        armor.add("Cloth Armor");
        armor.add("Frozen Heart");
        armor.add("Glacial Shroud");
        armor.add("Grez's Spectral Lantern");
        armor.add("Guardian Angel");
        armor.add("Hextech Sweeper");
        armor.add("Iceborn Gauntlet");
        armor.add("Moonflair Spellblade");
        armor.add("Ninja Tabi");
        armor.add("Quill Coat");
        armor.add("Randuin's Omen");
        armor.add("Seeker's Armguard");
        armor.add("Spirit of the Ancient Golem");
        armor.add("Sunfire Cape");
        armor.add("Thornmail");
        armor.add("Warden's Mail");
        armor.add("Wooglet's Witchcap");
        armor.add("Zhonya's Hourglass");
        
        List<String> movement = new ArrayList<String>();
        movement.add("Ardent Censer");
        movement.add("Berserker's Greaves");
        movement.add("Boots of Mobility");
        movement.add("Boots of Speed");
        movement.add("Boots of Swiftness");
        movement.add("Ionian Boots of Lucidity");
        movement.add("Mercury's Treads");
        movement.add("Ninja Tabi");
        movement.add("Sorcerer's Shoes");
        movement.add("Lich Bane");
        movement.add("Phantom Dancer");
        movement.add("Statikk Shiv");
        movement.add("Trinity Force");
        movement.add("Twin Shadows");
        movement.add("Zeal");
        movement.add("Zephyr");
        

        listDataChild.put(listDataHeader.get(0), attackDamage); // Header, Child data
        listDataChild.put(listDataHeader.get(1), criticalStrike);
        listDataChild.put(listDataHeader.get(2), attackSpeed);
        listDataChild.put(listDataHeader.get(3), lifeSteal); 
        listDataChild.put(listDataHeader.get(4), abilityPower); 
        listDataChild.put(listDataHeader.get(5), cooldownReduction); 
        listDataChild.put(listDataHeader.get(6), mana); 
        listDataChild.put(listDataHeader.get(7), health); 
        listDataChild.put(listDataHeader.get(8), magicResist); 
        listDataChild.put(listDataHeader.get(9), armor); 
        listDataChild.put(listDataHeader.get(10), movement);

    }
	

    public void setItemCollection(int groupPosition, int childPosition){
    	
    	itemSlot1 = (ImageView) findViewById(R.id.item_slot_1);
    	itemSlot2 = (ImageView) findViewById(R.id.item_slot_2);
    	itemSlot3 = (ImageView) findViewById(R.id.item_slot_3);
    	itemSlot4 = (ImageView) findViewById(R.id.item_slot_4);
    	itemSlot5 = (ImageView) findViewById(R.id.item_slot_5);
    	itemSlot6 = (ImageView) findViewById(R.id.item_slot_6);
    	ImageView itemSlotReferenceHolder;
    	
    	//saves the item selection as a string
    	String itemChosen = this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
     	
    	Bitmap bitmap1 = ((BitmapDrawable)itemSlot1.getDrawable()).getBitmap();
    	Bitmap bitmap2 = ((BitmapDrawable)itemSlot2.getDrawable()).getBitmap();
    	Bitmap bitmap3 = ((BitmapDrawable)itemSlot3.getDrawable()).getBitmap();
    	Bitmap bitmap4 = ((BitmapDrawable)itemSlot4.getDrawable()).getBitmap();
    	Bitmap bitmap5 = ((BitmapDrawable)itemSlot5.getDrawable()).getBitmap();
    	Bitmap bitmap6 = ((BitmapDrawable)itemSlot6.getDrawable()).getBitmap();
		Bitmap bitmapBlank = ((BitmapDrawable)getResources().getDrawable(R.drawable.i_blankspace)).getBitmap();
		

    	if (bitmap1 == bitmapBlank){
    		itemSlotReferenceHolder = itemSlot1;
    		itemChosen1 = itemChosen;
    	}
    	else if (bitmap2 == bitmapBlank){
    		itemSlotReferenceHolder = itemSlot2;
    		itemChosen2 = itemChosen;
    	}
    	else if (bitmap3 == bitmapBlank){
    		itemSlotReferenceHolder = itemSlot3;
    		itemChosen3 = itemChosen;
    	}
    	else if (bitmap4 == bitmapBlank){
    		itemSlotReferenceHolder = itemSlot4;
    		itemChosen4 = itemChosen;
    	}
    	else if (bitmap5 == bitmapBlank){
    		itemSlotReferenceHolder = itemSlot5;
    		itemChosen5 = itemChosen;
    	}
    	else  if (bitmap6 == bitmapBlank){
    		itemSlotReferenceHolder = itemSlot6;
    		itemChosen6 = itemChosen;
    	}
    	else{
    		itemSlotReferenceHolder = itemSlot6;
    	}

    	if (bitmap6 == bitmapBlank){
	    	switch(itemChosen){
	
	    	case "Abyssal Scepter":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_abyssal_scepter); 
	        	break;
	        	
	    	case "Aegis of the Legion":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_aegis_of_the_legion); 
	        	break;
	        	
	    	case "Aether Wisp":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_aether_wisp); 
	        	break;
	    		
	    	case "Amplifying Tome":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_amplifying_tome); 
	        	break;
	    		
	    	case "Ancient Coin":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_ancient_coin); 
	        	break;
	    		
	    	case "Archangel's Staff":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_archangels_staff); 
	        	break;
	    		
	    	case "Ardent Censer":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_ardent_censer); 
	        	break;
	    		
	    	case "Athene's Unholy Grail":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_athenes_unholy_grail); 
	        	break;
	    		
	    	case "Atma's Impaler":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_atmas_impaler); 
	        	break;
	    		
	    	case "Augment: Death":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_augment_death); 
	        	break;
	    		
	    	case "Augment: Gravity":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_augment_gravity); 
	        	break;
	    		
	    	case "Augment: Power":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_augment_power); 
	        	break;
	    		
	    	case "Avarice Blade":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_avarice_blade); 
	        	break;
	    		
	    	case "Banner of Command":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_banner_of_command); 
	        	break;
	    		
	    	case "Banshee's Veil":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_banshees_veil); 
	        	break;
	    		
	    	case "Berserker's Greaves":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_berserkers_greaves);
	        	break;
	    		
	    	case "Bilgewater Cutlass":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_bilgewater_cutlass);
	        	break;
	    		
	    	case "Blackfire Torch":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_blackfire_torch); 
	        	break;
	    		
	    	case "Blade of the Ruined King":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_blade_of_the_ruined_king); 
	        	break;
	    		
			case "Blasting Wand":
				itemSlotReferenceHolder.setImageResource(R.drawable.i_blasting_wand); 
	        	break;
	    		
	    	case "B.F. Sword":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_b_f_sword); 
	        	break;
	    		
	    	case "Boots of Mobility":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_boots_of_mobility); 
	        	break;
	    		
	    	case "Boots of Speed":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_boots_of_speed); 
	        	break;
	    		
	    	case "Boots of Swifness":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_boots_of_swiftness); 
	        	break;
	    		
	    	case "Brawler's Gloves":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_brawlers_gloves); 
	        	break;
	    		
	    	case "Catalyst the Protector":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_catalyst_the_protector); 
	        	break;
	    		
	    	case "Chain Vest":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_chain_vest); 
	        	break;
	    		
	    	case "Chalice of Harmony":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_chalice_of_harmony); 
	        	break;
	    		
	    	case "Cloak of Agility":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_cloak_of_agility); 
	        	break;
	    		
	    	case "Cloth Armor":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_cloth_armor); 
	        	break;
	    		
	    	case "Dagger":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_dagger); 
	        	break;
	    		
	    	case "Deathfire Grasp":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_deathfire_grasp); 
	        	break;
	    		
	    	case "Dervish Blade":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_dervish_blade); 
	        	break;
	    		
	    	case "Doran's Blade":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_dorans_blade);	
	        	break;
	    		
	    	case "Doran's Ring":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_dorans_ring); 
	        	break;
	    		
	    	case "Doran's Shield":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_dorans_shield); 
	        	break;
	    		
	    	case "Entropy":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_entropy); 
	        	break;
	        	
	    	case "Essence Reaver":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_essence_reaver); 
	        	break;
	    		
	    	case "Executioner's Calling":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_executioners_calling); 
	        	break;
	    		
	    	case "Face of the Mountain":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_face_of_the_mountain); 
	        	break;
	    		
	    	case "Faerie Charm":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_faerie_charm); 
	        	break;
	    		
	    	case "Feral Flare":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_feral_flare); 
	        	break;
	    		
	    	case "Fiendish Codex":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_fiendish_codex); 
	        	break;
	    		
	    	case "Forbidden Idol":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_forbidden_idol); 
	        	break;
	    		
	    	case "Frost Queen's Claim":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_frost_queens_claim); 
	        	break;
	    		
	    	case "Frostfang":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_frostfang); 
	        	break;
	    		
	    	case "Frozen Heart":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_frozen_heart); 
	        	break;
	    		
	    	case "Frozen Mallet":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_frozen_mallet); 
	        	break;
	    		
	    	case "Giant's Belt":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_giants_belt); 
	        	break;
	    		
	    	case "Glacial Shroud":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_glacial_shroud); 
	        	break;
	    		
	    	case "Grez's Spectral Lantern":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_grezs_spectral_lantern); 
	        	break;
	    		
	    	case "Guardian Angel":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_guardian_angel); 
	        	break;
	    		
	    	case "Guardian's Horn":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_guardians_horn); 
	        	break;
	    		
	    	case "Guinsoo's Rageblade":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_guinsoos_rageblade); 
	        	break;
	    		
	    	case "Haunting Guise":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_haunting_guise); 
	        	break;
	    		
	    	case "Hexdrinker":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_hexdrinker); 
	        	break;
	    		
	    	case "Hextech Gunblade":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_hextech_gunblade); 
	        	break;
	    		
	    	case "Hextech Revolver":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_hextech_revolver); 
	        	break;
	    		
	    	case "Hextech Sweeper":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_hextech_sweeper); 
	        	break;
	    		
	    	case "Hunter's Machete":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_hunters_machete); 
	        	break;
	    		
			case "Iceborn Gauntlet":
				itemSlotReferenceHolder.setImageResource(R.drawable.i_iceborn_gauntlet); 
	        	break;
	    		
	    	case "Infinity Edge":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_infinity_edge); 
	        	break;
	    		
	    	case "Ionian Boots of Lucidity":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_ionian_boots_of_lucidity); 
	        	break;
	    		
	    	case "Kindlegem":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_kindlegem); 
	        	break;
	    		
	    	case "Last Whisper":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_last_whisper); 
	        	break;
	    		
	    	case "Liandry's Torment":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_liandrys_torment); 
	        	break;
	    		
	    	case "Lich Bane":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_lich_bane);
	        	break;
	    		
	    	case "Locket of the Iron Solari":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_locket_of_the_iron_solari); 
	        	break;
	    		
	    	case "Long Sword":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_long_sword); 
	        	break;
	    		
	    	case "Lord Van Damm's Pillager":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_lord_van_damms_pillager); 
	        	break;
	    		
	    	case "Madred's Razors":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_madreds_razors); 
	        	break;
	    		
	    	case "Manamune":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_manamune); 
	        	break;
	    		
	    	case "Maw of Malmortius":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_maw_of_malmortius); 
	        	break;
	
	    	case "Mejai's Soulstealer":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_mejais_soulstealer); 
	        	break;
	    		
	    	case "Mercurial Scimitar":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_mercurial_scimitar); 
	        	break;
	    		
	    	case "Mercury's Treads":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_mercurys_treads); 
	        	break;
	    		
	    	case "Mikael's Crucible":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_mikaels_crucible); 
	        	break;
	    		
	    	case "Moonflair Spellblade":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_moonflair_spellblade); 
	        	break;
	    		
	    	case "Morellonomicon":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_morellonomicon); 
	        	break;
	    		   		
	    	case "Muramana":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_muramana); 
	        	break;
	    		
	    	case "Nashor's Tooth":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_nashors_tooth); 
	        	break;
	    		
	    	case "Needlessly Large Rod":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_needlessly_large_rod); 
	        	break;
	    		
	    	case "Negatron Cloak":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_negatron_cloak); 
	        	break;
	    		
	    	case "Ninja Tabi":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_ninja_tabi); 
	        	break;
	    		
	    	case "Nomad's Medallion":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_nomads_medallion); 
	        	break;
	    		
	    	case "Null-Magic Mantle":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_null_magic_mantle); 
	        	break;
	    		
	    	case "Odyn's Veil":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_odyns_veil); 
	        	break;
	    		
	    	case "Ohmwrecker":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_ohmwrecker); 
	        	break;
	    		
	    	case "Orb of Winter":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_orb_of_winter); 
	        	break;
	    		
	    	case "Overlord's Bloodmail":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_overlords_bloodmail); 
	        	break;
	    		
	    	case "Phage":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_phage); 
	        	break;
	    		
	    	case "Phantom Dancer":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_phantom_dancer); 
	        	break;
	
	    	case "Pickaxe":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_pickaxe); 
	        	break;
	    		
	    	case "Prospector's Blade":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_prospectors_blade); 
	        	break;
	    		
	    	case "Prospector's Ring":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_prospectors_ring); 
	        	break;
	    		
	    	case "Quicksilver Sash":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_quicksilver_sash); 
	        	break;
	        	
	    	case "Quill Coat":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_quill_coat); 
	        	break;
	    		
	    	case "Rabadon's Deathcap":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_rabadons_deathcap); 
	        	break;
	    		
	    	case "Randuin's Omen":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_randuins_omen); 
	        	break;
	    		
	    	case "Ravenous Hydra (Melee Only)":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_ravenous_hydra); 
	        	break;
	    		
	    	case "Recurve Bow":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_recurve_bow); 
	        	break;
	    		
	    	case "Rejuvenation Bead":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_rejuvenation_bead); 
	        	break;
	    		
	    	case "Relic Shield":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_relic_shield); 
	        	break;
	    		
	    	case "Rod of Ages":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_rod_of_ages); 
	        	break;
	    		
	    	case "Ruby Crystal":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_ruby_crystal); 
	        	break;
	    		
	    	case "Ruby Sightstone":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_ruby_sightstone); 
	        	break;
	    		
	    	case "Runaan's Hurricane (Ranged Only)":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_runaans_hurricane); 
	        	break;
	    		
			case "Rylai's Crystal Scepter":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_rylais_crystal_scepter); 
	        	break;
	    		
			case "Sanguine Blade":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_sanguine_blade);     		
	        	break;
	    		
	    	case "Sapphire Crystal":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_sapphire_crystal); 
	        	break;
	    		
	    	case "Seeker's Armguard":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_seekers_armguard); 
	        	break;
	    		
	    	case "Seraph's Embrace":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_seraphs_embrace); 
	        	break;
	    		
	    	case "Sheen":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_sheen); 
	        	break;
	    		
	    	case "Sightstone":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_sightstone); 
	        	break;
	    		
	    	case "Sorcerer's Shoes":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_sorcerers_shoes); 
	        	break;
	    		
	    	case "Spectre's Cowl":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_spectres_cowl); 
	        	break;
	    		
	    	case "Spellthief's Edge":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_spellthiefs_edge); 
	        	break;
	    		
	    	case "Spirit Stone":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_spirit_stone); 
	        	break;
	    		
	    	case "Spirit Visage":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_spirit_visage); 
	        	break;
	    		
	    	case "Spirit of the Ancient Golem":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_spirit_of_the_ancient_golem); 
	        	break;
	    		
	    	case "Spirit of the Elder Lizard":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_spirit_of_the_elder_lizard); 
	        	break;
	    		
	    	case "Spirit of the Spectral Wraith":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_spirit_of_the_spectral_wraith); 
	        	break;
	    		
	    	case "Statikk Shiv":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_statikk_shiv); 
	        	break;
	        	
	    	case "Stinger":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_stinger); 
	        	break;
	    		
	    	case "Sunfire Cape":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_sunfire_cape); 
	        	break;
	    		
	    	case "Sword of the Divine":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_sword_of_the_divine);
	        	break;
	    		
	    	case "Sword of the Occult":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_sword_of_the_occult);
	        	break;
	    		
	    	case "Talisman of Ascension":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_talisman_of_ascension); 
	        	break;
	    		
	    	case "Targon's Brace":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_targons_brace); 
	        	break;
	    		
	    	case "Tear of the Goddess":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_tear_of_the_goddess); 
	        	break;
	    		
	    	case "The Black Cleaver":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_the_black_cleaver); 
	        	break;
	    		
	    	case "The Bloodthirster":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_the_bloodthirster); 
	        	break;
	    		
	    	case "The Brutalizer":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_the_brutalizer); 
	        	break;
	    		
	    	case "The Hex Core":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_the_hex_core); 
	        	break;
	    		
	    	case "The Lightbringer":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_the_lightbringer);
	        	break;
	    		
	    	case "Thornmail":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_thornmail); 
	        	break;
	    		
	    	case "Tiamat (Melee Only)":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_tiamat); 
	        	break;
	    		
	    	case "Trinity Force":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_trinity_force); 
	        	break;
	
	    	case "Twin Shadows":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_twin_shadows); 	
	        	break;
	    		
	    	case "Vampiric Scepter":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_vampiric_scepter); 
	        	break;
	    		
	    	case "Void Staff":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_void_staff); 
	        	break;
	    		
	    	case "Warden's Mail":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_wardens_mail); 
	        	break;
	    		
	    	case "Warmog's Armor":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_warmogs_armor); 
	        	break;
	    		
	    	case "Wicked Hatchet":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_wicked_hatchet); 
	        	break;
	    		
	    	case "Will of the Ancients":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_will_of_the_ancients);
	        	break;
	    		
	    	case "Wit's End":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_wits_end); 
	        	break;
	    		
	    	case "Wooglet's Witchcap":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_wooglets_witchcap); 
	        	break;
	    		
	    	case "Wriggle's Lantern":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_wriggles_lantern); 
	        	break;
	    		
	    	case "Youmuu's Ghostblade":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_youmuus_ghostblade);
	        	break;
	    		
	       	case "Zeal":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_zeal);
	        	break;
	    		
	    	case "Zeke's Herald":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_zekes_herald); 
	        	break;
	    		
	    	case "Zephyr":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_zephyr);
	        	break;
	    		
	    	case "Zhonya's Hourglass":
	    		itemSlotReferenceHolder.setImageResource(R.drawable.i_zhonyas_hourglass);     
	        	break;		
	    		
	    	}
    	}
    	else{
    		Toast.makeText(getApplicationContext(), "Already Full Item Set" ,Toast.LENGTH_SHORT).show();
    	}
    }
    
    

	public void save(){
		
		EditText itemSetNameView = (EditText)findViewById(R.id.item_set_name);
		String itemSetName = itemSetNameView.getText().toString();
		
		Intent saveItemSet = new Intent(this, ViewItemSetActivity.class);
		saveItemSet.putExtra("Item Set Name", itemSetName);
		saveItemSet.putExtra("Item 1", itemChosen1);
		saveItemSet.putExtra("Item 2", itemChosen2);
		saveItemSet.putExtra("Item 3", itemChosen3);
		saveItemSet.putExtra("Item 4", itemChosen4);
		saveItemSet.putExtra("Item 5", itemChosen5);
		saveItemSet.putExtra("Item 6", itemChosen6);
		startActivity(saveItemSet);
		
	}
}
