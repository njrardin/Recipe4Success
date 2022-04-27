package it326.r4s.model;

import java.util.*;

/*
* A collection of meal, it can return all of its recipes or ingredients
* @author: Shu Liao (fliao@ilstu.edu)
* @date: 4/14/2022
*/

public class MealPlan extends Entity implements Portable {
    private String name;
    private String description;
    private List<Meal> meals;
    private Date createdOn;

    /**
     * Gets the ingredients required for all the recipes in this meal plan.
     * @return the collection of ingredients required.
     */
    public Collection<Ingredient> getAllIngredients() {
        Collection<Ingredient> allIngredients = new ArrayList<Ingredient>(); //ingredients to be returned
        for (Meal meal : this.meals) { // iterate through meals
            for (Ingredient ingredient : meal.getRecipe().getIngredientList().getIngredients()) { // iterate through meal ingredient
                
                boolean alreadyAdded = false;
                for (Ingredient existingIngredient : allIngredients) { // check if ingredient already exists
                    if (ingredient.getFoodItem() == existingIngredient.getFoodItem()) { // TODO - wait for FoodItem pool to more correctly handle this comparison!
                        allIngredients.remove(existingIngredient);
                        Ingredient copyIngredient = new Ingredient(existingIngredient.getFoodItem(), existingIngredient.getQuantity(), existingIngredient.getUnit());
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

    public MealPlan(String name) {
        this.meals = new ArrayList<Meal>();
        if (name == null || name.isEmpty()) {
            name = "default recipe";
        } else {
            this.name = name;
        }
        this.description = "";
    }

    public String getMealPlanName() {
        return this.name;
    }

    public String getMealPlanDescription() {
        return this.description;
    }

    public Date getMealPlanDate() {
        return (Date) this.createdOn.clone();
    }

    public void setMealPlanName(String inputName) {
        this.name = inputName;
    }

    public void setMealPlanDescription(String inputDes) {
        this.description = inputDes;
    }

    public boolean addMeal(Meal theMeal) {
        boolean added = meals.add(theMeal);
        return added;
    }

    public boolean removeMeal(Meal theMeal) {
        boolean removed = meals.remove(theMeal);
        return removed;
    }

    public boolean setMealServingSize(int servingSize) {
        for (Meal theMeal : meals) {
            theMeal.setServingSize(servingSize);
        }
        return true;
    }

    public List<Ingredient> getIngredients() {

        List<Ingredient> allIngredient = new ArrayList<>();

        for (Meal theMeal : meals) {
            allIngredient.addAll(theMeal.getRecipe().getIngredientList().getIngredients());
        }
        return allIngredient;
    }

    public Collection<Recipe> getRecipes() {
        List<Recipe> allRecipes = new ArrayList<>();
        for (Meal meal : meals) {
            allRecipes.add(meal.getRecipe());
        }
        return allRecipes;
    }

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

    @Override
    public String toString() {
        String temp = "";
        for (Meal meal : meals) {
            temp += meal.getRecipe().getName() + "\n";
        }
        return this.name + ":\nDescription: " + this.description + "\nMeals:\n" + temp;
    }

    public Date getCreatedOn() {
        return (Date) this.createdOn.clone();
    }
}
