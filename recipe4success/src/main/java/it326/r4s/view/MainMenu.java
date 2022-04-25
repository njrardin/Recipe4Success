package it326.r4s.view;

import java.util.Scanner;

public class MainMenu {
    
    public static void executeMainMenu(Scanner scan){
        while(true){

            displayOptions();

            String input = "";
            while (true) {
                System.out.print("Please type the number corresponding to the option you wish to select: ");
                System.out.println("(to see the options again, type \"options\")");

                input = scan.nextLine().toLowerCase();
                System.out.println();
                switch (input) {
                    case "1":
                        RecipeBookView.ExecuteRecipeBookView(scan);
                        break;
                    case "2":
                        MealPlannerView.ExecuteMealPlannerView(scan);
                        break;
                    case "3":
                        PantryView.ExecutePantryView(scan);
                        break;
                    case "4":
                        GroceryListView.ExecuteGroceryListView(scan);
                        break;
                    case "options":
                        displayOptions();
                        break;
                    case "exit":
                        return;
                    default:
                        System.out.println("Invalid input, please try again\n");
                }
            }
        }
    }

    public static void displayOptions(){
        System.out.println("");
        System.out.println("                                   -- MAIN MENU --                                    ");
        System.out.println("");
        System.out.println("1) Open my RecipeBook:\t\t\tsearch, edit, or create new tasty recipes!");
        System.out.println("2) Open my MealPlanner:\t\t\torganize your recipes into comprehensive meal plans.");
        System.out.println("3) Open my Pantry:\t\t\torganize your recipes into comprehensive meal plans.");
        System.out.println("4) Access my grocery list:\t\tview and edit your current grocery list.");
        System.out.println("");
        System.out.println("(If you would like to exit the application, type \"exit\")");
        System.out.println();
    }
}
