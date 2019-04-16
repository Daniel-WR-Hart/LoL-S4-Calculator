package com.leagueoflegendscalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.leagueoflegendscalculator.adapter.ClassExpandableListAdapterRunes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class CreateRunepageActivity extends ActionBarActivity {
	
    ClassExpandableListAdapterRunes listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    
 
    byte AbilityPowerRuneMCount = 0;
    byte AbilityPowerRuneSCount = 0;
    byte AbilityPowerRuneGCount = 0;
    byte AbilityPowerRuneQCount = 0;
    byte AbilityPowerScalingRuneMCount = 0;
    byte AbilityPowerScalingRuneSCount = 0;
    byte AbilityPowerScalingRuneGCount = 0;
    byte AbilityPowerScalingRuneQCount = 0;
    byte ArmorRuneMCount = 0;
    byte ArmorRuneSCount = 0;
    byte ArmorRuneGCount = 0;
    byte ArmorRuneQCount = 0;
    byte ArmorScalingRuneSCount = 0;
    byte ArmorScalingRuneQCount = 0;
    byte ArmorPenetrationRuneMCount = 0;
    byte ArmorPenetrationRuneQCount = 0;
    byte AttackDamageRuneMCount = 0;
    byte AttackDamageRuneSCount = 0;
    byte AttackDamageRuneGCount = 0;
    byte AttackDamageRuneQCount = 0;
    byte AttackDamageScalingRuneMCount = 0;
    byte AttackDamageScalingRuneSCount = 0;
    byte AttackDamageScalingRuneGCount = 0;
    byte AttackDamageScalingRuneQCount = 0;
    byte AttackSpeedRuneMCount = 0;
    byte AttackSpeedRuneSCount = 0;
    byte AttackSpeedRuneGCount = 0;
    byte AttackSpeedRuneQCount = 0;
    byte CooldownReductionRuneMCount = 0;
    byte CooldownReductionRuneSCount = 0;
    byte CooldownReductionRuneGCount = 0;
    byte CooldownReductionRuneQCount = 0;
    byte CooldownReductionScalingRuneGCount = 0;
    byte CooldownReductionScalingRuneQCount = 0;
    byte CriticalChanceRuneMCount = 0;
    byte CriticalChanceRuneSCount = 0;
    byte CriticalChanceRuneGCount = 0;
    byte CriticalChanceRuneQCount = 0;
    byte CriticalDamageRuneMCount = 0;
    byte CriticalDamageRuneSCount = 0;
    byte CriticalDamageRuneGCount = 0;
    byte CriticalDamageRuneQCount = 0;
    byte EnergyRuneGCount = 0;
    byte EnergyRuneQCount = 0;
    byte EnergyScalingRuneGCount = 0;
    byte EnergyRegenRuneSCount = 0;
    byte EnergyRegenRuneQCount = 0;
    byte EnergyRegenScalingRuneSCount = 0;
    byte HealthRuneMCount = 0;
    byte HealthRuneSCount = 0;
    byte HealthRuneGCount = 0;
    byte HealthRuneQCount = 0;
    byte HealthScalingRuneMCount = 0;
    byte HealthScalingRuneSCount = 0;
    byte HealthScalingRuneGCount = 0;
    byte HealthScalingRuneQCount = 0;
    byte HealthPercentRuneSCount = 0;
    byte HealthPercentRuneQCount = 0;
    byte HealthRegenRuneSCount = 0;
	byte HealthRegenRuneGCount = 0;
	byte HealthRegenRuneQCount = 0;
	byte HealthRegenScalingRuneSCount = 0;
	byte HealthRegenScalingRuneQCount = 0;
	byte HybridPenetrationRuneMCount = 0;
	byte HybridPenetrationRuneQCount = 0;
	byte LifeStealRuneQCount = 0;
	byte MagicPenetrationRuneMCount = 0;
	byte MagicPenetrationRuneGCount = 0;
	byte MagicPenetrationRuneQCount = 0;
	byte MagicResistRuneMCount = 0;
	byte MagicResistRuneSCount = 0;
	byte MagicResistRuneGCount = 0;
	byte MagicResistRuneQCount = 0;
	byte MagicResistScalingRuneMCount = 0;
	byte MagicResistScalingRuneSCount = 0;
	byte MagicResistScalingRuneGCount = 0;
	byte MagicResistScalingRuneQCount = 0;
	byte ManaRuneMCount = 0;
	byte ManaRuneSCount = 0;
	byte ManaRuneGCount = 0;
	byte ManaRuneQCount = 0;
	byte ManaScalingRuneMCount = 0;
	byte ManaScalingRuneSCount = 0;
	byte ManaScalingRuneGCount = 0;
	byte ManaScalingRuneQCount = 0;
	byte ManaRegenRuneMCount = 0;
	byte ManaRegenRuneSCount = 0;
	byte ManaRegenRuneGCount = 0;
	byte ManaRegenRuneQCount = 0;
	byte ManaRegenScalingRuneSCount = 0;
	byte ManaRegenScalingRuneGCount = 0;
	byte ManaRegenScalingRuneQCount = 0;
	byte MovementSpeedRuneQCount = 0;
	byte SpellVampRuneQCount = 0;
    
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_runepage);

		//This is needed to give listDataHeader and listDataChild actual values. Before this point they are defined but empty.
		prepareListData();
	    expListView = (ExpandableListView) findViewById(R.id.lvExp);//name MUST be lvExp
        listAdapter = new ClassExpandableListAdapterRunes(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        


		expListView.setOnChildClickListener(new OnChildClickListener() {
		    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
		    	
		    	selectedRunes(groupPosition, childPosition);
		    	return false;
		    }
		});
        
        
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_create_runepage, menu);
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
 
        // Adding header data
        listDataHeader.add("Tier 3 Marks");
        listDataHeader.add("Tier 3 Seals");
        listDataHeader.add("Tier 3 Glyphs");
        listDataHeader.add("Tier 3 Quintessence");

        // Adding child data
        List<String> marks = new ArrayList<String>();
        marks.add("Ability Power");
        marks.add("Attack Damage");
        marks.add("Attack Speed");
        marks.add("Armor");
        marks.add("Armor Penetration");
        marks.add("Cooldown Reduction");
        marks.add("Critical Chance");
        marks.add("Critical Damage");
        marks.add("Health");
        marks.add("Hybrid Penetration");
        marks.add("Magic Penetration");
        marks.add("Magic Resist");
        marks.add("Mana");
        marks.add("Mana Regeneration");
        marks.add("Scaling Ability Power");
        marks.add("Scaling Attack Damage");
        marks.add("Scaling Health");
        marks.add("Scaling Magic Resist");
        marks.add("Scaling Mana");
        
        List<String> seals = new ArrayList<String>();
        seals.add("Ability Power");
        seals.add("Armor");
        seals.add("Attack Damage");
        seals.add("Attack Speed");
        seals.add("Cooldown Reduction");
        seals.add("Critical Chance");
        seals.add("Critical Damage");
        seals.add("Energy Regeneration");
        seals.add("Gold");
        seals.add("Health");
        seals.add("Health Regeneration");
        seals.add("Magic Resist");
        seals.add("Mana");
        seals.add("Mana Regeneration");
        seals.add("Percent Health");
        seals.add("Scaling Ability Power");
        seals.add("Scaling Armor");
        seals.add("Scaling Attack Damage");
        seals.add("Scaling Energy Regeneration");
        seals.add("Scaling Health");
        seals.add("Scaling Health Regeneration");
        seals.add("Scaling Magic Resist");
        seals.add("Scaling Mana");
        seals.add("Scaling Mana Reneration");
        
        List<String> glyphs = new ArrayList<String>();
        glyphs.add("Ability Power");
        glyphs.add("Armor");
        glyphs.add("Attack Damage");
        glyphs.add("Attack Speed");
        glyphs.add("Cooldown Reduction");
        glyphs.add("Critical Damage");
        glyphs.add("Critical Chance");
        glyphs.add("Energy");
        glyphs.add("Health");
        glyphs.add("Health Regeneration");
        glyphs.add("Magic Penetration");
        glyphs.add("Magic Resist");
        glyphs.add("Mana");
        glyphs.add("Mana Regeneration");
        glyphs.add("Scaling Ability Power");
        glyphs.add("Scaling Attack Damage");
        glyphs.add("Scaling Cooldown Reduction");
        glyphs.add("Scaling Energy");
        glyphs.add("Scaling Health");
        glyphs.add("Scaling Magic Resist");
        glyphs.add("Scaling Mana");
        glyphs.add("Scaling Mana Reneration");
        
        List<String> quintessence = new ArrayList<String>();
        quintessence.add("Ability Power");
        quintessence.add("Armor");
        quintessence.add("Armor Penetration");
        quintessence.add("Attack Damage");
        quintessence.add("Attack Speed");
        quintessence.add("Cooldown Reduction");
        quintessence.add("Critical Chance");
        quintessence.add("Critical Damage");
        quintessence.add("Energy");
        quintessence.add("Energy Regeneration");
        quintessence.add("Experience");
        quintessence.add("Gold");
        quintessence.add("Health");
        quintessence.add("Health Regeneration");
        quintessence.add("Hybrid Penetration");
        quintessence.add("Life Steal");
        quintessence.add("Magic Penetration");
        quintessence.add("Magic Resist");
        quintessence.add("Mana");
        quintessence.add("Mana Regeneration");
        quintessence.add("Movement Speed");
        quintessence.add("Percent Health");
        quintessence.add("Revival");
        quintessence.add("Scaling Ability Power");
        quintessence.add("Scaling Armor");
        quintessence.add("Scaling Attack Damage");
        quintessence.add("Scaling Cooldown Reduction");
        quintessence.add("Scaling Health");
        quintessence.add("Scaling Health Regeneration");
        quintessence.add("Scaling Magic Resist");
        quintessence.add("Scaling Mana");
        quintessence.add("Scaling Mana Reneration");
        quintessence.add("Spell Vamp");

        listDataChild.put(listDataHeader.get(0), marks); // Header, Child data
        listDataChild.put(listDataHeader.get(1), seals);
        listDataChild.put(listDataHeader.get(2), glyphs);
        listDataChild.put(listDataHeader.get(3), quintessence); 
    }
	
	public void selectedRunes(int groupPosition, int childPosition){
		String runeStatNameString = this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
		String runeType = this.listDataHeader.get(groupPosition);

		TextView runeStatName1 = (TextView) findViewById(R.id.selected_rune_text1);
		TextView runeStatName2 = (TextView) findViewById(R.id.selected_rune_text2);
		TextView runeStatName3 = (TextView) findViewById(R.id.selected_rune_text3);
		TextView runeStatName4 = (TextView) findViewById(R.id.selected_rune_text4);
		TextView runeStatName5 = (TextView) findViewById(R.id.selected_rune_text5);
		TextView runeStatName6 = (TextView) findViewById(R.id.selected_rune_text6);
		TextView runeStatName7 = (TextView) findViewById(R.id.selected_rune_text7);
		TextView runeStatName8 = (TextView) findViewById(R.id.selected_rune_text8);
		TextView runeStatName9 = (TextView) findViewById(R.id.selected_rune_text9);
		TextView runeStatName10 = (TextView) findViewById(R.id.selected_rune_text10);
		TextView runeStatName11 = (TextView) findViewById(R.id.selected_rune_text11);
		TextView runeStatName12 = (TextView) findViewById(R.id.selected_rune_text12);
		TextView runeStatName13 = (TextView) findViewById(R.id.selected_rune_text13);
		TextView runeStatName14 = (TextView) findViewById(R.id.selected_rune_text14);
		TextView runeStatName15 = (TextView) findViewById(R.id.selected_rune_text15);
		TextView runeStatName16 = (TextView) findViewById(R.id.selected_rune_text16);
		TextView runeStatName17 = (TextView) findViewById(R.id.selected_rune_text17);
		TextView runeStatName18 = (TextView) findViewById(R.id.selected_rune_text18);
		TextView runeStatName19 = (TextView) findViewById(R.id.selected_rune_text19);
		TextView runeStatName20 = (TextView) findViewById(R.id.selected_rune_text20);
		TextView runeStatName21 = (TextView) findViewById(R.id.selected_rune_text21);
		TextView runeStatName22 = (TextView) findViewById(R.id.selected_rune_text22);
		TextView runeStatName23 = (TextView) findViewById(R.id.selected_rune_text23);
		TextView runeStatName24 = (TextView) findViewById(R.id.selected_rune_text24);
		TextView runeStatName25 = (TextView) findViewById(R.id.selected_rune_text25);
		TextView runeStatName26 = (TextView) findViewById(R.id.selected_rune_text26);
		TextView runeStatName27 = (TextView) findViewById(R.id.selected_rune_text27);
		TextView runeStatName28 = (TextView) findViewById(R.id.selected_rune_text28);
		TextView runeStatName29 = (TextView) findViewById(R.id.selected_rune_text29);
		TextView runeStatName30 = (TextView) findViewById(R.id.selected_rune_text30);

	    ImageView RuneImage1 = (ImageView)findViewById(R.id.selected_rune_image1);	
	    ImageView RuneImage2 = (ImageView)findViewById(R.id.selected_rune_image2);	
	    ImageView RuneImage3 = (ImageView)findViewById(R.id.selected_rune_image3);	
	    ImageView RuneImage4 = (ImageView)findViewById(R.id.selected_rune_image4);	
	    ImageView RuneImage5 = (ImageView)findViewById(R.id.selected_rune_image5);	
	    ImageView RuneImage6 = (ImageView)findViewById(R.id.selected_rune_image6);	
	    ImageView RuneImage7 = (ImageView)findViewById(R.id.selected_rune_image7);	
	    ImageView RuneImage8 = (ImageView)findViewById(R.id.selected_rune_image8);	
	    ImageView RuneImage9 = (ImageView)findViewById(R.id.selected_rune_image9);	
	    ImageView RuneImage10 = (ImageView)findViewById(R.id.selected_rune_image10);
	    ImageView RuneImage11 = (ImageView)findViewById(R.id.selected_rune_image11);	
	    ImageView RuneImage12 = (ImageView)findViewById(R.id.selected_rune_image12);	
	    ImageView RuneImage13 = (ImageView)findViewById(R.id.selected_rune_image13);	
	    ImageView RuneImage14 = (ImageView)findViewById(R.id.selected_rune_image14);	
	    ImageView RuneImage15 = (ImageView)findViewById(R.id.selected_rune_image15);	
	    ImageView RuneImage16 = (ImageView)findViewById(R.id.selected_rune_image16);	
	    ImageView RuneImage17 = (ImageView)findViewById(R.id.selected_rune_image17);	
	    ImageView RuneImage18 = (ImageView)findViewById(R.id.selected_rune_image18);	
	    ImageView RuneImage19 = (ImageView)findViewById(R.id.selected_rune_image19);	
	    ImageView RuneImage20 = (ImageView)findViewById(R.id.selected_rune_image20);
	    ImageView RuneImage21 = (ImageView)findViewById(R.id.selected_rune_image21);	
	    ImageView RuneImage22 = (ImageView)findViewById(R.id.selected_rune_image22);	
	    ImageView RuneImage23 = (ImageView)findViewById(R.id.selected_rune_image23);	
	    ImageView RuneImage24 = (ImageView)findViewById(R.id.selected_rune_image24);	
	    ImageView RuneImage25 = (ImageView)findViewById(R.id.selected_rune_image25);	
	    ImageView RuneImage26 = (ImageView)findViewById(R.id.selected_rune_image26);	
	    ImageView RuneImage27 = (ImageView)findViewById(R.id.selected_rune_image27);	
	    ImageView RuneImage28 = (ImageView)findViewById(R.id.selected_rune_image28);	
	    ImageView RuneImage29 = (ImageView)findViewById(R.id.selected_rune_image29);	
	    ImageView RuneImage30 = (ImageView)findViewById(R.id.selected_rune_image30);
	    ImageView RuneImagePlaceholder;
	    
    	Bitmap bitmap1 = ((BitmapDrawable)RuneImage1.getDrawable()).getBitmap();
    	Bitmap bitmap2 = ((BitmapDrawable)RuneImage2.getDrawable()).getBitmap();
    	Bitmap bitmap3 = ((BitmapDrawable)RuneImage3.getDrawable()).getBitmap();
    	Bitmap bitmap4 = ((BitmapDrawable)RuneImage4.getDrawable()).getBitmap();
    	Bitmap bitmap5 = ((BitmapDrawable)RuneImage5.getDrawable()).getBitmap();
    	Bitmap bitmap6 = ((BitmapDrawable)RuneImage6.getDrawable()).getBitmap();
    	Bitmap bitmap7 = ((BitmapDrawable)RuneImage7.getDrawable()).getBitmap();
    	Bitmap bitmap8 = ((BitmapDrawable)RuneImage8.getDrawable()).getBitmap();
    	Bitmap bitmap9 = ((BitmapDrawable)RuneImage9.getDrawable()).getBitmap();
    	Bitmap bitmap10 = ((BitmapDrawable)RuneImage10.getDrawable()).getBitmap();
    	Bitmap bitmap11 = ((BitmapDrawable)RuneImage11.getDrawable()).getBitmap();
    	Bitmap bitmap12 = ((BitmapDrawable)RuneImage12.getDrawable()).getBitmap();
    	Bitmap bitmap13 = ((BitmapDrawable)RuneImage13.getDrawable()).getBitmap();
    	Bitmap bitmap14 = ((BitmapDrawable)RuneImage14.getDrawable()).getBitmap();
    	Bitmap bitmap15 = ((BitmapDrawable)RuneImage15.getDrawable()).getBitmap();
    	Bitmap bitmap16 = ((BitmapDrawable)RuneImage16.getDrawable()).getBitmap();
    	Bitmap bitmap17 = ((BitmapDrawable)RuneImage17.getDrawable()).getBitmap();
    	Bitmap bitmap18 = ((BitmapDrawable)RuneImage18.getDrawable()).getBitmap();
    	Bitmap bitmap19 = ((BitmapDrawable)RuneImage19.getDrawable()).getBitmap();
    	Bitmap bitmap20 = ((BitmapDrawable)RuneImage20.getDrawable()).getBitmap();
    	Bitmap bitmap21 = ((BitmapDrawable)RuneImage21.getDrawable()).getBitmap();
    	Bitmap bitmap22 = ((BitmapDrawable)RuneImage22.getDrawable()).getBitmap();
    	Bitmap bitmap23 = ((BitmapDrawable)RuneImage23.getDrawable()).getBitmap();
    	Bitmap bitmap24 = ((BitmapDrawable)RuneImage24.getDrawable()).getBitmap();
    	Bitmap bitmap25 = ((BitmapDrawable)RuneImage25.getDrawable()).getBitmap();
    	Bitmap bitmap26 = ((BitmapDrawable)RuneImage26.getDrawable()).getBitmap();
    	Bitmap bitmap27 = ((BitmapDrawable)RuneImage27.getDrawable()).getBitmap();
    	Bitmap bitmap28 = ((BitmapDrawable)RuneImage28.getDrawable()).getBitmap();
    	Bitmap bitmap29 = ((BitmapDrawable)RuneImage29.getDrawable()).getBitmap();
    	Bitmap bitmap30 = ((BitmapDrawable)RuneImage30.getDrawable()).getBitmap();
    	Bitmap bitmapBlankMark = ((BitmapDrawable)getResources().getDrawable(R.drawable.r_mark_blank)).getBitmap();
    	Bitmap bitmapBlankSeal = ((BitmapDrawable)getResources().getDrawable(R.drawable.r_seal_blank)).getBitmap();
    	Bitmap bitmapBlankGlyph = ((BitmapDrawable)getResources().getDrawable(R.drawable.r_glyph_blank)).getBitmap();
    	Bitmap bitmapBlankQuintessence = ((BitmapDrawable)getResources().getDrawable(R.drawable.r_quintessence_blank)).getBitmap();
	    
	    if(runeType.equals("Tier 3 Marks") && bitmap9 == bitmapBlankMark){
		    if (bitmap1 == bitmapBlankMark){
		    	RuneImagePlaceholder = RuneImage1;
				runeStatName1.setText(runeStatNameString);
		    }
		    else if (bitmap2 == bitmapBlankMark){
		    	RuneImagePlaceholder = RuneImage2;
				runeStatName2.setText(runeStatNameString);
		    }
		    else if (bitmap3 == bitmapBlankMark){
		    	RuneImagePlaceholder = RuneImage3;
				runeStatName3.setText(runeStatNameString);
		    }
		    else if (bitmap4 == bitmapBlankMark){
		    	RuneImagePlaceholder = RuneImage4;
				runeStatName4.setText(runeStatNameString);
		    }
		    else if (bitmap5 == bitmapBlankMark){
		    	RuneImagePlaceholder = RuneImage5;
				runeStatName5.setText(runeStatNameString);
		    }
		    else if (bitmap6 == bitmapBlankMark){
		    	RuneImagePlaceholder = RuneImage6;
				runeStatName6.setText(runeStatNameString);
		    }
		    else if (bitmap7 == bitmapBlankMark){
		    	RuneImagePlaceholder = RuneImage7;
				runeStatName7.setText(runeStatNameString);
		    }
		    else if (bitmap8 == bitmapBlankMark){
		    	RuneImagePlaceholder = RuneImage8;
				runeStatName8.setText(runeStatNameString);
		    }
		    else{
		    	RuneImagePlaceholder = RuneImage9;
				runeStatName9.setText(runeStatNameString);
		    }
	    }
	    
	    else if(runeType.equals("Tier 3 Seals") && bitmap18 == bitmapBlankSeal){
		    if (bitmap10 == bitmapBlankSeal){
		    	RuneImagePlaceholder = RuneImage10;
				runeStatName10.setText(runeStatNameString);
		    }
		    else if (bitmap11 == bitmapBlankSeal){
		    	RuneImagePlaceholder = RuneImage11;
				runeStatName11.setText(runeStatNameString);
		    }
		    else if (bitmap12 == bitmapBlankSeal){
		    	RuneImagePlaceholder = RuneImage12;
				runeStatName12.setText(runeStatNameString);
		    }
		    else if (bitmap13 == bitmapBlankSeal){
		    	RuneImagePlaceholder = RuneImage13;
				runeStatName13.setText(runeStatNameString);
		    }
		    else if (bitmap14 == bitmapBlankSeal){
		    	RuneImagePlaceholder = RuneImage14;
				runeStatName14.setText(runeStatNameString);
		    }
		    else if (bitmap15 == bitmapBlankSeal){
		    	RuneImagePlaceholder = RuneImage15;
				runeStatName15.setText(runeStatNameString);
		    }
		    else if (bitmap16 == bitmapBlankSeal){
		    	RuneImagePlaceholder = RuneImage16;
				runeStatName16.setText(runeStatNameString);
		    }
		    else if (bitmap17 == bitmapBlankSeal){
		    	RuneImagePlaceholder = RuneImage17;
				runeStatName17.setText(runeStatNameString);
		    }
		    else{
		    	RuneImagePlaceholder = RuneImage18;
				runeStatName18.setText(runeStatNameString);
		    }
	    }
	    
	    else if(runeType.equals("Tier 3 Glyphs") && bitmap27 == bitmapBlankGlyph){
		    if (bitmap19 == bitmapBlankGlyph){
		    	RuneImagePlaceholder = RuneImage19;
				runeStatName19.setText(runeStatNameString);
		    }
		    else if (bitmap20 == bitmapBlankGlyph){
		    	RuneImagePlaceholder = RuneImage20;
				runeStatName20.setText(runeStatNameString);
		    }
		    else if (bitmap21 == bitmapBlankGlyph){
		    	RuneImagePlaceholder = RuneImage21;
				runeStatName21.setText(runeStatNameString);
		    }
		    else if (bitmap22 == bitmapBlankGlyph){
		    	RuneImagePlaceholder = RuneImage22;
				runeStatName22.setText(runeStatNameString);
		    }
		    else if (bitmap23 == bitmapBlankGlyph){
		    	RuneImagePlaceholder = RuneImage23;
				runeStatName23.setText(runeStatNameString);
		    }
		    else if (bitmap24 == bitmapBlankGlyph){
		    	RuneImagePlaceholder = RuneImage24;
				runeStatName24.setText(runeStatNameString);
		    }
		    else if (bitmap25 == bitmapBlankGlyph){
		    	RuneImagePlaceholder = RuneImage25;
				runeStatName25.setText(runeStatNameString);
		    }
		    else if (bitmap26 == bitmapBlankGlyph){
		    	RuneImagePlaceholder = RuneImage26;
				runeStatName26.setText(runeStatNameString);
		    }
		    else{
		    	RuneImagePlaceholder = RuneImage27;
				runeStatName27.setText(runeStatNameString);
		    }
	    }
	    
	    else if (runeType.equals("Tier 3 Quintessence") && bitmap30 == bitmapBlankQuintessence){
		    if (bitmap28 == bitmapBlankQuintessence){
		    	RuneImagePlaceholder = RuneImage28;
				runeStatName28.setText(runeStatNameString);
		    }
		    else if (bitmap29 == bitmapBlankQuintessence){
		    	RuneImagePlaceholder = RuneImage29;
				runeStatName29.setText(runeStatNameString);
		    }
		    else{
		    	RuneImagePlaceholder = RuneImage30;
				runeStatName30.setText(runeStatNameString);
		    }
	    }
	    
	    else{
	    	RuneImagePlaceholder = RuneImage30;//This is just to ensure that RuneImagePlaceholder will always have some value
	    }
	    
	    
	    
    	if (runeType.equals("Tier 3 Marks") && bitmap9 == bitmapBlankMark ){
        	switch(runeStatNameString){
        	case "Ability Power":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_poison);
        		AbilityPowerRuneMCount++;
        		break;
        	case "Attack Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_arrows);
        		AttackDamageRuneMCount++;
        		break;
        	case "Attack Speed":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_poison);
        		AttackSpeedRuneMCount++;
        		break;
        	case "Armor":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_arrows);
        		ArmorRuneMCount++;
        		break;
        	case "Armor Penetration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_arrows);
        		ArmorPenetrationRuneMCount++;
        		break;
        	case "Cooldown Reduction":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_arrows);
        		CooldownReductionRuneMCount++;
        		break;
        	case "Critical Chance":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_poison);
        		CriticalChanceRuneMCount++;
        		break;
        	case "Critical Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_arrows);
        		CriticalDamageRuneMCount++;
        		break;
        	case "Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_poison);
        		HealthRuneMCount++;
        		break;
        	case "Hybrid Penetration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_arrows);
        		HybridPenetrationRuneMCount++;
        		break;
        	case "Magic Penetration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_arrows);
        		MagicPenetrationRuneMCount++;
        		break;
        	case "Magic Resist":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_poison);
        		MagicResistRuneMCount++;
        		break;
        	case "Mana":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_arrows);
        		ManaRuneMCount++;
        		break;
        	case "Mana Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_poison);
        		ManaRegenRuneMCount++;
        		break;
        	case "Scaling Ability Power":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_mace); 
        		AbilityPowerScalingRuneMCount++;
        		break;
        	case "Scaling Attack Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_spear); 
        		AttackDamageScalingRuneMCount++;
        		break;
        	case "Scaling Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_mace); 
        		HealthScalingRuneMCount++;
        		break;
        	case "Scaling Magic Resist":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_mace);
        		MagicResistScalingRuneMCount++;
        		break;
        	case "Scaling Mana":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_mark_spear); 
        		ManaScalingRuneMCount++;
        		break;
        	}
    	}
    	

    	else if (runeType.equals("Tier 3 Seals") && bitmap18 == bitmapBlankSeal ){
        	switch(runeStatNameString){
        	case "Ability Power":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_wing);
        		AbilityPowerRuneSCount++;
        		break;
        	case "Armor":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_goblet);
        		ArmorRuneSCount++;
        		break;
        	case "Attack Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_goblet);
        		AttackDamageRuneSCount++;
        		break;
        	case "Attack Speed":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_wing);
        		AttackSpeedRuneSCount++;
        		break;
        	case "Cooldown Reduction":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_goblet);
        		CooldownReductionRuneSCount++;
        		break;
        	case "Critical Chance":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_wing);
        		CriticalChanceRuneSCount++;
        		break;
        	case "Critical Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_goblet);
        		CriticalDamageRuneSCount++;
        		break;
        	case "Energy Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_goblet);
        		EnergyRegenRuneSCount++;
        		break;
        	case "Gold":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_wing);
        		break;
        	case "Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_wing);
        		HealthRuneSCount++;
        		break;
        	case "Health Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_goblet);
        		HealthRegenRuneSCount++;
        		break;
        	case "Magic Resist":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_wing);
        		MagicResistRuneSCount++;
        		break;
        	case "Mana":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_goblet);
        		ManaRuneSCount++;
        		break;
        	case "Mana Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_wing);
        		ManaRegenRuneSCount++;
        		break;
        	case "Percent Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_wing); 
        		HealthPercentRuneSCount++;
        		break;
        	case "Scaling Ability Power":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_shield);
        		AbilityPowerScalingRuneSCount++;
        		break;
        	case "Scaling Armor":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_shield);
        		ArmorScalingRuneSCount++;
        		break;
        	case "Scaling Attack Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_shield);
        		AttackDamageScalingRuneSCount++;
        		break;
        	case "Scaling Energy Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_wing);
        		EnergyRegenScalingRuneSCount++;
        		break;
        	case "Scaling Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_shield);
        		HealthScalingRuneSCount++;
        		break;
        	case "Scaling Health Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_shield);
        		HealthRegenScalingRuneSCount++;
        		break;
        	case "Scaling Magic Resist":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_shield);
        		MagicResistScalingRuneSCount++;
        		break;
        	case "Scaling Mana":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_shield);
        		ManaScalingRuneSCount++;
        		break;
        	case "Scaling Mana Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_seal_shield);
        		ManaRegenScalingRuneSCount++;
        		break;
        	}
    	}

    	else if (runeType.equals("Tier 3 Glyphs") && bitmap27 == bitmapBlankGlyph ){
        	switch(runeStatNameString){
        	case "Ability Power":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_shell);
        		AbilityPowerRuneGCount++;
        		break;
        	case "Armor":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_candle);
        		ArmorRuneGCount++;
        		break;
        	case "Attack Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_candle);
        		AttackDamageRuneGCount++;
        		break;
        	case "Attack Speed":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_shell);
        		AttackSpeedRuneGCount++;
        		break;
        	case "Cooldown Reduction":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_candle);
        		CooldownReductionRuneGCount++;
        		break;
        	case "Critical Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_candle);
        		CriticalDamageRuneGCount++;
        		break;
        	case "Critical Chance":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_shell);
        		CriticalChanceRuneGCount++;
        		break;
        	case "Energy":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_shell);
        		EnergyRuneGCount++;
        		break;
        	case "Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_shell);
        		HealthRuneGCount++;
        		break;
        	case "Health Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_candle);
        		HealthRegenRuneGCount++;
        		break;
        	case "Magic Penetration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_candle);
        		MagicPenetrationRuneGCount++;
        		break;
        	case "Magic Resist":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_shell);
        		MagicResistRuneGCount++;
        		break;
        	case "Mana":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_candle);
        		ManaRuneGCount++;
        		break;
        	case "Mana Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_shell);
        		ManaRegenRuneGCount++;
        		break;
        	case "Scaling Ability Power":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_key);
        		AbilityPowerScalingRuneGCount++;
        		break;
        	case "Scaling Attack Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_hand);
        		AttackDamageScalingRuneGCount++;
        		break;
        	case "Scaling Cooldown Reduction":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_hand);
        		CooldownReductionScalingRuneGCount++;
        		break;
        	case "Scaling Energy":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_hand);
        		EnergyScalingRuneGCount++;
        		break;
        	case "Scaling Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_key);
        		HealthScalingRuneGCount++;
        		break;
        	case "Scaling Magic Resist":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_key);
        		MagicResistScalingRuneGCount++;
        		break;
        	case "Scaling Mana":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_hand);
        		ManaScalingRuneGCount++;
        		break;
        	case "Scaling Mana Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_glyph_key);
        		ManaRegenScalingRuneGCount++;
        		break;
        	}
    	}

    	else if (runeType.equals("Tier 3 Quintessence") && bitmap30 == bitmapBlankQuintessence){
        	switch(runeStatNameString){
        	case "Ability Power":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_ram);
        		AbilityPowerRuneQCount++;
        		break;
        	case "Armor":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		ArmorRuneQCount++;
        		break;
        	case "Armor Penetration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		ArmorPenetrationRuneQCount++;
        		break;
        	case "Attack Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		AttackDamageRuneQCount++;
        		break;
        	case "Attack Speed":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_ram);
        		AttackSpeedRuneQCount++;
        		break;
        	case "Cooldown Reduction":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		CooldownReductionRuneQCount++;
        		break;
        	case "Critical Chance":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_ram);
        		CriticalChanceRuneQCount++;
        		break;
        	case "Critical Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		CriticalDamageRuneQCount++;
        		break;
        	case "Energy":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_ram);
        		EnergyRuneQCount++;
        		break;
        	case "Energy Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_lion);
        		EnergyRegenRuneQCount++;
        		break;
        	case "Experience":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_lion);
        		break;
        	case "Gold":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_tree); 
        		break;   
        	case "Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_ram);
        		HealthRuneQCount++;
        		break;
        	case "Health Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		HealthRegenRuneQCount++;
        		break;
        	case "Hybrid Penetration":;
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_tree); 
        		HybridPenetrationRuneQCount++;
        		break;
        	case "Life Steal":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		LifeStealRuneQCount++;
        		break;
        	case "Magic Penetration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		MagicPenetrationRuneQCount++;
        		break;
        	case "Magic Resist":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_ram);
        		MagicResistRuneQCount++;
        		break;
        	case "Mana":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		ManaRuneQCount++;
        		break;
        	case "Mana Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_ram);
        		ManaRegenRuneQCount++;
        		break;
        	case "Movement Speed":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_ram);
        		MovementSpeedRuneQCount++;
        		break;
        	case "Percent Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_ram);
        		HealthPercentRuneQCount++;
        		break;
        	case "Revival":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_dragon);
        		break;
        	case "Scaling Ability Power":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_tree);
        		AbilityPowerScalingRuneQCount++;
        		break;
        	case "Scaling Armor":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_lion);
        		ArmorScalingRuneQCount++;
        		break;
        	case "Scaling Attack Damage":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_lion);
        		AttackDamageScalingRuneQCount++;
        		break;
        	case "Scaling Cooldown Reduction":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_lion);
        		CooldownReductionScalingRuneQCount++;
        		break;
        	case "Scaling Health":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_tree);
        		HealthScalingRuneQCount++;
        		break;
        	case "Scaling Health Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_lion);
        		HealthRegenScalingRuneQCount++;
        		break;
        	case "Scaling Magic Resist":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_tree);
        		MagicResistScalingRuneQCount++;
        		break;
        	case "Scaling Mana":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_lion);
        		ManaScalingRuneQCount++;
        		break;
        	case "Scaling Mana Regeneration":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_tree);
        		ManaRegenScalingRuneQCount++;
        		break;
        	case "Spell Vamp":
        		RuneImagePlaceholder.setImageResource(R.drawable.r_quintessence_tree);
        		SpellVampRuneQCount++;
        		break;
        	}
    	}
	}
	
	
	
	public void save(){
		
		/*
		ClassRunes runePage = new ClassRunes(
				AbilityPowerRuneMCount,
			    AbilityPowerRuneSCount,
			    AbilityPowerRuneGCount,
			    AbilityPowerRuneQCount,
			    AbilityPowerScalingRuneMCount,
			    AbilityPowerScalingRuneSCount,
			    AbilityPowerScalingRuneGCount,
			    AbilityPowerScalingRuneQCount,
			    ArmorRuneMCount,
			    ArmorRuneSCount,
			    ArmorRuneGCount,
			    ArmorRuneQCount,
			    ArmorScalingRuneSCount,
			    ArmorScalingRuneQCount,
			    ArmorPenetrationRuneMCount,
			    ArmorPenetrationRuneQCount,
			    AttackDamageRuneMCount,
			    AttackDamageRuneSCount,
			    AttackDamageRuneGCount,
			    AttackDamageRuneQCount,
			    AttackDamageScalingRuneMCount,
			    AttackDamageScalingRuneSCount,
			    AttackDamageScalingRuneGCount,
			    AttackDamageScalingRuneQCount,
			    AttackSpeedRuneMCount,
			    AttackSpeedRuneSCount,
			    AttackSpeedRuneGCount,
			    AttackSpeedRuneQCount,
			    CooldownReductionRuneMCount,
			    CooldownReductionRuneSCount,
			    CooldownReductionRuneGCount,
			    CooldownReductionRuneQCount,
			    CooldownReductionScalingRuneGCount,
			    CooldownReductionScalingRuneQCount,
			    CriticalChanceRuneMCount,
			    CriticalChanceRuneSCount,
			    CriticalChanceRuneGCount,
			    CriticalChanceRuneQCount,
			    CriticalDamageRuneMCount,
			    CriticalDamageRuneSCount,
			    CriticalDamageRuneGCount,
			    CriticalDamageRuneQCount,
			    EnergyRuneGCount,
			    EnergyRuneQCount,
			    EnergyScalingRuneGCount,
			    EnergyRegenRuneSCount,
			    EnergyRegenRuneQCount,
			    EnergyRegenScalingRuneSCount,
			    HealthRuneMCount,
			    HealthRuneSCount,
			    HealthRuneGCount,
			    HealthRuneQCount,
			    HealthScalingRuneMCount,
			    HealthScalingRuneSCount,
			    HealthScalingRuneGCount,
			    HealthScalingRuneQCount,
			    HealthPercentRuneSCount,
			    HealthPercentRuneQCount,
			    HealthRegenRuneSCount,
				HealthRegenRuneGCount,
				HealthRegenRuneQCount,
				HealthRegenScalingRuneSCount,
				HealthRegenScalingRuneQCount,
				HybridPenetrationRuneMCount,
				HybridPenetrationRuneQCount,
				LifeStealRuneQCount,
				MagicPenetrationRuneMCount,
				MagicPenetrationRuneGCount,
				MagicPenetrationRuneQCount,
				MagicResistRuneMCount,
				MagicResistRuneSCount,
				MagicResistRuneGCount,
				MagicResistRuneQCount,
				MagicResistScalingRuneMCount,
				MagicResistScalingRuneSCount,
				MagicResistScalingRuneGCount,
				MagicResistScalingRuneQCount,
				ManaRuneMCount,
				ManaRuneSCount,
				ManaRuneGCount,
				ManaRuneQCount,
				ManaScalingRuneMCount,
				ManaScalingRuneSCount,
				ManaScalingRuneGCount,
				ManaScalingRuneQCount,
				ManaRegenRuneMCount,
				ManaRegenRuneSCount,
				ManaRegenRuneGCount,
				ManaRegenRuneQCount,
				ManaRegenScalingRuneSCount,
				ManaRegenScalingRuneGCount,
				ManaRegenScalingRuneQCount,
				MovementSpeedRuneQCount,
				SpellVampRuneQCount
				);
		*/
		
		Intent saveRunepage = new Intent(this, ViewRunepagesActivity.class);
		
		EditText runeSetNameView = (EditText)findViewById(R.id.rune_set_name);
		String runeSetName = runeSetNameView.getText().toString();
		
		saveRunepage.putExtra("runeSetName", runeSetName);
		saveRunepage.putExtra("AbilityPowerRuneMCount", AbilityPowerRuneMCount);
		saveRunepage.putExtra("AbilityPowerRuneSCount", AbilityPowerRuneSCount);
		saveRunepage.putExtra("AbilityPowerRuneGCount", AbilityPowerRuneGCount);
		saveRunepage.putExtra("AbilityPowerRuneQCount", AbilityPowerRuneQCount);
		saveRunepage.putExtra("AbilityPowerScalingRuneMCount", AbilityPowerScalingRuneMCount);
		saveRunepage.putExtra("AbilityPowerScalingRuneSCount", AbilityPowerScalingRuneSCount);
		saveRunepage.putExtra("AbilityPowerScalingRuneGCount", AbilityPowerScalingRuneGCount);
		saveRunepage.putExtra("AbilityPowerScalingRuneQCount", AbilityPowerScalingRuneQCount);
		saveRunepage.putExtra("ArmorRuneMCount", ArmorRuneMCount);
		saveRunepage.putExtra("ArmorRuneSCount", ArmorRuneSCount);
		saveRunepage.putExtra("ArmorRuneGCount", ArmorRuneGCount);
		saveRunepage.putExtra("ArmorRuneQCount", ArmorRuneQCount);
		saveRunepage.putExtra("ArmorScalingRuneSCount", ArmorScalingRuneSCount);
		saveRunepage.putExtra("ArmorScalingRuneQCount", ArmorScalingRuneQCount);
		saveRunepage.putExtra("ArmorPenetrationRuneMCount", ArmorPenetrationRuneMCount);
		saveRunepage.putExtra("ArmorPenetrationRuneQCount", ArmorPenetrationRuneQCount);
		saveRunepage.putExtra("AttackDamageRuneMCount", AttackDamageRuneMCount);
		saveRunepage.putExtra("AttackDamageRuneSCount", AttackDamageRuneSCount);
		saveRunepage.putExtra("AttackDamageRuneGCount", AttackDamageRuneGCount);
		saveRunepage.putExtra("AttackDamageRuneQCount", AttackDamageRuneQCount);
		saveRunepage.putExtra("AttackDamageScalingRuneMCount", AttackDamageScalingRuneMCount);
		saveRunepage.putExtra("AttackDamageScalingRuneSCount", AttackDamageScalingRuneSCount);
		saveRunepage.putExtra("AttackDamageScalingRuneGCount", AttackDamageScalingRuneGCount);
		saveRunepage.putExtra("AttackDamageScalingRuneQCount", AttackDamageScalingRuneQCount);
		saveRunepage.putExtra("AttackSpeedRuneMCount", AttackSpeedRuneMCount);
		saveRunepage.putExtra("AttackSpeedRuneSCount", AttackSpeedRuneSCount);
		saveRunepage.putExtra("AttackSpeedRuneGCount", AttackSpeedRuneGCount);
		saveRunepage.putExtra("AttackSpeedRuneQCount", AttackSpeedRuneQCount);
		saveRunepage.putExtra("CooldownReductionRuneMCount", CooldownReductionRuneMCount);
		saveRunepage.putExtra("CooldownReductionRuneSCount", CooldownReductionRuneSCount);
		saveRunepage.putExtra("CooldownReductionRuneGCount", CooldownReductionRuneGCount);
		saveRunepage.putExtra("CooldownReductionRuneQCount", CooldownReductionRuneQCount);
		saveRunepage.putExtra("CooldownReductionScalingRuneGCount", CooldownReductionScalingRuneGCount);
		saveRunepage.putExtra("CooldownReductionScalingRuneQCount", CooldownReductionScalingRuneQCount);
		saveRunepage.putExtra("CriticalChanceRuneMCount", CriticalChanceRuneMCount);
		saveRunepage.putExtra("CriticalChanceRuneSCount", CriticalChanceRuneSCount);
		saveRunepage.putExtra("CriticalChanceRuneGCount", CriticalChanceRuneGCount);
		saveRunepage.putExtra("CriticalChanceRuneQCount", CriticalChanceRuneQCount);
		saveRunepage.putExtra("CriticalDamageRuneMCount", CriticalDamageRuneMCount);
		saveRunepage.putExtra("CriticalDamageRuneSCount", CriticalDamageRuneSCount);
		saveRunepage.putExtra("CriticalDamageRuneGCount", CriticalDamageRuneGCount);
		saveRunepage.putExtra("CriticalDamageRuneQCount", CriticalDamageRuneQCount);
		saveRunepage.putExtra("EnergyRuneGCount", EnergyRuneGCount);
		saveRunepage.putExtra("EnergyRuneQCount", EnergyRuneQCount);
		saveRunepage.putExtra("EnergyScalingRuneGCount", EnergyScalingRuneGCount);
		saveRunepage.putExtra("EnergyRegenRuneSCount", EnergyRegenRuneSCount);
		saveRunepage.putExtra("EnergyRegenRuneQCount", EnergyRegenRuneQCount);
		saveRunepage.putExtra("EnergyRegenScalingRuneSCount", EnergyRegenScalingRuneSCount);
		saveRunepage.putExtra("HealthRuneMCount", HealthRuneMCount);
		saveRunepage.putExtra("HealthRuneSCount", HealthRuneSCount);
		saveRunepage.putExtra("HealthRuneGCount", HealthRuneGCount);
		saveRunepage.putExtra("HealthRuneQCount", HealthRuneQCount);
		saveRunepage.putExtra("HealthScalingRuneMCount", HealthScalingRuneMCount);
		saveRunepage.putExtra("HealthScalingRuneSCount", HealthScalingRuneSCount);
		saveRunepage.putExtra("HealthScalingRuneGCount", HealthScalingRuneGCount);
		saveRunepage.putExtra("HealthScalingRuneQCount", HealthScalingRuneQCount);
		saveRunepage.putExtra("HealthPercentRuneSCount", HealthPercentRuneSCount);
		saveRunepage.putExtra("HealthPercentRuneQCount", HealthPercentRuneQCount);
		saveRunepage.putExtra("HealthRegenRuneSCount", HealthRegenRuneSCount);
		saveRunepage.putExtra("HealthRegenRuneGCount", HealthRegenRuneGCount);
		saveRunepage.putExtra("HealthRegenRuneQCount", HealthRegenRuneQCount);
		saveRunepage.putExtra("HealthRegenScalingRuneSCount", HealthRegenScalingRuneSCount);
		saveRunepage.putExtra("HealthRegenScalingRuneQCount", HealthRegenScalingRuneQCount);
		saveRunepage.putExtra("HybridPenetrationRuneMCount", HybridPenetrationRuneMCount);
		saveRunepage.putExtra("HybridPenetrationRuneQCount", HybridPenetrationRuneQCount);
		saveRunepage.putExtra("LifeStealRuneQCount", LifeStealRuneQCount);
		saveRunepage.putExtra("MagicPenetrationRuneMCount", MagicPenetrationRuneMCount);
		saveRunepage.putExtra("MagicPenetrationRuneGCount", MagicPenetrationRuneGCount);
		saveRunepage.putExtra("MagicPenetrationRuneQCount", MagicPenetrationRuneQCount);
		saveRunepage.putExtra("MagicResistRuneMCount", MagicResistRuneMCount);
		saveRunepage.putExtra("MagicResistRuneSCount", MagicResistRuneSCount);
		saveRunepage.putExtra("MagicResistRuneGCount", MagicResistRuneGCount);
		saveRunepage.putExtra("MagicResistRuneQCount", MagicResistRuneQCount);
		saveRunepage.putExtra("MagicResistScalingRuneMCount", MagicResistScalingRuneMCount);
		saveRunepage.putExtra("MagicResistScalingRuneSCount", MagicResistScalingRuneSCount);
		saveRunepage.putExtra("MagicResistScalingRuneGCount", MagicResistScalingRuneGCount);
		saveRunepage.putExtra("MagicResistScalingRuneQCount", MagicResistScalingRuneQCount);
		saveRunepage.putExtra("ManaRuneMCount", ManaRuneMCount);
		saveRunepage.putExtra("ManaRuneSCount", ManaRuneSCount);
		saveRunepage.putExtra("ManaRuneGCount", ManaRuneGCount);
		saveRunepage.putExtra("ManaRuneQCount", ManaRuneQCount);
		saveRunepage.putExtra("ManaScalingRuneMCount", ManaScalingRuneMCount);
		saveRunepage.putExtra("ManaScalingRuneSCount", ManaScalingRuneSCount);
		saveRunepage.putExtra("ManaScalingRuneGCount", ManaScalingRuneGCount);
		saveRunepage.putExtra("ManaScalingRuneQCount", ManaScalingRuneQCount);
		saveRunepage.putExtra("ManaRegenRuneMCount", ManaRegenRuneMCount);
		saveRunepage.putExtra("ManaRegenRuneSCount", ManaRegenRuneSCount);
		saveRunepage.putExtra("ManaRegenRuneGCount", ManaRegenRuneGCount);
		saveRunepage.putExtra("ManaRegenRuneQCount", ManaRegenRuneQCount);
		saveRunepage.putExtra("ManaRegenScalingRuneSCount", ManaRegenScalingRuneSCount);
		saveRunepage.putExtra("ManaRegenScalingRuneGCount", ManaRegenScalingRuneGCount);
		saveRunepage.putExtra("ManaRegenScalingRuneQCount", ManaRegenScalingRuneQCount);
		saveRunepage.putExtra("MovementSpeedRuneQCount", MovementSpeedRuneQCount);
		saveRunepage.putExtra("SpellVampRuneQCount", SpellVampRuneQCount);
		startActivity(saveRunepage);
		
	}


    
    
}


