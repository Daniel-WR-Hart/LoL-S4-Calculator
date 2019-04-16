package com.leagueoflegendscalculator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leagueoflegendscalculator.adapter.ClassCustomChampSaved;
import com.leagueoflegendscalculator.myclasses.SavedElementsChampions;
import com.leagueoflegendscalculator.myclasses.SetChampionPicture;

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

public class ViewChampionActivity extends ActionBarActivity { 
	
	DatabaseHelper dbChamp;
	List<SavedElementsChampions> champions;
	String[] championID;
	String[] savedChampion;
	Integer[] savedChampionImage;
	ListView list;
	ClassCustomChampSaved dataAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_champion);

		Intent getValue = getIntent();
		//ClassChampion champion = (ClassChampion)getValue.getSerializableExtra("Champion");
		
		byte byteHolder = 0;
		
		String name = getValue.getStringExtra("Name");
		String level = String.valueOf(getValue.getByteExtra("level",byteHolder));//String.valueOf(int) and Integer.toString(int) do the same thing?
		String qskill = String.valueOf(getValue.getByteExtra("qskill",byteHolder));
		String wskill = String.valueOf(getValue.getByteExtra("wskill",byteHolder));
		String eskill = String.valueOf(getValue.getByteExtra("eskill",byteHolder));
		String rskill = String.valueOf(getValue.getByteExtra("rskill",byteHolder));
		
		dbChamp = new DatabaseHelper(this);
		
		dbChamp.addChampion(new SavedElementsChampions(name, level, qskill, wskill, eskill, rskill));
		
		champions = dbChamp.getAllChampions();   
		
		   Collections.sort(champions, new Comparator<SavedElementsChampions>() {
		        @Override
		        public int compare(final SavedElementsChampions object1, final SavedElementsChampions object2) {
		            return object1.getName().compareTo(object2.getName());
		        }
		   });
		
        int i = champions.size();
        championID = new String[i];
		savedChampion = new String[i];
		savedChampionImage = new Integer[i];
        
        int j=0;
        for (SavedElementsChampions listChamp : champions) {//runs a for loop for every member of the List called contacts
        	championID[j] = Integer.toString(listChamp.getID());
            savedChampion[j] = listChamp.getName() + ", Level " + listChamp.getLevel() + "\nQ/W/E/R = " + listChamp.getQSkill() +"/"+ listChamp.getWSkill() +"/"+ listChamp.getESkill() +"/"+ listChamp.getRSkill();
            SetChampionPicture championPictureObject = new SetChampionPicture(listChamp.getName());
            savedChampionImage[j] = championPictureObject.championPicture;
            if (i == j+1){
            	break;
            }
            j++;
        }
        
        
        dataAdapter = new ClassCustomChampSaved(ViewChampionActivity.this, championID, savedChampion, savedChampionImage);
	    list = (ListView)findViewById(R.id.listViewDisplaySavedChamps);
		list.setAdapter(dataAdapter);

					
		
		list.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		    	if(savedChampion[position] != " "){
		    		//turn the name of the cell into an integer
			    	String idString = list.getItemAtPosition(position).toString(); 
			    	int idInt = Integer.parseInt(idString);
			    	
			    	//save the cell info of the cell to be deleted, then delete it
			    	String deletedChampion = dbChamp.getChampion(idInt).getName() + ", Level " + dbChamp.getChampion(idInt).getLevel() + "\nQ/W/E/R = " + dbChamp.getChampion(idInt).getQSkill() +"/"+ dbChamp.getChampion(idInt).getWSkill() +"/"+ dbChamp.getChampion(idInt).getESkill() +"/"+ dbChamp.getChampion(idInt).getRSkill();
			    	dbChamp.deleteChampion(dbChamp.getChampion(idInt));
	
			    	//make a temporary message saying that the cell was deleted
			    	Toast.makeText(getApplicationContext(), "You deleted " + deletedChampion, Toast.LENGTH_SHORT).show();
			    	
			    	//erase the info on the cell associated with the deleted info
			    	savedChampion[position] = " ";
			    	savedChampionImage[position] = R.drawable.c_blank;
			    	
			    	//rebuild the ListView to show the changes in cell info
			    	dataAdapter = new ClassCustomChampSaved(ViewChampionActivity.this, championID, savedChampion, savedChampionImage);
					list.setAdapter(dataAdapter);
		    	}
		    }
		});
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_view_champion, menu);
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
