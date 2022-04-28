package it326.r4s.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import it326.r4s.controller.RecipeController;
import it326.r4s.controller.UserController;
import it326.r4s.controller.RecipeController.RecipeBuilderController;
import it326.r4s.model.Category;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.Recipe;
import it326.r4s.model.UnitConverter.Unit;

/**
 * View for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeView implements CLI_View{

    private RecipeController recipeController;

    public RecipeView(RecipeController recipeController){
        this.recipeController = recipeController;
    }
    
    public void execute(){
        String input = "";
        Scanner scan = ViewUtilities.scan;
        displayRecipe();
        displayRecipeOptions();

        while(true){
            System.out.println("Please type the number corresponding to the option you wish to select: ");
            System.out.println("(to see the options again, type \"options\")");
    
            input = scan.nextLine().toLowerCase();
            System.out.println();
            switch (input) {
                case "1":
                    recipeController.editRecipe();
                    break;
                case "2":
                    recipeController.addReview(UserController.getGlobalUser());
                    break;
                case "3":
                    recipeController.adjustServingSize(this.getNewServingSize());
                    break;
                case "4":
                    recipeController.exportRecipe();
                    break;
                case "5":
                    recipeController.deleteRecipe();
                    return;
                case "6":
                    displayRecipe();
                    break;
                case "7":
                    return;
                case "options":
                    displayRecipeOptions();
                    break;
                case "back":
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            displayRecipe();
            displayRecipeOptions();
        }
    }

    public void displayRecipe(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Name: " + recipeController.getRecipe().getName());
        System.out.println("Description: " + recipeController.getRecipe().getDescription());
        System.out.println("Serving Size: " + recipeController.getRecipe().getServingSize());
        System.out.println("Created on: " + recipeController.getRecipe().getCreatedOn());
        System.out.println("Your rating: " + getUserRating() + " /5 stars");
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
    //TODO: also add a rating display

    public void displayRecipeOptions(){
        System.out.println("");
        System.out.println("                               -- Recipe Options --                                  ");
        System.out.println("");
        System.out.println("1) Edit recipe");
        System.out.println("2) Rate this recipe");
        System.out.println("3) Adjust serving size");
        System.out.println("4) Export this recipe");
        System.out.println("5) Delete this recipe");
        System.out.println("6) Re-Display Recipe");
        System.out.println("7) Go back");
        System.out.println();
    }

    private int getNewServingSize() {
        Scanner scan = ViewUtilities.scan;
        int servingSize = -1;

        do{
            System.out.println("What is the new serving size?");
            try{
                servingSize = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            if(servingSize < 0){
                System.out.println("Serving size must be above 0");
            }
        } while (servingSize < 0);

        return servingSize;
    }

    private void displayIngredients() {
        recipeController.getIngredientListController().getIngredientListView().displayIngredients();
    }
    
    private void displayInstructions() {
        ArrayList<String > instructions = recipeController.getInstructions();

        int instNum = 1;
        for(String instruction: instructions){
            System.out.println(instNum + ") " + instruction);
            instNum++;
        }
    }

    private String getUserRating(){
        try{
            return String.valueOf(recipeController.getRecipe().getReviews().get(0).getRatingValue());
        } catch (Exception e) {
            return "none";
        }
    }

    public void editRecipe(Recipe recipe) {
        
	}

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

    public void displayOneline() {
        System.out.println(recipeController.getRecipe().toString());
    }

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

        private RecipeBuilderController rBuildController;

        public RecipeBuilderView(RecipeBuilderController rBuildController){
            this.rBuildController = rBuildController;
        }
        
        public void displayRecipeBuildInit(){
            System.out.println("Alright "  + UserController.getGlobalUser() + "!");
            System.out.println("Let's create a recipe!");
        }

        public String getRecipeNameFromUser(){
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

		public String getDescriptionFromUser() {
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

		public int getServingSizeFromUser() {
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

		public ArrayList<String> getInstructionsFromUser() {
            Scanner scan = ViewUtilities.scan;
            String resp = "";
            String instructionString;
            ArrayList<String> instructions = new ArrayList<String>();

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
    
                do {
                    System.out.println("Would you like to add another step? (Y/N)");
                    resp = scan.nextLine().toLowerCase();
                } while (!(resp.equals("y") || resp.equals("n")));
                
                if(resp.equals("n")){
                    return instructions;
                }
    
            }
		}

		public IngredientList getIngredientsFromUser() {
            Scanner scan = ViewUtilities.scan;
            String resp = "";

            String ingredientName;
            double ingredientQuantity;
            Unit unit;

            IngredientList ingredientList = new IngredientList();

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
                unit = UnitView.getUnitFromUser();

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
    
                do {
                    System.out.println("Would you like to add another ingredient? (Y/N)");
                    resp = scan.nextLine().toLowerCase();
                } while (!(resp.equals("y") || resp.equals("n")));
                
                if(resp.equals("n")){
                    return ingredientList;
                }
    
            }
		}

		public ArrayList<Category> getCategoriesFromUser() {
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
    
                do {
                    System.out.println("Would you like to add another category? (Y/N)");
                    resp = scan.nextLine().toLowerCase();
                } while (!(resp.equals("y") || resp.equals("n")));
                
                if(resp.equals("n")){
                    return categories;
                }
    
            }
		}

		public boolean confirmBuild() {
            Scanner scan = ViewUtilities.scan;
            String resp = "";
            //TODO: implement or delete this
			return true;
		}

    }

}
