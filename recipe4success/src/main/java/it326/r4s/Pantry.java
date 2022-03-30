package it326.r4s;

public class Pantry {
    private IngredientList ingredientList;

    public Pantry() {
        ingredientList = new IngredientList();
    }

    public IngredientList getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }
}