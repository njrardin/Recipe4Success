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
     * Displays the full meal planner to the user
     */
    public void displayMealPlanner() {
        try{
            System.out.println("\nCurrent active Mealplan: " + mprController.getMealPlanner().getMealPlans().get(mprController.getMealPlanner().getActiveMealPlanIndex()));
        } catch (Exception e) {
            System.out.println("\nCurrent active Mealplan: ...there is no active mealplan yet!" );
        }
        System.out.println();
        displayMealPlans(mprController.getMealPlanControllers());
        System.out.println();
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
            "Set mealplan as 'Active'",
            "Go back"
        };
        return ViewUtilities.getOptionFromCLI(title, prompt, options);
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
    public MealPlanController getMealPlanSelection(ArrayList<MealPlanController> mealPlanControllers) throws RuntimeException{    
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

    /**
     * A confirmation option for selecting a mealplan
     * @return true if confirmed, false if denied
     */
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

    /**
     * Gets from the user the index of in the mealplanner which contains
     * the meal plan which they wish to set as "active"
     */
    public int getActivationSelection(){
        System.out.println("Please select one of the following meal plans: ");
        displayMealPlanner();

        Scanner scan = ViewUtilities.scan;
        int selection = -1;
        do{
            System.out.println("Please select an option by entering the corresponding number:");
            try{
                selection = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input, selection must be a number:");
                continue;
            }
        } while( !(0 < selection && selection <= mprController.getMealPlanControllers().size()));
        System.out.println("Selection returned as: " + selection);
        return selection;
    }

    /**
     * Displays the message at the start of a meal plan creation process 
     */
    public void initCreateMealplan() {
        System.out.println("Let's create a meal plan!");
    }

    /**
     * Gets from the user the name of a mealplan
     * @return
     */
    public String getMealPlanNameFromUser() {
        Scanner scan = ViewUtilities.scan;
        String name = "";

        while(true){
            System.out.println("\nPlease provide the mealplan's name:");
            name = scan.nextLine();
            if(name != ""){
                System.out.println("You provided the name \"" + name + ",\" is this correct? (Y/N)");
                if(scan.nextLine().toLowerCase().equals("y")){
                    return name;
                }
            }
        }
    }

    /**
     * Gets from the user a confirmation as to whether or not they
     * wish to add anothe recipe to a meal plan
     * @return boolean repesentation of response
     */
    public boolean wantToAddAnotherRecipe() {
        Scanner scan = ViewUtilities.scan;
        String input = "";
        do{
        System.out.println("Would you like to add another recipe? (Y/N)");
        input = scan.nextLine().toLowerCase();
        } while ( !(input.equals("y") || input.equals("n")) );
        if(input.equals("n")){
            return false;
        }
        return true;
    }

    /**
     * Gets from the user a description for a meal plan
     * @return
     */
    public String getMealPlanDescriptionFromUser() {
        Scanner scan = ViewUtilities.scan;
        String description = "";
        while(true){
            System.out.println("Please provide a description for the meal plan");
            description = scan.nextLine();

            System.out.println("You provided the description\n\n \"" 

            + description + 

            "\"\n\n is this correct? (Y/N)");

            if(scan.nextLine().toLowerCase().equals("y")){
                return description;
            }
        }
    }


}
