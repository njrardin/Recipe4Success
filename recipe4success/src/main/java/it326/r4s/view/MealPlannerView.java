package it326.r4s.view;

import java.util.ArrayList;
import java.util.Scanner;

import it326.r4s.controller.MealPlanController;
import it326.r4s.controller.MealPlannerController;
/**
 * View for R4S MealPlanner
 * @author Zach Plattner (zmplatt@ilstu.edu) and Nate Rardin(njradi@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlannerView implements CLI_Menu{

    //*Instance Variables*\\
    private MealPlannerController mprController;

    //*Constructor*\\
    /**
     * Constructor for R4S's MealPlannerView
     * @param mprController - the MealPlannerView's controller
     */
    public MealPlannerView(MealPlannerController mprController){
        this.mprController = mprController;
    }
    
    //*Methods*\\
    /**
     * Displays the Meal Planner header 
     */
    public void displayHeader(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                               -- Meal Planner --                              ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        String title = "Meal Planner";
        String prompt = "What would you like to do?";
        String[] options = {
            "Search mealplans",
            "Import a mealplan",
            "Export a mealplan",
            "Create a new mealplan",
            "Select a mealplan",
            "Go back"
        };
        return ViewUtilities.getOptionFromCLI(title, prompt, options);
    }

    /**
     * Displays the full meal planner to the user
     */
    public void displayMealPlanner() {
        displayMealPlans(mprController.getMealPlanControllers());
    }

    /**
     * Displays to the user all the meal plans
     * in a given list of mealplan controllers
     * @param mealPlanControllers
     */
    public void displayMealPlans(ArrayList<MealPlanController> mealPlanControllers){
        int i = 1;
        for(MealPlanController mealPlanController: mealPlanControllers){
            System.out.print(i + ") ");
            mealPlanController.getMealPlanView().displayOneline();
            i++;
        }
    }

    /**
     * Displays a series of mealplans and allows the user to select one
     * @param mealPlanControllers - an ArrayList of MealPlanControllers to present as selection options to the user
     * @return the MealPlanController who's mealplan was selected
     * @throws RuntimeException - if the user aborts the selection process
     */
    public MealPlanController displayAndSelect(ArrayList<MealPlanController> mealPlanControllers) throws RuntimeException{    
        displayMealPlans(mealPlanControllers);
        if (askSelectMealPlan() == false){
            throw new RuntimeException();
        }    

        String input;
        int inputNum = -1;

        Scanner scan = ViewUtilities.scan;
        do{
            System.out.println("\n Which meal plan would you like to select?");
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
            
            if (inputNum <= 0 || mealPlanControllers.size() < inputNum){
                System.out.println("Invalid selection, selection out of range.");
            }

        } while(inputNum <= 0 || mealPlanControllers.size() < inputNum);

        return mealPlanControllers.get(inputNum - 1);
    }

    private boolean askSelectMealPlan() {
        Scanner scan = ViewUtilities.scan;
        String input = "";
        do{
        System.out.println("Would you like to select a meal plan? (Y/N)");
        input = scan.nextLine().toLowerCase();
        } while ( !(input.equals("y") || input.equals("n")) );
        if(input.equals("n")){
            return false;
        }
        return true;
    }

}
