package it326.r4s;

import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import it326.r4s.model.*;
import it326.r4s.model.UnitConverter.Unit;

import org.junit.Before;
import org.junit.Test;

public class RecipeBookTest {
    private static RecipeBook theRecipeBook;
    private static Recipe recipe1, recipe2;
    private static FoodItem.Pool fiPool = FoodItem.Pool.getInstance();

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
        FoodItem repeatFoodItem = fiPool.getFoodItem("Sugar");
        recipe1.addIngredient(new Ingredient(repeatFoodItem, 1, Unit.TABLESPOON));
        recipe1.addIngredient(new Ingredient(repeatFoodItem, 2, Unit.CUP));

        recipe2 = new Recipe.RecipeBuilder("Tomato Salad")
                .setDescription("A yummy meal!")
                .setServingSize(2)
                .setIngredientList(new IngredientList())
                .setReviews(new ArrayList<Review>())
                .setCategories(new ArrayList<Category>())
                .setInstructions(new ArrayList<String>())
                .build();
        recipe2.addIngredient(new Ingredient(repeatFoodItem, 1, Unit.TABLESPOON));
        recipe2.addIngredient(new Ingredient(repeatFoodItem, 2, Unit.CUP));

        theRecipeBook = new RecipeBook();
        theRecipeBook.addRecipe(recipe1);
    }

    @Test
    public void testAddRecipe() {
        assertEquals(true, theRecipeBook.addRecipe(recipe2));
        assertEquals(false, theRecipeBook.addRecipe(recipe1));
    }

    @Test
    public void testRemoveRecipe() {
        assertEquals(true, theRecipeBook.removeRecipe(recipe1));
        assertEquals(false, theRecipeBook.removeRecipe(recipe1));
    }

}
