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

public class ClassCustomMasterySaved  extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] savedMasterySet;
	private final Byte[] offenseTotal;
	private final Byte[] defenseTotal;
	private final Byte[] utilityTotal;
	
	public ClassCustomMasterySaved(Activity context, String[] masteryID, String[] savedMasterySet, Byte[] offenseTotal, Byte[] defenseTotal, Byte[] utilityTotal) {
		//The parameter arrayOfChampions in super() is what gives the names to the list items
		// This uses list_single.xml as the format of each cell on the list
		super(context, R.layout.mastery_saved_row, masteryID); 
		this.context = context;
		this.savedMasterySet = savedMasterySet;
		this.offenseTotal = offenseTotal;
		this.defenseTotal = defenseTotal;
		this.utilityTotal = utilityTotal;
		
	}
	
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.mastery_saved_row, null, true);
		
		TextView txtChamp = (TextView) rowView.findViewById(R.id.mastery_set_name);
		TextView offenseText = (TextView) rowView.findViewById(R.id.offense_text);
		TextView defenseText = (TextView) rowView.findViewById(R.id.defense_text);
		TextView utilityText = (TextView) rowView.findViewById(R.id.utility_text);

		
		txtChamp.setText(savedMasterySet[position]);
		offenseText.setText(offenseTotal[position].toString());// Could also use String.valueOf(byte) but .toString() is faster and not ambiguous 
		defenseText.setText(defenseTotal[position].toString());
		utilityText.setText(utilityTotal[position].toString());


		
		return rowView;
	}
}


