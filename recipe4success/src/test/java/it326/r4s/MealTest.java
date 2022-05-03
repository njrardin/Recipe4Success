package it326.r4s;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it326.r4s.model.FoodItem;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.Meal;
import it326.r4s.model.Recipe;
import it326.r4s.model.UnitConverter.Unit;

public class MealTest {
    
    static Recipe theRecipe;
    static Meal theMeal;
    static final int SERVINGSIZE = 2;
    static FoodItem.Pool fiPool = FoodItem.Pool.getInstance();

    @Before
    public void before(){
        
        theRecipe = new Recipe.RecipeBuilder("Red Velvet Cupcakes")
        .setDescription("Believe it or not it's actually just red chocolate.")
        .setServingSize(2)
        .build();

        IngredientList ingredientList = new IngredientList();
        Ingredient testIngredient = new Ingredient(fiPool.getFoodItem("Flour"), 1, Unit.CUP);
        Recipe aRecipe = new Recipe.RecipeBuilder("Recipe with Ingredientlist").setIngredientList(ingredientList).build();
        aRecipe.addIngredient(testIngredient);

        theMeal = new Meal(theRecipe);
    }
    

    @Test
    public void testConstructor(){
        assertNotNull(theMeal);
    }

    //ADD test cases for servingSize = 0 and <0
    @Test
    public void testAdjustServingSize(){

        int newServingSize = 4;
        theMeal.adjustServingSize(newServingSize);

        assertEquals(newServingSize, theMeal.getServingSize());
    }
}
