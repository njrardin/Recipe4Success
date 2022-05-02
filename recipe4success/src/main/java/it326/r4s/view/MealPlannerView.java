package it326.r4s.view;

import java.util.Collection;

import it326.r4s.controller.MealPlanController;
import it326.r4s.controller.MealPlannerController;
import it326.r4s.view.utilities.DisplayUtils;
import it326.r4s.view.utilities.InputAccess;
/**
 * View for R4S MealPlanner
 * @author Zach Plattner (zmplatt@ilstu.edu) and Nate Rardin(njradi@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlannerView implements R4SMenu{

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
        System.out.println(DisplayUtils.getHeader("Meal Planner"));
    }

    /**
     * Displays the full meal planner to the user
     */
    public void displayMealPlanner() {
        int index = mprController.getMealPlanner().getActiveMealPlanIndex();
        if (index < 0 || index >= mprController.getMealPlanner().getMealPlans().size())
            System.out.println("No currently active Mealplan");
        else
            System.out.println("\nCurrent active Mealplan: " + mprController.getMealPlanner().getMealPlans().get(index));
        System.out.println();
        displayMealPlans(mprController.getMealPlanControllers());
        System.out.println();
    }

    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        String title = "Meal Planner Options";
        String prompt = "What would you like to do?";
        String[] options = {
            "Search Meal Plans",
            "Import a Meal Plan",
            "Export a Meal Plan",
            "Create a new Meal Plan",
            "Open a Meal Plan",
            "Set Meal Plan as 'Active'",
            "Go back"
        };
        InputAccess inputAccess = new InputAccess();
        return inputAccess.getOptionSelection(title, prompt, options);
    }

    /**
     * Displays to the user all the meal plans
     * in a given list of mealplan controllers
     * @param mealPlanControllers
     */
    public void displayMealPlans(Collection<MealPlanController> mealPlanControllers){
        System.out.println("Meal Plans:");
        System.out.println(DisplayUtils.HYPHEN_DIVIDER);
        if(mealPlanControllers == null){
            System.out.println("\nThere are no meal plans in your mealplanner. Try adding some!");
        }
        else {
            int i = 1;
            for(MealPlanController mealPlanController: mealPlanControllers){
                System.out.print(i + ") ");
                mealPlanController.getMealPlanView().displayOneLine();
                i++;
            }
        }
        System.out.println(DisplayUtils.HYPHEN_DIVIDER);
    }

    /**
     * Displays a series of mealplans and allows the user to select one
     * @param mealPlanControllers - an ArrayList of MealPlanControllers to present as selection options to the user
     * @return the MealPlanController who's mealplan was selected
     * @throws RuntimeException - if the user aborts the selection process
     */
    public MealPlanController getMealPlanSelection(Collection<MealPlanController> mealPlanControllers) throws RuntimeException{    
        displayMealPlans(mealPlanControllers);

        String selection = "";
        int inputNum = -1;

        InputAccess inputAccess = new InputAccess();
        do{
            System.out.println("\n Which meal plan would you like to select?");
            System.out.print("(please type the selection number or type \"exit\" to go back) : ");

            selection = inputAccess.getInputLine();
            if(selection.toLowerCase().equals("exit")){
                throw new RuntimeException();
            }

            try{
                inputNum = Integer.parseInt(selection);
            } catch (Exception e){
                System.out.println("\nInvalid selection, selection must be a number.");
                continue;
            }
            
            if (inputNum <= 0 || mealPlanControllers.size() < inputNum){
                System.out.println("\nInvalid selection, selection out of range.");
            }

        } while(inputNum <= 0 || mealPlanControllers.size() < inputNum);

        return (MealPlanController) mealPlanControllers.toArray()[inputNum - 1];
    }

    /**
     * Gets from the user the index of in the mealplanner which contains
     * the meal plan which they wish to set as "active"
     */
    public int getActivationSelection(){
        System.out.println("Please select one of the following meal plans: ");
        displayMealPlanner();

        InputAccess inputAccess = new InputAccess();
        int selection = -1;
        do{
            System.out.print("Please select an option by entering the corresponding number to mark it as active: ");
            try{
                selection = Integer.parseInt(inputAccess.getInputLine());
            } catch (Exception e) {
                System.out.print("Invalid input, selection must be a number: ");
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
        InputAccess inputAccess = new InputAccess();
        String name = "";

        while(true){
            System.out.print("\nPlease provide the meal plan's name: ");
            name = inputAccess.getInputLine();
            if(!name.equals("")){
                System.out.print("You provided the name \"" + name + ",\" is this correct? (Y/N) : ");
                if(inputAccess.getInputLine().toLowerCase().equals("y")){
                    return name;
                }
            }
        }
    }

    /**
     * Gets from the user a confirmation as to whether or not they
     * wish to add another recipe to a meal plan
     * @return boolean representation of response
     */
    public boolean wantToAddAnotherRecipe() {
        InputAccess inputAccess = new InputAccess();
        String response = "";
        do{
        System.out.println("Would you like to add another recipe? (Y/N) : ");
        response = inputAccess.getInputLine().toLowerCase();
        } while ( !(response.equals("y") || response.equals("n")) );
        if(response.equals("n")){
            return false;
        }
        return true;
    }

    /**
     * Gets from the user a description for a meal plan
     * @return
     */
    public String getMealPlanDescriptionFromUser() {
        InputAccess inputAccess = new InputAccess();
        String description = "";
        while(true){
            System.out.println("Please provide a description for the meal plan:");
            description = inputAccess.getInputLine();

            System.out.print("You provided the description\n\n \"" 

            + description + 

            "\"\n\n is this correct? (Y/N) : ");

            if(inputAccess.getInputLine().toLowerCase().equals("y")){
                return description;
            }
        }
    }


}
