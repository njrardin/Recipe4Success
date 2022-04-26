package it326.r4s.view;

import java.util.ArrayList;
import java.util.Scanner;
import it326.r4s.controller.RecipeBookController;
import it326.r4s.controller.RecipeController;
import it326.r4s.model.Recipe;
import it326.r4s.model.RecipeBook;
/**
 * View for R4S RecipeBook
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeBookView implements CLI_View{
    
    private RecipeBookController rbController;

    public RecipeBookView(RecipeBookController rbController){
        this.rbController = rbController;
    }

    public void execute(){
        String input = "";
        Scanner scan = ViewUtilities.scan;

        displayHeader();
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
                    displayRecipeBook(rbController.getRecipeBook());
                    rbController.selectRecipe();
                    break;
                case "6":
                    return;
                case "options":
                    displayOptions();
                case "back":
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            displayOptions();
        }
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
        System.out.println("5) View all recipes");
        System.out.println("6) Go back");
        System.out.println();
    }

    public String getSearchQuery() {
        //TODO: get user input to search for recipe
        return null;
    }

    public void displayRecipeBook(RecipeBook recipeBook) {
        //TODO: Logic to display the recipebook to the screen
    }

    public RecipeController getSelectedRecipe(ArrayList<RecipeController> recipeControllers) throws RuntimeException{
        displayRecipes(recipeControllers);

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
                inputNum = Integer.parseInt(scan.nextLine());
            } catch (Exception e){
                System.out.println("Invalid selection, selection must be a number.");
            }
            
            if (inputNum <= 0 || recipeControllers.size() < inputNum){
                System.out.println("Invalid selection, selection out of range.");
            }
        } while(inputNum <= 0 || recipeControllers.size() < inputNum);

        return recipeControllers.get(inputNum);
    }

    public void displayRecipes(ArrayList<RecipeController> recipeControllers) {
        for(int i = 0; i < recipeControllers.size(); i++){
            System.out.println(i + ") " + recipeControllers.get(i));
        }
    }

}
