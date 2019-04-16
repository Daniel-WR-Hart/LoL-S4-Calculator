package com.leagueoflegendscalculator.myclasses;


public class SavedElementsBuilds {

    //private variables
	int _id;
    String _name;
    String championInputString;
    String itemInputString;
    String masteryInputString;
    String runeInputString;
    
    //use these variables to sort the builds by champion name and dps in SavedBuildsActivity
    public String champName;
    public double dps;
    
     
    // Empty constructor
    public SavedElementsBuilds(){
    }
    
    public SavedElementsBuilds(int id, String _name, String championInputString, String itemInputString, String masteryInputString, String runeInputString){
        this._id = id;
        this._name = _name;
        this.championInputString = championInputString;
        this.itemInputString = itemInputString;
        this.masteryInputString = masteryInputString;
        this.runeInputString = runeInputString;
        
    }
     
    public SavedElementsBuilds(String _name, String championInputString, String itemInputString, String masteryInputString, String runeInputString){
        this._name = _name;
        this.championInputString = championInputString;
        this.itemInputString = itemInputString;
        this.masteryInputString = masteryInputString;
        this.runeInputString = runeInputString;
            }
    
    public int getID(){
        return this._id;
    }
     
    public void setID(int id){
        this._id = id;
    }
     
    public String getName(){
        return this._name;
    }
     
    public void setName(String name){
        this._name = name;
    }
     
    public String getChampionInputString(){
        return this.championInputString;
    }
     
    public void setChampionInputString(String championInputString){
        this.championInputString = championInputString;
    }
    
    public String getItemInputString(){
        return this.itemInputString;
    }
     
    public void setItemInputString(String itemInputString){
        this.itemInputString = itemInputString;
    }
    
    public String getMasteryInputString(){
        return this.masteryInputString;
    }
     
    public void setMasteryInputString(String masteryInputString){
        this.masteryInputString = masteryInputString;
    }
    
    public String getRuneInputString(){
        return this.runeInputString;
    }
     
    public void setRuneInputString(String runeInputString){
        this.runeInputString = runeInputString;
    }
    
    
}
