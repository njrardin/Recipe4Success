package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.model.*;

public class RecipeBookView {
    
    public static void ExecuteRecipeBookView(){

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
        System.out.println("");
        System.out.println("(If you would like to go back to the main menu, type \"back\")");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("Please type the number corresponding to ythe option you wish to select: ");

            input = scan.nextLine().toLowerCase();
            System.out.println();
            switch (input) {
                case "1":
                    RecipeBookView.searchRecipes();
                    break;
                case "2":
                    RecipeBookView.importRecipe();
                    break;
                case "3":
                    RecipeBookView.exportRecipe();
                    break;
                case "4":
                    RecipeBookView.createRecipe();
                    break;
                case "back":
                    break;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            break;
        }
        scan.close();
    }

    private static void displayOneline(Recipe recipe){

    }
    
    private static void searchRecipes(){
        
    }
    
    private static void exportRecipe(){
        
    }
    
    private static void importRecipe(){
        
    }

    private static void createRecipe(){

    }
}
