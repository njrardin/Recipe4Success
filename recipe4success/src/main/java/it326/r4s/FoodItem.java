package it326.r4s;

/*
* ADD HEADER HERE
* 
* 
*/

public class FoodItem extends Entity {
    private String name;
    private static int ID = 0;

    // constructors
    public FoodItem() {
        super();
        this.name = "FoodItem_" + ++ID;
    }

    public FoodItem(String name) {
        super();
        this.name = name;
        ID++;
    }

    // getters
    public String getName() { return this.name; }

    public int getID() { return ID; }
    
}
