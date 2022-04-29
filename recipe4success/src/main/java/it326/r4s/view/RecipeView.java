package it326.r4s.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import com.google.gson.internal.sql.SqlTypesSupport;

import it326.r4s.controller.RecipeController;
import it326.r4s.controller.UnitController;
import it326.r4s.controller.UserController;
import it326.r4s.controller.RecipeController.RecipeBuilderController;
import it326.r4s.model.Category;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.UnitConverter.Unit;

/**
 * View for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeView implements CLI_Menu{

    //*Instance Variables*\\
    private RecipeController recipeController;

    //*Constructor*\\
    /**
     * Constructs a recipeView from its controller
     * @param recipeController - the RecipeView's controller
     */
    public RecipeView(RecipeController recipeController){
        this.recipeController = recipeController;
    }

    //*Methods*\\
    /**
     * Displays the recipe to the screen
     */
    public void displayRecipe(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Name: " + recipeController.getRecipe().getName());
        System.out.println("Description: " + recipeController.getRecipe().getDescription());
        System.out.println("Serving Size: " + recipeController.getRecipe().getServingSize());
        System.out.println("Created on: " + recipeController.getRecipe().getCreatedOn());
        System.out.println("Your rating: " + retUserRating() + "/5 stars");
        System.out.println();
        System.out.println("Ingredients: ");
        displayIngredients();
        System.out.println();
        System.out.println("Instructions: ");
        displayInstructions();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");   
    } 
    //TODO: behaviour to handle null values and format date better
    
    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        String title = "Recipe: " + recipeController.getRecipe().getName();
        String prompt = "What would you like to do?";
        String[] options = {
            "Edit recipe",
            "Rate this recipe",
            "Adjust serving size",
            "Export this recipe",
            "Delete this recipe",
            "Re-Display Recipe",
            "Go back"
        };
        return ViewUtilities.getOptionFromCLI(title, prompt, options);
    }
    
    /**
     * Allows the user to select one of a series of edit options
     * @return an int representing the selected option
     */
    public int getEditOptionSelection(){
        String title = "Recipe: " + recipeController.getRecipe().getName() + " (edit options)";
        String prompt = "What would you like to edit?";
        String[] options = {
            "Name",
            "Description",
            "Serving Size",
            "Ingredients",
            "Instructions",
            "Go back",
        };
        return ViewUtilities.getOptionFromCLI(title, prompt, options);
    }

    /**
     * Displays a message declaring the update to be a success
     */
    public void displayUpdateSuccess() {
        System.out.println("You successfully updated " + recipeController.getRecipe().getName());
    }

    /**
     * Displays the ingredients of the recipe
     */
    private void displayIngredients() {
        recipeController.getIngredientListController().getIngredientListView().displayIngredients();
    }
    
    /**
     * Displays the recipe's instructions
     */
    private void displayInstructions() {
        ArrayList<String > instructions = recipeController.getRecipe().getInstructions();

        int instNum = 1;
        for(String instruction: instructions){
            System.out.println(instNum + ") " + instruction);
            instNum++;
        }
    }

    /**
     * Gets the recipe's overall rating
     * @return
     */
    private String retUserRating(){
        try{
            return String.valueOf(recipeController.getRecipe().getReviews().get(0).getRatingValue());
        } catch (Exception e) {
            return "none";
        }
    }

    /**
     * Gets from the user a 1-5 star rating for the recipe
     * @return an int representing the rating
     */
    public int getReviewRating(){
        Scanner scan = ViewUtilities.scan;
        int acceptableRatings[] = {1,2,3,4,5};
        int ratingNum;

        do{
            System.out.println("How many stars would you like to rate this recipe? (1, 2, 3, 4, or 5)");
            ratingNum = Integer.parseInt(scan.nextLine());
        } while (Arrays.asList(acceptableRatings).contains(ratingNum));

        System.out.println("You have successfully rated " + recipeController.getRecipe().getName() + " with a total of " + ratingNum + "/5 stars.");
        return ratingNum;
    }

    /**
     * Displays the recipe in a one line format
     */
    public void displayOneline() {
        System.out.println(recipeController.getRecipe().toString());
    }

    /**
     * Asks of the user a confirmation of deletion
     * @return true if confirmed to delete, false if deletion denied
     */
    public boolean deletionConfirmation() {
        Scanner scan = ViewUtilities.scan;
        String input = "";
        do{
            System.out.println("Are you sure you want to delete " + recipeController.getRecipe().getName() + " from your recipe book? (Y/N)");
            input = scan.nextLine().toLowerCase();
        }  while ( !(input.equals("y") || input.equals("n") ));

        if(input.equals("n")){
            return false;
        }
        else{
            System.out.println("...deleting " + recipeController.getRecipe().getName());
            return true;
        }

    }

    /**
     * View for R4S RecipeBuilder
     * @author Nate Rardin (njrardi@ilstu.edu)
     * @date 4/27/22
     */
    public static class RecipeBuilderView{

        //*Instance Variables*\\
        private RecipeBuilderController rBuildController;

        //*Constructor*\\
        /**
         * Constructs a RecipeBuilderView from its controller
         * @param rBuildController - the RecipeBuilderView's controller
         */
        public RecipeBuilderView(RecipeBuilderController rBuildController){
            this.rBuildController = rBuildController;
        }
        
        //*Methods*\\
        /**
         * Displays a message at the initialization of a recipe build process
         */
        public static void displayRecipeBuildInit(){
            System.out.println("Alright "  + UserController.getUserController().getGlobalUser().getName() + "!");
            System.out.println("Let's create a recipe!");
        }

        /**
         * Prompts the user for the recipe's name
         * @return the recipes name
         */
        public static String getRecipeNameFromUser(){
            Scanner scan = ViewUtilities.scan;
            String name = "";

            while(true){
                System.out.println("\nPlease provide the recipe's name:");
                name = scan.nextLine();
                if(name != ""){
                    System.out.println("You provided the name \"" + name + ",\" is this correct? (Y/N)");
                    if(scan.nextLine().toLowerCase().equals("y")){
                        return name;
                    }
                }
            }
        }

        /**
         * Prompts the user for the recipe's description
         * @return the recipes description
         */
		public static String getDescriptionFromUser() {
            Scanner scan = ViewUtilities.scan;
            String description = "";
            while(true){
                System.out.println("Please provide a description for the recipe");
                description = scan.nextLine();
    
                System.out.println("You provided the description\n\n \"" 
    
                + description + 
    
                "\"\n\n is this correct? (Y/N)");
    
                if(scan.nextLine().toLowerCase().equals("y")){
                    return description;
                }
            }
		}

        /**
         * Prompts the user for the recipe's serving size
         * @return the recipes serving size
         */
		public static int getServingSizeFromUser() {
            Scanner scan = ViewUtilities.scan;
            int servingSize;
            while(true){
                System.out.println("How many people does this recipe serve?");
                try{
                    servingSize = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    continue;
                }
                if(servingSize <=0){
                    System.out.println("Serving size must be greater than 0.");
                    continue;
                }
            
                System.out.println("You provided a serving-size of \"" + servingSize + "\" is this correct? (Y/N)");
                if(scan.nextLine().toLowerCase().equals("y")){
                    return servingSize;
                }
            }
		}

        /**
         * Prompts the user for the recipe's instructions
         * @return the recipes name
         */
		public static ArrayList<String> getInstructionsFromUser() {
            Scanner scan = ViewUtilities.scan;
            String resp = "";
            String instructionString;
            ArrayList<String> instructions = new ArrayList<String>();

            //loop to allow multiple instructions to be added
            int stepNum = 1;
            System.out.println("Now let's write the instruction steps for the recipe.");
            while(true){
                if(stepNum == 1){
                    System.out.println("What is the first step in creating the recipe?\n");
                }
                else{
                    System.out.println("What is the next step in creating the recipe?\n");
                }
    
                instructionString = scan.nextLine();
                
                //confirming each step's correctness
                System.out.println("You provided step #" + stepNum + " as\n\n \"" 
    
                + instructionString + 
    
                "\"\n\nis this correct? (Y/N)");
                resp = scan.nextLine().toLowerCase();
                if(resp.equals("y")){
                    instructions.add(instructionString);
                    stepNum++;
                }
                else{
                    continue;
                }
    
                //check to see if the user wishes to add another step
                do {
                    System.out.println("Would you like to add another step? (Y/N)");
                    resp = scan.nextLine().toLowerCase();
                } while (!(resp.equals("y") || resp.equals("n")));
                
                if(resp.equals("n")){
                    return instructions; //returns the instructions after confirming there are no more to be added
                }
            }
		}

        /**
         * Prompts the user for the recipe's ingredients
         * @return the recipes name
         */
		public static IngredientList getIngredientsFromUser() {
            Scanner scan = ViewUtilities.scan;
            String resp = "";

            String ingredientName;
            double ingredientQuantity;
            Unit unit;

            IngredientList ingredientList = new IngredientList();

            //loop to allow multiple instructions to be added
            int ingredientNum = 1;
            System.out.println("Now let's add the recipe's ingredients.");
            while(true){
                //get ingredient name
                if(ingredientNum == 1){
                    System.out.println("What is the first ingredient?\n");
                }
                else{
                    System.out.println("What is the next ingredient?\n");
                }
                ingredientName = scan.nextLine().toLowerCase();

                //get the unit
                System.out.println("What is the unit of measure for " + ingredientName + "?");
                unit = UnitController.getUnit();

                //get the quantity
                System.out.println("How many " + unit.stringRep + "s are used?");
                ingredientQuantity = Double.parseDouble(scan.nextLine());
                
                //confirm accuracy
                System.out.println("You provided ingredient #" + ingredientNum + " as\n\n \"" 
    
                + ingredientQuantity + " " + unit.stringRep + "s of " + ingredientName +
    
                "\"\n\n is this correct? (Y/N)");
                resp = scan.nextLine().toLowerCase();
                if(resp.equals("y")){

                    ingredientList.addIngredient(new Ingredient(ingredientName, ingredientQuantity, unit));
                    ingredientNum++;
                }
                else{
                    continue;
                }
                
                //check to see if the user wishes to add another step
                do {
                    System.out.println("Would you like to add another ingredient? (Y/N)");
                    resp = scan.nextLine().toLowerCase();
                } while (!(resp.equals("y") || resp.equals("n")));
                
                if(resp.equals("n")){
                    return ingredientList;
                }
    
            }
		}

        /**
         * Prompts the user for the recipe's ingredients
         * @return the recipes name
         */
		public static ArrayList<Category> getCategoriesFromUser() {
            Scanner scan = ViewUtilities.scan;
            String resp = "";
            String categoryString;
            ArrayList<Category> categories = new ArrayList<Category>();


            do{
                System.out.println("Would you like to add any categories? (Y/N)");
                resp = scan.nextLine().toLowerCase();
            }while (!(resp.equals("y") || resp.equals("n")));
            if(resp.equals("n")){
                return categories;
            }

            //loop to allow multiple instructions to be added
            int categoryNum = 1;
            System.out.println("Alright, let's add some categories for the recipe.");
            while(true){
                if(categoryNum == 1){
                    System.out.println("What would you like to call the first category?\n");
                }
                else{
                    System.out.println("What would you like to call the next category?\n");
                }
    
                categoryString = scan.nextLine();
                
                //confirm accuracy
                System.out.println("You provided the category " 
    
                + categoryString + 
    
                ". Is this correct? (Y/N)");
                resp = scan.nextLine().toLowerCase();
                if(resp.equals("y")){
                    categories.add(new Category(categoryString));
                    categoryNum++;
                }
                else{
                    continue;
                }
                
                //check if adding another category
                do {
                    System.out.println("Would you like to add another category? (Y/N)");
                    resp = scan.nextLine().toLowerCase();
                } while (!(resp.equals("y") || resp.equals("n")));
                
                if(resp.equals("n")){
                    return categories; //return categories upon confirmation
                }
    
            }
		}

        /**
         * Confirms build with user
         * @return true if confirmed, false if not
         */
		public static boolean confirmBuild() {
            Scanner scan = ViewUtilities.scan;
            String resp = "";
            //TODO: implement or delete this
			return true;
		}

    }

}
