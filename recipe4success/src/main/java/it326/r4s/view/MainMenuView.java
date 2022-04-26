package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.MainMenuController;

public class MainMenuView implements CLI_View{
    
    public MainMenuController mmController;

    public MainMenuView(MainMenuController mmController){
        this.mmController = mmController;
    }
    
    public void displayOptions(){
        System.out.println("");
        System.out.println("                                   -- MAIN MENU --                                    ");
        System.out.println("");
        System.out.println("1) Open my RecipeBook:\t\t\tsearch, edit, or create new tasty recipes!");
        System.out.println("2) Open my MealPlanner:\t\t\torganize your recipes into comprehensive meal plans.");
        System.out.println("3) Open my Pantry:\t\t\torganize your recipes into comprehensive meal plans.");
        System.out.println("4) Access my grocery list:\t\tview and edit your current grocery list.");
        System.out.println("5) Exit Application");
        System.out.println();
    }
    
    public void execute(){
        Scanner scan = ViewUtilities.scan;
        String input = "";

        displayOptions();
        while(true){
            System.out.println();
            System.out.println("(to see the options again, type \"options\")");

            input = scan.nextLine().toLowerCase();
            System.out.println();
            switch (input) {
                case "1":
                    mmController.openRecipeBook();
                    break;
                case "2":
                    mmController.openMealPlanner();
                    break;
                case "3":
                    mmController.openPantry();
                    break;
                case "4":
                    mmController.accessGroceryList();
                    break;
                case "5":
                    return;
                case "options":
                    displayOptions();
                    break;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            displayOptions();
        }
    }

}
