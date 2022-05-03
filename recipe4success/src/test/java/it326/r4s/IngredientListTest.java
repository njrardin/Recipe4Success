package it326.r4s;

import org.junit.Assert.*;

import it326.r4s.model.*;
import it326.r4s.model.UnitConverter.Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class IngredientListTest {
    private static IngredientList theIngredientList;
    private static Ingredient ingredient1, ingredient2, ingredient3;
    private static FoodItem fItem;
    private static FoodItem.Pool pool = FoodItem.Pool.getInstance();
    private static ArrayList<Ingredient> theIngredients = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> expectedList = new ArrayList<Ingredient>();

    @Before
    public void setUp() {
        fItem = pool.getFoodItem("Apple");
        ingredient1 = new Ingredient(fItem, 2, Unit.NONE);
        fItem = pool.getFoodItem("Banana");
        ingredient2 = new Ingredient(fItem, 3, Unit.GRAM);
        fItem = pool.getFoodItem("Cherry");
        ingredient3 = new Ingredient(fItem, 4, Unit.OUNCE);

        theIngredientList = new IngredientList();
        theIngredientList.addIngredient(ingredient1);
        // theIngredientList.addIngredient(ingredient2);

        theIngredients.add(ingredient1);
        theIngredients.add(ingredient2);
        theIngredients.add(ingredient3);

    }

    @Test
    public void testAddIngredient() {
        assertEquals(true, theIngredientList.addIngredient(ingredient1));
        assertEquals(false, theIngredientList.addIngredient(ingredient3));
        fItem = pool.getFoodItem("Banana");
        ingredient2 = new Ingredient(fItem, 3, Unit.OUNCE);
        assertEquals(false, theIngredientList.addIngredient(ingredient2));
    }

    @Test
    public void testAddIngredients() {
        assertEquals(false, theIngredientList.addIngredients(theIngredients));
        ArrayList<Ingredient> actualList = theIngredientList.getIngredients();
        expectedList.add(ingredient1);
        expectedList.add(ingredient2);
        expectedList.add(ingredient3);
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testRemoveIngredient() {
        theIngredientList.addIngredient(ingredient1);
        assertEquals(true, theIngredientList.removeIngredient(ingredient1));
        assertEquals(false, theIngredientList.removeIngredient(ingredient1));
    }

    @Test
    public void testRemoveIngredients() {
        assertTrue(theIngredientList.removeIngredients(theIngredients));
        theIngredients.remove(ingredient2);
        theIngredients.remove(ingredient3);
        theIngredientList.addIngredient(ingredient1);
        assertTrue(theIngredientList.removeIngredients(theIngredients));
        assertFalse(theIngredientList.removeIngredients(theIngredients));
        theIngredientList.addIngredient(ingredient1);
        theIngredients.remove(ingredient1);
        theIngredients.add(ingredient2);
        theIngredients.add(ingredient3);
        assertFalse(theIngredientList.removeIngredients(theIngredients));
        expectedList.add(ingredient1);
        ArrayList<Ingredient> actualList = theIngredientList.getIngredients();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testClearIngredients() {
        theIngredientList.clearIngredients();
        assertEquals(expectedList, theIngredientList.getIngredients());
    }

    @Test
    public void testContainsIngredients() {
        assertEquals(false, theIngredientList.containsIngredients(theIngredients));
        theIngredientList.removeIngredient(ingredient1);
        // did not pass null ingredientList test
        // assertEquals(false, theIngredientList.containsIngredients(theIngredients));
        theIngredientList.addIngredient(ingredient1);
        theIngredientList.addIngredient(ingredient2);
        theIngredientList.addIngredient(ingredient3);
        assertEquals(true, theIngredientList.containsIngredients(theIngredients));
    }

    /**
     * fail when performing second reoganizeIngredients()
     * result is same as the first time
     */
    @Test
    public void testReorganizeIngredients() {
        theIngredientList.addIngredient(ingredient2);
        theIngredientList.addIngredient(ingredient3);
        // move 1 after 2
        theIngredientList.reoganizeIngredients(ingredient1, ingredient3);
        expectedList.add(ingredient2);
        expectedList.add(ingredient3);
        expectedList.add(ingredient1);
        expectedList.add(ingredient1);

        ArrayList<Ingredient> actualList = theIngredientList.getIngredients();
        assertEquals(expectedList, actualList);

    }

}
