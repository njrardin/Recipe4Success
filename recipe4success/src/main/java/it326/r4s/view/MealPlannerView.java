package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.MealPlannerController;
/**
 * View for R4S MealPlanner
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlannerView implements CLI_Menu{

    private MealPlannerController mprController;

    public MealPlannerView(MealPlannerController mprController){
        this.mprController = mprController;
    }
    
    public int getMenuOptionSelection(){
    return -1; //TODO implement; del depreciated
        // Scanner scan = ViewUtilities.scan;
        // String input = "";
        // displayHeader();
        // displayOptions();
        // while (true) {

        //     System.out.println();
        //     System.out.println("(to see the options again, type \"options\")");
    
        //     input = scan.nextLine().toLowerCase();
        //     System.out.println();
        //     switch (input) {
        //         case "1":
        //             mprController.searchMealPlans();
        //             break;
        //         case "2":
        //             mprController.importMealPlan();
        //             break;
        //         case "3":
        //             mprController.exportMealPlan();
        //             break;
        //         case "4":
        //             mprController.createMealPlan();
        //             break;
        //         case "5":
        //             mprController.viewMealPlans();
        //             break;
        //         case "6":
        //             return -1;
        //         default:
        //             System.out.println("Invalid input, please try again\n");
        //     }
        //     break;
        // }
        // retu
    }

    private void displayHeader(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                               -- Meal Planner --                              ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private void displayOptions(){
        System.out.println("");
        System.out.println("                               -- Meal Planner Options --                              ");
        System.out.println("");
        System.out.println("1) Search MealPlans");
        System.out.println("2) Import a MealPlan");
        System.out.println("3) Export a MealPlan");
        System.out.println("4) Create a new MealPlan");
        System.out.println("5) View all MealPlans");
        System.out.println("6) Go back");
        System.out.println();
    }
}
