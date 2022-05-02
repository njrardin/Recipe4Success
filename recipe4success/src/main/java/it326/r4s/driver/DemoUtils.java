package it326.r4s.driver;

import java.util.ArrayList;

import it326.r4s.model.Category;
import it326.r4s.model.GroceryList;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.Meal;
import it326.r4s.model.MealPlan;
import it326.r4s.model.MealPlanner;
import it326.r4s.model.Recipe;
import it326.r4s.model.Recipe.RecipeBuilder;
import it326.r4s.model.RecipeBook;
import it326.r4s.model.UnitConverter;
import it326.r4s.model.UnitConverter.Unit;
import it326.r4s.model.User;

/**
 * Utilities for the Driver
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class DemoUtils {    
    public static void prepopulateUser(User user) {
        //======================================================================================================
        //Populate the recipeBook with a series of recipes
        RecipeBook recipeBook = new RecipeBook();

        //Demo recipe 1
        Recipe demoRecipe1;
        RecipeBuilder recipeBuilder = new RecipeBuilder("Mac and Cheese")
        .setDescription("A cheesy meal!")
        .setServingSize(1);

        ArrayList<String> instructions = new ArrayList<String>();
        instructions.add("Get a big bowl and fill it with water");
        instructions.add("Boil the water");
        instructions.add("Pour macaroni in water");
        instructions.add("microwave for 10 minutes");
        instructions.add("Pour pasta in strainer and add 2 slices of cheese");
        instructions.add("stir until mixed thoroughly and enjoy!");

        recipeBuilder.setInstructions(instructions);

        IngredientList ingredientList = new IngredientList();
        ingredientList.addIngredient(new Ingredient("cheese", 2, UnitConverter.Unit.NONE));
        ingredientList.addIngredient(new Ingredient("macaroni", 4, UnitConverter.Unit.CUP));

        recipeBuilder.setIngredientList(ingredientList);

        demoRecipe1 = recipeBuilder.build();

        recipeBook.addRecipe(demoRecipe1);

        //Demo recipe 2
        Recipe demoRecipe2;

        recipeBuilder = new RecipeBuilder("Cupcakes")
        .setDescription("A great desert")
        .setServingSize(2);

        instructions = new ArrayList<String>();
        instructions.add("Pour cupcake batter");
        instructions.add("bake the cupcakes for 15 minutes at 350 degrees");

        recipeBuilder.setInstructions(instructions);

        ingredientList = new IngredientList();
        ingredientList.addIngredient(new Ingredient("cupcake batter", 4, UnitConverter.Unit.CUP));
        ingredientList.addIngredient(new Ingredient("cupcake icing", 2, UnitConverter.Unit.TABLESPOON));

        recipeBuilder.setIngredientList(ingredientList);

        demoRecipe2 = recipeBuilder.build();
        recipeBook.addRecipe(demoRecipe2);

        //Demo recipe 3
        Recipe demoRecipe3;

        recipeBuilder = new RecipeBuilder("Grammy's mashed potatoes")
        .setDescription("The yummy taters my grandma used to make.")
        .setServingSize(4);

        instructions = new ArrayList<String>();
        instructions.add("Take 3 potatoes...");
        instructions.add("...(pretend more instructions here)...");
        instructions.add("...and now you have potatoes!");

        recipeBuilder.setInstructions(instructions);

        ingredientList = new IngredientList();
        ingredientList.addIngredient(new Ingredient("potatoes", 8, UnitConverter.Unit.NONE));
        ingredientList.addIngredient(new Ingredient("butter", 1, UnitConverter.Unit.TEASPOON));

        recipeBuilder.setIngredientList(ingredientList);

        ArrayList<Category> categories = new ArrayList<Category>();
        Category.Pool cPool = Category.Pool.getInstance();
        categories.add(cPool.getCategory(Category.Type.RECIPE, "vegan"));
        recipeBuilder.setCategories(categories);

        demoRecipe3 = recipeBuilder.build();
        recipeBook.addRecipe(demoRecipe3);

        //Demo recipe 4
        Recipe demoRecipe4;

        recipeBuilder = new RecipeBuilder("Mega-mini-locos-tacos platter")
        .setDescription("A whole lotta really wacky tiny tacos.")
        .setServingSize(7);

        instructions = new ArrayList<String>();
        instructions.add("Put the taco meat in the tacos");
        instructions.add("...(pretend more instructions here)...");
        instructions.add("...serve on your party tray!");

        recipeBuilder.setInstructions(instructions);

        ingredientList = new IngredientList();
        ingredientList.addIngredient(new Ingredient("taco shell",20, UnitConverter.Unit.NONE));
        ingredientList.addIngredient(new Ingredient("taco meat filling", 2, UnitConverter.Unit.CUP));
        ingredientList.addIngredient(new Ingredient("shredded triple cheddar cheese", 2, UnitConverter.Unit.CUP));

        recipeBuilder.setIngredientList(ingredientList);

        categories = new ArrayList<Category>();
        categories.add(cPool.getCategory(Category.Type.RECIPE,"mexican"));
        categories.add(cPool.getCategory(Category.Type.RECIPE,"party"));
        recipeBuilder.setCategories(categories);

        demoRecipe4 = recipeBuilder.build();
        recipeBook.addRecipe(demoRecipe4);

        //Demo recipe 5
        Recipe demoRecipe5;

        recipeBuilder = new RecipeBuilder("Simple spaghetti")
        .setDescription("A quick and easy dinner.")
        .setServingSize(2);

        instructions = new ArrayList<String>();
        instructions.add("Pour water in a bowl");
        instructions.add("...(pretend more instructions here)...");
        instructions.add("...enjoy!");

        recipeBuilder.setInstructions(instructions);

        ingredientList = new IngredientList();
        ingredientList.addIngredient(new Ingredient("spaghetti", 5, UnitConverter.Unit.OUNCE));
        ingredientList.addIngredient(new Ingredient("spaghetti sauce", 3, UnitConverter.Unit.TABLESPOON));

        recipeBuilder.setIngredientList(ingredientList);

        categories = new ArrayList<Category>();
        categories.add(cPool.getCategory(Category.Type.RECIPE,"italian"));
        categories.add(cPool.getCategory(Category.Type.RECIPE,"simple"));
        recipeBuilder.setCategories(categories);

        demoRecipe5 = recipeBuilder.build();
        recipeBook.addRecipe(demoRecipe5);

        //Demo recipe 6
        Recipe demoRecipe6;

        recipeBuilder = new RecipeBuilder("Big breakfast")
        .setDescription("A hearty start to a great day.")
        .setServingSize(2);

        instructions = new ArrayList<String>();
        instructions.add("Get out a nonstick pan...");
        instructions.add("...(pretend more instructions here)...");
        instructions.add("...enjoy!");

        recipeBuilder.setInstructions(instructions);

        ingredientList = new IngredientList();
        ingredientList.addIngredient(new Ingredient("bacon", 4, UnitConverter.Unit.NONE));
        ingredientList.addIngredient(new Ingredient("egg", 6, UnitConverter.Unit.NONE));
        ingredientList.addIngredient(new Ingredient("whole wheat bread", 2, UnitConverter.Unit.NONE));
        ingredientList.addIngredient(new Ingredient("grape jelly", 2, UnitConverter.Unit.TEASPOON));

        recipeBuilder.setIngredientList(ingredientList);

        categories = new ArrayList<Category>();
        categories.add(cPool.getCategory(Category.Type.RECIPE,"breakfast"));
        recipeBuilder.setCategories(categories);

        demoRecipe6 = recipeBuilder.build();
        recipeBook.addRecipe(demoRecipe6);

        //Demo recipe 7
        Recipe demoRecipe7;

        recipeBuilder = new RecipeBuilder("Homemade pizza")
        .setDescription("Literally the best dish ever created.")
        .setServingSize(2);

        instructions = new ArrayList<String>();
        instructions.add("Get out a pizza pan...");
        instructions.add("...(pretend more instructions here)...");
        instructions.add("...enjoy!");

        recipeBuilder.setInstructions(instructions);

        ingredientList = new IngredientList();
        ingredientList.addIngredient(new Ingredient("pizza dough", 200, UnitConverter.Unit.GRAM));
        ingredientList.addIngredient(new Ingredient("marinara sauce", 3, UnitConverter.Unit.TABLESPOON));
        ingredientList.addIngredient(new Ingredient("shredded mozzarella", 0.5, UnitConverter.Unit.CUP));
        ingredientList.addIngredient(new Ingredient("pepperoni", 12, UnitConverter.Unit.NONE));

        recipeBuilder.setIngredientList(ingredientList);

        categories = new ArrayList<Category>();
        categories.add(cPool.getCategory(Category.Type.RECIPE,"italian"));
        recipeBuilder.setCategories(categories);

        demoRecipe7 = recipeBuilder.build();
        recipeBook.addRecipe(demoRecipe7);

        user.setRecipeBook(recipeBook);

        //======================================================================================================
        //Populate the mealplanner with a series of mealplans

        //Mealplan 1
        MealPlan demoMP1 = new MealPlan("Saturday Meals");
        demoMP1.setMealPlanDescription("Just some meals for my day off");
        demoMP1.addMeal(new Meal(demoRecipe6));
        demoMP1.addMeal(new Meal(demoRecipe1));
        demoMP1.addMeal(new Meal(demoRecipe7));

        //Mealplan 2
        MealPlan demoMP2 = new MealPlan("Some meals");
        demoMP2.setMealPlanDescription("These don't go together at all but I need more for the demo");
        demoMP2.addMeal(new Meal(demoRecipe6));
        demoMP2.addMeal(new Meal(demoRecipe5));
        demoMP2.addMeal(new Meal(demoRecipe4));
        demoMP2.addMeal(new Meal(demoRecipe2));

        MealPlanner mp = new MealPlanner();
        mp.addMealPlan(demoMP1);
        mp.addMealPlan(demoMP2);

        user.setMealPlanner(mp);

        //======================================================================================================
        //Populate GroceryList with some ingredients used in demo recipes
        
        //IngredientList 1
        IngredientList iList = new IngredientList();
        iList.addIngredient(new Ingredient("cheese", 2, Unit.NONE));
        iList.addIngredient(new Ingredient("macaroni", 3, Unit.CUP));
        iList.addIngredient(new Ingredient("potatoes", 17, Unit.NONE));
        iList.addIngredient(new Ingredient("butter", 2, Unit.TEASPOON));

        GroceryList gList = new GroceryList();
        gList.setIngredientList(iList);

        user.setGroceryList(gList);
    }
}
