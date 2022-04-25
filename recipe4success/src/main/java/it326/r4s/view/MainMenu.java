package it326.r4s.view;

import java.util.Scanner;

public class MainMenu {
    
    public static void executeMainMenu(){
        while(true){

            displayOptions();

            Scanner scan = new Scanner(System.in);
            String input = "";
            while (true) {
                System.out.print("Please type the number corresponding to the option you wish to select: ");
                System.out.println("(to see the options again, type \"options\"");

                input = scan.nextLine().toLowerCase();
                System.out.println();
                switch (input) {
                    case "1":
                        RecipeBookView.ExecuteRecipeBookView();
                        break;
                    case "2":
                        MealPlannerView.ExecuteMealPlannerView();
                        break;
                    case "3":
                        PantryView.ExecutePantryView();
                        break;
                    case "4":
                        GroceryListView.ExecuteGroceryListView();
                        break;
                    case "options":
                        displayOptions();
                        break;
                    case "stop":
                        return;
                    default:
                        System.out.println("Invalid input, please try again\n");
                }
                break;
            }
            scan.close();
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
        System.out.println("(If you would like to exit the application, type \"stop\")");
        System.out.println();
    }
}
