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

public class ClassCustomItemSetSaved  extends ArrayAdapter<String>{
	private final Activity context;

	private final String[] savedItemSet;
	private final Integer[] savedItemSetImage1;
	private final Integer[] savedItemSetImage2;
	private final Integer[] savedItemSetImage3;
	private final Integer[] savedItemSetImage4;
	private final Integer[] savedItemSetImage5;
	private final Integer[] savedItemSetImage6;
	
	public ClassCustomItemSetSaved(Activity context, String[] ItemID, String[] savedItemSet, Integer[] savedItemSetImage1, Integer[] savedItemSetImage2, Integer[] savedItemSetImage3, Integer[] savedItemSetImage4, Integer[] savedItemSetImage5, Integer[] savedItemSetImage6) {
		//The parameter arrayOfChampions in super() is what gives the names to the list items
		// This uses list_single.xml as the format of each cell on the list
		super(context, R.layout.item_saved_row, ItemID); 
		this.context = context;
		this.savedItemSet = savedItemSet;
		this.savedItemSetImage1 = savedItemSetImage1;
		this.savedItemSetImage2 = savedItemSetImage2;
		this.savedItemSetImage3 = savedItemSetImage3;
		this.savedItemSetImage4 = savedItemSetImage4;
		this.savedItemSetImage5 = savedItemSetImage5;
		this.savedItemSetImage6 = savedItemSetImage6;
		
	}
	
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.item_saved_row, null, true);
		
		TextView txtChamp = (TextView) rowView.findViewById(R.id.itemSetName);
		ImageView imageView1 = (ImageView) rowView.findViewById(R.id.img1);
		ImageView imageView2 = (ImageView) rowView.findViewById(R.id.img2);
		ImageView imageView3 = (ImageView) rowView.findViewById(R.id.img3);
		ImageView imageView4 = (ImageView) rowView.findViewById(R.id.img4);
		ImageView imageView5 = (ImageView) rowView.findViewById(R.id.img5);
		ImageView imageView6 = (ImageView) rowView.findViewById(R.id.img6);
		
		txtChamp.setText(savedItemSet[position]);
		imageView1.setImageResource(savedItemSetImage1[position]);
		imageView2.setImageResource(savedItemSetImage2[position]);
		imageView3.setImageResource(savedItemSetImage3[position]);
		imageView4.setImageResource(savedItemSetImage4[position]);
		imageView5.setImageResource(savedItemSetImage5[position]);
		imageView6.setImageResource(savedItemSetImage6[position]);

		
		return rowView;
	}
}



