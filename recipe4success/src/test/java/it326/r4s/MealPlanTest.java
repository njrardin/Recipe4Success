package it326.r4s;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it326.r4s.UnitConverter.Unit;

import java.util.ArrayList;
import java.util.Collection;

public class MealPlanTest {
    static MealPlan mainMealPlan;
    static Recipe recipe1, recipe2;
    static Meal meal1, meal2;

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
        FoodItem repeatFoodItem = new FoodItem("Egg");
        recipe1.addIngredient(new Ingredient(repeatFoodItem, 4, Unit.CUP));
        recipe1.addIngredient(new Ingredient(new FoodItem(), 2, Unit.TEASPOON));
        recipe2 = new Recipe.RecipeBuilder("Mac and Cheese")
        .setDescription("A yummy meal!")
        .setServingSize(2)
        .setIngredientList(new IngredientList())
        .setReviews(new ArrayList<Review>())
        .setCategories(new ArrayList<Category>())
        .setInstructions(new ArrayList<String>())
        .build();
        recipe2.addIngredient(new Ingredient(repeatFoodItem, 1, Unit.CUP));
        recipe2.addIngredient(new Ingredient(new FoodItem(), 3, Unit.POUND));
        meal1 = new Meal(recipe1, 4);
        meal2 = new Meal(recipe2, 2);

        mainMealPlan = new MealPlan("Main");
        mainMealPlan.addMeal(meal1);
        mainMealPlan.addMeal(meal2);
    }

    @Test
    public void testGetAllIngredients() {
        Collection<Ingredient> mealPlanIngredients = mainMealPlan.getAllIngredients();
        for (Ingredient ing : mealPlanIngredients) {
            String name = ing.getFoodItem().getName();
            double qty = ing.getQuantity();
            System.out.println(name + " - " + qty);
        }
    }
}
