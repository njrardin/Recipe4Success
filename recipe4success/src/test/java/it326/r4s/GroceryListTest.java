package it326.r4s;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import it326.r4s.model.FoodItem;
import it326.r4s.model.GroceryList;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.UnitConverter.Unit;

public class GroceryListTest {
    private static FoodItem.Pool pool = null;
    private Ingredient ingredient1, ingredient2, ingredient3;
    private static IngredientList ingredientList;
    private static IngredientList ingredientList2;
    private static GroceryList theGroceryList;

    @Before
    public void setUp() {
        pool = FoodItem.Pool.getInstance();

        ingredient1 = new Ingredient(pool.getFoodItem("Tomato"), 2, Unit.NONE);
        ingredient2 = new Ingredient(pool.getFoodItem("Noodle"), 6, Unit.OUNCE);
        ingredient3 = new Ingredient(pool.getFoodItem("Soy Sauce"), 100, Unit.MILLILITER);

        ingredientList = new IngredientList();
        ingredientList.addIngredient(ingredient1);
        ingredientList.addIngredient(ingredient2);
        ingredientList.addIngredient(ingredient3);

        ingredientList2 = new IngredientList();
        ingredientList2.addIngredient(new Ingredient(pool.getFoodItem("Tomato"), 4, Unit.NONE));
        ingredientList2.addIngredient(new Ingredient(pool.getFoodItem("Noodle"), 12, Unit.OUNCE));
        ingredientList2.addIngredient(new Ingredient(pool.getFoodItem("Soy Sauce"), 200, Unit.MILLILITER));
        ingredientList2.addIngredient(new Ingredient(pool.getFoodItem("Apple"), 6, Unit.NONE));

        theGroceryList = new GroceryList();
    }

    @Test
    public void testAddIngredients() {
        theGroceryList.addIngredients(ingredientList);
        Collection<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(ingredient1);
        expectedIngredients.add(ingredient2);
        expectedIngredients.add(ingredient3);
        assertEquals(expectedIngredients.size(), theGroceryList.getIngredientList().getIngredients().size());
        assertEquals(expectedIngredients, theGroceryList.getIngredientList().getIngredients());

        Collection<Ingredient> emptyIngredients = new ArrayList<>();
        theGroceryList.addIngredients(emptyIngredients);
        assertEquals(expectedIngredients.size(), theGroceryList.getIngredientList().getIngredients().size());
        assertEquals(expectedIngredients, theGroceryList.getIngredientList().getIngredients());
    }

    @Test
    public void testRemoveIngredient() {
        theGroceryList.setIngredientList(ingredientList);
        assertEquals(true, theGroceryList.removeIngredient(ingredient1));
        assertEquals(false, theGroceryList.removeIngredient(ingredient1));
    }

    @Test
    public void TestRemoveIngredients() {
        theGroceryList.addIngredients(ingredientList);
        Collection<Ingredient> expectedIngredients = new ArrayList<>();
        assertTrue(theGroceryList.removeIngredients(ingredientList));
        assertEquals(expectedIngredients.size(), theGroceryList.getIngredientList().getIngredients().size());
        assertEquals(expectedIngredients, theGroceryList.getIngredientList().getIngredients());

        theGroceryList.addIngredients(ingredientList);
        expectedIngredients.add(ingredient1);
        expectedIngredients.add(ingredient2);
        expectedIngredients.add(ingredient3);
        assertTrue(theGroceryList.removeIngredients(expectedIngredients));
        assertEquals(0, theGroceryList.getIngredientList().getIngredients().size());
        expectedIngredients.clear();
        assertEquals(expectedIngredients, theGroceryList.getIngredientList().getIngredients());

    }

    @Test
    public void testRemoveIngredients() {
        ArrayList<Ingredient> groceryIngredients = new ArrayList<Ingredient>();
        ArrayList<Ingredient> ingredientsToRemove = new ArrayList<Ingredient>();
        ArrayList<Ingredient> expectedList = new ArrayList<Ingredient>();
        ArrayList<Ingredient> notExpectedList = new ArrayList<Ingredient>();
        ArrayList<Ingredient> actualList = new ArrayList<Ingredient>();

        theGroceryList = new GroceryList();

        theGroceryList.getIngredientList().clearIngredients();

        groceryIngredients.add(ingredient1);
        groceryIngredients.add(ingredient2);
        groceryIngredients.add(ingredient3);
        theGroceryList.addIngredients(groceryIngredients);


        ingredientsToRemove.add(ingredient1);
        ingredientsToRemove.add(ingredient2);

        notExpectedList.add(ingredient1);
        notExpectedList.add(ingredient2);
        notExpectedList.add(ingredient3);

        expectedList.add(ingredient3);

        assertTrue(theGroceryList.removeIngredients(ingredientsToRemove));
        assertFalse(theGroceryList.removeIngredients(ingredientsToRemove));

        actualList = theGroceryList.getIngredientList().getIngredients();

        assertTrue(expectedList.containsAll(actualList));
    }
}