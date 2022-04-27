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
public class RecipeBookView implements CLI_View {
    
    private RecipeBookController rbController;

    public RecipeBookView(RecipeBookController rbController){
        this.rbController = rbController;
    }

    public void execute(){
        String input = "";
        Scanner scan = ViewUtilities.scan;

        displayHeader();
        displayRecipeBook();
        displayOptions();
        while (true) {
            System.out.print("Please type the number corresponding to the option you wish to select: ");
            System.out.println("(to see the options again, type \"options\")");
    
            input = scan.nextLine().toLowerCase();
            System.out.println();
            switch (input) {
                case "1":
                    rbController.searchRecipes();
                    break;
                case "2":
                    rbController.importRecipe();
                    break;
                case "3":
                    rbController.exportRecipe();
                    break;
                case "4":
                    rbController.createRecipe();
                    break;
                case "5":
                    rbController.selectRecipe(rbController.getRecipeBook().getRecipes());
                    break;
                case "6":
                    return;
                case "back":
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            displayOptions();
        }
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

    public void displayHeader(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                               -- Recipe Book --                               ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private static void displayOptions(){
        System.out.println("");
        System.out.println("                               -- Recipe Book Options --                              ");
        System.out.println("");
        System.out.println("1) Search and filter recipes");
        System.out.println("2) Import a recipe");
        System.out.println("3) Export a recipe");
        System.out.println("4) Create a new recipe");
        System.out.println("5) View/Select recipes");
        System.out.println("6) Go back");
        System.out.println();
    }

    public String getSearchQuery() {
        Scanner scan = ViewUtilities.scan;
        String input = "";
        do{
            System.out.println("Please enter the term to search the recipes for:");
            input = scan.nextLine().toLowerCase();
        } while (input == "");

        return input;
    }

    public void displayRecipeBook() {
        displayRecipes(rbController.getRecipeControllers());
    }

    public void displayRecipes(ArrayList<RecipeController> recipeControllers){
        int i = 1;
        for(RecipeController recipeController: recipeControllers){
            System.out.print(i + ") ");
            recipeController.getRecipeView().displayOneline();
            i++;
        }
    }

    public RecipeController displayAndSelect(ArrayList<RecipeController> recipeControllers) throws RuntimeException{    
        displayRecipes(recipeControllers);
        if (askSelectRecipe() == false){
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

}
