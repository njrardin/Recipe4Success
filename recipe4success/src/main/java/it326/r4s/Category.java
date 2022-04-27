package it326.r4s;

/**
 * A basic category of the Recipes4Success application.
 * 
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class Category implements Categorizable {
    // *Instance Variable*\\
    private String name;

    // *Constructor*\\
    /**
     * creates category object with a specified name.
     * 
     * @param name the name of the category.
     */
    public Category(String name) {
        this.name = name;
    }

    // *Methods*\\
    /**
     * Gets the category's name.
     * 
     * @return the name of the category.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the category's name.
     * 
     * @param name the new name of the category.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * An override for the .equals method of java.obj.
     * 
     * @param obj a Category object.
     *            private String name;
     * 
     * @return a bool indicating if the two ingredients are equal.
     */
    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }
        // Check if the compared object is of correct type
        if (!(obj instanceof User)) {
            return false;
        }
        Category otherCategory = (Category) obj;
        return this.name.equals(otherCategory.getName());
    }

    /**
     * An override for the .toString method of java.objre
     * 
     * @return a string representation of the Category object.
     */
    @Override
    public String toString() {
        return "Category " + this.name;
    }
}
