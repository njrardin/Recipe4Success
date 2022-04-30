package it326.r4s;

import static org.junit.Assert.*;

import it326.r4s.model.Category;
import it326.r4s.model.Category.Type;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
// import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CategoryTest {

    private static String name;
    private static Category theCategory;

    @Before
    public void setUp() {
        name = "Test Category";
        theCategory = new Category(name);

    }

    @Test
    public void testGetName() {
        assertEquals(name, theCategory.getName());
    }

    @Test
    public void testSetName() {
        String newName = "New Test Category";
        theCategory.setName(newName);

        assertEquals(newName, theCategory.getName());
    }

    public static class testCategoryPool {

        private static Category.Pool pool1 = null;
        private static Category theTestCategory;
        ArrayList<Category> theFoodCollection = new ArrayList<Category>();
        ArrayList<Category> theRecipeCollection = new ArrayList<Category>();
        Map<Type, ArrayList<Category>> allCategories = new HashMap<Category.Type, ArrayList<Category>>();

        @Before
        public void setUp() {

            theTestCategory = new Category("Vegetable");
            theFoodCollection.add(new Category("Vegetable"));
            theFoodCollection.add(new Category("Poultry"));
            theRecipeCollection.add(new Category("Scramble Egg"));
            allCategories.put(Type.FOODITEM, theFoodCollection);
            allCategories.put(Type.RECIPE, theRecipeCollection);

            pool1 = Category.Pool.getInstance();

            pool1.getCategory(Type.FOODITEM, "Vegetable");
            pool1.getCategory(Type.RECIPE, "Scramble Egg");
            pool1.getCategory(Type.FOODITEM, "Poultry");
        }

        @Test
        public void testGetCategory() {
            assertEquals(theTestCategory, pool1.getCategory(Type.FOODITEM, "Vegetable"));
        }

        @Test
        public void testGetCategories() {
            Collection<Category> actualCategory = pool1.getCategories(Type.FOODITEM);
            ArrayList<Category> outputCategory = new ArrayList<Category>();
            for (Category c : actualCategory) {
                outputCategory.add(c);
            }
            assertEquals(theFoodCollection, outputCategory);
        }

        @Test
        public void testRemoveCategory() {
            assertEquals(true, pool1.removeCategory(Type.RECIPE, "Scramble Egg"));
            assertEquals(false, pool1.removeCategory(Type.RECIPE, "Scramble Egg"));
        }

        @Test
        public void testContains() {
            assertEquals(true, pool1.contains(Type.FOODITEM, "Vegetable"));
            pool1.removeCategory(Type.RECIPE, "Scramble Egg");
            assertEquals(false, pool1.contains(Type.RECIPE, "Scramble Egg"));
        }

    }

}
