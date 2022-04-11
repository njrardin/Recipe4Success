package it326.r4s;

import java.util.*;

public class MealPlan extends Entity implements Categorizable, Exportable {
    private String name;
    private String description;
    private List<Meal> meals;
    private Date createdOn;

    /**
     * Gets the ingredients required for all the recipes in this meal plan.
     * @return the collection of ingredients required.
     */
    public Collection<Ingredient> getAllIngredients() {
        // TODO #11 - implement getAllIngredients (not easy)
        return null;
    }
    
    public MealPlan() {
        this.meals = new ArrayList<Meal>();
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

}
