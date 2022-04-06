package it326.r4s;

import static org.junit.Assert.*;
import org.junit.Test;

import it326.r4s.UnitConverter.Unit;

import org.junit.Before;
import java.util.ArrayList;

public class RecipeTest {
    
    static Recipe setupRecipe;

    @Before
    public void setUp(){
        
        setupRecipe = new Recipe.RecipeBuilder("Mac and Cheese")
        .setDescription("A yummy meal!")
        .setServingSize(2)
        .setIngredientList(new IngredientList())
        .setReviews(new ArrayList<Review>())
        .setCategories(new ArrayList<Category>())
        .setInstructions(new ArrayList<String>())
        .build();
    }


    @Test
    public void testRecipeBuilder(){

        assertNotNull(setupRecipe);
    }
    
    @Test
    public void testRemoveCategory(){
        ArrayList<Category> categoryList = new ArrayList<Category>();
        Category glutenFree = new Category("Gluten Free");
        categoryList.add(glutenFree);

        Recipe aRecipe = new Recipe.RecipeBuilder("Recipe with categories").setCategories(categoryList).build();

        aRecipe.removeCategory(glutenFree);

        assertFalse(aRecipe.getCategories().contains(glutenFree));
    }

    @Test
    public void testAddCategory(){
        Category newCategory = new Category("CATEGORY");

        setupRecipe.addCategory(newCategory);

        assertTrue(setupRecipe.getCategories().contains(newCategory));
    }

    @Test
    public void testRemoveIngredient(){
        IngredientList ingredientList = new IngredientList();
        Ingredient testIngredient = new Ingredient(new FoodItem(), 1, Unit.CUP);
        ingredientList.addIngredient(testIngredient);
        
        Recipe aRecipe = new Recipe.RecipeBuilder("Recipe with Ingredientlist").setIngredientList(ingredientList).build();

        aRecipe.removeIngredient(testIngredient);

        assertFalse(aRecipe.getIngredientList().getIngredients().contains(testIngredient));
    }

    @Test
    public void testAddIngredient(){
        IngredientList ingredientList = new IngredientList();
        Ingredient testIngredient = new Ingredient(new FoodItem(), 1, Unit.CUP);
        
        Recipe aRecipe = new Recipe.RecipeBuilder("Recipe with Ingredientlist").setIngredientList(ingredientList).build();
        
        aRecipe.addIngredient(testIngredient);

        assertTrue(aRecipe.getIngredientList().getIngredients().contains(testIngredient));
    }

    @Test 
    public void testRemoveReview(){
        Review newReview = new Review();
        ArrayList<Review> reviewList = new ArrayList<Review>();
        reviewList.add(newReview);

        Recipe aRecipe = new Recipe.RecipeBuilder("Recipe with Reviews").setReviews(reviewList).build();

        aRecipe.removeReview(newReview);

        assertFalse(aRecipe.getReviews().contains(newReview));
    }

    @Test
    public void testAddReview(){
        Review newReview = new Review();

        setupRecipe.addReview(newReview);

        assertTrue(setupRecipe.getReviews().contains(newReview));
    }

}
