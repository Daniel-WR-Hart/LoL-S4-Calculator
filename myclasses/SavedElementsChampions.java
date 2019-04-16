package com.leagueoflegendscalculator.myclasses;

public class SavedElementsChampions {
    
    //private variables
	int _id;
    String _name;
    String _level;
    String _qskill;
    String _wskill;
    String _eskill;
    String _rskill;
    
     
    // Empty constructor
    public SavedElementsChampions(){
    }
    
    public SavedElementsChampions(int id, String _name, String _level, String _qskill, String _wskill, String _eskill, String _rskill){
        this._id = id;
        this._name = _name;
        this._level = _level;
        this._qskill = _qskill;
        this._wskill = _wskill;
        this._eskill = _eskill;
        this._rskill = _rskill;
        
    }
     
    public SavedElementsChampions(String _name, String _level, String _qskill, String _wskill, String _eskill, String _rskill){
        this._name = _name;
        this._level = _level;
        this._qskill = _qskill;
        this._wskill = _wskill;
        this._eskill = _eskill;
        this._rskill = _rskill;
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
     
    public String getLevel(){
        return this._level;
    }
     
    public void setLevel(String level){
        this._level = level;
    }
    
    public String getQSkill(){
        return this._qskill;
    }
     
    public void setQSkill(String qskill){
        this._qskill = qskill;
    }
    
    public String getWSkill(){
        return this._wskill;
    }
     
    public void setWSkill(String wskill){
        this._wskill = wskill;
    }
    
    public String getESkill(){
        return this._eskill;
    }
     
    public void setESkill(String eskill){
        this._eskill = eskill;
    }
    
    public String getRSkill(){
        return this._rskill;
    }
     
    public void setRSkill(String rskill){
        this._rskill = rskill;
    }
    
    
    
    
    
    
    
}