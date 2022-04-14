package it326.r4s;

/*
* TODO - whoever implemented this class needs to write a header description.
* See User.java for good header examples
* 
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
