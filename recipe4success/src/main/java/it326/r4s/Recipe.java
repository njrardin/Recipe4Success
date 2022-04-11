package it326.r4s;
import java.util.*;

/*
* TODO #7 - whoever implemented this class needs to write a header description.
* See User.java for good header examples
* s
*/

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
        reviews.remove(theReview);
    }
    
    public void addReview(Review theReview){
        reviews.add(theReview);
    }


    //================================Getters and Setters=================================
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

    public IngredientList getIngredientList() {
        return this.ingredientList;
    }

    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    /*
     * 
     * Getters and Setters that don't break encapsulation 
     * 
     * 
     */
    // public IngredientList getIngredientList() {
    //     return (IngredientList) this.ingredientList.clone();
    // }

    // public void setIngredientList(IngredientList ingredientList) {
    //     this.ingredientList = (IngredientList) ingredientList.clone();
    // }

    // public List<Review> getReviews() {
    //     List<Review> listReturn = new ArrayList<Review>();
    //     for (Category aReview : this.categories) {
    //         listReturn.add((Review) aReview.clone());
    //     }   
    // }

    // public List<Category> getCategories() {
    //     List<Category> listReturn = new ArrayList<Category>();
    //     for (Category aCategory : this.categories) {
    //         listReturn.add((Category) aCategory.clone());
    //     }
     
    //     return listReturn;
    // }

    public List<String> getInstructions() {
        return new ArrayList<String>(this.instructions);
    }

    @Override
    public String toString(){
        return name + ": " + description; 
    }

    @Override
    public ArrayList<String> getAttributeSearchStrings(){
        ArrayList<String> attributeSearchStrings = new ArrayList<String>();
        attributeSearchStrings.add(name);
        attributeSearchStrings.add(description);
        return attributeSearchStrings;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if( !(obj instanceof Recipe)){
            return false;
        }

        Recipe recObj = (Recipe) obj;

        if( recObj.name.equals(this.name) && recObj.description.equals(this.description) ){
                return true;
        }
        else{
            return false;
        }
    }

    //=======================================RecipeBuilder=======================================
    public static class RecipeBuilder
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