package it326.r4s;

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
