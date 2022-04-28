package it326.r4s.model;

/*
* The Meal object class for Recipe4Success application
* A Meal holds a recipe and its serving size
* @author: Shu Liao (fliao@ilstu.edu)
* @date: 4/14/2022
*/

public class Meal {
    // *Instance Variables*\\
    private Recipe recipe;
    private int servingSize;

    // *Constructor*\\
    /**
     * Creates a Meal object with specified recipe and serving size.
     * 
     * @param recipe      the recipe of the Meal.
     * @param servingSize the serving size of the Meal.
     */
    public Meal(Recipe recipe, int servingSize) {
        this.recipe = recipe;
        this.servingSize = servingSize;
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
     * Sets the Meal's serving size.
     * 
     * @param servingSize the new serving size of the Meal.
     */
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
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
        return "Recipe:\n" + this.recipe.getName() + "\nServing Size: " + this.servingSize;
    }
}
