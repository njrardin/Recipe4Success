package it326.r4s.view;

import java.util.Collection;

import it326.r4s.controller.RecipeBookController;
import it326.r4s.controller.RecipeController;
import it326.r4s.view.utilities.DisplayUtils;
import it326.r4s.view.utilities.InputAccess;
/**
 * View for R4S RecipeBook
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeBookView implements R4SMenu {
    
    //*Instance Variables*\\
    private RecipeBookController rbController;

    //*Constructor*\\
    /**
     * Constructs a RecipeBookView from its controller
     * @param rbController - the RecipeBookView's controller
     */
    public RecipeBookView(RecipeBookController rbController){
        this.rbController = rbController;
    }

    //*Methods*\\
    /**
     * Displays the Recipe Book header to the user
     */
    public void displayHeader(){
        System.out.println(DisplayUtils.getHeader("Recipe Book"));
    }

    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        String title = "Recipe Book Options";
        String prompt = "What would you like to do?";
        String[] options = {
            "Search and filter recipes",
            "Import a recipe",
            "Export a recipe",
            "Create a new recipe",
            "Select a recipe",
            "Go back"
        };
        InputAccess inputAccess = new InputAccess();
        return inputAccess.getOptionSelection(title, prompt, options);
    }

    /**
     * Displays the full recipeBook to the user
     */
    public void displayRecipeBook() {
        displayRecipes(rbController.getRecipeControllers());
    }

    /**
     * Displays to the user all recipes in a given
     * list of recipeControllers
     * @param recipeControllers - recipeControllers which are associated with the recipes to display
     */
    public void displayRecipes(Collection<RecipeController> recipeControllers){
        System.out.println("Recipes:");
        System.out.println(DisplayUtils.HYPHEN_DIVIDER);
        int i = 1;
        for(RecipeController recipeController: recipeControllers){
            System.out.print(i + ") ");
            recipeController.getRecipeView().displayOneline();
            i++;
        }
        System.out.println(DisplayUtils.HYPHEN_DIVIDER);
    }

    /**
     * Displays a series of recipes and allows the user to select one
     * @param recipeControllers - an ArrayList of RecipeControllers to present as selection options to the user
     * @return the RecipeController who's recipe was selected
     * @throws RuntimeException - if the user aborts the selection process
     */
    public RecipeController getRecipeSelection(Collection<RecipeController> recipeControllers) throws RuntimeException{    
        displayRecipes(recipeControllers);
        if (askSelectRecipe() == false){
            throw new RuntimeException();
        }    

        //Selection loop; only exits once a valid recipe is selcted
        String input;
        int inputNum = -1;
        InputAccess inputAccess = new InputAccess();
        do{
            System.out.println("\n Which recipe would you like to select?");
            System.out.print("(please type the selection number or type \"exit\" to go back) : ");

            input = inputAccess.getInputLine();
            if(input.toLowerCase().equals("exit")){
                throw new RuntimeException();
            }

            try{
                inputNum = Integer.parseInt(input);
            } catch (Exception e){
                System.out.println("Invalid selection, selection must be a number.");
                continue;
            }
            
            if (inputNum <= 0 || recipeControllers.size() < inputNum){
                System.out.println("Invalid selection, selection out of range.");
            }

        } while(inputNum <= 0 || recipeControllers.size() < inputNum);

        //returns the selected RecipeController
        return (RecipeController) recipeControllers.toArray()[inputNum - 1];
    }

    /**
     * A confirmation option for selecting a recipe
     * @return true if confirmed, false if denied
     */
    private static boolean askSelectRecipe() {
        InputAccess inputAccess = new InputAccess();
        String response = "";
        do{
        System.out.print("Would you like to select a recipe? (Y/N) : ");
        response = inputAccess.getInputLine().toLowerCase();
        } while ( !(response.equals("y") || response.equals("n")) );
        if(response.equals("n")){
            return false;
        }
        return true;
    }

}
