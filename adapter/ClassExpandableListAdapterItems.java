package com.leagueoflegendscalculator.adapter;


import java.util.HashMap;
import java.util.List;

import com.leagueoflegendscalculator.R;
import com.leagueoflegendscalculator.R.drawable;
import com.leagueoflegendscalculator.R.id;
import com.leagueoflegendscalculator.R.layout;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassExpandableListAdapterItems extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
 

    public ClassExpandableListAdapterItems(Context context, List<String> listDataHeader,HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }
 
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosition);
    }
 
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
 
    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
 
        final String childText = (String) getChild(groupPosition, childPosition);
        
        //The rune stats are created by taking the name of the child/rune name from String childText and entering it into the
        //method RuneStatsAndPicture which returns the string value of the stats as well set the ImageView via switch-case.
        

 
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //list_itemexplistview is the xml file that contains the TextView below (ExpandedListRuneItem)
            convertView = infalInflater.inflate(R.layout.list_itemexplistview_items, null);
        }
        
        //String itemType = this._listDataHeader.get(groupPosition);//actual string name of header. groupPosition is just an integer.
        //final String childSubText = ItemStatsAndPicture(childText, itemType, convertView);
        final String childSubText = ItemStatsAndPicture(childText, convertView);
        
        //ExpandedlistRuneItem determines the properties of the text in the items on each list.
        TextView txtListChild = (TextView) convertView.findViewById(R.id.ExpandedListItemName);
        txtListChild.setText(childText);
        

        //subtext here
        TextView subTxtListChild = (TextView) convertView.findViewById(R.id.ExpandedListItemStat);
        subTxtListChild.setText(childSubText);
        
        return convertView;
    }
 
    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }
 
    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }
 
    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }
 
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
 
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //list_groupexplistview is the xml file that contains the TextView for the headers (ExpandedListRuneHeader)
            convertView = infalInflater.inflate(R.layout.list_groupexplistview, null);
        }
 
        //ExpandedListRuneHeader is the TextView inside list_groupexplistview used for the header for each list
        TextView ExpandedListItemHeader = (TextView) convertView.findViewById(R.id.ExpandedListHeader);
        
        //sets the color of the headers for runes page
        ExpandedListItemHeader.setTypeface(null, Typeface.BOLD);
        ExpandedListItemHeader.setText(headerTitle);
 
        return convertView;
    }
 
    @Override
    public boolean hasStableIds() {
        return false;
    }
 
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    

	//I used to have a variable here called itemType that would break up the items into separate categories based on what (header) group they are in
    //It's more difficult to update these after a patch if they appear more than once so I changed it to one large switch-case
    //REMEMBER TO UPDATE THE REFERENCES IN THE CREATEITEMSETACTIVITY AS WELL AS HERE
    public String ItemStatsAndPicture(String childText, View convertView){

    	String childSubText = "";
    	//childText is the name of the strings from the Hashmap
    	//ImageView runeImage = (ImageView)findViewById(R.id.RuneImage); can change images here for some reason
        ImageView itemImage = (ImageView)convertView.findViewById(R.id.item_image);
    	
        //Notice that the names of the cells in an ExpandableListView are determined by children from the Hashmap created in CreateItemSetActivity. 
        //There is no confusion in trying to extract that cell by name since every other view inside of that cell is given their value here.
        //ExpandedListItemName contains the name of the cell. In a regular ListView, all the elements defined in separate lists seem to be defined and used
        //equally throughout the custom converter ClassCustomChampList, but the names of the cells are given by super(context, R.layout.list_single, arrayOfChampions);
    	
        switch(childText){
    	case "B.F. Sword":
    		childSubText = "+50 Attack Damage";
    		itemImage.setImageResource(R.drawable.i_b_f_sword); 
    		return childSubText;
    	case "Bilgewater Cutlass":
    		childSubText = "+25 Attack Damage\n" + "+8% Life Steal\n" + "UNIQUE Active: Deals 100 magic damage and slows the target champion's Movement Speed by 25% for 2 seconds (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_bilgewater_cutlass); 
    		return childSubText;
    	case "Blade of the Ruined King":
    		childSubText = "+25 Attack Damage\n" + "+40% Attack Speed\n" + "+10% Life Steal\n" + "UNIQUE Passive: Basic attacks deal 8% of the target's current Health in bonus physical damage (max 60 vs. monsters and minions) on hit.\n" + "UNIQUE Active: Deals 10% of target champion's maximum Health (min. 100) as physical damage, heals for the same amount, and steals 25% of the target's Movement Speed for 3 seconds (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_blade_of_the_ruined_king); 
    		return childSubText;
    	case "Doran's Blade":
    		childSubText = "+70 Health\n" + "+7 Attack Damage\n" + "+3% Lifesteal";
    		itemImage.setImageResource(R.drawable.i_dorans_blade); 
    		return childSubText;
    	case "Entropy":
    		childSubText = "+275 Health\n" + "+55 Attack Damage\n" + "UNIQUE Passive - Rage: Basic attacks grant 20 Movement Speed for 2 seconds on hit. Kills grant 60 Movement Speed for 2 seconds. This Movement Speed bonus is halved for ranged champions.\n" + "UNIQUE Active: For the next 5 seconds, basic attacks reduce the target's Movement Speed by 30% and deal 80 true damage over 2.5 seconds on hit (60 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_entropy); 
    		return childSubText;
    	case "Essence Reaver":
    		childSubText = "+80 Attack Damage\n" + "+10% Lifesteal\n" + "+10% Cooldown Reduction\n" + "UNIQUE PASSIVE You gain 2-8% of the damage dealt by basic attacks as mana. This effect increases based on how much mana you are missing";
    		itemImage.setImageResource(R.drawable.i_essence_reaver); 
    		return childSubText;
    	case "Executioner's Calling":
    		childSubText = "+25 Attack Damage\n" + "+20% Critical Strike Chance\n" + "UNIQUE Passive: Basic attacks inflict Grievous Wounds on enemy champions for 1.5 seconds on hit.";
    		itemImage.setImageResource(R.drawable.i_executioners_calling); 
    		return childSubText;
    	case "Feral Flare":
    		childSubText = "+12 Attack Damage\n" + "+30% Attack Speed\n" + "UNIQUE Passive - Maim: Basic attacks deal (25 + Feral stacks) bonus magic damage (300% against minions and monsters) and heal 10 Health on hit. Kills, assists and large monster kills grant a Feral stack.\n" + "UNIQUE Passive: Gain 30% increased Gold from monsters.\n" + "UNIQUE Active: Places a Stealth Ward that reveals the surrounding area for 180 seconds (180 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_feral_flare); 
    		return childSubText;
    	case "Frozen Mallet":
    		childSubText = "+700 Health\n" + "+30 Attack Damage\n" + "UNIQUE Passive - Icy: Basic attacks slow the target's Movement Speed for 1.5 seconds on hit (40% slow for melee attacks, 30% slow for ranged attacks).";
    		itemImage.setImageResource(R.drawable.i_frozen_mallet); 
    		return childSubText;
    	case "Grez's Spectral Lantern":
    		childSubText = "+15 Attack Damage\n" + "+20 Armor\n" + "+12% Life Steal\n" + "UNIQUE Passive: Basic attacks against minions and monsters have a 20% chance to deal 200 bonus magic damage on hit.\n" + "UNIQUE Active: A stealth-detecting mist grants vision in the target area for 5 seconds, revealing enemy champions that enter for 3 seconds (60 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_grezs_spectral_lantern); 
    		return childSubText;
    	case "Guinsoo's Rageblade":
    		childSubText = "+30 Attack Damage\n" + "+40 Ability Power\n" + "Passive: Basic attacks (on attack) and spell casts grant +4% Attack Speed and +4 Ability Power for 8 seconds (stacks up to 8 times).";
    		itemImage.setImageResource(R.drawable.i_guinsoos_rageblade); 
    		return childSubText;		
    	case "Hexdrinker":
    		childSubText = "+25 Attack Damage\n" + "+25 Magic Resist\n" + "UNIQUE Passive - Lifeline: Upon taking magic damage that would reduce Health below 30%, grants a shield that absorbs 250 magic damage for 5 seconds (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_hexdrinker); 
    		return childSubText;
    	case "Hextech Gunblade":
    		childSubText = "+45 Attack Damage +65\n" + "Ability Power\n" + "+12% Life Steal\n" + "UNIQUE Passive: +20% Spell Vamp\n" + "UNIQUE Passive: Basic attacks (on hit) and single-target spells against champions reduce the cooldown of this item by 3 seconds.\n" + "UNIQUE Active: Deals 150 (+40% of Ability Power) magic damage and slows the target champion's Movement Speed by 40% for 2 seconds (60 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_hextech_gunblade); 
    		return childSubText;
    	case "Infinity Edge":
    		childSubText = "+80 Attack Damage\n" + "+25% Critical Strike Chance\n" + "UNIQUE Passive: Critical strikes deal 250% damage instead of 200%.";
    		itemImage.setImageResource(R.drawable.i_infinity_edge); 
    		return childSubText;
    	case "Last Whisper":
    		childSubText = "+40 Attack Damage\n" + "UNIQUE Passive: Physical damage ignores 35% of the target's Armor (applies before Armor Penetration).";
    		itemImage.setImageResource(R.drawable.i_last_whisper); 
    		return childSubText;	
    	case "Long Sword":
    		childSubText = "+10 Attack Damage";
    		itemImage.setImageResource(R.drawable.i_long_sword); 
    		return childSubText;
    	case "Lord Van Damm's Pillager":
    		childSubText = "+70 Attack Damage\n" + "+25% Critical Strike Chance\n" + "UNIQUE Passive: Critical strikes deal 250% damage instead of 200%.";
    		itemImage.setImageResource(R.drawable.i_lord_van_damms_pillager); 
    		return childSubText;
    	case "Manamune":
    		childSubText = "+250 Mana\n" + "+25 Attack Damage\n" + "+7 Mana Regen per 5 seconds\n" + "UNIQUE Passive - Awe: Grants bonus Attack Damage equal to 2% of maximum Mana.\n" + "UNIQUE Passive - Mana Charge: Grants +4 maximum Mana (max +750 Mana) for each basic attack, spell cast, and Mana expenditure (occurs up to 2 times every 8 seconds). Transforms into Muramana at +750 Mana.";
    		itemImage.setImageResource(R.drawable.i_manamune); 
    		return childSubText;
    	case "Maw of Malmortius":
    		childSubText = "+60 Attack Damage\n" + "+40 Magic Resist\n" + "UNIQUE Passive: Grants +1 Attack Damage for every 2% of missing Health, up to a maximum of 35 Attack Damage.\n" + "UNIQUE Passive - Lifeline: Upon taking magic damage that would reduce Health below 30%, grants a shield that absorbs 400 magic damage for 5 seconds (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_maw_of_malmortius); 
    		return childSubText;		
    	case "Mercurial Scimitar":
    		childSubText = "+80 Attack Damage\n" + "+45 Magic Resist\n" + "UNIQUE Active - Quicksilver: Removes all debuffs and also grants +50% bonus Movement Speed for 1 second (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_mercurial_scimitar); 
    		return childSubText;
    	case "Muramana":
    		childSubText = "+1000 Mana\n" + "+20 Attack Damage\n" + "+7 Mana Regen per 5 seconds\n" + "UNIQUE Passive - Awe: Grants bonus Attack Damage equal to 2% of maximum Mana.\n" + "UNIQUE Toggle: Single target spells and attacks (on hit) consume 3% of current Mana to deal bonus physical damage equal to twice the amount of Mana consumed.";
    		itemImage.setImageResource(R.drawable.i_muramana); 
    		return childSubText;
    	case "Phage":
    		childSubText = "+200 Health\n" + "+20 Attack Damage\n" + "UNIQUE Passive - Rage: Basic attacks grant 20 Movement Speed for 2 seconds. Kills grant 60 Movement Speed instead. This Movement Speed bonus is halved for ranged champions.";
    		itemImage.setImageResource(R.drawable.i_phage); 
    		return childSubText;
    	case "Pickaxe":
    		childSubText = "+25 Attack Damage";
    		itemImage.setImageResource(R.drawable.i_pickaxe); 
    		return childSubText;
    	case "Prospector's Blade":
    		childSubText = "+16 Attack Damage\n" + "+15% Attack Speed\n" + "UNIQUE Passive - Prospector: +150 Health";
    		itemImage.setImageResource(R.drawable.i_prospectors_blade); 
    		return childSubText;
    	case "Ravenous Hydra (Melee Only)":
    		childSubText = "+75 Attack Damage\n" + "+15 Health Regen per 5 seconds\n" + "+12% Life Steal Passive: Life Steal applies to damage dealt by this item.\n" + "UNIQUE Passive - Cleave: Basic attacks deal 20% to 60% of total Attack Damage as bonus physical damage to enemies near the target on hit (enemies closest to the target take the most damage).\n" + "UNIQUE Active - Crescent: Deals 60% to 100% of total Attack Damage as physical damage to nearby enemy units (closest enemies take the most damage) (10 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_ravenous_hydra); 
    		return childSubText;
    	case "Sanguine Blade":
    		childSubText = "+45 Attack Damage\n" + "+10% Life Steal\n" + "UNIQUE Passive: Basic attacks grant +6 Attack Damage and +1% Life Steal for 8 seconds on hit (effect stacks up to 5 times).";
    		itemImage.setImageResource(R.drawable.i_sanguine_blade); 
    		return childSubText;
    	case "Spirit of the Elder Lizard":
    		childSubText = "+30 Attack Damage\n" + "+10% Cooldown Reduction\n" + "UNIQUE Passive - Incinerate: Deals 16-50 (based on level) true damage over 3 seconds on dealing physical damage.\n" + "UNIQUE Passive - Butcher: Against monsters, deal 20% bonus damage and restore 6% of damage dealt as Health and 3% as Mana.\n" + "UNIQUE Passive - Conservation: Upon killing a large or epic monster, grants up to 40 bonus Gold, based on the last time Conservation triggered (Max 80 stacks of Conservation).";
    		itemImage.setImageResource(R.drawable.i_spirit_of_the_elder_lizard); 
    		return childSubText;
    	case "Sword of the Occult":
    		childSubText = "+10 Attack Damage\n" + "UNIQUE Passive: Grants +5 Attack Damage per stack. Grants 2 stacks for a kill or 1 stack for an assist (max 20 stacks). A third of the stacks are lost upon death. At 20 stacks, grants +15% bonus Movement Speed.";
    		itemImage.setImageResource(R.drawable.i_sword_of_the_occult); 
    		return childSubText;
    	case "The Black Cleaver":
    		childSubText = "+200 Health\n" + "+50 Attack Damage\n" + "+10% Cooldown Reduction\n" + "UNIQUE Passive: +10 Armor Penetration Passive: Dealing physical damage to an enemy champion reduces their Armor by 5% for 4 seconds (stacks up to 5 times, up to 25%).";
    		itemImage.setImageResource(R.drawable.i_the_black_cleaver); 
    		return childSubText;
    	case "The Bloodthirster":
    		childSubText = "+80 Attack Damage \n" + "UNIQUE Passive: +20% Lifesteal\n" + "UNIQUE Passive: Your lifesteal can now overheal you. Excess life is stored as a shield that can block 50-350 damage, based on champion level.\n" + "This shield decays slowly if you haven't dealt or taken damage in the last 25 seconds.";
    		itemImage.setImageResource(R.drawable.i_the_bloodthirster); 
    		return childSubText;
    	case "The Brutalizer":
    		childSubText = "+25 Attack Damage \n" + "UNIQUE Passive: +10% Cooldown Reduction \n" + "UNIQUE Passive: +10 Armor Penetration";
    		itemImage.setImageResource(R.drawable.i_the_brutalizer); 
    		return childSubText;
    	case "The Lightbringer":
    		childSubText = "+30 Attack Damage\n" + "+30% Critical Strike Chance\n" + "UNIQUE Passive: Critical Strikes cause your target to bleed for an additional 90% of your bonus Attack Damage as physical damage over 3 seconds and reveal them for the duration.\n" + "UNIQUE Passive - Trap Detection: Nearby stealthed enemy traps are revealed.\n" + "UNIQUE Active: A stealth-detecting mist grants vision in the target area for 5 seconds, revealing enemy champions that enter for 3 seconds (60 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_the_lightbringer); 
    		return childSubText;
    	case "Tiamat (Melee Only)":
    		childSubText = "+40 Attack Damage\n" + "+15 Health Regen per 5 seconds\n" + "UNIQUE Passive - Cleave: Basic attacks deal 20% to 60% of total Attack Damage as bonus physical damage to enemies near the target on hit (enemies closest to the target take the most damage).\n" + "UNIQUE Active - Crescent: Deals 60% to 100% of total Attack Damage as physical damage to nearby enemy units (closest enemies take the most damage) (10 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_tiamat); 
    		return childSubText;
    	case "Trinity Force":
    		childSubText = "+30 Attack Damage\n" + "+30 Ability Power\n" + "+30% Attack Speed\n" + "+10% Critical Strike Chance\n" + "+8% Movement Speed\n" + "+250 Health\n" + "+200 Mana\n" + "UNIQUE Passive - Rage: Basic attacks grant 20 Movement Speed for 2 seconds. Kills grant 60 Movement Speed instead. This Movement Speed bonus is halved for ranged champions.\n" + "UNIQUE Passive - Spellblade: After using an ability, the next basic attack deals bonus physical damage equal to 200% of base Attack Damage on hit (2 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_trinity_force); 
    		return childSubText;
    	case "Vampiric Scepter":
    		childSubText = "+10 Attack Damage\n" + "+8% Life Steal";
    		itemImage.setImageResource(R.drawable.i_vampiric_scepter); 
    		return childSubText;
    	case "Wicked Hatchet":
    		childSubText = "+20 Attack Damage\n" + "+10% Critical Strike Chance\n" + "UNIQUE Passive: Critical Strikes cause your target to bleed for an additional 60% of your bonus Attack Damage as physical damage over 3 seconds.";
    		itemImage.setImageResource(R.drawable.i_wicked_hatchet); 
    		return childSubText;
    	case "Wriggle's Lantern":
    		childSubText = "+12 Attack Damage\n" + "+30% Attack Speed\n" + "UNIQUE Passive - Maim: Basic attacks against monsters deal 75 bonus magic damage and heal 10 Health on hit.\n" + "UNIQUE Passive: Gain 30% increased Gold from monsters.\n" + "UNIQUE Active: Places a Stealth Ward that reveals the surrounding area for 180 seconds (180 second cooldown). Transforms into Feral Flare at 30 kills, assists and large monster kills.";
    		itemImage.setImageResource(R.drawable.i_wriggles_lantern); 
    		return childSubText;
    	case "Youmuu's Ghostblade":
    		childSubText = "+30 Attack Damage\n" + "+15% Critical Strike Chance\n" + "+10% Cooldown Reduction\n" + "UNIQUE Passive: +20 Armor Penetration\n" + "UNIQUE Active: Grants +20% Movement Speed and +40% Attack Speed for 6 seconds (45 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_youmuus_ghostblade); 
    		return childSubText;
    	case "Zephyr":
    		childSubText = "+25 Attack Damage\n" + "+50% Attack Speed\n" + "+10% Movement Speed\n" + "+10% Cooldown Reduction\n" + "UNIQUE Passive - Tenacity: Reduces the duration of stuns, slows, taunts, fears, silences, blinds, polymorphs, and immobilizes by 35%.";
    		itemImage.setImageResource(R.drawable.i_zephyr); 
    		return childSubText;

    	case "Atma's Impaler":
    		childSubText = "+45 Armor +\n" + "15% Critical Strike Chance\n" + "UNIQUE Passive: Grants bonus Attack Damage equal to 1.5% of maximum Health.";
    		itemImage.setImageResource(R.drawable.i_atmas_impaler);
    		return childSubText;
    	case "Avarice Blade":
    		childSubText = "+10% Critical Strike Chance \n" + "UNIQUE Passive - Avarice: +3 Gold per 10 seconds \n" + "UNIQUE Passive - Greed: Grants 2 Gold upon killing a unit. May be bought with another Gold Income item";
    		itemImage.setImageResource(R.drawable.i_avarice_blade);
    		return childSubText;
    	case "Brawler's Gloves":
    		childSubText = "+8% Critical Strike Chance";
    		itemImage.setImageResource(R.drawable.i_brawlers_gloves); 
    		return childSubText;
    	case "Cloak of Agility":
    		childSubText = "+15% Critical Strike Chance";
    		itemImage.setImageResource(R.drawable.i_cloak_of_agility); 
    		return childSubText;

    	case "Phantom Dancer":
    		childSubText = "+50% Attack Speed \n" + "+30% Critical Strike Chance \n" + "+5% Movement Speed \n" + "UNIQUE Passive: Champion can move through units.";
    		itemImage.setImageResource(R.drawable.i_phantom_dancer); 
    		return childSubText;
    	case "Statikk Shiv":
    		childSubText = "+40% Attack Speed \n" + "+20% Critical Strike Chance \n" + "+6% Movement Speed \n" + "UNIQUE Passive: Grants Static Charges upon moving or attacking. At 100 Charges, basic attacking expends all Charges to deal 100 bonus magic damage to up to 4 targets on hit (this damage can critically strike).";
    		itemImage.setImageResource(R.drawable.i_statikk_shiv); 
    		return childSubText;
    	case "Sword of the Divine":
    		childSubText = "+45% Attack Speed \n" + "Passive: This item does not grant any Attack Speed while on cooldown. Champion kills reduce the current cooldown by 50%. \n" + "UNIQUE Active: Grants +100% Attack Speed and 100% Critical Strike Chance for 3 seconds or 3 critical strikes (60 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_sword_of_the_divine); 
    		return childSubText;

    	case "Zeal":
    		childSubText = "+20% Attack Speed\n" + "+10% Critical Strike Chance\n" + "+5% Movement Speed";
    		itemImage.setImageResource(R.drawable.i_zeal); 
    		return childSubText;

    	case "Berserker's Greaves":
    		childSubText = "+25% Attack Speed\n" + "UNIQUE Passive - Enhanced Movement: +45 Movement Speed";
    		itemImage.setImageResource(R.drawable.i_berserkers_greaves);
    		return childSubText;

    	case "Dagger":
    		childSubText = "+15% Attack Speed";
    		itemImage.setImageResource(R.drawable.i_dagger); 
    		return childSubText;
    	case "Dervish Blade":
    		childSubText = "+50% Attack Speed\n" + "+45 Magic Resist\n" + "+10% Cooldown Reduction\n" + "UNIQUE Active - Quicksilver: Removes all debuffs, and if champion is melee, also grants +50% bonus Movement Speed for 1 second (90 second cooldown).";
        		itemImage.setImageResource(R.drawable.i_dervish_blade); 
        		return childSubText;
 
        	case "Madred's Razors":
    		childSubText = "+15% Attack Speed\n" + "UNIQUE Passive - Maim: Basic attacks against monsters deal 50 bonus magic damage and heal 8 Health on hit.";
    		itemImage.setImageResource(R.drawable.i_madreds_razors); 
    		return childSubText;
    	case "Nashor's Tooth":
    		childSubText = "+50% Attack Speed\n" + "+60 Ability Power\n" + "UNIQUE Passive: +20% Cooldown Reduction\n" + "UNIQUE Passive: Basic attacks deal 15 (+15% of Ability Power) bonus magic damage on hit.";
    		itemImage.setImageResource(R.drawable.i_nashors_tooth); 
    		return childSubText;

    	case "Recurve Bow":
    		childSubText = "+30% Attack Speed";
    		itemImage.setImageResource(R.drawable.i_recurve_bow); 
    		return childSubText;
    	case "Runaan's Hurricane (Ranged Only)":
    		childSubText = "+70% Attack Speed\n" + "UNIQUE Passive: When basic attacking, bolts are fired at up to 2 enemies near the target, each dealing 10 (+50% of Attack Damage) physical damage. These bolts apply on-hit effects.";
    		itemImage.setImageResource(R.drawable.i_runaans_hurricane); 
    		return childSubText;

    	case "Stinger":
    		childSubText = "+40% Attack Speed\n" + "UNIQUE Passive: +10% Cooldown Reduction";
    		itemImage.setImageResource(R.drawable.i_stinger); 
    		return childSubText;

    	case "Wit's End":
    		childSubText = "+50% Attack Speed\n" + "+25 Magic Resist\n" + "UNIQUE Passive: Basic attacks deal 42 bonus magic damage on hit. UNIQUE Passive: Basic attacks steal 5 Magic Resist from the target on hit (stacks up to 5 times.)";
    		itemImage.setImageResource(R.drawable.i_wits_end); 
    		return childSubText;
 
    	case "Zeke's Herald":
    		childSubText = "+250 Health\n" + "+20% Cooldown Reduction\n" + "UNIQUE Aura: Grants allied champions +10% Life Steal and +20 Attack Damage.";
    		itemImage.setImageResource(R.drawable.i_zekes_herald); 
    		return childSubText;

    	case "Abyssal Scepter":
    		childSubText = "+70 Ability Power\n" + "+45 Magic Resist\n" + "UNIQUE Aura: Reduces the Magic Resist of nearby enemies by 20.";
    		itemImage.setImageResource(R.drawable.i_abyssal_scepter); 
    		return childSubText;
    	case "Aether Wisp":
    		childSubText = "+30 Ability Power\n" + "UNIQUE Passive: +5% Movement Speed";
    		itemImage.setImageResource(R.drawable.i_aether_wisp); 
    		return childSubText;
    	case "Amplifying Tome":
    		childSubText = "+20 Ability Power";
    		itemImage.setImageResource(R.drawable.i_amplifying_tome); 
    		return childSubText;
    	case "Archangel's Staff":
    		childSubText = "+250 Mana\n" + "+60 Ability Power\n" + "+10 Mana Regen per 5 seconds\n" + "UNIQUE Passive - Insight: Grants Ability Power equal to 3% of maximum Mana.\n" + "UNIQUE Passive - Mana Charge: Grants +8 maximum Mana (max +750 Mana) for each spell cast and Mana expenditure (occurs up to 2 times every 8 seconds). Transforms into Seraph's Embrace at +750 Mana.";
    		itemImage.setImageResource(R.drawable.i_archangels_staff); 
    		return childSubText;
    	case "Ardent Censer":
    		childSubText = "+40 Ability Power\n" + "+10 Mana Regen per 5 seconds\n" + "+10% Cooldown Reduction" + "UNIQUE Passive: +8% Movement Speed\n" + "UNIQUE Passive: Your heals and shields on another unit grant them 25% Attack Speed for 6 seconds. (This does not include regeneration effects or effects on yourself.)";
    		itemImage.setImageResource(R.drawable.i_ardent_censer); 
    		return childSubText;
    	case "Athene's Unholy Grail":
    		childSubText = "+60 Ability Power \n" + "+25 Magic Resist \n" + "+10 Mana Regen per 5 seconds \n" + "+20% Cooldown Reduction \n" + "UNIQUE Passive: Restores 15% of maximum Mana on kill or assist. \n" + "UNIQUE Passive - Mana Font: Increases Mana Regen by 1% for every 1% of missing Mana.";
    		itemImage.setImageResource(R.drawable.i_athenes_unholy_grail); 
    		return childSubText;
    	case "Augment: Death":
    		childSubText = "+3 Ability Power per level\n" + "+45 Ability Power\n" + "Ability Augment: Death Ray sets fire to enemies, dealing 30% additional magic damage over 4 seconds.";
    		itemImage.setImageResource(R.drawable.i_augment_death); 
    		return childSubText;
    	case "Banner of Command":
    		childSubText = "+80 Ability Power\n" + "+20% Cooldown Reduction\n" + "UNIQUE Aura - Valor: Nearby allied minions deal 15% increased damage.\n" + "UNIQUE Active - Promote: Transforms a nearby siege minion into a more powerful unit and grants all gold that the unit earns (180 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_banner_of_command); 
    		return childSubText;
    	case "Blackfire Torch":
    		childSubText = "+80 Ability Power\n" + "+10% Cooldown Reduction\n" + "UNIQUE Active: Deals 20% of target champion's maximum Health in magic damage over 4 seconds and increases all subsequent magic damage taken by the target by 20% (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_blackfire_torch); 
    		return childSubText;        	
		case "Blasting Wand":
    		childSubText = "+40 Ability Power";
    		itemImage.setImageResource(R.drawable.i_blasting_wand); 
    		return childSubText;
    	case "Deathfire Grasp":
    		childSubText = "+120 Ability Power\n" + "+10% Cooldown Reduction\n" + "UNIQUE Active: Deals 15% of target champion's maximum Health in magic damage and increases all subsequent magic damage taken by the target by 20% for 4 seconds (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_deathfire_grasp); 
    		return childSubText;
    	case "Doran's Ring":
    		childSubText = "+60 Health\n" + "+15 Ability Power\n" + "+3 Mana Regen per 5 seconds \n" + "Passive: Restores 4 Mana upon killing a unit.";
    		itemImage.setImageResource(R.drawable.i_dorans_ring); 
    		return childSubText;
    	case "Fiendish Codex":
    		childSubText = "+30 Ability Power \n" + "UNIQUE Passive: +10% Cooldown Reduction";
    		itemImage.setImageResource(R.drawable.i_fiendish_codex); 
    		return childSubText;
    	case "Frost Queen's Claim":
    		childSubText = "+50 Ability Power \n" + "+10 Mana Regen per 5 seconds \n" + "+10% Cooldown Reduction \n" + "+2 Gold per 10 seconds \n" + "UNIQUE Passive - Tribute: Spells and basic attacks against champions or buildings deal 15 additional damage and grant 10 Gold. This can occur up to three times every 30 seconds. \n" + "UNIQUE Active: Fires an ice lance that explodes dealing 50 (+5 per champion level) magic damage to nearby enemies and slowing their Movement Speed by 80%, decaying over 2 seconds. (60 second cooldown.)";
    		itemImage.setImageResource(R.drawable.i_frost_queens_claim); 
    		return childSubText;
    	case "Frostfang":
    		childSubText = "+10 Ability Power \n" + "+5 Mana Regen per 5 seconds \n" + "+2 Gold per 10 seconds \n" + "UNIQUE Passive - Tribute: Spells and basic attacks against champions or buildings deal 15 additional damage and grant 10 Gold. This can occur up to three times every 30 seconds. Killing a minion disables this passive for 12 seconds.";
    		itemImage.setImageResource(R.drawable.i_frostfang); 
    		return childSubText;

    	case "Haunting Guise":
    		childSubText = "+25 Ability Power \n" + "+200 Health \n" + "UNIQUE Passive - Eyes of Pain: +15 Magic Penetration";
    		itemImage.setImageResource(R.drawable.i_haunting_guise); 
    		return childSubText;

    	case "Hextech Revolver":
    		childSubText = "+40 Ability Power \n" + "UNIQUE Passive: +12% Spell Vamp";
    		itemImage.setImageResource(R.drawable.i_hextech_revolver); 
    		return childSubText;        	
		case "Iceborn Gauntlet":
    		childSubText = "+500 Mana \n" + "+60 Armor \n" + "+30 Ability Power \n" + "+10% Cooldown Reduction \n" + "UNIQUE Passive - Spellblade: After using an ability, the next basic attack (on hit) deals bonus physical damage equal to 125% of base Attack Damage to enemies near the target, and creates a field around the target for 2 seconds that slows enemy Movement Speed by 30% (2 second cooldown, half-sized field if ranged).";
    		itemImage.setImageResource(R.drawable.i_iceborn_gauntlet); 
    		return childSubText;
    	case "Liandry's Torment":
    		childSubText = "+50 Ability Power \n" + "+300 Health \n" + "UNIQUE Passive - Eyes of Pain: +15 Magic Penetration \n" + "UNIQUE Passive: Dealing spell damage applies a damage-over-time effect for 3 seconds that deals bonus magic damage equal to 2% of the target's current Health per second. This bonus damage is doubled against movement-impaired units and capped at 100 damage per second vs. monsters.";
    		itemImage.setImageResource(R.drawable.i_liandrys_torment); 
    		return childSubText;
    	case "Lich Bane":
    		childSubText = "+80 Ability Power \n" + "+250 Mana \n" + "+5% Movement Speed \n" + "UNIQUE Passive - Spellblade: After using an ability, the next basic attack deals 75% Base Attack Damage (+50% of Ability Power) bonus magic damage on hit (2 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_lich_bane); 
    		return childSubText;
    	case "Mejai's Soulstealer":
    		childSubText = "+20 Ability Power \n" + "UNIQUE Passive: Grants +8 Ability Power per stack. Grants 2 stacks for a kill or 1 stack for an assist (max 20 stacks). A third of the stacks are lost upon death. At 20 stacks, grants +15% Cooldown Reduction.";
    		itemImage.setImageResource(R.drawable.i_mejais_soulstealer); 
    		return childSubText;
    	case "Moonflair Spellblade":
    		childSubText = "+50 Ability Power \n" + "+50 Armor \n" + "+50 Magic Resist \n" + "UNIQUE Passive - Tenacity: Reduces the duration of stuns, slows, taunts, fears, silences, blinds, polymorphs, and immobilizes by 35%.";
    		itemImage.setImageResource(R.drawable.i_moonflair_spellblade); 
    		return childSubText;     		
    	case "Morellonomicon":
    		childSubText = "+80 Ability Power \n" + "+10 Mana Regen per 5 seconds \n" + "+20% Cooldown Reduction \n" + "UNIQUE Passive: Dealing magic damage to enemy champions below 40% Health inflicts Grievous Wounds for 4 seconds.";
    		itemImage.setImageResource(R.drawable.i_morellonomicon); 
    		return childSubText;        	

    	case "Needlessly Large Rod":
    		childSubText = "+80 Ability Power";
    		itemImage.setImageResource(R.drawable.i_needlessly_large_rod); 
    		return childSubText;
    	case "Ohmwrecker":
    		childSubText = "+350 Health\n" + "+50 Ability Power\n" + "UNIQUE Active: Prevents nearby enemy turrets from attacking for 2.5 seconds (120 second cooldown). This effect cannot be used against the same turret more than once every 7.5 seconds.";
    		itemImage.setImageResource(R.drawable.i_ohmwrecker); 
    		return childSubText;
    	case "Prospector's Ring":
    		childSubText = "+35 Ability Power\n" + "+6 Mana Regeneration\n" + "UNIQUE Passive - Prospector: +150 Health";
    		itemImage.setImageResource(R.drawable.i_prospectors_ring); 
    		return childSubText;
    	case "Rabadon's Deathcap":
    		childSubText = "+120 Ability Power\n" + "UNIQUE Passive: Increases Ability Power by 30%.";
    		itemImage.setImageResource(R.drawable.i_rabadons_deathcap); 
    		return childSubText; 
    	case "Rod of Ages":
    		childSubText = "+450 Health\n" + "+450 Mana\n" + "+60 Ability Power\n" + "Passive: Grants +20 Health, +20 Mana, and +2 Ability Power per stack (max +200 Health, +200 Mana, and +20 Ability Power). Grants 1 stack per minute (max 10 stacks).\n" + "UNIQUE Passive - Valor's Reward: Upon leveling up, restores 150 Health and 200 Mana over 8 seconds.";
    		itemImage.setImageResource(R.drawable.i_rod_of_ages); 
    		return childSubText;        	
		case "Rylai's Crystal Scepter":
    		childSubText = "+400 Health\n" + "+100 Ability Power\n" + "UNIQUE Passive: Dealing spell damage slows the target's Movement Speed by 35% for 1.5 seconds (15% for multi-target and damage-over-time spells).";
    		itemImage.setImageResource(R.drawable.i_rylais_crystal_scepter); 
    		return childSubText;
    	case "Seeker's Armguard":
    		childSubText = "+30 Armor\n" + "+20 Ability Power\n" + "UNIQUE Passive: Killing a unit grants 0.5 bonus Armor and Ability Power. This bonus stacks up to 30 times.";
    		itemImage.setImageResource(R.drawable.i_seekers_armguard); 
    		return childSubText;
    	case "Seraph's Embrace":
    		childSubText = "+1000 Mana\n" + "+60 Ability Power\n" + "+10 Mana Regen per 5 seconds\n" + "UNIQUE Passive - Insight: Grants Ability Power equal to 3% of maximum Mana.\n" + "UNIQUE Active - Mana Shield: Consumes 20% of current Mana to grant a shield for 3 seconds that absorbs damage equal to 150 plus the amount of Mana consumed (120 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_seraphs_embrace); 
    		return childSubText;
    	case "Sheen":
    		childSubText = "+200 Mana\n" + "+25 Ability Power\n" + "UNIQUE Passive - Spellblade: After using an ability, the next basic attack deals bonus physical damage equal to base Attack Damage on hit (2 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_sheen); 
    		return childSubText;
    	case "Spellthief's Edge":
    		childSubText = "+5 Ability Power\n" + "+2 Mana Regen per 5 seconds\n" + "+2 Gold per 10 seconds\n" + "UNIQUE Passive - Tribute: Spells and basic attacks against champions or buildings deal 10 additional damage and grant 5 Gold. This can occur up to three times every 30 seconds. Killing a minion disables this passive for 12 seconds.";
    		itemImage.setImageResource(R.drawable.i_spellthiefs_edge); 
    		return childSubText; 
    	case "Spirit of the Spectral Wraith":
    		childSubText = "+50 Ability Power\n" + "+10% Cooldown Reduction\n" + "UNIQUE Passive - Spirit Drain: Grants 2 Ability Power per large or epic monster kill. (max: 30)\n" + "UNIQUE Passive - Butcher: Against monsters, deal 30% bonus damage and restore 6% of damage dealt as Health and 3% as Mana.\n" + "UNIQUE Passive - Conservation: Upon killing a large or epic monster, grants up to 40 bonus Gold, based on the last time Conservation triggered (Max 80 stacks of Conservation).";
    		itemImage.setImageResource(R.drawable.i_spirit_of_the_spectral_wraith); 
    		return childSubText;

    	case "Twin Shadows":
    		childSubText = "+80 Ability Power\n" + "+10% Cooldown Reduction\n" + "+6% Movement Speed\n" + "UNIQUE Active - Hunt: Summons up to 2 invulnerable ghosts that seek out the two nearest enemy champions for 6 seconds. If a ghost reaches its target, it reveals the target and reduces their Movement Speed by 40% for 2.5 seconds. If a ghost cannot find a target, it tries to return to the caster. Ghosts that successfully return in this way reduce the item's cooldown by 40 seconds (120 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_twin_shadows); 
    		return childSubText; 
    	case "Void Staff":
    		childSubText = "+70 Ability Power\n" + "UNIQUE Passive: Magic damage ignores 35% of the target's Magic Resist (applies before Magic Penetration).";
    		itemImage.setImageResource(R.drawable.i_void_staff); 
    		return childSubText;
    	case "Will of the Ancients":
    		childSubText = "+80 Ability Power\n" + "+10% Cooldown Reduction\n" + "UNIQUE Passive: +20% Spell Vamp";
    		itemImage.setImageResource(R.drawable.i_will_of_the_ancients); 
    		return childSubText;
    	case "Wooglet's Witchcap":
    		childSubText = "+100 Ability Power\n" + "+45 Armor\n" + "UNIQUE Passive: Increases Ability Power by 25%\n" + "UNIQUE Active: Champion becomes invulnerable and untargetable for 2.5 seconds, but is unable to move, attack, cast spells, or use items during this time (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_wooglets_witchcap); 
    		return childSubText; 
    	case "Zhonya's Hourglass":
    		childSubText = "+120 Ability Power\n" + "+50 Armor\n" + "UNIQUE Active - Stasis: Champion becomes invulnerable and untargetable for 2.5 seconds, but is unable to move, attack, cast spells, or use items during this time (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_zhonyas_hourglass); 
    		return childSubText;


    	case "Augment: Gravity":
    		childSubText = "+3 Ability Power per level\n" + "+200 Mana\n" + "+10% Cooldown Reduction\n" + "+5 Mana Regen per 5 seconds\n" + "Ability Augment: Gravity Field has an additional 30% cast range.";
    		itemImage.setImageResource(R.drawable.i_augment_gravity); 
    		return childSubText; 

    	case "Face of the Mountain":
    		childSubText = "+500 Health\n" + "+20 Health Regen per 5 seconds\n" + "+10% Cooldown Reduction\n" + "UNIQUE Passive - Spoils of War: Melee basic attacks execute minions below 200 Health. Killing a minion heals you and the nearest allied champion for 50 (+1% of your maximum Health) and grants them kill Gold. These effects require a nearby allied champion. Recharges every 30 seconds. Max 4 charges.\n" + "UNIQUE Active: Shield target ally for 10% of your maximum Health for 4 seconds. After 4 seconds, the target explodes dealing 100% of their total Attack Damage plus 30% of their Ability Power as magic damage in an area. (60 second cooldown)";
    		itemImage.setImageResource(R.drawable.i_face_of_the_mountain); 
    		return childSubText;

    	case "Forbidden Idol":
    		childSubText = "+8 Mana Regen per 5 seconds\n" + "UNIQUE Passive: +10% Cooldown Reduction";
    		itemImage.setImageResource(R.drawable.i_forbidden_idol); 
    		return childSubText;

    	case "Frozen Heart":
    		childSubText = "+100 Armor\n" + "+400 Mana\n" + "+20% Cooldown Reduction\n" + "UNIQUE Aura: Reduces the Attack Speed of nearby enemies by 15%.";
    		itemImage.setImageResource(R.drawable.i_frozen_heart); 
    		return childSubText;
    	case "Glacial Shroud":
    		childSubText = "+250 Mana\n" + "+20 Armor\n" + "UNIQUE Passive: +10% Cooldown Reduction";
    		itemImage.setImageResource(R.drawable.i_glacial_shroud); 
    		return childSubText;
    	case "Hextech Sweeper":
    		childSubText = "+225 Health\n" + "+250 Mana\n" + "+25 Armor\n" + "+20% Cooldown Reduction\n" + "UNIQUE Passive: - Trap Detection Nearby stealthed enemy traps are revealed.\n" + "UNIQUE Active: A stealth-detecting mist grants vision in the target area for 5 seconds, revealing enemy champions that enter for 3 seconds (60 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_hextech_sweeper); 
    		return childSubText;

    	case "Ionian Boots of Lucidity":
    		childSubText = "UNIQUE Passive: +15% Cooldown Reduction\n" + "UNIQUE Passive - Enhanced Movement: +45 Movement Speed";
    		itemImage.setImageResource(R.drawable.i_ionian_boots_of_lucidity); 
    		return childSubText; 
    	case "Kindlegem":
    		childSubText = "+200 Health\n" + "UNIQUE Passive: +10% Cooldown Reduction";
    		itemImage.setImageResource(R.drawable.i_kindlegem); 
    		return childSubText;
    	case "Locket of the Iron Solari":
    		childSubText = "+400 Health\n" + "+20 Magic Resistance\n" + "+10% Cooldown Reduction\n" + "UNIQUE Active: Grants a shield to nearby allies for 5 seconds that absorbs up to 50 (+10 per level) damage (60 second cooldown).\n" + "UNIQUE Aura - Legion: Grants nearby allies +20 Magic Resist and +10 Health Regen per 5 seconds. (Unique Auras with the same name don't stack.)";
    		itemImage.setImageResource(R.drawable.i_locket_of_the_iron_solari); 
    		return childSubText;
    	case "Mikael's Crucible":
        	childSubText = "+40 Magic Resist\n" + "+20 Mana Regen per 5 seconds\n" + "+10% Cooldon Reduction\n" + "UNIQUE Passive - Mana Font: Increases Mana Regen by 1% for every 1% of missing Mana.\n" + "UNIQUE Active: Removes all stuns, roots, taunts, fears, silences, and slows on an allied champion and heals that champion for 150 (+10% of maximum Health) (180 second cooldown).";
        	itemImage.setImageResource(R.drawable.i_mikaels_crucible); 
        	return childSubText;

    	case "Spirit Visage":
    		childSubText = "+400 Health\n" + "+55 Magic Resist\n" + "+20 Health Regen per 5 seconds\n" + "+10% Cooldown Reduction\n" + "UNIQUE Passive: Increases self-healing, Health Regen, Lifesteal, and Spell Vamp effects by 20%.";
    		itemImage.setImageResource(R.drawable.i_spirit_visage); 
    		return childSubText; 
    	case "Spirit of the Ancient Golem":
    		childSubText = "+200 Health\n" + "+10% Cooldown Reduction\n" + "+20 Armor\n" + "25% Bonus Health\n" + "Passive: Sapping Barbs: Attacking monsters lose 5% of their maximum Health over 3 seconds (up to 195). Wearer gains +60 health regeneration per 5 seconds and +45 mana regeneration per 5 seconds when in combat with monsters.\n" + "Active: Hunter's Ward: Places a Stealth Ward that reveals the surrounding area for 180 seconds (180 second cooldown)";
    		itemImage.setImageResource(R.drawable.i_spirit_of_the_ancient_golem); 
    		return childSubText; 

    	case "Talisman of Ascension":
    		childSubText = "+10% Cooldown Reduction\n" + "+15 Mana Regen per 5 seconds\n" + "+15 Health Regen per 5 seconds\n" + "+20 Movement Speed \n" + "+2 Gold per 10 seconds\n" + "UNIQUE Passive - Favor: Being near a minion death without dealing the killing blow grants 3 Gold and 10 Health.\n" + "UNIQUE Active: Grants nearby allies +40% Movement Speed for 3 seconds (60 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_talisman_of_ascension); 
    		return childSubText; 


    	case "Ancient Coin":
    		childSubText = "+3 Mana Regen per 5 seconds\n" + "UNIQUE Passive - Favor: Being near a minion death without dealing the killing blow grants 2 Gold and 5 Health.";
    		itemImage.setImageResource(R.drawable.i_ancient_coin); 
    		return childSubText; 

    	case "Catalyst the Protector":
    		childSubText = "+200 Health\n" + "+300 Mana\n" + "UNIQUE Passive - Valor's Reward: Upon leveling up, restores 150 Health and 200 Mana over 8 seconds.";
    		itemImage.setImageResource(R.drawable.i_catalyst_the_protector); 
    		return childSubText; 
    	case "Chalice of Harmony":
    		childSubText = "+20 Magic Resist\n" + "+7 Mana Regen per 5 seconds\n" + "UNIQUE Passive - Mana Font: Increases Mana Regen by 1% per 1% of missing Mana.";
    		itemImage.setImageResource(R.drawable.i_chalice_of_harmony); 
    		return childSubText;

    	case "Faerie Charm":
    		childSubText = "+3 Mana Regen per 5 seconds";
    		itemImage.setImageResource(R.drawable.i_faerie_charm); 
    		return childSubText;

    	case "Nomad's Medallion":
    		childSubText = "+5 Mana Regen per 5 seconds \n" + "+5 Health Regen per 5 seconds \n" + "+2 Gold per 10 seconds \n" + "+10 Movement Speed \n" + "UNIQUE Passive - Favor: Being near a minion death without dealing the killing blow grants 3 Gold and 5 Health.";
    		itemImage.setImageResource(R.drawable.i_nomads_medallion); 
    		return childSubText;

    	case "Odyn's Veil":
    		childSubText = "+350 Health \n" + "+350 Mana \n" + "+50 Magic Resist \n" + "UNIQUE Passive: Reduces and stores 10% of magic damage received. \n" + "UNIQUE Active: Deals 200 + (stored magic) (max 400) magic damage to nearby enemy units (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_odyns_veil); 
    		return childSubText; 

    	case "Sapphire Crystal":
    		childSubText = "+200 Mana";
    		itemImage.setImageResource(R.drawable.i_sapphire_crystal); 
    		return childSubText; 

    	case "Tear of the Goddess":
    		childSubText = "+250 Mana\n" + "+6 Mana Regen per 5 seconds\n" + "UNIQUE Passive - Mana Charge: +4 maximum Mana on spell cast or Mana expenditure (up to twice per 8 seconds); +1 maximum Mana per 8 seconds; Max +750 Mana.";
    		itemImage.setImageResource(R.drawable.i_tear_of_the_goddess); 
    		return childSubText;


    	
    	case "Aegis of the Legion":
    		childSubText = "+200 Health\n" + "+20 Magic Resistance\n" + "UNIQUE Aura - Legion: Grants nearby allies +20 Magic Resist and +10 Health Regen per 5 seconds.";
    		itemImage.setImageResource(R.drawable.i_aegis_of_the_legion); 
    		return childSubText; 
    	case "Augment: Power":
    		childSubText = "+3 Ability Power per level\n" + "+220 Health\n" + "+6 Health Regen per 5 seconds\n" + "Ability Augment: Power Transfer increases Viktor's Movement Speed by 30% for 3 seconds.";
    		itemImage.setImageResource(R.drawable.i_augment_power); 
    		return childSubText; 
    	case "Banshee's Veil":
    		childSubText = "+450 Health\n" + "+55 Magic Resist\n" + "UNIQUE Passive: Grants a spell shield that blocks the next enemy ability. This shield refreshes after no damage is taken from enemy champions for 40 seconds.\n" + "UNIQUE Passive: Grants 45 Health Regen per 5 for up to 10 seconds after taking damage from an enemy champion or when the spell shield breaks.";
    		itemImage.setImageResource(R.drawable.i_banshees_veil); 
    		return childSubText;

    	case "Doran's Shield":
    		childSubText = "+80 Health\n" + "+6 Health Regen per 5 seconds\n" + "UNIQUE Passive: Blocks 8 damage from champion basic attacks.";
    		itemImage.setImageResource(R.drawable.i_dorans_shield); 
    		return childSubText;

    	case "Giant's Belt":
    		childSubText = "+380 Health";
    		itemImage.setImageResource(R.drawable.i_giants_belt); 
    		return childSubText;
    	case "Guardian's Horn":
    		childSubText = "+180 Health\n" + "+12 Health Regen per 5 seconds\n" + "UNIQUE Passive: Enemy spellcasts reduce the cooldown of Battle Cry by 1 second.\n" + "UNIQUE Active - Battle Cry: Gain 30% movement speed, 20 Armor, and 20 Magic Resistance for 3 seconds. 25 second cooldown.";
    		itemImage.setImageResource(R.drawable.i_guardians_horn); 
    		return childSubText;

    	case "Orb of Winter":
    		childSubText = "+70 Magic Resist\n" + "+20 Health Regen per 5 seconds\n" + "UNIQUE Passive: Grants a shield that absorbs up to 30 (+10 per level) damage. The shield will refresh after 9 seconds without receiving damage.";
    		itemImage.setImageResource(R.drawable.i_orb_of_winter); 
    		return childSubText; 
    	case "Overlord's Bloodmail":
    		childSubText = "+850 Health\n" + "UNIQUE Passive: Upon champion kill or assist, restores 200 Health over 5 seconds.";
    		itemImage.setImageResource(R.drawable.i_overlords_bloodmail); 
    		return childSubText;

    	case "Randuin's Omen":
    		childSubText = "+500 Health\n" + "+70 Armor\n" + "UNIQUE Passive - Cold Steel: When hit by basic attacks, reduces the attacker's Attack Speed by 15% for 1 seconds.\n" + "UNIQUE Active: Slows the Movement Speed of nearby enemy units by 35% for 2 seconds (+1 second per 200 Armor and +1 second per 200 Magic Resist) (60 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_randuins_omen); 
    		return childSubText;

    	case "Rejuvenation Bead":
    		childSubText = "+5 Health Regen per 5 seconds";
    		itemImage.setImageResource(R.drawable.i_rejuvenation_bead); 
    		return childSubText; 
    	case "Relic Shield":
    		childSubText = "+75 Health\n" + "UNIQUE Passive - Spoils of War: Melee basic attacks execute minions below 200 Health. Killing a minion heals you and the nearest allied champion for 40 Health and grants them kill Gold. These effects require a nearby allied champion. Recharges every 60 seconds. Max 2 charges. ";
    		itemImage.setImageResource(R.drawable.i_relic_shield); 
    		return childSubText;

    	case "Ruby Crystal":
    		childSubText = "+150 Health";
    		itemImage.setImageResource(R.drawable.i_ruby_crystal); 
    		return childSubText; 
    	case "Ruby Sightstone":
    		childSubText = "+400 Health\n" + "UNIQUE Passive - Ward Refresh: Holds 5 charges and refills upon visiting the shop.\n" + "UNIQUE Active - Ghost Ward: Consumes a charge to place a Stealth Ward that reveals the surrounding area for 3 minutes. A player may only have 3 Stealth Wards on the map at one time.";
        		itemImage.setImageResource(R.drawable.i_ruby_sightstone); 
        		return childSubText; 
 
        	case "Sightstone":
    		childSubText = "+150 Health\n" + "UNIQUE Passive - Ward Refresh: Holds 4 charges and refills upon visiting the shop.\n" + "UNIQUE Active - Ghost Ward: Consumes a charge to place a Stealth Ward that reveals the surrounding area for 3 minutes. A player may only have 3 Stealth Wards on the map at one time.";
    		itemImage.setImageResource(R.drawable.i_sightstone); 
    		return childSubText;
    	case "Spectre's Cowl":
    		childSubText = "+200 Health\n" + "+45 Magic Resist\n" + "UNIQUE Passive: Grants 15 Health Regen per 5 seconds for up to 10 seconds after taking damage from an enemy champion.";
    		itemImage.setImageResource(R.drawable.i_spectres_cowl); 
    		return childSubText; 

    	case "Sunfire Cape":
    		childSubText = "+450 Health\n" + "+45 Armor\n" + "UNIQUE Passive: Deals 25 (+ character level) magic damage per second to nearby enemies.";
    		itemImage.setImageResource(R.drawable.i_sunfire_cape); 
    		return childSubText;

    	case "Targon's Brace":
    		childSubText = "+175 Health \n" + "+8 Health Regen per 5 seconds \n" + "UNIQUE Passive - Spoils of War: Melee basic attacks execute minions below 200 Health. Killing a minion heals you and the nearest allied champion for 50 Health and grants them kill Gold. These effects require a nearby allied champion. Recharges every 30 seconds. Max 3 charges.";
    		itemImage.setImageResource(R.drawable.i_targons_brace); 
    		return childSubText;

    	case "Warmog's Armor":
    		childSubText = "+1000 Health \n" + "UNIQUE Passive: Restores 1% of maximum Health every 5 seconds.";
    		itemImage.setImageResource(R.drawable.i_warmogs_armor); 
    		return childSubText; 
    	case "Guardian Angel":
    		childSubText = "+50 Armor \n" + "+40 Magic Resist \n" + "UNIQUE Passive: Upon taking lethal damage, restores 30% of maximum Health and Mana after 4 seconds of stasis (300 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_guardian_angel); 
    		return childSubText;  
    	case "Mercury's Treads":
    		childSubText = "+25 Magic Resist \n" + "UNIQUE Passive - Enhanced Movement: +45 Movement Speed UNIQUE \n" + "Passive - Tenacity: Reduces the duration of stuns, slows, taunts, fears, silences, blinds, polymorphs, and immobilizes by 35%.";
    		itemImage.setImageResource(R.drawable.i_mercurys_treads); 
    		return childSubText;  
    	case "Negatron Cloak":
    		childSubText = "+40 Magic Resist";
    		itemImage.setImageResource(R.drawable.i_negatron_cloak); 
    		return childSubText; 
    	case "Null-Magic Mantle":
    		childSubText = "+20 Magic Resist";
    		itemImage.setImageResource(R.drawable.i_null_magic_mantle); 
    		return childSubText;  
    	case "Quicksilver Sash":
    		childSubText = "+45 Magic Resist \n" + "UNIQUE Active - Quicksilver: Removes all debuffs (90 second cooldown).";
    		itemImage.setImageResource(R.drawable.i_quicksilver_sash); 
    		return childSubText;  
    	case "Chain Vest":
    		childSubText = "+40 Armor";
    		itemImage.setImageResource(R.drawable.i_chain_vest); 
    		return childSubText; 
    	case "Cloth Armor":
    		childSubText = "+15 Armor";
        	itemImage.setImageResource(R.drawable.i_cloth_armor); 
        	return childSubText; 
        case "Ninja Tabi":
    		childSubText = "+25 Armor \n" + "UNIQUE Passive: Blocks 10% of the damage from basic attacks. \n" + "UNIQUE Passive - Enhanced Movement: +45 Movement Speed";
    		itemImage.setImageResource(R.drawable.i_ninja_tabi); 
    		return childSubText;  
    	case "Quill Coat":
    		childSubText = "+10 Armor\n" + "Passive: Sapping Barbs: Attacking monsters lose 5% of their maximum health over 3 seconds (up to 150). Wearer gains +40 health regeneration per 5 seconds and +30 mana regeneration per 5 seconds when in combat with monsters.\n" + "Active: Hunter's Ward: Places a Stealth Ward that reveals the surrounding area for 180 seconds (180 second cooldown)";
    		itemImage.setImageResource(R.drawable.i_quill_coat); 
    		return childSubText;        		
    	case "Thornmail":
    		childSubText = "+100 Armor \n" + "UNIQUE Passive: Upon being hit by a basic attack, returns 30% of the incoming damage (before being reduced by defenses) to the attacker as magic damage.";
    		itemImage.setImageResource(R.drawable.i_thornmail); 
    		return childSubText; 
    	case "Warden's Mail":
    		childSubText = "+50 Armor \n" + "UNIQUE Passive - Cold Steel: When hit by basic attacks, reduces the attacker's Attack Speed by 15% for 1 seconds.";
    		itemImage.setImageResource(R.drawable.i_wardens_mail); 
    		return childSubText;  
    	case "Boots of Mobility":
    		childSubText = "UNIQUE Passive - Enhanced Movement: +25 Movement Speed. Increases to +105 Movement Speed when out of combat for 5 seconds.";
    		itemImage.setImageResource(R.drawable.i_boots_of_mobility); 
    		return childSubText;  
    	case "Boots of Speed":
    		childSubText = "UNIQUE Passive - Enhanced Movement: +25 Movement Speed";
    		itemImage.setImageResource(R.drawable.i_boots_of_speed); 
    		return childSubText;  
    	case "Boots of Swiftness":
    		childSubText = "UNIQUE Passive - Enhanced Movement: +60 Movement Speed UNIQUE Passive - Slow Resist: Movement slowing effects are reduced by 25%.";
    		itemImage.setImageResource(R.drawable.i_boots_of_swiftness); 
    		return childSubText;  
    	case "Sorcerer's Shoes":
    		childSubText = "+15 Magic Penetration \n" + "UNIQUE Passive - Enhanced Movement: +45 Movement Speed";
        	itemImage.setImageResource(R.drawable.i_sorcerers_shoes); 
        	return childSubText;  
        	
        default:
        	return childSubText;
        }
    }
}

