package it326.r4s.model;
import java.util.*;

/**
 * The Recipe object class for the Recipe4Success application
 * 
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/13/22
 */
public class Recipe extends Entity implements Portable {

    // * Instance variables *\\
    private String name;
    private String description;
    private int servingSize;
    private Date createdOn;
    private IngredientList ingredientList;
    private Collection<Review> reviews; //TODO: should have an overall rating attribute that uses this
    private Collection<Category> categories;
    private Collection<String> instructions;

    // * Constructor *\\

    /**
     * Constructor for Recipe using the nested class RecipeBuilder
     * - only used inside the RecipeBuilder constructor. RecipeBuilder must be used
     * to create Recipe objects.
     * 
     * @param builder - the RecipeBuilder object from which to create the class
     */
    private Recipe(RecipeBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.servingSize = builder.servingSize;
        this.createdOn = builder.createdOn;
        this.ingredientList = builder.ingredientList;
        this.reviews = builder.reviews;
        this.categories = builder.categories;
        this.instructions = builder.instructions;
    }

    // * Methods \\

    /**
     * adjusts the quantities of all ingredients in the list to reflect the new serving size of this recipe
     * @param newServingSize
     */
    public void adjustServingSize(int newServingSize) {
        int oldServingSize = this.servingSize;
        for(Ingredient ingredient: ingredientList.getIngredients()){
            double newQuantity = ((double) newServingSize / (double) oldServingSize) * ingredient.getQuantity();
            ingredient.setQuantity(newQuantity);
        }
        this.servingSize = newServingSize;
    }

    /**
     * Removes the category from the recipe
     * 
     * @param theCategory
     */
    public void removeCategory(Category theCategory) {
        categories.remove(theCategory);
    }

    /**
     * Adds the category to the recipe
     * 
     * @param theCategory
     */
    public void addCategory(Category theCategory) {
        categories.add(theCategory);
    }

    /**
     * Removes the ingredient from the recipe
     * 
     * @param theIngredient
     */
    public void removeIngredient(Ingredient theIngredient) {
        ingredientList.removeIngredient(theIngredient);
    }

    /**
     * Adds the ingredient to the recipe
     * 
     * @param theIngredient
     */
    public void addIngredient(Ingredient theIngredient) {
        ingredientList.addIngredient(theIngredient);
    }

    /**
     * Removes the review from the recipe
     * 
     * @param theReview
     */
    public void removeReview(Review theReview) {
        reviews.remove(theReview);
    }

    /**
     * Adds the review to the recipe
     * 
     * @param theReview
     */
    public void addReview(Review theReview) {
        reviews.add(theReview);
    }

    /**
     * Accessor for the recipe's name
     * 
     * @return name of recipe as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Mutator for the recipe's name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor for the recipe's description
     * 
     * @return description of recipe as a String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Mutator for the recipe's description
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accessor for the recipe's serving size
     * 
     * @return serving size as an positive int
     */
    public int getServingSize() {
        return this.servingSize;
    }

    /**
     * Accessor for the recipe's createdOn date
     * 
     * @return the Date object representing when the recipe was created
     */
    public Date getCreatedOn() {
        return (Date) this.createdOn.clone();
    }

    /**
     * Accessor for the recipe's ingredientlist
     * 
     * @return the IngredientList obj which holds the recipe's list of ingredients
     */
    public IngredientList getIngredientList() {
        return this.ingredientList;
    }

    /**
     * Mutator for the recipe's ingredientlist
     * 
     * @param ingredientList
     */
    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }

    /**
     * Accessor for the recipe's reviews
     * 
     * @return the List<Review> of the recipe's reviews
     */
    public Collection<Review> getReviews() {
        return this.reviews;
    }

    /**
     * Accessor for the recipe's list of categories
     * 
     * @return the List<Category> of the recipe's categories
     */
    public Collection<Category> getCategories() {
        return this.categories;
    }

    /**
     * Gets the Recipe's instructions.
     * 
     * @return a Collection of instructions.
     */
    public Collection<String> getInstructions() {
        return new ArrayList<String>(this.instructions);
    }

    /**
     * Setter for the recipe's instructions
     * @param instructions - arraylist of string instructions
     */
    public void setInstructions(Collection<String> instructions){
        this.instructions = instructions;
    }
    
    /** 
     * An override for the .toString method of java.obj.
     * 
     * @return a string representation of the Recipe Object.
     */
    @Override
    public String toString() {
        return name + ": " + description;
    }

    /**
     * An override for the .equals method of java.obj.
     * 
     * @param obj a Recipe object.
     *            private String name;
     *            private String description;
     *            private int servingSize;
     *            private Date createdOn;
     *            private IngredientList ingredientList;
     *            private Collection<Review> reviews;
     *            private Collection<Category> categories;
     *            private Collection<String> instructions;
     * @return true if two Recipe objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        // Check if the compared object is of correct type
        if (!(obj instanceof Recipe) || obj == null) {
            return false;
        }
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }

        Recipe otherRecipe = (Recipe) obj;
        if ( !(this.name.equals(otherRecipe.getName())) ){
            return false;
        }

        if(this.ingredientList != null){
            if ( !(this.ingredientList.equals(otherRecipe.getIngredientList())) )
                return false;
        }
        else{
            if(otherRecipe.getIngredientList() != null)
                return false;
        }

        if(this.servingSize != otherRecipe.getServingSize()){
            return false;
        }

        return true;
    }

    // * RecipeBuilder inner builder class for Recipe.java *\\
    /**
     * The builder class used to instantiate the Recipe class through a fluent
     * interface
     * 
     * @author Nate Rardin (njrardi@ilstu.edu)
     * @date 4/13/22
     */
    public static class RecipeBuilder {
        // * Instance Variables *\\
        private String name;
        private String description;
        private int servingSize;
        private Date createdOn;
        private IngredientList ingredientList;
        private ArrayList<Review> reviews;
        private ArrayList<Category> categories;
        private ArrayList<String> instructions;

        // * Constructor *\\

        /**
         * RecipeBuilder Constructor
         * - call this method first, then dot-chain attribute setters
         * - initializes createdOn date to the date and time this was called
         * - initializes reviews, categories, and instructions to empty ArrayLists
         * - initializes description to empty string
         * - initializes serving size to 1
         * 
         * @param name - the Recipe's name. Name is required to create a Recipe.
         */
        public RecipeBuilder(String name) {
            this.name = name;
            this.description = "";
            this.servingSize = 1;
            this.createdOn = new Date();
            this.reviews = new ArrayList<Review>();
            this.categories = new ArrayList<Category>();
            this.instructions = new ArrayList<String>();
        }

        // * RecipeBuilder methods - for constructing Recipe object *\\

        /**
         * Final method in the dot-chain which returns a Recipe object
         * 
         * @return the Recipe object built using the RecipeBuilder
         */
        public Recipe build() {
            Recipe recipe = new Recipe(this);
            return recipe;
        }

        /**
         * Sets description with which to instantiate the recipe being built
         * 
         * @param description
         * @return RecipeBuilder
         */
        public RecipeBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets serving size with which to instantiate the recipe being built
         * 
         * @param servingSize
         * @return RecipeBuilder
         */
        public RecipeBuilder setServingSize(int servingSize) {
            this.servingSize = servingSize;
            return this;
        }

        /**
         * Sets list of ingredients with which to instantiate the recipe being built
         * 
         * @param ingredientList
         * @return RecipeBuilder
         */
        public RecipeBuilder setIngredientList(IngredientList ingredientList) {
            this.ingredientList = ingredientList;
            return this;//TODO: Enforce at least one ingredient
        }

        /**
         * Sets list of reviews with which to instantiate the recipe being built
         * 
         * @param reviews
         * @return RecipeBuilder
         */
        public RecipeBuilder setReviews(ArrayList<Review> reviews){
            this.reviews = reviews;
            return this;
        }

        /**
         * Sets list of categories with which to instantiate the recipe being built
         * 
         * @param categories
         * @return RecipeBuilder
         */
        public RecipeBuilder setCategories(ArrayList<Category> categories){
            this.categories = categories;
            return this;
        }

        /**
         * Sets list of instructions with which to instantiate the recipe being built
         * 
         * @param instructions
         * @return RecipeBuilder
         */
        public RecipeBuilder setInstructions(ArrayList<String> instructions){
            this.instructions = instructions;
            return this;//TODO: Enforce at least one instruction
        }
    }
}