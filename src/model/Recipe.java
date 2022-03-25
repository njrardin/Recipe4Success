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

    public void removeCategory(Category theCategory){
        categories.remove(theCategory);
    }
    
    public void addCategory(Category theCategory){
        categories.add(theCategory);
    }
    
    public void removeIngredient(Ingredient theIngredient){
        ingredientList.removeIngredient(theIngredient);
    }
    
    public void addIngredient(Ingredient theIngredient){
        ingredientList.addIngredient(theIngredient);
    }
    
    public void removeReview(Review theReview){
        reviews.add(theReview);
    }
    
    public void addReview(Review theReview){
        reviews.remove(theReview);
    }


    //================================Getters and Setters=================================
    /*note: getters and setters for collections and R4S entities are commented out because
    they allow for values to be manipulated through the getters so they need to be reworked
    */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getServingSize() {
        return this.servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public Date getCreatedOn() {
        return (Date) this.createdOn.clone();
    }

    // public IngredientList getIngredientList() {
    //     return this.ingredientList;
    // }

    // public void setIngredientList(IngredientList ingredientList) {
    //     this.ingredientList = ingredientList;
    // }

    // public List<Review> getReviews() {
    //     return this.reviews;
    // }

    // public void setReviews(List<Review> reviews) {
    //     this.reviews = reviews;
    // }

    // public List<Category> getCategories() {
    //     return this.categories;
    // }

    // public void setCategories(List<Category> categories) {
    //     this.categories = categories;
    // }

    // public List<String> getInstructions() {
    //     return this.instructions;
    // }

    // public void setInstructions(List<String> instructions) {
    //     this.instructions = instructions;
    // }


    //=======================================RecipeBuilder=======================================
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
         * - call this method first, then dot-chain attribute setters
         * - initializes createdOn date to the date and time this was called
         * - initializes reviews, categories, and instructions to empty ArrayLists
         * 
         * @param name - the Recipe's name. Name is required to create a Recipe.
         */
        public RecipeBuilder(String name){
            this.name = name;
            this.createdOn = new Date();
            this.reviews = new ArrayList<Review>();
            this.categories = new ArrayList<Category>();
            this.instructions = new ArrayList<String>();
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