package it326.r4s;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import org.junit.BeforeClass;
import org.junit.Test;

import it326.r4s.model.Category;
import it326.r4s.model.Category.Type;

@RunWith (Enclosed.class)
public class CategoryTest {
    
    public static class CategoryMethods {
        @Test
        public void testEquals(){
            Category category1 = new Category("Vegan");
            Category category2 = new Category("vegan");
            Category category3 = new Category("not vegan");
    
            assertTrue(category1.equals(category2));
            assertTrue(category2.equals(category2));
            assertFalse(category2.equals(category3));

        }
    } 

    public static class CategoryPoolTest {
        static Category.Pool pool = Category.Pool.getInstance();
    
        @BeforeClass
        public static void before() {
            pool.getCategory(Category.Type.FOODITEM, "Vegetable");
            pool.getCategory(Category.Type.FOODITEM, "Fruit");
            pool.getCategory(Category.Type.FOODITEM, "Meat");
            pool.getCategory(Category.Type.RECIPE, "a recipe category");
            pool.getCategory(Category.Type.RECIPE, "willBeRemoved"); //removed in removeCategory test
        }
    
        @Test
        public void testGetCategory() {
            Category category = pool.getCategory(Category.Type.FOODITEM, "Fruit");
            assertEquals("Fruit", category.getName());
        }

        @Test
        public void testGetCategories(){
            ArrayList<Category> fiCategoryList = new ArrayList<Category>();
            fiCategoryList.add(new Category("Vegetable"));
            fiCategoryList.add(new Category("Fruit"));
            fiCategoryList.add(new Category("Meat"));
            assertTrue(pool.getCategories(Type.FOODITEM).containsAll(fiCategoryList));
            fiCategoryList.add(new Category("a recipe category"));
            assertFalse(pool.getCategories(Type.FOODITEM).containsAll(fiCategoryList));
        }

        @Test
        public void testGetInstance(){
            Category.Pool samePool = Category.Pool.getInstance();
            assertTrue(pool == samePool); //tests for equality by reference
        }

        @Test
        public void testRemoveCategory(){
            assertFalse(pool.removeCategory(Type.FOODITEM, "doesNotExist"));
            assertFalse(pool.removeCategory(Type.FOODITEM, "willBeRemoved"));
            assertTrue(pool.removeCategory(Type.RECIPE, "willBeRemoved"));
        }

        @Test
        public void testContains(){
            assertFalse(pool.contains(Type.FOODITEM, "Vegechair"));
            assertFalse(pool.contains(Type.RECIPE, "Vegetable"));
            assertTrue(pool.contains(Type.FOODITEM, "Vegetable"));
        }
        
    }
}
