package it326.r4s;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;

public class MealTest {
    
    static Recipe theRecipe;
    static Meal theMeal;
    static final int SERVINGSIZE = 5;

    @BeforeClass
    public static void before(){

        theRecipe = new Recipe.RecipeBuilder("Red Velvet Cupcakes")
        .setDescription("Believe it or not it's actually just red chocolate.")
        .build();

        theMeal = new Meal(theRecipe, SERVINGSIZE);
    }

    @Test
    public void testConstructor(){
        assertNotNull(theMeal);
    }
    
    @Test
    public void testGetRecipe(){
        assertEquals(theRecipe, theMeal.getRecipe());
    }
    
    @Test
    public void testGetServinSize(){
        assertEquals(SERVINGSIZE, theMeal.getServingSize());
    }
}
