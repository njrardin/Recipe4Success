package it326.r4s.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import it326.r4s.controller.RecipeController;
import it326.r4s.controller.UnitController;
import it326.r4s.model.Category;
import it326.r4s.model.Review;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.UnitConverter.Unit;
import it326.r4s.view.utilities.InputAccess;

/**
 * View for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeView implements R4SMenu{

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
        System.out.println("Your rating: " + getRecipeRating());
        System.out.println();
        System.out.println("Ingredients: ");
        displayIngredients();
        System.out.println();
        System.out.println("Instructions: ");
        displayInstructions();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");   
    } 
    //TODO: behavior to handle null values and format date better
    
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
        InputAccess inputAccess = new InputAccess();
        return inputAccess.getOptionSelection(title, prompt, options);
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
        InputAccess inputAccess = new InputAccess();
        return inputAccess.getOptionSelection(title, prompt, options);
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
        Collection<String> instructions = recipeController.getRecipe().getInstructions();

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
    private String getRecipeRating(){
        try{
            return String.valueOf(((Review) recipeController.getRecipe().getReviews().toArray()[0]).getRatingValue());
        } catch (Exception e) {
            return "none";
        }
    }

    /**
     * Gets from the user a 1-5 star rating for the recipe
     * @return an int representing the rating
     */
    public int getRatingFromUser(){
        InputAccess inputAccess = new InputAccess();
        Integer[] acceptableRatings = {1, 2, 3, 4, 5};
        Collection<Integer> acceptableRatingsList = Arrays.asList(acceptableRatings);
        int ratingNum;

        do{
            System.out.print("How many stars would you like to rate this recipe? (1, 2, 3, 4, or 5) : ");
            ratingNum = Integer.parseInt(inputAccess.getInputLine());
        } while (!acceptableRatingsList.contains(ratingNum));

        System.out.println("You have successfully rated " + recipeController.getRecipe().getName() + " with a total of " + ratingNum + "/5 stars.");
        return ratingNum;
    }

    /**
     * Displays the recipe in a one line format
     */
    public void displayOneLine() {
        System.out.println(recipeController.getRecipe().toString());
    }

    /**
     * Asks of the user a confirmation of deletion
     * @return true if confirmed to delete, false if deletion denied
     */
    public boolean deletionConfirmation() {
        InputAccess inputAccess = new InputAccess();
        String input = "";
        do{
            System.out.print("Are you sure you want to delete " + recipeController.getRecipe().getName() + " from your recipe book? " 
            + "(this includes any instance of this recipe in a mealplan) (Y/N): ");
            input = inputAccess.getInputLine().toLowerCase();
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

        //*Methods*\\
        /**
         * Displays a message at the initialization of a recipe build process
         */
        public static void displayRecipeBuildInit(){
            System.out.println("Alright!, Let's create a recipe!");
        }

        /**
         * Prompts the user for the recipe's name
         * @return the recipes name
         */
        public static String getRecipeNameFromUser(){
            InputAccess inputAccess = new InputAccess();
            String name = "";

            while(true){
                System.out.print("\nPlease provide the recipe's name: ");
                name = inputAccess.getInputLine();
                if(!name.equals("")){
                    System.out.print("You provided the name \"" + name + "\", is this correct? (Y/N) : ");
                    if(inputAccess.getInputLine().toLowerCase().equals("y")){
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
            InputAccess inputAccess = new InputAccess();
            String description = "";
            while(true){
                System.out.println("Please provide a description for the recipe:");
                description = inputAccess.getInputLine();
    
                System.out.println("You provided the description -\n\n \"" 
    
                + description + 
    
                "\"\n\n - is this correct? (Y/N) : ");
    
                if(inputAccess.getInputLine().toLowerCase().equals("y")){
                    return description;
                }
            }
		}

        /**
         * Prompts the user for the recipe's serving size
         * @return the recipes serving size
         */
		public static int getServingSizeFromUser() {
            InputAccess inputAccess = new InputAccess();
            int servingSize;
            while(true){
                System.out.print("How many people does this recipe serve? : ");
                try{
                    servingSize = Integer.parseInt(inputAccess.getInputLine());
                } catch (NumberFormatException e) {
                    continue;
                }
                if(servingSize <=0){
                    System.out.println("Serving size must be greater than 0.");
                    continue;
                }
            
                System.out.print("You provided a serving-size of \"" + servingSize + "\" is this correct? (Y/N) : ");
                if(inputAccess.getInputLine().toLowerCase().equals("y")){
                    return servingSize;
                }
            }
		}

        /**
         * Prompts the user for the recipe's instructions
         * @return the recipes name
         */
		public static ArrayList<String> getInstructionsFromUser() {
            InputAccess inputAccess = new InputAccess();
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
    
                instructionString = inputAccess.getInputLine();
                
                //confirming each step's correctness
                System.out.print("You provided step #" + stepNum + " as\n\n \"" 
    
                + instructionString + 
    
                "\"\n\nis this correct? (Y/N) : ");
                resp = inputAccess.getInputLine().toLowerCase();
                if(resp.equals("y")){
                    instructions.add(instructionString);
                    stepNum++;
                }
                else{
                    continue;
                }
    
                //check to see if the user wishes to add another step
                do {
                    System.out.print("Would you like to add another step? (Y/N) : ");
                    resp = inputAccess.getInputLine().toLowerCase();
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
            InputAccess inputAccess = new InputAccess();
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
                    System.out.print("What is the first ingredient? : ");
                }
                else{
                    System.out.print("What is the next ingredient? : ");
                }
                ingredientName = inputAccess.getInputLine().toLowerCase();

                //get the unit
                System.out.println("What is the unit of measure for " + ingredientName + "? : ");
                unit = UnitController.getUnit();

                //get the quantity
                System.out.print("How many " + unit.stringRep + "s are used? : ");
                ingredientQuantity = -1;
                do{
                    try{
                        ingredientQuantity = Double.parseDouble(inputAccess.getInputLine());
                        break;
                    } catch (Exception e) {
                        System.out.print("Please enter a quantity in integer or decimal form: ");
                        continue;
                    }
                } while(true);
                
                //confirm accuracy
                System.out.print("You provided ingredient #" + ingredientNum + " as\n\n \"" 
    
                + ingredientQuantity + " " + unit.stringRep + "s of " + ingredientName +
    
                "\"\n\n is this correct? (Y/N) : ");
                resp = inputAccess.getInputLine().toLowerCase();
                if(resp.equals("y")){

                    ingredientList.addIngredient(new Ingredient(ingredientName, ingredientQuantity, unit));
                    ingredientNum++;
                }
                else{
                    continue;
                }
                
                //check to see if the user wishes to add another step
                do {
                    System.out.print("Would you like to add another ingredient? (Y/N) : ");
                    resp = inputAccess.getInputLine().toLowerCase();
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
            InputAccess inputAccess = new InputAccess();
            String resp = "";
            String categoryString;
            Category.Pool cPool = Category.Pool.getInstance();
            ArrayList<Category> categories = new ArrayList<Category>();

            do{
                System.out.print("Would you like to add any categories? (Y/N) : ");
                resp = inputAccess.getInputLine().toLowerCase();
            }while (!(resp.equals("y") || resp.equals("n")));
            if(resp.equals("n")){
                return categories;
            }

            //loop to allow multiple instructions to be added
            int categoryNum = 1;
            System.out.println("Alright, let's add some categories for the recipe.");
            while(true){
                if(categoryNum == 1){
                    System.out.print("What would you like to call the first category? : ");
                }
                else{
                    System.out.print("What would you like to call the next category? : ");
                }
    
                categoryString = inputAccess.getInputLine();
                
                //confirm accuracy
                System.out.print("You provided the category \"" 
    
                + categoryString + 
    
                "\". Is this correct? (Y/N) : ");
                resp = inputAccess.getInputLine().toLowerCase();
                if(resp.equals("y")){
                    categories.add(cPool.getCategory(Category.Type.RECIPE, categoryString));
                    categoryNum++;
                }
                else{
                    continue;
                }
                
                //check if adding another category
                do {
                    System.out.print("Would you like to add another category? (Y/N) : ");
                    resp = inputAccess.getInputLine().toLowerCase();
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
            InputAccess inputAccess = new InputAccess();
            String resp = "";
            System.out.println("\nRecipe construction complete.\n");
            do {
                System.out.print("Please confirm the addition of this recipe to your Recipe Book. (Y/N) : ");
                resp = inputAccess.getInputLine().toLowerCase();
            } while (!(resp.equals("y") || resp.equals("n")));
            if (resp.equals("n")) {
                return false;
            }
            return true;
		}

    }

}
