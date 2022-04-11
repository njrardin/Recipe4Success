package it326.r4s;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeSearchTest {
    
    @Test
    public void testSearchFor_SingleParam(){

        //Set up
        Recipe demoRecipe;
        ArrayList<Recipe> expectedList = new ArrayList<Recipe>();
        ArrayList<Recipe> inputList = new ArrayList<Recipe>();
        ArrayList<Recipe> returnList = new ArrayList<Recipe>();

        //Demo recipe 1. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Mac and Cheese")
        .setDescription("A yummy meal!")
        .build();

        expectedList.add(demoRecipe);
        inputList.add(demoRecipe);
        
        //Demo recipe 2. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Cupcakes")
        .setDescription("A yummy thing to eat!")
        .build();

        expectedList.add(demoRecipe);
        inputList.add(demoRecipe);

        //Demo recipe 3. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Yummy yum casserole")
        .setDescription("Made with love <3")
        .build();

        expectedList.add(demoRecipe);
        inputList.add(demoRecipe);

        //Demo recipe 4. Is  NOT valid
        demoRecipe = new Recipe.RecipeBuilder("Super Cereal")
        .setDescription("It's just frosted flakes with chocolate in it")
        .build();

        inputList.add(demoRecipe);
        
        //Demo recipe 5. Is NOT valid
        demoRecipe = new Recipe.RecipeBuilder("fjlaksdjflkeiina")
        .setDescription("hsdhfjsdkjfn sh fjnsdkfj ksjd fnkj sdkjfn jdsf")
        .build();

        inputList.add(demoRecipe);

        RecipeSearch recipeSearch = new RecipeSearch(new ArrayList<Recipe>(inputList));

        returnList = recipeSearch.searchFor("yummy");

        assertEquals(expectedList.size(), returnList.size());

        assertTrue(expectedList.containsAll(returnList));
    }

    @Test
    public void testSearchFor_SingleCateogry(){

        //Set up
        Recipe demoRecipe;
        ArrayList<Recipe> expectedList = new ArrayList<Recipe>();
        ArrayList<Recipe> inputList = new ArrayList<Recipe>();
        ArrayList<Recipe> returnList = new ArrayList<Recipe>();

        Category category1 = new Category("Category 1");
        Category category2 = new Category("Category 2");
        Category category3 = new Category("Category 3");

        //Demo recipe 1. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 1")
        .build();
        demoRecipe.addCategory(category1);  
        demoRecipe.addCategory(category2);  
        
        inputList.add(demoRecipe);
        expectedList.add(demoRecipe);

        //Demo recipe 2. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 2")
        .build();
        demoRecipe.addCategory(category2);  
        demoRecipe.addCategory(category1);  

        inputList.add(demoRecipe);
        expectedList.add(demoRecipe);

        //Demo recipe 3. Is NOT valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 3")
        .build();
        demoRecipe.addCategory(category2);  
        demoRecipe.addCategory(category3);  

        inputList.add(demoRecipe);

        //Demo recipe 4. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 1")
        .build();
        demoRecipe.addCategory(category1);  
        demoRecipe.addCategory(category3);  

        inputList.add(demoRecipe);
        expectedList.add(demoRecipe);

        //Demo recipe 5. Is NOT valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 1")
        .build();
        demoRecipe.addCategory(category3);  
        demoRecipe.addCategory(category2);  

        inputList.add(demoRecipe);


        RecipeSearch recipeSearch = new RecipeSearch(new ArrayList<Recipe>(inputList));

        returnList = recipeSearch.searchFor(category1);

        assertEquals(expectedList.size(), returnList.size());
        assertTrue(expectedList.containsAll(returnList));
    }

    @Test
    public void testSearchFor_MultipleCateogories(){

        //Set up
        Recipe demoRecipe;
        ArrayList<Recipe> expectedList = new ArrayList<Recipe>();
        ArrayList<Recipe> inputList = new ArrayList<Recipe>();
        ArrayList<Recipe> returnList = new ArrayList<Recipe>();

        Category category1 = new Category("Category 1");
        Category category2 = new Category("Category 2");
        Category category3 = new Category("Category 3");
        ArrayList<Category> categoryListQuery = new ArrayList<Category>();
        categoryListQuery.add(category1);
        categoryListQuery.add(category2);

        //Demo recipe 1. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 1")
        .build();
        demoRecipe.addCategory(category1);  
        demoRecipe.addCategory(category2);  
        
        inputList.add(demoRecipe);
        expectedList.add(demoRecipe);

        //Demo recipe 2. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 2")
        .build();
        demoRecipe.addCategory(category2);  
        demoRecipe.addCategory(category1);  

        inputList.add(demoRecipe);
        expectedList.add(demoRecipe);

        //Demo recipe 3. Is NOT valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 3")
        .build();
        demoRecipe.addCategory(category3);  

        inputList.add(demoRecipe);


        //Demo recipe 4. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 1")
        .build();
        demoRecipe.addCategory(category1);  
        demoRecipe.addCategory(category3);  

        inputList.add(demoRecipe);
        expectedList.add(demoRecipe);

        //Demo recipe 5. Is valid
        demoRecipe = new Recipe.RecipeBuilder("Recipe 1")
        .build();
        demoRecipe.addCategory(category3);  
        demoRecipe.addCategory(category2);  

        inputList.add(demoRecipe);
        expectedList.add(demoRecipe);

        RecipeSearch recipeSearch = new RecipeSearch(new ArrayList<Recipe>(inputList));
        returnList = recipeSearch.searchFor(categoryListQuery);

        assertEquals(expectedList.size(), returnList.size());
        assertTrue(expectedList.containsAll(returnList));
    }

}
