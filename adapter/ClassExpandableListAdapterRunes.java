package com.leagueoflegendscalculator.adapter;


import java.util.HashMap;
import java.util.List;

import com.leagueoflegendscalculator.R;
import com.leagueoflegendscalculator.R.drawable;
import com.leagueoflegendscalculator.R.id;
import com.leagueoflegendscalculator.R.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class ClassExpandableListAdapterRunes extends BaseExpandableListAdapter {
 
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
 

    public ClassExpandableListAdapterRunes(Context context, List<String> listDataHeader,HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }
 
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosititon);
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
            convertView = infalInflater.inflate(R.layout.list_itemexplistview_runes, null);
        }
        
        String runeType = this._listDataHeader.get(groupPosition);//actual string name of header. groupPosition is just an integer >0.
        final String childSubText = RuneStatsAndPicture(childText, runeType, convertView);
        
        //ExpandedlistRuneItem determines the properties of the text in the items on each list.
        TextView txtListChild = (TextView) convertView.findViewById(R.id.ExpandedListRuneName);
        txtListChild.setText(childText);
        

        //subtext here
        TextView subTxtListChild = (TextView) convertView.findViewById(R.id.ExpandedListRuneStat);
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
        TextView ExpandedListRuneHeader = (TextView) convertView.findViewById(R.id.ExpandedListHeader);
        
        //sets the color of the headers for runes page
        switch(groupPosition){
        case 0:
        	ExpandedListRuneHeader.setTextColor(Color.rgb(255, 70, 70));break;
        case 1:
        	ExpandedListRuneHeader.setTextColor(Color.rgb(255, 255, 70));break;
        case 2:
        	ExpandedListRuneHeader.setTextColor(Color.rgb(100, 100, 255));break;
        case 3:
        	ExpandedListRuneHeader.setTextColor(Color.rgb(255, 20, 255));break;
        }
        
        ExpandedListRuneHeader.setTypeface(null, Typeface.BOLD);
        ExpandedListRuneHeader.setText(headerTitle);
 
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
    

    
    public String RuneStatsAndPicture(String childText, String runeType, View convertView){
    	String childSubText = "";
    	//childText is the name of the strings from the Hashmap
    	//ImageView runeImage = (ImageView)findViewById(R.id.RuneImage); can change images here for some reason
        ImageView RuneImage = (ImageView)convertView.findViewById(R.id.rune_image);
    	
    	if (runeType.equals("Tier 3 Marks")){
        	switch(childText){
        	case "Ability Power":
        		childSubText = "+0.59 ability power";
        		RuneImage.setImageResource(R.drawable.r_mark_poison);
        		return childSubText;
        	case "Attack Damage":
        		childSubText = "+0.95 attack damage";
        		RuneImage.setImageResource(R.drawable.r_mark_arrows);
        		return childSubText;
        	case "Attack Speed":
        		childSubText = "+1.7% attack speed";
        		RuneImage.setImageResource(R.drawable.r_mark_poison);
        		return childSubText;
        	case "Armor":
        		childSubText = "+0.91 armor";	
        		RuneImage.setImageResource(R.drawable.r_mark_arrows);
        		return childSubText;
        	case "Armor Penetration":
        		childSubText = "+1.28 armor penetration";
        		RuneImage.setImageResource(R.drawable.r_mark_arrows);
        		return childSubText;	
        	case "Cooldown Reduction":
        		childSubText = "-0.2% cooldowns";
        		RuneImage.setImageResource(R.drawable.r_mark_arrows);
        		return childSubText;
        	case "Critical Chance":
        		childSubText = "+0.93% critical chance";
        		RuneImage.setImageResource(R.drawable.r_mark_poison);
        		return childSubText;
        	case "Critical Damage":
        		childSubText = "+2.23% critical damage";
        		RuneImage.setImageResource(R.drawable.r_mark_arrows);
        		return childSubText;	
        	case "Health":
        		childSubText = "+3.47 health";
        		RuneImage.setImageResource(R.drawable.r_mark_poison);
        		return childSubText;
        	case "Hybrid Penetration":
        		childSubText = "+0.9 Armor Penetration\n" +  "+0.62 Magic Penetration";
        		RuneImage.setImageResource(R.drawable.r_mark_arrows);
        		return childSubText;	
        	case "Magic Penetration":
        		childSubText = "+0.87 magic penetration";
        		RuneImage.setImageResource(R.drawable.r_mark_arrows);
        		return childSubText;
        	case "Magic Resist":
        		childSubText = "+0.77 magic resist";
        		RuneImage.setImageResource(R.drawable.r_mark_poison);
        		return childSubText;
        	case "Mana":
        		childSubText = "+5.91 mana";
        		RuneImage.setImageResource(R.drawable.r_mark_arrows);
        		return childSubText;
        	case "Mana Regeneration":
        		childSubText = "+0.26 mana regen / 5 sec";
        		RuneImage.setImageResource(R.drawable.r_mark_poison);
        		return childSubText;
        	case "Scaling Ability Power":
        		childSubText = "+0.1 ability power per level\n" + "(+1.8 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_mark_mace); 
        		return childSubText;
        	case "Scaling Attack Damage":
        		childSubText = "+0.13 attack damage per level\n" + "(+2.43 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_mark_spear); 
        		return childSubText;
        	case "Scaling Health":
        		childSubText = "+0.54 health per level\n" + "(+9.72 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_mark_mace); 
        		return childSubText;
        	case "Scaling Magic Resist":
        		childSubText = "+0.07 magic resist per level\n" + "(+1.26 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_mark_mace); 
        		return childSubText;
        	case "Scaling Mana":
        		childSubText = "+1.17 mana per level\n" + "(+21.06 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_mark_spear); 
        		return childSubText;
        	default:
        		return childSubText;
        	}
    	}
    	
    	else if (runeType.equals("Tier 3 Seals")){
        	switch(childText){
        	case "Ability Power":
        		childSubText = "+0.59 ability power";
        		RuneImage.setImageResource(R.drawable.r_seal_wing);
        		return childSubText;
        	case "Armor":
        		childSubText = "+1 armor";
        		RuneImage.setImageResource(R.drawable.r_seal_goblet);
        		return childSubText;
        	case "Attack Damage":
        		childSubText = "+0.43 attack damage";
        		RuneImage.setImageResource(R.drawable.r_seal_goblet);
        		return childSubText;
        	case "Attack Speed":
        		childSubText = "+0.76% attack speed";
        		RuneImage.setImageResource(R.drawable.r_seal_wing);
        		return childSubText;
        	case "Cooldown Reduction":
        		childSubText = "-0.36% cooldowns";
        		RuneImage.setImageResource(R.drawable.r_seal_goblet);
        		return childSubText;
        	case "Critical Chance":
        		childSubText = "+0.42% critical chance";
        		RuneImage.setImageResource(R.drawable.r_seal_wing);
        		return childSubText;
        	case "Critical Damage":
        		childSubText = "+0.78% critical damage";
        		RuneImage.setImageResource(R.drawable.r_seal_goblet);
        		return childSubText;
        	case "Energy Regeneration":
        		childSubText = "+0.63 Energy regen/5 sec";
        		RuneImage.setImageResource(R.drawable.r_seal_goblet);
        		return childSubText;
        	case "Gold":
        		childSubText = "+0.25 gold / 10 sec.";
        		RuneImage.setImageResource(R.drawable.r_seal_wing);
        		return childSubText;
        	case "Health":
        		childSubText = "+8 health";
        		RuneImage.setImageResource(R.drawable.r_seal_wing);
        		return childSubText;
        	case "Health Regeneration":
        		childSubText = "+0.56 health regen / 5 sec";
        		RuneImage.setImageResource(R.drawable.r_seal_goblet);
        		return childSubText;
        	case "Magic Resist":
        		childSubText = "+0.74 magic resist";
        		RuneImage.setImageResource(R.drawable.r_seal_wing);
        		return childSubText;
        	case "Mana":
        		childSubText = "+6.89 mana";
        		RuneImage.setImageResource(R.drawable.r_seal_goblet);
        		return childSubText;
        	case "Mana Regeneration":
        		childSubText = "+0.41 mana regen / 5 sec";
        		RuneImage.setImageResource(R.drawable.r_seal_wing);
        		return childSubText;
        	case "Percent Health":
        		childSubText = "+0.5% Health";
        		RuneImage.setImageResource(R.drawable.r_seal_wing); 
        		return childSubText;
        	case "Scaling Ability Power":
        		childSubText = "+0.1 ability power per level\n" + "(+1.8 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_seal_shield);
        		return childSubText;
        	case "Scaling Armor":
        		childSubText = "+0.16 armor per level\n" + "(+3 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_seal_shield);
        		return childSubText;
        	case "Scaling Attack Damage":
        		childSubText = "+0.06 attack damage per level\n" + "(+1.09 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_seal_shield);
        		return childSubText;
        	case "Scaling Energy Regeneration":
        		childSubText = "+0.064 Energy regen/5 sec per level\n" + "(+1.15 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_seal_wing);
        		return childSubText;
        	case "Scaling Health":
        		childSubText = "+1.33 health per level\n" + "(+24 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_seal_shield);
        		return childSubText;
        	case "Scaling Health Regeneration":
        		childSubText = "+0.11 health regen / 5 sec. per level\n" + "(+1.98 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_seal_shield);
        		return childSubText;
        	case "Scaling Magic Resist":
        		childSubText = "+0.1 magic resist per level\n" + "(+1.8 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_seal_shield);
        		return childSubText;
        	case "Scaling Mana":
        		childSubText = "+1.17 mana per level\n" + "(+21.06 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_seal_shield);
        		return childSubText;
        	case "Scaling Mana Reneration":
        		childSubText = "+0.065 mana regen / 5 sec. per level\n" + "(+1.17 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_seal_shield);
        		return childSubText;
        	default:
        		return childSubText;
        	}
    	}
    		
    	else if (runeType.equals("Tier 3 Glyphs")){
        	switch(childText){
        	case "Ability Power":
        		childSubText = "+1.19 ability power";
        		RuneImage.setImageResource(R.drawable.r_glyph_shell);
        		return childSubText;
        	case "Armor":
        		childSubText = "+0.7 armor";
        		RuneImage.setImageResource(R.drawable.r_glyph_candle);
        		return childSubText;
        	case "Attack Damage":
        		childSubText = "+0.28 attack damage";
        		RuneImage.setImageResource(R.drawable.r_glyph_candle);
        		return childSubText;
        	case "Attack Speed":
        		childSubText = "+0.64% attack speed";
        		RuneImage.setImageResource(R.drawable.r_glyph_shell);
        		return childSubText;
        	case "Cooldown Reduction":
        		childSubText = "-0.83% cooldowns";
        		RuneImage.setImageResource(R.drawable.r_glyph_candle);
        		return childSubText;
        	case "Critical Damage":
        		childSubText = "+0.56% critical damage";
        		RuneImage.setImageResource(R.drawable.r_glyph_candle);
        		return childSubText;
        	case "Critical Chance":
        		childSubText = "+0.28% critical chance";
        		RuneImage.setImageResource(R.drawable.r_glyph_shell);
        		return childSubText;
        	case "Energy":
        		childSubText = "+2.2 Energy";
        		RuneImage.setImageResource(R.drawable.r_glyph_shell);
        		return childSubText;
        	case "Health":
        		childSubText = "+2.67 health";
        		RuneImage.setImageResource(R.drawable.r_glyph_shell);
        		return childSubText;
        	case "Health Regeneration":
        		childSubText = "+0.27 health regen / 5 sec.";
        		RuneImage.setImageResource(R.drawable.r_glyph_candle);
        		return childSubText;
        	case "Magic Penetration":
        		childSubText = "+0.63 magic penetration";
        		RuneImage.setImageResource(R.drawable.r_glyph_candle);
        		return childSubText;
        	case "Magic Resist":
        		childSubText = "+1.34 magic resist";
        		RuneImage.setImageResource(R.drawable.r_glyph_shell);
        		return childSubText;
        	case "Mana":
        		childSubText = "+11.25 mana";
        		RuneImage.setImageResource(R.drawable.r_glyph_candle);
        		return childSubText;
        	case "Mana Regeneration":
        		childSubText = "+0.33 mana regen / 5 sec.";
        		RuneImage.setImageResource(R.drawable.r_glyph_shell);
        		return childSubText;
        	case "Scaling Ability Power":
        		childSubText = "+0.17 ability power per level\n" + "(+3.06 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_glyph_key);
        		return childSubText;
        	case "Scaling Attack Damage":
        		childSubText = "+0.04 attack damage per level\n" + "(+0.73 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_glyph_hand);
        		return childSubText;
        	case "Scaling Cooldown Reduction":
        		childSubText = "-0.09% cooldowns per level\n" + "(-1.67% at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_glyph_hand);
        		return childSubText;
        	case "Scaling Energy":
        		childSubText = "+0.161 Energy/level\n" + "(+2.89 at level 18)";
        		RuneImage.setImageResource(R.drawable.r_glyph_hand);
        		return childSubText;
        	case "Scaling Health":
        		childSubText = "+0.54 health per level\n" + "(+9.72 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_glyph_key);
        		return childSubText;
        	case "Scaling Magic Resist":
        		childSubText = "+0.16 magic resist per level\n" + "(+3 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_glyph_key);
        		return childSubText;
        	case "Scaling Mana":
        		childSubText = "+1.42 mana per level\n" + "(+25.56 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_glyph_hand);
        		return childSubText;
        	case "Scaling Mana Reneration":
        		childSubText = "+0.06 mana regen / 5 sec. per level\n" + "(+1.2 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_glyph_key);
        		return childSubText;
        	default:
        		return childSubText;
        	}
    	}
    		
    	else if (runeType.equals("Tier 3 Quintessence")){
        	switch(childText){
        	case "Ability Power":
        		childSubText = "+4.95 ability power";
        		RuneImage.setImageResource(R.drawable.r_quintessence_ram);
        		return childSubText;
        	case "Armor":
        		childSubText = "+4.26 armor";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Armor Penetration":
        		childSubText = "+2.56 armor penetration";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Attack Damage":
        		childSubText = "+2.25 attack damage";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Attack Speed":
        		childSubText = "+4.5% attack speed";
        		RuneImage.setImageResource(R.drawable.r_quintessence_ram);
        		return childSubText;
        	case "Cooldown Reduction":
        		childSubText = "-2.5% cooldowns";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Critical Chance":
        		childSubText = "+1.86% critical chance";
        		RuneImage.setImageResource(R.drawable.r_quintessence_ram);
        		return childSubText;
        	case "Critical Damage":
        		childSubText = "+4.46% critical damage";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Energy":
        		childSubText = "+5.4 Energy";
        		RuneImage.setImageResource(R.drawable.r_quintessence_ram);
        		return childSubText;
        	case "Energy Regeneration":
        		childSubText = "+1.575 Energy regen/5 sec";
        		RuneImage.setImageResource(R.drawable.r_quintessence_lion);
        		return childSubText;
        	case "Experience":
        		childSubText = "+2% experience gained";
        		RuneImage.setImageResource(R.drawable.r_quintessence_lion);
        		return childSubText;
        	case "Gold":
        		childSubText = "+1 gold / 10 sec";
        		RuneImage.setImageResource(R.drawable.r_quintessence_tree);    
        		return childSubText;
        	case "Health":
        		childSubText = "+26 health";
        		RuneImage.setImageResource(R.drawable.r_quintessence_ram);
        		return childSubText;
        	case "Health Regeneration":
        		childSubText = "+2.7 health regen / 5 sec";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Hybrid Penetration":
        		childSubText = "+1.79 Armor Penetration\n" + "+1.4 Magic Penetration";
        		RuneImage.setImageResource(R.drawable.r_quintessence_tree);        		
        		return childSubText;
        	case "Life Steal":
        		childSubText = "+1.5% Life Steal";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Magic Penetration":
        		childSubText = "+2.01 magic penetration";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Magic Resist":
        		childSubText = "+4 magic resist";
        		RuneImage.setImageResource(R.drawable.r_quintessence_ram);
        		return childSubText;
        	case "Mana":
        		childSubText = "+37.5 mana";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Mana Regeneration":
        		childSubText = "+1.25 mana regen / 5 sec";
        		RuneImage.setImageResource(R.drawable.r_quintessence_ram);
        		return childSubText;
        	case "Movement Speed":
        		childSubText = "+1.5% movement speed";
        		RuneImage.setImageResource(R.drawable.r_quintessence_ram);
        		return childSubText;
        	case "Percent Health":
        		childSubText = "+1.5% increased health";
        		RuneImage.setImageResource(R.drawable.r_quintessence_ram);
        		return childSubText;
        	case "Revival":
        		childSubText = "-5% time dead";
        		RuneImage.setImageResource(R.drawable.r_quintessence_dragon);
        		return childSubText;
        	case "Scaling Ability Power":
        		childSubText = "+0.43 ability power per level\n" + "(+7.74 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_quintessence_tree);    
        		return childSubText;
        	case "Scaling Armor":
        		childSubText = "+0.38 armor per level\n" + "(+6.84 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_quintessence_lion);
        		return childSubText;
        	case "Scaling Attack Damage":
        		childSubText = "+0.25 attack damage per level\n" + "(+4.5 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_quintessence_lion);
        		return childSubText;
        	case "Scaling Cooldown Reduction":
        		childSubText = "-0.28% cooldowns per level\n" + "(-5% at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_quintessence_lion);
        		return childSubText;
        	case "Scaling Health":
        		childSubText = "+2.7 health per level\n" + "(+48.6 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_quintessence_tree);    
        		return childSubText;
        	case "Scaling Health Regeneration":
        		childSubText = "+0.28 health regen / 5 sec. per level\n" + "(+5.04 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_quintessence_lion);
        		return childSubText;
        	case "Scaling Magic Resist":
        		childSubText = "+0.37 magic resist per level\n" + "(+6.66 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_quintessence_tree);    
        		return childSubText;
        	case "Scaling Mana":
        		childSubText = "+4.17 mana per level\n" + "(+75.06 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_quintessence_lion);
        		return childSubText;
        	case "Scaling Mana Reneration":
        		childSubText = "+0.24 mana regen / 5 sec. per level\n" + "(+4.32 at champion level 18)";
        		RuneImage.setImageResource(R.drawable.r_quintessence_tree);    
        		return childSubText;
        	case "Spell Vamp":
        		childSubText = "+2% Spellvamp";
        		RuneImage.setImageResource(R.drawable.r_quintessence_tree);    
        		return childSubText;
        	default:
        		return childSubText;
        	}
    	}
    	else{
    		return childSubText;
    	}
    }
    
    
    
    
    
    
}