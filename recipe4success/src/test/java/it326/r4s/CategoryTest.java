package it326.r4s;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
            Category.Pool catPool = Category.Pool.getInstance();

            Category category1 = catPool.getCategory(Type.RECIPE, "Vegan");
            Category category2 = catPool.getCategory(Type.RECIPE, "vegan");
            Category category3 = catPool.getCategory(Type.RECIPE, "not vegan");
    
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
            Collection<Category> fiCategories = pool.getCategories(Type.FOODITEM);

            String[] fiNamesArr = {"Vegetable", "Fruit", "Meat"};
            List<String> fiNames = Arrays.asList(fiNamesArr);
            for(Category category: fiCategories){
                assertTrue(fiNames.contains(category.getName()));
            }
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
