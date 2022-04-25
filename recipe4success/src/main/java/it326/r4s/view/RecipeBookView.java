package it326.r4s.view;

import java.util.ArrayList;
import java.util.Scanner;

import it326.r4s.model.*;
import it326.r4s.model.Recipe.RecipeBuilder;

public class RecipeBookView {
    
    public static void ExecuteRecipeBookView(Scanner scan){
        
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                               -- Recipe Book --                               ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        
        String input = "";
        while (true) {
            displayOptions();

            System.out.print("Please type the number corresponding to the option you wish to select: ");
            System.out.println("(to see the options again, type \"options\"");
    
            input = scan.nextLine().toLowerCase();
            System.out.println();
            switch (input) {
                case "1":
                    RecipeBookView.searchRecipes(scan);
                    break;
                case "2":
                    RecipeBookView.importRecipe(scan);
                    break;
                case "3":
                    RecipeBookView.exportRecipe(scan);
                    break;
                case "4":
                    Recipe newRecipe = RecipeBookView.createRecipe(scan);
                    RecipeView.executeRecipeView(newRecipe);
                    break;
                case "options":
                    displayOptions();
                case "back":
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
        }
    }

    private static void displayOptions(){
        System.out.println("");
        System.out.println("                               -- Recipe Book Options --                              ");
        System.out.println("");
        System.out.println("1) Search and filter recipes");
        System.out.println("2) Import a recipe");
        System.out.println("3) Export a recipe");
        System.out.println("4) Create a new recipe");
        System.out.println("");
        System.out.println("(If you would like to go back to the main menu, type \"back\")");
        System.out.println();
    }

    private static void displayOneline(Recipe recipe){
    
    }
    
    private static void searchRecipes(Scanner scan){
        //use displayOneline method
    }
    
    
    private static void exportRecipe(Scanner scan){
        
    }
    
    private static void importRecipe(Scanner scan){
        
    }

    private static Recipe createRecipe(Scanner scan){
        
        String name = "";
        String description;
        int servingSize;
        ArrayList<String> instructions = new ArrayList<String>();

        String resp;
        
        while(true){
            System.out.println("\nPlease provide the recipe's name:");
            name = scan.nextLine();
            if(name != ""){
                System.out.println("You provided the name \"" + name + ",\" is this correct? (Y/N)");
                if(scan.nextLine().toLowerCase().equals("y")){
                    break;
                }
            }
        }

        RecipeBuilder rpBuild = new RecipeBuilder(name);

        while(true){
            System.out.println("Please provide a description for the recipe");
            description = scan.nextLine();

            System.out.println("You provided the description\n\n \"" 

            + description + 

            "\"\n\n is this correct? (Y/N)");

            if(scan.nextLine().toLowerCase().equals("y")){
                rpBuild.setDescription(description);
                break;
            }
        }
        
        while(true){
            System.out.println("How many people does this recipe serve?");
            try{
                servingSize = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
        
            System.out.println("You provided a serving-size of \"" + servingSize + "\" is this correct? (Y/N)");
            if(scan.nextLine().toLowerCase().equals("y")){
                rpBuild.setServingSize(servingSize);
                break;
            }
        }

        String instructionString;
        int stepNum = 1;
        System.out.println("Now let's write the instruction steps for the recipe.");
        while(true){
            if(stepNum == 1){
                System.out.println("What is the first step in creating the recipe?\n");
            }
            else{
                System.out.println("What is the next step in creating the recipe?\n");
            }

            instructionString = scan.nextLine();
            
            System.out.println("You provided step #" + stepNum + " as\n\n \"" 

            + instructionString + 

            "\"\n\n is this correct? (Y/N)");
            resp = scan.nextLine().toLowerCase();
            if(resp.equals("y")){
                instructions.add(instructionString);
                stepNum++;
            }
            else{
                continue;
            }

            do {
                System.out.println("Would you like to add another step? (Y/N)");
                resp = scan.nextLine().toLowerCase();
            } while (!(resp.equals("y") || resp.equals("n")));
            
            if(resp.equals("n")){
                rpBuild.setInstructions(instructions);
                break;
            }

        }

        //TODO: Implement adding cateogries
        //TODO: Implement adding ingredients

        Recipe newRecipe = rpBuild.build();

        System.out.println("Perfect! Your recipe is complete.");
        User theUser = User.getUser();
        theUser.addRecipe(newRecipe);

        return newRecipe;
    }

}
