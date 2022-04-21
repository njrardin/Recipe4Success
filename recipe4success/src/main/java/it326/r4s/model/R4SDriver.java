package it326.r4s.model;

import java.util.Scanner;

public class R4SDriver {

    public static void main(String[] args) {
        importFileData();

        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                      -- WELCOME TO RECIPES 4 SUCCESS! --                      ---");
        System.out.println("---                                                                               ---");
        System.out.println("--- //**to team - should we probably list mealplans/recipes here?                 ---");
        System.out.println("---                                                                               ---");
        System.out.println("--- A quick guide to using the app:                                               ---");
        System.out.println("---                                                                               ---");
        System.out.println("---            -- RECIPE --                           -- MEAL PLAN --             ---");
        System.out.println("--- 1.  Create Recipe                      10. Create Meal Plan                   ---");
        System.out.println("--- 2.  Edit Recipe                        11. Delete Meal Plan                   ---");
        System.out.println("--- 3.  Delete Recipe                      12. Add Recipe to Meal Plan            ---");
        System.out.println("--- 4.  Rate Recipe                        13. Remove Recipe from Meal Plan       ---");
        System.out.println("--- 5.  Adjust Recipe Serving Size         14. Adjust Meal Plan Serving Size      ---");
        System.out.println("--- 6.  Search for Recipe                  15. Mark Meal Plan as Active           ---");
        System.out.println("--- 7.  Export Recipe                      16. Search for Meal Plan               ---");
        System.out.println("--- 8.  Upload Recipe                      17. Export Meal Plan                   ---");
        System.out.println("--- 9.  Filter Recipes by Category         18. Upload Meal Plan                   ---");
        System.out.println("---                                        19. Move Meal Plan Ingredients to      ---");
        System.out.println("---                                            Grocery List                       ---");
        System.out.println("---                                                                               ---");
        System.out.println("---                         -- GROCERY LIST AND PANTRY --                         ---");
        System.out.println("--- 20. Export Grocery List                25. Add Item to Pantry                 ---");
        System.out.println("--- 21. Add Item to Grocery List           26. Remove Item from Pantry            ---");
        System.out.println("--- 22. Remove Item from Grocery List      27. Show Recipes Makeable from Pantry  ---");
        System.out.println("--- 23. Move Grocery List Items to Pantry  28. Finish Making a Recipe & remove    ---");
        System.out.println("--- 24. Organize Items in Grocery List         its ingredients from the Pantry    ---");
        System.out.println("---                                                                               ---");
        System.out.println("---                                                                               ---");
        System.out.println("--- If you would like to exit the application, type \"stop\"                        ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        String input = "";
        do {
            System.out.print("Enter the number of any app function you want to run: ");
            input = scan.nextLine();
            System.out.println();
            switch (input) {
                case "1":
                    createRecipe(scan);
                    break;
                case "2":
                    editRecipe(scan);
                    break;
                case "3":
                    deleteRecipe(scan);
                    break;
                case "4":
                    rateRecipe(scan);
                    break;
                case "5":
                    adjustServingSize(scan);
                    break;
                case "6":
                    searchForRecipe(scan);
                    break;
                case "7":
                    exportRecipe(scan);
                    break;
                case "8":
                    uploadRecipe(scan);
                    break;
                case "9":
                    filterRecipeByCategory(scan);
                    break;
                case "10":
                    createMealPlan(scan);
                    break;
                case "11":
                    deleteMealPlan(scan);
                    break;
                case "12":
                    addRecipeToMealPlan(scan);
                    break;
                case "13":
                    removeRecipeFromMealPlan(scan);
                    break;
                case "14":
                    adjustMealPlanServingSize(scan);
                    break;
                case "15":
                    markMealPlanAsActive(scan);
                    break;
                case "16":
                    searchForMealPlan(scan);
                    break;
                case "17":
                    exportMealPlan(scan);
                    break;
                case "18":
                    uploadMealPlan(scan);
                    break;
                case "19":
                    moveMealPlanItemsToGroceryList(scan);
                    break;
                case "20":
                    exportGroceryList(scan);
                    break;
                case "21":
                    addItemToGroceryList(scan);
                    break;
                case "22":
                    removeItemFromGroceryList(scan);
                    break;
                case "23":
                    moveGroceryListItemsToPantry(scan);
                    break;
                case "24":
                    organizeItemsInGroceryList(scan);
                    break;
                case "25":
                    addItemToPantry(scan);
                    break;
                case "26":
                    removeItemFromPantry(scan);
                    break;
                case "27":
                    showMakeableRecipes(scan);
                    break;
                case "28":
                    removeRecipeItemsFromPantry(scan);
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

    private static void createRecipe(Scanner scan) {
        System.out.println("Creating Recipe...\n");
    }

    private static void editRecipe(Scanner scan) {
        System.out.println("Editing Recipe...\n");
    }

    private static void deleteRecipe(Scanner scan) {
        System.out.println("Deleting Recipe...\n");
    }

    private static void rateRecipe(Scanner scan) {
        System.out.println("Rating Recipe...\n");
    }

    private static void adjustServingSize(Scanner scan) {
        System.out.println("Adjusting Recipe Serving Size...\n");

        System.out.print("Enter the name of the recipe you want to edit: ");
        String name = scan.nextLine();

        // TODO - use RecipeBook to iterate through all recipes and find a name match (or use searchRecipe?)
        //if (nameNotFound) {
        //    System.out.println("Sorry, that recipe couldn't be found, please try again!");
        //    return;
        //}

        System.out.print("Enter the new serving size for this recipe: ");
        String size = scan.nextLine();
        System.out.println();
        //recipe.setServingSize(size);
        
        // ??? if (invalidServingSize) {
        //    System.out.println("Sorry, that is an invalid serving size, please try again!");
        //    return;
        //}

        System.out.println("Serving size of recipe '" + name + "' adjusted to " + size + ".\n");
    }

    private static void searchForRecipe(Scanner scan) {
        System.out.println("Searching for Recipe...\n");
    }

    private static void exportRecipe(Scanner scan) {
        System.out.println("Exporting Recipe...\n");
    }

    private static void uploadRecipe(Scanner scan) {
        System.out.println("Uploading Recipe...\n");
    }

    private static void filterRecipeByCategory(Scanner scan) {
        System.out.println("Filtering Recipes by Category...\n");
    }

    private static void createMealPlan(Scanner scan) {
        System.out.println("Creating Meal Plan...\n");
    }

    private static void deleteMealPlan(Scanner scan) {
        System.out.println("Deleting Meal Plan...\n");
    }

    private static void addRecipeToMealPlan(Scanner scan) {
        System.out.println("Adding Recipe to Meal Plan...\n");
    }

    private static void removeRecipeFromMealPlan(Scanner scan) {
        System.out.println("Removing Recipe from Meal Plan...\n");
    }

    private static void adjustMealPlanServingSize(Scanner scan) {
        System.out.println("Adjusting Meal Plan Serving Size...\n");
    }

    private static void markMealPlanAsActive(Scanner scan) {
        System.out.println("Marking Meal Plan As Active...\n");
    }

    private static void searchForMealPlan(Scanner scan) {
        System.out.println("Searching for Meal Plan...\n");
    }

    private static void exportMealPlan(Scanner scan) {
        System.out.println("Exporting Meal Plan...\n");
    }

    private static void uploadMealPlan(Scanner scan) {
        System.out.println("Uploading Meal Plan...\n");
    }

    private static void moveMealPlanItemsToGroceryList(Scanner scan) {
        System.out.println("Moving Meal Plan Ingredients to your Grocery List...\n");
    }

    private static void exportGroceryList(Scanner scan) {
        System.out.println("Exporting your Grocery List...\n");
    }

    private static void addItemToGroceryList(Scanner scan) {
        System.out.println("Adding Item to your Grocery List...\n");
    }

    private static void removeItemFromGroceryList(Scanner scan) {
        System.out.println("Removing Item from your Grocery List...\n");
    }

    private static void moveGroceryListItemsToPantry(Scanner scan) {
        System.out.println("Moving Grocery List Items to your Pantry...\n");
    }

    private static void organizeItemsInGroceryList(Scanner scan) {
        System.out.println("Organizing Grocery List to your Preference...\n");
    }

    private static void addItemToPantry(Scanner scan) {
        System.out.println("Adding Item to your Pantry...\n");
    }

    private static void removeItemFromPantry(Scanner scan) {
        System.out.println("Removing Item from your Pantry...\n");
    }

    private static void showMakeableRecipes(Scanner scan) {
        System.out.println("Showing Recipes you can make with your existing Pantry...\n");
    }

    private static void removeRecipeItemsFromPantry(Scanner scan) {
        System.out.println("Marking Recipe as made to remove its ingredients from your Pantry...\n");
    }

    private static void saveAndExit() {
       //TODO: Save data from application and then 

       System.out.println("Thank you for using Recipe4Success!");
       System.out.println("\n\tapplication exiting...\n\n");
    }

    private static void importFileData() {
       //TODO: Save data from application and then 
    }
}
