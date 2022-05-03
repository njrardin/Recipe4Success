package it326.r4s;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import it326.r4s.model.FoodItem;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.UnitConverter.Unit;

public class IngredientListTest {
    private static IngredientList theIngredientList;
    private static Ingredient ingredient1, ingredient2, ingredient3;
    private static FoodItem fItem;
    private static FoodItem.Pool pool = FoodItem.Pool.getInstance();

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

    }

    @Test
    public void testConstructor() {
        Collection<Ingredient> theIngredients = new ArrayList<Ingredient>();
        theIngredients.add(ingredient1);
        theIngredients.add(ingredient2);
        theIngredients.add(ingredient3);
        theIngredientList = new IngredientList(theIngredients);
        assertNotNull(theIngredientList);
        assertEquals(theIngredients.size(), theIngredientList.getIngredients().size());

        IngredientList otherIngredientList = new IngredientList();
        otherIngredientList.addIngredient(ingredient2);
        otherIngredientList.addIngredient(ingredient3);
        theIngredientList = new IngredientList(otherIngredientList);
        assertNotNull(theIngredientList);
        assertEquals(2, theIngredientList.getIngredients().size());
    }

    @Test
    public void testAddIngredient() {
        Collection<Ingredient> theIngredients = new ArrayList<Ingredient>();
        theIngredients.add(ingredient1);
        theIngredients.add(ingredient2);
        theIngredients.add(ingredient3);
        assertEquals(true, theIngredientList.addIngredient(ingredient1));
        assertEquals(false, theIngredientList.addIngredient(ingredient3));
        fItem = pool.getFoodItem("Banana");
        ingredient2 = new Ingredient(fItem, 3, Unit.OUNCE);
        assertEquals(false, theIngredientList.addIngredient(ingredient2));
    }

    @Test
    public void testAddIngredients() {
        Collection<Ingredient> theIngredients = new ArrayList<Ingredient>();
        theIngredients.add(ingredient1);
        theIngredients.add(ingredient2);
        theIngredients.add(ingredient3);
        theIngredientList = new IngredientList();
        theIngredientList.addIngredient(ingredient1);
        assertEquals(false, theIngredientList.addIngredients(theIngredients));

        fItem = pool.getFoodItem("Apple");
        ingredient1 = new Ingredient(fItem, 4, Unit.NONE);
        Collection<Ingredient> expectedList = new ArrayList<>();
        expectedList.add(ingredient1);
        expectedList.add(ingredient2);
        expectedList.add(ingredient3);
        assertEquals(expectedList, theIngredientList.getIngredients());

        IngredientList otherIngredientList = new IngredientList();
        fItem = pool.getFoodItem("Peach");
        ingredient1 = new Ingredient(fItem, 1, Unit.NONE);
        otherIngredientList.addIngredient(ingredient1);
        otherIngredientList.addIngredient(ingredient3);
        assertFalse(theIngredientList.addIngredients(otherIngredientList));
        assertEquals(4, theIngredientList.getIngredients().size());
    }

    @Test
    public void testRemoveIngredient() {
        assertEquals(true, theIngredientList.removeIngredient(ingredient1));
        assertEquals(false, theIngredientList.removeIngredient(ingredient1));
    }

    @Test
    public void testRemoveIngredients() {
        Collection<Ingredient> theIngredients = new ArrayList<Ingredient>();
        theIngredients.add(ingredient1);
        theIngredients.add(ingredient2);
        theIngredients.add(ingredient3);
        assertTrue(theIngredientList.removeIngredients(theIngredients));
        assertFalse(theIngredientList.removeIngredients(theIngredients));

        theIngredientList.addIngredient(ingredient1);
        IngredientList otherIngredientList = new IngredientList();
        otherIngredientList.addIngredient(ingredient2);
        otherIngredientList.addIngredient(ingredient3);
        assertFalse(theIngredientList.removeIngredients(otherIngredientList));
    }

    @Test
    public void testClearIngredients() {
        theIngredientList.clearIngredients();
        Collection<Ingredient> emptyList = new ArrayList<>();
        assertEquals(emptyList, theIngredientList.getIngredients());
    }

    @Test
    public void testContainsIngredients() {
        Collection<Ingredient> theIngredients = new ArrayList<Ingredient>();
        theIngredients.add(ingredient1);
        theIngredients.add(ingredient2);
        theIngredients.add(ingredient3);
        IngredientList otherIngredientList = new IngredientList();
        otherIngredientList.addIngredient(ingredient1);
        otherIngredientList.addIngredient(ingredient3);
        assertFalse(theIngredientList.containsIngredients(otherIngredientList));
        assertTrue(theIngredientList.getIngredients().contains(ingredient1));
        assertFalse(theIngredientList.getIngredients().containsAll(otherIngredientList.getIngredients()));

        theIngredientList.addIngredient(ingredient2);
        theIngredientList.addIngredient(ingredient3);
        assertEquals(true, theIngredientList.containsIngredients(theIngredients));
        assertTrue(theIngredientList.getIngredients().containsAll(theIngredients));

        theIngredients.clear();
        assertTrue(theIngredientList.containsIngredients(theIngredients));
    }

    @Test
    public void testReorganizeIngredients() {
        theIngredientList.addIngredient(ingredient2);
        theIngredientList.addIngredient(ingredient3);
        theIngredientList.reorganizeIngredients(ingredient1, ingredient3);
        Collection<Ingredient> expectedList = new ArrayList<>();
        expectedList.add(ingredient2);
        expectedList.add(ingredient3);
        expectedList.add(ingredient1);
        assertEquals(expectedList, theIngredientList.getIngredients());

        theIngredientList.reorganizeIngredients(ingredient1, ingredient2);
        expectedList.clear();
        expectedList.add(ingredient2);
        expectedList.add(ingredient1);
        expectedList.add(ingredient3);
        assertEquals(expectedList, theIngredientList.getIngredients());

        fItem = pool.getFoodItem("Does not exitst");
        ingredient1 = new Ingredient(fItem, 2, Unit.NONE);
        assertFalse(theIngredientList.reorganizeIngredients(ingredient2, ingredient1));
    }

}
