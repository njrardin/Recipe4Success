package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.model.MealPlan;

public class MealPlannerView {
    
    public static void ExecuteMealPlannerView(Scanner scan2){
        
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                               -- Meal Planner --                              ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        

        Scanner scan = new Scanner(System.in);
        String input = "";
        while (true) {
            displayOptions();

            System.out.print("Please type the number corresponding to ythe option you wish to select: ");
            System.out.println("(to see the options again, type \"options\"");
    
            input = scan.nextLine().toLowerCase();
            System.out.println();
            switch (input) {
                case "1":
                    MealPlannerView.searchMealPlans();
                    break;
                case "2":
                    MealPlannerView.importMealPlan();
                    break;
                case "3":
                    MealPlannerView.exportMealPlan();
                    break;
                case "4":
                    MealPlannerView.createMealPlan();
                    break;
                case "options":
                    displayOptions();
                case "back":
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            break;
        }
        scan.close();
    }

    private static void displayOptions(){
        System.out.println("");
        System.out.println("                               -- Meal Planner Options --                              ");
        System.out.println("");
        System.out.println("1) Search MealPlans");
        System.out.println("2) Import a MealPlan");
        System.out.println("3) Export a MealPlan");
        System.out.println("4) Create a new MealPlan");
        System.out.println("");
        System.out.println("(If you would like to go back to the main menu, type \"back\")");
        System.out.println();
    }

    private static void searchMealPlans(){
        //use displayOneline method
    }
    
    private static void displayOneline(MealPlan mealplan){
    
    }

    private static void exportMealPlan(){
        
    }
    
    private static void importMealPlan(){
        
    }

    private static void createMealPlan(){

    }
}
