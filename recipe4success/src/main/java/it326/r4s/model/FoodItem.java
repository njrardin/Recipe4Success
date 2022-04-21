package it326.r4s.model;

/*
* TODO #4 - whoever implemented this class needs to write a header description.
* See User.java for good header examples
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
