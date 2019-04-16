package com.leagueoflegendscalculator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.leagueoflegendscalculator.adapter.ClassCustomItemSetSaved;
import com.leagueoflegendscalculator.myclasses.SavedElementsItems;
import com.leagueoflegendscalculator.myclasses.SetItemPicture;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 
public class ItemFragment extends Fragment {
	
	
	List<SavedElementsItems> items;
	String[] itemID;
	String[] savedItemSet;
	Integer[] savedItemSetImage1;
	Integer[] savedItemSetImage2;
	Integer[] savedItemSetImage3;
	Integer[] savedItemSetImage4;
	Integer[] savedItemSetImage5;
	Integer[] savedItemSetImage6;
    ListView listViewItem;
    TextView textItem;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_item, container, false);
        
        listViewItem = (ListView) rootView.findViewById (R.id.listViewItem);
        textItem = (TextView) rootView.findViewById (R.id.ItemText);
        createItemList();
        ClassCustomItemSetSaved dataAdapter2 = new ClassCustomItemSetSaved(getActivity(), itemID, savedItemSet, savedItemSetImage1, savedItemSetImage2, savedItemSetImage3, savedItemSetImage4, savedItemSetImage5, savedItemSetImage6);
        listViewItem.setAdapter(dataAdapter2);
        
        
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        Editor prefsEditor = appSharedPrefs.edit();
        if (textItem.getText().toString().equals("Select an Item Set")){
        	prefsEditor.putString("ItemState", textItem.getText().toString());//may have to put this into an if statement like if(textChampion.getText().equal("Select a champion")
        }
    	prefsEditor.commit();

        
        listViewItem.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	DatabaseHelper dbItem = new DatabaseHelper(getActivity());

		    	int idOfSelection = Integer.parseInt(listViewItem.getItemAtPosition(position).toString());
		    	String ItemSelection = dbItem.getItem(idOfSelection).getName();

		    	SavedElementsItems obj = new SavedElementsItems(dbItem.getItem(idOfSelection).getName(), dbItem.getItem(idOfSelection).getItem1(), dbItem.getItem(idOfSelection).getItem2(), dbItem.getItem(idOfSelection).getItem3(), dbItem.getItem(idOfSelection).getItem4(), dbItem.getItem(idOfSelection).getItem5(), dbItem.getItem(idOfSelection).getItem6());

		    	//dbItem.close();
		    	
		    	textItem.setText(ItemSelection); 
		    	Toast.makeText(getActivity(), "You selected:\n" + ItemSelection, Toast.LENGTH_SHORT).show();
		    	
		    	SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
		    	Editor prefsEditor = appSharedPrefs.edit();
		    	Gson gson = new Gson();
		    	String json = gson.toJson(obj);
		    	prefsEditor.putString("Item Set", json);
		    	prefsEditor.putString("ItemState", textItem.getText().toString());
		    	prefsEditor.commit();	
		    	
		    }
		});
        
        
        
         
        return rootView;
    }
    
    public void createItemList(){
    	DatabaseHelper dbItem = new DatabaseHelper(getActivity());
    	
        items = dbItem.getAllItems();   

        //dbItem.close();
        
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
            SetItemPicture itemPictureObject = new SetItemPicture(listItem.getItem1(), listItem.getItem2(), listItem.getItem3(), listItem.getItem4(), listItem.getItem5(), listItem.getItem6());
            savedItemSetImage1[j] = itemPictureObject.itemPicture[0];
            savedItemSetImage2[j] = itemPictureObject.itemPicture[1];
            savedItemSetImage3[j] = itemPictureObject.itemPicture[2];
            savedItemSetImage4[j] = itemPictureObject.itemPicture[3];
            savedItemSetImage5[j] = itemPictureObject.itemPicture[4];
            savedItemSetImage6[j] = itemPictureObject.itemPicture[5];
            
            
            if (i == j+1){
            	break;
            }
            j++;
        }
    }
}
