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
    public boolean equals(GroceryList otheGroceryList) {
        return this.ingredientList.equals(otheGroceryList.getIngredientList());
    }

    @Override
    public String toString() {
        return this.ingredientList.toString();
    }
}