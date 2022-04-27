package it326.r4s.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import it326.r4s.controller.RecipeController.RecipeBuilderController;
import it326.r4s.model.Recipe;
import it326.r4s.model.RecipeBook;
import it326.r4s.model.Recipe.RecipeBuilder;
import it326.r4s.view.RecipeBookView;
import it326.r4s.view.RecipeView;
import it326.r4s.view.ViewUtilities;
/**
 * Controller for R4S RecipeBook
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeBookController implements CLI_Controller {
    
    public RecipeBook recipeBook;
    public RecipeBookView recipeBookView;

    public RecipeBookController(RecipeBook recipeBook){
        this.recipeBook = recipeBook;
        this.recipeBookView = new RecipeBookView(this);
    }

    public RecipeBook getRecipeBook(){
        return this.recipeBook;
    }

    public ArrayList<RecipeController> getRecipeControllers(){
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();
        for(Recipe recipe: recipeBook.getRecipes()){
            recipeControllers.add(new RecipeController(recipe));
        }
        return recipeControllers;
    }

    public void executeView(){
        recipeBookView.execute();
    }
    
    public void exportRecipe() {
        //TODO - req 7
    }
    
    public void searchRecipes() {
        RecipeSearchController rsController = new RecipeSearchController(recipeBook.getRecipes());
        String searchQuery = recipeBookView.getSearchQuery();
        ArrayList<Recipe> returnRecipes = rsController.searchFor(searchQuery);
        
        selectRecipe(returnRecipes);
    }
    
    public void filterRecipeByCategory() {
        RecipeSearchController rsController = new RecipeSearchController(recipeBook.getRecipes());
        String searchQuery = recipeBookView.getSearchQuery();
        ArrayList<Recipe> returnRecipes = rsController.searchFor(searchQuery);
        
        selectRecipe(returnRecipes);
    }

    public void importRecipe() {
        //TODO - req 8
    }


    public void selectRecipe(Collection<Recipe> recipes){
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();
        for(Recipe recipe: recipes){
            recipeControllers.add(new RecipeController(recipe));
        }
        try{
            RecipeController selectedRecipe = recipeBookView.displayAndSelect(recipeControllers);
            selectedRecipe.executeView();
        } catch (RuntimeException e) { /*do nothing*/ }
    }

    public void viewRecipes(){
        RecipeView recipeView;
        int i = 1;
        for(Recipe recipe: recipeBook.getRecipes()){
            recipeView =  new RecipeView(new RecipeController(recipe));
            System.out.println(i);
            recipeView.displayOneline();
            i++;
        }
    }

    public void createRecipe(){ //TODO: Offset user input gatherint to view class
        //TODO - this is req 1. Is it done? Delete this todo if so.
        Scanner scan = ViewUtilities.scan;

        RecipeBuilderController rBuildController = new RecipeBuilderController();

        //Name

        //Desc

        //Serving size

        //instructions

        //categories (if any)

        //ingredients
        
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
        recipeBook.addRecipe(newRecipe);
    }
}
