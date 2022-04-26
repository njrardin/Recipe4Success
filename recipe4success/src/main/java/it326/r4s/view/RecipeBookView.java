package it326.r4s.view;

import java.util.Scanner;
import it326.r4s.controller.RecipeBookController;
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
                    rbController.viewRecipes();
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

}
