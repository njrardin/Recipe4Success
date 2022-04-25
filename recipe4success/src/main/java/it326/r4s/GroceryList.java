package it326.r4s;

/**
 * The basic GroceryList class of the Recipes4Success application.
 * Essentially just holds an ingredientList object as the groceryList
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class GroceryList {
    private IngredientList ingredientList;

    public GroceryList() {
        ingredientList = new IngredientList();
    }

    public IngredientList getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the compared object is of correct type
        if (!(obj instanceof GroceryList) || obj == null) {
            return false;
        }
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }

        GroceryList otheGroceryList = (GroceryList) obj;
        return this.ingredientList.equals(otheGroceryList.getIngredientList());
    }

    @Override
    public String toString() {
        return this.ingredientList.toString();
    }
}