package it326.r4s;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class MealPlanSearchTest {
    
    @Test
    public void testSearchFor_SingleString(){

        //Set up
        MealPlan demoMP;
        Recipe demoRecipe;
        ArrayList<MealPlan> expectedList = new ArrayList<MealPlan>();
        ArrayList<MealPlan> inputList = new ArrayList<MealPlan>();
        ArrayList<MealPlan> returnList = new ArrayList<MealPlan>();

        final String SEARCH_STRING = "ever";

        //MealPlan 1: Is valid
        demoMP = new MealPlan("MP1");
        demoRecipe = new Recipe.RecipeBuilder("demoMP1-demoR1").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("First mealplan");
        demoMP.setMealPlanDescription("This is my first mealplan ever!");

        expectedList.add(demoMP);
        inputList.add(demoMP);

        //MealPlan 2: Is valid
        demoMP = new MealPlan("MP2");
        demoRecipe = new Recipe.RecipeBuilder("demoMP2-demoR1").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("Evermore menu");
        demoMP.setMealPlanDescription("A scrumptious fantasy menu.");

        expectedList.add(demoMP);
        inputList.add(demoMP);

        //MealPlan 3: Is NOT valid
        demoMP = new MealPlan("MP3");
        demoRecipe = new Recipe.RecipeBuilder("demoMP3-demoR1").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("Des vacances en France");
        demoMP.setMealPlanDescription("Je ne savais pas ce qu'ils avaient alors j'ai cree ce plan de repas ci");

        inputList.add(demoMP);

        //MealPlan 4: Is valid
        demoMP = new MealPlan("MP4");
        demoRecipe = new Recipe.RecipeBuilder("demoMP4-demoR1").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("Beverly Hills Mealplan");
        demoMP.setMealPlanDescription("I think its clever");

        expectedList.add(demoMP);
        inputList.add(demoMP);

        //MealPlan 5: Is NOT valid
        demoMP = new MealPlan("MP5");
        demoRecipe = new Recipe.RecipeBuilder("demoMP5-demoR1").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("Oh no my ISU mealplan ran out");
        demoMP.setMealPlanDescription("guess I gotta buy groceries now");

        inputList.add(demoMP);


        MealPlanSearch MealPlanSearch = new MealPlanSearch(new ArrayList<MealPlan>(inputList));

        returnList = MealPlanSearch.searchFor(SEARCH_STRING);

        assertEquals(expectedList.size(), returnList.size());
        assertTrue(expectedList.containsAll(returnList));
    }

    @Test
    public void testSearchRecipesFor_SingleString(){
        //Set up
        MealPlan demoMP;
        Recipe demoRecipe;
        ArrayList<MealPlan> expectedList = new ArrayList<MealPlan>();
        ArrayList<MealPlan> inputList = new ArrayList<MealPlan>();
        ArrayList<MealPlan> returnList = new ArrayList<MealPlan>();

        final String SEARCH_STRING = "apple";

        //MealPlan 1: Is valid
        demoMP = new MealPlan("MP1");
        demoRecipe = new Recipe.RecipeBuilder("apple pie").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("First mealplan");
        demoMP.setMealPlanDescription("This is my first mealplan ever!");

        expectedList.add(demoMP);
        inputList.add(demoMP);

        //MealPlan 2: Is valid
        demoMP = new MealPlan("MP2");
        demoRecipe = new Recipe.RecipeBuilder("grandma's apple cider").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("Evermore menu");
        demoMP.setMealPlanDescription("A scrumptious fantasy menu.");

        expectedList.add(demoMP);
        inputList.add(demoMP);

        //MealPlan 3: Is NOT valid
        demoMP = new MealPlan("MP3");
        demoRecipe = new Recipe.RecipeBuilder("cupcake thing").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("Des vacances en France");
        demoMP.setMealPlanDescription("Je ne savais pas ce qu'ils avaient alors j'ai cree ce plan de repas ci");

        inputList.add(demoMP);

        //MealPlan 4: Is valid
        demoMP = new MealPlan("MP4");
        demoRecipe = new Recipe.RecipeBuilder("title that doesn't have the a word").setDescription("description that says apple").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("Beverly Hills Mealplan");
        demoMP.setMealPlanDescription("I think its clever");

        expectedList.add(demoMP);
        inputList.add(demoMP);

        //MealPlan 5: Is NOT valid
        demoMP = new MealPlan("MP5");
        demoRecipe = new Recipe.RecipeBuilder("wawa we wa").build();
        demoMP.addMeal(new Meal(demoRecipe, 4));
        demoMP.setMealPlanName("Oh no my ISU mealplan ran out");
        demoMP.setMealPlanDescription("guess I gotta buy groceries now");

        inputList.add(demoMP);


        MealPlanSearch MealPlanSearch = new MealPlanSearch(new ArrayList<MealPlan>(inputList));

        returnList = MealPlanSearch.searchRecipesFor(SEARCH_STRING);

        assertEquals(expectedList.size(), returnList.size());
        assertTrue(expectedList.containsAll(returnList));
    }
}
