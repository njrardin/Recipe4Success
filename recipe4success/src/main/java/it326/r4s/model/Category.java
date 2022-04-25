package it326.r4s.model;

/**
 * A basic category class of the Recipes4Success application.
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class Category implements Categorizable {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the compared object is of correct type or is null
        if (!(obj instanceof Category) || obj == null) {
            return false;
        }
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }
        Category otherCategory = (Category) obj;
        return this.name.equals(otherCategory.getName());
    }

    @Override
    public String toString() {
        return "Category " + this.name;
    }
}
