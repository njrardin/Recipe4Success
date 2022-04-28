package it326.r4s.view;

import java.util.ArrayList;
import java.util.Scanner;
import it326.r4s.controller.RecipeBookController;
import it326.r4s.controller.RecipeController;
/**
 * View for R4S RecipeBook
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeBookView implements CLI_Menu {
    
    private RecipeBookController rbController;

    public RecipeBookView(RecipeBookController rbController){
        this.rbController = rbController;
    }

    public void displayHeader(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                               -- Recipe Book --                               ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();
    }

    public int getMenuOptionSelection(){
        String title = "Recipe Book";
        String prompt = "What would you like to do?";
        String[] options = {
            "Search and filter recipes",
            "Import a recipe",
            "Export a recipe",
            "Create a new recipe",
            "View/Select recipes",
            "Go back"
        };
        return ViewUtilities.getOptionFromCLI(title, prompt, options);
    }

    public void displayRecipes(ArrayList<RecipeController> recipeControllers){
        int i = 1;
        for(RecipeController recipeController: recipeControllers){
            System.out.print(i + ") ");
            recipeController.getRecipeView().displayOneline();
            i++;
        }
    }

    public void displayRecipeBook() {
        displayRecipes(rbController.getRecipeControllers());
    }


    public RecipeController getRecipeSelection(ArrayList<RecipeController> recipeControllers) throws RuntimeException{    
        displayRecipes(recipeControllers);
        if (askSelectRecipe() == false){ //TODO: use menu system to do this
            throw new RuntimeException();
        }    

        String input;
        int inputNum = -1;

        Scanner scan = ViewUtilities.scan;
        do{
            System.out.println("\n Which recipe would you like to select?");
            System.out.println("(please type the selection number or type \"exit\" to go back)");

            input = scan.nextLine();
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

        return recipeControllers.get(inputNum - 1);
    }

    private boolean askSelectRecipe() {
        Scanner scan = ViewUtilities.scan;
        String input = "";
        do{
        System.out.println("Would you like to select a recipe? (Y/N)");
        input = scan.nextLine().toLowerCase();
        } while ( !(input.equals("y") || input.equals("n")) );
        if(input.equals("n")){
            return false;
        }
        return true;
    }

}
