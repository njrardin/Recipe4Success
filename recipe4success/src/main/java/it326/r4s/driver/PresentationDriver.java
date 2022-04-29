package it326.r4s.driver;

import java.util.ArrayList;

import it326.r4s.controller.MainMenuController;
import it326.r4s.controller.UserController;
import it326.r4s.model.Category;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.MealPlanner;
import it326.r4s.model.RecipeBook;
import it326.r4s.model.UnitConverter;
import it326.r4s.model.User;
import it326.r4s.model.Recipe.RecipeBuilder;
import it326.r4s.view.ViewUtilities;

/**
 * Controller for R4S RecipeBook
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class PresentationDriver {
    public static void main(String[] args) {     
        
        displayWelcome();

        launchProgram();

        saveAndExit();
    }

    private static void displayWelcome(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                      -- WELCOME TO RECIPES 4 SUCCESS! --                      ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private static void launchProgram(){
        
        User user = prepopulateUser();
        
        UserController.initUserController(user);
        UserController userController = UserController.getUserController();

        MainMenuController mmController = new MainMenuController(userController);
        
        mmController.launchMainMenu();
    }

    
    private static void saveAndExit() {
        //TODO: Save data from application before exit
        
        System.out.println("Thank you for using Recipe4Success!");
        System.out.println("\n\tapplication exiting...\n\n");
        
        ViewUtilities.scan.close();
        System.exit(0);
    }
    
    private static User prepopulateUser() {
        User user = new User("Rishi Saripalle");

        user.setRecipeBook(prepopulateRecipeBook());
        user.setMealPlanner(prepopulateMealPlanner());

        return user;
    }

    private static RecipeBook prepopulateRecipeBook() {

        //Demo recipe 1
        RecipeBook recipeBook = new RecipeBook();

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
        ingredientList.addIngredient(new Ingredient("Cheese", 2, UnitConverter.Unit.NONE));
        ingredientList.addIngredient(new Ingredient("Macaroni", 4, UnitConverter.Unit.CUP));

        recipeBuilder.setIngredientList(ingredientList);

        recipeBook.addRecipe(recipeBuilder.build());

        //Demo recipe 2
        recipeBuilder = new RecipeBuilder("Cupcakes")
        .setDescription("A great desert")
        .setServingSize(2);

        instructions = new ArrayList<String>();
        instructions.add("Pour cupcake batter");
        instructions.add("bake the cupcakes for 15 minutes at 350 degrees");

        recipeBuilder.setInstructions(instructions);

        ingredientList = new IngredientList();
        ingredientList.addIngredient(new Ingredient("Cupcake batter", 4, UnitConverter.Unit.CUP));
        ingredientList.addIngredient(new Ingredient("Cupcake icing", 2, UnitConverter.Unit.TABLESPOON));

        recipeBuilder.setIngredientList(ingredientList);

        recipeBook.addRecipe(recipeBuilder.build());

        //Demo recipe 3
        recipeBuilder = new RecipeBuilder("Grammy's mashed potatoes")
        .setDescription("The yummy taters my grandma used to make.")
        .setServingSize(4);

        instructions = new ArrayList<String>();
        instructions.add("Take 3 potatoes...");
        instructions.add("...(pretend more instructions here)...");
        instructions.add("...and now you have potatoes!");

        recipeBuilder.setInstructions(instructions);

        ingredientList = new IngredientList();
        ingredientList.addIngredient(new Ingredient("Potatoes", 8, UnitConverter.Unit.NONE));
        ingredientList.addIngredient(new Ingredient("Butter", 1, UnitConverter.Unit.TEASPOON));

        recipeBuilder.setIngredientList(ingredientList);

        ArrayList<Category> categories = new ArrayList<Category>();
        categories.add(new Category("vegan"));
        recipeBuilder.setCategories(categories);

        recipeBook.addRecipe(recipeBuilder.build());

        return recipeBook;
    }

    private static MealPlanner prepopulateMealPlanner(){
        //TODO: This
        return new MealPlanner();
    }

}
