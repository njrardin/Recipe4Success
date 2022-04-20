package it326.r4s;

/*
* The Meal object class for Recipe4Success application
* A Meal holds a recipe and its serving size
* @author: Shu Liao (fliao@ilstu.edu)
* @date: 4/14/2022
*/

public class Meal {
    
    private Recipe recipe;
    private int servingSize;

    public Meal(Recipe recipe, int servingSize){
        this.recipe = recipe;
        this.servingSize = servingSize;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getServingSize() {
        return this.servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

}
