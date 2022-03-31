package it326.r4s;

import static org.junit.Assert.*;
import org.junit.Test;

public class RecipeTest {
    

    @Test
    public void testRecipeBuilder(){

        Recipe recipe = new Recipe.RecipeBuilder("Mac and Cheese").setDescription("A yummy meal!").build();
        
        assertNotNull(recipe);
    }
}
