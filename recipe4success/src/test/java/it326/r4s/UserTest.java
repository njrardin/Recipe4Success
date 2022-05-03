package it326.r4s;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import it326.r4s.model.Category;
import it326.r4s.model.FoodItem;
import it326.r4s.model.GroceryList;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.Meal;
import it326.r4s.model.MealPlan;
import it326.r4s.model.Recipe;
import it326.r4s.model.Review;
import it326.r4s.model.UnitConverter.Unit;
import it326.r4s.model.User;

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
    public void testConstructor(){
        user = new User("Test User 2");
        assertNotNull(user);
        assertEquals("Test User 2", user.getName());
    }
    
    @Test
    public void testMoveGroceryListToPantry() {
        GroceryList gl = user.getGroceryList();

        gl.addIngredient(new Ingredient("Ingredient one", 1, Unit.TEASPOON));
        gl.addIngredient(new Ingredient("Ingredient TWO", 2, Unit.TABLESPOON));

        user.setGroceryList(gl);

        //ensures the pantry is empty to start
        assertTrue(user.getPantry().getIngredientList().getIngredients().isEmpty());

        //moves items
        user.moveGroceryListToPantry();

        //tests to ensure items in pantry
        assertTrue(user.getPantry().getIngredientList().getIngredients().containsAll(gl.getIngredientList().getIngredients()));
    }

    @Test
    public void testGetMakeableRecipes() {
        Collection<Recipe> expectedRecipe = new ArrayList<Recipe>();
        expectedRecipe.add(recipe1);
        expectedRecipe.add(recipe2);
        
        assertEquals(expectedRecipe, user.getMakeableRecipes());
        assertEquals(expectedRecipe.size(), user.getMakeableRecipes().size());

        ingredients.removeIngredient(ingredient3);
        user.getPantry().getIngredientList().addIngredients(ingredients);
        expectedRecipe.remove(recipe2);
        assertEquals(1, user.getMakeableRecipes().size());
        assertEquals(expectedRecipe, user.getMakeableRecipes());
    }

    @Test
    public void testAddMealPlanToGroceryList() {
        user.addMealPlanToGroceryList(mealPlan);
        assertEquals(3, user.getGroceryList().getIngredientList().getIngredients().size());
        mealPlan = new MealPlan("Empty MealPlan");
        user.addMealPlanToGroceryList(mealPlan);
        assertEquals(3, user.getGroceryList().getIngredientList().getIngredients().size());
    }

}
