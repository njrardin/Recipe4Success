package it326.r4s;

import java.util.*;

/*
* A collection of meal, it can return all of its recipes or ingredients
* @author: Shu Liao (fliao@ilstu.edu)
* @date: 4/14/2022
*/

public class MealPlan extends Entity implements Categorizable, Portable {
    // *Instance Variables*\\
    private String name;
    private String description;
    private List<Meal> meals;
    private Date createdOn;

    // *Constructor*\\
    /**
     * Creates a MealPlan object with a specified name.
     * 
     * @param name the name of the MealPlan.
     */
    public MealPlan(String name) {
        this.meals = new ArrayList<Meal>();
        if (name == null || name.isEmpty()) {
            name = "default recipe";
        } else {
            this.name = name;
        }
        this.description = "";
    }

    // *Methods*\\
    /**
     * Gets the MealPlan's name.
     * 
     * @return the name of the MealPlan.
     */
    public String getMealPlanName() {
        return this.name;
    }

    /**
     * Gets the MealPlan's description.
     * 
     * @return the description of the MealPlan.
     */
    public String getMealPlanDescription() {
        return this.description;
    }

    /**
     * Gets the MealPlan's create date.
     * 
     * @return the create date of the MealPlan.
     */
    public Date getMealPlanDate() {
        return (Date) this.createdOn.clone();
    }

    /**
     * Sets the MealPlan's name.
     * 
     * @param inputName the new name of the MealPlan.
     */
    public void setMealPlanName(String inputName) {
        this.name = inputName;
    }

    /**
     * Sets the MealPlan's description.
     * 
     * @param inputDes the new description of the MealPlan.
     */
    public void setMealPlanDescription(String inputDes) {
        this.description = inputDes;
    }

    /**
     * Attempts to add a meal to the MealPlan.
     * 
     * @param theMeal the meal to be added.
     * @return true if theMeal is sucessfully add to the MealPlan, false otherwise.
     */
    public boolean addMeal(Meal theMeal) {
        boolean added = meals.add(theMeal);
        return added;
    }

    /**
     * Attempts to remove a meal from the MealPlan.
     * 
     * @param theMeal the meal to be removed.
     * @return true if theMeal is successfully remove from the MealPlan, false
     *         otherwise.
     */
    public boolean removeMeal(Meal theMeal) {
        boolean removed = meals.remove(theMeal);
        return removed;
    }

    /**
     * Sets the meals' serving size.
     * 
     * @param servingSize the new serving size of the meals.
     * @return true .
     */
    public boolean setMealServingSize(int servingSize) {
        for (Meal theMeal : meals) {
            theMeal.setServingSize(servingSize);
        }
        return true;
    }

    /**
     * Gets the ingredients of the MealPlan.
     * 
     * @return a collection of ingredients.
     */
    public List<Ingredient> getIngredients() {

        List<Ingredient> allIngredient = new ArrayList<>();

        for (Meal theMeal : meals) {
            allIngredient.addAll(theMeal.getRecipe().getIngredientList().getIngredients());
        }
        return allIngredient;
    }

    /**
     * Gets the recipes of the MealPlan.
     * 
     * @return a collection of recipes.
     */
    public Collection<Recipe> getRecipes() {
        List<Recipe> allRecipes = new ArrayList<>();
        for (Meal meal : meals) {
            allRecipes.add(meal.getRecipe());
        }
        return allRecipes;
    }

    /**
     * Gets the ingredients required for all the recipes in this meal plan.
     * 
     * @return the collection of ingredients required.
     */
    public Collection<Ingredient> getAllIngredients() {
        Collection<Ingredient> allIngredients = new ArrayList<Ingredient>(); // ingredients to be returned
        for (Meal meal : this.meals) { // iterate through meals
            for (Ingredient ingredient : meal.getRecipe().getIngredientList().getIngredients()) { // iterate through
                                                                                                  // meal ingredient

                boolean alreadyAdded = false;
                for (Ingredient existingIngredient : allIngredients) { // check if ingredient already exists
                    if (ingredient.getFoodItem() == existingIngredient.getFoodItem()) { // TODO - wait for FoodItem pool
                                                                                        // to more correctly handle this
                                                                                        // comparison!
                        allIngredients.remove(existingIngredient);
                        Ingredient copyIngredient = new Ingredient(existingIngredient.getFoodItem(),
                                existingIngredient.getQuantity(), existingIngredient.getUnit());
                        if (!copyIngredient.changeUnit(ingredient.getUnit())) {
                            allIngredients.add(copyIngredient);
                            break;
                        }
                        copyIngredient.setQuantity(copyIngredient.getQuantity() + ingredient.getQuantity());
                        allIngredients.add(copyIngredient);
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    allIngredients.add(ingredient);
                }
            }
        }
        return allIngredients;
    }

    /**
     * An override for the .equals method of java.obj.
     * 
     * @param obj a MealPlan object.
     *            private String name;
     *            private String description;
     *            private List<Meal> meals;
     *            private Date createdOn;
     * 
     * @return true if two MealPlan objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MealPlan)) {
            return false;
        }
        MealPlan other = (MealPlan) obj;
        if (!this.getMealPlanName().equals(other.getMealPlanName())) {
            return false;
        }
        if (!this.getMealPlanDescription().equals(other.getMealPlanDescription())) {
            return false;
        }
        if (!this.getMealPlanDate().equals(other.getMealPlanDate())) {
            return false;
        }
        if (!this.getRecipes().equals(other.getRecipes())) {
            return false;
        }
        return true;
    }

    /**
     * An override for the .toString method of java.obj.
     * 
     * @return a string representation of the MealPlan object.
     */
    @Override
    public String toString() {
        String temp = "";
        for (Meal meal : meals) {
            temp += meal.getRecipe().getName() + "\n";
        }
        return this.name + ":\nDescription: " + this.description + "\nMeals:\n" + temp;
    }
}
