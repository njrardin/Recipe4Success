package it326.r4s.model;

import java.util.*;

/*
* A collection of meal, it can return all of its recipes or ingredients
* @author: Shu Liao (fliao@ilstu.edu) and Zach Plattner (zmplatt@ilstu.edu)
* @date: 4/14/2022
*/

public class MealPlan extends Entity implements Portable {
    private String name;
    private String description;
    private Collection<Meal> meals;
    private Date createdOn;
    private int mpServingSize = 0;

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
        this.createdOn = new Date();
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
     * Gets the MealPlan's collection of meals.
     * 
     * @return the collection of meals.
     */
    public Collection<Meal> getMeals() {
        return this.meals;
    }

    /**
     * Gets the MealPlan's create date.
     * 
     * @return the create date of the MealPlan.
     */
    public Date getMealPlanDate() {
        return (Date) this.createdOn.clone();
    }

    public int getMPServingSize() {
        return this.mpServingSize;
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
     * @return true if theMeal is successfully add to the MealPlan, false otherwise.
     */
    public boolean addMeal(Meal theMeal) {
        return meals.add(theMeal);
    }

    /**
     * Attempts to remove a meal from the MealPlan.
     * 
     * @param theMeal the meal to be removed.
     * @return true if theMeal is successfully remove from the MealPlan, false
     *         otherwise.
     */
    public boolean removeMeal(Meal theMeal) {
        return meals.remove(theMeal);
    }

    /**
     * Attempts to remove a meal from the MealPlan.
     * 
     * @param theRecipe the recipe whose meal is to be removed.
     * @return true if theMeal is successfully removed from the MealPlan, false
     *         otherwise.
     */
    public boolean removeMeal(Recipe theRecipe) {
        for (Meal meal : meals) {
            if (meal.getRecipe().equals(theRecipe)) {
                return removeMeal(meal);
            }
        }
        return false;
    }

    /**
     * Sets the meals' serving size.
     * 
     * @param servingSize the new serving size of the meals.
     * @return true .
     */
    public boolean setMealServingSize(int servingSize) {
        this.mpServingSize = servingSize;
        for (Meal theMeal : meals) {
            theMeal.adjustServingSize(servingSize);
        }
        return true;
    }

    /**
     * Gets the ingredients of the the Meal.
     * 
     * @return a collection of ingredients.
     */
    public IngredientList getIngredients(Meal theMeal) {
        IngredientList mealIngredient;
        mealIngredient = theMeal.getRecipe().getIngredientList();
        return mealIngredient;
    }

    /**
     * Gets the recipes of the MealPlan.
     * 
     * @return a collection of recipes.
     */
    public Collection<Recipe> getRecipes() {
        Collection<Recipe> allRecipes = new ArrayList<>();
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
            for (Ingredient ingredient : meal.getIngredientList().getIngredients()) { // iterate through meal ingredient

                boolean alreadyAdded = false;
                for (Ingredient existingIngredient : allIngredients) { // check if ingredient already exists
                    if (ingredient.getFoodItem().equals(existingIngredient.getFoodItem())) {
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

        MealPlan otherMealPlan = (MealPlan) obj;
        if (!this.getMealPlanName().equals(otherMealPlan.getMealPlanName())) {
            return false;
        }
        if (!this.getMealPlanDescription().equals(otherMealPlan.getMealPlanDescription())) {
            return false;
        }
        if (!this.getRecipes().equals(otherMealPlan.getRecipes())) {
            return false;
        }
        return true;
    }

    /**
     * An override for the .toString method of java.obj.
     * @return a string representation of the MealPlan object.
     */
    @Override
    public String toString() {
        return "Name: " + getMealPlanName() + "\n" +
            "Description: " + getMealPlanDescription() + "\n" +
            "Created on: " + getMealPlanDate() + "\n" +
            "Serving size: " + getMPServingSize() + "\n" +
            "Meals: \n" + getMeals() + "\n";
    }
}
