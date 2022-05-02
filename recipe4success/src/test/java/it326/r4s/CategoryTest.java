package it326.r4s;

import static org.junit.Assert.*;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import org.junit.BeforeClass;
import org.junit.Test;

import it326.r4s.model.Category;

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
        }
    
        @Test
        public void testGetCategory() {
            Category category = pool.getCategory(Category.Type.FOODITEM, "Fruit");
            assertEquals("Fruit", category.getName());
        }

        @Test
        public void testGetInstance(){
            Category.Pool samePool = Category.Pool.getInstance();
            assertTrue(pool == samePool); //tests for equality by reference
        }

        
    }
}
