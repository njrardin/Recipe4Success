package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import it326.r4s.model.*;
import it326.r4s.model.UnitConverter.Unit;

public class MealPlanTest {
    static MealPlan mainMealPlan;
    static Recipe recipe1, recipe2;
    static Meal meal1, meal2;
    static FoodItem.Pool fiPool = FoodItem.Pool.getInstance();

    @Before
    public void before() {

        recipe1 = new Recipe.RecipeBuilder("Mac and Cheese")
        .setDescription("A yummy meal!")
        .setServingSize(2)
        .setIngredientList(new IngredientList())
        .setReviews(new ArrayList<Review>())
        .setCategories(new ArrayList<Category>())
        .setInstructions(new ArrayList<String>())
        .build();
        FoodItem repeatFoodItem = fiPool.getFoodItem("Sugar");
        recipe1.addIngredient(new Ingredient(repeatFoodItem, 1, Unit.TABLESPOON));
        recipe1.addIngredient(new Ingredient(repeatFoodItem, 2, Unit.CUP));
        recipe2 = new Recipe.RecipeBuilder("Mac and Cheese")
        .setDescription("A yummy meal!")
        .setServingSize(2)
        .setIngredientList(new IngredientList())
        .setReviews(new ArrayList<Review>())
        .setCategories(new ArrayList<Category>())
        .setInstructions(new ArrayList<String>())
        .build();
        recipe2.addIngredient(new Ingredient(repeatFoodItem, 1, Unit.TEASPOON));
        recipe2.addIngredient(new Ingredient(repeatFoodItem, 3, Unit.POUND));
        meal1 = new Meal(recipe1);
        meal2 = new Meal(recipe2);

        mainMealPlan = new MealPlan("Main");
        mainMealPlan.addMeal(meal1);
        mainMealPlan.addMeal(meal2);
    }

    //ADD TestSetMealServingSize()

    //ADD TestGetRecipes()
    @Test
    public void testGetAllIngredients() {
        Collection<Ingredient> mealPlanIngredients = mainMealPlan.getAllIngredients();
        for (Ingredient ing : mealPlanIngredients) {
            String name = ing.getFoodItem().getName();
            double qty = ing.getQuantity();
            Unit unit = ing.getUnit();
            System.out.println(name + " - " + qty + " - " + unit);
        }
    }
}
