package com.leagueoflegendscalculator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leagueoflegendscalculator.adapter.ClassCustomItemSetSaved;
import com.leagueoflegendscalculator.myclasses.SavedElementsItems;
import com.leagueoflegendscalculator.myclasses.SetItemPicture;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ViewItemSetActivity extends ActionBarActivity {

	DatabaseHelper dbItem;
	List<SavedElementsItems> items;
	String[] itemID;
	String[] savedItemSet;
	Integer[] savedItemSetImage1;
	Integer[] savedItemSetImage2;
	Integer[] savedItemSetImage3;
	Integer[] savedItemSetImage4;
	Integer[] savedItemSetImage5;
	Integer[] savedItemSetImage6;
	ListView list;
	ClassCustomItemSetSaved dataAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_item_set);

		Intent getValue = getIntent();
		String itemSetName = getValue.getStringExtra("Item Set Name");
		String item1 = getValue.getStringExtra("Item 1");
		String item2 = getValue.getStringExtra("Item 2");
		String item3 = getValue.getStringExtra("Item 3");
		String item4 = getValue.getStringExtra("Item 4");
		String item5 = getValue.getStringExtra("Item 5");
		String item6 = getValue.getStringExtra("Item 6");
		

		dbItem = new DatabaseHelper(this);
		
        // Inserting Contacts //argument1 = itemsetname, argument2 = items
        dbItem.addItem(new SavedElementsItems(itemSetName, item1, item2, item3, item4, item5, item6));
         
        // Reading all contacts
        items = dbItem.getAllItems();
        
		   Collections.sort(items, new Comparator<SavedElementsItems>() {
		        @Override
		        public int compare(final SavedElementsItems object1, final SavedElementsItems object2) {
		            return object1.getName().compareTo(object2.getName());
		        }
		   });
        
        int i = items.size();

        itemID = new String[i];
		savedItemSet = new String[i];
		savedItemSetImage1 = new Integer[i];
		savedItemSetImage2 = new Integer[i];
		savedItemSetImage3 = new Integer[i];
		savedItemSetImage4 = new Integer[i];
		savedItemSetImage5 = new Integer[i];
		savedItemSetImage6 = new Integer[i];
        
		
		
		
        int j=0;
        for (SavedElementsItems listItem : items) {//runs a for loop for every member of the List called contacts
        	itemID[j] = Integer.toString(listItem.getID());
            savedItemSet[j] = listItem.getName();
            SetItemPicture itemImageObject = new SetItemPicture (listItem.getItem1(), listItem.getItem2(), listItem.getItem3(), listItem.getItem4(), listItem.getItem5(), listItem.getItem6());
            savedItemSetImage1[j] = itemImageObject.itemPicture[0];
            savedItemSetImage2[j] = itemImageObject.itemPicture[1];
            savedItemSetImage3[j] = itemImageObject.itemPicture[2];
            savedItemSetImage4[j] = itemImageObject.itemPicture[3];
            savedItemSetImage5[j] = itemImageObject.itemPicture[4];
            savedItemSetImage6[j] = itemImageObject.itemPicture[5];
            
            
            if (i == j+1){
            	break;
            }
            j++;
        }
        

        dataAdapter = new ClassCustomItemSetSaved(ViewItemSetActivity.this, itemID, savedItemSet, savedItemSetImage1, savedItemSetImage2, savedItemSetImage3, savedItemSetImage4, savedItemSetImage5, savedItemSetImage6);
	    list = (ListView)findViewById(R.id.listViewDisplaySavedItemSets);
		list.setAdapter(dataAdapter);
		

		list.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	
		    	//savedItemSet is the variable of the name given by the user to the set. This is different from itemID which is the name of the cell, which I defined to be the id of the object is saved
		    	if(savedItemSet[position] != " "){
		    		
			    	String idString = list.getItemAtPosition(position).toString(); 
			    	int idInt = Integer.parseInt(idString);
			    	
			    	String deletedItemSet = dbItem.getItem(idInt).getName();
			    	dbItem.deleteItem(dbItem.getItem(idInt));
	
			    	Toast.makeText(getApplicationContext(), "You deleted " + deletedItemSet, Toast.LENGTH_SHORT).show();	
			    	
			    	savedItemSet[position] = " ";
			    	savedItemSetImage1[position] = R.drawable.c_blank;
			    	savedItemSetImage2[position] = R.drawable.c_blank;
			    	savedItemSetImage3[position] = R.drawable.c_blank;
			    	savedItemSetImage4[position] = R.drawable.c_blank;
			    	savedItemSetImage5[position] = R.drawable.c_blank;
			    	savedItemSetImage6[position] = R.drawable.c_blank;
			    	
			    	dataAdapter = new ClassCustomItemSetSaved(ViewItemSetActivity.this, itemID, savedItemSet, savedItemSetImage1, savedItemSetImage2, savedItemSetImage3, savedItemSetImage4, savedItemSetImage5, savedItemSetImage6);
					list.setAdapter(dataAdapter);
		    	}
		    }
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_view_item_set, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_main_menu){
			backToMainMenu();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

			

	public void backToMainMenu(){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	
	
}
