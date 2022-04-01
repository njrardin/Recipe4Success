package it326.r4s;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

public class RecipeTest {
    
    static Recipe testRecipe;

    @Before
    public void setUp(){
        
        testRecipe = new Recipe.RecipeBuilder("Mac and Cheese")
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

        assertNotNull(testRecipe);
    }

    @Test
    public void testAddCategory(){
        Category newCategory = new Category();

        testRecipe.addCategory(newCategory);

        assertTrue(testRecipe.getCategories().contains(newCategory));
    }
}
