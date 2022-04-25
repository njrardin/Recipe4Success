package it326.r4s;

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
    
    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }
        // Check if the compared object is of correct type
        if (!(obj instanceof User)) {
            return false;
        }

        FoodItem otherFoodItem = (FoodItem) obj;
        return this.name.equals(otherFoodItem.getName()) && ID == otherFoodItem.getID();
    }

    @Override
    public String toString() {
        return "FoodItem number " + ID + ": " + this.name;
    }
}
