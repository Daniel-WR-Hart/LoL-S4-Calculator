package com.leagueoflegendscalculator.adapter;


import com.leagueoflegendscalculator.R;
import com.leagueoflegendscalculator.R.id;
import com.leagueoflegendscalculator.R.layout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassCustomBuildSaved extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] buildName;
	private final String[] championInfo;
	private final Integer[] championImage;
	private final String[] itemSetName; 
	private final Integer[] itemImage1; 
	private final Integer[] itemImage2; 
	private final Integer[] itemImage3;
	private final Integer[] itemImage4; 
	private final Integer[] itemImage5;
	private final Integer[] itemImage6; 
	private final String[] masteryPageName;
	private final String[] runePageName; 
    
	public ClassCustomBuildSaved(Activity context, String[] buildID, String[] buildName, String[] championInfo, Integer[] championImage, String[] itemSetName, Integer[] itemImage1, Integer[] itemImage2, Integer[] itemImage3, Integer[] itemImage4, Integer[] itemImage5, Integer[] itemImage6, String[] masteryPageName, String[] runePageName) {
		//The parameter arrayOfChampions in super() is what gives the names to the list items
		// This uses list_single.xml as the format of each cell on the list
		super(context, R.layout.build_saved_row, buildID); 
		this.context = context;
		this.buildName = buildName;
		this.championInfo = championInfo;
		this.championImage = championImage;
		this.itemSetName = itemSetName;
		this.itemImage1 = itemImage1;
		this.itemImage2 = itemImage2;
		this.itemImage3 = itemImage3;
		this.itemImage4 = itemImage4;
		this.itemImage5 = itemImage5;
		this.itemImage6 = itemImage6;
		this.masteryPageName = masteryPageName;
		this.runePageName = runePageName;
	}
	
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.build_saved_row, null, true);
		
		TextView txtBuildName = (TextView) rowView.findViewById(R.id.build_name);
		TextView txtChampionInfo = (TextView) rowView.findViewById(R.id.champion_info);
		ImageView imgChampionImage = (ImageView) rowView.findViewById(R.id.champion_image);
		TextView txtItemSetName = (TextView) rowView.findViewById(R.id.item_set_name);
		ImageView imgItemImage1 = (ImageView) rowView.findViewById(R.id.item_image1);
		ImageView imgItemImage2 = (ImageView) rowView.findViewById(R.id.item_image2);
		ImageView imgItemImage3 = (ImageView) rowView.findViewById(R.id.item_image3);
		ImageView imgItemImage4 = (ImageView) rowView.findViewById(R.id.item_image4);
		ImageView imgItemImage5 = (ImageView) rowView.findViewById(R.id.item_image5);
		ImageView imgItemImage6 = (ImageView) rowView.findViewById(R.id.item_image6);
		TextView txtMasteryPageName = (TextView) rowView.findViewById(R.id.mastery_page_name);
		TextView txtRunePageName = (TextView) rowView.findViewById(R.id.rune_page_name);
		
	
		txtBuildName.setText(buildName[position]);
		txtChampionInfo.setText(championInfo[position]);
		imgChampionImage.setImageResource(championImage[position]);
		txtItemSetName.setText("Item Set: " + itemSetName[position]);
		imgItemImage1.setImageResource(itemImage1[position]);
		imgItemImage2.setImageResource(itemImage2[position]);
		imgItemImage3.setImageResource(itemImage3[position]);
		imgItemImage4.setImageResource(itemImage4[position]);
		imgItemImage5.setImageResource(itemImage5[position]);
		imgItemImage6.setImageResource(itemImage6[position]);
		txtMasteryPageName.setText("Mastery Page: " + masteryPageName[position]);
		txtRunePageName.setText("Rune Page: " + runePageName[position]);
		
		
		return rowView;
	}
}