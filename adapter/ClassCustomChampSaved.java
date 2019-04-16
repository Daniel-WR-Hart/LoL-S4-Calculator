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

public class ClassCustomChampSaved extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] savedChampion;
	private final Integer[] savedChampionImage;
	
	public ClassCustomChampSaved(Activity context, String[] ChampionID, String[] savedChampion, Integer[] savedChampionImage) {
		//The parameter arrayOfChampions in super() is what gives the names to the list items
		// This uses list_single.xml as the format of each cell on the list
		super(context, R.layout.champ_saved_row, ChampionID); 
		this.context = context;
		this.savedChampion = savedChampion;
		this.savedChampionImage = savedChampionImage;
	}
	
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.champ_saved_row, null, true);
		
		TextView txtChamp = (TextView) rowView.findViewById(R.id.champName);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		
		txtChamp.setText(savedChampion[position]);
		imageView.setImageResource(savedChampionImage[position]);

		
		return rowView;
	}
}


