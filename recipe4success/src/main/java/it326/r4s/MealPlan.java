package it326.r4s;

import java.util.*;

/*
* A collection of meal, it can return all of its recipes or ingredients
* @author: Shu Liao (fliao@ilstu.edu)
* @date: 4/14/2022
*/

public class MealPlan extends Entity implements Categorizable, Exportable {
    private String name;
    private String description;
    private List<Meal> meals;
    private Date createdOn;

    /**
     * Gets the ingredients required for all the recipes in this meal plan.
     * TODO NOTE 4/15 - This does not yet handle combining ingredients that have the same fooditem BUT different units
     * @return the collection of ingredients required.
     */
    public Collection<Ingredient> getAllIngredients() {
        Collection<Ingredient> allIngredients = new ArrayList<Ingredient>(); //ingredients to be returned
        for (Meal meal : this.meals) { // iterate through meals
            for (Ingredient ingredient : meal.getRecipe().getIngredientList().getIngredients()) { // iterate through meal ingredient
                
                boolean alreadyAdded = false;
                for (Ingredient existingIngredient : allIngredients) { // check if ingredient already exists
                    if (ingredient.getFoodItem() == existingIngredient.getFoodItem()) {
                        allIngredients.remove(existingIngredient);
                        double newQuantity = existingIngredient.getQuantity() + ingredient.getQuantity();
                        Ingredient updatedIngredient = new Ingredient(existingIngredient.getFoodItem(), newQuantity, existingIngredient.getUnit());
                        allIngredients.add(updatedIngredient);
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

}
