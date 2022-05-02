package it326.r4s.model;

/*
* The Meal object class for Recipe4Success application
* A Meal holds a recipe and its serving size
* @author: Shu Liao (fliao@ilstu.edu) and Zach Plattner
* @date: 4/14/2022
*/

public class Meal {
    // *Instance Variables*\\
    private Recipe recipe;
    private int servingSize;
    private IngredientList ingredientList;

    // *Constructor*\\
    /**
     * Creates a Meal object with specified recipe, serving size, and ingredient list.
     * 
     * @param recipe the recipe of the Meal.
     */
    public Meal(Recipe recipe) {
        this.recipe = recipe;
        this.servingSize = recipe.getServingSize();
        this.ingredientList = new IngredientList(recipe.getIngredientList());
    }

    // *Methods*\\
    /**
     * Gets the Meal's recipe.
     * 
     * @return the recipe of the Meal.
     */
    public Recipe getRecipe() {
        return this.recipe;
    }

    /**
     * Sets the Meal's recipe.
     * 
     * @param recipe the new recipe of the Meal.
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    /**
     * Gets the Meal's serving size.
     * 
     * @return the serving size of the Meal.
     */
    public int getServingSize() {
        return this.servingSize;
    }

    /**
     * adjusts the quantities of all ingredients in the list to reflect the new serving size of this meal
     * @param newServingSize
     */
    public void adjustServingSize(int newServingSize) {
        int oldServingSize = this.servingSize;
        for(Ingredient ingredient: ingredientList.getIngredients()){
            double newQuantity = ((double) newServingSize / (double) oldServingSize) * ingredient.getQuantity();
            ingredient.setQuantity(newQuantity);
        }
        this.servingSize = newServingSize;
    }

    /**
     * Gets the Meal's ingredientlist.
     * 
     * @return the ingredientlist of the Meal.
     */
    public IngredientList getIngredientList() {
        return this.ingredientList;
    }

    /**
     * Sets the Meal's ingredientlist.
     * 
     * @param ingredientList the new ingredientlist of the Meal.
     */
    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }

    /**
     * An override for the .equals method of java.obj.
     * 
     * @param obj a Meal object
     *            private Recipe recipe;
     *            private int servingSize;
     * @return true if two Meal objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        // Check if the compared object is of correct type
        if (!(obj instanceof Meal) || obj == null) {
            return false;
        }
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }

        Meal otherMeal = (Meal) obj;
        return this.recipe.equals(otherMeal.getRecipe()) && this.servingSize == otherMeal.getServingSize();
    }

    /**
     * An override for the .toString method of java.obj.
     * 
     * @return a string representation of the Meal object.
     */
    @Override
    public String toString() {
        return "Recipe: " + this.recipe.getName();
    }
}
