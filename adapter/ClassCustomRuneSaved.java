package com.leagueoflegendscalculator.adapter;


import com.leagueoflegendscalculator.R;
import com.leagueoflegendscalculator.R.id;
import com.leagueoflegendscalculator.R.layout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ClassCustomRuneSaved  extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] savedRuneSetName;
	private final String[] savedRuneSetDetails;
	
	public ClassCustomRuneSaved(Activity context, String[] runeID, String[] savedRuneSetName, String[] savedRuneSetDetails) {
		//The parameter arrayOfChampions in super() is what gives the names to the list items
		// This uses list_single.xml as the format of each cell on the list
		super(context, R.layout.runepage_saved_row, runeID);
		this.context = context;
		this.savedRuneSetName = savedRuneSetName;
		this.savedRuneSetDetails= savedRuneSetDetails;
		
	}
	
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.runepage_saved_row, null, true);
		
		TextView savedRuneSetNameText = (TextView) rowView.findViewById(R.id.runepage_set_name);
		TextView savedRuneSetDetailsText = (TextView) rowView.findViewById(R.id.runepage_details);
		
		savedRuneSetNameText.setText(savedRuneSetName[position]);
		savedRuneSetDetailsText.setText(savedRuneSetDetails[position]);


		
		return rowView;
	}
}



