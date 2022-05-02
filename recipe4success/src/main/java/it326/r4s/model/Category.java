package it326.r4s.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The category class of the Recipes4Success application.
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class Category {
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
        // Check if the compared object is of correct type or is null
        if (!(obj instanceof Category) || obj == null) {
            return false;
        }
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }
        Category otherCategory = (Category) obj;
        return this.name.toLowerCase().equals(otherCategory.getName().toLowerCase());
    }

    /**
     * An override for the .toString method of java.objre
     * 
     * @return a string representation of the Category object.
     */
    @Override
    public String toString() {
        return this.name;
    }

    public static enum Type { RECIPE, FOODITEM }

    /**
     * A singleton pool of available categories.
     * 
     * @author Alex Smith (alsmi14@ilstu.edu)
     * @date 4/27/22
     */
    public static class Pool implements Portable {
        private static Pool pool = null;
        private Map<Type, Collection<Category>> allCategories;

        private Pool() {
            allCategories = new HashMap<>();
            for (Type t : Type.values()) {
                allCategories.put(t, new ArrayList<Category>());
            }
        }

        public static Pool getInstance() {
            if (pool == null) {
                pool = new Pool();
            }

            return pool;
        }

        public Category getCategory(Type type, String name) {
            for (Category c : allCategories.get(type)) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }

            return addCategory(type, name);
        }

        public boolean removeCategory(Type type, String name) {
            Category c = new Category(name);
            return allCategories.get(type).remove(c);
        }

        public Collection<Category> getCategories(Type type) {
            return Collections.unmodifiableCollection(allCategories.get(type));
        }

        public boolean contains(Type type, String name)  {
            Category c = new Category(name);
            return allCategories.get(type).contains(c);
        }

        private Category addCategory(Type type, String name) {
            Category c = new Category(name);
            allCategories.get(type).add(c);
            return c;
        }
    }
}
