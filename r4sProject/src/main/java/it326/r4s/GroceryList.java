package it326.r4s;

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
}