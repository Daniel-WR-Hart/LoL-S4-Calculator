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


public class ClassCustomChampList extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] arrayOfChampions;
	private final Integer[] imageId;
	private final String[] arrayOfTitles;
	public ClassCustomChampList(Activity context,String[] arrayOfChampions, Integer[] imageId, String[] arrayOfTitles) {
		//The parameter arrayOfChampions in super() is what gives the names to the list items
		// This uses list_single.xml as the format of each cell on the list
		super(context, R.layout.champ_list_row, arrayOfChampions); 
		this.context = context;
		this.arrayOfChampions = arrayOfChampions;
		this.imageId = imageId;
		this.arrayOfTitles = arrayOfTitles;
	}
	
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.champ_list_row, null, true);
		
		TextView txtChamp = (TextView) rowView.findViewById(R.id.champName);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.champTitle);
		//*********notice that rowView. is needed before the findViewById part or else we get a similar error to what happens when I try to use findViewById to change images in the expanded list view class.
		//"rowView" is a View that was inflated a few lines back. Something like this may be needed in the expanded list view. Try to find other instances of findViewById that are preceded
		//by some word and check if that word was inflated earlier in the code.**********
		//The name of that word to try is convertView, so try ImageView RuneImage = (ImageView)convertView.findViewById(R.id.rune_image);
		
		txtChamp.setText(arrayOfChampions[position]);
		imageView.setImageResource(imageId[position]);
		txtTitle.setText(arrayOfTitles[position]);
		
		//There is a weird bug that makes it so that depending on the order of the TextViews in the xml file, the TextView
		//may not end up taking in the correct array. I found that by changing the order of the TextViews in the xml file,
		//the text formats in the emulator are also switched (good), and the pre-entered test text I put in each TextView
		//is also switched in the preview (good), but the information from the arrays end up in the same position as before
		//the change (they are supposed to "follow" the TextViews they were assigned to and change positions). Also note
		//that the order of code in this java file did not make a difference.
		
		return rowView;
	}
}


