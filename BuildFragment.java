package com.leagueoflegendscalculator;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import android.widget.LinearLayout;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class BuildFragment extends Fragment{
	
	EditText buildNameText;
	Button saveButton;
	String buildName;
	
	  /** The view to show the ad. */
	  private AdView adView;

	  /* Your ad unit id. Replace with your actual ad unit id. */
	  private static final String AD_UNIT_ID = "ca-app-pub-2372477138407725/9004488695";



	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
        View rootView = inflater.inflate(R.layout.fragment_build, container, false);
    	buildNameText = (EditText)rootView.findViewById(R.id.BuildEditText);
    	
    	
 
        // Create an ad.
        adView = new AdView(getActivity());
        adView.setAdSize(AdSize.LARGE_BANNER);
        adView.setAdUnitId(AD_UNIT_ID);

        // Add the AdView to the view hierarchy. The view will have no size
        // until the ad is loaded.
        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.linearLayout);
        layout.addView(adView);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device.
        AdRequest adRequest = new AdRequest.Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE")
            .build();

        // Start loading the ad in the background.
        adView.loadAd(adRequest); 


    	
    	// ONCLICK LISTENER FOR THE SAVE BUTTON
        // Can't be done in XML, same with the ad
    	saveButton = (Button) rootView.findViewById(R.id.save_button);
    	saveButton.setOnClickListener(new OnClickListener()
        {
          public void onClick(View v)
          {
             save();
          }
        });

        return rootView;
    }
    
    
    
    @Override
    public void onResume() {
      super.onResume();
      if (adView != null) {
        adView.resume();
      }
    }

    @Override
    public void onPause() {
      if (adView != null) {
        adView.pause();
      }
      super.onPause();
    }

    /** Called before the activity is destroyed. */
    @Override
    public void onDestroy() {
      // Destroy the AdView.
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }

    
    
    

    
	public void save(){
		
		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
		Editor prefsEditor = appSharedPrefs.edit();
		
		//saves the build name
		prefsEditor.putString("Build Name", buildNameText.getText().toString());
		prefsEditor.commit();
		
		//loads the rest of the saved info - champion, items, masteries, runes
		String championTest = appSharedPrefs.getString("ChampionState", "");
		String itemTest = appSharedPrefs.getString("ItemState", "");
		String masteryTest = appSharedPrefs.getString("MasteryState", "");
		String runeTest = appSharedPrefs.getString("RuneState", "");
		String buildNameTest = appSharedPrefs.getString("Build Name", "");
		
		if(!championTest.equals("Select a Champion") && !itemTest.equals("Select an Item Set") && !masteryTest.equals("Select a Mastery Page") && !runeTest.equals("Select a Rune Page") && !buildNameTest.equals("")){
			Intent intent = new Intent(getActivity(), ViewBuildActivity.class);
			startActivity(intent);
		}
		else{
			Toast.makeText(getActivity(), "You still need to complete at least one of the following: Select a Champion, Item Set, Mastery Page, Rune Page, or Build Name", Toast.LENGTH_LONG).show();
			//Toast.makeText(getActivity(), championTest + itemTest +masteryTest + runeTest+buildNameTest, Toast.LENGTH_LONG).show();
		}
	}
}

