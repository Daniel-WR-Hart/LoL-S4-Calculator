package com.leagueoflegendscalculator.myclasses;


public class SavedElementsItems {
	 //private variables
    int _id;
    public String itemSetName;
    public String _item1;
    public String _item2;
    public String _item3;
    public String _item4;
    public String _item5;
    public String _item6;
    
     
    // Empty constructor
    public SavedElementsItems(){
    }
    
    public SavedElementsItems(int id, String itemSetName, String _item1, String _item2, String _item3, String _item4, String _item5, String _item6){
        this._id = id;
        this.itemSetName = itemSetName;
        this._item1 = _item1;
        this._item2 = _item2;
        this._item3 = _item3;
        this._item4 = _item4;
        this._item5 = _item5;
        this._item6 = _item6;

        
    }
     
    public SavedElementsItems(String itemSetName, String _item1, String _item2, String _item3, String _item4, String _item5, String _item6){
        this.itemSetName = itemSetName;
        this._item1 = _item1;
        this._item2 = _item2;
        this._item3 = _item3;
        this._item4 = _item4;
        this._item5 = _item5;
        this._item6 = _item6;
            }
    
    public int getID(){
        return this._id;
    }
     
    public void setID(int id){
        this._id = id;
    }
     
    public String getName(){
        return this.itemSetName;
    }
     
    public void setName(String itemSetName){
        this.itemSetName = itemSetName;
    }
     
    public String getItem1(){
        return this._item1;
    }
     
    public void setItem1(String item1){
        this._item1= item1;
    }
    
    public String getItem2(){
        return this._item2;
    }
     
    public void setItem2(String item2){
        this._item2= item2;
    }
    
    public String getItem3(){
        return this._item3;
    }
     
    public void setItem3(String item3){
        this._item3= item3;
    }
    
    public String getItem4(){
        return this._item4;
    }
     
    public void setItem4(String item4){
        this._item4= item4;
    }
    
    public String getItem5(){
        return this._item5;
    }
     
    public void setItem5(String item5){
        this._item5= item5;
    }
    
    public String getItem6(){
        return this._item6;
    }
     
    public void setItem6(String item6){
        this._item6= item6;
    }
    
     
    
    
    
}

