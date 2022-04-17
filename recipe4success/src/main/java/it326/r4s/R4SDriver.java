package it326.r4s;

import java.util.Scanner;

public class R4SDriver {

    public static void main(String[] args) {
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
        System.out.println("--- 7.  Export Recipe                      16. Search Meal Plan                   ---");
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
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        String input = "";
        do {
            System.out.print("Enter the number of any app function you want to run: ");
            input = scan.nextLine();
            switch (input) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "10":
                    break;
                case "11":
                    break;
                case "12":
                    break;
                case "13":
                    break;
                case "14":
                    break;
                case "15":
                    break;
                case "16":
                    break;
                case "17":
                    break;
                case "18":
                    break;
                case "19":
                    break;
                case "20":
                    break;
                case "21":
                    break;
                case "22":
                    break;
                case "23":
                    break;
                case "24":
                    break;
                case "25":
                    break;
                case "26":
                    break;
                case "27":
                    break;
                case "28":
                    break;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
        } while (!input.contains("stop"));
        scan.close();
    }
}
