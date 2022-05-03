package it326.r4s;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import it326.r4s.model.*;
import it326.r4s.model.UnitConverter.Unit;


public class UserTest {
    private static User user;
    private static Ingredient ingredient1, ingredient2, ingredient3;
    private static IngredientList ingredients;
    private static MealPlan mealPlan;
    private static Meal meal;
    private static Recipe recipe1, recipe2;
    private static FoodItem fItem;
    private static FoodItem.Pool fiPool = FoodItem.Pool.getInstance();

    @Before
    public void setUp() {
        user = new User("R4S Test User");

        fItem = fiPool.getFoodItem("Apple");
        ingredient1 = new Ingredient(fItem, 2, Unit.NONE);
        fItem = fiPool.getFoodItem("Banana");
        ingredient2 = new Ingredient(fItem, 3, Unit.GRAM);
        fItem = fiPool.getFoodItem("Cherry");
        ingredient3 = new Ingredient(fItem, 4, Unit.OUNCE);

        ingredients = new IngredientList();
        ingredients.addIngredient(ingredient1);
        ingredients.addIngredient(ingredient2);
        ingredients.addIngredient(ingredient3);

        recipe1 = new Recipe.RecipeBuilder("Mac and Cheese")
                .setDescription("Ingredients:Apple, Banana")
                .setServingSize(2)
                .setIngredientList(new IngredientList())
                .setReviews(new ArrayList<Review>())
                .setCategories(new ArrayList<Category>())
                .setInstructions(new ArrayList<String>())
                .build();

        recipe1.addIngredient(ingredient1);
        recipe1.addIngredient(ingredient2);

        recipe2 = new Recipe.RecipeBuilder("Tomato Salad")
                .setDescription("Ingredients: Apple, Cherry")
                .setServingSize(2)
                .setIngredientList(new IngredientList())
                .setReviews(new ArrayList<Review>())
                .setCategories(new ArrayList<Category>())
                .setInstructions(new ArrayList<String>())
                .build();
        recipe2.addIngredient(ingredient1);
        recipe2.addIngredient(ingredient3);

        user.getRecipeBook().addRecipe(recipe1);
        user.getRecipeBook().addRecipe(recipe2);

        mealPlan = new MealPlan("Meal Plan one");
        meal = new Meal(recipe1);
        mealPlan.addMeal(meal);
        meal = new Meal(recipe2);
        mealPlan.addMeal(meal);
    }

    //ADD test for copy constructor
    
    @Test
    public void testMoveGroceryListToPantry() {
        user.getGroceryList().addIngredients(ingredients);
        // Collection<Ingredient> ingredients = new ArrayList<Ingredient>();
        // ingredients.add(ingredient1);
        // ingredients.add(ingredient2);
        // ingredients.add(ingredient3);
        user.getGroceryList().addIngredients(ingredients);
        int count = user.getGroceryList().getIngredientList().getIngredients().size();
        user.moveGroceryListToPantry();
        assertEquals(0, user.getGroceryList().getIngredientList().getIngredients().size());
        assertEquals(count, user.getPantry().getIngredientList().getIngredients().size());
        //Change Compare Object
        assertEquals(ingredients, user.getPantry().getIngredientList().getIngredients());

        fItem = fiPool.getFoodItem("Peach");
        // ingredient1 = ;
        ingredients.addIngredient(new Ingredient(fItem, 1, Unit.POUND));
        user.getGroceryList().addIngredients(ingredients);
        count = user.getGroceryList().getIngredientList().getIngredients().size();
        user.moveGroceryListToPantry();
        assertEquals(0, user.getGroceryList().getIngredientList().getIngredients().size());
        assertEquals(count, user.getPantry().getIngredientList().getIngredients().size());
        assertEquals(ingredients, user.getPantry().getIngredientList());

    }

    /**
     * Fail
     * because the method should not return any recipe when the pantry is empty
     */
    @Test
    public void testGetMakeableRecipes() {
        Collection<Recipe> outputRecipe = new ArrayList<Recipe>();
        outputRecipe = user.getMakeableRecipes();
        // assertEquals(0,outputRecipe.size());
        System.out.println("Pantry" + user.getPantry().getIngredientList().toString());
        System.out.println(outputRecipe.toString());

        ingredients.removeIngredient(ingredient3);
        user.getPantry().getIngredientList().addIngredients(ingredients);
        outputRecipe = user.getMakeableRecipes();
        Collection<Recipe> expectedRecipe = new ArrayList<Recipe>();
        expectedRecipe.add(recipe1);
        assertEquals(1, outputRecipe.size());
        assertEquals(expectedRecipe, outputRecipe);
        System.out.println("Pantry" + user.getPantry().getIngredientList().toString());
        System.out.println(outputRecipe.toString());
    }

    @Test
    public void testAddMealPlanToGroceryList() {
        // add meal plan's ingredients to groceryList
        user.addMealPlanToGroceryList(mealPlan);
        assertEquals(3, user.getGroceryList().getIngredientList().getIngredients().size());
        mealPlan = new MealPlan("Empty MealPlan");
        user.addMealPlanToGroceryList(mealPlan);
        assertEquals(3, user.getGroceryList().getIngredientList().getIngredients().size());
    }

}
