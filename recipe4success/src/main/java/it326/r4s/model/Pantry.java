package it326.r4s.model;

/**
 * The basic Pantry class of the Recipes4Success application.
 * Essentially just holds an ingredientList object as the pantry
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
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