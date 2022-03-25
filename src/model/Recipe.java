package model;
import java.util.*;

public class Recipe extends Entity implements Searchable, Categorizable, Exportable {

    private String name;
    private String description;
    private int recipeServingSize;
    private Date createdOn;
    private IngredientList ingredientList;
    private List<Review> reviews;
    private List<Category> categories;
    private List<String> instructions;

    /**
     * Builder Class for Recipe Objects
     */
    public static class RecipeBuilder
    {
        private String name;
        private String description;
        private int recipeServingSize;
        private Date createdOn;
        private IngredientList ingredientList;
        private List<Review> reviews;
        private List<Category> categories;
        private List<String> instructions;

        public RecipeBuilder(){
            this.createdOn = new Date();
        }

        public Recipe build(){
            Recipe recipe = new Recipe(this);
            return recipe;
        }

        public RecipeBuilder setName(String name){
            this.name = name;
            return this;
        }

        public RecipeBuilder setDescription(String description){
            this.description = description;
            return this;
        }

        public RecipeBuilder setServingSize(int recipeServingSize){
            this.recipeServingSize = recipeServingSize;
            return this;
        }

        public RecipeBuilder setIngredientList(IngredientList ingredientList){
            this.ingredientList = ingredientList;
            return this;
        }
        
        public RecipeBuilder setReviews(List<Review> reviews){
            this.reviews = reviews;
            return this;
        }
        
        public RecipeBuilder setCategories(List<Category> categories){
            this.categories = categories;
            return this;
        }
        
        public RecipeBuilder setInstructions(List<String> instructions){
            this.instructions = instructions
            return this;
        }
    } 
}