package it326.r4s;

import static org.junit.Assert.*;

import it326.r4s.model.GroceryList;
import it326.r4s.model.FoodItem;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.UnitConverter.Unit;

import org.junit.Before;
import org.junit.Test;

public class GroceryListTest {
    private static FoodItem.Pool pool = null;
    private Ingredient ingredient1, ingredient2, ingredient3;
    private static IngredientList ingredientList;
    private static IngredientList ingredientList2;
    private static IngredientList ingredientList3;
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
        ingredientList2.addIngredient(ingredient1);
        ingredientList2.addIngredient(ingredient2);
        ingredientList2.addIngredient(ingredient3);

        ingredientList3 = new IngredientList();
        ingredientList3.addIngredient(new Ingredient(pool.getFoodItem("Tomato"), 4, Unit.NONE));
        ingredientList3.addIngredient(new Ingredient(pool.getFoodItem("Noodle"), 12, Unit.OUNCE));
        ingredientList3.addIngredient(new Ingredient(pool.getFoodItem("Soy Sauce"), 200, Unit.MILLILITER));
        ingredientList3.addIngredient(new Ingredient(pool.getFoodItem("Apple"), 6, Unit.NONE));

        theGroceryList = new GroceryList();
        theGroceryList.setIngredientList(ingredientList);
    }

    @Test
    public void testConstructor() {
        assertNotNull(theGroceryList);
    }

    @Test
    public void testGetIngredientList() {
        assertEquals(ingredientList2, theGroceryList.getIngredientList());
    }

    @Test
    public void testAddIngredientList() {
        ingredient1 = new Ingredient(pool.getFoodItem("Apple"), 3, Unit.NONE);
        ingredientList.addIngredient(ingredient1);
        assertEquals(ingredientList3, theGroceryList.getIngredientList());

        ingredient1 = new Ingredient(pool.getFoodItem("Tomato"), 2, Unit.NONE);
        ingredientList2.removeIngredient(ingredient1);
        ingredientList2.removeIngredient(ingredient2);
        ingredientList2.removeIngredient(ingredient3);
        assertEquals(ingredientList3, theGroceryList.getIngredientList());
    }

    @Test
    public void testRemoveIngredient() {
        assertEquals(true, theGroceryList.removeIngredient(ingredient1));
        assertEquals(false, theGroceryList.removeIngredient(ingredient1));
    }
}