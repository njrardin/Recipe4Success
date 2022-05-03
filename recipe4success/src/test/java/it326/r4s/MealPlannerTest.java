package it326.r4s;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it326.r4s.model.*;
import it326.r4s.model.UnitConverter.Unit;

public class MealPlannerTest {
    private static MealPlanner theMealPlanner;
    private static MealPlan mealPlan1;
    private static MealPlan mealPlan2;
    private static MealPlan mealPlan3;
    private static Recipe recipe1, recipe2;
    private static Meal meal1, meal2;
    private static FoodItem.Pool pool = FoodItem.Pool.getInstance();

    @Before
    public void setUp() {
        recipe1 = new Recipe.RecipeBuilder("Mac and Cheese")
                .setDescription("A yummy meal!")
                .setServingSize(2)
                .setIngredientList(new IngredientList())
                .setReviews(new ArrayList<Review>())
                .setCategories(new ArrayList<Category>())
                .setInstructions(new ArrayList<String>())
                .build();

        FoodItem repeatFoodItem = pool.getFoodItem("Sugar");
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

        mealPlan1 = new MealPlan("Meal Plan one");
        mealPlan1.addMeal(meal1);
        mealPlan1.addMeal(meal2);

        mealPlan2 = new MealPlan("Meal Plan two");
        mealPlan2.addMeal(meal1);
        mealPlan2.addMeal(meal2);

        mealPlan3 = new MealPlan("Meal Plan three");
        mealPlan3.addMeal(meal1);
        mealPlan3.addMeal(meal2);

        theMealPlanner = new MealPlanner();
        theMealPlanner.addMealPlan(mealPlan1);
        theMealPlanner.addMealPlan(mealPlan2);
        theMealPlanner.setActiveMealPlanIndex(1);
    }

    @Test
    public void testSetActiveMealPlanIndex() {
        assertEquals(true, theMealPlanner.setActiveMealPlanIndex(0));
        assertEquals(false, theMealPlanner.setActiveMealPlanIndex(4));
        assertEquals(false, theMealPlanner.setActiveMealPlanIndex(-1));
    }

    @Test
    public void testAddMealPlan() {
        assertEquals(false, theMealPlanner.addMealPlan(mealPlan1));
        recipe1 = new Recipe.RecipeBuilder("Tomato Salad")
                .setDescription("A yummy meal!")
                .setServingSize(2)
                .setIngredientList(new IngredientList())
                .setReviews(new ArrayList<Review>())
                .setCategories(new ArrayList<Category>())
                .setInstructions(new ArrayList<String>())
                .build();
        meal1 = new Meal(recipe1);
        mealPlan3.addMeal(meal1);
        assertEquals(true, theMealPlanner.addMealPlan(mealPlan3));
        mealPlan3.setMealPlanName("Meal Plan one");
        assertEquals(false, theMealPlanner.addMealPlan(mealPlan3));
    }

    @Test
    public void testRemoveMealPlan() {
        assertEquals(true, theMealPlanner.removeMealPlan(mealPlan1));
        assertEquals(false, theMealPlanner.removeMealPlan(mealPlan3));
        assertEquals(false, theMealPlanner.removeMealPlan(mealPlan1));
    }

}
