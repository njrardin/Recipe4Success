package it326.r4s.model;
import java.util.*;

/**
 * The Recipe object class for the Recipe4Success application
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/13/22
 */
public class Recipe extends Entity implements Categorizable, Exportable {

    //* Instance variables *\\
    private String name;
    private String description;
    private int servingSize;
    private Date createdOn;
    private IngredientList ingredientList;
    private List<Review> reviews;
    private List<Category> categories;
    private List<String> instructions;

    //* Constructor *\\

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

    //* Methods \\

    /**
     * Removes the category from the recipe
     * @param theCategory
     */
    public void removeCategory(Category theCategory){
        categories.remove(theCategory);
    }
    
    /**
     * Adds the category to the recipe
     * @param theCategory
     */
    public void addCategory(Category theCategory){
        categories.add(theCategory);
    }
    
    /**
     * Removes the ingredient from the recipe
     * @param theIngredient
     */
    public void removeIngredient(Ingredient theIngredient){
        ingredientList.removeIngredient(theIngredient);
    }
    
    /**
     * Adds the ingredient to the recipe
     * @param theIngredient
     */
    public void addIngredient(Ingredient theIngredient){
        ingredientList.addIngredient(theIngredient);
    }
    
    /**
     * Removes the review from the recipe
     * @param theReview
     */
    public void removeReview(Review theReview){
        reviews.remove(theReview);
    }
    
    /**
     * Adds the review to the recipe
     * @param theReview
     */
    public void addReview(Review theReview){
        reviews.add(theReview);
    }

    /**
     * Accessor for the recipe's name
     * @return name of recipe as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Mutator for the recipe's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor for the recipe's description
     * @return description of recipe as a String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Mutator for the recipe's description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accessor for the recipe's serving size
     * @return serving size as an positive int 
     */
    public int getServingSize() {
        return this.servingSize;
    }

    /**
     * Mutator for the recipe's serving size
     * @param servingSize
     */
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    /**
     * Accessor for the recipe's createdOn date
     * @return the Date object representing when the recipe was created
     */
    public Date getCreatedOn() {
        return (Date) this.createdOn.clone();
    }

    /**
     * Accessor for the recipe's ingredientlist
     * @return the IngredientList obj which holds the recipe's list of ingredients
     */
    public IngredientList getIngredientList() {
        return this.ingredientList;
    }

    /**
     * Mutator for the recipe's ingredientlist
     * @param ingredientList
     */
    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }

    /**
     * Accessor for the recipe's reviews
     * @return the List<Review> of the recipe's reviews
     */
    public List<Review> getReviews() {
        return this.reviews;
    }

    /**
     * Accessor for the recipe's list of categories
     * @return the List<Category> of the recipe's categories
     */
    public List<Category> getCategories() {
        return this.categories;
    }

    public List<String> getInstructions() {
        return new ArrayList<String>(this.instructions);
    }

    @Override
    public String toString() {
        return name + ": " + description; 
    }

    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }
        // Check if the compared object is of correct type
        if (!(obj instanceof Recipe)) {
            return false;
        }

        Recipe otherRecipe = (Recipe) obj;
        if (this.name.equals(otherRecipe.getName())) return false;
        if (this.ingredientList.equals(otherRecipe.getIngredientList())) return false;
        return this.servingSize == otherRecipe.getServingSize();
    }

    //* RecipeBuilder inner builder class for Recipe.java *\\

    /**
    * The builder class used to instantiate the Recipe class through a fluent interface
    * @author Nate Rardin (njrardi@ilstu.edu)
    * @date 4/13/22
    */
    public static class RecipeBuilder
    {
        //* Instance Variables *\\
        private String name;
        private String description;
        private int servingSize;
        private Date createdOn;
        private IngredientList ingredientList;
        private List<Review> reviews;
        private List<Category> categories;
        private List<String> instructions;

        //* Constructor *\\

        /**
         * RecipeBuilder Constructor
         * - call this method first, then dot-chain attribute setters
         * - initializes createdOn date to the date and time this was called
         * - initializes reviews, categories, and instructions to empty ArrayLists
         * - initializes description to empty string
         * - initializes serving size to 1
         * @param name - the Recipe's name. Name is required to create a Recipe.
         */
        public RecipeBuilder(String name){
            this.name = name;
            this.description = "";
            this.servingSize = 1;
            this.createdOn = new Date();
            this.reviews = new ArrayList<Review>();
            this.categories = new ArrayList<Category>();
            this.instructions = new ArrayList<String>();
        }

        //* RecipeBuilder methods - for constructing Recipe object *\\

        /**
         * Final method in the dot-chain which returns a Recipe object
         * @return the Recipe object built using the RecipeBuilder
         */
        public Recipe build(){
            Recipe recipe = new Recipe(this);
            return recipe;
        }

        /**
         * Sets description with which to instantiate the recipe being built
         * @param description
         * @return RecipeBuilder
         */
        public RecipeBuilder setDescription(String description){
            this.description = description;
            return this;
        }

        /**
         * Sets serving size with which to instantiate the recipe being built
         * @param servingSize
         * @return RecipeBuilder
         */
        public RecipeBuilder setServingSize(int servingSize){
            this.servingSize = servingSize;
            return this;
        }

        /**
         * Sets list of ingredients with which to instantiate the recipe being built
         * @param ingredientList
         * @return RecipeBuilder
         */
        public RecipeBuilder setIngredientList(IngredientList ingredientList){
            this.ingredientList = ingredientList;
            return this;
        }
        
        /**
         * Sets list of reviews with which to instantiate the recipe being built
         * @param reviews
         * @return RecipeBuilder
         */
        public RecipeBuilder setReviews(List<Review> reviews){
            this.reviews = reviews;
            return this;
        }
        
        /**
         * Sets list of categories with which to instantiate the recipe being built
         * @param categories
         * @return RecipeBuilder
         */
        public RecipeBuilder setCategories(List<Category> categories){
            this.categories = categories;
            return this;
        }
        
        /**
         * Sets list of instructions with which to instantiate the recipe being built
         * @param instructions
         * @return RecipeBuilder
         */
        public RecipeBuilder setInstructions(List<String> instructions){
            this.instructions = instructions;
            return this;
        }
    } 
}