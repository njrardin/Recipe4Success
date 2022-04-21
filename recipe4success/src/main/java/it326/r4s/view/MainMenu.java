package it326.r4s.view;

import java.util.Scanner;

public class MainMenu {
    
    public static void executeMainMenu(){
        System.out.println("");
        System.out.println("Please type the number corresponding to the option you wish to select:");
        System.out.println("1) Open my RecipeBook:\tsearch, edit, or create new tasty recipes!");
        System.out.println("2) Open my MealPlanner:\torganize your recipes into comprehensive meal plans.");
        System.out.println("3) Open my Pantry:\torganize your recipes into comprehensive meal plans.");
        System.out.println("4) Access my grocery list:\tview and edit your current grocery list.");
        System.out.println("");
        System.out.println("(If you would like to exit the application, type \"stop\")");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        String input = "";
        do {
            System.out.print("Enter the number of any app function you want to run: ");
            input = scan.nextLine();
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
                case "stop":
                    saveAndExit();
                    break;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
        } while (!input.toLowerCase().equals("stop"));
        scan.close();
    }

    private static void saveAndExit() {
        //TODO: Save data from application and then 
 
        System.out.println("Thank you for using Recipe4Success!");
        System.out.println("\n\tapplication exiting...\n\n");
     }
}
