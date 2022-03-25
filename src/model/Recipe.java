package model;
import java.util.*;

public class Recipe extends Entity implements Searchable, Categorizable, Exportable {

    private String name;
    private String description;
    private int servingSize;
    private Date createdOn;
    private IngredientList ingredientList;
    private List<Review> reviews;
    private List<Category> categories;
    private List<String> instructions;

    /**
     * Constructor for Recipe using the nested class RecipeBuilder
     * - only used inside the RecipeBuilder constructor. RecipeBuilder must be used to create Recipe objects.
     * 
     * @param builder - the RecipeBuilder object from which to create the class
     */
    private Recipe(RecipeBuilder builder){
        this.name = builder.name;
        this.description = builder.description;
        this.servingSize = builder.servingSize;
        this.createdOn = builder.createdOn;
        this.ingredientList = builder.ingredientList;
        this.reviews = builder.reviews;
        this.categories = builder.categories;
        this.instructions = builder.instructions;
    }


    /**
     * Nested builder class for Recipe objects
     */
    public class RecipeBuilder
    {
        private String name;
        private String description;
        private int servingSize;
        private Date createdOn;
        private IngredientList ingredientList;
        private List<Review> reviews;
        private List<Category> categories;
        private List<String> instructions;

        /**
         * RecipeBuilder Constructor
         * - call this method to dot-chain attribute additions
         * - initializes createdOn date to the date and time this was called
         */
        public RecipeBuilder(){
            this.createdOn = new Date();
        }

        /**
         * Final method in the dot-chain which returns a Recipe object
         * @return the Recipe object built using the 
         */
        public Recipe build(){
            Recipe recipe = new Recipe(this);
            return recipe;
        }

        //setters for each attribute (allows for dot-chaining)

        public RecipeBuilder setName(String name){
            this.name = name;
            return this;
        }

        public RecipeBuilder setDescription(String description){
            this.description = description;
            return this;
        }

        public RecipeBuilder setServingSize(int servingSize){
            this.servingSize = servingSize;
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
            this.instructions = instructions;
            return this;
        }
    } 
}